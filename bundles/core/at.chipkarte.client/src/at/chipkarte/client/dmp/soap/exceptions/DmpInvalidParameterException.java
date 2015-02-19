/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception, wenn ein ungültiger Parameter in einer Funktion angegeben wird. Fehlercodes siehe
 * {@link at.chipkarte.client.dmp.soap.constants.DmpInvalidParameterExceptionConstants InvalidParameterDmpExceptionConstants}.
 */
@WebFault(targetNamespace = "http://exceptions.soap.dmp.client.chipkarte.at")
public class DmpInvalidParameterException extends Exception {

  private DmpInvalidParameterExceptionContent _faultInfo;
  
  public DmpInvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(DmpInvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
