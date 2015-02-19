/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.uze.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn ein ung&uuml;ltiger Parameter in einer Funktion angegeben wird.
 * Fehlercodes siehe
 * {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants InvalidParameterUzeExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.uze.client.chipkarte.at")
public class UzeInvalidParameterException extends Exception {

  private UzeInvalidParameterExceptionContent _faultInfo;
  
  public UzeInvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(UzeInvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
