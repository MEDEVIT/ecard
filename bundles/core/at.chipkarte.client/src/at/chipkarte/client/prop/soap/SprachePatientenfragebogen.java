package at.chipkarte.client.prop.soap;
/**
 * Beinhaltet Informationen zu einer Sprache (Anzeigetext und Codewert),
 * in der der Patientenfragebogen zur Verfügung steht.
 */
public class SprachePatientenfragebogen {
  private String _spracheText;
  private String _spracheCode;
  /**
   * Textuelle Beschreibung der Sprache.<br>
   * Format: max. 150-stellig
   * @return Beschreibung der Sprache
   */
  public String getSpracheText() {
    return _spracheText;
  }
  public void setSpracheText(String spracheText) {
    _spracheText = spracheText;
  }
  /**
   * Code der Sprache.<br>
   * Format: 6-stellig
   * @return Code der Sprache
   */
  public String getSpracheCode() {
    return _spracheCode;
  }
  public void setSpracheCode(String spracheCode) {
    _spracheCode = spracheCode;
  }
}
