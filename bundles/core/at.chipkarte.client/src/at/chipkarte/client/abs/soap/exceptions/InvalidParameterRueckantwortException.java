/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception, wenn Parameter für die Funktion {@link IAbsService#getRueckantwort(String, String) IAbsService.getRueckantwort()}
 * fehlerhaft versorgt werden.
 */
@WebFault(targetNamespace="http://exceptions.soap.abs.client.chipkarte.at")
public class InvalidParameterRueckantwortException extends Exception {

  private InvalidParameterRueckantwortExceptionContent _faultInfo;
  
  public InvalidParameterRueckantwortExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterRueckantwortExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
