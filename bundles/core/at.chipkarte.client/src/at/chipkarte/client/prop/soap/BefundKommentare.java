package at.chipkarte.client.prop.soap;

/**
 * Beinhaltet die Vertragspartner-Kommentare zu einem Befund.
 */
public class BefundKommentare {


  private String _generellerText;

  private GruppenKommentar[] _gruppenkommentar;

  /**
   * Genereller Kommentar den ganzen Befund betreffend.<br>
   * Format: max. 1000-stellig.
   * @return generelller Text 
   */
  public String getGenerellerText() {
    return _generellerText;
  }

  public void setGenerellerText(String generellerText) {
    _generellerText = generellerText;
  }

  /**
   * Kommentar zu einer bestimmten Untersuchungsgruppe.<br>
   * @return Gruppenkommentar
   * @see GruppenKommentar
   */
  public GruppenKommentar[] getGruppenkommentar() {
    return _gruppenkommentar;
  }

  public void setGruppenkommentar(GruppenKommentar[] gruppenkommentar) {
    _gruppenkommentar = gruppenkommentar;
  }
}
