/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für den Event-Typ von Kartenleser-Events.
 */
public class ReaderEventTyp {

  /**
   * Übermittlung der Gesamtliste, da keine Deltalistenberechnung möglich (1ter Aufruf) oder
   * gewünscht (handle nicht übergeben).
   */
  public static final String INITIAL_EVENT = "INITIAL_EVENT";

  /**
   * Ein neuer Kartenleser wurde im System erkannt.
   */
  public static final String ADD_EVENT = "ADD_EVENT";

  /**
   * Ein Kartenleser wurde vom System entfernt.
   */
  public static final String REMOVE_EVENT = "REMOVE_EVENT";

  /**
   * Der Status eines Kartenlesers hat sich verändert.
   */
  public static final String READER_STATUS_CHANGE_EVENT = "READER_STATUS_CHANGE_EVENT";

  /**
   * Es wurde erkannt, dass seit dem letzten Aufruf ein Neustart der Gina oder ein Failover auf eine andere Gina stattgefunden hat.
   * Es können zu diesem Zeitpunkt keine Änderungen des Kartenleserstatus zurückgegeben werden. In diesem Fall findet für die
   * Kartenleser die Übermittlung der aktuelle Kartenleserstatus statt. <br>
   * Kann nur auftreten wenn der handle als Eingangsparamter übergeben wurde.
   */
  public static final String SERVER_RESTART_EVENT = "SERVER_RESTART_EVENT";

}
