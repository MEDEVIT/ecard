package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet das fachliche Ergebnis des Präoperativen Befunds.
 */
public class BefundData {
  private RisikoFaktor[] _angaben;
  private UntersuchungData[] _untersuchungData;
  private BefundKommentare befundkommentare; 

  /**
   * Angegebene Risikofaktoren.<br>
   * @return
   */
  public RisikoFaktor[] getAngaben() {
    return _angaben;
  }
  public void setAngaben(RisikoFaktor[] angaben) {
    _angaben = angaben;
  }
  /**
   * Ermittelte Untersuchungen.<br>
   * @return
   */
  public UntersuchungData[] getUntersuchungData() {
    return _untersuchungData;
  }
  public void setUntersuchungData(UntersuchungData[] untersuchungData) {
    _untersuchungData = untersuchungData;
  }
  
  /**
   * Bei der Speicherung angegeben Kommentare zum Befund bzw. den ermittelten Untersuchungsgruppen.<br>
   * @return BefundKommentare
   * @see BefundKommentare
   */
  public BefundKommentare getBefundkommentare() {
    return befundkommentare;
  }
  public void setBefundkommentare(BefundKommentare befundkommentare) {
    this.befundkommentare = befundkommentare;
  }
  
  


}
