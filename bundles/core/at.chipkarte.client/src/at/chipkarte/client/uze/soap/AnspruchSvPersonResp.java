/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Ausgangsdaten der Funktion acquireAnspruchSvPerson.
 */
public class AnspruchSvPersonResp {
  private Anspruch _anspruch;
  private SvPatientInfo _svPatient;

  /**
   * Eigener oder abgeleiteter Anspruch basierend auf SVT der Eingangsdaten, der bei der versicherungsrechtlichen
   * Anspruchspr&uuml;fung eindeutig ermittelt wurde.<br>
   * Versorgt, wenn Kennzeichen Krankenbehandlungsleistung in Eingangsdaten JA und Aufruf erfolgreich.<br>
   * @return Anspruch
   */
  public Anspruch getAnspruch() {
    return _anspruch;
  }

  /**
   * Daten einer SV-Person.<br>
   * Versorgt, wenn Aufruf erfolgreich.<br>
   * @return SvPatient
   */
  public SvPatientInfo getSvPatient() {
    return _svPatient;
  }

  /**
   * Eigener oder abgeleiteter Anspruch basierend auf SVT der Eingangsdaten, der bei der versicherungsrechtlichen
   * Anspruchspr&uuml;fung eindeutig ermittelt wurde.<br>
   * Versorgt, wenn Kennzeichen Krankenbehandlungsleistung in Eingangsdaten JA und Aufruf erfolgreich.<br>
   * @param anspruch Der zu setzende Wert f&uuml;r Anspruch.
   */
  public void setAnspruch(Anspruch anspruch) {
    _anspruch = anspruch;
  }

  /**
   * Daten einer SV-Person.<br>
   * Versorgt, wenn Aufruf erfolgreich.<br>
   * @param svPatient Der zu setzende Wert f&uuml;r SvPatient.
   */
  public void setSvPatient(SvPatientInfo svPatient) {
    _svPatient = svPatient;
  }
}
