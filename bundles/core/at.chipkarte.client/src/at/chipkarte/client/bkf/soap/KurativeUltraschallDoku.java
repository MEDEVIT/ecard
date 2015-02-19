package at.chipkarte.client.bkf.soap;

/**
 * Enthält die Ergebnisdaten der kurativen Ultraschalluntersuchung, zum Aufruf 
 * der Funktion <i>createKurativeUltraschallDoku</i>.
 */
public class KurativeUltraschallDoku {

  private String _svNummer;
  private Long _konsultationsID;
  private String _leistungsdatum;
  private String _versionsnummer;
  private String _befundungsZeitstempel;
  private String _ergebnis;
  private String _groesseLinks;
  private String _groesseRechts;
  private String _infoDatum;
  private String _patientID;
  
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
   * Darf nicht mehr als 5 Minuten in der Zukunft liegen.<br>
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
  * Datum der Befundung. <br>
  * Darf nicht in der Zukunft liegen. Muss größer oder gleich dem <i>Leistungsdatum</i> bzw. dem 
  * <i>Behandlungsdatum</i> der gewählten Konsultation sein.<br>
  * Angabe: Muss. <br>
  * Format: TT.MM.JJJJ hh:mm:ss <br>
  * ParameterID: 0801.
  * @return BefundungsZeitstempel
  */
  public String getBefundungsZeitstempel() {
    return _befundungsZeitstempel;
  }
  public void setBefundungsZeitstempel(String befundungsZeitstempel) {
    _befundungsZeitstempel = befundungsZeitstempel;
  }
  
  /**
  * Ergebnis Ultraschall (US-SCORE). <br>
  * Angabe: Muss. <br>
  * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisUltraschallAssessmentTypConstant}.<br>
  * ParameterID: 0802.
  * @return Ergebnis
  */
  public String getErgebnis() {
    return _ergebnis;
  }
  public void setErgebnis(String ergebnis) {
    _ergebnis = ergebnis;
  }
  
  /**
   * Größe der Läsion links in mm. <br>
   * Angabe: Bedingt. 
   * Bei Befuuml;llung von <i>Ergebnis</i> mit einem Wert >= 4 (4, 5 oder 6): 
   * <i>GroesseRechts</i> und/oder <i>GroesseLinks</i> muss angegeben werden.
   * Bei Befuuml;llung von <i>Ergebnis</i> mit einem Wert < 4 (0, 1, 2, oder 3): 
   * Weder <i>GroesseRechts</i> noch <i>GroesseLinks</i> darf angegeben werden.<br>
   * Format: numerisch, maximal 3-stellig, Wertebereich 1-200.<br>
   * ParameterID: 0804.
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
   * Angabe: Bedingt. 
   * Bei Befuuml;llung von <i>Ergebnis</i> mit einem Wert >= 4 (4, 5 oder 6): 
   * <i>GroesseRechts</i> und/oder <i>GroesseLinks</i> muss angegeben werden.
   * Bei Befuuml;llung von <i>Ergebnis</i> mit einem Wert < 4 (0, 1, 2, oder 3): 
   * Weder <i>GroesseRechts</i> noch <i>GroesseLinks</i> darf angegeben werden.<br>
   * Format: numerisch, maximal 3-stellig, Wertebereich 1-200.<br>
   * ParameterID: 0805.
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
   * dem aktuellen Datum + 1 Monat sein.<br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ <br>
   * ParameterID: 0806.
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
   * ParameterID: 0807.
   * @return InfoDatum
   */
  public String getPatientID() {
    return _patientID;
  }
  public void setPatientID(String patientID) {
    _patientID = patientID;
  }
}
