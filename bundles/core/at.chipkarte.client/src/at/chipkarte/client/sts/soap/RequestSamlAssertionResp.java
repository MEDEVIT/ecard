/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap;

/**
 * Enthält die Ausgangsdaten der Funktion
 * {@link at.chipkarte.client.sts.soap.IStsService#requestSamlAssertion(String, RequestSamlAssertionReq, String) requestSamlAssertion}.
 */
public class RequestSamlAssertionResp {
  private String _samlTicket;

  /**
   * Liefert die generierte SAML-Assertion als XML-String.<br>
   * 
   * @return SAML-Assertion als XML-String
   */
  public String getSamlTicket() {
    return _samlTicket;
  }

  /**
   * Setzt die generierte SAML-Assertion als XML-String.<br>
   * 
   * @param samlTicket
   *          SAML-Assertion als XML-String
   */
  public void setSamlTicket(String samlTicket) {
    this._samlTicket = samlTicket;
  }

}
