package at.chipkarte.client.dbas.soap.constants;

/**
 * Fehlerkonstanten für die DbasException.
 */
public class DbasExceptionConstants {
  /**
   * Die angegebene Konsultation ist ungültig.<br>
   * ORCLI-Code: CL-1200009
   */
  public static final int KONSULTATION_INVALID = 1;

  /**
   * Beim Ermitteln der Abrechnungsdaten trat ein Fehler auf.<br>
   * ORCLI-Code: CL-1200023
   */
  public static final int CREATE_ABRECHNUNG_DATA_FAILED = 2;

  /**
   * Interner Fehler des DBAS Services.<br>
   * ORCLI-Code: CL-S0012
   */
  public static final int INTERNAL_ERROR = 3;

  /**
   * Die übergebene SV-Nummer existiert nicht oder ist nicht mehr gültig.<br>
   * ORCLI-Code: ZS-12001
   */
  public static final int INVALID_VSNR = 4;

  /**
   * Die Anzahl der gefundenen Treffer überschreitet die maximal zulässige Anzahl.<br>
   * ORCLI-Code: ZS-12003
   */
  public static final int MAX_RESULTS_EXCEEDED = 5;

  /**
   * Der angegebene SV-Patient ist zum angegebenen Untersuchungsdatum nicht beim angegebenen Vertragspartner für das jeweilige
   * DMP-Programm eingeschrieben.<br>
   * ORCLI-Code: ZS-12004
   */
  public static final int PERSON_NOT_IN_DMP = 6;

  /**
   * Ein oder mehrere Schlüssel konnten nicht gefunden werden.<br>
   * ORCLI-Code: ZS-12006
   */
  public static final int NO_KEYS_FOUND = 8;

  /**
   * Die in den Abrechnungsdaten übergebene Konsultation ist ungültig (KonsultationId).<br>
   * ORCLI-Code: ZS-12007
   */
  public static final int INVALID_KONSULTATION = 9;

  /**
   * Die Empfangsbestätigung konnte nicht erfolgreich erstellt bzw. signiert werden.<br>
   * ORCLI-Code: ZS-12008
   */
  public static final int CREATE_QUITTUNG_FAILED = 10;

  /**
   * Die gesteckte Karte wird vom eCS nicht akzeptiert.<br>
   * ORCLI-Code: ZS-00044 (Text:CL-00053)
   */
  public static final int INVALID_CARD_EXCEPTION = 11;

  /**
   * Zur Vertragspartnernummer <VPNR> und Sozialversicherungsnummer <VSNR> wurden Konsultationen gefunden.<br>
   * ORCLI-Code: CL-1200025
   */
  public static final int MATCHING_KONSULTATION_FOUND = 12;

  /**
   * Das angegebene Betreuungsverhältnis ist ungültig.<br>
   * ORCLI-Code: CL-1200035
   */
  public static final int BETREUUNG_INVALID = 13;
  
  /**
   * Das in den Abrechnungsdaten übergebene Betreuungsverhältnis <BvId> ist ungültig.<br>
   * ORCLI-Code: ZS-12009
   */
  public static final int INVALID_BETREUUNG = 14;
}