/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.vdas.soap.exceptions.InvalidParameterVdasException;
import at.chipkarte.client.vdas.soap.exceptions.VdasException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des Versichertendatenabfrageservice
 * (VDAS) zur Verfügung.
 * </p>
 */
public interface IVdasService {

  /**
   * <p>
   * Mit dieser Funktion wird eine stichtagsaktuelle Versichertendatenabfrage durchgeführt. 
   * Es können in der Vergangenheit liegende Anspruchsdaten gesucht werden.
   * </p>
   * <p>
   * Die Abfrage kann wahlweise mit e-card, o-card oder mit Software-Zertifikat
   * durchgeführt werden.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf VDAS zur Abfrage der tagesaktuellen Versichertendaten 
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#VDAS_CORE VDAS_CORE})
   * und Zugriff auf VDAS zur Abfrage von Versichertendaten für ein bestimmtes Datum (in der Vergangenheit liegend),
   * sowie zur Anzeige aller Ansprüche eines Patienten bei gemischter Mehrfachversicherung 
   * (GKK/BKK-Träger und Sonderversicherungsträger)
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#VDAS_ANSPRUCH_HISTORISCH VDAS_ANSPRUCH_HISTORISCH}).
   * </li>
   * <li>Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im
   * Kartenleser, der dem Dialog zugeordnet ist bzw. der als Attribut angegeben
   * ist, gesteckt sein. Wenn die Abfrage ohne e-card durchgeführt wird, muss
   * die Sozialversicherungsnummer des Patienten angegeben werden.</li>
   * <li>Es wird nur dann auf eine gesteckte Karte zugegriffen, wenn explizit
   * ein Kartenleser angegeben ist (d.h. das Attribut <i>cardReaderId</i> befüllt ist).</li>
   * <li>Wenn die Abfrage mit Software-Zertifikat durchgeführt wird und nicht
   * explizit ein Kartenleser angegeben ist, wird das Software-Zertifikat verwendet.
   * Eine eventuell gesteckte Karte wird ignoriert.</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog-Id eines aufgebauten Dialogs.
   * @param suchKriterien
   *           Die Suchkriterien für eine Abfrage der stichtagsaktuellen Versichertendaten für einen Patienten.
   * @param cardReaderId
   *           Id eines Kartenlesers (optional).
   * @return Ergebnis der stichtagsaktuellen Versichertendatenabfrage.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_VDAS_CORE MISSING_VDAS_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_VDAS_ANSPRUCH_HISTORISCH MISSING_VDAS_ANSPRUCH_HISTORISCH}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH CERTIFICATE_MISMATCH},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION PARAMETER_MISMATCH_EXCEPTION},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID CERTIFICATE_TIMESTAMPS_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE CERTIFICATE_REQUEST_OUT_OF_DATE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR REPEATED_SIGNATUR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_OCARD WRONG_OCARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD}
   * @throws VdasException
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_CARD_CHECK_PATIENT INVALID_CARD_CHECK_PATIENT},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT INVALID_CARD_LOST_STOLEN_CHECK_PATIENT},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#NO_SVPERSON NO_SVPERSON},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#BACKENDSYSTEM_NOT_AVAILABLE BACKENDSYSTEM_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#BACKENDSYSTEM_SYSTEM_ERROR BACKENDSYSTEM_SYSTEM_ERROR}
   * @throws InvalidParameterVdasException
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_SV_NUMBER_ABL INVALID_SV_NUMBER_ABL},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_SVT_NUMBER INVALID_SVT_NUMBER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_ABT_FUNK_CODE INVALID_ABT_FUNK_CODE},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_STICHTAGSDATUM INVALID_STICHTAGSDATUM},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#NO_ANSPRUECHE_PROVIDED_FOR_SELECTED_DATE NO_ANSPRUECHE_PROVIDED_FOR_SELECTED_DATE},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#NO_CERTIFICATE_AND_NO_CARD_READER NO_CERTIFICATE_AND_NO_CARD_READER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#NO_CERTIFICATE_AND_NO_ECARD NO_CERTIFICATE_AND_NO_ECARD},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INPUT_SV_NUMBER_NOT_IDENT_CARD_SV_NUMBER INPUT_SV_NUMBER_NOT_IDENT_CARD_SV_NUMBER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#STICHTAGSDATUM_NOT_VALID_FOR_PAST_REQUEST STICHTAGSDATUM_NOT_VALID_FOR_PAST_REQUEST},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#STICHTAGSDATUM_NOT_SET STICHTAGSDATUM_NOT_SET}
   */
  VersichertendatenAbfrageErgebnis retrieveVersichertendatenPerStichtag(String dialogId,
      VersichertendatenAbfragePerStichtag suchKriterien, String cardReaderId) throws AccessException, ServiceException,
      DialogException, CardException, VdasException, InvalidParameterVdasException;

