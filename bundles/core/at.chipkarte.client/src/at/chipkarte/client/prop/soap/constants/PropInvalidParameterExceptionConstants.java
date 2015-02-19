package at.chipkarte.client.prop.soap.constants;

public class PropInvalidParameterExceptionConstants {
  /**
   * Es ist weder eine e-card gesteckt, noch eine gültige SV-Nummer angegeben.
   * ORCLI-Code: CL-1700002
   */
  public static final int SVNR_MISSING_NO_ECARD = 1;
  /**
   * Der Wert in SV-Nummer ist ungültig.
   * ORCLI-Code: CL-1700004
   */
  public static final int SV_NUMMER_INVALID = 2;
  /**
   * Der Wert in Konsultation ist ungültig.
   * ORCLI-Code: CL-1700006
   */
  public static final int KONSULTATION_INVALID = 3;
  /**
   * Fachinformation Version ist ein Pflichtfeld.
   * ORCLI-Code: CL-1700019
   */
  public static final int FACHINFORMATION_VERSION_REQUIRED = 4;
  /**
   * Die verwendete Version der Fachinformation ist nicht (mehr) aktuell. Die Anamnesedaten müssen erneut erfasst werden.
   * ORCLI-Code: CL-1700020
   */
  public static final int FACHINFORMATION_VERSION_INVALID = 5;
  /**
   * Anamnese ist ein Pflichtfeld.
   * ORCLI-Code: CL-1700030
   */
  public static final int ANAMNESE_REQUIRED = 6;
  /**
   * Anamnese Data ist ein Pflichtfeld.
   * ORCLI-Code: CL-1700031
   */
  public static final int ANAMNESE_DATA_REQUIRED = 7;
  /**
   * Der übergebene Parameter &lt;angegebener Codewert der unbekannten Risikogruppe bzw. des unbekannten Risikofaktors&gt; ist nicht
   * bekannt.
   * ORCLI-Code: CL-1700021
   */
  public static final int ANAMNESE_DATA_PARAMETER_INVALID = 8;
  /**
   * Die Bedingung der Risikogruppe &lt;Anzeigetext Risikogruppe laut Fachinformationen&gt; setzt eine Pflichtangabe der Gruppe und
   * eines Risikofaktors voraus.
   * ORCLI-Code: CL-1700022
   */
  public static final int RISIKOGRUPPE_REQUIRED = 9;
  /**
   * Die Angabe des Risikofaktor &lt;Anzeigetext des Risikofaktors&gt; in der Riskogruppe &lt;Anzeigetext der Risikogruppe&gt; ist
   * ungültig.
   * ORCLI-Code: CL-1700023
   */
  public static final int RISIKOFAKTOR_NOT_ALLOWED = 10;
  /**
   * In der Risikogruppe &lt;Anzeigetext der Risikogruppe&gt; muss ein Risikofaktor angegeben werden. ORCLI-Code: CL-1700024
   */
  public static final int RISIKOGRUPPE_RISIKOFAKTOR_NOT_SET = 11;
  /**
   * Das Format der Kennung ist ungültig.
   * ORCLI-Code: CL-1700005
   */
  public static final int KENNUNG_WRONG_FORMAT = 12;
  /**
   * Das Bis-Datum darf nicht vor dem Von-Datum liegen.
   * ORCLI-Code: CL-1700008
   */
  public static final int VON_DATUM_VOR_BIS_DATUM = 13;
  /**
   * Das Format von Von-Datum ist ungültig.
   * ORCLI-Code: CL-1700011
   */
  public static final int VON_DATUM_WRONG_FORMAT = 14;
  /**
   * Das Format von Bis-Datum ist ungültig.
   * ORCLI-Code: CL-1700012
   */
  public static final int BIS_DATUM_WRONG_FORMAT = 15;
  /**
   * Der Wert in Sprache Code ist ungültig.
   * ORCLI-Code: CL-1700017
   */
  public static final int SPRACHE_CODE_INVALID = 16;
  /**
   * Der Risikofaktor &lt;Anzeigetext Risikofaktor&gt; in der Riskogruppe &lt;Anzeigetext der Risikogruppe&gt; wurde mehrfach
   * übergeben.
   * ORCLI-Code: CL-1700025
   */
  public static final int RISIKOFAKTOR_SET_SEVERAL_TIMES = 17;
  /**
   * Der Codewert im Objekt Risikogruppe ist ein Pflichtfeld. Bei mindestens eine Risikogruppe wurde kein Codewert angegeben.
   * ORCLI-Code: CL-1700026
   */
  public static final int RISIKOGRUPPE_CODE_REQUIRED = 18;
  /**
   * Der Codewert in Objekt Risikofaktor ist ein Pflichtfeld. Bei mindestens einen Risikofaktor wurde kein Codewert angegeben.
   * ORCLI-Code: CL-1700027
   */
  public static final int RISIKOFAKTOR_CODE_REQUIRED = 19;
  /**
   * Die Risikogruppe &lt;Anzeigetext der Risikogruppe&gt; wurde mehrfach übergeben.
   * ORCLI-Code: CL-1700028
   */
  public static final int RISIKOGRUPPE_SET_SEVERAL_TIMES = 20;
  /**
   * In der Risikogruppe &lt;Anzeigetext der Risikogruppe&gt; muss mindestens ein Risikofaktor angegeben werden.
   * ORCLI-Code:
   * CL-1700029
   */
  public static final int RISIKOGRUPPE_RISIKOFAKTOR_REQUIRED = 21;
  /**
   * Der Wert in Von-Datum und/oder Bis-Datum ist ungültig. Der Suchzeitraum darf nicht in der Zukunft liegen.
   * ORCLI-Code: CL-1700033
   */
  public static final int VON_BIS_DATUM_INVALID = 23;

