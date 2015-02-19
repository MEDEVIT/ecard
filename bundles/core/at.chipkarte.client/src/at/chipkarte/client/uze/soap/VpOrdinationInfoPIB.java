/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Ordinationsdaten, die beim Erstellen/Drucken des PatientenInformationsblattes verwendet werden.
 */
public class VpOrdinationInfoPIB {
  
  private String _adresse;
  private String _ordinationsZeiten;
  private String _vornameVp;
  private String _zunameVp;

  /**
   * Adresse der Ordination bestehend aus PLZ, Ort, Straße, Nummer etc.<br>
   * Die Angabe der Adresse ist optional.<br/>
   * Format: maximal 120-stellig.
   * @return Adresse
   */
  public String getAdresse() {
    return _adresse;
  }

  /**
   * Ordinationszeiten.<br>
   * Die Angabe der Ordinationszeiten ist optional.<br/>
   * Format: maximal 200-stellig.
   * @return OrdinationsZeiten
   */
  public String getOrdinationsZeiten() {
    return _ordinationsZeiten;
  }

  /**
   * Vorname des Vertragspartners inklusive Titel vorne oder die Organisationsbezeichnung.<br>
   * Die Angabe von VornameVP ist optional.<br/>
   * Format: maximal 100-stellig.
   * @return VornameVp
   */
  public String getVornameVp() {
    return _vornameVp;
  }

  /**
   * Nachname des Vertragspartners inklusive Titel hinten 
   * bzw. Name des Labors oder des Institutes oder die Organisationsbezeichnung.<br>
   * Die Angabe von ZunameVp ist optional.<br/>
   * Format: maximal 100-stellig.
   * @return ZunameVp
   */
  public String getZunameVp() {
    return _zunameVp;
  }

  /**
   * Adresse der Ordination bestehend aus PLZ, Ort, Straße, Nummer etc.<br>
   * Die Angabe der Adresse ist optional.<br/>
   * Format: maximal 120-stellig.
   * @param adresse Der zu setzende Wert f&uuml;r Adresse.
   */
  public void setAdresse(String adresse) {
    _adresse = adresse;
  }

  /**
   * Ordinationszeiten.<br>
   * Die Angabe der Ordinationszeiten ist optional.<br/>
   * Format: maximal 200-stellig.
   * @param ordinationsZeiten Der zu setzende Wert f&uuml;r OrdinationsZeiten.
   */
  public void setOrdinationsZeiten(String ordinationsZeiten) {
    _ordinationsZeiten = ordinationsZeiten;
  }

  /**
   * Vorname des Vertragspartners inklusive Titel vorne oder die Organisationsbezeichnung.<br>
   * Die Angabe von VornameVp ist optional.<br/>
   * Format: maximal 100-stellig.
   * @param vornameVp Der zu setzende Wert f&uuml;r VornameVp.
   */
  public void setVornameVp(String vornameVp) {
    _vornameVp = vornameVp;
  }

  /**
   * Nachname des Vertragspartners inklusive Titel hinten 
   * bzw. Name des Labors oder des Institutes oder die Organisationsbezeichnung.<br>
   * Die Angabe von ZunameVp ist optional.<br/>
   * Format: maximal 100-stellig.
   * @param zunameVp Der zu setzende Wert f&uuml;r ZunameVp.
   */
  public void setZunameVp(String zunameVp) {
    _zunameVp = zunameVp;
  }

}
