/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion "searchRealizableUze".
 */
public class RealizableUzeSearchReq {
  private String _fachgebiet;
  private String _uzeCode;
  private String _svNummer;

  /**
   * Das zugewiesene Fachgebiet, zu dem UZE gefunden werden sollen.<br>
   * Die Angabe des Fachgebietes ist optional.<br/>
   * Die Eingabe wird ignoriert, wenn der Vertragspartner, der den Dialog aufgebaut hat, 
   * nicht das Recht UZE.FG_UEBERGREIFEND hat.<br>
   * Format: 2-stellig.
   * @return Fachgebiet
   */
  public String getFachgebiet() {
    return _fachgebiet;
  }

  /**
   * Der generierte Code einer UZEWeisung.
   * Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal einer UZEWeisung.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Wenn eine e-card gesteckt ist, muss kein UzeCode angegeben sein. Dies gilt nur wenn die SV-Nummer
   * nicht versorgt ist.<br>
   * Format: 5-stellig.
   * @return UzeCode
   */
  public String getUzeCode() {
    return _uzeCode;
  }

  /**
   * SV-Nummer der SV-Person, von der eine UZE eingel&ouml;st werden soll.<br>
   * Die Angabe der SV-Nummer ist optional.<br/>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.
   * Ist keine e-card gesteckt, muss eine SvNummer angegeben sein.<br>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Das zugewiesene Fachgebiet, zu dem UZE gefunden werden sollen.<br>
   * Die Angabe des Fachgebietes ist optional.<br/>
   * Die Eingabe wird ignoriert, wenn der Vertragspartner, der den Dialog aufgebaut hat, 
   * nicht das Recht UZE.FG_UEBERGREIFEND hat.<br>
   * Format: 2-stellig.
   * @param fachgebiet Der zu setzende Wert f&uuml;r Fachgebiet.
   */
  public void setFachgebiet(String fachgebiet) {
    _fachgebiet = fachgebiet;
  }

  /**
   * Der generierte Code einer UZEWeisung.
   * Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal einer UZEWeisung.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Wenn eine e-card gesteckt ist, muss kein UzeCode angegeben sein.<br>
   * Format: 5-stellig.
   * @param uzeCode Der zu setzende Wert f&uuml;r UzeCode.
   */
  public void setUzeCode(String uzeCode) {
    _uzeCode = uzeCode;
  }

  /**
   * SV-Nummer der SV-Person, von der eine UZE eingel&ouml;st werden soll.<br>
   * Die Angabe der SV-Nummer ist optional.<br/>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert. 
   * Ist keine e-card gesteckt, muss eine SvNummer angegeben sein.<br>
   * Format: 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

}
