/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die HTML Seite des Patienteninformationsblattes.
 */
public class PIBPrepareResp {
  private String _pib;

  /**
   * Patienteninformationsblatt in html-Format.<br>
   * @return Pib Patienteninformationsblatt in html-Format als String.
   */
  public String getPib() {
    return _pib;
  }

  /**
   * Patienteninformationsblatt in html-Format.<br>
   * @param pib Das zu setzende Patienteninformationsblatt. 
   */
  public void setPib(String pib) {
    _pib = pib;
  }

}
