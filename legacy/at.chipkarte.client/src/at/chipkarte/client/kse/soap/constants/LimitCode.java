/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für die möglichen Limittypen.
 */

public final class LimitCode extends Enum {

  /**
   * Ohne e-card Limit.
   */
  public static final String LIMIT_TYP_OH = "OH";
  /** @exclude */
  public static LimitCode LIMIT_TYP_OH_ = new LimitCode(LIMIT_TYP_OH);

  /**
   * Offline Limit.
   */
  public static final String LIMIT_TYP_OF = "OF";
  /** @exclude */
  public static LimitCode LIMIT_TYP_OF_ = new LimitCode(LIMIT_TYP_OF);

  /** @exclude */
  public static LimitCode getEnum(String enumString) {
    return (LimitCode) getEnum(LimitCode.class, enumString);
  }

  private LimitCode(String limitCode) {
    super(limitCode);
  }
}
