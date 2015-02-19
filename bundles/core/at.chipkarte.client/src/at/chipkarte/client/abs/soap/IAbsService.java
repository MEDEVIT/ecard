/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

import javax.activation.DataHandler;

import at.chipkarte.client.abs.soap.exceptions.AbsException;
import at.chipkarte.client.abs.soap.exceptions.InvalidParameterBewilligungsanfrageException;
import at.chipkarte.client.abs.soap.exceptions.InvalidParameterGetAnfrageStatusException;
import at.chipkarte.client.abs.soap.exceptions.InvalidParameterRueckantwortException;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.SvtProperty;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;

/**
 * Dieses Service stellt die Funktionalitäten für das
 * Arzneimittelbewilligungsservice (ABS) zur Verfügung.
 */
public interface IAbsService {

    /**
     * <p>
     * Diese Funktion sendet eine Bewilligungsanfrage an den Ordinationsclient.
     * </p>
     * <p>
     * Die Kennzeichnung einer Bewilligungsanfrage (Bewilligungsanfrage im
     * Rahmen einer Rezeptausstellung bzw. Bewilligungsanfrage im Rahmen einer
     * Arztbrieferstellung) erfolgt anhand des Antragstyps (siehe
     * {@link at.chipkarte.client.abs.soap.constants.Antragstyp Antragstyp}).
     * Bewilligungsanfragen, die keine Rezeptausstellung zur Folge haben, können
     * im Gegensatz zu den Bewilligungsanfragen zur Ausstellung eines Rezeptes,
     * nur von Benutzern mit dem Recht für Bewilligungsanfragen im Rahmen der
     * Arztbrieferstellung durchgeführt werden. Für etwaige Rückfragen kann
     * optional eine Verordnerinformation angegeben werden, die nicht weiter
     * geprüft wird.
     * <br>
     * Einer Bewilligungsanfrage kann ein ZIP-Archiv als SOAP-Attachment
     * angehängt werden, welches maximal 10 Dateien beinhalten darf. Die
     * entpackten Dateien dürfen insgesamt die Größe von 3 MB nicht
     * überschreiten. <br>
     * Die einzelnen Dateinamen müssen zwischen 5 und 128 Zeichen (inkl.
     * Dateinamenerweiterung) haben. <br>
     * Erlaubte Dateinamenerweiterungen im Archiv: gif, jpg, jpeg, pdf, png,
     * tiff, tif, xml.
     * <br>
     * Die Bewilligungsanfrage wird zu einem späteren Zeitpunkt bearbeitet. Die
     * Benachrichtigung, dass die Rückantwort zur Abholung bereitsteht, erfolgt
     * über den Messaging-Mechanismus. Hat die Meldung die Kategorie
     * <code>RUECKANTWORT</code>, können die bereitgestellten Statusantworten
     * über die Funktion
     * {@link #getStatusBewilligungsAnfragen getStatusBewilligungsAnfragen}
     * angefordert werden.
     * </p>
     * <p>
     * <B>Voraussetzung: </B> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
     * setDialogAddress} wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Falls es sich um eine Bewilligungsfrage für Rezeptausstellung
     * handelt, ist das Recht für Bewilligungsanfragen im Rahmen der
     * Rezeptausstellung (siehe
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_REZEPTUR ABS_REZEPTUR})
     * notwendig. Bewilligungsanfragen im Rahmen einer Arztbrieferstellung sind
     * nur von Vertragspartnern in Krankenanstalten mit dem Recht für
     * Bewilligungsanfragen im Rahmen der Arztbrieferstellung (siehe
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_ARZTBRIEF ABS_ARZTBRIEF})
     * zulässig.</li>
     * <li>
     * Es ist sicherzustellen, dass ein XML-Parser verwendet wird, der die
     * Reihenfolge der Verordnungen innerhalb der Bewilligungsanfrage
     * nicht verändert. 
     * </li>
     * </ul>
     * </p>
     * <p>
     * <B>Laufzeitgruppe: </B> Mittel<br>
     * <B>Achtung:</B> Wird die Funktion unter Angabe eines Attachments aufgerufen, kann die in der 
     * Laufzeitgruppe "Mittel" definierte Zeitspanne unter Umständen nicht mehr eingehalten werden 
     * (in Abhängigkeit von der Attachmentgröße sowie der vom Provider zur Verfügung gestellten Upload-Bandbreite). 
     * Es wird daher bei der Verwendung von Attachments eine Vergrößerung der Zeitspanne um 50% empfohlen 
     * (d.h. >= 90s). Diese Empfehlung gilt nur bei Verwendung eines einzelnen Dialoges.
     * </p>
     * 
     * @param dialogId
     *          Identifiziert einen aufgebauten Dialog
     * @param anfrage
     *          {@link BewilligungsAnfrage BewilligungsAnfrage}
     * @param cardReaderId
     *          Identifizierer des Kartenlesers
     * @param attachment Bewilligungsanfrage als SOAP-Attachment (ZIP-Archiv)
     * @return Objekt vom Typ AnfrageAntwort - Ergebnis der Anfrage
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_REZEPTUR MISSING_ABS_REZEPTUR},
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_ARZTBRIEF MISSING_ABS_ARZTBRIEF}
     * @throws CardException
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD}
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD}
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD}
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws InvalidParameterBewilligungsanfrageException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ATTACHMENT_DUPLICATE ATTACHMENT_DUPLICATE},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ATTACHMENT_INVALID ATTACHMENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ATTACHMENT_MAX_FILES_EXCEEDED ATTACHMENT_MAX_FILES_EXCEEDED},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ATTACHMENT_NAME_NOT_VALID ATTACHMENT_NAME_NOT_VALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ATTACHMENT_TYP_NOT_VALID ATTACHMENT_TYP_NOT_VALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#BEGRUENDUNG_INVALID BEGRUENDUNG_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#BEGRUENDUNG_NOT_SET BEGRUENDUNG_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#DIAGNOSE_INVALID DIAGNOSE_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#DIAGNOSE_NOT_SET DIAGNOSE_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#DOSIERUNG_INVALID DOSIERUNG_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#EKVK_NUMMER_INVALID EKVK_NUMMER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#GESCHLECHT_PATIENT_INVALID GESCHLECHT_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#KOSTENTRAEGER_INVALID KOSTENTRAEGER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#LANGZEITVERORDNUNG_INVALID LANGZEITVERORDNUNG_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#MAGISTRALE_ZUBEREITUNG_INVALID MAGISTRALE_ZUBEREITUNG_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#MEDIKAMENT_INVALID MEDIKAMENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#MEDIKAMENT_NAME_NOT_SET MEDIKAMENT_NAME_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#MEDIKAMENT_ZUBEREITUNG_NOT_SET MEDIKAMENT_ZUBEREITUNG_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#NACHNAME_PATIENT_INVALID NACHNAME_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#NACHNAME_PATIENT_NOT_SET NACHNAME_PATIENT_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#PACKUNGSANZAHL_INVALID PACKUNGSANZAHL_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#PHARMANUMMER_INVALID PHARMANUMMER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_EKVKNR_NOT_SET SVNR_EKVKNR_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_INVALID SVNR_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VERORDNUNG_MAX_EXCEEDED VERORDNUNG_MAX_EXCEEDED},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VERORDNUNG_NOT_SET VERORDNUNG_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VORNAME_PATIENT_INVALID VORNAME_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VORNAME_PATIENT_NOT_SET VORNAME_PATIENT_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ATTACHMENT_FILESIZE_NOT_ALLOWED ATTACHMENT_FILESIZE_NOT_ALLOWED},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ANTRAGSTYP_INVALID ANTRAGSTYP_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ANTRAGSTYP_NOT_SET ANTRAGSTYP_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VERORDNERINFORMATION_INVALID VERORDNERINFORMATION_INVALID}
     * @throws AbsException
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#CARD_LOCKED CARD_LOCKED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_ANSPRUCH NO_KVA_ANSPRUCH},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVT_PROVIDED NO_KVT_PROVIDED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_PRESCRIPTION_RIGHT NO_PRESCRIPTION_RIGHT},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#PATIENTENDATEN_NOT_CONSISTENT PATIENTENDATEN_NOT_CONSISTENT}
     */
    AnfrageAntwort sendenAnfrage(String dialogId, BewilligungsAnfrage anfrage, String cardReaderId, DataHandler attachment) throws ServiceException,
      CardException, DialogException, InvalidParameterBewilligungsanfrageException, AbsException, AccessException;
    
