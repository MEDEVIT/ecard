/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt Patienteninformationen.
 */
public class SvPatientInfo {
  private String _svNummer;
  private String _geburtsDatum;
  private String _geschlechtCode;
  private String _titelHinten;
  private String _titelVorne;
  private String _vorname;
  private String _zuname;
  private String _druckVorname;
  private String _druckZuname;
  private String _druckTitelHinten;
  private String _druckTitelVorne;

  /**
   * Sozialversicherungsnummer des Patienten.<br>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Geburtsdatum des Patienten.<br>
   * Die Angabe des Geburtsdatums ist optional.<br/>
   * Format: TT.MM.JJJJ<br>
   * @return GeburtsDatum
   */
  public String getGeburtsDatum() {
    return _geburtsDatum;
  }

  /**
   * Code des Geschlechts.<br>
   * Die Angabe des Codes des Geschlechts ist optional.<br/>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlecht}.<br/>
   * Format: 1-stellig.
   * @return GeschlechtCode
   */
  public String getGeschlechtCode() {
    return _geschlechtCode;
  }

  /**
   * Titel hinten des Patienten.<br>
   * Die Angabe des Titels hinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return TitelHinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Titel vorne des Patienten.<br>
   * Die Angabe des Titels vorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return TitelVorne
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  /**
   * Vorname des Patienten.<br>
   * Die Angabe des Vornamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * Zuname des Patienten.<br>
   * Die Angabe des Zunamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return Zuname
   */
  public String getZuname() {
    return _zuname;
  }

  /**
   * Drucktitel hinten des Patienten.<br>
   * Die Angabe des Titels hinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return TitelHinten
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  /**
   * Drucktitel vorne des Patienten.<br>
   * Die Angabe des Titels vorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return TitelVorne
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  /**
   * Druckvorname des Patienten.<br>
   * Die Angabe des Vornamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return Vorname
   */
  public String getDruckVorname() {
    return _druckVorname;
  }

  /**
   * Druckzuname des Patienten.<br>
   * Die Angabe des Zunamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return Zuname
   */
  public String getDruckZuname() {
    return _druckZuname;
  }

  /**
   * Sozialversicherungsnummer des Patienten.<br>
   * Format: maximal 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Geburtsdatum des Patienten.<br>
   * Die Angabe des Geburtsdatums ist optional.<br/>
   * Format: TT.MM.JJJJ<br>
   * @param geburtsDatum Der zu setzende Wert f&uuml;r GeburtsDatum.
   */
  public void setGeburtsDatum(String geburtsDatum) {
    _geburtsDatum = geburtsDatum;
  }

  /**
   * Code des Geschlechts.<br>
   * Die Angabe des Codes des Geschlechts ist optional.<br/>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlecht}.<br/>
   * Format: 1-stellig.
   * @param geschlechtCode Der zu setzende Wert f&uuml;r GeschlechtCode.
   */
  public void setGeschlechtCode(String geschlechtCode) {
    _geschlechtCode = geschlechtCode;
  }

  /**
   * Titel hinten des Patienten.<br>
   * Die Angabe des Titels hinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param titelHinten Der zu setzende Wert f&uuml;r TitelHinten.
   */
  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  /**
   * Titel vorne des Patienten.<br>
   * Die Angabe des Titels vorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param titelVorne Der zu setzende Wert f&uuml;r TitelVorne.
   */
  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }

  /**
   * Vorname des Patienten.<br>
   * Die Angabe des Vornamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param vorname Der zu setzende Wert f&uuml;r Vorname.
   */
  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
   * Zuname des Patienten.<br>
   * Die Angabe des Zunamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param zuname Der zu setzende Wert f&uuml;r Zuname.
   */
  public void setZuname(String zuname) {
    _zuname = zuname;
  }

  /**
   * Drucktitel hinten des Patienten.<br>
   * Die Angabe des Titels hinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param titelHinten Der zu setzende Wert f&uuml;r TitelHinten.
   */
  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }

  /**
   * Drucktitel vorne des Patienten.<br>
   * Die Angabe des Titels vorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param titelVorne Der zu setzende Wert f&uuml;r TitelVorne.
   */
  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }

  /**
   * Druckvorname des Patienten.<br>
   * Die Angabe des Vornamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param vorname Der zu setzende Wert f&uuml;r Vorname.
   */
  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }

  /**
   * Druckzuname des Patienten.<br>
   * Die Angabe des Zunamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param zuname Der zu setzende Wert f&uuml;r Zuname.
   */
  public void setDruckZuname(String druckZuname) {
    _druckZuname = druckZuname;
  }

}