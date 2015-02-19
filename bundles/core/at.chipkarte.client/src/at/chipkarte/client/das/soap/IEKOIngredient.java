package at.chipkarte.client.das.soap;

/**
 * <p>
 * Detaildaten zu einem in der Arzneispezialität enthaltenen Wirkstoff.
 * </p>
 */
public class IEKOIngredient {
  
  private String _ingredientName;
  private String _atcCode;
  private String _ingredientStrength;
  private String _ingredientDimension;
  
  /**
   * Der Name (die Bedeutung) des Wirkstoffes.
   * Format: max 200-stellig.
   *  
   * @return IngredientName
   */
  public String getIngredientName() {
    return _ingredientName;
  }
  
  /**
   * Der ATC-Code des Wirkstoffes.
   * Format: 7-stellig.
   *  
   * @return AtcCode
   */
  public String getAtcCode() {
    return _atcCode;
  }
  
  /**
   * Wirkstoffstärke des Wirkstoffes in der Arzneispezialität.
   * Format: 10-stellig.
   *  
   * @return IngredientStrength
   */
  public String getIngredientStrength() {
    return _ingredientStrength;
  }
  
  /**
   * Dimension des Wirkstoffes in der Arzneispezialität
   * Format: 9-stellig.
   * 
   * Hinweis: ist dieser Parameter nicht befüllt, 
   * bedeutet dies die Dimension Gramm/Stück
   * 
   * @return IngredientDimension
   */
  public String getIngredientDimension() {
    return _ingredientDimension;
  }
  
  public void setIngredientName(String ingredientName) {
    _ingredientName = ingredientName;
  }
  
  public void setAtcCode(String atcCode) {
    _atcCode = atcCode;
  }
  
  public void setIngredientStrength(String ingredientStrength) {
    _ingredientStrength = ingredientStrength;
  }
  
  public void setIngredientDimension(String ingredientDimension) {
    _ingredientDimension = ingredientDimension;
  }
  
}
