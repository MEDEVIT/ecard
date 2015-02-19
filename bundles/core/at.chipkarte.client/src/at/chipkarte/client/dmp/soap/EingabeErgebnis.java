/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Daten zu einer erfolgreich durchgeführten DMP-Eingabe.
 * </p>
 */
public class EingabeErgebnis {

  private SvPerson _patient;
  private String _svtCode;
  private String _fachgebietsCode;
  private String _dmpCode;
  private String _eingabeZeitstempel;
  private String _eingabeStatus;
  private Zustelladresse _zustellAdresse;
  private String _telefonNummer;
  private String _emailAdresse;
  private Boolean _isUebersteuert;

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
   * Status der Eingabe.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dmp.soap.constants.AnfrageStatus Konstante AnfrageStatus}.<br>
   * Format: maximal 3-stellig.
   * @return Status der Eingabe
   */
  public String getEingabeStatus() {
    return _eingabeStatus;
  }

  /**
   * Zeitpunkt, ab dem die Eingabe zur Weitergabe zum DMP-Backend bereitsteht.<br>
   * Format: "TT.MM.JJJJ HH:MM".
   * @return EingabeZeitstempel
   */
  public String getEingabeZeitstempel() {
    return _eingabeZeitstempel;
  }

  /**
   * E-Mail-Adresse des Patienten.<br>
   * Format: maximal 256-stellig.
   * @return E-Mail-Adresse
   */
  public String getEmailAdresse() {
    return _emailAdresse;
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
   * Information, ob der Sozialversicherungsträger übersteuert wurde.
   * @return True, wenn der Sozialversicherungsträger übersteuert wurde, ansonsten False.
   */
  public Boolean isUebersteuert() {
    return _isUebersteuert;
  }

  /**
   * Daten zum DMP-Patient.
   * @return SvPerson
   */
  public SvPerson getPatient() {
    return _patient;
  }

  /**
   * Code des Sozialversicherungsträgers, für den ein Betreuungsverhältnis für den Patienten besteht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() Funktion getSVTs}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Sozialversicherungsträgers
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Telefonnummer des Patienten.<br>
   * Format: maximal 50-stellig.
   * @return Telefonnummer
   */
  public String getTelefonNummer() {
    return _telefonNummer;
  }

  /**
   * Adresse des Patienten für die Zustellung der Eingabe.
   * @return Zustelladresse
   */
  public Zustelladresse getZustellAdresse() {
    return _zustellAdresse;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setEingabeStatus(String eingabeStatus) {
    _eingabeStatus = eingabeStatus;
  }

  public void setEingabeZeitstempel(String eingabeZeitstempel) {
    _eingabeZeitstempel = eingabeZeitstempel;
  }

  public void setEmailAdresse(String emailAdresse) {
    _emailAdresse = emailAdresse;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  public void setUebersteuert(Boolean isUebersteuert) {
    _isUebersteuert = isUebersteuert;
  }

  public void setPatient(SvPerson patient) {
    _patient = patient;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  public void setTelefonNummer(String telefonNummer) {
    _telefonNummer = telefonNummer;
  }

  public void setZustellAdresse(Zustelladresse zustellAdresse) {
    _zustellAdresse = zustellAdresse;
  }

}
