/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap.constants;

/**
 * Fehlerkonstanten, wenn ein ungültiger Parameter in einer Funktion angegeben wird. Fehlercodes siehe
 * {@link at.chipkarte.client.vdas.soap.constants.InvalidParameterVdasExceptionConstants InvalidParameterVdasExceptionConstants}
 */
public final class InvalidParameterVdasExceptionConstants {

  private InvalidParameterVdasExceptionConstants() {
    // nothing to do
  }

  /**
   * Die Sozialversicherungsnummer ist ungültig oder fehlt. <br>
   * ORCLI-Code: CL-05202
   */
  public static final int INVALID_SV_NUMBER = 1;

  /**
   * Die abgeleitete Sozialversicherungsnummer ist ungültig. <br>
   * ORCLI-Code: CL-05213
   */
  public static final int INVALID_SV_NUMBER_ABL = 2;

  /**
   * Der Krankenversicherungsträger ist ungültig. <br>
   * ORCLI-Code: CL-05224
   */
  public static final int INVALID_SVT_NUMBER = 3;

  /**
   * Der Abteilungs- bzw Funktionscode hat eine falsche Länge. <br>
   * ORCLI-Code: CL-05233
   */
  public static final int INVALID_ABT_FUNK_CODE = 5;

  /**
   * In der Funktion wurde eine CIN übergeben, die nicht mit der CIN der gesteckten Karte übereinstimmt. <br>
   * ORCLI-Code: CL-05242
   */
  public static final int CIN_NOT_IDENT = 6;

  /**
   * Das Stichtagsdatum ist ungültig. <br>
   * ORCLI-Code: CL-05282
   */
  public static final int INVALID_STICHTAGSDATUM = 7;

  /**
   * Zu dem angegebenen Datum können keine Versichertendaten ermittelt werden. <br>
   * Diese Exception tritt auf, wenn zum abgefragten Datum keine Ansprüche vorliegen. <br>
   * ORCLI-Code: CL-05285
   */
  public static final int NO_ANSPRUECHE_PROVIDED_FOR_SELECTED_DATE = 8;

  /**
   * Es wurde kein Software-Zertifikat für die Signierung des Requests verwendet und kein Kartenleser zugeordnet. <br>
   * ORCLI-Code: CL-05011
   */
  public static final int NO_CERTIFICATE_AND_NO_CARD_READER = 10;

  /**
   * Es wurde weder ein Software-Zertifikat für die Signierung verwendet, noch eine e-card gesteckt. <br>
   * ORCLI-Code: CL-05012
   */
  public static final int NO_CERTIFICATE_AND_NO_ECARD = 11;

  /**
   * Die übergebene Sozialversicherungsnummer ist nicht ident mit der gelesenen Sozialversicherungsnummer der gesteckten Karte. <br>
   * ORCLI-Code: CL-05205
   */
  public static final int INPUT_SV_NUMBER_NOT_IDENT_CARD_SV_NUMBER = 12;

  /**
   * Um tagesaktuelle Versicherungsdaten zu ermitteln, verwenden Sie bitte den Ablauf "Tagesaktuelle Versichertendaten abfrage".<br>
   * ORCLI-Code: CL-05286
   */
  public static final int STICHTAGSDATUM_NOT_VALID_FOR_PAST_REQUEST = 13;

  /**
   * Das Stichtagsdatum ist ein Pflichtfeld.<br>
   * ORCLI-Code: CL-05281
   */
  public static final int STICHTAGSDATUM_NOT_SET = 14;
}
