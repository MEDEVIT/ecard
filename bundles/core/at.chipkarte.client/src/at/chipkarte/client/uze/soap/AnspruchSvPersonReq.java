/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

/**
 * Enth&auml;lt die Eingangsdaten zum Aufruf der Funktion acquireAnspruchSvPerson.
 */
public class AnspruchSvPersonReq {
  private String _anspruchId;
  private String _behandlungsKontext;
  private String _fachgebietLe;
  private Boolean _kblKennzeichen;
  private String _ordinationsIdLe;
  private String _taetigkeitsbereichIdLe;
  private String _svtCode;
  private String _svNummer;
  private String _weisungsTyp;

  /**
   * ID des eigenen Anspruchs oder eines abgeleiteten Anspruchs, welcher bei einem vorherigen Aufrufs dieser Funktion
   * in einer der {@link at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException UzeAnspruchException}
   * zur&uuml;ckgeliefert wurde.<br>
   * Die Angabe der AnspruchsId ist optional.<br/>
   * Wird ignoriert, wenn KblKennzeichen NEIN.<br>
   * Wenn SvtCode angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * @return AnspruchId
   */
  public String getAnspruchId() {
    return _anspruchId;
  }

  /**
   * Code des Behandlungskontexts der UZE.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BehandlungsKontext BehandlungsKontext}.<br>
   * Format: 2-stellig.
   * @return BehandlungsKontext
   */
  public String getBehandlungsKontext() {
    return _behandlungsKontext;
  }

