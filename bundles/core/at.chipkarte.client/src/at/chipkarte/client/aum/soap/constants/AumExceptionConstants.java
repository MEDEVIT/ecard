/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.aum.soap.constants;

/**
 * <p>
 * Fachliche Fehlerkonstanten des elektronischen Arbeitsunfähigkeitsmeldungsservice (AUM).
 * </p>
 */
public class AumExceptionConstants {
  /**
   * Der Patient hat keinen für das elektronische Arbeitsunfähigkeitsmeldungsservice 
   * gültigen Versicherungsanspruch.
   * <br>ORCLI-Code: ZS-03001
   */
  public static final int NO_ANSPRUCH                   = 101;
  /**
   * Der Patient hat beim angegebenen KVT keinen für das elektronische 
   * Arbeitsunfähigkeitsmeldungsservice gültigen Anspruch,
   * aber bei einem oder mehreren anderen.
   * <br>ORCLI-Code: ZS-03003
   */
  public static final int NO_ANSPRUCH_SVT               = 102;
  /**
   * Der Patient hat nur abgeleitete Ansprüche.
   * <br>ORCLI-Code: ZS-03002
   */
  public static final int ONLY_ABGELEITETER_ANSPRUCH    = 103;
  /**
   *  Auf diese Meldung kann nicht zugegriffen werden,
   *  weil sie von einem anderen Vertragspartner angelegt wurde.
   *
   * Sie haben nicht die Berechtigung, die Meldung anzusehen,
   * weil sie von einem anderen Benutzer angelegt wurde.
   * <br>ORCLI-Code: ZS-03013 / ZS-03034
   */
  public static final int ACCESS_NOT_ALLOWED            = 106;
  /**
   * Die Meldung kann nicht geändert oder gelöscht werden,
   * weil sie inzwischen geändert wurde.
   * Bitte aktualisieren Sie Ihren Datenbestand.
   * <br>ORLCI-Code: ZS-03011
   */
  public static final int MELDUNG_NOT_AKTUELL           = 107;
  /**
   * Auf diese Meldung kann nicht mehr zugegriffen werden, weil sie
   * mittlerweile storniert wurde.
   * <br>ORCLI-Code: ZS-03010
   */
  public static final int ID_STORNIERT                  = 116;
  /**
   * Wenn die SV-Nummer angegeben ist,
   * darf das Feld <i>Vorname</i> nicht gesetzt sein.
   * <br>ORCLI-Code: CL-03046
   */
  public static final int SVNR_OR_VORNAME               = 118;
  /**
   * Wenn die SV-Nummer angegeben ist,
   * darf das Feld <i>Zuname</i> nicht gesetzt sein.
   * <br>ORCLI-Code: CL-03047
   */
  public static final int SVNR_OR_NACHNAME              = 119;
  /**
   * Wenn die SV-Nummer angegeben ist,
   * darf das Feld <i>Geburtsdatum</i> nicht gesetzt sein.
   * <br>ORCLI-Code: CL-03053
   */
  public static final int SVNR_OR_GEBURTSDATUM          = 3053;
  /**
   * Das Datum von <i>ArbeitsunfaehigVon</i> muss kleiner oder gleich dem Datum
   * von <i>ArbeitsunfaehigBis</i> (Letzter Tag der AU) sein.
   * <br>ORCLI-Code: CL-03014 / ZS-03037
   */
  public static final int AU_BIS_VOR_AU_VON             = 120;
  /**
   * Das Datum von <i>ArbeitsunfaehigVon</i> muss kleiner oder gleich dem Datum
   * von <i>VoraussichtlichArbeitsunfaehigBis</i> sein.
   * <br>ORCLI-Code: CL-03015
   */
  public static final int VORAUSS_ENDE_AU_VOR_AU_VON    = 121;
  /**
   * Das Datum von <i>KrankenhausaufenthaltBis</i> muss größer oder gleich dem Datum
   * von <i>KrankenhausaufenthaltVon</i> sein.
   * <br>ORCLI-Code: CL-03019
   */
  public static final int KH_BIS_VOR_KH_VON             = 122;
  /**
   * Wenn das Feld <i>Diagnose</i> gesetzt ist, dürfen nicht
   * gleichzeitig die Felder <i>DiagnoseCode</i> und/oder <i>DiagnoseCodetyp</i> gesetzt sein.
   * <br>ORCLI-Code: CL-03020
   */
  public static final int DIAGNOSE_XOR_DIAGNOSECODE_REQUIRED = 123;
  /**
   * Wenn das Feld <i>EkvkNummer</i> gesetzt ist, darf die SV-Nummer nicht
   * angegeben sein.
   * <br>ORCLI-Code: CL-03034
   */
  public static final int EKVK_XOR_SV_NUMMER              = 124;
  /**
   * Die SV-Nummer existiert nicht.
   * <br>ORCLI-Code: ZS-03008
   */
  public static final int SV_NUMMER_NOT_EXISTS           = 126;
  /**
   * Die gesuchte Meldung existiert nicht im e-card-System.
   * Möglicherweise wurde sie wegen Zeitablauf gelöscht.
   * <br>ORCLI-Code: ZS-03012
   */
  public static final int MELDUNG_NOT_FOUND             = 128;
  /**
   * Der Wert für <i>AbweichendeAusgehzeitVon1</i> muss kleiner
   * sein als der Wert für <i>AbweichendeAusgehzeitBis1</i>.
   * <br>OCLI-Code: CL-03025
   */
  public static final int AUSGEH_BIS1_VOR_VON            = 129;
  /**
   * Der Wert für <i>AbweichendeAusgehzeitVon2</i> muss kleiner
   * sein als der Wert für <i>AbweichendeAusgehzeitBis2</i>.
   * <br>OCLI-Code: CL-03028
   */
  public static final int AUSGEH_BIS2_VOR_VON            = 130;
  /**
   * Der Wert von <i>ErstellungBis</i> muss größer oder gleich dem Wert
   * von <i>ErstellungAb</i> sein.
   * <br>ORCLI-Code: CL-03045
   */
  public static final int AUSSTELLUNGSDATUM_BIS_VOR_VON = 131;
  /**
   * Die Meldung kann nicht an die ausgewählten KVTs geschickt werden,
   * da Sie mit dem KVT keinen gültigen Vertrag haben.
   * <br>ORCLI-Code: ZS-03019
   */
  public static final int NO_VPANSPRUCH_FOR_SVT         = 133;
  /**
   *  Der Patient hat nur Ansprüche bei KVTs,
   *  die nicht an der elektronischen Arbeitsunfähigkeitsmeldung
   *  teilnehmen.
   *  <br>ORCLI-Code: ZS-03021
   */
  public static final int NO_AUM_SVT                    = 135;
  /**
   * Wenn eines der Felder <i>AbweichendeAusgehzeitVon1</i> oder
   * <i>AbweichendeAusgehzeitBis1</i> gesetzt ist,
   *  müssen beide gesetzt sein.
   * <br>ORCLI-Code: CL-03070
   */
  public static final int NEED_BOTH_AUSGANG1            = 136;
  /**
   * Wenn eines der Felder <i>AbweichendeAusgehzeitVon2</i> oder
   * <i>AbweichendeAusgehzeitBis2</i> gesetzt ist,
   *  müssen beide gesetzt sein.
   *  <br>ORCLI-Code: CL-03071
   */
  public static final int NEED_BOTH_AUSGANG2            = 137;
  /**
   * Wenn eines der Felder <i>KrankenhausaufenthaltBis</i>
   * oder <i>KrankenhausaufenthaltVon</i> gesetzt ist, müssen beide
   * gesetzt sein.
   * <br>ORCLI-Code: CL-03018
   */
  public static final int KH_BIS_WITHOUT_VON              = 140;
  /**
   * Das Datum von <i>Wiederbestellung</i> muss
   * größer oder gleich dem Datum von <i>ArbeitsunfaehigVon</i> sein.
   * <br>ORCLI-Code: CL-03035
   */
  public static final int WIEDERBESTELLT_VOR_AU_VON       = 141;
  /**
   * Es ist ein unerwarteter Fehler aufgetreten.
   * <br>ORCLI-Code: CL-S0012
   */
  public static final int INTERNAL_ERROR                = 200;
  /**
   * Wenn die SV-Nummer angegeben ist,
   * dürfen <i>Vorname</i>, <i>Zuname</i> und <i>Geburtsdatum</i> nicht gesetzt sein.
   * <br>ORCLI-Code: CL-03051
   */
  public static final int PERSON_DATA_INCONSISTENT      = 3051;
  /**
   * Für Meldungen, die geprüft werden müssen, dürfen die Felder
   * <i>Vorname</i>, <i>Zuname</i> und <i>Geburtsdatum</i> nicht angegeben werden.
   * <br>ORCLI-Code: CL-03054
   */
  public static final int PERSON_DATA_FORBIDDEN         = 3054;
  /**
   * Für nicht zu prüfende Meldungen dürfen die Felder
   * <i>EkvkNummer</i> und <i>EkvkTraeger</i> nicht gesetzt sein.
   * <br>ORCLI-Code: CL-03055
   */
  public static final int EKVK_FORBIDDEN                = 3055;
  /**
   * Für nicht zu prüfende Meldungen darf nicht <i>AL</i> ("alle KVTs") gewählt werden.
   * <br>ORCLI-Code: CL-03056
   */
  public static final int ALLE_SVT_INVALID              = 3056;
  /**
   * Der KVT darf für diese Meldung nicht verändert werden.
   * <br>ORCLI-Code: ZS-03006
   */
  public static final int KVT_MODIFICATION_NOT_ALLOWED  = 13006;
  /**
   * Der Patient hat nur Ansprüche, die für
   * qualifizierte Sachleistungen S1/S2 berechtigen
   * und für die elektronische Arbeitsunfähigkeitsmeldung ungültig sind.
   * <br>ORCLI-Code: ZS-03024
   */
  public static final int QUASA_ONLY                    = 13024;
  /**
   * Der Patient hat nur Ansprüche bei der BVA
   * und gehört zur Versichertenkategorie B (Beamter).
   * Deshalb kann für diesen Patienten keine Arbeitsunfähigkeitsmeldung angelegt werden.
   * <br>ORCLI-Code: ZS-03026
   */
  public static final int BVA_BEAMTER                   = 13026;
  /**
   * Die Meldung kann nicht "ohne Anspruchsprüfung" (<i>ungeprueft</i> = </i>true</i>)
   * oder für EKVK-Patienten erstellt werden, da der Patient
   * für das elektronische Arbeitsunfähigkeitsmeldungsservice gültige Ansprüche hat
   * oder die lokale GKK nicht am elektronischen Arbeitsunfähigkeitsmeldungsservice teilnimmt.
   * <br>ORCLI-Code: ZS-03027
   */
  public static final int ANSPRUCH_EXISTS               = 13027;
  /**
   * Die Karte ist gesperrt: {Sperrgrund}.
   * <br>ORCLI-Code: ZS-03053
   */
  public static final int CARD_INVALID             = 3050;
  /**
   * Die SV-Nummer der Karte ist ungleich der angegebenen SV-Nummer.
   * Bitte überprüfen Sie die gesteckte Karte.
   * <br>ORCLI-Code: ZS-03055
   */
  public static final int SV_NUMMERS_DIFFERENT     = 3055;
  /**
   * Es existiert bereits eine offene Meldung mit der angegebenen
   * SV-Nummer für den angegebenen KVT.
   * <br>ORCLI-Code: ZS-03052
   */
  public static final int OPEN_MELDUNG_EXISTS      = 3052;
  /**
   * Das Datum <i>ArbeitsunfaehigBis</i> (Letzter Tag der AU) darf nicht gelöscht werden.
   * <br>ORCLI-Code: ZS-03060
   */
  public static final int MUST_NOT_DELETE_AU_BIS   = 3060;
  /**
   * Diese Meldung ist eine reine AF-Meldung, die Funktion
   * <i>auEndeBearbeiten()</i> darf nicht auf sie angewendet werden.
   * <br>ORCLI-Code: ZS-03061
   */
  public static final int INVALID_FOR_AF           = 3061;
  /**
   * Diese Meldung ist bereits abgelaufen und kann daher nicht mehr
   * verändert oder storniert werden.
   * <br>ORCLI-Code: ZS-03062
   */
  public static final int MELDUNG_EXPIRED          = 3062;
}
