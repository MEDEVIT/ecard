/**
 * (c) MEDEVIT OG
 */
package at.medevit.elexis.at.ecard.client.kse;

import java.rmi.RemoteException;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.BCardException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.IKseService;
import at.chipkarte.client.kse.soap.KonsultationdatenAnfrage;
import at.chipkarte.client.kse.soap.KonsultationsBeleg;
import at.chipkarte.client.kse.soap.Konsultationsdaten;
import at.chipkarte.client.kse.soap.Limit;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.chipkarte.client.kse.soap.SuchFilter;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.GINAServiceManager;
import at.medevit.elexis.at.ecard.client.base.exceptionHandler.RemoteExceptionHandler;
import ch.elexis.Hub;

/**
 * Singleton Class gaining access to the Krankenscheinersatz Service on a GINA by resolving the
 * respective Endpoint at the GINAs ServiceManager Endpoint URL
 * 
 * @author M. Descher, MEDEVIT, Austria
 * 
 */
public class KseService implements IKseService {
	
	public static final String PLUGIN_ID = "at.medevit.elexis.at.ecard.client.kse";
	
	private static KseService instance = null;
	private static IKseService kseVP11 = null;
	
	private KseService(String ginaServiceManagerUrl){
		if (kseVP11 == null) {
			kseVP11 = initKse11ServiceConnection(ginaServiceManagerUrl);
		}
	}
	
