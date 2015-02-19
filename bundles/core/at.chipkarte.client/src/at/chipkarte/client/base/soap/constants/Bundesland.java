/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Länder.
 * 
 * @ecardOk rule=ConstantNameCheck changing constant names on the SS12 interface is not advisable
 * @ecardOk rule=JavadocVariableCheck no need for further documentation
 */
public final class Bundesland {

  private Bundesland() {
    // nothing to do
  }
  
  public static final String AUSLAND = "0";
  public static final String WIEN = "1";
  public static final String NIEDERÖSTERREICH = "2";
  public static final String BURGENLAND = "3";
  public static final String OBERÖSTERREICH = "4";
  public static final String STEIERMARK = "5";
  public static final String KÄRNTEN = "6";
  public static final String SALZBURG = "7";
  public static final String TIROL = "8";
  public static final String VORARLBERG = "9";

}
