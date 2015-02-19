/*
 * (C) SVC 2005
 */
package at.chipkarte.client.sas.soap.exceptions;

import javax.xml.ws.WebFault;

import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;


/**
 * Die Suchkriterien wurden nicht korrekt übergeben. Fehlercodes siehe
 * {@link at.chipkarte.client.sas.soap.constants.InvalidParameterSuchkriterienExceptionConstants
 * InvalidParameterSuchkriterienExceptionConstants}.
 */
@WebFault(targetNamespace="http://exceptions.soap.sas.client.chipkarte.at")
public class InvalidParameterSuchkriterienException extends Exception {

  private InvalidParameterSuchkriterienExceptionContent _faultInfo;
  
  public InvalidParameterSuchkriterienExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterSuchkriterienExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
