package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet Informationen zu der Gruppe selbst (Anzeigetext und Codewert) sowie die Risikogruppen.
 */
public class AnamneseGruppe {
  private String _anamneseGruppeText;
  private String _anamneseGruppeCode;
  private RisikoGruppe[] _risikoGruppe;

  /**
   * Textuelle Beschreibung der Anamnesegruppe.<br>
   * Format: 150-stellig.
   * @return Beschreibung der Anamnesegruppe
   */
  public String getAnamneseGruppeText() {
    return _anamneseGruppeText;
  }
  public void setAnamneseGruppeText(String anamneseGruppeText) {
    _anamneseGruppeText = anamneseGruppeText;
  }
  /**
   * Code der Anamnesegruppe.<br>
   * Format: 6-stellig.
   * @return Code der Anamnesegruppe.
   */
  public String getAnamneseGruppeCode() {
    return _anamneseGruppeCode;
  }
  public void setAnamneseGruppeCode(String anamneseGruppeCode) {
    _anamneseGruppeCode = anamneseGruppeCode;
  }
  /**
   * Zu der Anamnesegruppe gehörige {@link RisikoGruppe Risikogruppen}.
   * @return
   */
  public RisikoGruppe[] getRisikoGruppe() {
    return _risikoGruppe;
  }
  public void setRisikoGruppe(RisikoGruppe[] risikoGruppe) {
    _risikoGruppe = risikoGruppe;
  }
}
