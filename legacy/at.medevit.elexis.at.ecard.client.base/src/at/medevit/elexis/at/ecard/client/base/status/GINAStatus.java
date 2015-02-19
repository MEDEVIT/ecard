package at.medevit.elexis.at.ecard.client.base.status;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.ISourceProviderService;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.StatusInformationen;
import at.chipkarte.client.base.soap.SvtProperty;
import at.chipkarte.client.base.soap.constants.Modus;
import at.medevit.elexis.at.dynamicdata.Fachgebiete;
import at.medevit.elexis.at.dynamicdata.Sozialversicherungstraeger;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.command.GINAStatusInformation;
import at.medevit.elexis.at.ecard.client.base.sourceprovider.GINAStatusSourceProvider;
import ch.elexis.Hub;

/**
 * Diese Klasse verwaltet den gegenwärtigen Status der GINA Box.
 */
public class GINAStatus {
	
	public static final int GINA_STATUS_ONLINE = 0;
	public static final int GINA_STATUS_OFFLINE = 1;
	public static final int GINA_STATUS_NO_CONNECTION_TO_GINA = 7;
	public static final int GINA_STATUS_CURRENTLY_UPDATING = 8;
	public static final int GINA_STATUS_CONNECTION_NOT_CONFIGURED = 9;
	
	private static ISourceProviderService sps = null;
	private static ICommandService commandService = null;
	private static GINAStatusSourceProvider gssp = null;
	
	private static Date m_statusInfoTime;
	private static int m_ginaStatus;
	private static int m_ginaStatusBefore;
	private static StatusInformationen m_ginaStatusInformationen;
	private static RemoteException m_exception = null;
	
	/** CACHEABLE **/
	private static SvtProperty[] m_svtList = null;
	
	static {
		sps =
			(ISourceProviderService) PlatformUI.getWorkbench().getService(
				ISourceProviderService.class);
		gssp =
			(GINAStatusSourceProvider) sps.getSourceProvider(GINAStatusSourceProvider.GINA_STATUS);
		commandService =
			(ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		m_ginaStatus = GINA_STATUS_CURRENTLY_UPDATING;
	}
	
	/**
	 * Update the status of the GINA Box
	 * 
	 * @param initialRun
	 *            some information needs only to be updated once, that is during the initial run
	 */
	public static void updateStatus(boolean initialRun){
		setGinaStatus(GINA_STATUS_CURRENTLY_UPDATING, null);
		
		String ginaIP =
			Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_IP,
				GINAConfigurationConstants.NO_VALUE);
		if (ginaIP.equalsIgnoreCase(GINAConfigurationConstants.NO_VALUE)) {
			// Is the GINA configured?
			setGinaStatus(GINA_STATUS_CONNECTION_NOT_CONFIGURED, null);
			return;
		} else {
			// We need to check the online status now
			StatusInformationen si =
				BaseService.getInstance(null).getGinaAndServiceavailabilityInformation(); // possible
// NPE
			// getInstance may return null in case of no connection
			/**
			 * --------------Exception-------------- java.lang.NullPointerException at
			 * at.medevit.elexis
			 * .at.ecard.client.base.status.GINAStatus.updateStatus(GINAStatus.java:62) at
			 * at.medevit.elexis.at.ecard.client.base.updatertasks.GINAStatusUpdater.earlyStartup(
			 * GINAStatusUpdater.java:24) at
			 * org.eclipse.ui.internal.EarlyStartupRunnable.runEarlyStartup
			 * (EarlyStartupRunnable.java:87) at
			 * org.eclipse.ui.internal.EarlyStartupRunnable.run(EarlyStartupRunnable.java:66) at
			 * org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:42) at
			 * org.eclipse.ui.internal.Workbench$63.run(Workbench.java:2465) at
			 * org.eclipse.core.internal.jobs.Worker.run(Worker.java:54) -----------End Exception
			 * handler-----
			 */
			
			// We query only the first service for its status (ONLINE OR OFFLINE)
			// TODO: Maybe we should check the modus of all services to reliably say ONLINE
			String modusText = si.getServiceStatusInformation(0).getModusText();
			if (modusText.equalsIgnoreCase(Modus.ONLINE)) {
				setGinaStatus(GINA_STATUS_ONLINE, si);
			} else {
				setGinaStatus(GINA_STATUS_OFFLINE, si);
				userOfflineAlert(si);
			}
			
			if (initialRun) {
				updateFachgebiete(BaseService.getInstance(null).getFachgebiete());
				updateSozialversicherungstraeger(BaseService.getInstance(null).getSVTs());
			}
		}
	}
	
	/**
	 * Update the system-wide list of {@link Sozialversicherungstraeger}
	 * 
	 * @param svTs
	 */
	private static void updateSozialversicherungstraeger(SvtProperty[] svTs){
		for (SvtProperty sp : svTs) {
			Sozialversicherungstraeger
				.setSozialversicherungstraeger(new Sozialversicherungstraeger.SVT(sp.getCode(), sp
					.getKurzbezeichnung(), sp.getText(), sp.getEKVKCode(), sp.getEKVKName(), sp
					.isASVG()));
		}
	}
	
	/**
	 * Update the system-wide list of {@link Fachgebiete}
	 * 
	 * @param fachgebiete
	 */
	private static void updateFachgebiete(BaseProperty[] fachgebiete){
		for (BaseProperty bp : fachgebiete) {
			Fachgebiete.setFachgebiet(Integer.parseInt(bp.getCode()), bp.getText());
		}
	}
	
	public synchronized static void setGinaStatus(int ginaStatusIn, StatusInformationen siIn){
		m_ginaStatusBefore = m_ginaStatus;
		m_ginaStatus = ginaStatusIn;
		m_statusInfoTime = new Date();
		m_ginaStatusInformationen = siIn;
		
		if (m_ginaStatusBefore != m_ginaStatus) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				@Override
				public void run(){
					commandService.refreshElements(GINAStatusInformation.ID, null);
					gssp.statusChanged();
				}
			});
		}
	}
	
	/**
	 * Alert the user about the offline system state
	 * 
	 * @param si
	 */
	private static void userOfflineAlert(final StatusInformationen si){
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run(){
				MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
					"Keine Verbindung zum eCard Serversystem", si.getServiceStatusInformation(0)
						.getHinweisAktion()
						+ "\n\n"
						+ si.getServiceStatusInformation(0).getHinweisZusatz());
			}
		});
	}
	
	public static int getGinaStatus(){
		return m_ginaStatus;
	}
	
	public static StatusInformationen getStatusInformationen(){
		return m_ginaStatusInformationen;
	}
	
	public static Date getStatusInformationenUpdateTime(){
		return m_statusInfoTime;
	}
	
	public static RemoteException getRemoteExceptionInformation(){
		return m_exception;
	}
	
	public static void setRemoteExceptionInformation(RemoteException e){
		m_exception = e;
	}
	
	public static SvtProperty[] getCurrentSVTList(){
		return m_svtList;
	}
	
	/**
	 * Queries the registry for the current list of Fachgebiete, and returns them in e-Card specific
	 * format
	 */
	public static BaseProperty[] getFachgebiete(){
		List<Fachgebiete.Fachgebiet> fgb = Fachgebiete.getAllFachgebiete();
		List<BaseProperty> lbp = new LinkedList<BaseProperty>();
		for (Fachgebiete.Fachgebiet fg : fgb) {
			lbp.add(new BaseProperty(fg.getCode() + "", false, fg.getText()));
		}
		return lbp.toArray(new BaseProperty[] {});
	}
}
