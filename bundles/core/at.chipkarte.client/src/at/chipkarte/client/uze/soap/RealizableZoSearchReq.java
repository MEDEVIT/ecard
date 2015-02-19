/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion "searchRealizableZo".
 */
public class RealizableZoSearchReq {
  private String _suchzeitraumBis;
  private String _suchzeitraumVon;
  private String _uzeCode;
  private String _svNummer;

  /**
   * Endedatum des Suchzeitraums (Erstellungszeitpunkt).<br>
   * Die Angabe von SuchzeitraumBis ist optional.<br/>
   * Falls nicht versorgt, wird das Endedatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ<br>
   * @return SuchzeitraumBis
   */
  public String getSuchzeitraumBis() {
    return _suchzeitraumBis;
  }

  /**
   * Beginndatum des Suchzeitraums (Erstellungszeitpunkt).<br>
   * Die Angabe von SuchzeitraumVon ist optional.<br/>
   * Falls nicht versorgt, wird das Beginndatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ<br>
   * @return SuchzeitraumVon
   */
  public String getSuchzeitraumVon() {
    return _suchzeitraumVon;
  }

  /**
   * Der generierte Code der ZO, die abgefragt werden soll.<br> 
   * Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal der ZO.<br>
   * Die Angabe des UzeCode ist optional.<br/>
   * Format: 5-stellig.
   * @return UzeCode
   */
  public String getUzeCode() {
    return _uzeCode;
  }

  /**
   * Versicherungsnummer des Patienten, dessen einl&ouml;sbare ZOs abgefragt werden sollen.<br>
   * Die Angabe der Versicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Endedatum des Suchzeitraums (Erstellungszeitpunkt).<br>
   * Die Angabe des SuchzeitraumBis ist optional.<br/>
   * Falls nicht versorgt, wird das Endedatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ<br>
   * @param suchzeitraumBis Der zu setzende Wert f&uuml;r SuchzeitraumBis.
   */
  public void setSuchzeitraumBis(String suchzeitraumBis) {
    _suchzeitraumBis = suchzeitraumBis;
  }

  /**
   * Beginndatum des Suchzeitraums (Erstellungszeitpunkt).<br>
   * Die Angabe von SuchzeitraumVon ist optional.<br/>
   * Falls nicht versorgt, wird das Beginndatum des Suchzeitraums nicht eingeschr&auml;nkt.<br>
   * Format: TT.MM.JJJJ<br>
   * @param suchzeitraumVon Der zu setzende Wert f&uuml;r SuchzeitraumVon.
   */
  public void setSuchzeitraumVon(String suchzeitraumVon) {
    _suchzeitraumVon = suchzeitraumVon;
  }

  /**
   * Der generierte Code der ZO, die abgefragt werden soll.<br> 
   * Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal der ZO.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Format: 5-stellig.
   * @param uzeCode Der zu setzende Wert f&uuml;r UzeCode.
   */
  public void setUzeCode(String uzeCode) {
    _uzeCode = uzeCode;
  }

  /**
   * Versicherungsnummer des Patienten, dessen einl&ouml;sbare ZOs abgefragt werden sollen.<br>
   * Die Angabe der Versicherungsnummer ist optional.<br/>
   * Format: 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

}
