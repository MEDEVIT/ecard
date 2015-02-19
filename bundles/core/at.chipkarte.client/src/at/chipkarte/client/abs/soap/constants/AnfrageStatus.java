/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.constants;

/**
 * Konstanten zur Kennzeichnung des Status einer {@link at.chipkarte.client.abs.soap.BewilligungsAnfrage BewilligungsAnfrage}.
 */
public final class AnfrageStatus {
  
  private AnfrageStatus() {
    // do not use
  }

  /**
   * Die Bewilligungsanfrage wurde im ABS-System gespeichert.
   */
  public static final String UEBERTRAGEN = "uebertragen";

  /**
   * Die Bewilligungsanfrage wurde bereits bearbeitet und es steht eine Rückantwort zur Verfügung.
   */
  public static final String BEANTWORTET = "beantwortet";

  /**
   * Die Bewilligungsanfrage wurde bereits bearbeitet und die Rückantwort bereits einmal abgerufen.
   */
  public static final String GELESEN = "gelesen";

}