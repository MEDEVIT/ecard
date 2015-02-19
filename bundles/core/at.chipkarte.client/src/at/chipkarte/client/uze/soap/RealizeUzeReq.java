/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten der Funktion "realizeUze".
 */
public class RealizeUzeReq {
  private String _anspruchId;
  private String _bewilligungsPflichtig;
  private Boolean _bewilligungVorliegend;
  private ECardTicket _ecardTicket;
  private String _fachgebietEinloesung;
  private Boolean _kblKennzeichen;
  private String _svtCode;
  private Long _uzeId;
  private String _uzeCode;
  private Integer _version;

  /**
   * ID des eigenen Anspruchs oder eines abgeleiteten Anspruchs, welcher bei einem vorherigen Aufruf 
   * dieser Funktion in einer der {@link at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException UzeAnspruchException} 
   * zurückgeliefert wurde.<br>
   * Wird ignoriert, wenn KBL Kennzeichen NEIN.<br>
   * Wenn SvtCode angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Format: maximal 19-stellig.
   * @return AnspruchId
   */
  public String getAnspruchId() {
    return _anspruchId;
  }

  /**
   * Kennzeichen, ob die UZE bewilligungspflichtig ist.<br>
   * @return BewilligungsPflichtig
   */
  public String getBewilligungsPflichtig() {
    return _bewilligungsPflichtig;
  }

  /**
   * Kennzeichen, ob eine Bewilligung der UZE vorliegt.<br>
   * @return BewilligungVorliegend
   */
  public Boolean isBewilligungVorliegend() {
    return _bewilligungVorliegend;
  }

  /**
   * Enth&auml;lt die Signatur zur Sicherstellung der Echtheit der verwendeten e-card 
   * bei der Suche nach einl&ouml;sbaren UZE mit Patientenkontakt.<br>
   * Die Angabe des EcardTicket ist optional.<br/>
   * Muss versorgt sein, wenn die Einl&ouml;sung ohne UZE Code erfolgt.
   * @return EcardTicket
   */
  public ECardTicket getEcardTicket() {
    return _ecardTicket;
  }

