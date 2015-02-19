/*
 * CAUTION!! THIS IS A GENERATED FILE! PLEASE DON'T EDIT IT!
 * Your changes will be overwritten when the generation proccess
 * is run again.
 *
 * Instead, try to modify the sources from which the file was generated:
 * - java source code files in the packages at.chipkarte.client.dbas.core.api, at.chipkarte.client.dbas.core.api.valueobjects,
 *   at.chipkarte.ecard.server.dbas.api, and at.chipkarte.ecard.server.dbas.api.valueobjects
 *   (specifically the javadoc tags in these files)
 * - the configuration file conf/generator.properties
 * - the template from which this file was generated: templates/soapBean.vsl
 * - the code of the generator
 *
 * (C) SVC 2010
 */
package at.chipkarte.client.dbas.soap;


/**
 * <p>
 * Empfangsbestätigung der Funktionen
 * {@link at.chipkarte.client.dbas.soap.IDbasService#createDatenblattAllgemeinesProgramm(String, String, DatenblattAllgemeinesProgramm) createDatenblattAllgemeinesProgramm},
 * {@link at.chipkarte.client.dbas.soap.IDbasService#createDatenblattMammographie(String, String, DatenblattMammographie) createDatenblattMammographie},
 * {@link at.chipkarte.client.dbas.soap.IDbasService#createDatenblattPapAbstrich(String, String, DatenblattPapAbstrich) createDatenblattPapAbstrich},
 * {@link at.chipkarte.client.dbas.soap.IDbasService#createDatenblattKoloskopie(String, String, DatenblattKoloskopie) createDatenblattKoloskopie},
 * {@link at.chipkarte.client.dbas.soap.IDbasService#createDatenblattQZKoloskopie(String , String , DatenblattKoloskopie datenblattKoloskopie, String , boolean) createDatenblattQZKKoloskopie},
 * {@link at.chipkarte.client.dbas.soap.IDbasService#createDatenblattDmpDm2(String, String, DatenblattDmpDm2) createDatenblattDmpDm2}.
 * </p>
 */
public class Quittung {

  /**
  * _untersuchungsdatum
  * @id 44
  */
  private String _untersuchungsdatum;
  /**
  * _datenblattTyp
  * @id 45
  */
  private String _datenblattTyp;
  /**
  * _annahmezeitpunkt
  * @id 46
  */
  private String _annahmezeitpunkt;
  /**
  * _signatur
  * @id 47
  */
  private byte[] _signatur;
  /**
  * _svNummer
  * @id 48
  */
  private String _svNummer;
  /**
  * _svtCode
  * @id 49
  */
  private String _svtCode;
  /**
  * _vpNummer
  * @id 50
  */
  private String _vpNummer;

  /**
   * Datum der Untersuchung.<br>
   * Format: TT.MM.JJJJ
   * @return Untersuchungsdatum.
   */
  public String getUntersuchungsdatum() {
    return _untersuchungsdatum;
  }
  
  public void setUntersuchungsdatum(String _untersuchungsdatum) {
    this._untersuchungsdatum = _untersuchungsdatum;
  }

  /**
   * Datenblatttyp.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.DatenblattConstants DatenblattConstants}.<br>
   * Format: maximal 3-stellig
   * @return DatenblattTyp.
   */
  public String getDatenblattTyp() {
    return _datenblattTyp;
  }
  
  public void setDatenblattTyp(String _datenblattTyp) {
    this._datenblattTyp = _datenblattTyp;
  }

  /**
   * Datum der Annahme des Dokumentations-/Befundblattes am Server (Datum der Speicherung des Befundblattes am Server).<br>
   * Format: TT.MM.JJJJ
   * @return Annahmezeitpunkt.
   */
  public String getAnnahmezeitpunkt() {
    return _annahmezeitpunkt;
  }
  
  public void setAnnahmezeitpunkt(String _annahmezeitpunkt) {
    this._annahmezeitpunkt = _annahmezeitpunkt;
  }

  /**
   * Signatur der Empfangsbestätigung.<br>
   * @return Signatur.
   */
  public byte[] getSignatur() {
    return _signatur;
  }
  
  public void setSignatur(byte[] _signatur) {
    this._signatur = _signatur;
  }

  /**   
   * Sozialversicherungsnummer der SV-Person.<br>
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
   * Format: maximal 2-stellig
   * @return SvtCode
   */
  public String getSvtCode() {
    return _svtCode;
  }
  
  public void setSvtCode(String _svtCode) {
    this._svtCode = _svtCode;
  }

  /**   
   * Vertragspartnernummer.<br>
   * Format: maximal 6-stellig
   * @return VpNummer
   */
  public String getVpNummer() {
    return _vpNummer;
  }
  public void setVpNummer(String _vpNummer) {
    this._vpNummer = _vpNummer;
  }
}