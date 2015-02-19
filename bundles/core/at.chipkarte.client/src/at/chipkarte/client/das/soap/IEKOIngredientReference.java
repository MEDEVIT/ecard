package at.chipkarte.client.das.soap;

/**
 * <p>
 * Die Referenzdaten (Name und ATC-Code) eines Wirkstoffes.
 * </p>
 */
public class IEKOIngredientReference {

  private String _ingredientName;
  private String _atcCode;
  
  
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
  
  public void setIngredientName(String ingredientName) {
    _ingredientName = ingredientName;
  }
  
  public void setAtcCode(String atcCode) {
    _atcCode = atcCode;
  }
}
