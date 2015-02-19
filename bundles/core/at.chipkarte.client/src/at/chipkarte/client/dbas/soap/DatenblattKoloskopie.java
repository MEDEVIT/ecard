package at.chipkarte.client.dbas.soap;



/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion createDatenblattKoloskopie beziehungsweise der 
 * Funktion createDatenblattQZKoloskopie.<br>
 * ParameterID: 120500. <br>
 */
public class DatenblattKoloskopie {

	/**
	*	_postleitzahl
	*	@id 120518
	*/
	private String _postleitzahl;
	/**
	*	_ort
	*	@id 120519
	*/
	private String _ort;
    /**
    *   _kommentar
    *   @id 120547
    */
    private String _kommentar;
    /**
    *   _patientenzustimmung
    *   @id 120551
    */
    private String _patientenzustimmung;
    /**
     *   _untersuchung
     *   @id 120552
     */
    private String _untersuchung;
    /**
    *   _vorbereitungsqualitaet
    *   @id 120550
    */
    private String _vorbereitungsqualitaet;
	/**
	*	_sedierungAnalgesie
	*	@id 120520
	*/
	private String _sedierungAnalgesie;
	/**
	*	_zoekumErreicht
	*	@id 120521
	*/
	private String _zoekumErreicht;
	/**
	*	_grundUnvollstaendigeKolo
	*	@id 120522
	*/
	private String _grundUnvollstaendigeKolo;
	/**
	*	_makroskopischerBefund
	*	@id 120523
	*/
	private String[] _makroskopischerBefund;
	/**
	*	_interventionspflichtig
	*	@id 120524
	*/
	private String _interventionspflichtig;
	/**
	*	_interKomplikationJa
	*	@id 120525
	*/
	private String _interKomplikationJa;
	/**
	*	_behandlung
	*	@id 120526
	*/
	private String _behandlung;
	/**
	*	_ausgang
	*	@id 120527
	*/
	private String _ausgang;
	/**
	*	_anzahl
	*	@id 120528
	*/
	private String _anzahl;
	/**
	*	_form
	*	@id 120529
	*/
	private String _form;
	/**
	*	_groesse
	*	@id 120530
	*/
	private String _groesse;
	/**
	*	_lokalisation
	*	@id 120531
	*/
	private String _lokalisation;
	/**
	*	_polypektomie
	*	@id 120532
	*/
	private String _polypektomie;
	/**
	*	_zangenabtragung
	*	@id 120533
	*/
	private String _zangenabtragung;
	/**
	*	_polypEntfernt
	*	@id 120534
	*/
	private String _polypEntfernt;
	/**
	*	_polypGeborgen
	*	@id 120535
	*/
	private String _polypGeborgen;
	/**
	*	_biopsieEntnommen
	*	@id 120536
	*/
	private String _biopsieEntnommen;
	/**
	*	_polyp
	*	@id 120537
	*/
	private String _polyp;
	/**
	*	_adenom
	*	@id 120538
	*/
	private String _adenom;
    /**
    *   _dysplasie
    *   @id 120549
    */
	private String _dysplasie;
	/**
	*	_anzahlAdenome
	*	@id 120553
	*/
	private String _anzahlAdenome;
	/**
	 *	_adenomEntfernt
	 *	@id 120539
	 */
	private String _adenomEntfernt;
	/**
	*	_histoKarzinom
	*	@id 120548
	*/
	private String _histoKarzinom;
    /**
    *   _karzinomEntfernt
    *   @id 120540
    */
    private String _karzinomEntfernt;
	/**
	*	_sonstiges
	*	@id 120541
	*/
	private String _sonstiges;
	/**
	*	_diagnose
	*	@id 120542
	*/
	private String _diagnose;
	/**
	*	_patientenkontaktVerloren
	*	@id 120543
	*/
	private String _patientenkontaktVerloren;
	/**
	*	_massnahmen
	*	@id 120544
	*/
	private String _massnahmen;
	/**
	*	_polypenabtragung
	*	@id 120545
	*/
	private String _polypenabtragung;
	/**
	*	_kontrolleMonate
	*	@id 120546
	*/
	private String _kontrolleMonate;
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
    * Postleitzahl des Patienten.<br>
    * Format: maximal 9-stellig. <br>
    * Angabe: Muss. <br>
    * ParameterID: 120518.
    * @return Postleitzahl
    */
	public String getPostleitzahl() {
		return _postleitzahl;
	}
	public void setPostleitzahl(String _postleitzahl) {
		this._postleitzahl = _postleitzahl;
	}

