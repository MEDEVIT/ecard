/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten zur Kennzeichnung der Prüfung der leistungsrechtlichen Limits.
 */
public final class LeistungRLimit extends Enum {

  /**
   * Konsultation wurde gegen das Regelwerk geprüft.
   */
  public static final String R = "R";
  /** @exclude */
  public static LeistungRLimit R_ = new LeistungRLimit(R);

  /**
   * Konsultation wurde nicht geprüft, weil es sich z.B. um eine Folgekonsultation handelt.
   */
  public static final String N = "N";
  /** @exclude */
  public static LeistungRLimit N_ = new LeistungRLimit(N);

  /**
   * Regelwerk negativ, aber die personenbezogenen leistungsrechtlichen Limits wurden nicht überschritten.
   */
  public static final String Z = "Z";
  /** @exclude */
  public static LeistungRLimit Z_ = new LeistungRLimit(Z);

  private LeistungRLimit(String leistungsRLimit) {
    super(leistungsRLimit);
  }

}
