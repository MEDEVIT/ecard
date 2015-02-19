/*
 * (C) SVC 2012
 */
package at.chipkarte.client.kse.soap.constants;

/**
 * Konstanten für die Sortierungsvariante bei der Suche nach Konsultationen,
 * {@link at.chipkarte.client.kse.soap.IKseService#getKonsultationsdaten}.
 */
public class Sortierung {
  
  /**
   * Sortierung nach KV-Träger.
   */
  public static final String KVT = "1";

  /**
   * Sortierung nach Patient.
   */
  public static final String PATIENT = "2";

  /**
   * Sortierung nach Behandlungsdatum.
   */
  public static final String BEHANDLUNGSDATUM = "3";
  
  /**
   * Sortierung nach Behandlungsfall.
   */
  public static final String BEHANDLUNGSFALL= "4";
  
  /**
   * Sortierung nach Fachgebiet.
   */
  public static final String FACHGEBIET= "5";

  private Sortierung() {
  }

  /**
   * Enum-based accessor.
   * @exclude
   */
  public static enum Enum {
    
    KVT(Sortierung.KVT),
    PATIENT(Sortierung.PATIENT),
    BEHANDLUNGSDATUM(Sortierung.BEHANDLUNGSDATUM),
    BEHANDLUNGSFALL(Sortierung.BEHANDLUNGSFALL),
    FACHGEBIET(Sortierung.FACHGEBIET);
    
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
