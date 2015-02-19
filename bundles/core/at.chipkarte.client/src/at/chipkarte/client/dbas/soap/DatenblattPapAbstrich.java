package at.chipkarte.client.dbas.soap;



/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion createDatenblattPapAbstrich.<br>
 * ParameterID: 120400. <br>
 * Hinweis: Kann nur für Frauen übermittelt werden.<br>
 */
public class DatenblattPapAbstrich {

	/**
	*	_anschrift
	*	@id 120411
	*/
	private String _anschrift;
	/**
	*	_postleitzahl
	*	@id 120412
	*/
	private String _postleitzahl;
	/**
	*	_aufklaerung
	*	@id 120413
	*/
	private String _aufklaerung;
	/**
	*	_qualitaet
	*	@id 120414
	*/
	private String _qualitaet;
	/**
	*	_beurteilung
	*	@id 120415
	*/
	private String _beurteilung;
	/**
	*	_abstrichwiederholung
	*	@id 120416
	*/
	private String _abstrichwiederholung;
	/**
	*	_papKlasse
	*	@id 120417
	*/
	private String _papKlasse;
	/**
	*	_massnahme
	*	@id 120418
	*/
	private String _massnahme;
	/**
	*	_befund
	*	@id 120419
	*/
	private String _befund;
	/**
	*	_ergebnisinformation
	*	@id 120420
	*/
	private String _ergebnisinformation;
	/**
	*	_auffaelligkeiten
	*	@id 120421
	*/
	private String _auffaelligkeiten;
	/**
	*	_konsultationId
	*	@id 129007
	*/
	private Long _konsultationId;
	/**
	*	_versionsnummer
	*	@id 129008
	*/
	private String _versionsnummer;
	/**
	*	_svNummer
	*	@id 129001
	*/
	private String _svNummer;
    /**
     *  _geburtsdatum
     *  @id 129007
     */
    private String _geburtsdatum;

    
    /**
    * Anschrift des Patienten.<br>
    * Format: maximal 108-stellig. <br>
    * Angabe: Muss. <br>
    * ParameterID: 120411.
    * @return Anschrift
    */
	public String getAnschrift() {
		return _anschrift;
	}
	public void setAnschrift(String _anschrift) {
		this._anschrift = _anschrift;
	}
    
    /**
    * Postleitzahl des Patienten.<br>
    * Format: maximal 9-stellig. <br>
    * Angabe: Muss. <br>
    * ParameterID: 120412.
    * @return Postleitzahl
    */
	public String getPostleitzahl() {
		return _postleitzahl;
	}
	public void setPostleitzahl(String _postleitzahl) {
		this._postleitzahl = _postleitzahl;
	}
    
    /**
    * Aufklaerung vor Untersuchung durchgefuehrt - Abstrichqualitaet.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VuTyp19Constants VuTyp19Constants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120413.
    * @return Aufklaerung
    */
	public String getAufklaerung() {
		return _aufklaerung;
	}
	public void setAufklaerung(String _aufklaerung) {
		this._aufklaerung = _aufklaerung;
	}
    
    /**
    * Qualitaet (Kategorie) - Abstrichqualitaet.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PapQualConstants PapQualConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120414.
    * @return Qualitaet
    */
	public String getQualitaet() {
		return _qualitaet;
	}
	public void setQualitaet(String _qualitaet) {
		this._qualitaet = _qualitaet;
	}
    
    /**
    * Beurteilung (Probandin über Ergebnis informiert) - Abstrichqualitaet.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PapBeurtConstants PapBeurtConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden wenn Qualitaet mit "EINGE" (Einge) oder "NICHT" (Nicht) belegt, ansonsten Optional). <br>
    * ParameterID: 120415.
    * @return Beurteilung
    */
	public String getBeurteilung() {
		return _beurteilung;
	}
	public void setBeurteilung(String _beurteilung) {
		this._beurteilung = _beurteilung;
	}
    
    /**
    * Abstrichwiederholung - Abstrichqualitaet.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VuTyp19Constants VuTyp19Constants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120416.
    * @return Abstrichwiederholung
    */
	public String getAbstrichwiederholung() {
		return _abstrichwiederholung;
	}
	public void setAbstrichwiederholung(String _abstrichwiederholung) {
		this._abstrichwiederholung = _abstrichwiederholung;
	}
    