  /**
   * Fachgebiet, zu dem zugewiesen wird.<br>
   * Format: 2-stellig.
   * @return FachgebietLe
   */
  public String getFachgebietLe() {
    return _fachgebietLe;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt.<br>
   * @return kblKennzeichen
   */
  public Boolean isKblKennzeichen() {
    return _kblKennzeichen;
  }

  /**
   * Ordinations ID des Leistungserbringers.<br>
   * Die Angabe der OrdinationsIdLe ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @return OrdinationsIdLe
   */
  public String getOrdinationsIdLe() {
    return _ordinationsIdLe;
  }
  
  /**
   * Tätigkeitsbereich-ID des Leistungserbringers.<br>
   * Die Angabe der TaetigkeitsbereichIdLe ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @return TaetigkeitsbereichIdLe
   */
  public String getTaetigkeitsbereichIdLe() {
    return _taetigkeitsbereichIdLe;
  }  

  /**
   * Code des SVT der SV-Person.<br>
   * Die Angabe des SvtCode ist optional.<br/>
   * Wird ignoriert, wenn KblKennzeichen NEIN.<br>
   * Wenn AnspruchId angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Format: 2-stellig.
   * @return SvtCode
   */
  public String getSvtCode() {
    return _svtCode;
  }

  /**
   * SV-Nummer der SV-Person.<br>
   * Die Angabe der SV-Nummer ist optional.<br/>
   * Wenn eine e-card gesteckt ist und eine Sv-Nummer eingegeben ist, wird die e-card ignoriert.
   * Ist eine AnspruchId angegeben, muss eine SV- Nummer angegeben sein.<br>
   * Format: 10-stellig.
   * @return SvNummer
   */
  public String getSvNummer() {
    return _svNummer;
  }

  /**
   * Weisungstyp der UZE.<br>
   * Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: 2-stellig.
   * @return WeisungsTyp
   */
  public String getWeisungsTyp() {
    return _weisungsTyp;
  }

  /**
   * ID des eigenen Anspruchs oder eines abgeleiteten Anspruchs, welcher bei einem vorherigen Aufrufs dieser Funktion
   * in einer der {@link at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException UzeAnspruchException}
   * zur&uuml;ckgeliefert wurde.<br>
   * Die Angabe der AnspruchId ist optional.<br/>
   * Wird ignoriert, wenn KblKennzeichen NEIN.<br>
   * Wenn SvtCode angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * @param anspruchId Der zu setzende Wert f&uuml;r AnspruchId.
   */
  public void setAnspruchId(String anspruchId) {
    _anspruchId = anspruchId;
  }

  /**
   * Code des Behandlungskontexts der UZE.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.BehandlungsKontext BehandlungsKontext}.<br>
   * Format: 2-stellig.
   * @param behandlungsKontext Der zu setzende Wert f&uuml;r BehandlungsKontext.
   */
  public void setBehandlungsKontext(String behandlungsKontext) {
    _behandlungsKontext = behandlungsKontext;
  }

  /**
   * Fachgebiet, zu dem zugewiesen wird.<br>
   * Format: 2-stellig.
   * @param fachgebietLe Der zu setzende Wert f&uuml;r FachgebietLe.
   */
  public void setFachgebietLe(String fachgebietLe) {
    _fachgebietLe = fachgebietLe;
  }

  /**
   * Kennzeichen, ob es sich um eine Krankenbehandlungsleistung handelt.<br>
   * @param kblKennzeichen Der zu setzende Wert f&uuml;r KblKennzeichen.
   */
  public void setKblKennzeichen(Boolean kblKennzeichen) {
    _kblKennzeichen = kblKennzeichen;
  }

  /**
   * Ordinations ID des Leistungserbringers.<br>
   * Die Angabe der OrdinationsIdLe ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @param ordinationsIdLe Der zu setzende Wert f&uuml;r OrdinationsIdLe.
   */
  public void setOrdinationsIdLe(String ordinationsIdLe) {
    _ordinationsIdLe = ordinationsIdLe;
  }
  
  /**
   * Tätigkeitsbereich-ID des Leistungserbringers.<br>
   * Die Angabe der TaetigkeitsbereichIdLe ist optional.<br/>
   * Wird ignoriert, wenn Weisungstyp &lt;&gt; Zuweisung ohne Patientenkontakt.<br>
   * Muss angegeben sein, wenn Weisungstyp = Zuweisung ohne Patientenkontakt.<br>
   * Format: maximal 19-stellig.
   * @param taetigkeitsbereichIdLe Der zu setzende Wert f&uuml;r TaetigkeitsbereichIdLe.
   */
  public void setTaetigkeitsbereichIdLe(String taetigkeitsbereichIdLe) {
    _taetigkeitsbereichIdLe = taetigkeitsbereichIdLe;
  }

  /**
   * Code des SVT der SV-Person.<br>
   * Die Angabe des SvtCode ist optional.<br/>
   * Wird ignoriert, wenn KblKennzeichen NEIN.<br>
   * Wenn AnspruchId angegeben ist, darf dieses Feld nicht bef&uuml;llt sein.<br>
   * Format: 2-stellig.
   * @param svtCode Der zu setzende Wert f&uuml;r SvtCode.
   */
  public void setSvtCode(String svtCode) {
    _svtCode = svtCode;
  }

  /**
   * SV-Nummer der SV-Person.<br>
   * Die Angabe von SV-Nummer ist optional.<br/>
   * Wenn keine AnspruchId angegeben ist und eine e-card gesteckt ist, wird die Eingabe nicht ignoriert 
   * (SV-Nummer der e-card wird nicht verwendet). Ist eine AnspruchId angegeben, muss eine SV- Nummer angegeben sein.<br>
   * Format: 10-stellig.
   * @param svNummer Der zu setzende Wert f&uuml;r SvNummer.
   */
  public void setSvNummer(String svNummer) {
    _svNummer = svNummer;
  }

  /**
   * Weisungstyp der UZE.<br>
   * Entspricht der abzul&ouml;senden Scheinart.<br>
   * Mögliche Werte siehe {@link at.chipkarte.client.uze.soap.constants.WeisungsTyp WeisungsTyp}.<br>
   * Format: 2-stellig.
   * @param weisungsTyp Der zu setzende Wert f&uuml;r WeisungsTyp.
   */
  public void setWeisungsTyp(String weisungsTyp) {
    _weisungsTyp = weisungsTyp;
  }
}
