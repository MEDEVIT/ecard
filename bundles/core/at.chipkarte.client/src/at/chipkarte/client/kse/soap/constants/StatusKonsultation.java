/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;



/**
 * Konstanten für den Status einer Konsultation.
 */
public final class StatusKonsultation {

  public static final int NEU = 1;

  public static final int STORNIERT = 2;

  public static final int WIEDER_IN_KRAFT_GESETZT = 3;

  public static final int GEAENDERT = 4;

  public static final int NACHSIGNIERT = 5;

  private StatusKonsultation() {
  }

}