  /**
   * Der Fachgebietscode ist ungültig.
   * ORCLI-Code: CL-A0015
   */
  public static final int FG_INVALID = 24;
  /**
   * In der Risikogruppe &lt;Anzeigetext der Risikogruppe&gt; darf nur ein Risikofaktor angegeben werden.
   * ORCLI-Code: CL-1700034
   */
  public static final int TOO_MANY_RISIKOFAKTOR_FOR_RISIKOGRUPPE = 25;
  /**
   * Es existiert keine Berechtigung zur Erfassung eines Präoperativen Befundes mit Bindung an eine Konsultation.
   * ORCLI-Code: CL-1700035
   */
  public static final int BEFUND_WITH_KONS_NOT_ALLOWED = 26;
  
  /** 
   * Der Wert in Geburtsdatum ist ungültig.
   *ORCLI-Code:CL-1700014
   */
   public static final int GEBURTSDATUM_INVALID = 27;

  /** 
   * Bei Angabe der SV-Nummer ist die Angabe von Patientendaten nicht zulässig.
   *ORCLI-Code:CL-1700036
   */
   public static final int SV_NUMMER_AND_EKVKPATIENT_NOT_ALLOWED = 28;

  /** 
   * Bei Angabe von Patientendaten ist die Angabe einer Konsultation nicht zulässig.
   *ORCLI-Code:CL-1700037
   */
   public static final int EKVKPATIENT_AND_KONSULTATION_NOT_ALLOWED = 29;

  /** 
   * Bei der Erfassung eines Präoperativen Befundes muss entweder eine e-card gesteckt, werden oder eine gültige SV-Nummer oder bzw. Patientendaten erfasst werden.
   *ORCLI-Code:CL-1700038
   */
   public static final int SV_NUMMER_EKVKPATIENT_OR_ECARD_REQUIERED = 30;

  /** 
   * Das Format von Protokollnummer ist ungültig.
   *ORCLI-Code:CL-1700041
   */
   public static final int PROTOKOLLNUMMER_WRONG_FORMAT = 31;

  /** 
   * Es muss entweder die Protokollnummer oder die Kombination aus SV-Nummer und Kennung angegeben werden.
   *ORCLI-Code:CL-1700042
   */
   public static final int PROTOKOLLNUMMER_OR_SV_NUMMER_AND_KENNUNG_REQUIRED = 32;