    /**
    * Ort des Patienten.<br>
    * Format: maximal 38-stellig. <br>
    * Angabe: Optional. <br>
    * ParameterID: 120519.
    * @return Ort
    */
	public String getOrt() {
		return _ort;
	}
	public void setOrt(String _ort) {
		this._ort = _ort;
	}

    /**
    * Kommentar zum ÖGGH.<br>
    * Format: maximal 100-stellig. <br>
    * Angabe: Optional. <br>
    * ParameterID: 120547.
    * @return Kommentar
    */
    public String getKommentar() {
        return _kommentar;
    }
    public void setKommentar(String _kommentar) {
        this._kommentar = _kommentar;
    }

    /**
     * Einwilligungserklärung durch den Patienten unterschrieben.<br>
     * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
     * Angabe: Bedingt (Muss angegeben werden bei Erfassung einer VU-Koloskopie. 
     * Darf nicht angegeben werden beim Erfassen einer QZ-Koloskopie). <br>
     * ParameterID: 120551.
     * @return Patientenzustimmung
     */
    public String getPatientenzustimmung() {
      return _patientenzustimmung;
    }
    public void setPatientenzustimmung(String _patientenzustimmung) {
      this._patientenzustimmung = _patientenzustimmung;
    }
    
    /**
     * Untersuchung.<br>
     * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.UntersuchungTypConstants UntersuchungTypConstants}.<br>
     * Angabe: Muss. <br>
     * ParameterID: 120552.
     * @return Untersuchung
     */
    public String getUntersuchung() {
      return _untersuchung;
    }
    public void setUntersuchung(String _untersuchung) {
      this._untersuchung = _untersuchung;
    }
    
    /**
    * Vorbereitungsqualitaet - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.VorbereitungsqualitaetConstants VorbereitungsqualitaetConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120550.
    * @return Vorbereitungsqualitaet
    */
    public String getVorbereitungsqualitaet() {
      return _vorbereitungsqualitaet;
    }
    public void setVorbereitungsqualitaet(String vorbereitungsqualitaet) {
      _vorbereitungsqualitaet = vorbereitungsqualitaet;
    }

    /**
    * Sedierung oder Analgesie notwendig - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120520.
    * @return SedierungAnalgesie
    */
	public String getSedierungAnalgesie() {
		return _sedierungAnalgesie;
	}
	public void setSedierungAnalgesie(String _sedierungAnalgesie) {
		this._sedierungAnalgesie = _sedierungAnalgesie;
	}

    /**
    * Zoekum erreicht - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120521.
    * @return ZoekumErreicht
    */
	public String getZoekumErreicht() {
		return _zoekumErreicht;
	}
	public void setZoekumErreicht(String _zoekumErreicht) {
		this._zoekumErreicht = _zoekumErreicht;
	}

    /**
    * Grund für unvollstaendige Koloskopie - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.GrundUnvollstaendigeKoloConstants GrundUnvollstaendigeKoloConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn ZoekumErreicht "NEIN" (Nein) ist. Ansonsten ist keine Eingabe erlaubt). <br>
    * ParameterID: 120522.
    * @return GrundUnvollstaendigeKolo
    */
	public String getGrundUnvollstaendigeKolo() {
		return _grundUnvollstaendigeKolo;
	}
	public void setGrundUnvollstaendigeKolo(String _grundUnvollstaendigeKolo) {
		this._grundUnvollstaendigeKolo = _grundUnvollstaendigeKolo;
	}

