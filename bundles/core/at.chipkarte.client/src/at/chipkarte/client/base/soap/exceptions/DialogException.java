/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception, wenn ein Fehler in Zusammenhang mit einem Dialog auftritt. Fehlercodes siehe
 * {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants DialogExceptionConstants}
 */
@WebFault(targetNamespace = "http://exceptions.soap.base.client.chipkarte.at")
public class DialogException extends Exception {

  private DialogExceptionContent _faultInfo;
  
  public DialogExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(DialogExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
  
}
