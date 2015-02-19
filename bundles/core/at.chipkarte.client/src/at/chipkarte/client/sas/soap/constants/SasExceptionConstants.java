/*
 * (C) SVC 2011
 */
package at.chipkarte.client.sas.soap.constants;

/**
 * Fachliche Fehlerkonstanten von SAS.
 */
public final class SasExceptionConstants {

  private SasExceptionConstants() {
  }

  /**
   * Zu den eingegebenen Suchkriterien konnte keine Person gefunden werden, für die eine e-card ausgestellt wurde.<br>
   * ORCLI-Code: ZS-08001
   */
  public static final int KEIN_TREFFER = 1;

  /**
   * Zu den eingegebenen Suchkriterien wurden mehrere Personen gefunden.<br>
   * ORCLI-Code: ZS-08002
   */
  public static final int MEHRERE_TREFFER = 2;

  /**
   * Die SV-Nummer existiert nicht oder ist nicht mehr gültig.<br>
   * ORCLI-Code: ZS-08003
   */
  public static final int NO_SVPERSON = 3;
  /**
   * Zum Patienten ist keine Adresse bekannt.<br>
   * ORCLI-Code: ZS-08004
   */
  public static final int ADRESSE_UNBEKANNT = 4;
  /**
   * Das Backend-Auskunftsservice steht derzeit nicht zur Verfügung. Bitte versuchen Sie es zu einem späteren Zeitpunkt erneut.<br>
   * ORCLI-Code: ZS-08005
   */
  public static final int BACKENDSYSTEM_NOT_AVAILABLE = 5;
  /**
   * Bei der Ermittlung der Adressdaten ist im Backend ein technischer Fehler aufgetreten. Bitte versuchen Sie es zu einem späteren
   * Zeitpunkt erneut.<br>
   * ORCLI-Code: ZS-08006
   */
  public static final int BACKENDSYSTEM_SYSTEM_ERROR = 6;
  /**
   * Bei der Ermittlung der Adressdaten ist im Backend ein technischer Fehler aufgetreten. Bitte versuchen Sie es zu einem späteren
   * Zeitpunkt erneut.<br>
   * ORCLI-Code: ZS-08007
   */
  public static final int BACKENDSYSTEM_SYSTEM_WARNING = 7;
  /**
   * Bei der Ermittlung der Adressdaten ist ein technischer Fehler aufgetreten.<br>
   * ORCLI-Code: ZS-08008
   */
  public static final int ADRESSABFRAGE_ERROR = 8;
}