    /**
    * Makroskopischer Befund - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.MassnahmenMakroBefundConstants MassnahmenMakroBefundConstants}.<br>
    * Angabe: Muss (Max. 4 Listeneinträge erlaubt. Bei Auswahl von "ohne Befund" (ohne Befund) ist keine zusätzliche Auswahl erlaubt). <br>
    * ParameterID: 120523.
    * @return MakroskopischerBefund
    */
	public String[] getMakroskopischerBefund() {
		return _makroskopischerBefund;
	}
	public void setMakroskopischerBefund(String[] _makroskopischerBefund) {
		this._makroskopischerBefund = _makroskopischerBefund;
	}

    /**
    * Interventionspflichtige Komplikationen - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Muss. <br>
    * ParameterID: 120524.
    * @return Interventionspflichtig
    */
	public String getInterventionspflichtig() {
		return _interventionspflichtig;
	}
	public void setInterventionspflichtig(String _interventionspflichtig) {
		this._interventionspflichtig = _interventionspflichtig;
	}

    /**
    * Komplikationsart - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.KomplikationsartConstants KomplikationsartConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Interventionspflichtig "Ja" (Ja) ist. Ansonsten ist keine Eingabe erlaubt). <br>
    * ParameterID: 120525.
    * @return InterKomplikationJa
    */
	public String getInterKomplikationJa() {
		return _interKomplikationJa;
	}
	public void setInterKomplikationJa(String _interKomplikationJa) {
		this._interKomplikationJa = _interKomplikationJa;
	}

    /**
    * Behandlung - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.BehandlungConstants BehandlungConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Interventionspflichtig "Ja" (Ja) ist. Ansonsten ist keine Eingabe erlaubt). <br>
    * ParameterID: 120526.
    * @return Behandlung
    */
	public String getBehandlung() {
		return _behandlung;
	}
	public void setBehandlung(String _behandlung) {
		this._behandlung = _behandlung;
	}

    /**
    * Ausgang - Grundinformation/Komplikationen/Makroskopischer Befund.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.AusgangConstants AusgangConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Interventionspflichtig "Ja" (Ja) ist. Ansonsten ist keine Eingabe erlaubt). <br>
    * ParameterID: 120527.
    * @return Ausgang
    */
	public String getAusgang() {
		return _ausgang;
	}
	public void setAusgang(String _ausgang) {
		this._ausgang = _ausgang;
	}

    /**
    * Anzahl - Bei Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.AnzahlTypConstants AnzahlTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn MakroskopischerBefund mit "Polyp(en)" (Polyp(en)) oder "Kolon-Ca." (Kolon-Ca.) oder
    * "Rektum-Ca." (Rektum-Ca.) belegt ist und sobald Form, Größe und Lokalisation belegt sind. In allen anderen Fällen ist das Feld
    * optional. Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist). <br>
    * ParameterID: 120528.
    * @return Anzahl
    */
	public String getAnzahl() {
		return _anzahl;
	}
	public void setAnzahl(String _anzahl) {
		this._anzahl = _anzahl;
	}

    /**
    * Form - Bei Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypenFormConstants PolypenFormConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn MakroskopischerBefund mit "Polyp(en)" (Polyp(en)) oder "Kolon-Ca." (Kolon-Ca.) oder
    * "Rektum-Ca." (Rektum-Ca.) belegt ist und sobald Anzahl, Größe und Lokalisation belegt sind. In allen anderen Fällen ist das Feld
    * optional. Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist). <br>
    * ParameterID: 120529.
    * @return Form
    */
	public String getForm() {
		return _form;
	}
	public void setForm(String _form) {
		this._form = _form;
	}

    /**
    * Groesse - Bei Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypenGroesseConstants PolypenGroesseConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn MakroskopischerBefund mit "Polyp(en)" (Polyp(en)) oder "Kolon-Ca." (Kolon-Ca.) oder
    * "Rektum-Ca." (Rektum-Ca.) belegt ist und sobald Anzahl, Form und Lokalisation belegt sind. In allen anderen Fällen ist das Feld
    * optional. Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist). <br>
    * ParameterID: 120530.
    * @return Groesse
    */
	public String getGroesse() {
		return _groesse;
	}
	public void setGroesse(String _groesse) {
		this._groesse = _groesse;
	}

