package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet Referenzdaten für einen Präoperativen Befund.
 */
public class BefundReferenz {
  private SvPatient _SvPatient;
  private String _kennung;
  private String _protokollnummer;
  private String _ausstellung;
  private EkvkPatient _ekvkPatient;

  /**
   * Patient, für den der Befund erstellt wurde.<br>
   * @return Patientendaten
   */
  public SvPatient getSvPatient() {
    return _SvPatient;
  }
  public void setSvPatient(SvPatient patient) {
    _SvPatient = patient;
  }
  /**
   * Patienteneindeutige Kennung.<br>
   * Format: 5-stellig
   * @return Kennung
   * @see Befund#getKennung()
   */
  public String getKennung() {
    return _kennung;
  }
  public void setKennung(String kennung) {
    _kennung = kennung;
  }
  /**
   * Protokollnummer.<br>
   * Format: 16-stellig
   * @return Protokollnummer
   * @see Befund#getProtokollnummer()
   */
  public String getProtokollnummer() {
    return _protokollnummer;
  }
  public void setProtokollnummer(String protokollnummer) {
    _protokollnummer = protokollnummer;
  }
  /**
   * Ausstellungsdatum.<br>
   * Format: 10-stellig, TT.MM.JJJJ
   * @return Ausstellungsdatum
   */
  public String getAusstellung() {
    return _ausstellung;
  }
  public void setAusstellung(String ausstellung) {
    _ausstellung = ausstellung;
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

}
