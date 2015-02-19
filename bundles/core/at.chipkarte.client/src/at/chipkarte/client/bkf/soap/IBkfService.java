/*
 * (C) SVC 2012
 */
package at.chipkarte.client.bkf.soap;

import javax.jws.WebParam;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.bkf.soap.exceptions.BkfEncryptionException;
import at.chipkarte.client.bkf.soap.exceptions.BkfException;
import at.chipkarte.client.bkf.soap.exceptions.BkfInvalidParameterException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des Brustkrebs-Früherkennungs-Service (BKF) für Befunderfassung und -übermittlung zur Verfügung.
 * </p>
 */
public interface IBkfService {
  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des BKF zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @param dialogId
   *           Dialog-ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *           Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *           Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Property[] checkStatus(String dialogId) throws DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Mit dieser Funktion werden die Empfangsbestätigungen übertragener Dokumentationen, die die
   * Suchkriterien erfüllen, vom e-card-Server abgeholt.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param dokumentationstyp
   *            Dokumentationstyp (siehe {@link at.chipkarte.client.bkf.soap.constants.DokumentationTypConstant})
   * @param svnr
   *            SV-Nummer der Patientin.
   * @param kvt
   *            Code des KVT.
   * @param ohneAnspruch
   *            Es sollen nur Quittungen angezeigt werden, die für Patienten ohne Anspruch erzeugt wurden.
   *            (siehe {@link at.chipkarte.client.bkf.soap.constants.JaTypConstant})
   * @param vonDatum
   *            Es sollen nur Quittungen angezeigt werden, die nach dem angegebenen Datum erzeugt wurden.
   *            Format: TT.MM.JJJJ
   * @param bisDatum
   *            Es sollen nur Quittungen angezeigt werden, die vor dem angegebenen Datum erzeugt wurden.
   *            Format: TT.MM.JJJJ
   * @return
   *            Liste der ermittelten Quittungen.
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#DOKUMENTATIONSTYP_INVALID DOKUMENTATIONSTYP_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#BIS_DATUM_WRONG_FORMAT BIS_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#BIS_DATUM_INVALID BIS_DATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VON_DATUM_WRONG_FORMAT VON_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#OHNE_ANSPRUCH_AND_KVT_NOT_ALLOWED OHNE_ANSPRUCH_AND_KVT_NOT_ALLOWED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KVT_INVALID KVT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#OHNE_ANSPRUCH_INVALID OHNE_ANSPRUCH_INVALID}
   */
  BKFQuittung [] searchBkfQuittungen (String dialogId, String dokumentationstyp, String svnr, String kvt, String ohneAnspruch, String vonDatum, String bisDatum) throws DialogException, AccessException, ServiceException, BkfException, BkfInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird die angegebene Patientin (mittels SV-Nummer beziehungsweise gesteckter e-card) geprüft 
   * und die Patientendaten, sowie die verfügbaren Konsultationen 
   * in Abhängigkeit des angegebenen Dokumentationstyp vom e-card-Server geholt.
   * </p>
   *  <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param svnr
   *            SV-Nummer der Patientin.
   * @param dokumentationstyp
   *            Dokumentationstyp Dokumentationstyp (siehe {@link at.chipkarte.client.bkf.soap.constants.DokumentationTypConstant})<br>
   *            Es sind nur die Dokumentationstypen "SCR", "SUS", "KUM", "KUS" und "KML" zulässig.
   *            
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.SearchBkfKonsultationDataErgebnis})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_MAMMO MISSING_BKF_MAMMO}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_EINLADUNG_NOT_FOUND KONSULTATION_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#LEISTUNGSDATUM_EINLADUNG_NOT_FOUND LEISTUNGSDATUM_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_EINLADUNG_NOT_FOUND SV_NUMMER_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_KONS_EINLADUNG_NOT_AVAILABLE VPNR_KONS_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_SCR_EINLADUNG_NOT_AVAILABLE VPNR_SCR_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#NO_KONSULTATION_FOUND NO_KONSULTATION_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#TOKEN_ALREADY_BONDED_TO_OTHER_DOKUTYP TOKEN_ALREADY_BONDED_TO_OTHER_DOKUTYP}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#DOKUMENTATIONSTYP_REQUIRED DOKUMENTATIONSTYP_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#DOKUMENTATIONSTYP_INVALID DOKUMENTATIONSTYP_INVALID}
   */
  SearchBkfKonsultationDataErgebnis searchBkfKonsultationData(String dialogId, String cardReaderId,
      String svnr, String dokumentationstyp) throws DialogException, AccessException, ServiceException,
      CardException, BkfException, BkfInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion erfolgt eine Prüfung ob für die betreffende Patientin eine Einladung ermittelt
   * werden kann und somit eine Screening-Dokumentation oder Screening Ultraschalldokumentation erfasst werden kann.
   * </p>
   *  <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param svnr
   *            SV-Nummer der Patientin.
   * @param konsultationsID
   *            ID einer Konsultation<br>
   *            Es muss entweder die <i>KonsultationsID</i> oder das <i>Leistungsdatum</i> angegeben werden.
   * @param leistungsdatum
   *            Leistungsdatum
   *            <br>Es muss entweder die <i>KonsultationsID</i> oder das <i>Leistungsdatum</i> angegeben werden.
   * @param dokumentationstyp    
   *            Dokumentationstyp Dokumentationstyp (siehe {@link at.chipkarte.client.bkf.soap.constants.DokumentationTypConstant})<br>
   *            Es sind nur die Dokumentationstypen "SCR" und "SUS" zulässig.        
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.CheckBkfTokenErgebnis})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_MAMMO MISSING_BKF_MAMMO}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_EINLADUNG_NOT_FOUND KONSULTATION_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#LEISTUNGSDATUM_EINLADUNG_NOT_FOUND LEISTUNGSDATUM_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_EINLADUNG_NOT_FOUND SV_NUMMER_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_KONS_EINLADUNG_NOT_AVAILABLE VPNR_KONS_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_SCR_EINLADUNG_NOT_AVAILABLE VPNR_SCR_EINLADUNG_NOT_AVAILABLE}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_REQUIRED KONSULTATION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_WRONG_FORMAT LEISTUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID LEISTUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID2 LEISTUNGSDATUM_INVALID2}
   */
  CheckBkfTokenErgebnis checkBkfToken(String dialogId, String cardReaderId, String svnr, Long konsultationsID,
      String leistungsdatum, String dokumentationstyp) throws DialogException, AccessException, ServiceException, CardException, BkfException, BkfInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion werden die Daten eines mittels ID spezifizierten, zertifizierten Arztes ermittelt.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            DialogID eines gültigen Dialogs.
   * @param arztID
   *            Gültige ArztID
   * @return
   *             (siehe {@link at.chipkarte.client.bkf.soap.BKFArzt})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_MAMMO MISSING_BKF_MAMMO}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#NO_PARTICIPANT_FOUND NO_PARTICIPANT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ARZTID_WRONG_FORMAT ARZTID_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ARZTID_REQUIRED ARZTID_REQUIRED}
   */
  BKFArzt searchBkfArzt(String dialogId, String arztID) throws DialogException, AccessException, ServiceException, BkfException, BkfInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird die Screening-Dokumentation validiert, verschlüsselt und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param screening
   *            Die Daten der Screening-Dokumentation ({@link at.chipkarte.client.bkf.soap.ScreeningDoku ScreeningDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_MAMMO MISSING_BKF_MAMMO}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_EINLADUNG_NOT_FOUND KONSULTATION_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#LEISTUNGSDATUM_EINLADUNG_NOT_FOUND LEISTUNGSDATUM_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_EINLADUNG_NOT_FOUND SV_NUMMER_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_KONS_EINLADUNG_NOT_AVAILABLE VPNR_KONS_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_SCR_EINLADUNG_NOT_AVAILABLE VPNR_SCR_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#EINLADUNG_STATUS_CHANGED EINLADUNG_STATUS_CHANGED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#NO_KONSULTATION_FOUND NO_KONSULTATION_FOUND},
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCREENING_REQUIRED SCREENING_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_MAMMO_ERSTBEFUNDER_REQUIRED SCR_MAMMO_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_MAMMO_ZWEITBEFUNDER_REQUIRED SCR_MAMMO_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ENDERGEBNIS_REQUIRED SCR_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_WRONG_FORMAT LEISTUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID LEISTUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID2 LEISTUNGSDATUM_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_REQUIRED KONSULTATION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED SCR_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT SCR_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ERSTBEFUNDER_INVALID SCR_IDENTIFIKATION_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ERSTBEFUNDER_INVALID2 SCR_IDENTIFIKATION_ERSTBEFUNDER_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND SCR_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_REQUIRED SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_WRONG_FORMAT SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_INVALID SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DICHTE_ERSTBEFUNDER_REQUIRED SCR_DICHTE_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DICHTE_ERSTBEFUNDER_INVALID SCR_DICHTE_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ERSTBEFUNDER_REQUIRED SCR_ERGEBNIS_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ERSTBEFUNDER_INVALID SCR_ERGEBNIS_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ULTRASCHALL_REQUIRED SCR_DATUM_BEFUNDUNG_ULTRASCHALL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ULTRASCHALL_WRONG_FORMAT SCR_DATUM_BEFUNDUNG_ULTRASCHALL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ULTRASCHALL_INVALID SCR_DATUM_BEFUNDUNG_ULTRASCHALL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GRUND_REQUIRED SCR_GRUND_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GRUND_INVALID SCR_GRUND_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GRUND_INVALID2 SCR_GRUND_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GRUND_INVALID3 SCR_GRUND_INVALID3},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GRUND_INVALID4 SCR_GRUND_INVALID4},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GRUND_INVALID5 SCR_GRUND_INVALID5},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ULTRASCHALL_REQUIRED SCR_ERGEBNIS_ULTRASCHALL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ULTRASCHALL_INVALID SCR_ERGEBNIS_ULTRASCHALL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ZWEITBEFUNDER_REQUIRED SCR_IDENTIFIKATION_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT SCR_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND SCR_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_REQUIRED SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_WRONG_FORMAT SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_INVALID SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DICHTE_ZWEITBEFUNDER_REQUIRED SCR_DICHTE_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DICHTE_ZWEITBEFUNDER_INVALID SCR_DICHTE_ZWEITBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ZWEITBEFUNDER_REQUIRED SCR_ERGEBNIS_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ZWEITBEFUNDER_INVALID SCR_ERGEBNIS_ZWEITBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_MED_ZUSATZAUFNAHME_REQUIRED SCR_MED_ZUSATZAUFNAHME_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_MED_ZUSATZAUFNAHME_INVALID SCR_MED_ZUSATZAUFNAHME_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_INAKZEPTABEL_REQUIRED SCR_INAKZEPTABEL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_INAKZEPTABEL_INVALID SCR_INAKZEPTABEL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_TECH_ZUSATZAUFNAHME_REQUIRED SCR_TECH_ZUSATZAUFNAHME_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_TECH_ZUSATZAUFNAHME_INVALID SCR_TECH_ZUSATZAUFNAHME_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DOPPELBEFUNDUNG_REQUIRED SCR_DOPPELBEFUNDUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DOPPELBEFUNDUNG_INVALID SCR_DOPPELBEFUNDUNG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ENDERGEBNIS_REQUIRED SCR_ERGEBNIS_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_ERGEBNIS_ENDERGEBNIS_INVALID SCR_ERGEBNIS_ENDERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DICHTE_ENDERGEBNIS_REQUIRED SCR_DICHTE_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DICHTE_ENDERGEBNIS_INVALID SCR_DICHTE_ENDERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GROESSE_LINKS_REQUIRED SCR_GROESSE_LINKS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GROESSE_LINKS_INVALID SCR_GROESSE_LINKS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GROESSE_LINKS_INVALID2 SCR_GROESSE_LINKS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GROESSE_RECHTS_INVALID SCR_GROESSE_RECHTS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_GROESSE_RECHTS_INVALID2 SCR_GROESSE_RECHTS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_VORGEHEN_REQUIRED SCR_VORGEHEN_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_VORGEHEN_INVALID SCR_VORGEHEN_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_VORGEHEN_INVALID2 SCR_VORGEHEN_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_REQUIRED SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_WRONG_FORMAT SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID2 SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_INFO_PATIENT_REQUIRED SCR_INFO_PATIENT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_INFO_PATIENT_WRONG_FORMAT SCR_INFO_PATIENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_INFO_PATIENT_INVALID SCR_INFO_PATIENT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_PATIENT_ID_WRONG_FORMAT SCR_PATIENT_ID_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_WIEDERBESTELLUNG_REQUIRED SCR_WIEDERBESTELLUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCR_WIEDERBESTELLUNG_INVALID SCR_WIEDERBESTELLUNG_INVALID}
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createScreeningDoku(String dialogId, String cardReaderId, ScreeningDoku screening)
      throws DialogException, AccessException, ServiceException, CardException, BkfException,
      BkfInvalidParameterException, BkfEncryptionException;


  /**
   * <p>
   * Mit dieser Funktion wird die Kurative Mammographiedokumentation validiert, verschlüsselt und 
   * zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param kum
   *            Die Daten der kurative Mammographiedokumentation ({@link at.chipkarte.client.bkf.soap.KurativeMammographieDoku KurativeMammographieDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_MAMMO MISSING_BKF_MAMMO}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#NO_KONSULTATION_FOUND NO_KONSULTATION_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KUM_KONSULTATION_INVALID KUM_KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KUM_LEISTUNGSDATUM_INVALID KUM_LEISTUNGSDATUM_INVALID},
   * @throws BkfInvalidParameterException <br>
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KURATIV_MAMMO_REQUIRED KURATIV_MAMMO_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_MAMMO_ERSTBEFUNDER_REQUIRED KUM_MAMMO_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ENDERGEBNIS_REQUIRED KUM_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_WRONG_FORMAT LEISTUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID LEISTUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED KUM_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT KUM_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND KUM_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ERSTBEFUNDER_INVALID KUM_IDENTIFIKATION_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_REQUIRED KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_WRONG_FORMAT KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_INVALID KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DICHTE_ERSTBEFUNDER_REQUIRED KUM_DICHTE_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DICHTE_ERSTBEFUNDER_INVALID KUM_DICHTE_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ERSTBEFUNDER_REQUIRED KUM_ERGEBNIS_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ERSTBEFUNDER_INVALID KUM_ERGEBNIS_ERSTBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ULTRASCHALL_REQUIRED KUM_DATUM_BEFUNDUNG_ULTRASCHALL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ULTRASCHALL_WRONG_FORMAT KUM_DATUM_BEFUNDUNG_ULTRASCHALL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ULTRASCHALL_INVALID KUM_DATUM_BEFUNDUNG_ULTRASCHALL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GRUND_REQUIRED KUM_GRUND_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GRUND_INVALID KUM_GRUND_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GRUND_INVALID2 KUM_GRUND_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GRUND_INVALID3 KUM_GRUND_INVALID3},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GRUND_INVALID4 KUM_GRUND_INVALID4},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GRUND_INVALID5 KUM_GRUND_INVALID5},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ULTRASCHALL_REQUIRED KUM_ERGEBNIS_ULTRASCHALL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ULTRASCHALL_INVALID KUM_ERGEBNIS_ULTRASCHALL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ZWEITBEFUNDER_REQUIRED KUM_IDENTIFIKATION_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT KUM_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND KUM_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_REQUIRED KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_WRONG_FORMAT KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_INVALID KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DICHTE_ZWEITBEFUNDER_REQUIRED KUM_DICHTE_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DICHTE_ZWEITBEFUNDER_INVALID KUM_DICHTE_ZWEITBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ZWEITBEFUNDER_REQUIRED KUM_ERGEBNIS_ZWEITBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ZWEITBEFUNDER_INVALID KUM_ERGEBNIS_ZWEITBEFUNDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_MED_ZUSATZAUFNAHME_REQUIRED KUM_MED_ZUSATZAUFNAHME_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_MED_ZUSATZAUFNAHME_INVALID KUM_MED_ZUSATZAUFNAHME_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_INAKZEPTABEL_REQUIRED KUM_INAKZEPTABEL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_INAKZEPTABEL_INVALID KUM_INAKZEPTABEL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_TECH_ZUSATZAUFNAHME_REQUIRED KUM_TECH_ZUSATZAUFNAHME_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_TECH_ZUSATZAUFNAHME_INVALID KUM_TECH_ZUSATZAUFNAHME_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ENDERGEBNIS_REQUIRED KUM_ERGEBNIS_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_ERGEBNIS_ENDERGEBNIS_INVALID KUM_ERGEBNIS_ENDERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DICHTE_ENDERGEBNIS_REQUIRED KUM_DICHTE_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DICHTE_ENDERGEBNIS_INVALID KUM_DICHTE_ENDERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GROESSE_LINKS_REQUIRED KUM_GROESSE_LINKS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GROESSE_LINKS_INVALID KUM_GROESSE_LINKS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GROESSE_LINKS_INVALID2 KUM_GROESSE_LINKS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GROESSE_RECHTS_INVALID KUM_GROESSE_RECHTS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_GROESSE_RECHTS_INVALID2 KUM_GROESSE_RECHTS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_REQUIRED KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_WRONG_FORMAT KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID2 KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_INFO_PATIENT_REQUIRED KUM_INFO_PATIENT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_INFO_PATIENT_WRONG_FORMAT KUM_INFO_PATIENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_INFO_PATIENT_INVALID KUM_INFO_PATIENT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_PATIENT_ID_WRONG_FORMAT KUM_PATIENT_ID_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_WIEDERBESTELLUNG_REQUIRED KUM_WIEDERBESTELLUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUM_WIEDERBESTELLUNG_INVALID KUM_WIEDERBESTELLUNG_INVALID},
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createKurativeMammographieDoku(String dialogId, String cardReaderId, KurativeMammographieDoku kum)
      throws DialogException, AccessException, ServiceException, CardException, BkfException,
      BkfInvalidParameterException, BkfEncryptionException;

  /**
   * <p>
   * Mit dieser Funktion wird die Assessmentdokumentation Bildgebende Diagnostik validiert, verschlüsselt 
   * und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_ASSESSMENT BKF_ASSESSMENT}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param abd
   *            Die Daten der Assessmentdokumentation Bildgebende Diagnostik 
   *            ({@link at.chipkarte.client.bkf.soap.AssessmentBildgebendeDiagnostikDoku AssessmentBildgebendeDiagnostikDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ASSESSMENT_BILDGEBEND_REQUIRED ASSESSMENT_BILDGEBEND_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_LEISTUNGSANFANG_REQUIRED ABD_LEISTUNGSANFANG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_LEISTUNGSANFANG_WRONG_FORMAT ABD_LEISTUNGSANFANG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_LEISTUNGSANFANG_INVALID ABD_LEISTUNGSANFANG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ERGEBNIS_KLINISCH_INVALID ABD_ERGEBNIS_KLINISCH_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_MAMMO_DURCHGEFUEHRT_REQUIRED ABD_MAMMO_DURCHGEFUEHRT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_MAMMO_DURCHGEFUEHRT_INVALID ABD_MAMMO_DURCHGEFUEHRT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ZUSATZAUFNAHME_REQUIRED ABD_ZUSATZAUFNAHME_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ZUSATZAUFNAHME_INVALID ABD_ZUSATZAUFNAHME_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ERGBNIS_MAMMO_REQUIRED ABD_ERGBNIS_MAMMO_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ERGEBNIS_MAMMO_INVALID ABD_ERGEBNIS_MAMMO_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ERGEBNIS_MAMMO_INVALID ABD_ERGEBNIS_MAMMO_INVALID},2
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ERGEBNIS_US_INVALID ABD_ERGEBNIS_US_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ERGEBNIS_MRT_INVALID ABD_ERGEBNIS_MRT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_GESAMTERGEBNIS_REQUIRED ABD_GESAMTERGEBNIS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_GESAMTERGEBNIS_INVALID ABD_GESAMTERGEBNIS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED ABD_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID ABD_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_INFO_PATIENT_REQUIRED ABD_INFO_PATIENT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_INFO_PATIENT_WRONG_FORMAT ABD_INFO_PATIENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ABD_INFO_PATIENT_INVALID ABD_INFO_PATIENT_INVALID}
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createAssessmentBildgebendeDiagnostikDoku(String dialogId, String cardReaderId, AssessmentBildgebendeDiagnostikDoku abd)
      throws DialogException, AccessException, ServiceException, CardException, BkfException,
      BkfInvalidParameterException, BkfEncryptionException;
  
  /**
   * <p>
   * Mit dieser Funktion wird die Assessmentdokumentation Invasive Diagnostik validiert, verschlüsselt 
   * und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_ASSESSMENT BKF_ASSESSMENT}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param aid
   *            Die Daten der Assessmentdokumentation Invasive Diagnostik ({@link at.chipkarte.client.bkf.soap.AssessmentInvasiveDiagnostikDoku AssessmentInvasiveDiagnostikDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws BkfInvalidParameterException           
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#ASSESSMENT_INVASIV_REQUIRED ASSESSMENT_INVASIV_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_LEISTUNGSANFANG_REQUIRED AID_LEISTUNGSANFANG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_LEISTUNGSANFANG_WRONG_FORMAT AID_LEISTUNGSANFANG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_LEISTUNGSANFANG_INVALID AID_LEISTUNGSANFANG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_SEITE_REQUIRED AID_SEITE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_SEITE_INVALID AID_SEITE_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ERGEBNIS_KLINISCH_INVALID AID_ERGEBNIS_KLINISCH_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_BIOPSIE_METHODE_REQUIRED AID_BIOPSIE_METHODE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_BIOPSIE_METHODE_INVALID AID_BIOPSIE_METHODE_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_BIOPSIE_MODALITAET_REQUIRED AID_BIOPSIE_MODALITAET_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_BIOPSIE_MODALITAET_INVALID AID_BIOPSIE_MODALITAET_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ERGEBNIS_HISTOLOGIE_INVALID AID_ERGEBNIS_HISTOLOGIE_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED AID_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID AID_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_INFO_PATIENT_REQUIRED AID_INFO_PATIENT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_INFO_PATIENT_WRONG_FORMAT AID_INFO_PATIENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_INFO_PATIENT_INVALID AID_INFO_PATIENT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ERGEBNIS_HISTOLOGIE_REQUIRED AID_ERGEBNIS_HISTOLOGIE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ERGEBNIS_HISTOLOGIE_INVALID2 AID_ERGEBNIS_HISTOLOGIE_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#AID_ERGEBNIS_HISTOLOGIE_INVALID3 AID_ERGEBNIS_HISTOLOGIE_INVALID3}
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createAssessmentInvasiveDiagnostikDoku (String dialogId,
      String cardReaderId,
      AssessmentInvasiveDiagnostikDoku aid) throws DialogException, AccessException, ServiceException, CardException,
      BkfException, BkfInvalidParameterException, BkfEncryptionException;
  
  /**
   * <p>
   * Mit dieser Funktion wird die Dokumentation für die Kurative Mammographie Leermeldung validiert, 
   * verschlüsselt und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param kml
   *            Die Daten der Dokumentation zur Kurative Mammographie Leermeldung ({@link at.chipkarte.client.bkf.soap.KurativeMammoLeermeldung KurativeMammoLeermeldung}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KUM_KONSULTATION_INVALID KUM_KONSULTATION_INVALID}
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KUM_LEISTUNGSDATUM_INVALID KUM_LEISTUNGSDATUM_INVALID}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_NOT_ALLOWED KONSULTATION_NOT_ALLOWED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_WRONG_FORMAT LEISTUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID LEISTUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_REQUIRED LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KURATIVE_MAMMOGRAPHIE_LEERMELDUNG_REQUIRED KURATIVE_MAMMOGRAPHIE_LEERMELDUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KML_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED KML_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KML_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT KML_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KML_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND KML_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KML_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT KML_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KML_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND  KML_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND },
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KML_IDENTIFIKATION_ERSTBEFUNDER_AND_IDENTIFIKATION_ZWEITBEFUNDER_IDENT KML_IDENTIFIKATION_ERSTBEFUNDER_AND_IDENTIFIKATION_ZWEITBEFUNDER_IDENT}
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createKurativeMammoLeermeldungDoku (String dialogId,
      String cardReaderId,
      KurativeMammoLeermeldung kml) throws DialogException, AccessException, ServiceException, CardException,
      BkfException, BkfInvalidParameterException, BkfEncryptionException;

  /**
   * <p>
   * Mit dieser Funktion wird die Screening Ultraschalldokumentation validiert, verschlüsselt und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param sus
   *            Die Daten der Screening Ultraschalldokumentation ({@link at.chipkarte.client.bkf.soap.ScreeningUltraschallDoku ScreeningUltraschallDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_EINLADUNG_NOT_FOUND KONSULTATION_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#LEISTUNGSDATUM_EINLADUNG_NOT_FOUND LEISTUNGSDATUM_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_EINLADUNG_NOT_FOUND SV_NUMMER_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_KONS_EINLADUNG_NOT_AVAILABLE VPNR_KONS_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_SCR_EINLADUNG_NOT_AVAILABLE VPNR_SCR_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#TOKEN_ALREADY_BONDED_TO_OTHER_DOKUTYP TOKEN_ALREADY_BONDED_TO_OTHER_DOKUTYP},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#EINLADUNG_STATUS_CHANGED EINLADUNG_STATUS_CHANGED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#NO_KONSULTATION_FOUND NO_KONSULTATION_FOUND}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_WRONG_FORMAT LEISTUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID LEISTUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID2 LEISTUNGSDATUM_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_REQUIRED KONSULTATION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SCREENING_ULTRASCHALL_REQUIRED SCREENING_ULTRASCHALL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_DATUM_BEFUNDUNG_REQUIRED SUS_DATUM_BEFUNDUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_DATUM_BEFUNDUNG_WRONG_FORMAT SUS_DATUM_BEFUNDUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_DATUM_BEFUNDUNG_INVALID SUS_DATUM_BEFUNDUNG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_ERGEBNIS_ULTRASCHALL_REQUIRED  SUS_ERGEBNIS_ULTRASCHALL_REQUIRED },
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_ERGEBNIS_ULTRASCHALL_INVALID  SUS_ERGEBNIS_ULTRASCHALL_INVALID },
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_GROESSE_LINKS_REQUIRED SUS_GROESSE_LINKS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_GROESSE_LINKS_INVALID SUS_GROESSE_LINKS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_GROESSE_LINKS_INVALID2 SUS_GROESSE_LINKS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_GROESSE_RECHTS_INVALID SUS_GROESSE_RECHTS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_GROESSE_RECHTS_INVALID2 SUS_GROESSE_RECHTS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_VORGEHEN_REQUIRED SUS_VORGEHEN_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_VORGEHEN_INVALID SUS_VORGEHEN_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_VORGEHEN_INVALID2 SUS_VORGEHEN_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_INFO_DATUM_REQUIRED SUS_INFO_DATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_INFO_DATUM_WRONG_FORMAT SUS_INFO_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_INFO_DATUM_WRONG_INVALID SUS_INFO_DATUM_WRONG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_PATIENT_ID_WRONG_FORMAT SUS_PATIENT_ID_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_IDENTIFIKATION_BEFUNDER_REQUIRED SUS_IDENTIFIKATION_BEFUNDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_IDENTIFIKATION_BEFUNDER_WRONG_FORMAT SUS_IDENTIFIKATION_BEFUNDER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SUS_IDENTIFIKATION_BEFUNDER_INVALID SUS_IDENTIFIKATION_BEFUNDER_INVALID}
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createScreeningUltraschallDoku(String dialogId,
      String cardReaderId,
      ScreeningUltraschallDoku sus) throws DialogException, AccessException, ServiceException, CardException,
      BkfException, BkfInvalidParameterException, BkfEncryptionException;
  
  /**
   * <p>
   * Mit dieser Funktion wird die Kurative Ultraschalldokumentation validiert, verschlüsselt und 
   * zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_MAMMO BKF_MAMMO}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param kus
   *            Die Daten der kurative Ultraschalldokumentation ({@link at.chipkarte.client.bkf.soap.KurativeUltraschallDoku KurativeUltraschallDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KUM_KONSULTATION_INVALID KUM_KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KUM_LEISTUNGSDATUM_INVALID KUM_LEISTUNGSDATUM_INVALID}
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_WRONG_FORMAT LEISTUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#LEISTUNGSDATUM_INVALID LEISTUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KURATIVER_ULTRASCHALL_REQUIRED KURATIVER_ULTRASCHALL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_DATUM_BEFUNDUNG_REQUIRED KUS_DATUM_BEFUNDUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_DATUM_BEFUNDUNG_WRONG_FORMAT KUS_DATUM_BEFUNDUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_DATUM_BEFUNDUNG_INVALID KUS_DATUM_BEFUNDUNG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_ERGEBNIS_ULTRASCHALL_REQUIRED  KUS_ERGEBNIS_ULTRASCHALL_REQUIRED },
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_ERGEBNIS_ULTRASCHALL_INVALID  KUS_ERGEBNIS_ULTRASCHALL_INVALID },
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_GROESSE_LINKS_REQUIRED KUS_GROESSE_LINKS_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_GROESSE_LINKS_INVALID KUS_GROESSE_LINKS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_GROESSE_LINKS_INVALID2 KUS_GROESSE_LINKS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_GROESSE_RECHTS_INVALID KUS_GROESSE_RECHTS_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_GROESSE_RECHTS_INVALID2 KUS_GROESSE_RECHTS_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_INFO_DATUM_REQUIRED KUS_INFO_DATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_INFO_DATUM_WRONG_FORMAT KUS_INFO_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_INFO_DATUM_WRONG_INVALID KUS_INFO_DATUM_WRONG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#KUS_PATIENT_ID_WRONG_FORMAT KUS_PATIENT_ID_WRONG_FORMAT}
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createKurativeUltraschallDoku (String dialogId,
      String cardReaderId,
      KurativeUltraschallDoku kus) throws DialogException, AccessException, ServiceException, CardException,
      BkfException, BkfInvalidParameterException, BkfEncryptionException;
   
  /**
   * <p>
   * Mit dieser Funktion wird die Therapiedokumentation Pathologie validiert, verschlüsselt und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_ASSESSMENT BKF_ASSESSMENT}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param pat
   *            Die Daten der Therapiedokumentation Pathologie ({@link at.chipkarte.client.bkf.soap.TherapiePathologieDoku TherapiePathologieDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_EINLADUNG_NOT_FOUND KONSULTATION_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#LEISTUNGSDATUM_EINLADUNG_NOT_FOUND LEISTUNGSDATUM_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_EINLADUNG_NOT_FOUND SV_NUMMER_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_KONS_EINLADUNG_NOT_AVAILABLE VPNR_KONS_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_SCR_EINLADUNG_NOT_AVAILABLE VPNR_SCR_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#EINLADUNG_STATUS_CHANGED EINLADUNG_STATUS_CHANGED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   * @throws BkfInvalidParameterException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#THERAPIE_PATHOLOGIE_REQUIRED THERAPIE_PATHOLOGIE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD  SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_OPERATIONSDATUM_REQUIRED PAT_OPERATIONSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_OPERATIONSDATUM_WRONG_FORMAT PAT_OPERATIONSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_OPERATIONSDATUM_INVALID PAT_OPERATIONSDATUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_ZEITSTEMPEL_BEFUNDUNG_REQUIRED PAT_ZEITSTEMPEL_BEFUNDUNG_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_ZEITSTEMPEL_BEFUNDUNG_WRONG_FORMAT PAT_ZEITSTEMPEL_BEFUNDUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_ZEITSTEMPEL_BEFUNDUNG_INVALID PAT_ZEITSTEMPEL_BEFUNDUNG_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_SEITE_REQUIRED PAT_SEITE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_SEITE_INVALID PAT_SEITE_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_GEFRIERSCHNITT_REQUIRED PAT_GEFRIERSCHNITT_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_GEFRIERSCHNITT_INVALID PAT_GEFRIERSCHNITT_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_DIAMETER_REQUIRED PAT_DIAMETER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_DIAMETER_REQUIRED PAT_DIAMETER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_HISTOLOGISCHE_DIAGNOSE_REQUIRED PAT_HISTOLOGISCHE_DIAGNOSE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_HISTOLOGISCHE_DIAGNOSE_INVALID PAT_HISTOLOGISCHE_DIAGNOSE_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_REZIDIV_REQUIRED PAT_REZIDIV_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_REZIDIV_INVALID PAT_REZIDIV_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_REZIDIV_INVALID2 PAT_REZIDIV_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_MULTIFOKAL_REQUIRED PAT_MULTIFOKAL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_MULTIFOKAL_INVALID PAT_MULTIFOKAL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_MULTIFOKAL_INVALID2 PAT_MULTIFOKAL_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_LCIS_TYP_REQUIRED PAT_LCIS_TYP_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_LCIS_TYP_INVALID PAT_LCIS_TYP_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_LCIS_TYP_INVALID2 PAT_LCIS_TYP_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_MICROINVASION_REQUIRED PAT_MICROINVASION_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_MICROINVASION_INVALID PAT_MICROINVASION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_MICROINVASION_INVALID2 PAT_MICROINVASION_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_DCIS_TYP_REQUIRED PAT_DCIS_TYP_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_DCIS_TYP_INVALID PAT_DCIS_TYP_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_DCIS_TYP_INVALID2 PAT_DCIS_TYP_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_OESTROGEN_REQUIRED PAT_OESTROGEN_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_OESTROGEN_INVALID PAT_OESTROGEN_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_OESTROGEN_INVALID2 PAT_OESTROGEN_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PROGESTERON_REQUIRED PAT_PROGESTERON_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PROGESTERON_INVALID PAT_PROGESTERON_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PROGESTERON_INVALID2 PAT_PROGESTERON_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PT_STADIUM_REQUIRED PAT_PT_STADIUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PT_STADIUM_INVALID PAT_PT_STADIUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PT_STADIUM_INVALID2 PAT_PT_STADIUM_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_LYMPHGEFAESSEINBRUCH_REQUIRED PAT_LYMPHGEFAESSEINBRUCH_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_LYMPHGEFAESSEINBRUCH_INVALID PAT_LYMPHGEFAESSEINBRUCH_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_LYMPHGEFAESSEINBRUCH_INVALID2 PAT_LYMPHGEFAESSEINBRUCH_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_BLUTGEFAESSEINBRUCH_REQUIRED PAT_BLUTGEFAESSEINBRUCH_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_BLUTGEFAESSEINBRUCH_INVALID PAT_BLUTGEFAESSEINBRUCH_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_BLUTGEFAESSEINBRUCH_INVALID2 PAT_BLUTGEFAESSEINBRUCH_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_RESEKTIONSRAENDER_REQUIRED PAT_RESEKTIONSRAENDER_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_RESEKTIONSRAENDER_INVALID PAT_RESEKTIONSRAENDER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_RESEKTIONSRAENDER_INVALID2 PAT_RESEKTIONSRAENDER_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INVASIV_TYP_REQUIRED PAT_INVASIV_TYP_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INVASIV_TYP_INVALID PAT_INVASIV_TYP_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INVASIV_TYP_INVALID2 PAT_INVASIV_TYP_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INVASIV_PURE_SPECIAL_REQUIRED PAT_INVASIV_PURE_SPECIAL_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INVASIV_PURE_SPECIAL_INVALID PAT_INVASIV_PURE_SPECIAL_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INVASIV_PURE_SPECIAL_INVALID2 PAT_INVASIV_PURE_SPECIAL_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INTRADUKTALE_KOMPONENTE_REQUIRED PAT_INTRADUKTALE_KOMPONENTE_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INTRADUKTALE_KOMPONENTE_INVALID PAT_INTRADUKTALE_KOMPONENTE_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_INTRADUKTALE_KOMPONENTE_INVALID2 PAT_INTRADUKTALE_KOMPONENTE_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_TUMORGRAD_REQUIRED PAT_TUMORGRAD_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_TUMORGRAD_INVALID PAT_TUMORGRAD_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_TUMORGRAD_INVALID2 PAT_TUMORGRAD_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_HER2_REQUIRED PAT_HER2_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_HER2_INVALID PAT_HER2_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_HER2_INVALID2 PAT_HER2_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PROLIEFERATIONSINDEX_REQUIRED PAT_PROLIEFERATIONSINDEX_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PROLIEFERATIONSINDEX_INVALID PAT_PROLIEFERATIONSINDEX_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PROLIEFERATIONSINDEX_INVALID2 PAT_PROLIEFERATIONSINDEX_INVALID2},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PN_STADIUM_REQUIRED PAT_PN_STADIUM_REQUIRED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PN_STADIUM_INVALID PAT_PN_STADIUM_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#PAT_PN_STADIUM_INVALID2 PAT_PN_STADIUM_INVALID2},     
   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createTherapiePathologieDoku(String dialogId,
      String cardReaderId,
      TherapiePathologieDoku pat) throws DialogException, AccessException, ServiceException, CardException,
      BkfException, BkfInvalidParameterException, BkfEncryptionException;
  
  /**
   * <p>
   * Mit dieser Funktion wird die Therapiedokumentation Tumor validiert, verschlüsselt und zum e-card-Server übertragen.
   * Im Erfolgsfall wird eine Quittung  (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung}) retourniert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf BKF
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_CORE BKF_CORE}).
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#BKF_ASSESSMENT BKF_ASSESSMENT}).
   * </li>
   * <li>
   *    Es ist eine SV-Nummer angegeben oder eine e-card gesteckt.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines gültigen Dialogs.
   * @param cardReaderId
   *            ID eines gültigen Kartenlesers.
   * @param tum
   *            Die Daten der Therapiedokumentation Tumordokumentation ({@link at.chipkarte.client.bkf.soap.TherapieTumorDoku TherapieTumorDoku}).
   * @return
   *            (siehe {@link at.chipkarte.client.bkf.soap.BKFQuittung BKFQuittung})
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_CORE MISSING_BKF_CORE},
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_BKF_ASSESSMENT MISSING_BKF_ASSESSMENT}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws BkfException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_EINLADUNG_NOT_FOUND KONSULTATION_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#LEISTUNGSDATUM_EINLADUNG_NOT_FOUND LEISTUNGSDATUM_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#SV_NUMMER_EINLADUNG_NOT_FOUND SV_NUMMER_EINLADUNG_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_KONS_EINLADUNG_NOT_AVAILABLE VPNR_KONS_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#VPNR_SCR_EINLADUNG_NOT_AVAILABLE VPNR_SCR_EINLADUNG_NOT_AVAILABLE},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KEYS_NOT_FOUND KEYS_NOT_FOUND},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#EINLADUNG_STATUS_CHANGED EINLADUNG_STATUS_CHANGED},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   * @throws BkfInvalidParameterException
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#THERAPIE_TUMOR_REQUIRED THERAPIE_TUMOR_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_REQUIRED VERSION_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_OPERATIONSDATUM_REQUIRED TUM_OPERATIONSDATUM_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_OPERATIONSDATUM_WRONG_FORMAT TUM_OPERATIONSDATUM_WRONG_FORMAT},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_ZEITSTEMPELOPERATIONSDATUM_BEFUNDUNG_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED TUM_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID TUM_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_SEITE_REQUIRED TUM_SEITE_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_SEITE_INVALID TUM_SEITE_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMORE_TASTBAR_REQUIRED TUM_TUMORE_TASTBAR_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMORE_TASTBAR_INVALID TUM_TUMORE_TASTBAR_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMORSTADIUM_REQUIRED TUM_TUMORSTADIUM_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMORSTADIUM_INVALID TUM_TUMORSTADIUM_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_STADIUM_NACH_UICC_REQUIRED TUM_STADIUM_NACH_UICC_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_STADIUM_NACH_UICC_INVALID TUM_STADIUM_NACH_UICC_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMORDURCHMESSER_REQUIRED TUM_TUMORDURCHMESSER_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMORDURCHMESSER_INVALID TUM_TUMORDURCHMESSER_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_OFFENE_BIOPSIE_REQUIRED TUM_OFFENE_BIOPSIE_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_OFFENE_BIOPSIE_INVALID TUM_OFFENE_BIOPSIE_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_GEFRIERSCHNITT_REQUIRED TUM_GEFRIERSCHNITT_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_GEFRIERSCHNITT_INVALID TUM_GEFRIERSCHNITT_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMOR_ENTFERNT_REQUIRED TUM_TUMOR_ENTFERNT_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_TUMOR_ENTFERNT_INVALID TUM_TUMOR_ENTFERNT_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_ABLATIO_REQUIRED TUM_ABLATIO_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_ABLATIO_INVALID TUM_ABLATIO_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_MULTIFOKAL_REQUIRED TUM_MULTIFOKAL_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_MULTIFOKAL_INVALID TUM_MULTIFOKAL_INVALID},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_NEOADJUVANTE_THERAPIE_REQUIRED TUM_NEOADJUVANTE_THERAPIE_REQUIRED},
   *          {@link at.chipkarte.client.bkf.soap.constants.BkfInvalidParameterExceptionConstants#TUM_NEOADJUVANTE_THERAPIE_INVALID TUM_NEOADJUVANTE_THERAPIE_INVALID}, 

   * @throws BkfEncryptionException
   *           {@link at.chipkarte.client.bkf.soap.constants.BkfEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   */
  BKFQuittung createTherapieTumorDoku (String dialogId,
      String cardReaderId,
      TherapieTumorDoku tum) throws DialogException, AccessException, ServiceException, CardException,
      BkfException, BkfInvalidParameterException, BkfEncryptionException;
}
