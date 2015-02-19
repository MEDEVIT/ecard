/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Daten zu einer Version eines Konsultationsbelegs.
 */
public class KonsultationsBeleg {

  private String  _abstimmungsBeleg;
  private Integer _belegInhaltVersion;
  private String  _signaturFormatClient;
  private String  _signaturFormatServer;
  private String  _vpNummer;
  private String  _svNummer;
  private String  _bearbeitungsDatumClientSignatur;
  private Integer _ordNummer;
  private String  _fachgebietsCode;
  private String  _behandlungsfallCode;
  private String  _konsultationsartCode;
  private String  _behandlungsDatum;
  private String  _svNummerAbgeleitet;
  private String  _originalSvtCode;
  private String  _bearbeitungsDatum;
  private Long    _id;
  private Integer _version;
  private String  _abrechnungsPeriode;
  private Boolean _overLimit;
  private String  _leistungsrechtlichesLimitGeprueft;
  private String  _status;
  private String  _versichertenKategorie;
  private String  _anspruchsart;
  private Boolean _kostenanteilbefreit;
  private Boolean _rezeptgebbefreit;
  private String  _leistungsSvtCode;
  private String  _verrechnungsSvtCode;
  private String  _bezugsBereich;
  private String  _bundeslandCode;
  private String  _versichertenartCode;
  private Long    _txnNummer;
  private byte[]  _clientSignatur;
  private byte[]  _serverSignatur;

  public void setAbrechnungsPeriode(String abrechnungsPeriode) {
    _abrechnungsPeriode = abrechnungsPeriode;
  }

  public void setAbstimmungsBeleg(String abstimmungsBeleg) {
    _abstimmungsBeleg = abstimmungsBeleg;
  }

  public void setAnspruchsart(String anspruchsart) {
    _anspruchsart = anspruchsart;
  }

  public void setBearbeitungsDatum(String bearbeitungsDatum) {
    _bearbeitungsDatum = bearbeitungsDatum;
  }

  public void setBearbeitungsDatumClientSignatur(String bearbeitungsDatumClientSignatur) {
    _bearbeitungsDatumClientSignatur = bearbeitungsDatumClientSignatur;
  }

  public void setBehandlungsDatum(String behandlungsDatum) {
    _behandlungsDatum = behandlungsDatum;
  }

  public void setBehandlungsfallCode(String behandlungsfallCode) {
    _behandlungsfallCode = behandlungsfallCode;
  }

  public void setBelegInhaltVersion(Integer belegInhaltVersion) {
    _belegInhaltVersion = belegInhaltVersion;
  }

  public void setBezugsBereich(String bezugsBereich) {
    _bezugsBereich = bezugsBereich;
  }

  public void setBundeslandCode(String bundeslandCode) {
    _bundeslandCode = bundeslandCode;
  }

  public void setClientSignatur(byte[] clientSignatur) {
    _clientSignatur = clientSignatur;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    _fachgebietsCode = fachgebietsCode;
  }

  public void setId(Long id) {
    _id = id;
  }

  public void setKonsultationsartCode(String konsartCode) {
    _konsultationsartCode = konsartCode;
  }

  public void setKostenanteilbefreit(Boolean kostenanteilbefreit) {
    _kostenanteilbefreit = kostenanteilbefreit;
  }

  public void setLeistungsSvtCode(String leistungsSvtCode) {
    _leistungsSvtCode = leistungsSvtCode;
  }

  public void setLeistungsrechtlichesLimitGeprueft(String limit) {
    _leistungsrechtlichesLimitGeprueft = limit;
  }

  public void setOrdNummer(Integer ordNummer) {
    _ordNummer = ordNummer;
  }

  public void setOriginalSvtCode(String originalSvtCode) {
    _originalSvtCode = originalSvtCode;
  }

  public void setOverLimit(Boolean overLimit) {
    _overLimit = overLimit;
  }

  public void setRezeptgebbefreit(Boolean rezeptgebbefreit) {
    _rezeptgebbefreit = rezeptgebbefreit;
  }

  public void setServerSignatur(byte[] serverSignatur) {
    _serverSignatur = serverSignatur;
  }

  public void setSignaturFormatClient(String signaturFormatClient) {
    _signaturFormatClient = signaturFormatClient;
  }

  public void setSignaturFormatServer(String signaturFormatServer) {
    _signaturFormatServer = signaturFormatServer;
  }

