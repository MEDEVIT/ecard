/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion searchLeForZo.
 */
public class LeForZoSearchReq {
  private String _fachgebiet;
  private String _vpNummer;
  private String _vornameVp;
  private String _zunameVp;

  /**
   * Code des Fachgebiets, f&uuml;r welches ein Vertragspartner gefunden werden soll.<br>
   * Format: maximal 2-stellig.
   * @return Fachgebiet
   */
  public String getFachgebiet() {
    return _fachgebiet;
  }

  /**
   * Vertragspartnernummer des Vertragspartners, der gesucht wird.<br>
   * Die Angabe der Vertragspartnernummer ist optional.<br/>
   * Format: maximal 6-stellig.
   * @return VpNummer
   */
  public String getVpNummer() {
    return _vpNummer;
  }

  /**
   * Vorname oder Teilstring des Vornamens des Vertragspartners, der gesucht wird.<br>
   * Die Angabe von VornameVP ist optional.<br/>
   * Format: Mindestl&auml;nge, wenn angegeben: 4 Zeichen, maximal 70-stellig.<br>
   * @return VornameVp
   */
  public String getVornameVp() {
    return _vornameVp;
  }

  /**
   * Zuname des Vertragspartners / Name des Labors oder Institutes, nach dem gesucht wird. 
   * Es kann auch nur ein Teilstring angegeben werden.<br>
   * Die Angabe von ZunameVP ist optional.<br/>
   * Format: Mindestl&auml;nge, wenn angegeben: 4 Zeichen, maximal 70-stellig.<br>
   * @return ZunameVp
   */
  public String getZunameVp() {
    return _zunameVp;
  }

  /**
   * Code des Fachgebiets, f&uuml;r welches ein Vertragspartner gefunden werden soll.<br>
   * @param fachgebiet Der zu setzende Wert f&uuml;r Fachgebiet.
   */
  public void setFachgebiet(String fachgebiet) {
    _fachgebiet = fachgebiet;
  }

  /**
   * Vertragspartnernummer des Vertragspartners, der gesucht wird.<br>
   * Die Angabe der Vertragspartnernummer ist optional.<br/>
   * @param vpNummer Der zu setzende Wert f&uuml;r VpNummer.
   */
  public void setVpNummer(String vpNummer) {
    _vpNummer = vpNummer;
  }

  /**
   * Vorname oder Teilstring des Vornamens des Vertragspartners, der gesucht wird.<br>
   * Die Angabe von VornameVP ist optional.<br/>
   * Format: Mindestl&auml;nge, wenn angegeben: 4 Zeichen, maximal 70-stellig.<br>
   * @param vornameVp Der zu setzende Wert f&uuml;r VornameVp.
   */
  public void setVornameVp(String vornameVp) {
    _vornameVp = vornameVp;
  }

  /**
   * Zuname des Vertragspartners / Name des Labors oder Institutes, nach dem gesucht wird. 
   * Es kann auch nur ein Teilstring angegeben werden.<br>
   * Die Angabe von ZunameVP ist optional.<br/>
   * Format: Mindestl&auml;nge, wenn angegeben: 4 Zeichen, maximal 70-stellig.<br>
   * @param zunameVp Der zu setzende Wert f&uuml;r ZunameVp.
   */
  public void setZunameVp(String zunameVp) {
    _zunameVp = zunameVp;
  }

}
