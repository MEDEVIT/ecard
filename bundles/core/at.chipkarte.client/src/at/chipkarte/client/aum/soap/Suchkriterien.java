/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.aum.soap;
/**
 * Ermöglicht das Filtern der Meldungen, die von
 *  {@link IAumService#selbstErstellteMeldungenSuchen(String, Suchkriterien)} zurückgegeben werden.
 */
public class Suchkriterien {
  private String _meldungsart;
  private String _svNummer;
  private String _vorname;
  private String _zuname;
  private String _erstellungAb;
  private String _erstellungBis;

  /**
   * Nur Meldungen, die vor oder an diesem Datum ausgestellt wurden, 
   * werden zurückgegeben (optional).  
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Zeitraum bis zu dem gesucht werden soll
   */
  public String getErstellungBis() {
    return _erstellungBis;
  }
  public void setErstellungBis(String erstellungBis) {
    _erstellungBis = erstellungBis;
  }
  /**
   * Nur Meldungen, die nach oder an diesem Datum ausgestellt wurden, 
   * werden zurückgegeben (optional). 
   * <br>Format: 10-stellig, TT.MM.JJJJ
   * @return Zeitraum ab dem gesucht werden soll
   */
  public String getErstellungAb() {
    return _erstellungAb;
  }
  public void setErstellungAb(String erstellungAb) {
    _erstellungAb = erstellungAb;
  }
  /**
   * Meldungsart nach der gesucht wird. 
   * <br>Format: 2-stellig 
   * <br>Mögliche Werte: {@link at.chipkarte.client.aum.soap.constants.SuchMeldungsart}.
   * @return Suchkriterium Meldungsart
   */
  public String getMeldungsart() {
    return _meldungsart;
  }
  public void setMeldungsart(String meldungsart) {
    _meldungsart = meldungsart;
  }
  /**
   * Nur Meldungen von Patienten mit dem angegebenen Zunamen
   * werden zurückgegeben (optional). 
   * <br>Format: maximal 70-stellig
   * @return Suchkriterium Zuname
   */
  public String getZuname() {
    return _zuname;
  }
  public void setZuname(String zuname) {
    _zuname = zuname;
  }
  /**
   * Nur Meldungen von Patienten mit dem angegebenen Vornamen
   * werden zurückgegeben (optional).
   * <br>Format: maximal 70-stellig
   * @return Suchkriterium Vorname
   */
  public String getVorname() {
    return _vorname;
  }
  public void setVorname(String vorname) {
    _vorname = vorname;
  }
  /**
   * Nur Meldungen für den Patienten mit dieser SV-Nummer werden zurückgegeben. 
   * <br>Format: 10-stellig
    * @return Suchkriterium SV-Nummer
   */
  public String getSvNummer() {
    return _svNummer;
  }
  public void setSvNummer(String vsnr) {
    _svNummer = vsnr;
  }
  
}
