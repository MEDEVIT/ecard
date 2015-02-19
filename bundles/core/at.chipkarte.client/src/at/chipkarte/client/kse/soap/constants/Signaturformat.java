/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;


/**
 * Konstanten für das Signaturformat.
 */
public final class Signaturformat {
  
  /**
   * Signatur gemäß CMS (Cryptographic Message Syntax).
   */
  public static final String CMS = "C";

  /**
   * Signatur gemäß XMLDSig (Digitale Signatur bei XML-Dokumenten).
   */
  public static final String XMLDSIG = "X";

  private Signaturformat() {
  }

}
