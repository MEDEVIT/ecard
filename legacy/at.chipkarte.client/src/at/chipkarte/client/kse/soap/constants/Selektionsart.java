/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für die Selektionsart bei der Suche nach Konsultationen,
 * {@link at.chipkarte.client.kse.soap.IKseService#getKonsultationsdaten}.
 */
public final class Selektionsart extends Enum {

  /**
   * Alle zum aktuellen Datum stornierbaren bzw. änderbaren Konsultationen werden gesucht.
   */
  public static final String MODIFIZIERBAR = "MODIFIZIERBAR";
  /** @exclude */
  public static Selektionsart MODIFIZIERBAR_ = new Selektionsart(MODIFIZIERBAR);

  /**
   * Alle zum aktuellen Datum stornierten (und somit wieder in Kraft setzbaren) Konsultationen werden gesucht.
   */
  public static final String STORNIERT = "STORNIERT";
  /** @exclude */
  public static Selektionsart STORNIERT_ = new Selektionsart(STORNIERT);

  /**
   * Alle zum aktuellen Datum verfügbaren Konsultationen werden gesucht.
   */
  public static final String ALLE = "ALLE";
  /** @exclude */
  public static Selektionsart ALLE_ = new Selektionsart(ALLE);

  private Selektionsart(String att) {
    super(att);
  }

  /** @exclude */
  public static Selektionsart getEnum(String enumString) {
    return (Selektionsart) getEnum(Selektionsart.class, enumString);
  }

}
