/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Daten zu den Limits eines Vertragspartners bezogen auf einen Bezugsbereich, auf ein Fachgebiet und einen
 * Krankenversicherungsträger.
 */

public class Limit {

  private String _fachgebietsCode;
  private String _svtCode;
  private LimitValue[] _limitValue;
  private LimitKonfig[] _limitConfig;

  public void setFachgebietsCode(String fachgebietCode) {
    _fachgebietsCode = fachgebietCode;
  }

  public void setLimitConfig(LimitKonfig[] limitConfig) {
    _limitConfig = limitConfig;
  }

  public void setLimitValue(LimitValue[] limitValues) {
    _limitValue = limitValues;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  /**
   * Fachgebietscode, für das das Limit gilt, siehe Funktion {@link #getFachgebietsCode() getFachgebietsCode}.
   * <br/>Format: 2-stellig
   * @return Fachgebietscode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  /**
   * Krankenversicherungsträger, der aufgrund der Vertragslage des Vertragspartners dieses Limit vorgegeben hat, siehe Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}.
   * <br/>Format:  2-stellig
   * @return KVT-Code
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Konkreter Limitstand pro Vertrag.
   * @return Limitstand
   */
  public LimitValue[] getLimitValue() {
    return _limitValue;
  }

  /**
   * Limitkonfigurationen für den Vertragspartner.
   * @return Limitkonfiguration
   */

  public LimitKonfig[] getLimitConfig() {
    return _limitConfig;
  }

}
