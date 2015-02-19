/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten einer Rückantwort des chefärztlichen Dienstes zu einer {@link BewilligungsAnfrage}.
 * </p>
 * <p>
 * Die Daten können unter Umständen von den Daten in der Anfrage abweichen, falls sie durch den chefärztlichen
 * Dienst korrigiert wurden.
 * </p>
 * <p>
 * <b>Achtung: </b> Die Felder der Rückantwort werden teilweise manuell durch die Bearbeiter im chefärztlichen Dienst befüllt. Daher
 * kann hier nicht gewährleistet werden, dass alle formalen Kriterien genau wie im Antrag erfüllt werden. Beispielsweise könnte das
 * Feld SVNR des Patienten einen Wert enthalten, der nicht der Formalprüfung für SV-Nummern entspricht. Die hier angegebenen
 * Formalkriterien (z.B. maximale Feldlängen) werden jedoch auf jeden Fall eingehalten.<br>
 * Diese Einschränkung gilt auch für die Daten der Anfrageentscheide.
 * </p>
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */
public class Rueckantwort {
  private String _anfrageId;
  private String _referenzId;
  private String _einlangeZeitpunkt;
  private String _beantwortungsZeitpunkt;
  private String _abfrageZeitpunkt;
  private String _infoText;
  private String _sVNRPatient;
  private String _eKVKPatient;
  private String _nachnamePatient;
  private String _vornamePatient;
  private AnfrageEntscheid[] _anfrageEntscheide;
  private BewilligungsAnfrage _bewilligungsAnfrage;
  private String _antragstyp;

  /**
   * Eindeutige ID der Bewilligungsanfrage. 
   * <br/>Siehe {@link AnfrageAntwort#getId() Id}. 
   * Diese ID dient zur Identifizierung einer Anfrage im ABS.
   * <br/>Format: maximal 38-stellig
   * @return ID der Anfrage
   */
  public String getAnfrageId() {
    return _anfrageId;
  }

  /**
   * Eindeutige ID für die Anfrage beziehungsweise Antwort am Backend-System, das die Bewilligungsanfrage verarbeitet. 
   * <br/>Diese Nummer dient zur
   * Identifizierung einer Anfrage beziehungsweise Antwort am Backend-System. 
   * <br/>Format: maximal 38-stellig
   * @return Referenz-ID am Backend
   */
  public String getReferenzId() {
    return _referenzId;
  }

  /**
   * Zeitpunkt des Einlangens der Anfrage im ABS. 
   * <br/>Format: TT.MM.JJJJ hh:mm
   * @return Einlangenzeitpunkt
   */
  public String getEinlangeZeitpunkt() {
    return _einlangeZeitpunkt;
  }

  /**
   * Zeitpunkt des Bereitstellens der Rückantwort zu der Anfrage durch den chefärztlichen Dienst. 
   * <br/>Format: TT.MM.JJJJ hh:mm
   * @return Beantwortungszeitpunkt
   */
  public String getBeantwortungsZeitpunkt() {
    return _beantwortungsZeitpunkt;
  }

  /**
   * Zeitpunkt der ersten Abfrage der Rückantwort. 
   * <br/>Wird eine Rückantwort mehrmals abgefragt, ändert sich dieser Zeitpunkt nicht.
   * <br/>Format: TT.MM.JJJJ hh:mm
   * @return Abfragezeitpunkt
   */
  public String getAbfrageZeitpunkt() {
    return _abfrageZeitpunkt;
  }

  /**
   * Informationstext des chefärztlichen Dienstes bezüglich der gesamten Anfrage (zum Beispiel: Begründung der Ablehnung eines
   * Antrages). 
   * <br/>Optional
   * <br/>Format: maximal 800-stellig
   * @return Informationstext des chefärztlichen Dienstes
   */
  public String getInfoText() {
    return _infoText;
  }

  /**
   * Sozialversicherungsnummer des Patienten für den die Bewilligungsanfrage gestellt wird. 
   * <br/>Optional
   * <br/>Format: 10-stellig 
   * @return SVNR des Patienten
   */
  public String getSVNRPatient() {
    return _sVNRPatient;
  }

