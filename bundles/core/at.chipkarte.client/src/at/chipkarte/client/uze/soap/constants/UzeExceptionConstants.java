/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap.constants;

/**
 * <p>
 * Fachliche Fehlerkonstanten von UZE.
 * </p>
 */
public class UzeExceptionConstants {
  /**
   * Die gesteckte Karte wird vom eCS nicht akzeptiert.<br>
   * ORCLI-Code: ZS-00044
   */
  public static final int INVALID_CARD_EXCEPTION = 1;

  /**
   * Die Signatur der gesteckten Karte ist ung&uuml;ltig.<br>
   * ORCLI-Code: ZS-00043
   */
  public static final int INVALID_SIGNATURE_EXCEPTION = 2;

  /**
   * F&uuml;r eine bewilligungspflichtige UZE liegt kein Bewilligungsschreiben vor. Die UZE kann nicht eingel&ouml;st werden. <br>
   * ORCLI-Code: ZS-06001
   */
  public static final int UZE_BEWILLIGUNG_MISSING = 3;

  /**
   * Der Vertragspartner kann keine UZE mit dem angegebenen Weisungstyp erstellen.<br>
   * ORCLI-Code: ZS-06002
   */
  public static final int WEISUNGSTYP_NOT_ALLOWED = 4;

  /**
   * Der angegebene Anspruch ist ungültig oder exisitert nicht (mehr).<br>
   * ORCLI-Code: ZS-06003
   */
  public static final int INVALID_ANSPRUCH = 5;

  /**
   * F&uuml;r den Patienten kann derzeit kein g&uuml;ltiger Krankenversicherungsanspruch festgestellt werden.<br>
   * ORCLI-Code: ZS-06005
   */
  public static final int NO_ANSPRUCH = 6;

  /**
   * Die SV-Person hat keinen g&uuml;ltigen Krankenversicherungsanspruch zum gew&auml;hlten SVT.<br>
   * ORCLI-Code: ZS-06007
   */
  public static final int NO_SUCH_ANSPRUCH = 7;

  /**
   * Keine Berechtigung f&uuml;r das Einl&ouml;sen von Einweisungen vorhanden. Nur Krankenanstalten k&ouml;nnen Einweisungen
   * einl&ouml;sen. <br>
   * ORCLI-Code: ZS-06009
   */
  public static final int MISSING_RIGHT_FOR_EINLOESUNG = 8;

  /**
   * Der Patient ist mehrfach versichert, ein SVT muss erfasst werden.<br>
   * ORCLI-Code: ZS-06010
   */
  public static final int NO_SVT_PROVIDED = 9;

  /**
   * Die SV-Nummer existiert nicht oder ist nicht mehr g&uuml;ltig.<br>
   * ORCLI-Code: ZS-06012
   */
  public static final int NO_SVPERSON = 10;

  /**
   * Der Weisungstyp "Zuweisungen ohne Patientenkontakt" ist f&uuml;r das angegebene Fachgebiet nicht zul&auml;ssig.<br>
   * ORCLI-Code: ZS-06013
   */
  public static final int WRONG_FACHGEBIET_FOR_ZO = 11;

  /**
   * Die Anzahl der gefundenen Treffer &uuml;berschreitet die maximal zul&auml;ssige Anzahl.<br>
   * ORCLI-Code: ZS-06014
   */
  public static final int MAX_RESULTS_EXCEEDED = 12;

  /**
   * Die ID der &Uuml;ber-/Zu-/Einweisung ist ung&uuml;ltig.<br>
   * ORCLI-Code: ZS-06015
   */
  public static final int INVALID_UZE_ID = 13;

  /**
   * Die Version der &Uuml;ber-/Zu-/Einweisung ist ung&uuml;ltig.<br>
   * ORCLI-Code: ZS-06016
   */
  public static final int INVALID_UZE_VERSION = 14;

  /**
   * Ver-/Entschl&uuml;sseln der medizinischen Daten ist fehlgeschlagen.<br>
   * ORCLI-Code: ZS-06017 ZS-06018 ZS-06019 ZS-06020
   */
  public static final int UZE_CRYPTO_ERROR = 15;

