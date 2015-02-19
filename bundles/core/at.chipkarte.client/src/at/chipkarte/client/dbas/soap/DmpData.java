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
 * Enthält das Ergebnis der Funktion
 * {@link at.chipkarte.client.dbas.soap.IDbasService#searchDmpData(String, String, String, String) searchDmpData}.
 * </p>
 */
public class DmpData {

  /**
   * _svPatient
   */
  private PatientInfo _svPatient;

  /**
   * _betreuungen
   */
  private Betreuung[] _betreuungen;

  /**
   * Daten des Patienten.
   * @return PatientInfo
   */
  public PatientInfo getSvPatient() {
    return _svPatient;
  }

  public void setSvPatient(PatientInfo _svPatient) {
    this._svPatient = _svPatient;
  }

  /**
   * Im System bereits vorhandene Betreuungsverhältnisse für den gewählten Datenblatttyp.
   * @return Liste von Betreuungsverhältnissen
   */
  public Betreuung[] getBetreuungen() {
    return _betreuungen;
  }

  public void setBetreuungen(Betreuung[] betreuungen) {
    _betreuungen = betreuungen;
  }

}