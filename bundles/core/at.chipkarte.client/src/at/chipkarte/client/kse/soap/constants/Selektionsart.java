/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;


/**
 * Konstanten für die Selektionsart bei der Suche nach Konsultationen,
 * {@link at.chipkarte.client.kse.soap.IKseService#getKonsultationsdaten}.
 */
public final class Selektionsart {

  /**
   * Alle zum aktuellen Datum stornier- beziehungsweise änderbare Konsultationen werden gesucht.
   */
  public static final String MODIFIZIERBAR = "MODIFIZIERBAR";

  /**
   * Alle zum aktuellen Datum stornierten (und somit wieder in Kraft setzbaren) Konsultationen werden gesucht.
   */
  public static final String STORNIERT = "STORNIERT";

  /**
   * Alle zum aktuellen Datum verfügbaren Konsultationen werden gesucht.
   */
  public static final String ALLE = "ALLE";

  private Selektionsart() {
  }

  /**
   * Enum-based accessor.
   * @exclude
   */
  public static enum Enum {
    
    MODIFIZIERBAR(Selektionsart.MODIFIZIERBAR),
    STORNIERT(Selektionsart.STORNIERT),
    ALLE(Selektionsart.ALLE);
    
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