    /**
     * <p>
     * Diese Funktion liefert den Status sämtlicher Bewilligungsanfragen des aktuellen
     * Zeitfensters.
     * </p>
     * <p>
     * <B>Voraussetzung: </B> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
     * setDialogAddress} wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Das Recht
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_CORE ABS_CORE}.
     * </li>
     * </ul>
     * </p>
     * <p>
     * <B>Laufzeitgruppe: </B> Mittel
     * </p>
     * 
     * @param dialogId
     *          Identifiziert einen aufgebauten Dialog
     * @param filterkriterien
     *           Filterkriterien zur Einschränkung des Ergebnisses.<br>
     *           Dieser Parameter ist optional.
     *           Wird er nicht angegeben, liefert die Funktion den Status sämtlicher Bewilligungsanfragen
     *           des aktuellen Zeitfensters.
     *           Wird er angegeben, so wird das Ergebnis entsprechend eingeschränkt.
     * @return Objekt vom Typ StatusBewilligungsAnfrage[]
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_CORE MISSING_ABS_CORE}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws InvalidParameterGetAnfrageStatusException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterGetAnfrageStatusExceptionConstants#ANFRAGESTATUS_INVALID ANFRAGESTATUS_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterGetAnfrageStatusExceptionConstants#DATE_INVALID DATE_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterGetAnfrageStatusExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG}
     */
    StatusBewilligungsAnfrage[] getStatusBewilligungsAnfragen(String dialogId, FilterKriterien filterkriterien)
      throws ServiceException, DialogException, AccessException, InvalidParameterGetAnfrageStatusException;
    
    
    /**
     * <p>
     * Diese Funktion liefert die Rückantwort zu einer Bewilligungsanfrage.
     * </p>
     * <p>
     * <B>Voraussetzung: </B> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
     * setDialogAddress} wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Das Recht
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_CORE ABS_CORE}.
     * </li>
     * <li>
     * Es ist sicherzustellen, dass ein XML-Parser verwendet wird, der die
     * Reihenfolge der Verordnungen innerhalb der Bewilligungsanfrage
     * nicht verändert. 
     * </li>
     * </ul>
     * </p>
     * <p><B>Laufzeitgruppe: </B> Mittel</p>
     * @param dialogId
     *            Identifiziert einen aufgebauten Dialog
     * @param anfrageId
     *            Format: maximal 38-stellig<br>
     *            Es gibt zwei Möglichkeiten, die nötige <code>anfrageId</code>
     *            zu ermitteln:
     *            <ul>
     *            <li>aus dem Rückgabewert der Funktion
     *            {@link #sendenAnfrage(String, BewilligungsAnfrage, String) sendenAnfrage}
     *            </li>
     *            <li>aus dem Attribut
     *            {@link at.chipkarte.client.base.soap.Message#getData() Message.getData()},
     *            die von der Funktion
     *            {@link at.chipkarte.client.base.soap.IBaseService#getMessages(String, boolean) IBaseService.getMessages}
     *            zurückgeliefert wird.</li>
     *            </ul>
     * @return Objekt vom Typ Rueckantwort
     * @throws AccessException
     *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_CORE MISSING_ABS_CORE}
     * @throws ServiceException
     *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     * @throws DialogException
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws InvalidParameterRueckantwortException
     *             {@link at.chipkarte.client.abs.soap.constants.InvalidParameterRueckantwortExceptionConstants#ANFRAGE_ID_NOT_NUMERIC ANFRAGE_ID_NOT_NUMERIC},
     *             {@link at.chipkarte.client.abs.soap.constants.InvalidParameterRueckantwortExceptionConstants#ANFRAGE_ID_NOT_SET ANFRAGE_ID_NOT_SET}
     * @throws AbsException
     *             {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID}
     */
    Rueckantwort getRueckantwort(String dialogId, String anfrageId) throws AccessException, ServiceException, DialogException,
      InvalidParameterRueckantwortException, AbsException;
    
