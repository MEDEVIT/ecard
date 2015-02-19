/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Es ist ein fachlicher Fehler in DMP aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.dmp.soap.constants.DmpExceptionConstants DmpExceptionConstants}.
 */
@WebFault(targetNamespace = "http://exceptions.soap.dmp.client.chipkarte.at")
public class DmpException extends Exception {

  private DmpExceptionContent _faultInfo;
  
  public DmpExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(DmpExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
