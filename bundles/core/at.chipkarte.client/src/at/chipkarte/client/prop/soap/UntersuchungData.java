package at.chipkarte.client.prop.soap;
/**
 * Beinhaltet die Untersuchungsgruppe und alle zugehörigen ermittelten Untersuchungen der Gruppe.
 */
public class UntersuchungData {
  private String _untersuchungGruppeText;
  private String untersuchungGruppeCode;
  private Untersuchungen[] _untersuchung;
  /**
   * Textuelle Beschreibung der Untersuchungsgruppe.<br>
   * Format: max. 150-stellig
   * @return Beschreibung der Untersuchungsgruppe
   */
  public String getUntersuchungGruppeText() {
    return _untersuchungGruppeText;
  }
  public void setUntersuchungGruppeText(String untersuchungGruppeText) {
    _untersuchungGruppeText = untersuchungGruppeText;
  }
  /**
   * Code der Untersuchungsgruppe.<br>
   * Format: 6-stellig
   * @return Code der Untersuchungsgruppe
   */
  public String getUntersuchungGruppeCode() {
    return untersuchungGruppeCode;
  }
  public void setUntersuchungGruppeCode(String untersuchungGruppeCode) {
    this.untersuchungGruppeCode = untersuchungGruppeCode;
  }
  /**
   * Die zu dieser Untersuchungsgruppe gehörenden {@link Untersuchungen}.
   * @return Untersuchungen
   */
  public Untersuchungen[] getUntersuchung() {
    return _untersuchung;
  }
  public void setUntersuchung(Untersuchungen[] untersuchung) {
    _untersuchung = untersuchung;
  }


}
