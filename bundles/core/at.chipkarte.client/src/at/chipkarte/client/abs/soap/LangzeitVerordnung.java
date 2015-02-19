/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

/**
 * Enthält die Rückantwortdaten zu einer beantragten Langzeitverordnung innerhalb einer {@link BewilligungsAnfrage}.
 */
public class LangzeitVerordnung {
  private Integer _beantragteMonate;
  private Integer _bewilligteMonate;
  private Integer _bewilligtePackungen;

  /**
   * Die beantragten Monate. 
   * <br/>Format: [1..99]
   * @return Beantragte Monate; der Wert -1 bedeutet, dass das Feld in der Rückantwort nicht versorgt wurde.
   */
  public Integer getBeantragteMonate() {
    return _beantragteMonate;
  }

  /**
   * Die bewilligten Monate. 
   * <br/>Format: [0..99]
   * @return Bewilligte Monate; der Wert -1 bedeutet, dass das Feld in der Rückantwort nicht versorgt wurde.
   */
  public Integer getBewilligteMonate() {
    return _bewilligteMonate;
  }

  /**
   * Die bewilligte gesamte Packungsanzahl für die Langzeitverordnung. 
   * <br/>Format: [0..99]
   * @return Bewilligte Packungen; der Wert -1 bedeutet, dass das Feld in der Rückantwort nicht versorgt wurde.
   */
  public Integer getBewilligtePackungen() {
    return _bewilligtePackungen;
  }

  public void setBeantragteMonate(Integer beantragteMonate) {
    _beantragteMonate = beantragteMonate;
  }

  public void setBewilligteMonate(Integer bewilligteMonate) {
    _bewilligteMonate = bewilligteMonate;
  }

  public void setBewilligtePackungen(Integer bewilligtePackungen) {
    _bewilligtePackungen = bewilligtePackungen;
  }
}