package at.chipkarte.client.uze.soap;
/*
 * (C) Siemens and SVCBE 2007
 */

/**
 * Enth&auml;lt Daten zu einer Vertragspartner- Ordination.
 */
public class VpOrdinationInfo {
  private Long _ordinationsId;
  private Long _taetigkeitsbereichId;
  private String _anredeCode;
  private String[] _fachgebiete;
  private String _ort;
  private String _pLZ;
  private String _strasse;
  private String _titelHinten;
  private String _titelVorne;
  private String _vorname;
  private String _vpNummer;
  private String _zuname;
  private String _druckVorname;
  private String _druckZuname;
  private String _druckTitelHinten;
  private String _druckTitelVorne;

  /**
   * Eindeutige ID der Ordination.<br>
   * @return OrdinationsId
   */
  public Long getOrdinationsId() {
    return _ordinationsId;
  }

  /**
   * Eindeutige ID des Tätigkeitsbereiches.<br>
   * @return taetigkeitsbereichId
   */
  public Long getTaetigkeitsbereichId() {
    return _taetigkeitsbereichId;
  }

  /**
   * Code der Anrede.<br>
   * Format: 1-stellig.
   * @return AnredeCode
   */
  public String getAnredeCode() {
    return _anredeCode;
  }

  /**
   * Codes der Fachgebiete des Vertragspartners in der mit Ordinations ID und Tätigkeitsbereich ID
   * identifizierten Ordination.<br>
   * @return Fachgebiete
   */
  public String[] getFachgebiete() {
    return _fachgebiete;
  }

  /**
   * Ort der Ordination.<br>
   * Format: maximal 40-stellig.
   * @return Ort
   */
  public String getOrt() {
    return _ort;
  }

  /**
   * Postleitzahl der Ordination.<br>
   * Format: maximal 9-stellig.
   * @return PLZ
   */
  public String getPLZ() {
    return _pLZ;
  }

  /**
   * Straße der Ordination.<br>
   * Format: maximal 60-stellig.
   * @return Strasse
   */
  public String getStrasse() {
    return _strasse;
  }

  /**
   * Titel hinten des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @return TitelHinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Titel vorne des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @return TitelVorne
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  /**
   * Vorname oder Organisationsbezeichnung des Vertragspartners.<br>
   * Format: maximal 70-stellig.
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * Druckitel hinten des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @return TitelHinten
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  /**
   * Drucktitel vorne des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @return TitelVorne
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  /**
   * Druckvorname oder Organisationsbezeichnung des Vertragspartners.<br>
   * Format: maximal 70-stellig.
   * @return DruckVorname
   */
  public String getDruckVorname() {
    return _druckVorname;
  }
  
  /**
   * Druckzuname des Vertragspartners.<br>
   * Format: maximal 70-stellig.
   * @return DruckZuname
   */
  public String getDruckZuname() {
    return _druckZuname;
  }

  /**
   * Vertragspartnernummer.<br>
   * Format: maximal 6-stellig.
   * @return VpNummer
   */
  public String getVpNummer() {
    return _vpNummer;
  }

  /**
   * Zuname oder Organisationsbezeichnung des Vertragspartners /
   * Name oder Organisationsbezeichnung des Labors beziehungsweise Institutes.<br>
   * Format: maximal 70-stellig.
   * @return Zuname
   */
  public String getZuname() {
    return _zuname;
  }

  /**
   * Eindeutige ID der Ordination.<br>
   * @param ordinationsId Der zu setzende Wert f&uuml;r OrdinationsId.
   */
  public void setOrdinationsId(Long ordinationsId) {
    _ordinationsId = ordinationsId;
  }

  /**
   * Eindeutige ID des Tätigkeitsbereiches.<br>
   * @param taetigkeitsbereichId Der zu setzende Wert f&uuml;r TaetigkeitsbereichId.
   */
  public void setTaetigkeitsbereichId(Long taetigkeitsbereichId) {
    _taetigkeitsbereichId = taetigkeitsbereichId;
  }

  /**
   * Code der Anrede.<br>
   * Format: 1-stellig.
   * @param anredeCode Der zu setzende Wert f&uuml;r AnredeCode.
   */
  public void setAnredeCode(String anredeCode) {
    _anredeCode = anredeCode;
  }

  /**
   * Codes der Fachgebiete des Vertragspartners in der mit Ordinations ID und Tätigkeitsbereich ID
   * identifizierten Ordination.<br>
   * @param fachgebiete Der zu setzende Wert f&uuml;r Fachgebiete.
   */
  public void setFachgebiete(String[] fachgebiete) {
    _fachgebiete = fachgebiete;
  }

  /**
   * Ort der Ordination.<br>
   * Format: maximal 40-stellig.
   * @param ort Der zu setzende Wert f&uuml;r Ort.
   */
  public void setOrt(String ort) {
    _ort = ort;
  }

  /**
   * Postleitzahl der Ordination.<br>
   * Format: maximal 9-stellig.
   * @param pLZ Der zu setzende Wert f&uuml;r PLZ.
   */
  public void setPLZ(String pLZ) {
    _pLZ = pLZ;
  }

  /**
   * Straße der Ordination.<br>
   * Format: maximal 60-stellig.
   * @param strasse Der zu setzende Wert f&uuml;r Strasse.
   */
  public void setStrasse(String strasse) {
    _strasse = strasse;
  }

  /**
   * Titel hinten des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @param titelHinten Der zu setzende Wert f&uuml;r TitelHinten.
   */
  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  /**
   * Titel vorne des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @param titelVorne Der zu setzende Wert f&uuml;r TitelVorne.
   */
  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }

  /**
   * Vorname oder Organisationsbezeichnung des Vertragspartners.<br>
   * Format: maximal 70-stellig.
   * @param vorname Der zu setzende Wert f&uuml;r Vorname.
   */
  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
   * Vertragspartnernummer.<br>
   * Format: maximal 6-stellig.
   * @param vpNummer Der zu setzende Wert f&uuml;r VpNummer.
   */
  public void setVpNummer(String vpNummer) {
    _vpNummer = vpNummer;
  }

  /**
   * Zuname oder Organisationsbezeichnung des Vertragspartners /
   * Name oder Organisationsbezeichnung des Labors beziehungsweise Institutes.<br>
   * Format: maximal 70-stellig.
   * @param zuname Der zu setzende Wert f&uuml;r Zuname.
   */
  public void setZuname(String zuname) {
    _zuname = zuname;
  }

  /**
   * Drucktitel hinten des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @param titelHinten Der zu setzende Wert f&uuml;r TitelHinten.
   */
  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }

  /**
   * Drucktitel vorne des Vertragspartners.<br>
   * Format: maximal 30-stellig.
   * @param titelVorne Der zu setzende Wert f&uuml;r TitelVorne.
   */
  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }

  /**
   * Druckvorname oder Organisationsbezeichnung des Vertragspartners.<br>
   * Format: maximal 70-stellig.
   * @param vorname Der zu setzende Wert f&uuml;r Vorname.
   */
  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }

  /**
   * Druckzuname oder Organisationsbezeichnung des Vertragspartners /
   * Name oder Organisationsbezeichnung des Labors beziehungsweise Institutes.<br>
   * Format: maximal 70-stellig.
   * @param zuname Der zu setzende Wert f&uuml;r Zuname.
   */
  public void setDruckZuname(String druckZuname) {
    _druckZuname = druckZuname;
  }

}
