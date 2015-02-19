/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn ein Fehler in Zusammenhang mit Kartenleser oder Karte auftritt. Fehlercodes siehe
 * {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants CardExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.base.client.chipkarte.at")
public class CardException extends Exception {

  private CardExceptionContent _faultInfo;
  
  public CardExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(CardExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
  
}
