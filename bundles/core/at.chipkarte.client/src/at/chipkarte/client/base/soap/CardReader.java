/*
 * S?liche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * sterreichischen Sozialversicherungstr?r. 
 * Insbesondere ist die Ver?erung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap;

/**
 * 
 * Enthält Informationen zu einen Kartenleser.
 */
public class CardReader {

  private String _name;
  private String _id;

  public CardReader() {
    _id = "";
    _name = "";
  }

  /**
   * Konfigurierte Bezeichnung ("friendly-name") des Kartenlesers.
   * <br>Format: maximal 43-stellig
   * @return Name 
   */
  public String getName() {
    return _name;
  }

  /**
   * Identifizierer des Kartenlesers (dient als Referenz dieses Kartenlesers in anderen Funktionen).
   * <br>Format: maximal 43-stellig
   * @return Id
   */
  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public void setName(String name) {
    _name = name;
  }
}
