/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;

/**
 * <p>
 * Dieses Service stellt die Funktionen der KSE-Applikation einer Vertragspartnersoftware zur Verfügung.
 * </p> 
 */
public interface IKseService {
 
  /**
   * <p>
   * Diese Funktion liefert alle Limitstände des Vertragspartners für die aktuelle Abrechnungsperiode oder für die Nachbringfrist
   * zur Ordinationsadresse, die dem Dialog zugeordnet ist. 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress} wurde
   * erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * @param zeitraum Zeitraum für den die Limits abgefragt werden sollen.<br> 
   *        &nbsp;Gültige Werte:<br>
   *        &nbsp;&nbsp;&nbsp;{@link at.chipkarte.client.kse.soap.constants.LimitZeitraum#AKTUELLE_PRUEFPERIODE LimitZeitraum.AKTUELLE_PRUEFPERIODE} - 
   *        es werden die Limits für die aktuelle Prüfperiode abgefragt<br> 
   *        &nbsp;&nbsp;&nbsp;{@link at.chipkarte.client.kse.soap.constants.LimitZeitraum#NACHBRINGFRIST LimitZeitram.NACHBRINGFRIST} -  
   *        es werden die Limits für die Nachbringfrist abgefragt
   *        
   * @return Objekt vom Typ Limit[]
   * 
   * @throws ServiceException
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *         {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   * @throws InvalidParameterException
   *         {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_LIMIT_ZEITRAUM INVALID_LIMIT_ZEITRAUM}
   */
  Limit[] getLimit(String dialogId, Integer zeitraum) throws AccessException, DialogException, ServiceException,
      InvalidParameterException;
 
  /**
   * <p>
   * Durchführen oder Nacherfassen einer Konsultation im Online-Modus.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Eine gültige e-card oder o-card ist in den, dem Dialog zugeordneten,  
   * Kartenleser gesteckt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Keine Offlinekonsultationen vorhanden, deren Frist zum Senden an das
   * e-card Serversystem überschritten ist, siehe auch
   * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED KseExceptionConstants.OFFLINE_FRIST_EXCEEDED}</li>
   * <li>Wenn die Konsultation mit der <b>e-card </b> durchgeführt wird, muss
   * diese in den Kartenleser, der dem Dialog zugeordnet ist, gesteckt sein.</li>
   * <li>KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param cin
   *            Card-Identification-Number der Karte, die für die Signatur
   *            verwendet wird. Prüfung, ob die Karte ident mit der Karte ist,
   *            von der die Daten (SV-Nummer) gelesen werden. Wenn null, erfolgt
   *            keine Prüfung.
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs.
   * @param svNummer
   *            Sozialversicherungsnummer des Patienten, der die Leistung in
   *            Anspruch nimmt. Wird im Falle der Zeichnung mit der o-card benötigt.
   *            Ist die e-card des Patienten gesteckt, wird das Feld svNummer ignoriert und automatisch 
   *            die Sozialversicherungsnummer der Karte verwendet.
   * @param svtCode
   *            Code des Krankenversicherungsträgers des Patienten, für den diese
   *            Konsultation durchgeführt wird. Wenn null, wird der
   *            Krankenversicherungsträger automatisch vom e-card-Serversystem
   *            ermittelt. <br>
   *            Mögliche Werte laut Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}
   * @param anspruchId
   *            ID des abgeleiteten Anspruchs, sonst null. Die möglichen
   *            Ansprüche eines Patienten wurden durch vorherigen Aufruf dieser
   *            Funktion unter Angabe eines nicht eindeutigen Anspruchs in der
   *            Exception
   *            {@link at.chipkarte.client.kse.soap.exceptions.KseException AnspruchException}
   *            zurückgeliefert.
   * @param fachgebietsCode
   *            Fachgebiet, für das diese Konsultation durchgeführt wird. <br>
   *            Mögliche Werte laut Funktion
   *            {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() getFachgebiete}
   * @param behandlungsfallCode
   *            Behandlungsfall, für den diese Konsultation durchgeführt wird.
   *            <br>
   *            Mögliche Werte laut Funktion
   *            {@link #getBehandlungsfaelle() getBehandlungsfaelle}
   * @param nacherfassungsgrundCode
   *            Grund für die Nacherfassung einer Konsultation. Wenn null,
   *            handelt es sich um eine Konsultation (Behandlungsfall
   *            durchführen), sonst um eine nacherfasste Konsultation. In diesem
   *            Fall muss auch das Behandlungsdatum angeführt werden. <br>
   *            Mögliche Werte siehe
   *            {@link at.chipkarte.client.kse.soap.constants.Nacherfassungsgrund Nacherfassungsgrundcodes}
   * @param behandlungsdatum
   *            Datum, an dem die nachzuerfassende Konsultation tatsächlich
   *            durchgeführt wurde. Pflichtfeld, wenn <Code>
   *            nacherfassungsgrundCode</Code> angegeben, sonst null. <br>
   *            Format: TT.MM.JJJJ
   * @param forceExecution
   *            Die Exception
   *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR CardExceptionConstants.REPEATED_SIGNATUR}
   *            wird nicht geworfen. <br>
   *            Die Durchführung dieser Funktion wird durch diese Exception
   *            nicht mehr abgebrochen.
   * @param cardReaderId Identifizierer des Kartenlesers            
   * 
   * @return Objekt vom Typ ErgebnisKonsultation
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL MISSING_KSE_FULL}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH CERTIFICATE_MISMATCH},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID CERTIFICATE_TIMESTAMPS_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE CERTIFICATE_REQUEST_OUT_OF_DATE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION PARAMETER_MISMATCH_EXCEPTION},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID}        
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF INVALID_BF},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_NACHERFASSUNGSGRUND INVALID_NACHERFASSUNGSGRUND},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_NOT_SET DATE_NOT_SET},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID DATE_INVALID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_IN_FUTURE DATE_IN_FUTURE},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ILLEGAL_VALUE ILLEGAL_VALUE},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_ECARD NO_CERTIFICATE_AND_NO_ECARD},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_CARD_READER NO_CERTIFICATE_AND_NO_CARD_READER},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#MISSING_RIGHT_FOR_BEHANDLUNGSFALL MISSING_RIGHT_FOR_BEHANDLUNGSFALL}            
   * @throws CardException
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR REPEATED_SIGNATUR},
   *              {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED OFFLINE_FRIST_EXCEEDED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_FOR_SVT_EXCEPTION NO_VPANSPRUCH_FOR_SVT_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_OUT_OF_RANGE_EXCEPTION DATE_OUT_OF_RANGE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SPECIALISM_EXCEPTION INVALID_SPECIALISM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_CLAIM_EXCEPTION NO_SUCH_CLAIM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_ANSPRUCH_PROVIDED_EXCEPTION NO_ANSPRUCH_PROVIDED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CLAIM_EXCEPTION INVALID_CLAIM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_EXCEPTION NO_VPANSPRUCH_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED KONSULTATION_CHANGED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_ALREADY_CANCELLED KONSULTATION_ALREADY_CANCELLED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION NO_SUCH_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#REFERERALL_REQUIRED_EXCEPTION REFERERALL_REQUIRED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SVT_PROVIDED_EXCEPTION NO_SVT_PROVIDED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TREATMENT_DATE_IN_FUTURE_EXCEPTION TREATMENT_DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#AGE_NOT_REACHED AGE_NOT_REACHED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_BEHANDLUNGSFALL INVALID_BEHANDLUNGSFALL},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VA_MATCHING_KONSULTATION NO_VA_MATCHING_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED TIME_NOT_ELAPSED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_CHECK_PATIENT INVALID_CARD_CHECK_PATIENT},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT INVALID_CARD_LOST_STOLEN_CHECK_PATIENT},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_EINLADUNG_FOR_BKF_VM NO_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_OPEN_EINLADUNG_FOR_BKF_VM NO_OPEN_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OTHER_VM_EXIST OTHER_VM_EXIST}
   */
  ErgebnisKonsultation doKonsultation(String cin, String dialogId, String svNummer, String svtCode, String anspruchId,
      String fachgebietsCode, String behandlungsfallCode, String nacherfassungsgrundCode, String behandlungsdatum,
      Boolean forceExecution, String cardReaderId) throws AccessException, DialogException, CardException,
      ServiceException, KseException, InvalidParameterException;

