/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.base.soap;

/**
 * Aufgetretener Event für einen bestimmten Kartenleser.
 */
public class ReaderStatusEvent {

  private String _eventType;

  private String _cardReaderId;

  private String _cardReaderState;

  private String _cardType;

  private String _timeStamp;

  public ReaderStatusEvent() {
  }
  
  /**
   * Erzeugung einer Instanz mit allen angegebenen Werten. 
   * @param eventType Event-Typ
   * @param cardReaderId Kartenleseridentifikation
   * @param cardReaderState Kartenleserstatus
   * @param cardType Kartentyp
   * @param timeStamp Zeitpunkt des Events
   */
  public ReaderStatusEvent(String eventType, String cardReaderId, String cardReaderState, String cardType, String timeStamp) {
    _eventType = eventType;
    _cardReaderId = cardReaderId;
    _cardReaderState = cardReaderState;
    _cardType = cardType;
    _timeStamp = timeStamp;
  }

  /**
   * Kartenleseridentifikation des betroffenen Kartenlesers.
   * @return cardReaderId.
   */
  public String getCardReaderId() {
    return _cardReaderId;
  }

  /**
   * Status des Kartenlesers.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.ReaderStatus ReaderStatus}.
   * @return cardReaderState.
   */
  public String getCardReaderState() {
    return _cardReaderState;
  }

  /**
   * Kartentyp.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.DefCardTyp DefCardTyp}.
   * @return cardType.
   */
  public String getCardType() {
    return _cardType;
  }

  /**
   * Event-Typ, gibt an welches Event an dem Kartenleser aufgetreten ist. 
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.ReaderEventTyp ReaderEventTyp}.
   * @return eventType.
   */
  public String getEventType() {
    return _eventType;
  }

  /**
   * Zeitpunkt des Events.
   * <br>Format: YYMMDDHHmmsscccc
   * @return timeStamp.
   */
  public String getTimeStamp() {
    return _timeStamp;
  }

  public void setCardReaderId(String readerId) {
    _cardReaderId = readerId;
  }

  public void setCardReaderState(String readerState) {
    _cardReaderState = readerState;
  }

  public void setCardType(String type) {
    _cardType = type;
  }

  public void setEventType(String eventType) {
    _eventType = eventType;
  }

  public void setTimeStamp(String timeStamp) {
    _timeStamp = timeStamp;
  }

}
