/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die modifizierbare UZE und den Zeitpunkt bis zu dem sie modifiziert werden kann.
 */
public class ModifiableUze {
  private String _modifizierbarBis;
  private UZEWeisung _uze;

  /**
   * Gibt den sp&auml;test m&ouml;glichsten Zeitpunkt an, bis zu dem die UZE modifiziert werden kann.<br>
   * Format: TT.MM.JJJJ HH:MM, maximal 16-stellig.<br>
   * @return ModifizierbarBis
   */
  public String getModifizierbarBis() {
    return _modifizierbarBis;
  }

  /**
   * Modifizierbare UZE entsprechend den Selektionskriterien.<br>
   * @return uze die den Selektionskriterien entsprechende UZE.
   */
  public UZEWeisung getUze() {
    return _uze;
  }

  /**
   * Gibt den sp&auml;test m&ouml;glichsten Zeitpunkt an, bis zu dem die UZE modifiziert werden kann.<br>
   * Format: TT.MM.JJJJ HH:MM, maximal 16-stellig.<br>
   * @param modifizierbarBis Der zu setzende Wert f&uuml;r ModifizierbarBis.
   */
  public void setModifizierbarBis(String modifizierbarBis) {
    _modifizierbarBis = modifizierbarBis;
  }

  /**
   * Modifizierbare UZE entsprechend den Selektionskriterien.<br>
   * @param uze Der zu setzende Wert f&uuml;r uze.
   */
  public void setUze(UZEWeisung uze) {
    _uze = uze;
  }

}
