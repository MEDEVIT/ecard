package at.chipkarte.client.das.soap;

/**
 * <p>
 * Detaildaten der in Vergelich gefundenen Arzneispezialität.
 * </p>
 */
public class IEKOMedicament {
  
  private String _pharmaNumber;
  private String _registerNumberPrefix;
  private String _registerNumber;
  private String _packageNumber;
  private String _medicamentName;
  private String _box;
  private String _healthInsuranceSign;
  private String _amount;
  private String _price;
  private String _pricePerUnit;
  private String _dosageForm;
  private String _divisibility;
  private String _refaktie;
  private String _dispensingCount;
  private String _packageInformation;
  private String _informationText;
  private String _ruleText;
  private String _indicationText;
  private String _atcCode;
  private String _ingredientName;
  private String _ingredientInformation;
  private IEKOIngredient[] _iEKOIngredient;
  private String _ingredientNarcoticSign;
  private String _longTermPermission;
  private String _indicationTextHTMLFormatted;
  private String _ruleTextHTMLFormatted;
  
  /**
   * Die Pharmanummer der Arzneispezialität.
   * Format: numerisch, 7-stellig.
   *  
   * @return Pharmanummer
   */
  public String getPharmaNumber() {
    return _pharmaNumber;
  }
  
  /**
   * Registernummerprefix der Arzneispezialität.
   * Format: 6-stellig.
   *  
   * @return RegisterNumberPrefix
   */
  public String getRegisterNumberPrefix() {
    return _registerNumberPrefix;
  }
  
  /**
   * Registernummer der Arzneispezialität.
   * Format: 2-stellig.
   *  
   * @return RegisterNumber
   */
  public String getRegisterNumber() {
    return _registerNumber;
  }
  
  /**
   * Packungsnummer der Arzneispezialität.
   * Format: 3-stellig.
   *  
   * @return PackageNumber
   */
  public String getPackageNumber() {
    return _packageNumber;
  }
  
  /**
   * Name der Arzneispezialität.
   * Format: max 100-stellig.
   *  
   * @return MedicamentName
   */
  public String getMedicamentName() {
    return _medicamentName;
  }
  
  /**
   * Boxenzuordnung der Arzneispezialität (grüne oder gelbe Box).
   * Format: 3-stellig.
   *  
   * @return Box
   */
  public String getBox() {
    return _box;
  }
  
  /**
   * Kassenzeichen der Arzneispezialität.
   * Format: 5-stellig.
   *  
   * @return HealthInsuranceSign
   */
  public String getHealthInsuranceSign() {
    return _healthInsuranceSign;
  }
  
  /**
   * Menge und Mengenart der Arzneispezialität.
   * Format: 8-stellig.
   *  
   * @return Amount
   */
  public String getAmount() {
    return _amount;
  }
  
  /**
   * KVP (Kassenverkaufspreis) der Arzneispezialität in Euro.
   * Format: 10-stellig.
   *  
   * @return price
   */
  public String getPrice() {
    return _price;
  }
  
  /**
   * KVP (Kassenverkaufspreis) der Arzneispezialität in Euro pro Einheit.
   * Format: 10-stellig.
   *  
   * @return PricePerUnit
   */
  public String getPricePerUnit() {
    return _pricePerUnit;
  }
  
  /**
   * Dareichungsform der Arzneispezialität.
   * Format: 9-stellig.
   *  
   * @return DosageForm
   */
  public String getDosageForm() {
    return _dosageForm;
  }
  
  /**
   * Teilbarkeit der Arzneispezialität.
   * Format: 9-stellig.
   *  
   * @return Divisibility
   */
  public String getDivisibility() {
    return _divisibility;
  }
  
  /**
   * Refaktie der Arzneispezialität.
   * Format: 3-stellig.
   *  
   * @return Refaktie
   */
  public String getRefaktie() {
    return _refaktie;
  }
  
  /**
   * Abgabeanzahl der Arzneispezialität.
   * Format: 3-stellig.
   *  
   * Hinweis: ist dieser Parameter nicht befüllt, 
   * bedeutet dies eine Abgabemenge von "1"  
   *  
   * @return DispensingCount
   */
  public String getDispensingCount() {
    return _dispensingCount;
  }
  
  /**
   * Hinweis zur Packung der Arzneispezialität.
   * Format: 28-stellig. 
   *  
   * @return PackageInformation
   */
  public String getPackageInformation() {
    return _packageInformation;
  }
  
  /**
   * Hinweistext der Arzneispezialität.
   * Format:max 3000-stellig. 
   *  
   * @return InformationText
   */
  public String getInformationText() {
    return _informationText;
  }
  
  /**
   * Regeltext der Arzneispezialität.
   * Format:max 4000-stellig. 
   *  
   * @return RuleText
   */
  public String getRuleText() {
    return _ruleText;
  }
  
  /**
   * Indikationstextext der Arzneispezialität.
   * Format:max 4000-stellig. 
   *  
   * @return IndicationText
   */
  public String getIndicationText() {
    return _indicationText;
  }
  
