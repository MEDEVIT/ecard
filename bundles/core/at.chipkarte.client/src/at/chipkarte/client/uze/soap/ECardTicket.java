/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Signatur zur Sicherstellung der Echtheit der verwendeten e-card.
 */
public class ECardTicket {
  private byte[] _clientSignatur;
  private String _signaturFormatCode;
  private String _vpNummer;
  private String _svNummer;
  private String _zeitStempel;

  /**
   * Signatur der e-card &uuml;ber VpNummer + SvNummer + Zeitstempel, die am Client generiert wurde, 
   * inklusive Zertifikats ID zum Identifizieren des entsprechenden Zertifikates am e-card Serversystem.<br>
   * Format: maximal 1000-stellig.
   * @return ClientSignatur
   */
  public byte[] getClientSignatur() {
    return _clientSignatur;
  }

  /**
   * Codes des Signaturformats: "C".<br>
   * Format: 1-stellig.
   * @return SignaturFormatCode
   */
  public String getSignaturFormatCode() {
    return _signaturFormatCode;
  }

  /**
   * VpNummer des Vertragpartners.<br>
   * Format: maximal 6-stellig.
   * @return VpNummer
   */
  public String getVpNummer() {
    return _vpNummer;
  }

  /**
   * SvNummer des Patienten.<br>
   * Format: maximal 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Zeitpunkt, der f&uuml;r die Signatur verwendet wurde.<br>
   * Format TT.MM.JJJJ hh:mm:ss, maximal 19-stellig.
   * @return ZeitStempel
   */
  public String getZeitStempel() {
    return _zeitStempel;
  }

  /**
   * Signatur der e-card &uuml;ber VpNummer + SvNummer + Zeitstempel, die am Client generiert wurde, 
   * inklusive Zertifikats ID zum Identifizieren des entsprechenden Zertifikates am e-card Serversystem.<br>
   * Format: maximal 1000-stellig.
   * @param clientSignatur  The ClientSignatur to set.
   */
  public void setClientSignatur(byte[] clientSignatur) {
    _clientSignatur = clientSignatur;
  }

  /**
   * Codes des Signaturformats: "C".<br>
   * Format: maximal 1-stellig.
   * @param signaturFormatCode Der zu setzende Wert f&uuml;r ClientSignatur.
   */
  public void setSignaturFormatCode(String signaturFormatCode) {
    _signaturFormatCode = signaturFormatCode;
  }

  /**
   * VpNummer des Vertragpartners.<br>
   * Format: maximal 6-stellig.
   * @param vpNummer Der zu setzende Wert f&uuml;r SignaturFormatCode.
   */
  public void setVpNummer(String vpNummer) {
    _vpNummer = vpNummer;
  }

  /**
   * SvNummer des Patienten.<br>
   * Format: maximal 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r VpNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Zeitpunkt, der f&uuml;r die Signatur verwendet wurde.<br>
   * Format TT.MM.JJJJ hh:mm:ss, maximal 19-stellig.
   * @param zeitStempel Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setZeitStempel(String zeitStempel) {
    _zeitStempel = zeitStempel;
  }

}
