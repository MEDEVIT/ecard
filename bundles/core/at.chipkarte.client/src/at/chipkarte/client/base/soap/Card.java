/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap;

/**
 * Enthält die Daten zu der eingelesenen Karte.
 */
public class Card {

  private String _cardType;

  private String _cin;

  private String _csn;

  private String _geburtsdatum;

  private String _vorname;

  private String _vornameLatin1;

  private String _geschlechtCode;

  private String _titel;

  private String _titelLatin1;

  private String _nachname;

  private String _nachnameLatin1;

  private String _titelHinten;

  private String _titelHintenLatin1;

  private String _nummer;

  public Card() {

  }

  /**
   * Kartentyp.
   * <br>Format: maximal 20-stellig
   * <br>mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.CardType CardType} 
   * @return Kartentyp
   */

  public String getCardType() {
    return _cardType;
  }

  /**
   * <b>C</b>ard <b>I</b>dentification <b>N</b>umber, eindeutige Nummer der Karte im e-card-System. 
   * <br>Format: maximal 20-stellig
   * @return Cin
   */

  public String getCin() {
    return _cin;
  }

  /**
   * Laufnummer der Karte pro Kartenbesitzer. 
   * <br>Format: 3-stellig
   * @return Csn
   */

  public String getCsn() {
    return _csn;
  }

  /**
   * Geburtsdatum des Kartenbesitzers. 
   * <br>Format : TT.MM.JJJJ
   * @return Geburtsdatum
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Vorname des Kartenbesitzers im UTF-8 Zeichensatz. 
   * <br>Format: maximal 70-stellig
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  /**
   * Vorname des Kartenbesitzers im Latin-1 Format (ISO-8859-1). 
   * <br>Format: maximal 70-stellig
   * @return Vorname im Latin-1 Format
   */
  public String getVornameLatin1() {
    return _vornameLatin1;
  }

  /**
   * Geschlecht des Kartenbesitzers.
   * <br>Format: 1-stellig
   * <br>Mögliche Werte: siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht Geschlecht}
   * @return Geschlechtscode
   */
  public String getGeschlechtCode() {
    return _geschlechtCode;
  }

  /**
   * Titel des Kartenbesitzers im UTF-8 Zeichensatz. 
   * <br>Format: maximal 30-stellig
   * @return Titel
   */
  public String getTitel() {
    return _titel;
  }

  /**
   * Titel des Kartenbesitzers im Latin-1 Format (ISO-8859-1). 
   * <br>Format: maximal 30-stellig
   * @return Titel im Latin-1 Format
   */
  public String getTitelLatin1() {
    return _titelLatin1;
  }

  /**
   * Nachname des Kartenbesitzers / Organisationsname im UTF-8 Zeichensatz. 
   * <br>Format: maximal 70-stellig
   * @return Nachname
   */
  public String getNachname() {
    return _nachname;
  }

  /**
   * Nachname des Kartenbesitzers / der Organisation im Latin-1 Format (ISO-8859-1). 
   * <br>Format: maximal 70-stellig
   * @return Nachname im Latin-1 Format
   */
  public String getNachnameLatin1() {
    return _nachnameLatin1;
  }

  /**
   * Titel hinten des Kartenbesitzers im UTF-8 Zeichensatz. 
   * <br>Format: maximal 30-stellig
   * @return Titel hinten
   */
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Titel hinten des Kartenbesitzers im Latin-1 Format (ISO-8859-1). 
   * <br>Format: maximal 30-stellig
   * @return Titel hinten im Latin-1 Format
   */
  public String getTitelHintenLatin1() {
    return _titelHintenLatin1;
  }

  /**
   * Sozialversicherungsnummer bei e-card, Vertragspartnernummer bei o-card. 
   * <br>Format: maximal 10-stellig
   * @return Sozialversicherungsnummer bei e-card, Vertragspartnernummer bei o-card
   */

  public String getNummer() {
    return _nummer;
  }

  public void setCin(String cin) {
    _cin = cin;
  }

  public void setCsn(String csn) {
    _csn = csn;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    _geburtsdatum = geburtsdatum;
  }

  public void setNachname(String nachname) {
    _nachname = nachname;
  }

  public void setNachnameLatin1(String nachnameLatin1) {
    _nachnameLatin1 = nachnameLatin1;
  }

  public void setNummer(String nummer) {
    _nummer = nummer;
  }

  public void setTitel(String titel) {
    _titel = titel;
  }

  public void setTitelLatin1(String titelLatin1) {
    _titelLatin1 = titelLatin1;
  }

  public void setCardType(String type) {
    _cardType = type;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  public void setVornameLatin1(String vornameLatin1) {
    _vornameLatin1 = vornameLatin1;
  }

  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  public void setTitelHintenLatin1(String titelHintenLatin1) {
    _titelHintenLatin1 = titelHintenLatin1;
  }

  public void setGeschlechtCode(String geschlechtCode) {
    _geschlechtCode = geschlechtCode;
  }

}