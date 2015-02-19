/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.kse.soap.constants;

/**
 * Fehlerkonstanten, die im Zusammenhang mit Konsultationen vom e-card Serversystem geliefert
 * werden. Fehlercodes siehe
 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants KseExceptionConstants}.
 *  
 */
public class KseExceptionConstants {

  /**
   * Die gesteckte Karte wird vom e-card Serversystem nicht akzeptiert.
   * <br/>ORCLI-Code: CL-00020, Cl-00053 (ZS-00044) 
   */
  public static final int INVALID_CARD_EXCEPTION = 1;

  /**
   * Gewählter abgeleiteter KV-Anspruch ist nicht mehr gültig.
   * <br/>ORCLI-Code: ZS-00011
   */
  // at.siemens.ecard.server.kse.api.exceptions.InvalidClaimException (ZS-00011)
  public static final int INVALID_CLAIM_EXCEPTION = 2;

  /**
   * Die Signatur ist ungültig.
   * <br/>ORCLI-Code: CL-00020, Cl-00053 (ZS-00043)
   */
  // at.siemens.ecard.server.base.exceptions.InvalidSignatureException (ZS-00043)
  public static final int INVALID_SIGNATURE_EXCEPTION = 3;

  /**
   * Fachgebietscode ist am e-card Serversystem nicht gültig.
   * <br/>ORCLI-Code: ZS-00006
   */
  // at.siemens.ecard.server.kse.api.exceptions.InvalidSpecialismException (ZS-00006);
  public static final int INVALID_SPECIALISM_EXCEPTION = 4;

  /**
   * Der Patient hat keinen gültigen Krankenversicherungsanspruch.
   * <br/>ORCLI-Code: ZS-00007
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoKVALeistungsAnspruchException (ZS-00007);
  public static final int NO_KVA_LEISTUNGSANSPRUCH_EXCEPTION = 5;

  /**
   * Alle erlaubten Erstkonsultationen für das angegebene Fachgebiet und den angegebenen KVT wurden
   * bereits verbraucht.
   * <br/>ORCLI-Code: CL-00062, CL-00079, CL-00088 (ZS-00015, ZS-00081) 
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoLeistungsAnspruchForFachgebietException (ZS-00015)
  public static final int NO_LEISTUNGSANSPRUCH_FOR_FACHGEBIET_EXCEPTION = 6;

  /**
   * Alle erlaubten Erstkonsultationen für die Fachgebietsgruppe und den angegebenen KVT wurden
   * bereits verbraucht.
   * <br/>ORCLI-Code: CL-00062, CL-00079, CL-00088 (ZS-00016, ZS-00082) 
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoLeistungsAnspruchForFachgruppeException (ZS-00016)
  public static final int NO_LEISTUNGSANSPRUCH_FOR_FACHGRUPPE_EXCEPTION = 7;

  /**
   * Der Patient hat keinen gültigen Krankenversicherungsanspruch zum gewählten KVT.
   * <br/>ORCLI-Code: ZS-00009
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoSuchClaimException (ZS-00009);
  public static final int NO_SUCH_CLAIM_EXCEPTION = 8;

  /**
   * Es existiert kein gültiger Vertragspartner-Anspruch.
   * <br/>ORCLI-Code: ZS-00013
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoVPAnspruchException (ZS-00013)
  public static final int NO_VPANSPRUCH_EXCEPTION = 9;

  /**
   * Es existiert kein gültiger Vertragspartner-Vertrag zum KVT des Patienten.
   * <br/>ORCLI-Code: ZS-00003
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoVPAnspruchForSVTException (ZS-00003);
  public static final int NO_VPANSPRUCH_FOR_SVT_EXCEPTION = 10;

  /**
   * Es liegt eine Mehrfachversicherung vor  KVT muss erfasst werden. Die zur Auswahl stehenden
   * Ansprüche ({@link at.chipkarte.client.kse.soap.Anspruch}) werden in bestimmten Fällen der
   * Mehrfachversicherung bzw. bei abgeleiteten Ansprüchen in der Exception mitgeliefert. Siehe dazu
   * auch das Vertragspartner-Benutzerhandbuch des aktuellen Release,  Kapitel "Patient hat
   * mehrere KV-Ansprüche".
   * <br/>ORCLI-Code: ZS-00027, ZS-00037
   */
  // at.siemens.ecard.server.kse.api.exceptions.ProvideSVTException (ZS-00027)
  public static final int NO_SVT_PROVIDED_EXCEPTION = 11;

