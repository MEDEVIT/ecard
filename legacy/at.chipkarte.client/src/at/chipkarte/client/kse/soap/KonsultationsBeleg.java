/**
 * KonsultationsBeleg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class KonsultationsBeleg  implements java.io.Serializable {
    private java.lang.String abrechnungsPeriode;

    private java.lang.String abstimmungsBeleg;

    private java.lang.String anspruchsart;

    private java.lang.String bearbeitungsDatum;

    private java.lang.String bearbeitungsDatumClientSignatur;

    private java.lang.String behandlungsDatum;

    private java.lang.String behandlungsfallCode;

    private int belegInhaltVersion;

    private java.lang.String bezugsBereich;

    private java.lang.String bundeslandCode;

    private byte[] clientSignatur;

    private java.lang.String fachgebietsCode;

    private long id;

    private java.lang.String konsultationsartCode;

    private boolean kostenanteilbefreit;

    private java.lang.String leistungsSvtCode;

    private java.lang.String leistungsrechtlichesLimitGeprueft;

    private int ordNummer;

    private java.lang.String originalSvtCode;

    private boolean overLimit;

    private boolean rezeptgebbefreit;

    private byte[] serverSignatur;

    private java.lang.String signaturFormatClient;

    private java.lang.String signaturFormatServer;

    private java.lang.String status;

    private java.lang.String svNummer;

    private java.lang.String svNummerAbgeleitet;

    private long txnNummer;

    private java.lang.String verrechnungsSvtCode;

    private java.lang.String versichertenKategorie;

    private java.lang.String versichertenartCode;

    private int version;

    private java.lang.String vpNummer;

    public KonsultationsBeleg() {
    }

    public KonsultationsBeleg(
           java.lang.String abrechnungsPeriode,
           java.lang.String abstimmungsBeleg,
           java.lang.String anspruchsart,
           java.lang.String bearbeitungsDatum,
           java.lang.String bearbeitungsDatumClientSignatur,
           java.lang.String behandlungsDatum,
           java.lang.String behandlungsfallCode,
           int belegInhaltVersion,
           java.lang.String bezugsBereich,
           java.lang.String bundeslandCode,
           byte[] clientSignatur,
           java.lang.String fachgebietsCode,
           long id,
           java.lang.String konsultationsartCode,
           boolean kostenanteilbefreit,
           java.lang.String leistungsSvtCode,
           java.lang.String leistungsrechtlichesLimitGeprueft,
           int ordNummer,
           java.lang.String originalSvtCode,
           boolean overLimit,
           boolean rezeptgebbefreit,
           byte[] serverSignatur,
           java.lang.String signaturFormatClient,
           java.lang.String signaturFormatServer,
           java.lang.String status,
           java.lang.String svNummer,
           java.lang.String svNummerAbgeleitet,
           long txnNummer,
           java.lang.String verrechnungsSvtCode,
           java.lang.String versichertenKategorie,
           java.lang.String versichertenartCode,
           int version,
           java.lang.String vpNummer) {
           this.abrechnungsPeriode = abrechnungsPeriode;
           this.abstimmungsBeleg = abstimmungsBeleg;
           this.anspruchsart = anspruchsart;
           this.bearbeitungsDatum = bearbeitungsDatum;
           this.bearbeitungsDatumClientSignatur = bearbeitungsDatumClientSignatur;
           this.behandlungsDatum = behandlungsDatum;
           this.behandlungsfallCode = behandlungsfallCode;
           this.belegInhaltVersion = belegInhaltVersion;
           this.bezugsBereich = bezugsBereich;
           this.bundeslandCode = bundeslandCode;
           this.clientSignatur = clientSignatur;
           this.fachgebietsCode = fachgebietsCode;
           this.id = id;
           this.konsultationsartCode = konsultationsartCode;
           this.kostenanteilbefreit = kostenanteilbefreit;
           this.leistungsSvtCode = leistungsSvtCode;
           this.leistungsrechtlichesLimitGeprueft = leistungsrechtlichesLimitGeprueft;
           this.ordNummer = ordNummer;
           this.originalSvtCode = originalSvtCode;
           this.overLimit = overLimit;
           this.rezeptgebbefreit = rezeptgebbefreit;
           this.serverSignatur = serverSignatur;
           this.signaturFormatClient = signaturFormatClient;
           this.signaturFormatServer = signaturFormatServer;
           this.status = status;
           this.svNummer = svNummer;
           this.svNummerAbgeleitet = svNummerAbgeleitet;
           this.txnNummer = txnNummer;
           this.verrechnungsSvtCode = verrechnungsSvtCode;
           this.versichertenKategorie = versichertenKategorie;
           this.versichertenartCode = versichertenartCode;
           this.version = version;
           this.vpNummer = vpNummer;
    }


    /**
     * Gets the abrechnungsPeriode value for this KonsultationsBeleg.
     * 
     * @return abrechnungsPeriode
     */
    public java.lang.String getAbrechnungsPeriode() {
        return abrechnungsPeriode;
    }


    /**
     * Sets the abrechnungsPeriode value for this KonsultationsBeleg.
     * 
     * @param abrechnungsPeriode
     */
    public void setAbrechnungsPeriode(java.lang.String abrechnungsPeriode) {
        this.abrechnungsPeriode = abrechnungsPeriode;
    }


    /**
     * Gets the abstimmungsBeleg value for this KonsultationsBeleg.
     * 
     * @return abstimmungsBeleg
     */
    public java.lang.String getAbstimmungsBeleg() {
        return abstimmungsBeleg;
    }


    /**
     * Sets the abstimmungsBeleg value for this KonsultationsBeleg.
     * 
     * @param abstimmungsBeleg
     */
    public void setAbstimmungsBeleg(java.lang.String abstimmungsBeleg) {
        this.abstimmungsBeleg = abstimmungsBeleg;
    }


    /**
     * Gets the anspruchsart value for this KonsultationsBeleg.
     * 
     * @return anspruchsart
     */
    public java.lang.String getAnspruchsart() {
        return anspruchsart;
    }


    /**
     * Sets the anspruchsart value for this KonsultationsBeleg.
     * 
     * @param anspruchsart
     */
    public void setAnspruchsart(java.lang.String anspruchsart) {
        this.anspruchsart = anspruchsart;
    }


    /**
     * Gets the bearbeitungsDatum value for this KonsultationsBeleg.
     * 
     * @return bearbeitungsDatum
     */
    public java.lang.String getBearbeitungsDatum() {
        return bearbeitungsDatum;
    }


    /**
     * Sets the bearbeitungsDatum value for this KonsultationsBeleg.
     * 
     * @param bearbeitungsDatum
     */
    public void setBearbeitungsDatum(java.lang.String bearbeitungsDatum) {
        this.bearbeitungsDatum = bearbeitungsDatum;
    }


    /**
     * Gets the bearbeitungsDatumClientSignatur value for this KonsultationsBeleg.
     * 
     * @return bearbeitungsDatumClientSignatur
     */
    public java.lang.String getBearbeitungsDatumClientSignatur() {
        return bearbeitungsDatumClientSignatur;
    }


    /**
     * Sets the bearbeitungsDatumClientSignatur value for this KonsultationsBeleg.
     * 
     * @param bearbeitungsDatumClientSignatur
     */
    public void setBearbeitungsDatumClientSignatur(java.lang.String bearbeitungsDatumClientSignatur) {
        this.bearbeitungsDatumClientSignatur = bearbeitungsDatumClientSignatur;
    }


    /**
     * Gets the behandlungsDatum value for this KonsultationsBeleg.
     * 
     * @return behandlungsDatum
     */
    public java.lang.String getBehandlungsDatum() {
        return behandlungsDatum;
    }


    /**
     * Sets the behandlungsDatum value for this KonsultationsBeleg.
     * 
     * @param behandlungsDatum
     */
    public void setBehandlungsDatum(java.lang.String behandlungsDatum) {
        this.behandlungsDatum = behandlungsDatum;
    }


    /**
     * Gets the behandlungsfallCode value for this KonsultationsBeleg.
     * 
     * @return behandlungsfallCode
     */
    public java.lang.String getBehandlungsfallCode() {
        return behandlungsfallCode;
    }


    /**
     * Sets the behandlungsfallCode value for this KonsultationsBeleg.
     * 
     * @param behandlungsfallCode
     */
    public void setBehandlungsfallCode(java.lang.String behandlungsfallCode) {
        this.behandlungsfallCode = behandlungsfallCode;
    }


    /**
     * Gets the belegInhaltVersion value for this KonsultationsBeleg.
     * 
     * @return belegInhaltVersion
     */
    public int getBelegInhaltVersion() {
        return belegInhaltVersion;
    }


    /**
     * Sets the belegInhaltVersion value for this KonsultationsBeleg.
     * 
     * @param belegInhaltVersion
     */
    public void setBelegInhaltVersion(int belegInhaltVersion) {
        this.belegInhaltVersion = belegInhaltVersion;
    }


    /**
     * Gets the bezugsBereich value for this KonsultationsBeleg.
     * 
     * @return bezugsBereich
     */
    public java.lang.String getBezugsBereich() {
        return bezugsBereich;
    }


    /**
     * Sets the bezugsBereich value for this KonsultationsBeleg.
     * 
     * @param bezugsBereich
     */
    public void setBezugsBereich(java.lang.String bezugsBereich) {
        this.bezugsBereich = bezugsBereich;
    }


    /**
     * Gets the bundeslandCode value for this KonsultationsBeleg.
     * 
     * @return bundeslandCode
     */
    public java.lang.String getBundeslandCode() {
        return bundeslandCode;
    }


    /**
     * Sets the bundeslandCode value for this KonsultationsBeleg.
     * 
     * @param bundeslandCode
     */
    public void setBundeslandCode(java.lang.String bundeslandCode) {
        this.bundeslandCode = bundeslandCode;
    }


    /**
     * Gets the clientSignatur value for this KonsultationsBeleg.
     * 
     * @return clientSignatur
     */
    public byte[] getClientSignatur() {
        return clientSignatur;
    }


    /**
     * Sets the clientSignatur value for this KonsultationsBeleg.
     * 
     * @param clientSignatur
     */
    public void setClientSignatur(byte[] clientSignatur) {
        this.clientSignatur = clientSignatur;
    }


    /**
     * Gets the fachgebietsCode value for this KonsultationsBeleg.
     * 
     * @return fachgebietsCode
     */
    public java.lang.String getFachgebietsCode() {
        return fachgebietsCode;
    }


    /**
     * Sets the fachgebietsCode value for this KonsultationsBeleg.
     * 
     * @param fachgebietsCode
     */
    public void setFachgebietsCode(java.lang.String fachgebietsCode) {
        this.fachgebietsCode = fachgebietsCode;
    }


    /**
     * Gets the id value for this KonsultationsBeleg.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this KonsultationsBeleg.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the konsultationsartCode value for this KonsultationsBeleg.
     * 
     * @return konsultationsartCode
     */
    public java.lang.String getKonsultationsartCode() {
        return konsultationsartCode;
    }


    /**
     * Sets the konsultationsartCode value for this KonsultationsBeleg.
     * 
     * @param konsultationsartCode
     */
    public void setKonsultationsartCode(java.lang.String konsultationsartCode) {
        this.konsultationsartCode = konsultationsartCode;
    }


    /**
     * Gets the kostenanteilbefreit value for this KonsultationsBeleg.
     * 
     * @return kostenanteilbefreit
     */
    public boolean isKostenanteilbefreit() {
        return kostenanteilbefreit;
    }


    /**
     * Sets the kostenanteilbefreit value for this KonsultationsBeleg.
     * 
     * @param kostenanteilbefreit
     */
    public void setKostenanteilbefreit(boolean kostenanteilbefreit) {
        this.kostenanteilbefreit = kostenanteilbefreit;
    }


    /**
     * Gets the leistungsSvtCode value for this KonsultationsBeleg.
     * 
     * @return leistungsSvtCode
     */
    public java.lang.String getLeistungsSvtCode() {
        return leistungsSvtCode;
    }


    /**
     * Sets the leistungsSvtCode value for this KonsultationsBeleg.
     * 
     * @param leistungsSvtCode
     */
    public void setLeistungsSvtCode(java.lang.String leistungsSvtCode) {
        this.leistungsSvtCode = leistungsSvtCode;
    }


    /**
     * Gets the leistungsrechtlichesLimitGeprueft value for this KonsultationsBeleg.
     * 
     * @return leistungsrechtlichesLimitGeprueft
     */
    public java.lang.String getLeistungsrechtlichesLimitGeprueft() {
        return leistungsrechtlichesLimitGeprueft;
    }


    /**
     * Sets the leistungsrechtlichesLimitGeprueft value for this KonsultationsBeleg.
     * 
     * @param leistungsrechtlichesLimitGeprueft
     */
    public void setLeistungsrechtlichesLimitGeprueft(java.lang.String leistungsrechtlichesLimitGeprueft) {
        this.leistungsrechtlichesLimitGeprueft = leistungsrechtlichesLimitGeprueft;
    }


    /**
     * Gets the ordNummer value for this KonsultationsBeleg.
     * 
     * @return ordNummer
     */
    public int getOrdNummer() {
        return ordNummer;
    }


    /**
     * Sets the ordNummer value for this KonsultationsBeleg.
     * 
     * @param ordNummer
     */
    public void setOrdNummer(int ordNummer) {
        this.ordNummer = ordNummer;
    }


    /**
     * Gets the originalSvtCode value for this KonsultationsBeleg.
     * 
     * @return originalSvtCode
     */
    public java.lang.String getOriginalSvtCode() {
        return originalSvtCode;
    }


    /**
     * Sets the originalSvtCode value for this KonsultationsBeleg.
     * 
     * @param originalSvtCode
     */
    public void setOriginalSvtCode(java.lang.String originalSvtCode) {
        this.originalSvtCode = originalSvtCode;
    }


    /**
     * Gets the overLimit value for this KonsultationsBeleg.
     * 
     * @return overLimit
     */
    public boolean isOverLimit() {
        return overLimit;
    }


    /**
     * Sets the overLimit value for this KonsultationsBeleg.
     * 
     * @param overLimit
     */
    public void setOverLimit(boolean overLimit) {
        this.overLimit = overLimit;
    }


    /**
     * Gets the rezeptgebbefreit value for this KonsultationsBeleg.
     * 
     * @return rezeptgebbefreit
     */
    public boolean isRezeptgebbefreit() {
        return rezeptgebbefreit;
    }


    /**
     * Sets the rezeptgebbefreit value for this KonsultationsBeleg.
     * 
     * @param rezeptgebbefreit
     */
    public void setRezeptgebbefreit(boolean rezeptgebbefreit) {
        this.rezeptgebbefreit = rezeptgebbefreit;
    }


    /**
     * Gets the serverSignatur value for this KonsultationsBeleg.
     * 
     * @return serverSignatur
     */
    public byte[] getServerSignatur() {
        return serverSignatur;
    }


    /**
     * Sets the serverSignatur value for this KonsultationsBeleg.
     * 
     * @param serverSignatur
     */
    public void setServerSignatur(byte[] serverSignatur) {
        this.serverSignatur = serverSignatur;
    }


    /**
     * Gets the signaturFormatClient value for this KonsultationsBeleg.
     * 
     * @return signaturFormatClient
     */
    public java.lang.String getSignaturFormatClient() {
        return signaturFormatClient;
    }


    /**
     * Sets the signaturFormatClient value for this KonsultationsBeleg.
     * 
     * @param signaturFormatClient
     */
    public void setSignaturFormatClient(java.lang.String signaturFormatClient) {
        this.signaturFormatClient = signaturFormatClient;
    }


    /**
     * Gets the signaturFormatServer value for this KonsultationsBeleg.
     * 
     * @return signaturFormatServer
     */
    public java.lang.String getSignaturFormatServer() {
        return signaturFormatServer;
    }


    /**
     * Sets the signaturFormatServer value for this KonsultationsBeleg.
     * 
     * @param signaturFormatServer
     */
    public void setSignaturFormatServer(java.lang.String signaturFormatServer) {
        this.signaturFormatServer = signaturFormatServer;
    }


    /**
     * Gets the status value for this KonsultationsBeleg.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this KonsultationsBeleg.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the svNummer value for this KonsultationsBeleg.
     * 
     * @return svNummer
     */
    public java.lang.String getSvNummer() {
        return svNummer;
    }


    /**
     * Sets the svNummer value for this KonsultationsBeleg.
     * 
     * @param svNummer
     */
    public void setSvNummer(java.lang.String svNummer) {
        this.svNummer = svNummer;
    }


    /**
     * Gets the svNummerAbgeleitet value for this KonsultationsBeleg.
     * 
     * @return svNummerAbgeleitet
     */
    public java.lang.String getSvNummerAbgeleitet() {
        return svNummerAbgeleitet;
    }


    /**
     * Sets the svNummerAbgeleitet value for this KonsultationsBeleg.
     * 
     * @param svNummerAbgeleitet
     */
    public void setSvNummerAbgeleitet(java.lang.String svNummerAbgeleitet) {
        this.svNummerAbgeleitet = svNummerAbgeleitet;
    }


    /**
     * Gets the txnNummer value for this KonsultationsBeleg.
     * 
     * @return txnNummer
     */
    public long getTxnNummer() {
        return txnNummer;
    }


    /**
     * Sets the txnNummer value for this KonsultationsBeleg.
     * 
     * @param txnNummer
     */
    public void setTxnNummer(long txnNummer) {
        this.txnNummer = txnNummer;
    }


    /**
     * Gets the verrechnungsSvtCode value for this KonsultationsBeleg.
     * 
     * @return verrechnungsSvtCode
     */
    public java.lang.String getVerrechnungsSvtCode() {
        return verrechnungsSvtCode;
    }


    /**
     * Sets the verrechnungsSvtCode value for this KonsultationsBeleg.
     * 
     * @param verrechnungsSvtCode
     */
    public void setVerrechnungsSvtCode(java.lang.String verrechnungsSvtCode) {
        this.verrechnungsSvtCode = verrechnungsSvtCode;
    }


    /**
     * Gets the versichertenKategorie value for this KonsultationsBeleg.
     * 
     * @return versichertenKategorie
     */
    public java.lang.String getVersichertenKategorie() {
        return versichertenKategorie;
    }


    /**
     * Sets the versichertenKategorie value for this KonsultationsBeleg.
     * 
     * @param versichertenKategorie
     */
    public void setVersichertenKategorie(java.lang.String versichertenKategorie) {
        this.versichertenKategorie = versichertenKategorie;
    }


    /**
     * Gets the versichertenartCode value for this KonsultationsBeleg.
     * 
     * @return versichertenartCode
     */
    public java.lang.String getVersichertenartCode() {
        return versichertenartCode;
    }


    /**
     * Sets the versichertenartCode value for this KonsultationsBeleg.
     * 
     * @param versichertenartCode
     */
    public void setVersichertenartCode(java.lang.String versichertenartCode) {
        this.versichertenartCode = versichertenartCode;
    }


    /**
     * Gets the version value for this KonsultationsBeleg.
     * 
     * @return version
     */
    public int getVersion() {
        return version;
    }


    /**
     * Sets the version value for this KonsultationsBeleg.
     * 
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the vpNummer value for this KonsultationsBeleg.
     * 
     * @return vpNummer
     */
    public java.lang.String getVpNummer() {
        return vpNummer;
    }


    /**
     * Sets the vpNummer value for this KonsultationsBeleg.
     * 
     * @param vpNummer
     */
    public void setVpNummer(java.lang.String vpNummer) {
        this.vpNummer = vpNummer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KonsultationsBeleg)) return false;
        KonsultationsBeleg other = (KonsultationsBeleg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abrechnungsPeriode==null && other.getAbrechnungsPeriode()==null) || 
             (this.abrechnungsPeriode!=null &&
              this.abrechnungsPeriode.equals(other.getAbrechnungsPeriode()))) &&
            ((this.abstimmungsBeleg==null && other.getAbstimmungsBeleg()==null) || 
             (this.abstimmungsBeleg!=null &&
              this.abstimmungsBeleg.equals(other.getAbstimmungsBeleg()))) &&
            ((this.anspruchsart==null && other.getAnspruchsart()==null) || 
             (this.anspruchsart!=null &&
              this.anspruchsart.equals(other.getAnspruchsart()))) &&
            ((this.bearbeitungsDatum==null && other.getBearbeitungsDatum()==null) || 
             (this.bearbeitungsDatum!=null &&
              this.bearbeitungsDatum.equals(other.getBearbeitungsDatum()))) &&
            ((this.bearbeitungsDatumClientSignatur==null && other.getBearbeitungsDatumClientSignatur()==null) || 
             (this.bearbeitungsDatumClientSignatur!=null &&
              this.bearbeitungsDatumClientSignatur.equals(other.getBearbeitungsDatumClientSignatur()))) &&
            ((this.behandlungsDatum==null && other.getBehandlungsDatum()==null) || 
             (this.behandlungsDatum!=null &&
              this.behandlungsDatum.equals(other.getBehandlungsDatum()))) &&
            ((this.behandlungsfallCode==null && other.getBehandlungsfallCode()==null) || 
             (this.behandlungsfallCode!=null &&
              this.behandlungsfallCode.equals(other.getBehandlungsfallCode()))) &&
            this.belegInhaltVersion == other.getBelegInhaltVersion() &&
            ((this.bezugsBereich==null && other.getBezugsBereich()==null) || 
             (this.bezugsBereich!=null &&
              this.bezugsBereich.equals(other.getBezugsBereich()))) &&
            ((this.bundeslandCode==null && other.getBundeslandCode()==null) || 
             (this.bundeslandCode!=null &&
              this.bundeslandCode.equals(other.getBundeslandCode()))) &&
            ((this.clientSignatur==null && other.getClientSignatur()==null) || 
             (this.clientSignatur!=null &&
              java.util.Arrays.equals(this.clientSignatur, other.getClientSignatur()))) &&
            ((this.fachgebietsCode==null && other.getFachgebietsCode()==null) || 
             (this.fachgebietsCode!=null &&
              this.fachgebietsCode.equals(other.getFachgebietsCode()))) &&
            this.id == other.getId() &&
            ((this.konsultationsartCode==null && other.getKonsultationsartCode()==null) || 
             (this.konsultationsartCode!=null &&
              this.konsultationsartCode.equals(other.getKonsultationsartCode()))) &&
            this.kostenanteilbefreit == other.isKostenanteilbefreit() &&
            ((this.leistungsSvtCode==null && other.getLeistungsSvtCode()==null) || 
             (this.leistungsSvtCode!=null &&
              this.leistungsSvtCode.equals(other.getLeistungsSvtCode()))) &&
            ((this.leistungsrechtlichesLimitGeprueft==null && other.getLeistungsrechtlichesLimitGeprueft()==null) || 
             (this.leistungsrechtlichesLimitGeprueft!=null &&
              this.leistungsrechtlichesLimitGeprueft.equals(other.getLeistungsrechtlichesLimitGeprueft()))) &&
            this.ordNummer == other.getOrdNummer() &&
            ((this.originalSvtCode==null && other.getOriginalSvtCode()==null) || 
             (this.originalSvtCode!=null &&
              this.originalSvtCode.equals(other.getOriginalSvtCode()))) &&
            this.overLimit == other.isOverLimit() &&
            this.rezeptgebbefreit == other.isRezeptgebbefreit() &&
            ((this.serverSignatur==null && other.getServerSignatur()==null) || 
             (this.serverSignatur!=null &&
              java.util.Arrays.equals(this.serverSignatur, other.getServerSignatur()))) &&
            ((this.signaturFormatClient==null && other.getSignaturFormatClient()==null) || 
             (this.signaturFormatClient!=null &&
              this.signaturFormatClient.equals(other.getSignaturFormatClient()))) &&
            ((this.signaturFormatServer==null && other.getSignaturFormatServer()==null) || 
             (this.signaturFormatServer!=null &&
              this.signaturFormatServer.equals(other.getSignaturFormatServer()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.svNummer==null && other.getSvNummer()==null) || 
             (this.svNummer!=null &&
              this.svNummer.equals(other.getSvNummer()))) &&
            ((this.svNummerAbgeleitet==null && other.getSvNummerAbgeleitet()==null) || 
             (this.svNummerAbgeleitet!=null &&
              this.svNummerAbgeleitet.equals(other.getSvNummerAbgeleitet()))) &&
            this.txnNummer == other.getTxnNummer() &&
            ((this.verrechnungsSvtCode==null && other.getVerrechnungsSvtCode()==null) || 
             (this.verrechnungsSvtCode!=null &&
              this.verrechnungsSvtCode.equals(other.getVerrechnungsSvtCode()))) &&
            ((this.versichertenKategorie==null && other.getVersichertenKategorie()==null) || 
             (this.versichertenKategorie!=null &&
              this.versichertenKategorie.equals(other.getVersichertenKategorie()))) &&
            ((this.versichertenartCode==null && other.getVersichertenartCode()==null) || 
             (this.versichertenartCode!=null &&
              this.versichertenartCode.equals(other.getVersichertenartCode()))) &&
            this.version == other.getVersion() &&
            ((this.vpNummer==null && other.getVpNummer()==null) || 
             (this.vpNummer!=null &&
              this.vpNummer.equals(other.getVpNummer())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAbrechnungsPeriode() != null) {
            _hashCode += getAbrechnungsPeriode().hashCode();
        }
        if (getAbstimmungsBeleg() != null) {
            _hashCode += getAbstimmungsBeleg().hashCode();
        }
        if (getAnspruchsart() != null) {
            _hashCode += getAnspruchsart().hashCode();
        }
        if (getBearbeitungsDatum() != null) {
            _hashCode += getBearbeitungsDatum().hashCode();
        }
        if (getBearbeitungsDatumClientSignatur() != null) {
            _hashCode += getBearbeitungsDatumClientSignatur().hashCode();
        }
        if (getBehandlungsDatum() != null) {
            _hashCode += getBehandlungsDatum().hashCode();
        }
        if (getBehandlungsfallCode() != null) {
            _hashCode += getBehandlungsfallCode().hashCode();
        }
        _hashCode += getBelegInhaltVersion();
        if (getBezugsBereich() != null) {
            _hashCode += getBezugsBereich().hashCode();
        }
        if (getBundeslandCode() != null) {
            _hashCode += getBundeslandCode().hashCode();
        }
        if (getClientSignatur() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientSignatur());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientSignatur(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFachgebietsCode() != null) {
            _hashCode += getFachgebietsCode().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        if (getKonsultationsartCode() != null) {
            _hashCode += getKonsultationsartCode().hashCode();
        }
        _hashCode += (isKostenanteilbefreit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLeistungsSvtCode() != null) {
            _hashCode += getLeistungsSvtCode().hashCode();
        }
        if (getLeistungsrechtlichesLimitGeprueft() != null) {
            _hashCode += getLeistungsrechtlichesLimitGeprueft().hashCode();
        }
        _hashCode += getOrdNummer();
        if (getOriginalSvtCode() != null) {
            _hashCode += getOriginalSvtCode().hashCode();
        }
        _hashCode += (isOverLimit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRezeptgebbefreit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getServerSignatur() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServerSignatur());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServerSignatur(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSignaturFormatClient() != null) {
            _hashCode += getSignaturFormatClient().hashCode();
        }
        if (getSignaturFormatServer() != null) {
            _hashCode += getSignaturFormatServer().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSvNummer() != null) {
            _hashCode += getSvNummer().hashCode();
        }
        if (getSvNummerAbgeleitet() != null) {
            _hashCode += getSvNummerAbgeleitet().hashCode();
        }
        _hashCode += new Long(getTxnNummer()).hashCode();
        if (getVerrechnungsSvtCode() != null) {
            _hashCode += getVerrechnungsSvtCode().hashCode();
        }
        if (getVersichertenKategorie() != null) {
            _hashCode += getVersichertenKategorie().hashCode();
        }
        if (getVersichertenartCode() != null) {
            _hashCode += getVersichertenartCode().hashCode();
        }
        _hashCode += getVersion();
        if (getVpNummer() != null) {
            _hashCode += getVpNummer().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KonsultationsBeleg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abrechnungsPeriode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "abrechnungsPeriode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abstimmungsBeleg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "abstimmungsBeleg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anspruchsart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "anspruchsart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bearbeitungsDatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "bearbeitungsDatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bearbeitungsDatumClientSignatur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "bearbeitungsDatumClientSignatur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("behandlungsDatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsDatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("behandlungsfallCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsfallCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("belegInhaltVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "belegInhaltVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bezugsBereich");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "bezugsBereich"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bundeslandCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "bundeslandCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientSignatur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "clientSignatur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fachgebietsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("konsultationsartCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsultationsartCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kostenanteilbefreit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "kostenanteilbefreit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leistungsSvtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "leistungsSvtCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leistungsrechtlichesLimitGeprueft");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "leistungsrechtlichesLimitGeprueft"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ordNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalSvtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "originalSvtCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "overLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rezeptgebbefreit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "rezeptgebbefreit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverSignatur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "serverSignatur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signaturFormatClient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "signaturFormatClient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signaturFormatServer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "signaturFormatServer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svNummerAbgeleitet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svNummerAbgeleitet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txnNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "txnNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verrechnungsSvtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "verrechnungsSvtCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versichertenKategorie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "versichertenKategorie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versichertenartCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "versichertenartCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vpNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "vpNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
