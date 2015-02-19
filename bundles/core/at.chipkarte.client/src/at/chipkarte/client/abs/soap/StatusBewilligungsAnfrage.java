/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap;

/**
 * <p>
 * Enthält die Daten zum Status einer Bewilligungsanfrage.
 * </p>
 * Eine Bewilligungsanfrage kann sich in einem der folgenden Status befinden:
 * <ul>
 * <li><b>&Uuml;bertragen:</b> Die Bewilligungsanfrage wurde erfolgreich an den chef- und kontrollärztlichen 
 * Dienst übermittelt.</li>
 * <li><b>Beantwortet:</b> Es liegt eine noch nicht abgerufene Rückantwort des chef- und kontrollärztlichen Dienstes zur gestellten
 * Bewilligungsanfrage vor.</li>
 * <li><b>Gelesen:</b> Die Rückantwort zur Bewilligungsanfrage wurde bereits abgerufen.</li>
 * </ul>
 * <p>
 * Der aktuelle Status kann wie folgt aus den in dieser Klasse definierten Zeitpunkten abgeleitet werden:
 * </p>
 * <table border="1">
 * <tr align="center">
 * <th>Status</th>
 * <th>Einlangenzeitpunkt</th>
 * <th>Beantwortungszeitpunkt</th>
 * <th>Abfragezeitpunkt</th>
 * </tr>
 * <tr align="center">
 * <td>&Uuml;bertragen</td>
 * <td>gesetzt</td>
 * <td><code>null</code></td>
 * <td><code>null</code></td>
 * </tr>
 * <tr align="center">
 * <td>Beantwortet</td>
 * <td>gesetzt</td>
 * <td>gesetzt</td>
 * <td><code>null</code></td>
 * </tr>
 * <tr align="center">
 * <td>Gelesen</td>
 * <td>gesetzt</td>
 * <td>gesetzt</td>
 * <td>gesetzt</td>
 * </tr>
 * </table>
 * <br>
 * <p>
 * Bewilligungsanfragen stehen nur innerhalb eines im ABS konfigurierten Zeitraums zur Statusabfrage zur Verfügung. Derzeit ist für
 * Bewilligungsanfragen im Zustand gelesen ein Zeitraum von mindestens 14 Tagen und Bewilligungsanfragen im Zustand übertragen
 * oder beantwortet ein Zeitraum von mindestens 6 Monaten vorgesehen.
 * </p>
 */
public class StatusBewilligungsAnfrage {
  private String _anfrageId;
  private String _einlangeZeitpunkt;
  private String _beantwortungsZeitpunkt;
  private String _abfrageZeitpunkt;
  private String _sVNRPatient;
  private String _eKVKNummer;
  private String _nachnamePatient;
  private String _vornamePatient;

  /**
   * Zeitpunkt der ersten Abfrage der Rückantwort. Wird eine Rückantwort mehrmals abgefragt, ändert sich dieser Zeitpunkt nicht. 
   * <br/>Format: TT.MM.JJJJ hh:mm
   * @return Abfragezeitpunkt
   */
  public String getAbfrageZeitpunkt() {
    return _abfrageZeitpunkt;
  }

  /**
   * Eindeutige ID der Bewilligungsanfrage. 
   * <br/>Format: maximal 38-stellig
   * @return AnfrageId
   */
  public String getAnfrageId() {
    return _anfrageId;
  }

  /**
   * Zeitpunkt des Einlangens der Bewilligungsanfrage im ABS. 
   * <br/>Format: TT.MM.JJJJ hh:mm
   * @return Einlangezeitpunkt
   */
  public String getEinlangeZeitpunkt() {
    return _einlangeZeitpunkt;
  }

  /**
   * Zeitpunkt des Bereitstellens der Rückantwort zu dieser Anfrage durch das ABS. 
   * <br/>Format: TT.MM.JJJJ hh:mm
   * @return Beantwortungszeitpunkt
   */
  public String getBeantwortungsZeitpunkt() {
    return _beantwortungsZeitpunkt;
  }

  /**
   * Sozialversicherungsnummer des Patienten für den die Bewilligungsanfrage gestellt wurde, sofern die Person in Österreich
   * versichert ist. Andernfalls liefert diese Methode <code>null</code> zurück und die {@link #getEKVKNummer() EKVKNummer}&nbsp;
   * ist gesetzt. 
   * <br/>Format: 10-stellig, numerisch 
   * <br/>Die Sozialversicherungsnummer entspricht den Regeln für Sozialversicherungsnummern (Prüfziffer).
   * @return SVNR des Patienten
   */
  public String getSVNRPatient() {
    return _sVNRPatient;
  }

  /**
   * Nachname des Patienten, für den die Bewilligungsanfrage gestellt wurde. 
   * <br/>Format: maximal 70-stellig
   * @return Nachname des Patienten
   */
  public String getNachnamePatient() {
    return _nachnamePatient;
  }

  /**
   * Vorname des Patienten, für den die Bewilligungsanfrage gestellt wurde. 
   * <br/>Format: maximal 70-stellig
   * @return Vorname des Patienten
   */
  public String getVornamePatient() {
    return _vornamePatient;
  }

  /**
   * Die EKVK-Nummer des Patienten der europäischen Krankenversicherungskarte (EKVK), sofern der Patient im
   * EU-Ausland versichert ist. 
   * <br/>Format: maximal 20-stellig
   * @return EKVK-Nummer
   */
  public String getEKVKNummer() {
    return _eKVKNummer;
  }

  public void setAbfrageZeitpunkt(String abfrageZeitpunkt) {
    _abfrageZeitpunkt = abfrageZeitpunkt;
  }

  public void setAnfrageId(String anfrageId) {
    _anfrageId = anfrageId;
  }

  public void setEinlangeZeitpunkt(String einlangeZeitpunkt) {
    _einlangeZeitpunkt = einlangeZeitpunkt;
  }

  public void setBeantwortungsZeitpunkt(String beantwortungsZeitpunkt) {
    _beantwortungsZeitpunkt = beantwortungsZeitpunkt;
  }

  public void setSVNRPatient(String patient) {
    _sVNRPatient = patient;
  }

  public void setNachnamePatient(String nachnamePatient) {
    _nachnamePatient = nachnamePatient;
  }

  public void setVornamePatient(String vornamePatient) {
    _vornamePatient = vornamePatient;
  }

  public void setEKVKNummer(String nummer) {
    _eKVKNummer = nummer;
  }
}