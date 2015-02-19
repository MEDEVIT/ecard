/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

import at.chipkarte.client.base.soap.SvPersonV2;

/**
 * Enthält die Daten zu einer (nacherfassten) Konsultation.
 */
public class Konsultationsdaten {

  private KonsultationsBeleg _konsultationsBeleg;
  private SvPersonV2 _versichertenDaten;
  private SvPersonV2 _angehoerigenDaten;

  public void setAngehoerigenDaten(SvPersonV2 angehoerigenDaten) {
    _angehoerigenDaten = angehoerigenDaten;
  }

  public void setKonsultationsBeleg(KonsultationsBeleg konsultationsBeleg) {
    _konsultationsBeleg = konsultationsBeleg;
  }

  public void setVersichertenDaten(SvPersonV2 versichertenDaten) {
    _versichertenDaten = versichertenDaten;
  }

  /**
   * Konsultationsbeleg in bestimmter Version.
   * @return Konsultationsbeleg
   */
  public KonsultationsBeleg getKonsultationsBeleg() {
    return _konsultationsBeleg;
  }

  /**
   * Versichertendaten des Patienten, der diese Konsultation in Anspruch genommen hat.
   * @return Versichertendaten der SV-Person
   */

  public SvPersonV2 getVersichertenDaten() {
    return _versichertenDaten;
  }

  /**
   * Daten des Versicherten, von dem sich der vorliegende Anspruch ableitet. Null, wenn es sich um keinen abgeleiteten
   * Anspruch handelt. <br>
   * Die Felder Geschlecht und Geburtsdatum im Objekt SV-Person werden nicht versorgt.
   * @return Angehörigendaten
   */

  public SvPersonV2 getAngehoerigenDaten() {
    return _angehoerigenDaten;
  }

}
