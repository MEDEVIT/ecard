package at.chipkarte.client.prop.soap;
/**
 * Beschreibt die Konsultation, an die ein Befund gebunden ist.
 */
public class Konsultation {
  private Long _konsultationId;
  private String _behandlungsdatum;
  private String _leistungsSvtCode;
  private String _verrechnungsSvtCode;
  private String _fachgebietsCode;
  private String _behandlungsfallCode;
  /**
   * Eindeutiger Bezeichner der Konsultation.<br>
   * Format: max. 19-stellig
   * @return Bezeichner der Konsultation
   */
  public Long getKonsultationId() {
    return _konsultationId;
  }
  public void setKonsultationId(Long konsultationId) {
    _konsultationId = konsultationId;
  }
  /**
   * Datum der Behandlung.<br>
   * Format: 10-stellig TT.MM.JJJJ
   * @return Datum der Behandlung
   */
  public String getBehandlungsdatum() {
    return _behandlungsdatum;
  }
  public void setBehandlungsdatum(String behandlungsdatum) {
    _behandlungsdatum = behandlungsdatum;
  }
  /**
   * Code des leistungszuständigen SV-Trägers.<br>
   * Format: 2-stellig
   * @return Code des leistungszuständigen SVT
   */
  public String getLeistungsSvtCode() {
    return _leistungsSvtCode;
  }
  public void setLeistungsSvtCode(String leistungsSvtCode) {
    _leistungsSvtCode = leistungsSvtCode;
  }
  /**
   * Code des verrechnungszuständigen SV-Trägers.<br>
   * Format: 2-stellig
   * @return Code des verrechnungszuständigen SVT
   */
  public String getVerrechnungsSvtCode() {
    return _verrechnungsSvtCode;
  }
  public void setVerrechnungsSvtCode(String verrechnungsSvtCode) {
    _verrechnungsSvtCode = verrechnungsSvtCode;
  }
  /**
   * Code des Fachgebiets.<br>
   * Format: 2-stellig
   * @return Code des Fachgebiets
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }
  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }
  /**
   * Code des Behandlungsfalls.<br>
   * Format: 2-stellig
   * @return Code des Behandlungsfalls
   */
  public String getBehandlungsfallCode() {
    return _behandlungsfallCode;
  }
  public void setBehandlungsfallCode(String behandlungsfallCode) {
    _behandlungsfallCode = behandlungsfallCode;
  }

}
