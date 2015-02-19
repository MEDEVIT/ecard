/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für erlaubte Konsultationsarten im Falle Nacherfassung.
 */
public final class Nacherfassungsgrund extends Enum {

  /**
   * Nacherfasste Konsultationen aufgrund von Hausbesuch.
   */
  public static final String NACHERFASSTE_KONSULTATION_HAUSBESUCH = "NHO";
  /**
   * @exclude
   */
  public static Nacherfassungsgrund NKH = new Nacherfassungsgrund(NACHERFASSTE_KONSULTATION_HAUSBESUCH);

  /**
   * Nacherfasste Konsultationen aufgrund einer Störung des e-card Systems.
   */
  public static final String NACHERFASSTE_KONSULTATION_STOERUNG = "NSO";
  /**
   * @exclude
   */
  public static Nacherfassungsgrund NKS = new Nacherfassungsgrund(NACHERFASSTE_KONSULTATION_STOERUNG);

  /**
   * Nacherfasste Konsultationen aufgrund einer Behandlung außerhalb der Ordinationszeit.
   */
  public static final String AUSSERHALB_ORDINATIONSZEIT = "AOZ";
  /**
   * @exclude
   */
  public static Nacherfassungsgrund AOZ = new Nacherfassungsgrund(AUSSERHALB_ORDINATIONSZEIT);

  private Nacherfassungsgrund(String att) {
    super(att);
  }

  /**
   * @exclude
   */
  public static Nacherfassungsgrund getEnum(String enumString) {
    return (Nacherfassungsgrund) getEnum(Nacherfassungsgrund.class, enumString);
  }

}