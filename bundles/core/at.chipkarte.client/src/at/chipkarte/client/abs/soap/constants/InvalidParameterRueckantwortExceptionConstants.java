/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap.constants;

/**
 * Fehlerkonstanten für falsche Parameterübergaben bei der Abfrage der Rückantwort.
 */
public final class InvalidParameterRueckantwortExceptionConstants {

  private InvalidParameterRueckantwortExceptionConstants() {
    // do not use
  }

  /**
   * Die Anfrage-ID ist ein Pflichtfeld. 
   * <br/>ORCLI-Code: CL-A0033
   */
  public static final int ANFRAGE_ID_NOT_SET = 1;

  /**
   * Die Anfrage-ID entspricht keinem numerischen Wert. 
   * <br/>ORCLI-Code: CL-A0034
   */
  public static final int ANFRAGE_ID_NOT_NUMERIC = 2;

  /**
   * Die angegebene Anfrage-ID ist ungültig. 
   * <br/>ORCLI-Code: CL-A0037
   */
  public static final int INVALID_ANFRAGE_ID = 3;

}
