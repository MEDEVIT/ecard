/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Daten zu einer asynchronen Konsultationsanfrage.
 */
public class KonsultationdatenAnfrage {
  private String _timestamp;
  private SuchFilter _filter;
  private Integer _status;
  private String _anfrageId;

  /**
   * ID der ursprünglichen Anfrage.
   * <br/>Format: maximal 19-stellig
   * @return Anfrage-ID
   */
  public String getAnfrageId() {
    return _anfrageId;
  }

  public void setAnfrageId(String anfrageId) {
    _anfrageId = anfrageId;
  }

  /**
   * Suchkriterien der Anfrage.
   * @return SuchFilter
   */
  public SuchFilter getFilter() {
    return _filter;
  }

  public void setFilter(SuchFilter filter) {
    _filter = filter;
  }

  /**
   * Status der Anfrage (mögliche Werte: {@link at.chipkarte.client.kse.soap.constants.AnfrageStatus AnfrageStatus}).
   * <br/>Format: 1-stellig
   * @return Status
   */
  public Integer getStatus() {
    return _status;
  }

  public void setStatus(Integer status) {
    _status = status;
  }

  /**
   * Zeitpunkt, zu dem die Anfrage erstellt wurde.
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Zeitstempel
   */
  public String getTimestamp() {
    return _timestamp;
  }

  public void setTimestamp(String timestamp) {
    _timestamp = timestamp;
  }
}
