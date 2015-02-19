/*
 * (C) SVC 2012
 */
package at.chipkarte.client.abs.soap.exceptions;

import at.chipkarte.client.abs.soap.PatientenDaten;
import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;

/**
 * Exception-Inhalt.
 */
public class AbsExceptionContent extends BaseExceptionContent {
  private PatientenDaten _patientenDaten = null;
  private String[] _kvtCodes = null;


  /**
   * Wenn zum Zeitpunkt des Fehlerereignisses der Patient bereits vom e-card Serversystem ermittelt werden konnte, werden dessen
   * Daten retourniert.
   * @return Array von <code>PatientenDaten</code> Objekten
   */
  public PatientenDaten getPatientenDaten() {
    return _patientenDaten;
  }

  /**
   * Wenn die ABS-Exception aufgrund einer fehlenden beziehungsweise 
   * fehlerhaften Eingabe des KVT in der Bewilligungsanfrage erfolgte und der
   * betreffende Patient Ansprüche bei mehreren GKKs besitzt, werden diese hier retourniert.
   * @return Array von KVT-Codes, siehe auch {@link at.chipkarte.client.base.soap.SvtProperty#isASVG() GKK/BKK(ASVG)-Kennzeichen}.
   */
  public String[] getKVTCodes() {
    return _kvtCodes;
  }

  public void setPatientenDaten(PatientenDaten person) {
    _patientenDaten = person;
  }

  public void setKVTCodes(String[] ts) {
    _kvtCodes = ts;
  }

}
