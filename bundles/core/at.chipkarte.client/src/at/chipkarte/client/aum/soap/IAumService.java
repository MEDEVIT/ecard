/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap;

import at.chipkarte.client.aum.soap.exceptions.AumException;
import at.chipkarte.client.aum.soap.exceptions.AumInvalidParameterException;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des elektronischen Arbeitsunfähigkeitsmeldungsservice (AUM) zur Verfügung.
 * </p>
 */
public interface IAumService {
  /**
   * Konstante für den Parameter Berufskrankheit im Objekt Meldungsdaten ('0' wenn keine Berufskrankheit vorliegt).
   */
  Integer FALSE = 0;
  /**
   * Konstante für den Parameter Berufskrankheit ('1' wenn eine Berufskrankheit vorliegt).
   */
  Integer TRUE = 1;
  /**
   * Konstante für den Parameter Berufskrankheit ('2' wenn nicht bekannt ist ob eine Berufskrankheit vorliegt).
   */
  Integer UNKNOWN = 2;

  /**
   * <p>
   * Legt eine neue Meldung an.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * <li>Es steckt entweder eine gültige e-card im Kartenleser, 
   * der dem Dialog zugeordnet bzw. der als Attribut angegeben ist ODER 
   * es sind entweder die SV-Nummer, die EKVK-Daten oder Vorname, Nachname und 
   * Geburtsdatum angegeben. Es dürfen nicht SV-Nummer und EKVK-Daten/Personendaten gleichzeitig angegeben werden.</li>
   * <li>Das Flag <i>ungeprueft</i> muss mit <i>false</i> angegeben werden, wenn die Erfassungen für 
   * Patienten mit einen für AUM gültigen Anspruch (Personendatenangabe mittels SV-Nummer oder gesteckter e-card) 
   * oder für EKVK-Patienten (Personendatenangabe mittels Vorname, Nachname, Geschlecht, EKVK-Nummer und EKVK-Träger) 
   * erfolgt.</li>
   * <li>Das Flag <i>ungeprueft</i> muss mit <i>true</i> angegeben werden, wenn die Erfassung für Patienten 
   * mit keinen für AUM gültigen Anspruch (Personendatenangabe mittels SV-Nummer oder gesteckter e-card) oder für Patienten 
   * deren SV-Nummer nicht bekannt/ermittelbar ist 
   * (Personendatenangabe mittels Vorname, Nachname und Geburtsdatum) erfolgt.</li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId ID eines existierenden Dialogs.
   * @param cardReaderId ID eines Kartenlesers (optional)
   * @param meldungsdaten Meldungsdatenstruktur ({@link Meldungsdaten}). <br>
   * Pflichtattribute f&uuml;r dieses Objekt in dieser Funktion sind:
   * <ul>
   *    <li><i>SvtCode</i> (nur Pflicht für SV-Personen, für EKVK-Personen kann dieses Attribut leer bleiben)</li>
   *    <li><i>ArbeitsunfaehigVon</i></li>
   *    <li><i>BehandlungsDatum</i></li>
   *    <li>entweder <i>DiagnoseCode</i> und <i>DiagnoseCodeTyp</i> oder <i>Diagnose</i></li>  
   *    <li><i>Strasse</i>, <i>Ort</i> und <i>Plz</i> - bedingte Pflichtfelder: es m&uuml;ssen entweder alle drei Felder gesetzt 
   *        oder leer sein</li>
   *    <li><i>RueckdatierungsgrundCode</i>, falls <i>ArbeitsunfaehigVon</i> um mehr als 
   *        einen Arbeitstag vor <i>BehandlungsDatum</i> liegt (wobei Feiertage 
   *        nicht ber&uuml;cksichtigt werden)</li>
   * </ul>
   * @param meldungsArt die Art der anzulegenden Meldung (AU oder AF)
   * @param person Personendaten (siehe {@link Person})
   * @param forceExecution falls <code>true</code>, wird die Prüfung auf 
   * Daten, die um mehr als 300 Tage vom aktuellen Datum abweichen, übersprungen.
   * @param ungeprueft Kennzeichen, ob die Meldung für eine Person ohne bekannte SV-Nummer bzw. ohne einen für AUM gültigen Anspruch 
   * angelegt werden soll.
   * @param offeneMeldungenSuchen Kennzeichen, ob vor dem Anlegen der Meldung auf offene Meldungen, für den mittels SV-Nummer spezifizierten Patienten
   *  geprüft werden soll. 
   * <u>Hinweis:</u> falls das Kennzeichen <i>ungeprueft</i> auf <i>true</i> oder keine SV-Nummer in {@link Person} versorgt ist, wird dieser Wert ignoriert 
   * (d.h. es findet <u>keine Prüfung</u> statt)
   * @return Array von Datenstrukturen (Meldungen) mit Eingabedaten und vom Server zugewiesener ID
   *    ({@link Quittung}) <br>
   *    Diese Methode gibt ein Array zurück, weil ggf. mehr als eine Meldung 
   *    generiert werden kann (wenn <code>svtCode</code>  = <i>AL</i> und eine Mehrfachversicherung vorliegt). 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   *
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER}
   *
   * @throws CardException
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BESONDERE_URSACHE_INVALID BESONDERE_URSACHE_INVALID}, 
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#PERSON_REQUIRED PERSON_REQUIRED}, 
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GEHUNFAEHIG_INVALID GEHUNFAEHIG_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DATE_GIPSBIS_INVALID DATE_GIPSBIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DATE_GIPS_BIS_WRONG_VALUE DATE_GIPS_BIS_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DATE_WIEDERBESTELLUNG_INVALID DATE_WIEDERBESTELLUNG_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MITTEILUNG_INVALID MITTEILUNG_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#EKVKTRAEGER_REQUIRED EKVKTRAEGER_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#EKVKTRAEGER_INVALID EKVKTRAEGER_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#EKVK_NUMMER_INVALID EKVK_NUMMER_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SV_NUMMER_REQUIRED SV_NUMMER_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VORNAME_REQUIRED VORNAME_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VORNAME_INVALID VORNAME_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#NACHNAME_REQUIRED NACHNAME_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#NACHNAME_INVALID NACHNAME_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GESCHLECHT_REQUIRED GESCHLECHT_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GESCHLECHT_INVALID GESCHLECHT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_VON_REQUIRED AU_VON_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_VON_INVALID AU_VON_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_VON_OUT_OF_RANGE AU_VON_OUT_OF_RANGE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_INVALID AU_BIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_OUT_OF_RANGE AU_BIS_OUT_OF_RANGE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VORAUSS_ENDE_AU_INVALID VORAUSS_ENDE_AU_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHVON1_INVALID TIME_AUSGEHVON1_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHBIS1_INVALID TIME_AUSGEHBIS1_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSE_REQUIRED DIAGNOSE_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSE_INVALID DIAGNOSE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHVON2_INVALID TIME_AUSGEHVON2_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHBIS2_INVALID TIME_AUSGEHBIS2_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SVT_REQUIRED SVT_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SVT_INVALID SVT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#NEED_DIAGNOSE_CODE_AND_TYPE NEED_DIAGNOSE_CODE_AND_TYPE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSECODETYP_INVALID DIAGNOSECODETYP_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSECODE_INVALID DIAGNOSECODE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZUSATZDIAGNOSE_INVALID ZUSATZDIAGNOSE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_BIS_INVALID KH_BIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_BIS_WRONG_VALUE KH_BIS_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_VON_INVALID KH_VON_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_VON_WRONG_VALUE KH_VON_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#STRASSE_REQUIRED STRASSE_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#STRASSE_INVALID STRASSE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#PLZ_REQUIRED PLZ_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#PLZ_INVALID PLZ_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ORT_REQUIRED ORT_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ORT_INVALID ORT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BERUFSKRANKHEIT_INVALID BERUFSKRANKHEIT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BEHANDLUNGSDATUM_REQUIRED BEHANDLUNGSDATUM_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BEHANDLUNGSDATUM_INVALID BEHANDLUNGSDATUM_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BEHANDLUNGSDATUM_WRONG_VALUE BEHANDLUNGSDATUM_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#RUECKDATIERUNGSGRUND_REQUIRED RUECKDATIERUNGSGRUND_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#RUECKDATIERUNGSGRUND_INVALID RUECKDATIERUNGSGRUND_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GEBURTSDATUM_REQUIRED GEBURTSDATUM_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GEBURTSDATUM_INVALID GEBURTSDATUM_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GEBURTSDATUM_WRONG_VALUE GEBURTSDATUM_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_REQUIRED MELDUNGSART_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_INVALID MELDUNGSART_INVALID},
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_ANSPRUCH NO_ANSPRUCH},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_ANSPRUCH_SVT NO_ANSPRUCH_SVT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#QUASA_ONLY QUASA_ONLY},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#BVA_BEAMTER BVA_BEAMTER},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ANSPRUCH_EXISTS ANSPRUCH_EXISTS},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#DIAGNOSE_XOR_DIAGNOSECODE_REQUIRED DIAGNOSE_XOR_DIAGNOSECODE_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#EKVK_XOR_SV_NUMMER EKVK_XOR_SV_NUMMER},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SV_NUMMER_NOT_EXISTS SV_NUMMER_NOT_EXISTS},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSGEH_BIS1_VOR_VON AUSGEH_BIS1_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSGEH_BIS2_VOR_VON AUSGEH_BIS2_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSSTELLUNGSDATUM_BIS_VOR_VON AUSSTELLUNGSDATUM_BIS_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_VPANSPRUCH_FOR_SVT NO_VPANSPRUCH_FOR_SVT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AU_BIS_VOR_AU_VON AU_BIS_VOR_AU_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#VORAUSS_ENDE_AU_VOR_AU_VON VORAUSS_ENDE_AU_VOR_AU_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_AUM_SVT NO_AUM_SVT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ALLE_SVT_INVALID ALLE_SVT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#EKVK_FORBIDDEN EKVK_FORBIDDEN},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#PERSON_DATA_FORBIDDEN PERSON_DATA_FORBIDDEN},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#PERSON_DATA_INCONSISTENT PERSON_DATA_INCONSISTENT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#KH_BIS_VOR_KH_VON KH_BIS_VOR_KH_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#CARD_INVALID CARD_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SV_NUMMERS_DIFFERENT SV_NUMMERS_DIFFERENT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#OPEN_MELDUNG_EXISTS OPEN_MELDUNG_EXISTS},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}

   */
  Quittung[] meldungAnlegen(String dialogId, String cardReaderId, Meldungsdaten meldungsdaten,
      String meldungsArt, Person person, Boolean forceExecution, Boolean ungeprueft, Boolean offeneMeldungenSuchen) 
  throws ServiceException, DialogException, CardException, AccessException,
  AumInvalidParameterException, AumException;
  /**
   * <p>
   *    Setzt das Datum für <i>ArbeitsunfaehigBis</i> (Letzter Tag der AU) in einer AU-Meldung (beendet die Meldung).
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * 
   * @param dialogId ID eines existierenden Dialogs.
   * @param cardReaderId ID eines Kartenlesers (optional) 
   * @param aufId ID der AU-Meldung
   * @param aufIdVersion (aktuelle) Version der AU-Meldung
   * @param arbeitsunfaehigBis Ende der Arbeitsunfähigkeit (Letzter Tag der AU). 
   *    <br><u>Hinweis:</u> Der Parameter ist zwingend anzugeben. Das Löschen 
   * eines bereits gesetzten Datums für den Letzten Tag der AU (<i>ArbeitsunfaehigBis</i> gesetzt) ist mit dieser Funktion daher <u>nicht</u> möglich.
   * @param forceExecution falls <code>true</code>, wird die Prüfung auf 
   * Daten, die um mehr als 300 Tage vom aktuellen Datum abweichen, übersprungen.
   * @return Die bearbeitete Meldung ({@link Quittung}) mit eingetragenen/geänderten Endedatum
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws CardException
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}                    
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_REQUIRED AU_BIS_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_INVALID AU_BIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_OUT_OF_RANGE AU_BIS_OUT_OF_RANGE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ID_INVALID ID_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID}
   * 
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_AKTUELL MELDUNG_NOT_AKTUELL},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ID_STORNIERT ID_STORNIERT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ACCESS_NOT_ALLOWED ACCESS_NOT_ALLOWED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_FOUND MELDUNG_NOT_FOUND},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AU_BIS_VOR_AU_VON AU_BIS_VOR_AU_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#CARD_INVALID CARD_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SV_NUMMERS_DIFFERENT SV_NUMMERS_DIFFERENT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_EXPIRED MELDUNG_EXPIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MUST_NOT_DELETE_AU_BIS MUST_NOT_DELETE_AU_BIS},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INVALID_FOR_AF INVALID_FOR_AF},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}

   */
  AufSuchergebnis auEndeBearbeiten(String dialogId, String cardReaderId,
      Long aufId, Integer aufIdVersion,
      String arbeitsunfaehigBis, Boolean forceExecution)
  throws ServiceException, DialogException,  AccessException, AumInvalidParameterException, AumException, CardException;
  /**
   * <p>Ändert eine existierende Meldung.</p>
   * <p>
   * Das Feld <i>SvtCode</i> darf f&uuml;r EKVK-Patienten und
   * f&uuml;r &quot;ungepr&uuml;fte&quot; Meldungen nicht ge&auml;ndert werden.
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * <li>Im System existiert eine Meldung mit der übergebenen <i>aufId</i> 
   * und <i>aufIdVersion</i>, die änderbar und nicht storniert ist.</li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId ID eines existierenden Dialogs.
   * @param aufId ID der zu &auml;ndernden Meldung
   * @param aufIdVersion (aktuelle) Version der zu &auml;ndernden Meldung
   * @param meldungNeu die neue Meldung (alle Pflichtfelder müssen ausgefüllt werden
   * <br>Felder die nicht ausgefüllt wurden, werden auf <code>null</code> gesetzt). <br>
   * Pflichtattribute f&uuml;r dieses Objekt in dieser Funktion sind:
   *  <ul>
   *    <li><i>SvtCode</i> (nur Pflicht für SV-Personen, für EKVK-Personen kann dieses Attribut leer bleiben)</li>
   *    <li><i>ArbeitsunfaehigVon</i></li>
   *    <li><i>BehandlungsDatum</i></li>
   *    <li>entweder <i>DiagnoseCode</i> und <i>DiagnoseCodeTyp</i> oder <i>Diagnose</i></li>  
   *    <li><i>Strasse</i>, <i>Ort</i> und <i>Plz</i> - bedingte Pflichtfelder: es m&uuml;ssen entweder alle drei Felder gesetzt 
   *        oder leer sein</li>
   *    <li><i>RueckdatierungsgrundCode</i>, falls <i>ArbeitsunfaehigVon</i> um mehr als 
   *        einen Arbeitstag vor <i>BehandlungsDatum</i> liegt (wobei Feiertage 
   *        nicht ber&uuml;cksichtigt werden)</li>
   *    <li><i>ArbeitsunfaehigBis</i> (Letzter Tag des AU), falls es sich um eine reine AF-Meldung handelt</li>
   * </ul>
   * @param meldungsArt die Art der anzulegenden Meldung (AU oder AF)       
   * @param forceExecution falls <code>true</code>, wird die Prüfung auf 
   * Daten, die um mehr als 300 Tage vom aktuellen Datum abweichen, übersprungen.
   * @return Die geänderte Meldung {@link Quittung} mit den aktuellen Meldungsdaten.
   * 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNG_NEU_REQUIRED MELDUNG_NEU_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BESONDERE_URSACHE_INVALID BESONDERE_URSACHE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#GEHUNFAEHIG_INVALID GEHUNFAEHIG_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DATE_GIPSBIS_INVALID DATE_GIPSBIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DATE_GIPS_BIS_WRONG_VALUE DATE_GIPS_BIS_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DATE_WIEDERBESTELLUNG_INVALID DATE_WIEDERBESTELLUNG_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MITTEILUNG_INVALID MITTEILUNG_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_VON_REQUIRED AU_VON_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_VON_INVALID AU_VON_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_VON_OUT_OF_RANGE AU_VON_OUT_OF_RANGE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_REQUIRED AU_BIS_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_INVALID AU_BIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#AU_BIS_OUT_OF_RANGE AU_BIS_OUT_OF_RANGE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VORAUSS_ENDE_AU_INVALID VORAUSS_ENDE_AU_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHVON1_INVALID TIME_AUSGEHVON1_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHBIS1_INVALID TIME_AUSGEHBIS1_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSE_REQUIRED DIAGNOSE_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSE_INVALID DIAGNOSE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHVON2_INVALID TIME_AUSGEHVON2_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#TIME_AUSGEHBIS2_INVALID TIME_AUSGEHBIS2_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SVT_REQUIRED SVT_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SVT_INVALID SVT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#NEED_DIAGNOSE_CODE_AND_TYPE NEED_DIAGNOSE_CODE_AND_TYPE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSECODETYP_INVALID DIAGNOSECODETYP_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#DIAGNOSECODE_INVALID DIAGNOSECODE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZUSATZDIAGNOSE_INVALID ZUSATZDIAGNOSE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_VON_INVALID KH_VON_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_VON_WRONG_VALUE KH_VON_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_BIS_INVALID KH_BIS_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#KH_BIS_WRONG_VALUE KH_BIS_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ID_INVALID ID_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#STRASSE_REQUIRED STRASSE_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#STRASSE_INVALID STRASSE_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#PLZ_REQUIRED PLZ_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#PLZ_INVALID PLZ_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ORT_REQUIRED ORT_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ORT_INVALID ORT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BERUFSKRANKHEIT_INVALID BERUFSKRANKHEIT_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#RUECKDATIERUNGSGRUND_REQUIRED RUECKDATIERUNGSGRUND_REQUIRED}
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#RUECKDATIERUNGSGRUND_INVALID RUECKDATIERUNGSGRUND_INVALID}
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BEHANDLUNGSDATUM_REQUIRED BEHANDLUNGSDATUM_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BEHANDLUNGSDATUM_INVALID BEHANDLUNGSDATUM_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#BEHANDLUNGSDATUM_WRONG_VALUE BEHANDLUNGSDATUM_WRONG_VALUE},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ID_INVALID ID_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_REQUIRED MELDUNGSART_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_INVALID MELDUNGSART_INVALID},
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_ANSPRUCH NO_ANSPRUCH},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_ANSPRUCH_SVT NO_ANSPRUCH_SVT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_AKTUELL MELDUNG_NOT_AKTUELL},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ID_STORNIERT ID_STORNIERT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#DIAGNOSE_XOR_DIAGNOSECODE_REQUIRED DIAGNOSE_XOR_DIAGNOSECODE_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSGEH_BIS1_VOR_VON AUSGEH_BIS1_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSGEH_BIS2_VOR_VON AUSGEH_BIS2_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AU_BIS_VOR_AU_VON AU_BIS_VOR_AU_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#KH_BIS_VOR_KH_VON KH_BIS_VOR_KH_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#KH_BIS_WITHOUT_VON KH_BIS_WITHOUT_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NEED_BOTH_AUSGANG1 NEED_BOTH_AUSGANG1},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NEED_BOTH_AUSGANG2 NEED_BOTH_AUSGANG2},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#VORAUSS_ENDE_AU_VOR_AU_VON VORAUSS_ENDE_AU_VOR_AU_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#NO_VPANSPRUCH_FOR_SVT NO_VPANSPRUCH_FOR_SVT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_FOUND MELDUNG_NOT_FOUND},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ACCESS_NOT_ALLOWED ACCESS_NOT_ALLOWED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#KVT_MODIFICATION_NOT_ALLOWED KVT_MODIFICATION_NOT_ALLOWED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_EXPIRED MELDUNG_EXPIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MUST_NOT_DELETE_AU_BIS MUST_NOT_DELETE_AU_BIS},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}

   */
  Quittung meldungAendern(String dialogId, 
      Long aufId, Integer aufIdVersion, Meldungsdaten meldungNeu, String meldungsArt, Boolean forceExecution)
  throws ServiceException, DialogException, AccessException,
  AumInvalidParameterException, AumException;
  /**
   * <p>Holt Überblicksdaten für selbsterstellte Meldungen, die den im Parameter <code>suche</code> angegebenen Kriterien entsprechen.
   * <br><u>Hinweis:</u> Der Vertragspartner kann nur eigene (selbsterstellte) Meldungen suchen.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p><b>ACHTUNG:</b> Falls die Suchkriterien zu unspezifisch gew&auml;hlt wurden, sodass mehr als 100 Meldungen den
   * Kriterien entsprechen, wird eine Exception geliefert.
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId ID eines existierenden Dialogs.
   * @param suche filtert auf Attribute der Meldungen ({@link Suchkriterien}).
   * @return AufSuchergebnis - Ein Array von {@link AufSuchergebnis}-Objekten.
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VORNAME_INVALID VORNAME_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#NACHNAME_REQUIRED  NACHNAME_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#NACHNAME_INVALID NACHNAME_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_REQUIRED MELDUNGSART_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_INVALID MELDUNGSART_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZEITRAUM_VON_REQUIRED ZEITRAUM_VON_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZEITRAUM_VON_INVALID ZEITRAUM_VON_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MAX_SUCHERGEBNISSE_EXCEEDED MAX_SUCHERGEBNISSE_EXCEEDED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZEITRAUM_BIS_REQUIRED ZEITRAUM_BIS_REQUIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZEITRAUM_BIS_INVALID ZEITRAUM_BIS_INVALID}
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSSTELLUNGSDATUM_BIS_VOR_VON AUSSTELLUNGSDATUM_BIS_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SVNR_OR_NACHNAME SVNR_OR_NACHNAME},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SVNR_OR_VORNAME SVNR_OR_VORNAME},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}

   */
  AufSuchergebnis[] selbstErstellteMeldungenSuchen(String dialogId, Suchkriterien suche)
  throws ServiceException, DialogException, AccessException,
  AumInvalidParameterException, AumException;
  /**
   * <p>
   * Holt Überblicksdaten für Meldungen eines Patienten (nur möglich für Patienten mit Sozialversicherungsnummer), die 
   * den im Parameter <code>suchparameterSvPerson</code> angegebenen Kriterien entsprechen.
   * <br><u>Hinweis:</u> Der Vertragspartner kann nur Meldungen für einen Patienten mit Sozialversicherungsnummer suchen. Der gewünschte 
   * Patient zu dem gesucht werden soll, kann entweder mittels Angabe des Parameters <i>SvNummer</i> oder mittels gesteckter 
   * e-card erfolgen. Meldungen bei denen der Vertragspartner nicht der Initialersteller ist (sondern die Meldung "nur" beendet hat)
   * werden nur gefunden, wenn diese noch offen sind 
   * (d.h. Letzter Tag der AU - <i>ArbeitsunfaehigBis</i> - ist noch nicht oder mit einem Datum größer, gleich 
   * dem aktuellen Datum versorgt).
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p><b>ACHTUNG:</b> Falls die Suchkriterien zu unspezifisch gew&auml;hlt wurden, sodass mehr als 100 Meldungen den
   * Kriterien entsprechen, so wird eine Exception geliefert.
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId ID eines existierenden Dialogs.
   * @param cardReaderId ID eines Kartenlesers (optional)
   * @param SuchparameterSvPerson Filtert auf Attribute der Meldungen (siehe {@link SuchparameterSvPerson}).
   * @return AufSuchergebnis - Ein Array von {@link AufSuchergebnis}-Objekten.
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws CardException
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}           
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SV_NUMMER_REQUIRED2 SV_NUMMER_REQUIRED2},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#SV_NUMMER_INVALID SV_NUMMER_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MELDUNGSART_INVALID MELDUNGSART_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZEITRAUM_VON_INVALID ZEITRAUM_VON_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#MAX_SUCHERGEBNISSE_EXCEEDED MAX_SUCHERGEBNISSE_EXCEEDED},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ZEITRAUM_BIS_INVALID ZEITRAUM_BIS_INVALID}
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#AUSSTELLUNGSDATUM_BIS_VOR_VON AUSSTELLUNGSDATUM_BIS_VOR_VON},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SV_NUMMER_NOT_EXISTS SV_NUMMER_NOT_EXISTS},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#CARD_INVALID CARD_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#SV_NUMMERS_DIFFERENT SV_NUMMERS_DIFFERENT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}

   */
  AufSuchergebnis[] meldungenFuerSvPersonSuchen(String dialogId, String cardReaderId, SuchparameterSvPerson suchparameterSvPerson)
  throws ServiceException, DialogException, AccessException, AumInvalidParameterException, AumException, CardException;
  /**
   * <p>
   * Holt die Meldung (Quittung) mit der angegebenen ID vom Server.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * <li>Die Meldung mit der angegebenen ID wurde vom abfragenden Vertragspartner angelegt.</li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId ID eines existierenden Dialogs.
   * @param aufId ID der Meldung
   * @return Quittung der angeforderten Meldung. 
   * Wenn keine Meldung mit der angegebenen ID existiert, 
   * wird <code>null</code> zur&uuml;ckgegeben.
   * 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ID_INVALID ID_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ID_REQUIRED ID_REQUIRED}
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_FOUND MELDUNG_NOT_FOUND},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ACCESS_NOT_ALLOWED ACCESS_NOT_ALLOWED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ID_STORNIERT ID_STORNIERT},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   */
  Quittung detailDatenAbfragen(String dialogId, Long aufId)
  throws ServiceException, DialogException, AccessException,
  AumInvalidParameterException, AumException;

