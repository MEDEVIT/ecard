package at.chipkarte.client.bkf.soap;

/**
 * Enth&auml;lt die Ergebnisdaten zur Therapiedokumentation Tumor,  zum Aufruf der Funktion <i>createTherapieTumorDoku</i>.
 */
public class TherapieTumorDoku {

  private String _svNummer;
  private String _versionsnummer;
  private String _operationsdatum;
  private String _zustimmungFeedback;
  private String _seite;
  private String _tumoreTastbar;
  private String _tumorstadium;
  private String _stadiumUICC;
  private String _tumordurchmesser;
  private String _offeneBiopsie;
  private String _gefrierschnitt;
  private String _tumorEntfernt;
  private String _ablatio;
  private String _multifokal;
  private String _neoadjuvanteTherapie;

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
   * Datum der Operation beziehungsweise der offenen Biopsie. <br>
   * Darf nicht in der Zukunft liegen.<br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0701.
   * @return Operationsdatum.
   */
  public String getOperationsdatum() {
    return _operationsdatum;
  }

  public void setOperationsdatum(String operationsdatum) {
    _operationsdatum = operationsdatum;
  }

  /**
   * Zustimmung zu Feedbackbericht. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0702
   * @return ZustimmungFeedback
   */
  public String getZustimmungFeedback() {
    return _zustimmungFeedback;
  }

  public void setZustimmungFeedback(String zustimmungFeedback) {
    _zustimmungFeedback = zustimmungFeedback;
  }

  /**
   * Betroffene Seite. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.BetroffeneSeiteTypConstant}.<br>
   * ParameterID: 0703
   * @return Seite
   */
  public String getSeite() {
    return _seite;
  }

  public void setSeite(String seite) {
    _seite = seite;
  }

  /**
   * Alle Tumore waren tastbar. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0704
   * @return TumoreTastbar
   */
  public String getTumoreTastbar() {
    return _tumoreTastbar;
  }

  public void setTumoreTastbar(String tumoreTastbar) {
    _tumoreTastbar = tumoreTastbar;
  }

  /**
   * cTumorstadium. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.TumorstadiumTypConstant}.<br>
   * ParameterID: 0705
   * @return Tumorstadium
   */
  public String getTumorstadium() {
    return _tumorstadium;
  }

  public void setTumorstadium(String tumorstadium) {
    _tumorstadium = tumorstadium;
  }
  
  /**
   * cM Stadium nach UICC. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.StadiumUICCTypConstant}.<br>
   * ParameterID: 0706
   * @return StadiumUICC
   */
  public String getStadiumUICC() {
    return _stadiumUICC;
  }

  public void setStadiumUICC(String stadiumUICC) {
    _stadiumUICC = stadiumUICC;
  }

  /**
   * Größter Tumordurchmesser. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.TumordurchmesserTypConstant}.<br>
   * ParameterID: 0707
   * @return Tumordurchmesser
   */
  public String getTumordurchmesser() {
    return _tumordurchmesser;
  }

  public void setTumordurchmesser(String tumordurchmesser) {
    _tumordurchmesser = tumordurchmesser;
  }

  /**
   * Offene Biopsie durchgeführt. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0708
   * @return OffeneBiopsie
   */
  public String getOffeneBiopsie() {
    return _offeneBiopsie;
  }

  public void setOffeneBiopsie(String offeneBiopsie) {
    _offeneBiopsie = offeneBiopsie;
  }

  /**
   * Gefrierschnitt. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.GefrierschnittTypConstant}.<br>
   * ParameterID: 0709
   * @return Gefrierschnitt  
   */
  public String getGefrierschnitt() {
    return _gefrierschnitt;
  }

  public void setGefrierschnitt(String gefrierschnitt) {
    _gefrierschnitt = gefrierschnitt;
  }

  /**
   * Alle Tumore bei Erstoperation entfernt. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0710
   * @return TumorEntfernt  
   */
  public String getTumorEntfernt() {
    return _tumorEntfernt;
  }

  public void setTumorEntfernt(String tumorEntfernt) {
    _tumorEntfernt = tumorEntfernt;
  }

  /**
   * Ablatio. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.AblatioTypConstant}.<br>
   * ParameterID: 0711
   * @return Ablatio  
   */
  public String getAblatio() {
    return _ablatio;
  }

  public void setAblatio(String ablatio) {
    _ablatio = ablatio;
  }

  /**
   * Multifokaler Tumor. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0712
   * @return Multifokal
   */
  public String getMultifokal() {
    return _multifokal;
  }

  public void setMultifokal(String multifokal) {
    _multifokal = multifokal;
  }

  /**
   * Neoadjuvante Therapie erhalten. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0713
   * @return NeoadjuvanteTherapie
   */
  public String getNeoadjuvanteTherapie() {
    return _neoadjuvanteTherapie;
  }

  public void setNeoadjuvanteTherapie(String neoadjuvanteTherapie) {
    _neoadjuvanteTherapie = neoadjuvanteTherapie;
  }

}
