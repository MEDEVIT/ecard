/*
 * (C) SVC 2011
 */
package at.chipkarte.client.sas.soap;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException;
import at.chipkarte.client.sas.soap.exceptions.SasException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des SV-Nummern-Abfrage-Service (SAS) zur Verfügung.
 * </p>
 */
public interface ISasService {

  /**
   * <p>
   * Diese Funktion führt eine SV-Nummern-Abfrage durch. Dabei wird die SV-Nummer einer SV-Person anhand der übergebenen
   * Suchkriterien in der e-card-Datenbank gesucht.
   * </p>
   * <p>
   * Es wird nur dann ein Ergebnis zurückgeliefert, wenn die Suchkriterien exakt mit den Daten der SV-Person in der Datenbank
   * übereinstimmen, wobei folgende Ausnahmen gelten:
   * <ul>
   * <li>Die erlaubten Trennzeichen werden als äquivalent betrachtet (z.B. findet "Hans Peter" auch "Hans-Peter").</li>
   * <li>Die Groß-/Kleinschreibung wird ignoriert (z.B. findet "mayer" auch "Mayer").</li>
   * </ul>
   * </p>
   * <p>
   * Weiters werden nur eindeutige Treffer zurückgegeben. Bei Mehrfachtreffern oder falls kein Treffer gefunden wurde, wird eine
   * SasException zurückgeliefert.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress} wurde
   * erfolgreich ausgeführt.</li>
   * <li>Online-Modus (siehe {@link #checkStatus(String) checkStatus}).</li>
   * <li>Zugriff auf SAS (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#SAS_CORE SAS_CORE}).</li>
   * </ul>
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   * @param dialogId Dialog ID eines aufgebauten Dialogs.
   * @param svNummerAbfragenSuchkriterien Die Suchkriterien für die SV-Nummern-Abfrage.
   * @return Das AbfrageErgebnis der SV-Nummern-Abfrage.
   * @throws AccessException
   *            {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_SAS_CORE MISSING_SAS_CORE}
   * @throws DialogException
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID}, 
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws InvalidParameterSuchkriterienException
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#FAMILIENNAME_NICHT_BEFUELLT FAMILIENNAME_NICHT_BEFUELLT},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#FAMILIENNAME_UNGUELTIG FAMILIENNAME_UNGUELTIG},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#FAMILIENNAME_ZU_LANG FAMILIENNAME_ZU_LANG},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#GEBURTSDATUM_NICHT_BEFUELLT GEBURTSDATUM_NICHT_BEFUELLT},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#GEBURTSDATUM_UNGUELTIG GEBURTSDATUM_UNGUELTIG},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#VORNAME_NICHT_BEFUELLT VORNAME_NICHT_BEFUELLT},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#VORNAME_UNGUELTIG VORNAME_UNGUELTIG},
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#VORNAME_ZU_LANG VORNAME_ZU_LANG}
   * @throws SasException
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#KEIN_TREFFER KEIN_TREFFER},
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#MEHRERE_TREFFER MEHRERE_TREFFER}
   */
  AbfrageErgebnis svNummerAbfragen(String dialogId, Suchkriterien svNummerAbfragenSuchkriterien) throws AccessException, DialogException,
      ServiceException, InvalidParameterSuchkriterienException, SasException;

  /**
   * <p>
   * Diese Funktion ermöglicht die Abfrage der Personendaten eines Patienten anhand dessen Sozialversicherungsnummer.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress} wurde
   * erfolgreich ausgeführt.</li>
   * <li>Online-Modus (siehe {@link #checkStatus(String) checkStatus}).</li>
   * <li>Zugriff auf SAS (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#SAS_CORE SAS_CORE}).</li>
   * </ul>
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   * @param dialogId Dialog ID eines aufgebauten Dialogs.
   * @param svNummer Sozialversicherungsnummer des Patienten, für den die Daten ermittelt werden sollen.
   * @return Das AbfrageErgebnis der SV-Nummern-Abfrage.
   * @throws AccessException
   *            {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_SAS_CORE MISSING_SAS_CORE}
   * @throws DialogException
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws InvalidParameterSuchkriterienException
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER}
   * @throws SasException
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#NO_SVPERSON NO_SVPERSON}
   */
  AbfrageErgebnis patientendatenAbfragen(String dialogId, String svNummer) throws AccessException, DialogException,
      ServiceException, InvalidParameterSuchkriterienException, SasException;

  /**
   * <p>
   * Diese Funktion ermöglicht die Abfrage der Adressdaten eines Patienten anhand dessen Sozialversicherungsnummer.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress} wurde
   * erfolgreich ausgeführt.</li>
   * <li>Online-Modus (siehe {@link #checkStatus(String) checkStatus}).</li>
   * <li>Zugriff auf SAS (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#SAS_CORE SAS_CORE}) 
   * und das Recht zur Adressabfrage (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#SAS_ADRESSABFRAGE SAS_ADRESSABFRAGE}).</li>
   * </ul>
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   * @param dialogId Dialog ID eines aufgebauten Dialogs.
   * @param svNummer Sozialversicherungsnummer des Patienten, für den die Daten ermittelt werden sollen.
   * @return Das AbfrageErgebnis der Adressdaten-Abfrage.
   * @throws AccessException
   *            {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_SAS_CORE MISSING_SAS_CORE},
   *            {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_SAS_ADRESSABFRAGE MISSING_SAS_ADRESSABFRAGE}
   * @throws DialogException
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws InvalidParameterSuchkriterienException
   *            {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER}
   * @throws SasException
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#NO_SVPERSON NO_SVPERSON},
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#ADRESSE_UNBEKANNT ADRESSE_UNBEKANNT},
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#BACKENDSYSTEM_NOT_AVAILABLE BACKENDSYSTEM_NOT_AVAILABLE},
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#BACKENDSYSTEM_SYSTEM_ERROR BACKENDSYSTEM_SYSTEM_ERROR},
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#BACKENDSYSTEM_SYSTEM_WARNING BACKENDSYSTEM_SYSTEM_WARNING},
   *            {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants#ADRESSABFRAGE_ERROR ADRESSABFRAGE_ERROR}
   */
  Adressdaten adressdatenAbfragen(String dialogId, String svNummer) throws AccessException, DialogException,
      ServiceException, InvalidParameterSuchkriterienException, SasException;

  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des SAS zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress} wurde
   * erfolgreich ausgeführt.</li>
   * <li>Zugriff auf SAS (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#SAS_CORE SAS_CORE}).</li>
   * </ul>
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz
   * </p>
   * @param dialogId Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *         Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *         Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws DialogException
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *            {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws AccessException
   *            {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_SAS_CORE MISSING_SAS_CORE}
   * @throws ServiceException
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *            {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Property[] checkStatus(String dialogId) throws AccessException, DialogException, ServiceException;
}
