/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.tsv.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception der Funktionen des Schulungssystems. Fehlercodes siehe
 * {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants SchulungExceptionConstants}.
 */
@WebFault(targetNamespace="http://exceptions.soap.tsv.client.chipkarte.at")
public class SchulungException extends Exception {

  private SchulungExceptionContent _faultInfo;
  
  public SchulungExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(SchulungExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }
}
