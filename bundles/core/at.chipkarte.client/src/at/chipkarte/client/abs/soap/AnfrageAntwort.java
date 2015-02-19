/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap;

/**
 * Enthält die Daten, die von der Funktion
 * {@link at.chipkarte.client.abs.soap.IAbsService#sendenAnfrage(String, BewilligungsAnfrage, String) sendenAnfrage} zurückgeliefert
 * werden.
 */
public class AnfrageAntwort {
  private String _id;
  private Boolean _bearbeitungNaechsterWerktag;
  private PatientenDaten _patientenDaten;

  /**
   * Kennzeichen, ob die Bearbeitung der Anfrage erst am nächsten Werktag erfolgt. Wenn <i>false</i>, erfolgt die Bearbeitung sofort.
   * @return Kennzeichen für Bearbeitung am nächsten Werktag
   */
  public Boolean isBearbeitungNaechsterWerktag() {
    return _bearbeitungNaechsterWerktag;
  }

  public void setBearbeitungNaechsterWerktag(Boolean bearbeitungNaechsterWerktag) {
    _bearbeitungNaechsterWerktag = bearbeitungNaechsterWerktag;
  }

  /**
   * ID der Bewilligungsanfrage.
   * <br/>Format: maximal 38-stellig
   * @return Id
   */
  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  /**
   * Patient, der vom e-card Serversystem ermittelt wurde.
   * @return Objekt vom Typ PatientenDaten - Daten zum Patienten
   */
  public PatientenDaten getPatientenDaten() {
    return _patientenDaten;
  }

  public void setPatientenDaten(PatientenDaten patientenDaten) {
    _patientenDaten = patientenDaten;
  }
}
