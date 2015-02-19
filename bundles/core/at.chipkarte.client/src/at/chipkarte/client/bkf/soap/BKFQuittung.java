package at.chipkarte.client.bkf.soap;

/**
 * <p>
 * Empfangsbestätigung der <i>create</i>-Funktionen.
 * </p>
 */
public class BKFQuittung {

  private String _dokumentationstyp;
  private String _vpNummer;
  private String _svNummer;
  private String _annahmezeitpunkt;
  private String _leistungsdatum;
  private String _versicherungstraeger;
  private Boolean _folgedokumentation;
  private byte[] _signatur;

  /**
   * Dokumentationstyp. <br>
   * Mögliche Werte siehe {@link at.chipkarte.client.bkf.soap.constants.DokumentationTypConstant}.<br>
   * Angabe: Muss. <br>
   * Format: 3-stellig 
   * @return DatenblattTyp.
   */
  public String getDokumentationstyp() {
    return _dokumentationstyp;
  }

  public void setDokumentationstyp(String dokumentationstyp) {
    _dokumentationstyp = dokumentationstyp;
  }

  /**
   * Vertragspartnernummer. <br>
   * Angabe: Muss. <br>
   * Format: 6-stellig 
   * @return VpNummer
   */
  public String getVpNummer() {
    return _vpNummer;
  }

  public void setVpNummer(String vpNummer) {
    _vpNummer = vpNummer;
  }

  /**
   * Sozialversicherungsnummer der Patientin. <br>
   * Angabe: Muss.<br> 
   * Format: 10-stellig 
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Datum der Annahme des Dokumentations-/Befundblattes am Server (Datum der Speicherung des Befundblattes am Server). <br>
   * Angabe: Muss.<br>
   * Format: TT.MM.JJJJ hh:mm:ss  
   * @return Annahmezeitpunkt
   */
  public String getAnnahmezeitpunkt() {
    return _annahmezeitpunkt;
  }

  public void setAnnahmezeitpunkt(String annahmezeitpunkt) {
    _annahmezeitpunkt = annahmezeitpunkt;
  }

  /**
   * Datum der Leistung. <br>
   * Angabe: Muss.<br> 
   * Format: TT.MM.JJJJ 
   * @return Leistungsdatum
   */
  public String getLeistungsdatum() {
    return _leistungsdatum;
  }

  public void setLeistungsdatum(String leistungsdatum) {
    _leistungsdatum = leistungsdatum;
  }

  /**
   * Code des Versicherungsträgers der Patientin. <br>
   * Angabe: Nur versorgt bei Dokumentationen mit Bindung an eine Konsultation mit einem Anspruch.<br>
   * Format: 2-stellig
   * @return Versicherungstraeger
   */
  public String getVersicherungstraeger() {
    return _versicherungstraeger;
  }

  public void setVersicherungstraeger(String versicherungstraeger) {
    _versicherungstraeger = versicherungstraeger;
  }

  /**
   * Kennzeichen ob eine Folge-/Korrekturdokumentation übermittelt wurde. <br>
   * Nur relevant für Screeningdokumentationen und kurative Mammographiedokumentationen.<br>
   * Angabe: Muss. 
   * @return Folgedokumentation
   */
  public Boolean isFolgedokumentation() {
    return _folgedokumentation;
  }

  public void setFolgedokumentation(Boolean folgedokumentation) {
    _folgedokumentation = folgedokumentation;
  }

  /**
   * Signatur der Empfangsbestätigung. <br>
   * Angabe: Muss. 
   * @return Signatur.
   */
  public byte[] getSignatur() {
    return _signatur;
  }

  public void setSignatur(byte[] signatur) {
    _signatur = signatur;
  }
}