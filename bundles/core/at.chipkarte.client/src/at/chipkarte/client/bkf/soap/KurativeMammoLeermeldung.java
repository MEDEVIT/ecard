package at.chipkarte.client.bkf.soap;

/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion createKurativeMammoLeermeldung.
 */
public class KurativeMammoLeermeldung {

  private String _svNummer;
  private Long _konsultationsID;
  private String _leistungsdatum;
  private String _versionsnummer;
  private String _erstbefunderArztID;
  private String _zweitbefunderArztID;

  /**
   * Sozialversicherungsnummer der Patientin. <br>
   * Angabe: Kann. <br>
   * Format: 10-stellig
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
  * Angabe: Bei Erfassung mit <i>SvNummer</i> bzw. gesteckter e-card muss entweder eine Konsultation oder ein
  *  Leistungsdatum angegeben werden. 
  * Bei Erfassung ohne <i>SvNummer</i> oder gesteckter e-card darf keine Konsultation angegeben werden.<br>
  * Mittels der Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfKonsultationData(String, String, String, String)} 
  * können die 
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
   * Angabe: Bei Erfassung mit <i>SvNummer</i> bzw. gesteckter e-card muss entweder eine Konsultation oder ein Leistungsdatum
   *  angegeben werden. 
   * Bei Erfassung ohne <i>SvNummer</i> muss ein Leistungsdatum eingegeben werden.<br> Darf nicht in der Zukunft liegen.<br>
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
  * Eindeutiger Bezeichner eines Arztes, Identifikation Erstbefunder. <br>
  * Muss unterschiedlich zur <i>ZweitbefunderArztID</i> (sofern angegeben) sein. 
  * Muss als zertifizierter Arzt gemeldet sein (siehe Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfArzt(String, String)}).<br>
  * Angabe: Muss. <br>
  * Format: 11-stellig<br>
  * ParameterID: 0601.
  * @return ErstbefunderArztID
  */
  public String getErstbefunderArztID() {
    return _erstbefunderArztID;
  }

  public void setErstbefunderArztID(String erstbefunderArztID) {
    _erstbefunderArztID = erstbefunderArztID;
  }

  /**
  * Eindeutiger Bezeichner eines Arztes, Identifikation Zweitbefunder. <br>
  * Muss bei Angabe unterschiedlich zur <i>ErstbefunderArztID</i> sein. 
  * Muss als zertifizierter Arzt gemeldet sein (siehe Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfArzt(String, String)}).<br>
  * Angabe: Kann. <br>
  * Format: 11-stellig<br>
  * ParameterID: 0602.
  * @return ZweitbefunderArztID
  */
  public String getZweitbefunderArztID() {
    return _zweitbefunderArztID;
  }

  public void setZweitbefunderArztID(String zweitbefunderArztID) {
    _zweitbefunderArztID = zweitbefunderArztID;
  }

}
