/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap;

/**
 * Enthält die zusätzlichen Informationen zu einem Patienten und fordert den Vertragspartner (in Abhängigkeit des Parameters
 * AntwortAnzeigeBedingung) zur Durchführung einer bestimmten Aktion auf.
 */

public class Zusatzinformation {

  private Long _zusatzinformationsAntwortId;
  private String _svtCode;
  private String _zusatzinformationsText;
  private Integer _antwortAnzeigeBedingung;
  
  /**
   * Eindeutige ID zur Identifikation der übermittelten Zusatzinformation. 
   * <br/>Format: Long (numerisch)
   * @return ID der Zusatzinformation.
   */
  public Long getZusatzinformationsAntwortId() {
    return _zusatzinformationsAntwortId;
  }

  /**
   * Zuständiger KVT für die Zusatzinformation (Ansprechpartner).
   * <br/>Mögliche Werte siehe Funktion {@link at.chipkarte.client.base.soap.IBaseService#getSVTs() getSVTs} 
   * <br/>Format: 2-stellig
   * @return KVT-Code.
   */
  public String getSvtCode() {
    return _svtCode;
  }
  
  /**
   * Meldungstext, der im Rahmen der Zusatzinformationsanforderung angezeigt werden soll.
   * <br/>Format: maximal 180-stellig
   * @return Zusatzinformations-Text.
   */
  public String getZusatzinformationsText() {
    return _zusatzinformationsText;
  }

  /**
   * Angabe zur Anzeige der Antwortmöglichkeiten auf Zusatzinformationen.
   * <br/>Mögliche Werte siehe {@link at.chipkarte.client.kse.soap.constants.AntwortAnzeigeBedingung AntwortAnzeigeBedingung}
   * @return AntwortAnzeigeBedingung.
   */
  public Integer getAntwortAnzeigeBedingung() {
    return _antwortAnzeigeBedingung;
  }

  public void setZusatzinformationsAntwortId(Long zusatzinformationsAntwortId) {
    _zusatzinformationsAntwortId = zusatzinformationsAntwortId;
  }

  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
  
  public void setZusatzinformationsText(String zusatzinformationsText) {
    _zusatzinformationsText = zusatzinformationsText;
  }

  public void setAntwortAnzeigeBedingung(Integer antwortAnzeigeBedingung) {
    _antwortAnzeigeBedingung = antwortAnzeigeBedingung;
  }
}
