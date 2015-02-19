/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Berechtigungen im e-card-System.
 */
public final class Berechtigungen {

  private Berechtigungen() {
    // nothing to do
  }
  
  /**
   * Zugriff auf BASE.
   */
  public static final String BASE_CORE = "BASE.CORE";
  /**
   * Zugriff auf KSE (unabhängig von der Kombination aus gewählter Ordination und Tätigkeitsbereich, besteht mindestens ein Vertrag mit Konsultationsrecht).
   */
  public static final String KSE_CORE = "KSE.CORE";
  /**
   * Berechtigt zur Erfassung einer Konsultation im KSE-Service (bei der Kombination aus gewählter Ordination und Tätigkeitsbereich, besteht mindestens ein Vertrag mit Konsultationsrecht).
   */
  public static final String KSE_FULL = "KSE.FULL";
  /**
   * Berechtigt zur Erfassung einer Konsultation mit dem Behandlungsfalls "VM" im Rahmen der Brustkrebs-Früherkennung im KSE-Service.
   */
  public static final String KSE_BKF = "KSE.BKF";
  /**
   * Zugriff auf ABS.
   */
  public static final String ABS_CORE = "ABS.CORE";
  /**
   * Berechtigt zur Erfassung einer Bewilligungsanfrage im Rahmen der Arztbrieferstellung in ABS.
   */
  public static final String ABS_ARZTBRIEF = "ABS.ARZTBRIEF";
  /**
   * Berechtigt zur Erfassung einer Bewilligungsanfrage im Rahmen der Rezeptausstellung in ABS.
   */
  public static final String ABS_REZEPTUR = "ABS.REZEPTUR";
  /**
   * Zugriff auf SAS.
   */
  public static final String SAS_CORE = "SAS.CORE";
  /**
   * Berechtigt zur Adressdatenabfrage in SAS.
   */
  public static final String SAS_ADRESSABFRAGE = "SAS.ADRESSABFRAGE";
  /**
   * Zugriff auf VDAS und Berechtigung zur Abfrage der tagesaktuellen Versichertendaten in VDAS.
   */
  public static final String VDAS_CORE = "VDAS.CORE";
  /**
   * Berechtigt zur stichtagaktuellen Abfrage von Versichertendaten
   * (für ein bestimmtes Datum in der Vergangenheit liegend) sowie zur Anzeige
   * aller Ansprüche eines Patienten bei gemischter Mehrfachversicherung
   * (GKK/BKK-Träger und Sonderversicherungsträger) in VDAS.
   */
  public static final String VDAS_ANSPRUCH_HISTORISCH  = "VDAS.ANSPRUCH_HISTORISCH";
  /**
   * Zugriff auf DMP.
   */
  public static final String DMP_CORE = "DMP.CORE";
  /**
   * Zugriff auf TSV.
   */
  public static final String TSV_CORE = "TSV.CORE";
  /**
   * Zugriff auf AUM.
   */
  public static final String AUM_CORE = "AUM.CORE";
  /**
   * Zugriff auf UZE.
   */
  public static final String UZE_CORE = "UZE.CORE";
  /**
   * Berechtigt zum Einlösen von Einweisungen im UZE-Service.
   */
  public static final String UZE_EW_EINLOESEN = "UZE.EW_EINLOESEN";
  /**
   * Berechtigt zur Fachgebietsübergreifenden Verwendung im UZE-Service.
   */
  public static final String UZE_FG_UEBERGREIFEND = "UZE.FG_UEBERGREIFEND";
  /**
   * Zugriff auf DBAS.
   */
  public static final String DBAS_CORE = "DBAS.CORE";
  /**
   * Zugriff auf DAS.
   */
  public static final String DAS_CORE = "DAS.CORE";
  /**
   * Berechtigt zur Erfassung einer QZK-Dokumentation in DBAS.
   */
  public static final String DBAS_QZK = "DBAS.QZK";
  /**
   * Zugriff auf PROP (Erfassung eines PROP-Befundes ist nur ohne Konsultationsangabe möglich).
   */
  public static final String PROP_CORE = "PROP.CORE";
  /**
   * Berechtigt zur Erfassung von PROP-Befunden mit Angabe einer Konsultation.
   */
  public static final String PROP_KONSULTATION = "PROP.KONSULTATION";
  /**
   * Zugriff auf BKF.
   */
  public static final String BKF_CORE = "BKF.CORE";
  /**
   * Berechtigt zur Erfassung von Dokumentationen aus dem Früherkennungs-(Screening) oder Kurativen-Bereich 
   * im BKF-Service.
   */
  public static final String BKF_MAMMO = "BKF.MAMMO";
  /**
   * Berechtigt zur Erfassung von Dokumentationen aus dem Assessment- oder Therapiebereich im BKF-Service.
   */
  public static final String BKF_ASSESSMENT = "BKF.ASSESSMENT";
  /**
   * Berechtigt zur Erfassung einer Früherkennungsdokumentation (Screening- bzw. Screeningultraschall) ohne der Angabe einer Konsultation im BKF-Service.
   */
  public static final String BKF_NO_KONS = "BKF.NO_KONS";
  /**
   * Zugriff auf STS.
   */
  public static final String STS_CORE = "STS.CORE";
}
