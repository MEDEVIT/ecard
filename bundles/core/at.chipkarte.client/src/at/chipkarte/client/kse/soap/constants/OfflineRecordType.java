/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;


/**
 * Konstanten für den Typ eines Offline-Records (Offlinekonsultation).
 */
public final class OfflineRecordType {

  /**
   * Der offline erfasste Datensatz ist eine Konsultation beziehungsweise nacherfasste Konsultation.
   */
  public static final int KONSULTATION = 1;

  /**
   * Der offline erfasste Datensatz ist eine Anfrage zum Nachsignieren.
   */
  public static final int NACHSIGNATUR = 2;

  private OfflineRecordType() {
  }

}
