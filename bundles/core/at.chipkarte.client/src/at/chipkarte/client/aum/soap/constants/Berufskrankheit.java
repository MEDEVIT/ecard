/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap.constants;
/**
 * Konstanten f&uuml;r den Wert des Parameters "Berufskrankheit" 
 * (<code>boolean</code> kann hier nicht verwendet werden, weil
 * "Berufskrankheit" kein Pflichtfeld ist).
 */
public class Berufskrankheit {
  /**
   * Konstante f&uuml;r Berufskrankheit (falsch).
   */
  public static final int FALSE = 0;
  /**
   * Konstante f&uuml;r Berufskrankheit (richtig).
   */
  public static final int TRUE = 1;
  /**
   * Konstante f&uuml;r Berufskrankheit (unbekannt / nicht gesetzt).
   */
  public static final int UNKNOWN = 2;
}
