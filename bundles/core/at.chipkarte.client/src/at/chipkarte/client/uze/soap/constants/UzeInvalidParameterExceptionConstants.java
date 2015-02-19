/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap.constants;

/**
 * <p>
 * Fehlerkonstanten, wenn ein ung&uuml;ltiger Parameter in einer Funktion angegeben
 * wird.
 * </p>
 */
public class UzeInvalidParameterExceptionConstants {
  /**
   * Die Vertragspartnernummer hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06002
   */
  public static final int INVALID_VPNUMMER_FORMAT = 1;

  /**
   * Die Sozialversicherungsnummer ist ung&uuml;ltig oder fehlt.<br>
   * Kann beim Erstellen einer UZE auftreten, wenn die SvNummer zusammen mit einer AnspruchId &uuml;bergeben wurde.<br>
   * ORCLI-Code: CL-06003
   */
  public static final int INVALID_SVNUMBER = 2;

  /**
   * Die SV-Person kann nicht identifiziert werden (Es ist weder eine e-card gesteckt, noch eine 
   * Sozialversicherungsnummer angegeben).<br>
   * Kann beim Erstellen einer UZE auftreten, wenn keine AnspruchId mit &uuml;bergeben wird.<br>
   * ORCLI-Code: CL-06004
   */
  public static final int NO_SVPERSON_IDENTIFICATION = 3;

  /**
   * Das angegebene Fachgebiet ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06005
   */
  public static final int INVALID_FACHGEBIET = 4;

  /**
   * Der angegebene Krankenversicherungstr&auml;ger ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06006
   */
  public static final int INVALID_SVT = 5;

  /**
   * Der angegebene Behandlungskontext ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06007
   */
  public static final int INVALID_BEHANDLUNGSKONTEXT = 6;

  /**
   * Der Weisungstyp ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06008
   */
  public static final int INVALID_WEISUNGSTYP = 7;

  /**
   * Der Weisungstyp "Zuweisungen ohne Patientenkontakt" ist f&uuml;r das angegebene Fachgebiet nicht zul&auml;ssig.<br>
   * ORCLI-Code: CL-06009
   */
  public static final int WRONG_FACHGEBIET_FOR_ZO = 8;

  /**
   * Bei Weisungstyp "Zuweisung ohne Patientenkontakt" gew&auml;hlt, muss ein Leistungserbringer angegeben werden.<br>
   * ORCLI-Code: CL-06010
   */
  public static final int LE_REQUIRED_FOR_ZO = 9;

  /**
   * Das Objekt Medizinische Daten zum Speichern einer UZE wurde nicht &uuml;bergeben (enth&auml;lt Mussfelder).<br>
   * ORCLI-Code: CL-06011
   */
  public static final int STOREUZE_MEDDATEN_NOT_SET = 10;

  /**
   * Beim Suchen nach selbst erstellten UZEWeisungen sind nur E (erstellt) oder S (storniert) als Parameter f&uuml;r den 
   * Status der UZEWeisung zul&auml;ssig.<br>
   * ORCLI-Code: CL-06013
   */
  public static final int INVALID_UZE_STATUS = 12;

  /**
   * Beim Erstellen und beim Einl&ouml;sen einer UZE darf entweder nur der SvtCode oder ein Anspruch beziehungsweise keines von 
   * beiden angegeben werden. Es ist nicht erlaubt, beides zugleich anzugeben.<br>
   * ORCLI-Code: CL-06014
   */
  public static final int ANSPRUCH_AND_SVTCODE_SET = 13;

  /**
   * Die ID der UzeWeisung ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06015
   */
  public static final int INVALID_UZE_ID = 14;

  /**
   * Die Version der UzeWeisung ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06016
   */
  public static final int INVALID_UZE_VERSION = 15;

  /**
   * Es kann kein Leistungserbringer ermittelt werden, da das &uuml;bergebene Fachgebiet nicht f&uuml;r Zuweisungen ohne 
   * Patientenkontakt  zul&auml;ssig ist.<br>
   * ORCLI-Code: CL-06017
   */
  public static final int FG_FOR_ZO_NOT_ALLOWED = 16;

