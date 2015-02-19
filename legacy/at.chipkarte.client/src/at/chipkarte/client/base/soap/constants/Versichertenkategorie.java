/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten der Versichertenkategorien.
 */
public final class Versichertenkategorie extends Enum {

  /**
   * Erwerbstätige, Arbeitslose, Selbstversicherte, Zivildiener, Asylanten, Flüchtlinge, Mindestsicherungsbezieher.
   */
  public static final String ERWERBSTAETIGER = "01";
  /** @exclude */
  public static Versichertenkategorie ERWERSTAETIGER_ = new Versichertenkategorie(ERWERBSTAETIGER);

  /**
   * Pensionisten, Ruhegenussempfänger.
   */
  public static final String PENSIONISTEN = "05";
  /** @exclude */
  public static Versichertenkategorie PENSIONISTEN_ = new Versichertenkategorie(PENSIONISTEN);

  /**
   * Kriegshinterbliebene.
   */
  public static final String KRIEGSHINTERBLIEBENE = "07";
  /** @exclude */
  public static Versichertenkategorie KRIEGSHINTERBLIEBENE_ = new Versichertenkategorie(KRIEGSHINTERBLIEBENE);

  /**
   * Zugeteilt nach OFG.
   */
  public static final String ZUGETEILT_OFG = "20";
  /** @exclude */
  public static Versichertenkategorie ZUGETEILT_OFG_ = new Versichertenkategorie(ZUGETEILT_OFG);

  /**
   * Zugeteilt nach KOVG, HVG.
   */
  public static final String ZUGETEILT_KOVG_HVG = "21";
  /** @exclude */
  public static Versichertenkategorie ZUGETEILT_KOVG_HVG_ = new Versichertenkategorie(ZUGETEILT_KOVG_HVG);

  /**
   * Zugeteilt nach KOVG-D.
   */
  public static final String ZUGETEILT_KOVG_D = "22";
  /** @exclude */
  public static Versichertenkategorie ZUGETEILT_KOVG_D_ = new Versichertenkategorie(ZUGETEILT_KOVG_D);

  /**
   * Zugeteilt nach STVG.
   */
  public static final String ZUGETEILT_STVG = "23";
  /** @exclude */
  public static Versichertenkategorie ZUGETEILT_STVG_D_ = new Versichertenkategorie(ZUGETEILT_STVG);

  /**
   * Zugeteilt nach VOG.
   */
  public static final String ZUGETEILT_VOG = "24";
  /** @exclude */
  public static Versichertenkategorie ZUGETEILT_VOG_ = new Versichertenkategorie(ZUGETEILT_VOG);

  /**
   * Fremdstaaten (De-facto-Versicherte).
   */
  public static final String FREMDSTAATEN = "29";
  /** @exclude */
  public static Versichertenkategorie FREMDSTAATEN_ = new Versichertenkategorie(FREMDSTAATEN);

  private Versichertenkategorie(String versichertenkategorie) {
    super(versichertenkategorie);
  }

  /** @exclude */
  public static Versichertenkategorie getEnum(String enumString) {
    return (Versichertenkategorie) getEnum(Versichertenkategorie.class, enumString);
  }
}
