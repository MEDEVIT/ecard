/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Key-Werte einer Property für erweiterte Kartendaten. 
 */
public final class CardProperty {

  private CardProperty() {
    // nothing to do
  }
  
  /**
   * Key für den Namen des EKVK-Versicherungsträgers.<br>
   */
  public static final String EKVK_TRAEGER_NAME = "EKVK_TRAEGER_NAME";
  /**
   * Key für die EKVK-Nummer des Versicherungsträgers.<br>
   */
  public static final String EKVK_TRAEGER_NUMMER = "EKVK_TRAEGER_NUMMER";
  /**
   * Key für das Verfallsdatum der Gültigkeit der EKVK für den Versicherungsträger.<br>
   */
  public static final String EKVK_VERFALLSDATUM = "EKVK_VERFALLSDATUM";

}
