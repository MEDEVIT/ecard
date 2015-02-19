/*
 * (C) SVC 2011
 */
package at.chipkarte.client.dbas.soap;

/**
 * Diese Klasse hält die Daten eines Betreuungsverhältnisses, an das das entsprechende Datenblatt zugeordnet werden kann.
 */
public class Betreuung {

  /**
   * _bvId
   */
  private Long _bvId;
  /**
   * _ausschreibedatum
   */
  private String _ausschreibedatum;
  /**
   * _antragsdatum
   */
  private String _antragsdatum;
  /**
   * _fachgebietsCode
   */
  private String _fachgebietsCode;
  /**
   * _svtCode
   */
  private String _svtCode;

  /**
   * Eindeutige Nummer des Betreuungsverhältnisses.<br>
   * Format: maximal 19-stellig
   * @return BvId.
   */
  public Long getBvId() {
    return _bvId;
  }

  public void setBvId(Long bvId) {
    _bvId = bvId;
  }

  /**
   * Datum der Ausschreibung.<br>
   * Format: TT.MM.JJJJ
   * @return Ausschreibedatum.
   */
  public String getAusschreibedatum() {
    return _ausschreibedatum;
  }

  public void setAusschreibedatum(String ausschreibedatum) {
    _ausschreibedatum = ausschreibedatum;
  }

  /**
   * Datum der Antragstellung beziehungsweise frühest mögliches Untersuchungsdatum eines Dokumentations-/Befundblattes zu der Einschreibung.<br>
   * Format: TT.MM.JJJJ
   * @return Antragsdatum.
   */
  public String getAntragsdatum() {
    return _antragsdatum;
  }

  public void setAntragsdatum(String antragsdatum) {
    _antragsdatum = antragsdatum;
  }

  /**
   * Code des Fachgebietes, zu dem eingeschrieben wurde.<br>
   * Format: maximal 2-stellig
   * @return FachgebietsCode.
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  /**
   * Code des SVT, zu dem eingeschrieben wurde.<br>
   * Format: maximal 2-stellig
   * @return SvtCode.
   */
  public String getSvtCode() {
    return _svtCode;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
}
