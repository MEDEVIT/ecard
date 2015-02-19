/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap.constants;

/**
 * Konstanten zur Anzeige der Antwortmöglichkeiten auf Zusatzinformationen.
 */
public class AntwortAnzeigeBedingung {

  /**
   * Der Vertragspartner wird in der Zusatzinformation zu einer Aktion aufgefordert, auf die er mit ja oder nein antworten muss.
   */
  public static final int JA_NEIN = 1;

  /**
   * Der Vertragspartner wird in der Zusatzinformation über einen Sachverhalt informiert. Es ist keine ja/nein Antwortmöglichkeit
   * anzuzeigen. Es ist jedoch der Erhalt bwz. die Kenntnisnahme des Sachverhalts zu bestätigen  mittels Übermittlung der
   * Zusatzinformationsantwort mit der Antwort gleich ja.
   */
  public static final int HINWEISERHALTEN_ZURKENNTNISGENOMMEN = 2;

}
