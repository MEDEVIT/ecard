package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Ergebnisdaten einer Ultraschalluntersuchung 
 * der kurativen Mammographie (<i>KurativeMammographieDoku</i>). <br>
 * Die Angabe eines Ultraschalls ist bei der kurativen Mammographie optional. Wird <i>KUMUltraschall</i> 
 * allerdings angegeben, sind alle Parameter darin verpflichtend anzugeben.<br>
 * ParameterID: 0430. 
 */

public class KUMUltraschall {

  private String _befundungsZeitstempel;
  private String _grund;
  private String _ergebnis;

  /**
   * Zeitstempel der Befundung. <br>
   * Darf nicht mehr als 5 Minuten in der Zukunft liegen. Muss größer oder gleich dem <i>Leistungsdatum</i> bzw. dem 
   * <i>Behandlungsdatum</i> der gewählten Konsultation sein.<br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ hh:mm:ss<br>
   * ParameterID: 0433.
   * @return BefundungsZeitstempel
   */
  public String getBefundungsZeitstempel() {
    return _befundungsZeitstempel;
  }

  public void setBefundungsZeitstempel(String befundungsZeitstempel) {
    _befundungsZeitstempel = befundungsZeitstempel;
  }

  /**
   * Grund der Untersuchung. <br>
   * Angabe: Muss. <br>
   * Prüfung bei {@link at.chipkarte.client.bkf.soap.constants.GrundTypConstant} gleich
   * <ul>
   * <li><b>'1'</b>: Erstbefunderangaben (<i>KUMMammographieErstbefunder</i>) 
   * - der Parameter <i>Dichte</i> (Ergebnis Dichte (D-SCORE)) muss mit '3' 
   * ('D3') oder '4' ('D4') und  der Parameter <i>Ergebnis</i> (Ergebnis Mammographie (MG-SCORE)) mit '1' ('MG1') 
   * oder '2' ('MG2') befüllt sein</li>
   * <li><b>'2'</b>: Erstbefunderangaben (<i>KUMMammographieErstbefunder</i>) 
   * - der Parameter <i>Ergebnis</i> (Ergebnis Mammographie (MG-SCORE)) muss mit '4' ('MG4'),
   * '5' ('MG5') oder '6' ('MG2') befüllt sein</li>
   * <li><b>'3'</b> oder <b>'4'</b>: keine Prüfung</li>
   * <li><b>'5'</b>: Zweitbefunderangaben (<i>KUMMammographieZweitbefunder</i>) 
   * - der Parameter <i>Dichte</i> (Ergebnis Dichte (D-SCORE)) muss mit 3 
   * ('D3') oder 4 ('D4') und  der Parameter <i>Ergebnis</i> (Ergebnis Mammographie (MG-SCORE)) mit '1' ('MG1') 
   * oder '2' ('MG2') befüllt sein</li>
   * <li><b>'6'</b>: Zweitbefunderangaben (<i>KUMMammographieZweitbefunder</i>) muss
   * - der Parameter <i>Ergebnis</i> (Ergebnis Mammographie (MG-SCORE)) 
   * mit '4' ('MG4'), '5' ('MG5') oder '6' ('MG2') befüllt sein</li>
   * <li><b>'7'</b> oder <b>'8'</b>: keine Prüfung</li>
   * </ul>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.GrundTypConstant}.<br>
   * ParameterID: 0434.
   * @return Grund
   */
  public String getGrund() {
    return _grund;
  }

  public void setGrund(String grund) {
    _grund = grund;
  }

  /**
   * Ergebnis Ultraschall (US-SCORE). <br>
   * Angabe: Muss. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.ErgebnisUltraschallTypConstant}.<br>
   * ParameterID: 0435.
   * @return Ergebnis
   */
  public String getErgebnis() {
    return _ergebnis;
  }

  public void setErgebnis(String ergebnis) {
    _ergebnis = ergebnis;
  }

}