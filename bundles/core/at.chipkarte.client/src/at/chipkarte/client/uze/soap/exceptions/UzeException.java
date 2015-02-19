/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.uze.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Es ist ein fachlicher Fehler in UZE aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants UzeExceptionConstants}.
 */
@WebFault(targetNamespace = "http://exceptions.soap.uze.client.chipkarte.at")
public class UzeException extends Exception {

  private UzeExceptionContent _faultInfo;
  
  public UzeExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(UzeExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
