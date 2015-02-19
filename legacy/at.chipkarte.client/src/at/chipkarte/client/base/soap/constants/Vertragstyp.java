/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für den Vertragstyp.
 */
public final class Vertragstyp extends Enum {

  /**
   * Kurativer Vertrag.
   */
  public static final String KU = "KU";
  /** @exclude */
  public static Vertragstyp KU_ = new Vertragstyp(KU);
  /**
   * Vorsorgeuntersuchungsvertrag.
   */
  public static final String GU = "GU";
  /** @exclude */
  public static Vertragstyp GU_ = new Vertragstyp(GU);
  /**
   * Hausapothekenvertrag.
   */
  public static final String HAPO = "HAPO";
  /** @exclude */
  public static Vertragstyp HAPO_ = new Vertragstyp(HAPO);
  /**
   * Rezepturvertrag.
   */
  public static final String REZ = "REZ";
  /** @exclude */
  public static Vertragstyp REZ_ = new Vertragstyp(REZ);  
  /**
   * Vorsorgeuntersuchung Allgemeines Programm.
   */
  public static final String VUA = "VU-A";
  /** @exclude */
  public static Vertragstyp VUA_ = new Vertragstyp(VUA);
  /**
   * Vorsorgeuntersuchung Koloskopie.
   */
  public static final String VUK = "VU-K";
  /** @exclude */
  public static Vertragstyp VUK_ = new Vertragstyp(VUK);
  /**
   * Vorsorgeuntersuchung Gynäkologie.
   */
  public static final String VUG = "VU-G";
  /** @exclude */
  public static Vertragstyp VUG_ = new Vertragstyp(VUG);
  /**
   * Vorsorgeuntersuchung Mammographie.
   */
  public static final String VUM = "VU-M";
  /** @exclude */
  public static Vertragstyp VUM_ = new Vertragstyp(VUM);
  
  private Vertragstyp(String vertragstypCode) {
    super(vertragstypCode);
  }

  /** @exclude */
  public static Vertragstyp getEnum(String enumString) {
    return (Vertragstyp) getEnum(Vertragstyp.class, enumString);
  }
}
