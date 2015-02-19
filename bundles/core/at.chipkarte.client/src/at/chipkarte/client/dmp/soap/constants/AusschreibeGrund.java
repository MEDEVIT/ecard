/*
 * (C) SVC 2012
 */
package at.chipkarte.client.dmp.soap.constants;

/**
 * <p>
 * Konstanten für den Grund der Ausschreibung.
 * </p>
 */
public final class AusschreibeGrund {
  /**
   * Konstante für den Ausschreibegrund "Durch Versicherte/n".
   */
  public static final String DURCH_VERSICHERTEN = "AV";
  /**
   * Konstante für den Ausschreibegrund "Verstorben".
   */
  public static final String VERSTORBEN = "VE";
  /**
   * Konstante für den Ausschreibegrund "Eingabefehler".
   */
  public static final String EINGABEFEHLER = "EF";
  /**
   * Konstante für den Ausschreibegrund "Arztwunsch".
   */
  public static final String ARZTWUNSCH = "AW";
  /**
   * Konstante für den Ausschreibegrund "Sonstiges".
   */
  public static final String SONSTIGES = "SO";

  private AusschreibeGrund() {
    // do not use
  }
}
