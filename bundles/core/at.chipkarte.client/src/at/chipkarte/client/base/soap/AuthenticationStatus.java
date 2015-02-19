/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

/**
 * Enthält Daten über den Authentifizierungsstatus eines Dialogs.<br>
 * Im Offline-Modus wird nur das Attribut <i>FailedPINAttempts</i> versorgt.
 */
public class AuthenticationStatus {

  private Integer _failedLoginAttempts = 0;
  private String _lastLoginDate = "";
  private Integer _failedPINAttempts = 0;

  /**
   * Anzahl der fehlerhaften PIN-Eingaben seit der letzten gültigen PIN-Eingabe.
   * @return Anzahl fehlerhafte PIN-Eingaben
   */
  public Integer getFailedPINAttempts() {
    return _failedPINAttempts;
  }

  public void setFailedPINAttempts(Integer failedPINAttempts) {
    _failedPINAttempts = failedPINAttempts;
  }

  public AuthenticationStatus() {
    _failedLoginAttempts = 0;
    _lastLoginDate = "";
  }

  /**
   * Anzahl der fehlgeschlagenen Login-Versuche seit dem letzten erfolgreichen Login. Dieser Wert wird ausschließlich im 
   * Online-Modus geliefert.
   * @return Anzahl Login Fehlversuche
   */
  public Integer getFailedLoginAttempts() {
    return _failedLoginAttempts;
  }

  /**
   * Zeitpunkt des letzten erfolgreichen Logins. Dieser Wert wird ausschließlich im Online-Modus geliefert. <br>
   * Format: TT.MM.JJJJ hh:mm
   * @return Zeitpunkt des letzten erfolgreichen Logins
   */
  public String getLastLoginDate() {
    return _lastLoginDate;
  }

  public void setLastLoginDate(String lastLoginDate) {
    _lastLoginDate = lastLoginDate;
  }

  public void setFailedLoginAttempts(Integer failedLoginAttempts) {
    _failedLoginAttempts = failedLoginAttempts;
  }

}
