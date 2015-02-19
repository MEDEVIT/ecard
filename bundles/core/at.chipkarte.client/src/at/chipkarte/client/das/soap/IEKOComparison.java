package at.chipkarte.client.das.soap;

/**
 * <p>
 * Detaildaten zu einem in der Arzneispezialität enthaltenen Wirkstoff.
 * </p>
 */
public class IEKOComparison {
  
  private IEKOMedicament _iEKOMedicament;
  private String _comparisonPosition;
  private String _comparisonCode; 
  
  /**
   * Im Vergleich gefundene Arzneispezialität.
   *  
   * @return IEKOMedicament
   */
  public IEKOMedicament getIEKOMedicament() {
    return _iEKOMedicament;
  }
  
  /**
   * Position der Arzneispezialität im ökonomischen Ranking.
   * Format: 2-stellig
   *  
   * @return ComparisonPosition
   */
  public String getComparisonPosition() {
    return _comparisonPosition;
  }
  
  /**
   * Vergleichskennzeichen hinsichtlich des Wirkstoffes.
   * Format: 1-stellig
   *  
   * @return comparisonCode
   */
  public String getComparisonCode() {
    return _comparisonCode;
  }
  
  public void setIEKOMedicament(IEKOMedicament iEKOMedicament) {
    _iEKOMedicament = iEKOMedicament;
  }
  
  public void setComparisonPosition(String comparisonPosition) {
    _comparisonPosition = comparisonPosition;
  }
  
  public void setComparisonCode(String comparisonCode) {
    _comparisonCode = comparisonCode;
  }
  
}
