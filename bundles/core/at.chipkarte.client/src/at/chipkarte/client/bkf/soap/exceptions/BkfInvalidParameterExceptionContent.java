/*
 * (C) SVC 2012
 */
package at.chipkarte.client.bkf.soap.exceptions;

import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;

/**
 * Exception-Inhalt.
 */
public class BkfInvalidParameterExceptionContent extends BaseExceptionContent {
  /**
   * Konstante, die anzeigt, dass der <code>fieldCode</code> ung&uuml;ltig ist.
   */
  public static final int INVALID_FIELD_CODE = -1;
  private Integer _fieldCode = INVALID_FIELD_CODE;
  private Boolean _fieldCodeSet = Boolean.FALSE;

  /**
   * Eindeutige Id des Datenfeldes, auf das sich die Fehlermeldung bezieht. Diese Id
   * scheint in der Dokumentation der Datenstrukturen bei den Zugriffsfunktionen
   * als ParameterID auf. Falls
   * sich die Fehlermeldung auf mehrere Datenfelder bezieht, enthält dieses Feld
   * einen ung&uuml;ltigen Wert. Ob die Id g&uuml;ltig ist, kann mit {@link #isFieldCodeSet()}
   * festgestellt werden.
   * @return - Id des Datenfelds.
   */
  public Integer getFieldCode() {
    return _fieldCode;
  }
  /**
   * Setzt die Id des Datenfeldes (siehe {@link #getFieldCode()}).
   * @param fieldCode - Id des Datenfeldes
   */
  public void setFieldCode(Integer fieldCode) {
    _fieldCode = fieldCode;
  }
  /**
   * Gibt an, ob <code>fieldCode</code> einen g&uuml;ltigen Wert enth&auml;lt.
   * @return <code>true</code> falls <code>fieldCode</code> g&uuml;ltig ist;
   * andernfalls <code>false</code>.
   */
  public Boolean getFieldCodeSet() {
    return _fieldCodeSet;
  }
  
  public void setFieldCodeSet(Boolean fieldCodeSet) {
     _fieldCodeSet = fieldCodeSet;
  }
}
