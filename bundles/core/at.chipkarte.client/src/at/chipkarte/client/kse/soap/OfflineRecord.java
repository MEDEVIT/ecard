/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.kse.soap;

/**
 * Enthält den Offlinedatensatz einer Konsultation oder Nachsignatur.
 */
public class OfflineRecord {

  private String _id;
  private String _svNummer = null;
  private String _vorname = null;
  private String _nachname = null;

  private Integer _type;
  private String _erstellungsDatum = null;
  private String _offlineFrist = null;
  private OfflineKonsultation _offlineKonsultation = null;


  /**
   * Nachname des Patienten.
   * <br/>Format: maximal 70-stellig
   * @return Nachname
   */
  public String getNachname() {
    return _nachname;
  }

  public void setNachname(String nachname) {
    _nachname = nachname;
  }

  /**
   * Vorname des Patienten.
   * <br/>Format: maximal 70-stellig
   * @return Vorname
   */
  public String getVorname() {
    return _vorname;
  }

  public void setVorname(String vorname) {
    _vorname = vorname;
  }

  /**
   * Erfassungsdatum der Offlinekonsultation beziehungsweise der Nachsignierungsanfrage. 
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Erstellungsdatum
   */
  public String getErstellungsDatum() {
    return _erstellungsDatum;
  }

  public void setErstellungsDatum(String erstellungsDatum) {
    _erstellungsDatum = erstellungsDatum;
  }

  /**
   * Eindeutige ID (GINA bezogen) der offline erfassten Konsultation beziehungsweise Nachsignierungsanfrage. <br/>
   * Format: maximal 36-stellig
   * @return ID
   */
  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  /**
   * Datum, an dem die Offlinekonsultation beziehungsweise die Nachsignierungsanfrage spätestens an das e-card-Serversystem
   * übertragen werden muss. 
   * <br/>Format: TT.MM.JJJJ, 10-stellig
   * @return Offlinefrist
   */
  public String getOfflineFrist() {
    return _offlineFrist;
  }

  public void setOfflineFrist(String offlineFrist) {
    _offlineFrist = offlineFrist;
  }

  /**
   * Offlinekonsultationen, wenn der Typ des Offlinedatensatzes
   * {@link at.chipkarte.client.kse.soap.constants.OfflineRecordType#KONSULTATION KONSULTATION} ist, sonst null.
   * @return Offlinekonsultation
   */
  public OfflineKonsultation getOfflineKonsultation() {
    return _offlineKonsultation;
  }

  public void setOfflineKonsultation(OfflineKonsultation offlineKonsultation) {
    _offlineKonsultation = offlineKonsultation;
  }

  /**
   * Sozialversicherungsnummer des Patienten für den offline erfassten Datensatz.
   * <br/>Format: 10-stellig
   * @return Sozialversicherungsnummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Typ des Offlinedatensatzes.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.OfflineRecordType OfflineRecordType}
   * @return Typ
   */
  public Integer getType() {
    return _type;
  }

  public void setType(Integer type) {
    _type = type;
  }
}
