/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.abs.soap;

import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Enthält die Parameter zum
 * {@link at.chipkarte.client.abs.soap.IAbsService#sendenFolgeverordnung(String, FolgeverordnungsAusstellungsParameter, String)
 * Ausstellen einer Folgeverordnung}.
 * <p>
 * Optionale Felder dürfen den Wert <code>null</code> oder, im Fall von Strings, einen Leerstring zurückliefern. Pflichtfelder
 * dürfen weder <code>null</code> noch einen Leerstring zurückliefern. Felder, die nicht explizit als optional gekennzeichnet sind,
 * sind Pflichtfelder.
 * </p>
 */

@XmlType(name = "folgeverordnungsAusstellungsParameter", propOrder = {
    "SVNRPatient",
    "SVTCode",
    "beantragteAbgabemenge",
    "medikamentName",
    "pharmanummer"
})
public class FolgeverordnungsAusstellungsParameter {
  private String _sVTCode;
  private Integer _beantragteAbgabemenge;
  private String _sVNRPatient;
  private String _medikamentName;
  private String _pharmanummer;

  /**
   * Beantragte Abgabemenge (Packungsanzahl) des verschriebenen Medikaments. 
   * <br/>Format: [1..99]
   * @return Beantragte Abgabemenge
   */
  public Integer getBeantragteAbgabemenge() {
    return _beantragteAbgabemenge;
  }

  /**
   * Eindeutiger Code des leistungszuständigen Krankenversicherungsträgers.
   * <br/>Mögliche Werte siehe
   * {@link at.chipkarte.client.abs.soap.IAbsService#getSVTs() getSVTs}. 
   * <br/>Optional
   * <br/>Format: 2-stellig, numerisch
   * @return Code des leistungszuständigen Krankenversicherungsträgers
   */
  public String getSVTCode() {
    return _sVTCode;
  }

  public void setBeantragteAbgabemenge(Integer beantragteAbgabemenge) {
    _beantragteAbgabemenge = beantragteAbgabemenge;
  }

  public void setSVTCode(String code) {
    _sVTCode = code;
  }

  /**
   * Eindeutiger Name des Medikaments. 
   * <br/>Format: maximal 100-stellig 
   * <br/>Die Angabe des Medikamentennamens ist optional. Wird er nicht angegeben, muss jedoch die {@link #getPharmanummer() Pharmanummer} 
   * angegeben werden. Wird der Medikamentenname angegeben, darf die {@link #getPharmanummer() Pharmanummer} nicht angegeben werden. 
   * <br/><br/>Es wird nur dann eine Langzeitbewilligung gefunden, wenn der Medikamentenname folgender Bildungsvorschrift 
   * entspricht: 
   * <br/>Feldaufbau laut Datensatzbeschreibung DEKO: 
   * <br/>&lt;Kurzname&gt; + " " + &lt;Mengenangabe&gt; + " " +&lt;Mengenart&gt;
   * <br/><br/>
   * Wenn die einzelnen Felder (Kurzname, Mengenangabe und Mengenart) am Anfang und am Ende Leerzeichen ("Blanks") 
   * enthalten, müssen diese weggetrimmt werden! Leerzeichen innerhalb des Kurznamens dürfen nicht getrimmt werden!
   * Beispiel: 
   * <br/>Medikamentenname = "<code>VIAGRA FTBL&nbsp;&nbsp;25MG 4 ST</code>"
   * <br/>Der Kurzname laut DEKO = "<code>VIAGRA FTBL&nbsp;&nbsp;25MG</code>"
   * <br/>Da im Kurznamen selbst zwischen <code>FTBL</code> und <code>25MG</code> zwei Leerzeichen vorhanden sind, werden 
   * diese nicht mit weggetrimmt!
   * @return Medikamentenname
   */
  public String getMedikamentName() {
    return _medikamentName;
  }

  /**
   * Pharmanummer des Medikaments. 
   * <br/>Format: maximal 9-stellig, numerisch 
   * <br/>Die Pharmanummer muss den Regeln für Pharmanummern (Prüfziffer) entsprechen. 
   * <br/>Die Angabe der Pharmanummer ist optional. Wird sie nicht angegeben, muss jedoch der {@link #getMedikamentName() Medikamentname}
   *  angegeben werden. Wird die Pharmanummer angegeben, darf der {@link #getMedikamentName() Medikamentname} nicht angegeben werden. 
   * @return Pharmanummer
   */
  public String getPharmanummer() {
    return _pharmanummer;
  }

  /**
   * Sozialversicherungsnummer des Patienten, für den das Bestehen einer Langzeitbewilligung abgefragt wird. 
   * <br/>Format: 10-stellig 
   * <br/>Die Angabe der SVNR des Patienten ist optional. Wird keine SVNR angegeben, muss eine e-card gesteckt sein.
   * Wird eine SVNR angegeben und ist gleichzeitig eine e-card gesteckt, wird die e-card ignoriert. D.h. soll explizit die e-card 
   * verwendet werden, darf dieser Parameter nicht angegeben werden.
   * @return Sozialversicherungsnummer
   */
  public String getSVNRPatient() {
    return _sVNRPatient;
  }

  public void setMedikamentName(String medikamentName) {
    _medikamentName = medikamentName;
  }

  public void setPharmanummer(String pharmanummer) {
    _pharmanummer = pharmanummer;
  }

  public void setSVNRPatient(String patient) {
    _sVNRPatient = patient;
  }

}