package at.chipkarte.client.prop.soap.exceptions;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace="http://exceptions.soap.prop.client.chipkarte.at")
public class PropException extends Exception {

  private PropExceptionContent _faultInfo;
  
  public PropExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(PropExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
