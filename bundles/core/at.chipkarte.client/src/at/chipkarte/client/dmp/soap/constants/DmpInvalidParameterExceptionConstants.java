/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap.constants;

/**
 * <p>
 * Fehlerkonstanten, wenn ein ungültiger Parameter in einer Funktion angegeben wird.
 * </p>
 */
public final class DmpInvalidParameterExceptionConstants {

  private DmpInvalidParameterExceptionConstants() {
    // do not use
  }

  /**
   * Das Therapie Aktiv Programm ist ungültig.<br>
   * ORCLI-Code: CL-02001
   */
  public static final int INVALID_DMP_CODE = 1;

  /**
   * Die Einschreibeart ist ungültig.<br>
   * ORCLI-Code: CL-02002
   */
  public static final int INVALID_EINGABE_ART = 2;

  /**
   * Die Sozialversicherungsnummer ist ungültig oder fehlt.<br>
   * ORCLI-Code: CL-02003
   */
  public static final int INVALID_SV_NUMBER = 3;

  /**
   * Es ist keine e-card gesteckt und/oder die eingegebene Sozialversicherungsnummer ist ungültig oder fehlt.<br>
   * ORCLI-Code: CL-02004
   */
  public static final int NO_SV_PERSON_IDENTIFICATION = 4;

  /**
   * Das angegebene Fachgebiet ist ungültig.<br>
   * ORCLI-Code: CL-02005
   */
  public static final int INVALID_FG = 5;

  /**
   * Der Krankenversicherungsträger ist ungültig.<br>
   * ORCLI-Code: CL-02006
   */
  public static final int INVALID_SVT = 6;

  /**
   * Der Anfragestatus ist ungültig.<br>
   * ORCLI-Code: CL-02007
   */
  public static final int INVALID_ANFRAGE_STATUS = 7;

  /**
   * "Suchzeitraum bis" muss nach "Suchzeitraum von" liegen.<br>
   * ORCLI-Code: CL-02008
   */
  public static final int DATE_ORDER_WRONG = 8;

  /**
   * "Suchzeitraum von" ist ungültig (kein gültiges Datum).<br>
   * ORCLI-Code: CL-02009
   */
  public static final int BEGIN_DATUM_INVALID = 9;

  /**
   * "Suchzeitraum bis" ist ungültig (kein gültiges Datum).<br>
   * ORCLI-Code: CL-02010
   */
  public static final int ENDE_DATUM_INVALID = 10;

  /**
   * Der Betreuungsstatus ist ungültig.<br>
   * ORCLI-Code: CL-02012
   */
  public static final int INVALID_BETREUUNGSSTATUS = 12;

  /**
   * Der Ausschreibegrund ist ungültig.<br>
   * ORCLI-Code: CL-02015
   */
  public static final int INVALID_AUSSCHREIBEGRUND = 13;

  /**
   * Die Anfrageart ist ungültig.<br>
   * ORCLI-Code: CL-02017
   */
  public static final int INVALID_ANFRAGE_ART = 14;

  /**
   * Postleitzahl hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02103
   */
  public static final int PLZ_WRONG_FORMAT = 20;

  /**
   * Ort hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02113
   */
  public static final int ORT_WRONG_FORMAT = 22;

  /**
   * Straße hat falsches Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02123
   */
  public static final int STRASSE_WRONG_FORMAT = 24;

  /**
   * Hausnummer hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02133
   */
  public static final int HAUSNR_WRONG_FORMAT = 25;

  /**
   * Stock/Türnummer hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02143
   */
  public static final int NR_ZUSATZ_WRONG_FORMAT = 27;

  /**
   * Anschriftzusatz hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02153
   */
  public static final int ADRESS_ZUSATZ_WRONG_FORMAT = 28;

  /**
   * Telefonnummer hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02163
   */
  public static final int TEL_NR_WRONG_FORMAT = 29;

  /**
   * Email hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02173
   */
  public static final int EMAIL_WRONG_FORMAT = 30;

  /**
   * Kommentar hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02183
   */
  public static final int EINGABE_ZUSATZ_WRONG_FORMAT = 31;

  /**
   * Die Eingabe für "Suchzeitraum von" hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02193
   */
  public static final int BEGIN_DATUM_WRONG_FORMAT = 32;

  /**
   * Die Eingabe für "Suchzeitraum bis" hat das falsche Format (Format oder Länge).<br>
   * ORCLI-Code: CL-02203
   */
  public static final int ENDE_DATUM_WRONG_FORMAT = 33;

  /**
   * Die Postfachnummer hat das falsche Format.<br>
   * ORCLI-Code: CL-02213
   */
  public static final int POSTFACHNUMMER_WRONG_FORMAT = 34;

  /**
   * Der Postfachtext hat das falsche Format.<br>
   * ORCLI-Code: CL-02223
   */
  public static final int POSTFACHTEXT_WRONG_FORMAT = 35;

  /**
   * Wird eine Adresse angegeben, muss diese vollständig erfasst werden (Ort, PLZ, Hausnummer oder Postfachnummer).<br>
   * ORCLI-Code: CL-02013
   */
  public static final int ADRESSE_INCOMPLETE = 36;
}
