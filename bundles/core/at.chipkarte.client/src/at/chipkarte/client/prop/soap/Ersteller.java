package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet Daten zum Vertragspartner und zum Arzt der Erstellung
 */
public class Ersteller {

  private String _erstellerId;
  
  private String _erstellerName;
  
  private String _vertragspartnerVorname;
  
  private String _vertragspartnerZuname;
  
  private String _vertragspartnerDruckVorname;
  
  private String _vertragspartnerDruckZuname;
  
  private String _vertragspartnerTitelVorne;
  
  private String _vertragspartnerTitelHinten;
  
  private String _vertragspartnerDrucktitelVorne;
  
  private String _vertragspartnerDrucktitelHinten;

  
  /**
   * ID des Erstellers (Arztes) des Befundes.<br>
   * @return Id
   */
  public String getErstellerId() {
    return _erstellerId;
  }

  public void setErstellerId(String erstellerId) {
    _erstellerId = erstellerId;
  }

  /**
   * Name des Ersteller (Arztes) des Befundes.<br>
   * @return Name
   */
  public String getErstellerName() {
    return _erstellerName;
  }

  public void setErstellerName(String erstellerName) {
    _erstellerName = erstellerName;
  }
  
  /**
   * Vorname des Vertragspartners der Erstellung.<br>
   * @return Vorname
   */
  public String getVertragspartnerVorname() {
    return _vertragspartnerVorname;
  }

  public void setVertragspartnerVorname(String vertragspartnerVorname) {
    _vertragspartnerVorname = vertragspartnerVorname;
  }
  
  /**
   * Zuname des Vertragspartners der Erstellung.<br> 
   * @return Zuname
   */
  public String getVertragspartnerZuname() {
    return _vertragspartnerZuname;
  }

  public void setVertragspartnerZuname(String vertragspartnerZuname) {
    _vertragspartnerZuname = vertragspartnerZuname;
  }
  
  /**
   * Druckvorname des Vertragspartners der Erstellung.<br> 
   * @return Vorname mit diakritischen Zeichen
   */
  public String getVertragspartnerDruckVorname() {
    return _vertragspartnerDruckVorname;
  }

  public void setVertragspartnerDruckVorname(String vertragspartnerDruckVorname) {
    _vertragspartnerDruckVorname = vertragspartnerDruckVorname;
  }
  
  /**
   * Druckzuname des Vertragspartners der Erstellung.<br> 
   * @return Zuname mit diakritischen Zeichen
   */
  public String getVertragspartnerDruckZuname() {
    return _vertragspartnerDruckZuname;
  }

  public void setVertragspartnerDruckZuname(String vertragspartnerDruckZuname) {
    _vertragspartnerDruckZuname = vertragspartnerDruckZuname;
  }
  
  /**
   * Titel vorne des Vertragspartners der Erstellung.<br>
   * @return Titel vorne
   */
  public String getVertragspartnerTitelVorne() {
    return _vertragspartnerTitelVorne;
  }

  public void setVertragspartnerTitelVorne(String vertragspartnerTitelVorne) {
    _vertragspartnerTitelVorne = vertragspartnerTitelVorne;
  }
  
  /**
   * Titel hitnen des Vertragspartners der Erstellung.<br>
   * @return Titel hinten
   */
  public String getVertragspartnerTitelHinten() {
    return _vertragspartnerTitelHinten;
  }

  public void setVertragspartnerTitelHinten(String vertragspartnerTitelHinten) {
    _vertragspartnerTitelHinten = vertragspartnerTitelHinten;
  }
  
  /**
   * Drucktitel vorne des Vertragspartners der Erstellung.<br>
   * @return Drucktitel vorne
   */
  public String getVertragspartnerDrucktitelVorne() {
    return _vertragspartnerDrucktitelVorne;
  }

  public void setVertragspartnerDrucktitelVorne(String vertragspartnerDrucktitelVorne) {
    _vertragspartnerDrucktitelVorne = vertragspartnerDrucktitelVorne;
  }
  
  /**
   * Drucktitel hinten des Vertragspartners der Erstellung.<br>
   * @return Drucktitel hinten
   */
  public String getVertragspartnerDrucktitelHinten() {
    return _vertragspartnerDrucktitelHinten;
  }

  public void setVertragspartnerDrucktitelHinten(String vertragspartnerDrucktitelHinten) {
    _vertragspartnerDrucktitelHinten = vertragspartnerDrucktitelHinten;
  }
  
}
