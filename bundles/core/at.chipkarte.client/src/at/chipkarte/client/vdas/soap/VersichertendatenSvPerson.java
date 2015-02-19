/*
 * Sämtliche Werknutzungs- und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap;

/**
 * Enthält die Daten zu einem Patienten. Die Daten stammen vom e-card-Serversystem.
 */
public class VersichertendatenSvPerson {
  private String _geburtsdatum;
  private String _geschlecht;
  private String _nachname;
  private String _titelHinten;
  private String _titelVorne;
  private String _vorname;
  private String _svNummer;
  private String _todesdatum;
  private String _todesdatumBestaetigt;
  private java.lang.String _druckNachname;
  private java.lang.String _druckTitelHinten;
  private java.lang.String _druckTitelVorne;
  private java.lang.String _druckVorname;

  /**
   * Geburtsdatum des Patienten.<br>
   * Format: 10-stellig, TT.MM.JJJJ
   * @return Geburtsdatum
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Geschlecht des Patienten.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht}.<br>
   * Format: 1-stellig
   * @return Geschlechtscode
   */
  public String getGeschlecht() {
    return _geschlecht;
  }

  /**
   * Nachname des Patienten im reduzierten Zeichensatzumfang von Latin-1. Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * @return Nachname
   */
  public String getNachname() {
    return _nachname;
  }

  /**
   * Titel hinten des Patienten im reduzierten Zeichensatzumfang von Latin-1. Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * @return Titel hinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Titel vorne des Patienten im reduzierten Zeichensatzumfang von Latin-1. Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * @return Titel vorne
   */
  public String getTitelVorne() {
    return _titelVorne;
  }

  /**
   * Vorname des Patienten im reduzierten Zeichensatzumfang von Latin-1. Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * DruckNachname des Patienten im Datensatz von UTF-8.
   * @return DruckNachname
   */
  public String getDruckNachname() {
    return _druckNachname;
  }

  /**
   * DruckTitel hinten des Patienten im Datensatz von UTF-8.
   * @return DruckTitel hinten
   */
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  /**
   * DruckTitel vorne des Patienten im Datensatz von UTF-8.
   * @return DruckTitel vorne
   */
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  /**
   * DruckVorname des Patienten im Datensatz von UTF-8.
   * @return DruckVorname
   */
  public String getDruckVorname() {
    return _druckVorname;
  }

  /**
   * Sozialversicherungsnummer des Patienten.
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Datumsangabe des Todes des Patienten. 
   * <br>Das Feld wird nur im Falle des Todes des Patienten gesetzt, sonst ist es leer.<br>
   * Format: 10-stellig, TT.MM.JJJJ
   * @return Todesdatum
   */
  public String getTodesdatum() {
    return _todesdatum;
  }

  /**
   * Gibt an, ob das angegebene Todesdatum bestätigt ist (<i>1</i> - JA) oder nicht (<i>0</i> - NEIN). 
   * <br>Wenn der Patient nicht als verstorben 
   * geführt wird, bleibt
   * dieses Feld leer (nicht null).<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.vdas.soap.constants.TodesdatumBestaetigt}.<br>
   * Format: 1-stellig
   * @return TodesdatumBestaetigt Code
   */
  public String getTodesdatumBestaetigt() {
    return _todesdatumBestaetigt;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  public void setGeschlecht(String geschlecht) {
    _geschlecht = geschlecht;
  }

  public void setNachname(String nachname) {
    _nachname = nachname;
  }

  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }


  public void setDruckNachname(String druckNachname) {
    _druckNachname = druckNachname;
  }

  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }

  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }

  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setTodesdatum(String todesdatum) {
    _todesdatum = todesdatum;
  }

  public void setTodesdatumBestaetigt(String todesdatumBestaetigt) {
    _todesdatumBestaetigt = todesdatumBestaetigt;
  }

}
