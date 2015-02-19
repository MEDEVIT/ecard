/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap.constants;

/**
 * <p>
 * Fachliche Fehlerkonstanten von UZE in Zusammenhang mit einer Anspruchspr&uuml;fung.
 * </p>
 */
public class UzeAnspruchExceptionConstants {

  /**
   * Der Krankenversicherungstr&auml;ger wurde richtiggestellt. Bitte pr&uuml;fen Sie, ob die gew&uuml;nschte Leistung beim 
   * ermittelten Krankenversicherungstr&auml;ger ebenfalls eine Krankenbehandlungsleistung ist.<br>
   * ORCLI-Code: ZS-06006
   */
  public static final int SVT_CORRECTED = 1;

  /**
   * Der Patient hat abgeleitete Krankenversicherungsanspr&uuml;che. Einer der abgeleiteten Anspr&uuml;che muss ausgew&auml;hlt
   * werden.<br>
   * ORCLI-Code: ZS-06008
   */
  public static final int SELECT_ANSPRUCH = 2;

  /**
   * Einer der GKK/BKK Anspr&uuml;che muss ausgew&auml;hlt werden.<br>
   * ORCLI-Code: ZS-06011
   */
  public static final int SELECT_ASVG_SVT = 3;

}
