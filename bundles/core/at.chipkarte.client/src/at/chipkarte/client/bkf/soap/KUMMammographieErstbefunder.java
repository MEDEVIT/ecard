package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Ergebnisdaten einer Mammographiebefundung durch den Erstbefunder 
 * der kurativen Mammographie (<i>KurativeMammographieDoku</i>). <br>
 * ParameterID: 0410. 
 */

public class KUMMammographieErstbefunder {

  private String _arztID;
  private String _befundungsZeitstempel;
  private String _dichte;
  private String _ergebnis;

  /**
  * Eindeutiger Bezeichner eines Arztes. <br>
  * Muss unterschiedlich zur <i>ArztID</i> des Zweitbefunders (sofern angegeben) sein. 
  * Muss als zertifizierter Arzt gemeldet sein (siehe Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfArzt(String, String)}).<br>
  * Angabe: Muss. <br>
  * Format: 11-stellig<br>
  * ParameterID: 0411.
  * @return ArztID
  */
  public String getArztID() {
    return _arztID;
  }

  public void setArztID(String arztID) {
    _arztID = arztID;
  }

  /**
   * Zeitstempel der Befundung. <br>
   * Darf nicht mehr als 5 Minuten in der Zukunft liegen. Muss größer oder gleich dem <i>Leistungsdatum</i> bzw. dem 
   * <i>Behandlungsdatum</i> der gewählten Konsultation sein.<br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ hh:mm:ss<br>
   * ParameterID: 0413.
   * @return BefundungsZeitstempel
   */
  public String getBefundungsZeitstempel() {
    return _befundungsZeitstempel;
  }

  public void setBefundungsZeitstempel(String befundungsZeitstempel) {
    _befundungsZeitstempel = befundungsZeitstempel;
  }

  /**
   * Ergebnis Dichte (D-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DichteTypConstant}.<br>
   * ParameterID: 0414.
   * @return Dichte
   */
  public String getDichte() {
    return _dichte;
  }

  public void setDichte(String dichte) {
    _dichte = dichte;
  }

  /**
   * Ergebnis Mammographie (MG-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisMammographieTypConstant}.<br>
   * ParameterID: 0415.
   * @return Ergebnis
   */
  public String getErgebnis() {
    return _ergebnis;
  }

  public void setErgebnis(String ergebnis) {
    _ergebnis = ergebnis;
  }


}