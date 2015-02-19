package at.chipkarte.client.prop.soap;

public class EkvkPatient {

  private String _vorname;
  
  private String _zuname;
  
  private String _geburtsdatum;
  
  private String _geschlechtscode;
  
  private String _ekvkNummer;

  /**
   * Vorname des Patienten.<br>
   * Format: max. 70-stellig.
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
   * Zuname des Patienten.<br> 
   * Format: max. 70-stellig.
   * @return Zuname
   */
  public String getZuname() {
    return _zuname;
  }

  public void setZuname(String zuname) {
    _zuname = zuname;
  }

  /**
   *Geburtsdatum des Patienten.<br> 
   * Format: 10-stellig, TT.MM.JJJJ
   * @return Geburtsdatum
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  /**
   * Geschlechtscode des Patienten.<br> 
   * Format: Format: 1-stellig, 'M' oder 'W'
   * @return Zuname
   */
  public String getGeschlechtscode() {
    return _geschlechtscode;
  }

  public void setGeschlechtscode(String geschlechtscode) {
    _geschlechtscode = geschlechtscode;
  }

  /**
   * EKVK Nummer des Patienten.<br> 
   * Format: 20-stellig.
   * @return Zuname
   */
  public String getEkvkNummer() {
    return _ekvkNummer;
  }

  public void setEkvkNummer(String ekvkNummer) {
    _ekvkNummer = ekvkNummer;
  }
  
}