    /**
    * Lokalisation - Bei Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypenLokationConstants PolypenLokationConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn MakroskopischerBefund mit "Polyp(en)" (Polyp(en)) oder "Kolon-Ca." (Kolon-Ca.) oder
    * "Rektum-Ca." (Rektum-Ca.) belegt ist und sobald Anzahl, Form und Größe belegt sind. In allen anderen Fällen ist das Feld
    * optional. Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist). <br>
    * ParameterID: 120531.
    * @return Lokalisation
    */
	public String getLokalisation() {
		return _lokalisation;
	}
	public void setLokalisation(String _lokalisation) {
		this._lokalisation = _lokalisation;
	}

    /**
    * Polypektomie - Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypektomieTypConstants PolypektomieTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn MakroskopischerBefund leer bzw. NICHT mit "ohne Befund" (ohne Befund) belegt ist.
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120532.
    * @return Polypektomie
    */
	public String getPolypektomie() {
		return _polypektomie;
	}
	public void setPolypektomie(String _polypektomie) {
		this._polypektomie = _polypektomie;
	}

    /**
    * Zangenabtragung - Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn MakroskopischerBefund leer bzw. NICHT mit "ohne Befund" (ohne Befund) belegt ist.
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120533.
    * @return Zangenabtragung
    */
	public String getZangenabtragung() {
		return _zangenabtragung;
	}
	public void setZangenabtragung(String _zangenabtragung) {
		this._zangenabtragung = _zangenabtragung;
	}

    /**
    * Polyp Entfernt - Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypEntferntConstants PolypEntferntConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Polypektomie mit einem Wert (Konstante) ungleich "keine" und/oder Zangenabtragung 
    * mit dem Wert (Konstante) "Ja" (Ja) belegt ist, ansonsten optional.
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist bzw. Polypektomie mit "keine" und
    * Zangenabtragung mit "Nein" (Nein) belegt oder nicht gesetzt sind.) <br>
    * ParameterID: 120534.
    * @return PolypEntfernt
    */
	public String getPolypEntfernt() {
		return _polypEntfernt;
	}
	public void setPolypEntfernt(String _polypEntfernt) {
		this._polypEntfernt = _polypEntfernt;
	}

    /**
    * Polyp Geborgen - Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Polypektomie mit einem Wert (Konstante) ungleich "keine" und/oder Zangenabtragung mit 
    * dem Wert (Konstante) "Ja" (Ja) belegt ist, ansonsten optional.
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist bzw. Polypektomie  mit "keine" und
    * Zangenabtragung mit "Nein" (Nein) belegt oder nicht gesetzt sind.) <br>
    * ParameterID: 120535.
    * @return PolypGeborgen
    */
	public String getPolypGeborgen() {
		return _polypGeborgen;
	}
	public void setPolypGeborgen(String _polypGeborgen) {
		this._polypGeborgen = _polypGeborgen;
	}

    /**
    * Biopsie Entnommen - Polypen / Polypenabtragung / Biopsie.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Polypektomie mit dem Wert (Konstante) "keine" 
    * und Zangenabtragung mit dem Wert (Konstante) "Nein" (Nein) belegt ist.
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120536.
    * @return BiopsieEntnommen
    */
	public String getBiopsieEntnommen() {
		return _biopsieEntnommen;
	}
	public void setBiopsieEntnommen(String _biopsieEntnommen) {
		this._biopsieEntnommen = _biopsieEntnommen;
	}

    /**
    * Polyp - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypConstants PolypConstants}.<br>
    * Angabe: Bedingt (Es muss mindestens eines der Datenfelder Polyp, Adenom, HistoKarzinom, Sonstiges ausgewählt werden. Ist die
    * Eingabe mindestens einer dieser Parameter Pflicht, ist auch eine Eingabe bei Diagnose erforderlich. Diese Bedingung gilt nur
    * dann, wenn im Datenfeld MakroskopischerBefund NICHT der Eintrag "ohne Befund" (ohne Befund) gesetzt ist. 
    * Diese Bedingung gilt NICHT, wenn in Polypektomie der Eintrag "keine" und in Zangenabtragung und BiopsieEntnommen der 
    * Eintrag "Nein" gewählt wurde. 
    * Diese Bedingung gilt weiters NICHT, wenn PolypGeborgen mit "Nein" belegt und BiopsieEntnommen mit "Nein" oder nicht belegt ist. 
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
    * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
    * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
    * ParameterID: 120537.
    * @return Polyp
    */
	public String getPolyp() {
		return _polyp;
	}
	public void setPolyp(String _polyp) {
		this._polyp = _polyp;
	}

