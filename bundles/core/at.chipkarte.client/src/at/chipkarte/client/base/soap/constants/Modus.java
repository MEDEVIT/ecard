/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für den Verbindungszustand des Ordinationsclient.
 */
public final class Modus {

  private Modus() {
    // nothing to do
  }
  
  /**
   * Der Wert für den Online-Modus des Ordinationsclient.
   */
  public static final String ONLINE = "ONLINE";

  /**
   * Der Wert für den Offline-Modus des Ordinationsclient. 
   * <br>Anmerkung: Der Modus wird auch Offline gesetzt, wenn ein Service nicht
   * konfiguriert ist.
   */
  public static final String OFFLINE = "OFFLINE";

}
