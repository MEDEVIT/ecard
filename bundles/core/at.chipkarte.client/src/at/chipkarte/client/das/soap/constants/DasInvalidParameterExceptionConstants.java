package at.chipkarte.client.das.soap.constants;

/**
 * <p>
 * Fehlerkonstanten, wenn ein ungültiger Parameter in einer Funktion angegeben
 * wird.
 * </p>
 */
public class DasInvalidParameterExceptionConstants {
  /**
   * Die Pharmanummer ist ein Mussfeld.<br>
   * ORCLI-Code: CL-1501021
   */
  public static final int IEKO_PHARMA_NUMBER_NOT_SET = 1;
  
  /**
   * Die angegebene Pharmanummer ist ungültig.<br>
   * ORCLI-Code: CL-1501020
   */
  public static final int IEKO_PHARMA_NUMBER_INVALID = 2;
}