    /**
     * <p>
     * Mit dieser Funktion werden alle zurzeit gültigen
     * Krankenversicherungsträger für ABS geliefert.
     * </p>
     * <p><B>Voraussetzung: </B>keine</p>
     * 
     * <p><B>Laufzeitgruppe: </B> Kurz</p>
     * @return Objekt vom Typ SvtProperty[] - Array der Krankenversicherungsträger, siehe auch
     *         {@link at.chipkarte.client.base.soap.SvtProperty SvtProperty}
     * 
     * @throws ServiceException
     *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     */
    SvtProperty[] getSVTs() throws ServiceException;

    
    /**
     * <p>
     * Diese Funktion liefert den Systemstatus des ABS zurück.
     * </p>
     * 
     * <p>
     * <B>Voraussetzung: </B> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
     * wurde erfolgreich ausgeführt.</li>
     * <li>Das Recht
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_CORE ABS_CORE}.
     * </li>
     * </ul>
     * </p>
     * 
     * <p>
     * <B>Laufzeitgruppe: </B> Kurz
     * </p>
     * 
     * @param dialogId
     *         Identifiziert einen aufgebauten Dialog
     * @return Objekt vom Typ Property[] - Array mit Key und Wert eines Attributpaares, siehe auch
     *         {@link Property Property}<br>
     *         Möglicher Key siehe
     *         {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
     *         Mögliche Werte siehe
     *         {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_CORE MISSING_ABS_CORE}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
     */
    Property[] checkStatus(String dialogId) throws AccessException, ServiceException, DialogException;