  /**
   * F&uuml;r UZE vom Weisungstyp "Zuweisung ohne Patientenkontakt" wird bereits bei der Erstellung ein Leistungserbringer 
   * angegeben. Aus diesem Grund ist die Angabe eines Leistungserbringers f&uuml;r das Patienteninformationsblatt nicht 
   * zul&auml;ssig.<br>
   * ORCLI-Code: CL-06018
   */
  public static final int OPT_LE_FOR_ZO_NOT_ALLOWED = 17;

  /**
   * F&uuml;r die Abfrage von einl&ouml;sbaren UZE muss entweder eine e-card gesteckt sein 
   * oder ein UzeCode &uuml;bergeben werden. Bei der Verwendung der e-card darf die SV-Nummer nicht versorgt werden<br>
   * ORCLI-Code: CL-06019
   */
  public static final int CARD_OR_CODE_REQUIRED = 18;

  /**
   * Die Sozialversicherungsnummer ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06020
   */
  public static final int INVALID_CONDITIONAL_SVNUMBER = 19;

  /**
   * Die OrdinationsId des Leistungsanforderers ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06021
   */
  public static final int INVALID_ORDID_LA = 20;

  /**
   * Die OrdinationsId des Leistungserbringers ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06022
   */
  public static final int INVALID_ORDID_LE = 21;

  /**
   * Die AnspruchId ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06023
   */
  public static final int INVALID_ANSPRUCH_ID = 22;

  /**
   * Beim Einl&ouml;sen einer UZE muss entweder der Code oder das e-card-Ticket angegeben sein.<br>
   * ORCLI-Code: CL-06024
   */
  public static final int CODE_OR_TICKET_REQUIRED = 23;

  /**
   * Das Patienteninformationsblatt kann nur f&uuml;r UZE mit Status "E", wie erstellt, oder "L", wie eingel&ouml;st, aufbereitet
   * werden. F&uuml;r stornierte UZE ist eine Aufbereitung nicht zul&auml;ssig.<br>
   * ORCLI-Code: CL-06025
   */
  public static final int WRONG_STATUS_FOR_PIB = 24;

  /**
   * Das Objekt UZE wurde nicht &uuml;bergeben (ist ein Mussfeld f&uuml;rs Aufbereiten des Patienteninformationsbalttes).<br>
   * ORCLI-Code: CL-06026
   */
  public static final int UZE_NOT_SET_FOR_PIB = 25;

  /**
   * Das Bis-Datum muss nach dem Von-Datum liegen.<br>
   * ORCLI-Code: CL-06101
   */
  public static final int DATE_ORDER_WRONG = 50;

  /**
   * Das Von-Datum ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06102
   */
  public static final int INVALID_VON_DATUM = 51;

  /**
   * Das Bis-Datum ist ung&uuml;ltig.<br>
   * ORCLI-Code: CL-06103
   */
  public static final int INVALID_BIS_DATUM = 52;

  /**
   * Der Vorname des Leistungserbringer hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06163
   */
  public static final int VORNAME_LE_WRONG_FORMAT = 53;

  /**
   * Der Zuname des Leistungserbringer hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06173
   */
  public static final int ZUNAME_LE_WRONG_FORMAT = 54;

  /**
   * Die Adresse des Leistungserbringer hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06183
   */
  public static final int ADRESSE_LE_WRONG_FORMAT = 55;

  /**
   * Ordinationszeiten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06193
   */
  public static final int ORDINATIONSZEITEN_WRONG_FORMAT = 56;

  /**
   * AdministrativeVermerke hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06203
   */
  public static final int ADMIN_VERMERKE_WRONG_FORMAT = 57;

  /**
   * Die Fachabteilung hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06223
   */
  public static final int FACHABTEILUNG_WRONG_FORMAT = 59;

  /**
   * Das Feld NotizLa (Notiz des Leistungsanforderers) hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06233
   */
  public static final int NOTIZFELD_WRONG_FORMAT = 60;

  /**
   * Patientenverf&uuml;gung hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06243
   */
  public static final int PATIENTENVERFUEGUNG_WRONG_FORMAT = 61;

