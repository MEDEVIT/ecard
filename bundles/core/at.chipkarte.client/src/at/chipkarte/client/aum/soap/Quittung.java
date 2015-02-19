/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.aum.soap;

/**
 * Datenstruktur für die Daten einer am Server angelegten bzw. ge&auml;nderten
 * AU- oder AF-Meldung.
 * Wird von den Methoden, die Meldungen anlegen oder ändern sowie 
 * von {@link IAumService#detailDatenAbfragen(String, long)} zurückgegeben. <br>
 * Enth&auml;lt, au&szlig;er der vom Benutzer eingegebenen Daten auch vom Server
 * gesetzte Felder, n&auml;mlich: {@link #getId() Id}, {@link #getVersion() Version},
 * {@link #getMeldungsart() Meldungsart} und {@link #getAusstellungsDatum() Ausstellungsdatum}.
 */
public class Quittung {
  private Long _id;
  private Integer _version;
  private String _meldungsart;
  private String _ausstellungsDatum;
  private Meldungsdaten _meldungsdaten;
  private Person _personendaten;
  private Boolean _ungeprueft;
  private String _auErgaenzer;
  private String _afMelder;
  private Boolean _selbsterstelltAU;
  private Boolean _selbsterstelltAF;
  private Boolean _editierbar;
  /**
   * Datenstruktur für die Personendaten.
   * <br>Siehe auch: {@link at.chipkarte.client.aum.soap.Meldung.Person Person}
   * @return Personendaten
   */
  public Person getPersonendaten() {
    return _personendaten;
  }
  public void setPersonendaten(Person personendaten) {
    _personendaten = personendaten;
  }
  /**
   * ID der Meldung.
   * <br>Format:  maximal 19-stellig
   * @return ID der Meldung
   */
  public Long getId() {
    return _id;
  }
  public void setId(Long id) {
    _id = id;
  }
  /**
   * Die Datenstruktur mit allen Daten der AU- oder AF-Meldung.
   * <br>Siehe auch: {@link at.chipkarte.client.aum.soap.Meldungsdaten Meldungsdaten}
   * @return Datenobjekt Meldungsdaten
   */
  public Meldungsdaten getMeldungsdaten() {
    return _meldungsdaten;
  }
  public void setMeldungsdaten(Meldungsdaten meldungsdaten) {
    _meldungsdaten = meldungsdaten;
  }
  /**
   * Art der Meldung.
   * <br>Format:  2-stellig 
   * <br>Mögliche Werte: {@link at.chipkarte.client.aum.soap.constants.Meldungsart Meldungsart}.
   * @return Art der Meldung
   */
  public String getMeldungsart() {
    return _meldungsart;
  }
  public void setMeldungsart(String meldungsart) {
    _meldungsart = meldungsart;
  }
  /**
   * Version der Meldung.
   * @return Version der Meldung
   */
  public Integer getVersion() {
    return _version;
  }
  public void setVersion(Integer version) {
    _version = version;
  }
  
  /**
   * Ausstellungsdatum der Meldung (<b>NICHT</b> vom Benutzer zu setzen, wird intern versorgt).
   * <br>Format:  10-stellig, TT.MM.JJJJ
   * @return Ausstellungsdatum der Meldung
   */
  public String getAusstellungsDatum() {
    return _ausstellungsDatum;
  }
  public void setAusstellungsDatum(String ausstellungsDatum) {
    _ausstellungsDatum = ausstellungsDatum;
  }
  
  /**
   * Gibt an, ob die Meldung "ohne Anspruch" angelegt wurde - für einen Patienten, 
   * der keinen für die elektronische Arbeitsunfähigkeitsmeldung gültigen Anspruch hat.
   * @return Kennzeichen für eine Meldung "ohne Anspruch"
   */  
  public Boolean getUngeprueft() {
    return _ungeprueft;
  }
  public void setUngeprueft(Boolean ungeprueft) {
    _ungeprueft = ungeprueft;
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
