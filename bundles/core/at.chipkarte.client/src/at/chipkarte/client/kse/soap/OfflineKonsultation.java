/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Ein-/Ausgangsparameter einer Offlinekonsultation.
 */
public class OfflineKonsultation {

  private String _fachgebietsCode = null;
  private String _behandlunsfallCode = null;
  private String _svtCode = null;

  private String _behandlungsDatum = null;
  private String _konsultationsartCode = null;

  /**
   * Behandlungsdatum der offline erfassten Konsultation.
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Behandlungsdatum
   */
  public String getBehandlungsDatum() {
    return _behandlungsDatum;
  }

  public void setBehandlungsDatum(String behandlungsDatum) {
    _behandlungsDatum = behandlungsDatum;
  }

  /**
   * Behandlungsfall, für den diese Konsultation durchgeführt wird.
   * <br/>Mögliche Werte laut Funktion {@link IKseService#getBehandlungsfaelle() getBehandlungsfaelle}.
   * <br/>Format: 2-stellig
   * @return Behandlungsfallcode
   */

  public String getBehandlunsfallCode() {
    return _behandlunsfallCode;
  }

  public void setBehandlunsfallCode(String behandlunsfallCode) {
    _behandlunsfallCode = behandlunsfallCode;
  }

  /**
   * Fachgebiet, für das diese Konsultation durchgeführt wird.
   * <br/>Mögliche Werte laut Funktion {@link at.chipkarte.client.base.soap.IBaseService#getFachgebiete() getFachgebiete}.
   * <br/>Format: 2-stellig
   * @return Fachgebietscode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  /**
   * Konsultationsart der offline erfassten Konsultation.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.Konsultationsart Konsultationsarten}.
   * <br/>Format: 3-stellig
   * @return Code der Konsultationsart
   */
  public String getKonsultationsartCode() {
    return _konsultationsartCode;
  }

  public void setKonsultationsartCode(String konsultationsartCode) {
    _konsultationsartCode = konsultationsartCode;
  }

  /**
   * Code des leistungszuständigen KVT für den Patienten.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}.
   * <br/>Format: 2-stellig
   * @return KVT-Code
   */
  public String getSvtCode() {
    return _svtCode;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
}
