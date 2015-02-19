/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.base.soap;

/**
 * Liefert Informationen über die Anzahl der am Ordinationsclient zurzeit aufgebauten Dialoge beziehungsweise 
 * über die maximale Anzahl der aufbaubaren Dialoge.
 */
public class DialogsInfo {

  private Integer _maxDialogsCount = 0;
  private Integer _currentDialogsCount = 0;

  /**
   * Anzahl der zurzeit aufgebauten Dialoge.
   * @return Anzahl aufgebaute Dialoge.
   */
  public Integer getCurrentDialogsCount() {
    return _currentDialogsCount;
  }

  public void setCurrentDialogsCount(Integer currentDialogsCount) {
    _currentDialogsCount = currentDialogsCount;
  }

  /**
   * Maximale Anzahl der Dialoge, die gleichzeitig am Ordinationsclient aufgebaut sein können.
   * @return Anzahl mögliche Dialoge
   */
  public Integer getMaxDialogsCount() {
    return _maxDialogsCount;
  }

  public void setMaxDialogsCount(Integer maxDialogsCount) {
    _maxDialogsCount = maxDialogsCount;
  }
}
