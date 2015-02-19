/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Niederlassungsform.
 */
public final class Niederlassungsform {

  private Niederlassungsform() {
    // nothing to do
  }
  
  /**
   * Niedergelassener Arzt.
   */
  public static final String ARZT = "01";
  /**
   * Selbstständige Ambulanz nach dem KAG.
   */
  public static final String AMBULANZ = "02";
  /**
   * Gruppenpraxen (Gesellschaft mit Rechtspersönlichkeit).
   */
  public static final String GRUPPEN_PRAXEN = "03";
  /**
   * Krankenanstalt.
   */
  public static final String KRANKENANSTALT = "04";
  /**
   * Sonstige.
   */
  public static final String SONSTIG = "99";

}
