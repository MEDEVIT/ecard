package at.chipkarte.client.prop.soap;

public class SvPatient {
  private String _svNummer;
  private String _geburtsdatum;
  private String _geschlechtscode;
  private String _titelVorne;
  private String _titelHinten;
  private String _vorname;
  private String _zuname;
  private String _druckVorname;
  private String _druckZuname;
  private String _druckTitelVorne;
  private String _druckTitelHinten;

  /**
   * Sozialversicherungsnummer des Patienten.<br>
   * Format: 10-stellig.
   * @return SV-Nummer des Patienten
   */
  public String getSvNummer() {
    return _svNummer;
  }
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }
  /**
   * Geburtsdatum des Patienten.<br>
   * Format: 10-stellig, TT.MM.JJJJ
   * @return Geburtsdatum des Patienten
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }
  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }
  /**
   * Geschlechtscode des Patienten.<br>
   * Format: 1-stellig, 'M' oder 'W'
   * @return Geschlechtscode
   */
  public String getGeschlechtscode() {
    return _geschlechtscode;
  }
  public void setGeschlechtscode(String geschlechtscode) {
    _geschlechtscode = geschlechtscode;
  }
  /**
   * Titel vorne (ohne diakritische Zeichen).<br>
   * Format: 30-stellig.
   * @return Titel vorne
   */
  public String getTitelVorne() {
    return _titelVorne;
  }
  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }
  /**
   * Titel hinten (ohne diakritische Zeichen).<br>
   * Format: 30-stellig.
   * @return Titel hinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }
  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }
  /**
   * Vorname (ohne diakritische Zeichen).<br>
   * Format: 70-stellig.
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }
  public void setVorname(String vorname) {
    _vorname = vorname;
  }
  /**
   * Zuname (ohne diakritische Zeichen).<br>
   * Format: 70-stellig.
   * @return Zuname
   */
  public String getZuname() {
    return _zuname;
  }
  public void setZuname(String zuname) {
    _zuname = zuname;
  }
  /**
   * Vorname (mit diakritischen Zeichen).<br>
   * Format: 70-stellig.
   * @return Vorname mit diakritischen Zeichen.
   */
  public String getDruckVorname() {
    return _druckVorname;
  }
  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }
  /**
   * Zuname (mit diakritischen Zeichen).
   * Format: 70-stellig.
   * @return Zuname mit diakritischen Zeichen
   */
  public String getDruckZuname() {
    return _druckZuname;
  }
  public void setDruckZuname(String druckZuname) {
    _druckZuname = druckZuname;
  }
  /**
   * Titel vorne (mit diakritischen Zeichen).<br>
   * Format: 30-stellig.
   * @return Titel vorne
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }
  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }
  /**
   * Titel hinten (mit diakritischen Zeichen).<br>
   * Format: 30-stellig.
   * @return Titel hinten
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }
  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }

}