    /**
    * PAP-Klasse - Zervikalzyt. Befund und Folgemassnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PapKlasseConstants PapKlasseConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120417.
    * @return PapKlasse
    */
	public String getPapKlasse() {
		return _papKlasse;
	}
	public void setPapKlasse(String _papKlasse) {
		this._papKlasse = _papKlasse;
	}
    
    /**
    * Maßnahme - Zervikalzyt. Befund und Folgemassnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PapMassnConstants PapMassnConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120418.
    * @return Massnahme
    */
	public String getMassnahme() {
		return _massnahme;
	}
	public void setMassnahme(String _massnahme) {
		this._massnahme = _massnahme;
	}
    
    /**
    * Informationsrelevanter Befund - Zervikalzyt. Befund und Folgemassnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VuTyp19Constants VuTyp19Constants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120419.
    * @return Befund
    */
	public String getBefund() {
		return _befund;
	}
	public void setBefund(String _befund) {
		this._befund = _befund;
	}
    
    /**
    * Probandin über Ergebnis informiert - Zervikalzyt. Befund und Folgemassnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VuTyp19Constants VuTyp19Constants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120420.
    * @return Ergebnisinformation
    */
	public String getErgebnisinformation() {
		return _ergebnisinformation;
	}
	public void setErgebnisinformation(String _ergebnisinformation) {
		this._ergebnisinformation = _ergebnisinformation;
	}
    
    /**   
    * Von Probandin angegebene Auffaelligkeiten - Sonstiges.<br>    
    * Format: maximal 250-stellig. <br>    
    * Angabe: Optional. <br>    
    * ParameterID: 120421.    
    * @return Auffaelligkeiten    
    */
	public String getAuffaelligkeiten() {
		return _auffaelligkeiten;
	}
	public void setAuffaelligkeiten(String _auffaelligkeiten) {
		this._auffaelligkeiten = _auffaelligkeiten;
	}
    
    /**   
    * ID der gewählten Konsultation zum Datenblatt.<br>    
    * Format: 19-stellig. <br>    
    * Angabe: Muss. <br>    
    * ParameterID: 129007.    
    * @return KonsultationId    
     */
	public Long getKonsultationId() {
		return _konsultationId;
	}
	public void setKonsultationId(Long _konsultationId) {
		this._konsultationId = _konsultationId;
	}
    
    /**   
    * Version des Dokumentations-/Befundblattes.<br>    
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.DatenblattVersionConstants DatenblattVersionConstants}.<br>   
    * Angabe: Muss. <br>    
    * ParameterID: 129008.    
    * @return Versionsnummer   
    */
	public String getVersionsnummer() {
		return _versionsnummer;
	}
	public void setVersionsnummer(String _versionsnummer) {
		this._versionsnummer = _versionsnummer;
	}
    
    /**   
    * Sv-Nummer des Patienten für den das Datenblatt übermittelt werden soll.<br>    
    * Format: 10-stellig.<br>   
    * Angabe: Bedingt (Es muss entweder die e-card des Patienten gesteckt sein, oder die SV-Nummer angegeben werden.) <br>
    * Hinweis: Wird die SV-Nummer angegeben und eine e-card gesteckt, wird die gesteckte e-card ignoriert. <br>    
    * ParameterID: 129001.    
    * @return SvNummer   
    */
	public String getSvNummer() {
		return _svNummer;
	}
	public void setSvNummer(String _svNummer) {
		this._svNummer = _svNummer;
	}
    /**
     * Geburtsdatum des Patienten.<br>
     * Format: 10-stellig im Format TT.MM.JJJJ<br>
     * Angabe: Bedingt (Muss angegeben werden, wenn die vom beim Aufruf
     * {@link IDbasService#searchKonsultationData(String, String, String, String)}
     * zurückgelieferte Struktur {@link PatientInfo} (enthalten in {@link KonsultationData})
     * kein gültiges Geburtsdatum enthält.)<br>
     * Hinweis: wenn am Server ein Geburtsdatum ermittelt werden konnte,
     * so muss der Wert von <code>geburtsdatum</code> mit diesem übereinstimmen!
     * @return Geburtsdatum
     */
    public String getGeburtsdatum() {
      return _geburtsdatum;
    }
    public void setGeburtsdatum(String geburtsdatum) {
      _geburtsdatum = geburtsdatum;
    }
}