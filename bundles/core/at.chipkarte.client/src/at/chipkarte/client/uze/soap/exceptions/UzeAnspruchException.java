/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.uze.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Es ist ein fachlicher Fehler in UZE in Zusammenhang mir einer Anspruchpr&uuml;fung aufgetreten.
 * Fehlercodes siehe {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants UzeAnspruchExceptionConstants}.
 */
@WebFault(targetNamespace = "http://exceptions.soap.uze.client.chipkarte.at")
public class UzeAnspruchException extends Exception {
  
  private UzeAnspruchExceptionContent _faultInfo;
  
  public UzeAnspruchExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(UzeAnspruchExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