  /**
   * Gewähltes Fachgebiet ist überweisungsgebunden.
   * <br/>ORCLI-Code: ZS-00017
   */
  // at.siemens.ecard.server.kse.api.exceptions.ReferralRequiredException (ZS-00017)
  public static final int REFERERALL_REQUIRED_EXCEPTION = 13;

  /**
   * Einer der abgeleiteten Ansprüche muss ausgewählt werden. Die zur Auswahl stehenden Ansprüche (
   * {@link at.chipkarte.client.kse.soap.Anspruch}) werden in der Exception geliefert.
   * <br/>ORCLI-Code: ZS-00010
   */
  // at.siemens.ecard.server.kse.api.exceptions.SelectAnspruchException (ZS-00010, ZS-00037)
  public static final int NO_ANSPRUCH_PROVIDED_EXCEPTION = 14;

  /**
   * Das Behandlungsdatum liegt außerhalb des gültigen Bereichs.
   * <br/>ORCLI-Code: ZS-00005
   */
  // at.siemens.ecard.server.kse.api.exceptions.DateOutOfRangeException (ZS-00005)
  public static final int DATE_OUT_OF_RANGE_EXCEPTION = 15;

  /**
   * Das angegeben Behandlungsdatum liegt in der Zukunft.
   * <br/>ORCLI-Code: ZS-00020
   */
  // at.siemens.ecard.server.kse.api.exceptions.TreatmentDateInFutureException (ZS-00020)
  public static final int TREATMENT_DATE_IN_FUTURE_EXCEPTION = 16;

  /**
   * Das angegebene Bearbeitungsdatum liegt in der Zukunft.
   * <br/>ORCLI-Code: ZS-00033
   */
  // at.siemens.ecard.server.kse.api.exceptions.DateInFutureException (ZS-00033)
  public static final int DATE_IN_FUTURE_EXCEPTION = 17;

  /**
   * Die Suchfunktion
   * {@link at.chipkarte.client.kse.soap.IKseService#getKonsultationsdaten(java.lang.String, at.chipkarte.client.kse.soap.SuchFilter, java.lang.String) getKonsultationsdaten}
   * kann nicht synchron durchgeführt werden. 
   * <br/>ORCLI-Code: ZS-00052
   */
  // at.siemens.ecard.server.kse.api.exceptions.SyncRequestNotPossibleException (ZS-00052)
  public static final int SYNC_SUCHANFRAGE_NOT_AVAIL = 20;

  /**
   * Die angeforderte Id zum Download der Konsultationsdaten konnte am e-card Server nicht gefunden
   * werden.
   * <br/>ORCLI-Code: ZS-00054
   */
  // at.siemens.ecard.server.kse.api.exceptions.RequestIdNotFoundFoundException (ZS-00054)
  public static final int ASYNC_REQUEST_ID_NOT_FOUND = 21;

  /**
   * Der Download für die angeforderte Id steht am e-card Serversystem noch nicht bereit.
   * <br/>ORCLI-Code: ZS-00055
   */
  // at.siemens.ecard.server.kse.api.exceptions.RequestNotProcessedException (ZS-00055)
  public static final int ASYNC_REQUEST_NOT_PROCESSED = 22;

