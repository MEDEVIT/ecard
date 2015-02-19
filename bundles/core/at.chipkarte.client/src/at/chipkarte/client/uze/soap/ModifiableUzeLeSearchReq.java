/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion searchModifiableUzeLe.
 */
public class ModifiableUzeLeSearchReq {
  private String _uzeCode;
  private String _svNummer;
  private String _weisungsTyp;

  /**
   * Der generierte Code der UZE, die auf Stornierbarkeit abgefragt werden soll.<br>
   * Gemeinsam mit der VSNR ist er ein eindeutiges Identifizierungsmerkmal der UZE.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Format: 5-stellig.
   * @return UzeCode
   */
  public String getUzeCode() {
    return _uzeCode;
  }

  /**
   * Versicherungsnummer des Patienten, dessen UZE auf Stornierbarkeit abgefragt werden sollen.<br>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.<br>
   * Die Angabe der Versicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Die Angabe des WeisungsTyps ist optional.<br/>
   * Format: 2-stellig.
   * @return WeisungsTyp
   */
  public String getWeisungsTyp() {
    return _weisungsTyp;
  }

  /**
   * Der generierte Code der UZE, die auf Stornierbarkeit abgefragt werden soll.<br>
   * Gemeinsam mit der VSNR ist er ein eindeutiges Identifizierungsmerkmal der UZE.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Format: 5-stellig.
   * @param uzeCode Der zu setzende Wert f&uuml;r UzeCode.
   */
  public void setUzeCode(String uzeCode) {
    _uzeCode = uzeCode;
  }

  /**
   * Versicherungsnummer des Patienten, dessen UZE auf Stornierbarkeit abgefragt werden sollen.<br>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.<br>
   * Die Angabe der Versicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Die Angabe des WeisungsTyps ist optional.<br/>
   * Format: 2-stellig.
   * @param weisungsTyp Der zu setzende Wert f&uuml;r WeisungsTyp.
   */
  public void setWeisungsTyp(String weisungsTyp) {
    _weisungsTyp = weisungsTyp;
  }

}
