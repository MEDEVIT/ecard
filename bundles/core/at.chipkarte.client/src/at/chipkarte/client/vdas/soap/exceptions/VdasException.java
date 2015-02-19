/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Es ist ein fachlicher Fehler in VDAS aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants VdasExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.vdas.client.chipkarte.at")
public class VdasException extends Exception {

  private VdasExceptionContent _faultInfo;
  
  public VdasExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(VdasExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
