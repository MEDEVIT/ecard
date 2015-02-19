/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten zu einer Verordnung im Rahmen einer {@link BewilligungsAnfrage}.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class Verordnung {
  private Medikament _medikament;
  private String _magistraleZubereitung;
  private Integer _packungsanzahl;
  private String _dosierung;
  private String _diagnose;
  private String _begruendung;
  private String _langzeitverordnung;

  /**
   * Das zu verschreibende Medikamtent (siehe {@link Medikament}).
   * <br/>Die Angabe des Medikaments ist optional. Wird es nicht angegeben, muss jedoch eine {@link #getMagistraleZubereitung()
   * Magistrale Zubereitung} angegeben werden.
   * @return Objekt vom Typ Medikament
   */
  public Medikament getMedikament() {
    return _medikament;
  }

  /**
   * Die zu verschreibende Magistrale Zubereitung. 
   * <br/>Format: maximal 1000-stellig 
   * <br/>Die Angabe der Magistralen Zubereitung ist optional. Wird sie nicht angegeben, muss jedoch ein {@link #getMedikament()
   * Medikament}  angegeben werden.
   * @return Magistrale Zubereitung
   */
  public String getMagistraleZubereitung() {
    return _magistraleZubereitung;
  }

  /**
   * Die Packungsanzahl (Abgabemenge) des zu verschreibenden Medikaments beziehungsweise der Magistralen Zubereitung. 
   * <br/>Wertebereich: [1..99]
   * @return Packungsanzahl
   */
  public Integer getPackungsanzahl() {
    return _packungsanzahl;
  }

  /**
   * Dosierung/Abgabemodus der Verordnung (z.B.: 1-0-1). 
   * <br/>Format: maximal 25-stellig 
   * <br/>Die Angabe der Dosierung ist optional.
   * @return Dosierung
   */
  public String getDosierung() {
    return _dosierung;
  }

  /**
   * Diagnose für die Verordnung. 
   * <br/>Format: maximal 100-stellig
   * @return Diagnose
   */
  public String getDiagnose() {
    return _diagnose;
  }

  /**
   * Ärztliche Begründung für die Verordnung. 
   * <br/>Format: maximal 1000-stellig
   * @return Begründung
   */
  public String getBegruendung() {
    return _begruendung;
  }

  /**
   * Antrag auf Langzeitverordnung des Medikaments oder der Magistralen Zubereitung. 
   * <br/>Format: 2-stellig, numerisch 
   * <br/>Wertebereich: >= 0 
   * <br/>Diese Angabe ist optional. Wird eine Langzeitverordnung beantragt, muss der numerische Wert dieses Feldes 
   * größer oder gleich 1 sein (ansonsten 0).
   * @return Langzeitverordnungsmonate
   */
  public String getLangzeitverordnung() {
    return _langzeitverordnung;
  }

  public void setMedikament(Medikament medikament) {
    _medikament = medikament;
  }

  public void setPackungsanzahl(Integer packungsanzahl) {
    _packungsanzahl = packungsanzahl;
  }

  public void setDosierung(String dosierung) {
    _dosierung = dosierung;
  }

  public void setMagistraleZubereitung(String zubereitung) {
    _magistraleZubereitung = zubereitung;
  }

  public void setDiagnose(String diagnose) {
    _diagnose = diagnose;
  }

  public void setBegruendung(String begruendung) {
    _begruendung = begruendung;
  }

  public void setLangzeitverordnung(String langzeitverordnung) {
    _langzeitverordnung = langzeitverordnung;
  }

}