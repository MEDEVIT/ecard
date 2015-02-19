/*
 * (C) SVC 2011
 */
package at.chipkarte.client.sas.soap.constants;



/**
 * Gibt an ob das Todesdatum bestätigt ist (true) oder nicht (false). Wenn der Patient im eCS nicht als verstorben geführt wird,
 * bleibt dieses Feld leer (nicht null).
 */
public final class TodesdatumBestaetigtKZ {

  /**
   * Ja.
   */
  public static final String JA = "1";

  /**
   * Nein.
   */
  public static final String NEIN = "0";
  
  /**
   * Keine Angabe.
   */
  public static final String KEINE_ANGABE = "";

  private TodesdatumBestaetigtKZ() {
  }

}
