package at.chipkarte.client.bkf.soap;

/**
 * Enth&auml;lt die Ergebnisdaten zur Therapiedokumentation Pathologie, zum Aufruf der Funktion <i>createTherapiePathologieDoku</i>. 
 */
public class TherapiePathologieDoku {

  private String _svNummer;
  private String _versionsnummer;
  private String _operationsdatum;
  private String _befundungszeitstempel;
  private String _seite;
  private String _gefrierschnitt;
  private String _diameter;
  private String _diagnoseHistologie;
  private String _rezidiv;
  private String _multifokal;
  private String _lcis;
  private String _microinvasion;
  private String _dcis;
  private String _oestrogen;
  private String _progesteron;
  private String _pTStadium;
  private String _lymphgefaesseinbruch;
  private String _blutgefaesseinbruch;
  private String _resektionsraender;
  private String _invasivTyp;
  private String _invasivPureSpecial;
  private String _intraduktaleKomponente;
  private String _tumorgrad;
  private String _her2;
  private String _proliferationsindex;
  private String _pNStadium;

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
   * Darf nicht mehr als 5 Minuten in der Zukunft liegen.<br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0901.
   * @return Operationsdatum.
   */
  public String getOperationsdatum() {
    return _operationsdatum;
  }

  public void setOperationsdatum(String operationsdatum) {
    _operationsdatum = operationsdatum;
  }

  /**
  * Datum der Befundung. <br>
  * Darf nicht in der Zukunft liegen.<br>
  * Angabe: Muss. <br>
  * Format: TT.MM.JJJJ hh:mm:ss <br>
  * ParameterID: 0902.
  * @return BefundungsZeitstempel
  */
  public String getBefundungszeitstempel() {
    return _befundungszeitstempel;
  }

  public void setBefundungszeitstempel(String befundungszeitstempel) {
    _befundungszeitstempel = befundungszeitstempel;
  }

  /**
   * Betroffene Seite. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.TherapieseiteConstant}.<br>
   * ParameterID: 0903
   * @return Seite
   */
  public String getSeite() {
    return _seite;
  }

  public void setSeite(String seite) {
    _seite = seite;
  }

  /**
   * Gefrierschnitt. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.GefrierschnittTypConstant}.<br>
   * ParameterID: 0904
   * @return Gefrierschnitt
   */
  public String getGefrierschnitt() {
    return _gefrierschnitt;
  }

  public void setGefrierschnitt(String gefrierschnitt) {
    _gefrierschnitt = gefrierschnitt;
  }

  /**
   * Größe Tumordurchmesser. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit einem Wert
   * ungleich '1' ('Normal') oder '2' ('Benigne L&auml;sion') 
   * angegeben ist. Anderenfalls optional angebbar (bei <i>DiagnoseHistologie</i> gleich '1' oder '2').<br>
   * Format: numerisch, maximal 3-stellig, Wertebereich 0-200.<br>
   * ParameterID: 0905
   * @return Diameter
   */
  public String getDiameter() {
    return _diameter;
  }

  public void setDiameter(String diameter) {
    _diameter = diameter;
  }

  /**
   * Histologische Diagnose. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.HistologischeDiagnoseTypConstant}.<br>
   * ParameterID: 0906
   * @return DiagnoseHistologie
   */
  public String getDiagnoseHistologie() {
    return _diagnoseHistologie;
  }

  public void setDiagnoseHistologie(String diagnoseHistologie) {
    _diagnoseHistologie = diagnoseHistologie;
  }

  /**
   * Rezidiv. <br>
   * Angabe: Bedingt.
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit einem Wert
   * ungleich '1' ('Normal') oder '2' ('Benigne L&auml;sion') 
   * angegeben ist. Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> gleich '1' oder '2').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0907
   * @return Rezidiv
   */
  public String getRezidiv() {
    return _rezidiv;
  }

  public void setRezidiv(String rezidiv) {
    _rezidiv = rezidiv;
  }

  /**
  * Multifokaler Tumor. <br>
  * Angabe: Bedingt. 
  * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit einem Wert
  * ungleich '1' ('Normal') oder '2' ('Benigne L&auml;sion') 
  * angegeben ist. Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> gleich '1' oder '2').<br>
  * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
  * ParameterID: 0908
  * @return Rezidiv
  */
  public String getMultifokal() {
    return _multifokal;
  }

  public void setMultifokal(String multifokal) {
    _multifokal = multifokal;
  }

  /**
   * LCIS: Spezifizierung. <br>
   * Angabe: Bedingt.
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '3' ('LCIS') angegeben ist. Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '3').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.LCISTypConstant}.<br>
   * ParameterID: 0909
   * @return Lcis
   */
  public String getLcis() {
    return _lcis;
  }

  public void setLcis(String lcis) {
    _lcis = lcis;
  }

  /**
   * DCIS: Mikroinvasion vorhanden. <br>
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') angegeben ist. Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4').<br>
   * Angabe: Bedingt.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0910
   * @return Microinvasion
   */
  public String getMicroinvasion() {
    return _microinvasion;
  }

  public void setMicroinvasion(String microinvasion) {
    _microinvasion = microinvasion;
  }

  /**
   * DCIS: Spezifizierung. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') angegeben ist. Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DCISTypConstant}.<br>
   * ParameterID: 0911
   * @return Dcis
   */
  public String getDcis() {
    return _dcis;
  }

