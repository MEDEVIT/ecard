/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap;

/**
 * Gibt einen der möglichen Werte und Bezeichnungen des Attributs
 * <code>DiagnoseCode</code> der Klasse {@link Meldungsdaten} an.
 * @see IAumService#getDiagnoseCodeTyp().
  */
public class DiagnoseCodeTyp {
  String _code;
  String _bezeichnung;
  /**
   * Bezeichnung des <code>DiagnoseCodeTyp</code>.
   * <br>Format: maximal 50-stellig 
   * @return Bezeichnung
   */
  public String getBezeichnung() {
    return _bezeichnung;
  }
  public void setBezeichnung(String bezeichnung) {
    _bezeichnung = bezeichnung;
  }
  /**
   * Code des <code>DiagnoseCodeTyp</code>. 
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
