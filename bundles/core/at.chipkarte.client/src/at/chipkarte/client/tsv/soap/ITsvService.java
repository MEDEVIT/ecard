/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.tsv.soap;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.tsv.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.tsv.soap.exceptions.SchulungException;

/**
 * Dieses Service stellt die Funktionalitäten der Testszenarienverwaltung (TSV) zur Verfügung.
 */
public interface ITsvService {
  /**
   * Diese Funktion liefert den Systemstatus des TSV Systems zurück.
   * 
   * <p>
   * <B>Voraussetzung : </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf TSV
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#TSV_CORE TSV_CORE}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @param dialogId
   *            Dialog-Id eines aufgebauten Dialogs
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *             Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *             Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   *             Im Falle eines nicht konfigurierten KSE Service wird auch OFFLINE als Modus gesetzt. 
   *             Dann sind auch keine Offline-Funktionen möglich.
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_TSV_CORE MISSING_TSV_CORE}
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
   
  Property[] checkStatus(String dialogId) throws AccessException, ServiceException, DialogException, SchulungException;

  /**
   * 
   * Diese Funktion ermittelt die verfügbaren Schulungsszenarien. 
   * 
   * <p>
   * <B>Voraussetzung : </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Die Authentifizierung des Dialogs ist mit Systemtype
   * {@link at.chipkarte.client.base.soap.constants.SystemType#SCHULUNG SCHULUNG} erfolgt.</li>
   * <li>Zugriff auf TSV
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#TSV_CORE TSV_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId Dialog-Id eines aufgebauten Dialogs
   * @return Liste mit den IDs der verfügbaren Schulungsszenarien oder null, wenn keine
   *         Schulungsszenarien verfügbar sind. <br>
   *         Format: maximal 10-stellig
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_TSV_CORE MISSING_TSV_CORE}
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
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
   * @throws SchulungException
   *             {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants#NO_SCENARIO_FOUND NO_SCENARIO_FOUND}
   */
  String[] getSchulungsszenarien(String dialogId) throws DialogException, ServiceException, SchulungException, AccessException;

  /**
   * 
   * Diese Funktion weist der gesteckten Schulungskarte ein bestimmtes Schulungsszenario zu. <br>
   * Die Funktion wird im Offline Modus nicht unterstützt. 
   *   
   * 
   * <p>
   * <B>Voraussetzung : </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Die Authentifizierung des Dialogs ist mit Systemtype
   * {@link at.chipkarte.client.base.soap.constants.SystemType#SCHULUNG SCHULUNG} erfolgt.</li>
   * <li>eine gültige Schulungs e-card ist im dem Dialog zugeordneten Kartenleser gesteckt.</li>
   * <li>Zugriff auf TSV
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#TSV_CORE TSV_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p>
   * <b>Anmerkung:</b>&nbsp;
   * Wenn der gesteckten Schulungs e-card bereits ein Schulungsszenario zugeordnet ist, 
   * wird diese Zuordnung aufgehoben und es werden sämtliche Konsultationen, die mit diesem 
   * Szenario durchgeführt wurden, gelöscht.
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId Dialog-Id eines aufgebauten Dialogs
   * @param szenarioId Id des Schulungsszenarios, siehe auch
   *          {@link #getSchulungsszenarien getSchulungsszenarien}
   * @param fachgebietsCode Fachgebietscode für das Schulungsszenario
   * @param cardReaderId Identifizierer des Kartenlesers 
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_TSV_CORE MISSING_TSV_CORE}
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
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
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws InvalidParameterException
   *             {@link at.chipkarte.client.tsv.soap.constants.InvalidParameterExceptionConstants#INVALID_FG INVALID_FG},
   *             {@link at.chipkarte.client.tsv.soap.constants.InvalidParameterExceptionConstants#ILLEGAL_VALUE ILLEGAL_VALUE}
   * @throws CardException
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws SchulungException
   *             {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants#SCHULUNGS_ECARD_NOT_AVAIL SCHULUNGS_ECARD_NOT_AVAIL},
   *             {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants#SELECTED_SCENARIO_NOT_AVAIL SELECTED_SCENARIO_NOT_AVAIL}
   */
  void setSchulungsszenario(String dialogId, String szenarioId, String fachgebietsCode, String cardReaderId) throws DialogException,
      ServiceException, CardException, InvalidParameterException, SchulungException, AccessException;

  /**
   * Diese Funktion löscht Konsultationen, die nach dem Zuweisen eines Szenarios
   * zu einer Schulungskarte durchgeführt werden (das Szenario selbst bleibt
   * der Schulungskarte zugewiesen).
   * 
   * <p>
   * <B>Voraussetzung : </B> <br>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgeführt.</li>
   * <li>eine gültige Schulungs e-card ist im dem Dialog zugeordneten
   * Kartenleser gesteckt.</li>
   * <li>es wurde im gleichen Dialog zuvor ein Schulungsszenario zugeordnet, siehe Funktion 
   * {@link #setSchulungsszenario(String, String, String) setSchulungsszenario}.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Die Authentifizierung des Dialogs ist mit Systemtype
   * {@link at.chipkarte.client.base.soap.constants.SystemType#SCHULUNG SCHULUNG}
   * erfolgt.</li>
   * <li>Zugriff auf TSV
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#TSV_CORE TSV_CORE}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *            Dialog-Id eines aufgebauten Dialogs
   * @param cardReaderId Identifizierer des Kartenlesers 
   * @throws AccessException
   *             {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_TSV_CORE MISSING_TSV_CORE}
   * @throws ServiceException
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
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
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *             {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   * @throws CardException
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *             {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws SchulungException
   *             {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants#SCHULUNGS_ECARD_NOT_AVAIL SCHULUNGS_ECARD_NOT_AVAIL},
   *             {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants#SELECTED_SCENARIO_NOT_AVAIL SELECTED_SCENARIO_NOT_AVAIL}
   * 
   */
  void deleteSchulungsdaten(String dialogId, String cardReaderId) throws DialogException, ServiceException, CardException,
      SchulungException, AccessException;
  
}
