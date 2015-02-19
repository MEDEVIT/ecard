/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Es ist ein fachlicher Fehler in UZE aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.uze.soap.constants.UzeFachgebietExceptionConstants UzeFachgebietExceptionConstants}.
 */
@WebFault(targetNamespace = "http://exceptions.soap.uze.client.chipkarte.at")
public class UzeFachgebietException extends Exception {
  
  private UzeFachgebietExceptionContent _faultInfo;
  
  public UzeFachgebietExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(UzeFachgebietExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
