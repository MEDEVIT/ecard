/*
 * (C) SVC 2011
 */
package at.chipkarte.client.prop.soap;

import javax.activation.DataHandler;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.prop.soap.exceptions.PropException;
import at.chipkarte.client.prop.soap.exceptions.PropInvalidParameterException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten der präoperativen Befundung bei elektiven Operationen (PROP) zur Verfügung.
 * </p>
 */
public interface IPropService {
  /**
   * <p>
   * Diese Funktion liefert die Patientendaten für den (mit SV-Nummer oder gesteckter eCard identifizierten) Patienten.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B>Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *           ID eines Kartenlesers.
   * @param svNummer
   *           SV-Nummer des Patienten.
   * @return Patientendaten<br>
   * @throws PropException
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_SV_NUMMER INVALID_SV_NUMMER}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT INVALID_CARD_LOST_STOLEN_CHECK_PATIENT}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_CARD_CHECK_PATIENT INVALID_CARD_CHECK_PATIENT}
   * @throws PropInvalidParameterException
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  PatientData searchSvPatientData(String dialogId, String cardReaderId, String svNummer)
  throws PropInvalidParameterException, PropException, DialogException, AccessException, CardException, ServiceException;

  /**
   * <p>
   * Erstellt einen Präoperativen Befund anhand der übergebenen Anamnesedaten
   * (falls <code>save == true</code>, wird der Befund auch gespeichert).
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *           ID eines Kartenlesers.
   * @param anamnese
   *           Anamnese.
   * @param save
   *           falls <code>true</code>, wird der Befund gespeichert.
   *           
   * @param befundkommentare
   *            Erfasste Kommentare zu den zuvor ermittelten Befund (mittels Aufruf dieser Funktion mit save gleich false).
   * @return Befund<br>
   * @throws PropException
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_SV_NUMMER INVALID_SV_NUMMER}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_KONSULTATION INVALID_KONSULTATION}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_FACHINFORMATION_VERSION INVALID_FIACHINFORMATION_VERSION}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_CARD_LOST_STOLEN_CHECK_PATIENT INVALID_CARD_LOST_STOLEN_CHECK_PATIENT}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_CARD_CHECK_PATIENT INVALID_CARD_CHECK_PATIENT}
   * @throws PropInvalidParameterException
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SVNR_MISSING_NO_ECARD SVNR_MISSING_NO_ECARD}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#KONSULTATION_INVALID KONSULTATION_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#FACHINFORMATION_VERSION_REQUIRED FACHINFORMATION_VERSION_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#FACHINFORMATION_VERSION_INVALID FACHINFORMATION_VERSION_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#ANAMNESE_REQUIRED ANAMNESE_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#ANAMNESE_DATA_REQUIRED ANAMNESE_DATA_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#ANAMNESE_DATA_PARAMETER_INVALID ANAMNESE_DATA_PARAMETER_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOGRUPPE_REQUIRED RISIKOGRUPPE_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOFAKTOR_NOT_ALLOWED RISIKOFAKTOR_NOT_ALLOWED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOGRUPPE_RISIKOFAKTOR_NOT_SET RISIKOGRUPPE_RISIKOFAKTOR_NOT_SET}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOGRUPPE_SET_SEVERAL_TIMES RISIKOGRUPPE_SET_SEVERAL_TIMES}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOGRUPPE_CODE_REQUIRED RISIKOGRUPPE_CODE_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOFAKTOR_CODE_REQUIRED RISIKOFAKTOR_CODE_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOFAKTOR_SET_SEVERAL_TIMES RISIKOFAKTOR_SET_SEVERAL_TIMES}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#RISIKOGRUPPE_RISIKOFAKTOR_REQUIRED RISIKOGRUPPE_RISIKOFAKTOR_REQUIRED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#TOO_MANY_RISIKOFAKTOR_FOR_RISIKOGRUPPE TOO_MANY_RISIKOFAKTOR_FOR_RISIKOGRUPPE}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#BEFUND_WITH_KONS_NOT_ALLOWED BEFUND_WITH_KONS_NOT_ALLOWED}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Befund createBefund(String dialogId, String cardReaderId, Anamnese anamnese, Boolean save, BefundKommentare befundkommentare)
  throws PropInvalidParameterException, PropException, DialogException, AccessException, CardException, ServiceException;

  /**
   * <p>
   * Holt die Referenzdaten der Präoperativen Befunde, die den Suchkriterien entsprechen, vom Server.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param svNummer
   *           SV-Nummer des Patienten.
   * @param kennung
   *           Patienteneindeutige Kennung des PROP Befundes (eindeutig nur in Verbindung mit VSNR des jeweiligen Patienten).
   * @param vonDatum
   *           falls gesetzt, wird die Suche auf Befunde eingeschränkt, die nach diesem Datum erstellt wurden. Format TTMMJJJJ.
   * @param bisDatum
   *           falls gesetzt, wird die Suche auf Befunde eingeschränkt, die vor diesem Datum erstellt wurden. Format TTMMJJJJ.
   * @param vorname
   *            Vorname des Patienten zu dem Befunde gesucht werden sollen.
   * @param zuname
   *            Familienname des Patienten zu dem Befunde gesucht werden sollen.
   * @return Referenzen auf selbst erstellte Präoperative Befunde<br>
   *
   * @throws PropException
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_SV_NUMMER INVALID_SV_NUMMER}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_VON_DATUM INVALID_VON_DATUM}
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_BIS_DATUM INVALID_BIS_DATUM}
   * @throws PropInvalidParameterException
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#KENNUNG_WRONG_FORMAT KENNUNG_WRONG_FORMAT}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#VON_DATUM_WRONG_FORMAT VON_DATUM_WRONG_FORMAT}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#BIS_DATUM_WRONG_FORMAT BIS_DATUM_WRONG_FORMAT}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#VON_DATUM_VOR_BIS_DATUM VON_DATUM_VOR_BIS_DATUM}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#VON_BIS_DATUM_INVALID VON_BIS_DATUM_INVALID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BefundReferenz[] searchBefunde(String dialogId, String svNummer, String kennung, String vonDatum, String bisDatum, 
                                  String vorname, String zuname)
  throws PropInvalidParameterException, PropException, DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Holt den Präoperativen Befund, der den Suchkriterien entspricht, vom Server.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param svNummer
   *           SV-Nummer des Patienten.
   * @param kennung
   *           Patienteneindeutige Kennung des PROP Befundes (eindeutig nur in Verbindung mit VSNR des jeweiligen Patienten).
   *         
   * @param protokollnummer
   *            Eindeutige Kennung des PROP Befundes. 9 (Befund für einen Patienten ohne SV-Nummer) oder 16 stellig (Befund für einen Patienten mit SV-Nummer).

   * @return Präoperativer Befund<br>
   *
   * @throws PropException
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_SV_NUMMER INVALID_SV_NUMMER}
   * @throws PropInvalidParameterException
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#KENNUNG_WRONG_FORMAT KENNUNG_WRONG_FORMAT}
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SV_NUMMER_KENNUNG_REQUIRED SV_NUMMER_KENNUNG_REQUIRED}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Befund searchBefundByIdentifier(String dialogId, String svNummer, String kennung, String protokollnummer)
  throws PropInvalidParameterException, PropException, DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Retourniert Patienten-Fragebogen in der gewählten Sprache als SOAP-Attachment (PDF-Datei).
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param spracheCode
   *           Code für die Sprache, in der der Patientenfragebogen geliefert werden soll
   *           (siehe {@link #getPatientenfragebogenSprachenFachinformation(String)}).
   *
   * @throws PropInvalidParameterException
   *           {@link at.chipkarte.client.prop.soap.constants.PropInvalidParameterExceptionConstants#SPRACHE_CODE_INVALID SPRACHE_CODE_INVALID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  DataHandler getPatientenfragebogen(String dialogId, String spracheCode)
  throws PropInvalidParameterException, PropException, DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Retourniert die Anamnese-Fachinformation.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @return
   *           Anamnese-Fachinformation
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Fachinformation getAnamneseFachinformation(String dialogId) throws PropException, PropInvalidParameterException,
  DialogException, AccessException, ServiceException, PropException, PropInvalidParameterException;

  /**
   * <p>
   * Retourniert die Sprache-Fachinformation (gültige Werte für den Parameter <code>spracheCode</code>
   * der Funktion {@link #getPatientenfragebogenSprachenFachinformation(String)}).
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @return
   *           Liste von Sprachen-Codes.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  SprachePatientenfragebogen[] getPatientenfragebogenSprachenFachinformation(String dialogId)
  throws  PropException, PropInvalidParameterException, DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Retourniert die Codes der für PROP relevanten verrechnungszuständigen Träger.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @return
   *           Liste von SVT-Codes.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  String[] getPropSvts(String dialogId) throws  PropException, PropInvalidParameterException, DialogException, AccessException, ServiceException;
                                                

  /**
   * <p>
   * Retourniert die für PROP relevanten Fachgebiete sowie die zugehörigen Behandlungsfälle.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @param fachgebiet
   *           Code des Fachgebiets.
   *
   * @throws PropException
   *           {@link at.chipkarte.client.prop.soap.constants.PropExceptionConstants#INVALID_FACHGEBIET INVALID_FACHGEBIET}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR}
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  PropFachgebiet[] getPropFgsAndRelatedBfs(String dialogId, String fachgebiet)
  throws  PropException, PropInvalidParameterException, DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des PROP zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf PROP
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#PROP_CORE PROP_CORE}).
   * </li>
   * </ul>
   * </p>
   *
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @param dialogId
   *           Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *           Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *           Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_PROP_CORE MISSING_PROP_CORE}
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
}
