/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Fehlerkonstanten für Fehler im Zusammenhang mit Kartenleser und Karte.
 */
public final class CardExceptionConstants {

  private CardExceptionConstants() {
    // nothing to do
  }
  
  /**
   * Die gesteckte Karte ist fehlerhaft.
   * <br>ORCLI-Code: CA-01001, CA-01002, CA-01010, CA-02003, CA-02102, CA-02105
   */
  public static final int DEFECT_CARD = 1;
  /**
   * Die gesteckte Karte ist vom falschen Typ. Dies kann auftreten, wenn für eine Aktion eine o-card notwendig ist, jedoch eine
   * e-card oder eine Testkarte gesteckt wird bzw. wenn ein vom e-card-System nicht akzeptierter Kartentyp identifiziert wird. 
   * <br>ORCLI-Code: CA-02100, CA-03006, CL-00258
   */
  public static final int WRONG_CARD = 2;
  /**
   * Der angegebene PIN-Code stimmt nicht mit dem PIN-Code der Karte überein.
   * <br>ORCLI-Code: CA-03002
   */
  public static final int WRONG_PIN = 3;
  /**
   * Das Format des angegebenen PIN-Codes ist nicht gültig.
   * <br>ORCLI-Code: CA-03007
   */
  public static final int INVALID_PIN = 4;
  /**
   * Der PIN-Code der gesteckten Karte wurde gesperrt. Der PIN-Code kann nur durch Eingabe des PUK-Codes entsperrt werden. Siehe
   * Funktion
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#changePinWithPuk(String, String, String, String) changePinWithPuk} 
   * <br>ORCLI-Code: CA-03005
   */
  public static final int PIN_LOCKED = 5;
  /**
   * Transport-PIN ist gesetzt und muss geändert werden. Siehe Funktion
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#changePin(String, String, String, String) changePin} 
   * <br>ORCLI-Code: CA-03009
   */
  public static final int TRANSPORT_PIN = 6;

  /**
   * Für die angegebene Kartenleser-ID ist kein Kartenleser registriert.
   * <br>ORCLI-Code: CA-02110
   */
  public static final int INVALID_CARD_READER_ID = 7;

  /**
   * Die angegebene CIN stimmt nicht mit der CIN der Karte überein, die in dem verwendeten Kartenleser steckt.
   * <br>ORCLI-Code: CL-A0002, CL-05242
   */
  public static final int CIN_NOT_IDENT = 8;

  /**
   * Mit dieser Karte wurde erneut in Folge eine Signatur im gleichen Kartenleser erzeugt. 
   * <br>ORCLI-Code: CA-03011
   */
  public static final int REPEATED_SIGNATUR = 9;

  /**
   * Der angegebene PUK-Code stimmt nicht mit dem PUK-Code der Karte überein.
   * <br>ORCLI-Code: CA-03003
   */
  public static final int WRONG_PUK = 10;
  /**
   * Das Format des angegebenen PUK-Codes ist nicht gültig.
   * <br>ORCLI-Code: CA-03008
   */
  public static final int INVALID_PUK = 11;

  /**
   * Es befindet sich keine Karte im Kartenleser.
   * <br>ORCLI-Code: CA-02111, CA-02112, CL-00257
   */
  public static final int NO_CARD = 12;

  /**
   * Es ist ein interner Fehler beim Zugriff auf die Karte aufgetreten.
   * <br>ORCLI-Code: CA-01000,CA-01003, CA-01004, CA-01005, CA-01008, CA-01009, CA-01011, CA-01012, CA-02001, CA-02002, 
   * CA-02005, CA-02006, CA-02200, CA-02201, CA-02202, CA-03010
   */
  public static final int INTERNAL_ERROR = 13;
  /**
   * Die Karte wurde aufgrund einer mehrfachen falschen PUK-Codeeingabe gesperrt. Die Karte kann nicht mehr entsperrt werden. 
   * <br>ORCLI-Code: CA-03004
   */

  public static final int PUK_LOCKED = 15;
  /**
   * Die Karte wurde während eines Zugriffs aus dem Kartenleser entfernt. 
   * <br>ORCLI-Code: CA-02108
   */
  public static final int CARD_CHANGED = 16;

  /**
   * Die Authentifizierung mit der gesteckten Karte ist fehlgeschlagen. Möglicherweise wurde die Karte manipuliert. Der Fehlerfall
   * kann ausschließlich im Offline-Modus des Ordinationsclients auftreten. 
   * <br>ORCLI-Code: CA-02400, CA-02401, CA-02402
   */
  public static final int AUTHENTICATION_FAILED = 18;

  /**
   * Es wird versucht auf einen Kartenleser zuzugreifen der gerade in Verwendung ist. 
   * <br>ORCLI-Code: CA-02101, CA-02007, CA-02103, CA-02104
   */
  public static final int CARDREADER_IN_USE = 36;

  /**
   * Der übergebene Wert für die maximale Wartezeit liegt nicht im vorgegebenen Wertebereich. 
   * <br>ORCLI-Code: CA-01013
   */
  public static final int INVALID_TIMEOUT_PARAMETER = 37;

  /**
   * Die Kartenleserstatusüberwachung konnte nicht aktiviert werden. 
   * <br>ORCLI-Code: CA-02203
   */
  public static final int CARDREADERCONTROL_NOT_STARTED = 38;
  
  /**
   * Es ist die falsche Ordinationskarte gesteckt. Sie haben sich mit der
   * Ordinationskarte eines anderen Vertragspartners angemeldet.
   * <br>ORCLI-Code: CL-00043
   */
  public static final int WRONG_OCARD = 39;
}
