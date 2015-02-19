/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap;

/**
 * <p>
 * Diese Klasse enthält die vom Benutzer veränderbaren Daten einer AU- oder AF-Meldung.<br>
 * Hinweise: <br>
 * a.) Wohnanschrift (<i>Strasse</i>, <i>Plz</i>, <i>Ort</i>) - bedingte Pflichtfelder: es müssen
 * entweder alle drei Felder gesetzt oder leer sein<br>
 * b.) Abweichende Ausgehzeiten (Von, Bis) - Optional, wenn eines versorgt wird, müssen jeweils beide Parameter der zusammengehörigen
 * Ausgehzeiten gesetzt werden<br>
 * c.) <i>DiagnoseCode</i> + <i>DiagnoseCodeTyp</i> bzw. <i>Diagnose</i> - entweder die <i>Diagnose</i> oder der <i>DiagnoseCode</i> 
 * gemeinsam mit dem <i>DiagnoseCodeTyp</i>  sind gesetzt<br>
 * d.) <i>BehandlungsDatum</i> - Pflichtfeld<br>
 * e.) <i>R&uuml;ckdatierungsgrundCode</i> - bedingtes Pflichtfeld: muss gesetzt sein,
 * wenn <i>ArbeitsunfaehigVon</i> mehr als einen Arbeitstag vor <i>BehandlungsDatum</i> 
 * liegt (Feiertage werden ignoriert, d.h. sie werden als Arbeitstag gerechnet,
 * wenn der Wochentag, auf den sie fallen, ein Arbeitstag ist).
 * </p>
 */
