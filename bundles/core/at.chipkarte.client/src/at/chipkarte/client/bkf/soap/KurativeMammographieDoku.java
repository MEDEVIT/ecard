package at.chipkarte.client.bkf.soap;

/**
 * Enthält die Ergebnisdaten der kurativen Mammographie, zum Aufruf der Funktion <i>createKurativeMammographieDoku</i>.
 */

public class KurativeMammographieDoku {

  private String _svNummer;
  private Long _konsultationsID;
  private String _leistungsdatum;
  private String _versionsnummer;
  private KUMMammographieErstbefunder _mamErstbefunder;
  private KUMMammographieZweitbefunder _mamZweitbefunder;
  private KUMUltraschall _ultraschall;
  private KUMEndergebnis _endergebnis;

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
  * Eindeutiger Bezeichner der gewählten Konsultation. <br>
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
   * Mammographiedokumentation des Erstbefunders {@link KUMMammographieErstbefunder}. <br>
   * Angabe: Muss. <br>
   * ParameterID: 0410.
   * @return MamErstbefunder
   */
  public KUMMammographieErstbefunder getMamErstbefunder() {
    return _mamErstbefunder;
  }

  public void setMamErstbefunder(KUMMammographieErstbefunder mamErstbefunder) {
    _mamErstbefunder = mamErstbefunder;
  }

  /**
   * Mammographiedokumentation des Zweitbefunders {@link KUMMammographieZweitbefunder}. <br>
   * Angabe: Kann. <br>
   * ParameterID: 0450.
   * @return MamZweitbefunder
   */
  public KUMMammographieZweitbefunder getMamZweitbefunder() {
    return _mamZweitbefunder;
  }

  public void setMamZweitbefunder(KUMMammographieZweitbefunder mamZweitbefunder) {
    _mamZweitbefunder = mamZweitbefunder;
  }

  /**
   * Ultraschalldokumentation {@link KUMUltraschall}. <br>
   * Angabe: Kann.<br>
   * ParameterID: 0430.

   * @return KUMUltraschall
   */
  public KUMUltraschall getUltraschall() {
    return _ultraschall;
  }

  public void setUltraschall(KUMUltraschall ultraschall) {
    _ultraschall = ultraschall;
  }

  /**
   * Dokumentation des Endergebnisses {@link KUMEndergebnis}. <br>
   * Angabe: Muss. <br>
   * ParameterID: 0470.
   * @return Endergebnis
   */
  public KUMEndergebnis getEndergebnis() {
    return _endergebnis;
  }

  public void setEndergebnis(KUMEndergebnis endergebnis) {
    _endergebnis = endergebnis;
  }
}