  /**
   * Das Telefon des Patient hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06253
   */
  public static final int TELEFON_PATIENT_WRONG_FORMAT = 62;

  /**
   * Das Telefon des Leistungsanforderer muss gesetzt sein.<br>
   * ORCLI-Code: CL-06261
   */
  public static final int TELEFON_LA_NOT_SET = 63;

  /**
   * Das Telefon des Leistungsanforderer hat nicht das richtige Format..<br>
   * ORCLI-Code: CL-06263
   */
  public static final int TELEFON_LA_WRONG_FORMAT = 64;

  /**
   * Der Vertragspartner- Vorname hat nicht das richtige Format..<br>
   * ORCLI-Code: CL-06273
   */
  public static final int VP_VORNAME_WRONG_FORMAT = 65;

  /**
   * Der Vertragspartner- Zuname hat falsches Format.<br>
   * ORCLI-Code: CL-06283
   */
  public static final int VP_ZUNAME_WRONG_FORMAT = 66;

  /**
   * Der Code hat nicht das richtige Format..<br>
   * ORCLI-Code: CL-06293
   */
  public static final int CODE_WRONG_FORMAT = 67;

  /**
   * Das Telefon des Hausarztes hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06423
   */
  public static final int HAUSARZT_TELEFON_WRONG_FORMAT = 71;

  /**
   * Das Telefon der medizinischen Vertrauensperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06523
   */
  public static final int VERTRAUENSPERSON_TELEFON_WRONG_FORMAT = 75;

  /**
   * Das Telefon der privaten Kontaktperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06623
   */
  public static final int KONTAKTPERSON_TELEFON_WRONG_FORMAT = 79;

  /**
   * Das Telefon des Sachwalters hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06723
   */
  public static final int SACHWALTER_TELEFON_WRONG_FORMAT = 83;

  /**
   * Medikation: Die Beschreibung hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06803
   */
  public static final int MEDIKATION_WRONG_FORMAT = 84;

  /**
   * Das Feld Akuttherapie in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06813
   */
  public static final int AKUTTHERAPIE_WRONG_FORMAT = 85;

  /**
   * Das Feld AllergieMuInfo (Allergie und Medikamentenunvertraeglichkeit Info) in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06823
   */
  public static final int ALLERGIE_MU_INFO_WRONG_FORMAT = 86;

  /**
   * Das Feld GewuenschteLeistung in den medizinischen Daten zum Speichern einer UZE muss gesetzt sein.<br>
   * ORCLI-Code: CL-06831
   */
  public static final int GEW_LEISTUNG_NOT_SET = 87;

  /**
   * Das Feld GewuenschteLeistung in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06833
   */
  public static final int GEW_LEISTUNG_WRONG_FORMAT = 88;

  /**
   * Das Feld SymptomBeschreibung in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06843
   */
  public static final int SYMPTOMBESCHREIBUNG_WRONG_FORMAT = 89;

  /**
   * Das Feld VerdachtsDiagnose in den medizinischen Daten zum Speichern einer UZE muss gesetzt sein.<br>
   * ORCLI-Code: CL-06851
   */
  public static final int VERDACHTSDIAGNOSE_NOT_SET = 90;

  /**
   * Das Feld VerdachtsDiagnose in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06853
   */
  public static final int VERDACHTSDIAGNOSE_WRONG_FORMAT = 91;

  /**
   * Das Feld Vorgeschichte in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06863
   */
  public static final int VORGESCHICHTE_WRONG_FORMAT = 92;

  /**
   * Das Feld WesentlicheNebenDiagnosen in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06873
   */
  public static final int WES_NEBENDIAGNOSEN_WRONG_FORMAT = 93;

  /**
   * Das Feld NotizLa in den medizinischen Daten zum Speichern einer UZE hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06883
   */
  public static final int NOTIZ_LA_WRONG_FORMAT = 94;

  /**
   * Laufzeitfehler: Das UZE-Service steht zur Zeit nicht zur Verf&uuml;gung.<br>
   * ORCLI-Code: CL-06900
   */
  public static final int UZE_SERVICE_NOT_AVAILABLE = 95;
  
