/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.constants;

/**
 * Konstanten zur Kennzeichnung einer {@link at.chipkarte.client.abs.soap.BewilligungsAnfrage BewilligungsAnfrage} für den
 * chefärztlichen Dienst.
 */
public final class Antragstyp {

  private Antragstyp() {
    // do not use
  }

  /**
   * Kennzeichnung einer Bewilligungsanfrage im Rahmen einer Rezeptausstellung.
   */
  public static final String REZEPT = "R";

  /**
   * Kennzeichnung einer Bewilligungsanfrage im Rahmen einer Arztbrieferstellung.
   */
  public static final String ARZTBRIEF = "A";

}