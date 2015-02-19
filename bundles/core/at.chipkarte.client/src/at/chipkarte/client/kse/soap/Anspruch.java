/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Daten für einen eigenen Anspruch beziehungsweise für einen abgeleiteten Anspruch, siehe
 * {@link at.chipkarte.client.kse.soap.exceptions.KseException AnspruchException}.
 */

public class Anspruch {

  private String _id;
  private String _svtCode;
  private String _abgeleitetVorname;
  private String _abgeleitetNachname;
  private String _abgeleitetTitelVorne;
  private String _abgeleitetTitelHinten;
  private String _abgeleitetDruckVorname;
  private String _abgeleitetDruckNachname;
  private String _abgeleitetDruckTitelVorne;
  private String _abgeleitetDruckTitelHinten;
  private String _ablSvNummer;

  /**
   * Sozialversicherungsnummer des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAblSvNummer() {
    return _ablSvNummer;
  }

  /**
   * Titel hinten des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 30-stellig
   * @return Titel hinten des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetTitelHinten() {
    return _abgeleitetTitelHinten;
  }

  /**
   * Titel vorne des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 30-stellig
   * @return Titel vorne des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetTitelVorne() {
    return _abgeleitetTitelVorne;
  }

  /**
   * Vorname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Vorname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetVorname() {
    return _abgeleitetVorname;
  }

  /**
   * Nachname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Nachname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetNachname() {
    return _abgeleitetNachname;
  }

  /**
   * Drucktitel hinten des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 30-stellig
   * @return Drucktitel hinten des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetDruckTitelHinten() {
    return _abgeleitetDruckTitelHinten;
  }

  /**
   * Drucktitel vorne des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 30-stellig
   * @return Drucktitel vorne des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetDruckTitelVorne() {
    return _abgeleitetDruckTitelVorne;
  }

  /**
   * Druckvorname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Druckvorname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetDruckVorname() {
    return _abgeleitetDruckVorname;
  }

  /**
   * Drucknachname des Versicherten (Person von der der Anspruch abgeleitet ist). 
   * <br/>Format: maximal 70-stellig
   * @return Drucknachname des Versicherten (Person von der der Anspruch abgeleitet ist).
   */
  public String getAbgeleitetDruckNachname() {
    return _abgeleitetDruckNachname;
  }

  /**
   * ID des Anspruchs (eigener oder abgeleiteter, dient zur Referenzierung dieses Anspruchs in anderen Funktionen). 
   * <br/>Format: maximal 19-stellig
   * @return ID.
   */
  public String getId() {
    return _id;
  }

  /**
   * Für den (eigenen oder abgeleiteten) Anspruch zuständiger Krankenversicherungsträger. 
   * <br/>Mögliche Werte siehe Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs} 
   * <br/>Format: 2-stellig
   * @return KVT-Code.
   */
  public String getSvtCode() {
    return _svtCode;
  }

  public void setAbgeleitetNachname(String abgeleitetNachname) {
    _abgeleitetNachname = abgeleitetNachname;
  }

  public void setAbgeleitetTitelHinten(String abgeleitetTitelHinten) {
    _abgeleitetTitelHinten = abgeleitetTitelHinten;
  }

  public void setAbgeleitetTitelVorne(String abgeleitetTitelVorne) {
    _abgeleitetTitelVorne = abgeleitetTitelVorne;
  }

  public void setAbgeleitetVorname(String abgeleitetVorname) {
    _abgeleitetVorname = abgeleitetVorname;
  }

  public void setAbgeleitetDruckNachname(String abgeleitetDruckNachname) {
    _abgeleitetDruckNachname = abgeleitetDruckNachname;
  }

  public void setAbgeleitetDruckTitelHinten(String abgeleitetDruckTitelHinten) {
    _abgeleitetDruckTitelHinten = abgeleitetDruckTitelHinten;
  }

  public void setAbgeleitetDruckTitelVorne(String abgeleitetDruckTitelVorne) {
    _abgeleitetDruckTitelVorne = abgeleitetDruckTitelVorne;
  }

  public void setAbgeleitetDruckVorname(String abgeleitetDruckVorname) {
    _abgeleitetDruckVorname = abgeleitetDruckVorname;
  }

  public void setAblSvNummer(String ablSvNummer) {
    _ablSvNummer = ablSvNummer;
  }

  public void setId(String id) {
    _id = id;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
}
