/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für KSE spezifische zusätzliche Meldungen im Falle einer positiv durchgeführten Konsultation.
 */
public final class KseMessage extends Enum {

  /**
   * Bei der Konsultation handelt es sich um eine Erstkonsultation.
   */
  public static final int ERST_KONSULTATION = 1;
  /** @exclude */
  public static KseMessage ERST_KONSULTATION_ = new KseMessage(ERST_KONSULTATION);

  /**
   * Der im Funktionsaufruf nicht oder falsch angegebene Sozialversicherungsträger wurde vom e-card Serversystem automatisch
   * übersteuert.
   */
  public static final int SVT_UEBERSTEUERT = 2;
  /** @exclude */
  public static KseMessage SVT_UEBERSTEUERT_ = new KseMessage(SVT_UEBERSTEUERT);
  
  /**
   * Zu dieser Person existieren zusätzliche Informationen!  
   */
  public static final int PATIENT_ZUSATZINFO = 4;
  /** @exclude */
  public static KseMessage PATIENT_ZUSATZINFO_ = new KseMessage(PATIENT_ZUSATZINFO);
  
  protected KseMessage(String kseMessage) {
    super(kseMessage);
  }

  private KseMessage(int att) {
    super(String.valueOf(att));
  }

  /** @exclude */
  public static KseMessage getEnum(String enumString) {
    return (KseMessage) getEnum(KseMessage.class, enumString);
  }

  /** @exclude */
  public static KseMessage getEnum(int enumInt) {
    return (KseMessage) getEnum(KseMessage.class, String.valueOf(enumInt));
  }

}
