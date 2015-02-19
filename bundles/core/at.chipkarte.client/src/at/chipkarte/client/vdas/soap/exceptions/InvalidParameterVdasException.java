/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn ein ungültiger Parameter in einer Funktion angegeben wird. Fehlercodes siehe
 * {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants InvalidParameterVdasExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.vdas.client.chipkarte.at")
public class InvalidParameterVdasException extends Exception {

  private InvalidParameterVdasExceptionContent _faultInfo;
  
  public InvalidParameterVdasExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterVdasExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
