package at.chipkarte.client.prop.soap;

/**
 * Die Fachinformation beinhaltet die fachlichen Parameter für die Erfassung eines Präoperativen Befundes.
 */
public class Fachinformation {
  private Integer _version;
  private AnamneseGruppe[] _anamneseGruppe;
  private String _versionGiltSeit;
  /**
   * Version der Fachinformation.<br>
   * Format: 3-stellig
   * @return Version
   */
  public Integer getVersion() {
    return _version;
  }
  public void setVersion(Integer version) {
    _version = version;
  }
  /**
   * Daten der {@link AnamneseGruppe Anamnesegruppen}.
   * @return Anamnesegruppen
   */
  public AnamneseGruppe[] getAnamneseGruppe() {
    return _anamneseGruppe;
  }
  public void setAnamneseGruppe(AnamneseGruppe[] anamneseGruppe) {
    _anamneseGruppe = anamneseGruppe;
  }
  
  /**
   * Datum seit dem die Version Gültigkeit hat.<br>
   * Format: TT.MM.JJJJ
   * @return Datum der Gültigkeit
   */
  public String getVersionGiltSeit() {
    return _versionGiltSeit;
  }
  public void setVersionGiltSeit(String versionGiltSeit) {
    _versionGiltSeit = versionGiltSeit;
  }
  

}