  /**
   * Der ATC-Code des Hauptwirkstoffes der Arzneispezialität.
   * Format: 7-stellig.
   * 
   * Hinweis: Bei Mono-Präparaten werden die Detaildaten zum einzigen Wirkstoff zurückgeliefert 
   * (dieser entspricht dem Hauptwirkstoff), bei Kombipräparaten werden alle Detaildaten der 
   * Wirkstoffe zurückgeliefert, die durch den Hauptwirkstoff zusammencodiert sind.
   *  
   * @return AtcCode
   */
  public String getAtcCode() {
    return _atcCode;
  }
  
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
   * Informationen zu den Wirkstoff(en) in der Arzneispezialität.
   * Format: max 300-stellig.
   *  
   * @return IngredientInformation
   */
  public String getIngredientInformation() {
    return _ingredientInformation;
  }

  /**
   * Beinhaltet die Detaildaten der Wirkstoffe zur Arzneispezialität. 
   *  
   * @return IEKOIngredient[]
   */
  public IEKOIngredient[] getIEKOIngredient() {
    return _iEKOIngredient;
  }
  
  /**
   * Suchtgift Vignette der Arzneispezialität. 
   * Format: max. 3-stellig
   *  
   * @return IngredientNarcoticSign
   */
  public String getIngredientNarcoticSign() {
    return _ingredientNarcoticSign;
  }
  
  /**
   * Langzeitbewilligung-Kennzeichnung der Arzneispezialität. 
   * Format: max. 3-stellig
   *  
   * @return LongTermPermission
   */
  public String getLongTermPermission() {
    return _longTermPermission;
  }
  
  /**
   * Indikationstext der Arzneispezialität in HTML Format.
   * Format:max 4000-stellig. 
   *  
   * @return IndicationTextHTMLFormatted
   */
  public String getIndicationTextHTMLFormatted() {
    return _indicationTextHTMLFormatted;
  }
  
  /**
   * Regeltext der Arzneispezialität in HTML Format.
   * Format:max 4000-stellig. 
   *  
   * @return RuleTextHTMLFormatted
   */
  public String getRuleTextHTMLFormatted() {
    return _ruleTextHTMLFormatted;
  }
  
  public void setPharmaNumber(String pharmaNumber) {
    _pharmaNumber = pharmaNumber;
  }
  
  public void setRegisterNumberPrefix(String registerNumberPrefix) {
    _registerNumberPrefix = registerNumberPrefix;
  }
  
  public void setRegisterNumber(String registerNumber) {
    _registerNumber = registerNumber;
  }
  
  public void setPackageNumber(String packageNumber) {
    _packageNumber = packageNumber;
  }
  
  public void setMedicamentName(String medicamentName) {
    _medicamentName = medicamentName;
  }
  
  public void setBox(String box) {
    _box = box;
  }
  
  public void setHealthInsuranceSign(String healthInsuranceSign) {
    _healthInsuranceSign = healthInsuranceSign;
  }
  
  public void setAmount(String amount) {
    _amount = amount;
  }
  
  public void setPrice(String price) {
    _price = price;
  }
  
  public void setPricePerUnit(String pricePerUnit) {
    _pricePerUnit = pricePerUnit;
  }
  
  public void setDosageForm(String dosageForm) {
    _dosageForm = dosageForm;
  }
  
  public void setDivisibility(String divisibility) {
    _divisibility = divisibility;
  }
  
  public void setRefaktie(String refaktie) {
    _refaktie = refaktie;
  }
  
  public void setDispensingCount(String dispensingCount) {
    _dispensingCount = dispensingCount;
  }
  
  public void setPackageInformation(String packageInformation) {
    _packageInformation = packageInformation;
  }
  
  public void setInformationText(String informationText) {
    _informationText = informationText;
  }
  
  public void setRuleText(String ruleText) {
    _ruleText = ruleText;
  }
  
  public void setIndicationText(String indicationText) {
    _indicationText = indicationText;
  }
  
  public void setAtcCode(String atcCode) {
    _atcCode = atcCode;
  }
  
  public void setIngredientName(String ingredientName) {
    _ingredientName = ingredientName;
  }
  
  public void setIngredientInformation(String ingredientInformation) {
    _ingredientInformation = ingredientInformation;
  }

  public void setIEKOIngredient(IEKOIngredient[] iEKOIngredient) {
    _iEKOIngredient = iEKOIngredient;
  }

  public void setIngredientNarcoticSign(String ingredientNarcoticSign) {
    _ingredientNarcoticSign = ingredientNarcoticSign;
  }

  public void setLongTermPermission(String longTermPermission) {
    _longTermPermission = longTermPermission;
  }

  public void setIndicationTextHTMLFormatted(String indicationTextHTMLFormatted) {
    _indicationTextHTMLFormatted = indicationTextHTMLFormatted;
  }

  public void setRuleTextHTMLFormatted(String ruleTextHTMLFormatted) {
    _ruleTextHTMLFormatted = ruleTextHTMLFormatted;
  }
}
