/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.constants;

/**
 * Fehlerkonstanten für die AbsException.
 */
public final class AbsExceptionConstants {

  private AbsExceptionConstants() {
    // do not use
  }

  /**
   * Der Vertragspartner hat für keinen KV-Träger des Patienten einen Vertrag mit Rezepturrecht. <br>
   * Code: ZS-04009
   */
  public static final int NO_PRESCRIPTION_RIGHT = 8;

  /**
   * Die angegebene Anfrage-ID ist für diesen Vertragspartner ungültig. <br>
   * Code: ZS-04001
   */
  public static final int INVALID_ANFRAGE_ID = 9;
  /**
   * Die Patientendaten der Bewilligungsanfrage sind nicht konsistent. <br>
   * Code: ZS-04002
   */
  public static final int PATIENTENDATEN_NOT_CONSISTENT = 10;

  /**
   * Der Patient hat keinen gültigen Krankenversicherungsanspruch. <br>
   * Code: ZS-04007
   */
  public static final int NO_KVA_ANSPRUCH = 11;

  /**
   * Der Patient ist mehrfachversichert, ein KVT muss angegeben werden. <br>
   * Code: ZS-04010
   */
  public static final int NO_KVT_PROVIDED = 12;

  /**
   * Der Patient hat bei dem angegebenen KVT keinen gültigen Anspruch. <br>
   * Code: ZS-04008
   */
  public static final int NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION = 14;

  /**
   * Die Karte des Patienten ist gesperrt. <br>
   * Code: CL-00053 (ZS-00044)
   */
  public static final int CARD_LOCKED = 15;

  /**
   * Für dieses Medikament wurde keine gültige Langzeitbewilligung gefunden. <br>
   * Code: ZS-04011
   */
  public static final int NO_LZB_FOUND = 16;

  /**
   * Das System zur Abfrage der Langzeitbewilligung steht derzeit nicht zur Verfügung. <br>
   * Code: ZS-04013
   */
  public static final int UNAVAILABLE_BE = 18;

  /**
   * Die Abgabemenge wurde überschritten. <br>
   * Code: ZS-04014
   */
  public static final int LZB_CONFIRMATIONAMOUNT_EXCEEDED = 19;

  /**
   * Die nächste Folgeverordnung kann erst am {0} ausgestellt werden. <br>
   * Code: ZS-04015
   */
  public static final int LZB_RETENTION_PERIOD = 20;

  /**
   * Ihre Folgeverordnung wurde bereits im System registriert. <br>
   * Code: ZS-04016
   */
  public static final int REPEATED_LZB_CONFIRMATION = 21;

  /**
   * Abfrage erfolgte ohne e-card und im festgelegten Intervall wurde keine Konsultation für den Patienten gefunden. <br>
   * Code: ZS-04017
   */
  public static final int NO_PHYSICIAN_PATIENT_RELATIONSHIP = 22;

  /**
   * Der Verordner hat nicht das Recht zur Erstellung eines Arztbriefes. <br>
   * Code: ZS-04018
   */
  public static final int NO_DISCHARGE_LETTER_RIGHT = 23;

}
