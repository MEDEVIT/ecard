/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap.constants;

/**
 * <p>
 * Fehlerkonstanten, wenn ein ung&uuml;ltiger Parameter in einer Funktion angegeben
 * wird.
 * </p>
 */
public class AumInvalidParameterExceptionConstants {

  /**
   * Das Feld <i>BesondereArbeitsunfaehigkeitsursacheCode</i>
   * hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03514
   */
  public static final int BESONDERE_URSACHE_INVALID     = 3;
  /**
   * Das Feld <i>GehunfaehigBis</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03293
   */
  public static final int GEHUNFAEHIG_INVALID           = 5;
  /**
   * Das Feld <i>GipsBis</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03303
   */
  public static final int DATE_GIPSBIS_INVALID          = 6;
  /**
   * Das Feld <i>GipsBis</i> hat einen ungültigen Wert (Datum muss größer oder gleich
   * dem Datum von <i>ArbeitsunfaehigVon</i> sein).
   * <br>ORCLI-Code: CL-03304
   */
  public static final int DATE_GIPS_BIS_WRONG_VALUE     = 3304;
  /**
   * Das Feld <i>Wiederbestellung</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03283
   */
  public static final int DATE_WIEDERBESTELLUNG_INVALID = 7;
  /**
   * Das Feld <i>BesondereMitteilungAnSVT</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03543
   */
  public static final int MITTEILUNG_INVALID            = 8;
  /**
   * Die Personendaten dürfen nicht null sein.
   * <br>ORCLI-Code: CL-03087
   */
  public static final int PERSON_REQUIRED               =  3087;
  /**
   * Das Pflichtfeld <i>EkvkTraeger</i> ist nicht gesetzt (bei EKVK-Patienten).
   * <br>ORLCI-Code: CL-03431
   */
  public static final int EKVKTRAEGER_REQUIRED          = 9; 
  /**
   * Das Feld <i>EkvkTraeger</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03433
   */
  public static final int EKVKTRAEGER_INVALID           = 10;
  /**
   * Das Pflichtfeld <i>EkvkNummer</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03421
   */
  public static final int EKVK_NUMMER_REQUIRED          = 4;
  /**
   * Das Feld <i>EkvkNummer</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03423
   */
  public static final int EKVK_NUMMER_INVALID           = 11;
  /**
   * Es ist keine e-card gesteckt und keine Sozialversicherungsnummer angegeben.
   * <br>ORCLI-Code: CL-03205
   */
  public static final int SV_NUMMER_REQUIRED            = 13;
  /**
   * <i>SvNummer</i> ist ein Pflichtfeld.
   * <br>ORCLI-Code: CL-03201
   */
  public static final int SV_NUMMER_REQUIRED2            = 3201;    
  /**
   * Das Feld  <i>SvNummer</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03204
   */
  public static final int SV_NUMMER_INVALID              = 14;
  /**
   * Das Pflichtfeld <i>Vorname</i> ist nicht gesetzt (für EKVK-Patienten).
   * <br>ORCLI-Code: CL-03391
   */
  public static final int VORNAME_REQUIRED              = 15;
  /**
   * Das Feld <i>Vorname</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03393
   */
  public static final int VORNAME_INVALID               = 16;
  /**
   * Das Pflichtfeld <i>Zuname</i> ist nicht gesetzt (für EKVK-Patienten).
   * <br>ORCLI-Code: CL-03401
   * <br><br>
   * Wenn das Feld <i>Vorname</i> gesetzt ist, 
   * muss auch das Feld <i>Zuname</i> gesetzt sein.
   * <br>ORCLI-Code: CL-03048
   */
  public static final int NACHNAME_REQUIRED             = 17;
  /**
   * Das Feld <i>Zuname</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03403
   */
  public static final int NACHNAME_INVALID              = 18;
  /**
   * Das Pflichtfeld <i>Geschlecht</i> ist nicht gesetzt (für EKVK-Patienten).
   * <br>ORCLI-Code: CL-03411
   */
  public static final int GESCHLECHT_REQUIRED           = 19; 
  /**
   * Das Feld <i>Geschlecht</i> hat einen ungültigen Wert. 
   * <br>ORCLI-Code: CL-03414
   */
  public static final int GESCHLECHT_INVALID            = 20;
  /**
   * Das Pflichtfeld <i>ArbeitsunfaehigVon</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03221
   */
  public static final int AU_VON_REQUIRED               = 21;
  /**
   * Der Wert in <i>ArbeitsunfaehigVon</i> ist kein gültiges Datum.
   * <br>ORCLI-Code: CL-03223
   */
  public static final int AU_VON_INVALID                = 22;
  /**
   * Der Wert in <i>ArbeitsunfaehigVon</i> ist ungültig.
   * <br>ORCLI-Code: CL-03225 
   */
  public static final int AU_VON_OUT_OF_RANGE           = 23;
  /**
   * Das Pflichtfeld <i>ArbeitsunfaehigBis</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03231
   */
  public static final int AU_BIS_REQUIRED               = 24;
  /**
   * Der Wert in <i>ArbeitsunfaehigBis</i> ist kein gültiges Datum.
   * <br>ORCLI-Code: CL-03233
   */
  public static final int AU_BIS_INVALID                 = 25;
  /**
   * Das Datum von <i>ArbeitsunfaehigBis</i> weicht mehr als 300 Tage vom
   * aktuellen Datum ab.
   * <br>ORCLI-Code: CL-03235 
   */
  public static final int AU_BIS_OUT_OF_RANGE           = 26;
  /**
   * Das Feld <i>VoraussichtlichArbeitsunfaehigBis</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03243
   */
  public static final int VORAUSS_ENDE_AU_INVALID       = 27;
  /**
   * Der Wert von <i>AbweichendeAusgehzeitVon1</i> ist ungültig. 
   * <br>ORCLI-Code: CL-03313
   */
  public static final int TIME_AUSGEHVON1_INVALID        = 29;
  /**
   * Der Wert von <i>AbweichendeAusgehzeitBis1</i> ist ungültig. 
   * <br>ORCLI-Code: CL-03323
   */
  public static final int TIME_AUSGEHBIS1_INVALID         = 30;
  /**
   * Der Wert von <i>AbweichendeAusgehzeitVon2</i> ist ungültig. 
   * <br>ORCLI-Code: CL-03333
   */
  public static final int TIME_AUSGEHVON2_INVALID         = 31;
  /**
   * Der Wert von <i>AbweichendeAusgehzeitBis2</i> ist ungültig. 
   * <br>ORCLI-Code: CL-03343
   */
  public static final int TIME_AUSGEHBIS2_INVALID         = 32;
  /**
   * Wenn eines der Felder <i>DiagnoseCode</i> oder <i>DiagnoseCodeTyp</i> gesetzt ist, müssen beide gesetzt sein.
   * <br>ORCLI-Code: CL-03021
   */
  public static final int NEED_DIAGNOSE_CODE_AND_TYPE      = 33;
  /**
   * Das Feld <i>DiagnoseCodeTyp</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03504
   */
  public static final int DIAGNOSECODETYP_INVALID       = 34;
  /**
   * Das Feld <i>DiagnoseCode</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03583
   */
  public static final int DIAGNOSECODE_INVALID          = 35;
  /**
   * Es muss entweder die <i>Diagnose</i> oder die Kombination aus <i>DiagnoseCode</i> und <i>DiagnoseCodeTyp</i> angegeben werden.
   * <br>ORCLI-Code: CL-03251
   */
  public static final int DIAGNOSE_REQUIRED              = 36;
  /**
   * Das Feld <i>Diagnose</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03253
   */
  public static final int DIAGNOSE_INVALID              = 37;
  /**
   * Das Feld <i>ZusatzDiagnoseCode</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03554
   */
  public static final int ZUSATZDIAGNOSE_INVALID        = 39;
  /**
   * Das Pflichtfeld <i>SvtCode</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03211
   */
  public static final int SVT_REQUIRED                  = 43;
  /**
   * Das Feld <i>SvtCode</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03214
   * <br><br>
   * Der angegebene KVT ist nicht der GKK/BKK-Träger 
   * des Bundeslandes, in dem sich die Ordination befindet.
   * <br>ORCLI-Code: ZS-03009
   */
  public static final int SVT_INVALID                   = 40;
  /**
   * Das Feld <i>KrankenhausaufenthaltVon</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03263
   */
  public static final int KH_VON_INVALID             = 41;
  /**
   * Das Feld <i>KrankenhausaufenthaltVon</i> hat einen ungültigen Wert (Datum muss 
   * kleiner oder gleich dem Datum von <i>BehandlungsDatum</i> sein).
   * <br>ORCLI-Code: CL-03264
   */
  public static final int KH_VON_WRONG_VALUE            = 3264;
  /**
   * Das Feld <i>KrankenhausaufenthaltBis</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03273
   */
  public static final int KH_BIS_INVALID            = 42;
  /**
   * Das Feld <i>KrankenhausaufenthaltBis</i> hat einen ungültigen Wert (Datum muss 
   * kleiner oder gleich dem Datum von <i>BehandlungsDatum</i> sein).
   * <br>ORCLI-Code: CL-03274
   */
  public static final int KH_BIS_WRONG_VALUE            = 3274;
  /**
   * Das Pflichtfeld <i>AufId</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03451
   */
  public static final int ID_REQUIRED                   = 44;
  /**
   * Das Feld <i>AufId</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03453
   */
  public static final int ID_INVALID                    = 45;
  /**
   * Das Pflichtfeld <i>Meldungsart</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03381
   */
  public static final int MELDUNGSART_REQUIRED           = 47;
  /**
   * Das Feld <i>Meldungsart</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03384
   */
  public static final int MELDUNGSART_INVALID           = 48;
  /**
   * Das Pflichtfeld <i>ErstellungAb</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03361
   */
  public static final int ZEITRAUM_VON_REQUIRED         = 50;
  /**
   * Das Feld <i>ErstellungAb</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03363
   */
  public static final int ZEITRAUM_VON_INVALID         = 51;
  /**
   * Das Pflichtfeld <i>ErstellungBis</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03371
   */
  public static final int ZEITRAUM_BIS_REQUIRED        = 52;
  /**
   * Das Feld <i>ErstellungBis</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03373
   */
  public static final int ZEITRAUM_BIS_INVALID        = 53;
  /**
   * Das Pflichtfeld <i>aufIdVersion</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03461 / ZS-03016
   */
  public static final int VERSION_REQUIRED              = 54; 
  /**
   * Das Feld <i>aufIdVersion</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03463
   */
  public static final int VERSION_INVALID               = 55; 
  /**
   * Das Pflichtfeld <i>Strasse</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03471
   */
  public static final int STRASSE_REQUIRED              = 3471;
  /**
   * Das Feld <i>Strasse</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03473
   */
  public static final int STRASSE_INVALID               = 56; 
  /**
   * Das Pflichtfeld <i>Plz</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03481
   */
  public static final int PLZ_REQUIRED                  = 3481;
  /**
   * Das Feld <i>Plz</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03483
   */
  public static final int PLZ_INVALID                   = 57;
  /**
   * Das Pflichtfeld <i>Ort</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03491
   */
  public static final int  ORT_REQUIRED                 = 3491;
  /**
   * Das Feld <i>Ort</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03493
   */
  public static final int ORT_INVALID                   = 58;
  /**
   * Das Pflichtfeld <i>RuckdatierungsgrundCode</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03561
   */
  public static final int RUECKDATIERUNGSGRUND_REQUIRED = 3561;
  /**
   * Das Feld <i>RueckdatierungsgrundCode</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03564
   */
  public static final int RUECKDATIERUNGSGRUND_INVALID  = 59;
  
