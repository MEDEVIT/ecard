/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Ausgangsdaten der Funktion searchModifiableUzeLa bzw. der Funktion searchModifiableUzeLe.
 * Je nachdem, f&uuml;r welche der beiden Funktionen die Response generiert wird, entsprechen die angegebenen, modifizierbaren UZE denen
 * f&uuml;r den Leistungsanforderer bzw. f&uuml;r den Leistungserbringer.
 */
public class ModifiableUzeSearchResp {
  private ModifiableUze[] _modifizierbareUze;
  private String _serverZeitstempel;

  /**
   * Liste mit modifizierbaren UZEWeisungen.<br>
   * @return ModifizierbareUze
   */
  public ModifiableUze[] getModifizierbareUze() {
    return _modifizierbareUze;
  }

  /**
   * Zeitpunkt der Abfrage.<br>
   * Immer versorgt, auch wenn keine den Suchkriterien entsprechende UZE gefunden wird. 
   * Dient zur Zeitsynchronisation mit dem Server.<br>
   * Format: TT.MM.JJJJ hh:mm:ss:ccc<br>
   * @return ServerZeitstempel
   */
  public String getServerZeitstempel() {
    return _serverZeitstempel;
  }

  /**
   * Liste mit modifizierbaren UZEWeisungen.<br>
   * @param modifizierbareUze Der zu setzende Wert f&uuml;r ModifizierbareUze.
   */
  public void setModifizierbareUze(ModifiableUze[] modifizierbareUze) {
    _modifizierbareUze = modifizierbareUze;
  }

  /**
   * Zeitpunkt der Abfrage.<br>
   * Immer versorgt, auch wenn keine den Suchkriterien entsprechende UZE gefunden wird. 
   * Dient zur Zeitsynchronisation mit dem Server.<br>
   * Format: TT.MM.JJJJ hh:mm:ss:ccc<br>
   * @param serverZeitstempel Der zu setzende Wert f&uuml;r ServerZeitstempel.
   */
  public void setServerZeitstempel(String serverZeitstempel) {
    _serverZeitstempel = serverZeitstempel;
  }

}
