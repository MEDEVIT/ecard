/*
 * (C) Siemens and SVCBE 2008
 */
package at.chipkarte.client.abs.soap.constants;

/**
 * Fehlerkonstanten für falsche Parameterübergaben in der Funktion
 * {@link at.chipkarte.client.abs.soap.IAbsService#getStatusBewilligungsAnfragen(String) getStatusBewilligungsAnfragen} bzw. wenn
 * die Funktion
 * {@link at.chipkarte.client.abs.soap.IAbsService#getStatusPatientBewilligungsAnfragen(String, String, String, String, String)
 * getStatusPatientBewilligungsAnfragen} keinen Treffer retourniert hat.
 */
public final class InvalidParameterGetAnfrageStatusExceptionConstants {

  private InvalidParameterGetAnfrageStatusExceptionConstants() {
    // do not use
  }

  /**
   * Der angegebene Anfragestatus ist ungültig. 
   * <br/>ORCLI-Code: CL-04433
   */
  public static final int ANFRAGESTATUS_INVALID = 1;

  /**
   * Das angegebene Datum ist ungültig. 
   * <br/>ORCLI-Code: CL-04434
   */
  public static final int DATE_INVALID = 2;

  /**
   * Das Bis-Datum darf nicht vor dem Von-Datum liegen. 
   * <br/>ORCLI-Code: CL-04435
   */
  public static final int DATE_ORDER_WRONG = 3;

  /**
   * Das erfasste Suchkriterium lieferte keine Treffer in Bewilligungsanfragen. 
   * <br/>ORCLI-Code: CL-04412
   */
  public static final int NO_DATA_FOUND = 4;
}
