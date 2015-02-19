/*
 * (C) SVC 2011
 */
package at.chipkarte.client.sas.soap;

/**
 * <p>
 * Enthält bei positiver Durchführung der Funktion
 * {@link at.chipkarte.client.sas.soap.ISasService#adressdatenAbfragen(String, String)} als Ergebnis die Zustelladresse der
 * abgefragten SV-Person.
 * </p>
 * <p>
 * Eine Zustelladresse kann entweder eine Anschriftsadresse oder eine Postfachadresse sein:
 * <ul>
 * <li>Eine Anschriftsadresse besteht aus den Feldern Strasse, Hausnummer, StockTuerNummer und Anschriftszusatz.</li>
 * <li>Eine Postfachadresse besteht aus den Feldern PostfachText und PostfachNummer.</li>
 * </ul>
 * </p>
 * <p>
 * Die Felder Staatscode, Plz, Ort und Abgabestelle sind beiden Adresstypen zugeordnet.
 * </p>
 */
public class Adressdaten {
  private String _staatscode;
  private String _plz;
  private String _ort;
  private String _abgabestelle;
  private String _strasse;
  private String _hausnummer;
  private String _stockTuerNummer;
  private String _anschriftszusatz;
  private String _postfachText;
  private String _postfachNummer;

  /**
   * Länderkürzel bestehend aus 3 Buchstaben zur Identifizierung des Landes (nach ISO-3-Standard).<br>
   * Format: maximal 3 Zeichen
   * @return Länderkürzel.
   */
  public String getStaatscode() {
    return _staatscode;
  }

  /**
   * Postleitzahl.<br>
   * Format: maximal 9 Zeichen
   * @return Postleitzahl.
   */
  public String getPlz() {
    return _plz;
  }

  /**
   * Ortsname.<br>
   * Format: maximal 50 Zeichen
   * @return Ortsname.
   */
  public String getOrt() {
    return _ort;
  }

  /**
   * Genauerer Hinweis über die Abgabestelle (z.B. z.H. Herrn Peter Müller, per Adresse, bei Firma).<br>
   * Format: maximal 70 Zeichen
   * @return Abgabestelle.
   */
  public String getAbgabestelle() {
    return _abgabestelle;
  }

  /**
   * Strasse (ohne Hausnummer).<br>
   * Format: maximal 50 Zeichen
   * @return Strasse.
   */
  public String getStrasse() {
    return _strasse;
  }

  /**
   * Hausnummer.<br>
   * Format: maximal 10 Zeichen
   * @return Hausnummer.
   */
  public String getHausnummer() {
    return _hausnummer;
  }

  /**
   * Stock- beziehungsweise Türnummer, getrennt durch /.<br>
   * Format: maximal 10 Zeichen
   * @return Stock- bzw. Türnummer.
   */
  public String getStockTuerNummer() {
    return _stockTuerNummer;
  }

  /**
   * Zusatzinformation, die einen genaueren Hinweis über die Adressierung gibt (z.B. Ecke Kundmanngasse oder 3. Hof).<br>
   * Format: maximal 70 Zeichen
   * @return Anschriftszusatz.
   */
  public String getAnschriftszusatz() {
    return _anschriftszusatz;
  }

  /**
   * Bezeichnung des Postfachs abhängig vom jeweiligen Staat (z.B. Postfach für Österreich, p/o Box für USA).<br>
   * Format: maximal 30 Zeichen
   * @return Bezeichnung des Postfachs.
   */
  public String getPostfachText() {
    return _postfachText;
  }

  /**
   * Nummer des Postfachs.<br>
   * Format: maximal 6 Zeichen
   * @return Nummer des Postfachs.
   */
  public String getPostfachNummer() {
    return _postfachNummer;
  }

  public void setStaatscode(String staatscode) {
    _staatscode = staatscode;
  }

  public void setPlz(String plz) {
    _plz = plz;
  }

  public void setOrt(String ort) {
    _ort = ort;
  }

  public void setAbgabestelle(String abgabestelle) {
    _abgabestelle = abgabestelle;
  }

  public void setStrasse(String strasse) {
    _strasse = strasse;
  }

  public void setHausnummer(String hausnummer) {
    _hausnummer = hausnummer;
  }

  public void setStockTuerNummer(String stockTuerNummer) {
    _stockTuerNummer = stockTuerNummer;
  }

  public void setAnschriftszusatz(String anschriftszusatz) {
    _anschriftszusatz = anschriftszusatz;
  }

  public void setPostfachText(String postfachText) {
    _postfachText = postfachText;
  }

  public void setPostfachNummer(String postfachNummer) {
    _postfachNummer = postfachNummer;
  }
}