    /**
    * Adenom - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.AdenomConstants AdenomConstants}.<br>
    * Angabe: Bedingt (Es muss mindestens eines der Datenfelder Polyp, Adenom, HistoKarzinom, Sonstiges ausgewählt werden. Ist die
    * Eingabe mindestens einer dieser Parameter Pflicht, ist auch eine Eingabe bei Diagnose erforderlich. Diese Bedingung gilt nur
    * dann, wenn im Datenfeld MakroskopischerBefund NICHT der Eintrag "ohne Befund" (ohne Befund) gesetzt ist. 
    * Diese Bedingung gilt NICHT, wenn in Polypektomie der Eintrag "keine" und in Zangenabtragung und BiopsieEntnommen der 
    * Eintrag "Nein" gewählt wurde. 
    * Diese Bedingung gilt weiters NICHT, wenn PolypGeborgen mit "Nein" belegt und BiopsieEntnommen mit "Nein" oder nicht belegt ist. 
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
    * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
    * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
    * ParameterID: 120538.
    * @return Adenom
    */
	public String getAdenom() {
		return _adenom;
	}
	public void setAdenom(String _adenom) {
		this._adenom = _adenom;
	}

    /**
   * Dysplasie - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.DysplasieConstants DysplasieConstants}.<br>
   * Angabe: Bedingt (Muss angegeben werden, wenn im Datenfeld Adenom ein Wert gewählt wurde. 
   * Keine Eingabe erlaubt, wenn Adenom nicht belegt ist. 
   * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
   * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
   * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
   * ParameterID: 120549.
   * @return Dysplasie
   */
    public String getDysplasie() {
      return _dysplasie;
    }
    public void setDysplasie(String dysplasie) {
      _dysplasie = dysplasie;
    }

    /**
    * Anzahl Adenome.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.AnzahlTypConstants AnzahlTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn im Datenfeld Adenom ein Wert gewählt wurde. 
    * Keine Eingabe erlaubt, wenn Adenom nicht belegt ist. 
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
    * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
    * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
    * ParameterID: 120553.
    * @return AnzahlAdenome
    */
	public String getAnzahlAdenome() {
		return _anzahlAdenome;
	}
	public void setAnzahlAdenome(String _anzahlAdenome) {
		this._anzahlAdenome = _anzahlAdenome;
	}

	/**
	 * Adenom Entfernt - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
	 * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinUnklarConstants JaNeinUnklarConstants}.<br>
	 * Angabe: Bedingt (Muss angegeben werden, wenn im Datenfeld Adenom ein Wert gewählt wurde. Es muss mindestens eines der
	 * Datenfelder Polyp, Adenom, HistoKarzinom, Sonstiges ausgewählt werden. Ist die Eingabe mindestens einer dieser Parameter
	 * Pflicht, ist auch eine Eingabe bei Diagnose erforderlich. Diese Bedingung gilt nur dann, wenn im Datenfeld Makroskopischer
	 * Befund NICHT der Eintrag "ohne Befund" (ohne Befund) gesetzt ist. 
	 * Diese Bedingung gilt NICHT, wenn in Polypektomie der Eintrag "keine" und in Zangenabtragung und BiopsieEntnommen der Eintrag "Nein" gewählt wurde. 
	 * Diese Bedingung gilt weiters NICHT, wenn PolypGeborgen mit "Nein" belegt und BiopsieEntnommen mit "Nein" oder nicht belegt ist. 
	 * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
	 * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
	 * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
	 * ParameterID: 120539.
	 * @return AdenomEntfernt
	 */
	public String getAdenomEntfernt() {
	  return _adenomEntfernt;
	}
	public void setAdenomEntfernt(String _adenomEntfernt) {
	  this._adenomEntfernt = _adenomEntfernt;
	}
	
