package at.medevit.elexis.at.ecard.client.base.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.ISourceProviderService;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Message;
import at.chipkarte.client.base.soap.Ordination;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.TaetigkeitsBereich;
import at.chipkarte.client.base.soap.VertragsDaten;
import at.chipkarte.client.base.soap.Vertragspartner;
import at.chipkarte.client.base.soap.constants.StatusProperty;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.command.DialogStatusInformation;
import at.medevit.elexis.at.ecard.client.base.sourceprovider.DialogStatusSourceProvider;

public class DialogStatus {
	
	public static final int DIALOG_STATUS_CLOSED = 0;
	public static final int DIALOG_STATUS_OPEN = 1;
	public static final int DIALOG_STATUS_OPEN_NEWMESSAGES = 2;
	
	private static ICommandService commandService = null;
	private static ISourceProviderService sps = null;
	private static DialogStatusSourceProvider dssp = null;
	private static ArrayList<Observer> observers = new ArrayList<Observer>();
	
	private static String m_dialogId = null;
	/** Zeitpunkt des letzen Updates der in dieser Klasse präsentierten Information */
	private static Date m_statusInfoTime = null;
	private static int m_dialogStatus;
	private static int m_dialogStatusBefore;
	/** Zeitpunkt des Dialog-Aufbaus */
	private static Date m_dialogSetupTime = null;				
	private static Property[] m_dialogProperties = null;
	private static Vertragspartner m_vertragspartner = null;
	private static Ordination m_ordination = null;
	private static TaetigkeitsBereich m_taetigkeitsbereich = null;
	private static String[] m_berechtigungen = null;
	private static VertragsDaten[] m_vertragsdaten = null;
	private static BaseProperty[] m_fachgebieteByOrd = null;			// mögliche Fachgebiete basierend auf Ordination und Tätigkeitsbereich
	private static List<Message> m_messages = new LinkedList<Message>();// Eingehende Nachrichten
	
