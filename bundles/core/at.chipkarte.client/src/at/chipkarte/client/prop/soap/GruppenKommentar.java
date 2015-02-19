package at.chipkarte.client.prop.soap;

public class GruppenKommentar {

  private String _code;
  
  private String _text;

  /**
   * Code der Untersuchungsgruppe zu der der Kommentar gehört.<br>
   * Format: 6-stellig.
   * @return Code
   */
  public String getCode() {
    return _code;
  }

  public void setCode(String code) {
    _code = code;
  }

  /**
   * Kommentartext.<br>
   * Format: max. 500-stellig.
   * @return Text
   */
  public String getText() {
    return _text;
  }

  public void setText(String text) {
    _text = text;
  }
}
