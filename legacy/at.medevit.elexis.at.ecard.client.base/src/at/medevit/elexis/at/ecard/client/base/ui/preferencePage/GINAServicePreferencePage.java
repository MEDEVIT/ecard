package at.medevit.elexis.at.ecard.client.base.ui.preferencePage;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.wb.swt.ResourceManager;

import at.chipkarte.client.base.soap.CardReader;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import ch.elexis.Hub;

public class GINAServicePreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	public static final String ID = "at.medevit.elexis.at.ecard.client.base.ui.preferencePage.GINAServicePreferencePage";
	public static final String NO_GINA_IP = "N/A NONE N/A";


	private Text textGinaIP;
	private Group groupLocalSet;
	private ComboViewer comboViewerLanCCR;
	
	private CardReader cardReaderSelected;

	private Label lblGINAVersion;
	private Button btnAutoSelectPatient;
	private Button btnAutoSelectMandant;

	public GINAServicePreferencePage() {
		noDefaultAndApplyButton();
		setImageDescriptor(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base",
				"rsc/icons/ginabox-small.png"));
		setTitle("GINA Konfiguration");
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite ret = new Composite(parent, SWT.None);
		ret.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		ret.setLayout(new GridLayout(2, false));

		Label lblGinaIP = new Label(ret, SWT.NONE);
		lblGinaIP.setText("GINA-IP (Syntax: 10.196.1.1)");
		new Label(ret, SWT.NONE);

		textGinaIP = new Text(ret, SWT.BORDER);
		textGinaIP.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		Button validate = new Button(ret, SWT.None);
		validate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Hub.localCfg.set(GINAConfigurationConstants.CFG_GINA_IP,
						textGinaIP.getText());
				
				// TODO -> Should be based on GINAStatus
				BaseService bs = BaseService.getInstance(null);
				if (!BaseService.isConnected()) {
					System.out.println("tryReconnect");
					bs.tryReconnect(null);
					lblGINAVersion.setText("");
				}
				if (BaseService.isConnected()) {
					// TODO Does not correctly work, when first wrong IP is
					// entered, and then correct one?!?
//					GinaVersion gv = bs.getGinaSoftwareVersion();
					
//					lblGINAVersion.setText("Gina gefunden! Typ: " + gv.getTyp()
//							+ ", Gina SW Version: " + gv.getSoftwareVersion());

					comboViewerLanCCR.getCombo().setEnabled(true);
					CardReader[] cr = bs.getCardReaders();
					comboViewerLanCCR.setInput(cr);
					comboViewerLanCCR.addSelectionChangedListener(new ISelectionChangedListener() {
						
						@Override
						public void selectionChanged(SelectionChangedEvent event){
							IStructuredSelection sel = (IStructuredSelection) event.getSelection();
							cardReaderSelected = (CardReader) sel.getFirstElement();
						}
					});

					comboViewerLanCCR.refresh();
					if (cr.length > 0) {
						// Setting default first
						comboViewerLanCCR.setSelection(new StructuredSelection(
								cr[0]));
					}
				}
			}
		});
		validate.setText("Verbinden");

		lblGINAVersion = new Label(ret, SWT.NONE);
		lblGINAVersion.setLayoutData(new GridData(SWT.FILL, SWT.LEAD, true,
				false, 2, 1));
		lblGINAVersion.setText("");

		groupLocalSet = new Group(ret, SWT.None);
		groupLocalSet.setText("Einstellungen für diese Arbeitsstation");
		groupLocalSet.setToolTipText("");
		groupLocalSet.setLayout(new GridLayout(3, false));
		groupLocalSet.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));

		Label lblKartenlesegert = new Label(groupLocalSet, SWT.NONE);
		lblKartenlesegert.setText("Kartenlesegerät:");
		new Label(groupLocalSet, SWT.NONE);

		comboViewerLanCCR = new ComboViewer(groupLocalSet, SWT.NONE);
		Combo comboLanCCR = comboViewerLanCCR.getCombo();
		comboLanCCR.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		
		btnAutoSelectPatient = new Button(groupLocalSet, SWT.CHECK);
		btnAutoSelectPatient.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnAutoSelectPatient.setText("e-Card Stecken: Patient automatisch im System auswählen");
		
		btnAutoSelectMandant = new Button(groupLocalSet, SWT.CHECK);
		btnAutoSelectMandant.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnAutoSelectMandant.setText("o-Card Stecken: Mandant automatisch im System auswählen");

		comboViewerLanCCR
				.setLabelProvider(new LanCCRComboViewerLabelProvider());
		comboViewerLanCCR.setContentProvider(new ArrayContentProvider());

		initPreferencePage();
		return null;
	}

	private void initPreferencePage() {

		String ginaIP = Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_IP,
				NO_GINA_IP);
		System.out.println("ginaIP: "+ginaIP);
		if (ginaIP.equalsIgnoreCase(NO_GINA_IP)) {
			textGinaIP.setText("Bitte IP-Addresse eingeben");
		} else {
			textGinaIP.setText(ginaIP);
//			GinaVersion gv = BaseService.getInstance(null)
//					.getGinaSoftwareVersion();
////			lblGINAVersion.setText("Gina gefunden! Typ: " + gv.getTyp()
//					+ ", Gina SW Version: " + gv.getSoftwareVersion());
		}

		String localCCR = Hub.localCfg.get(
				GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);
		System.out.println(localCCR+" in Card");
		if (ginaIP.equalsIgnoreCase(NO_GINA_IP) || localCCR.equals(GINAConfigurationConstants.NO_VALUE)) {
			CardReader[] none = { new CardReader(GINAConfigurationConstants.NO_VALUE,
					"kein Kartenleser") };
			comboViewerLanCCR.setInput(none);
			comboViewerLanCCR.refresh();
			comboViewerLanCCR.setSelection(new StructuredSelection(none[0]));
		} else {
			CardReader[] crs = BaseService.getInstance(null).getCardReaders();
			if(crs!=null) comboViewerLanCCR.setInput(crs);
			comboViewerLanCCR.refresh();
			cardReaderSelected = BaseService.getInstance(null)
					.getCardReaderObjectFromCardReaderId(localCCR);
			if (cardReaderSelected != null)
				comboViewerLanCCR.setSelection(new StructuredSelection(cardReaderSelected));
		}
		
		btnAutoSelectPatient.setSelection(Hub.localCfg.get(GINAConfigurationConstants.CFG_AUTO_SELECT_PATIENT_IF_AVAILABLE, false));
		btnAutoSelectMandant.setSelection(Hub.localCfg.get(GINAConfigurationConstants.CFG_AUTO_SELECT_MANDANT_IF_AVAILABLE, false));
		// TODO: What if timeout? -> Leads to NPE
		// Input and selection have only to be done if != null and valid, else timeout!
	}

	@Override
	public boolean performOk() {
		Hub.localCfg
				.set(GINAConfigurationConstants.CFG_GINA_IP, textGinaIP.getText());
		Hub.localCfg.set(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, cardReaderSelected.getId());
		Hub.localCfg.set(GINAConfigurationConstants.CFG_AUTO_SELECT_PATIENT_IF_AVAILABLE, btnAutoSelectPatient.getSelection());
		Hub.localCfg.set(GINAConfigurationConstants.CFG_AUTO_SELECT_MANDANT_IF_AVAILABLE, btnAutoSelectMandant.getSelection());
		GINAStatus.updateStatus(false);
		return true;
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}
}
