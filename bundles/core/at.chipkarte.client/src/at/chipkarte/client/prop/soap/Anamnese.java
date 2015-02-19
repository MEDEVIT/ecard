package at.chipkarte.client.prop.soap;
/**
 * Beinhaltet die Eingangsdaten zur Erfassung des Präoperativen Befundes.
 */
public class Anamnese {
  private String _svNummer;
  private Long _konsultationId;
  private AnamneseData _anamneseData;
  private EkvkPatient _ekvkPatient;
  private String _erstellerId;
  private String _erstellerName;

  /**
   * Sozialversicherungsnummer des Patienten.<br>
   * Format: 10-stellig.
   * @return SV-Nummer
   */
  public String getSvNummer() {
    return _svNummer;
  }
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }
  /**
   * Id der Konsultation.<br>
   * Format: maximal 19-stellig
   * @return KonsultationsId
   */
  public Long getKonsultationId() {
    return _konsultationId;
  }
  public void setKonsultationId(Long konsultationId) {
    _konsultationId = konsultationId;
  }
  /**
   * Anamnesedaten.<br>
   * @return Anamnesedaten
   * @see AnamneseData
   */
  public AnamneseData getAnamneseData() {
    return _anamneseData;
  }
  public void setAnamneseData(AnamneseData anamneseData) {
    _anamneseData = anamneseData;
  }
  
  /**
   * Patientendaten eines Patienten ohne SV-Nummer.<br>
   * @return EkvkPatient
   * @see EkvkPatient
   */
  public EkvkPatient getEkvkPatient() {
    return _ekvkPatient;
  }
  public void setEkvkPatient(EkvkPatient ekvkPatient) {
    _ekvkPatient = ekvkPatient;
  }
  
  /**
   * Id des Erstellers.<br>
   * Format: maximal 20-stellig
   * @return KonsultationsId
   */
  public String getErstellerId() {
    return _erstellerId;
  }
  public void setErstellerId(String erstellerId) {
    _erstellerId = erstellerId;
  }
  
  /**
   * Name des Erstellers.<br>
   * Format: maximal 70-stellig
   * @return KonsultationsId
   */
  public String getErstellerName() {
    return _erstellerName;
  }
  public void setErstellerName(String erstellerName) {
    _erstellerName = erstellerName;
  }
  
  
}
