/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Key-Werte einer Property zu Status-Werte und Informationen des Ordinationsclient.  
 */
public final class StatusProperty {

  private StatusProperty() {
    // nothing to do
  }
  
  /**
   * Key für den Verbindungsstatus des Ordinationsclient (des Service). 
   * <br>Value: "ONLINE" bzw. "OFFLINE", siehe auch die entsprechenden Werte in {@link Modus Modus}.
   */
  public static final String SERVICE_STATE = "SERVICESTATE";

  /**
   * Key für den Benachrichtigungsstatus des e-card-Systems. Dieser Key gibt an, 
   * ob eine neue Nachricht im Messaging-System vorhanden ist. 
   * <br>Value: "NEW", eine neue Nachricht liegt vor und kann über die Funktion
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getMessages getMessages} abgeholt werden.
   */
  public static final String MESSAGE_FLAG = "MESSAGE_FLAG";

}
