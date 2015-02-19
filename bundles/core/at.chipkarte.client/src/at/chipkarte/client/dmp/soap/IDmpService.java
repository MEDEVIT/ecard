/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.dmp.soap.exceptions.DmpException;
import at.chipkarte.client.dmp.soap.exceptions.DmpInvalidParameterException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des Disease Management Programm
 * (DMP) zur Verfügung.
 * </p>
 */
public interface IDmpService {

  /**
   * <p>
   * Mit dieser Funktion werden alle aktuell gültigen Disease Management
   * Programme (DMPs) geliefert.
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz
   * </p>
   *
   * @return Liste von Disease Management Programmen, siehe
   *           {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getDMPs() throws AccessException, ServiceException;

  /**
   * <p>
   * Mit dieser Funktion wird eine DMP-Eingabe durchgeführt.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Eine gültige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param eingabeParameter
   *           Parameter zur Durchführung der DMP-Eingabe.
   * @param cardReaderId
   *           Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *           Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *           Kartenleser verwendet.
   * @return Ergebnis der durchgeführten DMP-Eingabe
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#ADRESS_ZUSATZ_WRONG_FORMAT ADRESS_ZUSATZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#EINGABE_ZUSATZ_WRONG_FORMAT EINGABE_ZUSATZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#EMAIL_WRONG_FORMAT EMAIL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#HAUSNR_WRONG_FORMAT HAUSNR_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_DMP_CODE INVALID_DMP_CODE},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_EINGABE_ART INVALID_EINGABE_ART},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#NO_SV_PERSON_IDENTIFICATION NO_SV_PERSON_IDENTIFICATION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#ADRESSE_INCOMPLETE ADRESSE_INCOMPLETE},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#NR_ZUSATZ_WRONG_FORMAT NR_ZUSATZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#ORT_WRONG_FORMAT ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#PLZ_WRONG_FORMAT PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#POSTFACHNUMMER_WRONG_FORMAT POSTFACHNUMMER_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#POSTFACHTEXT_WRONG_FORMAT POSTFACHTEXT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#STRASSE_WRONG_FORMAT STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#TEL_NR_WRONG_FORMAT TEL_NR_WRONG_FORMAT}
   * @throws DmpException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#SV_NUMMER_NOT_EXISTS SV_NUMMER_NOT_EXISTS},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_ANSPRUCH_EXCEPTION NO_ANSPRUCH_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_ASVG_SVT_PROVIDED_EXCEPTION NO_ASVG_SVT_PROVIDED_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_SUCH_CLAIM_EXCEPTION NO_SUCH_CLAIM_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_SVT_PROVIDED_EXCEPTION NO_SVT_PROVIDED_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_VERTRAG_EXCEPTION NO_VERTRAG_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#E_NOT_POSSIBLE_BUT_W E_NOT_POSSIBLE_BUT_W},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#A_NOT_POSSIBLE_BUT_W A_NOT_POSSIBLE_BUT_W},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#EINSCHREIBEART_NOT_POSSIBLE_BUT_A EINSCHREIBEART_NOT_POSSIBLE_BUT_A},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#EINSCHREIBEART_NOT_POSSIBLE EINSCHREIBEART_NOT_POSSIBLE},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#EINSCHREIBEART_NOT_POSSIBLE_BUT_E EINSCHREIBEART_NOT_POSSIBLE_BUT_E}
   */
  EingabeErgebnis doEingabe(String dialogId, EingabeParameter eingabeParameter, String cardReaderId) throws AccessException,
      ServiceException, DialogException, CardException, DmpInvalidParameterException, DmpException;

  /**
   * <p>
   * Mit dieser Funktion wird eine DMP Ausschreibeanfrage für einen Patienten erfasst.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Eine gültige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param ausschreibeParameter
   *           Parameter zur Durchführung der DMP Ausschreibeanfrage.
   * @param cardReaderId
   *           Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *           Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *           Kartenleser verwendet.
   * @return Ergebnis der durchgeführten DMP Ausschreibeanfrage
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#NO_SV_PERSON_IDENTIFICATION NO_SV_PERSON_IDENTIFICATION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_DMP_CODE INVALID_DMP_CODE},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_AUSSCHREIBEGRUND INVALID_AUSSCHREIBEGRUND}
   * @throws DmpException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#SV_NUMMER_NOT_EXISTS SV_NUMMER_NOT_EXISTS},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_BETR_VERH_AUSSCHREIBUNG_EXCEPTION NO_BETR_VERH_AUSSCHREIBUNG_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION}
   */
  AusschreibeErgebnis doAusschreibung(String dialogId, AusschreibeParameter ausschreibeParameter, String cardReaderId) throws AccessException,
      ServiceException, DialogException, CardException, DmpInvalidParameterException, DmpException;

