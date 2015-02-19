/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Daten, die nach &Auml;nderung in der UZE gespeichert sein sollen (Funktion changeUzeLa). 
 * D.h. Feldinhalte die sich nicht &auml;ndern sollen, m&uuml;ssen mit dem selben Inhalt wie bei der Abfrage &uuml;bergeben werden. 
 * Wird ein Attribut nicht &uuml;bergeben, wird der, bei der Erstellung gespeicherte, Wert gel&ouml;scht.
 */
public class UzeLaChangeReq {
  private Long _uzeId;
  private Integer _version;
  private String _administrativeVermerke;
  private Adresse _adressePatient;
  private String _emailLa;
  private Kontakt _hausarzt;
  private Kontakt _medVertrauensPerson;
  private String _notizLa;
  private String _ordinationsIdLe;
  private String _taetigkeitsbereichIdLe;
  private String _ordinationszeitenLa;
  private String _patientenVerfuegung;
  private Kontakt _privateKontaktPerson;
  private Kontakt _sachwalter;
  private String _telefonPatient;

  /**
   * Eindeutige ID der UZE.<br>
   * Format: maximal 19-stellig.
   * @return UzeId
   */
  public Long getUzeId() {
    return _uzeId;
  }

  /**
   * Administrative Vermerke, z.B.: soziales Umfeld.<br>
   * Die Angabe der administrativen Vermerke ist optional.<br/>
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
   * Email des Leistungsanforderers.<br>
   * Die Angabe der Email des Leistungsanforderers ist optional.<br/>
   * Format: maximal 50-stellig.
   * @return EmailLa
   */
  public String getEmailLa() {
    return _emailLa;
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
   * Notiz des Leistungsanforderers an den Leistungserbringer.<br>
   * Die Angabe der Notiz des Leistungsanforderers ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return NotizLa
   */
  public String getNotizLa() {
    return _notizLa;
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
   * Wird ignoriert, wenn der Weisungtyp der UZE ungleich "ZO", d.h Zuweisung ohne Patientenkontakt ist.<br>
   * Format: maximal 19-stellig.
   * @return ordinationsIdLe
   */
  public String getOrdinationsIdLe() {
    return _ordinationsIdLe;
  }
  
  /**
   * Tätigkeitsbereich-ID des Leistungserbringers.<br>
   * Die Angabe der TaetigkeitsbereichIdLe ist optional.<br/>
   * Wird ignoriert, wenn der Weisungtyp der UZE ungleich "ZO", d.h Zuweisung ohne Patientenkontakt ist.<br>
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
   * Telefonnummer des Patienten.<br>
   * Die Angabe der Telefonnummer des Patienten ist optional.<br/>
   * Format: maximal 50-stellig.
   * @return TelefonPatient
   */
  public String getTelefonPatient() {
    return _telefonPatient;
  }

  /**
   * Version der UZE.<br>
   * @return Version
   */
  public Integer getVersion() {
    return _version;
  }

  /**
   * Eindeutige ID der UZE.<br>
   * Format: maximal 19-stellig.
   * @param uzeId Der zu setzende Wert f&uuml;r UzeId.
   */
  public void setUzeId(Long uzeId) {
    _uzeId = uzeId;
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
   * @param adressePatient Der zu setzende Wert f&uuml;r AdressePatient.
   */
  public void setAdressePatient(Adresse adressePatient) {
    _adressePatient = adressePatient;
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
   * Daten zum Hausarzt des Patienten.<br>
   * Die Angabe des Hausarztes ist optional.<br/>
   * @param hausarzt Der zu setzende Wert f&uuml;r Hausarzt.
   */
  public void setHausarzt(Kontakt hausarzt) {
    _hausarzt = hausarzt;
  }

  /**
   * Notiz des Leistungsanforderers an den Leistungserbringer.<br>
   * Die Angabe der Notiz des Leistungsanforderers ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param notizLa Der zu setzende Wert f&uuml;r NotizLa.
   */
  public void setNotizLa(String notizLa) {
    _notizLa = notizLa;
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
   * Wird ignoriert, wenn der Weisungtyp der UZE ungleich "ZO", d.h Zuweisung ohne Patientenkontakt ist.<br>
   * Format: maximal 19-stellig. 
   * @param ordinationsIdLe  Der zu setzende Wert f&uuml;r OrdinationLe.
   */
  public void setOrdinationsIdLe(String ordinationsIdLe) {
    _ordinationsIdLe = ordinationsIdLe;
  }
  
  /**
   * Tätigkeitsbereich-ID des Leistungserbringers.<br>
   * Die Angabe der TaetigkeitsbereichIdLe ist optional.<br/>
   * Wird ignoriert, wenn der Weisungtyp der UZE ungleich "ZO", d.h Zuweisung ohne Patientenkontakt ist.<br>
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
   * Telefonnummer des Patienten.<br>
   * Die Angabe der Telefonnummer des Patienten ist optional.<br/>
   * Format: maximal 50-stellig.
   * @param telefonPatient Der zu setzende Wert f&uuml;r TelefonPatient.
   */
  public void setTelefonPatient(String telefonPatient) {
    _telefonPatient = telefonPatient;
  }

  /**
   * Version der UZE.<br>
   * @param version Der zu setzende Wert f&uuml;r Version.
   */
  public void setVersion(Integer version) {
    _version = version;
  }

}
