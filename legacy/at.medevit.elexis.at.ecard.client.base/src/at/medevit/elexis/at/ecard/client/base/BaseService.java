/**
 * (c) MEDEVIT OG
 */
package at.medevit.elexis.at.ecard.client.base;

import static at.medevit.elexis.at.ecard.client.base.exceptionHandler.RemoteExceptionHandler.handleRemoteException;

import java.rmi.RemoteException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.CardReader;
import at.chipkarte.client.base.soap.DialogsInfo;
import at.chipkarte.client.base.soap.GinaVersion;
import at.chipkarte.client.base.soap.Message;
import at.chipkarte.client.base.soap.Ordination;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.ReaderStatusResult;
import at.chipkarte.client.base.soap.StatusInformationen;
import at.chipkarte.client.base.soap.SvPerson;
import at.chipkarte.client.base.soap.SvtProperty;
import at.chipkarte.client.base.soap.VertragsDaten;
import at.chipkarte.client.base.soap.Vertragspartner;
import at.chipkarte.client.base.soap.exceptions.BCardException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.base.soap.vp.IBaseServiceVP;
import at.chipkarte.client.base.soap.vp.ProduktInfo;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.GINAServiceManager;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import ch.elexis.Hub;

/**
 * Singleton Class gaining access to the BASE Service on a GINA by resolving the
 * respective Endpoint at the GINAs ServiceManager Endpoint URL
 * 
 * @author M. Descher
 * 
 */
public class BaseService implements IBaseServiceVP {

	public final static String PLUGIN_ID = "at.medevit.elexis.at.ecard.client.base";
	public final static int PRODUCT_ID = 900201;	// Preliminary, after certification will receive
	public final static ProduktInfo PRODUCT_INFO = new ProduktInfo(PRODUCT_ID, "Elexis Desktop AT");
	
	
	private static BaseService instance = null;
	private static IBaseServiceVP baseVP90 = null;

	private BaseService(String ginaServiceManagerUrl) {
		if (baseVP90 == null) {	
			baseVP90 = initBase90ServiceConnection(ginaServiceManagerUrl);
		}
	}

