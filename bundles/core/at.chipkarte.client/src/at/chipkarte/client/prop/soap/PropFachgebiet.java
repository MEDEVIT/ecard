package at.chipkarte.client.prop.soap;
/**
 * Beinhaltet ein PROP relevantes Fachgebiet,
 * sowie die für dieses Fachgebiet zulässigen PROP relevanten Behandlungsfälle.
 */
public class PropFachgebiet {
  private String _fachgebiet;
  private String[] _behandlungsfall;
  /**
   * Code des Fachgebiets.<br>
   * Format: 2-stellig
   * @return Fachgebietscode
   */
  public String getFachgebiet() {
    return _fachgebiet;
  }
  public void setFachgebiet(String fachgebiet) {
    _fachgebiet = fachgebiet;
  }
  /**
   * Codes der für PROP relevanten Behandlungsfälle für dieses Fachgebiet.<br>
   * Format: Array; jeder Wert 2-stellig
   * @return Behandlungsfallcodes
   */
  public String[] getBehandlungsfall() {
    return _behandlungsfall;
  }
  public void setBehandlungsfall(String[] behandlungsfall) {
    _behandlungsfall = behandlungsfall;
  }

 }
