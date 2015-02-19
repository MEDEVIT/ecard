/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.sas.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Gibt an ob das Todesdatum bestätigt ist (true) oder nicht (false). Wenn der Patient im eCS nicht als verstorben geführt wird,
 * bleibt dieses Feld leer (nicht null).
 */
public final class TodesdatumBestaetigtKZ extends Enum {

  /**
   * Ja.
   */
  public static final String JA = "1";
  /** @exclude */
  public static TodesdatumBestaetigtKZ _JA = new TodesdatumBestaetigtKZ(JA);

  /**
   * Nein.
   */
  public static final String NEIN = "0";
  /** @exclude */
  public static TodesdatumBestaetigtKZ _NEIN = new TodesdatumBestaetigtKZ(NEIN);

  /**
   * Keine Angabe.
   */
  public static final String KEINE_ANGABE = "";
  /** @exclude */
  public static TodesdatumBestaetigtKZ _KEINE_ANGABE = new TodesdatumBestaetigtKZ(KEINE_ANGABE);

  /** @exclude */
  private TodesdatumBestaetigtKZ(String s) {
    super(s);
  }

  /** @exclude */
  public static TodesdatumBestaetigtKZ getEnum(String s) {
    return (TodesdatumBestaetigtKZ) getEnum(TodesdatumBestaetigtKZ.class, s);
  }
}
