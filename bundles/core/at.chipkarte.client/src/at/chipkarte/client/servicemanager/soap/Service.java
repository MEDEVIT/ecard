/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.servicemanager.soap;

/**
 * Enthält die Informationen zu einem Service des Ordinationsclient.
 */
public class Service {
  
  private String _description;
  private String _endPointURL;
  private String _name;
  private String _type;
  private String _version;

  /**
   * @return URL des Endpoints für diesen Service <br>
   *         Format: maximal 100-stellig
   */
  public String getEndPointURL() {
    return _endPointURL;
  }

  /**
   * @return Name des Service (mögliche Werte : {@link at.chipkarte.client.soap.constants.ServiceName ServiceName}) <br>
   *         Format: maximal 10-stellig
   */
  public String getName() {
    return _name;
  }

  /**
   * @return Beschreibung des Service <br>
   *         Format: maximal 150-stellig
   */
  public String getDescription() {
    return _description;
  }

  /**
   * @return Version des Service <br>
   *         Format: maximal 10-stellig
   */
  public String getVersion() {
    return _version;
  }

  /**
   * @return Deployment Typ des Service der das SOAP Format (Style und Use) definiert (mögliche Werte :
   *         {@link at.chipkarte.client.soap.constants.ServiceType ServiceType}) <br>
   *         Format: maximal 25-stellig
   */
  public String getType() {
    return _type;
  }

  public void setDescription(String description) {
    _description = description;
  }

  public void setEndPointURL(String endPointURL) {
    _endPointURL = endPointURL;
  }

  public void setName(String name) {
    _name = name;
  }

  public void setType(String type) {
    _type = type;
  }

  public void setVersion(String version) {
    _version = version;
  }
  
}