  /**
   * Die &Uuml;ber-/Zu-/Einweisung konnte nicht gespeichert werden wegen Problemen bei der Code-Generierung.<br>
   * ORCLI-Code: ZS-06022
   */
  public static final int UZE_CODE_ERROR = 16;

  /**
   * Die UZE kann nicht mehr eingel&ouml;st werden. (nicht im Status erstellt oder bereits abgelaufen).<br> 
   * ORCLI-Code: ZS-06023
   */
  public static final int UZE_NOT_REALIZABLE = 17;

  /**
   * Der &Auml;nderungszeitraum f&uuml;r die Modifizier-Funktion (&Auml;ndern, Stornieren, Storno r&uuml;cksetzen)
   * ist abgelaufen.<br>
   * ORCLI-Code: ZS-06024
   */
  public static final int MODIFYING_TIME_EXPIRED = 18;

  /**
   * Die gew&auml;hlte Ordination des Leistungserbringers wurde nicht gefunden.<br>
   * ORCLI-Code: ZS-06025
   */
  public static final int ORDINATION_LE_NOT_FOUND = 19;

  /**
   * Es existiert für den gewählten Leistungserbringer (Kombination aus OrdinationsID und TätigkeitsbereichID) 
   * kein gültiges Vertragsverhältnis für das (gewählte) Fachgebiet.<br>
   * ORCLI-Code: ZS_06026
   */
  public static final int NO_VERTRAG_FOR_FACHGEBIET = 20;

  /**
   * Die UZE kann mit den Fachgebieten des VP nicht eingel&ouml;st werden.<br>
   * ORCLI-Code: ZS-06027
   */
  public static final int INCOMPATIBLE_FACHGEBIET = 21;

  /**
   * Die Ordination des Vertragspartners entspricht nicht der Ordination des Leistungserbringers in der gespeicherten UZE.<br>
   * ORCLI-Code: ZS-06029
   */
  public static final int INCOMPATIBLE_ORDID = 22;

  /**
   * Für UZE mit dem Weisungstyp ZO kann das FG bei der Einlösung nicht verändert werden.<br>
   * ORCLI-Code: ZS-06031
   */
  public static final int FG_CHANGE_NOT_ALLOWED_FOR_WEISUNGSTYP = 23;

  /**
   * Die zur Abfrage der einlösbaren Über-/Zu-/Einweisung verwendete e-card wird nicht 
   * akzeptiert (gesperrt, abgelaufen).<br>
   * ORCLI-Code: ZS-06034
   */
  public static final int INVALID_TICKET_SIGNATURE = 24;

  /**
   * Das verwendete e-card Ticket passt nicht zur einzulösenden UZE.<br>
   * ORCLI-Code: ZS-06032
   */
  public static final int INVALID_TICKET_FOR_UZE = 25;

  /**
   * Der übergebene Code oder die übergebene SV-Nummer (nur möglich bei Anlage holen) 
   * stimmen nicht mit dem gespeicherten Daten der UZE überein.<br>
   * ORCLI-Code: ZS-06021
   */
  public static final int CODE_MISMATCH = 27;

  /**
   * Bei einer Suche nach einlösbaren Uzes mit Patientenkontakt mittels SV-Nummer und Code wurde
   * festgestellt, dass die betreffende Uze bereits eingelöst wurde.<br>
   * ORCLI-Code: ZS-06048
   */
  public static final int UZE_ALREADY_REALIZED = 29;

  /**
   * Bei einer Suche nach einlösbaren Uzes mit Patientenkontakt mittels SV-Nummer und Code wurde 
   * festgestellt, dass der Gültigkeitszeitraum abgelaufen ist.<br>
   * ORCLI-Code: ZS-06045
   */
  public static final int UZE_VALIDITY_EXPIRED = 30;

  /**
   * Bei einer Suche nach einlösbaren Uzes mit Patientenkontakt mittels SV-Nummer und Code wurde 
   * festgestellt, dass die betreffende Uze storniert wurde.<br>
   * ORCLI-Code: ZS-06046
   */
  public static final int UZE_CANCELED = 31;

  /**
   * Der gewählte Tätigkeitsbereich des Leistungserbringers wurde nicht gefunden.<br>
   * ORCLI-Code: ZS-06047
   */
  public static final int TAETIGKEITSBEREICH_LE_NOT_FOUND = 32;
}
