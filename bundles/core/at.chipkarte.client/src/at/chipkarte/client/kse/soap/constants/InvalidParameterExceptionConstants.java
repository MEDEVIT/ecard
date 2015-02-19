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
   * Der angegebene Krankenversicherungsträger ist ungültig.
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
   * Der Nacherfassungsgrund ist ungültig.
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
   * Die Funktion kann nicht durchgeführt werden, weil ein falscher Datensatztyp (Konsultation oder
   * Nachsignierung) im Parameter referenziert wurde.
   * <br/>ORCLI-Code: CL-A0047
   */
  public static final int WRONG_RECORD_TYPE_FOR_FUNCTION = 16;

  /**
   * Die Anfrage-Id ist ungültig.
   * <br/>ORCLI-Code: CL-A0025
   *  
   */
  public static final int INVALID_ANFRAGE_ID             = 17;

  /**
   * Die angegebene Ordinations-Id ist ungültig.
   * <br/>ORCLI-Code: CL-A0027
   */
  public static final int INVALID_ORDID                  = 19;

  /**
   * Der angegebene Zeitraum für die Limitanfrage ist nicht gültig.
   * <br/>ORCLI-Code: CL-A0028
   */
  public static final int INVALID_LIMIT_ZEITRAUM         = 20;

  /**
   * Die angegebene Version der Konsultation ist ungültig. Die Konsultationsversion muss numerisch und positiv sein.
   * <br/>ORCLI-Code: CL-A0036
   */
  public static final int INVALID_KONSULTATION_VERSION         = 21;
  
  /**
   * Bei der KSE-Anfrage (mit einem Dialog der mit SW-Zertifikat aufgebaut wurde) wurde weder eine e-card gesteckt noch der Request mit dem 
   * SW-Zertifikat signiert. Der Dialogaufbau erfolgte mit SW-Zertifikat. Es darf somit mit SW-Zertifikat oder e-card signiert werden. 
   * Beim Senden der KSE-Anfrage wurde jedoch keine-card gesteckt und der Request auch nicht mit einem SW-Zertifikat signiert.
   * <br/>ORCLI-Code: CL-00270
   */  
  public static final int NO_CERTIFICATE_AND_NO_ECARD = 22;

  /**
   * Bei der KSE-Anfrage (mit einem Dialog der mit SW-Zertifikat aufgebaut wurde) wurde weder ein Kartenleser übergeben noch der Request mit dem 
   * SW-Zertifikat signiert. Der Dialogaufbau erfolgte mit SW-Zertifikat. Es darf somit mit SW-Zertifikat oder e-card signiert werden. 
   * Beim Senden der KSE-Anfrage wurde jedoch kein Kartenleser übergeben und der Request auch nicht mit dem SW-Zertifikat signiert.
   * <br/>ORCLI-Code: CL-00269
   */  
  public static final int NO_CERTIFICATE_AND_NO_CARD_READER = 23;
 
  /**
   * Unerlaubter Wert für diesen Parameter.
   * <br/>ORCLI-Code: CL-A0029
   * 
   */
  public static final int ILLEGAL_VALUE = 100; 
  //ZS-00035 NoDataFoundException
  
  /**
   * Die Zusatzinformationsantwort-Id ist ungültig. 
   * <br/>ORCLI-Code: CL-00282
   * 
   */
  public static final int ZUSATZINFO_ANTWORTID_INVALID  = 101;
  
  /**
   * Der übergebene Wert für die Zusatzinformationsantwort ist entweder generell kein gültiger Wert oder kein gültiger Wert für die
   * beantwortete Zusatzinformation.
   * <br/>ORCLI-Code: CL-00283, ZS-00123
   */
  public static final int ZUSATZINFO_ANTWORT_INVALID  = 102;
  
  /**
   * Sie haben nicht die Berechtigung zur Buchung des Behandlungsfalles &lt;Anzeigetext BF&gt;.
   * <br/>ORCLI-Code: CL-00287, ZS-00113
   * 
   */
  public static final int MISSING_RIGHT_FOR_BEHANDLUNGSFALL  = 103;  
}