  /**
   * <p>
   * Storniert die Meldung mit der angegebenen ID und Version.
   * <br><u>Hinweis:</u> Der Vertragspartner kann nur eigene (selbsterstellte) AU/AF-Meldungen stornieren.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId ID eines existierenden Dialogs.
   * @param aufId ID der Meldung.
   * @param aufIdVersion Version der Meldung - 
   *        notwendig zur Überprüfung ob die Meldung aktuell ist.       
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *   {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws AumInvalidParameterException
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#ID_INVALID ID_INVALID},
   * {@link at.chipkarte.client.aum.soap.constants.AumInvalidParameterExceptionConstants#VERSION_INVALID VERSION_INVALID}
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_AKTUELL MELDUNG_NOT_AKTUELL},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_NOT_FOUND MELDUNG_NOT_FOUND},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#ACCESS_NOT_ALLOWED ACCESS_NOT_ALLOWED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#MELDUNG_EXPIRED MELDUNG_EXPIRED},
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   */
  void meldungStornieren(String dialogId, Long aufId, Integer aufIdVersion)
  throws ServiceException, DialogException, AccessException,
  AumInvalidParameterException, AumException;

  /**
   * <p>
   * Gibt die Daten der KVTs, die am elektronischen Arbeitsunfähigkeitsmeldungsservice (AUM) teilnehmen 
   * sowie die Standard-Ausgehzeiten der jeweiligen KVTs zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
   * </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId ID eines existierenden Dialogs.
   * @return Array von {@link AufSvtProperty} zu den einzelnen KVTs
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
      {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
   * @throws AumException
   * {@link at.chipkarte.client.aum.soap.constants.AumExceptionConstants#INTERNAL_ERROR    INTERNAL_ERROR   }
   */
  AufSvtProperty[] getSVTs(String dialogId)
  throws ServiceException, DialogException, AccessException,
  AumException;
  /**
   * <p>Gibt die möglichen Werte des Attributs <code>ZusatzdiagnoseCode</code> zurück.</p>
   * <p>
   * <b>Voraussetzungen: </b>
   * Keine
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz</p>
   * 
   * 
   * @return Array von {@link Zusatzdiagnose}
   * @see Meldungsdaten#getZusatzdiagnoseCode()
   * 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Zusatzdiagnose[] getZusatzdiagnoseCodes() throws ServiceException;

  /**
   * <p>Gibt die möglichen Werte des Attributs <code>RueckdatierungsgrundCode</code> zurück.</p>
   * <p>
   * <b>Voraussetzungen: </b>
   * Keine
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz</p>
   * 
   * @return Array von {@link Rueckdatierungsgrund}
   * @see Meldungsdaten#getRueckdatierungsgrundCode()
   * 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Rueckdatierungsgrund[] getRueckdatierungsgrundCodes() throws ServiceException;


  /**
   * <p>Gibt die möglichen Werte des Attributs <code>BesondereArbeitsunfaehigkeitsursacheCode</code> zurück.</p>
   * <p>
   * <b>Voraussetzungen: </b>
   * Keine
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @return Array von {@link BesondereArbeitsunfaehigkeitsursache}
   * @see Meldungsdaten#getBesondereArbeitsunfaehigkeitsursacheCode()
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BesondereArbeitsunfaehigkeitsursache[] getBesondereArbeitsunfaehigkeitsursacheCodes()
  throws ServiceException;

  /**
   * <p>Gibt die möglichen Werte des Attributs <code>DiagnoseCodeTyp</code> zurück.</p>
   * <p>
   * <b>Voraussetzungen: </b>
   * Keine
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @return Array von {@link DiagnoseCodeTyp}
   * @see Meldungsdaten#getDiagnoseCodeTyp()
   * 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  DiagnoseCodeTyp[] getDiagnoseCodeTyp() throws ServiceException;
  /**
   * <p>Liefert ein Blankoformular für die Arbeitsunf&auml;higkeitsmeldung
   * als HTML-formatierten String.</p>
   * <p>
   * <b>Voraussetzungen: </b>
   * Keine
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @return HTML-formatierter String
   * 
   * @throws ServiceException
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *   {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  String downloadFormblatt() throws ServiceException;
  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des elektronischen Arbeitsunfähigkeitsmeldungsservice (AUM) zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf AUM
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#AUM_CORE AUM_CORE}).
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
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_AUM_CORE MISSING_AUM_CORE}
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
