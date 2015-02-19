/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap;

import at.chipkarte.client.base.soap.SvPersonV2;

/**
 * Enthält die Daten für einen eigenen Anspruch beziehungsweise für einen abgeleiteten Anspruch.
 */
public class Anspruchsdaten {
  private String _svtCode;
  private SvPersonV2 _abgeleiteteDaten;
  private String _anspruchsart;
  private String _versichertenartCode;
  private String _versichertenKategorie;
  private Boolean _kostenanteilbefreit;
  private Boolean _rezeptgebbefreit;

  /**
   * Für den (eigenen oder abgeleiteten) Anspruch zuständiger Krankenversicherungsträger.
   * <br>Mögliche Werte siehe Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}<br>
   * Format: 2-stellig
   * @return KVT-Code
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Versichertendaten des Versicherten, von dem sich der vorliegende Anspruch ableitet. 
   * <br>Null, wenn es sich um keinen abgeleiteten
   * Anspruch handelt.<br>
   * Die Felder <i>Geschlecht</i> und <i>Geburtsdatum</i> vom Versicherten werden nicht versorgt.
   * @return abgeleitete Daten
   */
  public SvPersonV2 getAbgeleiteteDaten() {
    return _abgeleiteteDaten;
  }

  /**
   * Anspruchsart.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Anspruchsart}<br>
   * Format: maximal 2-stellig
   * @return Anspruchsart-Code
   */
  public String getAnspruchsart() {
    return _anspruchsart;
  }

  /**
   * Versichertenart-Code des Patienten.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Versichertenart} <br>
   * Format: 1-stellig
   * @return Versichertenart-Code
   */
  public String getVersichertenartCode() {
    return _versichertenartCode;
  }

  /**
   * Versichertenkategorie.
   * <br>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Versichertenkategorie} <br>
   * Format: 2-stellig
   * @return Versichertenkategorie
   */
  public String getVersichertenKategorie() {
    return _versichertenKategorie;
  }

  /**
   * Kennzeichen, ob der Patient vom Kostenanteil befreit ist.
   * @return <i>true</i> = Patient ist vom Kostenanteil befreit, <i>false</i> = Patient ist nicht vom Kostenanteil befreit
   */
  public Boolean isKostenanteilbefreit() {
    return _kostenanteilbefreit;
  }

  /**
   * Kennzeichen, ob der Patient von der Rezeptgebühr befreit ist.
   * @return <i>true</i> = Patient ist von der Rezeptgebühr befreit, <i>false</i> = Patient ist nicht von der Rezeptgebühr befreit
   */
  public Boolean isRezeptgebbefreit() {
    return _rezeptgebbefreit;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  public void setAbgeleiteteDaten(SvPersonV2 abgeleiteteDaten) {
    _abgeleiteteDaten = abgeleiteteDaten;
  }

  public void setAnspruchsart(String anspruchsart) {
    _anspruchsart = anspruchsart;
  }

  public void setVersichertenartCode(String versichertenartCode) {
    _versichertenartCode = versichertenartCode;
  }

  public void setVersichertenKategorie(String versichertenKategorie) {
    _versichertenKategorie = versichertenKategorie;
  }

  public void setKostenanteilbefreit(Boolean kostenanteilbefreit) {
    _kostenanteilbefreit = kostenanteilbefreit;
  }

  public void setRezeptgebbefreit(Boolean rezeptgebbefreit) {
    _rezeptgebbefreit = rezeptgebbefreit;
  }
}
