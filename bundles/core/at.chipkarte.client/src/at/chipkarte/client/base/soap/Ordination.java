/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Enthält Daten zur Ordinationsadresse.
 * 
 * @ecardOk rule=MemberNameCheck underlining the members in combination with explicit order would require additional annotations
 */
//since the desired property order is not alphabetic, we have to define it manually
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordination", propOrder = {
    "bezirk",
    "bundeslandCode",
    "landCode",
    "ordinationId",
    "ordinationNumber",
    "postleitzahl",
    "stadt",
    "strasse",
    "uebersiedeln",
    "uebersiedelnDate",
    "vorgaengerOrdinationId",
    "taetigkeitsBereich"
})
public class Ordination {

  private String stadt = "";
  private String landCode = "";
  private String bezirk = "";
  private String ordinationId = "";
  private Long ordinationNumber = 0L;
  private String bundeslandCode = "";
  private String strasse = "";
  private String postleitzahl = "";
  private Boolean uebersiedeln = false;
  private String uebersiedelnDate = null;
  private String vorgaengerOrdinationId = "";
  private TaetigkeitsBereich[] taetigkeitsBereich;

  public void setBundeslandCode(String bundesland) {
    this.bundeslandCode = bundesland;
  }

  public void setLandCode(String landCode) {
    this.landCode = landCode;
  }

  public void setOrdinationId(String ordinationId) {
    this.ordinationId = ordinationId;
  }

  public void setOrdinationNumber(Long ordinationNumber) {
    this.ordinationNumber = ordinationNumber;
  }

  public void setPostleitzahl(String postleitzahl) {
    this.postleitzahl = postleitzahl;
  }

  public void setStadt(String stadt) {
    this.stadt = stadt;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  /**
   * Stadt/Ort, in der sich die Ordination befindet.
   * <br>Format: maximal 40-stellig
   * @return Stadt
   */
  public String getStadt() {
    return stadt;
  }

  /**
   * ISO-3166-3 Code des Landes, in dem sich die Ordination befindet.
   * <br>Format: 3-stellig
   * @return Landescode
   */
  public String getLandCode() {
    return landCode;
  }

  /**
   * Bezirkscode, in dem sich die Ordination befindet. 
   * <br>Format: 2-stellig
   * @return Bezirk
   */
  public String getBezirk() {
    return bezirk;
  }

  /**
   * Identifizierer der Ordination (dient als Referenz dieser Ordinationsadresse in anderen Funktionen).
   * <br>Format: maximal 19-stellig
   * @return Ordinations-Id
   */
  public String getOrdinationId() {
    return ordinationId;
  }

  /**
   * Eindeutige Nummer der Ordination bezogen auf den Vertragspartner.
   * <br>Format: 2-stellig
   * @return Ordinationsnummer
   */
  public Long getOrdinationNumber() {
    return ordinationNumber;
  }

  /**
   * Code des Bundeslandes, in dem sich die Ordination befindet.
   * <br>Mögliche Werte: siehe {@link at.chipkarte.client.base.soap.constants.Bundesland Bundesländer}.
   * <br>Format: 1-stellig
   * @return Code des Bundeslandes
   */
  public String getBundeslandCode() {
    return bundeslandCode;
  }

  /**
   * Straße, in der sich die Ordination befindet.
   * <br>Format: maximal 60-stellig
   * @return Straße
   */
  public String getStrasse() {
    return strasse;
  }

  /**
   * Postleitzahl des Ortes, in dem sich die Ordination befindet.
   * <br>Format: maximal 9-stellig
   * @return Postleitzahl
   */
  public String getPostleitzahl() {
    return postleitzahl;
  }

  public void setBezirk(String bezirk) {
    this.bezirk = bezirk;
  }

  /**
   * Flag zur Kennzeichnung, ob es sich um eine alte Ordinationsadresse handelt, die zu übersiedeln ist.
   * @return Übersiedlungskennzeichen
   */
  public Boolean isUebersiedeln() {
    return uebersiedeln;
  }

  public void setUebersiedeln(Boolean uebersiedeln) {
    this.uebersiedeln = uebersiedeln;
  }

  /**
   * Id der Vorgängerordination (die "alte" Ordinationsadresse), von der zur aktuellen Adresse übersiedelt wird/wurde.
   * <br>Format: maximal 19-stellig
   * @return Ordinations-Id der Vorgängerordination
   */
  public String getVorgaengerOrdinationId() {
    return vorgaengerOrdinationId;
  }

  public void setVorgaengerOrdinationId(String vorgaengerOrdinationId) {
    this.vorgaengerOrdinationId = vorgaengerOrdinationId;
  }

  /**
   * Datum, wann die Adresse - serverseitig - geschlossen wird. 
   * <br>Die Adresse muss bis zu diesem Datum übersiedelt werden. Dieses
   * Datum wird dann geliefert, wenn sich der Vertragspartner bereits einmal an der neuen Ordinationsadresse angemeldet hat.
   * <br>Format: TT.MM.JJJJ
   * @return Datum der Übersiedlungsfrist
   */
  public String getUebersiedelnDate() {
    return uebersiedelnDate;
  }

  public void setUebersiedelnDate(String uebersiedelnDate) {
    this.uebersiedelnDate = uebersiedelnDate;
  }

  /**
   * Tätigkeitsbereiche an dieser Ordination.
   * @return Tätigkeitsbereiche
   */
  public TaetigkeitsBereich[] getTaetigkeitsBereich() {
    return taetigkeitsBereich;
  }

  public void setTaetigkeitsBereich(TaetigkeitsBereich[] taetigkeitsBereich) {
    this.taetigkeitsBereich = taetigkeitsBereich;
  }
}
