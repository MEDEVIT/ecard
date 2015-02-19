/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.uze.soap;

/**
 * Enthält die Medikament-Codierungen die der Vertragspartner im Zuge der 
 * Erstellung einer Über-/Zu-/Einweisung erfasst.
 */
public class MedikamentCode {
  
  private String _codierungsystem;
  private String _codebezeichner;
  private String _codebeschreibung;
  
  /**
   * Verwendetes Codierungsystem<br/>
   * Format: maximal 2-stellig.
   * @return codierungsystem
   */
  public String getCodierungsystem() {
    return _codierungsystem;
  }
  
  /**
   * Der eigentliche Code<br/>
   * Format: maximal 7-stellig.
   * @return codebezeichner
   */
  public String getCodebezeichner() {
    return _codebezeichner;
  }
  
  /**
   * Die Beschreibung zum angegebenen Codebezeichner<br/>
   * Format: maximal 500-stellig.
   * @return codebeschreibung
   */
  public String getCodebeschreibung() {
    return _codebeschreibung;
  }
  
  /**
   * Verwendetes Codierungsystem<br/>
   * Format: maximal 2-stellig.
   * @param codierungsystem Der zu setzende Wert f&uuml;r Benennung das verwendete Codierungsystem.
   */
  public void setCodierungsystem(String codierungsystem) {
    _codierungsystem = codierungsystem;
  }
  
  /**
   * Der eigentliche Code<br/>
   * Format: maximal 7-stellig.
   * @param codebezeichner Der zu setzende Wert f&uuml;r Inhalt des eigentlichen Codes.
   */
  public void setCodebezeichner(String codebezeichner) {
    _codebezeichner = codebezeichner;
  }
  
  /**
   * Die Beschreibung zum angegebenen Codebezeichner<br/>
   * Format: maximal 500-stellig.
   * @param codebezeichner Der zu setzende Wert f&uuml;r Inhalt der Beschreibung zum angegebenen Codebezeichner.
   */
  public void setCodebeschreibung(String codebeschreibung) {
    _codebeschreibung = codebeschreibung;
  }

}
