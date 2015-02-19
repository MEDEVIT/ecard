/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap;

/**
 * Enthält die Suchkriterien für eine Abfrage der tages-/stichtagsaktuellen Versichertendaten für einen Patienten.
 */
public class VersichertendatenAbfrage {
  private String _abteilungsFunktionsCode;
  private String _cin;
  private Boolean _forceExecution;
  private String _svNummer;
  private String _svNummerAbgeleitet;
  private String _svtCode;

  /**
   * Abteilungs-Funktionscode laut KA-ORG beziehungsweise VPNR bei Gesundheitsdienstanbietern.
   * <br>Format: maximal 8-stellig
   * @return Abteilungs-/Funktionscode
   */
  public String getAbteilungsFunktionsCode() {
    return _abteilungsFunktionsCode;
  }

  /**
   * Wird für die Signatur verwendet. Es erfolgt eine Prüfung, ob die Karte ident mit der Karte ist, von der die SV-Nummer gelesen
   * wurde. Ist nur im Falle einer gesteckten e-card relevant.<br>
   * Format: maximal 20-stellig
   * @return Cin
   */
  public String getCin() {
    return _cin;
  }

  /**
   * Kennzeichen, ob die Funktion auch bei wiederholter Verwendung der e-card durchgeführt werden soll.
   * @return <i>true</i> = Exception CardException.REPEATED_SIGNATUR wird nicht geliefert, 
   * <i>false</i> = Exception CardException.REPEATED_SIGNATUR
   *         wird geliefert und die Durchführung der Funktion abgebrochen
   */
  public Boolean isForceExecution() {
    return _forceExecution;
  }

  /**
   * Sozialversicherungsnummer des Patienten, für den die Versichertendatenabfrage durchgeführt werden soll.
   * <br>Ist keine e-card gesteckt ist die Angabe ein Muss. Ist eine e-card gesteckt und keine Sozialversicherungsnummer angegeben, wird
   * die Sozialversicherungsnummer der gesteckten e-card verwendet. Ist eine e-card gesteckt und eine Sozialversicherungsnummer
   * angegeben, müssen die angegebene und die gelesene Sozialversicherungsnummer ident sein.<br>
   * Format: 10-stellig
   * @return SV-Nummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Sozialversicherungsnummer des Versicherten, von dem der Anspruch abgeleitet ist. 
   * Wenn ein eindeutiger Anspruch gefunden wird, wird
   * diese Angabe ignoriert.<br>
   * Format: 10-stellig
   * @return abgeleitete SV-Nummer
   */
  public String getSvNummerAbgeleitet() {
    return _svNummerAbgeleitet;
  }

  /**
   * Code des KVT, bei dem der Anspruch besteht (eigener oder abgeleiteter Anspruch).
   * <br>Mögliche Werte siehe Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}<br>
   * Format: 2-stellig
   * @return KVT-Code
   */
  public String getSvtCode() {
    return _svtCode;
  }

  public void setAbteilungsFunktionsCode(String abteilungsFunktionsCode) {
    _abteilungsFunktionsCode = abteilungsFunktionsCode;
  }

  public void setCin(String cin) {
    _cin = cin;
  }

  public void setForceExecution(Boolean forceExecution) {
    _forceExecution = forceExecution;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setSvNummerAbgeleitet(String svNummerAbgeleitet) {
    _svNummerAbgeleitet = svNummerAbgeleitet;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
}
