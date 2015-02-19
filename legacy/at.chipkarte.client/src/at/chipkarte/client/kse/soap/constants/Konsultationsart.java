/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap.constants;

import org.apache.commons.lang.enums.Enum;

/**
 * Konstanten für die Konsultationsarten.
 */
public final class Konsultationsart extends Enum {

  /**
   * <b>O</b>nline <b>K</b>onsultation <b>m</b>it e-card.
   */
  public static final String     OKM  = "OKM";
  /** @exclude */
  public static Konsultationsart OKM_ = new Konsultationsart(OKM);

  /**
   * <b>O</b>nline <b>K</b>onsultationen <b>o</b>hne e-card.
   */
  public static final String     OKO  = "OKO";
  /** @exclude */
  public static Konsultationsart OKO_ = new Konsultationsart(OKO);

  /**
   * <b>O</b>nline <b>K</b>onsultation mit e-card <b>n</b>achsigniert.
   */
  public static final String     OKN  = "OKN";
  /** @exclude */
  public static Konsultationsart OKN_ = new Konsultationsart(OKN);

  /**
   * <b>N</b>acherfasste Konsultation wegen <b>H</b>ausbesuch <b>m</b>it e-card.
   */
  public static final String     NHM  = "NHM";
  /** @exclude */
  public static Konsultationsart NHM_ = new Konsultationsart(NHM);

  /**
   * <b>N</b>acherfasste Konsultation wegen <b>H</b>ausbesuch mit e-card <b>n</b>achsigniert.
   */
  public static final String     NHN  = "NHN";
  /** @exclude */
  public static Konsultationsart NHN_ = new Konsultationsart(NHN);

  /**
   * <b>N</b>acherfasste Konsultation wegen <b>H</b>ausbesuch <b>o</b>hne e-card.
   */
  public static final String     NHO  = "NHO";
  /** @exclude */
  public static Konsultationsart NHO_ = new Konsultationsart(NHO);

  /**
   * <b>N</b>acherfasste Konsultation wegen <b>S</b>törung <b>m</b>it e-card.
   */
  public static final String     NSM  = "NSM";
  /** @exclude */
  public static Konsultationsart NSM_ = new Konsultationsart(NSM);

  /**
   * <b>N</b>acherfasste Konsultation wegen <b>S</b>törung mit e-card <b>n</b>achsigniert.
   */
  public static final String     NSN  = "NSN";
  /** @exclude */
  public static Konsultationsart NSN_ = new Konsultationsart(NSN);

  /**
   * <b>N</b>acherfasste Konsultation wegen <b>S</b>törung <b>o</b>hne e-card.
   */
  public static final String     NSO  = "NSO";
  /** @exclude */
  public static Konsultationsart NSO_ = new Konsultationsart(NSO);

  /**
   * <b>O</b>nline <b>K</b>onsultation mit <b>B</b>ürgerkarte.
   */
  public static final String     OKB  = "OKB";
  /** @exclude */
  public static Konsultationsart OKB_ = new Konsultationsart(OKB);

  /**
   * <b>O</b>nline <b>K</b>onsultation mit Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     OKS  = "OKS";
  /** @exclude */
  public static Konsultationsart OKS_ = new Konsultationsart(OKS);

