/*
 * (C) SVC 2012
 */
package at.chipkarte.client.dmp.soap;

import at.chipkarte.client.dmp.soap.constants.BetreuungsStatus;

/**
 * <p>
 * Enthält die Daten zu einem betreuten Patienten.
 * </p>
 */
public class BetreuterPatient {

  private SvPerson _patient;
  private String _svtCode;
  private String _fachgebietsCode;
  private String _dmpCode;
  private String _einschreibungSeit;
  private String _ausschreibungSeit;
  private String _untersuchungsDatum;

  /**
   * Code des Disease Management Programms, für das ein Betreuungsverhältnis für den Patienten besteht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap#getDMPs() Funktion getDMPs()}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Disease Management Programms
   */
  public String getDmpCode() {
    return _dmpCode;
  }

  /**
   * Code des Fachgebietes, für das ein Betreuungsverhältnis für den Patienten besteht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() Funktion getFachgebiete()}.<br>
   * Format: maximal 2-stellig.
   * @return FachgebietsCode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  /**
   * Beschreibung des Patienten.
   * @return SvPerson
   */
  public SvPerson getPatient() {
    return _patient;
  }

  /**
   * Code des Sozialversicherungsträgers, für den das Betreuungsverhältnis für den Patienten besteht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() Funktion getSVTs}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Sozialversicherungsträgers
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Datum, zu dem eine DMP Bindung vom DMP Backend eingeschrieben wurde.<br>
   * Versorgt, sobald der Betreuungsstatus auf "Ein" (siehe {@link BetreuungsStatus#EINGESCHRIEBEN}) gesetzt wird.<br>
   * Format: "TT.MM.JJJJ"
   * @return Datum der Einschreibung
   */
  public String getEinschreibungSeit() {
    return _einschreibungSeit;
  }

  /**
   * Datum, zu dem eine DMP Bindung vom DMP Backend ausgeschrieben wurde.<br>
   * Versorgt, sobald der Betreuungsstatus auf "Aus" (siehe {@link BetreuungsStatus#AUSGESCHRIEBEN}) gesetzt wird.<br>
   * Format: "TT.MM.JJJJ"
   * @return Datum der Ausschreibung
   */
  public String getAusschreibungSeit() {
    return _ausschreibungSeit;
  }

  /**
   * Untersuchungsdatum des zuletzt ausgefüllten DMP Blattes zu diesem Betreuungsverhältnis.<br>
   * Format: "TT.MM.JJJJ"
   * @return Untersuchungsdatum
   */
  public String getUntersuchungsdatum() {
    return _untersuchungsDatum;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  public void setPatient(SvPerson patient) {
    _patient = patient;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  public void setEinschreibungSeit(String einschreibungSeit) {
    _einschreibungSeit = einschreibungSeit;
  }

  public void setAusschreibungSeit(String ausschreibungSeit) {
    _ausschreibungSeit = ausschreibungSeit;
  }

  public void setUntersuchungsdatum(String untersuchungsDatum) {
    _untersuchungsDatum = untersuchungsDatum;
  }
}
