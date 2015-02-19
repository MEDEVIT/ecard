package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Ergebnisdaten einer Mammographiebefundung durch den Erstbefunder 
 * der <i>ScreeningDoku</i>. <br>
 * ParameterID: 0110.
 */

public class SCRMammographieErstbefunder {

  private String _arztID;
  private String _befundungsZeitstempel;
  private String _dichte;
  private String _ergebnis;

  /**
  * Eindeutiger Bezeichner eines Arztes. <br>
  * Muss als zertifizierter Arzt mit der Zertifikatsart '0' gemeldet sein 
  * (siehe Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfArzt(String, String)}).<br>
  * Muss unterschiedlich zur <i>ArztID</i> des Zweitbefunders sein. 
  * Angabe: Muss.<br>
  * Format: 11-stellig<br>
  * ParameterID: 0111.
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
   * Format: TT.MM.JJJJ hh:mm:ss <br>
   * ParameterID: 0113.
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
   * ParameterID: 0114.
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
   * ParameterID: 0115.
   * @return Ergebnis
   */
  public String getErgebnis() {
    return _ergebnis;
  }

  public void setErgebnis(String ergebnis) {
    _ergebnis = ergebnis;
  }


}