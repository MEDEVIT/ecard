package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Daten einer Patientin.
 */
public class BKFPatientInfo {

  private String _svNummer;
  private String _geburtsdatum;
  private String _geschlechtscode;
  private String _titelVorne;
  private String _titelHinten;
  private String _vorname;
  private String _zuname;
  private String _druckTitelVorne;
  private String _druckTitelHinten;
  private String _druckVorname;
  private String _druckZuname;

  /**
   * Sozialversicherungsnummer der Patientin. <br>
   * Angabe: Muss.<br>
   * Format: 10-stellig
   * @return SvNummer.
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Geburtsdatum der Patientin. <br>
   * Format: TT.MM.JJJJ 
   * @return Geburtsdatum.
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  /**
   * Geschlechtscode der Patientin. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlechtscodes}. <br>
   * Format: 1-stellig 
   * @return Geschlechtscode.
   */
  public String getGeschlechtscode() {
    return _geschlechtscode;
  }

  public void setGeschlechtscode(String geschlechtscode) {
    _geschlechtscode = geschlechtscode;
  }

  /**
   * Titel vorne der Patientin. <br>
   * Format: maximal 30-stellig 
   * @return TitelVorne.
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }

  /**
   * Titel hinten der Patientin. <br>
   * Format: maximal 30-stellig 
   * @return TitelHinten.
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  /**
   * Vorname der Patientin. <br>
   * Format: maximal 70-stellig 
   * @return Vorname.
   */
  public String getVorname() {
    return _vorname;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
   * Zuname der Patientin. <br>
   * Format: maximal 70-stellig 
   * @return Zuname.
   */
  public String getZuname() {
    return _zuname;
  }

  public void setZuname(String zuname) {
    _zuname = zuname;
  }

  /**
   * Drucktitel vorne der Patientin. <br>
   * Format: maximal 30-stellig 
   * @return TitelVorne.
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }

  /**
   * Drucktitel hinten der Patientin. <br>
   * Format: maximal 30-stellig 
   * @return DruckTitelHinten.
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }

  /**
   * Druckvorname der Patientin. <br>
   * Format: maximal 70-stellig
   * @return DruckVorname.
   */
  public String getDruckVorname() {
    return _druckVorname;
  }

  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }

  /**
   * Druckzuname der Patientin. <br>
   * Format: maximal 70-stellig
   * @return DruckZuname.
   */
  public String getDruckZuname() {
    return _druckZuname;
  }

  public void setDruckZuname(String druckZuname) {
    _druckZuname = druckZuname;
  }
}