    /**
    * Karzinom - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Bedingt (Es muss mindestens eines der Datenfelder Polyp, Adenom, HistoKarzinom, Sonstiges ausgewählt werden. Ist die
    * Eingabe mindestens einer dieser Parameter Pflicht, ist auch eine Eingabe bei Diagnose erforderlich. Diese Bedingung gilt nur
    * dann, wenn im Datenfeld MakroskopischerBefund NICHT der Eintrag "ohne Befund" (ohne Befund) gesetzt ist. 
    * Diese Bedingung gilt NICHT, wenn in Polypektomie der Eintrag "keine" und in Zangenabtragung und BiopsieEntnommen der 
    * Eintrag "Nein" gewählt wurde. 
    * Diese Bedingung gilt weiters NICHT, wenn PolypGeborgen mit "Nein" belegt und BiopsieEntnommen mit "Nein" oder nicht belegt ist. 
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
    * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
    * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
    * ParameterID: 120548.
    * @return Karzinom
    */
    public String getHistoKarzinom() {
        return _histoKarzinom;
    }
    public void setHistoKarzinom(String _histoKarzinom) {
        this._histoKarzinom = _histoKarzinom;
    }

    /**
    * Karzinom Entfernt - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinUnklarConstants JaNeinUnklarConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn im Datenfeld HistoKarzinom der Wert "Ja" gewählt wurde. Es muss mindestens eines
    * der Datenfelder Polyp, Adenom, HistoKarzinom, Sonstiges ausgewählt werden. Ist die Eingabe mindestens einer dieser Parameter
    * Pflicht, ist auch eine Eingabe bei Diagnose erforderlich. Diese Bedingung gilt nur dann, wenn im Datenfeld Makroskopischer
    * Befund NICHT der Eintrag "ohne Befund" (ohne Befund) gesetzt ist. 
    * Diese Bedingung gilt NICHT, wenn in Polypektomie der Eintrag "keine" und in Zangenabtragung und BiopsieEntnommen der 
    * Eintrag "Nein" gewählt wurde. 
    * Diese Bedingung gilt weiters NICHT, wenn PolypGeborgen mit "Nein" belegt und BiopsieEntnommen mit "Nein" oder nicht belegt ist. 
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
    * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
    * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
    * ParameterID: 120540.
    * @return KarzinomEntfernt
    */
	public String getKarzinomEntfernt() {
		return _karzinomEntfernt;
	}
	public void setKarzinomEntfernt(String _karzinomEntfernt) {
		this._karzinomEntfernt = _karzinomEntfernt;
	}

    /**
    * Sonstiges - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.HbSonstigesConstants HbSonstigesConstants}.<br>
    * Angabe: Bedingt (Es muss mindestens eines der Datenfelder Polyp, Adenom, HistoKarzinom, Sonstiges ausgewählt werden. Ist die
    * Eingabe mindestens einer dieser Parameter Pflicht, ist auch eine Eingabe bei Diagnose erforderlich. Diese Bedingung gilt nur
    * dann, wenn im Datenfeld MakroskopischerBefund NICHT der Eintrag "ohne Befund" (ohne Befund) gesetzt ist. 
    * Diese Bedingung gilt NICHT, wenn in Polypektomie der Eintrag "keine" und in Zangenabtragung und BiopsieEntnommen der 
    * Eintrag "Nein" gewählt wurde. 
    * Diese Bedingung gilt weiters NICHT, wenn PolypGeborgen mit "Nein" belegt und BiopsieEntnommen mit "Nein" oder nicht belegt ist. 
    * Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist. 
    * Keine Eingabe erlaubt, wenn Polypektomie mit "keine" und Zangenabtragung und BiopsieEntnommen mit "Nein" belegt sind. 
    * Keine Eingabe erlaubt, wenn PolypGeborgen mit "Nein" belegt ist und BiopsieEntnommen mit "Nein" oder nicht belegt ist.) <br>
    * ParameterID: 120541.
    * @return Sonstiges
    */
	public String getSonstiges() {
		return _sonstiges;
	}
	public void setSonstiges(String _sonstiges) {
		this._sonstiges = _sonstiges;
	}

