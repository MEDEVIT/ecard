package at.chipkarte.client.bkf.soap.exceptions;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace = "http://exceptions.soap.bkf.client.chipkarte.at")
public class BkfEncryptionException extends Exception {
  private BkfEncryptionExceptionContent _faultInfo;
  
  public BkfEncryptionExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(BkfEncryptionExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
