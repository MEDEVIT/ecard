/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Bestätigung einer ausgestellten
 * {@link at.chipkarte.client.abs.soap.IAbsService#sendenFolgeverordnung(String, FolgeverordnungsAusstellungsParameter, String)
 * Folgeverordnung}.
 * </p>
 */
public class FolgeverordnungsAusstellungsErgebnis {
  private String _referenzNr;
  private String _sVTCode;
  private String _medikamentName;
  private String _pharmanummer;
  private Integer _bewilligteAbgabemenge;
  private String _vornamePatient;
  private String _nachnamePatient;
  private String _sVNRPatient;
  private String _druckVornamePatient;
  private String _druckNachnamePatient;
  private Boolean _rezeptGebBefreit;  

  /**
   * Bewilligte Abgabemenge (Packungsanzahl) des verschriebenen Medikaments. 
   * <br/>Format: [1..99]
   * @return Bewilligte Abgabemenge
   */
  public Integer getBewilligteAbgabemenge() {
    return _bewilligteAbgabemenge;
  }

  /**
   * Eindeutiger Name des Medikaments.
   * <br/>Format: maximal 100-stellig
   * @return Medikamentenname
   */
  public String getMedikamentName() {
    return _medikamentName;
  }

  /**
   * Nachname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return Nachname des Patienten
   */
  public String getNachnamePatient() {
    return _nachnamePatient;
  }

  /**
   * Drucknachname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return Nachname des Patienten
   */
  public String getDruckNachnamePatient() {
    return _druckNachnamePatient;
  }

  /**
   * Pharmanummer des Medikaments. 
   * <br/>Format: maximal 9-stellig, numerisch 
   * <br/>Die Pharmanummer muss den Regeln für Pharmanummern (Prüfziffer) entsprechen.
   * <br/>Die Angabe der Pharmanummer ist optional. Wird sie nicht angegeben, muss jedoch der {@link #getMedikamentName() Medikamentname} 
   * angegeben werden.
   * @return Pharmanummer
   */
  public String getPharmanummer() {
    return _pharmanummer;
  }

  /**
   * Referenznummer der Folgeverordnung. 
   * <br/>Format: maximal 38-stellig
   * @return Referenznummer
   */
  public String getReferenzNr() {
    return _referenzNr;
  }

  /**
   * Sozialversicherungsnummer des Patienten. 
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer
   */
  public String getSVNRPatient() {
    return _sVNRPatient;
  }

  /**
   * Eindeutiger Code des leistungszuständigen Krankenversicherungsträgers.
   * <br/>Mögliche Werte siehe
   * {@link at.chipkarte.client.abs.soap.IAbsService#getSVTs() getSVTs}. 
   * <br/>Format: 2-stellig
   * @return Code des leistungszuständigen Sozialversicherungsträgers
   */
  public String getSVTCode() {
    return _sVTCode;
  }

  /**
   * Vorname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return Vorname des Patienten
   */
  public String getVornamePatient() {
    return _vornamePatient;
  }

  /**
   * Druckvorname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return Vorname des Patienten
   */
  public String getDruckVornamePatient() {
    return _druckVornamePatient;
  }

  /**
   * Kennzeichen, ob der Patient von der Rezeptgebühr befreit ist.
   * @return True, wenn der Patient von der Rezeptgebühr befreit ist.
   */
  public Boolean isRezeptGebBefreit() {
    return _rezeptGebBefreit;
  }
  
  public void setBewilligteAbgabemenge(Integer bewilligteAbgabemenge) {
    _bewilligteAbgabemenge = bewilligteAbgabemenge;
  }

  public void setMedikamentName(String medikamentName) {
    _medikamentName = medikamentName;
  }

  public void setNachnamePatient(String nachnamePatient) {
    _nachnamePatient = nachnamePatient;
  }

  public void setDruckNachnamePatient(String druckNachnamePatient) {
    _druckNachnamePatient = druckNachnamePatient;
  }

  public void setPharmanummer(String pharmanummer) {
    _pharmanummer = pharmanummer;
  }

  public void setReferenzNr(String referenzNr) {
    _referenzNr = referenzNr;
  }

  public void setSVNRPatient(String patient) {
    _sVNRPatient = patient;
  }

  public void setSVTCode(String code) {
    _sVTCode = code;
  }

  public void setVornamePatient(String vornamePatient) {
    _vornamePatient = vornamePatient;
  }

  public void setDruckVornamePatient(String druckVornamePatient) {
    _druckVornamePatient = druckVornamePatient;
  }

  public void setRezeptGebBefreit(Boolean rezeptGebBefreit) {
    _rezeptGebBefreit = rezeptGebBefreit;
  }
}