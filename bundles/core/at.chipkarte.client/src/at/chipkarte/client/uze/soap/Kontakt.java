/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt Kontaktdaten (f&uuml;r UZE-Weisungen).
 */
public class Kontakt {
  private Adresse _adresse;
  private String _titelVorne;
  private String _vorname;
  private String _zuname;
  private String _titelHinten;
  private String _telefon;

  /**
   * Adresse des Kontaktes.<br>
   * @return Adresse
   */
  public Adresse getAdresse() {
    return _adresse;
  }

  /**
   * Titel hinten des Kontaktes.<br>
   * Die Angabe des Titels hinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return TitelHinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }
  
  /**
   * Titel vorne des Kontaktes.<br>
   * Die Angabe des Titels vorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @return TitelVorne
   */
  public String getTitelVorne() {
    return _titelVorne;
  }
  
  /**
   * Vorname des Kontaktes.<br>
   * Die Angabe des Vornamens ist optional.<br/>
   * Format: maximal 70-stellig.
   * @return Vorname
   */  
  public String getVorname() {
    return _vorname;
  }
  
  /**
   * Zuname des Kontaktes.<br>
   * Enthält den Zunamen des Kontaktes oder bei alten Uzes den kompletter Namen
   * des Kontaktes bestehend aus Titeln, Vorname und Nachname. 
   * Format: Eingabe maximal 70-stellig, Ausgabe maximal 203-stellig.
   * @return Zuname
   */  
  public String getZuname() {
    return _zuname;
  }

  /**
   * Telefon.<br>
   * Die Angabe der Telefonnummer ist optional.<br/>
   * Format: maximal 50-stellig.
   * @return Telefon
   */
  public String getTelefon() {
    return _telefon;
  }

  /**
   * Adresse des Kontaktes.<br>
   * @param adresse Der zu setzende Wert f&uuml;r Adresse.
   */
  public void setAdresse(Adresse adresse) {
    _adresse = adresse;
  }
  
  /**
   * Titel hinten des Kontaktes.<br>
   * Die Angabe der Titel hinten ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param titelHinten Der zu setzende Wert f&uuml;r Titel hinten.
   */
  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }
  
  /**
   * Titel vorne des Kontaktes.<br>
   * Die Angabe der Titel vorne ist optional.<br/>
   * Format: maximal 30-stellig.
   * @param titelVorne Der zu setzende Wert f&uuml;r Titel vorne.
   */
  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }
  
  /**
   * Vorname des Kontaktes.<br>
   * Die Angabe der Vornamen ist optional.<br/>
   * Format: maximal 70-stellig.
   * @param telefon Der zu setzende Wert f&uuml;r Vorname.
   */
  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
   * Zuname des Kontaktes.<br>
   * Enthält den Zunamen des Kontaktes oder bei alten Uzes den kompletter Namen
   * des Kontaktes bestehend aus Titeln, Vorname und Nachname. 
   * Format: Eingabe maximal 70-stellig, Ausgabe maximal 203-stellig.
   * @param Zuname Der zu setzende Wert f&uuml;r Zuname.
   */
  public void setZuname(String zuname) {
    _zuname = zuname;
  }

  /**
   * Telefon.<br>
   * Die Angabe der Telefonnummer ist optional.<br/>
   * Format: maximal 50-stellig.
   * @param telefon Der zu setzende Wert f&uuml;r Telefon.
   */
  public void setTelefon(String telefon) {
    _telefon = telefon;
  }

}
