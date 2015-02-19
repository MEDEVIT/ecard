/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für das Signaturformat.
 */
public final class Signaturformat extends Enum {

  /**
   * Signatur gemäß CMS (Cryptographic Message Syntax).
   */
  public static final String CMS = "C";
  /** @exclude */
  public static Signaturformat CMS_ = new Signaturformat(CMS);

  /**
   * Signatur gemäß XMLDSig (Digitale Signatur bei XML-Dokumenten).
   */
  public static final String XMLDSIG = "X";
  /** @exclude */
  public static Signaturformat XMLDSIG_ = new Signaturformat(XMLDSIG);

  private Signaturformat(String signaturformat) {
    super(signaturformat);
  }

  /** @exclude */
  public static Signaturformat getEnum(int enumInt) {
    return (Signaturformat) getEnum(Signaturformat.class, String.valueOf(enumInt));
  }

}
