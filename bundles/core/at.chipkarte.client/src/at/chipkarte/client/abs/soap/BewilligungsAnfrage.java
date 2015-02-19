/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten einer Bewilligungsanfrage im Sinne des Arzneimittelbewilligungsservice.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class BewilligungsAnfrage {
  private PatientenDaten _patientenDaten;
  private Verordnung[] _verordnungen;
  private String _verordnerinformation;
  private String _antragstyp;

  /**
   * Die Kennzeichnung der Bewilligungsanfrage (Bewilligungsanfrage im Rahmen einer Rezeptausstellung 
   * beziehungsweise Arztbrieferstellung).
   * <br/>Wertebereich: siehe {@link at.chipkarte.client.abs.soap.constants.Antragstyp Antragstyp}.
   * @return Antragstyp
   */
  public String getAntragstyp() {
    return _antragstyp;
  }

  /**
   * Die Daten des Patienten für den die Bewilligungsanfrage gestellt wird.
   * @return Patientendaten
   */
  public PatientenDaten getPatientenDaten() {
    return _patientenDaten;
  }

  /**
   * Freies Textfeld um den Namen beziehungsweise die Telefonnummer des Verordners zu übergeben.
   * <br/>z.B.: für Rückfragen in Krankenanstalten 
   * <br/>Optional
   * <br/>Format: maximal 150-stellig
   * @return Verordnerinformation
   */
  public String getVerordnerinformation() {
    return _verordnerinformation;
  }

  /**
   * Die Verordnungen die beantragt werden (maximal 10).
   * @return Objekt vom Typ Verordnung[] - Array von Verordnungen
   */
  public Verordnung[] getVerordnungen() {
    return _verordnungen;
  }

  public void setAntragstyp(String antragstyp) {
    _antragstyp = antragstyp;
  }

  public void setPatientenDaten(PatientenDaten patientenDaten) {
    _patientenDaten = patientenDaten;
  }

  public void setVerordnerinformation(String verordnerinformation) {
    _verordnerinformation = verordnerinformation;
  }

  public void setVerordnungen(Verordnung[] verordnungen) {
    _verordnungen = verordnungen;
  }

}