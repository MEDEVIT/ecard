/*
 * CAUTION!! THIS IS A GENERATED FILE! PLEASE DON'T EDIT IT!
 * Your changes will be overwritten when the generation proccess
 * is run again.
 *
 * Instead, try to modify the sources from which the file was generated:
 * - java source code files in the packages at.chipkarte.client.dbas.core.api, at.chipkarte.client.dbas.core.api.valueobjects,
 *   at.chipkarte.ecard.server.dbas.api, and at.chipkarte.ecard.server.dbas.api.valueobjects
 *   (specifically the javadoc tags in these files)
 * - the configuration file conf/generator.properties
 * - the template from which this file was generated: templates/soapBean.vsl
 * - the code of the generator
 *
 * (C) SVC 2010
 */
package at.chipkarte.client.dbas.soap;
import at.chipkarte.client.dbas.soap.constants.*;


/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion createDatenblattDmpPmi.<br>
 * ParameterID: 120800. <br>
 */
public class DatenblattDmpPmi {

  /**
  * _geburtsdatum
  * @id 129007
  * @wui GEBD
  */
  private String _geburtsdatum;
  /**
  * _anzahlInfarkte
  * @id 120820
  * @wui 126B
  * @maxLength 2
  */
  private String _anzahlInfarkte;
  /**
  * _letzterInfarktJahr
  * @id 120821
  * @wui 126B
  * @maxLength 4
  */
  private String _letzterInfarktJahr;
  /**
  * _infarktart
  * @id 120822
  * @wui 126B
  */
  private String _infarktart;
  /**
  * _insultFamilie
  * @id 120823
  * @wui 126B
  */
  private String _insultFamilie;
  /**
  * _herzinfarktFamilie
  * @id 120824
  * @wui 126B
  */
  private String _herzinfarktFamilie;
  /**
  * _pavk
  * @id 120887
  * @wui 126B
  */
  private String _pavk;
  /**
  * _aortacoronarBypass
  * @id 120825
  * @wui 126C
  * @maxLength 1
  */
  private String _aortacoronarBypass;
  /**
  * _carotisOp
  * @id 120826
  * @wui 126C
  * @maxLength 1
  */
  private String _carotisOp;
  /**
  * _periphererBypassPta
  * @id 120827
  * @wui 126C
  * @maxLength 1
  */
  private String _periphererBypassPta;
  /**
  * _stent
  * @id 120828
  * @wui 126C
  * @maxLength 1
  */
  private String _stent;
  /**
  * _letzterStent
  * @id 120829
  * @wui 126C
  */
  private String _letzterStent;
  /**
  * _anginaPectoris
  * @id 120830
  * @wui 126D
  * @maxLength 1
  */
  private String _anginaPectoris;
  /**
  * _herzinsuffizienz
  * @id 120831
  * @wui 126D
  * @maxLength 1
  */
  private String _herzinsuffizienz;
  /**
  * _insultAnamnese
  * @id 120832
  * @wui 126D
  */
  private String _insultAnamnese;
  /**
  * _letzteKardiologischeReha
  * @id 120833
  * @wui 126D
  * @maxLength 4
  */
  private String _letzteKardiologischeReha;
  /**
  * _hypertonieSeit
  * @id 120834
  * @wui 126D
  * @maxLength 4
  */
  private String _hypertonieSeit;
  /**
  * _diabetesSeit
  * @id 120835
  * @wui 126D
  * @maxLength 4
  */
  private String _diabetesSeit;
  /**
  * _dialysepflichtSeit
  * @id 120836
  * @wui 126D
  * @maxLength 4
  */
  private String _dialysepflichtSeit;
  /**
  * _rauchenSeit
  * @id 120837
  * @wui 126D
  * @maxLength 4
  */
  private String _rauchenSeit;
  /**
  * _zigarettenProTag
  * @id 120838
  * @wui 126D
  * @maxLength 2
  */
  private String _zigarettenProTag;
  /**
  * _gewichtBefund
  * @id 120839
  * @wui 126E
  */
  private String _gewichtBefund;
  /**
  * _groesse
  * @id 120840
  * @wui 126E
  */
  private String _groesse;
  /**
  * _bauchumfang
  * @id 120841
  * @wui 126E
  */
  private String _bauchumfang;
  /**
  * _blutdruckSysBefund
  * @id 120843
  * @wui 126E
  */
  private String _blutdruckSysBefund;
  /**
  * _blutdruckDiaBefund
  * @id 120844
  * @wui 126E
  */
  private String _blutdruckDiaBefund;
  /**
  * _blutdruckMessart
  * @id 120845
  * @wui 126E
  */
  private String _blutdruckMessart;
  /**
  * _cholesterin
  * @id 120846
  * @wui 126E
  */
  private String _cholesterin;
  /**
  * _hdlCholesterin
  * @id 120847
  * @wui 126E
  */
  private String _hdlCholesterin;
  /**
  * _triglyceride
  * @id 120848
  * @wui 126E
  */
  private String _triglyceride;
  /**
  * _eq5D
  * @id 120850
  * @wui 126F
  */
  private String _eq5D;
  /**
  * _eq5Dvas
  * @id 120851
  * @wui 126F
  */
  private String _eq5Dvas;
  /**
  * _depressionsscore
  * @id 120852
  * @wui 126F
  */
  private String _depressionsscore;
  /**
  * _gesamtscore
  * @id 120853
  * @wui 126F
  */
  private String _gesamtscore;
  /**
  * _diabetikerHba1C
  * @id 120854
  * @wui 126F
  */
  private String _diabetikerHba1C;
  /**
  * _nichtDiabetikerNuechternBZWert
  * @id 120855
  * @wui 126F
  */
  private String _nichtDiabetikerNuechternBZWert;
  /**
  * _betablocker
  * @id 120856
  * @wui 126G
  */
  private String _betablocker;
  /**
  * _betablockerKontraindikation
  * @id 120857
  * @wui 126G
  */
  private String _betablockerKontraindikation;
  /**
  * _acehemmer
  * @id 120858
  * @wui 126G
  */
  private String _acehemmer;
  /**
  * _acehemmerKontraindikation
  * @id 120859
  * @wui 126G
  */
  private String _acehemmerKontraindikation;
  /**
  * _atIIAntagonisten
  * @id 120860
  * @wui 126G
  */
  private String _atIIAntagonisten;
  /**
  * _atIIAntagonistenKontraindikation
  * @id 120861
  * @wui 126G
  */
  private String _atIIAntagonistenKontraindikation;
  /**
  * _statine
  * @id 120862
  * @wui 126G
  */
  private String _statine;
  /**
  * _statineKontraindikation
  * @id 120863
  * @wui 126G
  */
  private String _statineKontraindikation;
  /**
  * _ass
  * @id 120864
  * @wui 126G
  */
  private String _ass;
  /**
  * _assKontraindikation
  * @id 120865
  * @wui 126G
  */
  private String _assKontraindikation;
  /**
  * _sonstigeTah
  * @id 120866
  * @wui 126G
  */
  private String _sonstigeTah;
  /**
  * _sonstigeTahKontraindikation
  * @id 120867
  * @wui 126G
  */
  private String _sonstigeTahKontraindikation;
  /**
  * _nitrateMolsidomin
  * @id 120868
  * @wui 126G
  */
  private String _nitrateMolsidomin;
  /**
  * _nitrateMolsidominKontraindikation
  * @id 120869
  * @wui 126G
  */
  private String _nitrateMolsidominKontraindikation;
  /**
  * _kalziumkanalblocker
  * @id 120870
  * @wui 126G
  */
  private String _kalziumkanalblocker;
  /**
  * _kalziumkanalblockerKontraindikation
  * @id 120871
  * @wui 126G
  */
  private String _kalziumkanalblockerKontraindikation;
  /**
  * _kaliumkanaloeffner
  * @id 120872
  * @wui 126G
  */
  private String _kaliumkanaloeffner;
  /**
  * _kaliumkanaloeffnerKontraindikation
  * @id 120873
  * @wui 126G
  */
  private String _kaliumkanaloeffnerKontraindikation;
  /**
  * _blutdruckSysZielvereinbarung
  * @id 120874
  * @wui 126H
  */
  private String _blutdruckSysZielvereinbarung;
  /**
  * _blutdruckDiaZielvereinbarung
  * @id 120875
  * @wui 126H
  */
  private String _blutdruckDiaZielvereinbarung;
  /**
  * _ernaehrung
  * @id 120876
  * @wui 126H
  */
  private String _ernaehrung;
  /**
  * _bewegung
  * @id 120877
  * @wui 126H
  */
  private String _bewegung;
  /**
  * _gewichtZielvereinbarung
  * @id 120878
  * @wui 126H
  */
  private String _gewichtZielvereinbarung;
  /**
  * _tabak
  * @id 120879
  * @wui 126H
  */
  private String _tabak;
  /**
  * _grippeimpfungZielvereinbarung
  * @id 120888
  * @wui 126H
  */
  private String _grippeimpfungZielvereinbarung;
  /**
  * _ernaehrungsBeratung
  * @id 120880
  * @wui 126J
  */
  private String _ernaehrungsBeratung;
  /**
  * _koerperlicheAktivitaeten
  * @id 120881
  * @wui 126J
  */
  private String _koerperlicheAktivitaeten;
  /**
  * _raucherberatungEntwoehnung
  * @id 120882
  * @wui 126J
  */
  private String _raucherberatungEntwoehnung;
  /**
  * _grippeimpfung
  * @id 120883
  * @wui 126J
  */
  private String _grippeimpfung;
  /**
  * _ueberweisungInternistKardiologe
  * @id 120884
  * @wui 126J
  */
  private String _ueberweisungInternistKardiologe;
  /**
  * _ueberweisungInternKardiolAmbulanz
  * @id 120889
  * @wui 126J
  */
  private String _ueberweisungInternKardiolAmbulanz;
  /**
  * _ueberweisungStationaereAufnahme
  * @id 120890
  * @wui 126J
  */
  private String _ueberweisungStationaereAufnahme;
  /**
  * _pmiSchulung
  * @id 120885
  * @wui 126J
  */
  private String _pmiSchulung;
  /**
  * _pmiSchulungWannJahr
  * @id 120886
  * @wui 126J
  */
  private String _pmiSchulungWannJahr;
  /**
  * _untersuchungsdatum
  * @id 120605
  * @wui PERSDAT
  */
  private String _untersuchungsdatum;
  /**
   * _bvId
   * @id 120002
   */
  private Long _bvId;
  /**
  * _versionsnummer
  * @id 129008
  */
  private String _versionsnummer;
  /**
  * _svNummer
  * @id 129001
  */
  private String _svNummer;

