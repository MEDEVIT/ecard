/*
 * (C) SVC 2011
 */
package at.chipkarte.client.sas.soap;

/**
 * <p>
 * Enthält die Suchkriterien für die Suche nach der SV-Nummer eines Patienten mittels der Funktion
 * {@link at.chipkarte.client.sas.soap.ISasService#svNummerAbfragen(String, Suchkriterien) svNummerAbfragen}.
 * </p>
 * <p>
 * Alle Felder der Suchkriterien müssen befüllt sein.
 * </p>
 */
public class Suchkriterien {

  private String _familienname = null;

  private String _vorname = null;

  private String _geburtsdatum = null;

  /**
   * Familienname der gesuchten SV-Person. <br>
   * Format: maximal 70 Zeichen. <br>
   * Folgende Zeichen sind in den Namensfeldern erlaubt:
   * <ul>
   * <li>Buchstaben des deutschen Alphabets (a-z, A-Z, ä, Ä, ö, Ö, ü, Ü, ß)</li>
   * <li>Trennzeichen (Leerzeichen, Bindestrich, Hochkomma)</li>
   * </ul>
   * @return Familienname der gesuchten SV-Person
   */
  public String getFamilienname() {
    return _familienname;
  }

  /**
   * Geburtsdatum der gesuchten SV-Person. <br>
   * Format: TT.MM.JJJJ, muss ein gültiges Kalenderdatum sein
   * @return Geburtsdatum der gesuchten SV-Person
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Vorname der gesuchten SV-Person. <br>
   * Format: maximal 70 Zeichen. <br>
   * Folgende Zeichen sind in den Namensfeldern erlaubt:
   * <ul>
   * <li>Buchstaben des deutschen Alphabets (a-z, A-Z, ä, Ä, ö, Ö, ü, Ü, ß)</li>
   * <li>Trennzeichen (Leerzeichen, Bindestrich, Hochkomma)</li>
   * </ul>
   * @return Vorname der gesuchten SV-Person
   */
  public String getVorname() {
    return _vorname;
  }

  public void setFamilienname(String familienname) {
    _familienname = familienname;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }
}