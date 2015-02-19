/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 *  Enthält den Inhalt einer Nachricht.
 */
public class Message {

  private String _id = null;
  private String _text = null;
  private String _category = null;
  private String _appid = null;
  private String _data = null;
  private String _timestamp = null;

  /**
   * ID des Message-erzeugenden Service. Mögliche Werte siehe {@link at.chipkarte.client.soap.constants.ServiceName ServiceName}.
   * <br>Format: maximal 4-stellig
   * @return Applikations-Id
   */
  public String getAppid() {
    return _appid;
  }

  public void setAppid(String appid) {
    this._appid = appid;
  }

  /** 
   * Kategorie der Message. Dieser Wert legt fest, von welchem Typ diese Message ist. 
   * <p>Format: maximal 16-stellig</p>
   * Mögliche Werte:<br>
   * <table border="1" cellspacing="0">
   * <tr style="font-weight:bold">
   *   <td>appid</td><td>Kategorie</td><td>Bedeutung</td>
   * </tr>
   * <tr>
   *   <td>abs</td>
   *   <td>RUECKANTWORT</td>
   *   <td>Es ist eine Rückantwort zu einer gesendeten Bewilligungsanfrage vorhanden.</td>
   * </tr>
   * <tr>
   *   <td>kse</td>
   *   <td>ZS_KSE_MSG_ASYDL</td>
   *   <td>Am e-card-Serversystem liegen Konsultationsdaten zum Abholen bereit.
   *      Welche Anfragen bereit stehen, ist über die Funktion 
   *       {@link at.chipkarte.client.kse.soap.IKseService#getKonsultationsdatenAnfragen getKonsultationsdatenAnfragen} zu erfragen.
   *   </td>
   * </tr>
   * <tr>
   *   <td>base</td>
   *   <td>SW_UPDATE_SCHED</td>
   *   <td>Information, dass ein Software-Update bevor steht</td>
   * </tr> 
   * <tr>
   *   <td>opc</td>
   *   <td>&nbsp;</td>
   *   <td><i>Für <code>opc</code> gibt es keine vordefinierten Kategorien! <br>
   *       Die Meldung wurde vom Operator des e-card-Serversystems gesendet.</i></td>
   * </tr> 
   *   
   * </table> 
   * @return Kategorie
   * 
   */
  public String getCategory() {
    return _category;
  }

  public void setCategory(String category) {
    this._category = category;
  }

  /** 
   * Eindeutiger Bezeichner für die Message.
   * <br>Format: maximal 19-stellig
   * @return Id
   */
  public String getId() {
    return _id;
  }

  public void setId(String id) {
    this._id = id;
  }

  /** 
   * Datenfeld (Betreff-Feld) für das jeweilige Service mit beliebigem Inhalt. 
   * Der Inhalt dieses Feldes ist in <i>MessageCategory</i> des jeweiligen Service definiert.
   * @return Daten
   */
  public String getData() {
    return _data;
  }

  public void setData(String data) {
    this._data = data;
  }

  /** 
   * Text der Message.
   * <br>Format: maximal 4000-stellig
   * @return Text
   */
  public String getText() {
    return _text;
  }

  public void setText(String text) {
    this._text = text;
  }

  /**
   * Zeitstempel, ab dem die Message gültig ist.
   * <br>Format: TT.MM.JJJJ hh:mm
   * @return Zeitstempel
   */
  public String getTimestamp() {
    return _timestamp;
  }

  public void setTimestamp(String timestamp) {
    this._timestamp = timestamp;
  }
}