  /**
   * EKVK-Nummer für eine im EU-Ausland versicherte Person der europäischen 
   * Krankenversicherungskarte (EKVK). 
   * <br/>Optional
   * <br/>Format: maximal 20-stellig
   * @return EKVK-Nummer des Patienten
   */
  public String getEKVKPatient() {
    return _eKVKPatient;
  }

  /**
   * Nachname des Patienten, für den die Bewilligungsanfrage gestellt wird. 
   * <br/>Optional
   * <br/>Format: maximal 70-stellig
   * @return Nachname des Patienten
   */
  public String getNachnamePatient() {
    return _nachnamePatient;
  }

  /**
   * Vorname des Patienten, für den die Bewilligungsanfrage gestellt wird. 
   * <br/>Optional
   * <br/>Format: maximal 70-stellig
   * @return Vorname des Patienten
   */
  public String getVornamePatient() {
    return _vornamePatient;
  }

  /**
   * Die Entscheidungsdaten zu den einzelnen Verordnungen der Bewilligungsanfrage. 
   * <br/>Die Reihenfolge der Anfrageentscheide muss nicht
   * der Reihenfolge der Verordnungen in der Anfrage entsprechen.
   * @return Objekt vom Typ AnfrageEntscheid[] - Array von maximal 10 Anfrageentscheiden.
   */
  public AnfrageEntscheid[] getAnfrageEntscheide() {
    return _anfrageEntscheide;
  }

  /**
   * Die Bewilligungsanfrage zu dieser Rückantwort. 
   * <br/>Die Reihenfolge der Verordnungen in der Bewilligungsanfrage muss nicht der
   * Reihenfolge der Anfrageentscheide in der Rückantwort entsprechen.
   * @return Objekt vom Typ BewilligungsAnfrage - Die Bewilligungsanfrage zu dieser Rückantwort.
   */
  public BewilligungsAnfrage getBewilligungsAnfrage() {
    return _bewilligungsAnfrage;
  }

  /**
   * Die Kennzeichnung der Bewilligungsanfrage (Bewilligungsanfrage im Rahmen einer Rezeptausstellung beziehungsweise einer Arztbrieferstellung). 
   * <br/>Wertebereich: siehe {@link at.chipkarte.client.abs.soap.constants.Antragstyp Antragstyp}).
   * @return Antragstyp
   */
  public String getAntragstyp() {
    return _antragstyp;
  }

  public void setAnfrageId(String anfrageId) {
    _anfrageId = anfrageId;
  }

  public void setEinlangeZeitpunkt(String einlangeZeitpunkt) {
    _einlangeZeitpunkt = einlangeZeitpunkt;
  }

  public void setBeantwortungsZeitpunkt(String beantwortungsZeitpunkt) {
    _beantwortungsZeitpunkt = beantwortungsZeitpunkt;
  }

  public void setAbfrageZeitpunkt(String abfrageZeitpunkt) {
    _abfrageZeitpunkt = abfrageZeitpunkt;
  }

  public void setInfoText(String infoText) {
    _infoText = infoText;
  }

  public void setSVNRPatient(String patient) {
    _sVNRPatient = patient;
  }

  public void setEKVKPatient(String patient) {
    _eKVKPatient = patient;
  }

  public void setNachnamePatient(String nachnamePatient) {
    _nachnamePatient = nachnamePatient;
  }

  public void setVornamePatient(String vornamePatient) {
    _vornamePatient = vornamePatient;
  }

  public void setAnfrageEntscheide(AnfrageEntscheid[] anfrageEntscheide) {
    _anfrageEntscheide = anfrageEntscheide;
  }

  public void setBewilligungsAnfrage(BewilligungsAnfrage bewilligungsAnfrage) {
    _bewilligungsAnfrage = bewilligungsAnfrage;
  }

  public void setReferenzId(String referenzId) {
    _referenzId = referenzId;
  }

  public void setAntragstyp(String antragstyp) {
    _antragstyp = antragstyp;
  }
}