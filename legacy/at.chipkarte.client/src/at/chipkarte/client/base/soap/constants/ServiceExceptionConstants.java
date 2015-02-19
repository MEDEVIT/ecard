/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;

/**
 * Fehlerkonstanten bei allgemeinen Fehlern des Ordinations Clients.
 */
public class ServiceExceptionConstants {

  /**
   * Interner grundlegender Fehler im System.<br>
   * ORCLI-Code: CL-A0001, CL-00181, CL-00122, CL-00125, CL-S0006, CL-S0009, CL-S0010, CL-S0012, CL-S0013
   * 
   * <p>Hinweis zu CL-S0013: Die Schnittstellenversion wird im Dialog gespeichert. Falls nach der ersten Serviceanfrage
   * eine andere Version dieses Services verwendet werden soll, so muss dazu ein neuer Dialog aufgebaut werden.</p>
   */
  public static final int INTERNAL_ERROR      = 1;
  /**
   * Software Update wird gerade durchgeführt.<br>
   * ORCLI-Code: CL-00019
   */
  public static final int SW_UPDATE_EXCEPTION = 2;

  /**
   * Die aufgerufene Funktion steht zurzeit nicht zur Verfügung, weil sie gerade durch einen
   * anderen Benutzer gesperrt ist.<br>
   * ORCLI-Code: CL-01090
   */
  public static final int FUNCTION_LOCKED     = 3;
  
  /**
   * Es ist eine Inkompatibilität auf der Schnittstelle aufgetreten. Fehlernummer: &lt;OriginalFehlernummer&gt;.<br/>
   * ORCLI-Code: CL-I0001, ZS-99999
   */
  public static final int INCOMPATIBILITY_EXCEPTION = 4;

  /**
   * Keine Verbindung zum e-card Server möglich. Der Status des jeweiligen Service ändert sich zum Modus
   * {@link Modus#OFFLINE OFFLINE} bzw. der Offline-Status ist bereits bekannt. <br>
   * ORCLI-Code: CL-00115 (allgemein und KSE), CL-04223 (ABS), CL-05005 (VDAS), CL-08101 (SAS), CL-09001 (EMED), CL-02500 (DMP), CL-00265 (TSV), CL-03005 (AUM)
   */
  public final static int CONNECTION_ERROR    = 20; // at.siemens.ecard.common.protocol.CommunicationException

}