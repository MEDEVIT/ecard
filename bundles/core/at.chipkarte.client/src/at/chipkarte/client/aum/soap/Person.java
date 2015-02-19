/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap;
/**
 * Diese Klasse enthält alle personenbezogenen Daten einer Meldung.
 * Ein Patient kann identifiziert werden durch:
 * <ul>
 *  <li>SV-Nummer (in diesem Fall kann <code>ungeprueft</code> gleich <code>true</code> oder <code>false</code> sein.</li>
 *  <li>Vorname, Zuname, Geschlecht, EKVK-Nummer und EKVK-Träger (EKVK-Patient - <code>ungeprueft</code> muss <code>false</code> sein.)</li>
 *  <li>Vorname, Zuname, Geburtsdatum (Patient ohne bzw. mit nicht bekannter SV-Nummer,  <code>ungeprueft</code> muss <code>true</code> sein.)</li>
 * </ul>
 * Die Felder, die den Patienten im jeweiligen Fall identifizieren, sind Pflichtfelder. Falls eine SV-Nummer angegeben ist,
 * dürfen weder die EKVK-Nummer noch der EKVK-Träger gesetzt sein.<br>
 * Wird eine SV-Nummer angegeben, muss diese im e-card-System bekannt sein. Wenn nicht wird ein Fehler ausgegeben (unabhängig von <code>ungeprueft</code> gleich <code>true</code> oder <code>false</code>).
 */
public class Person {
  private String _ekvkNummer;
  private String _ekvkTraeger;
  protected String _vorname;
  protected String _druckVorname;
  protected String _zuname;
  protected String _druckZuname;
  protected String _geschlecht;
  protected String _geburtsdatum;
  protected String _svNummer;
  
  /**
   * SV-Nummer des Patienten. 
   * <br>Format:  10-stellig
   * @return SV-Nummer
   */
  public String getSvNummer() {
    return _svNummer;
  }
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }
  
  /**
   * EKVK-Nummer des EKVK-Patienten. 
   * <br>Format: maximal 20-stellig 
   * @return EKVK-Nummer
   */
  public String getEkvkNummer() {
    return _ekvkNummer;
  }
  public void setEkvkNummer(String nummer) {
    _ekvkNummer = nummer;
  }
  /**
   * Der (ausländische) KVT des EKVK-Patienten.
   * <br>Format: maximal 70-stellig 
   * @return EKVK-Träger
   */
  public String getEkvkTraeger() {
    return _ekvkTraeger;
  }
  public void setEkvkTraeger(String traeger) {
    _ekvkTraeger = traeger;
  }
  /**
   * Geschlechts-Code des EKVK-Patienten.
   * <br>mögliche Werte: {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlechtscodes}.
   * <br>Format: 1-stellig 
   *  @return Code des Geschlechts
   */
  public String getGeschlecht() {
    return _geschlecht;
  }
  public void setGeschlecht(String geschlecht) {
    _geschlecht = geschlecht;
  }
  /**
   * Zuname des Patienten. 
   * <br>Bei Verwendung des Objektes als Eingangsparameter: Pflichtfeld für EKVK-Patienten und für Meldungen ohne 
   * Anspruch und ohne <i>SvNummer</i>.<br>
   * Bei Verwendung des Objektes als Ausgangsparameter: Dieser Parameter enthält den Zunamen des Patienten - unabhängig 
   * davon ob der Patienten mittels SV-Nummer oder manuell per Personendatenangabe erfasst wurde. 
   * <br>Format: maximal 70-stellig
   * @return Zuname der Person
   */
  public String getZuname() {
    return _zuname;
  }
  public void setZuname(String zuname) {
    _zuname = zuname;
  }
  /**
   * Druckzuname des Patienten (im Zeichensatz UTF-8); Ausgabefeld, wird nur im Rückgabewert 
   * der Funktion <i>meldungAnlegen()</i> verwendet, sonst immer null. 
   * <br>Format: maximal 70-stellig
   * @return Druckzuname der Person
   */
  public String getDruckZuname() {
    return _druckZuname;
  }
  public void setDruckZuname(String druckZuname) {
    _druckZuname = druckZuname;
  }    
  /**
   * Vorname des Patienten.
   * <br>Bei Verwendung des Objektes als Eingangsparameter: Pflichtfeld für EKVK-Patienten und für Meldungen ohne 
   * Anspruch und ohne <i>SvNummer</i>.<br>
   * Bei Verwendung des Objektes als Ausgangsparameter: Dieser Parameter enthält den Vornamen des Patienten - unabhängig 
   * davon ob der Patienten mittels SV-Nummer oder manuell per Personendatenangabe erfasst wurde. 
   * <br>Format: maximal 70-stellig
   * @return Vorname der Person
   */
  public String getVorname() {
    return _vorname;
  }
  public void setVorname(String vorname) {
    _vorname = vorname;
  }
  /**
   * Druckvorname des Patienten (im Zeichensatz UTF-8); Ausgabefeld, wird nur im Rückgabewert 
   * der Funktion <i>meldungAnlegen()</i> verwendet, sonst immer null. 
   * <br>Format: maximal 70-stellig
   * @return Druckvorname der Person
   */
  public String getDruckVorname() {
    return _druckVorname;
  }
  public void setDruckVorname(String druckVorname) {
    _druckVorname = druckVorname;
  }  
  /**
   * Das Geburtsdatum des Patienten.
   * <br>Pflichtfeld falls <code>ungeprueft == true</code> und keine SV-Nummer angegeben ist.
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Geburtsdatum
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }
  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

}
