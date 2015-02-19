/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.sas.soap.constants;

/**
 * Fehlerkonstanten für falsche übergebene Suchkriterien.
 */
public class InvalidParameterSuchkriterienExceptionConstants {

  /**
   * Familienname ist ein Pflichtfeld. <br>
   * ORCLI-Code: CL-04001
   */
  public static final int FAMILIENNAME_NICHT_BEFUELLT = 1;

  /**
   * Länge der Eingabedaten für Familienname ist nicht im zulässigen Bereich. <br>
   * ORCLI-Code: CL-04002
   */
  public static final int FAMILIENNAME_ZU_LANG = 2;

  /**
   * Unzulässiges Eingabeformat für Familienname. <br>
   * ORCLI-Code: CL-04003
   */
  public static final int FAMILIENNAME_UNGUELTIG = 3;

  /**
   * Vorname ist ein Pflichtfeld. <br>
   * ORCLI-Code: CL-04011
   */
  public static final int VORNAME_NICHT_BEFUELLT = 4;

  /**
   * Länge der Eingabedaten für Vorname ist nicht im zulässigen Bereich. <br>
   * ORCLI-Code: CL-04012
   */
  public static final int VORNAME_ZU_LANG = 5;

  /**
   * Unzulässiges Eingabeformat für Vorname. <br>
   * ORCLI-Code: CL-04013
   */
  public static final int VORNAME_UNGUELTIG = 6;

  /**
   * Geburtsdatum ist ein Pflichtfeld. <br>
   * ORCLI-Code: CL-08001
   */
  public static final int GEBURTSDATUM_NICHT_BEFUELLT = 7;

  /**
   * Unzulässiger Wert oder Eingabeformat des Geburtsdatums. <br>
   * ORCLI-Code: CL-08002
   */
  public static final int GEBURTSDATUM_UNGUELTIG = 8;

  /**
   * Der Wert in SV-Nummer ist ungültig oder fehlt. <br>
   * ORCLI-Code: CL-08003
   */
  public static final int INVALID_SV_NUMBER = 9;
}
