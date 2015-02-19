/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Berechtigungen.
 */
public class Berechtigungen {

  /**
   * Anmeldung am System berechtigt.
   */
  public static final String BASE_CORE = "BASE.CORE";
  /**
   * Zugriff auf KSE (zumindest für einen Vertrag des Vertragspartners muss das Konsultationsrecht bestehen) berechtigt.
   */
  public static final String KSE_CORE = "KSE.CORE";
  /**
   * Voller Zugriff auf KSE berechtigt.
   */
  public static final String KSE_FULL = "KSE.FULL";
  /**
   * Zugriff auf ABS berechtigt.
   */
  public static final String ABS_CORE = "ABS.CORE";
  /**
   * Bewilligungsanfragen im Rahmen der Arztbrieferstellung berechtigt.
   */
  public static final String ABS_ARZTBRIEF = "ABS.ARZTBRIEF";
  /**
   * Bewilligungsanfragen im Rahmen der Rezeptausstellung berechtigt.
   */
  public static final String ABS_REZEPTUR = "ABS.REZEPTUR";
  /**
   * Zugriff auf SAS berechtigt.
   */
  public static final String SAS_CORE = "SAS.CORE";
  /**
   * Zugriff auf VDAS berechtigt. Abfrage der aktuellen Versichertendaten erlaubt.
   */
  public static final String VDAS_CORE = "VDAS.CORE";
  /**
   * Zugriff auf VDAS berechtigt. Berechtigt zur Abfrage von Versichertendaten
   * für ein bestimmtes Datum (in der Vergangenheit liegend), sowie zur Anzeige
   * aller Ansprüche einer SV-Person bei gemischter Mehrfachversicherung
   * (ASVG-Träger und Sonderversicherungsträger)
   */
  public static final String VDAS_ANSPRUCH_HISTORISCH  = "VDAS.ANSPRUCH_HISTORISCH";
  /**
   * Zugriff auf DMP berechtigt.
   */
  public static final String DMP_CORE = "DMP.CORE";
  /**
   * Zugriff auf TSV berechtigt.
   */
  public static final String TSV_CORE = "TSV.CORE";
  /**
   * Zugriff auf AUM berechtigt.
   */
  public static final String AUM_CORE = "AUM.CORE";
  /**
   * Zugriff auf UZE berechtigt.
   */
  public static final String UZE_CORE = "UZE.CORE";
  /**
   * Einlösen von Einweisungen berechtigt.
   */
  public static final String UZE_EW_EINLOESEN = "UZE.EW_EINLOESEN";
  /**
   * FG-übergreifende Verwendung berechtigt.
   */
  public static final String UZE_FG_UEBERGREIFEND = "UZE.FG_UEBERGREIFEND";
  /**
   * Zugriff auf DBAS berechtigt.
   */
  public static final String DBAS_CORE = "DBAS.CORE";
  /**
   * Zugriff auf DAS berechtigt.
   */
  public static final String DAS_CORE = "DAS.CORE";
  /**
   * Zugriff auf DBAS-QZK berechtigt.
   */
  public static final String DBAS_QZK = "DBAS.QZK";
  /**
   * Zugriff auf EMEDIK berechtigt.
   */
  public static final String EMEDIK_CORE = "EMEDIK.CORE";
  /**
   * Berechtigung zur Erstellung der Einwilligung ohne e-card.
   */
  public static final String EMEDIK_EINWILLIGUNG_OHNE_ECARD = "EMEDIK.EINWILLIGUNG_OHNE_ECARD";
  /**
   * Berechtigung zur Erstellung des Patientenausdrucks mit OTCs.
   */
  public static final String EMEDIK_AUSDRUCK_MIT_OTC = "EMEDIK.AUSDRUCK_MIT_OTC";
  /**
   * Berechtigung zur Abfrage der historischen Medikation.
   */
  public static final String EMEDIK_HISTORIE = "EMEDIK.HISTORIE";
  /**
   * Berechtigung zur Abgabe.
   */
  public static final String EMEDIK_ABGABE = "EMEDIK.ABGABE";
  /**
   * Berechtigung zur Erstellung von Verordnungen.
   */
  public static final String EMEDIK_VERORDNUNG = "EMEDIK.VERORDNUNG";
  /**
   * Berechtigung zur Abfrage von SIS Informationen.
   */
  public static final String EMEDIK_SIS = "EMEDIK.SIS";
  /**
   * Berechtigung zur Anforderung der automatischen Dokumentation.
   */
  public static final String EMEDIK_AUTO_DOKUMENTIEREN = "EMEDIK.AUTO_DOKUMENTIEREN";
}