  /**
   * Bei der Bearbeitung der Suchanfrage ist am e-card Serversystem ein Fehler aufgetreten, daher
   * gibt es kein Ergebnis zu der Suchanfrage.
   * <br/>ORCLI-Code: ZS-00060
   */
  // at.siemens.ecard.server.kse.api.exceptions.RequestProcessingErrorException (ZS-00060)
  public static final int ASYNC_REQUEST_ERROR = 23;

  /**
   * Das nötige Alter wurde für den gewählten Behandlungsfall noch nicht erreicht.
   * <br/>ORCLI-Code: ZS-00061
   */
  // at.siemens.ecard.server.kse.api.exceptions.AgeNotReachedException (ZS-00061)
  public static final int AGE_NOT_REACHED = 25;

  /**
   * Es existiert keine passende Vorsorgekonsultation zum Behandlungsfall VU Folgetermin.
   * <br/>ORCLI-Code: ZS-00063
   */
  //  at.siemens.ecard.server.kse.api.exceptions.NoVAMatchingConsultationException (ZS-00063)
  public static final int NO_VA_MATCHING_KONSULTATION = 28;

  /**
   * Der Zeitabstand seit der letzten Konsultation mit diesem Behandlungsfall ist für den Patienten zu gering.
   * <br/>ORCLI-Code: ZS-00064
   */
  // at.siemens.ecard.server.kse.api.exceptions.TimeNotElapsedException (ZS-00064)
  public static final int TIME_NOT_ELAPSED = 29;

  /**
   * Die Konsultation wurde von einem anderen Benutzer geändert.
   * <br/>ORCLI-Code: ZS-00012
   *  
   */
  // at.siemens.ecard.server.kse.api.exceptions.ConcurrentUpdateException (ZS-00012)
  public static final int KONSULTATION_CHANGED = 101;

  /**
   * Die Konsultation ist bereits storniert.
   * <br/>ORCLI-Code: ZS-00023
   *  
   */
  // at.siemens.ecard.server.kse.api.exceptions.AlreadyCancelledException (ZS-00023)
  public static final int KONSULTATION_ALREADY_CANCELLED = 102;

  /**
   * Das Zurücksetzen des Stornos ist nicht möglich, da die Konsultation nicht den Status storniert
   * hat.
   * <br/>ORCLI-Code: ZS-00024
   *  
   */
  // at.siemens.ecard.server.kse.api.exceptions.NotCancelledException (ZS-00024)
  public static final int KONSULTATION_NOT_CANCELLED = 103;

  /**
   * Der ausgewählte Behandlungsfall ist für das ausgewählte Fachgebiet nicht erlaubt.
   * <br/>ORCLI-Code: ZS-00025, ZS-00062
   * 
   */
  // at.siemens.ecard.server.kse.api.exceptions.InvalidTreatmentCaseCodeException (ZS-00025)
  // at.siemens.ecard.server.kse.api.exceptions.NoValidBfFgAssignmentException (ZS-00062)
  public static final int INVALID_BEHANDLUNGSFALL = 104;

  /**
   * Es wurde kein neuer Behandlungsfall ausgewählt. Zu dieser Konsultation wurden keine Änderungen
   * gespeichert.
   * <br/>ORCLI-Code: ZS-00026
   */
  // at.siemens.ecard.server.kse.api.exceptions.SameTreatmentCaseException (ZS-00026)
  public static final int SAME_BEHANDLUNGSFALL = 105;

  /**
   * 
   * Die Konsultation existiert nicht.
   * <br/>ORCLI-Code: ZS-00040
   */
  // at.siemens.ecard.server.kse.api.exceptions.NoSuchKonsultationException (ZS-00040)
  public static final int NO_SUCH_KONSULTATION = 106;

  /**
   * Die Anzahl der maximal erlaubten Konsultationen für die Suchanfrage wurde überschritten.
   * <br/>ORCLI-Code: CL-00210
   */
  public static final int MAX_KONSULTATIONEN_EXCEEDED = 108;

  /**
   * Die Aufbewahrungsfrist für Offlinekonsultationen ist überschritten.
   * <br/>ORCLI-Code: CL-A0030
   */
  public static final int OFFLINE_FRIST_EXCEEDED = 109;

