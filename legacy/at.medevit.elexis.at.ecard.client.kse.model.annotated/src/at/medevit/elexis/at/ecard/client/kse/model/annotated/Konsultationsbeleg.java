package at.medevit.elexis.at.ecard.client.kse.model.annotated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/** Enthält die Daten zu einer Version eines Konsultationsbelegs.<br>
 * Persistenzeinheit für {@link KonsultationsBeleg}
 */
@Entity
public class Konsultationsbeleg {
	
	/** Eindeutige Nummer der Konsultation (dient zur Referenzierung dieses Konsultationsbelegs in anderen Funktionen).
	 * Format: maximal 19-stellig
	 */
	@Id
    private long id;
	
	/**
	 * Zeitperiode, in der die Abrechnung der Konsultation stattfindet.<br>
	 * Format:<br>
	 * JJJJ + Monat ( 01 - 12) + KZ "M" für monatliche Abrechnung oder<br>
	 * JJJJ + Quartal (01 - 04) + KZ "Q" für quartalsmäßige Abrechnung<br>
	 * Beispiel: 200501Q (max. 7-stellig) 
	 */
	@Column(length=7)
	private String abrechnungsPeriode;
	
	/**  Formatierter Beleg zur Weitergabe an den Svt für die Abstimmung. Format: maximal 2222-stellig */
	@Column(length=2223)
    private String abstimmungsBeleg;
	
	/** Anspruchsart - mögliche Werte siehe {@link Anspruchsart}. Format: maximal 2-stellig */
	@Column(length=2)
    private String anspruchsart;
	
	/** Datum der zuletzt durchgeführten Änderung (Anlage, Änderung, Storno, Nachsignierung, Wiederinkraftsetzung) 
	 * einer Konsultation. Format: TTMMJJJJ 
	 */
	@Column(length=8)
    private String bearbeitungsDatum;
	
	/** Bearbeitungsdatum der Clientsignatur. Format: TTMMJJJJ */
	@Column(length=8)
    private String bearbeitungsDatumClientSignatur;
	
	/** Datum der Behandlung. Format: TTMMJJJJ */
	@Column(length=8)
    private String behandlungsDatum;
	
	/** Behandlungsfallcode mit dem die Konsultation durchgeführt wurde. Format: maximal 2-stellig */
	@Column(length=2)
    private String behandlungsfallCode;
	
	/** Format-/Inhaltsversion des Konsultationsbelegs. Format: maximal 4-stellig */
    private int belegInhaltVersion;
    
    /** Code des Bezugsbereiches der Konsultation. Mögliche Werte: {@link Bezugsbereich} Format: maximal 2-stellig */
    @Column(length=2)
    private String bezugsBereich;
    
    /** Code für das Bundesland, in dem sich die Ordinationsadresse befindet, in der die Behandlung erfolgt ist.<br>
     * Mögliche Werte siehe Bundeslandcodes in {@link at.chipkarte.client.base.soap.constants.Bundesland}<br>
     * Format: maximal 1-stellig
     */
    @Column(length=1)
    private String bundeslandCode;
    
    /** Binärdaten der Clientsignatur nach CMS (Cryptographic Message Syntax) mit externen Signaturdaten ("external signature"). */
    private byte[] clientSignatur;
    
    /**   Code des Fachgebietes, mit dem die Konsultation durchgeführt wurde. Format: maximal 2-stellig */
    @Column(length=2)
    private String fachgebietsCode;

    /**   Kennzeichen für die Konsultationsart. */
    private String konsultationsartCode;
    
    /** Kennzeichen, ob SV-Person vom Kostenanteil befreit ist. */
    private boolean kostenanteilbefreit;
    
    /** Code des leistungszuständigen Svt für die SV-Person.
     * Format: maximal 2-stellig
     */
    @Column(length=2)
    private String leistungsSvtCode;
    
    /** Kennzeichen, dass das leistungsrechtliche Limit geprüft wurde.<br>
     * Mögliche Werte siehe {@link LeistungRLimit}<br>
     * Format: maximal 1-stellig
     */
    @Column(length=1)
    private String leistungsrechtlichesLimitGeprueft;
    
    /** Fortlaufende Ordinationsnummer aufgrund der Verträge des Vertragspartners. */
    private int ordNummer;
    
    /** Code des ursprünglichen Svt, den der Vertragspartner beim Erstellen der Genehmigungsanfrage erfasst hat. */
    private String originalSvtCode;
    
