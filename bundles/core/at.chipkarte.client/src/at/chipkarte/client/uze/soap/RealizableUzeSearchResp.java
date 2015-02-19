/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Ausgangsdaten der Funktion "searchRealizableUze".
 */
public class RealizableUzeSearchResp {
  private ECardTicket _ecardTicket;
  private UZEWeisung[] _uze;

  /**
   * Enth&auml;lt die Signatur zur Sicherstellung der Echtheit der verwendeten e-card.<br>
   * Nur versorgt, wenn die Suche nach UZEs ohne UZE-Code durchgeführt wurde (mit e-card)
   * und ein Ergebnis vorliegt (d.h., dass mindestens eine UZE gefunden wurde).
   * @return EcardTicket
   */
  public ECardTicket getEcardTicket() {
    return _ecardTicket;
  }

  /**
   * Liste mit UZEWeisungen, die den gew&auml;hlten Selektionskriterien entsprechen.<br>
   * Wenn ECardTicket versorgt ist, ist das Attribut UZE-Code in den UZEWeisungen nicht versorgt.
   * @return Uze
   */
  public UZEWeisung[] getUze() {
    return _uze;
  }

  /**
   * Enth&auml;lt die Signatur zur Sicherstellung der Echtheit der verwendeten e-card.<br>
   * Nur versorgt, wenn die Suche nach UZEs ohne UZE-Code durchgeführt wurde (mit e-card)
   * und ein Ergebnis vorliegt (d.h., dass mindestens eine UZE gefunden wurde).
   * @param ecardTicket Der zu setzende Wert f&uuml;r EcardTicket.
   */
  public void setEcardTicket(ECardTicket ecardTicket) {
    _ecardTicket = ecardTicket;
  }

  /**
   * Liste mit UZEWeisungen, die den gew&auml;hlten Selektionskriterien entsprechen.<br>
   * Wenn ECardTicket versorgt ist, ist das Attribut UZE-Code in den UZEWeisungen nicht versorgt.
   * @param uze Der zu setzende Wert f&uuml;r Uze.
   */
  public void setUze(UZEWeisung[] uze) {
    _uze = uze;
  }

}
