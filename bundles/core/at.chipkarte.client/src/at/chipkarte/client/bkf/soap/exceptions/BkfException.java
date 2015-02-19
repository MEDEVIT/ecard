package at.chipkarte.client.bkf.soap.exceptions;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace = "http://exceptions.soap.bkf.client.chipkarte.at")
public class BkfException extends Exception {
  private BkfExceptionContent _faultInfo;
  
  public BkfExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(BkfExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
