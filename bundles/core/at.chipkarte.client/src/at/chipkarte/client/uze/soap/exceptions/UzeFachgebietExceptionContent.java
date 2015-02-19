/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap.exceptions;

import javax.xml.ws.WebFault;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;

/**
 * Es ist ein fachlicher Fehler in UZE aufgetreten. Fehlercodes siehe
 * {@link at.chipkarte.client.uze.soap.constants.UzeFachgebietExceptionConstants UzeFachgebietExceptionConstants}.
 */
public class UzeFachgebietExceptionContent extends BaseExceptionContent {
  
  private BaseProperty[] _fachgebiete;
  
  /**
   * Zul&auml;ssige Fachgebiete.
   * 
   * @return BaseProperty[] liefert die f&uuml;r die Einl&ouml;sung zul&auml;ssigen Fachgebiete.
   */
  public BaseProperty[] getFachgebiete() {
    return _fachgebiete;
  }

  /**
   * Zul&auml;ssige Fachgebiete.
   * @param fachgebiete setzt die f&uuml;r die Einl&ouml;sung zul&auml;ssigen Fachgebiete.
   */
  public void setFachgebiete(BaseProperty[] fachgebiete) {
    _fachgebiete = fachgebiete;
  }
}
