/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.abs.soap.constants;

/**
 * Konstanten für die Entscheidung des chefärztlichen Dienstes bezüglich einer {@link at.chipkarte.client.abs.soap.Verordnung
 * Verordnung}&nbsp; in einer {@link at.chipkarte.client.abs.soap.BewilligungsAnfrage BewilligungsAnfrage}.
 */
public final class VerordnungsEntscheidung {

  private VerordnungsEntscheidung() {
    // do not use
  }

  /**
   * Die Verordnung wurde ohne Änderungen bewilligt.
   */
  public static final String BEWILLIGUNG = "Bewilligung";

  /**
   * Die Verordnung wurde mit Änderungen durch den Chefarzt bewilligt.
   */
  public static final String BEWILLIGUNG_MIT_AENDERUNGEN = "Bewilligung mit Aenderungen";

  /**
   * Die Verordnung wurde abgelehnt.
   */
  public static final String ABLEHNUNG = "Ablehnung";

  /**
   * Die Verordnung ist kassenfrei.
   */
  public static final String KASSENFREI = "Kassenfrei";

  /**
   * Die Verordnung wurde vom Chefarzt nicht bearbeitet. Das bedeutet, dass das Medikament zwar dokumentationspflichtig ist, aber
   * nicht chefarztpflichtig. D.h. der Arzt muss einen Antrag stellen (zur Dokumentation), dieser wird aber weder genehmigt noch
   * abgelehnt, sondern eben nicht bearbeitet.
   */
  public static final String KEINE_BEARBEITUNG = "Keine Bearbeitung";

}