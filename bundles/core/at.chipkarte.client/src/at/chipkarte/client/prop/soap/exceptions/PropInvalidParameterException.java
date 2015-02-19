package at.chipkarte.client.prop.soap.exceptions;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace="http://exceptions.soap.prop.client.chipkarte.at")
public class PropInvalidParameterException extends Exception {
  private PropInvalidParameterExceptionContent _faultInfo;
  
  public PropInvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(PropInvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
