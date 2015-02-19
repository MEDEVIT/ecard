/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap;

/**
 * Enthält die Suchkriterien für eine Abfrage der stichtagsaktuellen Versichertendaten für einen Patienten.
 */
public class VersichertendatenAbfragePerStichtag extends VersichertendatenAbfrage {
  private String _stichtagsdatum;

  /**
   * Datum, zu dem die Versichertendaten ermittelt werden sollen. Muss in der Vergangenheit liegen (kleiner dem aktuellen Tag).<br>
   * Format: 10-stellig, TT.MM.JJJJ
   * @return Stichtagsdatum
   */
  public String getStichtagsdatum() {
    return _stichtagsdatum;
  }

  public void setStichtagsdatum(String stichtagsdatum) {
    _stichtagsdatum = stichtagsdatum;
  }
}
