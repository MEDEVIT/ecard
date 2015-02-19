/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion searchUzeLa.
 */
public class UzeLaSearchReq {
  private String _ordinationsIdLa;
  private String _status;
  private String _suchzeitraumBis;
  private String _suchzeitraumVon;
  private String _uzeCode;
  private String _svNummer;
  private String _weisungsTyp;

  /**
   * Ordinations ID der Ordination, in der die UZE erstellt wurde.<br>
   * Die Angabe der Ordinations ID des Leistungsanforderers ist optional.<br/>
   * Wenn nicht versorgt, wird &uuml;ber alle Ordinationen des Leistungsanforderers gesucht.<br>
   * Format: maximal 19-stellig.
   * @return OrdinationsIdLa
   */
  public String getOrdinationsIdLa() {
    return _ordinationsIdLa;
  }

  /**
   * Status, den die gefundenen UZE haben sollen.<br>
   * Die Angabe des Status ist optional.<br/>
   * Wenn nicht versorgt, wird nach allen Status gesucht.<br>
   * Format: 1-stellig.
   * @return Status
   */
  public String getStatus() {
    return _status;
  }

  /**
   * Endedatum des Suchzeitraums (Erstellungsdatum).<br>
   * Die Angabe von SuchzeitraumBis ist optional.<br/>
   * Falls nicht versorgt, wird das Endedatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ
   * @return SuchzeitraumBis
   */
  public String getSuchzeitraumBis() {
    return _suchzeitraumBis;
  }

  /**
   * Beginndatum des Suchzeitraums (Erstellungsdatum).<br>
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
   * Gemeinsam mit der SVNummer ist er ein eindeutiges Identifizierungsmerkmal der UZE.<br>
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
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Die Angabe des WeisungsTyps ist optional.<br/>
   * Wenn nicht versorgt, wird nach allen Weisungstypen gesucht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: 2-stellig.
   * @return WeisungsTyp
   */
  public String getWeisungsTyp() {
    return _weisungsTyp;
  }

  /**
   * Ordinations ID der Ordination, in der die UZE erstellt wurde.<br>
   * Die Angabe der Ordinations ID des Leistungsanforderers ist optional.<br/>
   * Wenn nicht versorgt, wird &uuml;ber alle Ordinationen des Leistungsanforderers gesucht.<br>
   * Format: maximal 19-stellig.
   * @param ordinationsIdLa Der zu setzende Wert f&uuml;r OrdinationsIdLa.
   */
  public void setOrdinationsIdLa(String ordinationsIdLa) {
    _ordinationsIdLa = ordinationsIdLa;
  }

  /**
   * Status, den die gefundenen UZE haben sollen.<br>
   * Die Angabe des Status ist optional.<br/>
   * Wenn nicht versorgt, wird nach allen Status gesucht.<br>
   * Format: 1-stellig.
   * @param status Der zu setzende Wert f&uuml;r Status.
   */
  public void setStatus(String status) {
    _status = status;
  }

  /**
   * Endedatum des Suchzeitraums (Erstellungsdatum).<br>
   * Die Angabe von SuchzeitraumBis ist optional.<br/>
   * Falls nicht versorgt, wird das Endedatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ
   * @param suchzeitraumBis Der zu setzende Wert f&uuml;r SuchzeitraumBis.
   */
  public void setSuchzeitraumBis(String suchzeitraumBis) {
    _suchzeitraumBis = suchzeitraumBis;
  }

  /**
   * Beginndatum des Suchzeitraums (Erstellungsdatum).<br>
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
   * Gemeinsam mit der SVNummer ist er ein eindeutiges Identifizierungsmerkmal der UZE.<br>
   * Die Angabe des UzeCode ist optional.<br/>
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
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Die Angabe des WeisungsTyps ist optional.<br/>
   * Wenn nicht versorgt, wird nach allen Weisungstypen gesucht.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: 2-stellig.
   * @param weisungsTyp Der zu setzende Wert f&uuml;r WeisungsTyp.
   */
  public void setWeisungsTyp(String weisungsTyp) {
    _weisungsTyp = weisungsTyp;
  }

}
