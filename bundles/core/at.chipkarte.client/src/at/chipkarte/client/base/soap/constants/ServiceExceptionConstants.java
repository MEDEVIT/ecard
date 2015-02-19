/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;

/**
 * Fehlerkonstanten bei allgemeinen Fehlern des Ordinationsclients.
 */
public final class ServiceExceptionConstants {

  private ServiceExceptionConstants() {
    // nothing to do
  }
  
  /**
   * Interner grundlegender Fehler im System.
   * <br>ORCLI-Code: CL-A0001, CL-A0048, CL-A0049, 
   * CL-00122, CL-00125, CL-00174, CL-00181,  
   * CL-S0006, CL-S0009, CL-S0010, CL-S0012, CL-S0013,
   * ZS-1700006, ZS-1700007, ZS-1700008, ZS-1700009, ZS-00103, ZS-100104
   * 
   * <p><i><u>Hinweis zu CL-S0013:</u> Die Schnittstellenversion wird im Dialog gespeichert. Falls nach dem 
   * ersten Serviceaufruf 
   * eine andere Version dieses Service verwendet werden soll, so muss dazu ein neuer Dialog aufgebaut werden.</i></p>
   */
  public static final int INTERNAL_ERROR      = 1;

  /**
   * Die aufgerufene Funktion steht zurzeit nicht zur Verfügung, weil sie durch einen
   * anderen Benutzer gesperrt ist.
   * <br>ORCLI-Code: CL-01090
   */
  public static final int FUNCTION_LOCKED     = 3;
  
  /**
   * Es ist eine Inkompatibilität auf der Schnittstelle aufgetreten. Fehlernummer: &lt;OriginalFehlernummer&gt;.
   * <br>ORCLI-Code: CL-I0001, ZS-99999
   */
  public static final int INCOMPATIBILITY_EXCEPTION = 4;

  /**
   * Keine Verbindung zum e-card-Server möglich. Der Status des jeweiligen Service ändert sich zum Modus
   * {@link Modus#OFFLINE OFFLINE} bzw. der Offline-Status ist bereits bekannt. 
   * <br>ORCLI-Code: CL-00115 (allgemein und KSE), 
   * CL-04223 (ABS), CL-05005 (VDAS), CL-08101 (SAS), CL-02500 (DMP), 
   * CL-00265 (TSV), CL-03005 (AUM), CL-06900 (UZE), CL-1200050 (DBAS), CL-1599999 (DAS), CL-1700001 (PROP), CL-1800001 (BKF) 
   */
  public static final int CONNECTION_ERROR    = 20;

}