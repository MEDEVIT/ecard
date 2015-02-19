/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

import org.apache.commons.lang.enums.Enum;

/** @exclude */
public class BaseEnum extends Enum {

  /** @exclude */
  public BaseEnum(String c) {
    super(c);
  }

  /** @exclude */
  public BaseEnum(int c) {
    super(String.valueOf(c));
  }

  /** @exclude */
  public static BaseEnum getEnum(String enumString) {
    return (BaseEnum) getEnum(BaseEnum.class, enumString);
  }

}
