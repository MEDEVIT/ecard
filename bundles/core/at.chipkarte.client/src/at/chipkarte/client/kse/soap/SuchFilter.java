/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die Daten zur Einschränkung der Datensätze im Zuge von {@link IKseService#getKonsultationsdaten getKonsultationsdaten} oder 
 * {@link IKseService#sendKonsultationsdatenAnfrage sendKonsultationsdatenAnfrage}.
 * Es werden nur jene Konsultationen gesucht, die den angegebenen Kriterien entsprechen.
 */

public class SuchFilter {

  private String _datumVon;
  private String _datumBis;
  private String _sVNummer;
  private String _ordId;
  private String _svtCode;
  private String _fachgebietsCode;
  private String _behandlungsfallCode;
  private String _konsultationsartCode;

  /**
   * Behandlungsfallcode der Konsultation.
   * <br/>Format: 2-stellig
   * @return Behandlungsfallcode
   */
  public String getBehandlungsfallCode() {
    return _behandlungsfallCode;
  }

  /**
   * Datum der Durchführung, bis zu dem Konsultationen gesucht werden. 
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Datum Bis
   */
  public String getDatumBis() {
    return _datumBis;
  }

  /**
   * Datum der Durchführung, ab dem Konsultationen gesucht werden. 
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Datum Von
   */
  public String getDatumVon() {
    return _datumVon;
  }

  /**
   * Fachgebietscode, zu dem Konsultationen gesucht werden. 
   * <br/>Format: 2-stellig
   * @return Fachgebietscode
   */
  public String getFachgebietsCode() {
    return _fachgebietsCode;
  }

  /**
   * Code der Konsultationsart, zu dem Konsultationen gesucht werden. 
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.Konsultationsart Konsultationsarten}. 
   * <br/>Zudem sind auch "logische" Konsultationsarten möglich, siehe
   * {@link at.chipkarte.client.kse.soap.constants.LogKonsArt "Logische Konsultationsarten"} 
   * <br/>Format: maximal 10-stellig
   * @return Code der Konsultationsart
   */
  public String getKonsultationsartCode() {
    return _konsultationsartCode;
  }

  /**
   * Code des Krankenversicherungsträgers, zu dem Konsultationen gesucht werden. 
   * <br/>Format: 2-stellig
   * @return KVT-Code
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * Ordinations-ID, zu der Konsultationen gesucht werden. Der Wert muss für die ordinationsübergreifende Suche null sein. 
   * <br/>Format: maximal 19-stellig
   * @return Ordinations-ID
   */
  public String getOrdId() {
    return _ordId;
  }

  /**
   * Sozialversicherungsnummer, zu der Konsultationen gesucht werden. 
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer
   */
  public String getSVNummer() {
    return _sVNummer;
  }

  public void setBehandlungsfallCode(String behandlungsfallCode) {
    this._behandlungsfallCode = behandlungsfallCode;
  }

  public void setDatumBis(String datumBis) {
    this._datumBis = datumBis;
  }

  public void setDatumVon(String datumVon) {
    this._datumVon = datumVon;
  }

  public void setFachgebietsCode(String fachgebietsCode) {
    this._fachgebietsCode = fachgebietsCode;
  }

  public void setKonsultationsartCode(String konsultationsart) {
    this._konsultationsartCode = konsultationsart;
  }

  public void setOrdId(String ordId) {
    this._ordId = ordId;
  }

  public void setSVNummer(String svnr) {
    _sVNummer = svnr;
  }

  public void setSvtCode(String svtCode) {
    this._svtCode = svtCode;
  }
}
