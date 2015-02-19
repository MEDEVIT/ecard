/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 * Enthält die Daten eines Patienten. Die Daten stammen vom e-card-Serversystem.
 */
public class SvPersonV2 {

  private String _titelVorne;
  private String _vorname;
  private String _nachname;
  private String _titelHinten;
  private String _druckTitelVorne;
  private String _druckVorname;
  private String _druckNachname;
  private String _druckTitelHinten;
  private String _geburtsdatum;
  private String _geschlecht;
  private String _svNummer;

  /**
   * Geburtsdatum des Patienten.
   * <br>Format: TT.MM.JJJJ
   * 
   * @return Geburtsdatum.
   *  
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Code des Geschlechts des Patienten.
   * <br>Mögliche Werte siehe
   * {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlechtscodes}.
   * <br>Format: 1-stellig
   * 
   * @return Geschlecht
   */
  public String getGeschlecht() {
    return _geschlecht;
  }

  /**
   * Nachname des Patienten im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 70-stellig
   * 
   * @return Nachname
   *  
   */
  public String getNachname() {
    return _nachname;
  }

  /**
   * Titel hinten des Patienten im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 30-stellig
   * 
   * @return Titel hinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Titel vorne des Patienten im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 30-stellig
   * @return Titel vorne 
   *         
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  /**
   * Vorname des Patienten im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 70-stellig
   * @return Vorname
   *         
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * Nachname des Patienten im UTF-8 Zeichensatz.
   * <br>Format: maximal 70-stellig
   * 
   * @return Drucknachname
   *  
   */
  public String getDruckNachname() {
    return _druckNachname;
  }
  
  /**
   * Titel hinten des Patienten im UTF-8 Zeichensatz.
   * <br>Format: maximal 30-stellig
   * 
   * @return Drucktitel hinten
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }
  
  /**
   * Titel vorne des Patienten im UTF-8 Zeichensatz.
   * <br>Format: maximal 30-stellig
   * @return Drucktitel vorne 
   *         
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }
  
  /**
   * Vorname des Patienten im UTF-8 Zeichensatz.
   * <br>Format: maximal 70-stellig
   * @return Druckvorname
   *         
   */
  public String getDruckVorname() {
    return _druckVorname;
  }
  
  public void setGeburtsdatum(String geburtsdatum) {
    this._geburtsdatum = geburtsdatum;
  }

  public void setGeschlecht(String geschlecht) {
    this._geschlecht = geschlecht;
  }

  public void setNachname(String nachname) {
    this._nachname = nachname;
  }

  public void setTitelHinten(String titelHinten) {
    this._titelHinten = titelHinten;
  }

  public void setTitelVorne(String titelVorne) {
    this._titelVorne = titelVorne;
  }

  public void setVorname(String vorname) {
    this._vorname = vorname;
  }

  public void setDruckNachname(String druckNachname) {
    this._druckNachname = druckNachname;
  }
  
  public void setDruckTitelHinten(String druckTitelHinten) {
    this._druckTitelHinten = druckTitelHinten;
  }
  
  public void setDruckTitelVorne(String druckTitelVorne) {
    this._druckTitelVorne = druckTitelVorne;
  }
  
  public void setDruckVorname(String druckVorname) {
    this._druckVorname = druckVorname;
  }
  
  /**
   * Sozialversicherungsnummer des Patienten.
   * <br>Format: 10-stellig
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String svNummer) {
    this._svNummer = svNummer;
  }

}