    /**  Kennzeichen, dass das Limit für Konsultationen ohne e-card zum Zeitpunkt dieser Konsultation überschritten wurde. */
    private boolean overLimit;
    
    /** Kennzeichen, ob SV-Person rezeptgebührenbefreit ist. */
    private boolean rezeptgebbefreit;
    
    /** Binärdaten der Serversignatur nach CMS (Cryptographic Message Syntax) mit externen Signaturdaten ("external signature"). */
    private byte[] serverSignatur;
    
    /**  Kennzeichen für das Signaturformat der Clientsignatur.
     * Mögliche Werte siehe {@link Signaturformat}.
     * Format: maximal 1-stellig 
     */
    @Column(length=1)
    private String signaturFormatClient;
    
    /**  Kennzeichen für das Signaturformat der Serversignatur.
     * Mögliche Werte siehe {@link Signaturformat}.
     * Format: maximal 1-stellig 
     */
    @Column(length=1)
    private String signaturFormatServer;
    
    /** Statuscode der Konsultation.
     * Mögliche Werte, siehe {@link StatusKonsultation}
     * Format: maximal 2-stellig */
    @Column(length=2)
    private String status;
    
    /** Sozialversicherungsnummer der SV-Person.
     * Format: maximal 10-stellig */
    @Column(length=10)
    private String svNummer;
    
    /** Sozialversicherungsnummer der SV-Person, von der sich der Anspruch ableitet.
     * Format: maximal 10-stellig */
    @Column(length=10)
    private String svNummerAbgeleitet;
    
    /**  Eindeutige fortlaufende vertragspartnerspezifische Nummer für diese Version des Konsultationsbelegs.
     * Format: maximal 19-stellig */
    private long txnNummer;
    
    /** Code des verrechnungszuständigen Svt des Vertragspartners.
     * Format: maximal 2-stellig */
    @Column(length=2)
    private String verrechnungsSvtCode;
    
    /** Versichertenkategorie.
     * Mögliche Werte siehe {@link Versichertenkategorie}.
     * Format: maximal 2-stellig */
    @Column(length=2)
    private String versichertenKategorie;
    
    /** Versichertenart Code der SV-Person.
     * Mögliche Werte siehe {@link Versichertenart}. */
    @Column(length=1)
    private String versichertenartCode;
    
    /** Laufende Nummer der Konsultation, die pro Status Änderung (zum Beispiel: nachgebracht oder storniert) hinaufgezählt wird. */
    private int version;
    
    /** Vertragspartnernummer. Format: maximal 6-stellig */
    @Column(length=6)
    private String vpNummer; 
    
	public Konsultationsbeleg(){}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getAbrechnungsPeriode(){
		return abrechnungsPeriode;
	}

	public void setAbrechnungsPeriode(String abrechnungsPeriode){
		this.abrechnungsPeriode = abrechnungsPeriode;
	}

	public String getAbstimmungsBeleg(){
		return abstimmungsBeleg;
	}

	public void setAbstimmungsBeleg(String abstimmungsBeleg){
		this.abstimmungsBeleg = abstimmungsBeleg;
	}

	public String getAnspruchsart(){
		return anspruchsart;
	}

	public void setAnspruchsart(String anspruchsart){
		this.anspruchsart = anspruchsart;
	}

	public String getBearbeitungsDatum(){
		return bearbeitungsDatum;
	}

	public void setBearbeitungsDatum(String bearbeitungsDatum){
		this.bearbeitungsDatum = bearbeitungsDatum;
	}

	public String getBearbeitungsDatumClientSignatur(){
		return bearbeitungsDatumClientSignatur;
	}

	public void setBearbeitungsDatumClientSignatur(String bearbeitungsDatumClientSignatur){
		this.bearbeitungsDatumClientSignatur = bearbeitungsDatumClientSignatur;
	}

	public String getBehandlungsDatum(){
		return behandlungsDatum;
	}

	public void setBehandlungsDatum(String behandlungsDatum){
		this.behandlungsDatum = behandlungsDatum;
	}

	public String getBehandlungsfallCode(){
		return behandlungsfallCode;
	}

	public void setBehandlungsfallCode(String behandlungsfallCode){
		this.behandlungsfallCode = behandlungsfallCode;
	}

	public int getBelegInhaltVersion(){
		return belegInhaltVersion;
	}

	public void setBelegInhaltVersion(int belegInhaltVersion){
		this.belegInhaltVersion = belegInhaltVersion;
	}

	public String getBezugsBereich(){
		return bezugsBereich;
	}

