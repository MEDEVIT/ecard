/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.tsv.soap.constants;

/**
 * 
 * Fehlerkonstanten, wenn ein ungültiger Parameter in einer Funktion angegeben wird. Fehlercodes
 * siehe
 * {@link at.chipkarte.client.tsv.soap.constants.InvalidParameterExceptionConstants InvalidParameterExceptionConstants}
 */
public class InvalidParameterExceptionConstants {

  /**
   * Fachgebietscode ist ungültig.
   * <br>ORCLI-Code: CL-A0015 
   *  
   */
  public static final int INVALID_FG                     = 6;

  /**
   * unerlaubter Wert für diesen Parameter.
   * <br>ORCLI-Code: CL-A0029
   * 
   */
  public static final int ILLEGAL_VALUE                  = 100; 
  
}

