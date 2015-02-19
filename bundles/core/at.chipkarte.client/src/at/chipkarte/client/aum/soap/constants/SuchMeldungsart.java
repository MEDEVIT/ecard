/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap.constants;

/**
 * <p>
 * Konstanten für die Meldungsarten nach denen gesucht werden kann.
 * </p>
 */
public class SuchMeldungsart {
  /**
   * Konstante für offene Meldungen, Meldungen ohne gesetztes <i>ArbeitsunfaehigBis</i> beziehungsweise 
   * bei denen <i>ArbeitsunfaehigBis</i> nach dem aktuellen Datum liegt.
   */
  public static final String OFFEN = "OF";
  /**
   * Konstante für geschlossene Meldungen, Meldungen bei denen <i>ArbeitsunfaehigBis</i> 
   * vor dem aktuellen Datum liegt.
   */
  public static final String GESCHLOSSEN = "GE";
  /**
   * Konstante für alle Meldungen.
   */
  public static final String ALLE = "AL";
}
