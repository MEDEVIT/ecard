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
 * Enthält die Daten zur Einschränkung der Datensätze im Zuge der Funktion
 * {@link at.chipkarte.client.dbas.soap.IDbasService#searchQuittungen(String, QuittungSearchCriteria) searchQuittungen}.
 * </p>
 */
public class QuittungSearchCriteria {

  /**
   * _bisDatum
   * @id 129004
   */
  private String _bisDatum;
  /**
   * _datenblattTyp
   * @id 129002
   */
  private String _datenblattTyp;
  /**
   * _vonDatum
   * @id 129003
   */
  private String _vonDatum;
  /**
   * _svNummer
   * @id 129001
   */
  private String _svNummer;
  /**
   * _svtCode
   * @id 129005
   * @maxLength 2
   */
  private String _svtCode;

  /**
   * Enddatum für den Suchzeitraum von Empfangsbestätigungen.<br>
   * Die Angabe ist optional.<br>
   * Format: "TT.MM.JJJJ"<br>
   * Zulässiger Wertebereich: VonDatum &lt;= BisDatum
   * @return BisDatum
   */
  public String getBisDatum() {
    return _bisDatum;
  }

  public void setBisDatum(String _bisDatum) {
    this._bisDatum = _bisDatum;
  }

  /**
   * Datenblatttyp, nach dem Empfangsbestätigungen gesucht werden.<br>
   * Die Angabe ist optional. Ist der Parameter nicht angegeben, dann wird nach allen Datenblatttypen selektiert. Die möglichen
   * Werte sind in {@link at.chipkarte.client.dbas.soap.constants.DatenblattConstants DatenblattConstants} definiert.<br>
   * @return DatenblattTyp
   */
  public String getDatenblattTyp() {
    return _datenblattTyp;
  }

  public void setDatenblattTyp(String _datenblattTyp) {
    this._datenblattTyp = _datenblattTyp;
  }

  /**
   * Beginndatum für den Suchzeitraum von Empfangsbestätigungen.<br>
   * Die Angabe ist optional.<br>
   * Format: "TT.MM.JJJJ"<br>
   * Zulässiger Wertebereich: VonDatum &lt;= BisDatum
   * @return VonDatum
   */
  public String getVonDatum() {
    return _vonDatum;
  }

  public void setVonDatum(String _vonDatum) {
    this._vonDatum = _vonDatum;
  }

  /**
   * Sozialversicherungsnummer, nach der Empfangsbestätigungen gesucht werden. <br>
   * Die Angabe ist optional.<br>
   * Format: maximal 10-stellig
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String _svNummer) {
    this._svNummer = _svNummer;
  }

  /**
   * Code des Versicherungsträgers der SV-Person.<br>
   * Die Angabe ist optional.<br>
   * Format: maximal 2-stellig
   * @return SvtCode
   */
  public String getSvtCode() {
    return _svtCode;
  }

  public void setSvtCode(String _svtCode) {
    this._svtCode = _svtCode;
  }
}