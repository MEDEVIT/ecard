/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap.constants;

/**
 * Fehlerkonstanten, die im Rahmen des STS Service vom e-card Serversystem
 * geworfen werden. Fehlercodes siehe
 * {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants StsExceptionConstants}.
 */
public class StsExceptionConstants {

  /**
   * Die gesteckte Karte wird vom e-card Serversystem nicht akzeptiert. <br>
   * ORCLI-Code: CL-00020, CL-00053 (ZS-00044)
   */
  public static final int INVALID_CARD_EXCEPTION = 1;

  /**
   * Die Signatur der gesteckten Karte ist ungültig. <br>
   * ORCLI-Code: CL-00020, CL-00053 (ZS-00043)
   */
  public static final int INVALID_SIGNATURE_EXCEPTION = 2;

  /**
   * Es ist keine Konfiguration für die im Ticketnamen angegebene Ticketversion
   * vorhanden. <br>
   * ORCLI-Code: ZS-07008
   */
  public static final int TICKETNAME_INVALID_NO_CONFIG_FOR_VERSION = 5;

  /**
   * Die SV-Nummer existiert nicht oder ist nicht mehr gültig. <br>
   * ORCLI-Code: ZS-07015
   */
  public static final int NO_SVPERSON = 6;

  /**
   * Die geforderte Mindestqualität des Patientenkontaktes für das angeforderte
   * Ticket konnte nicht bestätigt werden. (Mindestqualität: {Qualität}) <br>
   * ORCLI-Code: ZS-07106
   */
  public static final int PATIENT_CONTACT_QUALITY_VIOLATION = 7;

  /**
   * Das Signieren des generierten Tickets ist fehlgeschlagen. <br>
   * ORCLI-Code: ZS-07205
   */
  public static final int ASSERTION_SIGNING_FAILED = 8;

  /**
   * Es existiert keine Berechtigung zur Ausstellung des angeforderten Tickets.
   * Für die ermittelte Rolle des Vertragspartners wird die Ausstellung des
   * angeforderten Tickets nicht erlaubt.<br>
   * ORCLI-Code: ZS-07018
   */
  public static final int NO_QUALIFICATION_FOR_REQUEST_ASSERTION = 10;

  /**
   * Mit dem angegebenen Ticketsubject wurde keine Konfiguration gefunden. <br>
   * ORCLI-Code: ZS-07107
   */
  public static final int TICKETSUBJECT_INVALID_NO_CONFIG_AVAILABLE = 14;
  
  /**
   * Das Ticket besitzt keinen gültigen Status (darf nicht mehr
   * verwendet werden). <br>
   * ORCLI-Code: ZS-07108
   */
  public static final int TICKETSUBJECT_INVALID_WRONG_TICKET_STATE = 15;
  }
  