  /**
   * Geburtsdatum des Patienten, das manuell eingegeben wurde.
   */
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }
  public void setGeburtsdatum(String _geburtsdatum) {
    this._geburtsdatum = _geburtsdatum;
  }
  /**
   * Anzahl bisheriger Infarkte.<br>
   * Format: Numerisch von 0 - 99.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120820.
   */
  public String getAnzahlInfarkte() {
    return _anzahlInfarkte;
  }
  public void setAnzahlInfarkte(String _anzahlInfarkte) {
    this._anzahlInfarkte = _anzahlInfarkte;
  }
  /**
   * Jahr des letzten Infarktes.<br>
   * Format: Numerisch im Format yyyy.<br>
   * Angabe: Bedingt (Muss zwischen Geburtsjahr und dem aktuellen Jahr liegen.
   * Pflichtfeld wenn anzahlinfarkte > 0 ist. Keine Eingabe erlaubt wenn anzahlinfarkte gleich 0 ist.).<br>
   * ParameterID: 120821.
   */
  public String getLetzterInfarktJahr() {
    return _letzterInfarktJahr;
  }
  public void setLetzterInfarktJahr(String _letzterInfarktJahr) {
    this._letzterInfarktJahr = _letzterInfarktJahr;
  }
  /**
   * Infarktart (Vorliegen von Stemi).<br>
   * Mögliche Werte siehe {@link InfarktartTypConstants InfarktartTypConstants}.<br>
   * Angabe: Bedingt (Pflichtfeld wenn anzahlinfarkte > 0 ist. Keine Eingabe erlaubt wenn anzahlinfarkte gleich 0 ist.).<br>
   * ParameterID: 120822.
   */
  public String getInfarktart() {
    return _infarktart;
  }
  public void setInfarktart(String _infarktart) {
    this._infarktart = _infarktart;
  }
  /**
   * Insult (Familien Anamnese).<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120823.
   */
  public String getInsultFamilie() {
    return _insultFamilie;
  }
  public void setInsultFamilie(String _insultFamilie) {
    this._insultFamilie = _insultFamilie;
  }
  /**
   * Herzinfarkt (Familien Anamnese).<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120824.
   */
  public String getHerzinfarktFamilie() {
    return _herzinfarktFamilie;
  }
  public void setHerzinfarktFamilie(String _herzinfarktFamilie) {
    this._herzinfarktFamilie = _herzinfarktFamilie;
  }
  /**
   * PAVK (periphere Arterielle Verschlusskrankheit). <br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120887
   */
  public String getPavk() {
    return _pavk;
  }
  public void setPavk(String _pavk) {
    this._pavk = _pavk;
  }
  /**
   * Aortacoronarer Bypass.<br>
   * Format: Numerisch von 0 - 9 (9 steht für unbekannt).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120825.
   */
  public String getAortacoronarBypass() {
    return _aortacoronarBypass;
  }
  public void setAortacoronarBypass(String _aortacoronarBypass) {
    this._aortacoronarBypass = _aortacoronarBypass;
  }
  /**
   * Carotis-OP.<br>
   * Format: Numerisch von 0 - 9 (9 steht für unbekannt).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120826.
   */
  public String getCarotisOp() {
    return _carotisOp;
  }
  public void setCarotisOp(String _carotisOp) {
    this._carotisOp = _carotisOp;
  }
  /**
   * Peripherer Bypass/PTA.<br>
   * Format: Numerisch von 0 - 9 (9 steht für unbekannt).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120827.
   */
  public String getPeriphererBypassPta() {
    return _periphererBypassPta;
  }
  public void setPeriphererBypassPta(String _periphererBypassPta) {
    this._periphererBypassPta = _periphererBypassPta;
  }
  /**
   * Stent.<br>
   * Format: Numerisch von 0 - 9 (9 steht für unbekannt).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120828.
   */
  public String getStent() {
    return _stent;
  }
  public void setStent(String _stent) {
    this._stent = _stent;
  }
  /**
   * Typ des letzten Stents.<br>
   * Mögliche Werte siehe {@link LetzterStentTypConstants LetzterStentTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120829.
   */
  public String getLetzterStent() {
    return _letzterStent;
  }
  public void setLetzterStent(String _letzterStent) {
    this._letzterStent = _letzterStent;
  }
  /**
   * Angina Pectoris (CSS).<br>
   * Format: Numerisch von 0 - 4.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120830.
   */
  public String getAnginaPectoris() {
    return _anginaPectoris;
  }
  public void setAnginaPectoris(String _anginaPectoris) {
    this._anginaPectoris = _anginaPectoris;
  }
  /**
   * Herzinsuffizienz (NYHA).<br>
   * Format: Numerisch von 0 - 4.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120831.
   */
  public String getHerzinsuffizienz() {
    return _herzinsuffizienz;
  }
  public void setHerzinsuffizienz(String _herzinsuffizienz) {
    this._herzinsuffizienz = _herzinsuffizienz;
  }
  /**
   * Auftreten Insult.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120832.
   */
  public String getInsultAnamnese() {
    return _insultAnamnese;
  }
  public void setInsultAnamnese(String _insultAnamnese) {
    this._insultAnamnese = _insultAnamnese;
  }
  /**
   * Letzte kardiologische REHA (Jahr).<br>
   * Format: Numerisch im Format yyyy bzw. 0 (wenn keine kardiologische REHA).<br>
   * Angabe: Muss (Muss zwischen Geburtsjahr und dem aktuellen Jahr liegen.).<br>
   * ParameterID: 120833.
   */
  public String getLetzteKardiologischeReha() {
    return _letzteKardiologischeReha;
  }
  public void setLetzteKardiologischeReha(String _letzteKardiologischeReha) {
    this._letzteKardiologischeReha = _letzteKardiologischeReha;
  }
  /**
   * Jahresangabe, seit wann der Patient an Hypertonie leidet (ungefähr).<br>
   * Format: Numerisch im Format yyyy bzw. 0 (wenn keine Hypertonie).<br>
   * Angabe: Muss (Muss zwischen Geburtsjahr und dem aktuellen Jahr liegen.)<br>
   * ParameterID: 120834.
   */
  public String getHypertonieSeit() {
    return _hypertonieSeit;
  }
  public void setHypertonieSeit(String _hypertonieSeit) {
    this._hypertonieSeit = _hypertonieSeit;
  }
  /**
   * Jahresangabe, seit wann der Patient an Diabetes leidet (ungefähr).<br>
   * Format: Numerisch im Format yyyy bzw. 0 (wenn keine Diabetes).<br>
   * Angabe: Muss (Muss zwischen Geburtsjahr und dem aktuellen Jahr liegen.)<br>
   * ParameterID: 120835.
   */
  public String getDiabetesSeit() {
    return _diabetesSeit;
  }
  public void setDiabetesSeit(String _diabetesSeit) {
    this._diabetesSeit = _diabetesSeit;
  }
  /**
   * Dialysepflicht seit.<br>
   * Format: Numerisch im Format yyyy bzw. 0 (wenn keine Dialysepflicht).<br>
   * Angabe: Muss (Muss zwischen Geburtsjahr und dem aktuellen Jahr liegen).<br>
   * ParameterID: 120836.
   */
  public String getDialysepflichtSeit() {
    return _dialysepflichtSeit;
  }
  public void setDialysepflichtSeit(String _dialysepflichtSeit) {
    this._dialysepflichtSeit = _dialysepflichtSeit;
  }
  /**
   * Rauchen seit (ungefähr).<br>
   * Format: Numerisch im Format yyyy bzw. 0 (wenn kein Raucher).<br>
   * Angabe: Muss (Muss zwischen Geburtsjahr und dem aktuellen Jahr liegen).<br>
   * ParameterID: 120837.
   */
  public String getRauchenSeit() {
    return _rauchenSeit;
  }
  public void setRauchenSeit(String _rauchenSeit) {
    this._rauchenSeit = _rauchenSeit;
  }
  /**
   * Angabe über das Rauchverhalten des Patienten (Anzahl der Zigaretten pro Tag).<br>
   * Format: Numerisch von 0 - 99 (Muss > 0 sein, wenn RauchenSeit mit einer Jahreszahl belegt ist).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120838.
   */
  public String getZigarettenProTag() {
    return _zigarettenProTag;
  }
  public void setZigarettenProTag(String _zigarettenProTag) {
    this._zigarettenProTag = _zigarettenProTag;
  }
  /**
   * Gewicht [kg].<br>
   * Format: Numerisch von 0 - 300 (Der Wert "0" steht für nicht eruierbar.).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120839.
   */
  public String getGewichtBefund() {
    return _gewichtBefund;
  }
  public void setGewichtBefund(String _gewichtBefund) {
    this._gewichtBefund = _gewichtBefund;
  }
  /**
   * Größe [cm].<br>
   * Format: Numerisch von 40 - 250.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120840.
   */
  public String getGroesse() {
    return _groesse;
  }
  public void setGroesse(String _groesse) {
    this._groesse = _groesse;
  }
  /**
   * Bauchumfang [cm].<br>
   * Format: Numerisch 0 - 300.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120841.
   */
  public String getBauchumfang() {
    return _bauchumfang;
  }
  public void setBauchumfang(String _bauchumfang) {
    this._bauchumfang = _bauchumfang;
  }
  /**
   * Blutdruck systolisch [mmHg].<br>
   * Format: Numerisch von 70 - 300.<br>
   * Angabe: Muss (Der Wert muss größer sein als der 'diastolische Wert').<br>
   * ParameterID: 120843.
   */
  public String getBlutdruckSysBefund() {
    return _blutdruckSysBefund;
  }
  public void setBlutdruckSysBefund(String _blutdruckSysBefund) {
    this._blutdruckSysBefund = _blutdruckSysBefund;
  }
  /**
   * Blutdruck diastolisch [mmHg].<br>
   * Format: Numerisch von 30 - 150.<br>
   * Angabe: Muss (Der Wert muss kleiner sein als der 'systolische Wert').<br>
   * ParameterID: 120844.
   */
  public String getBlutdruckDiaBefund() {
    return _blutdruckDiaBefund;
  }
  public void setBlutdruckDiaBefund(String _blutdruckDiaBefund) {
    this._blutdruckDiaBefund = _blutdruckDiaBefund;
  }
  /**
   * Blutdruck-Messart.<br>
   * Mögliche Werte siehe {@link RrMessartTypConstants RrMessartTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120845.
   */
  public String getBlutdruckMessart() {
    return _blutdruckMessart;
  }
  public void setBlutdruckMessart(String _blutdruckMessart) {
    this._blutdruckMessart = _blutdruckMessart;
  }
  /**
   * Cholesterin [mg/dl].<br>
   * Format: Numerisch von 0 - 999.<br>
   * Angabe: Muss (Der Wert "0" steht für nicht eruierbar.)<br>
   * ParameterID: 120846.
   */
  public String getCholesterin() {
    return _cholesterin;
  }
  public void setCholesterin(String _cholesterin) {
    this._cholesterin = _cholesterin;
  }
  /**
   * HDL-Cholesterin [mg/dl].<br>
   * Format: Numerisch von 0 - 999.<br>
   * Angabe: Muss (Der Wert "0" steht für nicht eruierbar.)<br>
   * ParameterID: 120847.
   */
  public String getHdlCholesterin() {
    return _hdlCholesterin;
  }
  public void setHdlCholesterin(String _hdlCholesterin) {
    this._hdlCholesterin = _hdlCholesterin;
  }
  /**
   * Triglyceride [mg/dl].<br>
   * Format: Numerisch von 0 - 999.<br>
   * Angabe: Muss (Der Wert "0" steht für nicht eruierbar.)<br>
   * ParameterID: 120848.
   */
  public String getTriglyceride() {
    return _triglyceride;
  }
  public void setTriglyceride(String _triglyceride) {
    this._triglyceride = _triglyceride;
  }
  /**
   * Messwert der gesundheitsbezogenen Lebensqualität, der aus 5 Fragen berechnet wird.<br>
   * Format: Numerisch: [1-3]{5} (5-stellig, wobei nur die Ziffern 1-3 erlaubt sind).<br>
   * Angabe: Muss.<br>
   * ParameterID: 120850.
   */
  public String getEq5D() {
    return _eq5D;
  }
  public void setEq5D(String _eq5D) {
    this._eq5D = _eq5D;
  }
  /**
   * Verwendung der visuellen Analog-Skala bei EQ-5D.<br>
   * Format: Numerisch von 0 - 100.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120851.
   */
  public String getEq5Dvas() {
    return _eq5Dvas;
  }
  public void setEq5Dvas(String _eq5Dvas) {
    this._eq5Dvas = _eq5Dvas;
  }
  /**
   * Depressionsscore.<br>
   * Format: Numerisch von 0 - 21.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120852.
   */
  public String getDepressionsscore() {
    return _depressionsscore;
  }
  public void setDepressionsscore(String _depressionsscore) {
    this._depressionsscore = _depressionsscore;
  }
  /**
   * Gesamtscore.<br>
   * Format: Numerisch von 0 - 42.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120853.
   */
  public String getGesamtscore() {
    return _gesamtscore;
  }
  public void setGesamtscore(String _gesamtscore) {
    this._gesamtscore = _gesamtscore;
  }
  /**
   * HbA1c [%] bei Diabetikern.<br>
   * Format: Numerisch von 4,0 - 39,9.<br>
   * Angabe: Bedingt (Entweder diabetikerHba1c oder nichtDiabetikerNuechternBZWert muss angegeben werden).<br>
   * ParameterID: 120854.
   */
  public String getDiabetikerHba1C() {
    return _diabetikerHba1C;
  }
  public void setDiabetikerHba1C(String _diabetikerHba1C) {
    this._diabetikerHba1C = _diabetikerHba1C;
  }
  /**
   * Nüchtern Blutzucker-Wert [mg/dl] bei Nichtdiabetikern.<br>
   * Format: Numerisch von 20 - 999.<br>
   * Angabe: Bedingt (Entweder diabetikerHba1c oder nichtDiabetikerNuechternBZWert muss angegeben werden).<br>
   * ParameterID: 120855.
   */
  public String getNichtDiabetikerNuechternBZWert() {
    return _nichtDiabetikerNuechternBZWert;
  }
  public void setNichtDiabetikerNuechternBZWert(String _nichtDiabetikerNuechternBZWert) {
    this._nichtDiabetikerNuechternBZWert = _nichtDiabetikerNuechternBZWert;
  }
  /**
   * Betablocker.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120856.
   */
  public String getBetablocker() {
    return _betablocker;
  }
  public void setBetablocker(String _betablocker) {
    this._betablocker = _betablocker;
  }
  /**
   * Betablocker Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120857.
   */
  public String getBetablockerKontraindikation() {
    return _betablockerKontraindikation;
  }
  public void setBetablockerKontraindikation(String _betablockerKontraindikation) {
    this._betablockerKontraindikation = _betablockerKontraindikation;
  }
  /**
   * ACE-Hemmer.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120858.
   */
  public String getAcehemmer() {
    return _acehemmer;
  }
  public void setAcehemmer(String _acehemmer) {
    this._acehemmer = _acehemmer;
  }
  /**
   * ACE-Hemmer Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120859.
   */
  public String getAcehemmerKontraindikation() {
    return _acehemmerKontraindikation;
  }
  public void setAcehemmerKontraindikation(String _acehemmerKontraindikation) {
    this._acehemmerKontraindikation = _acehemmerKontraindikation;
  }
  /**
   * AT-II-Antagonisten.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120860.
   */
  public String getAtIIAntagonisten() {
    return _atIIAntagonisten;
  }
  public void setAtIIAntagonisten(String _atIIAntagonisten) {
    this._atIIAntagonisten = _atIIAntagonisten;
  }
  /**
   * AT-II-Antagonisten Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120861.
   */
  public String getAtIIAntagonistenKontraindikation() {
    return _atIIAntagonistenKontraindikation;
  }
  public void setAtIIAntagonistenKontraindikation(String _atIIAntagonistenKontraindikation) {
    this._atIIAntagonistenKontraindikation = _atIIAntagonistenKontraindikation;
  }
  /**
   * Statine.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120862.
   */
  public String getStatine() {
    return _statine;
  }
  public void setStatine(String _statine) {
    this._statine = _statine;
  }
  /**
   * Statine Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120863.
   */
  public String getStatineKontraindikation() {
    return _statineKontraindikation;
  }
  public void setStatineKontraindikation(String _statineKontraindikation) {
    this._statineKontraindikation = _statineKontraindikation;
  }
  /**
   * ASS.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120864.
   */
  public String getAss() {
    return _ass;
  }
  public void setAss(String _ass) {
    this._ass = _ass;
  }
  /**
   * ASS Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120865.
   */
  public String getAssKontraindikation() {
    return _assKontraindikation;
  }
  public void setAssKontraindikation(String _assKontraindikation) {
    this._assKontraindikation = _assKontraindikation;
  }
  /**
   * Sonstige Trombozytenaggregationshemmer.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120866.
   */
  public String getSonstigeTah() {
    return _sonstigeTah;
  }
  public void setSonstigeTah(String _sonstigeTah) {
    this._sonstigeTah = _sonstigeTah;
  }
  /**
   * Sonstige Trombozytenaggregationshemmer Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120867.
   */
  public String getSonstigeTahKontraindikation() {
    return _sonstigeTahKontraindikation;
  }
  public void setSonstigeTahKontraindikation(String _sonstigeTahKontraindikation) {
    this._sonstigeTahKontraindikation = _sonstigeTahKontraindikation;
  }
  /**
   * Nitrate/Molsidomin.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120868.
   */
  public String getNitrateMolsidomin() {
    return _nitrateMolsidomin;
  }
  public void setNitrateMolsidomin(String _nitrateMolsidomin) {
    this._nitrateMolsidomin = _nitrateMolsidomin;
  }
  /**
   * Nitrate/Molsidomin Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120869.
   */
  public String getNitrateMolsidominKontraindikation() {
    return _nitrateMolsidominKontraindikation;
  }
  public void setNitrateMolsidominKontraindikation(String _nitrateMolsidominKontraindikation) {
    this._nitrateMolsidominKontraindikation = _nitrateMolsidominKontraindikation;
  }
  /**
   * Kalziumkanal-Blocker.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120870.
   */
  public String getKalziumkanalblocker() {
    return _kalziumkanalblocker;
  }
  public void setKalziumkanalblocker(String _kalziumkanalblocker) {
    this._kalziumkanalblocker = _kalziumkanalblocker;
  }
  /**
   * Kalziumkanal-Blocker Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120871.
   */
  public String getKalziumkanalblockerKontraindikation() {
    return _kalziumkanalblockerKontraindikation;
  }
  public void setKalziumkanalblockerKontraindikation(String _kalziumkanalblockerKontraindikation) {
    this._kalziumkanalblockerKontraindikation = _kalziumkanalblockerKontraindikation;
  }
  /**
   * Kaliumkanal-Öffner.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120872.
   */
  public String getKaliumkanaloeffner() {
    return _kaliumkanaloeffner;
  }
  public void setKaliumkanaloeffner(String _kaliumkanaloeffner) {
    this._kaliumkanaloeffner = _kaliumkanaloeffner;
  }
  /**
   * Kaliumkanal-Öffner Kontraindikation.<br>
   * Mögliche Werte siehe {@link JaTypConstants JaTypConstants}.<br>
   * Angabe: Kann.<br>
   * ParameterID: 120873.
   */
  public String getKaliumkanaloeffnerKontraindikation() {
    return _kaliumkanaloeffnerKontraindikation;
  }
  public void setKaliumkanaloeffnerKontraindikation(String _kaliumkanaloeffnerKontraindikation) {
    this._kaliumkanaloeffnerKontraindikation = _kaliumkanaloeffnerKontraindikation;
  }
  /**
   * Blutdruck systolisch [mmHg] - Zielvereinbarung.<br>
   * Format: Numerisch von 70 - 300.<br>
   * Angabe: Muss (Der Wert muss größer sein als der 'diastolische Zielwert').<br>
   * ParameterID: 120874.
   */
  public String getBlutdruckSysZielvereinbarung() {
    return _blutdruckSysZielvereinbarung;
  }
  public void setBlutdruckSysZielvereinbarung(String _blutdruckSysZielvereinbarung) {
    this._blutdruckSysZielvereinbarung = _blutdruckSysZielvereinbarung;
  }
  /**
   * Blutdruck diastolisch [mmHg] - Zielvereinbarung.<br>
   * Format: Numerisch von 30 - 150.<br>
   * Angabe: Muss (Der Wert muss kleiner sein als der 'systolische Zielwert').<br>
   * ParameterID: 120875.
   */
  public String getBlutdruckDiaZielvereinbarung() {
    return _blutdruckDiaZielvereinbarung;
  }
  public void setBlutdruckDiaZielvereinbarung(String _blutdruckDiaZielvereinbarung) {
    this._blutdruckDiaZielvereinbarung = _blutdruckDiaZielvereinbarung;
  }
  /**
   * Ernaehrung - Zielvereinbarung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120876.
   */
  public String getErnaehrung() {
    return _ernaehrung;
  }
  public void setErnaehrung(String _ernaehrung) {
    this._ernaehrung = _ernaehrung;
  }
  /**
   * Bewegung - Zielvereinbarung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120877.
   */
  public String getBewegung() {
    return _bewegung;
  }
  public void setBewegung(String _bewegung) {
    this._bewegung = _bewegung;
  }
  /**
   * Gewichtsreduktion - Zielvereinbarung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120878.
   */
  public String getGewichtZielvereinbarung() {
    return _gewichtZielvereinbarung;
  }
  public void setGewichtZielvereinbarung(String _gewichtZielvereinbarung) {
    this._gewichtZielvereinbarung = _gewichtZielvereinbarung;
  }
  /**
   * Tabakreduktion/-stopp - Zielvereinbarung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss (darf nicht mit 'Ja' belegt sein, wenn 'Rauchen' den Wert '0' hat).<br>
   * ParameterID: 120879.
   */
  public String getTabak() {
    return _tabak;
  }
  public void setTabak(String _tabak) {
    this._tabak = _tabak;
  }
  /**
   * Grippeimpfung - Zielvereinbarung.
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120888
   */
  public String getGrippeimpfungZielvereinbarung() {
    return _grippeimpfungZielvereinbarung;
  }
  public void setGrippeimpfungZielvereinbarung(String _grippeimpfungZielvereinbarung) {
    this._grippeimpfungZielvereinbarung = _grippeimpfungZielvereinbarung;
  }
  /**
   * Ernährungsberatung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120880.
   */
  public String getErnaehrungsBeratung() {
    return _ernaehrungsBeratung;
  }
  public void setErnaehrungsBeratung(String _ernaehrungsBeratung) {
    this._ernaehrungsBeratung = _ernaehrungsBeratung;
  }
  /**
   * Körperliche Aktivitäten.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120881.
   */
  public String getKoerperlicheAktivitaeten() {
    return _koerperlicheAktivitaeten;
  }
  public void setKoerperlicheAktivitaeten(String _koerperlicheAktivitaeten) {
    this._koerperlicheAktivitaeten = _koerperlicheAktivitaeten;
  }
  /**
   * Raucherberatung/-entwöhnung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120882.
   */
  public String getRaucherberatungEntwoehnung() {
    return _raucherberatungEntwoehnung;
  }
  public void setRaucherberatungEntwoehnung(String _raucherberatungEntwoehnung) {
    this._raucherberatungEntwoehnung = _raucherberatungEntwoehnung;
  }
  /**
   * Grippeimpfung im letzten Jahr.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120883.
   */
  public String getGrippeimpfung() {
    return _grippeimpfung;
  }
  public void setGrippeimpfung(String _grippeimpfung) {
    this._grippeimpfung = _grippeimpfung;
  }
  /**
   * Überweisung zum Internisten/Kardiologen.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss.<br>
   * ParameterID: 120884.
   */
  public String getUeberweisungInternistKardiologe() {
    return _ueberweisungInternistKardiologe;
  }
  public void setUeberweisungInternistKardiologe(String _ueberweisungInternistKardiologe) {
    this._ueberweisungInternistKardiologe = _ueberweisungInternistKardiologe;
  }
  /**
   * Überweisung zur internistischen / kardiologischen Ambulanz.
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss. <br>
   * ParameterID: 120889
   */
  public String getUeberweisungInternKardiolAmbulanz() {
    return _ueberweisungInternKardiolAmbulanz;
  }
  public void setUeberweisungInternKardiolAmbulanz(String _ueberweisungInternKardiolAmbulanz) {
    this._ueberweisungInternKardiolAmbulanz = _ueberweisungInternKardiolAmbulanz;
  }
  /**
   * Überweisung zur stationären Aufnahme.
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Muss. <br>
   * ParameterID: 120890
   */
  public String getUeberweisungStationaereAufnahme() {
    return _ueberweisungStationaereAufnahme;
  }
  public void setUeberweisungStationaereAufnahme(String _ueberweisungStationaereAufnahme) {
    this._ueberweisungStationaereAufnahme = _ueberweisungStationaereAufnahme;
  }
  /**
   * PMI Schulung.<br>
   * Mögliche Werte siehe {@link JaNeinTypConstants JaNeinTypConstants}.<br>
   * Angabe: Kann (Muss den Wert 'Ja' haben, wenn das Datenfeld PmiSchulungWannJahr angegeben ist).<br>
   * ParameterID: 120885.
   */
  public String getPmiSchulung() {
    return _pmiSchulung;
  }
  public void setPmiSchulung(String _pmiSchulung) {
    this._pmiSchulung = _pmiSchulung;
  }
  /**
   * Angabe, in welchem Jahr die PMI Schulung besucht wurde.<br>
   * Format: Numerisch im Format yyyy bzw. 0.<br>
   * Angabe: Bedingt (Pflichtfeld wenn pmischulung mit 'Ja' belegt ist.
   * Muss zwischen dem aktuellen Jahr und dem Geburtsjahr liegen.
   * Keine Angabe erlaubt wenn 'PmiSchulung' nicht oder mit 'Nein' belegt ist. Eingabe von "0" wenn genaues Jahr
   * nicht bekannt.)<br>
   * ParameterID: 120886.
   */
  public String getPmiSchulungWannJahr() {
    return _pmiSchulungWannJahr;
  }
  public void setPmiSchulungWannJahr(String _pmiSchulungWannJahr) {
    this._pmiSchulungWannJahr = _pmiSchulungWannJahr;
  }

  /**
   * Untersuchungsdatum.<br>
   * Format: Datum im Format 'TT.MM.JJJJ'.<br>
   * Angabe: Muss (Das Datum darf nicht in der Zukunft liegen. Das Datum darf maximal 3 Jahre in der Vergangenheit liegen. Das Datum
   * muss innerhalb der Gültigkeitsdauer des gewählten Betreuungsverhältnisses liegen. Als Gültigkeitsdauer gilt der Zeitraum
   * zwischen Antragsdatum und Ausschreibedatum (falls kein Ausschreibedatum vorhanden ist, gilt das heutige Datum). Hinweis: Der
   * Patient muss zu diesem Datum eingeschieben gewesen sein.)<br>
   * ParameterID: 120605.
   */
  public String getUntersuchungsdatum() {
    return _untersuchungsdatum;
  }
  public void setUntersuchungsdatum(String _untersuchungsdatum) {
    this._untersuchungsdatum = _untersuchungsdatum;
  }
  /**
   * Version des Dokumentations-/Befundblattes.<br>
   * Mögliche Werte siehe {@link DatenblattConstants DatenblattConstants}.<br>
   * Angabe: Muss. <br>
   * ParameterID: 129008.
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
   */
  public String getSvNummer() {
    return _svNummer;
  }
  public void setSvNummer(String _svNummer) {
    this._svNummer = _svNummer;
  }
  
  /**
   * Eindeutiger Bezeichner des ausgewählten Betreuungsverhältnisses.<br>
   * Format: 19-stellig. <br>    
   * Angabe: Muss.    
   * @return BvId
   */
  public Long getBvId() {
    return _bvId;
  }
  public void setBvId(Long bvId) {
    _bvId = bvId;
  }
}