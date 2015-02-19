/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.uze.soap;

/**
 * Enthält die medizinischen Daten für die Medikation die der Vertragspartner im Zuge der Erstellung einer 
 * Über-/Zu-/Einweisung erfasst.
 */
public class Medikament {
  
  private String _beschreibung;
  private MedikamentCode[] _codierungen;
  
  /**
   * Allgemeine Beschreibung zur Medikation<br/>
   * Format: maximal 500-stellig.
   * @return codebeschreibung
   */
  public String getBeschreibung() {
    return _beschreibung;
  }
  
  /**
   * Vom Leistungsanforderer erfassten Medikament-Codierungen<br/>
   * Format: maximal 20.
   * @return codierungen
   */
  public MedikamentCode[] getCodierungen() {
    return _codierungen;
  }
  
  /**
   * Allgemeine Beschreibung zur Medikation<br/>
   * Format: maximal 500-stellig.
   * @param beschreibung Der zu setzende Wert f&uuml;r die Beschreibung.
   */
  public void setBeschreibung(String beschreibung) {
    _beschreibung = beschreibung;
  }
  
  /**
   * Vom Leistungsanforderer erfassten Medikament-Codierungen<br/>
   * Format: maximal 20.
   * @param codierungen
   */
  public void setCodierungen(MedikamentCode[] codierungen) {
    _codierungen = codierungen;
  }

}
