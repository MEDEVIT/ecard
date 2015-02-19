package at.chipkarte.client.prop.soap;

import at.chipkarte.client.prop.soap.constants.Bedingung;

/**
 * Beinhaltet Informationen zu der Gruppe selbst (Anzeigetext und Codewert), 
 * die Angabebedingung der Risikofaktoren innerhalb der Risikogruppe, sowie die Risikofaktoren selbst.
 */
public class RisikoGruppe {
  private String _risikoGruppeText;
  private String _risikoGruppeCode;
  private String _risikoGruppeBedingung;
  private RisikoFaktor[] _risikoFaktor;
  /**
   * Textuelle Beschreibung der Risikogruppe.<br>
   * Format: max. 150-stellig
   * @return Beschreibung der Risikogruppe
   */
  public String getRisikoGruppeText() {
    return _risikoGruppeText;
  }
  public void setRisikoGruppeText(String risikoGruppeText) {
    _risikoGruppeText = risikoGruppeText;
  }
  /**
   * Code der Risikogruppe.<br>
   * Format: 6-stellig
   * @return Code der Risikogruppe
   */
  public String getRisikoGruppeCode() {
    return _risikoGruppeCode;
  }
  public void setRisikoGruppeCode(String risikoGruppeCode) {
    _risikoGruppeCode = risikoGruppeCode;
  }
  /**
   * Anweisung für die Auswahl von Risikofaktoren zu dieser Risikogruppe.<br>
   * Format: 1-stellig<br>
   * Die möglichen Werte sind in der Konstante {@link Bedingung} definiert.
   * <table border="1" cellpadding="3">
   *    <tr><td>Konstantenname</td><td>Wert</td><td>Beschreibung</td></tr>
   *    <tr><td> {@link Bedingung#GENAU_EIN}</td><td> "0"</td><td>Es muss genau ein Risikofaktor gewählt werden.</td></tr>
   *    <tr><td> {@link Bedingung#KEIN_ODER_MEHRERE}</td><td>"1"</td><td>Es können beliebig viele Risikofaktoren gewählt werden.</td></tr>
   *    <tr><td> {@link Bedingung#MINDESTENS_EIN}</td><td>"2"</td><td>Es muss mindestens ein Risikofaktor gewählt werden.</td></tr>
   *    <tr><td> {@link Bedingung#KEIN_ODER_EIN}</td><td>"3"</td><td>Es darf höchstens ein Risikofaktor gewählt werden</td></tr>
   * </table>
   * @return Anweisung für die Auswahl von Risikofaktoren
   */
  public String getRisikoGruppeBedingung() {
    return _risikoGruppeBedingung;
  }
  public void setRisikoGruppeBedingung(String risikoGruppeBedingung) {
    _risikoGruppeBedingung = risikoGruppeBedingung;
  }
  /**
   * Die zu dieser Risikogruppe gehörenden {@link RisikoFaktor Risikofaktoren}.<br>
   * @return Risikofaktoren
   */
  public RisikoFaktor[] getRisikoFaktor() {
    return _risikoFaktor;
  }
  public void setRisikoFaktor(RisikoFaktor[] risikoFaktor) {
    _risikoFaktor = risikoFaktor;
  }
  
}
