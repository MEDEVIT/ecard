package at.chipkarte.client.bkf.soap;

/**
 * Rückgabewert der Funktion
 * {@link at.chipkarte.client.bkf.soap.IBkfService#checkBkfToken(String, String, String, long, String)}.
 */
public class CheckBkfTokenErgebnis {

  private String _einladungsdatum;
  private Boolean _folgeDokumentation;

  /**
   * Einladungsdatum. <br>
   * Angabe: Muss. <br>
   * Format: TT.MM.JJJJ
   * @return Einladungsdatum.
   */
  public String getEinladungsdatum() {
    return _einladungsdatum;
  }

  public void setEinladungsdatum(String einladungsdatum) {
    _einladungsdatum = einladungsdatum;
  }

  /**
   * Kennzeichen, ob eine Erst- oder Folgedokumentation erfasst werden kann. <br>
   * Angabe: Muss.
   * @return FolgeDokumentation.
   */
  public Boolean isFolgeDokumentation() {
    return _folgeDokumentation;
  }

  public void setFolgeDokumentation(Boolean folgeDokumentation) {
    _folgeDokumentation = folgeDokumentation;
  }
}