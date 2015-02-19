/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die am Server konfigurierten Limitwerte für den konkreten Vertrag des Vertragspartners.
 */
public class LimitKonfig {
  private String  _limitType;
  private String  _valueType;
  private String  _limitCode;
  private Integer _limitValue;
  private Integer _limitValuePercent;
  private String  _datumVon;
  private String  _datumBis;

  /**
   * Datum, ab dem das Limit gilt.
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return "Gültig ab" Datum des Limits
   */
  public String getDatumVon() {
    return _datumVon;
  }

  /**
   * Datum, bis zu dem das Limit gilt.
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return "Gültig bis" Datum des Limits
   */
  public String getDatumBis() {
    return _datumBis;
  }

  /**
   * Angabe, ob es sich um ein Limit für Offlinekonsultationen oder für Konsultationen ohne e-card handelt.
   * <br/>Mögliche Werte: {@link at.chipkarte.client.kse.soap.constants.LimitCode Limitcodes}.
   * <br/>Format: 2-stellig
   * @return Limitcode
   */

  public String getLimitCode() {
    return _limitCode;
  }

  /**
   * Limittyp zur Unterscheidung zwischen personenbezogenem und allgemeinem Limit.
   * <br/>Mögliche Werte siehe
   * {@link at.chipkarte.client.kse.soap.constants.LimitType LimitType}.
   * <br/>Format: 2-stellig
   * @return Limittyp
   */

  public String getLimitType() {
    return _limitType;
  }

  /**
   * Im Regelwerk angegebener Limitwert.
   * <br/>Wenn das prozentuelle Limit (siehe ValueType) angegeben ist, dann enthält das Feld den
   * berechneten prozentuellen Wert, ansonsten den konkreten (absoluten) Limitwert.
   * <br/>Format: Integer (numerisch)
   * @return Limitwert
   */
  public Integer getLimitValue() {
    return _limitValue;
  }

  /**
   * Kennzeichen, ob es sich um ein prozentuelles oder absolutes Limit handelt, siehe Feld <code>LimitValue</code>.
   * <br/>Format: 1-stellig
   * <br/>Mögliche Werte:
   * <ul>
   * <li>A...Absoluter Wert</li>
   * <li>P...Prozentueller Wert</li>
   * </ul>
   * @return Typ des Limitwertes. 
   */
  public String getValueType() {
    return _valueType;
  }

  /**
   * Prozentuelles Limit aus dem Regelwerk.
   * <ul>
   * <li>Wenn ValueType "P" ist, dann enthält das Feld 
   * den prozentuellen Wert (0..100) für das Limit aus dem Regelwerk.</li>
   * <li>Wenn ValueType "A" ist, dann enthält das Feld den Wert -1.</li>
   * </ul>
   * @return Prozentueller Limitwert<br>
   *         
   */
  public Integer getLimitValuePercent() {
    return _limitValuePercent;
  }

  public void setDatumVon(String datumVon) {
    _datumVon = datumVon;
  }

  public void setDatumBis(String datumBis) {
    _datumBis = datumBis;
  }

  public void setLimitCode(String code) {
    _limitCode = code;
  }

  public void setLimitType(String type) {
    _limitType = type;
  }

  public void setLimitValue(Integer value) {
    _limitValue = value;
  }

  public void setLimitValuePercent(Integer valuePercent) {
    _limitValuePercent = valuePercent;
  }

  public void setValueType(String type) {
    _valueType = type;
  }

}