  /**
   * <p>
   * Durchführen oder Nacherfassen einer Konsultation im Offline-Modus. Dabei
   * werden die erfassten Daten am Ordinationsclient gespeichert und keine
   * Online-Konsultation durchgeführt. Die Offlinekonsultation kann zu einem
   * späteren Zeitpunkt, wenn der Ordinationsclient wieder online ist, an den
   * e-card-Server übertragen werden
   * {@link at.chipkarte.client.kse.soap.IKseService#sendOfflineKonsultation(String, String, String, String, String, String) sendOfflineKonsultation}.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Eine gültige e-card oder o-card ist in den, dem Dialog zugeordneten
   * Kartenleser gesteckt</li>
   * <li>Offline-Modus des Dialogs</li>
   * <li>KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param cin
   *            Card-Identification-Number der Karte, die für die Signatur
   *            verwendet wird. Prüfung, ob die Karte ident mit der Karte ist,
   *            von der die Daten (SV-Nummer) gelesen werden. Wenn null, erfolgt
   *            keine Prüfung.
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param svNummer
   *            Sozialversicherungsnummer des Patienten, der die Leistung in
   *            Anspruch nimmt. 
   *            Ist die e-card des Patienten gesteckt, wird das Feld svNummer ignoriert und 
   *            automatisch die Sozialversicherungsnummer der Karte verwendet.
   * @param svtCode
   *            Code des Krankenversicherungsträgers des Patienten, für den diese
   *            Konsultation durchgeführt wird. Wenn null, wird der
   *            Krankenversicherungsträger automatisch vom e-card-Serversystem
   *            ermittelt. <br>
   *            Mögliche Werte laut Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}
   * @param fachgebietsCode
   *            Fachgebiet, für das diese Konsultation durchgeführt wird. <br>
   *            Mögliche Werte laut Funktion
   *            {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() getFachgebiete}
   * @param behandlungsfallCode
   *            Behandlungsfall, für den diese Konsultation durchgeführt wird.
   *            <br>
   *            Mögliche Werte laut Funktion
   *            {@link #getBehandlungsfaelle() getBehandlungsfaelle}
   * @param nacherfassungsgrundCode
   *            Grund für die Nacherfassung einer Konsultation. Wenn null,
   *            handelt es sich um eine Konsultation (Behandlungsfall
   *            durchführen), sonst um eine nacherfasste Konsultation. In diesem
   *            Fall muss auch das Behandlungsdatum angeführt werden. <br>
   *            Mögliche Werte siehe
   *            {@link at.chipkarte.client.kse.soap.constants.Nacherfassungsgrund Nacherfassungsgrundcodes}
   * @param behandlungsdatum
   *            Datum, an dem die nachzuerfassende Konsultation tatsächlich
   *            durchgeführt wurde. Pflichtfeld, wenn <Code>
   *            nacherfassungsgrundCode</Code> angegeben, sonst null. <br>
   *            Format: TT.MM.JJJJ
   * @param forceExecution
   *            Die Exception
   *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR CardExceptionConstants.REPEATED_SIGNATUR}
   *            wird nicht geworfen. <br>
   *            Die Durchführung dieser Funktion wird durch diese Exception
   *            nicht mehr abgebrochen.
   * @param cardReaderId Identifizierer des Kartenlesers 
   * 
   * @return Objekt vom Typ OfflineRecord
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL MISSING_KSE_FULL}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID CERTIFICATE_TIMESTAMPS_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE CERTIFICATE_REQUEST_OUT_OF_DATE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID}                     
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF INVALID_BF},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_NACHERFASSUNGSGRUND INVALID_NACHERFASSUNGSGRUND},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_NOT_SET DATE_NOT_SET},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID DATE_INVALID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_IN_FUTURE DATE_IN_FUTURE},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ILLEGAL_VALUE ILLEGAL_VALUE},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_ECARD NO_CERTIFICATE_AND_NO_ECARD},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#NO_CERTIFICATE_AND_NO_CARD_READER NO_CERTIFICATE_AND_NO_CARD_READER},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#MISSING_RIGHT_FOR_BEHANDLUNGSFALL MISSING_RIGHT_FOR_BEHANDLUNGSFALL} 
   * @throws CardException
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR REPEATED_SIGNATUR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#AUTHENTICATION_FAILED AUTHENTICATION_FAILED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   *             
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED}
   */
  OfflineRecord doKonsultationOffline(String cin, String dialogId, String svNummer, String svtCode, String fachgebietsCode,
      String behandlungsfallCode, String nacherfassungsgrundCode, String behandlungsdatum, Boolean forceExecution,
      String cardReaderId) throws AccessException, DialogException, CardException, ServiceException, InvalidParameterException,
      KseException;

