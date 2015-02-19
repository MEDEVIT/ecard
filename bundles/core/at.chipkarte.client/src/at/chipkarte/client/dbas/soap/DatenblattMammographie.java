package at.chipkarte.client.dbas.soap;



/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion createDatenblattMammographie.<br>
 * ParameterID: 120300. <br>
 * Hinweis: Kann nur für Frauen übermittelt werden.<br>
 */
public class DatenblattMammographie {

	/**
	*	_anschrift
	*	@id 120311
	*/
	private String _anschrift;
	/**
	*	_postleitzahl
	*	@id 120312
	*/
	private String _postleitzahl;
	/**
	*	_aufklaerung
	*	@id 120314
	*/
	private String _aufklaerung;
	/**
	*	_kategorie
	*	@id 120315
	*/
	private String _kategorie;
	/**
	*	_ergebnisinformation
	*	@id 120316
	*/
	private String _ergebnisinformation;
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
    * ParameterID: 120311.
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
    * ParameterID: 120312.
    * @return Postleitzahl
    */
	public String getPostleitzahl() {
		return _postleitzahl;
	}
	public void setPostleitzahl(String _postleitzahl) {
		this._postleitzahl = _postleitzahl;
	}
    
    /**
    * Aufklaerung vor Untersuchung durchgefuehrt - Mammogramm.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VuTyp19Constants VuTyp19Constants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120314.
    * @return Aufklaerung
    */
	public String getAufklaerung() {
		return _aufklaerung;
	}
	public void setAufklaerung(String _aufklaerung) {
		this._aufklaerung = _aufklaerung;
	}
    
    /**
    * Kategorie - Mammogramm.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.MammoKatConstants MammoKatConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120315.
    * @return Kategorie
    */
	public String getKategorie() {
		return _kategorie;
	}
	public void setKategorie(String _kategorie) {
		this._kategorie = _kategorie;
	}
    
    /**
    * Probandin über Ergebnis informiert - Mammogramm.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VuTyp19Constants VuTyp19Constants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120316.
    * @return Ergebnisinformation
    */
	public String getErgebnisinformation() {
		return _ergebnisinformation;
	}
	public void setErgebnisinformation(String _ergebnisinformation) {
		this._ergebnisinformation = _ergebnisinformation;
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