/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap;

/**
 * Enthält GINA-Informationen und Verfügbarkeitsinformationen zu den auf der GINA
 * installierten Services.
 */
public class StatusInformationen {
  private GinaInfo _ginaInfo;
  private ServiceStatusInformation[] _serviceStatusInformation;
  
  private Boolean _wartungsfensterKennzeichen;
  private String _wartungsfensterVon;
  private String _wartungsfensterBis;
  private String _wartungsfensterText;
  private String _wartungsfensterHinweis;
  
  
  /**
   * Enthält Informationen zu GINA-Parametern.
   * @return GinaInfo.
   */
  public GinaInfo getGinaInfo() {
    return _ginaInfo;
  }
  public void setGinaInfo(GinaInfo ginaInfo) {
    _ginaInfo = ginaInfo;
  }
    
  /**
   * Liste der installierten Services inklusive Statusinformationen und Hinweisen.
   * @return Liste der installierten Services
   */
  public ServiceStatusInformation[] getServiceStatusInformation() {
    return _serviceStatusInformation;
  }
  public void setServiceStatusInformation(ServiceStatusInformation[] serviceStatusInformation) {
    _serviceStatusInformation = serviceStatusInformation;
  }
    
  /**
   * Ende des Wartungsfensters.
   * <br>Format: TT.MM.JJJJ hh:mm
   * <br>Dieses Attribut ist nur versorgt, wenn <i>WartungsfensterKennzeichen</i> gleich <i>true</i> ist.
   * @return Zeitstempel - Endes des Wartungsfensters
   */
  public String getWartungsfensterBis() {
    return _wartungsfensterBis;
  }
  public void setWartungsfensterBis(String wartungsfensterBis) {
    _wartungsfensterBis = wartungsfensterBis;
  }
  
  /**
   * Hinweis zum Wartungsfenster, wenn dieses aktiv ist.
   * <br>Format: maximal 64-stellig
   * @return Wartungsfenster-Hinweistext 
   */ 
  public String getWartungsfensterHinweis() {
    return _wartungsfensterHinweis;
  }
  public void setWartungsfensterHinweis(String wartungsfensterHinweis) {
    _wartungsfensterHinweis = wartungsfensterHinweis;
  }

  /**
   * Flag zur Kennzeichnung, ob aktuell ein Wartungsfenster aktiv ist.
   * @return Wartungsfensterkennzeichen
   */
  public Boolean isWartungsfensterKennzeichen() {
    return _wartungsfensterKennzeichen;
  }
  public void setWartungsfensterKennzeichen(Boolean wartungsfensterKennzeichen) {
    _wartungsfensterKennzeichen = wartungsfensterKennzeichen;
  }
  
  /**
   * Gesamtinformation zum Wartungsfenster (Text mit Zeitraumangabe).
   * <br>Format: maximal 64-stellig
   * @return Wartungsfenster-Information in Textform
   */  
  public String getWartungsfensterText() {
    return _wartungsfensterText;
  }
  public void setWartungsfensterText(String wartungsfensterText) {
    _wartungsfensterText = wartungsfensterText;
  }
 
  /**
   * Beginn des Wartungsfensters.
   * <br>Format: TT.MM.JJJJ hh:mm
   * <br>Dieses Attribut ist nur versorgt, wenn <i>WartungsfensterKennzeichen</i> gleich <i>true</i> ist.
   * @return Zeitstempel - Beginns des Wartungsfensters.
   */
  public String getWartungsfensterVon() {
    return _wartungsfensterVon;
  }
  public void setWartungsfensterVon(String wartungsfensterVon) {
    _wartungsfensterVon = wartungsfensterVon;
  }
}
