package at.chipkarte.client.dbas.soap.exceptions;

import javax.xml.ws.WebFault;



/**
 * Exception, wenn serverseitig ein fachlicher Fehler in DBAS aufgetreten ist.
 */
@WebFault(targetNamespace="http://exceptions.soap.dbas.client.chipkarte.at")
public class DbasException extends Exception {
  private DbasExceptionContent _faultInfo;
  
  public DbasExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(DbasExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
