/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Parameter zu einer DMP-Eingabe.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class EingabeParameter {

  private String _svNummer;
  private String _svtCode;
  private String _fachgebietsCode;
  private String _dmpCode;
  private String _eingabeArt;
  private Zustelladresse _zustellAdresse;
  private String _telefonNummer;
  private String _emailAdresse;
  private String _eingabeZusatz;

  /**
   * Code des Disease Management Programms.<br>
   * Mögliche Werte siehe Funktion {@link at.chipkarte.client.dmp.soap.IDmpService#getDMPs() getDMPs()}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Disease Management Programms
   */
  public String getDmpCode() {
    return _dmpCode;
  }

  /**
   * Code der Eingabeart, mit dem die Eingabe gemacht wird.<br>
   * Mögliche Werte siehe Konstante {@link at.chipkarte.client.dmp.soap.constants.EingabeArt EingabeArt}.<br>
   * Format: maximal 1-stellig.
   * @return Code der Eingabeart
   */
  public String getEingabeArt() {
    return _eingabeArt;
  }

  /**
   * Frei vom Vertragspartner zu bearbeitendes Feld mit zusätzlichen Informationen zur DMP Eingabe.<br>
   * Die Angabe des EingabeZusatzes ist optional.<br>
   * Format: maximal 500-stellig.
   * @return EingabeZusatz
   */
  public String getEingabeZusatz() {
    return _eingabeZusatz;
  }

  /**
   * E-Mail-Adresse des Patienten.<br>
   * Die Angabe der E-Mail-Adresse ist optional.<br>
   * Format: maximal 256-stellig.
   * @return E-Mail-Adresse
   */
  public String getEmailAdresse() {
    return _emailAdresse;
  }

  /**
   * Code des Fachgebietes für das der Vertragspartner eine Betreuungsberechtigung besitzt.<br>
   * Mögliche Werte siehe Funktion {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getFachgebiete() getFachgebiete()}.<br>
   * Format: maximal 2-stellig.
   * @return FachgebietsCode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  /**
   * Sozialversicherungsnummer der SV-Person, die die Leistung in Anspruch nimmt.<br>
   * Die Angabe der Sozialversicherungsnummer ist optional. Ist die Sozialversicherungsnummer nicht angegeben, muss die e-card
   * gesteckt sein. Ist die Sozialversicherungsnummer angegeben und die e-card gesteckt, wird die Sozialversicherungsnummer
   * ignoriert.<br>
   * Die Sozialversicherungsnummer muss den Regeln für Sozialversicherungsnummern entsprechen (Prüfziffer). <br>
   * Format: 10-stellig, numerisch.
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Code des Sozialversicherungsträgers der SV-Person, für die diese Eingabe gemacht wird.<br>
   * Mögliche Werte siehe Funktion {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getSVTs() getSVTs()}.<br>
   * Die Angabe des Sozialversicherungsträgers ist optional. Ist der Sozialversicherungsträger nicht angegeben ist, dann wird er
   * automatisch vom e-card Serversystem ermittelt.<br>
   * Format: maximal 2-stellig.
   * @return Code des Sozialversicherungsträgers
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Telefonnummer des Patienten.<br>
   * Die Angabe der Telefonnummer ist optional.<br>
   * Format: maximal 50-stellig.
   * @return Telefonnummer
   */
  public String getTelefonNummer() {
    return _telefonNummer;
  }

  /**
   * Adresse des Patienten für die Zustellung der Eingabe.<br>
   * Die Angabe der Adresse ist optional.<br>
   * @return Zustelladresse
   */
  public Zustelladresse getZustellAdresse() {
    return _zustellAdresse;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setEingabeArt(String eingabeArt) {
    _eingabeArt = eingabeArt;
  }

  public void setEingabeZusatz(String eingabeZusatz) {
    _eingabeZusatz = eingabeZusatz;
  }

  public void setEmailAdresse(String emailAdresse) {
    _emailAdresse = emailAdresse;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
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