  /**
   * Code des Fachgebiets, mit dem die UZE eingelöst werden soll.<br>
   * Format: 2-stellig.
   * @return Fachgebiet der Einlösung
   */
  public String getFachgebietEinloesung() {
    return _fachgebietEinloesung;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt.<br>
   * @return KblKennzeichen
   */
  public Boolean isKblKennzeichen() {
    return _kblKennzeichen;
  }

  /**
   * Code des SVT der SV-Person.<br>
   * Die Angabe des SvtCodes ist optional.<br/>
   * Wird ignoriert, wenn KBL Kennzeichen NEIN.<br>
   * Wenn Anspruch ID angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Anmerkung: Darf nur versorgt sein, wenn eine neuerliche Anspruchspr&uuml;fung erfolgen soll 
   * (wenn bei der Erstellung der UZE kein Anspruch angegeben wurde bzw. eine &Auml;nderung 
   * des bei der Erstellung gew&auml;hlten SVT gewünscht ist).<br>
   * Format: maximal 2-stellig.
   * @return SvtCode
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Eindeutige ID der einzul&ouml;senden UZE.<br>
   * @return UzeId
   */
  public Long getUzeId() {
    return _uzeId;
  }

  /**
   * Der generierte Code einer UZE. Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal einer UZE.<br>
   * Die Angabe des UzeCode ist optional.<br/>
   * Der UzeCode muss versorgt sein, wenn das e-card Ticket nicht versorgt ist.<br>
   * Format: maximal 5-stellig.
   * @return UzeCode
   */
  public String getUzeCode() {
    return _uzeCode;
  }

  /**
   * Version der einzul&ouml;senden UZE.<br>
   * @return Version
   */
  public Integer getVersion() {
    return _version;
  }

  /**
   * ID des eigenen Anspruchs oder eines abgeleiteten Anspruchs, welcher bei einem vorherigen Aufruf 
   * dieser Funktion in einer der {@link at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException UzeAnspruchException}
   * zurückgeliefert wurde.<br>
   * Die Angabe des AnspruchsId ist optional.<br/>
   * Sie wird ignoriert, wenn KBL Kennzeichen NEIN.<br>
   * Wenn ein SvtCode angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Format: maximal 19-stellig.
   * @param anspruchId Der zu setzende Wert f&uuml;r AnspruchId.
   */
  public void setAnspruchId(String anspruchId) {
    _anspruchId = anspruchId;
  }

  /**
   * Kennzeichen, ob die UZE bewilligungspflichtig ist.<br>
   * @param bewilligungsPflichtig Der zu setzende Wert f&uuml;r BewilligungsPflicht.
   */
  public void setBewilligungsPflichtig(String bewilligungsPflichtig) {
    _bewilligungsPflichtig = bewilligungsPflichtig;
  }

  /**
   * Kennzeichen, ob eine Bewilligung der UZE vorliegt.<br>
   * @param bewilligungVorliegend Der zu setzende Wert f&uuml;r BewilligungVorliegend.
   */
  public void setBewilligungVorliegend(Boolean bewilligungVorliegend) {
    _bewilligungVorliegend = bewilligungVorliegend;
  }

  /**
   * Enth&auml;lt die Signatur zur Sicherstellung der Echtheit der verwendeten e-card 
   * bei der Suche nach einl&ouml;sbaren UZE mit Patientenkontakt.<br>
   * Die Angabe von EcardTicket ist optional.<br/>
   * Muss versorgt sein, wenn die Einl&ouml;sung ohne UZE Code erfolgt.
   * @param ecardTicket Der zu setzende Wert f&uuml;r EcardTicket.
   */
  public void setEcardTicket(ECardTicket ecardTicket) {
    _ecardTicket = ecardTicket;
  }

  /**
   * Code des Fachgebiets, mit dem die UZE eingelöst werden soll.<br>
   * Format: 2-stellig.
   * @param fachgebietEinloesung Der zu setzende Wert f&uuml;r das Fachgebiet der Einlösung.
   */
  public void setFachgebietEinloesung(String fachgebietEinloesung) {
    _fachgebietEinloesung = fachgebietEinloesung;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt.<br>
   * @param kblKennzeichen Der zu setzende Wert f&uuml;r KblKennzeichen.
   */
  public void setKblKennzeichen(Boolean kblKennzeichen) {
    _kblKennzeichen = kblKennzeichen;
  }

  /**
   * Code des SVT der SV-Person.<br>
   * Die Angabe des SvtCodes ist optional.<br/>
   * Wird ignoriert, wenn KBL Kennzeichen NEIN.<br>
   * Wenn Anspruch ID angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Anmerkung: Darf nur versorgt sein, wenn eine neuerliche Anspruchspr&uuml;fung erfolgen soll 
   * (wenn bei der Erstellung der UZE kein Anspruch angegeben wurde bzw. eine &Auml;nderung 
   * des bei der Erstellung gew&auml;hlten SVT gewünscht ist).<br>
   * Format: maximal 2-stellig.
   * @param svtCode Der zu setzende Wert f&uuml;r SvtCode.
   */
  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  /**
   * Eindeutige ID der einzul&ouml;senden UZE.<br>
   * @param uzeId Der zu setzende Wert f&uuml;r UzeId.
   */
  public void setUzeId(Long uzeId) {
    _uzeId = uzeId;
  }

  /**
   * Der generierte Code einer UZE. Gemeinsam mit der SvNummer ist er ein eindeutiges Identifizierungsmerkmal einer UZE.<br>
   * Die Angabe des UzeCodes ist optional.<br/>
   * Der UzeCode muss versorgt sein, wenn das e-card Ticket nicht versorgt ist.<br>
   * Format: maximal 5-stellig.
   * @param uzeCode Der zu setzende Wert f&uuml;r UzeCode.
   */
  public void setUzeCode(String uzeCode) {
    _uzeCode = uzeCode;
  }

  /**
   * Version der einzul&ouml;senden UZE.<br>
   * @param version Der zu setzende Wert f&uuml;r Version.
   */
  public void setVersion(Integer version) {
    _version = version;
  }

}
