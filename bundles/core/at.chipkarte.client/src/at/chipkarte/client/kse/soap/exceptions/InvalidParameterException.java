/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn ein ungültiger Parameter in einer Funktion angegeben wird. Fehlercodes siehe
 * {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants InvalidParameterExceptionConstants}.
 */
@WebFault(targetNamespace="http://exceptions.soap.kse.client.chipkarte.at")
public class InvalidParameterException extends Exception {
  
  private InvalidParameterExceptionContent _faultInfo;
  
  /**
   * Liefert Informationen zum Fehler zurück
   * @return FaultInfo - Fehlerinformation
   */
  public InvalidParameterExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
