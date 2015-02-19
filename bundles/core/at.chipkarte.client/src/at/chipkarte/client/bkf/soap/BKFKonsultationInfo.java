package at.chipkarte.client.bkf.soap;

/**
 * Diese Klasse enthält die Daten einer Konsultation.
 */
public class BKFKonsultationInfo {

  private Long _konsultationsID;
  private String _behandlungsdatum;
  private String _versicherungsstatus;
  private String _leistungsSvtCode;
  private String _verrechnungsSvtCode;
  private String _fachgebietsCode;
  private String _behandlungsfallCode;
  private Boolean _folgeDokumentation;

  /**
  * Eindeutiger Bezeichner einer Konsultation. <br>
  * Angabe: Muss. 
  * @return KonsultationsID
  */
  public Long getKonsultationsID() {
    return _konsultationsID;
  }

  public void setKonsultationsID(Long konsultationsID) {
    _konsultationsID = konsultationsID;
  }

  /**
  * Datum der Behandlung. <br>
  * Format: TT.MM.JJJJ<br>
  * Angabe: Muss.
  * @return Behandlungsdatum
  */
  public String getBehandlungsdatum() {
    return _behandlungsdatum;
  }

  public void setBehandlungsdatum(String behandlungsdatum) {
    _behandlungsdatum = behandlungsdatum;
  }

  /**
  * Code der Versichertenkategorie. <br>
  * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Versichertenkategorie}.
  * @return Versicherungsstatus
  */
  public String getVersicherungsstatus() {
    return _versicherungsstatus;
  }

  public void setVersicherungsstatus(String versicherungsstatus) {
    _versicherungsstatus = versicherungsstatus;
  }

  /**
  * Leistungszuständiger KVT. <br>
  * Format: 2-stellig.
  * @return LeistungsSvtCode
  */
  public String getLeistungsSvtCode() {
    return _leistungsSvtCode;
  }

  public void setLeistungsSvtCode(String leistungsSvtCode) {
    _leistungsSvtCode = leistungsSvtCode;
  }

  /**
  * Verrechnungszuständiger KVT. <br>
  * Format: 2-stellig.
  * @return VerrechnungsSvtCode
  */
  public String getVerrechnungsSvtCode() {
    return _verrechnungsSvtCode;
  }

  public void setVerrechnungsSvtCode(String verrechnungsSvtCode) {
    _verrechnungsSvtCode = verrechnungsSvtCode;
  }

  /**
   * Code des Fachgebietes, mit dem die Konsultation durchgeführt wurde. <br>
   * Format: 2-stellig.
   * @return FachgebietsCode.
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  /**
   * Code des Behandlungsfalls. <br>
   * Format: 2-stellig.
   * @return BehandlungsfallCode
   */
  public String getBehandlungsfallCode() {
    return _behandlungsfallCode;
  }

  public void setBehandlungsfallCode(String behandlungsfallCode) {
    _behandlungsfallCode = behandlungsfallCode;
  }

  /**
   * Kennzeichen, ob bei Verwendung dieser Konsultation 
   * eine Erst- oder Folgedokumentation erfasst werden kann. 
   * @return FolgeDokumentation
   */
  public Boolean isFolgeDokumentation() {
    return _folgeDokumentation;
  }

  public void setFolgeDokumentation(Boolean folgeDokumentation) {
    _folgeDokumentation = folgeDokumentation;
  }
}