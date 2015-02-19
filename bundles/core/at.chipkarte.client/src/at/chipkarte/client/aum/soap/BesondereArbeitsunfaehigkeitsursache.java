/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap;
/**
 * Gibt einen der möglichen Werte und Bezeichnungen des Attributs 
 * <code>BesondereArbeitfaehigkeitsursacheCode</code> von 
 * {@link Meldungsdaten} an.
 * @see IAumService#getBesondereArbeitsunfaehigkeitsursacheCodes().
 */
public class BesondereArbeitsunfaehigkeitsursache {
  private String _code;
  private String _bezeichnung;
  /**
   * Bezeichnung der besonderen Arbeitsunfähigkeitsursache. 
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
   * Code der besonderen Arbeitsunfähigkeitsursache.
   * <br>Format: 3-stellig 
   * @return Code
   */
  public String getCode() {
    return _code;
  }
  public void setCode(String code) {
    _code = code;
  }
}
