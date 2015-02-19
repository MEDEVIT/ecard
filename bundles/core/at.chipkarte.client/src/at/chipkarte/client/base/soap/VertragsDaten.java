/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der 
 * österreichischen Sozialversicherungsträger. 
 * Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Enthält Daten zum Vertrag eines Vertragspartners.
 */
//since the desired property order is not alphabetic, we have to define it manually
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vertragsDaten", propOrder = {
    "bezBereich",
    "fachGebietsCode",
    "konsultationsrecht",
    "leistungsSVT",
    "ordId",
    "rezepturrecht",
    "verrechnungsSVT",
    "taetigkeitsBereichId",
    "vertragsTyp"
})
public class VertragsDaten {

  @XmlTransient
  private String _leistungsSVT;
  @XmlTransient
  private String _fachGebietsCode;
  @XmlTransient
  private String _bezBereich;
  @XmlTransient
  private String _vertragsTyp;
  @XmlTransient
  private String _verrechnungsSVT;
  @XmlTransient
  private Boolean _rezepturrecht;
  @XmlTransient
  private Boolean _konsultationsrecht;
  @XmlTransient
  private String _ordId;
  @XmlTransient
  private String _taetigkeitsBereichId;

  /**
   * 
   * Angabe, ob für den Vertrag das Konsultationsrecht besteht. 
   * <br>Wenn nein, können mit
   * diesem Vertrag keine Konsultationen durchgeführt werden.
   * @return Konsultationsrecht
   */
  @XmlElement
  public Boolean isKonsultationsrecht() {
    return _konsultationsrecht;
  }

  /**
   * Angabe, ob für den Vertrag das Rezepturrecht besteht. 
   * <br>Wenn nein, wird eine ABS 
   * Bewilligungsanfrage abgelehnt.
   * @return Rezepturrecht
   */
  @XmlElement
  public Boolean isRezepturrecht() {
    return _rezepturrecht;
  }

  /**
   * 
   * Code des verrechnungszuständigen Krankenversicherungsträgers für den Vertrag.
   * <br>Format: 2-stellig
   * @return verrechnungszuständiger Krankenversicherungsträger
   */
  @XmlElement
  public String getVerrechnungsSVT() {
    return _verrechnungsSVT;
  }

  public void setKonsultationsrecht(Boolean konsultationsrecht) {
    _konsultationsrecht = konsultationsrecht;
  }

  public void setRezepturrecht(Boolean rezepturrecht) {
    _rezepturrecht = rezepturrecht;
  }

  public void setVerrechnungsSVT(String verrechnungssvt) {
    _verrechnungsSVT = verrechnungssvt;
  }

  /**
   * Code des leistungszuständigen Krankenversicherungsträgers für den Vertrag, siehe auch
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getSVTs() getSVTs()}. 
   * <br>Format: 2-stellig
   * @return leistungszuständiger Krankenversicherungsträger
   */
  @XmlElement
  public String getLeistungsSVT() {
    return _leistungsSVT;
  }

  public void setLeistungsSVT(String leistungsSVT) {
    _leistungsSVT = leistungsSVT;
  }

  /**
   * Fachgebietscode für den Vertrag, siehe auch
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getFachgebiete() getFachgebiete()}.
   * <br>Format: 2-stellig
   * @return Fachgebietscode
   */
  @XmlElement
  public String getFachGebietsCode() {
    return _fachGebietsCode;
  }

  public void setFachGebietsCode(String fachGebietsCode) {
    _fachGebietsCode = fachGebietsCode;
  }

  /**
   * Bezugsbereich des Vertrags.
   * <br>Mögliche Werte: {@link at.chipkarte.client.base.soap.constants.Bezugsbereich Bezugsbereich}.
   * @return Bezugsbereich
   */
  @XmlElement
  public String getBezBereich() {
    return _bezBereich;
  }

  public void setBezBereich(String bezBereich) {
    _bezBereich = bezBereich;
  }
  
  /**
   * Typ des Vertrags.
   * <br>Mögliche Werte: siehe {@link at.chipkarte.client.base.soap.constants.Vertragstyp Vertragstyp}.
   * @return Vertragstyp
   */
  @XmlElement
  public String getVertragsTyp() {
    return _vertragsTyp;
  }

  public void setVertragsTyp(String vertragsTyp) {
    _vertragsTyp = vertragsTyp;
  }

  /**
   * 
   * Ordinations-Id derjenigen Ordination, an die der Vertrag gebunden ist.
   * @return Ordinations-Id 
   */
  @XmlElement
  public String getOrdId() {
    return _ordId;
  }

  public void setOrdId(String ordId) {
    _ordId = ordId;
  }

  /**
   * Kennzeichnung des Tätigkeitsbereichs, an den der Vertrag gebunden ist. 
   * @return Kennzeichnung des Tätigkeitsbereichs.
   */
  @XmlElement
  public String getTaetigkeitsBereichId() {
    return _taetigkeitsBereichId;
  }
  
  public void setTaetigkeitsBereichId(String taetigkeitsBereichId) {
    _taetigkeitsBereichId = taetigkeitsBereichId;
  }


}