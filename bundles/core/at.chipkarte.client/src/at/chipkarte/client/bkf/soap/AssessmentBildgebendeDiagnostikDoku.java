package at.chipkarte.client.bkf.soap;

/**
 * Enth&auml;lt die Eingangsdaten zur Assessmentdokumentation der bildgebenden Diagnostik 
 * f&uuml;r den Aufruf der Funktion createAssessmentBildgebendeDiagnostikDoku.
 */

public class AssessmentBildgebendeDiagnostikDoku {
  private String _svNummer;
  private String _versionsnummer;
  private String _leistungsanfang;
  private String _ergebnisKlinisch;
  private String _zusatzaufnahme;
  private String _mammoDurchgefuehrt;
  private String _ergebnisMammo;
  private String _ergebnisUS;
  private String _ergebnisMRT;
  private String _gesamtbeurteilung;
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
  * <br>Angabe: Muss. <br>
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
   * Beginn der Leistungserbringung.
   * <br>Darf nicht in der Zukunft und nicht mehr in der Vergangenheit als 
   * das aktuelle Datum - 3 Jahre liegen.
   * <br>Angabe: Muss.<br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0201
   * @return Leistungsanfang
   */
  public String getLeistungsanfang() {
    return _leistungsanfang;
  }

  public void setLeistungsanfang(String leistungsanfang) {
    _leistungsanfang = leistungsanfang;
  }

  /**
   * Ergebnis klinische Untersuchung.
   * <br>Bei Mehrfachnennungen ist der Wert '5' ('sonstiges') auszuwählen.
   * <br>Angabe: Kann.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisKlinischeUntersuchungTypConstant}.<br>
   * ParameterID: 0202
   * @return ErgebnisKlinisch
   */
  public String getErgebnisKlinisch() {
    return _ergebnisKlinisch;
  }

  public void setErgebnisKlinisch(String ergebnisKlinisch) {
    _ergebnisKlinisch = ergebnisKlinisch;
  }

  /**
   * Zusätzliche mammographische Bilder.
   * <br>Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0204.
   * @return Zusatzaufnahme
   */
  public String getZusatzaufnahme() {
    return _zusatzaufnahme;
  }

  public void setZusatzaufnahme(String zusatzaufnahme) {
    _zusatzaufnahme = zusatzaufnahme;
  }

  /**
   * Mammographie im Assessment durchgef&uuml;hrt. 
   * <br>Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0203
   * @return MammoDurchgefuehrt
   */
  public String getMammoDurchgefuehrt() {
    return _mammoDurchgefuehrt;
  }

  public void setMammoDurchgefuehrt(String mammoDurchgefuehrt) {
    _mammoDurchgefuehrt = mammoDurchgefuehrt;
  }

  /**
   * Ergebnis mammographische Untersuchung (MG-SCORE).
   * <br>Angabe: Bedingt. Muss mit einem Wert ungleich '99' befüllt sein, 
   * wenn das Feld <i>MammoDurchgefuehrt</i> oder das Feld <i>Zusatzaufnahme</i> mit dem Wert '1' ('Ja') befüllt ist. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisMammographieAssessmentTypConstant}.<br>
   * ParamterID: 0205
   * @return ErgebnisMammo
   */
  public String getErgebnisMammo() {
    return _ergebnisMammo;
  }

  public void setErgebnisMammo(String ergebnisMammo) {
    _ergebnisMammo = ergebnisMammo;
  }

  /**
   * Ergebnis Ultraschall (US-SCORE).
   * <br>Angabe: Kann. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisUltraschallAssessmentTypConstant}.<br>
   * ParameterID: 0206
   * @return ErgebnisUltraschall
   */
  public String getErgebnisUS() {
    return _ergebnisUS;
  }

  public void setErgebnisUS(String ergebnisUS) {
    _ergebnisUS = ergebnisUS;
  }

  /**
   * Ergebnis MRT (MR-SCORE).
   * <br>Angabe: Kann.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisMRTTypConstant}.<br>
   * ParameterID: 0207
   * @return ErgebnisMRT
   */
  public String getErgebnisMRT() {
    return _ergebnisMRT;
  }

  public void setErgebnisMRT(String ergebnisMRT) {
    _ergebnisMRT = ergebnisMRT;
  }

  /**
   * Gesamtbeurteilung (ABD-SCORE).
   * <br>Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.GesamtbeurteilungABDTypConstant}.<br>
   * ParameterID: 0208
   * @return Gesamtbeurteilung
   */
  public String getGesamtbeurteilung() {
    return _gesamtbeurteilung;
  }

  public void setGesamtbeurteilung(String gesamtbeurteilung) {
    _gesamtbeurteilung = gesamtbeurteilung;
  }

  /**
   * Zustimmung zu Feedbackbericht.
   * <br>Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0209
   * @return ZustimmungFeedback
   */
  public String getZustimmungFeedback() {
    return _zustimmungFeedback;
  }

  public void setZustimmungFeedback(String zustimmungFeedback) {
    _zustimmungFeedback = zustimmungFeedback;
  }

  /**
   * Datum, ab dem der Befund versand- / abholbereit ist.
   * <br>Muss gr&ouml;&szlig;er oder gleich dem Leistungsdatum und kleiner oder gleich 
   * dem aktuellen Datum + 1 Monat sein.
   * <br>Angabe: Muss. <br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0210.
   * @return InfoDatum
   */
  public String getInfoDatum() {
    return _infoDatum;
  }

  public void setInfoDatum(String infoDatum) {
    _infoDatum = infoDatum;
  }

}