	private IBaseServiceVP initBase90ServiceConnection(
			String ginaServiceManagerUrl) {
		IBaseServiceVP b = null;
		String gsmu = null;
		if (ginaServiceManagerUrl != null) {
			gsmu = ginaServiceManagerUrl;
		} else {
			gsmu = GINAServiceManager
					.getConfiguredGinaServiceManagerEndpointUrl();
		}
		try {
			b = GINAServiceManager.getBaseService("9.0", gsmu);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return b;
	}

	/**
	 * Generate an instance of {@link BaseService} by passing a
	 * GinaServiceManager Endpoint URL if the parameter passed is null, the
	 * location is read from the Hub.localcfg
	 * 
	 * @param ginaServiceManagerUrl
	 *            leave null to use the system configured url
	 * @return
	 */
	public static BaseService getInstance(String ginaServiceManagerUrl) {
		if (instance == null || baseVP90 == null) {
			instance = new BaseService(ginaServiceManagerUrl);
		}
		
		// We do not have a valid connection
		if(baseVP90 == null) return null;
		
		return instance;
	}

	public static boolean isConnected() {
		return instance != null && baseVP90 != null;
	}

	/**
	 * Disconnect the instance from the service, by setting all respective
	 * variables to null. If a local variable of type {@link BaseService} was
	 * created this method returns null to also delete the respective variable.
	 * 
	 * @return null
	 */
	public static BaseService disconnect() {
		instance = null;
		baseVP90 = null;
		return null;
	}

	public void tryReconnect(String ginaServiceManagerUrl) {
		if (!isConnected()) {
			instance = new BaseService(ginaServiceManagerUrl);
		}
	}

	/**
	 * Diese Funktion generiert eine neue Dialog-Id. Dabei wird geprüft, ob die
	 * maximale Anzahl der Dialoge pro Ordinations-Client überschritten wurde
	 * und dadurch kein weiterer Dialogaufbau möglich ist.
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @param produktInfo
	 *            Informationen der Software, die diese Schnittstelle
	 *            implementiert;
	 * @param extUID
	 *            UserID vom externen System (z.B. KIS) (pseudonym/Klartext);
	 *            Optional
	 * @return DialogId - Identifiziert einen Dialog (dient zur Referenzierung
	 *         dieses Dialogs in anderen Funktionen) <br>
	 *         Format: maximal 32-stellig
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#SW_UPDATE_EXCEPTION
	 *             SW_UPDATE_EXCEPTION},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#EXT_UID_INVALID
	 *             EXT_UID_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PRODUKTINFO_INVALID
	 *             PRODUKTINFO_INVALID},
	 */
	@Override
	public String createDialog(String cardReaderId, ProduktInfo produktInfo,
			String extUID) throws CardException, DialogException {
		String dialogId = null;
		try {
			dialogId = baseVP90.createDialog(cardReaderId, produktInfo, extUID);
		} catch (CardException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return dialogId;
	}

	/**
	 * 
	 * Diese Funktion ermittelt alle verfügbaren Kartenleser, die an den
	 * Ordinations-Client angeschlosssen sind.
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @return Liste der verfügbaren Kartenleser
	 */
	@Override
	public CardReader[] getCardReaders() {
		CardReader[] result = null;
		try {
			result = baseVP90.getCardReaders();
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return result;
	}

	/**
	 * Diese Funktion liest die Daten der aktuell gesteckten Karte.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>eine gültige Karte steckt im angegebenen Kartenleser.
	 * </p>
	 * <p>
	 * Die Funktion erkennt zwar Bürgerkarten, kann deren Daten jedoch nicht für
	 * Folgeaufrufe zwischenspeichern. Wenn die gesteckte Karte also vom Typ
	 * {@link at.chipkarte.client.base.soap.constants.CardType#B_CARD b-card}
	 * ist, wird im {@link Card} Objekt lediglich das Attribut
	 * {@link Card#getCardType() CardType} versorgt. <br>
	 * Um auch die übrigen Daten inklusive der Sozialversicherungsnummer einer
	 * SV-Person zu einer Bürgerkarte zu erhalten, muss die Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getBCardSvPerson
	 * IBaseService.getBCardSvPerson} aufgerufen werden, womit am
	 * Ordinations-Client die benötigten Informationen für weitere KSE
	 * Funktionen, die mit der Bürgerkarte durchgeführt werden sollen, zur
	 * Verfügung stehen.
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @return Daten der gesteckten Karte
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * 
	 */
	@Override
	public Card getCardData(String cardReaderId) throws CardException {
		if(cardReaderId == null) cardReaderId = Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);
		Card c = null;
		try {
			c = baseVP90.getCardData(cardReaderId);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return c;
	}

	/**
	 * Diese Funktion liest die erweiterten Daten der aktuell gesteckten Karte.
	 * <p>
	 * <B>Voraussetzung: </B>
	 * <li>eine gültige Karte steckt in dem Kartenleser der dem angegebenen
	 * Dialog zugeordnet ist
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cardReaderId
	 *            Identifier des Kartenlesers
	 * @param CIN
	 *            Kartennummer einer bereits zuvor gelesenen Karte (um
	 *            sicherzustellen, dass die Daten von der gleichen Karte gelesen
	 *            werden). Wenn null, erfolgt keine Prüfung.
	 * @return Erweiterte Daten der gesteckten Karte (mögliche Werte siehe
	 *         {@link at.chipkarte.client.base.soap.constants.CardProperty
	 *         CardProperty})
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public Property[] getExtendedCardData(String cardReaderId, String CIN)
			throws CardException {
		Property[] p = null;
		if(cardReaderId == null) cardReaderId = Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);
		try {
			p = baseVP90.getExtendedCardData(cardReaderId, CIN);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return p;
	}

	/**
	 * 
	 * Mit dieser Funktion kann der PIN Code der o-card neu gesetzt werden.
	 * <p>
	 * <B>Voraussetzung: </B>
	 * <li>eine gültige o-card steckt in dem Kartenleser, der dem angegebenen
	 * Kartenleser zugeordnet ist
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @param cin
	 *            Kartennummer einer bereits zuvor gelesenen Karte (um
	 *            sicherzustellen, dass die Daten von der gleichen Karte gelesen
	 *            werden). Wenn null, erfolgt keine Prüfung.
	 * @param oldPin
	 *            aktueller PIN Code der o-card
	 * @param newPin
	 *            Neuer Pin, der auf der o-card gesetzt werden soll
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PIN_LOCKED
	 *             PIN_LOCKED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PIN
	 *             INVALID_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_PIN
	 *             WRONG_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#TRANSPORT_PIN
	 *             TRANSPORT_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public void changePin(String cardReaderId, String cin, String oldPin,
			String newPin) throws CardException {
		try {
			if(cardReaderId == null) cardReaderId = Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);	
			baseVP90.changePin(cardReaderId, cin, oldPin, newPin);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}

	}

	/**
	 * 
	 * Mit dieser Funktion kann eine o-card, die durch mehrmalige falsche PIN
	 * Eingabe gesperrt wurde, wieder entsperrt werden, indem der PIN Code der
	 * o-card neu gesetzt wird.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>eine gültige o-card steckt in dem Kartenleser der dem angegebenen
	 * Kartenleser zugeordnet ist
	 * <li>die Karte wurde durch mehrmalige Eingabe eines falsche PIN Codes
	 * gesperrt
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @param cin
	 *            Kartennummer einer bereits zuvor gelesenen Karte (um
	 *            sicherzustellen, dass die Daten von der gleichen Karte gelesen
	 *            werden). Wenn null, erfolgt keine Prüfung.
	 * @param puk
	 *            PUK Code der o-card
	 * @param newPin
	 *            Neuer Pin, der auf der o-card gesetzt werden soll
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PIN
	 *             INVALID_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PUK
	 *             INVALID_PUK},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_PUK
	 *             WRONG_PUK},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PUK_LOCKED
	 *             PUK_LOCKED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public void changePinWithPuk(String cardReaderId, String cin, String puk,
			String newPin) throws CardException {
		try {
			baseVP90.changePinWithPuk(cardReaderId, cin, puk, newPin);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}

	}

	/**
	 * 
	 * Diese Funktion testet den Zugriff auf die Karte, die sich im angegebenen
	 * Kartenleser befindet.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>eine gültige Karte steckt in dem angegebenen Kartenleser
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Resultat des Kartentests (der Wert 0 bedeutet OK - sonst
	 *         Fehlercode laut
	 *         {@link at.chipkarte.client.base.soap.exceptions.CardException})
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public int doCardTest(String cardReaderId) throws CardException {
		try {
			return baseVP90.doCardTest(cardReaderId);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return 0;
	}

	/**
	 * 
	 * Durch diese Funktion wird ein Dialog authentifiziert. Diese
	 * Authentifizierung erfolgt durch Prüfen der PIN der o-card sowie bei
	 * verfügbarer Serververbindung durch die Verifikation der o-card Signatur
	 * sowie einer Gültigkeitsprüfung der Karte.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.ent.IBaseServiceENT#createDialog
	 * createDialog} oder
	 * {@link at.chipkarte.client.base.soap.vp.IBaseServiceVP#createDialog
	 * createDialog} erfolgreich ausgeführt
	 * <li>gültige Ordinationskarte steckt in dem Kartenleser, der dem
	 * angegebenen Dialog zugeordnet ist
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode
	 *            {@link at.chipkarte.client.base.soap.ent.IBaseServiceENT#createDialog
	 *            createDialog} oder
	 *            {@link at.chipkarte.client.base.soap.vp.IBaseServiceVP#createDialog
	 *            createDialog} erzeugt wurde
	 * @param cin
	 *            Kartennummer einer bereits zuvor gelesenen Karte (um
	 *            sicherzustellen, dass die Daten von der gleichen Karte gelesen
	 *            werden). Wenn null, erfolgt keine Prüfung.
	 * @param pin
	 *            PIN der Ordinationskarte
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @return Authentifizierungsstatus und Informationen über den
	 *         Vertragspartners sowie Ordinationsadressen. <br>
	 *         Im Offline Modus des Ordinations-Client werden für die
	 *         Vertragspartner Bean lediglich die Felder <br>
	 *         <li>Anrede <li>Titel <li>Geburtsdatum <li>Vorname <li>Nachname
	 *         <li>Vertragspartnernummer <li>Ordinationsadresse(n) versorgt.
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED}
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PIN
	 *             INVALID_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PIN_LOCKED
	 *             PIN_LOCKED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#TRANSPORT_PIN
	 *             TRANSPORT_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_PIN
	 *             WRONG_PIN},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ALREADY_AUTHENTICATED
	 *             DIALOG_ALREADY_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID
	 *             SIGNATURE_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID
	 *             OCARD_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ID_ALREADY_EXISTS
	 *             DIALOG_ID_ALREADY_EXISTS},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER
	 *             NO_CARD_READER},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_GINA_MISMATCH
	 *             OCARD_GINA_MISMATCH},
	 * 
	 */
	@Override
	public Vertragspartner authenticateDialog(String dialogId, String cin,
			String pin, String cardReaderId) throws CardException,
			DialogException {
		if(cardReaderId == null) cardReaderId = Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);
		Vertragspartner vp = null;
		try {
			vp = baseVP90.authenticateDialog(dialogId, cin, pin, cardReaderId);
		} catch (CardException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return vp;
	}

	/**
	 * 
	 * Diese Funktion ordnet dem Dialog eine Ordinationsadresse zu.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion {@link #authenticateDialog authenticateDialog} wurde
	 * erfolgreich ausgeführt
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @param ordinationId
	 *            identifiziert eine Ordination, die dem Dialog zugeordnet
	 *            werden soll (kann über
	 *            {@link at.chipkarte.client.base.soap.Ordination#getOrdinationId}
	 *            aus dem Rückgabewert von {@link #authenticateDialog
	 *            authenticateDialog} ermittelt werden)
	 * @param taetigkeitsBereichId
	 *            identifiziert einen Tätigkeitsbereich, der dem Dialog
	 *            zugeordnet werden soll (kann über
	 *            {@link at.chipkarte.client.base.soap.TaetigkeitsBereich#getId()}
	 *            aus dem Rückgabewert von {@link #authenticateDialog
	 *            authenticateDialog} ermittelt werden)
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ADDRESS_ALREADY_SET
	 *             ADDRESS_ALREADY_SET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID
	 *             ORDINATION_ID_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID}
	 */
	@Override
	public void setDialogAddress(String dialogId, String ordinationId,
			String taetigkeitsBereichId) throws DialogException {
		try {
			baseVP90.setDialogAddress(dialogId, ordinationId,
					taetigkeitsBereichId);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}

	}

	/**
	 * 
	 * Diese Funktion beendet einen aufgebauten Dialog.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion {@link #createDialog createDialog} wurde erfolgreich
	 * ausgeführt.
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id des Dialogs, der geschlossen werden soll. Die Id
	 *            wurde durch die Methode {@link #createDialog createDialog}
	 *            erzeugt.
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 */
	@Override
	public void closeDialog(String dialogId) throws DialogException {
		try {
			baseVP90.closeDialog(dialogId);
		} catch (DialogException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
	}

	/**
	 * 
	 * Diese Funktion ermittelt den Status des Ordinations-Client und liefert
	 * eine Liste von Status Properties zurück. Die Funktion sollte in
	 * regelmäßigen Zeitabständen gepollt werden (z.B. im Intervall von einigen
	 * Minuten) um einen möglichst aktuellen Zustand des Systems zu bekommen. <br>
	 * Wenn der Dialog nicht mehr gültig ist, wird eine DialogException
	 * {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 * DIALOG_INVALID} geworfen.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress}
	 * wurde erfolgreich ausgeführt.
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @return Liste von Status Properties (mögliche keys in der Liste der
	 *         Properties siehe
	 *         {@link at.chipkarte.client.base.soap.constants.StatusProperty
	 *         StatusProperty})
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
	 */
	@Override
	public Property[] checkStatus(String dialogId) throws DialogException {
		Property[] p = null;
		try {
			p = baseVP90.checkStatus(dialogId);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return p;
	}

	/**
	 * Diese Funktion übersiedelt eine Ordinationsadresse eines
	 * Vertragspartners.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress}
	 * wurde erfolgreich ausgeführt.
	 * <li>Online Modus des Dialogs
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @param ordinationId
	 *            Id der zu übersiedelnden Adresse, siehe auch
	 *            {@link Ordination#isUebersiedeln() Ordination.isUebersiedeln}.
	 *            Die gültigen Ordinationsadressen sind in der
	 *            <code>Vertragspartner</code> -Bean enthalten, die von der
	 *            Funktion
	 *            {@link #authenticateDialog(String, String, String, int)
	 *            authenticateDialog} geliefert werden. Für diese Adresse kann
	 *            in Hinkunft kein Dialog mehr aufgebaut werden.
	 * @param forceUebersiedlung
	 *            Dieser Parameter bestimmt, ob vor Durchführung der
	 *            Übersiedlung auf eventuell vorhandene Offline-Konsultationen
	 *            für die abzuschließende Ordination geprüft werden soll.
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID
	 *             ORDINATION_ID_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NACHFOLGE_ORDID_NOTFOUND
	 *             NACHFOLGE_ORDID_NOTFOUND},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#UEBERSIEDELN_OFFLINEDATA_DETECTED}
	 */
	@Override
	public void uebersiedelnOrdination(String dialogId, String ordinationId,
			boolean forceUebersiedlung) throws DialogException {
		try {
			baseVP90.uebersiedelnOrdination(dialogId, ordinationId,
					forceUebersiedlung);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}

	}

	/**
	 * Diese Funktion liefert die aktuellen Nachrichten vom Messaging System des
	 * e-card Servers. Die Benachrichtigung, dass eine neue Nachricht vorliegt,
	 * erfolgt durch Pollen der Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#checkStatus
	 * checkStatus}. Durch diesen Mechanismus ist es möglich, asynchrone
	 * Messages vom e-card Serversystem zu übertragen. Dieser Messaging
	 * Mechanismus wird serviceübergreifend verwendet. An welches Service die
	 * Message adressiert ist, kann aus der
	 * {@link at.chipkarte.client.base.soap.Message Message } Bean ermittelt
	 * werden.
	 * 
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress}
	 * wurde erfolgreich ausgeführt.
	 * <li>Online Modus des Dialogs
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Lang
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @param newOnly
	 *            wenn true, werden nur die neuen Nachrichten geliefert, sonst
	 *            alle. Das Flag newOnly wird nur innerhalb des Dialoges
	 *            verwaltet!
	 * @return Array von Messages
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 */
	@Override
	public Message[] getMessages(String dialogId, boolean newOnly)
			throws DialogException {
		Message[] m = null;
		try {
			m = baseVP90.getMessages(dialogId, newOnly);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return m;
	}

	/**
	 * Diese Funktion liefert Informationen über die Anzahl der maximal
	 * möglichen bzw. zurzeit aufgebauten Dialoge.
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Information über Anzahl der Dialoge
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public DialogsInfo getFreeDialogs() {
		DialogsInfo di = null;
		try {
			if (baseVP90 == null) return null;
			di = baseVP90.getFreeDialogs();
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return di;
	}

	/**
	 * Diese Funktion liefert die aktuelle Softwareversion des
	 * Ordinations-Client. Eine Änderung dieser Softwareversion muss nicht
	 * zwangsläufig eine Auswirkung auf die Vertragspartner Software
	 * Schnittstelle haben. Sie dient beispielsweise als Zusatzinformation für
	 * Fehler Reports, Support.
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Softwareversion des Ordinations-Client
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public GinaVersion getGinaSoftwareVersion() {
		GinaVersion gv90 = null;
		try {
			gv90 = baseVP90.getGinaSoftwareVersion();
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return gv90;
	}

	/**
	 * Diese Funktion liefert Daten zu den Verträgen des Vertragspartners.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @return Vertragsdaten
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 */
	@Override
	public VertragsDaten[] getVertraege(String dialogId) throws DialogException {
		VertragsDaten[] v = null;
		try {
			v = baseVP90.getVertraege(dialogId);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return v;
	}

	/**
	 * Diese Funktion liefert die Daten zu einer SV-Person vom e-card
	 * Serversystem, wenn eine Bürgerkarte gesteckt ist. Durch den Aufruf der
	 * Funktion werden für den Dialog am Ordinations-Client bestimmte Daten der
	 * Karte gespeichert. Somit können diese Daten in einem Folgeaufruf von
	 * Funktionen, welche die Bürgerkarte unterstützen, an das e-card
	 * Serversystem übermittelt und die Zuordnung von Bürgerkarte und Patient
	 * sichergestellt werden. Ein erneuter Aufruf derartiger Funktionen
	 * überschreibt die Bürgerkarten Informationen.
	 * 
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt.
	 * <li>Online Modus des Dialogs
	 * <li>In dem Dialog zugeordneten Kartenleser steckt eine Bürgerkarte
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * 
	 * @param forceExecution
	 *            Flag zur Unterdrückung der
	 *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#BCARD_REPEATED_USE
	 *            CardException.BCARD_REPEATED_USE} Exception
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @return Daten der SV-Person
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PBD_NOT_AVAIL
	 *             PBD_NOT_AVAIL},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#BCARD_INVALID
	 *             BCARD_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#BCARD_REPEATED_USE
	 *             BCARD_REPEATED_USE},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws BCardException
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#PBD_NOT_ASSIGNED
	 *             PBD_NOT_ASSIGNED}
	 *             <p>
	 *             <b>HINWEIS: </b> <br>
	 *             Wenn eine der oben genannten Funktionen mit der Bürgerkarte
	 *             durchgeführt werden soll, muss gewährleistet sein, dass
	 *             unmittelbar nach Aufruf dieser Funktion die o-card gesteckt
	 *             wird und die gewünschte Funktion aufgerufen wird.
	 *             </p>
	 * 
	 */
	@Override
	public SvPerson getBCardSvPerson(String dialogId, boolean forceExecution,
			String readerId) throws BCardException, CardException,
			DialogException {
		SvPerson sp = null;
		try {
			sp = baseVP90.getBCardSvPerson(dialogId, forceExecution, readerId);
		} catch (CardException e) {
			throw e;
		} catch (BCardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return sp;
	}

	/**
	 * 
	 * Mit dieser Funktion werden alle zurzeit gültigen
	 * Sozialversicherungsträger geliefert.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>keine
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Array der Sozialversicherungsträger, siehe auch
	 *         {@link SvtProperty SvtProperty}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public SvtProperty[] getSVTs() {
		SvtProperty[] svtp = null;
		try {
			svtp = baseVP90.getSVTs();
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return svtp;
	}

	/**
	 * Mit dieser Funktion werden alle zurzeit gültigen Fachgebiete geliefert.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>keine
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Array der Fachgebiete, siehe auch {@link BaseProperty
	 *         BaseProperty}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public BaseProperty[] getFachgebiete() {
		BaseProperty[] bp = null;
		try {
			bp = baseVP90.getFachgebiete();
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return bp;
	}

	/**
	 * Mit dieser Funktion werden alle gültigen Fachgebiete einer bestimmten
	 * Ordination geliefert, für die der Vertragspartner das Konsultationsrecht
	 * besitzt.
	 * 
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @param ordId
	 *            Id der Ordination, für deren Verträge die Fachgebiete
	 *            abgefragt werden sollen. Wenn null, werden die gültigen
	 *            Fachgebiete für die Ordinationsadresse des aktuellen Dialogs
	 *            geliefert.
	 * @param taetigkeitsBereichId
	 *            Id des Tätigkeitsbereichs, für den die Fachgebiete abgefragt
	 *            werden sollen. Wenn null, werden die gültigen Fachgebiete für
	 *            die Ausprägung des aktuellen Dialogs geliefert.
	 * @return Array der Fachgebiete für eine bestimmte Ordination, siehe auch
	 *         {@link BaseProperty BaseProperty}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID
	 *             ORDINATION_ID_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID}
	 */
	@Override
	public BaseProperty[] getFachgebieteByOrdId(String dialogId, String ordId,
			String taetigkeitsBereichId) throws DialogException {
		BaseProperty[] bp = null;
		try {
			bp = baseVP90.getFachgebieteByOrdId(dialogId, ordId,
					taetigkeitsBereichId);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return bp;
	}

	/**
	 * Mit dieser Funktion werden die GINA-Information und die
	 * Verfügbarkeitsinformationen der auf der GINA installierten Services
	 * geliefert.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>keine
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Objekt, welches GINA-Informationen und
	 *         Serviceverfügbarkeitsinformationen enthält, siehe auch
	 *         {@link StatusInformationen StatusInformationen}
	 * @throws RemoteException 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public StatusInformationen getGinaAndServiceavailabilityInformation() {
		StatusInformationen si = null;
		try {
			si = baseVP90.getGinaAndServiceavailabilityInformation();
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return si;
	}

	/**
	 * Mit dieser Funktion kann vor einem Request mit Kartenzugriff die
	 * Kartenleserzuordnung geändert werden. Es wird dem Dialog der Kartenleser
	 * mit der in den Eingangsdaten übergebenen CardReaderId zugeordnet.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Es ist zumindest 1 Kartenleser am Ordinations-Client/Server-GINA
	 * angeschlossen.
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 */
	@Override
	public void setCardReader(String dialogId, String cardReaderId)
			throws CardException, DialogException {
		try {
			baseVP90.setCardReader(dialogId, cardReaderId);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
	}

	/**
	 * Mit dieser Funktion werden Ereignisse der Kartenleser ermittelt. Die
	 * Ereignis ist z.B. Änderung von es ist keine Karte gesteckt auf es ist
	 * eine Karte gesteckt. Es werden dabei für die, der GINA, bekannten
	 * Kartenleser laufend die aktuellen Kartenleserstatus und Ereignisse
	 * ermittelt. Abhängig der Eingangsdaten (statusId) enthält das
	 * Rückgabeobjekt die aktuellen Kartenleserstatus (momentaner
	 * Kartenleserstatus zum Abfragezeitpunkt) oder die aufgetretenen Ereignisse
	 * (Änderungen der Kartenleserstatus seit dem letzten Aufruf) in Form von
	 * Kartenleserstatus-Events.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>Es ist zumindest 1 Kartenleser am Ordinations-Client/Server-GINA
	 * angeschlossen.
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> keine Zuordnung zu einer Laufzeitgruppe (durch
	 * den Übergabeparameter userWaitTime)
	 * </p>
	 * 
	 * @param statusId
	 *            Handle, Identifikationskennzeichen, optional
	 *            <p>
	 *            Einer der Rückgabewerte dieser Funktion  bei jedem
	 *            Funktionsaufruf wird ein neuer Handle returniert <br>
	 *            - wird der zuletzt erhaltene Handle übergeben, enthält das
	 *            Rückgabeobjekt nur die aufgetretenen Ereignisse seit der
	 *            letzten Abfrage (Bsp. Ausgabe Ereignis Leser 1: Änderung von
	 *            keine Karte auf Karte gesteckt mit Kartentyp e-card,
	 *            keine Ausgabe für Leser 2 und 3 da noch immer keine Karte
	 *            gesteckt und daher kein Ereignis für diese Leser aufgetreten
	 *            ist, )<br>
	 *            - wird ein Leerstring übergeben, enthält das Rückgabeobjekt
	 *            die momentan aktuellen Kartenleserstatus der Kartenleser zum
	 *            Abfragezeitpunkt (Bsp. Leser 1 Karte gesteckt, Kartentyp
	 *            e-card, Leser 2 keine Karte gesteckt, Leser 3 keine Karte
	 *            gesteckt, )
	 *            </p>
	 * @param readerList
	 *            Objekt mit cardReaderIds (Identifizierer von Kartenleser),
	 *            Filterkriterium, optional
	 *            <p>
	 *            - wird eine Kartenleserliste übergeben werden nur die
	 *            Ereignisse/Kartenleserstatus der angegebenen Kartenleser
	 *            returniert <br>
	 *            - wird keine Kartenleserliste übergeben, werden die
	 *            Ereignisse/Kartenleserstatus für alle Kartenleser returniert.
	 *            <br>
	 *            <br>
	 *            Performancehinweis: bei sehr großen Installationen, und einer
	 *            nur geringfügig oder gar nicht eingeschränkten
	 *            Kartenleserliste, kann es von Vorteil sein diesen Parameter
	 *            leer zu lassen und die Filterung in der
	 *            Vertragspartnersoftware selbst durchzuführen
	 *            </p>
	 * @param userWaitTime
	 *            Maximale Wartezeit in Millisekunden, während dieser Zeit
	 *            wartet die Funktion auf auftretende Ereignisse
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR}
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_TIMEOUT_PARAMETER
	 *             INVALID_TIMEOUT_PARAMETER},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADERCONTROL_NOT_STARTED
	 *             CARDREADERCONTROL_NOT_STARTED}
	 * @return Objekt, welches den aktuellen handle und die aufgetretenen
	 *         Kartenleserstatus-Events, siehe auch {@link ReaderStatusResult
	 *         ReaderStatusResult} enthält
	 */
	@Override
	public ReaderStatusResult getReaderStatusEvents(String handle,
			String[] cardReaderId, int timeOut) throws CardException {
		ReaderStatusResult r = null;
		try {
			r = baseVP90.getReaderStatusEvents(handle, cardReaderId, timeOut);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return r;
	}

	/**
	 * Mit dieser Funktion kann die Karte im Kartenleser explizit freigegeben
	 * werden.
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers.
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID}
	 * 
	 */
	@Override
	public void releaseCardReader(String cardReaderId) throws CardException {
		try {
			baseVP90.releaseCardReader(cardReaderId);
		} catch (CardException e) {
			throw e;
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}

	}

	/**
	 * Diese Funktion gibt die mit dem Dialog verbundenen Rechte im Format
	 * <code>Service.Recht</code> zurück.
	 * 
	 * <p>
	 * <B>Voraussetzungen: </B> <br>
	 * <ul>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt</li>
	 * <li>Der Dialog wurde im Online-Modus aufgebaut. Wenn der Dialog im
	 * Offline-Modus aufgebaut wurde, wird eine leere Liste zurückgegeben.</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id, die durch die Methode {@link #createDialog
	 *            createDialog} erzeugt wurde
	 * @return Array von Rechten (als Strings)
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID
	 *             ORDINATION_ID_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID}
	 */
	@Override
	public String[] getBerechtigungen(String dialogId) throws DialogException  {
		String[] out = null;
		try {
			out = baseVP90.getBerechtigungen(dialogId);
		} catch (ServiceException e) {
			handleServiceException(e);
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return out;
	}

	/**
	 * Delivers the CardReader Object as identified by the cardReader Id.
	 * 
	 * @param cardReaderId String as returned by {@link CardReader#getId()}
	 * @return CardReader object as given by the String ID, null if not found
	 */
	public CardReader getCardReaderObjectFromCardReaderId(String cardReaderId) {
		CardReader[] cr = getCardReaders();
		for (int i = 0; i < cr.length; i++) {
			if(cardReaderId.equalsIgnoreCase(cr[i].getId())) return cr[i];
		}
		return null;
	}
	
	
	
	private void handleServiceException(ServiceException e) {
		GINAStatus.setGinaStatus(GINAStatus.GINA_STATUS_NO_CONNECTION_TO_GINA, null);
		// TODO - If correctly configured should come back
		// TODO - CardReader und DialogStatus???
		// TODO - selbes für RemoteException
		 Status status = new Status(IStatus.ERROR, PLUGIN_ID,
		 "GINA BASE Service 9.0 " + e.getMessage1(), e);
		 StatusManager.getManager().handle(status, StatusManager.SHOW);
		 e.printStackTrace();
	}
}
