/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 * Enthält Statusinformationen und gegebenenfalls Hinweise für ein Service.
 */
public class ServiceStatusInformation {

  private String _serviceName;
  private Boolean _modus;
  private String _modusText;
  private String _hinweisAktion;
  private String _hinweisZusatz;
  
  /**
   * Hinweistext zur Aktion, die der Benutzer setzen soll, wenn der Verbindungsmodus "OFFLINE" ist.
   * <br>Format: maximal 256-stellig
   * @return Aktion-Hinweistext 
   */
  public String getHinweisAktion() {
    return _hinweisAktion;
  }
  public void setHinweisAktion(String hinweisAktion) {
    _hinweisAktion = hinweisAktion;
  }
  
  /**
   * Hinweistext zur Abrechnungsgarantie im Falle des KSE-Service und Verbindungsmodus "OFFLINE".
   * <br>Format: maximal 256-stellig
   * @return Abrechnungsgarantie-Hinweistext 
   */
  public String getHinweisZusatz() {
    return _hinweisZusatz;
  }
  public void setHinweisZusatz(String hinweisZusatz) {
    _hinweisZusatz = hinweisZusatz;
  }
  
  /**
   * Flag zur Kennzeichnung, ob das Service online oder offline ist.
   * @return Online-Kennzeichen
   */
  public Boolean isModus() {
    return _modus;
  }
  public void setModus(Boolean modus) {
    _modus = modus;
  }
  
  /**
   * Modus in Textform (Zum Beispiel: ONLINE, OFFLINE).
   * <br>Format: maximal 10-stellig
   * @return Modus in Textform
   */
  public String getModusText() {
    return _modusText;
  }
  public void setModusText(String modusText) {
    _modusText = modusText;
  }
  
  /**
   * Name des Service in der Form <'Langtext'> (<'Abkürzung'>).
   * <br>Format: maximal 40-stellig
   * @return Service-Name 
   */
  public String getServiceName() {
    return _serviceName;
  }
  public void setServiceName(String serviceName) {
    _serviceName = serviceName;
  }
} 
