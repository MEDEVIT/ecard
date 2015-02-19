/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält den konkreten Limitstand zu einem Vertrag.
 */
public class LimitValue {
  private Long _value;
  private String _limitCode;

  /**
   * Wert für dieses Limit.
   * <br/>Format: Long (numerisch)
   * @return Limitwert
   */
  public Long getValue() {
    return _value;
  }

  /**
   * Limitcode für dieses Limit. 
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.LimitCode LimitCode}.
   * <br/>Format: 2-stellig
   * @return Limitcode
   */
  public String getLimitCode() {
    return _limitCode;
  }

  public void setLimitCode(String limitCode) {
    _limitCode = limitCode;
  }

  public void setValue(Long value) {
    _value = value;
  }
}
