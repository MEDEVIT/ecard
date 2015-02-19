/*
 * (C) SVC 2012
 */
package at.chipkarte.client.kse.soap.exceptions;

import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;
import at.chipkarte.client.kse.soap.Anspruch;

/**
 * Exception-Inhalt.
 */
public class KseExceptionContent extends BaseExceptionContent {

  private Anspruch[] _anspruch = null;

  /**
   * Bei Angabe eines nicht eindeutigen Anspruchs / KVT des Anspruches werden in bestimmten Fällen der
   * Mehrfachversicherung beziehungsweise bei abgeleiteten Ansprüchen die zur Auswahl stehenden Ansprüche in der Exception mitgeliefert.
   * @return Objekt vom Typ Anspruch[] - Anspruchsdaten des Patienten (Mehrfachansprüche oder abgeleitete Ansprüche)
   */
  public Anspruch[] getAnspruch() {
    return _anspruch;
  }

  public void setAnspruch(Anspruch[] anspruch) {
    this._anspruch = anspruch;
  }

}
