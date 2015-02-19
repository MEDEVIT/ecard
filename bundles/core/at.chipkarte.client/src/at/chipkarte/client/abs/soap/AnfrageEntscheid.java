/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Rückantwortdaten zu einer Verordnung im Rahmen einer {@link BewilligungsAnfrage}.
 * </p>
 * <p>
 * Die Werte der Felder, die mit dem Präfix "beantragt" beginnen (z.B. beantragtesMedikament) können unter Umständen von den
 * entsprechenden Daten in der Anfrage abweichen, falls diese durch den chefärztlichen Dienst korrigiert wurden (z.B. Ergänzung des
 * korrekten Medikamentennamens zur Pharmanummer).
 * </p>
 * <p>
 * Die Werte der Felder, die mit dem Präfix "bewilligt" beginnen (z.B. bewilligtesMedikament) können von den "beantragten" Werten
 * abweichen, falls sich der bewilligte Wert vom beantragten Wert unterscheidet.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class AnfrageEntscheid {
  private String _verordnungsEntscheidung;
  private Medikament _beantragtesMedikament;
  private Medikament _bewilligtesMedikament;
  private String _magistraleZubereitung;
  private String _infoText;
  private Integer _beantragtePackungsanzahl;
  private Integer _bewilligtePackungsanzahl;
  private LangzeitVerordnung _langzeitVerordnung;

  /**
   * Die Entscheidung des chefärztlichen Dienstes zu der beantragten Verordnung. Die möglichen Werte sind in
   * {@link at.chipkarte.client.abs.soap.constants.VerordnungsEntscheidung VerordnungsEntscheidung} definiert. <br>
   * Format: maximal 25-stellig
   * @return Entscheidung zur Verordnung.
   */
  public String getVerordnungsEntscheidung() {
    return _verordnungsEntscheidung;
  }

  /**
   * Das beantragte Medikamtent (siehe {@link Medikament}).
   * <br/>Optional
   * @return Beantragtes Medikament
   */
  public Medikament getBeantragtesMedikament() {
    return _beantragtesMedikament;
  }

  /**
   * Das bewilligte Medikamtent (siehe {@link Medikament}).
   * <br/>Optional
   * @return Bewilligtes Medikament
   */
  public Medikament getBewilligtesMedikament() {
    return _bewilligtesMedikament;
  }

  /**
   * Die beantragte und bewilligte Magistrale Zubereitung. 
   * <br/>Eine Magistrale Zubereitung kann durch den chefärztlichen Dienst gegenüber dem 
   * ursprünglichen Wert in der Anfrage verändert
   * worden sein, falls z.B. ein Tippfehler korrigiert wurde. Eine Unterscheidung zwischen beantragter und bewilligter Magistraler
   * Zubereitung entfällt jedoch, da immer nur die beantragte Magistrale Zubereitung bewilligt oder abgelehnt wird. <br>
   * <br/>Optional
   * <br/>Format: maximal 1000-stellig
   * @return Magistrale Zubereitung
   */
  public String getMagistraleZubereitung() {
    return _magistraleZubereitung;
  }

  /**
   * Beantragte Packungsanzahl (Abgabemenge) des zu verschreibenden Medikaments beziehungsweise der Magistralen Zubereitung. 
   * <br/>Format: Integer (numerisch)
   * @return Beantragte Packungsanzahl
   */
  public Integer getBeantragtePackungsanzahl() {
    return _beantragtePackungsanzahl;
  }

  /**
   * Bewilligte Packungsanzahl (Abgabemenge) des zu verschreibenden Medikaments beziehungsweise der Magistralen Zubereitung. 
   * <br/>Format: Integer (numerisch)
   * @return Bewilligte Packungsanzahl
   */
  public Integer getBewilligtePackungsanzahl() {
    return _bewilligtePackungsanzahl;
  }

  /**
   * Die Rückantwortdaten zur Langzeitverordnung.
   * @return Objekt vom Typ Langzeitverordnung - Rückantwortdaten zur Langzeitverordnung
   */
  public LangzeitVerordnung getLangzeitVerordnung() {
    return _langzeitVerordnung;
  }

  /**
   * Informationstext des chefärztlichen Dienstes bezüglich dieser Verordnung. Z.B. Begründung der Ablehnung.
   * <br/>Optional
   * <br/>Format: maximal 800-stellig
   * @return Informationstext des chefärztlichen Dienstes
   */
  public String getInfoText() {
    return _infoText;
  }

  public void setBeantragtePackungsanzahl(Integer beantragtePackungsanzahl) {
    _beantragtePackungsanzahl = beantragtePackungsanzahl;
  }

  public void setBeantragtesMedikament(Medikament beantragtesMedikament) {
    _beantragtesMedikament = beantragtesMedikament;
  }

  public void setBewilligtePackungsanzahl(Integer bewilligtePackungsanzahl) {
    _bewilligtePackungsanzahl = bewilligtePackungsanzahl;
  }

  public void setBewilligtesMedikament(Medikament bewilligtesMedikament) {
    _bewilligtesMedikament = bewilligtesMedikament;
  }

  public void setLangzeitVerordnung(LangzeitVerordnung langzeitVerordnung) {
    _langzeitVerordnung = langzeitVerordnung;
  }

  public void setMagistraleZubereitung(String magistraleZubereitung) {
    _magistraleZubereitung = magistraleZubereitung;
  }

  public void setVerordnungsEntscheidung(String verordnungsEntscheidung) {
    _verordnungsEntscheidung = verordnungsEntscheidung;
  }

  public void setInfoText(String infoText) {
    _infoText = infoText;
  }

}