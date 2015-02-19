/*
 * (C) Siemens and SVCBE 2012
 */
package at.chipkarte.client.bkf.soap.constants;

/**
 * <p>
 * Fehlerkonstanten, wenn ein ung&uuml;ltiger Parameter in einer Funktion angegeben wird.
 * </p>
 */
public class BkfInvalidParameterExceptionConstants {
  /**
   * Es ist weder eine e-card gesteckt, noch eine gültige SV-Nummer angegeben. <br/>
   * ORCLI-Code: CL-1800002
   */
  public static final int SVNR_MISSING_NO_ECARD = 14;
  /**
   * Es muss entweder eine Konsultation oder ein Leistungsdatum angegeben werden. <br/>
   * ORCLI-Code: CL-1800011
   */
  public static final int KONSULTATION_OR_LEISTUNGSDATUM_REQUIRED = 15;
  /**
   * Es konnte kein aktuell zertifizierter Arzt zum angegebenen Arzt-Identifikator gefunden werden. <br/>
   * ORCLI-Code: CL-1890090
   */
  public static final int NO_PARTICIPANT_FOUND = 16;
  /**
   * Identifikation Erstbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801111
   */
  public static final int SCR_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED = 17;
  /**
   * Der Wert in SV-Nummer ist ungültig. <br/>
   * ORCLI-Code: CL-1890014
   */
  public static final int SV_NUMMER_INVALID = 18;
  /**
   * Das Format von Identifikation Erstbefunder ist ungültig. <br/>
   * ORCLI-Code: CL-1801113
   */
  public static final int SCR_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT = 19;
  /**
   * Der Wert in Identifikation Erstbefunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1801114
   */
  public static final int SCR_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND = 20;
  /**
   * Versionsnummer ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1890031
   */
  public static final int VERSION_REQUIRED = 21;
  /**
   * Der Wert in Versionsnummer ist ungültig. <br/>
   * ORCLI-Code: CL-1890034
   */
  public static final int VERSION_INVALID = 22;
  /**
   * Konsultation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1890041
   */
  public static final int KONSULTATION_REQUIRED = 23;
  /**
   * Der Wert in Konsultation ist ungültig. <br/>
   * ORCLI-Code: CL-1890044
   */
  public static final int KONSULTATION_INVALID = 24;
  /**
   * Das Format von Leistungsdatum ist ungültig. <br/>
   * ORCLI-Code: CL-1890063
   */
  public static final int LEISTUNGSDATUM_WRONG_FORMAT = 25;
  /**
   * Der Wert in Leistungsdatum ist ungültig. <br/>
   * ORCLI-Code: CL-1890064
   */
  public static final int LEISTUNGSDATUM_INVALID = 26;
  /**
   * Der Wert in Leistungsdatum ist ungültig. (Es muss eine Konsultation angegeben werden, die Angabe eines Leistungsdatums ist
   * nicht zulässig). <br/>
   * ORCLI-Code: CL-1890065
   */
  public static final int LEISTUNGSDATUM_INVALID2 = 27;
  /**
   * Das Format von Arzt-Identifikator ist ungültig. <br/>
   * ORCLI-Code: CL-1890093
   */
  public static final int ARZTID_WRONG_FORMAT = 28;
  /**
   * Das Format von Bis-Datum ist ungültig. <br/>
   * ORCLI-Code: CL-1890103
   */
  public static final int BIS_DATUM_WRONG_FORMAT = 29;
  /**
   * Der Wert in Bis-Datum ist ungültig. (Das Bis-Datum darf nicht vor dem Von-Datum liegen.) <br/>
   * ORCLI-Code: CL-1890105
   */
  public static final int BIS_DATUM_INVALID = 30;
  /**
   * Das Format von Von-Datum ist ungültig. <br/>
   * ORCLI-Code: CL-1890113
   */
  public static final int VON_DATUM_WRONG_FORMAT = 31;
  /**
   * Der Wert in KV-Träger ist ungültig. <br/>
   * ORCLI-Code: CL-1890124
   */
  public static final int KVT_INVALID = 32;
  /**
   * Der Wert in Ohne Anspruch ist ungültig. <br/>
   * ORCLI-Code: CL-1890134
   */
  public static final int OHNE_ANSPRUCH_INVALID = 33;
  /**
   * Bei Angabe von Ohne Anspruch ist die Angabe eines KV-Trägers nicht zulässig. <br/>
   * ORCLI-Code: CL-1890120
   */
  public static final int OHNE_ANSPRUCH_AND_KVT_NOT_ALLOWED = 34;
  /**
   * ScreeningDoku ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801001
   */
  public static final int SCREENING_REQUIRED = 35;
  /**
   * Assessment Bildgebende Diagnostik Dokumentation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802001
   */
  public static final int ASSESSMENT_BILDGEBEND_REQUIRED = 36;
  /**
   * Assessment Invasive Diagnostik Dokumentation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803001
   */
  public static final int ASSESSMENT_INVASIV_REQUIRED = 37;
  /**
   * Kurative Mammographiedokumentation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804001
   */
  public static final int KURATIV_MAMMO_REQUIRED = 38;
  /**
   * Dokumentationstyp ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1890021
   */
  public static final int DOKUMENTATIONSTYP_REQUIRED = 39;
  /**
   * Tumordokumentation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807001
   */
  public static final int TUMOR_REQUIRED = 40;
  /**
   * Mammographie Erstbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801101
   */
  public static final int SCR_MAMMO_ERSTBEFUNDER_REQUIRED = 41;
  /**
   * Mammographie Zweitbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801501
   */
  public static final int SCR_MAMMO_ZWEITBEFUNDER_REQUIRED = 42;
  /**
   * Endergebnis ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801701
   */
  public static final int SCR_ENDERGEBNIS_REQUIRED = 43;
  /**
   * Datum der Befundung MG ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801131
   */
  public static final int SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_REQUIRED = 44;
  /**
   * Das Format von Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1801133
   */
  public static final int SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_WRONG_FORMAT = 45;
  /**
   * Der Wert in Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1801134
   */
  public static final int SCR_DATUM_BEFUNDUNG_ERSTBEFUNDER_INVALID = 46;
  /**
   * Ergebnis (D-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801141
   */
  public static final int SCR_DICHTE_ERSTBEFUNDER_REQUIRED = 47;
  /**
   * Der Wert in Ergebnis (D-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801144
   */
  public static final int SCR_DICHTE_ERSTBEFUNDER_INVALID = 48;
  /**
   * Ergebnis (MG-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801151
   */
  public static final int SCR_ERGEBNIS_ERSTBEFUNDER_REQUIRED = 49;
  /**
   * Der Wert in Ergebnis (MG-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801154
   */
  public static final int SCR_ERGEBNIS_ERSTBEFUNDER_INVALID = 50;
  /**
   * Datum der Befundung US ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801331
   */
  public static final int SCR_DATUM_BEFUNDUNG_ULTRASCHALL_REQUIRED = 51;
  /**
   * Das Format von Datum der Befundung US ist ungültig. <br/>
   * ORCLI-Code: CL-1801333
   */
  public static final int SCR_DATUM_BEFUNDUNG_ULTRASCHALL_WRONG_FORMAT = 52;
  /**
   * Der Wert in Datum der Befundung US ist ungültig. <br/>
   * ORCLI-Code: CL-1801334
   */
  public static final int SCR_DATUM_BEFUNDUNG_ULTRASCHALL_INVALID = 53;
  /**
   * Grund für US ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801341
   */
  public static final int SCR_GRUND_REQUIRED = 54;
  /**
   * Der Wert in Grund für US ist ungültig. <br/>
   * ORCLI-Code: CL-1801344
   */
  public static final int SCR_GRUND_INVALID = 55;
  /**
   * Ergebnis (US-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801351
   */
  public static final int SCR_ERGEBNIS_ULTRASCHALL_REQUIRED = 56;
  /**
   * Der Wert in Ergebnis (US-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801354
   */
  public static final int SCR_ERGEBNIS_ULTRASCHALL_INVALID = 57;
  /**
   * Datum der Befundung MG ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801531
   */
  public static final int SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_REQUIRED = 58;
  /**
   * Das Format von Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1801533
   */
  public static final int SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_WRONG_FORMAT = 59;
  /**
   * Der Wert in Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1801534
   */
  public static final int SCR_DATUM_BEFUNDUNG_ZWEITBEFUNDER_INVALID = 60;
  /**
   * Ergebnis (D-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801541
   */
  public static final int SCR_DICHTE_ZWEITBEFUNDER_REQUIRED = 61;
  /**
   * Der Wert in Ergebnis (D-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801544
   */
  public static final int SCR_DICHTE_ZWEITBEFUNDER_INVALID = 62;
  /**
   * Ergebnis (MG-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801551
   */
  public static final int SCR_ERGEBNIS_ZWEITBEFUNDER_REQUIRED = 63;
  /**
   * Der Wert in Ergebnis (MG-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801554
   */
  public static final int SCR_ERGEBNIS_ZWEITBEFUNDER_INVALID = 64;
  /**
   * Zusatzaufnahmen durchgeführt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801721
   */
  public static final int SCR_MED_ZUSATZAUFNAHME_REQUIRED = 65;
  /**
   * Der Wert in Zusatzaufnahmen durchgeführt ist ungültig. <br/>
   * ORCLI-Code: CL-1801724
   */
  public static final int SCR_MED_ZUSATZAUFNAHME_INVALID = 66;
  /**
   * Zumindest eine Aufnahme war radiologisch inakzeptabel ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801731
   */
  public static final int SCR_INAKZEPTABEL_REQUIRED = 67;
  /**
   * Der Wert in Aufnahme radiologisch inakzeptabel ist ungültig. <br/>
   * ORCLI-Code: CL-1801734
   */
  public static final int SCR_INAKZEPTABEL_INVALID = 68;
  /**
   * Aufnahme aus technischen Gründen wiederholt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801741
   */
  public static final int SCR_TECH_ZUSATZAUFNAHME_REQUIRED = 69;
  /**
   * Der Wert in Aufnahme aus technischen Gründen wiederholt ist ungültig. <br/>
   * ORCLI-Code: CL-1801744
   */
  public static final int SCR_TECH_ZUSATZAUFNAHME_INVALID = 70;
  /**
   * Setting der Doppelbefundung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801771
   */
  public static final int SCR_DOPPELBEFUNDUNG_REQUIRED = 71;
  /**
   * Der Wert in Setting der Doppelbefundung ist ungültig. <br/>
   * ORCLI-Code: CL-1801774
   */
  public static final int SCR_DOPPELBEFUNDUNG_INVALID = 72;
  /**
   * Endergebnis (SC-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801781
   */
  public static final int SCR_ERGEBNIS_ENDERGEBNIS_REQUIRED = 73;
  /**
   * Der Wert in Endergebnis (SC-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801784
   */
  public static final int SCR_ERGEBNIS_ENDERGEBNIS_INVALID = 74;
  /**
   * Ergebnis (D-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801791
   */
  public static final int SCR_DICHTE_ENDERGEBNIS_REQUIRED = 75;
  /**
   * Der Wert in Ergebnis (D-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1801794
   */
  public static final int SCR_DICHTE_ENDERGEBNIS_INVALID = 76;
  /**
   * Größe Läsion links ist ein Pflichtfeld. (Bei einem Endergebnis (SC-SCORE ) gleich "SC4" bis "SC6" muss entweder
   * Größe Läsion Links oder Größe Läsion Rechts angegeben werden.) <br/>
   * ORCLI-Code: CL-1801801
   */
  public static final int SCR_GROESSE_LINKS_REQUIRED = 77;
  /**
   * Der Wert in Größe Läsion links ist ungültig. <br/>
   * ORCLI-Code: CL-1801804
   */
  public static final int SCR_GROESSE_LINKS_INVALID = 78;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. <br/>
   * ORCLI-Code: CL-1801814
   */
  public static final int SCR_GROESSE_RECHTS_INVALID = 80;
  /**
   * Der Wert in Weiteres Vorgehen (bei SC3) ist ungültig. <br/>
   * ORCLI-Code: CL-1801824
   */
  public static final int SCR_VORGEHEN_INVALID = 81;
  /**
   * Der Wert in Weiteres Vorgehen (bei SC3) ist ungültig. (Bei Ergebnis (SC-SCORE) ungleich "SC3" ist keine Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1801825
   */
  public static final int SCR_VORGEHEN_INVALID2 = 82;
  /**
   * Grund für Wiederbestellung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801881
   */
  public static final int SCR_WIEDERBESTELLUNG_REQUIRED = 83;
  /**
   * Der Wert in Grund für Wiederbestellung ist ungültig. <br/>
   * ORCLI-Code: CL-1801884
   */
  public static final int SCR_WIEDERBESTELLUNG_INVALID = 84;
  /**
   * Mammographie Erstbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804101
   */
  public static final int KUM_MAMMO_ERSTBEFUNDER_REQUIRED = 85;
  /**
   * Endergebnis ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804701
   */
  public static final int KUM_ENDERGEBNIS_REQUIRED = 86;
  /**
   * Der Wert in Größe Läsion links ist ungültig. (Bei einem Endergebnis (SC-SCORE) gleich "SC0" bis "SC3" ist keine Angabe
   * erlaubt.) <br/>
   * ORCLI-Code: CL-1801805
   */
  public static final int SCR_GROESSE_LINKS_INVALID2 = 87;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. (Bei einem Endergebnis (SC-SCORE) gleich "SC0" bis "SC3" ist keine
   * Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1801815
   */
  public static final int SCR_GROESSE_RECHTS_INVALID2 = 88;
  /**
   * Datum der Befundung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801851
   */
  public static final int SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_REQUIRED = 91;
  /**
   * Das Format von Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1801853
   */
  public static final int SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_WRONG_FORMAT = 92;
  /**
   * Der Wert in Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1801854
   */
  public static final int SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID = 93;
  /**
   * Datum Befund versandbereit/abholbereit ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801861
   */
  public static final int SCR_INFO_PATIENT_REQUIRED = 94;
  /**
   * Das Format von Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1801863
   */
  public static final int SCR_INFO_PATIENT_WRONG_FORMAT = 95;
  /**
   * Der Wert in Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1801864
   */
  public static final int SCR_INFO_PATIENT_INVALID = 96;
  /**
   * Identifikation Erstbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804111
   */
  public static final int KUM_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED = 97;
  /**
   * Das Format von Identifikation Erstbefunder ist ungültig. <br/>
   * ORCLI-Code: CL-1804113
   */
  public static final int KUM_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT = 98;
  /**
   * Der Wert in Identifikation Erstbefunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1804114
   */
  public static final int KUM_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND = 99;
  /**
   * Der Wert in Identifikation Erstbefunder ist ungültig. (Bei Erst- und Zweitbefund müssen unterschiedliche Befunder eingetragen
   * werden.) <br/>
   * ORCLI-Code: CL-1804115
   */
  public static final int KUM_IDENTIFIKATION_ERSTBEFUNDER_INVALID = 100;
  /**
   * Datum der Befundung MG ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804131
   */
  public static final int KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_REQUIRED = 101;
  /**
   * Das Format von Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1804133
   */
  public static final int KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_WRONG_FORMAT = 102;
  /**
   * Der Wert in Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1804134
   */
  public static final int KUM_DATUM_BEFUNDUNG_ERSTBEFUNDER_INVALID = 103;
  /**
   * Ergebnis (D-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804141
   */
  public static final int KUM_DICHTE_ERSTBEFUNDER_REQUIRED = 104;
  /**
   * Der Wert in Ergebnis (D-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804144
   */
  public static final int KUM_DICHTE_ERSTBEFUNDER_INVALID = 105;
  /**
   * Ergebnis (MG-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804151
   */
  public static final int KUM_ERGEBNIS_ERSTBEFUNDER_REQUIRED = 106;
  /**
   * Der Wert in Ergebnis (MG-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804154
   */
  public static final int KUM_ERGEBNIS_ERSTBEFUNDER_INVALID = 107;
  /**
   * Datum der Befundung US ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804331
   */
  public static final int KUM_DATUM_BEFUNDUNG_ULTRASCHALL_REQUIRED = 108;
  /**
   * Das Format von Datum der Befundung US ist ungültig. <br/>
   * ORCLI-Code: CL-1804333
   */
  public static final int KUM_DATUM_BEFUNDUNG_ULTRASCHALL_WRONG_FORMAT = 109;
  /**
   * Der Wert in Datum der Befundung US ist ungültig. <br/>
   * ORCLI-Code: CL-1804334
   */
  public static final int KUM_DATUM_BEFUNDUNG_ULTRASCHALL_INVALID = 110;
  /**
   * Grund für US ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804341
   */
  public static final int KUM_GRUND_REQUIRED = 111;
  /**
   * Der Wert in Grund für US ist ungültig. <br/>
   * ORCLI-Code: CL-1804344
   */
  public static final int KUM_GRUND_INVALID = 112;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "dichte Brust bei nicht suspektem Befund durch Erstbefunder (D3-4 bei MG1-2)" ist nur erlaubt wenn im Erstbefund Ergebnis
   * (D-SCORE) gleich "D3" oder "D4" und Ergebnis (MG-SCORE) gleich "MG1" oder "MG2" ist.) <br/>
   * ORCLI-Code: CL-1804345
   */
  public static final int KUM_GRUND_INVALID2 = 113;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "suspekter Befund durch Erstbefunder (MG4-6) (Dichte der Brust unerheblich)" ist nur erlaubt wenn im Erstbefund Ergebnis
   * (MG-SCORE) gleich "MG4", "MG5" oder "MG6" ist.) <br/>
   * ORCLI-Code: CL-1804346
   */
  public static final int KUM_GRUND_INVALID3 = 114;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "dichte Brust bei nicht supektem Befund durch Zweitbefunder (D3-4 bei MG1-2)" ist nur erlaubt wenn im Zweitbefund Ergebnis
   * (D-SCORE) gleich "D3" oder "D4" und Ergebnis (MG-SCORE) gleich "MG1" oder "MG2" ist.) <br/>
   * ORCLI-Code: CL-1804347
   */
  public static final int KUM_GRUND_INVALID4 = 115;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "suspekter Befund durch Zweitbefunder (MG4-6) (Dichte der Brust unerheblich)" ist nur erlaubt wenn im Zweitbefund Ergebnis
   * (MG-SCORE) gleich "MG4", "MG5" oder "MG6" ist.) <br/>
   * ORCLI-Code: CL-1804348
   */
  public static final int KUM_GRUND_INVALID5 = 116;
  /**
   * Ergebnis (US-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804351
   */
  public static final int KUM_ERGEBNIS_ULTRASCHALL_REQUIRED = 117;
  /**
   * Der Wert in Ergebnis (US-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804354
   */
  public static final int KUM_ERGEBNIS_ULTRASCHALL_INVALID = 118;
  /**
   * Identifikation Zweitbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804511
   */
  public static final int KUM_IDENTIFIKATION_ZWEITBEFUNDER_REQUIRED = 119;
  /**
   * Das Format von Identifikation Zweitbefunder ist ungültig. <br/>
   * ORCLI-Code: CL-1804513
   */
  public static final int KUM_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT = 120;
  /**
   * Der Wert in Identifikation Zweitbefunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1804514
   */
  public static final int KUM_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND = 121;
  /**
   * Datum der Befundung MG ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804531
   */
  public static final int KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_REQUIRED = 122;
  /**
   * Das Format von Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1804533
   */
  public static final int KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_WRONG_FORMAT = 122;
  /**
   * Der Wert in Datum der Befundung MG ist ungültig. <br/>
   * ORCLI-Code: CL-1804534
   */
  public static final int KUM_DATUM_BEFUNDUNG_ZWEITBEFUNDER_INVALID = 123;
  /**
   * Ergebnis (D-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804541
   */
  public static final int KUM_DICHTE_ZWEITBEFUNDER_REQUIRED = 124;
  /**
   * Der Wert in Ergebnis (D-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804544
   */
  public static final int KUM_DICHTE_ZWEITBEFUNDER_INVALID = 125;
  /**
   * Ergebnis (MG-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804551
   */
  public static final int KUM_ERGEBNIS_ZWEITBEFUNDER_REQUIRED = 126;
  /**
   * Der Wert in Ergebnis (MG-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804554
   */
  public static final int KUM_ERGEBNIS_ZWEITBEFUNDER_INVALID = 127;
  /**
   * Zusatzaufnahmen durchgeführt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804721
   */
  public static final int KUM_MED_ZUSATZAUFNAHME_REQUIRED = 128;
  /**
   * Der Wert in Zusatzaufnahmen durchgeführt ist ungültig. <br/>
   * ORCLI-Code: CL-1804724
   */
  public static final int KUM_MED_ZUSATZAUFNAHME_INVALID = 129;
  /**
   * Zumindest eine Aufnahme war radiologisch inakzeptabel ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804731
   */
  public static final int KUM_INAKZEPTABEL_REQUIRED = 130;
  /**
   * Der Wert in Aufnahme radiologisch inakzeptabel ist ungültig. <br/>
   * ORCLI-Code: CL-1804734
   */
  public static final int KUM_INAKZEPTABEL_INVALID = 132;
  /**
   * Aufnahme aus technischen Gründen wiederholt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804741
   */
  public static final int KUM_TECH_ZUSATZAUFNAHME_REQUIRED = 133;
  /**
   * Der Wert in Aufnahme aus technischen Gründen wiederholt ist ungültig. <br/>
   * ORCLI-Code: CL-1804744
   */
  public static final int KUM_TECH_ZUSATZAUFNAHME_INVALID = 134;
  /**
   * Endergebnis (SC-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804781
   */
  public static final int KUM_ERGEBNIS_ENDERGEBNIS_REQUIRED = 135;
  /**
   * Der Wert in Endergebnis (SC-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804784
   */
  public static final int KUM_ERGEBNIS_ENDERGEBNIS_INVALID = 136;
  /**
   * Ergebnis (D-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804791
   */
  public static final int KUM_DICHTE_ENDERGEBNIS_REQUIRED = 137;
  /**
   * Der Wert in Ergebnis (D-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1804794
   */
  public static final int KUM_DICHTE_ENDERGEBNIS_INVALID = 138;
  /**
   * Größe Läsion links ist ein Pflichtfeld. (Bei einem Endergebnis (KUM-SCORE) gleich "KUM4" bis "KUM6" muss entweder Größe
   * Lasion links oder Größe Läsion rechts angegeben werden.) <br/>
   * ORCLI-Code: CL-1804801
   */
  public static final int KUM_GROESSE_LINKS_REQUIRED = 139;
  /**
   * Der Wert in Größe Läsion links ist ungültig. <br/>
   * ORCLI-Code: CL-1804804
   */
  public static final int KUM_GROESSE_LINKS_INVALID = 140;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. <br/>
   * ORCLI-Code: CL-1804814
   */
  public static final int KUM_GROESSE_RECHTS_INVALID = 141;
  /**
   * Datum der Befundung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804851
   */
  public static final int KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_REQUIRED = 142;
  /**
   * Das Format von Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1804853
   */
  public static final int KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_WRONG_FORMAT = 143;
  /**
   * Der Wert in Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1804854
   */
  public static final int KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID = 144;
  /**
   * Der Wert in Datum der Befundung ist ungültig. (Das Datum der Befundung des Endergebnisses darf nicht 
   * vor dem Datum der Befundung von Mammographie Erstbefunder bzw. wenn angegeben 
   * Mammographie Zweitbefunder oder Ultraschall liegen.)  <br/>
   * ORCLI-Code: CL-1804855
   */
  public static final int KUM_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID2 = 145;
  /**
   * Datum Befund versandbereit/abholbereit ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804861
   */
  public static final int KUM_INFO_PATIENT_REQUIRED = 146;
  /**
   * Das Format von Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1804863
   */
  public static final int KUM_INFO_PATIENT_WRONG_FORMAT = 147;
  /**
   * Der Wert in Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1804864
   */
  public static final int KUM_INFO_PATIENT_INVALID = 148;
  /**
   * Das Format von Verschlüsselte Patienten-ID ist ungültig. <br/>
   * ORCLI-Code: CL-1804873
   */
  public static final int KUM_PATIENT_ID_WRONG_FORMAT = 149;
  /**
   * Grund für Wiederbestellung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1804881
   */
  public static final int KUM_WIEDERBESTELLUNG_REQUIRED = 150;
  /**
   * Der Wert in Grund für Wiederbestellung ist ungültig. <br/>
   * ORCLI-Code: CL-1804884
   */
  public static final int KUM_WIEDERBESTELLUNG_INVALID = 151;
  /**
   * Der Wert in Größe Läsion links ist ungültig. (Bei einem Endergebnis (KUM-SCORE) gleich "KUM0" bis "KUM3" ist keine
   * Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1804805
   */
  public static final int KUM_GROESSE_LINKS_INVALID2 = 152;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. (Bei einem Endergebnis (KUM-SCORE) gleich "KUM0" bis "KUM3" ist keine
   * Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1804815
   */
  public static final int KUM_GROESSE_RECHTS_INVALID2 = 153;
  /**
   * Der Wert in Datum der Befundung ist ungültig. (Das Datum der Befundung des Endergebnisses darf nicht vor dem Datum der
   * Befundung von Mammographie Erstbefunder, Mammographie Zweitbefunder und, wenn angegeben, des Ultraschalls liegen.) <br/>
   * ORCLI-Code: CL-1801855
   */
  public static final int SCR_DATUM_BEFUNDUNG_ENDERGEBNIS_INVALID2 = 220;
  /**
   * Das Format von Verschlüsselte Patienten-ID ist ungültig. <br/>
   * ORCLI-Code: CL-1801873
   */
  public static final int SCR_PATIENT_ID_WRONG_FORMAT = 221;
  /**
   * Der Wert in Identifikation Erstbefunder ist ungültig. (Der gewählte Befunder ist nicht für die Erstbefundung berechtigt.) <br/>
   * ORCLI-Code: CL-1801115
   */
  public static final int SCR_IDENTIFIKATION_ERSTBEFUNDER_INVALID = 222;
  /**
   * Identifikation Zweitbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1801511
   */
  public static final int SCR_IDENTIFIKATION_ZWEITBEFUNDER_REQUIRED = 223;
  /**
   * Das Format von Identifikation Zweitbefunder ist ungültig. <br/>
   * ORCLI-Code: CL-1801513
   */
  public static final int SCR_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT = 224;
  /**
   * Der Wert in Identifikation Zweitbefunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1801514
   */
  public static final int SCR_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND = 225;
  /**
   * Der Wert in Dokumentationstyp ist ungültig. <br/>
   * ORCLI-Code: CL-1890024
   */
  public static final int DOKUMENTATIONSTYP_INVALID = 226;
  /**
   * Arzt-Identifikator ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1890091
   */
  public static final int ARZTID_REQUIRED = 227;
  /**
   * Der Wert in Identifikation Erstbefunder ist ungültig. (Bei Erst- und Zweitbefund müssen unterschiedliche Befunder eingetragen
   * werden.) <br/>
   * ORCLI-Code: CL-1801116
   */
  public static final int SCR_IDENTIFIKATION_ERSTBEFUNDER_INVALID2 = 232;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "dichte Brust bei nicht suspektem Befund durch Erstbefunder (D3-4 bei MG1-2)" ist nur erlaubt wenn, im Erstbefund Ergebnis
   * (D-SCORE) gleich "D3" oder "D4" und Ergebnis (MG-SCORE ) gleich "MG1" oder "MG2" ist.) <br/>
   * ORCLI-Code: CL-1801345
   */
  public static final int SCR_GRUND_INVALID2 = 233;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "suspekter Befund durch Erstbefunder (MG4-6) (Dichte der Brust unerheblich)" ist nur erlaubt wenn, im Erstbefund Ergebnis
   * (MG-SCORE ) gleich "MG4", "MG5" oder "MG6" ist.) <br/>
   * ORCLI-Code: CL-1801346
   */
  public static final int SCR_GRUND_INVALID3 = 234;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "dichte Brust bei nicht supektem Befund durch Zweitbefunder (D3-4 bei MG1-2)" ist nur erlaubt wenn, im Zweitbefund Ergebnis
   * (D-SCORE) gleich "D3" oder "D4" und Ergebnis (MG-SCORE ) gleich "MG1" oder "MG2" ist.) <br/>
   * ORCLI-Code: CL-1801347
   */
  public static final int SCR_GRUND_INVALID4 = 235;
  /**
   * Der Wert in Grund für US ist ungültig. (Die Angabe von
   * "suspekter Befund durch Zweitbefunder (MG4-6) (Dichte der Brust unerheblich)" ist nur erlaubt wenn, im Zweitbefund Ergebnis
   * (MG-SCORE) gleich "MG4", "MG5" oder "MG6" ist.) <br/>
   * ORCLI-Code: CL-1801348
   */
  public static final int SCR_GRUND_INVALID5 = 236;
  /**
   * Weiteres Vorgehen (bei SC3) ist ein Pflichtfeld. (Ergebnis (SC-SCORE) ist mit "SC3" belegt.) <br/>
   * ORCLI-Code: CL-1801821
   */
  public static final int SCR_VORGEHEN_REQUIRED = 239;
  /**
   * Beginn der Leistungserbringung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802011
   */
  public static final int ABD_LEISTUNGSANFANG_REQUIRED = 240;
  /**
   * Das Format von Beginn der Leistungserbringung ist ungültig. <br/>
   * ORCLI-Code: CL-1802013
   */
  public static final int ABD_LEISTUNGSANFANG_WRONG_FORMAT = 241;
  /**
   * Der Wert in Beginn der Leistungserbringung ist ungültig. <br/>
   * ORCLI-Code: CL-1802014
   */
  public static final int ABD_LEISTUNGSANFANG_INVALID = 242;
  /**
   * Der Wert in Ergebnis der klinischen Untersuchung ist ungültig. <br/>
   * ORCLI-Code: CL-1802024
   */
  public static final int ABD_ERGEBNIS_KLINISCH_INVALID = 243;
  /**
   * Mammographie im Assessment durchgeführt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802031
   */
  public static final int ABD_MAMMO_DURCHGEFUEHRT_REQUIRED = 244;
  /**
   * Der Wert in Mammographie im Assessment durchgeführt ist ungültig. <br/>
   * ORCLI-Code: CL-1802034
   */
  public static final int ABD_MAMMO_DURCHGEFUEHRT_INVALID = 245;
  /**
   * Zusätzliche mammographische Bilder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802041
   */
  public static final int ABD_ZUSATZAUFNAHME_REQUIRED = 246;
  /**
   * Der Wert in zusätzliche mammographische Bilder ist ungültig. <br/>
   * ORCLI-Code: CL-1802044
   */
  public static final int ABD_ZUSATZAUFNAHME_INVALID = 247;
  /**
   * Ergebnis der Mammographie (MG-SCORE) ist ein Pflichtfeld. (Bei Mammographie im Assessment durchgeführt gleich "Ja" oder
   * Zusätzliche mammographische Bilder gleich "Ja", muss ein Wert ungleich "nicht durchgeführt" angegeben werden.) <br/>
   * ORCLI-Code: CL-1802051
   */
  public static final int ABD_ERGBNIS_MAMMO_REQUIRED = 248;
  /**
   * Der Wert in Ergebnis der Mammographie (MG-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-CL-1802054
   */
  public static final int ABD_ERGEBNIS_MAMMO_INVALID = 249;
  /**
   * Der Wert in Ergebnis der Mammographie (MG-SCORE) ist ungültig. (Bei Mammographie im Assessment durchgeführt gleich "Ja"
   * oder Zusätzliche mammographische Bilder gleich "Ja", muss ein Wert ungleich "nicht durchgeführt" angegeben werden) <br/>
   * ORCLI-Code: CL-CL-1802055
   */
  public static final int ABD_ERGEBNIS_MAMMO_INVALID2 = 250;
  /**
   * Der Wert in Ergebnis Ultraschall (US-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1802064
   */
  public static final int ABD_ERGEBNIS_US_INVALID = 251;
  /**
   * Der Wert in Ergebnis MRT (MRT-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1802074
   */
  public static final int ABD_ERGEBNIS_MRT_INVALID = 252;
  /**
   * Gesamtbeurteilung (ABD-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802081
   */
  public static final int ABD_GESAMTERGEBNIS_REQUIRED = 253;
  /**
   * Der Wert in Gesamtbeurteilung (ABD-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1802084
   */
  public static final int ABD_GESAMTERGEBNIS_INVALID = 254;
  /**
   * Zustimmung zu Feedbackbericht ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802091
   */
  public static final int ABD_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED = 255;
  /**
   * Der Wert in Zustimmung zu Feedbackbericht ist ungültig. <br/>
   * ORCLI-Code: CL-1802094
   */
  public static final int ABD_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID = 256;
  /**
   * Datum Befund versandbereit/abholbereit ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1802101
   */
  public static final int ABD_INFO_PATIENT_REQUIRED = 257;
  /**
   * Das Format von Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1802103
   */
  public static final int ABD_INFO_PATIENT_WRONG_FORMAT = 258;
  /**
   * Der Wert in Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1802104
   */
  public static final int ABD_INFO_PATIENT_INVALID = 259;
  /**
   * Beginn der Leistungserbringung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803011
   */
  public static final int AID_LEISTUNGSANFANG_REQUIRED = 261;
  /**
   * Das Format von Beginn der Leistungserbringung ist ungültig. <br/>
   * ORCLI-Code: CL-1803013
   */
  public static final int AID_LEISTUNGSANFANG_WRONG_FORMAT = 262;
  /**
   * Der Wert in Beginn der Leistungserbringung ist ungültig. <br/>
   * ORCLI-Code: CL-1803014
   */
  public static final int AID_LEISTUNGSANFANG_INVALID = 263;
  /**
   * Seite ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803021
   */
  public static final int AID_SEITE_REQUIRED = 264;
  /**
   * Der Wert in Seite ist ungültig. <br/>
   * ORCLI-Code: CL-1803024
   */
  public static final int AID_SEITE_INVALID = 265;
  /**
   * Der Wert in Ergebnis klinische Untersuchung ist ungültig. <br/>
   * ORCLI-Code: CL-1803034
   */
  public static final int AID_ERGEBNIS_KLINISCH_INVALID = 266;
  /**
   * Biopsie Methode ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803041
   */
  public static final int AID_BIOPSIE_METHODE_REQUIRED = 267;
  /**
   * Der Wert in Biopsie Methode ist ungültig. <br/>
   * ORCLI-Code: CL-1803044
   */
  public static final int AID_BIOPSIE_METHODE_INVALID = 268;
  /**
   * Biopsie Modalität ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803051
   */
  public static final int AID_BIOPSIE_MODALITAET_REQUIRED = 269;
  /**
   * Der Wert in Biopsie Modalität ist ungültig. <br/>
   * ORCLI-Code: CL-1803054
   */
  public static final int AID_BIOPSIE_MODALITAET_INVALID = 270;
  /**
   * Der Wert in Histologisches Ergebnis ist ungültig. <br/>
   * ORCLI-Code: CL-1803064
   */
  public static final int AID_ERGEBNIS_HISTOLOGIE_INVALID = 271;
  /**
   * Histologisches Ergebnis ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803061
   */
  public static final int AID_ERGEBNIS_HISTOLOGIE_REQUIRED = 272;
  /**
   * Zustimmung zu Feedbackbericht ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803091
   */
  public static final int AID_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED = 275;
  /**
   * Der Wert in Zustimmung zu Feedbackbericht ist ungültig. <br/>
   * ORCLI-Code: CL-1803094
   */
  public static final int AID_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID = 276;
  /**
   * Datum Befund versandbereit/abholbereit ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1803101
   */
  public static final int AID_INFO_PATIENT_REQUIRED = 277;
  /**
   * Das Format von Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1803103
   */
  public static final int AID_INFO_PATIENT_WRONG_FORMAT = 278;
  /**
   * Der Wert in Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1803104
   */
  public static final int AID_INFO_PATIENT_INVALID = 279;
  /**
   * Der Wert in Histologisches Ergebnis ist ungültig. (Bei Biopsiemethode ungleich Stanzbiopsie oder Vakuum-Stanzbiopsie darf nur der Wert offene Biopsie angegeben werden.) <br/>
   * ORCLI-Code: CL-1803065
   */
  public static final int AID_ERGEBNIS_HISTOLOGIE_INVALID2 = 280;
  /**
   * Der Wert in Histologisches Ergebnis ist ungültig. (Bei Biopsiemethode gleich Stanzbiopsie oder Vakuum-Stanzbiopsie darf der Wert offene Biopsie nicht angegeben werden.) <br/>
   * ORCLI-Code: CL-1803066
   */
  public static final int AID_ERGEBNIS_HISTOLOGIE_INVALID3 = 281;
  /**
   * Kurative Mammographie Leermeldung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1806001
   */
  public static final int KURATIVE_MAMMOGRAPHIE_LEERMELDUNG_REQUIRED = 286;
  /**
   * Identifikation Erstbefunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1806011
   */
  public static final int KML_IDENTIFIKATION_ERSTBEFUNDER_REQUIRED = 287;
  /**
   * Das Format von Identifikation Erstbefunder ist ungültig. <br/>
   * ORCLI-Code: CL-1806013
   */
  public static final int KML_IDENTIFIKATION_ERSTBEFUNDER_WRONG_FORMAT = 288;
  /**
   * Der Wert in Identifikation Erstbefunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1806014
   */
  public static final int KML_IDENTIFIKATION_ERSTBEFUNDER_NOT_FOUND = 289;
  /**
   * Das Format von Identifikation Zweitbefunder ist ungültig. <br/>
   * ORCLI-Code: CL-1806023
   */
  public static final int KML_IDENTIFIKATION_ZWEITBEFUNDER_WRONG_FORMAT = 290;
  /**
   * Der Wert in Identifikation Zweitbefunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1806024
   */
  public static final int KML_IDENTIFIKATION_ZWEITBEFUNDER_NOT_FOUND = 291;
  /**
   * Der Wert in Identifikation Zweitbefunder ist ungültig. (Der Erst- und der Zweitbefunder dürfen nicht ident sein.) <br/>
   * ORCLI-Code: CL-1806025
   */
  public static final int KML_IDENTIFIKATION_ERSTBEFUNDER_AND_IDENTIFIKATION_ZWEITBEFUNDER_IDENT = 292;
  /**
   * Der Wert in Konsultation ist ungültig. (Es muss ein Leistungsdatum angegeben werden, die Angabe einer Konsultation ist nicht zulässig.) <br/>
   * ORCLI-Code: CL-1890045
   */
  public static final int KONSULTATION_NOT_ALLOWED = 293;
  /**
   * Leistungsdatum ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1890061
   */
  public static final int LEISTUNGSDATUM_REQUIRED = 294;
  /**
   * Screening Ultraschalldokumentation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1805001
   */
  public static final int SCREENING_ULTRASCHALL_REQUIRED = 295;
  /**
   * Datum der Befundung (VU-US) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1805011
   */
  public static final int SUS_DATUM_BEFUNDUNG_REQUIRED = 296;
  /**
   * Das Format von Datum der Befundung (VU-US) ist ungültig. <br/>
   * ORCLI-Code: CL-1805013
   */
  public static final int SUS_DATUM_BEFUNDUNG_WRONG_FORMAT = 297;
  /**
   * Der Wert in Datum der Befundung (VU-US) ist ungültig. <br/>
   * ORCLI-Code: CL-1805014
   */
  public static final int SUS_DATUM_BEFUNDUNG_INVALID = 298;
  /**
   * Ergebnis (US-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1805021
   */
  public static final int SUS_ERGEBNIS_ULTRASCHALL_REQUIRED  = 299;
  /**
   * Der Wert in Ergebnis (US-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1805024
   */
  public static final int SUS_ERGEBNIS_ULTRASCHALL_INVALID  = 300;
  /**
   * Der Wert in Größe Läsion links ist ungültig. <br/>
   * ORCLI-Code: CL-1805044
   */
  public static final int SUS_GROESSE_LINKS_INVALID = 301;
  /**
   * Der Wert in Größe Läsion links ist ungültig. (Bei einem Ergebnis (US-SCORE) gleich US0  bis US3 ist keine Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1805045
   */
  public static final int SUS_GROESSE_LINKS_INVALID2 = 302;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. <br/>
   * ORCLI-Code: CL-1805054
   */
  public static final int SUS_GROESSE_RECHTS_INVALID = 303;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. (Bei einem Ergebnis (US-SCORE) gleich US0  bis US3 ist keine Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1805055
   */
  public static final int SUS_GROESSE_RECHTS_INVALID2 = 304;
  /**
   * Weiteres Vorgehen (bei US3) ist ein Pflichtfeld. (Ergebnis (US-SCORE) ist mit US3 belegt.) <br/>
   * ORCLI-Code: CL-1805061
   */
  public static final int SUS_VORGEHEN_REQUIRED = 305;
  /**
   * Der Wert in Weiteres Vorgehen (bei US3) ist ungültig. <br/>
   * ORCLI-Code: CL-1805064
   */
  public static final int SUS_VORGEHEN_INVALID = 306;
  /**
   * Der Wert in Weiteres Vorgehen (bei US3) ist ungültig. (Bei einem Ergebnis (US-SCORE) ungleich US3 ist keine Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1805065
   */
  public static final int SUS_VORGEHEN_INVALID2 = 307;
  /**
   * Datum Befund versandbereit/abholbereit ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1805071
   */
  public static final int SUS_INFO_DATUM_REQUIRED = 308;
  /**
   * Das Format von Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1805073
   */
  public static final int SUS_INFO_DATUM_WRONG_FORMAT = 309;
  /**
   * Der Wert in Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1805074
   */
  public static final int SUS_INFO_DATUM_INVALID = 310;
  /**
   * Das Format von Verschlüsselte Patienten-ID ist ungültig. <br/>
   * ORCLI-Code: CL-1805083
   */
  public static final int SUS_PATIENT_ID_WRONG_FORMAT = 311;
  /**
   * Identifikation Befunder ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1805091
   */
  public static final int SUS_IDENTIFIKATION_BEFUNDER_REQUIRED = 312;
  /**
   * Das Format von Identifikation Befunder ist ungültig. <br/>
   * ORCLI-Code: CL-1805093
   */
  public static final int SUS_IDENTIFIKATION_BEFUNDER_WRONG_FORMAT = 313;
  /**
   * Der Wert in Identifikation Befunder ist ungültig. (Der gewählte Befunder ist nicht als zertifizierter Arzt eingetragen.) <br/>
   * ORCLI-Code: CL-1805094
   */
  public static final int SUS_IDENTIFIKATION_BEFUNDER_INVALID = 314;
  /**
   * Kurative Ultraschalldokumentation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1808001
   */
  public static final int KURATIVER_ULTRASCHALL_REQUIRED = 315;
  /**
   * Datum der Befundung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1808011
   */
  public static final int KUS_DATUM_BEFUNDUNG_REQUIRED = 316;
  /**
   * Das Format von Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1808013
   */
  public static final int KUS_DATUM_BEFUNDUNG_WRONG_FORMAT = 317;
  /**
   * Der Wert in Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1808014
   */
  public static final int KUS_DATUM_BEFUNDUNG_INVALID = 318;
  /**
   * Ergebnis (US-SCORE) ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1808021
   */
  public static final int KUS_ERGEBNIS_ULTRASCHALL_REQUIRED  = 319;
  /**
   * Der Wert in Ergebnis (US-SCORE) ist ungültig. <br/>
   * ORCLI-Code: CL-1808024
   */
  public static final int KUS_ERGEBNIS_ULTRASCHALL_INVALID  = 320;
  /**
   * Größe Läsion links ist ein Pflichtfeld. ( Bei einem Ergebnis (US-SCORE) gleich US4 bis US6 muss entweder Größe Läsion links oder Größe Läsion rechts angegeben werden.) <br/>
   * ORCLI-Code: CL-1808041
   */
  public static final int KUS_GROESSE_LINKS_REQUIRED = 321;
  /**
   * Der Wert in Größe Läsion links ist ungültig. <br/>
   * ORCLI-Code: CL-1808044
   */
  public static final int KUS_GROESSE_LINKS_INVALID = 322;
  /**
   * Der Wert in Größe Läsion links ist ungültig. (Bei einem Ergebnis (US-SCORE) gleich US0  bis US3 ist keine Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1808045
   */
  public static final int KUS_GROESSE_LINKS_INVALID2 = 323;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. <br/>
   * ORCLI-Code: CL-1808054
   */
  public static final int KUS_GROESSE_RECHTS_INVALID = 324;
  /**
   * Der Wert in Größe Läsion rechts ist ungültig. (Bei einem Ergebnis (US-SCORE) gleich US0  bis US3 ist keine Angabe erlaubt.) <br/>
   * ORCLI-Code: CL-1808055
   */
  public static final int KUS_GROESSE_RECHTS_INVALID2 = 325;
  /**
   * Datum Befund versandbereit/abholbereit ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1808061
   */
  public static final int KUS_INFO_DATUM_REQUIRED = 326;
  /**
   * Das Format von Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1808063
   */
  public static final int KUS_INFO_DATUM_WRONG_FORMAT = 327;
  /**
   * Der Wert in Datum Befund versandbereit/abholbereit ist ungültig. <br/>
   * ORCLI-Code: CL-1808064
   */
  public static final int KUS_INFO_DATUM_INVALID = 328;
  /**
   * Das Format von Verschlüsselte Patienten-ID ist ungültig. <br/>
   * ORCLI-Code: CL-1808073
   */
  public static final int KUS_PATIENT_ID_WRONG_FORMAT = 329;
  /**
   * Therapiedokumentation Pathologie ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1809001
   */
  public static final int THERAPIE_PATHOLOGIE_REQUIRED = 330;
  /**
   * Datum der Operation beziehungsweise der offenen Biopsie ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1809011
   */
  public static final int PAT_OPERATIONSDATUM_REQUIRED = 331;
  /**
   * Das Format von Datum der Operation beziehungsweise der offenen Biopsie ist ungültig. <br/>
   * ORCLI-Code: CL-1809013
   */
  public static final int PAT_OPERATIONSDATUM_WRONG_FORMAT = 332;
  /**
   * Der Wert in Datum der Operation beziehungsweise der offenen Biopsie ist ungültig. <br/>
   * ORCLI-Code: CL-1809014
   */
  public static final int PAT_OPERATIONSDATUM_INVALID = 333;
  /**
   * Datum der Befundung ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1809021
   */
  public static final int PAT_ZEITSTEMPEL_BEFUNDUNG_REQUIRED = 334;
  /**
   * Das Format von Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1809023
   */
  public static final int PAT_ZEITSTEMPEL_BEFUNDUNG_WRONG_FORMAT = 335;
  /**
   * Der Wert in Datum der Befundung ist ungültig. <br/>
   * ORCLI-Code: CL-1809024
   */
  public static final int PAT_ZEITSTEMPEL_BEFUNDUNG_INVALID = 336;
  /**
   * Seite ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1809031
   */
  public static final int PAT_SEITE_REQUIRED = 337;
  /**
   * Der Wert in Seite ist ungültig. <br/>
   * ORCLI-Code: CL-1809034
   */
  public static final int PAT_SEITE_INVALID = 338;
  /**
   * Gefrierschnitt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1809041
   */
  public static final int PAT_GEFRIERSCHNITT_REQUIRED = 339;
  /**
   * Der Wert in Gefrierschnitt ist ungültig. <br/>
   * ORCLI-Code: CL-1809044
   */
  public static final int PAT_GEFRIERSCHNITT_INVALID = 340;
  /**
   * Größe Tumordurchmesser ist ein Pflichtfeld. (Histologische Diagnose ist mit einem Wert ungleich Normal oder Benigne Läsion belegt.) <br/>
   * ORCLI-Code: CL-1809051
   */
  public static final int PAT_DIAMETER_REQUIRED = 341;
  /**
   * Der Wert in Größe Tumordurchmesser ist ungültig. <br/>
   * ORCLI-Code: CL-1809054
   */
  public static final int PAT_DIAMETER_INVALID = 342;
  /**
   * Histologische Diagnose ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1809061
   */
  public static final int PAT_HISTOLOGISCHE_DIAGNOSE_REQUIRED = 343;
  /**
   * Der Wert in Histologische Diagnose ist ungültig. <br/>
   * ORCLI-Code: CL-1809064
   */
  public static final int PAT_HISTOLOGISCHE_DIAGNOSE_INVALID = 344;
  /**
   * Rezidiv ist ein Pflichtfeld. (Histologische Diagnose ist mit einem Wert ungleich Normal oder Benigne Läsion belegt.) <br/>
   * ORCLI-Code: CL-1809071
   */
  public static final int PAT_REZIDIV_REQUIRED = 345;
  /**
   * Der Wert in Rezidiv ist ungültig. <br/>
   * ORCLI-Code: CL-1809074
   */
  public static final int PAT_REZIDIV_INVALID = 346;
  /**
   * Der Wert in Rezidiv ist ungültig. (Histologische Diagnose ist mit Normal oder Benigne Läsion belegt.) <br/>
   * ORCLI-Code: CL-1809075
   */
  public static final int PAT_REZIDIV_INVALID2 = 347;
  /**
   * Multifokaler Tumor ist ein Pflichtfeld. (Histologische Diagnose ist mit einem Wert ungleich Normal oder Benigne Läsion belegt.) <br/>
   * ORCLI-Code: CL-1809081
   */
  public static final int PAT_MULTIFOKAL_REQUIRED = 348;
  /**
   * Der Wert in Multifokaler Tumor ist ungültig. <br/>
   * ORCLI-Code: CL-1809084
   */
  public static final int PAT_MULTIFOKAL_INVALID = 349;
  /**
   * Der Wert in Multifokaler Tumor ist ungültig. (Histologische Diagnose ist mit Normal oder Benigne Läsion belegt.) <br/>
   * ORCLI-Code: CL-1809085
   */
  public static final int PAT_MULTIFOKAL_INVALID2 = 350;
  /**
   * LCIS: Spezifizierung ist ein Pflichtfeld. (Histologische Diagnose ist mit LCIS belegt.) <br/>
   * ORCLI-Code: CL-1809091
   */
  public static final int PAT_LCIS_TYP_REQUIRED = 351;
  /**
   * Der Wert in LCIS: Spezifizierung ist ungültig. <br/>
   * ORCLI-Code: CL-1809094
   */
  public static final int PAT_LCIS_TYP_INVALID = 352;
  /**
   * Der Wert in LCIS: Spezifizierung ist ungültig. (Histologische Diagnose ist ungleich LCIS belegt.) <br/>
   * ORCLI-Code: CL-1809095
   */
  public static final int PAT_LCIS_TYP_INVALID2 = 353;
  /**
   * DCIS: Mikroinvasion vorhanden ist ein Pflichtfeld. (Histologische Diagnose ist mit DCIS belegt.) <br/>
   * ORCLI-Code: CL-1809101
   */
  public static final int PAT_MICROINVASION_REQUIRED = 354;
  /**
   * Der Wert in DCIS: Mikroinvasion vorhanden ist ungültig. <br/>
   * ORCLI-Code: CL-1809104
   */
  public static final int PAT_MICROINVASION_INVALID = 355;
  /**
   * Der Wert in DCIS: Mikroinvasion vorhanden ist ungültig. (Histologische Diagnose ist ungleich DCIS belegt.) <br/>
   * ORCLI-Code: CL-1809105
   */
  public static final int PAT_MICROINVASION_INVALID2 = 356;
  /**
   * DCIS: Spezifizierung ist ein Pflichtfeld. (Histologische Diagnose ist mit DCIS belegt.) <br/>
   * ORCLI-Code: CL-1809111
   */
  public static final int PAT_DCIS_TYP_REQUIRED = 357;
  /**
   * Der Wert in DCIS: Spezifizierung ist ungültig. <br/>
   * ORCLI-Code: CL-1809114
   */
  public static final int PAT_DCIS_TYP_INVALID = 358;
  /**
   * Der Wert in DCIS: Spezifizierung ist ungültig. (Histologische Diagnose ist ungleich DCIS belegt.) <br/>
   * ORCLI-Code: CL-1809115
   */
  public static final int PAT_DCIS_TYP_INVALID2 = 359;
  /**
   * Östrogenrezeptor-Status ist ein Pflichtfeld. (Histologische Diagnose ist mit DCIS oder invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809121
   */
  public static final int PAT_OESTROGEN_REQUIRED = 360;
  /**
   * Der Wert in Östrogenrezeptor-Status ist ungültig. <br/>
   * ORCLI-Code: CL-1809124
   */
  public static final int PAT_OESTROGEN_INVALID = 361;
  /**
   * Der Wert Östrogenrezeptor-Status ist ungültig. (Histologische Diagnose ist ungleich DCIS oder invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809125
   */
  public static final int PAT_OESTROGEN_INVALID2 = 362;
  /**
   * Progesteronrezeptor-Status ist ein Pflichtfeld. (Histologische Diagnose ist mit DCIS oder invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809131
   */
  public static final int PAT_PROGESTERON_REQUIRED = 363;
  /**
   * Der Wert in Progesteronrezeptor-Status ist ungültig. <br/>
   * ORCLI-Code: CL-1809134
   */
  public static final int PAT_PROGESTERON_INVALID = 364;
  /**
   * Der Wert in Progesteronrezeptor-Status ist ungültig. (Histologische Diagnose ist ungleich DCIS oder invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809135
   */
  public static final int PAT_PROGESTERON_INVALID2 = 365;
  /**
   * pT Stadium nach UICC ist ein Pflichtfeld. (Histologische Diagnose ist mit "DCIS" oder "invasives Karzinom" belegt.) <br/>
   * ORCLI-Code: CL-1809141
   */
  public static final int PAT_PT_STADIUM_REQUIRED = 366;
  /**
   * Der Wert in pT Stadium nach UICC ist ungültig. <br/>
   * ORCLI-Code: CL-1809144
   */
  public static final int PAT_PT_STADIUM_INVALID = 367;
  /**
   * Der Wert in pT Stadium nach UICC ist ungültig. (Histologische Diagnose ist ungleich "DCIS" oder "invasives Karzinom" belegt.) <br/>
   * ORCLI-Code: CL-1809145
   */
  public static final int PAT_PT_STADIUM_INVALID2 = 368;
  /**
   * Gefäßeinbrüche (Lymphgefäße) ist ein Pflichtfeld. (Histologische Diagnose ist mit DCIS oder invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809151
   */
  public static final int PAT_LYMPHGEFAESSEINBRUCH_REQUIRED = 369;
  /**
   * Der Wert in Gefäßeinbrüche (Lymphgefäße) ist ungültig. <br/>
   * ORCLI-Code: CL-1809154
   */
  public static final int PAT_LYMPHGEFAESSEINBRUCH_INVALID = 370;
  /**
   * Der Wert Gefäßeinbrüche (Lymphgefäße) ist ungültig. (Histologische Diagnose ist ungleich DCIS oder invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809155
   */
  public static final int PAT_LYMPHGEFAESSEINBRUCH_INVALID2 = 371;
  /**
   * Gefäßeinbrüche (Blutgefäße) ist ein Pflichtfeld (Histologische Diagnose ist mit DCIS oder invasives Karzinom belegt). <br/>
   * ORCLI-Code: CL-1809161
   */
  public static final int PAT_BLUTGEFAESSEINBRUCH_REQUIRED = 372;
  /**
   * Der Wert in Gefäßeinbrüche (Blutgefäße) ist ungültig. <br/>
   * ORCLI-Code: CL-1809164
   */
  public static final int PAT_BLUTGEFAESSEINBRUCH_INVALID = 373;
  /**
   * Der Wert Gefäßeinbrüche (Blutgefäße) ist ungültig. (Histologische Diagnose ist ungleich DCIS oder invasives Karzinom belegt). <br/>
   * ORCLI-Code: CL-1809165
   */
  public static final int PAT_BLUTGEFAESSEINBRUCH_INVALID2 = 374;
  /**
   * Resektionsränder (Tumor am tuschemarkierten Resektionsrand) ist ein Pflichtfeld (Histologische Diagnose ist mit DCIS oder invasives Karzinom belegt). <br/>
   * ORCLI-Code: CL-1809171
   */
  public static final int PAT_RESEKTIONSRAENDER_REQUIRED = 375;
  /**
   * Der Wert in Resektionsränder (Tumor am tuschemarkierten Resektionsrand) ist ungültig. <br/>
   * ORCLI-Code: CL-1809174
   */
  public static final int PAT_RESEKTIONSRAENDER_INVALID = 376;
  /**
   * Der Wert in Resektionsränder (Tumor am tuschemarkierten Resektionsrand) ist ungültig. (Histologische Diagnose ist ungleich DCIS oder invasives Karzinom belegt). <br/>
   * ORCLI-Code: CL-1809175
   */
  public static final int PAT_RESEKTIONSRAENDER_INVALID2 = 377;
  /**
   * Invasiv: Invasiver Typ ist ein Pflichtfeld. (Histologische Diagnose ist mit invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809181
   */
  public static final int PAT_INVASIV_TYP_REQUIRED = 378;
  /**
   * Der Wert in Invasiv: Invasiver Typ ist ungültig. <br/>
   * ORCLI-Code: CL-1809184
   */
  public static final int PAT_INVASIV_TYP_INVALID = 379;
  /**
   * Der Wert Invasiv: Invasiver Typ ist ungültig. (Histologische Diagnose ist ungleich invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809185
   */
  public static final int PAT_INVASIV_TYP_INVALID2 = 380;
  /**
   * Invasiv: pure special type: Typ ist ein Pflichtfeld. (Invasiv: Invasiver Typ ist mit pure special belegt.) <br/>
   * ORCLI-Code: CL-1809191
   */
  public static final int PAT_INVASIV_PURE_SPECIAL_REQUIRED = 381;
  /**
   * Der Wert in Invasiv: pure special type: Typ ist ungültig. <br/>
   * ORCLI-Code: CL-1809194
   */
  public static final int PAT_INVASIV_PURE_SPECIAL_INVALID = 382;
  /**
   * Der Wert in Invasiv: pure special type: Typ  ist ungültig. (Invasiv: Invasiver Typ ist ungleich pure special belegt). <br/>
   * ORCLI-Code: CL-1809195
   */
  public static final int PAT_INVASIV_PURE_SPECIAL_INVALID2 = 383;
  /**
   * Invasiv: Intraduktale Komponente ist ein Pflichtfeld. (Histologische Diagnose ist mit invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809201
   */
  public static final int PAT_INTRADUKTALE_KOMPONENTE_REQUIRED = 384;
  /**
   * Der Wert in Invasiv: Intraduktale Komponente ist ungültig. <br/>
   * ORCLI-Code: CL-1809204
   */
  public static final int PAT_INTRADUKTALE_KOMPONENTE_INVALID = 385;
  /**
   * Der Wert in Invasiv: Intraduktale Komponente ist ungültig. (Histologische Diagnose ist ungleich invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809205
   */
  public static final int PAT_INTRADUKTALE_KOMPONENTE_INVALID2 = 386;
  /**
   * Tumorgrad nach Elston und Ellis ist ein Pflichtfeld. (Histologische Diagnose ist mit invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809211
   */
  public static final int PAT_TUMORGRAD_REQUIRED = 387;
  /**
   * Der Wert in Tumorgrad nach Elston und Ellis ist ungültig. <br/>
   * ORCLI-Code: CL-1809214
   */
  public static final int PAT_TUMORGRAD_INVALID = 388;
  /**
   * Der Wert Tumorgrad nach Elston und Ellis ist ungültig. (Histologische Diagnose ist ungleich invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809215
   */
  public static final int PAT_TUMORGRAD_INVALID2 = 389;
  /**
   * HER2 Status ist ein Pflichtfeld. (Histologische Diagnose ist mit invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809221
   */
  public static final int PAT_HER2_REQUIRED = 390;
  /**
   * Der Wert in HER2 Status ist ungültig. <br/>
   * ORCLI-Code: CL-1809224
   */
  public static final int PAT_HER2_INVALID = 391;
  /**
   * Der Wert HER2 Status ist ungültig. (Histologische Diagnose ist ungleich invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809225
   */
  public static final int PAT_HER2_INVALID2 = 392;
  /**
   * Proliferationsindex Ki67 ist ein Pflichtfeld. (Histologische Diagnose ist mit invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809231
   */
  public static final int PAT_PROLIEFERATIONSINDEX_REQUIRED = 393;
  /**
   * Der Wert in Proliferationsindex Ki67 ist ungültig. <br/>
   * ORCLI-Code: CL-1809234
   */
  public static final int PAT_PROLIEFERATIONSINDEX_INVALID = 394;
  /**
   * Der Wert Proliferationsindex Ki67 ist ungültig. (Histologische Diagnose ist ungleich invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809235
   */
  public static final int PAT_PROLIEFERATIONSINDEX_INVALID2 = 395;
  /**
   * pN Stadium nach UICC ist ein Pflichtfeld. (Histologische Diagnose ist mit invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809241
   */
  public static final int PAT_PN_STADIUM_REQUIRED = 396;
  /**
   * Der Wert in pN Stadium nach UICC ist ungültig. <br/>
   * ORCLI-Code: CL-1809244
   */
  public static final int PAT_PN_STADIUM_INVALID = 397;
  /**
   * Der Wert in pN Stadium nach UICC ist ungültig. (Histologische Diagnose ist ungleich invasives Karzinom belegt.) <br/>
   * ORCLI-Code: CL-1809245
   */
  public static final int PAT_PN_STADIUM_INVALID2 = 398;
  /**
   * Therapiedokumentation Tumor ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807001
   */
  public static final int THERAPIE_TUMOR_REQUIRED = 399;
  /**
   * Datum der Erstoperation ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807011
   */
  public static final int TUM_OPERATIONSDATUM_REQUIRED = 400;
  /**
   * Das Format von Datum der Erstoperation ist ungültig. <br/>
   * ORCLI-Code: CL-1807013
   */
  public static final int TUM_OPERATIONSDATUM_WRONG_FORMAT = 401;
  /**
   * Der Wert Datum der Erstoperation ist ungültig. <br/>
   * ORCLI-Code: CL-1807014
   */
  public static final int TUM_ZEITSTEMPELOPERATIONSDATUM_BEFUNDUNG_INVALID = 402;
  /**
   * Zustimmung zu Feedbackbericht ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807021
   */
  public static final int TUM_ZUSTIMMUNG_FEEDBACKBERICHT_REQUIRED = 403;
  /**
   * Der Wert in Zustimmung zu Feedbackbericht ist ungültig. <br/>
   * ORCLI-Code: CL-1807024
   */
  public static final int TUM_ZUSTIMMUNG_FEEDBACKBERICHT_INVALID = 404;
  /**
   * Seite ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807031
   */
  public static final int TUM_SEITE_REQUIRED = 405;
  /**
   * Der Wert in Seite ist ungültig. <br/>
   * ORCLI-Code: CL-1807034
   */
  public static final int TUM_SEITE_INVALID = 406;
  /**
   * Alle Tumore waren tastbar ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807041
   */
  public static final int TUM_TUMORE_TASTBAR_REQUIRED = 407;
  /**
   * Der Wert in Alle Tumore waren tastbar ist ungültig. <br/>
   * ORCLI-Code: CL-1807044
   */
  public static final int TUM_TUMORE_TASTBAR_INVALID = 408;
  /**
   * cTumorstadium ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807051
   */
  public static final int TUM_TUMORSTADIUM_REQUIRED = 409;
  /**
   * Der Wert in cTumorstadium ist ungültig. <br/>
   * ORCLI-Code: CL-1807054
   */
  public static final int TUM_TUMORSTADIUM_INVALID = 410;
  /**
   * cM Stadium nach UICC ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807061
   */
  public static final int TUM_STADIUM_NACH_UICC_REQUIRED = 411;
  /**
   * Der Wert in cM Stadium nach UICC ist ungültig. <br/>
   * ORCLI-Code: CL-1807064
   */
  public static final int TUM_STADIUM_NACH_UICC_INVALID = 412;
  /**
   * Größter Tumordurchmesser ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807071
   */
  public static final int TUM_TUMORDURCHMESSER_REQUIRED = 413;
  /**
   * Der Wert in Größter Tumordurchmesser ist ungültig. <br/>
   * ORCLI-Code: CL-1807074
   */
  public static final int TUM_TUMORDURCHMESSER_INVALID = 414;
  /**
   * Offene Biopsie durchgeführt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807081
   */
  public static final int TUM_OFFENE_BIOPSIE_REQUIRED = 415;
  /**
   * Der Wert in Offene Biopsie durchgeführt ist ungültig. <br/>
   * ORCLI-Code: CL-1807084
   */
  public static final int TUM_OFFENE_BIOPSIE_INVALID = 416;
  /**
   * Gefrierschnitt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807091
   */
  public static final int TUM_GEFRIERSCHNITT_REQUIRED = 417;
  /**
   * Der Wert in Gefrierschnitt ist ungültig. <br/>
   * ORCLI-Code: CL-1807094
   */
  public static final int TUM_GEFRIERSCHNITT_INVALID = 418;
  /**
   * Alle Tumore bei Erstoperation entfernt ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807101
   */
  public static final int TUM_TUMOR_ENTFERNT_REQUIRED = 419;
  /**
   * Der Wert in Alle Tumore bei Erstoperation entfernt ist ungültig. <br/>
   * ORCLI-Code: CL-1807104
   */
  public static final int TUM_TUMOR_ENTFERNT_INVALID = 420;
  /**
   * Ablatio ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807111
   */
  public static final int TUM_ABLATIO_REQUIRED = 421;
  /**
   * Der Wert in Ablatio ist ungültig. <br/>
   * ORCLI-Code: CL-1807114
   */
  public static final int TUM_ABLATIO_INVALID = 422;
  /**
   * Multifokaler Tumor ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807121
   */
  public static final int TUM_MULTIFOKAL_REQUIRED = 423;
  /**
   * Der Wert in Multifokaler Tumor ist ungültig. <br/>
   * ORCLI-Code: CL-1807124
   */
  public static final int TUM_MULTIFOKAL_INVALID = 424;
  /**
   * Neoadjuvante Therapie erhalten ist ein Pflichtfeld. <br/>
   * ORCLI-Code: CL-1807131
   */
  public static final int TUM_NEOADJUVANTE_THERAPIE_REQUIRED = 425;
  /**
   * Der Wert in Neoadjuvante Therapie erhalten ist ungültig. <br/>
   * ORCLI-Code: CL-1807134
   */
  public static final int TUM_NEOADJUVANTE_THERAPIE_INVALID = 426;
  /**
   * Größe Läsion links ist ein Pflichtfeld. (Bei einem Ergebnis (US-SCORE) gleich US4 bis US6 muss entweder Größe Läsion links oder Größe Läsion rechts angegeben werden.) <br/>
   * ORCLI-Code: CL-1805041
   */
  public static final int SUS_GROESSE_LINKS_REQUIRED = 427;

}
