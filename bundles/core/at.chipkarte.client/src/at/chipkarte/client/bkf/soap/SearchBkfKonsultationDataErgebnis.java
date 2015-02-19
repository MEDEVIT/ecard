package at.chipkarte.client.bkf.soap;


/**
 * Liefert, abhängig des Dokumentationsblattes BKF-relevante Konsultationen. 
 * <br>Rückgabewert der Funktion
 * {@link at.chipkarte.client.bkf.soap.IBkfService#searchBkfKonsultationData(String, String, String)}
 */

public class SearchBkfKonsultationDataErgebnis {

  private BKFPatientInfo _svPatient;
  private BKFKonsultationInfo[] _konsultationen;

  /**
   * Daten der Patientin zur Konsultation. Siehe {@link BKFPatientInfo}. <br>
   * Angabe: Muss.
   * @return SvPatient
   */
  public BKFPatientInfo getSvPatient() {
    return _svPatient;
  }

  public void setSvPatient(BKFPatientInfo svPatient) {
    _svPatient = svPatient;
  }

  /**
   * Konsultationen, denen das entsprechende Dokumentationsblatt zugeordnet werden kann. Siehe {@link BKFKonsultationInfo}. <br>
   * Angabe: Kann.
   * @return Konsultationen
   */
  public BKFKonsultationInfo[] getKonsultationen() {
    return _konsultationen;
  }

  public void setKonsultationen(BKFKonsultationInfo[] konsultationen) {
    _konsultationen = konsultationen;
  }

}