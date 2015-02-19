package at.chipkarte.client.aum.soap;

/**
 * Überblicksdaten einer Meldung. Diese Datenstruktur wird von der Methode 
 * {@link IAumService#suchenMeldungen(String, Suchkriterien)} zurückgegeben.
 */
public class AufSuchergebnis {
  private Long _aufID;
  private Integer _aufVersion;
  private String _vorname;
  private String _zuname;
  private String _svNummer;
  private String _meldungsart;
  private String _ausstellungsdatum;
  private String _svtCode;
  private String _arbeitsunfaehigVon;
  private String _arbeitsunfaehigBis;
  private String _geburtsDatum;
  private Boolean _ungeprueft;
  private String _abweichendeAusgehzeitVon1;
  private String _abweichendeAusgehzeitBis1;
  private String _abweichendeAusgehzeitVon2;
  private String _abweichendeAusgehzeitBis2;
  private Boolean _bettruhe;
  private String _auErgaenzer;
  private String _afMelder;
  private Boolean _selbsterstelltAU;
  private Boolean _selbsterstelltAF;
  private Boolean _editierbar;
  /**
   * Gibt an, ob die Meldung ohne Anspruchsprüfung angelegt wurde.
   * @return Kennzeichen - ungeprueft
   */
  public Boolean getUngeprueft() {
    return _ungeprueft;
  }
  public void setUngeprueft(Boolean ungeprueft) {
    _ungeprueft = ungeprueft;
  }
  /**
   * Ende der Arbeitsunfähigkeit (für beendete AU-Meldungen oder AF-Meldungen).
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Ende der Arbeitsunfähigkeit
   */
  public String getArbeitsunfaehigBis() {
    return _arbeitsunfaehigBis;
  }
  public void setArbeitsunfaehigBis(String arbeitsunfaehigBis) {
    _arbeitsunfaehigBis = arbeitsunfaehigBis;
  }
  /**
   * Beginn der Arbeitsunfähigkeit.
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Beginn der Arbeitsunfähigkeit
   */
  public String getArbeitsunfaehigVon() {
    return _arbeitsunfaehigVon;
  }
  public void setArbeitsunfaehigVon(String arbeitsunfaehigVon) {
    _arbeitsunfaehigVon = arbeitsunfaehigVon;
  }
  /**
   * Ausstellungsdatum der Meldung.
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Ausstellungsdatum der Meldung
   */
  public String getAusstellungsdatum() {
    return _ausstellungsdatum;
  }
  public void setAusstellungsdatum(String ausstellungsdatum) {
    _ausstellungsdatum = ausstellungsdatum;
  }
  /**
   * Meldungsart.
   * <br>Format: 2-stellig
   * <br>Mögliche Werte: {@link at.chipkarte.client.aum.soap.constants.Meldungsart Meldungsart}
   * @return Meldungsart
   */
  public String getMeldungsart() {
    return _meldungsart;
  }
  public void setMeldungsart(String meldungsart) {
    _meldungsart = meldungsart;
  }
  /**
   * Zuname des Patienten.
   * <br>Format: maximal 70-stellig
   * @return Zuname des Patienten
   */
  public String getZuname() {
    return _zuname;
  }
  public void setZuname(String zuname) {
    _zuname = zuname;
  }
  /**
   * SV-Nummer des Patienten (bleibt bei EKVK-Patienten leer).
   * <br>Format: 10-stellig
   * @return SV-Nummer des Patienten
   */
  public String getSvNummer() {
    return _svNummer;
  }
   public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }
   /**
    * Code des KVT, an den die Meldung gesendet wurde.
    * <br>Format: 2-stellig
    * @return Code des KVTs
    */
   public String getSvtCode() {
    return _svtCode;
  }
    public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
  /**
   * Vorname des Patienten.
   * <br>Format: maximal 70-stellig
   * @return Vorname des Patienten
   */
  public String getVorname() {
    return _vorname;
  }
  public void setVorname(String vorname) {
    _vorname = vorname;
  }
  /**
   * ID der Meldung.
   * <br>Format: 19-stellig
   * @return ID der Meldung
   */
  public Long getAufID() {
    return _aufID;
  }
  public void setAufID(Long aufID) {
    _aufID = aufID;
  }
  /**
   * Version der Meldung.
   * @return Version der Meldung
   */
  public Integer getAufVersion() {
    return _aufVersion;
  }
  public void setAufVersion(Integer aufVersion) {
    _aufVersion = aufVersion;
  }
  /**
   * Geburtsdatum des Patienten. 
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Geburtsdatum
   */
  public String getGeburtsDatum() {
    return _geburtsDatum;
  }
  public void setGeburtsDatum(String geburtsDatum) {
    _geburtsDatum = geburtsDatum;
  }
  /**
   * Ende der abweichenden Ausgehzeit 1.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 01 und 24
   * @return Ende der abweichenden Ausgehzeit 1
   */
  public String getAbweichendeAusgehzeitBis1() {
    return _abweichendeAusgehzeitBis1;
  }
  public void setAbweichendeAusgehzeitBis1(String abweichAusgang1Bis) {
    _abweichendeAusgehzeitBis1 = abweichAusgang1Bis;
  }
  /**
   * Beginn der abweichenden Ausgehzeit 1.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 00 und 23
   * @return Beginn der abweichenden Ausgehzeit 1
   */
  public String getAbweichendeAusgehzeitVon1() {
    return _abweichendeAusgehzeitVon1;
  }
  public void setAbweichendeAusgehzeitVon1(String abweichAusgang1Von) {
    _abweichendeAusgehzeitVon1 = abweichAusgang1Von;
  }
  /**
   * Ende der abweichenden Ausgehzeit 2.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 01 und 24
   * @return Ende der abweichenden Ausgehzeit 2
   */
  public String getAbweichendeAusgehzeitBis2() {
    return _abweichendeAusgehzeitBis2;
  }
  public void setAbweichendeAusgehzeitBis2(String abweichAusgang2Bis) {
    _abweichendeAusgehzeitBis2 = abweichAusgang2Bis;
  }
  /**
   * Beginn der abweichenden Ausgehzeit 2.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 00 und 23
   * @return Beginn der abweichenden Ausgehzeit 2 
   */
  public String getAbweichendeAusgehzeitVon2() {
    return _abweichendeAusgehzeitVon2;
  }
  public void setAbweichendeAusgehzeitVon2(String abweichAusgang2Von) {
    _abweichendeAusgehzeitVon2 = abweichAusgang2Von;
  }
  /**
   * Gibt an, ob dem Patienten Bettruhe verordnet wird.
   * @return Kennzeichen - Bettruhe verordnet
   */
  public Boolean getBettruhe() {
    return _bettruhe;
  }
  public void setBettruhe(Boolean bettruhe) {
    _bettruhe = bettruhe;
  }
  /**
   * Code für den Bearbeiter einer AU-Meldung im Backend.
   * <br>Mögliche Werte: {@link at.chipkarte.client.aum.soap.constants.AumMelderErgaenzerTypen AumMelderErgaenzerTypen}
   * @return Code für AU-Ergänzer
   */  
  public String getAuErgaenzer() {
    return _auErgaenzer;
  }
  public void setAuErgaenzer(String auErgaenzer) {
    _auErgaenzer = auErgaenzer;
  }
  
  /**
   * Code für den Akteur, der das Datum <i>ArbeitsunfaehigBis</i> (Letzter Tag der AU) gesetzt 
   * oder zuletzt geändert hat.
   * <br>Mögliche Werte: {@link at.chipkarte.client.aum.soap.constants.AumMelderErgaenzerTypen AumMelderErgaenzerTypen}
   * @return Code für AF-Melder
   */   
  public String getAfMelder() {
    return _afMelder;
  }
  public void setAfMelder(String afMelder) {
    _afMelder = afMelder;
  }
  
  /**
   * Kennzeichen, <i>true</i> falls der aktuelle Benutzer der Initialersteller der AU-Meldung ist; 
   * <i>false</i> für "reine" AF-Meldungen oder von anderen Benutzern erstellte AU-Meldungen.
   * @return Kennzeichen AU-selbsterstellt
   */   
  public Boolean getSelbsterstelltAU() {
    return _selbsterstelltAU;
  }
  public void setSelbsterstelltAU(Boolean selbsterstelltAU) {
    _selbsterstelltAU = selbsterstelltAU;
  }
  
  /**
   * Kennzeichen, <i>true</i> falls der aktuelle Benutzer das Datum für <i>ArbeitsunfaehigBis</i> 
   * (Letzter Tag der AU) gesetzt oder zuletzt geändert hat.
   * <br>Bei offenen Meldungen (ohne eingetragenem Wert für <i>ArbeitsunfaehigBis</i> ist das Kennzeichen immer <i>false</i>.
   * @return Kennzeichen AF-selbsterstellt
   */  
  public Boolean getSelbsterstelltAF() {
    return _selbsterstelltAF;
  }
  public void setSelbsterstelltAF(Boolean selbsterstelltAF) {
    _selbsterstelltAF = selbsterstelltAF;
  }
  
  /**
   * Kennzeichen, <i>true</i> falls diese Meldung geändert oder storniert werden kann.
   * @return Kennzeichen AF-selbsterstellt
   */   
  public Boolean isEditierbar() {
    return _editierbar;
  }
  public void setEditierbar(Boolean editierbar) {
    _editierbar = editierbar;
  }
}
