/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion searchUzeLa.
 */
public class UzeLeSearchReq {
  private String _ordinationsIdLe;
  private String _suchzeitraumBis;
  private String _suchzeitraumVon;
  private String _uzeCode;
  private String _svNummer;
  private String _weisungsTyp;

  /**
   * Ordinations ID der Ordination, in der die UZE eingel&ouml;st wurde.<br>
   * Die Angabe der OrdinationsIdLe ist optional.<br/>
   * Wenn nicht versorgt, wird &uuml;ber alle Ordinationen des Leistungserbringers gesucht.<br>
   * Format: maximal 19-stellig.
   * @return OrdinationsIdLe
   */
  public String getOrdinationsIdLe() {
    return _ordinationsIdLe;
  }

  /**
   * Endedatum des Suchzeitraums (Einl&ouml;sungsdatum).<br>
   * Die Angabe von SuchzeitraumBis ist optional.<br/>
   * Falls nicht versorgt, wird das Endedatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ
   * @return SuchzeitraumBis
   */
  public String getSuchzeitraumBis() {
    return _suchzeitraumBis;
  }

  /**
   * Beginndatum des Suchzeitraums (Einl&ouml;sungsdatum).<br>
   * Die Angabe von SuchzeitraumVon ist optional.<br/>
   * Falls nicht versorgt, wird das Beginndatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ
   * @return SuchzeitraumVon
   */
  public String getSuchzeitraumVon() {
    return _suchzeitraumVon;
  }

  /**
   * Der generierte Code der UZE, die abgefragt werden soll.<br> 
   * Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal der UZE.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Format: 5-stellig.
   * @return UzeCode
   */
  public String getUzeCode() {
    return _uzeCode;
  }

  /**
   * Versicherungsnummer des Patienten, dessen &Uuml;ber/Zu/Einweisung abgefragt werden sollen.<br>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.<br>
   * Die Angabe der Versicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Code des Weisungstyps der UZE.<br>
   * Entspricht der abzul&ouml;senden Scheinart. Wenn nicht versorgt, wird nach allen Weisungstypen gesucht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Die Angabe des WeisungsTyps ist optional.<br/>
   * Format: 2-stellig.
   * @return WeisungsTyp
   */
  public String getWeisungsTyp() {
    return _weisungsTyp;
  }

  /**
   * Ordinations ID der Ordination, in der die UZE eingel&ouml;st wurde.<br>
   * Die Angabe der OrdinationsId des Leistungserbringers ist optional.<br/>
   * Wenn nicht versorgt, wird &uuml;ber alle Ordinationen des Leistungserbringers gesucht.<br>
   * Format: maximal 19-stellig.
   * @param ordinationsIdLe Der zu setzende Wert f&uuml;r OrdinationsIdLe.
   */
  public void setOrdinationsIdLe(String ordinationsIdLe) {
    _ordinationsIdLe = ordinationsIdLe;
  }

  /**
   * Endedatum des Suchzeitraums (Einl&ouml;sungsdatum).<br>
   * Die Angabe von SuchzeitraumBis ist optional.<br/>
   * Falls nicht versorgt, wird das Endedatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ
   * @param suchzeitraumBis Der zu setzende Wert f&uuml;r SuchzeitraumBis.
   */
  public void setSuchzeitraumBis(String suchzeitraumBis) {
    _suchzeitraumBis = suchzeitraumBis;
  }

  /**
   * Beginndatum des Suchzeitraums (Einl&ouml;sungsdatum).<br>
   * Die Angabe von SuchzeitraumVon ist optional.<br/>
   * Falls nicht versorgt, wird das Beginndatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ
   * @param suchzeitraumVon Der zu setzende Wert f&uuml;r SuchzeitraumVon.
   */
  public void setSuchzeitraumVon(String suchzeitraumVon) {
    _suchzeitraumVon = suchzeitraumVon;
  }

  /**
   * Der generierte Code der UZE, die abgefragt werden soll.<br> 
   * Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal der UZE.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Format: 5-stellig.
   * @param uzeCode Der zu setzende Wert f&uuml;r UzeCode.
   */
  public void setUzeCode(String uzeCode) {
    _uzeCode = uzeCode;
  }

  /**
   * Versicherungsnummer des Patienten, dessen &Uuml;ber/Zu/Einweisung abgefragt werden sollen.<br>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.<br>
   * Die Angabe der Versicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Code des Weisungstyps der UZE.<br>
   * Entspricht der abzul&ouml;senden Scheinart. Wenn nicht versorgt, wird nach allen Weisungstypen gesucht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Die Angabe des WeisungsTyps ist optional.<br/>
   * Format: 2-stellig.
   * @param weisungsTyp Der zu setzende Wert f&uuml;r WeisungsTyp.
   */
  public void setWeisungsTyp(String weisungsTyp) {
    _weisungsTyp = weisungsTyp;
  }

}
