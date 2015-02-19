/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

/**
 * Konstanten für die Gründe warum der Behandlungsfall nacherfasst wird.
 */
public final class Nacherfassungsgrund {

  /**
   * Nacherfasste Konsultationen aufgrund von Hausbesuch.
   */
  public static final String NACHERFASSTE_KONSULTATION_HAUSBESUCH = "NHO";

  /**
   * Nacherfasste Konsultationen aufgrund einer Störung des e-card Systems.
   */
  public static final String NACHERFASSTE_KONSULTATION_STOERUNG = "NSO";

  /**
   * Nacherfasste Konsultationen aufgrund einer Behandlung außerhalb der Ordinationszeit.
   */
  public static final String AUSSERHALB_ORDINATIONSZEIT = "AOZ";

  /**
   * Nacherfasste Konsultationen aufgrund einer nachträglichen Anspruchsermittlung.
   */
  public static final String NACHTRAEGLICHE_ANSPRUCHSERMITTLUNG = "NNA";
  
  private Nacherfassungsgrund() {
  }
  
  /**
   * Enum-based accessor.
   * @exclude
   */
  public static enum Enum {
    
    NACHERFASSTE_KONSULTATION_HAUSBESUCH(Nacherfassungsgrund.NACHERFASSTE_KONSULTATION_HAUSBESUCH),
    NACHERFASSTE_KONSULTATION_STOERUNG(Nacherfassungsgrund.NACHERFASSTE_KONSULTATION_STOERUNG),
    AUSSERHALB_ORDINATIONSZEIT(Nacherfassungsgrund.AUSSERHALB_ORDINATIONSZEIT),
    NACHTRAEGLICHE_ANSPRUCHSERMITTLUNG(Nacherfassungsgrund.NACHTRAEGLICHE_ANSPRUCHSERMITTLUNG);
    
    private String _value; 

    private Enum(String value) {
      _value = value;
    }
    
    /** 
     * Returns an enum for the given String.
     */
    public static Enum getEnum(String s) {
      if (s == null) {
        return null;
      }
      for (Enum element : Enum.values()) {
        if (s.equals(element.getValue())) {
          return element;
        }
      }
      return null;
    }
    
    /** 
     * Returns the enum's value.
     */
    public String getValue() {
      return _value;
    }

  }

}