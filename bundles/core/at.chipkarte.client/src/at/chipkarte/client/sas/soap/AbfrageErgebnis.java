/*
 * (C) SVC 2011
 */
package at.chipkarte.client.sas.soap;


/**
 * <p>
 * Enthält bei positiver Durchführung der Funktionen
 * {@link at.chipkarte.client.sas.soap.ISasService#svNummerAbfragen(String, Suchkriterien) svNummerAbfragen} beziehungsweise
 * {@link at.chipkarte.client.sas.soap.ISasService#patientendatenAbfragen(String) patientendatenAbfragen} als Ergebnis die
 * Patientendaten.
 * </p>
 * <p>
 * Zusätzlich zur gefundenen SV-Nummer werden auch die bei der Suche übergebenen Daten wieder zurückgeliefert. Dabei werden
 * allerdings die Namensfelder in jener Schreibweise geliefert, wie sie in der e-card-Datenbank vorliegen (wurde beispielsweise nach
 * "Hans-Peter Huber" gesucht, aber ein "Hans Peter Huber" gefunden, so wird als Vorname "Hans Peter" zurückgeliefert).
 * </p>
 * <p>
 * Es sind immer alle Felder des AbfrageErgebnis befüllt.
 * </p>
 */
public class AbfrageErgebnis {

  private String _familienname = null;

  private String _vorname = null;

  private String _druckfamilienname = null;

  private String _druckvorname = null;

  private String _geburtsdatum = null;

  private String _svNummer = null;

  private String _todesdatum = null;

  private String _todesdatumBestaetigtKZ = null;

  /**
   * Familienname der gefundenen SV-Person (in der Schreibweise in der die Person in der e-card-Datenbank gespeichert ist). <br>
   * Format: maximal 70 Zeichen
   * @return Familienname der gefundenen SV-Person
   */
  public String getFamilienname() {
    return _familienname;
  }

  /**
   * DruckFamilienname der gefundenen SV-Person. <br>
   * Format: maximal 70 Zeichen
   * @return DruckFamilienname der gefundenen SV-Person
   */
  public String getDruckFamilienname() {
    return _druckfamilienname;
  }


  /**
   * Geburtsdatum der gefundenen SV-Person. <br>
   * Format: TT.MM.JJJJ
   * @return Geburtsdatum der gefundenen SV-Person
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Sozialversicherungsnummer der gefundenen SV-Person. <br>
   * Format: 10-stellig, nummerisch
   * @return Sozialversicherungsnummer der gefundenen SV-Person
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Vorname der gefundenen SV-Person (in der Schreibweise in der die Person in der e-card-Datenbank gespeichert ist). <br>
   * Format: maximal 70 Zeichen
   * @return Vorname der gefundenen SV-Person
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * DruckVorname der gefundenen SV-Person. <br>
   * Format: maximal 70 Zeichen
   * @return DruckVorname der gefundenen SV-Person
   */
  public String getDruckVorname() {
    return _druckvorname;
  }

  /**
   * Das Todesdatum des Patienten.<br>
   * Das Feld wird nur im Falle des gemeldeten Todes des Patienten gesetzt, sonst ist es leer.<br>
   * Format: TT.MM.JJJJ
   * @return Todesdatum des Patienten
   */
  public String getTodesdatum() {
    return _todesdatum;
  }

  /**
   * Gibt an ob das Todesdatum bestätigt ist (true) oder nicht (false). Wenn der Patient im eCS nicht als verstorben geführt wird,
   * bleibt dieses Feld leer (nicht null).
   * @return Mögliche Werte siehe Codes in {@link at.chipkarte.client.sas.soap.constants.TodesdatumBestaetigtKZ}.
   */
  public String getTodesdatumBestaetigtKZ() {
    return _todesdatumBestaetigtKZ;
  }

  public void setFamilienname(String familienname) {
    _familienname = familienname;
  }

  public void setDruckFamilienname(String druckfamilienname) {
    _druckfamilienname = druckfamilienname;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  public void setDruckVorname(String druckvorname) {
    _druckvorname = druckvorname;
  }

  public void setTodesdatum(String todesdatum) {
    _todesdatum = todesdatum;
  }

  public void setTodesdatumBestaetigtKZ(String todesdatumBestaetigtKZ) {
    _todesdatumBestaetigtKZ = todesdatumBestaetigtKZ;
  }

}