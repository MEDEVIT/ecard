package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Ergebnisdaten einer Mammographiebefundung durch den Zweitbefunder 
 * der kurativen Mammographie (<i>KurativeMammographieDoku</i>). <br>
 * Die Angabe eines Zweitbefundes ist bei der kurativen Mammographie optional. Wird <i>KUMMammographieZweitbefunder</i> 
 * allerdings angegeben, sind alle Parameter darin verpflichtend anzugeben.<br>
 * ParameterID: 0450. 
 */

public class KUMMammographieZweitbefunder {

  private String _arztID;
  private String _befundungsZeitstempel;
  private String _dichte;
  private String _ergebnis;


  /**
  * Eindeutiger Bezeichner eines Arztes. <br>
  * Muss unterschiedlich zur <i>ArztID</i> des Erstbefunders sein. 
  * Muss als zertifizierter Arzt gemeldet sein (siehe Funktion {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfArzt(String, String)}).<br>
  * Angabe: Muss. <br>
  * Format: 11-stellig <br>
  * ParameterID: 0451.
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
   * ParameterID: 0453.
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
   * ParameterID: 0454.
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
   * ParameterID: 0455.
   * @return Ergebnis
   */
  public String getErgebnis() {
    return _ergebnis;
  }

  public void setErgebnis(String ergebnis) {
    _ergebnis = ergebnis;
  }
}