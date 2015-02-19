/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap;

/**
 * <p>
 * Enthält administrative oder medizinische Patienteninformationen zu einem Patienten.
 * </p>
 */
public class PatientenInformation {

  private SvPerson _patient;
  private Textmeldung[] _textmeldung;

  /**
   * Beschreibung des Patienten.
   * @return SvPerson
   */
  public SvPerson getPatient() {
    return _patient;
  }

  /**
   * Textmeldung aus dem DMP-Backend.<br>
   * Pro DMP ist jeweils eine Textmeldung möglich.
   * @return Liste von Textmeldungen.
   */
  public Textmeldung[] getTextmeldung() {
    return _textmeldung;
  }

  public void setPatient(SvPerson patient) {
    _patient = patient;
  }

  public void setTextmeldung(Textmeldung[] textmeldung) {
    _textmeldung = textmeldung;
  }

}
