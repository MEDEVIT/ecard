/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;


/**
 * Konstanten zur Kennzeichnung der Prüfung der leistungsrechtlichen Limits.
 */
public final class LeistungRLimit {

  /**
   * Konsultation wurde gegen das Regelwerk geprüft.
   */
  public static final String R = "R";

  /**
   * Konsultation wurde nicht geprüft, weil es sich zum Beispiel um eine Folgekonsultation handelt.
   */
  public static final String N = "N";

  /**
   * Regelwerk negativ, aber die personenbezogenen leistungsrechtlichen Limits wurden nicht überschritten.
   */
  public static final String Z = "Z";

  private LeistungRLimit() {
  }

}