    /**
     * <p>
     * Diese Funktion fragt ab, ob für einen bestimmten Patienten eine
     * Langzeitbewilligung oder Arztbriefbewilligung im Bewilligungsvorrat
     * besteht.
     * <br>
     * Wird mindestens eine Langzeitbewilligung oder Arztbriefbewilligung
     * gefunden, so werden die Daten der gefundenen Bewilligungen sowie die Daten,
     * die zur Durchführung einer Folgeverordnung zu diesen Bewilligungen benötigt
     * werden, zurückgeliefert.
     * </p>
     * <p>
     * <b>Voraussetzung: </b> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
     * wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Eine gültige e-card steckt in dem Kartenleser, der dem angegebenen
     * Dialog zugeordnet ist, oder es liegt eine gültige Konsultation für diesen
     * Patienten im System vor.</li>
     * <li>Das Recht für Bewilligungsanfragen im Rahmen der Rezeptausstellung
     * (siehe
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_REZEPTUR ABS_REZEPTUR}).
     * </li>
     * </ul>
     * </p>
     * <p>
     * <B>Laufzeitgruppe: </B> Mittel
     * </p>
     * 
     * @param dialogId
     *          Identifiziert einen aufgebauten Dialog
     * @param sVNRPatient
     *          Sozialversicherungsnummer des Patienten. Format: 10-stellig <br>
     *          Dieser Parameter ist optional. Wird die SVNR nicht angegeben, muss eine e-card gesteckt sein. 
     *          Wird eine SVNR angegeben und ist gleichzeitig eine e-card gesteckt, wird die e-card ignoriert.
     *          D.h. soll explizit die e-card verwendet werden, darf dieser Parameter nicht angegeben werden.
     *          
     * @param cardReaderId
     *          Identifizierer des Kartenlesers
     * 
     * @return Objekt vom Typ LangzeitbewilligungsAbfrageErgebnis[]  Array der Abfrageergebnisse der Langzeitbewilligungsabfrage
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_REZEPTUR MISSING_ABS_REZEPTUR}
     * @throws AbsException
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#CARD_LOCKED CARD_LOCKED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_ANSPRUCH NO_KVA_ANSPRUCH},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_LZB_FOUND NO_LZB_FOUND},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_PHYSICIAN_PATIENT_RELATIONSHIP NO_PHYSICIAN_PATIENT_RELATIONSHIP},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_PRESCRIPTION_RIGHT NO_PRESCRIPTION_RIGHT},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#UNAVAILABLE_BE UNAVAILABLE_BE}
     * @throws CardException
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws InvalidParameterBewilligungsanfrageException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_INVALID SVNR_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_NOT_SET SVNR_PATIENT_NOT_SET}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     */
    LangzeitbewilligungsAbfrageErgebnis[] abfragenLangzeitbewilligung(String dialogId, String sVNRPatient, String cardReaderId)
        throws AccessException, DialogException, ServiceException, AbsException, CardException,
        InvalidParameterBewilligungsanfrageException;