  /**
   * Offlinedaten werden zurzeit von einem anderen Anwender bearbeitet/übertragen.
   * <br/>ORCLI-Code: CL-00197
   */
  public static final int OFFLINETRANSFER_ALREADY_IN_PROCESS = 110;

  /**
   * Die Anzahl der maximal erlaubten Suchanfragen ist überschritten.
   * <br/>ORCLI-Code: ZS-00053
   */
  // at.siemens.ecard.server.kse.api.exceptions.AsyncRequestNotPossibleException (ZS-00053)
  public static final int MAX_SUCHANFRAGEN_EXCEEDED = 111;

  /**
   * Das Zurücksetzen des Stornos ist nicht möglich, da sich der FG-Quartalsanspruch geändert hat und keine zusätzliche
   * Anspruchsnutzung, zum KVT der stornierten Konsultation genehmigt ist.
   * Hinweis zum FG-Quartalsanspruch: Bei der ersten
   * Konsultation innerhalb eines FG und des aktuellen Quartals muss sich der Patient, bei Mehrfachversicherung bei ASVG-Kassen,
   * für einen der Ansprüche entscheiden. Nur der ausgewählte Anspruch, die Sonderversicherungsträger-Ansprüche und zusätzlich
   * genehmigte Ansprüche werden für die Anspruchsprüfung verwendet. Zusätzlich genehmigte Anspruchsnutzung: Über die Onlineservices
   * kann für einen Patienten, vom entsprechenden KVT, eine zusätzliche Anspruchsnutzung eines ASVG-Anspruchs für das FG und das
   * aktuelle Quartal genehmigt werden.
   * <br/>ORCLI-Code: ZS-00065
   */
  public static final int INEXISTENT_ANSPRUCH_FOR_RESET = 112;

  /**
   * Aufgrund einer Systemeinstellung ist die Verwendung der Offline-KSE-Funktionalität nicht erlaubt.
   * <br/>ORCLI-Code: CL-00259
   */
  public static final int OFFLINE_NOT_ALLOWED = 113;

  /**
   * Es besteht kein Versicherungsschutz für die Zahnbehandlung - nur auf Kassenrezept. Die Zahnbehandlung kann nur gegen
   * Privathonorar erfolgen.
   * <br/>ORCLI-Code: ZS-00050
   */
  public static final int ANSPRUCH_FOR_ZAHNBEHANDLUNG_NOT_ALLOWED = 114;

  /**
   * Der Patient ist nur für Vorsorgeuntersuchungen und für Leistungen aus dem Mutter-Kind-Pass Programm anspruchsberechtigt.
   * <br/>ORCLI-Code: ZS-00051
   */
  public static final int ANSPRUCH_ONLY_FOR_VU_MKP_ALLOWED = 115;
  
  /**
   * Der Patient besitzt nicht das benötigte Geschlecht für diesen Behandlungsfall.
   * <br/>ORCLI-Code: ZS-00076
   */
  public static final int BEHANDLUNGSFALL_FOR_GENDER_NOT_ALLOWED = 120;

  /**
   * Der Patient hat die zulässige Anzahl an Lebensmonaten für diesen Behandlungsfall überschritten.
   * <br/>ORCLI-Code: ZS-00077
   */
  public static final int BEHANDLUNGSFALL_FOR_AGE_NOT_ALLOWED = 121;

  /**
   * Es wurden keine Konsultationen zum Nachsignieren vorgefunden.
   * <br/>ORCLI-Code: ZS-00085
   */
  public static final int NO_KONSULTATION_FOR_SIGNING_FOUND = 122;
  