  /**
   * <p>
   * Diese Funktion liefert alle von einem Vertragspartner eingereichten DMP
   * Anfragen entsprechend den angegebenen Selektionskriterien. Wenn keine
   * Selektionskriterien angegeben wurden, liefert die Funktion die maximal
   * mögliche Ergebnismenge.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param dmpCode
   *           Code des DMP-Programms. Dieser Parameter ist optional. Ist der
   *           Parameter nicht angegeben, dann wird nach allen DmpCode Werten
   *           selektiert. Mögliche Werte siehe Codes, die über die Funktion
   *           {@link #getDMPs()} abgefragt werden können.
   * @param anfrageArt
   *           Art der Anfrage. Dieser Parameter ist optional. Ist der Parameter
   *           nicht angegeben, dann wird nach allen Anfragearten
   *           selektiert. Mögliche Werte siehe
   *           {@link at.chipkarte.client.dmp.soap.constants.AnfrageArt Konstante AnfrageArt}.
   * @param anfrageStatus
   *           Status der Anfrage. Dieser Parameter ist optional. Ist der
   *           Parameter nicht angegeben, dann wird nach allen Status einer
   *           Anfrage selektiert. Mögliche Werte siehe
   *           {@link at.chipkarte.client.dmp.soap.constants.AnfrageStatus Konstante AnfrageStatus}.
   * @param datumBeginn
   *           Beginndatum für den Suchzeitraum der getätigten Anfrage. Dieser
   *           Parameter ist optional. Ist der Parameter nicht angegeben, wird
   *           uneingeschränkt in die Vergangenheit gesucht. Zulässiger
   *           Wertebereich: aktuelles Datum >= DatumBeginn. Format "TT.MM.JJJJ".
   * @param datumEnde
   *           Enddatum für den Suchzeitraum der getätigten Anfrage.
   *           Dieser Parameter ist optional. Ist der Parameter nicht angegeben,
   *           wird als Selektionskriterium das aktuelle Datum des
   *           Frontend-Servers verwendet. Zulässiger Wertebereich: DatumBeginn &lt;
   *           DatumEnde <= aktuelles Datum. Format "TT.MM.JJJJ".
   * @return Liste von Anfragen
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#BEGIN_DATUM_WRONG_FORMAT BEGIN_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#ENDE_DATUM_WRONG_FORMAT ENDE_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#BEGIN_DATUM_INVALID BEGIN_DATUM_INVALID},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#ENDE_DATUM_INVALID ENDE_DATUM_INVALID},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_DMP_CODE INVALID_DMP_CODE},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_ANFRAGE_ART INVALID_ANFRAGE_ART},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_ANFRAGE_STATUS INVALID_ANFRAGE_STATUS}
   */
  Anfrage[] searchAnfragen(String dialogId, String dmpCode, String anfrageArt, String anfrageStatus, String datumBeginn,
      String datumEnde) throws AccessException, ServiceException, DialogException, DmpInvalidParameterException;

  /**
   * <p>
   * Diese Funktion liefert den administrativen Patientenstatus zu einem
   * konkreten Patienten.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param svNummer
   *           Sozialversicherungsnummer des Patienten für den die administrative
   *           Patienteninformation selektiert wird.
   * @param strukturierteMeldung
   *           Kennzeichen, ob die strukturierte Textmeldung ermittelt werden
   *           soll (True) oder die freie, unstruktierte Textmeldung (False).
   * @return Administrative Patienteninformation
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER}
   */
  PatientenInformation getAdminPatientenInformationen(String dialogId, String svNummer, Boolean strukturierteMeldung)
      throws AccessException, ServiceException, DialogException, DmpInvalidParameterException;

  /**
   * <p>
   * Diese Funktion liefert den medizinischen Patientenstatus zu einem konkreten
   * Patienten.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param svNummer
   *           Sozialversicherungsnummer des Patienten für den die medizinische
   *           Patienteninformation selektiert wird.
   * @param strukturierteMeldung
   *           Kennzeichen, ob die strukturierte Textmeldung ermittelt werden
   *           soll (True) oder die freie, unstruktierte Textmeldung (False).
   * @return Medizinische Patienteninformation
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER}
   */
  PatientenInformation getMedPatientenInformationen(String dialogId, String svNummer, Boolean strukturierteMeldung)
      throws AccessException, ServiceException, DialogException, DmpInvalidParameterException;