  /**
   * <p>
   * Mit dieser Funktion wird eine stornierbare Konsultation storniert, wenn das
   * Behandlungsdatum der Konsultation in der aktuellen oder in der vorigen Abrechnungsperiode und das
   * aktuelle Datum innerhalb der Nachbringfrist der vorigen Abrechnungsperiode liegen.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param konsId
   *            ID der zu stornierenden Konsultation
   * @param konsVersion
   *            Version der zu stornierenden Konsultation
   * 
   * @return Objekt vom Typ KonsultationsBeleg
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATION_VERSION INVALID_KONSULTATION_VERSION}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED KONSULTATION_CHANGED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_ALREADY_CANCELLED KONSULTATION_ALREADY_CANCELLED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION NO_SUCH_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_STORNO_POSSIBLE NO_STORNO_POSSIBLE}
   */
  KonsultationsBeleg stornierenKonsultation(String dialogId, Long konsId, Integer konsVersion) throws KseException,
      DialogException, ServiceException, InvalidParameterException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion wird eine stornierte Konsultation wieder in Kraft
   * gesetzt, wenn das Behandlungsdatum der Konsultation in der aktuellen
   * oder in der vorigen Abrechnungsperiode und das aktuelle Datum innerhalb 
   * der Nachbringfrist der vorigen Abrechnungsperiode liegen. 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param konsId
   *            ID der wieder in Kraft zu setzenden Konsultation
   * @param konsVersion
   *            Version der wieder in Kraft zu setzenden Konsultation
   * 
   * @return Objekt vom Typ ErgebnisKonsultation
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATION_VERSION INVALID_KONSULTATION_VERSION}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED KONSULTATION_CHANGED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION NO_SUCH_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_NOT_CANCELLED KONSULTATION_NOT_CANCELLED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED TIME_NOT_ELAPSED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INEXISTENT_ANSPRUCH_FOR_RESET INEXISTENT_ANSPRUCH_FOR_RESET},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_OPEN_EINLADUNG_FOR_BKF_VM NO_OPEN_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OTHER_VM_EXIST OTHER_VM_EXIST}
   */
  ErgebnisKonsultation wiederinkraftsetzenKonsultation(String dialogId, Long konsId, Integer konsVersion) throws KseException,
      DialogException, ServiceException, InvalidParameterException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion wird eine änderbare Konsultation geändert, wenn das
   * Behandlungsdatum der Konsultation in der aktuellen oder in der vorigen Abrechnungsperiode und das
   * aktuelle Datum innerhalb der Nachbringfrist der vorigen Abrechnungsperiode liegen.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param konsId
   *            ID der zu ändernden Konsultation
   * @param konsVersion
   *            Version der zu ändernden Konsultation
   * @param behandlungsfallCode
   *            Behandlungsfall, auf den die Konsultation geändert werden soll. Mögliche Werte laut Funktion
   *            {@link #getBehandlungsfaelle() getBehandlungsfaelle}
   * 
   * @return Objekt vom Typ KonsultationsBeleg
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATION_VERSION INVALID_KONSULTATION_VERSION},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#MISSING_RIGHT_FOR_BEHANDLUNGSFALL MISSING_RIGHT_FOR_BEHANDLUNGSFALL}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_CHANGED KONSULTATION_CHANGED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#KONSULTATION_ALREADY_CANCELLED KONSULTATION_ALREADY_CANCELLED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_KONSULTATION NO_SUCH_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_EXCEPTION NO_VPANSPRUCH_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_FOR_SVT_EXCEPTION NO_VPANSPRUCH_FOR_SVT_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SPECIALISM_EXCEPTION INVALID_SPECIALISM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_BEHANDLUNGSFALL INVALID_BEHANDLUNGSFALL},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#SAME_BEHANDLUNGSFALL SAME_BEHANDLUNGSFALL},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#REFERERALL_REQUIRED_EXCEPTION REFERERALL_REQUIRED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#AGE_NOT_REACHED AGE_NOT_REACHED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VA_MATCHING_KONSULTATION NO_VA_MATCHING_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED TIME_NOT_ELAPSED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_EINLADUNG_FOR_BKF_VM NO_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_OPEN_EINLADUNG_FOR_BKF_VM NO_OPEN_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OTHER_VM_EXIST OTHER_VM_EXIST},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_CHANGE_POSSIBLE NO_CHANGE_POSSIBLE}
   */
  KonsultationsBeleg aendernKonsultation(String dialogId, Long konsId, Integer konsVersion, String behandlungsfallCode)
      throws KseException, InvalidParameterException, DialogException, ServiceException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion werden die den Suchkriterien entsprechenden
   * Konsultationen angefordert. Diese Funktion sollte für das Abfragen von
   * Konsultationsdaten verwendet werden, die dem Benutzer für
   * Korrekturfunktionen (stornieren, wieder in Kraft setzen, ändern) angeboten
   * werden (sofern diese Daten nicht von der Vertragspartnersoftware selbst gespeichert
   * werden). 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Eine der Funktionen {@link #getKonsultationsdaten(String, SuchFilter, String) getKonsultationsdaten} und 
   *     {@link #downloadKonsultationsdaten(String, String) downloadKonsultationsdaten} wird nicht zeitgleich ausgeführt, siehe auch 
   *     {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED FUNCTION_LOCKED}</li>  
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * 
   * <b>ACHTUNG:</b><br>
   * Wenn die Selektionsart
   * <ul>
   * <li>{@link at.chipkarte.client.kse.soap.constants.Selektionsart#ALLE "ALLE"} ist,
   * <ul>
   * <li>wird der Parameter
   * {@link SuchFilter#getSVNummer() SuchFilter.sVNummer} nicht ausgewertet,</li>
   * <li>werden maximal die Konsultationen für die aktuelle Abrechnungsperiode
   * plus zwei Vorquartale geliefert.</li>
   * </ul>
   * </li>
   * <li>{@link at.chipkarte.client.kse.soap.constants.Selektionsart#MODIFIZIERBAR "MODIFIZIERBAR"}
   * oder
   * {@link at.chipkarte.client.kse.soap.constants.Selektionsart#STORNIERT "STORNIERT"}
   * ist,
   * <ul>
   * <li>werden keine vollständigen Konsultationsbelege geliefert, die für die
   * Abrechnung mit dem jeweiligen KVT verwendet werden können!</li>
   * <li>sollte eines der Selektionskriterien <code>Zeitintervall</code>(
   * <code>DatumVon</code>,<code>DatumBis</code>) oder
   * <code>SvNummer</code> in der {@link SuchFilter SuchFilter} Klasse gesetzt
   * sein, werden maximal die Konsultationen für die aktuelle Abrechnungsperiode
   * inklusive Nachbringfrist geliefert.</li>
   * </ul>
   * </li>
   * </ul>
   * Wenn die angeforderten Konsultationen eine maximale Anzahl übersteigen,
   * kommt es zu der KseException
   * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED MAX_KONSULTATIONEN_EXCEEDED}.
   * Daher sollten die Selektionskriterien überlegt gewählt werden.
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Lang</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param selektionsKriterien
   *            Selektionskriterien zur Einschränkung der Daten, siehe auch
   *            {@link SuchFilter SuchFilter}
   * @param selektionsart
   *            Festlegung der Selektionsart, mögliche Werte siehe
   *            {@link at.chipkarte.client.kse.soap.constants.Selektionsart Selektionsarten}
   * @param sortierung
   *            Festlegung der Sortierung, wird keine, eine ungültige Sortierung oder als Selektionskriterium ALLE übergeben wird nach Behandlungsdatum sortiert, mögliche Werte siehe
   *            {@link at.chipkarte.client.kse.soap.constants.Sortierung Sortierung}
   * 
   * @return Objekt vom Typ Konsultationsdaten[] (ohne Signaturinformation und Abstimmungsbeleg) 
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED FUNCTION_LOCKED},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SELEKTIONS_ART INVALID_SELEKTIONS_ART},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ORDID INVALID_ORDID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID DATE_INVALID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF INVALID_BF},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATIONS_ART INVALID_KONSULTATIONS_ART}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#SYNC_SUCHANFRAGE_NOT_AVAIL SYNC_SUCHANFRAGE_NOT_AVAIL},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_SUCHANFRAGEN_EXCEEDED MAX_SUCHANFRAGEN_EXCEEDED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED MAX_KONSULTATIONEN_EXCEEDED}
   */
  Konsultationsdaten[] getKonsultationsdaten(String dialogId, SuchFilter selektionsKriterien, String selektionsart, String sortierung)
      throws InvalidParameterException, DialogException, ServiceException, KseException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion werden die den Suchkriterien entsprechenden Konsultationen für den maximalen Zeitraum
   * der aktuellen Abrechnungsperiode plus zwei Vorquartale angefordert. <br>
   * Von dieser Funktion wird eine Anfrage-ID zurückgeliefert. Der Auftrag wird vom 
   * e-card-Serversystem zu einem späteren Zeitpunkt bearbeitet. Die Benachrichtigung, dass die
   * Konsultationsdaten zur Abholung bereitstehen erfolgt über den Messaging-Mechanismus durch
   * Pollen der Funktion {@link at.chipkarte.client.base.soap.IBaseService#checkStatus 
   * checkStatus}. Diese Funktion signalisiert, dass eine neue Message vorliegt. Über die Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#getMessages getMessage} kann die neue Message
   * abgefragt werden. Hat diese Message die Kategorie <code>ZS_KSE_MSG_ASYDL</code>, können die
   * bereitgestellten Konsultationsdaten über die Funktion
   * {@link at.chipkarte.client.kse.soap.IKseService#downloadKonsultationsdaten downloadKonsultationsdaten}
   * angefordert werden.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   *    
   * <b>ACHTUNG:</b><br>
   * Der Parameter {@link SuchFilter#getSVNummer() SuchFilter.sVNummer} wird nicht ausgewertet.<br><br>
   * Bei allen Funktionsaufrufen, die einen Konsultationsbeleg erzeugen oder manipulieren, werden die
   * aktuellen Belegdaten an die Vertragspartnersoftware übergeben und sollten auch dort gespeichert werden.
   * Somit wird das Anfordern aller Belegdaten mit dieser Funktion nur mehr bei Datenverlust in
   * der Vertragspartnersoftware notwendig. <br> 
   * Wenn die angeforderten Konsultationen eine maximale Anzahl übersteigen,
   * kommt es zu der KseException {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED MAX_KONSULTATIONEN_EXCEEDED}.
   * Daher sollten die Selektionskriterien überlegt gewählt werden. 
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * @param selektionsKriterien Selektionskriterien zur Einschränkung der Daten, siehe auch
   *          {@link SuchFilter SuchFilter}
   *          
   * @return String - ID der Konsultationsdatenanfrage <br>
   *         Format: maximal 19-stellig
   *         
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ORDID INVALID_ORDID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_INVALID DATE_INVALID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF INVALID_BF},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_KONSULTATIONS_ART INVALID_KONSULTATIONS_ART}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_SUCHANFRAGEN_EXCEEDED MAX_SUCHANFRAGEN_EXCEEDED}
   */
  String sendKonsultationsdatenAnfrage(String dialogId, SuchFilter selektionsKriterien) throws InvalidParameterException,
      DialogException, ServiceException, KseException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion werden Konsultationsdaten, die über eine asynchrone
   * Suchanfrage
   * {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage sendKonsultationsdatenAnfrage}
   * angefordert wurden, abgefragt.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Funktion
   * {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage sendKonsultationsdatenAnfrage}
   * wurde erfolgreich ausgeführt</li>
   * <li>Eine der Funktionen {@link #getKonsultationsdaten(String, SuchFilter, String) #getKonsultationsdaten} und 
   *     {@link #downloadKonsultationsdaten(String, String) #downloadKonsultationsdaten} wird nicht zeitgleich ausgeführt, siehe auch 
   *     {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED ServiceExceptionConstants.FUNCTION_LOCKED}</li>   
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * <b>ACHTUNG: </b> <br>
   * Die Funktion sollte nur ausgeführt werden, wenn über den Message-Mechanismus signalisiert 
   * wurde, dass die angeforderten Daten
   * vorliegen. Abhängig von der Datenmenge des Ergebnisses kann das
   * Ausführen dieser Funktion längere Zeit in Anspruch nehmen. Wenn
   * die angeforderten Konsultationen eine maximale Anzahl
   * übersteigen, kommt es zu der KseException
   * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED MAX_KONSULTATIONEN_EXCEEDED}.
   * Daher sollten die Selektionskriterien überlegt gewählt werden.
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Lang</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param anfrageId
   *            Anfrage-ID, die von der Funktion
   *            {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage sendKonsultationsdatenAnfrage}
   *            geliefert wurde
   * 
   * @return Objekt vom Typ Konsultationsdaten[]
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#FUNCTION_LOCKED FUNCTION_LOCKED},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ASYNC_REQUEST_ID_NOT_FOUND ASYNC_REQUEST_ID_NOT_FOUND},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ASYNC_REQUEST_NOT_PROCESSED ASYNC_REQUEST_NOT_PROCESSED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ASYNC_REQUEST_ERROR ASYNC_REQUEST_ERROR},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#MAX_KONSULTATIONEN_EXCEEDED MAX_KONSULTATIONEN_EXCEEDED}
   */
  Konsultationsdaten[] downloadKonsultationsdaten(String dialogId, String anfrageId) throws InvalidParameterException,
      DialogException, ServiceException, KseException, AccessException;

  /**
   * <p>
   * Die Funktion liefert alle anstehenden Anfragen für Konsultationsdaten, die erfolgreich zum
   * e-card-Serversystem übertragen wurden.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Lang</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * @param onlyReady Bei "true" werden nur Anfragen zurückgeliefert, die vom e-card System
   *          verarbeitet und noch nicht abgeholt wurden
   *          
   * @return Objekt vom Typ KonsultationdatenAnfrage[] 
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   */

  KonsultationdatenAnfrage[] getKonsultationsdatenAnfragen(String dialogId, Boolean onlyReady) throws DialogException,
      ServiceException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion werden asynchrone Anfragen für Konsultationsdaten am
   * e-card-Serversystem gelöscht. Die Anfragen können unabhängig von ihrem
   * Status gelöscht werden.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param anfrageId
   *            Anfrage-ID die von der Funktion
   *            {@link at.chipkarte.client.kse.soap.IKseService#sendKonsultationsdatenAnfrage sendKonsultationsdatenAnfrage}
   *            geliefert wurde
   *            
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID}
   *  
   */
  void deleteKonsultationsdatenAnfrage(String dialogId, String anfrageId) throws InvalidParameterException, DialogException,
      ServiceException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion werden sämtliche Konsultationen eines Patienten, die
   * mit der o-card signiert wurden, mit der e-card nachsigniert, wenn das
   * Behandlungsdatum der Konsultation in der aktuellen oder in der vorigen Abrechnungsperiode und das
   * aktuelle Datum innerhalb der Nachbringfrist der vorigen Abrechnungsperiode liegen.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Eine gültige <b>e-card </b> ist in den Kartenleser, der dem Dialog
   * zugeordnet ist, gesteckt</li>
   * <li>Es gibt keinen Offlinedatensatz, dessen Offline- bzw. Bearbeitungsfrist zum Bearbeiten bzw. zum 
   * Senden an das e-card-Serversystem überschritten ist, siehe auch
   * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED KseExceptionConstants.OFFLINE_FRIST_EXCEEDED}</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param cin
   *            Card-Identification-Number der Karte, die für die Signatur
   *            verwendet wird. Prüfung, ob die Karte ident mit der Karte ist,
   *            von der die Daten (SV-Nummer) gelesen werden. Wenn null, erfolgt
   *            keine Prüfung.
   * @param forceExecution
   *            Die Exception
   *            {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR CardExceptionConstants.REPEATED_SIGNATUR}
   *            wird nicht geworfen. <br>
   *            Die Durchführung dieser Funktion wird durch diese Exception
   *            nicht mehr abgebrochen.
   * @param cardReaderId Identifizierer des Kartenlesers 
   * 
   * @return Objekt vom Typ KonsultationsBeleg[]
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH CERTIFICATE_MISMATCH}
   * @throws CardException
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR REPEATED_SIGNATUR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_FRIST_EXCEEDED OFFLINE_FRIST_EXCEEDED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_CHECK_PATIENT INVALID_CARD_CHECK_PATIENT},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT INVALID_CARD_LOST_STOLEN_CHECK_PATIENT} 
   */
  KonsultationsBeleg[] nachsignierenKonsultationen(String dialogId, String cin, Boolean forceExecution, String cardReaderId)
      throws CardException, ServiceException, DialogException, KseException, AccessException;

  /**
   * <p>
   * Mit dieser Funktion wird eine Nachsignierungsanfrage offline erfasst und auf der GINA
   * gespeichert. Sie kann, wenn die GINA wieder online ist, mit der Funktion
   * {@link at.chipkarte.client.kse.soap.IKseService#sendOfflineNachsignatur(String, String) sendOfflineNachsignatur}
   * an den e-card-Server gesendet werden.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Offline-Modus des Dialogs</li>
   * <li>Eine gültige <b>e-card</b> ist in den Kartenleser, der dem Dialog zugeordnet ist, gesteckt</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * @param cin Card-Identification-Number der Karte, die für die Signatur verwendet wird. Prüfung,
   *          ob die Karte ident mit der Karte ist, von der die Daten (SV-Nummer) gelesen werden.
   *          Wenn null, erfolgt keine Prüfung.
   * @param forceExecution Die Exception
   *          {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR CardExceptionConstants.REPEATED_SIGNATUR}
   *          wird nicht geworfen. <br>
   *          Die Durchführung dieser Funktion wird durch diese Exception nicht mehr abgebrochen.
   * @param cardReaderId Identifizierer des Kartenlesers 
   * 
   * @return Objekt vom Typ OfflineRecord &ndash; Offlinedatensatz
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE FUNCTION_NOT_ALLOWED_IN_ONLINE_MODE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws CardException
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#REPEATED_SIGNATUR REPEATED_SIGNATUR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#AUTHENTICATION_FAILED AUTHENTICATION_FAILED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}   
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED}
   */
  OfflineRecord nachsignierenKonsultationenOffline(String dialogId, String cin, Boolean forceExecution, String cardReaderId)
      throws CardException, ServiceException, DialogException, AccessException, KseException;

  /**
   * <p>
   * Mit dieser Funktion werden alle zurzeit gültigen Behandlungsfälle geliefert. 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Keine</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @return Objekt vom Typ BaseProperty[] - Array der Behandlungsfälle, siehe auch {@link BaseProperty BaseProperty}
   * 
   * @throws ServiceException
   *    {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *    {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getBehandlungsfaelle() throws ServiceException;


  /**
   * <p>
   * Mit dieser Funktion werden alle zurzeit gültigen Behandlungsfälle zu einem bestimmten
   * Fachgebiet geliefert.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Keine</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param fachgebietCode Code des Fachgebiets, für das die gültigen Behandlungsfälle abgefragt werden sollen
   * 
   * @return Objekt vom Typ BaseProperty[] - Array der Behandlungsfälle für ein Fachgebiet, siehe auch
   *         {@link BaseProperty BaseProperty}
   *
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG}
   */
  BaseProperty[] getBehandlungsfaelleByFachgebiet(String fachgebietCode) throws InvalidParameterException, ServiceException;
 
  /**
   * <p>
   * Diese Funktion liefert alle aktuell gültigen Behandlungsfälle zu einem bestimmten Fachgebiet, sowie eventuell benötigte 
   * Zusatzrechte um den Behandlungsfall durchführen zu können.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> <br>
   * <ul>
   * <li>Keine</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param fachgebietCode Code des Fachgebiets, für das die gültigen Behandlungsfälle abgefragt werden sollen
   * 
   * @return Objekt vom Typ BehandlungsfallZusatzProperty[] - Array der Behandlungsfälle für ein Fachgebiet inklusive 
   *         benötigtem Zusatzrecht, siehe auch {@link BehandlungsfallZusatzProperty BehandlungsfallZusatzProperty}
   *     
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG}
   */
  BehandlungsfallZusatzProperty[] getBehandlungsfaelleByFachgebietZusatz(String fachgebietCode) throws InvalidParameterException, ServiceException;  
  
  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des KSE-Systems zurück.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   *            
   * @return Objekt vom Typ Property[] - Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *             Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *             Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>            
   *             
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   */ 
  Property[] checkStatus(String dialogId) throws ServiceException, DialogException, AccessException;


  /**
   * <p>
   * Diese Funktion ermittelt die zurzeit auf der GINA gespeicherten Offlinedaten für die dem
   * Dialog zugeordnete Ordinationsadresse. 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Es gibt am Ordinationsclient keinen gleichzeitigen schreibenden Zugriff auf die 
   *  Offlinedatensätze des Vertragspartners; siehe auch
   * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS}</li> 
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * 
   * @return Objekt vom Typ OfflineRecord[] - Array von Offlinedatensätzen in der Reihenfolge der Erstellung
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED}
   */
  OfflineRecord[] getOfflineRecords(String dialogId) throws DialogException, KseException, ServiceException, AccessException;

  /**
   * <p>
   * Diese Funktion liefert die Anzahl der am Ordinationsclient gespeicherten Offlinekonsultationen.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * 
   * @return Long - Anzahl der offline gespeicherten Konsultationen
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED}
   */
  Long getNumberOfflineKonsultationen(String dialogId) throws DialogException, ServiceException, AccessException, KseException;

  /**
   * <p>
   * Diese Funktion liefert die Anzahl der am Ordinationsclient gespeicherten Offline-Nachsignaturen.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * 
   * @return Long - Anzahl der offline gespeicherten Nachsignaturen
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED}
 */
  Long getNumberOfflineNachsignaturen(String dialogId) throws DialogException, ServiceException, AccessException, KseException;

  /**
   * <p>
   * Diese Funktion löscht einen Offlinedatensatz von der GINA.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Es gibt am Ordinationsclient keinen gleichzeitigen schreibenden Zugriff auf die Offlinedatensätze des Vertragspartners;  
   * siehe auch {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS}</li> 
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Kurz</p>
   * 
   * @param dialogId
   *            Dialog-ID des aufgebauten Dialogs
   * @param offlineId
   *            ID des offline gespeicherten Datensatzes
   *            
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_ANFRAGE_ID INVALID_ANFRAGE_ID},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ID_NOT_FOUND ID_NOT_FOUND}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED}
   */
  void deleteOfflineRecord(String dialogId, String offlineId) throws DialogException, ServiceException,
      InvalidParameterException, KseException, AccessException;

  /**
   * <p>
   * Diese Funktion übermittelt eine am Ordinationsclient gespeicherte Offline (nacherfasste)
   * Konsultation an das e-card-Serversystem.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Es gibt am Ordinationsclient keinen gleichzeitigen schreibenden Zugriff auf 
   *  die Offlinedatensätze des Vertragspartners; siehe auch
   * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS}</li>
   * <li>KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * @param offlineId ID des offline gespeicherten Datensatzes
   * @param fachgebietsCode Fachgebietscode der zu sendenden Offlinekonsultation. Wenn null, wird
   *          der ursprünglich angegebene Fachgebietscode übermittelt, andernfalls muss auch der
   *          Behandlungsfallcode mit übergeben werden.
   * @param behandlungsfallCode Behandlungsfallcode der zu sendenden Offlinekonsultation. Wenn
   *          null, wird der ursprünglich angegebene Behandlungsfallcode übermittelt, andernfalls
   *          muss auch das Fachgebiet mit übergeben werden.
   * @param svtCode Code des Krankenversicherungsträgers des Patienten, für den diese Konsultation
   *          durchgeführt wird. Wenn null, wird der Krankenversicherungsträger automatisch vom
   *          e-card-Serversystem ermittelt. <br>
   *          Mögliche Werte laut Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}
   * @param anspruchId ID des abgeleiteten Anspruchs, sonst null. Die möglichen Ansprüche eines Patienten
   *          wurden durch vorherigen Aufruf dieser Funktion unter Angabe eines nicht
   *          eindeutigen Anspruchs in der Exception
   *          {@link at.chipkarte.client.kse.soap.exceptions.KseException AnspruchException}
   *          zurückgeliefert.
   *          
   * @return Objekt vom Typ ErgebnisKonsultation
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL MISSING_KSE_FULL}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION PARAMETER_MISMATCH_EXCEPTION},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID} 
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_BF INVALID_BF},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ID_NOT_FOUND ID_NOT_FOUND},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#WRONG_RECORD_TYPE_FOR_FUNCTION WRONG_RECORD_TYPE_FOR_FUNCTION},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#MISSING_RIGHT_FOR_BEHANDLUNGSFALL MISSING_RIGHT_FOR_BEHANDLUNGSFALL}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_FOR_SVT_EXCEPTION NO_VPANSPRUCH_FOR_SVT_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_OUT_OF_RANGE_EXCEPTION DATE_OUT_OF_RANGE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SPECIALISM_EXCEPTION INVALID_SPECIALISM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SUCH_CLAIM_EXCEPTION NO_SUCH_CLAIM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_ANSPRUCH_PROVIDED_EXCEPTION NO_ANSPRUCH_PROVIDED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CLAIM_EXCEPTION INVALID_CLAIM_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VPANSPRUCH_EXCEPTION NO_VPANSPRUCH_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#REFERERALL_REQUIRED_EXCEPTION REFERERALL_REQUIRED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_SVT_PROVIDED_EXCEPTION NO_SVT_PROVIDED_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TREATMENT_DATE_IN_FUTURE_EXCEPTION TREATMENT_DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#AGE_NOT_REACHED AGE_NOT_REACHED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_BEHANDLUNGSFALL INVALID_BEHANDLUNGSFALL},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_VA_MATCHING_KONSULTATION NO_VA_MATCHING_KONSULTATION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#TIME_NOT_ELAPSED TIME_NOT_ELAPSED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN INVALID_CARD_LOST_STOLEN},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_EINLADUNG_FOR_BKF_VM NO_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#NO_OPEN_EINLADUNG_FOR_BKF_VM NO_OPEN_EINLADUNG_FOR_BKF_VM},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OTHER_VM_EXIST OTHER_VM_EXIST}
   */
  ErgebnisKonsultation sendOfflineKonsultation(String dialogId, String offlineId, String fachgebietsCode,
      String behandlungsfallCode, String svtCode, String anspruchId) throws DialogException, ServiceException,
      InvalidParameterException, KseException, AccessException;

  /**
   * <p>
   * Diese Funktion übermittelt eine am Ordinationsclient gespeicherte Nachsignierungsanfrage an
   * das e-card-Serversystem. 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>Es gibt am Ordinationsclient keinen gleichzeitigen schreibenden Zugriff auf die Offlinedatensätze des Vertragspartners; siehe auch {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS}</li>
   * <li>Zumindest eingeschränktes KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId Dialog-ID eines aufgebauten Dialogs
   * @param offlineId ID des offline gespeicherten Datensatzes
   * 
   * @return Objekt vom Typ KonsultationsBeleg[] - Array der im Zuge des e-card Nachbringens nachsignierter Belege.
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_CORE MISSING_KSE_CORE}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ID_NOT_FOUND ID_NOT_FOUND},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#WRONG_RECORD_TYPE_FOR_FUNCTION WRONG_RECORD_TYPE_FOR_FUNCTION}
   * @throws KseException
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINETRANSFER_ALREADY_IN_PROCESS OFFLINETRANSFER_ALREADY_IN_PROCESS},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#DATE_IN_FUTURE_EXCEPTION DATE_IN_FUTURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#OFFLINE_NOT_ALLOWED OFFLINE_NOT_ALLOWED},
   *             {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#INVALID_CARD_LOST_STOLEN INVALID_CARD_LOST_STOLEN}
   */
  KonsultationsBeleg[] sendOfflineNachsignatur(String dialogId, String offlineId) throws DialogException, ServiceException,
      InvalidParameterException, KseException, AccessException;
  
  /**
   * <p>
   * Diese Funktion übermittelt die Antwortinformationen einer Zusatzinformation an das e-card-Serversystem.
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * <li>KSE-Recht</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param zusatzinformationsAntwortId
   *            Zusatzinformations-Antwort-ID die von der Funktion
   *            {@link at.chipkarte.client.kse.soap.IKseService#doKonsultation doKonsultation}
   *            geliefert wurde
   * @param zusatzinformationsAntwort
   *            Die zur Zusatzinformation ermittelte Antwort. <br> 
   *            Mögliche Werte siehe
   *            {@link at.chipkarte.client.kse.soap.constants.ZusatzinformationsAntwort ZusatzinformationsAntwort}. <br>
   *            <u>Hinweis:</u> Für Zusatzinformationen mit dem Parameter <i>AntwortAnzeigeBedingung</i> gleich <code>2</code> ist 
   *            nur für <i>zusatzinformationsAntwort</i> nur der Wert <code>1</code> (ja) zulässig 
   *            (entspricht in diesem Fall der Antwort "Hinweis erhalten / zur Kenntnis genommen").
   *                       
   * @throws ServiceException
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *            {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL MISSING_KSE_FULL}
   * @throws DialogException
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *            {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ZUSATZINFO_ANTWORTID_REQUIRED ZUSATZINFO_ANTWORTID_REQUIRED},
   *            {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#ANTWORT_REQUIRED ANTWORT_REQUIRED}
   * @throws KseException
   *            {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ZUSATZINFO_ANTWORTID_NOT_ALLOWED ZUSATZINFO_ANTWORTID_NOT_ALLOWED},
   *            {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ZUSATZINFO_ANTWORTID_ALREADY_USED ZUSATZINFO_ANTWORTID_ALREADY_USED},            
   *            {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants#ZUSATZINFO_ANTWORTID_INVALID ZUSATZINFO_ANTWORTID_INVALID}
   */
  void sendZusatzinformationsAntwort(String dialogId, Long zusatzinformationsAntwortId, Integer zusatzinformationsAntwort) throws InvalidParameterException, KseException, 
    DialogException, ServiceException, AccessException;
  
  /**
   * <p>
   * Diese Funktion ermittelt die eventuell vorhandenen Erstkonsultationen für einen Patienten. 
   * </p>
   * 
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt</li>
   * <li>Online-Modus des Dialogs</li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe:</B> Mittel</p>
   * 
   * @param dialogId
   *            Dialog-ID eines aufgebauten Dialogs
   * @param svNummer
   *            Sozialversicherungsnummer des Patienten, für den geprüft wird ob bereits eine Erstkonsultation vorhanden ist
   * @param fachgebietsCode
   *            Fachgebiet, für das gesucht werden soll. <br>
   *            Mögliche Werte laut Funktion
   *            {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() getFachgebiete}, wobei der Vertragspartner auf der 
   *            angemeldeten Kombination aus Ordination und Tätigkeitsbereich mit 
   *            dem angegebenen Fachgebiet einen kurativen Vertrag mit Konsultationsrecht besitzen muss (siehe hierzu auch 
   *            {@link at.chipkarte.client.base.soap.IBaseService#getVertraege(String) getVertraege}.
   * @param nacherfassung
   *            Kennzeichen, ob die Suche im Zuge der aktuellen Erfassung oder einer Nacherfassung vorgenommen wird. <br>
   *            Wird dieser Parameter nicht angegeben, wird als Default-Wert <code>false</code> (d.h. keine Nacherfassung) gesetzt.<br>
   *            <u>Hinweis:</u> Diese Funktion dient der Abfrage der bereits bestehenden Erstkonsultationen beim abfragenden 
   *            Vertragspartner im ZUGE einer Konsultationsbuchung. Die retournierten Werte dienen der Voreinstellung für die 
   *            Konsultationserfassung.
   *            
   * @return Objekt vom Typ Erstkonsultationsdaten[] - Array der ermittelten Erstkonsultationen.
   * 
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_KSE_FULL MISSING_KSE_FULL}
   * @throws DialogException
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER}
   */
  Erstkonsultationsdaten[] getErstkonsultationen(String dialogId, String svNummer, String fachgebietsCode, boolean nacherfassung) throws DialogException, ServiceException,
      InvalidParameterException, AccessException;

}
