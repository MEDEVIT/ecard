/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap.constants;

/**
 * Fehlerkonstanten für falsche Parameterübergaben in den Funktionen
 * {@link at.chipkarte.client.abs.soap.IAbsService#sendenAnfrage(String, at.chipkarte.client.abs.soap.BewilligungsAnfrage, String, javax.activation.DataHandler) sendenAnfrage},
 * {@link at.chipkarte.client.abs.soap.IAbsService#abfragenLangzeitbewilligung(String, String, String) abfragenLangzeitbewilligung}
 * {@link at.chipkarte.client.abs.soap.IAbsService#sendenFolgeverordnung(String, at.chipkarte.client.abs.soap.FolgeverordnungsAusstellungsParameter, String) sendenFolgeverordnung}
 * {@link at.chipkarte.client.abs.soap.IAbsService#ermittelnPatientenDaten(String, String, String, String, String, String, String, String, String) ermittelnPatientenDaten}
 * {@link at.chipkarte.client.abs.soap.IAbsService#getStatusPatientBewilligungsAnfragen(String, String, String, String, String) getStatusPatientBewilligungsAnfragen}.
 */
public final class InvalidParameterBewilligungsanfrageExceptionConstants {

  private InvalidParameterBewilligungsanfrageExceptionConstants() {
    // do not use
  }

  /**
   * Interner Verarbeitungsfehler in ABS. 
   * <br/>ORCLI-Code: CL-04031, CL-04051, CL-04061, CL-04081, CL-04091, CL-04101, CL-04121, CL-04141, CL-04203, CL-04451
   */
  public static final int INTERNAL_ERROR = 0;

  /**
   * Der Kostenträger ist ungültig. 
   * <br/>ORCLI-Code: CL-04022, CL-04023
   */
  public static final int KOSTENTRAEGER_INVALID = 3;

  /**
   * Die Sozialversicherungsnummer des Patienten ist ungültig, siehe
   * {@link at.chipkarte.client.abs.soap.PatientenDaten#getSVNummer() sVNummer}. 
   * <br/>ORCLI-Code: CL-04042, CL-04043, CL-04142, CL-04143
   */
  public static final int SVNR_PATIENT_INVALID = 5;

  /**
   * Der Familienname des Patienten wurde nicht angegeben. 
   * <br/>ORCLI-Code: CL-04001
   */
  public static final int NACHNAME_PATIENT_NOT_SET = 6;

  /**
   * Der Familienname des Patienten darf maximal 70 Zeichen enthalten. 
   * <br/>ORCLI-Code: CL-04002, CL-04003
   */
  public static final int NACHNAME_PATIENT_INVALID = 7;

  /**
   * Der Vorname des Patienten wurde nicht angegeben. 
   * <br/>ORCLI-Code: CL-04011
   */
  public static final int VORNAME_PATIENT_NOT_SET = 8;

  /**
   * Der Vorname des Patienten darf maximal 70 Zeichen enthalten. 
   * <br/>ORCLI-Code: CL-04012, CL-4013
   */
  public static final int VORNAME_PATIENT_INVALID = 9;

  /**
   * Die EKVK-Nummer darf maximal 20 Zeichen enthalten. 
   * <br/>ORCLI-Code: CL-04052, CL-04053
   */
  public static final int EKVK_NUMMER_INVALID = 10;

  /**
   * Die Pharmanummer ist ungültig. 
   * <br/>ORCLI-Code: CL-04062, CL-04063
   */
  public static final int PHARMANUMMER_INVALID = 11;

  /**
   * Das Geschlecht des Patienten ist ungültig. 
   * <br/>ORCLI-Code: CL-04032, CL-04033
   */
  public static final int GESCHLECHT_PATIENT_INVALID = 14;

  /**
   * Das Feld Diagnose darf maximal 100 Zeichen enthalten. 
   * <br/>ORCLI-Code: CL-04072, CL-04073
   */
  public static final int DIAGNOSE_INVALID = 15;

  /**
   * Die Dosierung darf maximal 25 Zeichen enthalten. 
   * <br/>ORCLI-Code: CL-04082, CL-04083
   */
  public static final int DOSIERUNG_INVALID = 16;

  /**
   * Es muss zumindest eine Verordnung vorhanden sein. 
   * <br/>ORCLI-Code: CL-04204
   */
  public static final int VERORDNUNG_NOT_SET = 17;

  /**
   * Die Anzahl der maximal erlaubten Verordnungen (10) wurde überschritten. 
   * <br/>ORCLI-Code: CL-04202
   */
  public static final int VERORDNUNG_MAX_EXCEEDED = 19;

  /**
   * Die Medikamentenbezeichnung darf maximal 100 Zeichen enthalten. 
   * <br/>ORCLI-Code: CL-04092, CL-04093
   */
  public static final int MEDIKAMENT_INVALID = 20;

  /**
   * Der angegebene Wert für die Langzeitverordnung ist ungültig, siehe auch
   * {@link at.chipkarte.client.abs.soap.Verordnung#getLangzeitverordnung() langzeitVerordnung}. 
   * <br/>ORCLI-Code: CL-04102, CL-04103
   */
  public static final int LANGZEITVERORDNUNG_INVALID = 21;