  /**
   * Email (des Leistungsanforderers) hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06303
   */
  public static final int EMAIL_WRONG_FORMAT = 96;
  
  /**
   * Die Landbezeichnung in der Adresse des Patienten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06313
   */
  public static final int PATIENT_ADRESSE_LAND_WRONG_FORMAT = 97;
  
  /**
   * Der Ort in der Adresse des Patienten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06323
   */
  public static final int PATIENT_ADRESSE_ORT_WRONG_FORMAT = 98;
  
  /**
   * Die Postleitzahl in der Adresse des Patienten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06333
   */
  public static final int PATIENT_ADRESSE_PLZ_WRONG_FORMAT = 99;
  
  /**
   * Die Straße in der Adresse des Patienten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06343
   */
  public static final int PATIENT_ADRESSE_STRASSE_WRONG_FORMAT = 100;
  
  /**
   * Hausarzt: TitelVorne hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06473
   */
  public static final int HAUSARZT_TITELVORNE_WRONG_FORMAT = 101;
  
  /**
   * Hausarzt: Vorname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06483
   */
  public static final int HAUSARZT_VORNAME_WRONG_FORMAT = 102;
  
  /**
   * Hausarzt: Wird der Kontakt angegeben, muss zumindest der Nachname befüllt sein.<br>
   * ORCLI-Code: CL-06491
   */
  public static final int HAUSARZT_ZUNAME_NOT_SET = 103;
  
  /**
   * Hausarzt: Zuname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06493
   */
  public static final int HAUSARZT_ZUNAME_WRONG_FORMAT = 104;
  
  /**
   * Hausarzt: TitelHinten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06353
   */
  public static final int HAUSARZT_TITELHINTEN_WRONG_FORMAT = 105;
  
  /**
   * Medizinische Vertrauensperson: TitelVorne hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06573
   */
  public static final int VERTRPERS_TITELVORNE_WRONG_FORMAT = 106;
  
  /**
   * Medizinische Vertrauensperson: Vorname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06583
   */
  public static final int VERTRPERS_VORNAME_WRONG_FORMAT = 107;
  
  /**
   * Medizinische Vertrauensperson: Zuname muss gesetzt sein.<br>
   * ORCLI-Code: CL-06591
   */
  public static final int VERTRPERS_ZUNAME_NOT_SET = 108;
  
  /**
   * Medizinische Vertrauensperson: Zuname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06593
   */
  public static final int VERTRPERS_ZUNAME_WRONG_FORMAT = 109;
  
  /**
   * Medizinische Vertrauensperson: TitelHinten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06363
   */
  public static final int VERTRPERS_TITELHINTEN_WRONG_FORMAT = 110;
  
  /**
   * Private Kontaktperson: TitelVorne hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06673
   */
  public static final int KONTAKTPERS_TITELVORNE_WRONG_FORMAT = 111;
  
  /**
   * Private Kontaktperson: Vorname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06683
   */
  public static final int KONTAKTPERS_VORNAME_WRONG_FORMAT = 112;
  
  /**
   * Private Kontaktperson: Zuname muss gesetzt sein.<br>
   * ORCLI-Code: CL-06691
   */
  public static final int KONTAKTPERS_ZUNAME_NOT_SET = 113;
  
  /**
   * Private Kontaktperson: Zuname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06693
   */
  public static final int KONTAKTPERS_ZUNAME_WRONG_FORMAT = 114;
  
  /**
   * Private Kontaktperson: TitelHinten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06373
   */
  public static final int KONTAKTPERS_TITELHINTEN_WRONG_FORMAT = 115;
  
  /**
   * Sachwalter: TitelVorne hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06773
   */
  public static final int SACHWALTER_TITELVORNE_WRONG_FORMAT = 116;
  
  /**
   * Sachwalter: Vorname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06783
   */
  public static final int SACHWALTER_VORNAME_WRONG_FORMAT = 117;
  
  /**
   * Sachwalter: Zuname muss gesetzt sein.<br>
   * ORCLI-Code: CL-06791
   */
  public static final int SACHWALTER_ZUNAME_NOT_SET = 118;
  
