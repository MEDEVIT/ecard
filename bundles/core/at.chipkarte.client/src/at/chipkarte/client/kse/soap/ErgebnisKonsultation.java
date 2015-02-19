/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält das Ergebnis einer positiv durchgeführten Konsultation.
 */

public class ErgebnisKonsultation {

  private KonsultationsBeleg[] _nachsignKonsultationen;
  private Konsultationsdaten _konsultationsDaten;
  private Integer[] _kseMessageCodes;
  private Zusatzinformation _zusatzinformation;

  public void setKonsultationsDaten(Konsultationsdaten konsultationsDaten) {
    _konsultationsDaten = konsultationsDaten;
  }

  public void setKseMessageCodes(Integer[] kseMessageCodes) {
    _kseMessageCodes = kseMessageCodes;
  }

  public void setNachsignKonsultationen(KonsultationsBeleg[] nachsignKonsultationen) {
    _nachsignKonsultationen = nachsignKonsultationen;
  }
  
  public void setZusatzinformation(Zusatzinformation zusatzinformation) {
    _zusatzinformation = zusatzinformation;
  }

  /**
   * {@link Konsultationsdaten Konsultationsdaten}, die zu einer Genehmigungsanfrage (Konsultation, Nacherfassung) gehören.
   * @return Konsultationsdaten
   */
  public Konsultationsdaten getKonsultationsDaten() {
    return _konsultationsDaten;
  }

  /**
   * Im Zuge der Konsultation nachsignierte Konsultationsbelege.
   * @return Belege der nachsignierten Konsultationen
   */
  public KonsultationsBeleg[] getNachsignKonsultationen() {
    return _nachsignKonsultationen;
  }

  /**
   * Codewert für zusätzliche Informationen, im Falle einer positiv durchgeführten Konsultation.
   * <br/>Optional
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.KseMessage KseMessage}
   * @return Message-Codes
   */
  public Integer[] getKseMessageCodes() {
    return _kseMessageCodes;
  }
  
  /**
   * Liefert eine {@link Zusatzinformation Zusatzinformation} zu dem Patienten.
   * <br/>Optional
   * @return Zusatzinformation
   */
  public Zusatzinformation getZusatzinformation() {
    return _zusatzinformation;
  }
}
