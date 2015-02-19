/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap;

/**
 * Enthält das Ergebnis einer positiv durchgeführten Versichertendatenabfrage.
 */
public class VersichertendatenAbfrageErgebnis {
  private VersichertendatenSvPerson _versichertenDaten;
  private Integer[] _vdasMessageCodes;
  private Anspruchsdaten[] _anspruchsDaten;

  /**
   * Daten zum Patienten, von dem die Versichertendaten abgefragt wurden.<br>
   * @return Versichertendaten
   */
  public VersichertendatenSvPerson getVersichertenDaten() {
    return _versichertenDaten;
  }

  /**
   * Zusätzliche Informationen im Falle einer positiv durchgeführten Versichertendatenabfrage.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.vdas.soap.constants.VdasMessage}
   * @return Zusatzinformation
   */
  public Integer[] getVdasMessageCodes() {
    return _vdasMessageCodes;
  }

  /**
   * Liste aller Ansprüche (eigene beziehungsweise abgeleitete) eines Patienten. 
   * Bei Eindeutigkeit der abgefragten Versichertendaten enthält
   * die Liste genau ein Element.
   * @return Anspruchsdaten
   */
  public Anspruchsdaten[] getAnspruchsDaten() {
    return _anspruchsDaten;
  }

  public void setVersichertenDaten(VersichertendatenSvPerson versichertenDaten) {
    _versichertenDaten = versichertenDaten;
  }

  public void setVdasMessageCodes(Integer[] vdasMessageCodes) {
    _vdasMessageCodes = vdasMessageCodes;
  }

  public void setAnspruchsDaten(Anspruchsdaten[] anspruchsDaten) {
    _anspruchsDaten = anspruchsDaten;
  }
}
