/*
 * CAUTION!! THIS IS A GENERATED FILE! PLEASE DON'T EDIT IT! Your changes will be overwritten when the generation proccess is run
 * again. Instead, try to modify the sources from which the file was generated: - java source code files in the packages
 * at.chipkarte.client.dbas.core.api, at.chipkarte.client.dbas.core.api.valueobjects, at.chipkarte.ecard.server.dbas.api, and
 * at.chipkarte.ecard.server.dbas.api.valueobjects (specifically the javadoc tags in these files) - the configuration file
 * conf/generator.properties - the template from which this file was generated: templates/soapBean.vsl - the code of the generator
 * (C) SVC 2010
 */
package at.chipkarte.client.dbas.soap;

/**
 * <p>
 * Diese Klasse hält die Daten einer Konsultation, an die das entsprechende Datenblatt zugeordnet werden kann.
 * </p>
 */
public class KonsultationInfo {

  /**
   * _konsultationId
   */
  private Long _konsultationId;
  /**
   * _behandlungsdatum
   */
  private String _behandlungsdatum;
  /**
   * _versicherungsstatus
   */
  private String _versicherungsstatus;
  /**
   * _fachgebietsCode
   */
  private String _fachgebietsCode;
  /**
   * _leistungsSvtCode
   */
  private String _leistungsSvtCode;
  /**
   * _verrechnungsSvtCode
   */
  private String _verrechnungsSvtCode;
  /**
   * _behandlungsfallCode
   */
  private String _behandlungsfallCode;

  /**
   * Eindeutige Nummer der Konsultation.<br>
   * Format: maximal 19-stellig
   * @return KonsultationId.
   */
  public Long getKonsultationId() {
    return _konsultationId;
  }

  public void setKonsultationId(Long _konsultationId) {
    this._konsultationId = _konsultationId;
  }

  /**
   * Datum der Behandlung.<br>
   * Format: TT.MM.JJJJ
   * @return Behandlungsdatum.
   */
  public String getBehandlungsdatum() {
    return _behandlungsdatum;
  }

  public void setBehandlungsdatum(String _behandlungsdatum) {
    this._behandlungsdatum = _behandlungsdatum;
  }

  /**
   * Versicherungsstatus.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Versichertenkategorie}.<br>
   * Format: maximal 2-stellig
   * @return Versicherungsstatus
   */
  public String getVersicherungsstatus() {
    return _versicherungsstatus;
  }

  public void setVersicherungsstatus(String _versicherungsstatus) {
    this._versicherungsstatus = _versicherungsstatus;
  }

  /**
   * Code des Fachgebietes, mit dem die Konsultation durchgeführt wurde.<br>
   * Format: maximal 2-stellig
   * @return FachgebietsCode.
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  public void setFachgebietsCode(String _fachgebietsCode) {
    this._fachgebietsCode = _fachgebietsCode;
  }

  /**
   * Code des leistungszuständigen Svt für die SV-Person.<br>
   * Format: maximal 2-stellig
   * @return LeistungsSvtCode
   */
  public String getLeistungsSvtCode() {
    return _leistungsSvtCode;
  }

  public void setLeistungsSvtCode(String _leistungsSvtCode) {
    this._leistungsSvtCode = _leistungsSvtCode;
  }

  /**
   * Code des verrechnungszuständigen Svt für die SV-Person.<br>
   * Format: maximal 2-stellig
   * @return VerrechnungsSvtCode
   */
  public String getVerrechnungsSvtCode() {
    return _verrechnungsSvtCode;
  }

  public void setVerrechnungsSvtCode(String _verrechnungsSvtCode) {
    this._verrechnungsSvtCode = _verrechnungsSvtCode;
  }

  /**
   * Code des Behandlungsfalls.<br>
   * Format: maximal 2-stellig
   * @return BehandlungsfallCode
   */
  public String getBehandlungsfallCode() {
    return _behandlungsfallCode;
  }

  public void setBehandlungsfallCode(String _behandlungsfallCode) {
    this._behandlungsfallCode = _behandlungsfallCode;
  }
}