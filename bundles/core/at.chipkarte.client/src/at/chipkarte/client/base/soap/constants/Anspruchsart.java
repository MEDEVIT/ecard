/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für die Anspruchsart.
 */
public final class Anspruchsart {

  /**
   * sachleistungsberechtigt.
   */
  public static final String SACHLEISTBER = "S";
  /**
   * geldleistungsberechtigt.
   */
  public static final String GELDLEISTBER = "G";
  /**
   * sachleistungsberechtigt gemäß §122 Absatz 3a ASVG.
   */
  public static final String SACHLEISTBER1 = "S1";
  /**
   * sachleistungsberechtigt für VU&MKP für Nichtversicherte.
   */
  public static final String SACHLEISTBER2 = "S2";

  private Anspruchsart() {
  }

}
