package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Daten des Endergebnisses der <i>ScreeningDoku.</i> <br>
 * ParameterID: 0170. 
 */
public class SCREndergebnis {

  private String _befundungsZeitstempel;
  private String _zusatzaufnahmen;
  private String _inakzeptabel;
  private String _technZusatzaufnahme;
  private String _doppelbefundung;
  private String _endergebnis;
  private String _dichte;
  private String _groesseLinks;
  private String _groesseRechts;
  private String _vorgehen;
  private String _infoDatum;
  private String _patientID;
  private String _wiederbestellung;

  /**
   * Zeitstempel der Befundung. <br>
   * Muss größer oder gleich den <i>BefundungsZeitstempel</i> von 
   * <i>SCRMammographieErstbefunder</i>, <i>SCRMammographieZweitbefunder</i> (sofern <i>SCRMammographieZweitbefunder</i> angegeben 
   * wurde) und <i>SCRUltraschall</i> (sofern <i>SCRUltraschall</i> angegeben 
   * wurde) sein und darf nicht mehr als 5 Minuten in der Zukunft liegen. Muss größer oder gleich dem <i>Leistungsdatum</i> bzw. dem 
   * <i>Behandlungsdatum</i> der gewählten Konsultation sein.<br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ hh:mm:ss<br>
   * ParameterID: 0185.
   * @return BefundungsZeitstempel
   */
  public String getBefundungsZeitstempel() {
    return _befundungsZeitstempel;
  }

  public void setBefundungsZeitstempel(String befundungsZeitstempel) {
    _befundungsZeitstempel = befundungsZeitstempel;
  }

  /**
   * Aus medizinischen beziehungsweise anatomischen Gründen wurden mammographische Zusatzaufnahmen durchgeführt. <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0173.
   * @return Zusatzaufnahmen
   */
  public String getZusatzaufnahmen() {
    return _zusatzaufnahmen;
  }

  public void setZusatzaufnahmen(String zusatzaufnahmen) {
    _zusatzaufnahmen = zusatzaufnahmen;
  }

  /**
   * Zumindest eine Aufnahme war radiologisch inakzeptabel. <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0172.
   * @return Inakzeptabel
   */
  public String getInakzeptabel() {
    return _inakzeptabel;
  }

  public void setInakzeptabel(String inakzeptabel) {
    _inakzeptabel = inakzeptabel;
  }

  /**
   * Zumindest eine Aufnahme musste aus technischen Gründen wiederholt werden. <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.JaNeinTypConstant}.<br>
   * ParameterID: 0174.
   * @return TechnZusatzaufnahme
   */
  public String getTechnZusatzaufnahme() {
    return _technZusatzaufnahme;
  }

  public void setTechnZusatzaufnahme(String technZusatzaufnahme) {
    _technZusatzaufnahme = technZusatzaufnahme;
  }

  /**
   * Setting der Doppelbefundung. <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DoppelbefundungTypConstant}.<br>
   * ParameterID: 0177.
   * @return Doppelbefundung
   */
  public String getDoppelbefundung() {
    return _doppelbefundung;
  }

  public void setDoppelbefundung(String doppelbefundung) {
    _doppelbefundung = doppelbefundung;
  }

  /**
   * Endergebnis (SC-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisEndbefundScreeningTypConstant}.<br>
   * ParameterID: 0178.
   * @return Endergebnis
   */
  public String getEndergebnis() {
    return _endergebnis;
  }

  public void setEndergebnis(String endergebnis) {
    _endergebnis = endergebnis;
  }

  /**
   * Ergebnis Dichte (D-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DichteTypConstant}.<br>
   * ParameterID: 0179.
   * @return Dichte
   */
  public String getDichte() {
    return _dichte;
  }

  public void setDichte(String dichte) {
    _dichte = dichte;
  }

  /**
   * Größe der Läsion links in mm. <br>
   * Bei Bef&uuml;llung von <i>Endergebnis</i> mit einem Wert >= 4 (4, 5 oder 6): 
   * <i>GroesseRechts</i> und/oder <i>GroesseLinks</i> muss angegeben werden.
   * Bei Bef&uuml;llung von <i>Endergebnis</i> mit einem Wert < 4 (0, 1, 2, oder 3): 
   * Weder <i>GroesseRechts</i> noch <i>GroesseLinks</i> darf angegeben werden.<br>
   * Format: numerisch, maximal 3-stellig, Wertebereich 1-200.<br>
   * ParameterID: 0180.
   * @return GroesseLinks
   */
  public String getGroesseLinks() {
    return _groesseLinks;
  }

  public void setGroesseLinks(String groesseLinks) {
    _groesseLinks = groesseLinks;
  }

  /**
   * Größe der Läsion rechts in mm. <br>
   * Bei Bef&uuml;llung von <i>Endergebnis</i> mit einem Wert >= 4 (4, 5 oder 6): 
   * <i>GroesseRechts</i> und/oder <i>GroesseLinks</i> muss angegeben werden.
   * Bei Bef&uuml;llung von <i>Endergebnis</i> mit einem Wert < 4 (0, 1, 2, oder 3): 
   * Weder <i>GroesseRechts</i> noch <i>GroesseLinks</i> darf angegeben werden.<br>
   * Format: numerisch, maximal 3-stellig, Wertebereich 1-200.<br>
   * ParameterID: 0181.
   * @return GroesseRechts
   */
  public String getGroesseRechts() {
    return _groesseRechts;
  }

  public void setGroesseRechts(String groesseRechts) {
    _groesseRechts = groesseRechts;
  }

  /**
   * Weiteres Vorgehen bei Endergebnis gleich SC3. <br>
   * Angabe: Bedingt. Muss gesetzt werden, wenn <i>Endergebnis</i> gleich '3' ('SC3'). Darf anderenfalls nicht gesetzt werden.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.WeiteresVorgehenTypConstant}.<br>
   * ParameterID: 0182.
   * @return Vorgehen
   */
  public String getVorgehen() {
    return _vorgehen;
  }

  public void setVorgehen(String vorgehen) {
    _vorgehen = vorgehen;
  }

  /**
   * Datum, ab dem der Befund versand- / abholbereit ist. <br>
   * Muss gr&ouml;&szlig;er oder gleich dem Datum in <i>BefundungsZeitstempel</i> und kleiner oder gleich 
   * dem aktuellen Datum + 1 Monat sein.<br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0186.
   * @return InfoDatum
   */
  public String getInfoDatum() {
    return _infoDatum;
  }

  public void setInfoDatum(String infoDatum) {
    _infoDatum = infoDatum;
  }

  /**
   * ID der Patientin in der Vertragspartnersoftware. <br>
   * Angabe: Kann. Wird die <i>PatientID</i> vom Radiologen nicht angegeben, können die 
   * probandinnenbezogenen Daten im Feedbackbericht nicht zugeordnet werden.<br>
   * Format: maximal 64-stellig.<br>
   * ParameterID: 0187.
   * @return InfoDatum
   */
  public String getPatientID() {
    return _patientID;
  }

  public void setPatientID(String patientID) {
    _patientID = patientID;
  }

  /**
   * Grund für eine Wiederbestellung. <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.WiederbestellungsGrundTypConstant}.<br>
   * ParameterID: 0188.
   * @return Wiederbestellung
   */
  public String getWiederbestellung() {
    return _wiederbestellung;
  }

  public void setWiederbestellung(String wiederbestellung) {
    _wiederbestellung = wiederbestellung;
  }

}