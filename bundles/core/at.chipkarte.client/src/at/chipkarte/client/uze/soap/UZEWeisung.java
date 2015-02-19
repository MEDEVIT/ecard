/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Daten einer UZE- Weisung.
 */
public class UZEWeisung {
  private Long _uzeId;
  private Integer _version;
  private String _administrativeVermerke;
  private Adresse _adressePatient;
  private Anspruch _anspruch;
  private String _ausstellungsZeitpunkt;
  private String _behandlungsKontext;
  private String _bewilligungsPflichtig;
  private Boolean _bewilligungVorliegend;
  private Boolean _dringlich;
  private String _einloeseZeitpunkt;
  private String _emailLa;
  private String _fachabteilungLe;
  private String _fachgebietLe;
  private String _gueltigBis;
  private Kontakt _hausarzt;
  private Boolean _kblKennzeichen;
  private MedDaten _medizinischeDaten;
  private Kontakt _medVertrauensPerson;
  private VpOrdinationInfo _ordinationLa;
  private VpOrdinationInfo _ordinationLe;
  private String _ordinationszeitenLa; 
  private String _patientenVerfuegung;
  private Kontakt _privateKontaktPerson;
  private Kontakt _sachwalter;
  private String _status;
  private SvPatientInfo _svPatient;
  private String _telefonPatient;
  private String _telefonLa;
  private String _weisungsTyp;
  private String _uzeCode;

  /**
   * ID der UZE.<br>
   * @return UzeId
   */
  public Long getUzeId() {
    return _uzeId;
  }

  /**
   * Administrative Vermerke, z.B.: soziales Umfeld.<br>
   * Format: maximal 500-stellig.
   * @return AdministrativeVermerke
   */
  public String getAdministrativeVermerke() {
    return _administrativeVermerke;
  }

  /**
   * Adresse des Patienten.<br>
   * @return AdressePatient
   */
  public Adresse getAdressePatient() {
    return _adressePatient;
  }

  /**
   * Anspruch, der bei der versicherungsrechtlichen Anspruchspr&uuml;fung bei der Erstellung 
   * oder der Einl&ouml;sung ermittelt wurde.<br>
   * @return Anspruch
   */
  public Anspruch getAnspruch() {
    return _anspruch;
  }

  /**
   * Ausstellungszeitpunkt der UZE.<br>
   * Wird bei der Erstellung der UZE gespeichert.<br>
   * Format TT.MM.JJJJ HH:MM
   * @return AusstellungsZeitpunkt
   */
  public String getAusstellungsZeitpunkt() {
    return _ausstellungsZeitpunkt;
  }

  /**
   * Code des Behandlungskontexts der UZE.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BehandlungsKontext BehandlungsKontext}.<br>
   * Format: 2-stellig.
   * @return BehandlungsKontext
   */
  public String getBehandlungsKontext() {
    return _behandlungsKontext;
  }

  /**
   * Kennzeichen, ob die UZE bewilligungspflichtig ist.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BewilligungsPflichtig BewilligungsPflichtig}.<br>
   * @return BewilligungsPflichtig
   */
  public String getBewilligungsPflichtig() {
    return _bewilligungsPflichtig;
  }

  /**
   * Kennzeichen, ob eine Bewilligung der UZE vorliegt.<br>
   * Dieses Kennzeichen wird bei der Einl&ouml;sung der UZE relevant und mit eingegebenen Wert bef&uuml;llt
   * (davor Bef&uuml;llung mit Defaultwert).<br>
   * @return BewilligungVorliegend
   */
  public Boolean isBewilligungVorliegend() {
    return _bewilligungVorliegend;
  }

  /**
   * Dringlichkeit der UZE.<br>
   * @return Dringlich
   */
  public Boolean isDringlich() {
    return _dringlich;
  }

  /**
   * Zeitpunkt der Einl&ouml;sung.<br>
   * Wird erst bei der Einl&ouml;sung der UZE gespeichert.<br>
   * Format TT.MM.JJJJ HH:MM
   * @return Einloesezeitpunkt
   */
  public String getEinloeseZeitpunkt() {
    return _einloeseZeitpunkt;
  }
  
