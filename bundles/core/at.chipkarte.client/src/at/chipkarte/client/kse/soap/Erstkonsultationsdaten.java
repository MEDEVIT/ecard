/*
 * (C) SVC 2012
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Daten zu einer Erstkonsultation.
 */
public class Erstkonsultationsdaten {

  private String  _svNummer; 
  private String  _svNummerAbgeleitet;
  private String _anspruchId;
  private String _abgeleitetVorname;
  private String _abgeleitetNachname;
  private String _abgeleitetDruckVorname;
  private String _abgeleitetDruckNachname;  
  private String _svtCode;
  private String  _fachgebietsCode;
  private String  _behandlungsfallCode;
  private String  _behandlungsDatum;
  private String  _konsultationsartCode;

  
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setSvNummerAbgeleitet(String svNummerAbgeleitet) {
    _svNummerAbgeleitet = svNummerAbgeleitet;
  }

  public void setAnspruchId(String anspruchId) {
    _anspruchId = anspruchId;
  }

  public void setAbgeleitetVorname(String abgeleitetVorname) {
    _abgeleitetVorname = abgeleitetVorname;
  }

  public void setAbgeleitetNachname(String abgeleitetNachname) {
    _abgeleitetNachname = abgeleitetNachname;
  }

  public void setAbgeleitetDruckVorname(String abgeleitetDruckVorname) {
    _abgeleitetDruckVorname = abgeleitetDruckVorname;
  }

  public void setAbgeleitetDruckNachname(String abgeleitetDruckNachname) {
    _abgeleitetDruckNachname = abgeleitetDruckNachname;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  public void setBehandlungsfallCode(String behandlungsfallCode) {
    _behandlungsfallCode = behandlungsfallCode;
  }

  public void setBehandlungsDatum(String behandlungsDatum) {
    _behandlungsDatum = behandlungsDatum;
  }

  public void setKonsultationsartCode(String konsultationsartCode) {
    _konsultationsartCode = konsultationsartCode;
  }

  /**
   * Sozialversicherungsnummer des Patienten.
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }
  
  /**
   * Sozialversicherungsnummer des Versicherten, von dem sich der Anspruch ableitet.
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer des Versicherten, von dem sich der Anspruch ableitet
   */
  public String getSvNummerAbgeleitet() {
    return _svNummerAbgeleitet;
  }
  
  /**
   * ID des Anspruchs (eigener oder abgeleiteter, dient zur Referenzierung dieses Anspruchs in anderen Funktionen). 
   * <br/>Format: maximal 19-stellig
   * @return ID.
   */
  public String getAnspruchId() {
    return _anspruchId;
  }
  
  /**
   * Vorname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Vorname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetVorname() {
    return _abgeleitetVorname;
  }

  /**
   * Nachname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Nachname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetNachname() {
    return _abgeleitetNachname;
  }
  
  /**
   * Druckvorname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Druckvorname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetDruckVorname() {
    return _abgeleitetDruckVorname;
  }

  /**
   * Drucknachname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Drucknachname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetDruckNachname() {
    return _abgeleitetDruckNachname;
  }
  
  /**
   * Code des leistungszuständigen KVT für den Patienten.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}.
   * <br/>Format: 2-stellig
   * @return KVT-Code
   */
  public String getSvtCode() {
    return _svtCode;
  }
  
  /**
   * Code des Fachgebietes, mit dem die Konsultation durchgeführt wurde.
   * <br/>Format: 2-stellig
   * @return Fachgebietscode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }
  
  /**
   * Behandlungsfallcode mit dem die Konsultation durchgeführt wurde.
   * <br/>Format: 2-stellig
   * @return Behandlungsfallcode
   */
  public String getBehandlungsfallCode() {
    return _behandlungsfallCode;
  }
  
  /**
   * Datum der Behandlung.
   * <br/>Format: TTMMJJJJ
   * @return Behandlungsdatum
   */
  public String getBehandlungsDatum() {
    return _behandlungsDatum;
  }
  
  /**
   * Kennzeichen für die Konsultationsart. Mögliche Werte siehe
   * {@link at.chipkarte.client.kse.soap.constants.Konsultationsart Konsultationsart}.
   * <br/>Format: 3-stellig
   * @return Konsultationsartcode
   */
  public String getKonsultationsartCode() {
    return _konsultationsartCode;
  }
  
  
}
