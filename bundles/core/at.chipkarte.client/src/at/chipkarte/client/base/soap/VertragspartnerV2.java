/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Enthält Informationen zu einem Vertragspartner.
 */
// since the desired property order is not alphabetic, we have to define it manually 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vertragspartnerV2", propOrder = {
    "anredeCode",
    "authenticationStatus",
    "druckNachname",
    "druckVorname",
    "druckTitelHinten",
    "druckTitelVorne",
    "geburtsdatum",
    "nachname",
    "ordination",
    "titelHinten",
    "titelVorne",
    "vorname",
    "vpId",
    "vpNummer"
})
public class VertragspartnerV2 {

  @XmlTransient
  private String _anredeCode;
  @XmlTransient
  private AuthenticationStatus _authenticationStatus;
  @XmlTransient
  private String _druckNachname;
  @XmlTransient
  private String _druckVorname;
  @XmlTransient
  private String _druckTitelHinten;
  @XmlTransient
  private String _druckTitelVorne;
  @XmlTransient
  private String _geburtsdatum;
  @XmlTransient
  private String _nachname;
  @XmlTransient
  private Ordination[] _ordination;
  @XmlTransient
  private String _titelHinten;
  @XmlTransient
  private String _titelVorne;
  @XmlTransient
  private String _vorname;
  @XmlTransient
  private String _vpId;
  @XmlTransient
  private String _vpNummer;

  /**
   * Liste der Ordinationsadressen des Vertragspartners.
   * @return Liste der Ordinationen
   *  
   */
  @XmlElement(nillable = true)
  public Ordination[] getOrdination() {
    return _ordination;
  }

  /**
   * Status der Authentifizierung.
   * @return Status der Authentifizierung
   *  
   */
  @XmlElement
  public AuthenticationStatus getAuthenticationStatus() {
    return _authenticationStatus;
  }

  /**
   * Titel hinten des Vertragspartners im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 30-stellig
   * 
   * @return Titel hinten
   */
  @XmlElement
  public String getTitelHinten() {
    return _titelHinten;
  }

  /**
   * Geburtsdatum des Vertragspartners.
   * <br>Format: TT.MM.JJJJ
   * 
   * @return Geburtsdatum
   */
  @XmlElement
  public String getGeburtsdatum() {
    return _geburtsdatum;
  }

  /**
   * Vorname des Vertragspartners im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 70-stellig
   * 
   * @return Vorname
   */
  @XmlElement
  public String getVorname() {
    return _vorname;
  }

  /**
   * Titel vorne des Vertragspartners im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten..
   * <br>Format: maximal 30-stellig
   * 
   * @return Titel vorne
   */
  @XmlElement
  public String getTitelVorne() {
    return _titelVorne;
  }

  /**
   * Nachname des Vertragspartners im reduzierten Zeichensatzumfang von Latin-1 (ISO-8859-1). Alle anderen
   * Sonderzeichen sind nicht enthalten.
   * <br>Format: maximal 70-stellig
   * 
   * @return Nachname
   */
  @XmlElement
  public String getNachname() {
    return _nachname;
  }

  /**
   * Vorname des Vertragspartners im UTF-8 Zeichensatz.
   * <br>Format: maximal 70-stellig
   * 
   * @return Druckvorname
   */
  @XmlElement
  public String getDruckVorname() {
    return _druckVorname;
  }

  /**
   * Nachname des Vertragspartners im UTF-8 Zeichensatz.
   * <br>Format: maximal 70-stellig
   * 
   * @return Drucknachname
   */
  @XmlElement
  public String getDruckNachname() {
    return _druckNachname;
  }

  /**
   * Titel hinten des Vertragspartners im UTF-8 Zeichensatz.
   * <br>Format: maximal 30-stellig
   * 
   * @return Drucktitel hinten
   */
  @XmlElement
  public String getDruckTitelHinten() {
    return _druckTitelHinten;
  }

  /**
   * Titel vorne des Vertragspartners im UTF-8 Zeichensatz.
   * <br>Format: maximal 30-stellig
   * 
   * @return Drucktitel vorne
   */
  @XmlElement
  public String getDruckTitelVorne() {
    return _druckTitelVorne;
  }

  /**
   * Code für die Anrede des Vertragspartners.
   * <br>Mögliche Werte siehe
   * {@link at.chipkarte.client.base.soap.constants.Anrede Anrede}.
   * <br>Format: 1-stellig
   * 
   * @return Anredecode
   */
  @XmlElement
  public String getAnredeCode() {
    return _anredeCode;
  }

  /**
   * Nummer des Vertragspartners. 
   * Es handelt sich um die auf der o-card stehende Nummer, welche als Referenz und/oder zur Identifizierung des 
   * Vertragspartners in Funktionen der Schnittstelle dient.
   * <br>Format: 6-stellig
   * 
   * @return Vertragspartnernummer
   *  
   */
  @XmlElement
  public String getVpNummer() {
    return _vpNummer;
  }

  /**
   * Vertragspartner-Id. 
   * <br>Eine interne Id des Vertragspartners, welche aber NICHT als Referenz und/oder zur Identifizierung des 
   * Vertragspartners in Funktionen dieser Schnittstelle herangezogen wird.
   * <br>Format: maximal 19-stellig
   * 
   * @return Vertragspartner-Id
   */
  @XmlElement
  public String getVpId() {
    return _vpId;
  }

  public void setAnredeCode(String anredeCode) {
    this._anredeCode = anredeCode;
  }

  public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
    this._authenticationStatus = authenticationStatus;
  }

  public void setDruckNachname(String druckNachname) {
    this._druckNachname = druckNachname;
  }

  public void setDruckVorname(String druckVorname) {
    this._druckVorname = druckVorname;
  }

  public void setDruckTitelHinten(String druckTitelHinten) {
    _druckTitelHinten = druckTitelHinten;
  }

  public void setDruckTitelVorne(String druckTitelVorne) {
    _druckTitelVorne = druckTitelVorne;
  }

  public void setGeburtsdatum(String geburtsdatum) {
    this._geburtsdatum = geburtsdatum;
  }

  public void setNachname(String nachname) {
    this._nachname = nachname;
  }

  public void setOrdination(Ordination[] ordination) {
    this._ordination = ordination;
  }

  public void setTitelHinten(String titelHinten) {
    this._titelHinten = titelHinten;
  }

  public void setTitelVorne(String titelVorne) {
    this._titelVorne = titelVorne;
  }

  public void setVorname(String vorname) {
    this._vorname = vorname;
  }

  public void setVpId(String vpId) {
    this._vpId = vpId;
  }

  public void setVpNummer(String vpNummer) {
    this._vpNummer = vpNummer;
  }

}