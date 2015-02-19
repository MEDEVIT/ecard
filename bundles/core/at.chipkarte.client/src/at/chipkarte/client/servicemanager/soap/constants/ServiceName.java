/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.servicemanager.soap.constants;

/**
 * Konstanten für Service Namen.
 */
public final class ServiceName {

  private ServiceName() {
    // nothing to do
  }
  
  /**
   * Name für Kse (Krankenschein Ersatz) Service.
   */
  public static final String KSE_SERVICE = "kse";
  /**
   * Name für Base Service.
   */
  public static final String BASE_SERVICE = "base";

  /**
   * Name für das ABS (Arznei Bewilligungs System) Service.
   */
  public static final String ABS_SERVICE = "abs";

  /**
   * Name für das SAS (SV-Nummern-Abfrage-Service).
   */
  public static final String SAS_SERVICE = "sas";

  /**
   * Name für das VDAS (Versichertendatenabfrageservice).
   */
  public static final String VDAS_SERVICE = "vdas";

  /**
   * Name für das OPC (Operationsclient) Service; Dieses Service wird nicht über die SOAP Schnittstelle angeboten. Es handelt sich
   * hiebei um ein Message erzeugendes Services, siehe auch
   * {@link at.chipkarte.client.base.soap.IBaseService#getMessages(java.lang.String, boolean), getMessages}.
   */
  public static final String OPC_SERVICE = "opc";

  /**
   * Name für das DMP (Diseasemanagement Program) Service.
   */
  public static final String DMP_SERVICE = "dmp";

  /**
   * Name für das AUM (Arbeits(un)fähigkeitsmeldung) Service.
   */
  public static final String AUM_SERVICE = "aum";

  /**
   * Name für das UZE (Über-/Zu-/Einweisung) Service.
   */
  public static final String UZE_SERVICE = "uze";

  /**
   * Name für Schulung Service.
   */
  public static final String TSV_SERVICE = "tsv";

  /**
   * Name für Dokumentationsblattannahme- Service.
   */
  public static final String DBAS_SERVICE = "dbas";

  /**
   * Name für Security Token Service.
   */
  public static final String STS_SERVICE = "sts";

  /**
   * Name für Datenabfrage Service.
   */
  public static final String DAS_SERVICE = "das";

  /**
   * Name für das PROP Service.
   */
  public static final String PROP_SERVICE = "prop";

  /**
   * Name für das BKF Service.
   */
  public static final String BKF_SERVICE = "bkf";
}
