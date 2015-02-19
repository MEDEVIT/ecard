/*
 * (C) Siemens and SVCBE 2007
 */

package at.chipkarte.client.dmp.soap.constants;

/**
 * <p>
 * Fachliche Fehlerkonstanten von DMP.
 * </p>
 */
public final class DmpExceptionConstants {

  private DmpExceptionConstants() {
    // do not use
  }

  /**
   * Die gesteckte e-card wird vom e-card Serversystem nicht akzeptiert.<br>
   * ORCLI-Code: ZS-00044 (Text: CL-00053)
   */
  public static final int INVALID_CARD_EXCEPTION = 1;

  /**
   * SV-Person hat keinen gültigen Krankenversicherungsanspruch, eine Einschreibung über das e-card System ist daher nicht möglich.<br>
   * ORCLI-Code: ZS-02003
   */
  public static final int NO_ANSPRUCH_EXCEPTION = 2;

  /**
   * Eine Einschreibung zum gewählten Krankenversicherungsträger ist nicht möglich, aber zu einem anderen.<br>
   * ORCLI-Code: ZS-02004
   */
  public static final int NO_SUCH_CLAIM_EXCEPTION = 3;

  /**
   * Es muss ein Krankenversicherungsträger erfasst werden, weil die Einschreibung bei mehreren Krankenversicherungsträgern möglich
   * ist.<br>
   * ORCLI-Code: ZS-02005
   */
  public static final int NO_SVT_PROVIDED_EXCEPTION = 4;

  /**
   * Ein ASVG-Krankenversicherungsträger muss erfasst werden, weil die Einschreibung bei mehreren ASVG-Krankenversicherungsträgern
   * möglich ist. Einer der SVTs muss ausgewählt werden. Die zur Auswahl stehenden SVTs werden in der Exception geliefert.<br>
   * ORCLI-Code: ZS-02008
   */
  public static final int NO_ASVG_SVT_PROVIDED_EXCEPTION = 5;

  /**
   * Es existiert kein gültiger Vertrag des Vertragspartners mit dem Fachgebiet und dem Krankenversicherungsträger der SV-Person.<br>
   * ORCLI-Code: ZS-02011
   */
  public static final int NO_VERTRAG_EXCEPTION = 7;

  /**
   * Die Anzahl der gefundenen Treffer überschreitet die maximal zulässige Anzahl. Bitte schränken Sie die Suchkriterien weiter ein.<br>
   * ORCLI-Code: ZS-02025
   */
  public static final int MAX_RESULT_EXCEEDED = 11;

  /**
   * Es konnte kein gültiges Betreuungsverhältnis für das gewählte Programm gefunden werden.<br>
   * ORCLI-Code: ZS-02019
   */
  public static final int NO_BETR_VERH_FOUND_EXCEPTION = 12;

  /**
   * Es gibt keine Therapie Aktiv Einschreibung bei Ihnen für das gewählte Programm. Ausschreibung ist daher nicht möglich.<br>
   * ORCLI-Code: ZS-02020
   */
  public static final int NO_BETR_VERH_AUSSCHREIBUNG_EXCEPTION = 13;

  /**
   * Die SV-Nummer ist im e-card System nicht bekannt.<br>
   * ORCLI-Code: ZS-02002
   */
  public static final int SV_NUMMER_NOT_EXISTS = 14;
  
  /**
   * Es gibt bereits eine Therapie Aktiv Einschreibung für das gewählte Programm in der Vergangenheit. 
   * Ersteinschreibung ist daher nicht möglich, jedoch eine Wiedereinschreibung.<br>
   * ORCLI-Code: ZS-02026
   */
  public static final int E_NOT_POSSIBLE_BUT_W = 15;
  
  /**
   * Es gibt aktuell keine Therapie Aktiv Einschreibung für das gewählte Programm, jedoch eine in der Vergangenheit. 
   * Arztwechsel ist daher nicht möglich, jedoch eine Wiedereinschreibung.<br>
   * ORCLI-Code: ZS-02027
   */
  public static final int A_NOT_POSSIBLE_BUT_W = 16;
  
  /**
   * Es gibt aktuell eine Therapie Aktiv Einschreibung mit einem anderen Vertragspartner für das gewählte Programm. 
   * &lt;Einschreibeart&gt; ist daher nicht möglich, jedoch ein Arztwechsel.<br>
   * ORCLI-Code: ZS-02028
   */
  public static final int EINSCHREIBEART_NOT_POSSIBLE_BUT_A = 17;
  
  /**
   * Es gibt aktuell eine Therapie Aktiv Einschreibung bei Ihnen für das gewählte Programm. 
   * &lt;Einschreibeart&gt; ist daher nicht möglich.<br>
   * ORCLI-Code: ZS-02029
   */
  public static final int EINSCHREIBEART_NOT_POSSIBLE = 18;
  
  /**
   * Es gibt noch keine Therapie Aktiv Einschreibung für das gewählte Programm. 
   * lt;Einschreibeartgt; ist daher nicht möglich, jedoch eine Ersteinschreibung.<br>
   * ORCLI-Code: ZS-02030
   */
  public static final int EINSCHREIBEART_NOT_POSSIBLE_BUT_E = 19;
  
}
