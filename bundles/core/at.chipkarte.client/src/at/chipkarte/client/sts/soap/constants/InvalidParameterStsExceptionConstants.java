/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap.constants;

/**
 * 
 * Fehlerkonstanten, die geworfen werden, wenn ein ungültiger Parameter in einer
 * Funktion angegeben wird. Fehlercodes siehe
 * {@link at.chipkarte.client.sts.soap.constants.InvalidParameterStsExceptionConstants InvalidParameterStsExceptionConstants}.
 */
public class InvalidParameterStsExceptionConstants {
  /**
   * Die Sozialversicherungsnummer ist ungültig.<br>
   * ORCLI-Code: CL-07013
   */
  public static final int INVALID_SV_NUMBER = 1;
  
  /**
   * Die eingegebene Sozialversicherungsnummer (als Ticketparameter übergeben)
   * entspricht nicht der, von der e-card gelesenen, Sozialversicherungsnummer.<br>
   * ORCLI-Code: CL-07015
   */
  public static final int INPUT_SVNUMBER_NOT_IDENT_CARD_SVNUMBER = 4;

  /**
   * Der Parameter {Parametername} wurde mehrfach übergeben.<br>
   * ORCLI-Code: CL-07016
   */
  public static final int SAME_TICKETPARAMETER_REPEATED = 5;
  
  /**
   * Das Format des {Index des Ticketparameter} "Ticketparameter" ist ungültig.<br>
   * ORCLI-Code: CL-07017
   */
  public static final int TICKETPARAMETER_WRONG_FORMAT = 6;

  /**
   * Die Länge des Paramter Ticketsubject  ist nicht im zulässigen Bereich.<br>
   * ORCLI-Code: CL-07118
   */
  public static final int TICKETSUBJECT_MAX_LENGTH_EXCEEDED = 8;
  
  /**
   * Die Länge des Paramter ResponseURL  ist nicht im zulässigen Bereich.<br>
   * ORCLI-Code: CL-07128
   */
  public static final int RESPONSEURL_MAX_LENGTH_EXCEEDED = 9;
  
  /**
   * Das Format des Paramter ResponseURL  ist ungültig.<br>
   * ORCLI-Code: CL-07113
   */
  public static final int RESPONSEURL_INVALID_FORMAT = 10;
  
  /**
   * Das Format des Paramter Ticketsubject ist ungültig.<br>
   * ORCLI-Code: CL-07103
   */
  public static final int TICKETSUBJECT_INVALID_FORMAT = 11;
  
  /**
   * Der Parameter Ticketsubject wurde nicht befüllt.<br>
   * ORCLI-Code: CL-07151
   */
  public static final int TICKETSUBJECT_MISSING = 12;

  /**
   * Die VPNR im Parameter Ticketsubject passt nicht zum Vertragspartner für den der Dialog aufgebaut wurde. <br>
   * ORCLI-Code: CL-07104
   */
  public static final int TICKETSUBJECT_VPNR_DIALOGID_MISSMATCH = 13;
  
  /**
   * Die VPNR im Parameter Ticketsubject entspricht nicht dem vorgegebenen Format <br>
   * ORCLI-Code: CL-07023
   */
  public static final int TICKETSUBJECT_VPNR_INVALID_FORMAT = 14;
  
}
