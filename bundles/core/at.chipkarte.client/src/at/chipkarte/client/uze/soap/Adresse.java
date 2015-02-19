/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enthält die Daten einer Adresse.
 */
public class Adresse {
  private String _landbezeichnung;
  private String _ort;
  private String _plz;
  private String _strasse;

  /**
   * Liefert die Kurzbezeichnung des Landes.<br/>
   * Format: maximal 3-stellig.<br/>
   * Die Angabe der Landbezeichnung ist optional.
   * @return Kurzbezeichnung des Landes als String
   */
  public String getLandbezeichnung() {
    return _landbezeichnung;
  }

  /**
   * Setzt die Kurzbezeichnung des Landes.<br/>
   * Format: maximal 3-stellig.<br/>
   * Die Angabe der Landbezeichnung ist optional.
   * @param landbezeichnung Kurzbezeichnung des Landes
   */
  public void setLandbezeichnung(String landbezeichnung) {
    _landbezeichnung = landbezeichnung;
  }

  /**
   * Liefert den Ortsnamen der Adresse.<br/>
   * Format: maximal 40-stellig.<br/>
   * Die Angabe der Landbezeichnung ist optional.<br/>
   * @return Ortsname der Adresse als String
   */
  public String getOrt() {
     return _ort;
  }

  /**
   * Setzt den Ortsnamen der Adresse.<br/>
   * Format: maximal 40-stellig.<br/>
   * Die Angabe der Landbezeichnung ist optional.<br/>
   * @param ort Ortsname der Adresse
   */
  public void setOrt(String ort) {
    _ort = ort;
  }

  /**
   * Liefert die Postleitzahl der Adresse.<br/>
   * Format: maximal 9-stellig.<br/>
   * Die Angabe der Postleitzahl ist optional.<br/>
   * @return Postleitzahl der Adresse als String
   */  
  public String getPLZ() {
     return _plz;
  }

  /**
   * Setzt die Postleitzahl der Adresse.<br/>
   * Format: maximal 9-stellig.<br/>
   * Die Angabe der Postleitzahl ist optional.<br/>
   * @param plz Postleitzahl der Adresse
   */ 
  public void setPLZ(String plz) {
    _plz = plz;
  }

  /**
   * Liefert den Straßennamen sowie eventuell die Hausnummer der Adresse.<br/>
   * Bei alten UZE enthält dieses Feld die Adresse bestehend aus PLZ, Ort, Straße, Nummer etc.<br/>
   * Format: Eingabe maximal 60-stellig, Ausgabe maximal 120-stellig<br/>
   * Die Angabe der Straße ist optional.<br/>
   * @return Straßename als String
   */ 
  public String getStrasse() {
     return _strasse;
  }

  /**
   * Setzt den Straßenamen sowie eventuell die Hausnummer der Adresse.<br/>
   * Bei alten UZE enthält dieses Feld die Adresse bestehend aus PLZ, Ort, Straße, Nummer etc.<br/>
   * Format: Eingabe maximal 60-stellig, Ausgabe maximal 120-stellig<br/>
   * Die Angabe der Straße ist optional.<br/>
   * @param strasse Straßename der Adresse
   */ 
  public void setStrasse(String strasse) {
    _strasse = strasse;
  }
}
