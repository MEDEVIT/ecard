package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet die Eingangsdaten zur Erfassung des Präoperativen Befundes.
 */
public class AnamneseRisikogruppe {
  private String _risikogruppeCode;
  private String[] _risikofaktorCode;
  /**
   * Code der Risikogruppe.<br>
   * Format: 6-stellig
   * @return Code der Risikogruppe
   */
  public String getRisikogruppeCode() {
    return _risikogruppeCode;
  }
  public void setRisikogruppeCode(String risikogruppeCode) {
    _risikogruppeCode = risikogruppeCode;
  }
  /**
   * Codes der Risikofaktoren.<br>
   * Format: Array; jeder Eintrag ist 6-stellig.
   * @return
   */
  public String[] getRisikofaktorCode() {
    return _risikofaktorCode;
  }
  public void setRisikofaktorCode(String[] risikofaktorCode) {
    _risikofaktorCode = risikofaktorCode;
  }

}
