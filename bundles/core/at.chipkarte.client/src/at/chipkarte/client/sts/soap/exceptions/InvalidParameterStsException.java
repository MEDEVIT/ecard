/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * 
 * Exception, wenn ein ungültiger Parameter in einer Funktion angegeben wird.
 * Fehlercodes siehe
 * {@link at.chipkarte.client.sts.soap.constants.InvalidParameterStsExceptionConstants InvalidParameterStsExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.sts.client.chipkarte.at")
public class InvalidParameterStsException extends Exception {

  private InvalidParameterStsExceptionContent _faultInfo;
  
  public InvalidParameterStsExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterStsExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
