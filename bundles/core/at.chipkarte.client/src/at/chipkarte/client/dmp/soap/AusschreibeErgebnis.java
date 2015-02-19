/*
 * (C) SVC 2012
 */
package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Daten zu einer erfolgreich durchgeführten DMP Ausschreibeanfrage.
 * </p>
 */
public class AusschreibeErgebnis {

  private SvPerson _patient;
  private String _dmpCode;
  private String _ausschreibeZeitstempel;
  private String _ausschreibeStatus;

  /**
   * Daten zum DMP-Patient.
   * @return SvPerson
   */
  public SvPerson getPatient() {
    return _patient;
  }

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
   * Zeitpunkt, ab dem die Ausschreibung zur Weitergabe zum DMP-Backend bereitsteht.<br>
   * Format: "TT.MM.JJJJ HH:MM".
   * @return AusschreibeZeitstempel
   */
  public String getAusschreibeZeitstempel() {
    return _ausschreibeZeitstempel;
  }

  /**
   * Status der Ausschreibung.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap.constants.AnfrageStatus Konstante AnfrageStatus}.<br>
   * Format: maximal 3-stellig.
   * @return Status der Ausschreibung
   */
  public String getAusschreibeStatus() {
    return _ausschreibeStatus;
  }

  public void setPatient(SvPerson patient) {
    _patient = patient;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setAusschreibeZeitstempel(String ausschreibeZeitstempel) {
    _ausschreibeZeitstempel = ausschreibeZeitstempel;
  }

  public void setAusschreibeStatus(String ausschreibeStatus) {
    _ausschreibeStatus = ausschreibeStatus;
  }

}
