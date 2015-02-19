package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Daten des Endergebnisses der kurativen Mammographie (<i>KurativenMammographiDoku</i>). <br>
 * ParameterID: 0470. 
 */
public class KUMEndergebnis {

  private String _befundungsZeitstempel;
  private String _zusatzaufnahmen;
  private String _inakzeptabel;
  private String _technZusatzaufnahme;
  private String _endergebnis;
  private String _dichte;
  private String _groesseLinks;
  private String _groesseRechts;
  private String _infoDatum;
  private String _patientID;
  private String _wiederbestellung;

  /**
   * Zeitstempel der Befundung. <br>
   * Muss größer oder gleich den <i>BefundungsZeitstempel</i> von 
   * <i>KUMMammographieErstbefunder</i>, <i>KUMMammographieZweitbefunder</i> (sofern <i>KUMMammographieZweitbefunder</i> angegeben 
   * wurde) und <i>KUMUltraschall</i> (sofern <i>KUMUltraschall</i> angegeben 
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
   * ParameterID: 0472.
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
   * ParameterID: 0473.
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
   * ParameterID: 0474.
   * @return TechnZusatzaufnahme
   */
  public String getTechnZusatzaufnahme() {
    return _technZusatzaufnahme;
  }

  public void setTechnZusatzaufnahme(String technZusatzaufnahme) {
    _technZusatzaufnahme = technZusatzaufnahme;
  }

  /**
   * Kurative Mammographie Endergebnis (KUM-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisEndbefundKurativTypConstant}. <br>
   * ParameterID: 0478.
   * @return Endergebnis
   */
  public String getEndergebnis() {
    return _endergebnis;
  }

  public void setEndergebnis(String endergebnis) {
    _endergebnis = endergebnis;
  }

  /**
   * Endbefund Ergebnis Dichte (D-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DichteTypConstant}.<br>
   * ParameterID: 0479.
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
   * Angabe: Bedingt. 
   * Bei Bef&uuml;llung von <i>Endergebnis</i> mit einem Wert >= 4 (4, 5 oder 6): 
   * <i>GroesseRechts</i> und/oder <i>GroesseLinks</i> muss angegeben werden.
   * Bei Bef&uuml;llung von <i>Endergebnis</i> mit einem Wert < 4 (0, 1, 2, oder 3): 
   * Weder <i>GroesseRechts</i> noch <i>GroesseLinks</i> darf angegeben werden.<br>
   * Format: numerisch, maximal 3-stellig, Wertebereich 1-200.<br>
   * ParameterID: 0480.
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
   * ParameterID: 0481.
   * @return GroesseRechts
   */
  public String getGroesseRechts() {
    return _groesseRechts;
  }

  public void setGroesseRechts(String groesseRechts) {
    _groesseRechts = groesseRechts;
  }

  /**
   * Datum, ab dem der Befund versand- / abholbereit ist. <br>
   * Muss gr&ouml;&szlig;er oder gleich dem Datum in <i>BefundungsZeitstempel</i>  und kleiner oder gleich 
   * dem aktuellen Datum + 1 Monat sein.
   * <br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0486.
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
   * @return PatientID
   */
  public String getPatientID() {
    return _patientID;
  }

  public void setPatientID(String patientID) {
    _patientID = patientID;
  }

  /**
   * Grund für die Wiederbestellung. <br>
   * Angabe: Muss.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.WiederbestellungsGrundTypConstant}.<br>
   * ParameterID: 0488
   * @return Wiederbestellung
   */
  public String getWiederbestellung() {
    return _wiederbestellung;
  }

  public void setWiederbestellung(String wiederbestellung) {
    _wiederbestellung = wiederbestellung;
  }

}