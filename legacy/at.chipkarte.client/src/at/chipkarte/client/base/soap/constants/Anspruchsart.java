/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für die Anspruchsart.
 */
public final class Anspruchsart extends Enum {

  /**
   * sachleistungsberechtigt.
   */
  public static final String SACHLEISTBER = "S";
  /** @exclude */
  public static Anspruchsart SACHLEISTBER_ = new Anspruchsart(SACHLEISTBER);
  /**
   * geldleistungsberechtigt.
   */
  public static final String GELDLEISTBER = "G";
  /** @exclude */
  public static Anspruchsart GELDLEISTBER_ = new Anspruchsart(GELDLEISTBER);
  /**
   * Sachleistungsb. gem. §122 Abs. 3a ASVG.
   */
  public static final String SACHLEISTBER1 = "S1";
  /** @exclude */
  public static Anspruchsart SACHLEISTBER1_ = new Anspruchsart(SACHLEISTBER1);
  /**
   * Sachleistungsb.: VU&MKP für Nichtversicherte.
   */
  public static final String SACHLEISTBER2 = "S2";
  /** @exclude */
  public static Anspruchsart SACHLEISTBER2_ = new Anspruchsart(SACHLEISTBER2);

  private Anspruchsart(String anspruchsart) {
    super(anspruchsart);
  }

  /** @exclude */
  public static Anspruchsart getEnum(String enumString) {
    return (Anspruchsart) getEnum(Anspruchsart.class, enumString);
  }
}
