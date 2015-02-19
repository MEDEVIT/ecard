/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap.constants;

/**
 * 
 * Fehlerkonstanten, wenn ein ungültiger Parameter in einer Funktion angegeben wird. Fehlercodes
 * siehe
 * {@link at.chipkarte.client.kse.soap.constants.InvalidParameterExceptionConstants InvalidParameterExceptionConstants}
 */
public class InvalidParameterExceptionConstants {

  /**
   * Das angegebene Datum ist ungültig.
   * <br/>ORCLI-Code: CL-00070
   */
  public static final int DATE_INVALID                   = 1;  

  /**
   * Das angegebene Datum liegt in der Zukunft.
   * <br/>ORCLI-Code: CL-A0017 
   *  
   */
  public static final int DATE_IN_FUTURE                 = 4;  

  /**
   * Das Bis-Datum muss nach dem Von-Datum liegen.
   * <br/>ORCLI-Code: CL-01060 
   */
  public static final int DATE_ORDER_WRONG               = 5;  

  /**
   * Der Fachgebietscode ist ungültig.
   * <br/>ORCLI-Code: CL-A0015 
   *  
   */
  public static final int INVALID_FG                     = 6;

  /**
   * Der Behandlungsfallcode ist ungültig.
   * <br/>ORCLI-Code: CL-A0018
   *  
   */
  public static final int INVALID_BF                     = 7;

  /**
   * Der Svt ist ungültig.
   * <br/>ORCLI-Code: CL-A0019
   *  
   */
  public static final int INVALID_SVT                    = 8;

  /**
   * Die Konsultationsart ist ungültig.
   * <br/>ORCLI-Code: CL-A0020
   *  
   */
  public static final int INVALID_KONSULTATIONS_ART      = 9;


  /**
   * Die Sozialversicherungsnummer ist ungültig oder fehlt.
   * <br/>ORCLI-Code: CL-A0021
   *  
   */
  public static final int INVALID_SV_NUMBER              = 11;

  /**
   * Die Selektionsart ungültig.
   * <br/>ORCLI-Code: CL-A0022
   *  
   */
  public static final int INVALID_SELEKTIONS_ART         = 12;

  /**
   * Der Nacherfassungsgrund ungültig.
   * <br/>ORCLI-Code: CL-A0023
   *  
   */
  public static final int INVALID_NACHERFASSUNGSGRUND    = 13;

  /**
   * Die Datumsangabe fehlt.
   * <br/>ORCLI-Code: CL-A0024
   */
  public static final int DATE_NOT_SET                   = 14; 

  /**
   * Der Datensatz mit dieser Id wurde nicht gefunden.
   * <br/>ORCLI-Code: CL-S0007
   */
  public static final int ID_NOT_FOUND                   = 15;

  /**
   * Die Funktion kann nicht durchgeführt werden, weil ein falscher Datensatz-Typ (Konsultation oder
   * Nachsignierung) im Parameter referenziert wurde.
   * <br/>ORCLI-Code: CL-A0047
   */
  public static final int WRONG_RECORD_TYPE_FOR_FUNCTION = 16;

  /**
   * Die Anfrage Id ist ungültig.
   * <br/>ORCLI-Code: CL-A0025
   *  
   */
  public static final int INVALID_ANFRAGE_ID             = 17;

  /**
   * Die angegebene Ordinations ID ist ungültig.
   * <br/>ORCLI-Code: CL-A0027
   */
  public static final int INVALID_ORDID                  = 19;

  /**
   * Der angegebene Wert ist für den Zeitraum der Limitabfrage nicht erlaubt.
   * <br/>ORCLI-Code: CL-A0028
   */
  public static final int INVALID_LIMIT_ZEITRAUM         = 20;

  /**
   * Die angegebene Konsultationsversion ist ungültig.
   * <br/>ORCLI-Code: CL-A0036
   */
  public static final int INVALID_KONSULTATION_VERSION         = 21;
  
  /**
   * Der Dialogaufbau erfolgte mit SW-Zertifikat. Es darf somit mit SW-Zertifikat oder e-card signiert werden. 
   * Beim Senden der KSE Anfrage wurde jedoch weder eine e-card gesteckt noch der Request mit einem SW-Zertifikat signiert.
   * <br/>ORCLI-Code: CL-00270
   */  
  public static final int NO_CERTIFICATE_AND_NO_ECARD = 22;

  /**
   * Der Dialogaufbau erfolgte mit SW-Zertifikat. Es darf somit mit SW-Zertifikat oder e-card signiert werden. 
   * In der KSE Anfrage kein Kartenleser übergeben.
   * <br/>ORCLI-Code: CL-00269
   */  
  public static final int NO_CERTIFICATE_AND_NO_CARD_READER = 23;
 
 /**
   * Der Dialogaufbau erfolgte mit SW-Zertifikat. Beim Nachsignieren mit Bürgerkarte muss der Request mit einem SW-Zertifikat
   * signiert werden. <br/>
   * ORCLI-Code: CL-00271
   */
  public static final int NO_CERTIFICATE = 24;
 
  /**
   * Unerlaubter Wert für diesen Parameter.
   * <br/>ORCLI-Code: CL-A0029
   * 
   */
  public static final int ILLEGAL_VALUE                  = 100; 
  //ZS-00035 NoDataFoundException
  
  /**
   * Die Zusatzinformations-AntwortID ist ungültig. 
   * <br/>ORCLI-Code: CL-00282
   * 
   */
  public static final int ZUSATZINFO_ANTWORTID_INVALID  = 101;
  
  /**
   * Die Antwort ist ungültig.
   * <br/>ORCLI-Code: CL-00283
   * 
   */
  public static final int ZUSATZINFO_ANTWORT_INVALID  = 102;
  
}

