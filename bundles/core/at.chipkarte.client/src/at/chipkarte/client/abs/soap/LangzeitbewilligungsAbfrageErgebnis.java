/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält das Ergebnis einer {@link at.chipkarte.client.abs.soap.IAbsService#abfragenLangzeitbewilligung(String, String, String)
 * LangzeitbewilligungsAbfrage}.
 * </p>
 */
public class LangzeitbewilligungsAbfrageErgebnis {
  private String _vornamePatient;
  private String _nachnamePatient;
  private String _sVNRPatient;
  private String _medikamentName;
  private String _pharmanummer;
  private String _dosierung;
  private Integer _bewilligteAbgabemenge;
  private Integer _offeneAbgabemenge;
  private Integer _maximaleAbgabemenge;
  private Integer _monatsBedarf;
  private Boolean _abgabeMoeglich;
  private String _datumNaechstMoeglicheFolgeverordnung;
  private Boolean _heuteBereitsVerordnet;
  private Integer _heuteBereitsVerordneteMenge;
  private String _datumGueltigBis;
  private String _druckVornamePatient;
  private String _druckNachnamePatient;

  /**
   * Kennzeichen, ob zum Zeitpunkt der Abfrage eine Folgeverordnung ausgestellt werden kann.
   * @return True, wenn das Ausstellen möglich ist
   */
  public Boolean isAbgabeMoeglich() {
    return _abgabeMoeglich;
  }

  /**
   * Kennzeichen, ob der Verordner an diesem Tag bereits eine Folgeverordnung zu diesem Patienten und diesem Medikament erfolgreich
   * verbucht hat. 
   * <br/>Ist dieses Feld True, so enthält das Feld {@link #getHeuteBereitsVerordneteMenge() heuteBereitsVerordneteMenge} die
   * ausgestellte Packungsanzahl.
   * @return True, wenn bereits eine Folgeverordnung erfolgreich verbucht wurde
   */
  public Boolean isHeuteBereitsVerordnet() {
    return _heuteBereitsVerordnet;
  }

  /**
   * Bewilligte gesamte Abgabemenge (Packungsanzahl) des verschriebenen Medikaments. 
   * <br/>Format: [1..99]
   * @return Bewilligte Abgabemenge
   */
  public Integer getBewilligteAbgabemenge() {
    return _bewilligteAbgabemenge;
  }

  /**
   * Enddatum der Langzeitbewilligung. 
   * <br/>Format: TT.MM.JJJJ, 10-stellig 
   * @return Enddatum der Langzeitbewilligung
   */
  public String getDatumGueltigBis() {
    return _datumGueltigBis;
  }

  /**
   * Nächst möglicher Zeitpunkt für die Folgeverordnung, wenn das Ausstellen einer Folgeverordnung zum 
   * heutigen Zeitpunkt nicht möglich ist. 
   * <br/>Dieser Parameter ist optional und nur gesetzt, falls derzeit keine Abgabe möglich 
   * ist, siehe:  {@link #isAbgabeMoeglich() isAbgabeMoeglich}. Ansonsten <code>null</code>.
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Nächst möglicher Zeitpunkt für die Folgeverordnung
   */
  public String getDatumNaechstMoeglicheFolgeverordnung() {
    return _datumNaechstMoeglicheFolgeverordnung;
  }

  /**
   * Dosierung/Abgabemodus der Verordnung (z.B.: 1-0-1). 
   * <br/>Format: maximal 25-stellig
   * @return Dosierung
   */
  public String getDosierung() {
    return _dosierung;
  }

  /**
   * Gesamt offene Abgabemenge (Packungsanzahl). 
   * <br/>Format: [1..99]
   * @return Gesamt offene Abgabemenge
   */
  public Integer getOffeneAbgabemenge() {
    return _offeneAbgabemenge;
  }

  /**
   * Packungsanzahl der heute verbuchten Folgeverordnung, wenn der Verordner an diesem Tag bereits eine Folgeverordnung zu 
   * diesem Patienten und diesem Medikament erfolgreich verbucht hat.
   * <br/>Siehe {@link #isHeuteBereitsVerordnet()
   *         isHeuteBereitsVerordnet}. Ansonsten <code>0</code>.
   * @return Packungsanzahl der heute verbuchten Folgeverordnung 
   */
  public Integer getHeuteBereitsVerordneteMenge() {
    return _heuteBereitsVerordneteMenge;
  }

  /**
   * Maximale Abgabemenge (Packungsanzahl) für die Folgeverordnung. 
   * <br/>Format: [1..99]
   * @return Maximale Abgabemenge für die Folgeverordnung
   */
  public Integer getMaximaleAbgabemenge() {
    return _maximaleAbgabemenge;
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
   * Monatsbedarf des verschriebenen Medikaments. 
   * <br/>Format: [1..99]
   * @return Monatsbedarf
   */
  public Integer getMonatsBedarf() {
    return _monatsBedarf;
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
   * @return DruckNachname des Patienten
   */
  public String getDruckNachnamePatient() {
    return _druckNachnamePatient;
  }

  /**
   * Pharmanummer des Medikaments. 
   * <br/>Format: maximal 9-stellig, numerisch 
   * <br/>Die Pharmanummer muss den Regeln für Pharmanummern (Prüfziffer) entsprechen.
   * @return Pharmanummer
   */
  public String getPharmanummer() {
    return _pharmanummer;
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
   * @return DruckVorname des Patienten
   */
  public String getDruckVornamePatient() {
    return _druckVornamePatient;
  }

  public void setBewilligteAbgabemenge(Integer bewilligteAbgabemenge) {
    _bewilligteAbgabemenge = bewilligteAbgabemenge;
  }

  public void setAbgabeMoeglich(Boolean abgabeMoeglich) {
    _abgabeMoeglich = abgabeMoeglich;
  }

  public void setDatumGueltigBis(String datumGueltigBis) {
    _datumGueltigBis = datumGueltigBis;
  }

  public void setDatumNaechstMoeglicheFolgeverordnung(String datumNaechstMoeglicheFolgeverordnung) {
    _datumNaechstMoeglicheFolgeverordnung = datumNaechstMoeglicheFolgeverordnung;
  }

  public void setDosierung(String dosierung) {
    _dosierung = dosierung;
  }

  public void setOffeneAbgabemenge(Integer offeneAbgabemenge) {
    _offeneAbgabemenge = offeneAbgabemenge;
  }

  public void setHeuteBereitsVerordnet(Boolean heuteBereitsVerordnet) {
    _heuteBereitsVerordnet = heuteBereitsVerordnet;
  }

  public void setHeuteBereitsVerordneteMenge(Integer heuteBereitsVerordneteMenge) {
    _heuteBereitsVerordneteMenge = heuteBereitsVerordneteMenge;
  }

  public void setMaximaleAbgabemenge(Integer maximaleAbgabemenge) {
    _maximaleAbgabemenge = maximaleAbgabemenge;
  }

  public void setMedikamentName(String medikamentName) {
    _medikamentName = medikamentName;
  }

  public void setMonatsBedarf(Integer monatsBedarf) {
    _monatsBedarf = monatsBedarf;
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

  public void setSVNRPatient(String patient) {
    _sVNRPatient = patient;
  }

  public void setVornamePatient(String vornamePatient) {
    _vornamePatient = vornamePatient;
  }
  public void setDruckVornamePatient(String druckVornamePatient) {
    _druckVornamePatient = druckVornamePatient;
  }

}