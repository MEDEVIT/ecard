/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.base.soap;


/**
 * Enthält Informationen des Softwareprodukts, das diese Schnittstelle implementiert.
 * 
 */
public class ProduktInfo {

  private Integer _produktId = 0;
  private String _produktVersion = null;
  
 
  /**
   * 
   * Produkt-Id des Softwareprodukts, das diese Schnittstelle implementiert. 
   * <br>Die Id wird vom Hauptverband der österreichischen Sozialversicherungsträger (HVB) vergeben.
   * <br>Format: 6-stellig
   * @return Produkt-Id
   */
  public Integer getProduktId() {
    return _produktId;
  }
  
  /**
   * 
   * Versionsinformation des Softwareprodukts, das diese Schnittstelle implementiert.
   * <br>Format: max. 20-stellig
   * @return Produkt-Version
   */
  public String getProduktVersion() {
    return _produktVersion;
  }
  public void setProduktId(Integer produktId) {
    this._produktId = produktId;
  }
  public void setProduktVersion(String produktVersion) {
    this._produktVersion = produktVersion;
  }
}
