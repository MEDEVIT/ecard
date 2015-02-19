/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.exceptions;

import javax.xml.ws.WebFault;


/**
 * Exception, wenn Parameter für die Funktion
 * {@link IAbsService#getStatusBewilligungsAnfragen(String, at.chipkarte.client.abs.soap.FilterKriterien) IAbsService.getStatusBewilligungsAnfragen()}
 * fehlerhaft versorgt werden.
 */
@WebFault(targetNamespace="http://exceptions.soap.abs.client.chipkarte.at")
public class InvalidParameterGetAnfrageStatusException extends Exception {

  private InvalidParameterGetAnfrageStatusExceptionContent _faultInfo;
  
  public InvalidParameterGetAnfrageStatusExceptionContent getFaultInfo() {
    return _faultInfo;
  }

  public void setFaultInfo(InvalidParameterGetAnfrageStatusExceptionContent faultInfo) {
    _faultInfo = faultInfo;
  }

}
