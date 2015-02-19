/*
 * CAUTION!! THIS IS A GENERATED FILE! PLEASE DON'T EDIT IT! Your changes will be overwritten when the generation proccess is run
 * again. Instead, try to modify the sources from which the file was generated: - java source code files in the packages
 * at.chipkarte.client.dbas.core.api, at.chipkarte.client.dbas.core.api.valueobjects, at.chipkarte.ecard.server.dbas.api, and
 * at.chipkarte.ecard.server.dbas.api.valueobjects (specifically the javadoc tags in these files) - the configuration file
 * conf/generator.properties - the template from which this file was generated: templates/soapBean.vsl - the code of the generator
 * (C) SVC 2010
 */
package at.chipkarte.client.dbas.soap;

/**
 * <p>
 * Enthält das Ergebnis der Funktion
 * {@link at.chipkarte.client.dbas.soap.IDbasService#searchDmpData(String, String, String, String) searchDmpData}.
 * </p>
 */
public class PatientInfo {

  /**
   * _geburtsdatum
   */
  private String _geburtsdatum;
  /**
   * _geschlechtscode
   */
  private String _geschlechtscode;
  /**
   * _titelHinten
   */
  private String _titelHinten;
  /**
   * _titelVorne
   */
  private String _titelVorne;
  /**
   * _vorname
   */
  private String _vorname;
  /**
   * _zuname
   */
  private String _zuname;
  /**
   * _svNummer
   */
  private String _svNummer;
  /**
   * _druckVorname
   */
  private String _druckVorname;
  /**
   * _druckZuname
   */
  private String _druckZuname;
  /**
   * _druckTitelHinten
   */
  private String _druckTitelHinten;
  /**
   * _druckTitelVorne
   */
  private String _druckTitelVorne;

  /**
   * Geburtsdatum der SV-Person. <br>
   * Format: TT.MM.JJJJ
   * @return Geburtsdatum.
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  public void setGeburtsdatum(String _geburtsdatum) {
    this._geburtsdatum = _geburtsdatum;
  }

  /**
   * Geschlechtscode der SV-Person. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlechtscodes}.<br>
   * Format: maximal 1-stellig
   * @return Geschlechtscode.
   */
  public String getGeschlechtscode() {
    return _geschlechtscode;
  }

  public void setGeschlechtscode(String _geschlechtscode) {
    this._geschlechtscode = _geschlechtscode;
  }

  /**
   * Titel hinten der SV-Person. <br>
   * Format: maximal 30-stellig
   * @return TitelHinten.
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  public void setTitelHinten(String _titelHinten) {
    this._titelHinten = _titelHinten;
  }

  /**
   * Titel vorne der SV-Person. <br>
   * Format: maximal 30-stellig
   * @return TitelVorne.
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  public void setTitelVorne(String _titelVorne) {
    this._titelVorne = _titelVorne;
  }

  /**
   * Vorname der SV-Person. <br>
   * Format: maximal 70-stellig
   * @return Vorname.
   */
  public String getVorname() {
    return _vorname;
  }

  public void setVorname(String _vorname) {
    this._vorname = _vorname;
  }

  /**
   * druckZuname der SV-Person. <br>
   * Format: maximal 70-stellig
   * @return druckZuname.
   */
  public String getDruckZuname() {
    return _druckZuname;
  }

  public void setDruckZuname(String _druckZuname) {
    this._druckZuname = _druckZuname;
  }

  /**
   * Sozialversicherungsnummer der SV-Person. <br>
   * Format: maximal 10-stellig
   * @return SvNummer.
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String _svNummer) {
    this._svNummer = _svNummer;
  }

  /**
   * druckVorname der SV-Person. <br>
   * Format: maximal 70-stellig
   * @return druckVorname.
   */
  public String getDruckVorname() {
    return _druckVorname;
  }

  public void setDruckVorname(String _druckVorname) {
    this._druckVorname = _druckVorname;
  }

  /**
   * Zuname der SV-Person. <br>
   * Format: maximal 70-stellig
   * @return Zuname.
   */
  public String getZuname() {
    return _zuname;
  }

  public void setZuname(String _zuname) {
    this._zuname = _zuname;
  }

  /**
   * Drucktitel hinten der SV-Person. <br>
   * Format: maximal 30-stellig
   * @return druckTitelHinten.
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  public void setDruckTitelHinten(String _druckTitelHinten) {
    this._druckTitelHinten = _druckTitelHinten;
  }

  /**
   * Drucktitel vorne der SV-Person. <br>
   * Format: maximal 30-stellig
   * @return druckTitelVorne.
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  public void setDruckTitelVorne(String _druckTitelVorne) {
    this._druckTitelVorne = _druckTitelVorne;
  }
}