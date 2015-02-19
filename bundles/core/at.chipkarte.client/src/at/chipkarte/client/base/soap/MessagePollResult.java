/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.base.soap;


/**
 * Enthält die Daten zu den über den Poll-Mechanismus abgefragten Nachrichten.
 */
public class MessagePollResult {

  /**
   * Zeitstempel in Millisekunden, ab dem die Nachrichten gelesen werden. Dieser Suchzeitpunkt muss beim nächsten Polling-Aufruf
   * angegeben werden, um die Vollständigkeit zu garantieren. 
   * <br>Format: JJJJMMTTHHmmssccc
   */
  private String _naechsterSuchzeitpunkt;

  /**
   * Kennzeichen ob weitere Nachrichten verfügbar sind. Diese müssen mit einem weiteren Aufruf abgeholt werden.
   */
  private Boolean _nachrichtenVerfuegbar;

  /**
   * Nachrichten. Enthält den Inhalt der einzelnen Nachrichten.
   */
  private Message[] _nachrichten;

  /**
   * Enthält die vorhandenen Nachrichten zur Abfrage.
   * @return Nachrichten
   */
  public Message[] getNachrichten() {
    return _nachrichten;
  }

  
  public void setNachrichten(Message[] nachrichten) {
    _nachrichten = nachrichten;
  }

  /**
   * Gibt an, ob Nachrichten verfügbar sind.
   * @return Kennzeichen - <i>true</i>, wenn Nachrichten verfügbar sind
   */
  public Boolean isNachrichtenVerfuegbar() {
    return _nachrichtenVerfuegbar;
  }

  
  public void setNachrichtenVerfuegbar(Boolean nachrichtenVerfuegbar) {
    _nachrichtenVerfuegbar = nachrichtenVerfuegbar;
  }

  /**
   * Gibt den nächsten Suchzeitpunkt an.
   * @return der nächste Suchzeitpunkt
   */
  public String getNaechsterSuchzeitpunkt() {
    return _naechsterSuchzeitpunkt;
  }

  
  public void setNaechsterSuchzeitpunkt(String naechsterSuchzeitpunkt) {
    _naechsterSuchzeitpunkt = naechsterSuchzeitpunkt;
  }
}