  /**
   * Sachwalter: Zuname hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06793
   */
  public static final int SACHWALTER_ZUNAME_WRONG_FORMAT = 119;
  
  /**
   * Sachwalter: TitelHinten hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06383
   */
  public static final int SACHWALTER_TITELHINTEN_WRONG_FORMAT = 120;
  
  /**
   * Wird der UzeCode angegeben muss auch die SvNummer angegeben werden und umgekehrt.<br>
   * ORCLI-Code: CL-06032
   */
  public static final int CODE_AND_SVNUMMER_REQUIRED = 121;
  
  /**
   * Die Landbezeichnung in der Adresse des Hausarztes hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06433
   */
  public static final int HAUSARZT_ADRESSE_LAND_WRONG_FORMAT = 122;
  
  /**
   * Der Ort in der Adresse des Hausarztes hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06443
   */
  public static final int HAUSARZT_ADRESSE_ORT_WRONG_FORMAT = 123;
  
  /**
   * Die Postleitzahl in der Adresse des Hausarztes hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06453
   */
  public static final int HAUSARZT_ADRESSE_PLZ_WRONG_FORMAT = 124;
  
  /**
   * Die Straße in der Adresse des Hausarztes hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06463
   */
  public static final int HAUSARZT_ADRESSE_STRASSE_WRONG_FORMAT = 125;
  
  /**
   * Die Landbezeichnung in der Adresse der medizinischen Vertrauensperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06533
   */
  public static final int VERTRAUENSPERSON_ADRESSE_LAND_WRONG_FORMAT = 126;
  
  /**
   * Der Ort in der Adresse der medizinischen Vertrauensperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06543
   */
  public static final int VERTRAUENSPERSON_ADRESSE_ORT_WRONG_FORMAT = 127;
  
  /**
   * Die Postleitzahl in der Adresse der medizinischen Vertrauensperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06553
   */
  public static final int VERTRAUENSPERSON_ADRESSE_PLZ_WRONG_FORMAT = 128;
  
  /**
   * Die Straße in der Adresse der medizinischen Vertrauensperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06563
   */
  public static final int VERTRAUENSPERSON_ADRESSE_STRASSE_WRONG_FORMAT = 129;
  
  /**
   * Die Landbezeichnung in der Adresse der privaten Kontaktperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06633
   */
  public static final int KONTAKTPERSON_ADRESSE_LAND_WRONG_FORMAT = 130;
  
  /**
   * Der Ort in der Adresse der privaten Kontaktperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06643
   */
  public static final int KONTAKTPERSON_ADRESSE_ORT_WRONG_FORMAT = 131;
  
  /**
   * Die Postleitzahl in der Adresse der privaten Kontaktperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06653
   */
  public static final int KONTAKTPERSON_ADRESSE_PLZ_WRONG_FORMAT = 132;
  
  /**
   * Die Straße in der Adresse der privaten Kontaktperson hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06663
   */
  public static final int KONTAKTPERSON_ADRESSE_STRASSE_WRONG_FORMAT = 133;
  
  /**
   * Die Landbezeichnung in der Adresse des Sachwalters hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06733
   */
  public static final int SACHWALTER_ADRESSE_LAND_WRONG_FORMAT = 134;
  
  /**
   * Der Ort in der Adresse des Sachwalters hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06743
   */
  public static final int SACHWALTER_ADRESSE_ORT_WRONG_FORMAT = 135;
  
  /**
   * Die Postleitzahl in der Adresse des Sachwalters hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06753
   */
  public static final int SACHWALTER_ADRESSE_PLZ_WRONG_FORMAT = 136;
  
  /**
   * Die Straße in der Adresse des Sachwalters hat nicht das richtige Format.<br>
   * ORCLI-Code: CL-06763
   */
  public static final int SACHWALTER_ADRESSE_STRASSE_WRONG_FORMAT = 137;
  
  /**
   * BewilligungsPflicht ist ungültig oder fehlt.<br>
   * ORCLI-Code: CL-06031
   */
  public static final int INVALID_BEWILLIGUNGSPFLICHT = 138;
  