    /**
     * <p>
     * Diese Funktion stellt (auf Basis einer bestehenden Langzeitbewilligung oder Arztbriefbewilligung)
     * eine Folgeverordnung aus und bestätigt die Ausstellung. 
     * </p>
     * <p>
     * <b>Voraussetzung: </b> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
     * wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Eine gültige e-card steckt in dem Kartenleser, der dem angegebenen
     * Dialog zugeordnet ist, oder es liegt eine gültige Konsultation für diesen
     * Patienten im System vor.</li>
     * <li>Funktion
     * {@link at.chipkarte.client.abs.soap.IAbsService#abfragenLangzeitbewilligung(String, String, String) abfragenLangzeitbewilligung}
     * wurde erfolgreich ausgeführt.</li>
     * <li>Das Recht für Bewilligungsanfragen im Rahmen der Rezeptausstellung
     * (siehe
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_REZEPTUR ABS_REZEPTUR}).
     * </li>
     * </ul>
     * </p>
     * <p>
     * <B>Laufzeitgruppe: </B> Mittel
     * </p>
     * 
     * @param dialogId
     *          Identifiziert einen aufgebauten Dialog
     * @param ausstellungsParameter
     *          Die Ausstellungsparameter der Folgeverordnung
     * @param cardReaderId
     *          Identifizierer des Kartenlesers
     * 
     * @return Objekt vom Typ FolgeverordnungsAusstellungsErgebnis - Das Ausstellungsergebnis der Folgeverordnung
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_REZEPTUR MISSING_ABS_REZEPTUR}
     * @throws AbsException
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#CARD_LOCKED CARD_LOCKED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#LZB_CONFIRMATIONAMOUNT_EXCEEDED LZB_CONFIRMATIONAMOUNT_EXCEEDED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#LZB_RETENTION_PERIOD LZB_RETENTION_PERIOD},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_ANSPRUCH NO_KVA_ANSPRUCH},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVT_PROVIDED NO_KVT_PROVIDED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_LZB_FOUND NO_LZB_FOUND},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_PRESCRIPTION_RIGHT NO_PRESCRIPTION_RIGHT},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#REPEATED_LZB_CONFIRMATION REPEATED_LZB_CONFIRMATION},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#UNAVAILABLE_BE UNAVAILABLE_BE},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_PHYSICIAN_PATIENT_RELATIONSHIP NO_PHYSICIAN_PATIENT_RELATIONSHIP}
     * @throws CardException
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws InvalidParameterBewilligungsanfrageException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#KOSTENTRAEGER_INVALID KOSTENTRAEGER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#MEDIKAMENT_INVALID MEDIKAMENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#PACKUNGSANZAHL_INVALID PACKUNGSANZAHL_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#PHARMANR_MEDIKAMENT_NOT_SET PHARMANR_MEDIKAMENT_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#PHARMANUMMER_INVALID PHARMANUMMER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_INVALID SVNR_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_NOT_SET SVNR_PATIENT_NOT_SET}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     */
    FolgeverordnungsAusstellungsErgebnis sendenFolgeverordnung(String dialogId,
      FolgeverordnungsAusstellungsParameter ausstellungsParameter, String cardReaderId) throws AccessException, DialogException,
      ServiceException, AbsException, CardException, InvalidParameterBewilligungsanfrageException;

