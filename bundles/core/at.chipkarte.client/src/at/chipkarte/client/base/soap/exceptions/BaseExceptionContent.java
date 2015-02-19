/*
 * (C) SVC 2011
 */
package at.chipkarte.client.base.soap.exceptions;

/**
 * Basisklasse für alle Exception-Inhalte.
 */
// Darf von zu werfenden Exceptions nicht direkt verwendet werden, da sonst der Empfänger (Axis 1) ggf.
// nicht zwischen den verschiedenen Exceptions unterscheiden kann.
public class BaseExceptionContent {

  private String _code;
  private Integer _errorCode;
  private String _message;

  /**
   * Code der spezifischen SS12-Exception.
   * Format: maximal 3-stellig
   * @return SS12-Fehlercode
   */
  public String getCode() {
    return _code;
  }

  public void setCode(String code) {
    _code = code;
  }

  /**
   * Code der (korrespondierenden GUI-) Text-Fehlermeldung.
   * Format: maximal 10-stellig
   * @return Fehlercode der Textmeldung
   */
  public Integer getErrorCode() {
    return _errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    _errorCode = errorCode;
  }

  /**
   * Fehlertext inklusive ursprünglicher Fehlernummer.
   * <br>Format: maximal 512-stellig
   * @return Fehlertext 
   */
  public String getMessage() {
    return _message;
  }

  public void setMessage(String message) {
    _message = message;
  }

}
