/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn parametrisierte Methodenaufrufe fehlerhaft versorgt werden.
 */
@WebFault(targetNamespace="http://exceptions.soap.abs.client.chipkarte.at")
public class InvalidParameterBewilligungsanfrageException extends Exception {

  private InvalidParameterBewilligungsanfrageExceptionContent _faultInfo;
  
  public InvalidParameterBewilligungsanfrageExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterBewilligungsanfrageExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
