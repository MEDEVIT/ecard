/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Daten zur Anfrage sowie den Status der Anfrage.
 * </p>
 */
public class Anfrage {

  private String _dmpCode;
  private String _eingabeArt;
  private String _ausschreibeGrund;
  private String _anfrageZeitstempel;
  private SvPerson _patient;
  private String _anfrageStatus;
  private String _beMeldung;

  /**
   * Meldungstext des DMP-Backend zur Anfrage.<br>
   * Format: maximal 500-stellig.
   * @return Meldungstext
   */
  public String getBeMeldung() {
    return _beMeldung;
  }

  /**
   * Code des Disease Management Programms, für das die Anfrage erfolgt ist.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap#getDMPs() Funktion getDMPs()}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Disease Management Programms
   */
  public String getDmpCode() {
    return _dmpCode;
  }

  /**
   * Code, der die Art der Eingabe beschreibt.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap.constants.EingabeArt Konstante EingabeArt}.<br>
   * Format: maximal 1-stellig.
   * @return Eingabeart
   */
  public String getEingabeArt() {
    return _eingabeArt;
  }

  /**
   * Status der Anfrage.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap.constants.AnfrageStatus Konstante EingabeStatus}.<br>
   * Format: maximal 3-stellig.
   * @return Status der Eingabe
   */
  public String getAnfrageStatus() {
    return _anfrageStatus;
  }

  /**
   * Zeitpunkt zu dem die Anfrage getätigt wurde.<br>
   * Format: "TT.MM.JJJJ HH:MM".
   * @return EingabeZeitstempel
   */
  public String getAnfrageZeitstempel() {
    return _anfrageZeitstempel;
  }

  /**
   * Beschreibung des Patienten für den die Anfrage getätigt wurde.
   * @return SvPerson
   */
  public SvPerson getPatient() {
    return _patient;
  }

  /**
   * Code, der den Grund der Ausschreibung beschreibt.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap.constants.AusschreibeGrund Konstante AusschreibeGrund}.<br>
   * Format: maximal 2-stellig.
   * @return AusschreibeGrund
   */
  public String getAusschreibeGrund() {
    return _ausschreibeGrund;
  }

  public void setBeMeldung(String beMeldung) {
    _beMeldung = beMeldung;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setEingabeArt(String eingabeArt) {
    _eingabeArt = eingabeArt;
  }

  public void setAnfrageStatus(String anfrageStatus) {
    _anfrageStatus = anfrageStatus;
  }

  public void setAnfrageZeitstempel(String anfrageZeitstempel) {
    _anfrageZeitstempel = anfrageZeitstempel;
  }

  public void setPatient(SvPerson patient) {
    _patient = patient;
  }

  public void setAusschreibeGrund(String ausschreibeGrund) {
    _ausschreibeGrund = ausschreibeGrund;
  }

}