  /**
   * Das Fachgebiet der Einlösung ist ungültig oder fehlt.<br>
   * ORCLI-Code: CL-06029
   */
  public static final int INVALID_FG_EINLOESUNG = 139;
  
  /**
   * Das angegebene Fachgebiet der Einlösung ist keines der 
   * Fachgebiete der ausgewählten Ordination.<br>
   * ORCLI-Code: CL-06030
   */
  public static final int WRONG_FG_EINLOESUNG_FOR_ORDINATION = 140;
  
  /**
   * Das e-card Ticket wurde durch einen anderen Vertragspartner 
   * ausgestellt und kann nicht verwendet werden.<br>
   * ORCLI-Code: CL-06112
   */
  public static final int INVALID_TICKET_FOR_VERTRAGSPARTNER = 147;
  
  /**
   * Das übergebene e-card Ticket ist ungültig.<br>
   * ORCLI-Code: CL-06114
   */
  public static final int INVALID_TICKET = 148;
  
  /**
   * Das Feld Antikoaguliert in den medizinischen Daten hat einen ungültigen Wert.<br>
   * ORCLI-Code: CL-06894
   */
  public static final int INVALID_ANTIKOAGULIERT = 149;
  
  /**
   * Medizinische Daten-Medikation: Mindestens eine Angabe des Codierungssystems hat einen ungültigen Wert.<br>
   * ORCLI-Code: CL-06953
   */
  public static final int MEDIKATION_INVALID_CODE_SYSTEM = 150;
  
  /**
   * Medizinische Daten-Medikation: Mindestens eine Angabe eines Codebezeichners hat einen ungültigen Wert.<br>
   * ORCLI-Code: CL-06954
   */
  public static final int MEDIKATION_INVALID_CODE_IDENTIFIER = 151; 
  
  /**
   * Medizinische Daten-Medikation: Mindestens eine Angabe einer Codebeschreibung hat ein ungültiges Format.<br>
   * ORCLI-Code: CL-06955
   */
  public static final int MEDIKATION_CODE_DESCRIPTION_WRONG_FORMAT = 152;
  
  /**
   * Medizinische Daten-Medikation: Die Summe der Beschreibung und aller Codebeschreibungen übersteigt das zulässige Format.<br>
   * ORCLI-Code: CL-06956
   */
  public static final int MEDIKATION_DESCRIPTION_SUM_WRONG_FORMAT = 153;
  
  /**
   * Medizinische Daten-Medikation: Die Anzahl der Codierungen übersteigt den zulässigen Wert.<br>
   * ORCLI-Code: CL-06957
   */
  public static final int MEDIKATION_INVALID_AMOUNT_OF_MEDCODES = 154;
  
  /**
   * Medizinische Daten-Medikation: Mindestens eine Angabe des Codierungssystems fehlt.<br>
   * ORCLI-Code: CL-06958
   */
  public static final int MEDIKATION_CODE_SYSTEM_NOT_SET = 155;
  
  /**
   * Medizinische Daten-Medikation: Mindestens eine Angabe eines Codebezeichners fehlt.<br>
   * ORCLI-Code: CL-06959
   */
  public static final int MEDIKATION_CODE_IDENTIFIER_NOT_SET = 156;
  
  /**
   * Medizinische Daten-Medikation: Mindestens eine Angabe einer Codebeschreibung fehlt.<br>
   * ORCLI-Code: CL-06960
   */
  public static final int MEDIKATION_CODE_DESCRIPTION_NOT_SET = 157;
  
  /**
   * Die ID des Tätigkeitsbereichs des Leistungserbringer ist ungültig.<br>
   * ORCLI-Code: CL-06033
   */
  public static final int INVALID_TAETIGKEITSBEREICHID_LE = 158;
  
  /**
   * Wenn die OrdinationsID des Leistungserbringers angegeben ist, muss auch die TätigkeitsbereichID angegeben sein.<br>
   * ORCLI-Code: CL-06034
   */
  public static final int ORDID_AND_TAETIGKEITSBEREICHID_REQUIRED = 159;
}
