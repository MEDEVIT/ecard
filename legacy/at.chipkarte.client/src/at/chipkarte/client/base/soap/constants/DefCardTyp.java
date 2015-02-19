/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für den Kartentyp bei Kartenleserstatus-Events.
 */
public class DefCardTyp {

  /**
   * Bürgerkarte.
   */
  public static final String BCARD_TEXT = "b-card (Bürgerkarte)";
  /**
   * e-card.
   */
  public static final String ECARD_TEXT = "e-card";
  /**
   * Ordinationskarte.
   */
  public static final String OCARD_TEXT = "o-card (Ordinationskarte)";
  /**
   * Schulungs-e-card.
   */
  public static final String ECARD_SCHULUNG_TEXT = "schulungs-e-card (e-card für die Schulung)";
  /**
   * Unbekannte Karte.
   */
  public static final String UNKNOWN_CARD_TEXT = "unbekannte Karte";
  /**
   * Keine Karte.
   */
  public static final String EMPTY_CARD_TEXT = "";

}