  public void setStatus(String status) {
    _status = status;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  public void setSvNummerAbgeleitet(String svNummerAbgeleitet) {
    _svNummerAbgeleitet = svNummerAbgeleitet;
  }

  public void setTxnNummer(Long txnNummer) {
    _txnNummer = txnNummer;
  }

  public void setVerrechnungsSvtCode(String verrechnungsSvtCode) {
    _verrechnungsSvtCode = verrechnungsSvtCode;
  }

  public void setVersichertenartCode(String versichertenartCode) {
    _versichertenartCode = versichertenartCode;
  }

  public void setVersichertenKategorie(String versichertenKategorie) {
    _versichertenKategorie = versichertenKategorie;
  }

  public void setVersion(Integer version) {
    _version = version;
  }

  public void setVpNummer(String vpNummer) {
    _vpNummer = vpNummer;
  }

  /**
   * Format-/Inhaltsversion des Konsultationsbelegs.
   * <br/>Format: maximal 4-stellig
   * 
   * @return Inhaltversion des Belegs
   */
  public Integer getBelegInhaltVersion() {
    return _belegInhaltVersion;
  }

  /**
   * Zeitperiode, in der die Abrechnung der Konsultation stattfindet.
   * <br/>Format: 
   * <br/>JJJJ + Monat ( 01 - 12) + KZ "M" für monatliche Abrechnung oder 
   * <br/>JJJJ + Quartal (01 - 04) + KZ "Q" für quartalsweise Abrechnung 
   * <br/>Beispiel: 200501Q
   * <br/>Format: 7-stellig
   * @return Abrechnungsperiode
   *  
   */
  public String getAbrechnungsPeriode() {
    return _abrechnungsPeriode;
  }

  /**
   * Sozialversicherungsnummer des Versicherten, von dem sich der Anspruch ableitet.
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer des Versicherten, von dem sich der Anspruch ableitet
   */
  public String getSvNummerAbgeleitet() {
    return _svNummerAbgeleitet;
  }

  /**
   * Anspruchsart - mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Anspruchsart Anspruchsarten}.
   * <br/>Format: maximal 2-stellig
   * @return Code der Anspruchsart
   */
  public String getAnspruchsart() {
    return _anspruchsart;
  }

  /**
   * Datum der zuletzt durchgeführten Bearbeitung (Anlage, Änderung, Storno, Nachsignierung, Wiederinkraftsetzung) einer Konsultation.
   * <br/>Format: TTMMJJJJ
   * @return Bearbeitungsdatum
   */
  public String getBearbeitungsDatum() {
    return _bearbeitungsDatum;
  }

  /**
   * Behandlungsfallcode mit dem die Konsultation durchgeführt wurde.
   * <br/>Format: 2-stellig
   * @return Behandlungsfallcode
   */
  public String getBehandlungsfallCode() {
    return _behandlungsfallCode;
  }

  /**
   * Code des Bezugsbereiches der Konsultation.
   * <br/>Mögliche Werte: {@link at.chipkarte.client.base.soap.constants.Bezugsbereich Bezugsbereich}
   * <br/>Format: 2-stellig
   * @return Bezugsbereichscode
   */
  public String getBezugsBereich() {
    return _bezugsBereich;
  }

  /**
   * Code für das Bundesland, in dem sich die Ordinationsadresse befindet, 
   * in der die Behandlung erfolgt ist.
   * <br/>Mögliche Werte siehe 
   * {@link at.chipkarte.client.base.soap.constants.Bundesland Bundeslandcodes}
   * <br/>Format: 1-stellig
   * @return Bundeslandcode
   */
  public String getBundeslandCode() {
    return _bundeslandCode;
  }

  /**
   * Code des Fachgebietes, mit dem die Konsultation durchgeführt wurde.
   * <br/>Format: 2-stellig
   * @return Fachgebietscode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  /**
   * Kennzeichen für die Konsultationsart. Mögliche Werte siehe
   * {@link at.chipkarte.client.kse.soap.constants.Konsultationsart Konsultationsart}.
   * <br/>Format: 3-stellig
   * @return Konsultationsartcode
   */
  public String getKonsultationsartCode() {
    return _konsultationsartCode;
  }

  /**
   * Laufende Nummer der Konsultation, die pro Status Änderung (zum Beispiel: nachgebracht oder
   * storniert) hinaufgezählt wird.
   * <br/>Format: Integer (numerischer, positiver Wert)
   * @return Version
   *  
   */
  public Integer getVersion() {
    return _version;
  }

  /**
   * Kennzeichen, ob der Patient vom Kostenanteil befreit ist.
   * <br/>Format: Boolean (true/false)
   * @return Kennzeichen der Kostenanteilsbefreiung
   */
  public Boolean isKostenanteilbefreit() {
    return _kostenanteilbefreit;
  }

  /**
   * Code des leistungszuständigen KVT für den Patienten.
   * <br/>Format: 2-stellig
   * @return Code des leistungszuständigen KVT
   */
  public String getLeistungsSvtCode() {
    return _leistungsSvtCode;
  }

  /**
   * Kennzeichen, ob der Patient rezeptgebührenbefreit ist.
   * <br/>Format: Boolean (true/false)
   * @return Kennzeichen der Rezeptgebührenbefreiung
   */
  public Boolean isRezeptgebbefreit() {
    return _rezeptgebbefreit;
  }

  /**
   * Statuscode der Konsultation.
   * <br/>Mögliche Werte, siehe {@link at.chipkarte.client.kse.soap.constants.StatusKonsultation "Statuscodes der Konsultation"}
   * <br/>Format: 2-stellig
   * @return Status-Code
   */
  public String getStatus() {
    return _status;
  }

  /**
   * Sozialversicherungsnummer des Patienten.
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Code des verrechnungszuständigen KVT des Vertragspartners.
   * <br/>Format: 2-stellig
   * @return Code des verrechnungszuständigen KVT
   */
  public String getVerrechnungsSvtCode() {
    return _verrechnungsSvtCode;
  }

  /**
   * Versichertenart-Code des Patienten.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Versichertenart Versichertenartcodes}.
   * <br/>Format: 1-stellig
   * @return Versichertenart-Code
   *  
   */
  public String getVersichertenartCode() {
    return _versichertenartCode;
  }

  /**
   * Versichertenkategorie des Patienten.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Versichertenkategorie}.
   * <br/>Format: 2-stellig
   * @return Versichertenkategorie
   */
  public String getVersichertenKategorie() {
    return _versichertenKategorie;
  }

  /**
   * Vertragspartnernummer.
   * <br/>Format: 6-stellig
   * @return Vertragspartnernummer
   *  
   */
  public String getVpNummer() {
    return _vpNummer;
  }

  /**
   * Kennzeichen für das Signaturformat der Clientsignatur.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.Signaturformat Signaturformate}.
   * <br/>Format: 1-stellig
   * @return Signaturformat der Clientsignatur
   *  
   */
  public String getSignaturFormatClient() {
    return _signaturFormatClient;
  }

  /**
   * Kennzeichen für das Signaturformat der Serversignatur.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.Signaturformat Signaturformate}.
   * <br/>Format: 1-stellig
   * @return Signaturformat der Serversignatur
   *  
   */
  public String getSignaturFormatServer() {
    return _signaturFormatServer;
  }

  /**
   * Bearbeitungsdatum der Clientsignatur.
   * <br/>Format: TTMMJJJJ
   * @return Bearbeitungsdatum der Clientsignatur
   */
  public String getBearbeitungsDatumClientSignatur() {
    return _bearbeitungsDatumClientSignatur;
  }

  /**
   * Fortlaufende Ordinationsnummer aufgrund der Verträge des Vertragspartners.
   * <br/>Format: Integer (numerischer, positiver Wert)
   * @return Ordinationsnummer
   *  
   */
  public Integer getOrdNummer() {
    return _ordNummer;
  }

  /**
   * Datum der Behandlung.
   * <br/>Format: TTMMJJJJ
   * @return Behandlungsdatum
   */
  public String getBehandlungsDatum() {
    return _behandlungsDatum;
  }

  /**
   * Code des ursprünglichen KVT, den der Vertragspartner beim Erstellen der Genehmigungsanfrage
   * erfasst hat. 
   * <br/>Mögliche Werte null oder siehe Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs}.
   * <br/>Format: 2-stellig
   * @return Ursprünglicher KVT-Code
   *  
   */
  public String getOriginalSvtCode() {
    return _originalSvtCode;
  }

  /**
   * Eindeutige Nummer der Konsultation (dient zur Referenzierung dieses Konsultationsbelegs in anderen Funktionen).
   * <br/>Format: maximal 19-stellig
   * @return ID
   */
  public Long getId() {
    return _id;
  }

  /**
   * Kennzeichen, dass das Limit für Konsultationen ohne e-card zum Zeitpunkt dieser Konsultation überschritten wurde.
   * <br/>Format: Boolean (true/false)
   * @return Kennzeichen für Limitüberschreitung
   */
  public Boolean isOverLimit() {
    return _overLimit;
  }

  /**
   * Kennzeichen, dass das leistungsrechtliche Limit geprüft wurde.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.LeistungRLimit LeistungRLimit}
   * <br/>Format: 1-stellig
   * @return Kennzeichen der leistungsrechtlichen Limitprüfung
   */
  public String getLeistungsrechtlichesLimitGeprueft() {
    return _leistungsrechtlichesLimitGeprueft;
  }

  /**
   * Eindeutige fortlaufende ausprägungsspezifische Nummer für diese Version des Konsultationsbelegs.
   * <br/>Format: maximal 19-stellig
   * @return Transaktionsnummer
   */
  public Long getTxnNummer() {
    return _txnNummer;
  }

  /**
   * Binärdaten der Clientsignatur nach CMS (Cryptographic Message Syntax) mit externen Signaturdaten ("external signature"). 
   * <br>Format: maximal 1000-stellig
   * @return Clientsignatur
   */
  public byte[] getClientSignatur() {
    return _clientSignatur;
  }

  /**
   * Binärdaten der Serversignatur nach CMS (Cryptographic Message Syntax) mit externen Signaturdaten ("external signature"). 
   * <br/>Format: maximal 1000-stellig
   * @return Serversignatur
   */
  public byte[] getServerSignatur() {
    return _serverSignatur;
  }

  /**
   * 
   * Formatierter Beleg zur Weitergabe an den KVT für die Abstimmung.
   * <br/>Format: maximal 2222-stellig
   * @return Abstimmungsbeleg
   */
  public String getAbstimmungsBeleg() {
    return _abstimmungsBeleg;
  }

}