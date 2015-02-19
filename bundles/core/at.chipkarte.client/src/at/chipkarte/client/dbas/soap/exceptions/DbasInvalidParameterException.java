package at.chipkarte.client.dbas.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception, wenn bei der Validierung ein Fehler in DBAS aufgetreten ist.
 */
@WebFault(targetNamespace="http://exceptions.soap.dbas.client.chipkarte.at")
public class DbasInvalidParameterException extends Exception {
  
  private DbasInvalidParameterExceptionContent _faultInfo;
  
  public DbasInvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(DbasInvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

  /**
   * Gibt an, ob <code>fieldCode</code> einen g&uuml;ltigen Wert enth&auml;lt.
   * @return <code>true</code> falls <code>fieldCode</code> g&uuml;ltig ist; 
   * andernfalls <code>false</code>.
   */
  public Boolean isFieldCodeSet() {
    return _faultInfo == null ? false : _faultInfo.getFieldCode() != DbasInvalidParameterExceptionContent.INVALID_FIELD_CODE;
  }
}
