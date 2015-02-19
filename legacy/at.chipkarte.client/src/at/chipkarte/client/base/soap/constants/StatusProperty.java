/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Key Werte einer Property für Status Werte und Informationen des Ordinations-Client.  
 */
public class StatusProperty {

  /**
   * Key für den Verbindungsstatus des Ordinations-Client (des Services). <br>
   * Value: "ONLINE" bzw. "OFFLINE", siehe auch die entsprechenden gültigen Werte dazu {@link Modus Modus}.
   */
  public static final String SERVICE_STATE = "SERVICESTATE";

  /**
   * Key für den Benachrichtigungsstatus des e-card Systems. Dieser key gibt an ob eine neue Nachricht im Messaging System vorhanden
   * ist. Value: "NEW", eine neue Nachricht liegt vor und kann über die Funktion
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getMessages getMessages} abgeholt werden.
   */
  public static final String MESSAGE_FLAG = "MESSAGE_FLAG";

}
