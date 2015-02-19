/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält die Daten der Zustelladresse eines DMP-Patienten.
 * </p>
 * <p>
 * Eine Zustelladresse kann entweder eine Anschriftsadresse oder eine Postfachadresse sein:
 * <ul>
 * <li>Eine Anschriftsadresse besteht aus den Feldern: Strasse, StockTuerNummer und Hausnummer.
 * <li>Eine Postfachadresse besteht aus den Feldern: PostfachNummer und PostfachText
 * </ul>
 * </p>
 * <p>
 * Wenn eine PostfachNummer angegeben ist, handelt es sich um eine Postfachadresse. Wenn eine Postfachadresse gesetzt ist, wird die
 * Anschriftsadresse ignoriert.
 * </p>
 * <p>
 * Die Adresse sollte dann angegeben werden, wenn sie von der Meldeadresse abweicht.
 * </p>
 */
public class Zustelladresse {

  private String _plz;
  private String _ort;

  // Anschriftsadresse
  private String _strasse;
  private String _stockTuerNummer;
  private String _hausnummer;

  // Postfachadresse
  private String _postfachNummer;
  private String _postfachText;

  private String _adresszusatz;

  /**
   * Adresszusatz.<br>
   * Die Angabe des Adresszusatzes ist optional.<br>
   * Format: maximal 70-stellig.
   * @return Adresszusatz
   */
  public String getAdresszusatz() {
    return _adresszusatz;
  }

  /**
   * Hausnummer.<br>
   * Die Angabe der Hausnummer ist optional. Die Hausnummer wird im Falle einer Postfachadresse ignoriert. Es muss entweder
   * Postfach- oder Hausnummer gemeinsam mit dem Ort und Plz angegeben werden.<br>
   * Format: maximal 10-stellig.
   * @return Hausnummer
   */
  public String getHausnummer() {
    return _hausnummer;
  }

  /**
   * Ort.<br>
   * Muss gemeinsam mit der Plz und entweder Postfach- oder Hausnummer angegeben werden.<br>
   * Format: maximal 40-stellig.
   * @return Ort
   */
  public String getOrt() {
    return _ort;
  }

  /**
   * Postleitzahl.<br>
   * Muss gemeinsam mit dem Ort und entweder Postfach- oder Hausnummer angegeben werden.<br>
   * Format: maximal 9-stellig.
   * @return Postleitzahl
   */
  public String getPlz() {
    return _plz;
  }

  /**
   * PostfachNummer.<br>
   * Die Angabe der PostfachNummer ist optional. Wenn eine PostfachNummer angegeben ist, handelt es sich um eine Postfachadresse und
   * die Felder der Anschriftsadresse werden ignoriert. Es muss entweder Postfach- oder Hausnummer gemeinsam mit dem Ort und Plz
   * angegeben werden.<br>
   * Format: maximal 6-stellig.
   * @return PostfachNummer
   */
  public String getPostfachNummer() {
    return _postfachNummer;
  }

  /**
   * PostfachText.<br>
   * Die Angabe des PostfachTextes ist optional. Wenn KEINE Postfachadresse angegeben ist, wird der PostfachText ignoriert.<br>
   * Format: maximal 30-stellig.
   * @return PostfachText
   */
  public String getPostfachText() {
    return _postfachText;
  }

  /**
   * StockTuerNummer.<br>
   * Die Angabe der StockTuerNummer ist optional. Wenn eine Postfachadresse angegeben ist, wird die StockTuerNummer ignoriert.<br>
   * Format: maximal 10-stellig.
   * @return StockTuerNummer
   */
  public String getStockTuerNummer() {
    return _stockTuerNummer;
  }

  /**
   * Straße.<br>
   * Die Angabe der Straße ist optional. Wenn eine Postfachadresse angegeben ist, wird die Straße ignoriert.<br>
   * Format: maximal 60-stellig.
   * @return Straße
   */
  public String getStrasse() {
    return _strasse;
  }

  public void setAdresszusatz(String adresszusatz) {
    _adresszusatz = adresszusatz;
  }

  public void setHausnummer(String hausnummer) {
    _hausnummer = hausnummer;
  }

  public void setOrt(String ort) {
    _ort = ort;
  }

  public void setPlz(String plz) {
    _plz = plz;
  }

  public void setPostfachNummer(String postfachNummer) {
    _postfachNummer = postfachNummer;
  }

  public void setPostfachText(String postfachText) {
    _postfachText = postfachText;
  }

  public void setStockTuerNummer(String stockTuerNummer) {
    _stockTuerNummer = stockTuerNummer;
  }

  public void setStrasse(String strasse) {
    _strasse = strasse;
  }

}