  /**
   * <p>
   * Mit dieser Funktion werden die tagesaktuellen Versichertendaten eines Patienten
   * abgefragt.
   * </p>
   * <p>
   * Die Abfrage kann wahlweise mit e-card, o-card oder mit Software-Zertifikat
   * durchgeführt werden.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf VDAS (siehe
   * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#VDAS_CORE VDAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im
   * Kartenleser, der dem Dialog zugeordnet ist bzw. der als Attribut angegeben
   * ist, gesteckt sein. Wenn die Abfrage ohne e-card durchgeführt wird, muss
   * die Sozialversicherungsnummer des Patienten angegeben werden.</li>
   * <li>Es wird nur dann auf eine gesteckte Karte zugegriffen, wenn explizit
   * ein Kartenleser angegeben ist (d.h. das Attribut <i>cardReaderId</i> befüllt ist).</li>
   * <li>Wenn die Abfrage mit Software-Zertifikat durchgeführt wird und nicht
   * explizit ein Kartenleser angegeben ist, wird das Software-Zertifikat verwendet.
   * Eine eventuell gesteckte Karte wird ignoriert.</li>
   * </ul>
   * </p>
   * 
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   * 
   * @param dialogId
   *           Dialog-Id eines aufgebauten Dialogs.
   * @param suchKriterien
   *           Die Suchkriterien für eine Abfrage der tagesaktuellen Versichertendaten
   *           für einen Patienten.
   * @param cardReaderId
   *           Id eines Kartenlesers (optional).
   * @return Ergebnis der tagesaktuellen Versichertendatenabfrage.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_VDAS_CORE MISSING_VDAS_CORE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH CERTIFICATE_MISMATCH},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION PARAMETER_MISMATCH_EXCEPTION},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID CERTIFICATE_TIMESTAMPS_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE CERTIFICATE_REQUEST_OUT_OF_DATE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR REPEATED_SIGNATUR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_OCARD WRONG_OCARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD}
   * @throws VdasException
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_CARD_CHECK_PATIENT INVALID_CARD_CHECK_PATIENT},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT INVALID_CARD_LOST_STOLEN_CHECK_PATIENT},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *           {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants#NO_SVPERSON NO_SVPERSON}
   * @throws InvalidParameterVdasException
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_SV_NUMBER_ABL INVALID_SV_NUMBER_ABL},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_SVT_NUMBER INVALID_SVT_NUMBER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INVALID_ABT_FUNK_CODE INVALID_ABT_FUNK_CODE},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#NO_CERTIFICATE_AND_NO_CARD_READER NO_CERTIFICATE_AND_NO_CARD_READER},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#NO_CERTIFICATE_AND_NO_ECARD NO_CERTIFICATE_AND_NO_ECARD},
   *           {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants#INPUT_SV_NUMBER_NOT_IDENT_CARD_SV_NUMBER INPUT_SV_NUMBER_NOT_IDENT_CARD_SV_NUMBER}
   */
  VersichertendatenAbfrageErgebnis getVersichertenDaten(String dialogId, VersichertendatenAbfrage suchKriterien, 
      String cardReaderId) throws AccessException, ServiceException, DialogException, CardException, VdasException, 
      InvalidParameterVdasException;

    /**
     * <p>
     * Diese Funktion liefert den Systemstatus des VDAS zurück.
     * </p>
     * <p>
     * <b>Voraussetzungen: </b>
     * <ul>
     * <li>Funktion
     * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
     * wurde erfolgreich ausgeführt.</li>
     * <li>Zugriff auf VDAS
     * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#VDAS_CORE VDAS_CORE}).
     * </li>
     * </ul>
     * </p>
     * 
     * <p><B>Laufzeitgruppe: </B> Kurz</p>
     * @param dialogId
     *           Dialog-Id eines aufgebauten Dialogs.
     * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
     *            Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
     *            Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
     * @throws AccessException
     *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_VDAS_CORE MISSING_VDAS_CORE}
     * @throws DialogException
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
     *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
     * @throws ServiceException
     *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
     */
    Property[] checkStatus(String dialogId) throws AccessException, DialogException, ServiceException;
}
