/*
 * (C) Siemens and SVCBE 2004
 */
package at.chipkarte.client.aum.soap;

/**
 * Beschreibt einen am elektronischen Arbeitsunfähigkeitsmeldungsservice (AUM) teilnehmenden KVT.
 * Rückgabewert der Funktion {@link IAumService#getSVTs(String)}.
 */
public class AufSvtProperty {
  private String _svtCode;
  private String _ekvkName;
  private String _ekvkCode;
  private String _kurzbezeichnung;
  private Boolean _isAsvg;
  private String _ausgehzeitVon1;
  private String _ausgehzeitBis1;
  private String _ausgehzeitVon2;
  private String _ausgehzeitBis2;
  
  /**
   * Ende der Standardausgehzeit 1 des KVT.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 01 und 24
   * @return Ende der Standardausgehzeit 1
   */
  public String getAusgehzeitBis1() {
    return _ausgehzeitBis1;
  }
  public void setAusgehzeitBis1(String ausgehzeitBis1) {
    _ausgehzeitBis1 = ausgehzeitBis1;
  }
  /**
   * Ende der Standardausgehzeit 2 des KVT.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 01 und 24
   * @return Ende der Standardausgehzeit 2
   */
  public String getAusgehzeitBis2() {
    return _ausgehzeitBis2;
  }
  public void setAusgehzeitBis2(String ausgehzeitBis2) {
    _ausgehzeitBis2 = ausgehzeitBis2;
  }
  /**
   * Beginn der Standardausgehzeit 1 des KVT.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 00 und 23
   * @return Beginn der Standardausgehzeit 1
   */
  public String getAusgehzeitVon1() {
    return _ausgehzeitVon1;
  }
  public void setAusgehzeitVon1(String ausgehzeitVon1) {
    _ausgehzeitVon1 = ausgehzeitVon1;
  }
  /**
   * Beginn der Standardausgehzeit 2 des KVT.
   * <br>Format: 2-stellig
   * <br>mögliche Werte: ganze Stunden, zwischen 00 und 23
   * @return Beginn der Standardausgehzeit 2
   */
  public String getAusgehzeitVon2() {
    return _ausgehzeitVon2;
  }
  public void setAusgehzeitVon2(String ausgehzeitVon2) {
    _ausgehzeitVon2 = ausgehzeitVon2;
  }
  /**
   * EKVK-Code des KVT.
   * <br>Format: maximal 10-stellig
   * @return EKVK-Code des KVT
   */
  public String getEkvkCode() {
    return _ekvkCode;
  }
  public void setEkvkCode(String ekvkCode) {
    _ekvkCode = ekvkCode;
  }
  /**
   * EKVK-Name des KVT.
   * <br>Format: maximal 15-stellig
   * @return EKVK-Name des KVT
   */
  public String getEkvkName() {
    return _ekvkName;
  }
  public void setEkvkName(String ekvkName) {
    _ekvkName = ekvkName;
  }
  /**
   * Gibt an, ob es sich um einen GKK/BKK-Träger handelt.
   * @return Kennzeichen, ob es sich um einen GKK/BKK-Träger handelt
   */
  public Boolean isAsvg() {
    return _isAsvg;
  }
  public void setAsvg(Boolean isAsvg) {
    _isAsvg = isAsvg;
  }
  /**
   * Kurzbezeichnung des KVT.
   * <br>Format: maximal 15-stellig
   * @return Kurzbezeichnung des KVT
   */
  public String getKurzbezeichnung() {
    return _kurzbezeichnung;
  }
  public void setKurzbezeichnung(String kurzbezeichnung) {
    _kurzbezeichnung = kurzbezeichnung;
  }
  /**
   * Code des KVT. 
   * <br>Format: 2-stellig
   * @return Code des KVT
   */
  public String getSvtCode() {
    return _svtCode;
  }
  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }
}