	public void setBezugsBereich(String bezugsBereich){
		this.bezugsBereich = bezugsBereich;
	}

	public String getBundeslandCode(){
		return bundeslandCode;
	}

	public void setBundeslandCode(String bundeslandCode){
		this.bundeslandCode = bundeslandCode;
	}

	public byte[] getClientSignatur(){
		return clientSignatur;
	}

	public void setClientSignatur(byte[] clientSignatur){
		this.clientSignatur = clientSignatur;
	}

	public String getFachgebietsCode(){
		return fachgebietsCode;
	}

	public void setFachgebietsCode(String fachgebietsCode){
		this.fachgebietsCode = fachgebietsCode;
	}

	public String getKonsultationsartCode(){
		return konsultationsartCode;
	}

	public void setKonsultationsartCode(String konsultationsartCode){
		this.konsultationsartCode = konsultationsartCode;
	}

	public boolean isKostenanteilbefreit(){
		return kostenanteilbefreit;
	}

	public void setKostenanteilbefreit(boolean kostenanteilbefreit){
		this.kostenanteilbefreit = kostenanteilbefreit;
	}

	public String getLeistungsSvtCode(){
		return leistungsSvtCode;
	}

	public void setLeistungsSvtCode(String leistungsSvtCode){
		this.leistungsSvtCode = leistungsSvtCode;
	}

	public String getLeistungsrechtlichesLimitGeprueft(){
		return leistungsrechtlichesLimitGeprueft;
	}

	public void setLeistungsrechtlichesLimitGeprueft(String leistungsrechtlichesLimitGeprueft){
		this.leistungsrechtlichesLimitGeprueft = leistungsrechtlichesLimitGeprueft;
	}

	public int getOrdNummer(){
		return ordNummer;
	}

	public void setOrdNummer(int ordNummer){
		this.ordNummer = ordNummer;
	}

	public String getOriginalSvtCode(){
		return originalSvtCode;
	}

	public void setOriginalSvtCode(String originalSvtCode){
		this.originalSvtCode = originalSvtCode;
	}

	public boolean isOverLimit(){
		return overLimit;
	}

	public void setOverLimit(boolean overLimit){
		this.overLimit = overLimit;
	}

	public boolean isRezeptgebbefreit(){
		return rezeptgebbefreit;
	}

	public void setRezeptgebbefreit(boolean rezeptgebbefreit){
		this.rezeptgebbefreit = rezeptgebbefreit;
	}

	public byte[] getServerSignatur(){
		return serverSignatur;
	}

	public void setServerSignatur(byte[] serverSignatur){
		this.serverSignatur = serverSignatur;
	}

	public String getSignaturFormatClient(){
		return signaturFormatClient;
	}

	public void setSignaturFormatClient(String signaturFormatClient){
		this.signaturFormatClient = signaturFormatClient;
	}

	public String getSignaturFormatServer(){
		return signaturFormatServer;
	}

	public void setSignaturFormatServer(String signaturFormatServer){
		this.signaturFormatServer = signaturFormatServer;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getSvNummer(){
		return svNummer;
	}

	public void setSvNummer(String svNummer){
		this.svNummer = svNummer;
	}

	public String getSvNummerAbgeleitet(){
		return svNummerAbgeleitet;
	}

	public void setSvNummerAbgeleitet(String svNummerAbgeleitet){
		this.svNummerAbgeleitet = svNummerAbgeleitet;
	}

	public long getTxnNummer(){
		return txnNummer;
	}

	public void setTxnNummer(long txnNummer){
		this.txnNummer = txnNummer;
	}

	public String getVerrechnungsSvtCode(){
		return verrechnungsSvtCode;
	}

	public void setVerrechnungsSvtCode(String verrechnungsSvtCode){
		this.verrechnungsSvtCode = verrechnungsSvtCode;
	}

	public String getVersichertenKategorie(){
		return versichertenKategorie;
	}

	public void setVersichertenKategorie(String versichertenKategorie){
		this.versichertenKategorie = versichertenKategorie;
	}

	public String getVersichertenartCode(){
		return versichertenartCode;
	}

	public void setVersichertenartCode(String versichertenartCode){
		this.versichertenartCode = versichertenartCode;
	}

	public int getVersion(){
		return version;
	}

	public void setVersion(int version){
		this.version = version;
	}

	public String getVpNummer(){
		return vpNummer;
	}

	public void setVpNummer(String vpNummer){
		this.vpNummer = vpNummer;
	}
	
	
}
