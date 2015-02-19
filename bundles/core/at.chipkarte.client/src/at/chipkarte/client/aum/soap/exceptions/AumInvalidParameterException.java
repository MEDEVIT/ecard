/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap.exceptions;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace = "http://exceptions.soap.aum.client.chipkarte.at")
public class AumInvalidParameterException extends Exception {
  private AumInvalidParameterExceptionContent _faultInfo;

  public AumInvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(AumInvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
