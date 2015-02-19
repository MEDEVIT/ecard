package at.medevit.elexis.at.ecard.client.base.status;

import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.ISourceProviderService;

import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.ReaderStatusEvent;
import at.chipkarte.client.base.soap.ReaderStatusResult;
import at.chipkarte.client.base.soap.constants.CardType;
import at.chipkarte.client.base.soap.constants.ReaderStatus;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.command.CardReaderInformation;
import at.medevit.elexis.at.ecard.client.base.helper.MandantHelper;
import at.medevit.elexis.at.ecard.client.base.helper.PatientHelper;
import at.medevit.elexis.at.ecard.client.base.sourceprovider.CardReaderStatusSourceProvider;
import ch.elexis.Hub;
import ch.elexis.data.Mandant;

public class CardReaderStatus {
	
	public static final int CARD_READER_CONTAINS_E_CARD = 0;
	public static final int CARD_READER_CONTAINS_O_CARD = 1;
	public static final int CARD_READER_CONTAINS_B_CARD = 2;
	public static final int CARD_READER_CONTAINS_SCHULUNGS_E_CARD = 3;
	public static final int CARD_CREADER_CONTAINS_UNKNOWN_CARD = 4;
	public static final int CARD_READER_IS_EMTPY = 5;
	public static final int CARD_READER_NOT_AVAILABLE = 8;
	public static final int CARD_READER_NOT_CONFIGURED = 9;
	
	private static ISourceProviderService sps = null;
	private static ICommandService commandService = null;
	private static CardReaderStatusSourceProvider crssp = null;
	
	private static String cardReaderId;
	private static Date m_statusInfoTime;
	private static int m_cardReaderStatusBefore;
	private static int m_cardReaderStatus;
	private static ReaderStatusResult rs = null;
	private static ReaderStatusEvent rse = null;
	private static CardException ce = null;
	
	static {
		sps =
			(ISourceProviderService) PlatformUI.getWorkbench().getService(
				ISourceProviderService.class);
		crssp =
			(CardReaderStatusSourceProvider) sps
				.getSourceProvider(CardReaderStatusSourceProvider.CARD_READER_STATUS);
		
		if (commandService == null) {
			commandService =
				(ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		}
		m_cardReaderStatus = CARD_READER_NOT_AVAILABLE;
	}
	
	public static void updateStatus(){
		cardReaderId =
			Hub.localCfg
				.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);
		if (cardReaderId.equals(GINAConfigurationConstants.NO_VALUE)) {
			setCardReaderStatus(CARD_READER_NOT_CONFIGURED);
		} else {
			try {
				rs = BaseService.getInstance(null).getReaderStatusEvents("", new String[] {
					cardReaderId
				}, 500);
				rse = rs.getReaderStatusEvents(0);
				
				if (rse.getCardReaderState().startsWith(ReaderStatus.STATUS_READER_PRESENT)) {
					String cardType = rse.getCardType();
					
					if (cardType.startsWith(CardType.O_CARD)) {
						setCardReaderStatus(CARD_READER_CONTAINS_O_CARD);
						return;
					} else if (cardType.startsWith(CardType.E_CARD)) {
						setCardReaderStatus(CARD_READER_CONTAINS_E_CARD);
						return;
					} else if (cardType.startsWith(CardType.B_CARD)) {
						setCardReaderStatus(CARD_READER_CONTAINS_B_CARD);
						return;
					} else if (cardType.startsWith(CardType.SCHULUNGS_E_CARD)) {
						setCardReaderStatus(CARD_READER_CONTAINS_SCHULUNGS_E_CARD);
						return;
					}
				} else {
					setCardReaderStatus(CARD_READER_IS_EMTPY);
				}
			} catch (CardException e) {
				setCardReaderStatus(CARD_READER_NOT_AVAILABLE);
				ce = e;
			}
		}
	}
	
	/**
	 * Update the current card reader status<br>
	 * On e-Card insert add patient if not already in the system (and if configured select)<br>
	 * On o-Card insert add mandant if not already in the system (and if configured select)<br>
	 * 
	 * @param cardReaderStatus
	 */
	private static void setCardReaderStatus(int cardReaderStatus){
		m_cardReaderStatusBefore = m_cardReaderStatus;
		m_cardReaderStatus = cardReaderStatus;
		m_statusInfoTime = new Date();
		
		final int crs = cardReaderStatus; // only to be used within the Runnable
		if (m_cardReaderStatus != m_cardReaderStatusBefore) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				
				@Override
				public void run(){
					commandService.refreshElements(CardReaderInformation.ID, null);
					crssp.statusChanged();
					try {
						if (crs == CARD_READER_CONTAINS_E_CARD
							|| crs == CARD_READER_CONTAINS_SCHULUNGS_E_CARD) {
							Card cardData = BaseService.getInstance(null).getCardData(null);
							
							PatientHelper.findAndIfNotAvailableAddSVPerson(cardData);
							if (Hub.localCfg.get(
								GINAConfigurationConstants.CFG_AUTO_SELECT_PATIENT_IF_AVAILABLE, false)) {
								PatientHelper.setElexisSelectedPatientByInsertedCard(cardData);
							}
						} else if (crs == CARD_READER_CONTAINS_O_CARD) {
							Card cardData = BaseService.getInstance(null).getCardData(null);
							Mandant m = MandantHelper.findAndIfNotAvailableAddMandant(cardData);
							if(Hub.localCfg.get(GINAConfigurationConstants.CFG_AUTO_SELECT_MANDANT_IF_AVAILABLE, false)) {
								Hub.setMandant(m);
							}
						}
						
					} catch (CardException e) {
						MessageDialog.openInformation(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Fehler beim Lesen der e-Card",
							e.getMessage1());
					}
				}
			});
			
		}
	}
	
	/**
	 * Query the actual state of the Card Reader and the card, as currently stored by the
	 * CardReaderUpdate process
	 * 
	 * @return String[] where [0] contains the Status of the Reader as denoted in
	 *         {@link ReaderStatus} and [1] contains the card type (if available else null) as
	 *         denoted in {@link CardType}
	 */
	public static String[] getReaderAndCardStatus(){
		if (rse == null)
			return null;
		String readerState = rse.getCardReaderState();
		String cardState = null;
		if (readerState.equalsIgnoreCase(ReaderStatus.STATUS_READER_PRESENT)) {
			cardState = rse.getCardType();
		}
		return new String[] {
			readerState, cardState
		};
	}
	
	public static Integer getStatus(){
		return m_cardReaderStatus;
	}
}