  public void setDcis(String dcis) {
    _dcis = dcis;
  }

  /**
   * Östrogenrezeptor-Status. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') oder '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4' oder '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.RezeptorStatusTypConstant}.<br>
   * ParameterID: 0912
   * @return Oestrogen
   */
  public String getOestrogen() {
    return _oestrogen;
  }

  public void setOestrogen(String oestrogen) {
    _oestrogen = oestrogen;
  }

  /**
   * Progesteronrezeptor-Status. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') oder '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4' oder '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.RezeptorStatusTypConstant}.<br>
   * ParameterID: 0913
   * @return Progesteron
   */
  public String getProgesteron() {
    return _progesteron;
  }

  public void setProgesteron(String progesteron) {
    _progesteron = progesteron;
  }
  
  /**
   * pT Stadium nach UICC. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') oder '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4' oder '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.PTStadiumTypConstant}.<br>
   * ParameterID: 0914
   * @return pTStadium
   */
  public String getpTStadium() {
    return _pTStadium;
  }

  public void setpTStadium(String pTStadium) {
    _pTStadium = pTStadium;
  }

  /**
   * Gefäßeinbrüche (Lymphgefäße). <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') oder '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4' oder '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.LymphgefaesseinbruchTypConstant}.<br>
   * ParameterID: 0915
   * @return Lymphgefaesseinbruch
   */
  public String getLymphgefaesseinbruch() {
    return _lymphgefaesseinbruch;
  }

  public void setLymphgefaesseinbruch(String lymphgefaesseinbruch) {
    _lymphgefaesseinbruch = lymphgefaesseinbruch;
  }

  /**
   * Gefäßeinbrüche (Blutgefäße). <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') oder '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4' oder '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.BlutgefaesseinbruchTypConstant}.<br>
   * ParameterID: 0916
   * @return Blutgefaesseinbruch
   */
  public String getBlutgefaesseinbruch() {
    return _blutgefaesseinbruch;
  }

  public void setBlutgefaesseinbruch(String blutgefaesseinbruch) {
    _blutgefaesseinbruch = blutgefaesseinbruch;
  }

  /**
   * Resektionsränder (Tumor am tuschemarkierten Resektionsrand). <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert
   *  '4' ('DCIS') oder '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '4' oder '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ResektionsraenderTypConstant}.<br>
   * ParameterID: 0917
   * @return Resektionsraender
   */
  public String getResektionsraender() {
    return _resektionsraender;
  }

  public void setResektionsraender(String resektionsraender) {
    _resektionsraender = resektionsraender;
  }

  /**
   * Invasiv: Invasiver Typ. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.InvasivTypConstant}.<br>
   * ParameterID: 0918
   * @return InvasivTyp
   */
  public String getInvasivTyp() {
    return _invasivTyp;
  }

  public void setInvasivTyp(String invasivTyp) {
    _invasivTyp = invasivTyp;
  }

  /**
   * Invasiv: Pure Special. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>InvasivTyp</i> mit dem Wert '3' ('pure special') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>InvasivTyp</i> ungleich '3').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.PureSpecialTypConstant}.<br>
   * ParameterID: 0919
   * @return InvasivPureSpecial
   */
  public String getInvasivPureSpecial() {
    return _invasivPureSpecial;
  }

  public void setInvasivPureSpecial(String invasivPureSpecial) {
    _invasivPureSpecial = invasivPureSpecial;
  }

  /**
   * Invasiv: Intraduktale Komponente. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0920
   * @return IntraduktaleKomponente
   */
  public String getIntraduktaleKomponente() {
    return _intraduktaleKomponente;
  }

  public void setIntraduktaleKomponente(String intraduktaleKomponente) {
    _intraduktaleKomponente = intraduktaleKomponente;
  }

  /**
   * Tumorgrad nach Elston und Ellis. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.TumorgradTypConstant}.<br>
   * ParameterID: 0921
   * @return Tumorgrad
   */
  public String getTumorgrad() {
    return _tumorgrad;
  }

  public void setTumorgrad(String tumorgrad) {
    _tumorgrad = tumorgrad;
  }

  /**
   * HER2 Status. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.RezeptorStatusTypConstant}.<br>
   * ParameterID: 0922
   * @return Her2
   */
  public String getHer2() {
    return _her2;
  }

  public void setHer2(String her2) {
    _her2 = her2;
  }

  /**
   * Proliferationsindex Ki67. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ProlieferationsindexTypConstant}.<br>
   * ParameterID: 0923
   * @return Proliferationsindex
   */
  public String getProliferationsindex() {
    return _proliferationsindex;
  }

  public void setProliferationsindex(String proliferationsindex) {
    _proliferationsindex = proliferationsindex;
  }

  /**
   * pN Stadium nach UICC. <br>
   * Angabe: Bedingt. 
   * Muss angegeben werden, wenn <i>DiagnoseHistologie</i> mit dem Wert '5' ('invasives Karzinom') angegeben ist. 
   * Anderenfalls ist keine Angabe erlaubt (bei <i>DiagnoseHistologie</i> ungleich '5').<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.PNStadiumTypConstant}.<br>
   * ParameterID: 0924
   * @return PNStadium
   */
  public String getpNStadium() {
    return _pNStadium;
  }

  public void setpNStadium(String pNStadium) {
    _pNStadium = pNStadium;
  }

}