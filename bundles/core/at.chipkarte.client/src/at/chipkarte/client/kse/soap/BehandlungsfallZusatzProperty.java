/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

import at.chipkarte.client.base.soap.BaseProperty;

/**
 * Enthält Daten zu den Behandlungsfällen sowie die Information, ob zur Durchführung einer Konsultation 
 * mit dem Behandlungsfall ein weiteres Zusatzrecht benötigt wird. 
 */
public class BehandlungsfallZusatzProperty {
  
  private BaseProperty _baseProperty;
  private String _zusatzRecht;
  
  /**
   * Enthält Daten zu verschiedenen Codewerten, die in der Schnittstelle verwendet werden.
   * <br/>Siehe {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty} 
   * @return BaseProperty.
   */  
  public BaseProperty getBaseProperty() {
    return _baseProperty;
  }
  public void setBaseProperty(BaseProperty baseProperty) {
    _baseProperty = baseProperty;
  }
  
  /**
   * Name des zusätzlich benötigen Rechts.
   * @return Zusatzrecht.
   */  
  public String getZusatzRecht() {
    return _zusatzRecht;
  }
  public void setZusatzRecht(String zusatzRecht) {
    _zusatzRecht = zusatzRecht;
  }
  
  

}
