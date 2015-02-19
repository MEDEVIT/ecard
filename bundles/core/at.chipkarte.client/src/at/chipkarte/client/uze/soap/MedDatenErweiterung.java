/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.uze.soap;

/**
 * Enthält weitere medizinische Informationen die aufgrund unterschiedlicher SS12 bzw. Clientversion bei Erstellung 
 * bzw. Abfrage nicht über die Schnittstelle transportiert werden könnten..
 */
public class MedDatenErweiterung {
  
  private String _datenBezeichner;
  private String _datenInhalt;
  
  /**
   * Benennung des medizinischen Feldes<br/>
   * Format: maximal 50-stellig.
   * @return datenBezeichner
   */
  public String getDatenBezeichner() {
    return _datenBezeichner;
  }
  
  /**
   * Inhalt des medizinischen Feldes<br/>
   * Format: maximal 500-stellig.
   * @return datenInhalt
   */
  public String getDatenInhalt() {
    return _datenInhalt;
  }
  
  /**
   * Benennung des medizinischen Feldes<br/>
   * Format: maximal 50-stellig.
   * @param datenBezeichner Der zu setzende Wert f&uuml;r Benennung des medizinischen Feldes.
   */
  public void setDatenBezeichner(String datenBezeichner) {
    _datenBezeichner = datenBezeichner;
  }
  
  /**
   * Inhalt des medizinischen Feldes<br/>
   * Format: maximal 500-stellig.
   * @param datenInhalt Der zu setzende Wert f&uuml;r Inhalt des medizinischen Feldes.
   */
  public void setDatenInhalt(String datenInhalt) {
    _datenInhalt = datenInhalt;
  }

}
