package at.chipkarte.client.bkf.soap;

/**
 * Enth&auml;lt die Eingangsdaten zur Assessmentdokumentation der 
 * invasiven Diagnostik für den Aufruf der Funktion createAssessmentInvasiveDiagnostikDoku.
 */
public class AssessmentInvasiveDiagnostikDoku {

  private String _svNummer;
  private String _versionsnummer;
  private String _leistungsanfang;
  private String _seite;
  private String _ergebnisKlinisch;
  private String _biopsieMethode;
  private String _biopsieModalitaet;
  private String _ergebnisHistologie;
  private String _zustimmungFeedback;
  private String _infoDatum;

  /**
   * Sozialversicherungsnummer der Patientin.
   * <br>Angabe: Es muss entweder die Sozialversicherung angegeben oder die e-card gesteckt werden.
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
  * Version der Dokumentation. 
  * <br>Angabe: Muss. 
  * <br>Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DokumentationVersionTypConstant}.<br>
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
   * Beginn der Leistungserbringung. <br>
   * Darf nicht in der Zukunft und nicht mehr in der Vergangenheit als das 
   * aktuelle Datum - 3 Jahre liegen.
   * Angabe: Muss.<br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0301
   * @return Leistungsanfang
   */
  public String getLeistungsanfang() {
    return _leistungsanfang;
  }

  public void setLeistungsanfang(String leistungsanfang) {
    _leistungsanfang = leistungsanfang;
  }

  /**
   * Betroffene Seite. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.BetroffeneSeiteTypConstant}.<br>
   * ParameterID: 0302
   * @return Seite
   */
  public String getSeite() {
    return _seite;
  }

  public void setSeite(String seite) {
    _seite = seite;
  }

  /**
   * Ergebnis klinische Untersuchung. <br>
   * <br>Bei Mehrfachnennungen ist der Wert '5' ('sonstiges') auszuwählen.
   * Angabe: Kann.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisKlinischeUntersuchungTypConstant}.<br>
   * ParameterID: 0303
   * @return ErgebnisKlinisch
   */
  public String getErgebnisKlinisch() {
    return _ergebnisKlinisch;
  }

  public void setErgebnisKlinisch(String ergebnisKlinisch) {
    _ergebnisKlinisch = ergebnisKlinisch;
  }

  /**
   * Biopsie Methode. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.BiopsieMethodeTypConstant}.<br>
   * ParameterID: 0304
   * @return BiopsieMethode
   */
  public String getBiopsieMethode() {
    return _biopsieMethode;
  }

  public void setBiopsieMethode(String biopsieMethode) {
    _biopsieMethode = biopsieMethode;
  }

  /**
   * Biopsie Modalität. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ModalitaetTypConstant}.<br>
   * ParameterID: 0305
   * @return BiopsieModalitaet
   */
  public String getBiopsieModalitaet() {
    return _biopsieModalitaet;
  }

  public void setBiopsieModalitaet(String biopsieModalitaet) {
    _biopsieModalitaet = biopsieModalitaet;
  }

  /**
   * Histologisches Ergebnis. <br>
   * Muss mit einem Wert zwischen 1 und 8 befüllt werden, wenn <i>BiopsieMethode</i> gleich 2 oder 3. 
   * Muss mit dem Wert 9 befüllt werden, wenn <i>BiopsieMethode</i> gleich 4 oder 5.<br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisHistologieTypConstant}.<br>
   * ParameterID: 0306
   * @return ErgebnisHistologie
   */
  public String getErgebnisHistologie() {
    return _ergebnisHistologie;
  }

  public void setErgebnisHistologie(String ergebnisHistologie) {
    _ergebnisHistologie = ergebnisHistologie;
  }

  /**
   * Zustimmung zu Feedbackbericht. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0309
   * @return ZustimmungFeedback
   */
  public String getZustimmungFeedback() {
    return _zustimmungFeedback;
  }

  public void setZustimmungFeedback(String zustimmungFeedback) {
    _zustimmungFeedback = zustimmungFeedback;
  }

  /**
   * Datum, ab dem der Befund versand- / abholbereit ist. <br>
   * Muss gr&ouml;&szlig;er oder gleich dem Leistungsdatum und kleiner oder gleich 
   * dem aktuellen Datum + 1 Monat sein.
   * <br>Angabe: Muss. <br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0310.
   * @return InfoDatum
   */
  public String getInfoDatum() {
    return _infoDatum;
  }

  public void setInfoDatum(String infoDatum) {
    _infoDatum = infoDatum;
  }

}