  /** 
   * Das Format von Ersteller-Id ist ungültig.
   *ORCLI-Code:CL-1700043
   */
   public static final int ARZTID_WRONG_FORMAT = 33;

  /** 
   * Das Format von Erstellername ist ungültig.
   *ORCLI-Code:CL-1700044
   */
   public static final int ARZTNAME_WRONG_FORMAT = 34;

  /** 
   * Vorname ist ein Pflichtfeld.
   *ORCLI-Code:CL-1700045
   */
   public static final int VORNAME_REQUIRED = 35;

  /** 
   * Das Format von Vorname ist ungültig.
   *ORCLI-Code:CL-1700046
   */
   public static final int VORNAME_WRONG_FORMAT = 36;

  /** 
   * Fam.name ist ein Pflichtfeld.
   *ORCLI-Code:CL-1700047
   */
   public static final int FAMNAME_REQUIRED = 37;

  /** 
   * Das Format von Fam.name ist ungültig.
   *ORCLI-Code:CL-1700048
   */
   public static final int FAMNAME_WRONG_FORMAT = 38;

  /** 
   * Geschlecht ist ein Pflichtfeld.
   *ORCLI-Code:CL-1700049
   */
   public static final int GESCHLECHT_REQUIRED = 39;

  /** 
   * Der Wert in Geschlecht ist ungültig.
   *ORCLI-Code:CL-1700050
   */
   public static final int GESCHLECHT_INVALID = 40;

  /** 
   * Das Format von EKVK-Nummer ist ungültig.
   *ORCLI-Code:CL-1700051
   */
   public static final int EKVKNUMMER_WRONG_FORMAT = 41;

  /** 
   * Geburtsdatum ist ein Pflichtfeld
   *ORCLI-Code:CL-1700052
   */
   public static final int GEBURTSDATUM_REQUIRED = 42;
   /** 
    * Die Angabe von Kommentaren ist nur bei Speicherung des Präoperativen Befundes zulässig.
    * ORCLI-Code:CL-1700053
    */
   public static final int KOMMENTARE_WITHOUR_SAVE_NOT_ALLOWED = 43;

   /** 
    * Bei Angabe von Befund-Kommentaren muss entweder der Generelle Kommentar und/oder mindestens ein Untersuchungsgruppen-Kommentar angegeben werden.
    * ORCLI-Code:CL-1700054
    */
   public static final int BEFUNDKOMMENTAR_GENERELL_OR_GRUPPE_REQUIRED = 44;

   /** 
    * Das Format des Generellen Kommentars zum Präoperativen Befund ist ungültig.
    * ORCLI-Code:CL-1700055
    */
   public static final int KOMMENTAR_GENERELL_TEXT_WRONG_FORMAT = 45;

   /** 
    * Das Format des Kommentars zur Untersuchungsgruppe <UG> ist ungültig.
    * ORCLI-Code:CL-1700056
    */
   public static final int KOMMENTAR_GRUPPE_TEXT_WRONG_FORMAT = 46;

   /** 
    * Das Format des Codes zum zur Untersuchungsgruppen-Kommentar <UG> ist ungültig.
    * ORCLI-Code:CL-1700057
    */
   public static final int KOMMENTAR_GRUPPE_CODE_WRONG_FORMAT = 47;

   /** 
    * Der Code für einen Untersuchungsgruppen-Kommentar <UG> ist mehrfach angegeben.
    * ORCLI-Code:CL-1700058
    */
   public static final int KOMMENTAR_GRUPPE_CODE_SET_SEVERAL_TIMES = 48;

   /** 
    * Bei Angabe eines Gruppenkommentars muss sowohl der Untersuchungsgruppen Code, als auch der Kommentartext angegeben werden.
    * ORCLI-Code:CL-1700059
    */
   public static final int GRUPPEKOMMENTAR_TEXT_AND_CODE_REQUIRED = 49;
}
