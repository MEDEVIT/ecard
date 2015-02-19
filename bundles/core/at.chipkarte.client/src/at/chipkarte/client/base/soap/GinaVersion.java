/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 * Enthält Informationen zur GINA-Softwareversion und dem GINA-Typ.
 */
public class GinaVersion {
  
  private String _softwareVersion;
  private String _typ;

  /**
   * Aktuelle Softwareversion des Ordinationsclient.
   */
  public String getSoftwareVersion() {
    return _softwareVersion;
  }

  public void setSoftwareVersion(String softwareVersion) {
    _softwareVersion = softwareVersion;
  }

  /**
   * Kennzeichnung des GINA-Typs.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.GinaTyp}.
   */
  public String getTyp() {
    return _typ;
  }

  public void setTyp(String typ) {
    _typ = typ;
  }
  
}
