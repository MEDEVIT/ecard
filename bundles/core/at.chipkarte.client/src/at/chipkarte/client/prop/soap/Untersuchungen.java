package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet Informationen zu den Untersuchungen (Anzeigetext und Codewert).
 */
public class Untersuchungen {
  private String _untersuchungsText;
  private String untersuchungCode;
  /**
   * Textuelle Beschreibung der Untersuchungen.<br>
   * Format: max. 150-stellig
   * @return Beschreibung der Untersuchungen
   */
  public String getUntersuchungsText() {
    return _untersuchungsText;
  }
  public void setUntersuchungsText(String untersuchungsText) {
    _untersuchungsText = untersuchungsText;
  }
  /**
   * Code der Untersuchungen.<br>
   * Format: 6-stellig
   * @return Code der Untersuchungen.
   */
  public String getUntersuchungCode() {
    return untersuchungCode;
  }
  public void setUntersuchungCode(String untersuchungCode) {
    this.untersuchungCode = untersuchungCode;
  }

}
