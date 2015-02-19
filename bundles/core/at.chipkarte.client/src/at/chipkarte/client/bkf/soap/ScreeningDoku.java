package at.chipkarte.client.bkf.soap;

/**
 * Enth&auml;lt die Ergebnisdaten der Screening-Dokumentation, zum Aufruf der Funktion <i>createScreeningDoku</i>.
 */

public class ScreeningDoku {

  private String _svNummer;
  private Long _konsultationsID;
  private String _leistungsdatum;
  private String _versionsnummer;
  private SCRMammographieErstbefunder _mamErstbefunder;
  private SCRMammographieZweitbefunder _mamZweitbefunder;
  private SCRUltraschall _ultraschall;
  private SCREndergebnis _endergebnis;

  /**
   * Sozialversicherungsnummer der Patientin. <br>
   * Angabe: Es muss entweder die Sozialversicherung angegeben oder die e-card gesteckt werden.
   * <br>Format: 10-stellig 
   * @return SvNummer.
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
  * Eindeutiger Bezeichner einer Konsultation. <br>
  * Angabe: Bedingt. Es muss entweder eine Konsultation oder ein Leistungsdatum angegeben werden.<br>
  * Mittels der Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfKonsultationData(String, String, String, String)} können die 
  * relevanten Erstkonsultation der Patientin zum Benutzer (Behandlungsdatum, Behandlungsfall-Code) abgefragt werden.<br>
  * ParameterID: 9004.
  * @return KonsultationsID
  */
  public Long getKonsultationsID() {
    return _konsultationsID;
  }

  public void setKonsultationsID(Long konsultationsID) {
    _konsultationsID = konsultationsID;
  }

  /**
   * Datum der Leistung. <br>
   * Angabe: Bedingt. Es muss entweder eine Konsultation oder ein Leistungsdatum angegeben werden. 
   * Darf nicht in der Zukunft liegen.<br>
   * Bei Angabe einer Konsultation wird automatisch das Behandlungsdatum der Konsultation als Leistungsdatum verwendet.<br>
   * Format: TT.MM.JJJJ<br>
   * ParameterID: 9006.
   * @return Leistungsdatum
   */
  public String getLeistungsdatum() {
    return _leistungsdatum;
  }

  public void setLeistungsdatum(String leistungsdatum) {
    _leistungsdatum = leistungsdatum;
  }

  /**
  * Version der Dokumentation. <br>
  * Angabe: Muss. <br>
  * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DokumentationVersionTypConstant}.<br>
  * ParameterID: 9003.
  * @return Versionsnummer
  */
  public String getVersionsnummer() {
    return _versionsnummer;
  }

  public void setVersionsnummer(String versionsnummer) {
    _versionsnummer = versionsnummer;
  }

  /**
   * Mammographiedokumentation des Erstbefunders {@link SCRMammographieErstbefunder}. <br>
   * Angabe: Muss. <br>
   * ParameterID: 0110.
   * @return MamErstbefunder
   */
  public SCRMammographieErstbefunder getMamErstbefunder() {
    return _mamErstbefunder;
  }

  public void setMamErstbefunder(SCRMammographieErstbefunder mamErstbefunder) {
    _mamErstbefunder = mamErstbefunder;
  }

  /**
   * Mammographiedokumentation des Zweitbefunders {@link SCRMammographieZweitbefunder}. <br>
   * Angabe: Muss. <br>
   * ParameterID: 0150.
   * @return MamZweitbefunder
   */
  public SCRMammographieZweitbefunder getMamZweitbefunder() {
    return _mamZweitbefunder;
  }

  public void setMamZweitbefunder(SCRMammographieZweitbefunder mamZweitbefunder) {
    _mamZweitbefunder = mamZweitbefunder;
  }

  /**
   * Ultraschalldokumentation {@link SCRUltraschall}. <br>
   * Angabe: Kann. <br>
   * ParameterID: 0130.
   * @return Ultraschall
   */
  public SCRUltraschall getUltraschall() {
    return _ultraschall;
  }

  public void setUltraschall(SCRUltraschall ultraschall) {
    _ultraschall = ultraschall;
  }

  /**
   * Dokumentation des Endergebnisses {@link SCREndergebnis}. <br>
   * Angabe: Muss. <br>
   * ParameterID: 0170.
   * @return Endergebnis
   */
  public SCREndergebnis getEndergebnis() {
    return _endergebnis;
  }

  public void setEndergebnis(SCREndergebnis endergebnis) {
    _endergebnis = endergebnis;
  }
}