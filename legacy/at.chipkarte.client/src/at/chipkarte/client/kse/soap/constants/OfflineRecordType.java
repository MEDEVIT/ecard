/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für den Type eines Offline Records.
 */
public final class OfflineRecordType extends Enum {

  /**
   * Der offline erfasste Datensatz ist eine Konsultation bzw. nacherfasste Konsultation.
   */
  public static final int KONSULTATION = 1;
  /** @exclude */
  public static OfflineRecordType KONSULTATION_ = new OfflineRecordType(KONSULTATION);

  /**
   * Der offline erfasste Datensatz ist eine Anfrage zum Nachsignieren.
   */
  public static final int NACHSIGNATUR = 2;
  /** @exclude */
  public static OfflineRecordType NACHSIGNATUR_ = new OfflineRecordType(NACHSIGNATUR);

  protected OfflineRecordType(String kseMessage) {
    super(kseMessage);
  }

  private OfflineRecordType(int att) {
    super(String.valueOf(att));
  }

  /** @exclude */
  public static OfflineRecordType getEnum(String enumString) {
    return (OfflineRecordType) getEnum(OfflineRecordType.class, enumString);
  }

  /** @exclude */
  public static OfflineRecordType getEnum(int enumInt) {
    return (OfflineRecordType) getEnum(OfflineRecordType.class, String.valueOf(enumInt));
  }

}
