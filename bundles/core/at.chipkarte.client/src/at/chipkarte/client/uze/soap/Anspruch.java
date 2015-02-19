/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Daten f&uuml;r einen eigenen Anspruch bzw. f&uuml;r einen abgeleiteten Anspruch.
 */
public class Anspruch {
  private String _anspruchId;
  private String _abgeleitetSvNummer;
  private String _abgeleitetTitelHinten;
  private String _abgeleitetTitelVorne;
  private String _abgeleitetVorname;
  private String _abgeleitetZuname;
  private String _svtCode;
  private String _abgeleitetDruckTitelHinten;
  private String _abgeleitetDruckTitelVorne;
  private String _abgeleitetDruckVorname;
  private String _abgeleitetDruckZuname;

  /**
   * Eindeutiger Bezeichner f&uuml;r einen Anspruch (eigener oder abgeleiteter).<br>
   * Format: maximal 19-stellig.
   * @return AnspruchId
   */
  public String getAnspruchId() {
    return _anspruchId;
  }

  /**
   * Sozialversicherungsnummer der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe der Sozialversicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @return AbgeleitetSvNummer
   */
  public String getAbgeleitetSvNummer() {
    return _abgeleitetSvNummer;
  }

  /**
   * Titel hinten der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelHinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return AbgeleitetTitelHinten
   */
  public String getAbgeleitetTitelHinten() {
    return _abgeleitetTitelHinten;
  }

  /**
   * Titel vorne der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelVorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return AbgeleitetTitelVorne
   */
  public String getAbgeleitetTitelVorne() {
    return _abgeleitetTitelVorne;
  }

  /**
   * Vorname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetVorname ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return AbgeleitetVorname
   */
  public String getAbgeleitetVorname() {
    return _abgeleitetVorname;
  }

  /**
   * Zuname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetZuname ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return AbgeleitetZuname
   */
  public String getAbgeleitetZuname() {
    return _abgeleitetZuname;
  }

  /**
   * Drucktitel hinten der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelHinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return AbgeleitetTitelHinten
   */
  public String getAbgeleitetDruckTitelHinten() {
    return _abgeleitetDruckTitelHinten;
  }

  /**
   * Drucktitel vorne der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelVorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return AbgeleitetTitelVorne
   */
  public String getAbgeleitetDruckTitelVorne() {
    return _abgeleitetDruckTitelVorne;
  }

  /**
   * Vorname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetVorname ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return AbgeleitetVorname
   */
  public String getAbgeleitetDruckVorname() {
    return _abgeleitetDruckVorname;
  }

  /**
   * Druckzuname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetZuname ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return AbgeleitetZuname
   */
  public String getAbgeleitetDruckZuname() {
    return _abgeleitetDruckZuname;
  }

  /**
   * Code des SVT, bei dem der Anspruch besteht.<br>
   * Format: 2-stellig.
   * @return SvtCode
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Eindeutiger Bezeichner f&uuml;r einen Anspruch (eigener oder abgeleiteter).<br>
   * Format: maximal 19-stellig.
   * @param anspruchId Der zu setzende Wert f&uuml;r AnspruchId.
   */
  public void setAnspruchId(String anspruchId) {
    _anspruchId = anspruchId;
  }

  /**
   * Sozialversicherungsnummer der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetSvNummer ist optional.<br/>
   * Format: 10-stellig.
   * @param abgeleitetSvNummer Der zu setzende Wert f&uuml;r AbgeleitetSvNummer.
   */
  public void setAbgeleitetSvNummer(String abgeleitetSvNummer) {
    _abgeleitetSvNummer = abgeleitetSvNummer;
  }

  /**
   * Titel hinten der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelHinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param abgeleitetTitelHinten Der zu setzende Wert f&uuml;r AbgeleitetTitelHinten.
   */
  public void setAbgeleitetTitelHinten(String abgeleitetTitelHinten) {
    _abgeleitetTitelHinten = abgeleitetTitelHinten;
  }

  /**
   * Titel vorne der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelVorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param abgeleitetTitelVorne Der zu setzende Wert f&uuml;r AbgeleitetTitelVorne.
   */
  public void setAbgeleitetTitelVorne(String abgeleitetTitelVorne) {
    _abgeleitetTitelVorne = abgeleitetTitelVorne;
  }

  /**
   * Vorname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetVorname ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param abgeleitetVorname Der zu setzende Wert f&uuml;r AbgeleitetVorname.
   */
  public void setAbgeleitetVorname(String abgeleitetVorname) {
    _abgeleitetVorname = abgeleitetVorname;
  }

  /**
   * Zuname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetZuname ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param abgeleitetZuname Der zu setzende Wert f&uuml;r AbgeleitetZuname.
   */
  public void setAbgeleitetZuname(String abgeleitetZuname) {
    _abgeleitetZuname = abgeleitetZuname;
  }


  /**
   * Drucktitel hinten der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelHinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param abgeleitetTitelHinten Der zu setzende Wert f&uuml;r AbgeleitetTitelHinten.
   */
  public void setAbgeleitetDruckTitelHinten(String abgeleitetDruckTitelHinten) {
    _abgeleitetDruckTitelHinten = abgeleitetDruckTitelHinten;
  }

  /**
   * Drucktitel vorne der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetTitelVorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param abgeleitetTitelVorne Der zu setzende Wert f&uuml;r AbgeleitetTitelVorne.
   */
  public void setAbgeleitetDruckTitelVorne(String abgeleitetDruckTitelVorne) {
    _abgeleitetDruckTitelVorne = abgeleitetDruckTitelVorne;
  }

  /**
   * Druckvorname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetVorname ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param abgeleitetVorname Der zu setzende Wert f&uuml;r AbgeleitetVorname.
   */
  public void setAbgeleitetDruckVorname(String abgeleitetDruckVorname) {
    _abgeleitetDruckVorname = abgeleitetDruckVorname;
  }

  /**
   * Druckzuname der SV-Person, von der der Anspruch abgeleitet ist.<br>
   * Die Angabe von AbgeleitetZuname ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param abgeleitetZuname Der zu setzende Wert f&uuml;r AbgeleitetZuname.
   */
  public void setAbgeleitetDruckZuname(String abgeleitetDruckZuname) {
    _abgeleitetDruckZuname = abgeleitetDruckZuname;
  }

  /**
   * Code des SVT, bei dem der Anspruch besteht.<br>
   * Format: 2-stellig.
   * @param svtCode Der zu setzende Wert f&uuml;r SvtCode.
   */
  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

}
