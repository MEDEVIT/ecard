/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 * Enthält GINA-Informationen.
 */
public class GinaInfo {
  private String _dnsName;
  private String _ipAdresse;
  private String _produktVersion;
  
  /**
   * DNS-Name der GINA.
   * <br>Format: maximal 55-stellig
   * @return DNS-Name 
   */
  public String getDnsName() {
    return _dnsName;
  }
  public void setDnsName(String dnsName) {
    _dnsName = dnsName;
  }
  
  /**
   * IP-Adresse der GINA.
   * <br>Format: maximal 15-stellig
   * @return IP-Adresse 
   */
  public String getIpAdresse() {
    return _ipAdresse;
  }
  public void setIpAdresse(String ipAdresse) {
    _ipAdresse = ipAdresse;
  }
  
  /**
   * Versionsinformation des Softwareprodukts, das diese Schnittstelle implementiert.
   * <br>Format: maximal 20-stellig
   * @return Produkt-Version 
   */
  public String getProduktVersion() {
    return _produktVersion;
  }
  public void setProduktVersion(String produktVersion) {
    _produktVersion = produktVersion;
  }
  
}
