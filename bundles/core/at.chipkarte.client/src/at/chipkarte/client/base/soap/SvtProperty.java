/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap;

/**
 * Enthält über {@link BaseProperty BaseProperty} hinausgehende Daten für einen
 * Krankenversicherungsträger.
 */
public class SvtProperty extends BaseProperty {

  private String  _kurzbezeichnung;
  private String  _eKVKCode;
  private String  _eKVKName;
  private Boolean _aSVG;

  /**
   * EKVK-Name des KVT.
   * <br>Format: maximal 15-stellig
   * @return EKVK-Name
   */
  public String getEKVKName() {
    return _eKVKName;
  }

  /**
   * EKVK-Code des KVT.
   * <br>Format: maximal 10-stellig
   * @return EKVK-Code
   *  
   */
  public String getEKVKCode() {
    return _eKVKCode;
  }

  /**
   * Kurzbezeichnung des Krankenversicherungsträgers.
   * <br>Format: maximal 15-stellig
   * @return Kurzbezeichnung
   */
  public String getKurzbezeichnung() {
    return _kurzbezeichnung;
  }

  public void setEKVKCode(String code) {
    _eKVKCode = code;
  }

  public void setEKVKName(String name) {
    _eKVKName = name;
  }

  public void setKurzbezeichnung(String kurzbezeichnung) {
    this._kurzbezeichnung = kurzbezeichnung;
  }

  /**
   * 
   * Kennzeichen, ob es sich um einen GKK/BKK-Träger handelt.
   * @return Kennzeichen für GKK/BKK
   */
  public Boolean isASVG() {
    return this._aSVG;
  }

  public void setASVG(Boolean asvg) {
    this._aSVG = asvg;
  }

}