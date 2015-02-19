/*
 * (C) SVC 2012
 */
package at.chipkarte.client.bkf.soap.constants;

/**
 * Fehlerkonstanten für die BkfException.
 */
public class BkfExceptionConstants {

  /**
   * Die SV-Nummer <VSNR> ist im e-card System nicht bekannt. <br/>
   * ORCLI-Code: ZS-1800001
   */
  public static final int SV_NUMMER_INVALID = 1;

  /**
   * Zur angegebenen Konsultation kann kein gültiger BKF-Leistungsanspruch ermittelt 
   * werden bzw. keine Dokumentation (mehr) erstellt werden. <br/>
   * ORCLI-Code: ZS-1800002
   */
  public static final int KONSULTATION_EINLADUNG_NOT_FOUND = 2;

  /**
   * Zum angegebenen Leistungsdatum kann kein gültiger BKF-Leistungsanspruch ermittelt 
   * werden bzw. keine Dokumentation (mehr) erstellt werden. <br/>
   * ORCLI-Code: ZS-1800003
   */
  public static final int LEISTUNGSDATUM_EINLADUNG_NOT_FOUND = 3;

  /**
   * Es existiert kein passender BKF-Leistungsanspruch für die SV-Nummer <VSNR>.
   * Die Erfassung der gewählten Dokumentation ist nicht möglich. <br/>
   * ORCLI-Code: ZS-1800004
   */
  public static final int SV_NUMMER_EINLADUNG_NOT_FOUND = 4;

  /**
   * Der BKF-Leistungsanspruch wurde bereits von einem anderen Vertragspartner beansprucht. 
   * Die Erfassung der gewählten Dokumentation ist nicht möglich. <br/>
   * ORCLI-Code: ZS-1800005
   */
  public static final int VPNR_KONS_EINLADUNG_NOT_AVAILABLE = 5;

  /**
   * Der BKF-Leistungsanspruch wurde bereits durch Sie oder einen anderen Vertragspartner 
   * in Anspruch genommen. Eine weitere Inanspruchnahme ist nicht möglich. <br/>
   * ORCLI-Code: ZS-1800006
   */
  public static final int VPNR_SCR_EINLADUNG_NOT_AVAILABLE = 6;

  /**
   * Ein oder mehrere Schlüssel konnten nicht gefunden werden. <br/>
   * ORCLI-Code: ZS-1800007
   */
  public static final int KEYS_NOT_FOUND = 7;

  /**
   * Die übergebene Konsultation <Konsultations-ID> ist ungültig. <br/>
   * ORCLI-Code: ZS-1800008
   */
  public static final int KONSULTATION_INVALID = 8;

  /**
   * Die Empfangsbestätigung konnte nicht erfolgreich erstellt beziehungsweise signiert werden. <br/>
   * ORCLI-Code: ZS-1800009
   */
  public static final int CREATE_QUITTUNG_FAILED = 9;

  /**
   * Die Anzahl der gefundenen Treffer überschreitet die maximal zulässige Anzahl von <Anzahl>. 
   * Bitte die Auswahl einschränken. <br/>
   * ORCLI-Code: ZS-1800010
   */
  public static final int MAX_RESULTS_EXCEEDED = 10;

  /**
   * Der Status des BKF-Leistungsanspruch hat sich zwischenzeitlich verändert. <br/>
   * ORCLI-Code: ZS-1800011
   */
  public static final int EINLADUNG_STATUS_CHANGED = 11;

  /**
   * Die gesteckte Karte wird vom e-card-System nicht akzeptiert. <br/>
   * ORCLI-Code: ZS-00044 (Text:CL-00053)
   */
  public static final int INVALID_CARD_EXCEPTION = 12;

  /**
   * Es ist ein unerwarteter Fehler aufgetreten. <br/>
   * ORCLI-Code: CL-S0012
   */
  public static final int INTERNAL_ERROR = 13;

  /**
   * Es existiert keine passende Konsultation zur Vertragspartnernummer <VPNR>
   * und der SV-Nummer <VSNR>. Die Erfassung der gewählten Dokumentation ist
   * nicht möglich. <br/>
   * ORCLI-Code: ZS-1800012
   */
  public static final int NO_KONSULTATION_FOUND = 14;

  /**
   * Die angegebene Konsultation ist nicht (mehr) zulässig zur Erfassung der gewählten Dokumentation. <br/>
   * ORCLI-Code: ZS-1800013
   */
  public static final int KUM_KONSULTATION_INVALID = 15;

  /**
   * Das angegebene Leistungsdatum ist nicht zulässig zur Erfassung der gewählten Dokumentation. <br/>
   * ORCLI-Code: ZS-1800014
   */
  public static final int KUM_LEISTUNGSDATUM_INVALID = 16;
  
  /**
   * Der BKF-Leistungsanspruch wurde bereits mit einem anderen Dokumentationstyp in Anspruch genommen. 
   * Die Erfassung der gewählten Dokumentation ist nicht möglich.
   * ORCLI-Code: ZS-1800015
   */
  public static final int TOKEN_ALREADY_BONDED_TO_OTHER_DOKUTYP = 17;

}
