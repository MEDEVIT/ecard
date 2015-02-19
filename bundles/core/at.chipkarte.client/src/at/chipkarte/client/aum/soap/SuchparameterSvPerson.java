/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.aum.soap;
/**
 * Ermöglicht das Filtern der Meldungen, die von
 *  {@link IAumService#meldungenFuerSvPersonSuchen(String, String, SuchparameterSvPerson)} zurückgegeben werden.
 */
public class SuchparameterSvPerson {
  private String _svNummer;
  private String _erstellungAb;
  private String _erstellungBis;
  private String _meldungsart;

  /**
   * SV-Nummer des Patienten. 
   * <br>Format:  10-stellig
   * @return Suchkriterium SV-Nummer
   */
  public String getSvNummer() {
    return _svNummer;
  }
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Nur Meldungen, die vor  oder an diesem Datum ausgestellt wurden, 
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
}