	static {
		if (sps == null)
			sps =
				(ISourceProviderService) PlatformUI.getWorkbench().getService(
					ISourceProviderService.class);
		if (dssp == null)
			dssp =
				(DialogStatusSourceProvider) sps
					.getSourceProvider(DialogStatusSourceProvider.DIALOG_STATUS);
		commandService =
				(ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		m_dialogStatus = DIALOG_STATUS_CLOSED;
	}
	
	// Other classes may register for dialog status changes
	public static void attachObserver (Observer observer){
	       observers.add(observer); 
	}
	public static void detachObserver(Observer observer) {
	       observers.remove(observer);
	}
	public static void notifyObservers() {
	    for (Observer o : observers)    
	          o.update(null, m_dialogStatus);
	}
	//
	
	public static void setDialogStatus(int dialogStatusIn){
		m_dialogStatusBefore = m_dialogStatus;
		m_dialogStatus = dialogStatusIn;
		
		if(m_dialogStatusBefore != m_dialogStatus) {
			IWorkbench wb = PlatformUI.getWorkbench();
			Display dp = wb.getDisplay();
			dp.asyncExec(new Runnable() {
				@Override
				public void run(){
					commandService.refreshElements(DialogStatusInformation.ID, null);
					dssp.statusChanged();
				}
			});
			notifyObservers();
		}
	}
	
	/**
	 * 
	 * @param dialogIdIn
	 *            dialogId nach Dialogaufbau, null nach Dialogabbau
	 * @throws DialogException
	 */
	public static void setDialogId(String dialogIdIn, Vertragspartner vp, Ordination ord,
		TaetigkeitsBereich t) throws DialogException {
		m_dialogId = dialogIdIn;
		m_vertragspartner = vp;
		m_ordination = ord;
		m_taetigkeitsbereich = t;
		
		m_dialogSetupTime = new Date();
		updateDialogStatus(false);
	}
	
	// TODO: Should be periodically updated!
	/**
	 * This method updates the current state of the Dialog connection. The following information is updated:<br>
	 * {@link BaseService#getBerechtigungen(String)}<br>
	 * {@link BaseService#getVertraege(String)}<br>
	 * {@link BaseService#getFachgebieteByOrdId(String, String, String)}<br>
	 * {@link BaseService#checkStatus(String)}<br>
	 * 
	 * @param fastUpdate update only {@link BaseService#checkStatus(String)}, leave out the other methods
	 * @throws DialogException
	 */
	public static void updateDialogStatus(boolean fastUpdate) throws DialogException {
		if(m_dialogId == null) return;
		m_statusInfoTime = new Date();
		try {
			if(!fastUpdate) {
				m_berechtigungen = BaseService.getInstance(null).getBerechtigungen(m_dialogId);
				m_vertragsdaten = BaseService.getInstance(null).getVertraege(m_dialogId);
				m_fachgebieteByOrd = BaseService.getInstance(null).getFachgebieteByOrdId(m_dialogId, m_ordination.getOrdinationId(), m_taetigkeitsbereich.getId());
			}
			
			setDialogStatus(DIALOG_STATUS_OPEN);
			m_dialogProperties = BaseService.getInstance(null).checkStatus(m_dialogId);
			if(m_dialogProperties != null && m_dialogProperties.length>0) {
				for (int i = 0; i < m_dialogProperties.length; i++) {
					System.out.println("m_DialogProperties");
					System.out.println(m_dialogProperties[i].getKey()+" "+m_dialogProperties[i].getValue());
					
					if(m_dialogProperties[i].getKey().equals(StatusProperty.MESSAGE_FLAG))  {
						String v = m_dialogProperties[i].getValue();
						// TODO: Update Messages View
						if(v!=null) {
							setDialogStatus(DIALOG_STATUS_OPEN_NEWMESSAGES);
							checkMessages(false);
						}

					}
					// TODO What about the other StatusProperty message?
				}
			}
		} catch (DialogException e) {
			throw e;
		}	
	}
	
	/**
	 * Check for incoming messages, if a dialog is open
	 * @throws DialogException 
	 */
	protected static void checkMessages(boolean newOnly) throws DialogException {
		if(m_dialogId == null) return;
		try {
			Message[] tempMessages  = BaseService.getInstance(null).getMessages(m_dialogId, newOnly);
			if(tempMessages != null && tempMessages.length>0) {
				for (Message m : tempMessages) {
					m_messages.add(m);
					
					// TODO remove
					System.out.println("-----MESSAGE------");
					System.out.println("ID "+m.getId());
					System.out.println("Text "+m.getText());
					System.out.println("Appid "+m.getAppid());
					System.out.println("Category "+m.getCategory());
					System.out.println("Data "+m.getData());
					System.out.println("Timestamp"+m.getTimestamp());
					System.out.println("-----EO MESSAGE----");
				}
			}			
		} catch (DialogException e) {
			throw e;
		}
	}
	
	public static void setDialogClosed(){
		m_dialogId = null;
		m_vertragspartner = null;
		m_ordination = null;
		m_taetigkeitsbereich = null;
		m_berechtigungen = null;
		m_vertragsdaten = null;

		m_dialogSetupTime = null;
		m_dialogProperties = null;
		
		setDialogStatus(DIALOG_STATUS_CLOSED);
	}
	
	public static int getDialogStatus() {
		return m_dialogStatus;
	}
	
	
	/**
	 * Liefert die ID des aktuell aktiven Dialogs, oder null wenn kein Dialog aktiv
	 * 
	 * @return dialogId or null
	 */
	public static String getDialogId(){
		return m_dialogId;
	}
	
	public static Vertragspartner getVertragspartner(){
		return m_vertragspartner;
	}
	
	/**
	 * 
	 * @return is a dialog open?
	 */
	public static boolean dialogOpen(){
		// TODO: change this?
		if (m_dialogId != null)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return Für diesen Dialog ausgewählte Ordination
	 */
	public static Ordination getOrdination(){
		return m_ordination;
	}
	
	/**
	 * 
	 * @return Für diesen Dialog ausgewählter Tätigkeitsbereich
	 */
	public static TaetigkeitsBereich getTaetigkeitsBereich(){
		return m_taetigkeitsbereich;
	}
	
	public static Date getSetupTime(){
		return m_dialogSetupTime;
	}
	
	public static String[] getBerechtigungen() {
		return m_berechtigungen;
	}
	
	public static VertragsDaten[] getVertragsDatens() {
		return m_vertragsdaten;
	}
	
	/**
	 * 
	 * @return Für die im Dialog gewählte Ordination werden alle gültigen Fachgebiete geliefert, 
	 * für die der Vertragspartner das Konsultationsrecht besitzt
	 */
	public static BaseProperty[] getFachgebieteByOrdId() {
		return m_fachgebieteByOrd;
	}
	
	public static Message[] getMessages() {
		
		return m_messages.toArray(new Message[] {});
	}
	
	public static int getNoOfNewMessages() {
		if(m_messages != null) {
			return m_messages.size();
		} else {
			return 0;
		}
	}
	
	/**
	 * Delete a message from the current message list. 
	 * @param m
	 */
	public static void removeMessage(Message m) {
		m_messages.remove(m);
	}
	
}
