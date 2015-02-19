package at.chipkarte.client.prop.soap;
/**
 * Enthält Daten eines Patienten sowie zu den für diesen Patienten erfassten Konsultationen.
 */
public class PatientData {
  private Konsultation[] _konsultationen;
  private SvPatient _svPatient;
  /**
   * Die für den Patienten erfassten {@link Konsultation Konsultationen}.<br>
   * @return Konsultationen
   */
  public Konsultation[] getKonsultationen() {
    return _konsultationen;
  }
  public void setKonsultationen(Konsultation[] konsultationen) {
    _konsultationen = konsultationen;
  }
  /**
   * Die Daten des Patienten.<br>
   * @return Patientendaten
   */
  public SvPatient getSvPatient() {
    return _svPatient;
  }
  public void setSvPatient(SvPatient patient) {
    _svPatient = patient;
  }
}
