/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Enthält die Daten zum Tätigkeitsbereich (der Ausprägung) des Vertragspartners. 
 */
//since the desired property order is not alphabetic, we have to define it manually
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taetigkeitsBereich", propOrder = {
    "id",
    "code",
    "anzeigeText"
})
public class TaetigkeitsBereich {

  @XmlTransient
  private String _id;
  @XmlTransient
  private String _code;
  @XmlTransient
  private String _anzeigeText;
  
  /**
   * ID des Tätigkeitsbereichs.
   * <br>Format: maximal 19-stellig
   * @return Kennzeichnung
   */
  @XmlElement
  public String getId() {
    return _id;
  }
  
  /**
   * Codebezeichner des Tätigkeitsbereichs.
   * <br>Mögliche (momentanen) Werte:<br>
   * <table cellspacing="0">
   *    <tr><td><b>Code</b></td><td><b>Bedeutung</b></td></tr>
   *    <tr><td>ARZT</td><td>Arzt</td></tr>
   *    <tr><td>HBHM</td><td>Heilbehelfe und Hilfsmittel</td></tr>
   *    <tr><td>HLLF</td><td>Hilfs- Liefer-  Leihfirma</td></tr>
   *    <tr><td>TRANSPORT</td><td>Rettungsdienste, Beförderungsgewerbe</td></tr>
   *    <tr><td>APOTH</td><td>öffentliche Apotheke</td></tr>
   *    <tr><td>GRPPX</td><td>Gruppenpraxis</td></tr>
   *    <tr><td>OEFFKASTA</td><td>öffentliche Krankenanstalt</td></tr>
   *    <tr><td>PRIVKASTA</td><td>private Krankenanstalt</td></tr>
   *    <tr><td>KASTAABT</td><td>Abteilung einer Krankenanstalt</td></tr>
   *    <tr><td>MSE</td><td>medizinische oder sonstige Einrichtung</td></tr>
   *    <tr><td>MSEABT</td><td>Abteilung einer medizinischen oder sonstigen Einrichtung</td></tr>
   *    <tr><td>VERB</td><td>Verbund</td></tr>
   *    <tr><td>SONST</td><td>Sonstige</td></tr>
   * </table>
   * <br/><i><u>Hinweis:</u></i> Die Tabelle der möglichen Werte unterliegt nicht der Garantie auf Vollständigkeit. 
   * Eine Erweiterung der möglichen Werte ist jederzeit (ohne Hebung der Schnittstelle, ohne Releasewechsel) möglich!
   * <br> 
   * Die Ermittlung der möglichen durchführbaren Funktionen des Vertragspartners sollte 
   * daher immer auf der aktuellen Rechte-Situation des Vertragspartners aufsetzen 
   * (siehe Funktion {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getBerechtigungen(String) getBerechtigungen}.)</i>
   * 
   * @return Code
   */
  @XmlElement
  public String getCode() {
    return _code;
  }
  
  /**
   * Anzeigetext des Tätigkeitsbereichs. Zum Beispiel Arzt, Apotheke, usw.
   * @return Anzeigetext
   */
  @XmlElement
  public String getAnzeigeText() {
    return _anzeigeText;
  }
  
  public void setId(String id) {
    _id = id;
  }
  
  public void setCode(String code) {
    _code = code;
  }
  
  public void setAnzeigeText(String anzeigeText) {
    _anzeigeText = anzeigeText;
  }

}