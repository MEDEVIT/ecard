package at.chipkarte.client.prop.soap;
/**
 * Beinhaltet Informationen zu einem Risikofaktor.
 */
public class RisikoFaktor {
  private String _risikoFaktorText;
  private String _risikoFaktorCode;
  /**
   * Textuelle Beschreibung des Risikofaktors.<br>
   * Format: max. 150-stellig
   * @return Beschreibung des Risikofaktors.
   */
  public String getRisikoFaktorText() {
    return _risikoFaktorText;
  }
  public void setRisikoFaktorText(String risikoFaktorText) {
    _risikoFaktorText = risikoFaktorText;
  }
  /**
   * Code des Risikofaktors.<br>
   * Format: 6-stellig
   * @return Risikofaktorcode
   */
  public String getRisikoFaktorCode() {
    return _risikoFaktorCode;
  }
  public void setRisikoFaktorCode(String risikoFaktorCode) {
    _risikoFaktorCode = risikoFaktorCode;
  }

}
