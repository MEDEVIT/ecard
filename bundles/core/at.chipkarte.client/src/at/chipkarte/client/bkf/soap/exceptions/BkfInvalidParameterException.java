package at.chipkarte.client.bkf.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn bei der Validierung ein Fehler in BKF aufgetreten ist.
 */
@WebFault(targetNamespace = "http://exceptions.soap.bkf.client.chipkarte.at")
public class BkfInvalidParameterException extends Exception {

  private BkfInvalidParameterExceptionContent _faultInfo;
  
  public BkfInvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(BkfInvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
