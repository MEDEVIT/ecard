/*
 * (C) Siemens and SVCBE 2008
 */
package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten zur Einschränkung der Datensätze im Zuge der Funktion
 * {@link at.chipkarte.client.abs.soap.IAbsService#getStatusBewilligungsAnfragen(String, FilterKriterien)
 * getStatusBewilligungsAnfragen}.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class FilterKriterien {

  private String _anfrageStatus;
  private String _datumVon;
  private String _datumBis;

  /**
   * Status der Bewilligungsanfrage.
   * <br/>Die Angabe ist optional. Ist der Parameter nicht angegeben, dann wird nach allen Status einer 
   * Anfrage selektiert. Die möglichen
   * Werte sind in {@link at.chipkarte.client.abs.soap.constants.AnfrageStatus AnfrageStatus} definiert.
   * <br/>Format: maximal 11-stellig
   * @return Status der Bewilligungsanfrage.
   */
  public String getAnfrageStatus() {
    return _anfrageStatus;
  }

  public void setAnfrageStatus(String anfrageStatus) {
    _anfrageStatus = anfrageStatus;
  }

  /**
   * Enddatum für den Suchzeitraum von gestellten Anfragen.
   * <br/>Die Angabe ist optional.
   * <br/>Format: TT.MM.JJJJ
   * <br/>Zulässiger Wertebereich: DatumVon &lt;= DatumBis
   * @return Enddatum für den Suchzeitraum von gestellten Anfragen.
   */
  public String getDatumBis() {
    return _datumBis;
  }

  public void setDatumBis(String datumBis) {
    _datumBis = datumBis;
  }

  /**
   * Beginndatum für den Suchzeitraum von gestellten Anfragen.
   * <br/>Die Angabe ist optional.
   * <br/>Format: TT.MM.JJJJ
   * <br/>Zulässiger Wertebereich: DatumVon &lt;= DatumBis
   * @return Beginndatum für den Suchzeitraum von gestellten Anfragen.
   */
  public String getDatumVon() {
    return _datumVon;
  }

  public void setDatumVon(String datumVon) {
    _datumVon = datumVon;
  }

}
