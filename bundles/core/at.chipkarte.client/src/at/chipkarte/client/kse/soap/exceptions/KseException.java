/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exceptions, die im Zusammenhang mit Konsultationen vom e-card Serversystem geworfen werden. Fehlercodes siehe
 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants KseExceptionConstants}.
 */
@WebFault(targetNamespace="http://exceptions.soap.kse.client.chipkarte.at")
public class KseException extends Exception {

  private KseExceptionContent _faultInfo;
  
  public KseExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(KseExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
