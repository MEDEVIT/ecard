package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Daten eines zertifizierten Arztes.
 */
public class BKFArzt {

  private String _vorname;
  private String _zuname;
  private String _titelVorne;
  private String _titelHinten;
  private String _arztID;
  private String _zertifikatsart;

  /**
  * Vorname. <br>
  * Format: maximal 70-stellig <br>
  * Angabe: Muss. 
  * @return Vorname
  */
  public String getVorname() {
    return _vorname;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
  * Zuname. <br>
  * Format: maximal 70-stellig <br>
  * Angabe: Muss. 
  * @return Zuname
  */
  public String getZuname() {
    return _zuname;
  }

  public void setZuname(String zuname) {
    _zuname = zuname;
  }

  /**
  * Titel vorne. <br>
  * Format: maximal 30-stellig 
  * @return TitelVorne
  */
  public String getTitelVorne() {
    return _titelVorne;
  }

  public void setTitelVorne(String titelVorne) {
    _titelVorne = titelVorne;
  }

  /**
  * Titel hinten. <br>
  * Format: maximal 30-stellig 
  * @return TitelHinten
  */
  public String getTitelHinten() {
    return _titelHinten;
  }

  public void setTitelHinten(String titelHinten) {
    _titelHinten = titelHinten;
  }

  /**
  * Eindeutiger Bezeichner eines Arztes. <br>
  * Angabe: Muss. 
  * @return ArztID
  */
  public String getArztID() {
    return _arztID;
  }

  public void setArztID(String arztID) {
    _arztID = arztID;
  }

  /**
  * Kennzeichen ob der Arzt nur Zweitbefundungen durchführen darf. <br>
  * Mögliche Werte: <br>
  * 0  für alle Befundungen berechtigt<br>
  * 1  nur als Zweitbefunder berechtigt.<br>
  * Nur relevant bei Screening-Dokumentation.<br>
  * Angabe: Muss. 
  * @return Zertifikatsart
  */
  public String getZertifikatsart() {
    return _zertifikatsart;
  }

  public void setZertifikatsart(String zertifikatsart) {
    _zertifikatsart = zertifikatsart;
  }
}