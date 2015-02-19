/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für die Versichertenart.
 */
public final class Versichertenart extends Enum {

  /**
   * Die Bedeutung des Codes ist SVT spezifisch.
   */
  public static final String ASVG = "A";
  /** @exclude */
  public static Versichertenart ASVG_ = new Versichertenart(ASVG);

  /**
   * Die Bedeutung des Codes ist SVT spezifisch.
   */
  public static final String KUVG = "B";
  /** @exclude */
  public static Versichertenart KUVG_ = new Versichertenart(KUVG);

  private Versichertenart(String versichertenart) {
    super(versichertenart);
  }

  /** @exclude */
  public static Versichertenart getEnum(String enumString) {
    return (Versichertenart) getEnum(Versichertenart.class, enumString);
  }
}
