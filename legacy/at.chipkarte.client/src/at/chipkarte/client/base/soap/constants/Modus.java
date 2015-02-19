/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für den Verbindungszustand des Ordinations-Client.
 */
public class Modus {

  /**
   * Der Wert für den Online Modus des Ordinations-Client.
   */
  public static final String ONLINE = "ONLINE";

  /**
   * Der Wert für den Offline Modus des Ordinations-Client. Anmerkung: Der Modus wird auch Offline gesetzt, wenn ein Service nicht
   * konfiguriert ist.
   */
  public static final String OFFLINE = "OFFLINE";

}