	private IKseService initKse11ServiceConnection(String ginaServiceManagerUrl){
		IKseService k = null;
		String gsmu = null;
		if (ginaServiceManagerUrl != null) {
			gsmu = ginaServiceManagerUrl;
		} else {
			gsmu = GINAServiceManager.getConfiguredGinaServiceManagerEndpointUrl();
		}
		try {
			k = GINAServiceManager.getKseService("11.0", gsmu);
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return k;
	}
	
	/**
	 * Generate an instance of {@link KseService} by passing a GinaServiceManager Endpoint URL if
	 * the parameter passed is null, the location is read from the Hub.localcfg
	 * 
	 * @param ginaServiceManagerUrl
	 *            leave null to use the system configured url
	 * @return
	 */
	public static KseService getInstance(String ginaServiceManagerUrl){
		if (instance == null || kseVP11 == null) {
			instance = new KseService(ginaServiceManagerUrl);
		}
		return instance;
	}
	
	/**
	 * Disconnect the instance from the service, by setting all respective variables to null. If a
	 * local variable of type {@link KseService} was created this method returns null to also delete
	 * the respective variable.
	 * 
	 * @return null
	 */
	public static KseService disconnect(){
		instance = null;
		kseVP11 = null;
		return null;
	}
	
	public static boolean isConnected(){
		return instance != null && kseVP11 != null;
	}
	
	/**
	 * Diese Funktion liefert den Systemstatus des KSE Systems zurück.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
	 *         Möglicher Key siehe
	 *         {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE
	 *         SERVICE_STATE}.<br>
	 *         Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus
	 *         Konstanten}<br>
	 *         Im Falle eines nicht konfigurierten KSE Service wird auch OFFLINE als Modus gesetzt.
	 *         Dann sind auch keine Offline-Funktionen möglich.
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
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
	 */
	@Override
	public Property[] checkStatus(String dialogId) throws DialogException, ServiceException,
		AccessException{
		
		Property[] result = null;
		try {
			result = kseVP11.checkStatus(dialogId);
		} catch (AccessException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return result;
	}
	
	/**
	 * Diese Funktion liefert alle Limitstände des Vertragspartners für die aktuelle
	 * Abrechnungsperiode oder für die Nachbringfrist zur Ordinationsadresse, die dem Dialog
	 * zugeordnet ist. <br>
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt.
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param zeitraum
	 *            Zeitraum für den die Limits abgefragt werden sollen.
	 *            <table border="0">
	 *            <tr>
	 *            <td width="60">&nbsp;</td>
	 *            <td>Gültige Werte:</td>
	 *            <td>&nbsp;</td>
	 *            </tr>
	 *            <tr>
	 *            <td>&nbsp;</td>
	 *            <td>
	 *            {@link at.chipkarte.client.kse.soap.constants.LimitZeitraum#AKTUELLE_PRUEFPERIODE
	 *            LimitZeitraum.AKTUELLE_PRUEFPERIODE}</td>
	 *            <td>es werden die Limits für die aktuelle Prüfperiode abgefragt</td>
	 *            </tr>
	 *            <tr>
	 *            <td>&nbsp;</td>
	 *            <td> {@link at.chipkarte.client.kse.soap.constants.LimitZeitraum#NACHBRINGFRIST
	 *            LimitZeitram.NACHBRINGFRIST}</td>
	 *            <td>es werden die Limits für die Nachbringfrist abgefragt</td>
	 *            </tr>
	 *            </table>
	 * @return Array von Limit Objekten
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID},
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_LIMIT_ZEITRAUM
	 *             INVALID_LIMIT_ZEITRAUM}
	 */
	@Override
	public Limit[] getLimit(String dialogId, int zeitraum) throws DialogException,
		ServiceException, AccessException, InvalidParameterException{
		
		Limit[] l = null;
		try {
			l = kseVP11.getLimit(dialogId, zeitraum);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return l;
	}
	
	/**
	 * 
	 * Diese Funktion dient dazu, eine Konsultation durchzuführen oder nachzuerfassen.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>eine gültige e-card oder o-card ist im, dem Dialog zugeordneten, Kartenleser gesteckt
	 * <li>Online Modus des Dialogs
	 * <li>keine Offline Konsultationen vorhanden, deren Frist zum Senden an das e-card Serversystem
	 * überschritten ist, siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED
	 * KseExceptionConstants.OFFLINE_FRIST_EXCEEDED}
	 * <li>Wenn die Konsultation mit der <b>e-card </b> durchgeführt wird, muss diese in dem
	 * Kartenleser, der dem Dialog zugeordnet ist, gesteckt sein. Wenn die Konsultation mit der
	 * <b>Bürgerkarte </b> durchgeführt wird, muss zuvor die Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#getBCardSvPerson
	 * IBaseService.getBCardSvPerson} mit der gesteckten Bürgerkarte aufgerufen werden, um so die
	 * Sozialversicherungsnummer des Patienten zu ermittelt. Danach muss die o-card gesteckt werden
	 * und die Funktion <code>doKonsultation</code> durchgeführt werden. Der Parameter
	 * <code>svNummer</code> muss mit der durch die Funktion <code>getBCardSvPerson</code>
	 * ermittelten Sozialversicherungsnummer gesetzt werden.
	 * <li>KSE-Recht </ul>
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param cin
	 *            Card Identification Number der Karte, die für die Signatur verwendet wird.
	 *            Prüfung, ob die Karte ident mit der Karte ist, von der die Daten (SV Nummer)
	 *            gelesen wurde. Wenn null, erfolgt keine Prüfung.
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs.
	 * @param svNummer
	 *            Sozialversicherungsnummer der SV Person, die die Leistung in Anspruch nimmt. Wird
	 *            im Falle der Zeichnung mit der o-card bzw. Bürgerkarte benötigt; im Falle der
	 *            Bürgerkarte muss die <code>svNummer</code> zuvor durch die Funktion
	 *            <code>getCardData</code> abgefragt werden. Wenn die svNummer null ist, wird die
	 *            Sozialversicherungsnummer der gesteckten e-card automatisch verwendet und diese
	 *            Angabe ignoriert. Die gesteckte e-card ist dafür Voraussetzung.
	 * @param svtCode
	 *            Code des Sozialversicherungsträgers der SV-Person, für die diese Konsultation
	 *            durchgeführt wird. Wenn null, wird der Sozialversicherungsträger automatisch vom
	 *            e-card Serversystem ermittelt. <br>
	 *            Mögliche Werte laut Funktion
	 *            {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}
	 * @param anspruchId
	 *            Id des abgeleiteten Anspruchs, sonst null. Die möglichen Ansprüche einer SV-Person
	 *            wurden durch vorherigen Aufruf dieser Funktion unter Angabe eines nicht
	 *            eindeutigen Anspruchs in der Exception
	 *            {@link at.chipkarte.client.kse.soap.exceptions.KseException AnspruchException}
	 *            zurückgeliefert.
	 * @param fachgebietsCode
	 *            Fachgebiet, für das diese Konsultation durchgeführt wird. <br>
	 *            Mögliche Werte laut Funktion
	 *            {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() getFachgebiete}
	 * @param behandlungsfallCode
	 *            Behandlungfall, für den diese Konsultation durchgeführt wird. <br>
	 *            Mögliche Werte laut Funktion {@link #getBehandlungsfaelle() getBehandlungsfaelle}
	 * @param nacherfassungsgrundCode
	 *            Grund für die Nacherfassung einer Konsultation. Wenn null, handelt es sich um eine
	 *            Konsultation (Behandlungsfall durchführen), sonst um eine nacherfasste
	 *            Konsultation. In diesem Fall muss auch das Behandlungsdatum angeführt werden. <br>
	 *            Mögliche Werte siehe
	 *            {@link at.chipkarte.client.kse.soap.constants.Nacherfassungsgrund
	 *            Nacherfassungsgrundcodes}
	 * @param behandlungsdatum
	 *            Datum, an dem die nachzuerfassende Konsultation tatsächlich durchgeführt wurde.
	 *            Pflichtfeld, wenn <Code>
	 *            nacherfassungsgrundCode</Code> angegeben, sonst null. <br>
	 *            Format: TT.MM.JJJJ
	 * @param forceExecution
	 *            Die Exception
	 *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *            CardExceptionConstants.REPEATED_SIGNATUR} wird nicht geworfen. <br>
	 *            Die Durchführung dieser Funktion wird durch diese Exception nicht mehr
	 *            abgebrochen.
	 *            <p>
	 *            <b>HINWEIS: </b> <br>
	 *            Allenfalls am Ordination-Client zwischengespeicherte Bürgerkartendaten werden
	 *            gelöscht.
	 *            </p>
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * 
	 * @return Objekt vom Typ ErgebnisKonsultation
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL
	 *             MISSING_KSE_FULL}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
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
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER
	 *             NO_CARD_READER},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE
	 *             INVALID_CERTIFICATE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH
	 *             CERTIFICATE_MISMATCH},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID
	 *             CERTIFICATE_TIMESTAMPS_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID
	 *             CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE
	 *             CERTIFICATE_REQUEST_OUT_OF_DATE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION
	 *             PARAMETER_MISMATCH_EXCEPTION}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER
	 *             INVALID_SV_NUMBER},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT
	 *             INVALID_SVT},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG
	 *             INVALID_FG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF
	 *             INVALID_BF},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_NACHERFASSUNGSGRUND
	 *             INVALID_NACHERFASSUNGSGRUND},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_NOT_SET
	 *             DATE_NOT_SET},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID
	 *             DATE_INVALID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_IN_FUTURE
	 *             DATE_IN_FUTURE},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ILLEGAL_VALUE
	 *             ILLEGAL_VALUE},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_ECARD
	 *             NO_CERTIFICATE_AND_NO_ECARD},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_CARD_READER
	 *             NO_CERTIFICATE_AND_NO_CARD_READER}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *             REPEATED_SIGNATUR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws BCardException
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#NOMATCH_BCARD_SVNR
	 *             NOMATCH_BCARD_SVNR},
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#NO_BCARD_DATA_AVAIL
	 *             NO_BCARD_DATA_AVAIL},
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#SVPERSON_NO_LONGER_FOUND
	 *             SVPERSON_NO_LONGER_FOUND},
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#SVNR_CONFIRMATION
	 *             SVNR_CONFIRMATION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED
	 *             OFFLINE_FRIST_EXCEEDED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_FOR_SVT_EXCEPTION
	 *             NO_VPANSPRUCH_FOR_SVT_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_OUT_OF_RANGE_EXCEPTION
	 *             DATE_OUT_OF_RANGE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SPECIALISM_EXCEPTION
	 *             INVALID_SPECIALISM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION
	 *             NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_CLAIM_EXCEPTION
	 *             NO_SUCH_CLAIM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_ANSPRUCH_PROVIDED_EXCEPTION
	 *             NO_ANSPRUCH_PROVIDED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CLAIM_EXCEPTION
	 *             INVALID_CLAIM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_EXCEPTION
	 *             NO_VPANSPRUCH_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED
	 *             KONSULTATION_CHANGED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_ALREADY_CANCELLED
	 *             KONSULTATION_ALREADY_CANCELLED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION
	 *             NO_SUCH_KONSULTATION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#REFERERALL_REQUIRED_EXCEPTION
	 *             REFERERALL_REQUIRED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SVT_PROVIDED_EXCEPTION
	 *             NO_SVT_PROVIDED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TREATMENT_DATE_IN_FUTURE_EXCEPTION
	 *             TREATMENT_DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION
	 *             INVALID_SIGNATURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION
	 *             INVALID_CARD_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#AGE_NOT_REACHED
	 *             AGE_NOT_REACHED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_BEHANDLUNGSFALL
	 *             INVALID_BEHANDLUNGSFALL},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VA_MATCHING_KONSULTATION
	 *             NO_VA_MATCHING_KONSULTATION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED
	 *             TIME_NOT_ELAPSED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED
	 *             ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED
	 *             ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED
	 *             BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED
	 *             BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_CHECK_PATIENT
	 *             INVALID_CARD_CHECK_PATIENT},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT
	 *             INVALID_CARD_LOST_STOLEN_CHECK_PATIENT}
	 */
	@Override
	public ErgebnisKonsultation doKonsultation(String cin, String dialogId, String svNummer,
		String svtCode, String anspruchId, String fachgebietsCode, String behandlungsfallCode,
		String nacherfassungsgrundCode, String behandlungsdatum, boolean forceExecution,
		String cardReaderId) throws CardException, DialogException, KseException, BCardException,
		ServiceException, AccessException, InvalidParameterException{
		
		if (cardReaderId == null)
			cardReaderId =
				Hub.localCfg.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR,
					GINAConfigurationConstants.NO_VALUE);
		
		ErgebnisKonsultation ek = null;
		try {
			ek =
				kseVP11.doKonsultation(cin, dialogId, svNummer, svtCode, anspruchId,
					fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode,
					behandlungsdatum, forceExecution, cardReaderId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (CardException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (BCardException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ek;
	}
	
	/**
	 * 
	 * Diese Funktion übermittelt die Antwortinformationen einer Zusatzinformation an das e-card
	 * Serversystem.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param zusatzinformationsAntwortId
	 *            Zusatzinformations-Antwort ID die von der Funktion
	 *            {@link at.chipkarte.client.kse.soap.IKseService#doKonsultation doKonsultation}
	 *            geliefert wurde
	 * @param zusatzinformationsAntwort
	 *            die zur Zusatzinformation ermittelte Anwort, mögliche Werte siehe
	 *            {@link at.chipkarte.client.kse.soap.constants.ZusatzinformationsAntwort
	 *            ZusatzinformationsAntwort}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL
	 *             MISSING_KSE_FULL}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
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
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ZUSATZINFO_ANTWORTID_REQUIRED
	 *             ZUSATZINFO_ANTWORTID_REQUIRED},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ANTWORT_REQUIRED
	 *             ANTWORT_REQUIRED}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ZUSATZINFO_ANTWORTID_NOT_ALLOWED
	 *             ZUSATZINFO_ANTWORTID_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ZUSATZINFO_ANTWORTID_ALREADY_USED
	 *             ZUSATZINFO_ANTWORTID_ALREADY_USED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ZUSATZINFO_ANTWORTID_INVALID
	 *             ZUSATZINFO_ANTWORTID_INVALID}
	 */
	@Override
	public void sendZusatzinformationsAntwort(String dialogId, long zusatzinformationsAntwortId,
		int zusatzinformationsAntwort) throws InvalidParameterException, AccessException,
		KseException, DialogException, ServiceException{
		
		try {
			kseVP11.sendZusatzinformationsAntwort(dialogId, zusatzinformationsAntwortId,
				zusatzinformationsAntwort);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
	}
	
	/**
	 * 
	 * Durchführen oder Nacherfassen einer Konsultation im Offline Modus. Dabei werden die erfassten
	 * Daten am Ordinations-Client gespeichert und keine Online Konsultation durchgeführt. Die
	 * Offline Konsultation kann zu einem späteren Zeitpunkt, wenn der Ordinations-Client wieder
	 * Online ist, an den e-card Server übertragen werden
	 * {@link at.chipkarte.client.kse.soap.IKseService#sendOfflineKonsultation(String, String, String, String, String, String)
	 * sendOfflineKonsultation}. <br>
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>eine gültige e-card oder o-card ist im dem Dialog zugeordneten Kartenleser gesteckt
	 * <li>Offline Modus des Dialogs
	 * <li>KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param cin
	 *            Card Identification Number der Karte, die für die Signatur verwendet wird.
	 *            Prüfung, ob die Karte ident mit der Karte ist, von der die Daten (SV Nummer)
	 *            gelesen wurde. Wenn null, erfolgt keine Prüfung.
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param svNummer
	 *            Sozialversicherungsnummer der SV Person, die die Leistung in Anspruch nimmt. Wird
	 *            nur im Falle der Zeichnung mit der o-card bzw. Bürgerkarte benötigt; wenn null,
	 *            wird die Sozialversicherungsnummer der gesteckten e-card automatisch verwendet und
	 *            diese Angabe ignoriert.
	 * @param svtCode
	 *            Code des Sozialversicherungsträgers der SV-Person, für die diese Konsultation
	 *            durchgeführt wird. Wenn null, wird der Sozialversicherungsträger automatisch vom
	 *            e-card Serversystem ermittelt. <br>
	 *            Mögliche Werte laut Funktion
	 *            {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}
	 * @param fachgebietsCode
	 *            Fachgebiet, für das diese Konsultation durchgeführt wird. <br>
	 *            Mögliche Werte laut Funktion
	 *            {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() getFachgebiete}
	 * @param behandlungsfallCode
	 *            Behandlungfall, für den diese Konsultation durchgeführt wird. <br>
	 *            Mögliche Werte laut Funktion {@link #getBehandlungsfaelle() getBehandlungsfaelle}
	 * @param nacherfassungsgrundCode
	 *            Grund für die Nacherfassung einer Konsultation. Wenn null, handelt es sich um eine
	 *            Konsultation (Behandlungsfall durchführen), sonst um eine nacherfasste
	 *            Konsultation. In diesem Fall muss auch das Behandlungsdatum angeführt werden. <br>
	 *            Mögliche Werte siehe
	 *            {@link at.chipkarte.client.kse.soap.constants.Nacherfassungsgrund
	 *            Nacherfassungsgrundcodes}
	 * @param behandlungsdatum
	 *            Datum, an dem die nachzuerfassende Konsultation tatsächlich durchgeführt wurde.
	 *            Pflichtfeld, wenn <Code>
	 *            nacherfassungsgrundCode</Code> angegeben, sonst null. <br>
	 *            Format: TT.MM.JJJJ
	 * @param forceExecution
	 *            Die Exception
	 *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *            CardExceptionConstants.REPEATED_SIGNATUR} wird nicht geworfen. <br>
	 *            Die Durchführung dieser Funktion wird durch diese Exception nicht mehr
	 *            abgebrochen.
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * 
	 * @return Objekt vom Typ OfflineRecord
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL
	 *             MISSING_KSE_FULL}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE
	 *             FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER
	 *             NO_CARD_READER},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE
	 *             INVALID_CERTIFICATE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID
	 *             CERTIFICATE_TIMESTAMPS_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID
	 *             CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE
	 *             CERTIFICATE_REQUEST_OUT_OF_DATE},
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER
	 *             INVALID_SV_NUMBER},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT
	 *             INVALID_SVT},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG
	 *             INVALID_FG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF
	 *             INVALID_BF},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_NACHERFASSUNGSGRUND
	 *             INVALID_NACHERFASSUNGSGRUND},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_NOT_SET
	 *             DATE_NOT_SET},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID
	 *             DATE_INVALID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_IN_FUTURE
	 *             DATE_IN_FUTURE},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ILLEGAL_VALUE
	 *             ILLEGAL_VALUE},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_ECARD
	 *             NO_CERTIFICATE_AND_NO_ECARD},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_CARD_READER
	 *             NO_CERTIFICATE_AND_NO_CARD_READER}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *             REPEATED_SIGNATUR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#AUTHENTICATION_FAILED
	 *             AUTHENTICATION_FAILED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * 
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED
	 *             CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED}
	 */
	@Override
	public OfflineRecord doKonsultationOffline(String cin, String dialogId, String svNummer,
		String svtCode, String fachgebietsCode, String behandlungsfallCode,
		String nacherfassungsgrundCode, String behandlungsdatum, boolean forceExecution,
		String cardReaderId) throws InvalidParameterException, AccessException, CardException,
		KseException, ServiceException, DialogException{
		
		OfflineRecord or = null;
		try {
			or =
				kseVP11.doKonsultationOffline(cin, dialogId, svNummer, svtCode, fachgebietsCode,
					behandlungsfallCode, nacherfassungsgrundCode, behandlungsdatum, forceExecution,
					cardReaderId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (CardException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return or;
	}
	
	/**
	 * Mit dieser Funktion wird eine stornierbare Konsultation storniert, wenn das Behandlungsdatum
	 * der Konsultation in der aktuellen Abrechnungsperiode liegt oder das Behandlungsdatum in der
	 * vorigen Abrechnungsperiode und das aktuelle Datum in der Nachbringfrist der vorigen
	 * Abrechnungsperiode liegen. <br>
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param konsId
	 *            Id der zu stornierenden Konsultation
	 * @param konsVersion
	 *            Version der zu stornierenden Konsultation
	 * 
	 * @return Objekt vom Typ KonsultationsBeleg
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
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
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID
	 *             INVALID_ANFRAGE_ID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATION_VERSION
	 *             INVALID_KONSULTATION_VERSION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED
	 *             KONSULTATION_CHANGED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_ALREADY_CANCELLED
	 *             KONSULTATION_ALREADY_CANCELLED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION
	 *             NO_SUCH_KONSULTATION}
	 */
	@Override
	public KonsultationsBeleg stornierenKonsultation(String dialogId, long konsId, int konsVersion)
		throws InvalidParameterException, AccessException, KseException, ServiceException,
		DialogException{
		
		KonsultationsBeleg b = null;
		try {
			b = kseVP11.stornierenKonsultation(dialogId, konsId, konsVersion);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return b;
	}
	
	/**
	 * Mit dieser Funktion wird eine stornierte Konsultation wieder in Kraft gesetzt, wenn das
	 * Behandlungsdatum der Konsultation in der aktuellen Abrechnungsperiode liegt oder das
	 * Behandlungsdatum in der vorigen Abrechnungsperiode und das aktuelle Datum in der
	 * Nachbringfrist der vorigen Abrechnungsperiode liegen. <br>
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param konsId
	 *            Id der wieder in Kraft zu setzenden Konsultation
	 * @param konsVersion
	 *            Version der wieder in Kraft zu setzenden Konsultation
	 * 
	 * @return Objekt vom Typ ErgebnisKonsultation
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID
	 *             INVALID_ANFRAGE_ID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATION_VERSION
	 *             INVALID_KONSULTATION_VERSION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED
	 *             KONSULTATION_CHANGED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION
	 *             NO_SUCH_KONSULTATION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_NOT_CANCELLED
	 *             KONSULTATION_NOT_CANCELLED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED
	 *             TIME_NOT_ELAPSED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INEXISTENT_ANSPRUCH_FOR_RESET
	 *             INEXISTENT_ANSPRUCH_FOR_RESET}
	 */
	@Override
	public ErgebnisKonsultation wiederinkraftsetzenKonsultation(String dialogId, long konsId,
		int konsVersion) throws InvalidParameterException, AccessException, KseException,
		ServiceException, DialogException{
		
		ErgebnisKonsultation ek = null;
		try {
			ek = kseVP11.wiederinkraftsetzenKonsultation(dialogId, konsId, konsVersion);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ek;
	}
	
	/**
	 * Mit dieser Funktion wird eine änderbare Konsultation geändert, wenn das Behandlungsdatum der
	 * Konsultation in der aktuellen Abrechnungsperiode liegt oder das Behandlungsdatum in der
	 * vorigen Abrechnungsperiode und das aktuelle Datum in der Nachbringfrist der vorigen
	 * Abrechnungsperiode liegen.
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param konsId
	 *            Id der zu ändernden Konsultation
	 * @param konsVersion
	 *            Version der zu ändernden Konsultation
	 * @param behandlungsfallCode
	 *            Behandlungsfall, auf den die Konsultation geändert werden soll. <br>
	 *            Mögliche Werte laut Funktion {@link #getBehandlungsfaelle() getBehandlungsfaelle}
	 * 
	 * @return Objekt vom Typ KonsultationsBeleg
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
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
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID
	 *             INVALID_ANFRAGE_ID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATION_VERSION
	 *             INVALID_KONSULTATION_VERSION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED
	 *             KONSULTATION_CHANGED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_ALREADY_CANCELLED
	 *             KONSULTATION_ALREADY_CANCELLED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION
	 *             NO_SUCH_KONSULTATION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_EXCEPTION
	 *             NO_VPANSPRUCH_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_FOR_SVT_EXCEPTION
	 *             NO_VPANSPRUCH_FOR_SVT_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SPECIALISM_EXCEPTION
	 *             INVALID_SPECIALISM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_BEHANDLUNGSFALL
	 *             INVALID_BEHANDLUNGSFALL},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#SAME_BEHANDLUNGSFALL
	 *             SAME_BEHANDLUNGSFALL},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#REFERERALL_REQUIRED_EXCEPTION
	 *             REFERERALL_REQUIRED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#AGE_NOT_REACHED
	 *             AGE_NOT_REACHED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VA_MATCHING_KONSULTATION
	 *             NO_VA_MATCHING_KONSULTATION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED
	 *             TIME_NOT_ELAPSED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED
	 *             ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED
	 *             ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED
	 *             BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED
	 *             BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED}
	 */
	@Override
	public KonsultationsBeleg aendernKonsultation(String dialogId, long konsId, int konsVersion,
		String behandlungsfallCode) throws DialogException, ServiceException, KseException,
		AccessException, InvalidParameterException{
		KonsultationsBeleg kb = null;
		try {
			kb = kseVP11.aendernKonsultation(dialogId, konsId, konsVersion, behandlungsfallCode);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return kb;
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden die den Suchkriterien entsprechenden Konsultationen angefordert.
	 * Diese Funktion sollte für das Abfragen von Konsultationsdaten verwendet werden, die dem
	 * Benutzer für Korrekturfunktionen (stornieren, wieder in Kraft setzen, ändern) angeboten
	 * werden (sofern diese Daten nicht von der Vertragspartner Software selbst gepeichert werden).
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>eine der Funktionen {@link #getKonsultationsdaten(String, SuchFilter, String)
	 * getKonsultationsdaten} und {@link #downloadKonsultationsdaten(String, String)
	 * downloadKonsultationsdaten} wird nicht zeitgleich ausgeführt, siehe auch
	 * {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED
	 * FUNCTION_LOCKED}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <H3>ACHTUNG:</H3> Wenn die Selektionsart
	 * {@link at.chipkarte.client.kse.soap.constants.Selektionsart#ALLE "ALLE"} ist,
	 * <ul>
	 * <li>wird der Parameter {@link SuchFilter#getSVNummer() SuchFilter.sVNummer} nicht
	 * ausgewertet.
	 * <li>werden maximal die Konsultationen für die aktuelle Abrechnungsperiode plus zwei
	 * Vorquartale geliefert
	 * </ul>
	 * <br>
	 * Wenn die Selektionsart
	 * {@link at.chipkarte.client.kse.soap.constants.Selektionsart#MODIFIZIERBAR "MODIFIZIERBAR"}
	 * oder {@link at.chipkarte.client.kse.soap.constants.Selektionsart#STORNIERT "STORNIERT"} ist,
	 * <ul>
	 * <li>werden keine vollständigen Konsultationsbelege geliefert, die für die Abrechnung mit dem
	 * jeweiligen SVT verwendet werden können!
	 * <li>sollte eines der Selektionskriterien <code>Zeitintervall</code>( <code>DatumVon</code>,
	 * <code>DatumBis</code>) oder <code>SvNummer</code> in der {@link SuchFilter SuchFilter} Klasse
	 * gesetzt sein.
	 * <li>werden maximal die Konsultationen für die aktuelle Abrechnungsperiode inklusive
	 * Nachbringfrist geliefert
	 * </ul>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Lang
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param selektionsKriterien
	 *            Selektionskriterien zur Einschränkung der Daten, siehe auch {@link SuchFilter
	 *            SuchFilter}
	 * @param selektionsart
	 *            Festlegung der Selektionsart, mögliche Werte siehe
	 *            {@link at.chipkarte.client.kse.soap.constants.Selektionsart Selektionsarten}
	 * 
	 * @return Konsultationsdaten ohne Signaturinformation und Abstimmungsbeleg
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED
	 *             FUNCTION_LOCKED},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
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
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SELEKTIONS_ART
	 *             INVALID_SELEKTIONS_ART},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ORDID
	 *             INVALID_ORDID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER
	 *             INVALID_SV_NUMBER},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID
	 *             DATE_INVALID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_ORDER_WRONG
	 *             DATE_ORDER_WRONG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG
	 *             INVALID_FG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF
	 *             INVALID_BF},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT
	 *             INVALID_SVT},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATIONS_ART
	 *             INVALID_KONSULTATIONS_ART}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#SYNC_SUCHANFRAGE_NOT_AVAIL
	 *             SYNC_SUCHANFRAGE_NOT_AVAIL},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_SUCHANFRAGEN_EXCEEDED
	 *             MAX_SUCHANFRAGEN_EXCEEDED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED
	 *             MAX_KONSULTATIONEN_EXCEEDED} <br>
	 * <br>
	 *             <b>ACHTUNG: </b> <br>
	 *             Wenn die angeforderten Konsultationen eine maximale Anzahl übersteigen, kommt es
	 *             zu der KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED
	 *             MAX_KONSULTATIONEN_EXCEEDED}. Daher sollten die Selektionskriterien überlegt
	 *             gewählt werden.
	 * 
	 * 
	 */
	@Override
	public Konsultationsdaten[] getKonsultationsdaten(String dialogId,
		SuchFilter selektionsKriterien, String selektionsart) throws DialogException,
		ServiceException, KseException, AccessException, InvalidParameterException{
		
		Konsultationsdaten[] kd = null;
		try {
			kd = kseVP11.getKonsultationsdaten(dialogId, selektionsKriterien, selektionsart);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return kd;
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden die den Suchkriterien entsprechenden Konsultationen für den
	 * maximalen Zeitraum der aktuellen Abrechnungsperiode plus 2 Vorquartale angefordert. <br>
	 * Von dieser Funktion wird eine Anfrage Id zurückgeliefert. Der Auftrag wird vom e-card
	 * Serversystem zu einem späteren Zeitpunkt bearbeitet. Die Benachrichtigung, dass die
	 * Konsultationsdaten zur Abholung bereitstehen erfolgt über den Messaging Mechanismus durch
	 * Pollen der Funktion {@link at.chipkarte.client.base.soap.IBaseService#checkStatus
	 * checkStatus}. Diese Funktion signalisiert, dass eine neue Message vorliegt. Über die Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#getMessages getMessage} kann die neue
	 * Message abgefragt werden. Hat diese Message die Kategorie <code>ZS_KSE_MSG_ASYDL</code>,
	 * können die bereitgestellten Konsultationsdaten über die Funktion
	 * {@link at.chipkarte.client.kse.soap.IKseService#downloadKonsultationsdaten
	 * downloadKonsultationsdaten} angefordert werden.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <H3>ACHTUNG:</H3> Der Parameter {@link SuchFilter#getSVNummer() SuchFilter.sVNummer} wird
	 * nicht ausgewertet. <br>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param selektionsKriterien
	 *            Selektionskriterien zur Einschränkung der Daten, siehe auch {@link SuchFilter
	 *            SuchFilter}
	 * @return Id der Konsultationdatenanfrage <br>
	 *         Format: maximal 19-stellig
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID
	 *             CORRUPT_DIALOGID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ORDID
	 *             INVALID_ORDID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID
	 *             DATE_INVALID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_ORDER_WRONG
	 *             DATE_ORDER_WRONG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG
	 *             INVALID_FG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF
	 *             INVALID_BF},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT
	 *             INVALID_SVT},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATIONS_ART
	 *             INVALID_KONSULTATIONS_ART}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_SUCHANFRAGEN_EXCEEDED
	 *             MAX_SUCHANFRAGEN_EXCEEDED}
	 * 
	 * <br>
	 * <br>
	 *             <b>ACHTUNG: </b> <br>
	 *             Bei allen Funktionsaufrufen, die einen Konsultationsbeleg erzeugen oder
	 *             manipulieren, werden die aktuellen Belegdaten an die Vertragspartner Software
	 *             übergeben und sollten auch dort gespeichert werden. Somit wird das Anfordern
	 *             aller Belegdaten mit dieser Funktion nur mehr bei Datenverlust in der
	 *             Vertragspartnersoftware notwendig. <br>
	 *             Wenn die angeforderten Konsultationen eine maximale Anzahl übersteigen, kommt es
	 *             zu der KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED
	 *             MAX_KONSULTATIONEN_EXCEEDED}. Daher sollten die Selektionskriterien überlegt
	 *             gewählt werden.
	 */
	@Override
	public String sendKonsultationsdatenAnfrage(String dialogId, SuchFilter selektionsKriterien)
		throws DialogException, InvalidParameterException, AccessException, KseException,
		ServiceException{
		
		String anfrageId = null;
		try {
			anfrageId = kseVP11.sendKonsultationsdatenAnfrage(dialogId, selektionsKriterien);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return anfrageId;
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden Konsultationsdaten, die über eine asynchrone Suchanfrage
	 * {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage
	 * sendKonsultationsdatenAnfrage} angefordert wurden, abgefragt.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>Funktion {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage
	 * sendKonsultationsdatenAnfrage} wurde erfolgreich ausgeführt
	 * <li>eine der Funktionen {@link #getKonsultationsdaten(String, SuchFilter, String)
	 * #getKonsultationsdaten} und {@link #downloadKonsultationsdaten(String, String)
	 * #downloadKonsultationsdaten} wird nicht zeitgleich ausgeführt, siehe auch
	 * {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED
	 * ServiceExceptionConstants.FUNCTION_LOCKED}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Lang
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param anfrageId
	 *            Anfrage ID, die von der Funktion
	 *            {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage
	 *            sendKonsultationsdatenAnfrage} geliefert wurde
	 * 
	 * @return Array von Konsultationsdaten Objekten
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED
	 *             FUNCTION_LOCKED},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
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
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID
	 *             INVALID_ANFRAGE_ID}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ASYNC_REQUEST_ID_NOT_FOUND
	 *             ASYNC_REQUEST_ID_NOT_FOUND},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ASYNC_REQUEST_NOT_PROCESSED
	 *             ASYNC_REQUEST_NOT_PROCESSED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ASYNC_REQUEST_ERROR
	 *             ASYNC_REQUEST_ERROR},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED
	 *             MAX_KONSULTATIONEN_EXCEEDED} <br>
	 * <br>
	 *             <b>ACHTUNG: </b> <br>
	 *             Die Funktion sollte nur ausgeführt werden wenn über den Message Mechanismus
	 *             signalisiert wurde, dass die angeforderten Daten vorliegen. Abhängig von der
	 *             Datenmenge des Ergebnisses kann das Ausführen dieser Funktion längere Zeit in
	 *             Anspruch nehmen. Wenn die angeforderten Konsultationen eine maximale Anzahl
	 *             übersteigen, kommt es zu der KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED
	 *             MAX_KONSULTATIONEN_EXCEEDED}. Daher sollten die Selektionskriterien überlegt
	 *             gewählt werden.
	 * 
	 */
	@Override
	public Konsultationsdaten[] downloadKonsultationsdaten(String dialogId, String anfrageId)
		throws InvalidParameterException, AccessException, KseException, ServiceException,
		DialogException{
		
		Konsultationsdaten[] ret = null;
		try {
			ret = kseVP11.downloadKonsultationsdaten(dialogId, anfrageId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * 
	 * Die Funktion liefert alle anstehenden Anfragen für Konsultationsdaten, die erfolgreich zum
	 * e-card Serversystem übertragen wurden.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Lang
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param onlyReady
	 *            bei "true" werden nur Anfragen zurückgeliefert, die vom e-card System verarbeitet
	 *            und noch nicht abgeholt wurden
	 * @return Array von KonsultationdatenAnfrage Objekten
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
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
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 */
	@Override
	public KonsultationdatenAnfrage[] getKonsultationsdatenAnfragen(String dialogId,
		boolean onlyReady) throws AccessException, ServiceException, DialogException{
		
		KonsultationdatenAnfrage[] ret = null;
		try {
			ret = kseVP11.getKonsultationsdatenAnfragen(dialogId, onlyReady);
		} catch (AccessException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden asynchrone Anfragen für Konsultationsdaten am e-card Serversystem
	 * gelöscht. Die Anfragen können unabhängig von ihrem Status gelöscht werden.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param anfrageId
	 *            Anfrage ID die von der Funktion
	 *            {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage
	 *            sendKonsultationsdatenAnfrage} geliefert wurde
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI
	 *             TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN
	 *             DIALOG_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN
	 *             ORDINATION_ID_UNKNOWN},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID
	 *             INVALID_ANFRAGE_ID}
	 * 
	 */
	@Override
	public void deleteKonsultationsdatenAnfrage(String dialogId, String anfrageId)
		throws InvalidParameterException, AccessException, ServiceException, DialogException{
		
		try {
			kseVP11.deleteKonsultationsdatenAnfrage(dialogId, anfrageId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden sämtliche Konsultationen einer SV-Person, die mit der o-card
	 * signiert wurden, mit der e-card nachsigniert, wenn das Behandlungsdatum der Konsultation in
	 * der aktuellen Abrechnungsperiode liegt oder das Behandlungsdatum in der vorigen
	 * Abrechnungsperiode und das aktuelle Datum in der Nachbringfrist der vorigen
	 * Abrechnungsperiode liegen.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B>
	 * <ul>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>eine gültige <b>e-card </b> ist in dem Kartenleser, der dem Dialog zugeordnet ist,
	 * gesteckt
	 * <li>Es gibt keinen Offline Datensatz, dessen Offline- bzw. Bearbeitungsfrist zum Bearbeiten
	 * bzw. zum Senden an das e-card Serversystem überschritten ist, siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED
	 * KseExceptionConstants.OFFLINE_FRIST_EXCEEDED}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </ul>
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param cin
	 *            Card Identification Number der Karte, die für die Signatur verwendet wird.
	 *            Prüfung, ob die Karte ident mit der Karte ist, von der die Daten (SV Nummer)
	 *            gelesen wurde. Wenn null, erfolgt keine Prüfung.
	 * @param forceExecution
	 *            Die Exception
	 *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *            CardExceptionConstants.REPEATED_SIGNATUR} wird nicht geworfen. <br>
	 *            Die Durchführung dieser Funktion wird durch diese Exception nicht mehr
	 *            abgebrochen.
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * 
	 * @return Array von KonsultationsBeleg Objekten
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
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
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER
	 *             NO_CARD_READER},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE
	 *             INVALID_CERTIFICATE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH
	 *             CERTIFICATE_MISMATCH}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *             REPEATED_SIGNATUR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED
	 *             OFFLINE_FRIST_EXCEEDED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION
	 *             INVALID_SIGNATURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION
	 *             INVALID_CARD_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_CHECK_PATIENT
	 *             INVALID_CARD_CHECK_PATIENT},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT
	 *             INVALID_CARD_LOST_STOLEN_CHECK_PATIENT}
	 */
	@Override
	public KonsultationsBeleg[] nachsignierenKonsultationen(String dialogId, String cin,
		boolean forceExecution, String cardReaderId) throws DialogException, ServiceException,
		KseException, CardException, AccessException{
		
		KonsultationsBeleg[] ret = null;
		try {
			ret = kseVP11.nachsignierenKonsultationen(dialogId, cin, forceExecution, cardReaderId);
		} catch (AccessException e) {
			throw e;
		} catch (CardException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		
		return ret;
	}
	
	/**
	 * Mit dieser Funktion werden sämtliche Konsultationen einer SV-Person, die mit der o-card
	 * signiert wurden, mit der Bürgerkarte nachsigniert, wenn das Behandlungsdatum der Konsultation
	 * in der aktuellen Abrechnungsperiode liegt oder das Behandlungsdatum in der vorigen
	 * Abrechnungsperiode und das aktuelle Datum in der Nachbringfrist der vorigen
	 * Abrechnungsperiode liegen.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B>
	 * <ul>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>Es wurde zuvor die Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#getBCardSvPerson
	 * IBaseService.getBCardSvPerson} mit der gesteckten Bürgerkarte aufgerufen
	 * <li>die o-card des am Dialog angemeldeten Vertragspartners ist im Kartenleser gesteckt
	 * <li>Es gibt keinen Offline Datensatz, dessen Offline- bzw. Bearbeitungsfrist zum Bearbeiten
	 * bzw. zum Senden an das e-card Serversystem überschritten ist, siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED
	 * KseExceptionConstants.OFFLINE_FRIST_EXCEEDED}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param svNummer
	 *            Sozialversicherungsnummer der SV Person, für die Konsultationen nachsigniert
	 *            werden.
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * 
	 * @return Array von KonsultationsBeleg Objekten
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
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
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER
	 *             NO_CARD_READER},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID
	 *             CERTIFICATE_TIMESTAMPS_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID
	 *             CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE
	 *             CERTIFICATE_REQUEST_OUT_OF_DATE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION
	 *             PARAMETER_MISMATCH_EXCEPTION}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER
	 *             INVALID_SV_NUMBER},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE
	 *             NO_CERTIFICATE}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws BCardException
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#NOMATCH_BCARD_SVNR
	 *             NOMATCH_BCARD_SVNR},
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#NO_BCARD_DATA_AVAIL
	 *             NO_BCARD_DATA_AVAIL},
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#SVPERSON_NO_LONGER_FOUND
	 *             SVPERSON_NO_LONGER_FOUND},
	 *             {@link at.chipkarte.client.base.soap.constants.BCardExceptionConstants#SVNR_CONFIRMATION
	 *             SVNR_CONFIRMATION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED
	 *             OFFLINE_FRIST_EXCEEDED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION
	 *             INVALID_SIGNATURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION
	 *             INVALID_CARD_EXCEPTION}
	 *             <p>
	 *             <b>HINWEIS: </b> <br>
	 *             Der Aufruf der Funktion hat zur Folge, dass die zwischengespeicherten
	 *             Bürgerkartendaten am Ordinationclient gelöscht werden.
	 *             </p>
	 * 
	 */
	@Override
	public KonsultationsBeleg[] nachsignierenKonsultationenBCard(String dialogId, String svNummer,
		String cardReaderId) throws DialogException, ServiceException, BCardException,
		InvalidParameterException, AccessException, CardException, KseException{
		
		KonsultationsBeleg[] ret = null;
		try {
			ret = kseVP11.nachsignierenKonsultationenBCard(dialogId, svNummer, cardReaderId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (CardException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (BCardException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * Mit dieser Funktion wird eine Nachsignierungsanfrage offline erfasst und auf der GINA
	 * gespeichert. Sie kann, wenn die GINA wieder online ist, mit der Funktion
	 * {@link at.chipkarte.client.kse.soap.IKseService#sendOfflineNachsignatur(String, String)
	 * sendOfflineNachsignatur} an den e-card Server gesendet werden.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Offline Modus des Dialogs
	 * <li>eine gültige <b>e-card</b> ist in dem Kartenleser, der dem Dialog zugeordnet ist,
	 * gesteckt
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param cin
	 *            Card Identification Number der Karte, die für die Signatur verwendet wird.
	 *            Prüfung, ob die Karte ident mit der Karte ist, von der die Daten (SV Nummer)
	 *            gelesen wurde. Wenn null, erfolgt keine Prüfung.
	 * @param forceExecution
	 *            Die Exception
	 *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *            CardExceptionConstants.REPEATED_SIGNATUR} wird nicht geworfen. <br>
	 *            Die Durchführung dieser Funktion wird durch diese Exception nicht mehr
	 *            abgebrochen.
	 * @param cardReaderId
	 *            Identifizierer des Kartenlesers
	 * 
	 * @return Offline Datensatz
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE
	 *             FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER
	 *             NO_CARD_READER}
	 * @throws CardException
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID
	 *             INVALID_CARD_READER_ID},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD
	 *             NO_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD
	 *             DEFECT_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED
	 *             CARD_CHANGED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD
	 *             WRONG_CARD},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT
	 *             CIN_NOT_IDENT},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR
	 *             REPEATED_SIGNATUR},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#AUTHENTICATION_FAILED
	 *             AUTHENTICATION_FAILED},
	 *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE
	 *             CARDREADER_IN_USE}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED}
	 */
	@Override
	public OfflineRecord nachsignierenKonsultationenOffline(String dialogId, String cin,
		boolean forceExecution, String cardReaderId) throws DialogException, ServiceException,
		KseException, CardException, AccessException{
		
		OfflineRecord ret = null;
		try {
			ret =
				kseVP11.nachsignierenKonsultationenOffline(dialogId, cin, forceExecution,
					cardReaderId);
		} catch (AccessException e) {
			throw e;
		} catch (CardException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden alle zurzeit gültigen Behandlungsfälle geliefert.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>keine
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @return Array der Behandlungsfälle, siehe auch {@link BaseProperty BaseProperty}
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 */
	@Override
	public BaseProperty[] getBehandlungsfaelle() throws ServiceException{
		BaseProperty[] bf = null;
		try {
			bf = kseVP11.getBehandlungsfaelle();
		} catch (ServiceException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return bf;
	}
	
	/**
	 * 
	 * Mit dieser Funktion werden alle zurzeit gültigen Behandlungsfälle zu einem bestimmten
	 * Fachgebiet geliefert.
	 * <p>
	 * <B>Voraussetzung: </B> <br>
	 * <li>keine
	 * </p>
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param fachgebietCode
	 *            Code des Fachgebiets, für das die gültigen Behandlungsfälle abgefragt werden
	 *            sollen
	 * @return Array der Behandlungsfälle für ein Fachgebiet, siehe auch {@link BaseProperty
	 *         BaseProperty}
	 * 
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG
	 *             INVALID_FG}
	 */
	@Override
	public BaseProperty[] getBehandlungsfaelleByFachgebiet(String fachgebietCode)
		throws ServiceException{
		BaseProperty[] bf = null;
		try {
			if (kseVP11 == null) {
				// TODO: Create a db cache for BaseProperty that delivers the label in this case
				return null;
			}
			bf = kseVP11.getBehandlungsfaelleByFachgebiet(fachgebietCode);
			// TODO if bf!=null update the cache
		} catch (ServiceException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return bf;
	}
	
	/**
	 * Diese Funktion ermittelt die zurzeit auf der GINA gespeicherten offline Daten für die dem
	 * Dialog zugeordnete Ordinationsadresse.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>Es gibt am Ordinations-Client keinen gleichzeitigen schreibenden Zugriff auf die
	 * Offline-Datensätze des Vertragspartners; siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 * OFFLINETRANSFER_ALREADY_IN_PROCESS}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @return Array von KseOfflineRecord Objekten in der Reihenfolge der Erstellung
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 *             OFFLINETRANSFER_ALREADY_IN_PROCESS},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED}
	 */
	@Override
	public OfflineRecord[] getOfflineRecords(String dialogId) throws DialogException,
		ServiceException, KseException, AccessException{
		
		OfflineRecord[] ret = null;
		try {
			ret = kseVP11.getOfflineRecords(dialogId);
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * Diese Funktion liefert die Anzahl der am Ordinations-Client gespeicherten Offline
	 * Konsultationen.
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindets eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @return Anzahl der offline gespeicherten Konsultationen
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED}
	 */
	@Override
	public long getNumberOfflineKonsultationen(String dialogId) throws DialogException,
		ServiceException, KseException, AccessException{
		long ret = 0;
		try {
			ret = kseVP11.getNumberOfflineKonsultationen(dialogId);
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * Diese Funktion liefert die Anzahl der am Ordinations-Client gespeicherten Offline
	 * Nachsignaturen.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @return Anzahl der offline gespeicherten Nachsignaturen
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED}
	 */
	@Override
	public long getNumberOfflineNachsignaturen(String dialogId) throws AccessException,
		KseException, ServiceException, DialogException{
		
		long ret = 0;
		try {
			ret = kseVP11.getNumberOfflineKonsultationen(dialogId);
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * Diese Funktion löscht einen Offline Datensatz von der GINA.
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>Es gibt am Ordinations-Client keinen gleichzeitigen schreibenden Zugriff auf die
	 * Offline-Datensätze des Vertragspartners; siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 * OFFLINETRANSFER_ALREADY_IN_PROCESS}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Kurz
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id des aufgebauten Dialogs
	 * @param offlineId
	 *            Id des offline gespeicherten Datensatzes
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID
	 *             INVALID_ANFRAGE_ID},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ID_NOT_FOUND
	 *             ID_NOT_FOUND}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 *             OFFLINETRANSFER_ALREADY_IN_PROCESS},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED}
	 */
	@Override
	public void deleteOfflineRecord(String dialogId, String offlineId) throws DialogException,
		ServiceException, KseException, AccessException, InvalidParameterException{
		try {
			kseVP11.deleteOfflineRecord(dialogId, offlineId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
	}
	
	/**
	 * Diese Funktion übermittelt eine am Ordinations-Client gespeicherte Offline (nacherfasste)
	 * Konsultation an das e-card Serversystem.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>Es gibt am Ordinations-Client keinen gleichzeitigen schreibenden Zugriff auf die
	 * Offline-Datensätze des Vertragspartners; siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 * OFFLINETRANSFER_ALREADY_IN_PROCESS}
	 * <li>KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param offlineId
	 *            Id des offline gespeicherten Datensatzes
	 * @param fachgebietsCode
	 *            Fachgebietscode der zu sendenden Offline Konsultationen. Wenn null, wird der
	 *            ursprünglich angegebene Fachgebietscode übermittelt, andernfalls muss auch der
	 *            Behandlungsfallcode mit übergeben werden.
	 * @param behandlungsfallCode
	 *            Behandlunsgfallcode der zu sendenden Offline Konsultation. Wenn null, wird der
	 *            ursprünglich angegebene Behandlungsfallcode übermittelt, andernfalls muss auch das
	 *            Fachgebiet mit übergeben werden.
	 * @param svtCode
	 *            Code des Sozialversicherungsträgers der SV-Person, für die diese Konsultation
	 *            durchgeführt wird. Wenn null, wird der Sozialversicherungsträger automatisch vom
	 *            e-card Serversystem ermittelt. <br>
	 *            Mögliche Werte laut Funktion
	 *            {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}
	 * @param anspruchId
	 *            Id des abgeleiteten Anspruchs, sonst null. Die möglichen Ansprüche einer SV-Person
	 *            wurden durch vorherigen Aufruf dieser Funktion unter Angabe eines nicht
	 *            eindeutigen Anspruchs in der Exception
	 *            {@link at.chipkarte.client.kse.soap.exceptions.KseException AnspruchException}
	 *            zurückgeliefert.
	 * @return Objekt vom Typ ErgebnisKonsultation
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL
	 *             MISSING_KSE_FULL}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE
	 *             INVALID_CERTIFICATE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION
	 *             PARAMETER_MISMATCH_EXCEPTION},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG
	 *             INVALID_FG},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF
	 *             INVALID_BF},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ID_NOT_FOUND
	 *             ID_NOT_FOUND},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#WRONG_RECORD_TYPE_FOR_FUNCTION
	 *             WRONG_RECORD_TYPE_FOR_FUNCTION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 *             OFFLINETRANSFER_ALREADY_IN_PROCESS},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_FOR_SVT_EXCEPTION
	 *             NO_VPANSPRUCH_FOR_SVT_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_OUT_OF_RANGE_EXCEPTION
	 *             DATE_OUT_OF_RANGE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SPECIALISM_EXCEPTION
	 *             INVALID_SPECIALISM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION
	 *             NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_CLAIM_EXCEPTION
	 *             NO_SUCH_CLAIM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_ANSPRUCH_PROVIDED_EXCEPTION
	 *             NO_ANSPRUCH_PROVIDED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CLAIM_EXCEPTION
	 *             INVALID_CLAIM_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_EXCEPTION
	 *             NO_VPANSPRUCH_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION
	 *             NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#REFERERALL_REQUIRED_EXCEPTION
	 *             REFERERALL_REQUIRED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SVT_PROVIDED_EXCEPTION
	 *             NO_SVT_PROVIDED_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TREATMENT_DATE_IN_FUTURE_EXCEPTION
	 *             TREATMENT_DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION
	 *             INVALID_SIGNATURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION
	 *             INVALID_CARD_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#AGE_NOT_REACHED
	 *             AGE_NOT_REACHED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_BEHANDLUNGSFALL
	 *             INVALID_BEHANDLUNGSFALL},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VA_MATCHING_KONSULTATION
	 *             NO_VA_MATCHING_KONSULTATION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED
	 *             TIME_NOT_ELAPSED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED
	 *             BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED
	 *             BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN
	 *             INVALID_CARD_LOST_STOLEN}
	 */
	@Override
	public ErgebnisKonsultation sendOfflineKonsultation(String dialogId, String offlineId,
		String fachgebietsCode, String behandlungsfallCode, String svtCode, String anspruchId)
		throws DialogException, ServiceException, KseException, AccessException,
		InvalidParameterException{
		
		ErgebnisKonsultation ret = null;
		try {
			ret =
				kseVP11.sendOfflineKonsultation(dialogId, offlineId, fachgebietsCode,
					behandlungsfallCode, svtCode, anspruchId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	/**
	 * Diese Funktion übermittelt eine am Ordinations-Client gespeicherte Nachsignierungsanfrage an
	 * das e-card Serversystem.
	 * 
	 * <p>
	 * <B>Voraussetzung : </B> <br>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
	 * setDialogAddress} wurde erfolgreich ausgeführt
	 * <li>Online Modus des Dialogs
	 * <li>Es gibt am Ordinations-Client keinen gleichzeitigen schreibenden Zugriff auf die
	 * Offline-Datensätze des Vertragsparnters; siehe auch
	 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 * KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS}
	 * <li>zumindest eingeschränktes KSE-Recht
	 * </p>
	 * 
	 * <p>
	 * <B>Laufzeitgruppe: </B> Mittel
	 * </p>
	 * 
	 * @param dialogId
	 *            Dialog-Id eines aufgebauten Dialogs
	 * @param offlineId
	 *            Id des offline gespeicherten Datensatzes
	 * @return Array der im Zuge des e-card Nachbringens nachsignierten Belege.
	 * @throws ServiceException
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR
	 *             INTERNAL_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR
	 *             CONNECTION_ERROR},
	 *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION
	 *             INCOMPATIBILITY_EXCEPTION}
	 * @throws AccessException
	 *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE
	 *             MISSING_KSE_CORE}
	 * @throws DialogException
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID
	 *             DIALOG_INVALID},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED
	 *             DIALOG_NOT_AUTHENTICATED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET
	 *             ORDINATION_ID_NOTSET},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE
	 *             DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED
	 *             DIALOG_CANCELED},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT
	 *             DIALOG_TIMEOUT},
	 *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID
	 *             INVALID_TRANSACTION_ID}
	 * @throws InvalidParameterException
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ID_NOT_FOUND
	 *             ID_NOT_FOUND},
	 *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#WRONG_RECORD_TYPE_FOR_FUNCTION
	 *             WRONG_RECORD_TYPE_FOR_FUNCTION}
	 * @throws KseException
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS
	 *             OFFLINETRANSFER_ALREADY_IN_PROCESS},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION
	 *             DATE_IN_FUTURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION
	 *             INVALID_SIGNATURE_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION
	 *             INVALID_CARD_EXCEPTION},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED
	 *             OFFLINE_NOT_ALLOWED},
	 *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN
	 *             INVALID_CARD_LOST_STOLEN}
	 */
	@Override
	public KonsultationsBeleg[] sendOfflineNachsignatur(String dialogId, String offlineId)
		throws DialogException, ServiceException, KseException, AccessException,
		InvalidParameterException{
		
		KonsultationsBeleg[] ret = null;
		try {
			ret = kseVP11.sendOfflineNachsignatur(dialogId, offlineId);
		} catch (InvalidParameterException e) {
			throw e;
		} catch (AccessException e) {
			throw e;
		} catch (KseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		} catch (DialogException e) {
			throw e;
		} catch (RemoteException e) {
			handleRemoteException(e);
		}
		return ret;
	}
	
	private void handleRemoteException(RemoteException e){
		RemoteExceptionHandler.handleRemoteException(e);
		KseService.disconnect();
	}
	
}
