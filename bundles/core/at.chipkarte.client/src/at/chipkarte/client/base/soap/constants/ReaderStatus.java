/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für den Kartenleser-Status.
 */
public final class ReaderStatus {

  private ReaderStatus() {
    // nothing to do
  }
  
  /**
   * Es steckt keine Karte im Kartenleser.
   */
  public static final String STATUS_READER_EMPTY = "STATUS_READER_EMPTY";

  /**
   * Es steckt eine Karte im Kartenleser.
   */
  public static final String STATUS_READER_PRESENT = "STATUS_READER_PRESENT";

  /**
   * Der Kartenleser ist nicht erreichbar.
   */
  public static final String STATUS_READER_UNAVAILABLE = "STATUS_READER_UNAVAILABLE";

  /**
   * Der Kartenleser ist unbekannt.
   */
  public static final String STATUS_READER_UNKNOWN = "STATUS_READER_UNKNOWN";

}
