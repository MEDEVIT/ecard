/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.abs.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn im Zuge der Verarbeitung von ABS-Anfragen Fehler auftreten.
 */
@WebFault(targetNamespace="http://exceptions.soap.abs.client.chipkarte.at")
public class AbsException extends Exception {

  private AbsExceptionContent _faultInfo;
  
  public AbsExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(AbsExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
  
}
