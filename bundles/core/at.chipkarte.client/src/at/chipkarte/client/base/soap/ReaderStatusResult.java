/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.base.soap;



/**
 * Enthält den aktuellen <i>Handle</i> der Kartenleserstatus-Event-Ermittlung, sowie die aufgetretenen 
 * Kartenleserstatus-Events.
 */
public class ReaderStatusResult {

  private String              _handle;
  private ReaderStatusEvent[] _readerStatusEvents;

  /**
   * Identifikationskennzeichen für die Ermittlung der Kartenleser-Events.
   * @return handle.
   */
  public String getHandle() {
    return _handle;
  }

  public void setHandle(String handle) {
    this._handle = handle;
  }

  
  /**
   * Auftretender Event eines Kartenlesers, siehe auch {@link ReaderStatusEvent ReaderStatusEvent}.
   * @return readerStatusEvents.
   */
  public ReaderStatusEvent[] getReaderStatusEvents() {
    return _readerStatusEvents;
  }

  public void setReaderStatusEvents(ReaderStatusEvent[] readerStatusEvents) {
    _readerStatusEvents = readerStatusEvents;
  }

}
