package at.chipkarte.client.prop.soap.constants;

public class PropExceptionConstants {
  /**
   * Die gesteckte Karte wird vom eCS nicht akzeptiert.
   * ORCLI-Code: ZS-00044
   */
  public static final int INVALID_CARD_EXCEPTION = 1;
  /**
   * SV-Nummer im e-card System nicht bekannt.
   * ORCLI-Code: ZS-1700001
   */
  public static final int INVALID_SV_NUMMER = 3;
  /**
   * Die angegebene Konsultation ist nicht (mehr) gültig.
   * ORCLI-Code: ZS-1700002
   */
  public static final int INVALID_KONSULTATION = 4;
  /**
   * Die verwendete Version der Fachinformation ist nicht (mehr) aktuell.
   * ORCLI-Code: ZS-1700003
   */
  public static final int INVALID_FACHINFORMATION_VERSION = 5;
  /**
   * Die Anzahl der gefundenen Treffer überschreitet die maximal zulässige Anzahl von &lt;Anzahl&gt;. 
   * Bitte die Auswahl einschränken.
   * ORCLI-Code: ZS-1700010
   */
  public static final int MAX_RESULTS_EXCEEDED = 6;
  /**
   * Das angegebene Fachgebiet ist nicht für die Erfassung eines Präoperativen Befundes definiert.
   * ORCLI-Code: ZS-1700004
   */
  public static final int INVALID_FACHGEBIET = 7;
  /**
   * Der Wert in Suchzeitraum Von liegt zu weit in der Vergangenheit.
   * ORCLI-Code: ZS-1700011
   */
  public static final int INVALID_VON_DATUM = 8;
  /**
   * Die e-card wird nicht akzeptiert (als gestohlen oder verloren gemeldet). 
   * Bitte informieren Sie den Inhaber und überprüfen Sie dessen Identität.
   * ORCLI-Code: ZS-00099
   */
  public static final int INVALID_CARD_LOST_STOLEN_CHECK_PATIENT = 10;
  /**
   * Die e-card wird nicht akzeptiert (gesperrt, abgelaufen). 
   * Bitte informieren Sie den Inhaber und überprüfen Sie dessen Identität.
   * ORCLI-Code: ZS-00100
   */
  public static final int INVALID_CARD_CHECK_PATIENT = 11;
  /**
   * Der Wert in Suchzeitraum Bis liegt zu weit in der Vergangenheit.
   * ORCLI-Code: ZS-1700012
   */
  public static final int INVALID_BIS_DATUM = 12;
  /**
   * Zur Untersuchungsgruppe <UG-Code> kann kein Kommentar erfasst werden.
   * ORCLI-Code: ZS-1700013
   */
  public static final int KOMMENTAR_FOR_UG_GRUPPE_NOT_ALLOWED = 13;
}
