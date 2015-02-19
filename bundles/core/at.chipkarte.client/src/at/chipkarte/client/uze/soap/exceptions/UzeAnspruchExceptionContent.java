/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.uze.soap.exceptions;

import javax.xml.ws.WebFault;

import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;
import at.chipkarte.client.uze.soap.Anspruch;

/**
 * Es ist ein fachlicher Fehler in UZE in Zusammenhang mir einer Anspruchpr&uuml;fung aufgetreten.
 * Fehlercodes siehe {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants UzeAnspruchExceptionConstants}.
 */
public class UzeAnspruchExceptionContent extends BaseExceptionContent {
  
  private Anspruch[] _anspruch = null;
  
  /**
   * M&ouml;gliche Anspr&uuml;che.
   * 
   * @return Anspruch[] liefert die zul&auml;ssigen eigenen Anspr&uuml;che einer SV-Person im Falle der Mehrfachversicherung 
   * (nur GKKs) oder die abgeleiteten Anspr&uuml;che einer SV-Person, sonst null.
   */
  public Anspruch[] getAnspruch() {
    return _anspruch;
  }

  /**
   * M&ouml;gliche Anspr&uuml;che.
   * @param anspruch setzt die zul&auml;ssigen eigenen Anspr&uuml;che einer SV-Person im Falle der Mehrfachversicherung (nur GKKs)
   * oder die abgeleiteten Anspr&uuml;che einer SV-Person
   */
  public void setAnspruch(Anspruch[] anspruch) {
    this._anspruch = anspruch;
  }
}
