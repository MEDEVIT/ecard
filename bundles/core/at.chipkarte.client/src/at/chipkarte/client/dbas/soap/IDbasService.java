package at.chipkarte.client.dbas.soap;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.dbas.soap.exceptions.DbasEncryptionException;
import at.chipkarte.client.dbas.soap.exceptions.DbasException;
import at.chipkarte.client.dbas.soap.exceptions.DbasInvalidParameterException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des Dokumentationsblatt Annahme Service
 * (DBAS) zur Verfügung.
 * </p>
 */
public interface IDbasService {

  /**
   * <p>
   * Mit dieser Funktion werden die Fachdaten (Patientendaten und Konsultationen) für den angegebenen
   * Datenblatttyp (VU-Datenblätter) vom Server abgeholt.<br>
   * Können dabei die Patientendaten nicht ermittelt werden, so wird die entsprechende Exception
   * geworfen. Sollten keine Konsultationen ermittelt werden können, so wird ein leeres Array von
   * Konsultationen geliefert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser, der dem
   * Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattTyp
   *          Typ (Code) des Datenblatts.<br>
   *          Der Parameter muss angegeben werden. Die möglichen Werte der VU-Datenblätter sind in
   *          {@link at.chipkarte.client.dbas.soap.constants.DatenblattConstants DatenblattConstants}
   *          definiert.<br>
   * @param svNummer
   *          Sozialversicherungsnummer des Patienten.<br>
   *          Format: maximal 10-stellig Dieser Parameter ist optional. Wird er
   *          nicht eingegeben, muss eine e-card gesteckt sein. Wird er angegeben
   *          und ist gleichzeitig eine e-card gesteckt, wird die eingegebene
   *          SVNR zur Ermittlung der Fachdaten verwendet.
   * @return Liste passender Konsultationen und Patientendaten
   * @throws DbasException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws DbasInvalidParameterException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_TYP_INVALID DATENBLATT_TYP_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD}
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_TYP_REQUIRED DATENBLATT_TYP_REQUIRED},
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	KonsultationData searchKonsultationData(String dialogId, String cardReaderId, String datenblattTyp, String svNummer) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion werden die Fachdaten (Patientendaten) für den angegebenen
   * Datenblatttyp (DMP-Datenblätter) vom Server abgeholt. Dazu muss der SV-Patient
   * beim Vertragspartner zum jeweiligen DMP-Programm eingeschrieben sein.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser, der dem
   * Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *		  ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattTyp
   *          Typ (Code) des Datenblatts.<br>
   *          Der Parameter muss angegeben werden. Die möglichen Werte der DMP-Datenblätter sind in
   *          {@link at.chipkarte.client.dbas.soap.constants.DatenblattConstants DatenblattConstants}
   *          definiert.<br>
   * @param svNummer
   *          Sozialversicherungsnummer des Patienten.<br>
   *          Format: maximal 10-stellig Dieser Parameter ist optional. Wird er
   *          nicht eingegeben, muss eine e-card gesteckt sein. Wird er angegeben
   *          und ist gleichzeitig eine e-card gesteckt, wird die eingegebene
   *          SVNR zur Ermittlung der Fachdaten verwendet.
   * @return DMP-Daten des Patienten (Patientendaten und Datum der Ersteinschreibung im jeweiligen DMP)
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#PERSON_NOT_IN_DMP PERSON_NOT_IN_DMP},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws DbasInvalidParameterException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_TYP_INVALID DATENBLATT_TYP_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD}
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_TYP_REQUIRED DATENBLATT_TYP_REQUIRED},
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	DmpData searchDmpData(String dialogId, String cardReaderId, String datenblattTyp, String svNummer) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird das Datenblatt 'Befundblatt Allgemeines Programm', nachdem
   * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
   * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *		  ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattAllgemeinesProgramm
   *          Daten des zu übertragenden Datenblattes 'Befundblatt Allgemeines Programm'
   * @return Empfangsbestätigung der erfolgreichen Übertragung.
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_ABRECHNUNG_DATA_FAILED CREATE_ABRECHNUNG_DATA_FAILED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#NO_KEYS_FOUND NO_KEYS_FOUND},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_KONSULTATION INVALID_KONSULTATION},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED}
   * @throws DbasEncryptionException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   * @throws DbasInvalidParameterException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_ALLGEMEINES_PROGRAMM_REQUIRED DATENBLATT_ALLGEMEINES_PROGRAMM_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ANSCHRIFT_REQUIRED AMP_ANSCHRIFT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ANSCHRIFT_WRONG_FORMAT AMP_ANSCHRIFT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_POSTLEITZAHL_REQUIRED AMP_POSTLEITZAHL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_POSTLEITZAHL_WRONG_FORMAT AMP_POSTLEITZAHL_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOPF_HALS_REQUIRED AMP_KOPF_HALS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOPF_HALS_WRONG_FORMAT AMP_KOPF_HALS_WRONG_FORMAT},,
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HOERVERMINDERUNG_REQUIRED AMP_HOERVERMINDERUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HOERVERMINDERUNG_INVALID AMP_HOERVERMINDERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HOERVERMINDERUNG_FORBIDDEN AMP_HOERVERMINDERUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UEBERWEISUNG_HNO_FA_INVALID AMP_UEBERWEISUNG_HNO_FA_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UEBERWEISUNG_HNO_FA_FORBIDDEN AMP_UEBERWEISUNG_HNO_FA_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SEHVERMINDERUNG_REQUIRED AMP_SEHVERMINDERUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SEHVERMINDERUNG_INVALID AMP_SEHVERMINDERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SEHVERMINDERUNG_FORBIDDEN AMP_SEHVERMINDERUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UEBERWEISUNG_AUGEN_FA_INVALID AMP_UEBERWEISUNG_AUGEN_FA_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UEBERWEISUNG_AUGEN_FA_FORBIDDEN AMP_UEBERWEISUNG_AUGEN_FA_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HERZ_LUNGE_GEFAESS_REQUIRED AMP_HERZ_LUNGE_GEFAESS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HERZ_LUNGE_GEFAESS_WRONG_FORMAT AMP_HERZ_LUNGE_GEFAESS_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ABDOMEN_REQUIRED AMP_ABDOMEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ABDOMEN_WRONG_FORMAT AMP_ABDOMEN_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_WIRBELSAEULE_GELENKE_REQUIRED AMP_WIRBELSAEULE_GELENKE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_WIRBELSAEULE_GELENKE_WRONG_FORMAT AMP_WIRBELSAEULE_GELENKE_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HAUT_REQUIRED AMP_HAUT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HAUT_WRONG_FORMAT AMP_HAUT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_AUFFAELLIGKEITEN_REQUIRED AMP_AUFFAELLIGKEITEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_AUFFAELLIGKEITEN_INVALID AMP_AUFFAELLIGKEITEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MELANOM_REQUIRED AMP_MELANOM_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MELANOM_INVALID AMP_MELANOM_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_HAUTKREBS_REQUIRED AMP_MASSNAHME_HAUTKREBS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_HAUTKREBS_INVALID AMP_MASSNAHME_HAUTKREBS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_HAUTKREBS_INVALID2 AMP_MASSNAHME_HAUTKREBS_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SONSTIGE_AUFFAELLIGE_BEFUNDE_WRONG_FORMAT AMP_SONSTIGE_AUFFAELLIGE_BEFUNDE_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GESUNDES_ZAHNFLEISCH_REQUIRED AMP_GESUNDES_ZAHNFLEISCH_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GESUNDES_ZAHNFLEISCH_INVALID AMP_GESUNDES_ZAHNFLEISCH_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ZAHNSTEIN_REQUIRED AMP_ZAHNSTEIN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ZAHNSTEIN_INVALID AMP_ZAHNSTEIN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ROETUNG_REQUIRED AMP_ROETUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ROETUNG_INVALID AMP_ROETUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PARODONTITIS_REQUIRED AMP_MASSNAHME_PARODONTITIS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PARODONTITIS_INVALID AMP_MASSNAHME_PARODONTITIS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PARADONTITIS_INVALID2 AMP_MASSNAHME_PARADONTITIS_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_CHOL_REQUIRED AMP_CHOL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_CHOL_WRONG_FORMAT AMP_CHOL_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_CHOL_INVALID AMP_CHOL_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HDL_CHOL_REQUIRED AMP_HDL_CHOL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HDL_CHOL_WRONG_FORMAT AMP_HDL_CHOL_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HDL_CHOL_INVALID AMP_HDL_CHOL_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTZUCKER_REQUIRED AMP_BLUTZUCKER_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTZUCKER_WRONG_FORMAT AMP_BLUTZUCKER_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTZUCKER_INVALID AMP_BLUTZUCKER_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_TRIGLYCERIDE_NUECHTERN_REQUIRED AMP_TRIGLYCERIDE_NUECHTERN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_TRIGLYCERIDE_NUECHTERN_WRONG_FORMAT AMP_TRIGLYCERIDE_NUECHTERN_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_TRIGLYCERIDE_NUECHTERN_INVALID AMP_TRIGLYCERIDE_NUECHTERN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GAMMA_GT_REQUIRED AMP_GAMMA_GT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GAMMA_GT_WRONG_FORMAT AMP_GAMMA_GT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GAMMA_GT_INVALID AMP_GAMMA_GT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERY_REQUIRED AMP_ERY_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERY_WRONG_FORMAT AMP_ERY_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERY_INVALID AMP_ERY_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HB_REQUIRED AMP_HB_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HB_WRONG_FORMAT AMP_HB_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HB_INVALID AMP_HB_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HKT_WRONG_FORMAT AMP_HKT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_HKT_INVALID AMP_HKT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_LEUKOZYTEN_REQUIRED AMP_LEUKOZYTEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_LEUKOZYTEN_INVALID AMP_LEUKOZYTEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GLUCOSE_REQUIRED AMP_GLUCOSE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_GLUCOSE_INVALID AMP_GLUCOSE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_NITRIT_REQUIRED AMP_NITRIT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_NITRIT_INVALID AMP_NITRIT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_EIWEISS_REQUIRED AMP_EIWEISS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_EIWEISS_INVALID AMP_EIWEISS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUT_REQUIRED AMP_BLUT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUT_INVALID AMP_BLUT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UBG_REQUIRED AMP_UBG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UBG_INVALID AMP_UBG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_HARNUNTERSUCHUNG_REQUIRED AMP_MASSNAHME_HARNUNTERSUCHUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_HARNUNTERSUCHUNG_INVALID AMP_MASSNAHME_HARNUNTERSUCHUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_HARNUNTERSUCHUNG_INVALID2 AMP_MASSNAHME_HARNUNTERSUCHUNG_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCK1_REQUIRED AMP_BLUTDRUCK1_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCK1_WRONG_FORMAT AMP_BLUTDRUCK1_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCK1_INVALID AMP_BLUTDRUCK1_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCK2_REQUIRED AMP_BLUTDRUCK2_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCK2_WRONG_FORMAT AMP_BLUTDRUCK2_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCK2_INVALID AMP_BLUTDRUCK2_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUTDRUCKSENKENDES_MEDIKAMENT_GENOMMEN_INVALID AMP_BLUTDRUCKSENKENDES_MEDIKAMENT_GENOMMEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BLUTDRUCK_REQUIRED AMP_MASSNAHME_BLUTDRUCK_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BLUTDRUCK_INVALID AMP_MASSNAHME_BLUTDRUCK_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BLUTDRUCK_INVALID2 AMP_MASSNAHME_BLUTDRUCK_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERGROESSE_REQUIRED AMP_KOERPERGROESSE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERGROESSE_WRONG_FORMAT AMP_KOERPERGROESSE_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERGROESSE_INVALID AMP_KOERPERGROESSE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERGEWICHT_REQUIRED AMP_KOERPERGEWICHT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERGEWICHT_WRONG_FORMAT AMP_KOERPERGEWICHT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERGEWICHT_INVALID AMP_KOERPERGEWICHT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_TAILLE_REQUIRED AMP_TAILLE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_TAILLE_INVALID AMP_TAILLE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BMI_REQUIRED AMP_MASSNAHME_BMI_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BMI_INVALID AMP_MASSNAHME_BMI_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BMI_INVALID2 AMP_MASSNAHME_BMI_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERLICHE_BEWEGUNG_REQUIRED AMP_KOERPERLICHE_BEWEGUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOERPERLICHE_BEWEGUNG_INVALID AMP_KOERPERLICHE_BEWEGUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BEWEGUNG_REQUIRED AMP_MASSNAHME_BEWEGUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BEWEGUNG_INVALID AMP_MASSNAHME_BEWEGUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KOERPERLICHE_BEWEGUNG_INVALID2 AMP_MASSNAHME_KOERPERLICHE_BEWEGUNG_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ALKOHOLFRAGEBOGEN_WRONG_FORMAT AMP_ALKOHOLFRAGEBOGEN_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ALKOHOLFRAGEBOGEN_INVALID AMP_ALKOHOLFRAGEBOGEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ALKOHOL_AUFHOERWILLE_VORHANDEN_INVALID AMP_ALKOHOL_AUFHOERWILLE_VORHANDEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ANDERE_VORBEFUNDE_INVALID AMP_ANDERE_VORBEFUNDE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_ALKOHOL_INVALID AMP_MASSNAHME_ALKOHOL_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_ALKOHOL_INVALID2 AMP_MASSNAHME_ALKOHOL_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SICHER_NICHTRAUCHER_REQUIRED AMP_SICHER_NICHTRAUCHER_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SICHER_NICHTRAUCHER_INVALID AMP_SICHER_NICHTRAUCHER_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_RAUCHEN_AUFHOERWILLE_VORHANDEN_REQUIRED AMP_RAUCHEN_AUFHOERWILLE_VORHANDEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_RAUCHEN_AUFHOERWILLE_VORHANDEN_INVALID AMP_RAUCHEN_AUFHOERWILLE_VORHANDEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_RAUCHVERHALTEN_REQUIRED AMP_MASSNAHME_RAUCHVERHALTEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_RAUCHVERHALTEN_INVALID AMP_MASSNAHME_RAUCHVERHALTEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_RAUCHVERHALTEN_INVALID2 AMP_MASSNAHME_RAUCHVERHALTEN_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BESTEHENDER_DIABETES_REQUIRED AMP_BESTEHENDER_DIABETES_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BESTEHENDER_DIABETES_INVALID AMP_BESTEHENDER_DIABETES_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERGEBNIS_REQUIRED AMP_ERGEBNIS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERGEBNIS_INVALID AMP_ERGEBNIS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BLUTZUCKER_REQUIRED AMP_MASSNAHME_BLUTZUCKER_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BLUTZUCKER_INVALID AMP_MASSNAHME_BLUTZUCKER_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_BLUTZUCKER_INVALID2 AMP_MASSNAHME_BLUTZUCKER_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_FAMILIAERE_BELASTUNG_REQUIRED AMP_FAMILIAERE_BELASTUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_FAMILIAERE_BELASTUNG_INVALID AMP_FAMILIAERE_BELASTUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_FAMILIAERE_BELASTUNG_FORBIDDEN AMP_FAMILIAERE_BELASTUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ANAMNESTISCH_WRONG_FORMAT AMP_ANAMNESTISCH_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KARDIO_REQUIRED AMP_MASSNAHME_KARDIO_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KARDIO_INVALID AMP_MASSNAHME_KARDIO_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KARDIO_INVALID2 AMP_MASSNAHME_KARDIO_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ABSTRICH_GEMACHT_REQUIRED AMP_ABSTRICH_GEMACHT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ABSTRICH_GEMACHT_INVALID AMP_ABSTRICH_GEMACHT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ABSTRICH_GEMACHT_FORBIDDEN AMP_ABSTRICH_GEMACHT_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BEFUND_VORHANDEN_INVALID AMP_BEFUND_VORHANDEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BEFUND_VORHANDEN_FORBIDDEN AMP_BEFUND_VORHANDEN_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_PAP_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID AMP_PAP_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_PAP_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN AMP_PAP_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PAP_REQUIRED AMP_MASSNAHME_PAP_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PAP_INVALID AMP_MASSNAHME_PAP_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PAP_FORBIDDEN AMP_MASSNAHME_PAP_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PAP_INVALID2 AMP_MASSNAHME_PAP_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_DURCHGEFUEHRT_INVALID AMP_DURCHGEFUEHRT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_DURCHGEFUEHRT_FORBIDDEN AMP_DURCHGEFUEHRT_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BIRADS_BEFUND_VORHANDEN_INVALID AMP_BIRADS_BEFUND_VORHANDEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BIRADS_BEFUND_VORHANDEN_FORBIDDEN AMP_BIRADS_BEFUND_VORHANDEN_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MAMMOGRAPHIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID AMP_MAMMOGRAPHIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MAMMOGRAPHIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN AMP_MAMMOGRAPHIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_MAMMOGRAPHIE_INVALID AMP_MASSNAHME_MAMMOGRAPHIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_MAMMOGRAPHIE_FORBIDDEN AMP_MASSNAHME_MAMMOGRAPHIE_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_MAMMOGRAPHIE_INVALID2 AMP_MASSNAHME_MAMMOGRAPHIE_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUT_IM_STUHL_REQUIRED AMP_BLUT_IM_STUHL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUT_IM_STUHL_INVALID AMP_BLUT_IM_STUHL_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_BLUT_IM_STUHL_FORBIDDEN AMP_BLUT_IM_STUHL_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_AKTUELLER_BEFUND_REQUIRED AMP_AKTUELLER_BEFUND_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_AKTUELLER_BEFUND_INVALID AMP_AKTUELLER_BEFUND_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_AKTUELLER_BEFUND_FORBIDDEN AMP_AKTUELLER_BEFUND_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_LETZTE_KOLOSKOPIE_REQUIRED AMP_LETZTE_KOLOSKOPIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_LETZTE_KOLOSKOPIE_INVALID AMP_LETZTE_KOLOSKOPIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_LETZTE_KOLOSKOPIE_FORBIDDEN AMP_LETZTE_KOLOSKOPIE_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_REQUIRED AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KOLOSKOPIE_REQUIRED AMP_MASSNAHME_KOLOSKOPIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KOLOSKOPIE_INVALID AMP_MASSNAHME_KOLOSKOPIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KOLOSKOPIE_FORBIDDEN AMP_MASSNAHME_KOLOSKOPIE_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_KOLOSKOPIE_INVALID2 AMP_MASSNAHME_KOLOSKOPIE_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_PROSTATA_AERZTLICHE_BERATUNG_INVALID AMP_PROSTATA_AERZTLICHE_BERATUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_PROSTATA_AERZTLICHE_BERATUNG_FORBIDDEN AMP_PROSTATA_AERZTLICHE_BERATUNG_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PROSTATA_REQUIRED AMP_MASSNAHME_PROSTATA_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PROSTATA_INVALID AMP_MASSNAHME_PROSTATA_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_PROSTATA_FORBIDDEN AMP_MASSNAHME_PROSTATA_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_RISIKO_GLAUKOM_VORHANDEN_REQUIRED AMP_RISIKO_GLAUKOM_VORHANDEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_RISIKO_GLAUKOM_VORHANDEN_INVALID AMP_RISIKO_GLAUKOM_VORHANDEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_RISIKO_GLAUKOM_VORHANDEN_FORBIDDEN AMP_RISIKO_GLAUKOM_VORHANDEN_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UNTERSUCHUNG_GLAUKOM_BIS65_REQUIRED AMP_UNTERSUCHUNG_GLAUKOM_BIS65_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UNTERSUCHUNG_GLAUKOM_BIS65_INVALID AMP_UNTERSUCHUNG_GLAUKOM_BIS65_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UNTERSUCHUNG_GLAUKOM_BIS65_FORBIDDEN AMP_UNTERSUCHUNG_GLAUKOM_BIS65_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_DIABETES_BIS65_REQUIRED AMP_MASSNAHME_DIABETES_BIS65_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_DIABETES_BIS65_INVALID AMP_MASSNAHME_DIABETES_BIS65_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_DIABETES_BIS65_FORBIDDEN AMP_MASSNAHME_DIABETES_BIS65_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SEHVERMOEGEN_KONTROLLIERT_REQUIRED AMP_SEHVERMOEGEN_KONTROLLIERT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SEHVERMOEGEN_KONTROLLIERT_INVALID AMP_SEHVERMOEGEN_KONTROLLIERT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_SEHVERMOEGEN_KONTROLLIERT_FORBIDDEN AMP_SEHVERMOEGEN_KONTROLLIERT_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UNTERSUCHUNG_GLAUKOM_AB65_REQUIRED AMP_UNTERSUCHUNG_GLAUKOM_AB65_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UNTERSUCHUNG_GLAUKOM_AB65_INVALID AMP_UNTERSUCHUNG_GLAUKOM_AB65_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_UNTERSUCHUNG_GLAUKOM_AB65_FORBIDDEN AMP_UNTERSUCHUNG_GLAUKOM_AB65_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_DIABETES_AB65_REQUIRED AMP_MASSNAHME_DIABETES_AB65_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_DIABETES_AB65_INVALID AMP_MASSNAHME_DIABETES_AB65_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_DIABETES_AB65_FORBIDDEN AMP_MASSNAHME_DIABETES_AB65_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERKRANKUNG1_WRONG_FORMAT AMP_ERKRANKUNG1_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERKRANKUNG2_WRONG_FORMAT AMP_ERKRANKUNG2_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ERKRANKUNG3_WRONG_FORMAT AMP_ERKRANKUNG3_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_VERDACHT_GESUNDHEITSPROBLEM_WRONG_FORMAT AMP_VERDACHT_GESUNDHEITSPROBLEM_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_SONSTIGES_REQUIRED AMP_MASSNAHME_SONSTIGES_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_SONSTIGES_INVALID AMP_MASSNAHME_SONSTIGES_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_MASSNAHME_SONSTIGES_INVALID2 AMP_MASSNAHME_SONSTIGES_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#AMP_ABSCHLUSSGESPRAECH_INVALID AMP_ABSCHLUSSGESPRAECH_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID GEBURTSDATUM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	Quittung createDatenblattAllgemeinesProgramm(String dialogId, String cardReaderId, DatenblattAllgemeinesProgramm datenblattAllgemeinesProgramm) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird das Datenblatt 'Dokumentationsblatt Mammographie', nachdem
   * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
   * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *		  ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattMammographie
   *          Daten des zu übertragenden Datenblattes 'Dokumentationsblatt Mammographie'
   * @return Empfangsbestätigung der erfolgreichen Übertragung.
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_ABRECHNUNG_DATA_FAILED CREATE_ABRECHNUNG_DATA_FAILED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#NO_KEYS_FOUND NO_KEYS_FOUND},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_KONSULTATION INVALID_KONSULTATION},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED}
   * @throws DbasEncryptionException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   * @throws DbasInvalidParameterException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DOKUMENT_FOR_SV_PERSON_INVALID DOKUMENT_FOR_SV_PERSON_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_MAMMOGRAPHIE_REQUIRED DATENBLATT_MAMMOGRAPHIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_ANSCHRIFT_REQUIRED MAM_ANSCHRIFT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_ANSCHRIFT_WRONG_FORMAT MAM_ANSCHRIFT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_POSTLEITZAHL_REQUIRED MAM_POSTLEITZAHL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_POSTLEITZAHL_WRONG_FORMAT MAM_POSTLEITZAHL_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_AUFKLAERUNG_REQUIRED MAM_AUFKLAERUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_AUFKLAERUNG_INVALID MAM_AUFKLAERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_KATEGORIE_REQUIRED MAM_KATEGORIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_KATEGORIE_INVALID MAM_KATEGORIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_ERGEBNISINFORMATION_REQUIRED MAM_ERGEBNISINFORMATION_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#MAM_ERGEBNISINFORMATION_INVALID MAM_ERGEBNISINFORMATION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID GEBURTSDATUM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	Quittung createDatenblattMammographie(String dialogId, String cardReaderId, DatenblattMammographie datenblattMammographie) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird das Datenblatt 'Dokumentationsblatt PAP-Abstrich', nachdem
   * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
   * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *		  ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattPapAbstrich
   *          Daten des zu übertragenden Datenblattes 'Dokumentationsblatt PAP-Abstrich'
   * @return Empfangsbestätigung der erfolgreichen Übertragung.
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_ABRECHNUNG_DATA_FAILED CREATE_ABRECHNUNG_DATA_FAILED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#NO_KEYS_FOUND NO_KEYS_FOUND},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_KONSULTATION INVALID_KONSULTATION},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED}
   * @throws DbasEncryptionException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   * @throws DbasInvalidParameterException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DOKUMENT_FOR_SV_PERSON_INVALID DOKUMENT_FOR_SV_PERSON_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_PAP_ABSTRICH_REQUIRED DATENBLATT_PAP_ABSTRICH_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_ANSCHRIFT_REQUIRED PAP_ANSCHRIFT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_ANSCHRIFT_WRONG_FORMAT PAP_ANSCHRIFT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_POSTLEITZAHL_REQUIRED PAP_POSTLEITZAHL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_POSTLEITZAHL_WRONG_FORMAT PAP_POSTLEITZAHL_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_AUFKLAERUNG_REQUIRED PAP_AUFKLAERUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_AUFKLAERUNG_INVALID PAP_AUFKLAERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_QUALITAET_REQUIRED PAP_QUALITAET_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_QUALITAET_INVALID PAP_QUALITAET_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_BEURTEILUNG_REQUIRED PAP_BEURTEILUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_BEURTEILUNG_INVALID PAP_BEURTEILUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_ABSTRICHWIEDERHOLUNG_REQUIRED PAP_ABSTRICHWIEDERHOLUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_ABSTRICHWIEDERHOLUNG_INVALID PAP_ABSTRICHWIEDERHOLUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_PAP_KLASSE_REQUIRED PAP_PAP_KLASSE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_PAP_KLASSE_INVALID PAP_PAP_KLASSE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_MASSNAHME_REQUIRED PAP_MASSNAHME_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_MASSNAHME_INVALID PAP_MASSNAHME_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_BEFUND_REQUIRED PAP_BEFUND_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_BEFUND_INVALID PAP_BEFUND_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_ERGEBNISINFORMATION_REQUIRED PAP_ERGEBNISINFORMATION_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_ERGEBNISINFORMATION_INVALID PAP_ERGEBNISINFORMATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PAP_AUFFAELLIGKEITEN_WRONG_FORMAT PAP_AUFFAELLIGKEITEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID GEBURTSDATUM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	Quittung createDatenblattPapAbstrich(String dialogId, String cardReaderId, DatenblattPapAbstrich datenblattPapAbstrich) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird das Datenblatt 'Befundblatt Koloskopie', nachdem
   * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
   * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *		  ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattKoloskopie
   *          Daten des zu übertragenden Datenblattes 'Befundblatt Koloskopie'
   * @return Empfangsbestätigung der erfolgreichen Übertragung.
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#NO_KEYS_FOUND NO_KEYS_FOUND},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_KONSULTATION INVALID_KONSULTATION},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED}
   * @throws DbasEncryptionException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   * @throws DbasInvalidParameterException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_KOLOSKOPIE_REQUIRED DATENBLATT_KOLOSKOPIE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POSTLEITZAHL_REQUIRED KOL_POSTLEITZAHL_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POSTLEITZAHL_WRONG_FORMAT KOL_POSTLEITZAHL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ORT_WRONG_FORMAT KOL_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KOMMENTAR_WRONG_FORMAT KOL_KOMMENTAR_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SEDIERUNG_ANALGESIE_REQUIRED KOL_SEDIERUNG_ANALGESIE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SEDIERUNG_ANALGESIE_INVALID KOL_SEDIERUNG_ANALGESIE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZOEKUM_ERREICHT_REQUIRED KOL_ZOEKUM_ERREICHT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZOEKUM_ERREICHT_INVALID KOL_ZOEKUM_ERREICHT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GRUND_UNVOLLSTAENDIGE_KOLO_REQUIRED KOL_GRUND_UNVOLLSTAENDIGE_KOLO_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GRUND_UNVOLLSTAENDIGE_KOLO_INVALID KOL_GRUND_UNVOLLSTAENDIGE_KOLO_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GRUND_UNVOLLSTAENDIGE_KOLO_FORBIDDEN KOL_GRUND_UNVOLLSTAENDIGE_KOLO_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MAKROSKOPISCHER_BEFUND_REQUIRED KOL_MAKROSKOPISCHER_BEFUND_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MAKROSKOPISCHER_BEFUND_INVALID KOL_MAKROSKOPISCHER_BEFUND_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MAKROSKOPISCHER_BEFUND_INVALID2 KOL_MAKROSKOPISCHER_BEFUND_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTERVENTIONSPFLICHTIG_REQUIRED KOL_INTERVENTIONSPFLICHTIG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTERVENTIONSPFLICHTIG_INVALID KOL_INTERVENTIONSPFLICHTIG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTER_KOMPLIKATION_JA_REQUIRED KOL_INTER_KOMPLIKATION_JA_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTER_KOMPLIKATION_JA_INVALID KOL_INTER_KOMPLIKATION_JA_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTER_KOMPLIKATION_JA_FORBIDDEN KOL_INTER_KOMPLIKATION_JA_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BEHANDLUNG_REQUIRED KOL_BEHANDLUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BEHANDLUNG_INVALID KOL_BEHANDLUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BEHANDLUNG_FORBIDDEN KOL_BEHANDLUNG_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_AUSGANG_REQUIRED KOL_AUSGANG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_AUSGANG_INVALID KOL_AUSGANG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_AUSGANG_FORBIDDEN KOL_AUSGANG_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_FORM_GROESSE_LOKALISATON_REQUIRED KOL_ANZAHL_FORM_GROESSE_LOKALISATON_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_REQUIRED KOL_ANZAHL_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_INVALID KOL_ANZAHL_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_FORBIDDEN KOL_ANZAHL_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_FORM_REQUIRED KOL_FORM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_FORM_INVALID KOL_FORM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_FORM_FORBIDDEN KOL_FORM_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GROESSE_REQUIRED KOL_GROESSE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GROESSE_INVALID KOL_GROESSE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GROESSE_FORBIDDEN KOL_GROESSE_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_LOKALISATION_REQUIRED KOL_LOKALISATION_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_LOKALISATION_INVALID KOL_LOKALISATION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_LOKALISATION_FORBIDDEN KOL_LOKALISATION_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPEKTOMIE_REQUIRED KOL_POLYPEKTOMIE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPEKTOMIE_INVALID KOL_POLYPEKTOMIE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPEKTOMIE_FORBIDDEN KOL_POLYPEKTOMIE_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZANGENABTRAGUNG_REQUIRED KOL_ZANGENABTRAGUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZANGENABTRAGUNG_INVALID KOL_ZANGENABTRAGUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZANGENABTRAGUNG_FORBIDDEN KOL_ZANGENABTRAGUNG_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_REQUIRED2 KOL_POLYP_ENTFERNT_REQUIRED2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_INVALID KOL_POLYP_ENTFERNT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_FORBIDDEN KOL_POLYP_ENTFERNT_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_FORBIDDEN3 KOL_POLYP_ENTFERNT_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_REQUIRED2 KOL_POLYP_GEBORGEN_REQUIRED2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_INVALID KOL_POLYP_GEBORGEN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_FORBIDDEN KOL_POLYP_GEBORGEN_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_FORBIDDEN3 KOL_POLYP_GEBORGEN_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BIOPSIE_ENTNOMMEN_REQUIRED2 KOL_BIOPSIE_ENTNOMMEN_REQUIRED2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BIOPSIE_ENTNOMMEN_INVALID KOL_BIOPSIE_ENTNOMMEN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BIOPSIE_ENTNOMMEN_FORBIDDEN KOL_BIOPSIE_ENTNOMMEN_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOLOGISCHER_BEFUND_REQUIRED KOL_HISTOLOGISCHER_BEFUND_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_INVALID KOL_POLYP_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_FORBIDDEN KOL_POLYP_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_FORBIDDEN3 KOL_POLYP_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_FORBIDDEN4 KOL_POLYP_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_INVALID KOL_ADENOM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_FORBIDDEN KOL_ADENOM_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_FORBIDDEN3 KOL_ADENOM_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_FORBIDDEN4 KOL_ADENOM_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_REQUIRED KOL_ADENOM_ENTFERNT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_INVALID KOL_ADENOM_ENTFERNT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_FORBIDDEN KOL_ADENOM_ENTFERNT_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_FORBIDDEN3 KOL_ADENOM_ENTFERNT_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_FORBIDDEN4 KOL_ADENOM_ENTFERNT_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_INVALID KOL_HISTOKARZINOM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_FORBIDDEN KOL_HISTOKARZINOM_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_FORBIDDEN3 KOL_HISTOKARZINOM_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_FORBIDDEN4 KOL_HISTOKARZINOM_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_REQUIRED KOL_KARZINOM_ENTFERNT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_INVALID KOL_KARZINOM_ENTFERNT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_FORBIDDEN KOL_KARZINOM_ENTFERNT_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_FORBIDDEN3 KOL_KARZINOM_ENTFERNT_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_FORBIDDEN4 KOL_KARZINOM_ENTFERNT_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_INVALID KOL_SONSTIGES_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_FORBIDDEN KOL_SONSTIGES_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_FORBIDDEN3 KOL_SONSTIGES_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_FORBIDDEN4 KOL_SONSTIGES_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_REQUIRED KOL_DIAGNOSE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_INVALID KOL_DIAGNOSE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_FORBIDDEN KOL_DIAGNOSE_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_INVALID2 KOL_DIAGNOSE_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_INVALID3 KOL_DIAGNOSE_INVALID3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENKONTAKT_VERLOREN_REQUIRED KOL_PATIENTENKONTAKT_VERLOREN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENKONTAKT_VERLOREN_INVALID KOL_PATIENTENKONTAKT_VERLOREN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENKONTAKT_VERLOREN_FORBIDDEN KOL_PATIENTENKONTAKT_VERLOREN_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_REQUIRED KOL_MASSNAHMEN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_INVALID KOL_MASSNAHMEN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_FORBIDDEN KOL_MASSNAHMEN_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_NOT_ALLOWED KOL_MASSNAHMEN_NOT_ALLOWED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_REQUIRED KOL_POLYPENABTRAGUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_INVALID KOL_POLYPENABTRAGUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_FORBIDDEN KOL_POLYPENABTRAGUNG_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_FORBIDDEN2 KOL_POLYPENABTRAGUNG_FORBIDDEN2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_FORBIDDEN3 KOL_POLYPENABTRAGUNG_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_REQUIRED KOL_KONTROLLE_MONATE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_WRONG_FORMAT KOL_KONTROLLE_MONATE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_FORBIDDEN KOL_KONTROLLE_MONATE_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_NOT_ALLOWED KOL_KONTROLLE_MONATE_NOT_ALLOWED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_NOT_ALLOWED2 KOL_KONTROLLE_MONATE_NOT_ALLOWED2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID GEBURTSDATUM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_REQUIRED KOL_DYSPLASIE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_INVALID KOL_DYSPLASIE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN KOL_DYSPLASIE_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN2 KOL_DYSPLASIE_FORBIDDEN2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN4 KOL_DYSPLASIE_FORBIDDEN4},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN5 KOL_DYSPLASIE_FORBIDDEN5},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_VORBEREITUNGSQUALITAET_REQUIRED KOL_VORBEREITUNGSQUALITAET_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_VORBEREITUNGSQUALITAET_INVALID KOL_VORBEREITUNGSQUALITAET_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENZUSTIMMUNG_REQUIRED KOL_PATIENTENZUSTIMMUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENZUSTIMMUNG_INVALID KOL_PATIENTENZUSTIMMUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENZUSTIMMUNG_FORBIDDEN KOL_PATIENTENZUSTIMMUNG_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_UNTERSUCHUNG_REQUIRED KOL_UNTERSUCHUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_UNTERSUCHUNG_INVALID KOL_UNTERSUCHUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_REQUIRED KOL_ANZAHL_ADENOME_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_INVALID KOL_ANZAHL_ADENOME_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN KOL_ANZAHL_ADENOME_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN2 KOL_ANZAHL_ADENOME_FORBIDDEN2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN3 KOL_ANZAHL_ADENOME_FORBIDDEN3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN4 KOL_ANZAHL_ADENOME_FORBIDDEN4}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	Quittung createDatenblattKoloskopie(String dialogId, String cardReaderId, DatenblattKoloskopie datenblattKoloskopie) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

	/**
	 * <p>
	 * Mit dieser Funktion wird das Datenblatt 'Qualitätszertifikat Koloskopie', nachdem
	 * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
	 * </p>
	 * <p>
	 * <b>Voraussetzungen: </b>
	 * <ul>
	 * <li>Funktion
	 * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
	 * wurde erfolgreich ausgeführt.</li>
	 * <li>Der Dialog ist im Online-Modus.</li>
	 * <li>Zugriff auf DBAS
	 *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
	 * </li>
	 * <li>Berechtigung eine 'Qualitätszertifikat Koloskopie' zu erstellen
	 *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_QZK DBAS_QZK}).
	 * </li>
	 * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
	 * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
	 * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
	 * </ul>
	 * </p>
	 *
	 * <p><B>Laufzeitgruppe: </B> Mittel</p>
	 * @param dialogId
	 *          Dialog ID eines aufgebauten Dialogs.
	 * @param cardReaderId
	 *          ID eines g&uuml;ltigen Kartenlesers.
	 * @param datenblattKoloskopie
	 *          Koloskopie-Daten des zu übertragenden Datenblattes 'Qualitätszertifikat Koloskopie'
	 * @param untersuchungsdatum
	 *          Untersuchungsdatum, darf nicht in der zukunft oder vor dem Geburtsdatum liegen.
	 * @param forcedQZ
	 *          true: es findet keine Prüfung auf vorhandene VK-Konsultationen statt
	 *          false: es findet eine Prüfung auf vorhandene VK-Konsultationen statt
	 * @return Empfangsbestätigung der erfolgreichen Übertragung.
	 * @throws DbasException
	 *     {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#NO_KEYS_FOUND NO_KEYS_FOUND},
	 *     {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_KONSULTATION INVALID_KONSULTATION},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#MATCHING_KONSULTATION_FOUND MATCHING_KONSULTATION_FOUND}
	 * @throws DbasEncryptionException
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
	 * @throws DbasInvalidParameterException
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_KOLOSKOPIE_REQUIRED DATENBLATT_KOLOSKOPIE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POSTLEITZAHL_REQUIRED KOL_POSTLEITZAHL_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POSTLEITZAHL_WRONG_FORMAT KOL_POSTLEITZAHL_WRONG_FORMAT},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ORT_WRONG_FORMAT KOL_ORT_WRONG_FORMAT},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KOMMENTAR_WRONG_FORMAT KOL_KOMMENTAR_WRONG_FORMAT},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SEDIERUNG_ANALGESIE_REQUIRED KOL_SEDIERUNG_ANALGESIE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SEDIERUNG_ANALGESIE_INVALID KOL_SEDIERUNG_ANALGESIE_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZOEKUM_ERREICHT_REQUIRED KOL_ZOEKUM_ERREICHT_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZOEKUM_ERREICHT_INVALID KOL_ZOEKUM_ERREICHT_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GRUND_UNVOLLSTAENDIGE_KOLO_REQUIRED KOL_GRUND_UNVOLLSTAENDIGE_KOLO_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GRUND_UNVOLLSTAENDIGE_KOLO_INVALID KOL_GRUND_UNVOLLSTAENDIGE_KOLO_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GRUND_UNVOLLSTAENDIGE_KOLO_FORBIDDEN KOL_GRUND_UNVOLLSTAENDIGE_KOLO_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MAKROSKOPISCHER_BEFUND_REQUIRED KOL_MAKROSKOPISCHER_BEFUND_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MAKROSKOPISCHER_BEFUND_INVALID KOL_MAKROSKOPISCHER_BEFUND_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MAKROSKOPISCHER_BEFUND_INVALID2 KOL_MAKROSKOPISCHER_BEFUND_INVALID2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTERVENTIONSPFLICHTIG_REQUIRED KOL_INTERVENTIONSPFLICHTIG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTERVENTIONSPFLICHTIG_INVALID KOL_INTERVENTIONSPFLICHTIG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTER_KOMPLIKATION_JA_REQUIRED KOL_INTER_KOMPLIKATION_JA_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTER_KOMPLIKATION_JA_INVALID KOL_INTER_KOMPLIKATION_JA_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_INTER_KOMPLIKATION_JA_FORBIDDEN KOL_INTER_KOMPLIKATION_JA_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BEHANDLUNG_REQUIRED KOL_BEHANDLUNG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BEHANDLUNG_INVALID KOL_BEHANDLUNG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BEHANDLUNG_FORBIDDEN KOL_BEHANDLUNG_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_AUSGANG_REQUIRED KOL_AUSGANG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_AUSGANG_INVALID KOL_AUSGANG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_AUSGANG_FORBIDDEN KOL_AUSGANG_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_FORM_GROESSE_LOKALISATON_REQUIRED KOL_ANZAHL_FORM_GROESSE_LOKALISATON_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_REQUIRED KOL_ANZAHL_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_INVALID KOL_ANZAHL_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_FORBIDDEN KOL_ANZAHL_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_FORM_REQUIRED KOL_FORM_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_FORM_INVALID KOL_FORM_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_FORM_FORBIDDEN KOL_FORM_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GROESSE_REQUIRED KOL_GROESSE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GROESSE_INVALID KOL_GROESSE_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_GROESSE_FORBIDDEN KOL_GROESSE_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_LOKALISATION_REQUIRED KOL_LOKALISATION_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_LOKALISATION_INVALID KOL_LOKALISATION_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_LOKALISATION_FORBIDDEN KOL_LOKALISATION_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPEKTOMIE_REQUIRED KOL_POLYPEKTOMIE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPEKTOMIE_INVALID KOL_POLYPEKTOMIE_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPEKTOMIE_FORBIDDEN KOL_POLYPEKTOMIE_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZANGENABTRAGUNG_REQUIRED KOL_ZANGENABTRAGUNG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZANGENABTRAGUNG_INVALID KOL_ZANGENABTRAGUNG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ZANGENABTRAGUNG_FORBIDDEN KOL_ZANGENABTRAGUNG_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_REQUIRED2 KOL_POLYP_ENTFERNT_REQUIRED2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_INVALID KOL_POLYP_ENTFERNT_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_FORBIDDEN KOL_POLYP_ENTFERNT_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_ENTFERNT_FORBIDDEN3 KOL_POLYP_ENTFERNT_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_REQUIRED2 KOL_POLYP_GEBORGEN_REQUIRED2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_INVALID KOL_POLYP_GEBORGEN_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_FORBIDDEN KOL_POLYP_GEBORGEN_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_GEBORGEN_FORBIDDEN3 KOL_POLYP_GEBORGEN_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BIOPSIE_ENTNOMMEN_REQUIRED2 KOL_BIOPSIE_ENTNOMMEN_REQUIRED2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BIOPSIE_ENTNOMMEN_INVALID KOL_BIOPSIE_ENTNOMMEN_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_BIOPSIE_ENTNOMMEN_FORBIDDEN KOL_BIOPSIE_ENTNOMMEN_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOLOGISCHER_BEFUND_REQUIRED KOL_HISTOLOGISCHER_BEFUND_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_INVALID KOL_POLYP_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_FORBIDDEN KOL_POLYP_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_FORBIDDEN3 KOL_POLYP_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYP_FORBIDDEN4 KOL_POLYP_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_INVALID KOL_ADENOM_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_FORBIDDEN KOL_ADENOM_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_FORBIDDEN3 KOL_ADENOM_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_FORBIDDEN4 KOL_ADENOM_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_REQUIRED KOL_ADENOM_ENTFERNT_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_INVALID KOL_ADENOM_ENTFERNT_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_FORBIDDEN KOL_ADENOM_ENTFERNT_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_FORBIDDEN3 KOL_ADENOM_ENTFERNT_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ADENOM_ENTFERNT_FORBIDDEN4 KOL_ADENOM_ENTFERNT_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_INVALID KOL_HISTOKARZINOM_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_FORBIDDEN KOL_HISTOKARZINOM_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_FORBIDDEN3 KOL_HISTOKARZINOM_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_HISTOKARZINOM_FORBIDDEN4 KOL_HISTOKARZINOM_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_REQUIRED KOL_KARZINOM_ENTFERNT_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_INVALID KOL_KARZINOM_ENTFERNT_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_FORBIDDEN KOL_KARZINOM_ENTFERNT_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_FORBIDDEN3 KOL_KARZINOM_ENTFERNT_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KARZINOM_ENTFERNT_FORBIDDEN4 KOL_KARZINOM_ENTFERNT_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_INVALID KOL_SONSTIGES_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_FORBIDDEN KOL_SONSTIGES_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_FORBIDDEN3 KOL_SONSTIGES_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_SONSTIGES_FORBIDDEN4 KOL_SONSTIGES_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_REQUIRED KOL_DIAGNOSE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_INVALID KOL_DIAGNOSE_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_FORBIDDEN KOL_DIAGNOSE_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_INVALID2 KOL_DIAGNOSE_INVALID2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DIAGNOSE_INVALID3 KOL_DIAGNOSE_INVALID3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENKONTAKT_VERLOREN_REQUIRED KOL_PATIENTENKONTAKT_VERLOREN_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENKONTAKT_VERLOREN_INVALID KOL_PATIENTENKONTAKT_VERLOREN_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENKONTAKT_VERLOREN_FORBIDDEN KOL_PATIENTENKONTAKT_VERLOREN_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_REQUIRED KOL_MASSNAHMEN_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_INVALID KOL_MASSNAHMEN_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_FORBIDDEN KOL_MASSNAHMEN_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_MASSNAHMEN_NOT_ALLOWED KOL_MASSNAHMEN_NOT_ALLOWED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_REQUIRED KOL_POLYPENABTRAGUNG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_INVALID KOL_POLYPENABTRAGUNG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_FORBIDDEN KOL_POLYPENABTRAGUNG_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_FORBIDDEN2 KOL_POLYPENABTRAGUNG_FORBIDDEN2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_POLYPENABTRAGUNG_FORBIDDEN3 KOL_POLYPENABTRAGUNG_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_REQUIRED KOL_KONTROLLE_MONATE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_WRONG_FORMAT KOL_KONTROLLE_MONATE_WRONG_FORMAT},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_FORBIDDEN KOL_KONTROLLE_MONATE_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_NOT_ALLOWED KOL_KONTROLLE_MONATE_NOT_ALLOWED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_KONTROLLE_MONATE_NOT_ALLOWED2 KOL_KONTROLLE_MONATE_NOT_ALLOWED2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID4 GEBURTSDATUM_INVALID4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_REQUIRED KOL_DYSPLASIE_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_INVALID KOL_DYSPLASIE_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN KOL_DYSPLASIE_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN2 KOL_DYSPLASIE_FORBIDDEN2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN4 KOL_DYSPLASIE_FORBIDDEN4},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_DYSPLASIE_FORBIDDEN5 KOL_DYSPLASIE_FORBIDDEN5},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_VORBEREITUNGSQUALITAET_REQUIRED KOL_VORBEREITUNGSQUALITAET_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_VORBEREITUNGSQUALITAET_INVALID KOL_VORBEREITUNGSQUALITAET_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENZUSTIMMUNG_REQUIRED KOL_PATIENTENZUSTIMMUNG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENZUSTIMMUNG_INVALID KOL_PATIENTENZUSTIMMUNG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_PATIENTENZUSTIMMUNG_FORBIDDEN KOL_PATIENTENZUSTIMMUNG_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_UNTERSUCHUNG_REQUIRED KOL_UNTERSUCHUNG_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_UNTERSUCHUNG_INVALID KOL_UNTERSUCHUNG_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_REQUIRED KOL_ANZAHL_ADENOME_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_INVALID KOL_ANZAHL_ADENOME_INVALID},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN KOL_ANZAHL_ADENOME_FORBIDDEN},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN2 KOL_ANZAHL_ADENOME_FORBIDDEN2},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN3 KOL_ANZAHL_ADENOME_FORBIDDEN3},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#KOL_ANZAHL_ADENOME_FORBIDDEN4 KOL_ANZAHL_ADENOME_FORBIDDEN4}
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#QZK_UNTERSUCHUNGSDATUM_REQUIRED QZK_UNTERSUCHUNGSDATUM_REQUIRED},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#QZK_UNTERSUCHUNGSDATUM_WRONG_FORMAT QZK_UNTERSUCHUNGSDATUM_WRONG_FORMAT},
	 *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#QZK_UNTERSUCHUNGSDATUM_INVALID QZK_UNTERSUCHUNGSDATUM_INVALID}
	 * @throws AccessException
	 *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE},
	 *     {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_QZK MISSING_DBAS_QZK}
	 * @throws DialogException
	 *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
	 *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
	 *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
	 *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
	 *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
	 *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
	 *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
	 *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
	 * @throws ServiceException
	 *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
	 *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
	 *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
	 */
	Quittung createDatenblattQZKoloskopie(String dialogId, String cardReaderId, DatenblattKoloskopie datenblattKoloskopie, String untersuchungsdatum, Boolean forcedQZ) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird das Datenblatt 'Dokumentationsbogen Therapie Aktiv DM2', nachdem
   * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
   * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *		  ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattDmpDm2
   *          Daten des zu übertragenden Datenblattes 'Dokumentationsbogen Therapie Aktiv DM2'
   * @return Empfangsbestätigung der erfolgreichen Übertragung.
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_ABRECHNUNG_DATA_FAILED CREATE_ABRECHNUNG_DATA_FAILED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#NO_KEYS_FOUND NO_KEYS_FOUND},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#PERSON_NOT_IN_DMP PERSON_NOT_IN_DMP},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#BETREUUNG_INVALID BETREUUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_BETREUUNG INVALID_BETREUUNG}
   * @throws DbasEncryptionException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   * @throws DbasInvalidParameterException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_DMP_DM2_REQUIRED DATENBLATT_DMP_DM2_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DMP_DATENBLATT_UNTERSUCHUNGSDATUM_REQUIRED DMP_DATENBLATT_UNTERSUCHUNGSDATUM_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DMP_DATENBLATT_UNTERSUCHUNGSDATUM_WRONG_FORMAT DMP_DATENBLATT_UNTERSUCHUNGSDATUM_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DMP_DATENBLATT_UNTERSUCHUNGSDATUM_INVALID DMP_DATENBLATT_UNTERSUCHUNGSDATUM_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DIABETES_DIAGNOSE_JAHR_REQUIRED DM2_DIABETES_DIAGNOSE_JAHR_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DIABETES_DIAGNOSE_JAHR_WRONG_FORMAT DM2_DIABETES_DIAGNOSE_JAHR_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DIABETES_DIAGNOSE_JAHR_INVALID DM2_DIABETES_DIAGNOSE_JAHR_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HYPERTONIE_SEIT_JAHR_REQUIRED DM2_HYPERTONIE_SEIT_JAHR_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HYPERTONIE_SEIT_JAHR_WRONG_FORMAT DM2_HYPERTONIE_SEIT_JAHR_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HYPERTONIE_SEIT_JAHR_INVALID DM2_HYPERTONIE_SEIT_JAHR_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_SEIT_JAHR_WRONG_FORMAT DM2_INSULIN_SEIT_JAHR_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_SEIT_JAHR_INVALID DM2_INSULIN_SEIT_JAHR_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_OAD_SEIT_JAHR_WRONG_FORMAT DM2_OAD_SEIT_JAHR_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_OAD_SEIT_JAHR_INVALID DM2_OAD_SEIT_JAHR_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLINDHEIT_REQUIRED DM2_BLINDHEIT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLINDHEIT_INVALID DM2_BLINDHEIT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TERMINALES_NIERENVERSAGEN_REQUIRED DM2_TERMINALES_NIERENVERSAGEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TERMINALES_NIERENVERSAGEN_INVALID DM2_TERMINALES_NIERENVERSAGEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HERZINFARKT_REQUIRED DM2_HERZINFARKT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HERZINFARKT_INVALID DM2_HERZINFARKT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HERZ_BYPASS_DILATATION_REQUIRED DM2_HERZ_BYPASS_DILATATION_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HERZ_BYPASS_DILATATION_INVALID DM2_HERZ_BYPASS_DILATATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_APOPLEXIE_REQUIRED DM2_APOPLEXIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_APOPLEXIE_INVALID DM2_APOPLEXIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_AMPUTATION_REQUIRED DM2_AMPUTATION_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_AMPUTATION_INVALID DM2_AMPUTATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_NEUROPATHIE_REQUIRED DM2_NEUROPATHIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_NEUROPATHIE_INVALID DM2_NEUROPATHIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_ANGINA_PECTORIS_REQUIRED DM2_ANGINA_PECTORIS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_ANGINA_PECTORIS_INVALID DM2_ANGINA_PECTORIS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_CLAUDICATIO_REQUIRED DM2_CLAUDICATIO_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_CLAUDICATIO_INVALID DM2_CLAUDICATIO_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TIAPRIND_REQUIRED DM2_TIAPRIND_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TIAPRIND_INVALID DM2_TIAPRIND_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_SCHWERE_HYPOGLYKAEMIE_REQUIRED DM2_SCHWERE_HYPOGLYKAEMIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_SCHWERE_HYPOGLYKAEMIE_INVALID DM2_SCHWERE_HYPOGLYKAEMIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EREKTILE_DYSFUNKTION_REQUIRED DM2_EREKTILE_DYSFUNKTION_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EREKTILE_DYSFUNKTION_INVALID DM2_EREKTILE_DYSFUNKTION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EREKTILE_DYSFUNKTION_FORBIDDEN DM2_EREKTILE_DYSFUNKTION_FORBIDDEN},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HERZINSUFFIZIENZ_INVALID DM2_HERZINSUFFIZIENZ_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_KHK_INVALID DM2_KHK_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DEPRESSION_INVALID DM2_DEPRESSION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PAVK_INVALID DM2_PAVK_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PAVK_BYPASS_INVALID DM2_PAVK_BYPASS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PAVK_DILATATION_INVALID DM2_PAVK_DILATATION_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INNERHALB12_MONATEN_REQUIRED DM2_INNERHALB12_MONATEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INNERHALB12_MONATEN_INVALID DM2_INNERHALB12_MONATEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_LASERUNG_INVALID DM2_LASERUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RETINOPATHIE_NICHT_PROLIFERATIV_INVALID DM2_RETINOPATHIE_NICHT_PROLIFERATIV_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RETINOPATHIE_PROLIFERATIV_INVALID DM2_RETINOPATHIE_PROLIFERATIV_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RETINOPATHIE_PROLIFERATIV_INVALID2 DM2_RETINOPATHIE_PROLIFERATIV_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_MAKULOPATHIE_INVALID DM2_MAKULOPATHIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_FUSSDEFORMITAET_LINKS_REQUIRED DM2_FUSSDEFORMITAET_LINKS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_FUSSDEFORMITAET_LINKS_INVALID DM2_FUSSDEFORMITAET_LINKS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_FUSSDEFORMITAET_RECHTS_REQUIRED DM2_FUSSDEFORMITAET_RECHTS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_FUSSDEFORMITAET_RECHTS_INVALID DM2_FUSSDEFORMITAET_RECHTS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEHEILTES_ULKUS_LINKS_REQUIRED DM2_GEHEILTES_ULKUS_LINKS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEHEILTES_ULKUS_LINKS_INVALID DM2_GEHEILTES_ULKUS_LINKS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEHEILTES_ULKUS_RECHTS_REQUIRED DM2_GEHEILTES_ULKUS_RECHTS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEHEILTES_ULKUS_RECHTS_INVALID DM2_GEHEILTES_ULKUS_RECHTS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_AKUTES_ULKUS_LINKS_REQUIRED DM2_AKUTES_ULKUS_LINKS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_AKUTES_ULKUS_LINKS_INVALID DM2_AKUTES_ULKUS_LINKS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_AKUTES_ULKUS_RECHTS_REQUIRED DM2_AKUTES_ULKUS_RECHTS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_AKUTES_ULKUS_RECHTS_INVALID DM2_AKUTES_ULKUS_RECHTS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PULS_NICHT_TASTBAR_LINKS_REQUIRED DM2_PULS_NICHT_TASTBAR_LINKS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PULS_NICHT_TASTBAR_LINKS_INVALID DM2_PULS_NICHT_TASTBAR_LINKS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PULS_NICHT_TASTBAR_RECHTS_REQUIRED DM2_PULS_NICHT_TASTBAR_RECHTS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PULS_NICHT_TASTBAR_RECHTS_INVALID DM2_PULS_NICHT_TASTBAR_RECHTS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_VIBRATIONSEMPFINDEN_VERMINDERT_LINKS_REQUIRED DM2_VIBRATIONSEMPFINDEN_VERMINDERT_LINKS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_VIBRATIONSEMPFINDEN_VERMINDERT_LINKS_INVALID DM2_VIBRATIONSEMPFINDEN_VERMINDERT_LINKS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_VIBRATIONSEMPFINDEN_VERMINDERT_RECHTS_REQUIRED DM2_VIBRATIONSEMPFINDEN_VERMINDERT_RECHTS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_VIBRATIONSEMPFINDEN_VERMINDERT_RECHTS_INVALID DM2_VIBRATIONSEMPFINDEN_VERMINDERT_RECHTS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RAUCHEN_REQUIRED DM2_RAUCHEN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RAUCHEN_WRONG_FORMAT DM2_RAUCHEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RAUCHEN_INVALID DM2_RAUCHEN_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RAUCHEN_INVALID2 DM2_RAUCHEN_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EQ_5D_REQUIRED DM2_EQ_5D_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EQ_5D_WRONG_FORMAT DM2_EQ_5D_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EQ_5DVAS_REQUIRED DM2_EQ_5DVAS_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EQ_5DVAS_WRONG_FORMAT DM2_EQ_5DVAS_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_EQ_5DVAS_INVALID DM2_EQ_5DVAS_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEWICHT_REQUIRED DM2_GEWICHT_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEWICHT_WRONG_FORMAT DM2_GEWICHT_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEWICHT_INVALID DM2_GEWICHT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GROESSE_REQUIRED DM2_GROESSE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GROESSE_WRONG_FORMAT DM2_GROESSE_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GROESSE_INVALID DM2_GROESSE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRSYS_RUHEMESSUNG_REQUIRED DM2_RRSYS_RUHEMESSUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRSYS_RUHEMESSUNG_WRONG_FORMAT DM2_RRSYS_RUHEMESSUNG_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRSYS_RUHEMESSUNG_INVALID DM2_RRSYS_RUHEMESSUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRSYS_RUHEMESSUNG_INVALID2 DM2_RRSYS_RUHEMESSUNG_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRDIA_RUHEMESSUNG_REQUIRED DM2_RRDIA_RUHEMESSUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRDIA_RUHEMESSUNG_WRONG_FORMAT DM2_RRDIA_RUHEMESSUNG_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RRDIA_RUHEMESSUNG_INVALID DM2_RRDIA_RUHEMESSUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_HBA_1C_MOL_REQUIRED DM2_HBA_1C_HBA_1C_MOL_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_WRONG_FORMAT DM2_HBA_1C_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_INVALID DM2_HBA_1C_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_MOL_WRONG_FORMAT DM2_HBA_1C_MOL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_MOL_INVALID DM2_HBA_1C_MOL_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_KREATININ_REQUIRED DM2_KREATININ_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_KREATININ_WRONG_FORMAT DM2_KREATININ_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_KREATININ_INVALID DM2_KREATININ_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_CHOLESTERIN_REQUIRED DM2_CHOLESTERIN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_CHOLESTERIN_WRONG_FORMAT DM2_CHOLESTERIN_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_CHOLESTERIN_INVALID DM2_CHOLESTERIN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HDL_CHOLESTERIN_REQUIRED DM2_HDL_CHOLESTERIN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HDL_CHOLESTERIN_WRONG_FORMAT DM2_HDL_CHOLESTERIN_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HDL_CHOLESTERIN_INVALID DM2_HDL_CHOLESTERIN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TRIGLYCERIDE_REQUIRED DM2_TRIGLYCERIDE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TRIGLYCERIDE_WRONG_FORMAT DM2_TRIGLYCERIDE_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TRIGLYCERIDE_INVALID DM2_TRIGLYCERIDE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_MIKROALBUMINURIE_REQUIRED DM2_MIKROALBUMINURIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_MIKROALBUMINURIE_INVALID DM2_MIKROALBUMINURIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PROTEINURIE_WRONG_FORMAT DM2_PROTEINURIE_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_PROTEINURIE_INVALID DM2_PROTEINURIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_NUR_DIAET_REQUIRED DM2_NUR_DIAET_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_NUR_DIAET_INVALID DM2_NUR_DIAET_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_OAD_REQUIRED DM2_OAD_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_OAD_INVALID DM2_OAD_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_REQUIRED DM2_INSULIN_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_INVALID DM2_INSULIN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_ZUSATZ_REQUIRED DM2_INSULIN_ZUSATZ_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_KONVENTIONELL_INVALID DM2_INSULIN_KONVENTIONELL_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_KONVENTIONELL_INVALID2 DM2_INSULIN_KONVENTIONELL_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_KONVENTIONELL_INVALID3 DM2_INSULIN_KONVENTIONELL_INVALID3},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_PRAEPRANDIAL_INVALID DM2_INSULIN_PRAEPRANDIAL_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_PRAEPRANDIAL_INVALID2 DM2_INSULIN_PRAEPRANDIAL_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_PRAEPRANDIAL_INVALID3 DM2_INSULIN_PRAEPRANDIAL_INVALID3},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_INTENSIVIERT_INVALID DM2_INSULIN_INTENSIVIERT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_INTENSIVIERT_INVALID2 DM2_INSULIN_INTENSIVIERT_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_INTENSIVIERT_INVALID3 DM2_INSULIN_INTENSIVIERT_INVALID3},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_NUR_BASAL_INVALID DM2_INSULIN_NUR_BASAL_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_INSULIN_NUR_BASAL_INVALID2 DM2_INSULIN_NUR_BASAL_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTDRUCK_THERAPIE_REQUIRED DM2_BLUTDRUCK_THERAPIE_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTDRUCK_THERAPIE_INVALID DM2_BLUTDRUCK_THERAPIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEWICHT_ZIELVEREINBARUNG_REQUIRED DM2_GEWICHT_ZIELVEREINBARUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_GEWICHT_ZIELVEREINBARUNG_INVALID DM2_GEWICHT_ZIELVEREINBARUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BEWEGUNG_REQUIRED DM2_BEWEGUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BEWEGUNG_INVALID DM2_BEWEGUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TABAK_REQUIRED DM2_TABAK_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_TABAK_INVALID DM2_TABAK_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_ERNAEHRUNG_REQUIRED DM2_ERNAEHRUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_ERNAEHRUNG_INVALID DM2_ERNAEHRUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTDRUCK_ZIELVEREINBARUNG_REQUIRED DM2_BLUTDRUCK_ZIELVEREINBARUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTDRUCK_ZIELVEREINBARUNG_INVALID DM2_BLUTDRUCK_ZIELVEREINBARUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_ZV_HBA_1C_MOL_ZV_REQUIRED DM2_HBA_1C_ZV_HBA_1C_MOL_ZV_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_ZIELVEREINBARUNG_WRONG_FORMAT DM2_HBA_1C_ZIELVEREINBARUNG_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_ZIELVEREINBARUNG_INVALID DM2_HBA_1C_ZIELVEREINBARUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_MOL_ZIELVEREINBARUNG_WRONG_FORMAT DM2_HBA_1C_MOL_ZIELVEREINBARUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HBA_1C_MOL_ZIELVEREINBARUNG_INVALID DM2_HBA_1C_MOL_ZIELVEREINBARUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTDRUCKMESSUNG_REQUIRED DM2_BLUTDRUCKMESSUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTDRUCKMESSUNG_INVALID DM2_BLUTDRUCKMESSUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTZUCKERMESSUNG_REQUIRED DM2_BLUTZUCKERMESSUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_BLUTZUCKERMESSUNG_INVALID DM2_BLUTZUCKERMESSUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HARNZUCKERMESSUNG_REQUIRED DM2_HARNZUCKERMESSUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_HARNZUCKERMESSUNG_INVALID DM2_HARNZUCKERMESSUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_SCHULUNG_REQUIRED DM2_SCHULUNG_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_SCHULUNG_INVALID DM2_SCHULUNG_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_SCHULUNG_INVALID2 DM2_SCHULUNG_INVALID2},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DIABETES_SCHULUNG_WANN_JAHR_REQUIRED DM2_DIABETES_SCHULUNG_WANN_JAHR_REQUIRED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DIABETES_SCHULUNG_WANN_JAHR_WRONG_FORMAT DM2_DIABETES_SCHULUNG_WANN_JAHR_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_DIABETES_SCHULUNG_WANN_JAHR_INVALID DM2_DIABETES_SCHULUNG_WANN_JAHR_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RETINOPATHIE_INVALID DM2_RETINOPATHIE_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DM2_RETINOPATHIE_INVALID2 DM2_RETINOPATHIE_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID3 GEBURTSDATUM_INVALID3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	Quittung createDatenblattDmpDm2(String dialogId, String cardReaderId, DatenblattDmpDm2 datenblattDmpDm2) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion wird das Datenblatt 'Dokumentationsbogen Therapie Aktiv PMI', nachdem
   * dieses erfolgreich validiert wurde, verschlüsselt und an den Server übertragen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * <li>Wenn die Abfrage ohne e-card durchgeführt wird, muss die Sozialversicherungsnummer des Patienten
   * im Datenblatt angegeben werden. Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im Kartenleser,
   * der dem Dialog zugeordnet ist, bzw. der als Attribut angegeben ist, gesteckt sein. </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          ID eines g&uuml;ltigen Kartenlesers.
   * @param datenblattDmpPmi
   *          Daten des zu übertragenden Datenblattes 'Dokumentationsbogen Therapie Aktiv PMI'
   * @return Empfangsbestätigung der erfolgreichen Übertragung.
   * @throws DbasException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#CREATE_QUITTUNG_FAILED CREATE_QUITTUNG_FAILED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_VSNR INVALID_VSNR},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#PERSON_NOT_IN_DMP PERSON_NOT_IN_DMP},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#BETREUUNG_INVALID BETREUUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INVALID_BETREUUNG INVALID_BETREUUNG}
   * @throws DbasEncryptionException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasEncryptionExceptionConstants#ENCRYPTION_ERROR ENCRYPTION_ERROR}
   * @throws DbasInvalidParameterException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_REQUIRED DATENBLATT_VERSIONSNUMMER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_VERSIONSNUMMER_INVALID DATENBLATT_VERSIONSNUMMER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_FORMAT GEBURTSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID2 GEBURTSDATUM_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID3 GEBURTSDATUM_INVALID3},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_DMP_PMI_REQUIRED DATENBLATT_DMP_PMI_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DMP_DATENBLATT_UNTERSUCHUNGSDATUM_REQUIRED DMP_DATENBLATT_UNTERSUCHUNGSDATUM_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DMP_DATENBLATT_UNTERSUCHUNGSDATUM_WRONG_FORMAT DMP_DATENBLATT_UNTERSUCHUNGSDATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DMP_DATENBLATT_UNTERSUCHUNGSDATUM_INVALID DMP_DATENBLATT_UNTERSUCHUNGSDATUM_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ANZAHL_INFARKTE_REQUIRED PMI_ANZAHL_INFARKTE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ANZAHL_INFARKTE_WRONG_FORMAT PMI_ANZAHL_INFARKTE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ANZAHL_INFARKTE_INVALID PMI_ANZAHL_INFARKTE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTER_INFARKT_JAHR_REQUIRED PMI_LETZTER_INFARKT_JAHR_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTER_INFARKT_JAHR_WRONG_FORMAT PMI_LETZTER_INFARKT_JAHR_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTER_INFARKT_JAHR_INVALID PMI_LETZTER_INFARKT_JAHR_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTER_INFARKT_JAHR_FORBIDDEN PMI_LETZTER_INFARKT_JAHR_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INFARKTART_REQUIRED PMI_INFARKTART_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INFARKTART_INVALID PMI_INFARKTART_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INFARKTART_FORBIDDEN PMI_INFARKTART_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INSULT_FAMILIE_REQUIRED PMI_INSULT_FAMILIE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INSULT_FAMILIE_INVALID PMI_INSULT_FAMILIE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HERZINFARKT_FAMILIE_REQUIRED PMI_HERZINFARKT_FAMILIE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HERZINFARKT_FAMILIE_INVALID PMI_HERZINFARKT_FAMILIE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PAVK_REQUIRED PMI_PAVK_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PAVK_INVALID PMI_PAVK_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_AORTACORONAR_BYPASS_REQUIRED PMI_AORTACORONAR_BYPASS_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_AORTACORONAR_BYPASS_WRONG_FORMAT PMI_AORTACORONAR_BYPASS_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_CAROTIS_OP_REQUIRED PMI_CAROTIS_OP_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_CAROTIS_OP_WRONG_FORMAT PMI_CAROTIS_OP_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PERIPHERER_BYPASS_PTA_REQUIRED PMI_PERIPHERER_BYPASS_PTA_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PERIPHERER_BYPASS_PTA_WRONG_FORMAT PMI_PERIPHERER_BYPASS_PTA_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_STENT_REQUIRED PMI_STENT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_STENT_WRONG_FORMAT PMI_STENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTER_STENT_INVALID PMI_LETZTER_STENT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTER_STENT_FORBIDDEN PMI_LETZTER_STENT_FORBIDDEN},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ANGINA_PECTORIS_REQUIRED PMI_ANGINA_PECTORIS_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ANGINA_PECTORIS_WRONG_FORMAT PMI_ANGINA_PECTORIS_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ANGINA_PECTORIS_INVALID PMI_ANGINA_PECTORIS_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HERZINSUFFIZIENZ_REQUIRED PMI_HERZINSUFFIZIENZ_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HERZINSUFFIZIENZ_WRONG_FORMAT PMI_HERZINSUFFIZIENZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HERZINSUFFIZIENZ_INVALID PMI_HERZINSUFFIZIENZ_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INSULT_ANAMNESE_REQUIRED PMI_INSULT_ANAMNESE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_INSULT_ANAMNESE_INVALID PMI_INSULT_ANAMNESE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTE_KARDIOLOGISCHE_REHA_REQUIRED PMI_LETZTE_KARDIOLOGISCHE_REHA_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTE_KARDIOLOGISCHE_REHA_WRONG_FORMAT PMI_LETZTE_KARDIOLOGISCHE_REHA_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_LETZTE_KARDIOLOGISCHE_REHA_INVALID PMI_LETZTE_KARDIOLOGISCHE_REHA_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HYPERTONIE_SEIT_REQUIRED PMI_HYPERTONIE_SEIT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HYPERTONIE_SEIT_WRONG_FORMAT PMI_HYPERTONIE_SEIT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HYPERTONIE_SEIT_INVALID PMI_HYPERTONIE_SEIT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIABETES_SEIT_REQUIRED PMI_DIABETES_SEIT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIABETES_SEIT_WRONG_FORMAT PMI_DIABETES_SEIT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIABETES_SEIT_INVALID PMI_DIABETES_SEIT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIALYSEPFLICHT_SEIT_REQUIRED PMI_DIALYSEPFLICHT_SEIT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIALYSEPFLICHT_SEIT_WRONG_FORMAT PMI_DIALYSEPFLICHT_SEIT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIALYSEPFLICHT_SEIT_INVALID PMI_DIALYSEPFLICHT_SEIT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_RAUCHEN_SEIT_REQUIRED PMI_RAUCHEN_SEIT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_RAUCHEN_SEIT_WRONG_FORMAT PMI_RAUCHEN_SEIT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_RAUCHEN_SEIT_INVALID PMI_RAUCHEN_SEIT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ZIGARETTEN_PRO_TAG_REQUIRED PMI_ZIGARETTEN_PRO_TAG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ZIGARETTEN_PRO_TAG_WRONG_FORMAT PMI_ZIGARETTEN_PRO_TAG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ZIGARETTEN_PRO_TAG_INVALID PMI_ZIGARETTEN_PRO_TAG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GEWICHT_BEFUND_REQUIRED PMI_GEWICHT_BEFUND_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GEWICHT_BEFUND_WRONG_FORMAT PMI_GEWICHT_BEFUND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GEWICHT_BEFUND_INVALID PMI_GEWICHT_BEFUND_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GROESSE_REQUIRED PMI_GROESSE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GROESSE_WRONG_FORMAT PMI_GROESSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GROESSE_INVALID PMI_GROESSE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BAUCHUMFANG_REQUIRED PMI_BAUCHUMFANG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BAUCHUMFANG_WRONG_FORMAT PMI_BAUCHUMFANG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BAUCHUMFANG_INVALID PMI_BAUCHUMFANG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_BEFUND_REQUIRED PMI_BLUTDRUCK_SYS_BEFUND_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_BEFUND_WRONG_FORMAT PMI_BLUTDRUCK_SYS_BEFUND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_BEFUND_INVALID PMI_BLUTDRUCK_SYS_BEFUND_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_BEFUND_INVALID2 PMI_BLUTDRUCK_SYS_BEFUND_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_DIA_BEFUND_REQUIRED PMI_BLUTDRUCK_DIA_BEFUND_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_DIA_BEFUND_WRONG_FORMAT PMI_BLUTDRUCK_DIA_BEFUND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_DIA_BEFUND_INVALID PMI_BLUTDRUCK_DIA_BEFUND_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_MESSART_REQUIRED PMI_BLUTDRUCK_MESSART_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_MESSART_INVALID PMI_BLUTDRUCK_MESSART_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_CHOLESTERIN_REQUIRED PMI_CHOLESTERIN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_CHOLESTERIN_WRONG_FORMAT PMI_CHOLESTERIN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_CHOLESTERIN_INVALID PMI_CHOLESTERIN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HDL_CHOLESTERIN_REQUIRED PMI_HDL_CHOLESTERIN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HDL_CHOLESTERIN_WRONG_FORMAT PMI_HDL_CHOLESTERIN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_HDL_CHOLESTERIN_INVALID PMI_HDL_CHOLESTERIN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_TRIGLYCERIDE_REQUIRED PMI_TRIGLYCERIDE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_TRIGLYCERIDE_WRONG_FORMAT PMI_TRIGLYCERIDE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_TRIGLYCERIDE_INVALID PMI_TRIGLYCERIDE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_EQ_5D_REQUIRED PMI_EQ_5D_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_EQ_5D_WRONG_FORMAT PMI_EQ_5D_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_EQ_5DVAS_REQUIRED PMI_EQ_5DVAS_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_EQ_5DVAS_WRONG_FORMAT PMI_EQ_5DVAS_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_EQ_5DVAS_INVALID PMI_EQ_5DVAS_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DEPRESSIONSSCORE_WRONG_FORMAT PMI_DEPRESSIONSSCORE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DEPRESSIONSSCORE_INVALID PMI_DEPRESSIONSSCORE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GESAMTSCORE_WRONG_FORMAT PMI_GESAMTSCORE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GESAMTSCORE_INVALID PMI_GESAMTSCORE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIABETIKER_HBA1C_NICHTDIABETIKER_NUECHTERN_BZ_WERT_REQUIRED PMI_DIABETIKER_HBA1C_NICHTDIABETIKER_NUECHTERN_BZ_WERT_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIABETIKER_HBA1C_WRONG_FORMAT PMI_DIABETIKER_HBA1C_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_DIABETIKER_HBA1C_INVALID PMI_DIABETIKER_HBA1C_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_NICHTDIABETIKER_NUECHTERN_BZ_WERT_WRONG_FORMAT PMI_NICHTDIABETIKER_NUECHTERN_BZ_WERT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_NICHTDIABETIKER_NUECHTERN_BZ_WERT_INVALID PMI_NICHTDIABETIKER_NUECHTERN_BZ_WERT_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BETABLOCKER_REQUIRED PMI_BETABLOCKER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BETABLOCKER_INVALID PMI_BETABLOCKER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BETABLOCKER_KONTRAINDIAKTION_INVALID PMI_BETABLOCKER_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ACEHEMMER_REQUIRED PMI_ACEHEMMER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ACEHEMMER_INVALID PMI_ACEHEMMER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ACEHEMMER_KONTRAINDIAKTION_INVALID PMI_ACEHEMMER_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_AT_II_ANTAGONISTEN_REQUIRED PMI_AT_II_ANTAGONISTEN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_AT_II_ANTAGONISTEN_INVALID PMI_AT_II_ANTAGONISTEN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_AT_II_ANTAGONISTEN_KONTRAINDIAKTION_INVALID PMI_AT_II_ANTAGONISTEN_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_STATINE_REQUIRED PMI_STATINE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_STATINE_INVALID PMI_STATINE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_STATINE_KONTRAINDIAKTION_INVALID PMI_STATINE_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ASS_REQUIRED PMI_ASS_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ASS_INVALID PMI_ASS_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ASS_KONTRAINDIAKTION_INVALID PMI_ASS_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_SONSTIGE_TAH_REQUIRED PMI_SONSTIGE_TAH_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_SONSTIGE_TAH_INVALID PMI_SONSTIGE_TAH_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_SONSTIGE_TAH_KONTRAINDIAKTION_INVALID PMI_SONSTIGE_TAH_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_NITRATE_MOLSIDOMIN_REQUIRED PMI_NITRATE_MOLSIDOMIN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_NITRATE_MOLSIDOMIN_INVALID PMI_NITRATE_MOLSIDOMIN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_NITRATE_MOLSIDOMIN_KONTRAINDIAKTION_INVALID PMI_NITRATE_MOLSIDOMIN_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KALZIUMKANAL_BLOCKER_REQUIRED PMI_KALZIUMKANAL_BLOCKER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KALZIUMKANAL_BLOCKER_INVALID PMI_KALZIUMKANAL_BLOCKER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KALZIUMKANAL_BLOCKER_KONTRAINDIAKTION_INVALID PMI_KALZIUMKANAL_BLOCKER_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KALIUMKANAL_OEFFNER_REQUIRED PMI_KALIUMKANAL_OEFFNER_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KALIUMKANAL_OEFFNER_INVALID PMI_KALIUMKANAL_OEFFNER_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KALIUMKANAL_OEFFNER_KONTRAINDIAKTION_INVALID PMI_KALIUMKANAL_OEFFNER_KONTRAINDIAKTION_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_REQUIRED PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_WRONG_FORMAT  PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_INVALID PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_INVALID2 PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_INVALID2},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_REQUIRED PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_WRONG_FORMAT PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_INVALID PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ERNAEHRUNG_REQUIRED PMI_ERNAEHRUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ERNAEHRUNG_INVALID PMI_ERNAEHRUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BEWEGUNG_REQUIRED PMI_BEWEGUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_BEWEGUNG_INVALID PMI_BEWEGUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GEWICHT_ZIELVEREINBARUNG_REQUIRED PMI_GEWICHT_ZIELVEREINBARUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GEWICHT_ZIELVEREINBARUNG_INVALID PMI_GEWICHT_ZIELVEREINBARUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_TABAK_REQUIRED PMI_TABAK_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_TABAK_INVALID PMI_TABAK_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GRIPPEIMPFUNG_ZIELVEREINBARUNG_REQUIRED PMI_GRIPPEIMPFUNG_ZIELVEREINBARUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GRIPPEIMPFUNG_ZIELVEREINBARUNG_INVALID PMI_GRIPPEIMPFUNG_ZIELVEREINBARUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ERNAEHRUNGS_BERATUNG_REQUIRED PMI_ERNAEHRUNGS_BERATUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_ERNAEHRUNGS_BERATUNG_INVALID PMI_ERNAEHRUNGS_BERATUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KOERPERLICHE_AKTIVITAETEN_REQUIRED PMI_KOERPERLICHE_AKTIVITAETEN_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_KOERPERLICHE_AKTIVITAETEN_INVALID PMI_KOERPERLICHE_AKTIVITAETEN_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_RAUCHERBERATUNG_ENTWOEHNUNG_REQUIRED PMI_RAUCHERBERATUNG_ENTWOEHNUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_RAUCHERBERATUNG_ENTWOEHNUNG_INVALID PMI_RAUCHERBERATUNG_ENTWOEHNUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GRIPPEIMPFUNG_REQUIRED PMI_GRIPPEIMPFUNG_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_GRIPPEIMPFUNG_INVALID PMI_GRIPPEIMPFUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_UEBERWEISUNG_INTERNIST_KARDIOLOGE_REQUIRED PMI_UEBERWEISUNG_INTERNIST_KARDIOLOGE_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_UEBERWEISUNG_INTERNIST_KARDIOLOGE_INVALID PMI_UEBERWEISUNG_INTERNIST_KARDIOLOGE_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_UEBERWEISUNG_INTERN_KARDIOL_AMBULANZ_REQUIRED PMI_UEBERWEISUNG_INTERN_KARDIOL_AMBULANZ_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_UEBERWEISUNG_INTERN_KARDIOL_AMBULANZ_INVALID PMI_UEBERWEISUNG_INTERN_KARDIOL_AMBULANZ_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_UEBERWEISUNG_STATIONAERE_AUFNAHME_REQUIRED PMI_UEBERWEISUNG_STATIONAERE_AUFNAHME_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_UEBERWEISUNG_STATIONAERE_AUFNAHME_INVALID PMI_UEBERWEISUNG_STATIONAERE_AUFNAHME_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PMI_SCHULUNG_INVALID PMI_PMI_SCHULUNG_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PMI_SCHULUNG_WANN_JAHR_REQUIRED PMI_PMI_SCHULUNG_WANN_JAHR_REQUIRED},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PMI_SCHULUNG_WANN_JAHR_FORMAT PMI_PMI_SCHULUNG_WANN_JAHR_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PMI_SCHULUNG_WANN_JAHR_INVALID PMI_PMI_SCHULUNG_WANN_JAHR_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#PMI_PMI_SCHULUNG_WANN_JAHR_FORBIDDEN PMI_PMI_SCHULUNG_WANN_JAHR_FORBIDDEN}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
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
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Quittung createDatenblattDmpPmi(String dialogId, String cardReaderId, DatenblattDmpPmi datenblattDmpPmi) throws AccessException, DialogException, ServiceException, CardException, DbasException, DbasEncryptionException, DbasInvalidParameterException;

  /**
   * <p>
   * Mit dieser Funktion werden die Empfangsbestätigungen übertragener Datenblätter, die die
   * Suchkriterien erfüllen, vom Server abgeholt.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param suchkriterien
   *          Suchkriterien zur Einschränkung des Ergebnisses.
   * @return Liste der gefundenen Empfangsbestätigungen übertragener Datenblätter
   * @throws DbasException
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   * @throws DbasInvalidParameterException
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#DATENBLATT_TYP_INVALID DATENBLATT_TYP_INVALID},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#VON_DATUM_WRONG_FORMAT VON_DATUM_WRONG_FORMAT},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#BIS_DATUM_WRONG_FORMAT BIS_DATUM_WRONG_FORMAT},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#VON_DATUM_VOR_BIS_DATUM VON_DATUM_VOR_BIS_DATUM},
   *           {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SVT_INVALID SVT_INVALID},
   *		   {@link at.chipkarte.client.dbas.soap.constants.DbasInvalidParameterExceptionConstants#SUCHKRITERIEN_REQUIRED SUCHKRITERIEN_REQUIRED}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
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
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
	Quittung[] searchQuittungen(String dialogId, QuittungSearchCriteria suchkriterien) throws AccessException, DialogException, ServiceException, DbasException, DbasInvalidParameterException;

  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des DBAS zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf DBAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DBAS_CORE DBAS_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *           Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *           Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DBAS_CORE MISSING_DBAS_CORE}
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
  public Property[] checkStatus(String dialogId) throws DialogException, AccessException, ServiceException;
}
