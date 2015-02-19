/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap.constants;

/**
 * <p>
 * Konstanten für den Verarbeitungsstatus der Anfrage.
 * </p>
 */
public final class AnfrageStatus {
  /**
   * Konstante für den Verarbeitungsstatus "Eingereicht".
   */
  public static final String EINGEREICHT = "Ein";
  /**
   * Konstante für den Verarbeitungsstatus "In Bearbeitung".
   */
  public static final String IN_BEARBEITUNG = "Ueb";
  /**
   * Konstante für den Verarbeitungsstatus "Bearbeitet".
   */
  public static final String BEARBEITET = "Bea";
  /**
   * Konstante für den Verarbeitungsstatus "Abgelehnt".
   */
  public static final String ABGELEHNT = "Abg";

  private AnfrageStatus() {
    // do not use
  }
}
