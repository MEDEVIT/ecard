/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für den Status einer Konsultation.
 */
public final class StatusKonsultation extends Enum {

  public static final int NEU = 1;
  /** @exclude */
  public static StatusKonsultation NEU_ = new StatusKonsultation(NEU);

  public static final int STORNIERT = 2;
  /** @exclude */
  public static StatusKonsultation STORNIERT_ = new StatusKonsultation(STORNIERT);

  public static final int WIEDER_IN_KRAFT_GESETZT = 3;
  /** @exclude */
  public static StatusKonsultation WIEDER_IN_KRAFT_GESETZT_ = new StatusKonsultation(WIEDER_IN_KRAFT_GESETZT);

  public static final int GEAENDERT = 4;
  /** @exclude */
  public static StatusKonsultation GEAENDERT_ = new StatusKonsultation(GEAENDERT);

  public static final int NACHSIGNIERT = 5;
  /** @exclude */
  public static StatusKonsultation NACHSIGNIERT_ = new StatusKonsultation(NACHSIGNIERT);

  protected StatusKonsultation(String statusKonsultation) {
    super(statusKonsultation);
  }

  private StatusKonsultation(int statusKonsultation) {
    super(String.valueOf(statusKonsultation));
  }

  /** @exclude */
  public static StatusKonsultation getEnum(String enumString) {
    return (StatusKonsultation) getEnum(StatusKonsultation.class, enumString);
  }

  /** @exclude */
  public static StatusKonsultation getEnum(int enumInt) {
    return (StatusKonsultation) getEnum(StatusKonsultation.class, String.valueOf(enumInt));
  }

}