  /**
   * <p>
   * Diese Funktion ermittelt abhängig vom Selektionskriterium
   * "BetreuungsStatus" die einem Vertragspartner zugeordneten DMP Patienten und
   * liefert Informationen zum Betreuungsverhältnis dieser DMP Patienten.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.<li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param dmpCode
   *           Code des DMP-Programms. Dieser Parameter ist optional. Ist der
   *           Parameter nicht angegeben, dann wird nach allen DmpCode Werten
   *           selektiert. Mögliche Werte siehe Codes, die über die Funktion
   *           {@link #getDMPs()} abgefragt werden können.
   * @param betreuungsStatus
   *           Status des DMP Betreuungsverhältnisses. Dieser Parameter ist
   *           optional. Ist der Parameter nicht angegeben, dann wird nach allen
   *           Statuswerten selektiert. Mögliche Werte siehe
   *           {@link at.chipkarte.client.dmp.soap.constants.BetreuungsStatus Konstante BetreuungsStatus}.
   * @return Liste von betreuten Patienten mit max. 500 Einträgen
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_BETREUUNGSSTATUS INVALID_BETREUUNGSSTATUS},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_DMP_CODE INVALID_DMP_CODE}
   * @throws DmpException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#MAX_RESULT_EXCEEDED MAX_RESULT_EXCEEDED}
   */
  BetreuterPatient[] getBetreutePatienten(String dialogId, String dmpCode, String betreuungsStatus) throws AccessException,
      ServiceException, DialogException, DmpInvalidParameterException, DmpException;

  /**
   * <p>
   * Mit dieser Funktion wird geprüft, ob zum aktuellen Zeitpunkt ein
   * DMP-Betreuungsverhältnis zwischen DMP-Arzt und DMP-Patient vorliegt.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param svNummer
   *           Sozialversicherungsnummer des Patienten.
   * @return True, wenn der abgefragte Patient ein DMP Patient ist.
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER}
   */
  Boolean isDMPPatient(String dialogId, String svNummer) throws AccessException, ServiceException, DialogException,
      DmpInvalidParameterException;

  /**
   * <p>
   * Diese Funktion ermittelt die aktuellen Betreuungsverhältnisse zu einem konkreten Patienten.
   * </p>
   *
   * <p>
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String)
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param dmpCode
   *           Code des DMP-Programms. Dieser Parameter ist optional. Ist der
   *           Parameter nicht angegeben, dann wird nach allen DmpCode Werten
   *           selektiert. Mögliche Werte siehe Codes, die mittels der Funktion
   *           {@link #getDMPs()} ermittelt werden können.
   * @param svNummer
   *           Sozialversicherungsnummer des Patienten. Dieser Parameter ist optional.
   *           Ist keine e-card gesteckt ist die Angabe ein Muss. Ist eine e-card gesteckt
   *           und keine Sozialversicherungsnummer angegeben, wird die Sozialversicherungsnummer
   *           der gesteckten e-card verwendet. Ist eine e-card gesteckt und eine
   *           Sozialversicherungsnummer angegeben, wird die angegebene Sozialversicherungsnummer verwendet.
   * @param cardReaderId
   *           Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *           Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser, der dem Dialog zugeordnet bzw.
   *           der als Attribut angegeben ist, gesteckt sein. Wenn die Abfrage ohne e-card durchgeführt wird, muss die
   *           Sozialversicherungsnummer des Patienten angegeben werden.
   * @return Liste von Betreuungsverhältnissen
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE}
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
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws DmpInvalidParameterException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#INVALID_DMP_CODE INVALID_DMP_CODE},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants#NO_SV_PERSON_IDENTIFICATION NO_SV_PERSON_IDENTIFICATION}
   * @throws DmpException
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants#NO_BETR_VERH_VP_EXCEPTION NO_BETR_VERH_VP_EXCEPTION}
   */
  Betreuungsverhaeltnis[] searchBetreuungsverhaeltnisseForPatient(String dialogId, String dmpCode, String svNummer,
      String cardReaderId) throws AccessException, ServiceException, DialogException, CardException, DmpInvalidParameterException,
      DmpException;

  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des DMP zurück.
   * </p>
   *
   * <p>
   * <b>Voraussetzung: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf DMP
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DMP_CORE DMP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz
   * </p>
   *
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch
   *           {@link at.chipkarte.client.base.soap.Property Property}.<br>
   *           Möglicher Key siehe
   *           {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE Konstante SERVICE_STATE}.<br>
   *           Mögliche Werte siehe
   *           {@link at.chipkarte.client.base.soap.constants.Modus Konstante Modus}.<br>
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DMP_CORE MISSING_DMP_CORE},
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
}