  /**
   * Es ist ein technisches Problem bei der Verarbeitung des SW-Zertifikats aufgetreten. 
   * Bitte melden Sie einen neuen Dialog mit der Ordinationskarte an um die Offline-Funktionalität nutzen zu können.
   * Hinweis: Nur bei Verwendung eines SW-Zertifikats im Offline-Modus zur Authentifizierung oder Signierung eines Requests:
   * <ul>
   * <li>es ist kein SW-Zertifikat am Client vorhanden</li>
   * <li>das SW-Zertifikat am Client ist defekt</li>
   * <li>das SW-Zertifikat ist abgelaufen</li>
   * </ul>
   * ORCLI-Code: CL-00273, CL-00275, CL-00276
   */
  public static final int CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED = 123;  
  
  /**
   * Für die angegebene Zusatzinformationsantwort-Id wurde bereits eine Antwort übermittelt.
   * <br/>ORCLI-Code: ZS-00092
   */
  public static final int ZUSATZINFO_ANTWORTID_ALREADY_USED = 124;
  
  /**
   * Die Konsultation zu der die Zusatzinformationen angezeigt wurden, 
   * wurde durch einen anderen Vertragspartner erfasst.
   * <br/>ORCLI-Code: ZS-00091
   */
  public static final int ZUSATZINFO_ANTWORTID_NOT_ALLOWED = 125;
  
  /**
   * Die angegebene Zusatzinformationsantwort-Id ist nicht bekannt.
   * <br/>ORCLI-Code: ZS-00090
   */
  public static final int ZUSATZINFO_ANTWORTID_INVALID = 126;
  
  /**
   * Die e-card wird nicht akzeptiert (als gestohlen oder verloren gemeldet). 
   * Bitte informieren Sie den Inhaber und überprüfen Sie dessen Identität.
   * <br/>ORCLI-Code: ZS-00099
   */
  public static final int INVALID_CARD_LOST_STOLEN_CHECK_PATIENT = 127;
  
  /**
   * Die e-card wird nicht akzeptiert (gesperrt, abgelaufen). 
   * Bitte informieren Sie den Inhaber und überprüfen Sie dessen Identität.
   * <br/>ORCLI-Code: ZS-00100
   */
  public static final int INVALID_CARD_CHECK_PATIENT = 128;
  
  /**
   * Die e-card wird nicht akzeptiert (als gestohlen oder verloren gemeldet).
   * <br/>ORCLI-Code: ZS-00101
   */
  public static final int INVALID_CARD_LOST_STOLEN = 129;
  
  /**
   * Die Buchung der Konsultation ist nicht möglich, da kein aktuell gültiger VM-Leistungsanspruch vorhanden ist.
   * <br/>ORCLI-Code: ZS-00107
   */
  public static final int NO_EINLADUNG_FOR_BKF_VM = 130;  
  
  /**
   * Die Buchung der Konsultation ist nicht möglich, da der aktuelle VM-Leistungsanspruch durch die Übermittlung einer Screeningdokumentation bereits in Anspruch genommen wurde.
   * <br/>ORCLI-Code: ZS-00108
   */
  public static final int NO_OPEN_EINLADUNG_FOR_BKF_VM = 131;  
  
  /**
   * Die Buchung der Konsultation ist nicht möglich, da bereits eine VM Erstkonsultation bei Ihnen oder bei einem anderen Vertragspartner erfasst wurde.
   * <br/>ORCLI-Code: ZS-00109
   */
  public static final int OTHER_VM_EXIST = 132;
  
  /**
   * Die Stornierung der Konsultation ist nicht möglich, da zu dieser Konsultation bereits eine Dokumentation des Brustkrebsfrüherkennungsservice übermittelt wurde.
   * <br/>ORCLI-Code: ZS-00110
   */
  public static final int NO_STORNO_POSSIBLE = 133;  
  
  /**
   * Die Änderung der Konsultation ist nicht möglich, da zu dieser Konsultation bereits eine Dokumentation des Brustkrebsfrüherkennungsservice übermittelt wurde.
   * <br/>ORCLI-Code: ZS-00111
   */
  public static final int NO_CHANGE_POSSIBLE = 134;  
    
}