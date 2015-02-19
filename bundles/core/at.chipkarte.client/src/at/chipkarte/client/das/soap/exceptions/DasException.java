package at.chipkarte.client.das.soap.exceptions;

import javax.xml.ws.WebFault;



/**
 * Es ist ein fachlicher Fehler in DAS aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.das.soap.constants.DasExceptionConstants DasExceptionConstants}.
 */
@WebFault(targetNamespace="http://exceptions.soap.das.client.chipkarte.at")
public class DasException extends Exception {
  
    private DasExceptionContent _faultInfo;
    
    public DasExceptionContent getFaultInfo() {
      return _faultInfo;
    }

    public void setFaultInfo(DasExceptionContent faultInfo) {
      _faultInfo = faultInfo;
    }
}
