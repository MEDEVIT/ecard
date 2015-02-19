/*
 * (C) SVC 2005
 */
package at.chipkarte.client.sas.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Es ist ein fachlicher Fehler in SAS aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.sas.soap.constants.SasExceptionConstants SasExceptionConstants}.
 */
@WebFault(targetNamespace="http://exceptions.soap.sas.client.chipkarte.at")
public class SasException extends Exception {
  private SasExceptionContent _faultInfo;
  
  public SasExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(SasExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