  /**
   * Das Feld Begründung entspricht nicht den Vorgaben, siehe auch {@link at.chipkarte.client.abs.soap.Verordnung#getBegruendung()
   * begruendung}. 
   * <br/>ORCLI-Code: CL-04112, CL-04113
   */
  public static final int BEGRUENDUNG_INVALID = 22;

  /**
   * Der angegebene Wert für Packungsanzahl ist ungültig, 
   * siehe {@link at.chipkarte.client.abs.soap.Verordnung#getPackungsanzahl() packungsanzahl}. 
   * <br/>ORCLI-Code: CL-04132, CL-04133
   */
  public static final int PACKUNGSANZAHL_INVALID = 23;

  /**
   * Der angegebene Wert für Magistrale Zubereitung ist ungültig. 
   * <br/>ORCLI-Code: CL-04122, CL-04123
   */
  public static final int MAGISTRALE_ZUBEREITUNG_INVALID = 24;

  /**
   * Diagnose ist ein Pflichtfeld. 
   * <br/>ORCLI-Code: CL-04071
   */
  public static final int DIAGNOSE_NOT_SET = 26;

  /**
   * Begründung ist ein Pflichtfeld. 
   * <br/>ORCLI-Code: CL-04111
   */
  public static final int BEGRUENDUNG_NOT_SET = 27;

  /**
   * Weder das Feld <Code>sVNummer</code> noch das Feld <code>eKVKNummer</code> wurden angegeben. Es muss eines der Felder SV-Nummer
   * oder EKVK-Nummer angegeben werden. 
   * <br/>ORCLI-Code: CL-04200
   */
  public static final int SVNR_EKVKNR_NOT_SET = 40;

  /**
   * Medikament oder Magistrale Zubereitung muss belegt werden.
   * <br/>ORCLI-Code: CL-04201
   */
  public static final int MEDIKAMENT_ZUBEREITUNG_NOT_SET = 41;

  /**
   * Es muss eines der Felder <code>Medikamentname</code> oder <code>Pharmanummer</code> angegeben werden. 
   * <br/>ORCLI-Code: CL-04213
   */
  public static final int PHARMANR_MEDIKAMENT_NOT_SET = 42;

  /**
   * Karte wird nicht akzeptiert (defekte, falsche oder keine Karte gesteckt). 
   * <br/>ORCLI-Code: CL-00006<br>
   * <br/>Es ist eine falsche Karte gesteckt. 
   * <br/>ORCLI-Code: CL-00258
   */
  public static final int CARD_INVALID = 43;

  /**
   * Sozialversicherungsnummer ist ein Pflichtfeld. 
   * <br/>ORCLI-Code: CL-04041
   */
  public static final int SVNR_PATIENT_NOT_SET = 45;

  /**
   * Der Medikamentenname ist ein Pflichtfeld. 
   * <br/>ORCLI-Code: CL-04214
   */
  public static final int MEDIKAMENT_NAME_NOT_SET = 46;

  // *******************************************************
  // ******* Attachment Fehler *****************************
  // *******************************************************

  /**
   * Es wurde kein Attachment hinzugefügt. 
   * <br/>ORCLI-Code: CL-04208
   */
  public static final int ATTACHMENT_INVALID = 50;

  /**
   * Die Anlage wurde bereits hinzugefügt. 
   * <br/>ORCLI-Code: CL-04205
   */
  public static final int ATTACHMENT_DUPLICATE = 51;

  /**
   * Die Anzahl der zulässigen Anlagen ist überschritten. 
   * <br/>ORCLI-Code: CL-04207
   */
  public static final int ATTACHMENT_MAX_FILES_EXCEEDED = 52;

  /**
   * Der Dateiname ist ungültig (5-128 Zeichen). 
   * <br/>ORCLI-Code: CL-04209
   */
  public static final int ATTACHMENT_NAME_NOT_VALID = 53;

  /**
   * Der Dateityp der Anlage ist nicht erlaubt. 
   * <br/>ORCLI-Code: CL-04210
   */
  public static final int ATTACHMENT_TYP_NOT_VALID = 54;

  /**
   * Die Dateigröße aller Anlagen zusammen ist ungültig. 
   * <br/>ORCLI-Code: CL-04211, CL-04212
   */
  public static final int ATTACHMENT_FILESIZE_NOT_ALLOWED = 55;

  /**
   * Der Antragstyp ist ein Pflichtfeld. 
   * <br/>ORCLI-Code: CL-04441
   */
  public static final int ANTRAGSTYP_NOT_SET = 56;

  /**
   * Der Antragstyp ist nicht gültig. 
   * <br/>ORCLI-Code: CL-04442, CL-04443
   */
  public static final int ANTRAGSTYP_INVALID = 57;

  /**
   * Die Verordnerinformation ist ungültig. 
   * <br/>ORCLI-Code: CL-04452, CL-04453
   */
  public static final int VERORDNERINFORMATION_INVALID = 58;

}