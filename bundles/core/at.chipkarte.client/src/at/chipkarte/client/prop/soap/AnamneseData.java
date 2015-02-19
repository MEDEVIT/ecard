package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet die Eingangsdaten zur Erfassung des Präoperativen Befundes.
 */
public class AnamneseData {
  private AnamneseRisikogruppe[] _anamneseRisikogruppen;
  private Integer _version;

  /**
   * Anamnese-Risikogruppen.<br>
   * @return Anamnese-Risikogruppen
   * @see AnamneseRisikogruppe
   */
  public AnamneseRisikogruppe[] getAnamneseRisikogruppen() {
    return _anamneseRisikogruppen;
  }
  public void setAnamneseRisikogruppen(AnamneseRisikogruppe[] ananmeseRisikogruppen) {
    _anamneseRisikogruppen = ananmeseRisikogruppen;
  }
  /**
   * Version der Fachinformation.<br>
   * Format: max. 3-stellig
   * @return Version
   */
  public Integer getVersion() {
    return _version;
  }
  public void setVersion(Integer version) {
    _version = version;
  }
}
