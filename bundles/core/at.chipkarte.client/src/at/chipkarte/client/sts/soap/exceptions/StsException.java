/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * 
 * Es ist ein fachlicher Fehler in STS aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants StsExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.sts.client.chipkarte.at")
public class StsException extends Exception {

  private StsExceptionContent _faultInfo;
  
  public StsExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(StsExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
