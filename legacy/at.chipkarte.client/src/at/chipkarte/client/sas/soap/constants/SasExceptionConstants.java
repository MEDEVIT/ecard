/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.sas.soap.constants;

/**
 * Fachliche Fehlerkonstanten von SAS.
 */
public class SasExceptionConstants {

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
}
