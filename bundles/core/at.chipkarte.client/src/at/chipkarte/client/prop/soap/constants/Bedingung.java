package at.chipkarte.client.prop.soap.constants;

public class Bedingung {
  /**
   * Bedingung: genau ein Risikofaktor muss gewählt werden. 
   */
  public static final String GENAU_EIN = "0";
  /**
   * Bedingung: beliebig viele Risikofaktoren können gewählt werden.
   */
  public static final String KEIN_ODER_MEHRERE = "1";
  /**
   * Bedingung: mindestens ein Risikofaktor muss gewählt werden.
   */
  public static final String MINDESTENS_EIN = "2";
  /**
   * Bedingung: kein oder ein Risikofaktor muss gewählt werden.
   */
  public static final String KEIN_ODER_EIN = "3";
}