  /**
   * Email des Leistungsanforderers.<br>
   * Die Angabe der Email des Leistungsanforderers ist optional.<br/>
   * Format: maximal 50-stellig.
   * @return EmailLa
   */
  public String getEmailLa() {
    return _emailLa;
  }

  /**
   * Fachabteilung, zu der zugewiesen wird.<br>
   * Format: maximal 45-stellig.
   * @return FachabteilungLe
   */
  public String getFachabteilungLe() {
    return _fachabteilungLe;
  }

  /**
   * Code des Fachgebiets, zu dem zugewiesen wird (LA) oder das eingel&ouml;st wurde (LE).<br>
   * Format: 2-stellig.
   * @return FachgebietLe
   */
  public String getFachgebietLe() {
    return _fachgebietLe;
  }

  /**
   * Datum, bis zu dem die UZE g&uuml;ltig ist.<br>
   * Wird zum Zeitpunkt der Erstellung der UZE gespeichert (Modifizierungen bewirken keine &Auml;nderung z.B. stornieren
   * und anschließendes zur&uuml;cksetzen)<br>
   * Format: TT.MM.JJJJ
   * @return GueltigBis
   */
  public String getGueltigBis() {
    return _gueltigBis;
  }

  /**
   * Daten zum Hausarzt des Patienten.<br>
   * @return Hausarzt
   */
  public Kontakt getHausarzt() {
    return _hausarzt;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt (abrechenbar mit KVT).<br>
   * @return KblKennzeichen
   */
  public Boolean isKblKennzeichen() {
    return _kblKennzeichen;
  }

  /**
   * Medizinische Daten zum Patienten.<br>
   * @return MedizinischeDaten
   */
  public MedDaten getMedizinischeDaten() {
    return _medizinischeDaten;
  }

  /**
   * Daten zur medizinischen Vertrauensperson.<br>
   * @return MedVertrauensPerson
   */
  public Kontakt getMedVertrauensPerson() {
    return _medVertrauensPerson;
  }

  /**
   * Ordinationsinformation des Leistungsanforderers.<br>
   * Wird bei der Erstellung der UZE gespeichert.<br>
   * @return OrdinationLa
   */
  public VpOrdinationInfo getOrdinationLa() {
    return _ordinationLa;
  }

  /**
   * Ordinationsinformation des Leistungserbringers.<br>
   * Wird bei UZE ohne Patientenkontakt (ZO) bei der Erstellung, bei allen anderen Weisungstypen bei der Einl&ouml;sung 
   * gespeichert.<br>
   * @return OrdinationLe
   */
  public VpOrdinationInfo getOrdinationLe() {
    return _ordinationLe;
  }

  /**
   * Ordinationszeiten des Leistungsanfoderers.<br/>
   * Die Angabe der Ordinationszeiten des Leistungsanfoderers ist optional.<br/>
   * Format: maximal 200-stellig.
   * @return OrdinationszeitenLa
   */
  public String getOrdinationszeitenLa() {
    return _ordinationszeitenLa;
  }  

  /**
   * Angaben zur Patientenverf&uuml;gung; z.B. wo sie aufliegt.<br>
   * Format: maximal 500-stellig.
   * @return PatientenVerfuegung
   */
  public String getPatientenVerfuegung() {
    return _patientenVerfuegung;
  }

  /**
   * Daten zu einer privaten Kontaktperson.<br>
   * @return PrivateKontaktPerson
   */
  public Kontakt getPrivateKontaktPerson() {
    return _privateKontaktPerson;
  }

  /**
   * Daten zum Sachwalter.<br>
   * @return Sachwalter
   */
  public Kontakt getSachwalter() {
    return _sachwalter;
  }

  /**
   * Code des Status der UZE.<br>
   * Wird bei Erstellung, Stornierung und Einl&ouml;sung jeweils neu gespeichert.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.Status Status}.<br>
   * Format: 1-stellig.
   * @return Status
   */
  public String getStatus() {
    return _status;
  }

  /**
   * Daten eines SV-Patient.<br>
   * @return SvPatient
   */
  public SvPatientInfo getSvPatient() {
    return _svPatient;
  }

  /**
   * Telefonnummer des Patienten.<br>
   * Format: maximal 50-stellig.
   * @return TelefonPatient
   */
  public String getTelefonPatient() {
    return _telefonPatient;
  }

  /**
   * Telefonnummer des Leistungsanforderers.<br>
   * Format: maximal 50-stellig.
   * @return TelefonLa
   */
  public String getTelefonLa() {
    return _telefonLa;
  }

  /**
   * Patienteneindeutiger Code der UZE.<br>
   * @return UzeCode
   */
  public String getUzeCode() {
    return _uzeCode;
  }  

  /**
   * Version der UZE.<br>
   * @return Version
   */
  public Integer getVersion() {
    return _version;
  }

  /**
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: 2-stellig.
   * @return WeisungsTyp
   */
  public String getWeisungsTyp() {
    return _weisungsTyp;
  }

  /**
   * ID der UZE.<br>
   * 
   * @param uzeId Der zu setzende Wert f&uuml;r UzeId.
   */
  public void setUzeId(Long uzeId) {
    _uzeId = uzeId;
  }

  /**
   * Administrative Vermerke, z.B.: soziales Umfeld.<br>
   * Format: maximal 500-stellig.
   * @param administrativeVermerke Der zu setzende Wert f&uuml;r AdministrativeVermerke.
   */
  public void setAdministrativeVermerke(String administrativeVermerke) {
    _administrativeVermerke = administrativeVermerke;
  }

  /**
   * Adresse des Patienten.<br>
   * @param adressePatient Der zu setzende Wert f&uuml;r AdressePatient.
   */
  public void setAdressePatient(Adresse adressePatient) {
    _adressePatient = adressePatient;
  }

  /**
   * Anspruch, der bei der versicherungsrechtlichen Anspruchspr&uuml;fung bei der Erstellung oder 
   * der Einl&ouml;sung ermittelt wurde.<br>
   * @param anspruch Der zu setzende Wert f&uuml;r Anspruch.
   */
  public void setAnspruch(Anspruch anspruch) {
    _anspruch = anspruch;
  }

  /**
   * Ausstellungszeitpunkt der UZE.<br>
   * Wird bei der Erstellung der UZE gespeichert.<br>
   * Format TT.MM.JJJJ HH:MM, maximal 16-stellig.
   * @param ausstellungsZeitpunkt Der zu setzende Wert f&uuml;r AusstellungsZeitpunkt.
   */
  public void setAusstellungsZeitpunkt(String ausstellungsZeitpunkt) {
    _ausstellungsZeitpunkt = ausstellungsZeitpunkt;
  }

  /**
   * Code des Behandlungskontexts der UZE.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BehandlungsKontext BehandlungsKontext}.<br>
   * Format: maximal 2-stellig.
   * @param behandlungsKontext Der zu setzende Wert f&uuml;r BehandlungsKontext.
   */
  public void setBehandlungsKontext(String behandlungsKontext) {
    _behandlungsKontext = behandlungsKontext;
  }

  /**
   * Kennzeichen, ob die UZE bewilligungspflichtig ist.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BewilligungsPflichtig BewilligungsPflichtig}.<br>
   * @param bewilligungsPflichtig Der zu setzende Wert f&uuml;r BewilligungsPflicht.
   */
  public void setBewilligungsPflichtig(String bewilligungsPflichtig) {
    _bewilligungsPflichtig = bewilligungsPflichtig;
  }

  /**
   * Kennzeichen, ob eine Bewilligung der UZE vorliegt.<br>
   * Dieses Kennzeichen wird bei der Einl&ouml;sung der UZE relevant und mit eingegebenen Wert bef&uuml;llt
   * (davor Bef&uuml;llung mit Defaultwert).<br>
   * @param bewilligungVorliegend Der zu setzende Wert f&uuml;r BewilligungVorliegend.
   */
  public void setBewilligungVorliegend(Boolean bewilligungVorliegend) {
    _bewilligungVorliegend = bewilligungVorliegend;
  }

  /**
   * Dringlichkeit der UZE.<br>
   * @param dringlich Der zu setzende Wert f&uuml;r Dringlich.
   */
  public void setDringlich(Boolean dringlich) {
    _dringlich = dringlich;
  }

  /**
   * Zeitpunkt der Einl&ouml;sung.<br>
   * Wird erst bei der Einl&ouml;sung der UZE gespeichert.<br>
   * Format TT.MM.JJJJ HH:MM, maximal 16-stellig.
   * @param einloeseZeitpunkt Der zu setzende Wert f&uuml;r EinloeseZeitpunkt.
   */
  public void setEinloeseZeitpunkt(String einloeseZeitpunkt) {
    _einloeseZeitpunkt = einloeseZeitpunkt;
  }
  
  /**
   * Email des Leistungsanforderers.<br>
   * Die Angabe der Email des Leistungsanforderers ist optional.<br/>
   * Format: maximal 50-stellig.
   * @param emailLa Email des Leistungsanforderers als String
   */
  public void setEmailLa(String emailLa) {
    _emailLa = emailLa;
  }
  
  /**
   * Fachabteilung, zu der zugewiesen wird.<br>
   * Format: maximal 45-stellig.
   * @param fachabteilungLe Der zu setzende Wert f&uuml;r FachabteilungLe.
   */
  public void setFachabteilungLe(String fachabteilungLe) {
    _fachabteilungLe = fachabteilungLe;
  }

  /**
   * Code des Fachgebiets, zu dem zugewiesen wird (LA) oder das eingel&ouml;st wurde (LE).<br>
   * Format: maximal 2-stellig.
   * @param fachgebietLe Der zu setzende Wert f&uuml;r FachgebietLe.
   */
  public void setFachgebietLe(String fachgebietLe) {
    _fachgebietLe = fachgebietLe;
  }

  /**
   * Datum, bis zu dem die UZE g&uuml;ltig ist.<br>
   * Wird zum Zeitpunkt der Erstellung der UZE gespeichert (Modifizierungen bewirken keine &Auml;nderung z.B. stornieren
   * und anschließendes zur&uuml;cksetzen)<br>
   * Format: TT.MM.JJJJ, maximal 10-stellig.
   * @param gueltigBis Der zu setzende Wert f&uuml;r GueltigBis.
   */
  public void setGueltigBis(String gueltigBis) {
    _gueltigBis = gueltigBis;
  }

  /**
   * Daten zum Hausarzt des Patienten.<br>
   * @param hausarzt Der zu setzende Wert f&uuml;r Hausarzt.
   */
  public void setHausarzt(Kontakt hausarzt) {
    _hausarzt = hausarzt;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt (abrechenbar mit KVT).<br>
   * @param kblKennzeichen Der zu setzende Wert f&uuml;r KblKennzeichen.
   */
  public void setKblKennzeichen(Boolean kblKennzeichen) {
    _kblKennzeichen = kblKennzeichen;
  }

  /**
   * Medizinische Daten zum Patienten.<br>
   * @param medizinischeDaten Der zu setzende Wert f&uuml;r MedizinischeDaten.
   */
  public void setMedizinischeDaten(MedDaten medizinischeDaten) {
    _medizinischeDaten = medizinischeDaten;
  }

  /**
   * Daten zur medizinischen Vertrauensperson.<br>
   * @param medVertrauensPerson Der zu setzende Wert f&uuml;r MedVertrauensPerson.
   */
  public void setMedVertrauensPerson(Kontakt medVertrauensPerson) {
    _medVertrauensPerson = medVertrauensPerson;
  }

  /**
   * Ordinationsinformation des Leistungsanforderers.<br>
   * Wird bei der Erstellung der UZE gespeichert.<br>
   * @param ordinationLa Der zu setzende Wert f&uuml;r OrdinationLa.
   */
  public void setOrdinationLa(VpOrdinationInfo ordinationLa) {
    _ordinationLa = ordinationLa;
  }

  /**
   * Ordinationsinformation des Leistungserbringers.<br>
   * Wird bei UZE ohne Patientenkontakt (ZO) bei der Erstellung, bei allen anderen Weisungstypen bei der Einl&ouml;sung
   * gespeichert.<br>
   * @param ordinationLe Der zu setzende Wert f&uuml;r OrdinationLe.
   */
  public void setOrdinationLe(VpOrdinationInfo ordinationLe) {
    _ordinationLe = ordinationLe;
  }


  /**
   * Ordinationszeiten des Leistungsanfoderers.<br/>
   * Die Angabe der Ordinationszeiten des Leistungsanfoderers ist optional.<br/>
   * Format: maximal 200-stellig.
   * @param ordinationszeitenLa Ordinationszeiten des Leistungsanfoderers
   */
  public void setOrdinationszeitenLa(String ordinationszeitenLa) {
    _ordinationszeitenLa = ordinationszeitenLa;
  }

  /**
   * Angaben zur Patientenverf&uuml;gung; z.B. wo sie aufliegt.<br>
   * Format: maximal 500-stellig.
   * @param patientenVerfuegung Der zu setzende Wert f&uuml;r PatientenVerfuegung.
   */
  public void setPatientenVerfuegung(String patientenVerfuegung) {
    _patientenVerfuegung = patientenVerfuegung;
  }

  /**
   * Daten zu einer privaten Kontaktperson.<br>
   * @param privateKontaktPerson Der zu setzende Wert f&uuml;r PrivateKontaktPerson.
   */
  public void setPrivateKontaktPerson(Kontakt privateKontaktPerson) {
    _privateKontaktPerson = privateKontaktPerson;
  }

  /**
   * Daten zum Sachwalter.<br>
   * @param sachwalter Der zu setzende Wert f&uuml;r Sachwalter.
   */
  public void setSachwalter(Kontakt sachwalter) {
    _sachwalter = sachwalter;
  }

  /**
   * Code des Status der UZE.<br>
   * Wird bei Erstellung, Stornierung und Einl&ouml;sung jeweils neu gespeichert.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.Status Status}.<br>
   * Format: 1-stellig.
   * @param status Der zu setzende Wert f&uuml;r Status.
   */
  public void setStatus(String status) {
    _status = status;
  }

  /**
   * Daten eines SV-Patient.<br>
   * @param svPatient Der zu setzende Wert f&uuml;r SvPatient.
   */
  public void setSvPatient(SvPatientInfo svPatient) {
    _svPatient = svPatient;
  }

  /**
   * Telefonnummer des Patienten.<br>
   * Format: maximal 50-stellig.
   * @param telefonPatient Der zu setzende Wert f&uuml;r TelefonPatient.
   */
  public void setTelefonPatient(String telefonPatient) {
    _telefonPatient = telefonPatient;
  }

  /**
   * Telefonnummer des Leistungsanforderers.<br>
   * Format: maximal 50-stellig.
   * @param telefonLa Der zu setzende Wert f&uuml;r TelefonLa.
   */
  public void setTelefonLa(String telefonLa) {
    _telefonLa = telefonLa;
  }

  /**
   * Patienteneindeutiger Code der UZE.<br>
   * @param uzeCode Der zu setzende Wert f&uuml;r UzeCode.
   */
  public void setUzeCode(String uzeCode) {
    _uzeCode = uzeCode;
  }

  /**
   * Version der UZE.<br>
   * @param version Der zu setzende Wert f&uuml;r Version.
   */
  public void setVersion(Integer version) {
    _version = version;
  }

  /**
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: 2-stellig.
   * @param weisungsTyp Der zu setzende Wert f&uuml;r Weisungstyp.
   */
  public void setWeisungsTyp(String weisungsTyp) {
    _weisungsTyp = weisungsTyp;
  }
}
