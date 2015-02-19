/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion storeUze.
 */
public class StoreUzeReq {
  private String _administrativeVermerke;
  private Adresse _adressePatient;
  private String _anspruchId;
  private String _behandlungsKontext;
  private String _bewilligungsPflichtig;
  private Boolean _dringend;
  private String _emailLa;
  private String _fachabteilungLe;
  private String _fachgebietLe;
  private Kontakt _hausarzt;
  private Boolean _kblKennzeichen;
  private StoreUzeMedDaten _medizinischeDaten;
  private Kontakt _medVertrauensPerson;
  private String _ordinationsIdLe;
  private String _taetigkeitsbereichIdLe;
  private String _ordinationszeitenLa;
  private String _patientenVerfuegung;
  private Kontakt _privateKontaktPerson;
  private Kontakt _sachwalter;
  private String _svtCode;
  private String _telefonPatient;
  private String _telefonLa;
  private String _svNummer;
  private String _weisungsTyp;
 
  /**
   * Administrative Vermerke, z.B.: soziales Umfeld.<br>
   * Die Angabe von administrativen Vermerken ist optional.<br/>
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
   * ID des eigenen Anspruchs oder eines abgeleiteten Anspruchs, welcher bei einem vorherigen Aufruf dieser
   * Funktion in einer der {@link at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException UzeAnspruchException}
   * zurückgeliefert wurde.<br>
   * Die Angabe der AnspruchsId ist optional.<br/>
   * Wird ignoriert, wenn Krankenbehandlungsleistung Kennzeichen NEIN.<br>
   * Wenn SvtCode angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * @return AnspruchId
   */
  public String getAnspruchId() {
    return _anspruchId;
  }

