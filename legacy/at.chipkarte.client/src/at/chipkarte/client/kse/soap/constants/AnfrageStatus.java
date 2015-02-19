/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap.constants;

/**
 * Konstanten für den Anfragestatus.
 */
public class AnfrageStatus {

  /**
   * Die Anfrage ist am e-card Serversystem in Bearbeitung.
   */
  public static final int IN_ARBEIT = 0;

  /**
   * Die Anfrage ist vom e-card Serversystem bearbeitet worden und zum Download bereit.
   */
  public static final int FERTIG = 1;

  /**
   * Die Anfrage wurde bereits downgeloadet.
   */
  public static final int ABGEHOLT = 2;

  /**
   * Die Verarbeitung war fehlerhaft. Der Download steht nicht zur Verfügung.
   */
  public static final int FEHLER = 3;

}
