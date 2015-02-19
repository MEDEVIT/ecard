package at.chipkarte.client.das.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception, wenn ein ungültiger Parameter in einer Funktion angegeben wird.
 * Fehlercodes siehe
 * {@link at.chipkarte.client.das.soap.constants.DasInvalidParameterExceptionConstants DasInvalidParameterExceptionConstants}
 */
@WebFault(targetNamespace="http://exceptions.soap.das.client.chipkarte.at")
public class DasInvalidParameterException extends Exception {
  
      private DasInvalidParameterExceptionContent _faultInfo;
      
      public DasInvalidParameterExceptionContent getFaultInfo() {
        return _faultInfo;
      }

      public void setFaultInfo(DasInvalidParameterExceptionContent faultInfo) {
        _faultInfo = faultInfo;
      }
}
