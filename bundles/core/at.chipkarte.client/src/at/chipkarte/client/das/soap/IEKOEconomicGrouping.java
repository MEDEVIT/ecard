package at.chipkarte.client.das.soap;

/**
 * <p>
 * Enthält das Ergebnis der Funktion
 * {@link at.chipkarte.client.das.soap.IDasService#retrieveIEKOEconomicGrouping(String) retrieveIEKOEconomicGrouping}.
 * </p>
 */
public class IEKOEconomicGrouping {
  
  
  private String _pharmaNumber;
  private String _medicamentName;
  private IEKOIngredientReference _identIngredient;
  private IEKOIngredientReference _similarIngredient;
  private IEKOComparison[] _iEKOComparison;
  
  /**
   * Die Pharmanummer der Arzneispezialität zu der der Vergleich durchgeführt wird.
   * Format: numerisch, 7-stellig.
   *  
   * @return Pharmanummer
   */
  public String getPharmaNumber() {
    return _pharmaNumber;
  } 
  
  /**
   * Der Name der Arzneispezialität zu der der Vergleich durchgeführt wird.
   * Format: max 100-stellig.
   *  
   * @return MedicamentName
   */
  public String getMedicamentName() {
    return _medicamentName;
  }
  
  /**
   * Der für den Vergleich herangezogene "gleiche" Wirkstoff (Hauptwirkstoff der Arzneispezialität).
   *  
   * @return IEKOIngredientReference
   */
  public IEKOIngredientReference getIdentIngredient() {
    return _identIngredient;
  }
  
  /**
   * Der für den Vergleich herangezogene "vergleichbare" Wirkstoff, ATC-Levelübergruppe des "gleichen" Wirkstoffes.
   *  
   * @return IEKOIngredientReference
   */
  public IEKOIngredientReference getSimilarIngredient() {
    return _similarIngredient;
  }
  
  /**
   * Die Vergleichsdaten (Arzneispezialitäten und deren Ranking im Vergleich).
   *  
   * @return IEKOComparison[]
   */
  public IEKOComparison[] getIEKOComparison() {
    return _iEKOComparison;
  }
  
  public void setPharmaNumber(String pharmaNumber) {
    _pharmaNumber = pharmaNumber;
  }
  
  public void setMedicamentName(String medicamentName) {
    _medicamentName = medicamentName;
  }
  
  public void setIdentIngredient(IEKOIngredientReference identIngredient) {
    _identIngredient = identIngredient;
  }
  
  public void setSimilarIngredient(IEKOIngredientReference similarIngredient) {
    _similarIngredient = similarIngredient;
  } 
  
  public void setIEKOComparison(IEKOComparison[] iEKOComparison) {
    _iEKOComparison = iEKOComparison;
  }  
}
