/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;


/**
 * Konstanten für KSE spezifische zusätzliche Meldungen im Falle einer positiv durchgeführten Konsultation.
 */
public final class KseMessage {
  
  /**
   * Bei der Konsultation handelt es sich um eine Erstkonsultation.
   */
  public static final int ERST_KONSULTATION = 1;

  /**
   * Der im Funktionsaufruf nicht oder falsch angegebene Krankenversicherungsträger wurde vom e-card Serversystem automatisch
   * übersteuert.
   */
  public static final int SVT_UEBERSTEUERT = 2;
  
  /**
   * Zu diesem Patienten existieren zusätzliche Informationen!  
   */
  public static final int PATIENT_ZUSATZINFO = 4;
  
  /**
   * Für diesen Patienten existiert aktuell kein gültiger Anspruch. Die Konsultation wurde trotzdem erfolgreich gespeichert!
   * <br/>Hinweis: Die Erfassung einer VM-Konsultation im Rahmen des Brustkrensfrüherkennungsprogrammes ist auch für Personen ohne Anspruch möglich 
   * (sofern eine aktuell gültige, noch nicht eingelöste oder reservierte Einladung vorhanden ist).  
   */
  public static final int OHNE_ANSPRUCH = 5;
  
  private KseMessage() {
  }

}
