/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap.exceptions;

import javax.xml.ws.WebFault;

import at.chipkarte.client.aum.soap.exceptions.AumExceptionContent;


@WebFault(targetNamespace="http://exceptions.soap.aum.client.chipkarte.at")
public class AumException extends Exception {
  
  private AumExceptionContent _faultInfo;
  
  public AumExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(AumExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
