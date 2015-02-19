/*
 * (C) SVC 2012
 */
package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Parameter zu einer DMP Ausschreibeanfrage.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class AusschreibeParameter {

  private String _svNummer;
  private String _dmpCode;
  private String _ausschreibeGrund;

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
   * Code des Disease Management Programms.<br>
   * Mögliche Werte siehe Funktion {@link at.chipkarte.client.dmp.soap.IDmpService#getDMPs() getDMPs()}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Disease Management Programms
   */
  public String getDmpCode() {
    return _dmpCode;
  }

  /**
   * Grund der Ausschreibung in codierter Form.<br>
   * Mögliche Werte siehe Konstante {@link at.chipkarte.client.dmp.soap.constants.AusschreibeGrund AusschreibeGrund}.<br>
   * Format: maximal 2-stellig.
   * @return Code der Ausschreibung
   */
  public String getAusschreibeGrund() {
    return _ausschreibeGrund;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setAusschreibeGrund(String ausschreibeGrund) {
    _ausschreibeGrund = ausschreibeGrund;
  }

}