    /**
    * Diagnose - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.KolDiagnoseConstants KolDiagnoseConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn der histologische Befund anzugeben ist. Muss mit "4" (Rektum-Ca.) oder "3"
    * (Kolon-Ca.) belegt sein, wenn HistoKarzinom mit "Ja" (Ja) belegt ist. Muss mit "2" (Adenome) belegt sein, wenn HistoKarzinom
    * mit "Nein" (Nein) belegt ist und bei Adenom ein Eintrag gewählt wurde. Keine Eingabe erlaubt, wenn MakroskopischerBefund mit
    * "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120542.
    * @return Diagnose
    */
	public String getDiagnose() {
		return _diagnose;
	}
	public void setDiagnose(String _diagnose) {
		this._diagnose = _diagnose;
	}

    /**
    * Patientenkontakt Verloren (Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom) - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.JaNeinTypConstants JaNeinTypConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden. Jedoch keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120543.
    * @return PatientenkontaktVerloren
    */
	public String getPatientenkontaktVerloren() {
		return _patientenkontaktVerloren;
	}
	public void setPatientenkontaktVerloren(String _patientenkontaktVerloren) {
		this._patientenkontaktVerloren = _patientenkontaktVerloren;
	}

    /**
    * Massnahmen - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.KolMassnahmenConstants KolMassnahmenConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn PatientenkontaktVerloren mit "Ja" (Ja) belegt ist. Keine Eingabe erlaubt, wenn MakroskopischerBefund mit "ohne Befund" (ohne Befund) bzw.
    * PatientenkontaktVerloren mit "Nein" (Nein) belegt ist.) <br>
    * ParameterID: 120544.
    * @return Massnahmen
    */
	public String getMassnahmen() {
		return _massnahmen;
	}
	public void setMassnahmen(String _massnahmen) {
		this._massnahmen = _massnahmen;
	}

    /**
    * endoskopische Polypenabtragung - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Mögliche Werte siehe {@link at.chipkarte.client.dbas.soap.constants.PolypenabtragungConstants PolypenabtragungConstants}.<br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Massnahme mit "1" (endoskopischer Polypenabtragung) belegt ist.
    * Keine Eingabe erlaubt, wenn PatientenkontaktVerloren (Angeratene weitere Maßnahmen) mit
    * "Nein" (Nein) bzw. Massnahme mit "3" (Kontrollkoloskopie) oder "2" (Operation) bzw. MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120545.
    * @return Polypenabtragung
    */
	public String getPolypenabtragung() {
		return _polypenabtragung;
	}
	public void setPolypenabtragung(String _polypenabtragung) {
		this._polypenabtragung = _polypenabtragung;
	}

    /**
    * Kontrollkoloskopie in - Histologischer Befund / Diagnose / weitere Massnahmen.<br>
    * Format: maximal 3-stellig (Numerisch im Format '000'). <br>
    * Angabe: Bedingt (Muss angegeben werden, wenn Massnahme mit "Kontrollkoloskopie" belegt ist.
    * Keine Eingabe erlaubt, wenn PatientenkontaktVerloren (Angeratene weitere Maßnahmen) mit
    * "Nein" (Nein), Massnnahme mit "1" (endoskopischer Polypenabtragung) oder "2" (Operation) bzw. MakroskopischerBefund mit "ohne Befund" (ohne Befund) belegt ist.) <br>
    * ParameterID: 120546.
    * @return Polypenabtragung
    */
	public String getKontrolleMonate() {
		return _kontrolleMonate;
	}
	public void setKontrolleMonate(String _kontrolleMonate) {
		this._kontrolleMonate = _kontrolleMonate;
	}

    /**
    * ID der gewählten Konsultation zum Datenblatt.<br>
    * Format: 19-stellig. <br>
    * Angabe: Muss. (Auch im Falle der QZK-Erfassung. Der Wert wird hierbei bei der Verarbeitung ignoriert. Die Angabe kann
    * z.B. mittels Werteangabe "0" erfolgen.)<br>
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