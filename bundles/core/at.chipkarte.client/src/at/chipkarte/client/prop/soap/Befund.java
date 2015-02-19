package at.chipkarte.client.prop.soap;
/**
 * Beinhaltet einen kompletten Präoperativen Befund.
 */
public class Befund {
  private BefundData _ergebnis;
  private SvPatient _svPatient;
  private String _kennung;
  private String _protokollnummer;
  private Konsultation _konsultation;
  private Integer _version;
  private String _ausstellung;
  private Boolean _selbsterstellt;
  private EkvkPatient _ekvkPatient;
  private String _versionGiltSeit;
  private Ersteller _ersteller;

  /**
   * Fachliches Ergebnis ({@link BefundData Befunddaten}) für diesen Befund.
   * @return Befunddaten.
   */
  public BefundData getErgebnis() {
    return _ergebnis;
  }
  public void setErgebnis(BefundData ergebnis) {
    _ergebnis = ergebnis;
  }
  /**
   * Der {@link SvPatient}, für den der Befund erstellt wurde.
   * @return
   */
  public SvPatient getSvPatient() {
    return _svPatient;
  }
  public void setSvPatient(SvPatient patient) {
    _svPatient = patient;
  }
  /**
   * Für den Patienten eindeutige Kennung des Befundes. Nur versorgt, wenn der Befund gespeichert wurde.<br>
   * Format: 5-stellig
   * @return Kennung
   */
  public String getKennung() {
    return _kennung;
  }
  public void setKennung(String kennung) {
    _kennung = kennung;
  }
  /**
   * Protokollnummer - eindeutiger Bezeichner des Befundes. Besteht aus SV-Nummer und Kennung.
   * Nur versorgt, wenn der Befund gespeichert wurde.<br>
   * Format: max. 16-stellig
   * @return Protokollnummer
   * @see SvPatient#getSvNummer()
   * @see #getKennung()
   */
  public String getProtokollnummer() {
    return _protokollnummer;
  }
  public void setProtokollnummer(String protokollnummer) {
    _protokollnummer = protokollnummer;
  }
  /**
   * Die {@link Konsultation}, mit der dieser Befund verbunden ist. Nur versorgt,
   * wenn der durchführende Vertragspartner der Aktion gleich dem Vertragspartner der Konsultation ist
   * und bei der Erfassung des Präoperativen Befundes eine Konsultation angegeben wurde.<br>
   * @return Konsultation
   */
  public Konsultation getKonsultation() {
    return _konsultation;
  }
  public void setKonsultation(Konsultation konsultation) {
    _konsultation = konsultation;
  }
  /**
   * Version der Fachinformation.<br>
   * Format: max. 3-stellig
   * @return Version
   */
  public Integer getVersion() {
    return _version;
  }
  public void setVersion(Integer version) {
    _version = version;
  }
  /**
   * Ausstellungszeitpunkt.<br>
   * Format: TT.MM.JJJJ hh:mm:sss
   * @return Datum der Ausstellung
   */
  public String getAusstellung() {
    return _ausstellung;
  }
  public void setAusstellung(String ausstellung) {
    _ausstellung = ausstellung;
  }
  /**
   * <tt>true</tt>, falls es sich um einen selbsterstellten Befund handelt.
   * @return
   */
  public Boolean isSelbsterstellt() {
    return _selbsterstellt;
  }
  public void setSelbsterstellt(Boolean selbsterstellt) {
    _selbsterstellt = selbsterstellt;
  }
  
  /**
   * Daten eines Patienten ohne SV-Nummer.<br>
   * @return EkvkPatient
   * @see EkvkPatient
   */
  public EkvkPatient getEkvkPatient() {
    return _ekvkPatient;
  }
  public void setEkvkPatient(EkvkPatient ekvkPatient) {
    _ekvkPatient = ekvkPatient;
  }
  
  /**
   * Datum seit dem die Version der Fachinformation Gültigkeit hat.<br>
   * Format: TT.MM.JJJJ
   * @return Datum der Gültigkeit der Version
   */
  public String getVersionGiltSeit() {
    return _versionGiltSeit;
  }
  public void setVersionGiltSeit(String versionGiltSeit) {
    _versionGiltSeit = versionGiltSeit;
  }
  
  /**
   * Daten zum Vertragspartner und dem Arzt der Erstellung.<br>
   * @return Ersteller
   * @see Ersteller
   */
  public Ersteller getErsteller() {
    return _ersteller;
  }
  public void setErsteller(Ersteller ersteller) {
    _ersteller = ersteller;
  }

}