  /**
   * Zu viele Ergebnisse. Bitte schränken Sie Ihre Abfrage ein.
   * <br>ORCLI-Code: ZS-03035
   */
  public static final int MAX_SUCHERGEBNISSE_EXCEEDED   = 60;
  
  /**
   * Das Feld <i>Berufskrankheit</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03594
   */
  public static final int BERUFSKRANKHEIT_INVALID       = 61;
  /**
   * Der Eingabeparameter <i>Meldungsdaten</i> darf nicht null sein.
   * <br>ORCLI-Code: CL-03080
   */
  public static final int MELDUNGSDATEN_REQUIRED        = 62;
  /**
   * Beim Ändern einer Meldung muss die geänderte (und somit neu gültige) Meldung (<i>MeldungNeu</i>) in der Funktion angegeben sein.
   * <br>ORCLI-Code: CL-03083
   */
  public static final int MELDUNG_NEU_REQUIRED          = 65;
  /**
   * Im Zuge der Suche von Meldungen muss das Objekt mit den Suchkriterien angegeben werden 
   * (<i>suche</i> bei der Funktion <i>selbstErstelltMeldungenSuchen()</i> beziehungsweise <i>suchparameterSvPerson</i> bei
   * der Funktion <i>meldungenFuerSvPersonSuchen()</i>).
   * <br>ORCLI-Code: CL-03086
   */
  public static final int SUCHE_REQUIRED                = 68;
  /**
   * Das Pflichtfeld <i>BehandlungsDatum</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03611
   */
  public static final int BEHANDLUNGSDATUM_REQUIRED     = 3611;
  /**
   * Das Feld <i>BehandlungsDatum</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03613
   */
  public static final int BEHANDLUNGSDATUM_INVALID      = 3613;
  /**
   * Das Feld <i>BehandlungsDatum</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03614
   */
  public static final int BEHANDLUNGSDATUM_WRONG_VALUE  = 3614;
  
  /**
   * Das Pflichtfeld <i>Geburtsdatum</i> ist nicht gesetzt.
   * <br>ORCLI-Code: CL-03621
   */
  public static final int GEBURTSDATUM_REQUIRED = 3621;
  /**
   * Das Feld <i>Geburtsdatum</i> hat ein ungültiges Format.
   * <br>ORCLI-Code: CL-03623
   */
  public static final int GEBURTSDATUM_INVALID = 3623;
  
  /**
   * Das Feld <i>Geburtsdatum</i> hat einen ungültigen Wert.
   * <br>ORCLI-Code: CL-03624
   */
  public static final int GEBURTSDATUM_WRONG_VALUE = 3624;
} 