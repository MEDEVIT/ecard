package at.chipkarte.client.dbas.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception, wenn clientseitig ein fachlicher Fehler in DBAS (Fehler beim Key-Handling) aufgetreten ist.
 */
@WebFault(targetNamespace="http://exceptions.soap.dbas.client.chipkarte.at")
public class DbasEncryptionException extends Exception {
  private DbasEncryptionExceptionContent _faultInfo;
  
  public DbasEncryptionExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(DbasEncryptionExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