  /**
   * Behandlungskontext der UZE.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BehandlungsKontext BehandlungsKontext}.<br>
   * Format: maximal 2-stellig.
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
   * Dringlichkeit der UZE.<br>
   * @return Dringend
   */
  public Boolean isDringend() {
    return _dringend;
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
   * Die Angabe der FachabteilungLe ist optional.<br/>
   * Format: maximal 45-stellig.
   * @return FachabteilungLe
   */
  public String getFachabteilungLe() {
    return _fachabteilungLe;
  }

  /**
   * Code des Fachgebiets, zu dem zugewiesen wird.<br>
   * Format: maximal 2-stellig.
   * @return FachgebietLe
   */
  public String getFachgebietLe() {
    return _fachgebietLe;
  }

  /**
   * Daten zum Hausarzt des Patienten.<br>
   * Die Angabe des Hausarztes ist optional.<br/>
   * @return Hausarzt
   */
  public Kontakt getHausarzt() {
    return _hausarzt;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt.<br>
   * @return KblKennzeichen
   */
  public Boolean isKblKennzeichen() {
    return _kblKennzeichen;
  }

  /**
   * Medizinische Daten.<br>
   * @return MedizinischeDaten
   */
  public StoreUzeMedDaten getMedizinischeDaten() {
    return _medizinischeDaten;
  }

  /**
   * Daten zur medizinischen Vertrauensperson.<br>
   * Die Angabe der medizinischen Vertrauensperson ist optional.<br/>
   * @return MedVertrauensPerson
   */
  public Kontakt getMedVertrauensPerson() {
    return _medVertrauensPerson;
  }

  /**
   * Ordinations ID des Leistungserbringers.<br>
   * Die Angabe der Ordinations ID des Leistungserbringers ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt<br>
   * Format: maximal 19-stellig.
   * @return OrdinationsIdLe
   */
  public String getOrdinationsIdLe() {
    return _ordinationsIdLe;
  }
  
  /**
   * Tätigkeitsbereich-ID des Leistungserbringers.<br>
   * Die Angabe der TaetigkeitsbereichIdLe ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @return TaetigkeitsbereichIdLe
   */
  public String getTaetigkeitsbereichIdLe() {
    return _taetigkeitsbereichIdLe;
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
   * Angaben zur Patientenverfügung; z.B. wo sie aufliegt.<br>
   * Die Angabe der Patientenverfügung ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return PatientenVerfuegung
   */
  public String getPatientenVerfuegung() {
    return _patientenVerfuegung;
  }

  /**
   * Daten zu einer privaten Kontaktperson.<br>
   * Die Angabe der privaten Kontaktperson ist optional.<br/>
   * @return PrivateKontaktPerson
   */
  public Kontakt getPrivateKontaktPerson() {
    return _privateKontaktPerson;
  }

  /**
   * Daten zum Sachwalter.<br>
   * Die Angabe des Sachwalters ist optional.<br/>
   * @return Sachwalter
   */
  public Kontakt getSachwalter() {
    return _sachwalter;
  }

  /**
   * Code des SVT der SV-Person.<br>
   * Die Angabe des SvtCodes ist optional.<br/>
   * Wird ignoriert, wenn Krankenbehandlungsleistung-Kennzeichen = NEIN.<br>
   * Wenn die AnspruchsId angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Format: 2-stellig.
   * @return SvtCode
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Telefonnummer des Patienten.<br>
   * Die Angabe der Telefonnummer des Patienten ist optional.<br/>
   * Format: maximal 50-stellig.
   * @return TelefonPatient
   */
  public String getTelefonPatient() {
    return _telefonPatient;
  }

  /**
   * Telefonnummer des Leistungsanforderers.<br>
   * Format: maximal 50-stellig.
   * @return TelefonLA
   */
  public String getTelefonLa() {
    return _telefonLa;
  }

  /**
   * SV-Nummer der SV-Person.<br>
   * Die Angabe der SV-Nummer ist optional.<br/>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.<br>
   * Ist eine AnspruchId angegeben, muss eine SV- Nummer angegeben sein.<br>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: maximal 2-stellig.
   * @return WeisungsTyp
   */
  public String getWeisungsTyp() {
    return _weisungsTyp;
  }

  /**
   * Administrative Vermerke, z.B.: soziales Umfeld.<br>
   * Die Angabe der administrativen Vermerke ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param administrativeVermerke Der zu setzende Wert f&uuml;r AdministrativeVermerke.
   */
  public void setAdministrativeVermerke(String administrativeVermerke) {
    _administrativeVermerke = administrativeVermerke;
  }

  /**
   * Adresse des Patienten.<br>
   Adresse* @param adressePatient Der zu setzende Wert f&uuml;r AdressePatient.
   */
  public void setAdressePatient(Adresse adressePatient) {
    _adressePatient = adressePatient;
  }

  /**
   * ID des eigenen Anspruchs oder eines abgeleiteten Anspruchs, welcher bei einem vorherigen Aufruf dieser
   * Funktion in einer der {@link at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException UzeAnspruchException}
   * zurückgeliefert wurde.<br>
   * Die Angabe der AnspruchsId ist optional.<br/>
   * Wird ignoriert, wenn Krankenbehandlungsleistung Kennzeichen NEIN.<br>
   * Wenn SvtCode angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * @param anspruchId Der zu setzende Wert f&uuml;r AnspruchId.
   */
  public void setAnspruchId(String anspruchId) {
    _anspruchId = anspruchId;
  }

  /**
   * Behandlungskontext der UZE.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BehandlungsKontext BehandlungsKontext}.<br>
   * Format: 2-stellig.
   * @param behandlungsKontext Der zu setzende Wert f&uuml;r BehandlungsKontext.
   */
  public void setBehandlungsKontext(String behandlungsKontext) {
    _behandlungsKontext = behandlungsKontext;
  }

  /**
   * Kennzeichen, ob die UZE bewilligungspflichtig ist.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BewilligungsPflichtig BewilligungsPflichtig}.<br>
   * @param bewilligungsPflichtig Der zu setzende Wert f&uuml;r BewilligungsPflichtig.
   */
  public void setBewilligungsPflichtig(String bewilligungsPflichtig) {
    _bewilligungsPflichtig = bewilligungsPflichtig;
  }

  /**
   * Dringlichkeit der UZE.<br>
   * @param dringend Der zu setzende Wert f&uuml;r Dringend.
   */
  public void setDringend(Boolean dringend) {
    _dringend = dringend;
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
   * Die Angabe der FachabteilungLe ist optional.<br/>
   * Format: maximal 45-stellig.
   * @param fachabteilungLe Der zu setzende Wert f&uuml;r FachabteilungLe.
   */
  public void setFachabteilungLe(String fachabteilungLe) {
    _fachabteilungLe = fachabteilungLe;
  }

  /**
   * Code des Fachgebiets, zu dem zugewiesen wird.<br>
   * Format: 2-stellig.
   * @param fachgebietLe Der zu setzende Wert f&uuml;r FachgebietLe.
   */
  public void setFachgebietLe(String fachgebietLe) {
    _fachgebietLe = fachgebietLe;
  }

  /**
   * Daten zum Hausarzt des Patienten.<br>
   * Die Angabe des Hausarztes ist optional.<br/>
   * @param hausarzt Der zu setzende Wert f&uuml;r Hausarzt.
   */
  public void setHausarzt(Kontakt hausarzt) {
    _hausarzt = hausarzt;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt.<br>
   * @param kblKennzeichen Der zu setzende Wert f&uuml;r KblKennzeichen.
   */
  public void setKblKennzeichen(Boolean kblKennzeichen) {
    _kblKennzeichen = kblKennzeichen;
  }

  /**
   * Medizinische Daten.<br>
   * @param medizinischeDaten Der zu setzende Wert f&uuml;r MedizinischeDaten.
   */
  public void setMedizinischeDaten(StoreUzeMedDaten medizinischeDaten) {
    _medizinischeDaten = medizinischeDaten;
  }

  /**
   * Daten zur medizinischen Vertrauensperson.<br>
   * Die Angabe der medizinischen Vertrauensperson ist optional.<br/>
   * @param medVertrauensPerson Der zu setzende Wert f&uuml;r MedVertrauensPerson.
   */
  public void setMedVertrauensPerson(Kontakt medVertrauensPerson) {
    _medVertrauensPerson = medVertrauensPerson;
  }

  /**
   * Ordinations ID des Leistungserbringers.<br>
   * Die Angabe der Ordinations ID des Leistungserbringers ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @param ordinationsIdLe Der zu setzende Wert f&uuml;r OrdinationsIdLe.
   */
  public void setOrdinationsIdLe(String ordinationsIdLe) {
    _ordinationsIdLe = ordinationsIdLe;
  }
  
  /**
   * Tätigkeitsbereich-ID des Leistungserbringers.<br>
   * Die Angabe der TaetigkeitsbereichIdLe ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @param taetigkeitsbereichIdLe Der zu setzende Wert f&uuml;r TaetigkeitsbereichIdLe.
   */
  public void setTaetigkeitsbereichIdLe(String taetigkeitsbereichIdLe) {
    _taetigkeitsbereichIdLe = taetigkeitsbereichIdLe;
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
   * Angaben zur Patientenverfügung; z.B. wo sie aufliegt.<br>
   * Die Angabe der Patientenverfügung ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param patientenVerfuegung Der zu setzende Wert f&uuml;r PatientenVerfuegung.
   */
  public void setPatientenVerfuegung(String patientenVerfuegung) {
    _patientenVerfuegung = patientenVerfuegung;
  }

  /**
   * Daten zu einer privaten Kontaktperson.<br>
   * Die Angabe der privaten Kontaktperson ist optional.<br/>
   * @param privateKontaktPerson Der zu setzende Wert f&uuml;r PrivateKontaktPerson.
   */
  public void setPrivateKontaktPerson(Kontakt privateKontaktPerson) {
    _privateKontaktPerson = privateKontaktPerson;
  }

  /**
   * Daten zum Sachwalter.<br>
   * Die Angabe des Sachwalters ist optional.<br/>
   * @param sachwalter Der zu setzende Wert f&uuml;r Sachwalter.
   */
  public void setSachwalter(Kontakt sachwalter) {
    _sachwalter = sachwalter;
  }

  /**
   * Code des SVT der SV-Person.<br>
   * Die Angabe des SvtCodes ist optional.<br/>
   * Wird ignoriert, wenn Krankenbehandlungsleistung-Kennzeichen = NEIN.<br>
   * Wenn AnspruchId angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Format: 2-stellig.
   * @param svtCode Der zu setzende Wert f&uuml;r SvtCode.
   */
  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  /**
   * Telefonnummer des Patienten.<br>
   * Die Angabe der Telefonnummer des Patienten ist optional.<br/>
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
   * SV-Nummer der SV-Person.<br>
   * Die Angabe der SV-Nummer ist optional.<br/>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.<br>
   * Ist eine AnspruchId angegeben, muss eine SV- Nummer angegeben sein.<br>
   * Format: 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Code des Weisungstyps der UZE. Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: maximal 2-stellig.
   * @param weisungsTyp Der zu setzende Wert f&uuml;r WeisungsTyp.
   */
  public void setWeisungsTyp(String weisungsTyp) {
    _weisungsTyp = weisungsTyp;
  }

}
