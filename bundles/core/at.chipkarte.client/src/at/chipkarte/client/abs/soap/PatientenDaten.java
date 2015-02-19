/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten des Patienten, für den eine {@link BewilligungsAnfrage} gestellt wird.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class PatientenDaten {
  private String _sVNummer;
  private String _eKVKNummer;
  private String _nachname;
  private String _vorname;
  private String _geschlecht;
  private String _sVTCode;
  private String _druckNachname;
  private String _druckVorname;
  private Boolean _rezeptGebBefreit;

  /**
   * Die Sozialversicherungsnummer des Patienten, sofern der Patient in Österreich versichert ist. 
   * <br/>Format: 10-stellig, numerisch 
   * <br/>Die Sozialversicherungsnummer muss den Regeln für Sozialversicherungsnummern entsprechen (Prüfziffer). 
   * <br/>Die Angabe der Sozialversicherungsnummer ist optional. Wird sie nicht angegeben, muss jedoch entweder die
   * {@link #getEKVKNummer() EKVK-Nummer} angegeben werden oder es muss die e-card, im dem Dialog zugeordneten Kartenleser
   * gesteckt sein. Im letzteren Fall wird die Sozialversicherungsnummer automatisch ausgelesen.
   * @return Sozialversicherungsnummer
   */
  public String getSVNummer() {
    return _sVNummer;
  }

  /**
   * Die EKVK-Nummer des Patienten aus der europäischen Krankenversicherungskarte (EKVK), sofern der Patient im
   * EU-Ausland versichert ist. 
   * <br/>Format: maximal 20-stellig 
   * <br/>Die Angabe der EKVK-Nummer ist optional. Wird sie nicht angegeben, gilt die Bestimmung für die Eingabe der
   * Sozialversicherungsnummer, siehe auch {@link #getSVNummer() SVNummer}.
   * @return EKVK-Nummer
   */
  public String getEKVKNummer() {
    return _eKVKNummer;
  }

  /**
   * Nachname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return Nachname
   */
  public String getNachname() {
    return _nachname;
  }

  /**
   * Vorname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * Drucknachname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return DruckNachname
   */
  public String getDruckNachname() {
    return _druckNachname;
  }

  /**
   * Druckvorname des Patienten. 
   * <br/>Format: maximal 70-stellig
   * @return DruckVorname
   */
  public String getDruckVorname() {
    return _druckVorname;
  }

  /**
   * Geschlecht des Patienten. 
   * <br/>Wertebereich: siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht}
   * <br/>Die Angabe des Geschlechts ist optional.
   * @return Geschlecht
   */
  public String getGeschlecht() {
    return _geschlecht;
  }

  /**
   * Der eindeutige Code des leistungszuständigen Krankenversicherungsträgers. 
   * <br/>Siehe {@link IAbsService#getSVTs()} beziehungsweise auch {@link at.chipkarte.client.base.soap.SvtProperty#getCode()
   *         SvtProperty#getCode()}. 
   * <br/>Die Angabe des KVT-Codes ist optional. In diesem Fall wird der KVT vom System automatisch ermittelt.
   * <br/>Format: 2-stellig, alphanumerisch
   * @return Code des Krankenversicherungsträgers
   */
  public String getSVTCode() {
    return _sVTCode;
  }

  /**
   * Kennzeichen, ob der Patient von der Rezeptgebühr befreit ist.
   * @return True, wenn der Patient von der Rezeptgebühr befreit ist.
   */
  public Boolean isRezeptGebBefreit() {
    return _rezeptGebBefreit;
  }

  public void setSVNummer(String sVNummer) {
    _sVNummer = sVNummer;
  }

  public void setEKVKNummer(String eKVKNummer) {
    _eKVKNummer = eKVKNummer;
  }

  public void setNachname(String nachname) {
    _nachname = nachname;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  public void setDruckNachname(String druckNachname) {
    _druckNachname = druckNachname;
  }

  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }

  public void setGeschlecht(String geschlechtPatient) {
    _geschlecht = geschlechtPatient;
  }

  public void setSVTCode(String sVTCode) {
    _sVTCode = sVTCode;
  }

  public void setRezeptGebBefreit(Boolean rezeptGebBefreit) {
    _rezeptGebBefreit = rezeptGebBefreit;
  }

}
