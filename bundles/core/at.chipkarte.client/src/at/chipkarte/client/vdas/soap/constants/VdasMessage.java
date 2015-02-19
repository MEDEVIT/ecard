/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap.constants;



/**
 * Zusatzinformationen im Falle einer am e-card-Serversystem erfolgreich durchgeführten Versichertendatenabfrage.
 */
public final class VdasMessage {

  /**
   * KVT wurde übersteuert.
   */
  public static final int SVT_UEBERSTEUERT = 1;

  /**
   * Einer der abgeleiteten Ansprüche muss ausgewählt werden.
   */
  public static final int PATIENT_ABGL_KVANSPRUECHE = 2;

  /**
   * Einer der GKK/BKK-Ansprüche muss ausgewählt werden.
   */
  public static final int ANSPRUCH_AUSWAEHLEN = 3;

  /**
   * Einer der Ansprüche muss ausgewählt werden.
   */
  public static final int ASVG_ODER_SONDERANSPRUCH_AUSWAEHLEN = 4;

  /**
   * Der gewählte abgeleitete KV-Anspruch ist nicht (mehr) gültig.
   */
  public static final int ABGELEITETER_ANSPRUCH_UNGUELTIG = 5;

  /**
   * Der Patient hat keinen gültigen KV-Anspruch.
   */
  public static final int KEIN_ANSPRUCH = 6;
  
  /**
   * Der Patient hat keinen gültigen KV-Anspruch zum gewählten KVT, aber zu einem anderen.
   */
  public static final int KEIN_ANSPRUCH_SVT = 7;

  /**
   * Es liegt eine Mehrfachversicherung vor - KVT muss erfasst werden.
   */
  public static final int MEHRFACHVERSICHERUNG = 8;

  /**
   * Zum angegebenen Datum kann kein gültiger KV-Anspruch ermittelt werden.
   */
  public static final int KEIN_ANSPRUCH_ZU_DIESEM_DATUM = 9;

  /**
   * Der Patient ist (zum Abfragedatum) bereits als verstorben gemeldet.
   */
  public static final int PERSON_VERSTORBEN = 10;

  private VdasMessage() {
  }

}