  /**
   * O<b>f</b>fline Konsultation wegen <b>S</b>törung <b>m</b>it e-card.
   */
  public static final String     FSM  = "FSM";
  /** @exclude */
  public static Konsultationsart FSM_ = new Konsultationsart(FSM);
  /**
   * O<b>f</b>fline Konsultation wegen <b>S</b>törung mit nachgebrachter e-card <b>n</b>achsigniert.
   */
  public static final String     FSN  = "FSN";
  /** @exclude */
  public static Konsultationsart FSN_ = new Konsultationsart(FSN);
  /**
   * O<b>f</b>fline Konsultation wegen <b>S</b>törung <b>o</b>hne e-card.
   */
  public static final String     FSO  = "FSO";
  /** @exclude */
  public static Konsultationsart FSO_ = new Konsultationsart(FSO);
  /**
   * <b>N</b>acherfasste Konsultation wegen <b>H</b>ausbesuch mit <b>B</b>ürgerkarte.
   */
  public static final String     NHB  = "NHB";
  /** @exclude */
  public static Konsultationsart NHB_ = new Konsultationsart(NHB);
  /**
   * <b>N</b>acherfasste Konsultation wegen <b>H</b>ausbesuch mit nachgebrachter Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     NHS  = "NHS";
  /** @exclude */
  public static Konsultationsart NHS_ = new Konsultationsart(NHS);
  /**
   * <b>N</b>acherfasste Konsultation wegen <b>S</b>törung mit <b>B</b>ürgerkarte.
   */
  public static final String     NSB  = "NSB";
  /** @exclude */
  public static Konsultationsart NSB_ = new Konsultationsart(NSB);
  /**
   * <b>N</b>acherfasste Konsultation wegen <b>S</b>törung mit nachgebrachter Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     NSS  = "NSS";
  /** @exclude */
  public static Konsultationsart NSS_ = new Konsultationsart(NSS);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>H</b>ausbesuch <b>m</b>it e-card.
   */
  public static final String     KHM  = "KHM";
  /** @exclude */
  public static Konsultationsart KHM_ = new Konsultationsart(KHM);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>H</b>ausbesuch mit e-card <b>n</b>achsigniert.
   */
  public static final String     KHN  = "KHN";
  /** @exclude */
  public static Konsultationsart KHN_ = new Konsultationsart(KHN);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>H</b>ausbesuch mit Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     KHS  = "KHS";
  /** @exclude */
  public static Konsultationsart KHS_ = new Konsultationsart(KHS);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>H</b>ausbesuch <b>o</b>hne e-card.
   */
  public static final String     KHO  = "KHO";
  /** @exclude */
  public static Konsultationsart KHO_ = new Konsultationsart(KHO);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>S</b>törung <b>m</b>it e-card.
   */
  public static final String     KSM  = "KSM";
  /** @exclude */
  public static Konsultationsart KSM_ = new Konsultationsart(KSM);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>S</b>törung mit e-card <b>n</b>achsigniert.
   */
  public static final String     KSN  = "KSN";
  /** @exclude */
  public static Konsultationsart KSN_ = new Konsultationsart(KSN);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>S</b>törung mit Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     KSS  = "KSS";
  /** @exclude */
  public static Konsultationsart KSS_ = new Konsultationsart(KSS);
  /**
   * Offline nacherfasste <b>K</b>onsultation wegen <b>S</b>törung <b>o</b>hne e-card.
   */
  public static final String     KSO  = "KSO";
  /** @exclude */
  public static Konsultationsart KSO_ = new Konsultationsart(KSO);

  /**
   * Offline <b>K</b>onsultation wegen <b>S</b>törung mit Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     FSS  = "FSS";
  /** @exclude */
  public static Konsultationsart FSS_ = new Konsultationsart(FSS);
  
  /**
   * ORDINATIONSZEITEN
   */
  /**
   * <b>N</b>acherfasste Konsultation <b>a</b>ußerhalb der Ordinationszeit <b>m</b>it e-card.
   */
  public static final String     NAM  = "NAM";
  /** @exclude */
  public static Konsultationsart NAM_ = new Konsultationsart(NAM);
  /**
   * <b>N</b>acherfasste Konsultation <b>a</b>ußerhalb der Ordinationszeit mit <b>B</b>ürgerkarte.
   */
  public static final String     NAB  = "NAB";
  /** @exclude */
  public static Konsultationsart NAB_ = new Konsultationsart(NAB);
  /**
   * <b>N</b>acherfasste Konsultation <b>a</b>ußerhalb der Ordinationszeit mit e-card <b>n</b>achsigniert.
   */
  public static final String     NAN  = "NAN";
  /** @exclude */
  public static Konsultationsart NAN_ = new Konsultationsart(NAN);
  /**
   * <b>N</b>acherfasste Konsultation <b>a</b>ußerhalb der Ordinationszeit mit Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     NAS  = "NAS";
  /** @exclude */
  public static Konsultationsart NAS_ = new Konsultationsart(NAS);
  /**
   * <b>N</b>acherfasste Konsultation <b>a</b>ußerhalb der Ordinationszeit <b>o</b>hne e-card.
   */
  public static final String     NAO  = "NAO";
  /** @exclude */
  public static Konsultationsart NAO_ = new Konsultationsart(NAO);
  /**
   * Offline nacherfasste <b>K</b>onsultation <b>a</b>ußerhalb der Ordinationszeit <b>m</b>it e-card.
   */
  public static final String     KAM  = "KAM";
  /** @exclude */
  public static Konsultationsart KAM_ = new Konsultationsart(KAM);
  /**
   * Offline nacherfasste <b>K</b>onsultation <b>a</b>ußerhalb der Ordinationszeit mit e-card <b>n</b>achsigniert.
   */
  public static final String     KAN  = "KAN";
  /** @exclude */
  public static Konsultationsart KAN_ = new Konsultationsart(KAN);
  /**
   * Offline nacherfasste <b>K</b>onsultation <b>a</b>ußerhalb der Ordinationszeit mit Bürgerkarte nach<b>s</b>igniert.
   */
  public static final String     KAS  = "KAS";
  /** @exclude */
  public static Konsultationsart KAS_ = new Konsultationsart(KAS);
  /**
   * Offline nacherfasste <b>K</b>onsultation <b>a</b>ußerhalb der Ordinationszeit <b>o</b>hne e-card.
   */
  public static final String     KAO  = "KAO";
  /** @exclude */
  public static Konsultationsart KAO_ = new Konsultationsart(KAO);


  private Konsultationsart(String att) {
    super(att);
  }

  /** @exclude */
  public static Konsultationsart getEnum(String enumString) {
    return (Konsultationsart) getEnum(Konsultationsart.class, enumString);
  }
}