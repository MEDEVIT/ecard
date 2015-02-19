/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap;

/**
 * Enthält Daten zu verschiedenen Codewerten, die an der Schnittstelle verwendet werden.
 */
public class BaseProperty {

  private String _code;
  private String _text;
  private Boolean _nurAnzeige = false;

  public BaseProperty() {
  }

  public void setCode(String code) {
    _code = code;
  }

  public void setNurAnzeige(Boolean nurAnzeige) {
    _nurAnzeige = nurAnzeige;
  }

  public void setText(String text) {
    _text = text;
  }

  /**
   * Schlüsselwert (Code, Key) der Property. Dieser dient als Referenz in anderen Funktionen.
   * @return Code der Property
   */
  public String getCode() {
    return _code;
  }

  /**
   * Flag zur Angabe, ob die Property nur angezeigt werden kann (informativ) oder ob sie auch als Inputparameter für Funktionen
   * dienen kann.
   * @return Anzeige-Flag
   */
  public Boolean isNurAnzeige() {
    return _nurAnzeige;
  }

  /**
   * Beschreibender Text der Property. Dieses Attribut kann auch leer sein, in diesem Fall ist nur der <code>Code</code> relevant.
   * @return Text
   */
  public String getText() {
    return _text;
  }

}