    /**
     * <p>
     * Diese Funktion prüft bzw. ermittelt anhand der eingegebenen Daten die Personendaten, den zulässigen KV-Träger und den Antragstyp.
     * </p>
     * <p>
     * Bei positiver Durchführung wird eine {@link BewilligungsAnfrage} mit bereits ausgefüllten Personendaten retourniert. 
     * Diese kann als Basis für das Senden einer Bewilligungsanfrage dienen (Angabe der Verordnungen und Verordnerinformationen
     * fehlen noch zur gültigen Bewilligungsanfrage).
     * Aus diesem Grund wird bereits in dieser Funktion auf eine valide Versorgung des Antragscodes geprüft
     * (Berechtigungen zur anschließenden Anfrageerfassung).
     * </p>
     * <p>
     * <B>Voraussetzung: </B> <br>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
     * setDialogAddress} wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Falls es sich um eine Abfrage zur anschließenden Erstellung einer Bewilligungsfrage für Rezeptausstellung
     * handelt, ist das Recht für Bewilligungsanfragen im Rahmen der
     * Rezeptausstellung (siehe
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_REZEPTUR ABS_REZEPTUR})
     * notwendig. Bewilligungsanfragen im Rahmen einer Arztbrieferstellung sind
     * nur von Vertragspartnern in Krankenanstalten mit dem Recht für
     * Bewilligungsanfragen im Rahmen der Arztbrieferstellung (siehe
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_ARZTBRIEF ABS_ARZTBRIEF})
     * zulässig. Zur Ermittlung der Rechte siehe {@link at.chipkarte.client.base.soap.IBaseService#getBerechtigungen(String)</li>
     * </ul>
     * </p>
     * <p>
     * <B>Laufzeitgruppe: </B> Mittel
     * </p>
     * 
     * @param dialogId
     *          Identifiziert einen aufgebauten Dialog
     * @param svNummer
     *          Die Sozialversicherungsnummer des Patienten, sofern der Patient in Österreich versichert ist. <br/>
     *          Format: 10-stellig, numerisch <br/>
     *          Die Sozialversicherungsnummer muss den Regeln für Sozialversicherungsnummern entsprechen (Prüfziffer). <br/>
     *          Die Angabe der Sozialversicherungsnummer ist optional. Wird sie nicht angegeben, muss jedoch entweder die
     *          EKVK-Nummer angegeben werden oder es muss die e-card, im (dem Dialog zugeordneten) Kartenleser
     *          gesteckt sein. Im letzteren Fall wird die Sozialversicherungsnummer automatisch ausgelesen. <br/>
     * @param svtCode
     *          Der eindeutige Code des leistungszuständigen Krankenversicherungsträgers. <br/> 
     *          Siehe {@link IAbsService#getSVTs()} bzw. auch {@link at.chipkarte.client.base.soap.SvtProperty#getCode()
     *          SvtProperty#getCode()}. <br/>
     *          Format: 2-stellig, alphanumerisch
     *          Die Angabe des KVT-Codes ist optional. In diesem Fall wird der KVT vom System automatisch ermittelt. <br/>
     * @param ekvkNummer
     *          Die EKVK-Nummer des Patienten aus der europäischen Krankenversicherungskarte (EKVK), sofern der Patient im
     *          EU-Ausland versichert ist. <br/>
     *          Format: maximal 20-stellig <br/>
     *          Die Angabe der EKVK-Nummer ist optional. Wird sie nicht angegeben, gilt die Bestimmung für die Eingabe der
     *          Sozialversicherungsnummer.
     * @param geschlecht
     *          Geschlecht des Patienten. <br/>
     *          Wertebereich: siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht} <br/>
     *          Die Angabe des Geschlechts ist optional. Wird ignoriert bei Angabe einer SV-Nummer.
     * @param nachname
     *          Nachname des Patienten. <br/>
     *          Format: maximal 70-stellig <br/>
     *          Muss eingegeben werden wenn eine EKVK-Nummer angegeben wurde. Wird ignoriert bei Angabe einer SV-Nummer.
     * @param vorname
     *          Vorname des Patienten. <br/>
     *          Format: maximal 70-stellig <br/>
     *          Muss eingegeben werden wenn eine EKVK-Nummer angegeben wurde. Wird ignoriert bei Angabe einer SV-Nummer.
     * @param antragstyp
     *          Die Kennzeichnung der Bewilligungsanfrage (Bewilligungsanfrage im Rahmen einer Rezeptausstellung beziehungsweise einer Arztbrieferstellung), 
     *          für die vorab der Patient geprüft werden soll. <br/>
     *          Wertebereich: siehe {@link at.chipkarte.client.abs.soap.constants.Antragstyp Antragstyp}).
     * @param cardReaderId
     *          Identifizierer des Kartenlesers
     * @return Objekt vom Typ BewilligungsAnfrage - Bewilligungsanfrage mit bereits ausgefüllten Personendaten, die als Basis für das Senden verwendet werden kann.
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_REZEPTUR MISSING_ABS_REZEPTUR},
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_ARZTBRIEF MISSING_ABS_ARZTBRIEF}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     * @throws AbsException
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#CARD_LOCKED CARD_LOCKED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_ANSPRUCH NO_KVA_ANSPRUCH},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_KVT_PROVIDED NO_KVT_PROVIDED},
     *           {@link at.chipkarte.client.abs.soap.constants.AbsExceptionConstants#NO_PRESCRIPTION_RIGHT NO_PRESCRIPTION_RIGHT}
     * @throws CardException
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
     * @throws InvalidParameterBewilligungsanfrageException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_INVALID SVNR_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#EKVK_NUMMER_INVALID EKVK_NUMMER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#GESCHLECHT_PATIENT_INVALID GESCHLECHT_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#KOSTENTRAEGER_INVALID KOSTENTRAEGER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#NACHNAME_PATIENT_INVALID NACHNAME_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#NACHNAME_PATIENT_NOT_SET NACHNAME_PATIENT_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_EKVKNR_NOT_SET SVNR_EKVKNR_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VORNAME_PATIENT_INVALID VORNAME_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VORNAME_PATIENT_NOT_SET VORNAME_PATIENT_NOT_SET},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ANTRAGSTYP_INVALID ANTRAGSTYP_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#ANTRAGSTYP_NOT_SET ANTRAGSTYP_NOT_SET}
     */
    BewilligungsAnfrage ermittelnPatientenDaten(String dialogId, String svNummer, String svtCode, String ekvkNummer,
        String geschlecht, String nachname, String vorname, String antragstyp, String cardReaderId) throws AccessException,
        DialogException, ServiceException, AbsException, CardException, InvalidParameterBewilligungsanfrageException;

