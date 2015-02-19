/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält Meldungen zu einem Patienten. Abbhängig von der Selektionsart wird wahlweise das Feld <code>freieMeldung</code> oder
 * <code>strukturierteMeldung</code> versorgt.
 * </p>
 */
public class Textmeldung {

  private String _dmpCode;
  private String _erzeugungsZeitstempel;
  private String _freieMeldung;
  private String _strukturierteMeldung;

  /**
   * Code des Disease Management Programms, für das die Textmeldung erstellt wurde.<br>
   * Mögliche Werte siehe Funktion {@link at.chipkarte.client.dmp.soap.IDmpService#getDMPs() getDMPs()}.<br>
   * Format: maximal 2-stellig.
   * @return Code des Disease Management Programms
   */
  public String getDmpCode() {
    return _dmpCode;
  }

  /**
   * Zeitpunkt zu dem diese Textmeldung erzeugt wurde.<br>
   * Format: "TT.MM.JJJJ HH:MM".
   * @return ErzeugungsZeitstempel
   */
  public String getErzeugungsZeitstempel() {
    return _erzeugungsZeitstempel;
  }

  /**
   * Konkrete Patienteninformation in freiem Textformat.<br>
   * Dieses Feld ist nur dann versorgt, wenn in den Eingangsparametern der aufrufenden Funktion der Parameter
   * <code>strukturierteMeldung</code> mit <code>False</code> versorgt wurde.<br>
   * Format: maximal 2000-stellig.
   * @return Konkrete Patienteninformation in freiem Textformat
   */
  public String getFreieMeldung() {
    return _freieMeldung;
  }

  /**
   * Konkrete Patienteninformation in strukturierter Form (z.B. XML) in Base64-Format.<br>
   * Die Struktur ist transparent und dem e-card System nicht bekannt.<br>
   * Dieses Feld ist nur dann versorgt, wenn in den Eingangsparametern der aufrufenden Funktion der Parameter
   * <code>strukturierteMeldung</code> mit <code>True</code> versorgt wurde.<br>
   * Format: maximal 4000-stellig.
   * @return Konkrete Patienteninformation in strukturierter Form
   */
  public String getStrukturierteMeldung() {
    return _strukturierteMeldung;
  }

  public void setDmpCode(String dmpCode) {
    _dmpCode = dmpCode;
  }

  public void setErzeugungsZeitstempel(String erzeugungsZeitstempel) {
    _erzeugungsZeitstempel = erzeugungsZeitstempel;
  }

  public void setFreieMeldung(String freieMeldung) {
    _freieMeldung = freieMeldung;
  }

  public void setStrukturierteMeldung(String strukturierteMeldung) {
    _strukturierteMeldung = strukturierteMeldung;
  }

}