public class Meldungsdaten {
  private String _svtCode;
  private String _arbeitsunfaehigVon;
  private String _arbeitsunfaehigBis;
  private String _strasse;
  private String _ort;
  private String _plz;
  private String _voraussichtlichArbeitsunfaehigBis;
  private String _diagnose;
  private String _diagnoseCode;
  private String _diagnoseCodeTyp;
  private String _zusatzdiagnoseCode;
  private String _besondereArbeitsunfaehigkeitsursacheCode;
  private Boolean _bettruhe;
  private Boolean _stromunfall;
  private Integer _berufskrankheit;
  private String _gehunfaehigBis;
  private String _gipsBis;
  private String _besondereMitteilungAnSVT;
  private String _krankenhausaufenthaltVon;
  private String _krankenhausaufenthaltBis;
  private String _abweichendeAusgehzeitVon1;
  private String _abweichendeAusgehzeitBis1;
  private String _abweichendeAusgehzeitVon2;
  private String _abweichendeAusgehzeitBis2;
  private String _wiederbestellung;
  private String _rueckdatierungsgrundCode;
  private String _behandlungsDatum;
  /**
   * 
   * Das Datum der Behandlung.
   * <br>Format:  10-stellig, TT.MM.JJJJ 
   * @return Behandlungsdatum
   */
  public String getBehandlungsDatum() {
    return _behandlungsDatum;
  }
  public void setBehandlungsDatum(String behandlungsDatum) {
    _behandlungsDatum = behandlungsDatum;
  }
  /**
   * Ende der abweichenden Ausgehzeit 1.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 01 und 24
   * @return Ende der abweichenden Ausgehzeit 1
   */
  public String getAbweichendeAusgehzeitBis1() {
    return _abweichendeAusgehzeitBis1;
  }
  public void setAbweichendeAusgehzeitBis1(String abweichAusgang1Bis) {
    _abweichendeAusgehzeitBis1 = abweichAusgang1Bis;
  }
  /**
   * Beginn der abweichenden Ausgehzeit 1.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 00 und 23
   * @return Beginn der abweichenden Ausgehzeit 1
   */
  public String getAbweichendeAusgehzeitVon1() {
    return _abweichendeAusgehzeitVon1;
  }
  public void setAbweichendeAusgehzeitVon1(String abweichAusgang1Von) {
    _abweichendeAusgehzeitVon1 = abweichAusgang1Von;
  }
  /**
   * Ende der abweichenden Ausgehzeit 2.
   * <br>Format: maximal 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 01 und 24
   * @return Ende der abweichenden Ausgehzeit 2
   */
  public String getAbweichendeAusgehzeitBis2() {
    return _abweichendeAusgehzeitBis2;
  }
  public void setAbweichendeAusgehzeitBis2(String abweichAusgang2Bis) {
    _abweichendeAusgehzeitBis2 = abweichAusgang2Bis;
  }
  /**
   * Beginn der abweichenden Ausgehzeit 2.
   * <br>Format: maximal 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 00 und 23
   * @return Beginn der abweichenden Ausgehzeit 2 
   */
  public String getAbweichendeAusgehzeitVon2() {
    return _abweichendeAusgehzeitVon2;
  }
  public void setAbweichendeAusgehzeitVon2(String abweichAusgang2Von) {
    _abweichendeAusgehzeitVon2 = abweichAusgang2Von;
  }
  /**
   * Ende des Krankenhausaufenthalts.
   * <br>Muss kleiner oder gleich <i>BehandlungsDatum</i> sein.
   * <br>Format: 10-stellig, TT.MM.JJJJ   
   * @return Ende des Krankenhausaufenthalts
   */
  public String getKrankenhausaufenthaltBis() {
    return _krankenhausaufenthaltBis;
  }
  public void setKrankenhausaufenthaltBis(String anstaltsaufenthaltBis) {
    _krankenhausaufenthaltBis = anstaltsaufenthaltBis;
  }
  /**
   * Beginn des Krankenhausaufenthalts.
   * <br>Muss kleiner oder gleich <i>KrankenhausaufenthaltBis</i> und <i>BehandlungsDatum</i> sein.
   * <br>Format: 10-stellig, TT.MM.JJJJ 
   * @return Beginn des Krankenhausaufenthalts
   */
  public String getKrankenhausaufenthaltVon() {
    return _krankenhausaufenthaltVon;
  }
  public void setKrankenhausaufenthaltVon(String anstaltsaufenthaltVon) {
    _krankenhausaufenthaltVon = anstaltsaufenthaltVon;
  }
  /**
   * Ende der Arbeitsunfähigkeit.
   * <br><b>ACHTUNG:</b> Der Name dieses Felds bei der Anzeige sollte "Letzter
   * Tag der AU" lauten.
   * <br>Muss gr&ouml;&szlig;er oder gleich
   * <i>ArbeitsunfaehigVon</i> sein.
   * <br>Format: 10-stellig, TT.MM.JJJJ 
   * @return Ende der Arbeitsunfähigkeit
   */
  public String getArbeitsunfaehigBis() {
    return _arbeitsunfaehigBis;
  }
  public void setArbeitsunfaehigBis(String arbeitsunfaehigBis) {
    _arbeitsunfaehigBis = arbeitsunfaehigBis;
  }
  /**
   * Beginn der Arbeitsunfähigkeit.
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Beginn der Arbeitsunfähigkeit
   */
  public String getArbeitsunfaehigVon() {
    return _arbeitsunfaehigVon;
  }
  public void setArbeitsunfaehigVon(String arbeitsunfaehigVon) {
    _arbeitsunfaehigVon = arbeitsunfaehigVon;
  }
  /**
   * Code für vorliegende Berufskrankheit.
   * <br>Format: 1-stellig
   * <br>Mögliche Werte: {@link at.chipkarte.client.aum.soap.constants.Berufskrankheit Berufskrankheit}
   * @return Berufskrankheit
   */
  public Integer getBerufskrankheit() {
    return _berufskrankheit;
  }
  public void setBerufskrankheit(Integer berufskrankheit) {
    _berufskrankheit = berufskrankheit;
  }
  /**
   * Code für besondere Arbeitsunfähigkeitsursache.
   * <br>Format: 3-stellig 
   * <br>Mögliche Werte: {@link IAumService#getBesondereArbeitsunfaehigkeitsursacheCodes()}.
   * @return Code für besondere Arbeitsunfähigkeitsursache
   */
  public String getBesondereArbeitsunfaehigkeitsursacheCode() {
    return _besondereArbeitsunfaehigkeitsursacheCode;
  }
  public void setBesondereArbeitsunfaehigkeitsursacheCode(String besondereErkrankungTyp) {
    _besondereArbeitsunfaehigkeitsursacheCode = besondereErkrankungTyp;
  }
  /**
   * Gibt an, ob dem Patienten Bettruhe verordnet wird.
   * @return Kennzeichen, ob dem Patienten Bettruhe verordnet wird
   */
  public Boolean getBettruhe() {
    return _bettruhe;
  }
  public void setBettruhe(Boolean bettruhe) {
    _bettruhe = bettruhe;
  }
  /**
   * Diagnose als Freitext.
   * <br>Bedingtes Pflichtfeld: es muss entweder
   * dieses Feld oder <i>DiagnoseCode</i> und <i>DiagnoseCodeTyp</i> gesetzt sein.
   * <br>Format: maximal 250-stellig. 
   * @return Diagnose
   */
  public String getDiagnose() {
    return _diagnose;
  }
  public void setDiagnose(String diagnoseBezeichnung) {
    _diagnose = diagnoseBezeichnung;
  }
  /**
   * Diagnosecode.
   * <br>Bedingtes Pflichtfeld: es muss entweder dieses Feld
   * und <i>DiagnoseCodeTyp</i> oder stattdessen alleinig das Feld <i>Diagnose</i> gesetzt sein.
   * <br>Format: 7-stellig. 
   * @return Diagnosecode
   */
  public String getDiagnoseCode() {
    return _diagnoseCode;
  }
  public void setDiagnoseCode(String diagnoseCode) {
    _diagnoseCode = diagnoseCode;
  }
  /**
   * Das für den Diagnosecode verwendete Codierungssystem.
   * Bedingtes Pflichtfeld: es muss entweder dieses Feld
   * und <i>Diagnosecode</i> oder stattdessen alleinig das Feld <i>Diagnose</i> gesetzt sein.
   * <br>Format: 2-stellig 
   * <br>Mögliche Werte {@link IAumService#getDiagnoseCodeTyp()}.
   * @return Verwendetes Codierungssystem
   */
  public String getDiagnoseCodeTyp() {
    return _diagnoseCodeTyp;
  }
  public void setDiagnoseCodeTyp(String diagnoseCodeSystem) {
    _diagnoseCodeTyp = diagnoseCodeSystem;
  }
  /**
   * Ende der Gehunfähigkeit.
   * <br>Format: 10-stellig, TT.MM.JJJJ 
   * @return Ende der Gehunfähigkeit
   */
  public String getGehunfaehigBis() {
    return _gehunfaehigBis;
  }
  public void setGehunfaehigBis(String gehunfaehigBis) {
    _gehunfaehigBis = gehunfaehigBis;
  }
  /**
   * Datum, bis zu dem ein Gipsverband getragen werden muss.
   * <br>Muss gr&ouml;&szlig;er oder gleich
   * <i>ArbeitsunfaehigVon</i> sein.
   * <br>Format: 10-stellig, TT.MM.JJJJ 
   * @return Datum, bis zu dem ein Gipsverband getragen werden muss
   */
  public String getGipsBis() {
    return _gipsBis;
  }
  public void setGipsBis(String gipsBis) {
    _gipsBis = gipsBis;
  }
  /**
   * Interne Mitteilung des Arztes an den KVT.
   * <br><b>ACHTUNG</b> Dieses Feld sollte an der Anzeige 
   * "zus&auml;tzliche Information" lauten. 
   * <br>Format: maximal 250-stellig
   * @return Interne Mitteilung des Arztes an den KVT
   */
  public String getBesondereMitteilungAnSVT() {
    return _besondereMitteilungAnSVT;
  }
  public void setBesondereMitteilungAnSVT(String intMitteilungSVT) {
    _besondereMitteilungAnSVT = intMitteilungSVT;
  }
  /**
   * Gibt an, ob es sich um einen Stromunfall handelt.
   * @return Kennzeichen, ob es sich um einen Stromunfall handelt
   */
  public Boolean getStromunfall() {
    return _stromunfall;
  }
  public void setStromunfall(Boolean stromunfall) {
    _stromunfall = stromunfall;
  }
  /**
   * Gibt den Code des KVT an. 
   * <br>Pflichtfeld f&uuml;r Meldungen f&uuml;r Patienten
   * "mit Anspruchspr&uuml;fung" (Flag <i>ungepr&uuml;ft</i> in {@link Person} nicht gesetzt).
   * <br>Die Eingabe des Wertes <code>AL</code> (für ALLE)
   * bewirkt, dass die Meldung an alle KVTs, bei denen der Patient versichert ist, gesendet wird.
   * <br>Für EKVK-Patienten ist der Code der Gebietskrankenkasse des Bundeslandes, in dem
   * sich die Ordination befindet, anzugeben. Andernfalls wird der angegebene
   * Code vom Server mit diesem Code &uuml;berschrieben. 
   * <br>F&uuml;r "ungepr&uuml;fte" Meldungen darf der Wert <code>AL</code> nicht verwendet
   * werden.
   * <br>Format: 2-stellig 
   * @return Code des KVT
   */
  public String getSvtCode() {
    return _svtCode;
  }
  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
  /**
   * Voraussichtliches Ende der Arbeitsunfähigkeit.
   * <br>Muss gr&ouml;&szlig;er oder gleich
   * <i>ArbeitsunfaehigVon" sein</i>.
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Voraussichtliches Ende der Arbeitsunfähigkeit
   */
  public String getVoraussichtlichArbeitsunfaehigBis() {
    return _voraussichtlichArbeitsunfaehigBis;
  }
  public void setVoraussichtlichArbeitsunfaehigBis(String voraussEndeArbeitsunfaehigkeit) {
    _voraussichtlichArbeitsunfaehigBis = voraussEndeArbeitsunfaehigkeit;
  }
  /**
   * Datum der Wiederbestellung.
   * Muss gr&ouml;&szlig;er oder gleich
   * <i>ArbeitsunfaehigVon</i> sein.
   * <br>Format: 10-stellig, TT.MM.JJJJ. 
   * @return Datum der Wiederbestellung
   */
  public String getWiederbestellung() {
    return _wiederbestellung;
  }
  public void setWiederbestellung(String wiederbestellung) {
    _wiederbestellung = wiederbestellung;
  }
  /**
   * Code für die Zusatzdiagnose. 
   * <br>Format:  3-stellig 
   * <br>Mögliche Werte: {@link IAumService#getZusatzdiagnoseCodes()}.
   * @return Code für die Zusatzdiagnose
   */
  public String getZusatzdiagnoseCode() {
    return _zusatzdiagnoseCode;
  }
  public void setZusatzdiagnoseCode(String zusatzICD) {
    _zusatzdiagnoseCode = zusatzICD;
  }
  /**
   * Wohnanschrift - Ort.
   * <br>Format:  maximal 40-stellig
   * @return Wohnanschrift - Ort
   */
  public String getOrt() {
    return _ort;
  }
  public void setOrt(String ort) {
    _ort = ort;
  }
  /**
   * Wohnanschrift - Postleitzahl.
   * <br>Format:  maximal 9-stellig
   * @return Wohnanschrift - Postleitzahl
   */
  public String getPlz() {
    return _plz;
  }
  public void setPlz(String plz) {
    _plz = plz;
  }
  /**
   * Wohnanschrift - Straße und Nummer.
   * <br>Format:  maximal 50-stellig
   * @return Wohnanschrift - Straße und Nummer
   */
  public String getStrasse() {
    return _strasse;
  }
  public void setStrasse(String strasse) {
    _strasse = strasse;
  }
  /**
   * Code für die Begründung der Rückdatierung der Meldung. 
   * <br>Bedingtes Pflichtfeld: muss gesetzt sein,
   * wenn <i>ArbeitsunfaehigVon</i> mehr als einen Arbeitstag vor <i>BehandlungsDatum</i> 
   * liegt (Feiertage werden ignoriert, d.h. sie werden als Arbeitstag gerechnet,
   * wenn der Wochentag, auf den sie fallen, ein Arbeitstag ist).
   * <br>Format: 2-stellig. 
   * <br>Mögliche Werte: {@link IAumService#getRueckdatierungsgrundCodes()}.
   * @return Code für die Begründung der Rückdatierung der Meldung
   */
  public String getRueckdatierungsgrundCode() {
    return _rueckdatierungsgrundCode;
  }
  public void setRueckdatierungsgrundCode(String rueckdatierungsgrundCode) {
    _rueckdatierungsgrundCode = rueckdatierungsgrundCode;
  }


}
