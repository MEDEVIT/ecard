/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 * Enthält Key und Value einer Property.
 */
public class Property {

  public void setKey(String key) {
    _key = key;
  }

  public void setValue(String value) {
    _value = value;
  }

  private String _key = "";
  private String _value = "";


  /**
   * Key (Schlüssel) der jeweiligen Property, dient dazu die Property in weiterer Folge zu
   * identifizieren.
   * 
   * @return Key
   */

  public String getKey() {
    return _key;
  }

  /**
   * Wert der jeweiligen Property.
   * @return Value
   */

  public String getValue() {
    return _value;
  }

}