/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Daten zu einer SV-Person. Die Daten stammen vom e-card Serversystem.
 * </p>
 */
public class SvPerson {

  private String _svNummer;
  private String _vorname;
  private String _nachname;
  private String _titelVorne;
  private String _titelHinten;
  private String _geburtsdatum;
  private String _geschlecht;
  private String _druckVorname;
  private String _druckNachname;
  private String _druckTitelVorne;
  private String _druckTitelHinten;

  /**
   * Geburtsdatum der SV-Person.<br>
   * Format: "TT.MM.JJJJ".
   * @return Geburtsdatum
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Code des Geschlechts der SV-Person.<br>
   * Mögliche Werte siehe Konstante {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlecht}.<br>
   * Format: maximal 1-stellig.
   * @return Geschlecht
   */
  public String getGeschlecht() {
    return _geschlecht;
  }

  /**
   * Sozialversicherungsnummer der SV-Person.<br>
   * Format: 10-stellig, numerisch.
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Titel hinten der SV-Person.<br>
   * Format: maximal 30-stellig.
   * @return Titel hinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Titel vorne der SV-Person.<br>
   * Format: maximal 30-stellig.
   * @return Titel vorne
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  /**
   * Vorname der SV-Person.<br>
   * Format: maximal 70-stellig.
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * Nachname der SV-Person.<br>
   * Format: maximal 70-stellig.
   * @return Nachname
   */
  public String getNachname() {
    return _nachname;
  }

  /**
   * Druckvorname der SV-Person.<br>
   * Format: maximal 70-stellig.
   * @return Druckvorname
   */
  public String getDruckVorname() {
    return _druckVorname;
  }

  /**
   * Druckitel vorne der SV-Person.<br>
   * Format: maximal 30-stellig.
   * @return Druckitel vorne
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  /**
   * Druckitel vorne der SV-Person.<br>
   * Format: maximal 30-stellig.
   * @return Druckitel vorne
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  /**
   * Drucknachname der SV-Person.<br>
   * Format: maximal 70-stellig.
   * @return Drucknachname
   */
  public String getDruckNachname() {
    return _druckNachname;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  public void setGeschlecht(String geschlecht) {
    _geschlecht = geschlecht;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  public void setNachname(String nachname) {
    _nachname = nachname;
  }

  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }

  public void setDruckNachname(String druckNachname) {
    _druckNachname = druckNachname;
  }

  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }

  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }



}
