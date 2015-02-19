/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.tsv.soap.constants;

/**
 * Fehlerkonstanten der Funktionen des Schulungssystems. Fehlercodes siehe
 * {@link at.chipkarte.client.tsv.soap.constants.SchulungExceptionConstants SchulungExceptionConstants}.
 */
public class SchulungExceptionConstants {

  /**
   * Es sind keine Schulungsszenarien verfügbar.<br>
   * ORCLI-Code: SS-00020
   */
  public static final int NO_SCENARIO_FOUND              = 1;

  /**
   * ausgewähltes Schulungsszenario nicht vorhanden.<br>
   * ORCLI-Code: SS-00011, SS-00012, SS-00013, SS-00014, SS-00021, SS-00025
   *  
   */
  public static final int SELECTED_SCENARIO_NOT_AVAIL    = 2;

  /**
   * Die Schulungsecard ist nicht gesteckt oder eine Karte ungleich Schulungsecard ist gesteckt.<br>
   * ORCLI-Code: CL-A0031
   */
  public static final int SCHULUNGS_ECARD_NOT_AVAIL      = 3;

}