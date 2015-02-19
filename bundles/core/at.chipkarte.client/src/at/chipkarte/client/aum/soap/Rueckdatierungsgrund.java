/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap;
/**
 * Gibt einen der möglichen Werte und Bezeichnungen des Attributs
 * <code>RueckdatierungsgrundCode</code> der Klasse {@link Meldungsdaten} an.
 * @see IAumService#getRueckdatierungsgrundCodes().
  */

public class Rueckdatierungsgrund {
  private String _code;
  private String _beschreibung;
  /**
   * Beschreibung des Rückdatierungsgrundes. 
   * <br>Format: maximal 50-stellig 
   * @return Beschreibung
   */
  public String getBeschreibung() {
    return _beschreibung;
  }
  public void setBeschreibung(String beschreibung) {
    _beschreibung = beschreibung;
  }
  /**
   * Code des Rückdatierungsgrundes.
   * <br>Format: 2-stellig 
   * @return Code
   */
  public String getCode() {
    return _code;
  }
  public void setCode(String code) {
    _code = code;
  }
}
