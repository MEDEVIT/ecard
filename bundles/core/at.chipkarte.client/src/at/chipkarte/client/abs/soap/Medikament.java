/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten eines Medikaments im Rahmen einer {@link Verordnung}.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class Medikament {
  private String _pharmanummer;
  private String _name;

  /**
   * Die Pharmanummer des Medikaments. 
   * <br/>Format: maximal 9-stellig, numerisch 
   * <br/>Die Pharmanummer muss den Regeln für Pharmanummern (Prüfziffer) entsprechen. 
   * <br/>Die Angabe der Pharmanummer ist optional.
   * @return Pharmanummer
   */
  public String getPharmanummer() {
    return _pharmanummer;
  }

  public void setPharmanummer(String pharmanummer) {
    _pharmanummer = pharmanummer;
  }

  /**
   * Der eindeutige Name des Medikaments (Kurzname, Darreichungsform und Stärke). 
   * <br/>Format: maximal 100-stellig 
   * @return Medikamentenname
   */
  public String getName() {
    return _name;
  }

  public void setName(String name) {
    _name = name;
  }

}