    /**
     * <p>
     * Diese Funktion liefert den Status bereits beantworteter Bewilligungsanfragen innerhalb eines definierten Zeitfensters zurück.
     * </p>
     * <p>
     * <B>Voraussetzung: </B> <br/>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
     * setDialogAddress} wurde erfolgreich ausgeführt.</li>
     * <li>Online-Modus des Dialogs.</li>
     * <li>Das Recht
     * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#ABS_CORE ABS_CORE}.
     * </li>
     * </ul>
     * </p>
     * <p>
     * <B>Laufzeitgruppe: </B> Mittel
     * </p>
     * 
     * @param dialogId
     *          Identifiziert einen aufgebauten Dialog
     * @param svNummer
     *          Sozialversicherungsnummer des Patienten. <br/> 
     *          Format: 10-stellig <br/>
     *          Es muss entweder eine e-card gesteckt oder mindestens eines der Felder SV-Nummer, Nachname oder Vorname angegeben werden.
     *          Im letzteren Fall wird eine aktuell gesteckte e-card ignoriert.
     * @param nachname
     *          Nachname des Patienten. <br/>
     *          Format: mindestens 2-stellig, maximal 70-stellig <br/>
     *          Es muss entweder eine e-card gesteckt oder mindestens eines der Felder SV-Nummer, Nachname oder Vorname angegeben werden.
     *          Im letzteren Fall wird eine aktuell gesteckte e-card ignoriert.
     * @param vorname
     *          Vorname des Patienten. <br/>
     *          Format: mindestens 2-stellig, maximal 70-stellig <br/>
     *          Es muss entweder eine e-card gesteckt oder mindestens eines der Felder SV-Nummer, Nachname oder Vorname angegeben werden.
     *          Im letzteren Fall wird eine aktuell gesteckte e-card ignoriert.
     * @param cardReaderId
     *          Identifizierer des Kartenlesers
     * @return Objekt vom Typ StatusBewilligungsAnfrage[]
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_ABS_CORE MISSING_ABS_CORE}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     * @throws CardException
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
     *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
     * @throws InvalidParameterBewilligungsanfrageException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#SVNR_PATIENT_INVALID SVNR_PATIENT_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#NACHNAME_PATIENT_INVALID KOSTENTRAEGER_INVALID},
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterBewilligungsanfrageExceptionConstants#VORNAME_PATIENT_INVALID MEDIKAMENT_INVALID}
     * @throws InvalidParameterGetAnfrageStatusException
     *           {@link at.chipkarte.client.abs.soap.constants.InvalidParameterGetAnfrageStatusExceptionConstants#NO_DATA_FOUND NO_DATA_FOUND}
     */
    StatusBewilligungsAnfrage[] getStatusPatientBewilligungsAnfragen(String dialogId, String svNummer, String nachname,
        String vorname, String cardReaderId) throws AccessException, DialogException, ServiceException, CardException,
        InvalidParameterBewilligungsanfrageException, InvalidParameterGetAnfrageStatusException;
}
