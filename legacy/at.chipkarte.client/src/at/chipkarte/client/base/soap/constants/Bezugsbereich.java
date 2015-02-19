/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für den Bezugsbereich.
 */
public final class Bezugsbereich extends Enum {

  /**
   * Kurative Medizin.
   */
  public static final String KU = "KU";
  /** @exclude */
  public static Bezugsbereich KU_ = new Bezugsbereich(KU);
  /**
   * Gesundenuntersuchung.
   */
  public static final String GU = "GU";
  /** @exclude */
  public static Bezugsbereich GU_ = new Bezugsbereich(GU);

  private Bezugsbereich(String bezugsbereichCode) {
    super(bezugsbereichCode);
  }

  /** @exclude */
  public static Bezugsbereich getEnum(String enumString) {
    return (Bezugsbereich) getEnum(Bezugsbereich.class, enumString);
  }
}
