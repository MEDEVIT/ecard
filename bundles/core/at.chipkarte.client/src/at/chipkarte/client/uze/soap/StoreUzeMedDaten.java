/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.uze.soap;

/**
 * Enthält die medizinischen Daten die der Vertragspartner im Zuge
 *  der Erstellung einer Über-/Zu-/Einweisung erfasst.
 */
public class StoreUzeMedDaten {
  private Medikament _medikation;
  private String _akutTherapie;
  private String _allergieMuInfo;
  private String _antikoaguliert;
  private String _gewuenschteLeistung;
  private String _notizLa;
  private String _symptomBeschreibung;
  private String _verdachtsDiagnose;
  private String _vorgeschichte;
  private String _wesentlicheNebenDiagnosen;
  
  /**
   * Vom Leistungsanforderer verabreichte Medikamente.<br>
   * Die Angabe der Medikation ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return medikation
   */
  public Medikament getMedikation() {
    return _medikation;
  }

  /**
   * Vom Leistungsanforderer durchgef&uuml;hrte Therapie.<br>
   * Die Angabe der Akuttherapie ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return AkutTherapie
   */
  public String getAkutTherapie() {
    return _akutTherapie;
  }

  /**
   * Information &uuml;ber bekannte Allergien und Unvertr&auml;glichkeiten von Medikamenten.<br>
   * Die Angabe von AllergieMuInfo ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return AllergieMuInfo
   */
  public String getAllergieMuInfo() {
    return _allergieMuInfo;
  }
  
  /**
   * Code Antikoaguliert der medikamentös gehemmten Blutgerinnung.<br>
   * Die Angabe von Antikoaguliert ist optional.<br/>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.Antikoaguliert Antikoaguliert}.<br>
   * @return Antikoaguliert
   */
  public String getAntikoaguliert() {
    return _antikoaguliert;
  }

  /**
   * Gew&uuml;nschte Leistung, Zweck der UZE.<br>
   * Format: maximal 500-stellig.
   * @return GewuenschteLeistung
   */
  public String getGewuenschteLeistung() {
    return _gewuenschteLeistung;
  }

  /**
   * Notiz des Leistungsanforderers an den Leistungserbringer.<br>
   * Die Angabe der NotizLa ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return NotizLa
   */
  public String getNotizLa() {
    return _notizLa;
  }

  /**
   * Symptome der Krankheit.<br>
   * Die Angabe der Symptombeschreibung ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return SymptomBeschreibung
   */
  public String getSymptomBeschreibung() {
    return _symptomBeschreibung;
  }

  /**
   * Diagnose des weisenden Arztes.<br>
   * Format: maximal 500-stellig.
   * @return VerdachtsDiagnose
   */
  public String getVerdachtsDiagnose() {
    return _verdachtsDiagnose;
  }

  /**
   * Medizinische Vorgeschichte des Patienten.<br>
   * Die Angabe der Vorgeschichte ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return Vorgeschichte
   */
  public String getVorgeschichte() {
    return _vorgeschichte;
  }
  
  /**
   * Zus&auml;tzliche Diagnosen des Arztes.<br>
   * Die Angabe der wesentlichen Nebendiagnosen ist optional.<br/>
   * Format: maximal 500-stellig.
   * @return WesentlicheNebenDiagnosen
   */
  public String getWesentlicheNebenDiagnosen() {
    return _wesentlicheNebenDiagnosen;
  }

  /**
   * Vom Leistungsanforderer verabreichte Medikamente.<br>
   * Die Angabe der Medikation ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param medikation Der zu setzende Wert f&uuml;r Medikation.
   */
  public void setMedikation(Medikament medikation) {
    _medikation = medikation;
  }

  /**
   * Vom Leistungsanforderer durchgef&uuml;hrte Therapie.<br>
   * Die Angabe der Akuttherapie ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param akutTherapie Der zu setzende Wert f&uuml;r AkutTherapie.
   */
  public void setAkutTherapie(String akutTherapie) {
    _akutTherapie = akutTherapie;
  }

  /**
   * Information &uuml;ber bekannte Allergien und Unvertr&auml;glichkeiten von Medikamenten.<br>
   * Die Angabe von AllergieMuInfo ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param allergieMuInfo Der zu setzende Wert f&uuml;r AllergieMuInfo.
   */
  public void setAllergieMuInfo(String allergieMuInfo) {
    _allergieMuInfo = allergieMuInfo;
  }
  
  /**
   * Code Antikoaguliert der medikamentös gehemmten Blutgerinnung.<br>
   * Die Angabe von Antikoaguliert ist optional.<br/>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.Antikoaguliert Antikoaguliert}.<br>
   * @param antikoaguliert Der zu setzende Wert f&uuml;r Antikoaguliert.
   */
  public void setAntikoaguliert(String antikoaguliert) {
    _antikoaguliert = antikoaguliert;
  }

  /**
   * Gew&uuml;nschte Leistung, Zweck der UZE.<br>
   * Format: maximal 500-stellig.
   * @param gewuenschteLeistung Der zu setzende Wert f&uuml;r GewuenschteLeistung.
   */
  public void setGewuenschteLeistung(String gewuenschteLeistung) {
    _gewuenschteLeistung = gewuenschteLeistung;
  }

  /**
   * Notiz des Leistungsanforderers an den Leistungserbringer.<br>
   * Format: maximal 500-stellig.
   * @param notizLa Der zu setzende Wert f&uuml;r NotizLa.
   */
  public void setNotizLa(String notizLa) {
    _notizLa = notizLa;
  }

  /**
   * Symptome der Krankheit.<br>
   * Die Angabe der Symptombeschreibung ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param symptomBeschreibung Der zu setzende Wert f&uuml;r SymptomBeschreibung.
   */
  public void setSymptomBeschreibung(String symptomBeschreibung) {
    _symptomBeschreibung = symptomBeschreibung;
  }

  /**
   * Diagnose des weisenden Arztes.<br>
   * Format: maximal 500-stellig.
   * @param verdachtsDiagnose Der zu setzende Wert f&uuml;r VerdachtsDiagnose.
   */
  public void setVerdachtsDiagnose(String verdachtsDiagnose) {
    _verdachtsDiagnose = verdachtsDiagnose;
  }

  /**
   * Medizinische Vorgeschichte des Patienten.<br>
   * Die Angabe der Vorgeschichte ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param vorgeschichte Der zu setzende Wert f&uuml;r Vorgeschichte.
   */
  public void setVorgeschichte(String vorgeschichte) {
    _vorgeschichte = vorgeschichte;
  }

  /**
   * Zus&auml;tzliche Diagnosen des Arztes.<br>
   * Die Angabe der wesentlichen Nebendiagnosen ist optional.<br/>
   * Format: maximal 500-stellig.
   * @param wesentlicheNebenDiagnosen Der zu setzende Wert f&uuml;r WesentlicheNebenDiagnosen.
   */
  public void setWesentlicheNebenDiagnosen(String wesentlicheNebenDiagnosen) {
    _wesentlicheNebenDiagnosen = wesentlicheNebenDiagnosen;
  }
  
}
