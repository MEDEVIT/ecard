/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.base.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, die im Zusammenhang mit fehlenden Benutzerrechten steht. Fehlercodes siehe
 * {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants AccessExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.base.client.chipkarte.at")
public class AccessException extends Exception {

  private AccessExceptionContent _faultInfo;
  
  public AccessExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(AccessExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
  
}
