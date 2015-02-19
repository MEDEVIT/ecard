package at.chipkarte.client.dbas.soap.constants;

/**
 * Fehlerkonstanten für die DbasInvalidParameterException
 */
public class DbasInvalidParameterExceptionConstants {
	/**
	* Der Wert in "SV-Nummer" ist nicht zulässig.
	* ORCLI-Code: CL-1290014
	*/
	public static final int SV_NUMMER_INVALID = 1290014;
	/**
	* Es ist keine e-card gesteckt und keine Sozialversicherungsnummer angegeben.
	* ORCLI-Code: CL-1200002
	*/
	public static final int SVNR_MISSING_NO_ECARD = 1200002;
	/**
	* Das gewählte Dokumentations-/Befundblatt ist für die angegebene SV-Person nicht erlaubt.
	* ORCLI-Code: CL-1200007
	*/
	public static final int DOKUMENT_FOR_SV_PERSON_INVALID = 1200007;
	/**
	* "DatenblattAllgemeinesProgramm" ist ein Mussfeld.
	* ORCLI-Code: CL-1201001
	*/
	public static final int DATENBLATT_ALLGEMEINES_PROGRAMM_REQUIRED = 1201001;
	/**
	* "Anschrift" ist ein Mussfeld.
	* ORCLI-Code: CL-1201111
	*/
	public static final int AMP_ANSCHRIFT_REQUIRED = 1201111;
	/**
	* "Anschrift" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201113
	*/
	public static final int AMP_ANSCHRIFT_WRONG_FORMAT = 1201113;
	/**
	* "Postleitzahl" ist ein Mussfeld.
	* ORCLI-Code: CL-1201121
	*/
	public static final int AMP_POSTLEITZAHL_REQUIRED = 1201121;
	/**
	* "Postleitzahl" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201123
	*/
	public static final int AMP_POSTLEITZAHL_WRONG_FORMAT = 1201123;
	/**
	* "Kopf/Hals" ist ein Mussfeld.
	* ORCLI-Code: CL-1201131
	*/
	public static final int AMP_KOPF_HALS_REQUIRED = 1201131;
	/**
	* "Kopf/Hals" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201133
	*/
	public static final int AMP_KOPF_HALS_WRONG_FORMAT = 1201133;
	/**
	* "Hörverminderung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201141
	*/
	public static final int AMP_HOERVERMINDERUNG_REQUIRED = 1201141;
	/**
	* Der Wert in "Hörverminderung" ist nicht zulässig.
	* ORCLI-Code: CL-1201144
	*/
	public static final int AMP_HOERVERMINDERUNG_INVALID = 1201144;
	/**
	* Der Wert in "Hörverminderung" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201145
	*/
	public static final int AMP_HOERVERMINDERUNG_FORBIDDEN = 1201145;
	/**
	* Der Wert in "Überweisung zum HNO-FA" ist nicht zulässig.
	* ORCLI-Code: CL-1201154
	*/
	public static final int AMP_UEBERWEISUNG_HNO_FA_INVALID = 1201154;
	/**
	* Der Wert in "Überweisung zum HNO-FA" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201155
	*/
	public static final int AMP_UEBERWEISUNG_HNO_FA_FORBIDDEN = 1201155;
	/**
	* "Sehverminderung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201161
	*/
	public static final int AMP_SEHVERMINDERUNG_REQUIRED = 1201161;
	/**
	* Der Wert in "Sehverminderung" ist nicht zulässig.
	* ORCLI-Code: CL-1201164
	*/
	public static final int AMP_SEHVERMINDERUNG_INVALID = 1201164;
	/**
	* Der Wert in "Sehverminderung" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201165
	*/
	public static final int AMP_SEHVERMINDERUNG_FORBIDDEN = 1201165;
	/**
	* Der Wert in "Überweisung zum Augen-FA" ist nicht zulässig.
	* ORCLI-Code: CL-1201174
	*/
	public static final int AMP_UEBERWEISUNG_AUGEN_FA_INVALID = 1201174;
	/**
	* Der Wert in "Überweisung zum Augen-FA" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201175
	*/
	public static final int AMP_UEBERWEISUNG_AUGEN_FA_FORBIDDEN = 1201175;
	/**
	* "Herz/Lunge/Gefäße" ist ein Mussfeld.
	* ORCLI-Code: CL-1201181
	*/
	public static final int AMP_HERZ_LUNGE_GEFAESS_REQUIRED = 1201181;
	/**
	* "Herz/Lunge/Gefäße" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201183
	*/
	public static final int AMP_HERZ_LUNGE_GEFAESS_WRONG_FORMAT = 1201183;
	/**
	* "Abdomen" ist ein Mussfeld.
	* ORCLI-Code: CL-1201191
	*/
	public static final int AMP_ABDOMEN_REQUIRED = 1201191;
	/**
	* "Abdomen" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201193
	*/
	public static final int AMP_ABDOMEN_WRONG_FORMAT = 1201193;
	/**
	* "WS/Gelenke" ist ein Mussfeld.
	* ORCLI-Code: CL-1201201
	*/
	public static final int AMP_WIRBELSAEULE_GELENKE_REQUIRED = 1201201;
	/**
	* "WS/Gelenke" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201203
	*/
	public static final int AMP_WIRBELSAEULE_GELENKE_WRONG_FORMAT = 1201203;
	/**
	* "Haut" ist ein Mussfeld.
	* ORCLI-Code: CL-1201211
	*/
	public static final int AMP_HAUT_REQUIRED = 1201211;
	/**
	* "Haut" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201213
	*/
	public static final int AMP_HAUT_WRONG_FORMAT = 1201213;
	/**
	* "Von ProbandIn angegebene Auffälligkeiten" ist ein Mussfeld.
	* ORCLI-Code: CL-1201221
	*/
	public static final int AMP_AUFFAELLIGKEITEN_REQUIRED = 1201221;
	/**
	* Der Wert in "von ProbandIn angegebene Auffälligkeiten" ist nicht zulässig.
	* ORCLI-Code: CL-1201224
	*/
	public static final int AMP_AUFFAELLIGKEITEN_INVALID = 1201224;
	/**
	* "Bösartiges Melanom bei Verwandtem ersten Grades" ist ein Mussfeld.
	* ORCLI-Code: CL-1201231
	*/
	public static final int AMP_MELANOM_REQUIRED = 1201231;
	/**
	* Der Wert in "bösartiges Melanom bei Verwandtem ersten Grades" ist nicht zulässig.
	* ORCLI-Code: CL-1201234
	*/
	public static final int AMP_MELANOM_INVALID = 1201234;
	/**
	* "Maßnahme Hautkrebs" ist ein Mussfeld.
	* ORCLI-Code: CL-1201241
	*/
	public static final int AMP_MASSNAHME_HAUTKREBS_REQUIRED = 1201241;
	/**
	* Der Wert in "Maßnahme Hautkrebs" ist nicht zulässig.
	* ORCLI-Code: CL-1201244
	*/
	public static final int AMP_MASSNAHME_HAUTKREBS_INVALID = 1201244;
	/**
	* Der Wert in "Maßnahme Hautkrebs" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201245
	*/
	public static final int AMP_MASSNAHME_HAUTKREBS_INVALID2 = 1201245;
	/**
	* "Sonstige auffällige Befunde" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201253
	*/
	public static final int AMP_SONSTIGE_AUFFAELLIGE_BEFUNDE_WRONG_FORMAT = 1201253;
	/**
	* "Gesundes Zahnfleisch" ist ein Mussfeld.
	* ORCLI-Code: CL-1201261
	*/
	public static final int AMP_GESUNDES_ZAHNFLEISCH_REQUIRED = 1201261;
	/**
	* Der Wert in "gesundes Zahnfleisch" ist nicht zulässig.
	* ORCLI-Code: CL-1201264
	*/
	public static final int AMP_GESUNDES_ZAHNFLEISCH_INVALID = 1201264;
	/**
	* "Zahnstein, Plaque, Mundgeruch, Rauchen" ist ein Mussfeld.
	* ORCLI-Code: CL-1201271
	*/
	public static final int AMP_ZAHNSTEIN_REQUIRED = 1201271;
	/**
	* Der Wert in "Zahnstein, Plaque, Mundgeruch, Rauchen" ist nicht zulässig.
	* ORCLI-Code: CL-1201274
	*/
	public static final int AMP_ZAHNSTEIN_INVALID = 1201274;
	/**
	* "Rötung, Schwellung, Lockerung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201281
	*/
	public static final int AMP_ROETUNG_REQUIRED = 1201281;
	/**
	* Der Wert in "Rötung, Schwellung, Lockerung" ist nicht zulässig.
	* ORCLI-Code: CL-1201284
	*/
	public static final int AMP_ROETUNG_INVALID = 1201284;
	/**
	* "Maßnahme Parodontitis" ist ein Mussfeld.
	* ORCLI-Code: CL-1201291
	*/
	public static final int AMP_MASSNAHME_PARODONTITIS_REQUIRED = 1201291;
	/**
	* Der Wert in "Maßnahme Parodontitis" ist nicht zulässig.
	* ORCLI-Code: CL-1201294
	*/
	public static final int AMP_MASSNAHME_PARODONTITIS_INVALID = 1201294;
	/**
	* Der Wert in "Maßnahme Parodontitis" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201295
	*/
	public static final int AMP_MASSNAHME_PARADONTITIS_INVALID2 = 1201295;
	/**
	* "Chol" ist ein Mussfeld.
	* ORCLI-Code: CL-1201301
	*/
	public static final int AMP_CHOL_REQUIRED = 1201301;
	/**
	* "Chol" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201303
	*/
	public static final int AMP_CHOL_WRONG_FORMAT = 1201303;
	/**
	* Der Wert in "Chol" ist nicht zulässig.
	* ORCLI-Code: CL-1201304
	*/
	public static final int AMP_CHOL_INVALID = 1201304;
	/**
	* "HDL-Chol" ist ein Mussfeld.
	* ORCLI-Code: CL-1201311
	*/
	public static final int AMP_HDL_CHOL_REQUIRED = 1201311;
	/**
	* "HDL-Chol" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201313
	*/
	public static final int AMP_HDL_CHOL_WRONG_FORMAT = 1201313;
	/**
	* Der Wert in "HDL-Chol" ist nicht zulässig.
	* ORCLI-Code: CL-1201314
	*/
	public static final int AMP_HDL_CHOL_INVALID = 1201314;
	/**
	* "Blutzucker" ist ein Mussfeld.
	* ORCLI-Code: CL-1201331
	*/
	public static final int AMP_BLUTZUCKER_REQUIRED = 1201331;
	/**
	* "Blutzucker" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201333
	*/
	public static final int AMP_BLUTZUCKER_WRONG_FORMAT = 1201333;
	/**
	* Der Wert in "Blutzucker" ist nicht zulässig.
	* ORCLI-Code: CL-1201334
	*/
	public static final int AMP_BLUTZUCKER_INVALID = 1201334;
	/**
	* "Triglyceride nüchtern" ist ein Mussfeld.
	* ORCLI-Code: CL-1201341
	*/
	public static final int AMP_TRIGLYCERIDE_NUECHTERN_REQUIRED = 1201341;
	/**
	* "Triglyceride nüchtern" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201343
	*/
	public static final int AMP_TRIGLYCERIDE_NUECHTERN_WRONG_FORMAT = 1201343;
	/**
	* Der Wert in "Triglyceride nüchtern" ist nicht zulässig.
	* ORCLI-Code: CL-1201344
	*/
	public static final int AMP_TRIGLYCERIDE_NUECHTERN_INVALID = 1201344;
	/**
	* "Gamma-GT" ist ein Mussfeld.
	* ORCLI-Code: CL-1201351
	*/
	public static final int AMP_GAMMA_GT_REQUIRED = 1201351;
	/**
	* "Gamma-GT" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201353
	*/
	public static final int AMP_GAMMA_GT_WRONG_FORMAT = 1201353;
	/**
	* Der Wert in "Gamma-GT" ist nicht zulässig.
	* ORCLI-Code: CL-1201354
	*/
	public static final int AMP_GAMMA_GT_INVALID = 1201354;
	/**
	* "Ery" ist ein Mussfeld.
	* ORCLI-Code: CL-1201361
	*/
	public static final int AMP_ERY_REQUIRED = 1201361;
	/**
	* "Ery" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201363
	*/
	public static final int AMP_ERY_WRONG_FORMAT = 1201363;
	/**
	* Der Wert in "Ery" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201364
	*/
	public static final int AMP_ERY_INVALID = 1201364;
    /**
    * Der Wert in "Ery" ist nicht zulässig.
    * ORCLI-Code: CL-1201365
    */
    public static final int AMP_ERY_INVALID2 = 1201365;
	/**
	* "Hb" ist ein Mussfeld.
	* ORCLI-Code: CL-1201371
	*/
	public static final int AMP_HB_REQUIRED = 1201371;
	/**
	* "Hb" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201373
	*/
	public static final int AMP_HB_WRONG_FORMAT = 1201373;
	/**
	* Der Wert in "Hb" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201374
	*/
	public static final int AMP_HB_INVALID = 1201374;
    /**
    * Der Wert in "Hb" ist nicht zulässig.
    * ORCLI-Code: CL-1201375
    */
    public static final int AMP_HB_INVALID2 = 1201375;
	/**
	* "Hkt" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201383
	*/
	public static final int AMP_HKT_WRONG_FORMAT = 1201383;
	/**
	* Der Wert in "Hkt" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201384
	*/
	public static final int AMP_HKT_INVALID = 1201384;
    /**
    * Der Wert in "Hkt" ist nicht zulässig.
    * ORCLI-Code: CL-1201385
    */
    public static final int AMP_HKT_INVALID2 = 1201385;
	/**
	* "Leukozyten" ist ein Mussfeld.
	* ORCLI-Code: CL-1201391
	*/
	public static final int AMP_LEUKOZYTEN_REQUIRED = 1201391;
	/**
	* Der Wert in "Leukozyten" ist nicht zulässig.
	* ORCLI-Code: CL-1201394
	*/
	public static final int AMP_LEUKOZYTEN_INVALID = 1201394;
	/**
	* "Glucose" ist ein Mussfeld.
	* ORCLI-Code: CL-1201401
	*/
	public static final int AMP_GLUCOSE_REQUIRED = 1201401;
	/**
	* Der Wert in "Glucose" ist nicht zulässig.
	* ORCLI-Code: CL-1201404
	*/
	public static final int AMP_GLUCOSE_INVALID = 1201404;
	/**
	* "Nitrit" ist ein Mussfeld.
	* ORCLI-Code: CL-1201411
	*/
	public static final int AMP_NITRIT_REQUIRED = 1201411;
	/**
	* Der Wert in "Nitrit" ist nicht zulässig.
	* ORCLI-Code: CL-1201414
	*/
	public static final int AMP_NITRIT_INVALID = 1201414;
	/**
	* "Eiweiß" ist ein Mussfeld.
	* ORCLI-Code: CL-1201421
	*/
	public static final int AMP_EIWEISS_REQUIRED = 1201421;
	/**
	* Der Wert in "Eiweiß" ist nicht zulässig.
	* ORCLI-Code: CL-1201424
	*/
	public static final int AMP_EIWEISS_INVALID = 1201424;
	/**
	* "Blut" ist ein Mussfeld.
	* ORCLI-Code: CL-1201431
	*/
	public static final int AMP_BLUT_REQUIRED = 1201431;
	/**
	* Der Wert in "Blut" ist nicht zulässig.
	* ORCLI-Code: CL-1201434
	*/
	public static final int AMP_BLUT_INVALID = 1201434;
	/**
	* "Ubg" ist ein Mussfeld.
	* ORCLI-Code: CL-1201441
	*/
	public static final int AMP_UBG_REQUIRED = 1201441;
	/**
	* Der Wert in "Ubg" ist nicht zulässig.
	* ORCLI-Code: CL-1201444
	*/
	public static final int AMP_UBG_INVALID = 1201444;
	/**
	* "Maßnahme Harnuntersuchung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201451
	*/
	public static final int AMP_MASSNAHME_HARNUNTERSUCHUNG_REQUIRED = 1201451;
	/**
	* Der Wert in "Maßnahme Harnuntersuchung" ist nicht zulässig.
	* ORCLI-Code: CL-1201454
	*/
	public static final int AMP_MASSNAHME_HARNUNTERSUCHUNG_INVALID = 1201454;
	/**
	* Der Wert in "Maßnahme Harnuntersuchung" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201455
	*/
	public static final int AMP_MASSNAHME_HARNUNTERSUCHUNG_INVALID2 = 1201455;
	/**
	* "Blutdruck (systolisch)" ist ein Mussfeld.
	* ORCLI-Code: CL-1201461
	*/
	public static final int AMP_BLUTDRUCK1_REQUIRED = 1201461;
	/**
	* "Blutdruck (systolisch)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201463
	*/
	public static final int AMP_BLUTDRUCK1_WRONG_FORMAT = 1201463;
	/**
	* Der Wert in "Blutdruck (systolisch)" ist nicht zulässig.
	* ORCLI-Code: CL-1201464
	*/
	public static final int AMP_BLUTDRUCK1_INVALID = 1201464;
	/**
	* "Blutdruck (diastolisch)" ist ein Mussfeld.
	* ORCLI-Code: CL-1201471
	*/
	public static final int AMP_BLUTDRUCK2_REQUIRED = 1201471;
	/**
	* "Blutdruck (diastolisch)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201473
	*/
	public static final int AMP_BLUTDRUCK2_WRONG_FORMAT = 1201473;
	/**
	* Der Wert in "Blutdruck (diastolisch)" ist nicht zulässig.
	* ORCLI-Code: CL-1201474
	*/
	public static final int AMP_BLUTDRUCK2_INVALID = 1201474;
	/**
	* Der Wert in "Blutdrucksenkendes Medikament eingenommen" ist nicht zulässig.
	* ORCLI-Code: CL-1201484
	*/
	public static final int AMP_BLUTDRUCKSENKENDES_MEDIKAMENT_GENOMMEN_INVALID = 1201484;
	/**
	* "Maßnahme Blutdruck" ist ein Mussfeld.
	* ORCLI-Code: CL-1201501
	*/
	public static final int AMP_MASSNAHME_BLUTDRUCK_REQUIRED = 1201501;
	/**
	* Der Wert in "Maßnahme Blutdruck" ist nicht zulässig.
	* ORCLI-Code: CL-1201504
	*/
	public static final int AMP_MASSNAHME_BLUTDRUCK_INVALID = 1201504;
	/**
	* Der Wert in "Maßnahme Blutdruck" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201505
	*/
	public static final int AMP_MASSNAHME_BLUTDRUCK_INVALID2 = 1201505;
	/**
	* "Körpergröße" ist ein Mussfeld.
	* ORCLI-Code: CL-1201511
	*/
	public static final int AMP_KOERPERGROESSE_REQUIRED = 1201511;
	/**
	* "Körpergröße" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201513
	*/
	public static final int AMP_KOERPERGROESSE_WRONG_FORMAT = 1201513;
	/**
	* Der Wert in "Körpergröße" ist nicht zulässig.
	* ORCLI-Code: CL-1201514
	*/
	public static final int AMP_KOERPERGROESSE_INVALID = 1201514;
	/**
	* "Körpergewicht" ist ein Mussfeld.
	* ORCLI-Code: CL-1201531
	*/
	public static final int AMP_KOERPERGEWICHT_REQUIRED = 1201531;
	/**
	* "Körpergewicht" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201533
	*/
	public static final int AMP_KOERPERGEWICHT_WRONG_FORMAT = 1201533;
	/**
	* Der Wert in "Körpergewicht" ist nicht zulässig.
	* ORCLI-Code: CL-1201534
	*/
	public static final int AMP_KOERPERGEWICHT_INVALID = 1201534;
	/**
	* "Taille" ist ein Mussfeld.
	* ORCLI-Code: CL-1201551
	*/
	public static final int AMP_TAILLE_REQUIRED = 1201551;
	/**
	* Der Wert in "Taille" ist nicht zulässig.
	* ORCLI-Code: CL-1201554
	*/
	public static final int AMP_TAILLE_INVALID = 1201554;
	/**
	* "Maßnahme BMI" ist ein Mussfeld.
	* ORCLI-Code: CL-1201571
	*/
	public static final int AMP_MASSNAHME_BMI_REQUIRED = 1201571;
	/**
	* Der Wert in "Maßnahme BMI" ist nicht zulässig.
	* ORCLI-Code: CL-1201574
	*/
	public static final int AMP_MASSNAHME_BMI_INVALID = 1201574;
	/**
	* Der Wert in "Maßnahme BMI" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201575
	*/
	public static final int AMP_MASSNAHME_BMI_INVALID2 = 1201575;
	/**
	* "Körperliche Bewegung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201581
	*/
	public static final int AMP_KOERPERLICHE_BEWEGUNG_REQUIRED = 1201581;
	/**
	* Der Wert in "Körperliche Bewegung" ist nicht zulässig.
	* ORCLI-Code: CL-1201584
	*/
	public static final int AMP_KOERPERLICHE_BEWEGUNG_INVALID = 1201584;
	/**
	* "Maßnahme Bewegung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201591
	*/
	public static final int AMP_MASSNAHME_BEWEGUNG_REQUIRED = 1201591;
	/**
	* Der Wert in "Maßnahme Bewegung" ist nicht zulässig.
	* ORCLI-Code: CL-1201594
	*/
	public static final int AMP_MASSNAHME_BEWEGUNG_INVALID = 1201594;
	/**
	* Der Wert in "Maßnahme Bewegung" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201595
	*/
	public static final int AMP_MASSNAHME_KOERPERLICHE_BEWEGUNG_INVALID2 = 1201595;
	/**
	* "Alkoholfragebogen" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201603
	*/
	public static final int AMP_ALKOHOLFRAGEBOGEN_WRONG_FORMAT = 1201603;
	/**
	* Der Wert in "Alkoholfragebogen" ist nicht zulässig.
	* ORCLI-Code: CL-1201604
	*/
	public static final int AMP_ALKOHOLFRAGEBOGEN_INVALID = 1201604;
	/**
	* Der Wert in "Aufhörwille vorhanden" ist nicht zulässig.
	* ORCLI-Code: CL-1201614
	*/
	public static final int AMP_ALKOHOL_AUFHOERWILLE_VORHANDEN_INVALID = 1201614;
	/**
	* Der Wert in "Andere Vorbefunde" ist nicht zulässig.
	* ORCLI-Code: CL-1201624
	*/
	public static final int AMP_ANDERE_VORBEFUNDE_INVALID = 1201624;
	/**
	* Der Wert in "Maßnahme Alkohol" ist nicht zulässig.
	* ORCLI-Code: CL-1201634
	*/
	public static final int AMP_MASSNAHME_ALKOHOL_INVALID = 1201634;
	/**
	* Der Wert in "Maßnahme Alkohol" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201635
	*/
	public static final int AMP_MASSNAHME_ALKOHOL_INVALID2 = 1201635;
	/**
	* "Sicher Nichtraucher" ist ein Mussfeld.
	* ORCLI-Code: CL-1201641
	*/
	public static final int AMP_SICHER_NICHTRAUCHER_REQUIRED = 1201641;
	/**
	* Der Wert in "Sicher Nichtraucher" ist nicht zulässig.
	* ORCLI-Code: CL-1201644
	*/
	public static final int AMP_SICHER_NICHTRAUCHER_INVALID = 1201644;
	/**
	* "Aufhörwille vorhanden" ist ein Mussfeld. ("Sicher Nichtraucher" ist mit "Nein" belegt.)
	* ORCLI-Code: CL-1201651
	*/
	public static final int AMP_RAUCHEN_AUFHOERWILLE_VORHANDEN_REQUIRED = 1201651;
	/**
	* Der Wert in "Aufhörwille vorhanden" ist nicht zulässig.
	* ORCLI-Code: CL-1201654
	*/
	public static final int AMP_RAUCHEN_AUFHOERWILLE_VORHANDEN_INVALID = 1201654;
	/**
	* "Maßnahme Rauchverhalten" ist ein Mussfeld.
	* ORCLI-Code: CL-1201661
	*/
	public static final int AMP_MASSNAHME_RAUCHVERHALTEN_REQUIRED = 1201661;
	/**
	* Der Wert in "Maßnahme Rauchverhalten" ist nicht zulässig.
	* ORCLI-Code: CL-1201664
	*/
	public static final int AMP_MASSNAHME_RAUCHVERHALTEN_INVALID = 1201664;
	/**
	* Der Wert in "Maßnahme Rauchverhalten" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201665
	*/
	public static final int AMP_MASSNAHME_RAUCHVERHALTEN_INVALID2 = 1201665;
	/**
	* "Bestehender Diabetes" ist ein Mussfeld.
	* ORCLI-Code: CL-1201671
	*/
	public static final int AMP_BESTEHENDER_DIABETES_REQUIRED = 1201671;
	/**
	* Der Wert in "Bestehender Diabetes" ist nicht zulässig.
	* ORCLI-Code: CL-1201674
	*/
	public static final int AMP_BESTEHENDER_DIABETES_INVALID = 1201674;
	/**
	* "Ergebnis" ist ein Mussfeld.
	* ORCLI-Code: CL-1201681
	*/
	public static final int AMP_ERGEBNIS_REQUIRED = 1201681;
	/**
	* Der Wert in "Ergebnis" ist nicht zulässig.
	* ORCLI-Code: CL-1201684
	*/
	public static final int AMP_ERGEBNIS_INVALID = 1201684;
	/**
	* "Maßnahme Blutzuckeruntersuchung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201691
	*/
	public static final int AMP_MASSNAHME_BLUTZUCKER_REQUIRED = 1201691;
	/**
	* Der Wert in "Maßnahme Blutzuckeruntersuchung" ist nicht zulässig.
	* ORCLI-Code: CL-1201694
	*/
	public static final int AMP_MASSNAHME_BLUTZUCKER_INVALID = 1201694;
	/**
	* Der Wert in "Maßnahme Blutzuckeruntersuchung" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201695
	*/
	public static final int AMP_MASSNAHME_BLUTZUCKER_INVALID2 = 1201695;
	/**
	* "Familiäre Belastung" ist ein Mussfeld.
	* ORCLI-Code: CL-1201701
	*/
	public static final int AMP_FAMILIAERE_BELASTUNG_REQUIRED = 1201701;
	/**
	* Der Wert in "Familiäre Belastung" ist nicht zulässig.
	* ORCLI-Code: CL-1201704
	*/
	public static final int AMP_FAMILIAERE_BELASTUNG_INVALID = 1201704;
	/**
	* Der Wert in "Familiäre Belastung" ist nicht zulässig. (Bei über 40-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201705
	*/
	public static final int AMP_FAMILIAERE_BELASTUNG_FORBIDDEN = 1201705;
	/**
	* "Anamnestisch" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201713
	*/
	public static final int AMP_ANAMNESTISCH_WRONG_FORMAT = 1201713;
	/**
	* "Maßnahme Kardiovaskuläres Risiko" ist ein Mussfeld.
	* ORCLI-Code: CL-1201741
	*/
	public static final int AMP_MASSNAHME_KARDIO_REQUIRED = 1201741;
	/**
	* Der Wert in "Maßnahme Kardiovaskuläres Risiko" ist nicht zulässig.
	* ORCLI-Code: CL-1201744
	*/
	public static final int AMP_MASSNAHME_KARDIO_INVALID = 1201744;
	/**
	* Der Wert in "Maßnahme Kardiovaskuläres Risiko" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201745
	*/
	public static final int AMP_MASSNAHME_KARDIO_INVALID2 = 1201745;
	/**
	* "Abstrich gemacht" ist ein Mussfeld.
	* ORCLI-Code: CL-1201751
	*/
	public static final int AMP_ABSTRICH_GEMACHT_REQUIRED = 1201751;
	/**
	* Der Wert in "Abstrich gemacht" ist nicht zulässig.
	* ORCLI-Code: CL-1201754
	*/
	public static final int AMP_ABSTRICH_GEMACHT_INVALID = 1201754;
	/**
	* Der Wert in "Abstrich gemacht" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201755
	*/
	public static final int AMP_ABSTRICH_GEMACHT_FORBIDDEN = 1201755;
	/**
	* Der Wert in "Befund vorhanden" ist nicht zulässig.
	* ORCLI-Code: CL-1201764
	*/
	public static final int AMP_BEFUND_VORHANDEN_INVALID = 1201764;
	/**
	* Der Wert in "Befund vorhanden" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201765
	*/
	public static final int AMP_BEFUND_VORHANDEN_FORBIDDEN = 1201765;
	/**
	* Der Wert in "Ärztliche Beratung und Aufklärung vor PAP-Abstrich" ist nicht zulässig.
	* ORCLI-Code: CL-1201774
	*/
	public static final int AMP_PAP_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID = 1201774;
	/**
	* Der Wert in "Ärztliche Beratung und Aufklärung vor PAP-Abstrich" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201775
	*/
	public static final int AMP_PAP_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN = 1201775;
	/**
	* "Maßnahme PAP-Abstrich" ist ein Mussfeld.
	* ORCLI-Code: CL-1201781
	*/
	public static final int AMP_MASSNAHME_PAP_REQUIRED = 1201781;
	/**
	* Der Wert in "Maßnahme PAP-Abstrich" ist nicht zulässig.
	* ORCLI-Code: CL-1201784
	*/
	public static final int AMP_MASSNAHME_PAP_INVALID = 1201784;
	/**
	* Der Wert in "Maßnahme PAP-Abstrich" ist nicht zulässig. (Angabe nur bei Frauen möglich.)
	* ORCLI-Code: CL-1201785
	*/
	public static final int AMP_MASSNAHME_PAP_FORBIDDEN = 1201785;
	/**
	* Der Wert in "Maßnahme PAP-Abstrich" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201786
	*/
	public static final int AMP_MASSNAHME_PAP_INVALID2 = 1201786;

	/**
	* Der Wert in "Durchgeführt" ist nicht zulässig.
	* ORCLI-Code: CL-1201794
	*/
	public static final int AMP_DURCHGEFUEHRT_INVALID = 1201794;
	/**
	* Der Wert in "Durchgeführt" ist nicht zulässig. (Angabe nur bei Frauen über 40 erlaubt.)
	* ORCLI-Code: CL-1201795
	*/
	public static final int AMP_DURCHGEFUEHRT_FORBIDDEN = 1201795;
	/**
	* Der Wert in "BIRADS - Befund vorhanden" ist nicht zulässig.
	* ORCLI-Code: CL-1201804
	*/
	public static final int AMP_BIRADS_BEFUND_VORHANDEN_INVALID = 1201804;
	/**
	* Der Wert in "BIRADS - Befund vorhanden" ist nicht zulässig. (Angabe nur bei Frauen über 40 erlaubt.)
	* ORCLI-Code: CL-1201805
	*/
	public static final int AMP_BIRADS_BEFUND_VORHANDEN_FORBIDDEN = 1201805;
	/**
	* Der Wert in "Ärztliche Beratung und Aufklärung vor Mammographie" ist nicht zulässig.
	* ORCLI-Code: CL-1201814
	*/
	public static final int AMP_MAMMOGRAPHIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID = 1201814;
	/**
	* Der Wert in "Ärztliche Beratung und Aufklärung vor Mammographie" ist nicht zulässig. (Angabe nur bei Frauen über 40 erlaubt.)
	* ORCLI-Code: CL-1201815
	*/
	public static final int AMP_MAMMOGRAPHIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN = 1201815;
	/**
	* Der Wert in "Maßnahme Mammographiebefund" ist nicht zulässig.
	* ORCLI-Code: CL-1201824
	*/
	public static final int AMP_MASSNAHME_MAMMOGRAPHIE_INVALID = 1201824;
	/**
	* Der Wert in "Maßnahme Mammographiebefund" ist nicht zulässig. (Angabe nur bei Frauen über 40 erlaubt.)
	* ORCLI-Code: CL-1201825
	*/
	public static final int AMP_MASSNAHME_MAMMOGRAPHIE_FORBIDDEN = 1201825;
	/**
	* Der Wert in "Maßnahme Mammographiebefund" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201826
	*/
	public static final int AMP_MASSNAHME_MAMMOGRAPHIE_INVALID2 = 1201826;
	/**
	* "Okkultes Blut im Stuhl Vorbefunde" ist ein Mussfeld.
	* ORCLI-Code: CL-1201831
	*/
	public static final int AMP_BLUT_IM_STUHL_REQUIRED = 1201831;
	/**
	* Der Wert in "Okkultes Blut im Stuhl Vorbefunde" ist nicht zulässig.
	* ORCLI-Code: CL-1201834
	*/
	public static final int AMP_BLUT_IM_STUHL_INVALID = 1201834;
	/**
	* Der Wert in "Okkultes Blut im Stuhl Vorbefunde" ist nicht zulässig. (Bei unter 50-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201835
	*/
	public static final int AMP_BLUT_IM_STUHL_FORBIDDEN = 1201835;
	/**
	* "Aktueller Befund" ist ein Mussfeld.
	* ORCLI-Code: CL-1201841
	*/
	public static final int AMP_AKTUELLER_BEFUND_REQUIRED = 1201841;
	/**
	* Der Wert in "Aktueller Befund" ist nicht zulässig.
	* ORCLI-Code: CL-1201844
	*/
	public static final int AMP_AKTUELLER_BEFUND_INVALID = 1201844;
	/**
	* Der Wert in "Aktueller Befund" ist nicht zulässig. (Bei unter 50-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201845
	*/
	public static final int AMP_AKTUELLER_BEFUND_FORBIDDEN = 1201845;
	/**
	* "Wann war die letzte Koloskopie" ist ein Mussfeld.
	* ORCLI-Code: CL-1201851
	*/
	public static final int AMP_LETZTE_KOLOSKOPIE_REQUIRED = 1201851;
	/**
	* Der Wert in "Wann war die letzte Koloskopie" ist nicht zulässig.
	* ORCLI-Code: CL-1201854
	*/
	public static final int AMP_LETZTE_KOLOSKOPIE_INVALID = 1201854;
	/**
	* Der Wert in "Wann war die letzte Koloskopie" ist nicht zulässig. (Bei unter 50-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201855
	*/
	public static final int AMP_LETZTE_KOLOSKOPIE_FORBIDDEN = 1201855;
	/**
	* "Ärztliche Beratung/Aufklärung über Koloskopie" ist ein Mussfeld.
	* ORCLI-Code: CL-1201861
	*/
	public static final int AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_REQUIRED = 1201861;
	/**
	* Der Wert in "Ärztliche Beratung/Aufklärung über Koloskopie" ist nicht zulässig.
	* ORCLI-Code: CL-1201864
	*/
	public static final int AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_INVALID = 1201864;
	/**
	* Der Wert in "Ärztliche Beratung/Aufklärung über Koloskopie" ist nicht zulässig. (Bei unter 50-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201865
	*/
	public static final int AMP_KOLOSKOPIE_AERZTLICHE_BERATUNG_AUFKLAERUNG_FORBIDDEN = 1201865;
	/**
	* "Maßnahme Koloskopie" ist ein Mussfeld.
	* ORCLI-Code: CL-1201871
	*/
	public static final int AMP_MASSNAHME_KOLOSKOPIE_REQUIRED = 1201871;
	/**
	* Der Wert in "Maßnahme Koloskopie" ist nicht zulässig.
	* ORCLI-Code: CL-1201874
	*/
	public static final int AMP_MASSNAHME_KOLOSKOPIE_INVALID = 1201874;
	/**
	* Der Wert in "Maßnahme Koloskopie" ist nicht zulässig. (Bei unter 50-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201875
	*/
	public static final int AMP_MASSNAHME_KOLOSKOPIE_FORBIDDEN = 1201875;
	/**
	* Der Wert in "Maßnahme Koloskopie" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1201876
	*/
	public static final int AMP_MASSNAHME_KOLOSKOPIE_INVALID2 = 1201876;
	/**
	* Der Wert in "Ärztliche Beratung/Aufklärung PSA-Test" ist nicht zulässig.
	* ORCLI-Code: CL-1201884
	*/
	public static final int AMP_PROSTATA_AERZTLICHE_BERATUNG_INVALID = 1201884;
	/**
	* Der Wert in "Ärztliche Beratung/Aufklärung PSA-Test" ist nicht zulässig. (Angabe nur bei Männern über 50 erlaubt.)
	* ORCLI-Code: CL-1201885
	*/
	public static final int AMP_PROSTATA_AERZTLICHE_BERATUNG_FORBIDDEN = 1201885;
	/**
	* "Maßnahme Prostata" ist ein Mussfeld.
	* ORCLI-Code: CL-1201891
	*/
	public static final int AMP_MASSNAHME_PROSTATA_REQUIRED = 1201891;
	/**
	* Der Wert in "Maßnahme Prostata" ist nicht zulässig.
	* ORCLI-Code: CL-1201894
	*/
	public static final int AMP_MASSNAHME_PROSTATA_INVALID = 1201894;
	/**
	* Der Wert in "Maßnahme Prostata" ist nicht zulässig. (Angabe nur bei Männern über 50 erlaubt.)
	* ORCLI-Code: CL-1201895
	*/
	public static final int AMP_MASSNAHME_PROSTATA_FORBIDDEN = 1201895;
	/**
	* "Risiko für Glaukom (Grüner Star) vorhanden" ist ein Mussfeld.
	* ORCLI-Code: CL-1201901
	*/
	public static final int AMP_RISIKO_GLAUKOM_VORHANDEN_REQUIRED = 1201901;
	/**
	* Der Wert in "Risiko für Glaukom (Grüner Star) vorhanden" ist nicht zulässig.
	* ORCLI-Code: CL-1201904
	*/
	public static final int AMP_RISIKO_GLAUKOM_VORHANDEN_INVALID = 1201904;
	/**
	* Der Wert in "Risiko für Glaukom (Grüner Star) vorhanden" ist nicht zulässig. (Bei ab 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201905
	*/
	public static final int AMP_RISIKO_GLAUKOM_VORHANDEN_FORBIDDEN = 1201905;
	/**
	* "FA-Untersuchung Glaukom unter 65" ist ein Mussfeld.
	* ORCLI-Code: CL-1201911
	*/
	public static final int AMP_UNTERSUCHUNG_GLAUKOM_BIS65_REQUIRED = 1201911;
	/**
	* Der Wert in "FA-Untersuchung Glaukom unter 65" ist nicht zulässig.
	* ORCLI-Code: CL-1201914
	*/
	public static final int AMP_UNTERSUCHUNG_GLAUKOM_BIS65_INVALID = 1201914;
	/**
	* Der Wert in "FA-Untersuchung Glaukom unter 65" ist nicht zulässig. (Bei ab 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201915
	*/
	public static final int AMP_UNTERSUCHUNG_GLAUKOM_BIS65_FORBIDDEN = 1201915;
	/**
	* "Maßnahme Diabetes unter 65" ist ein Mussfeld.
	* ORCLI-Code: CL-1201921
	*/
	public static final int AMP_MASSNAHME_DIABETES_BIS65_REQUIRED = 1201921;
	/**
	* Der Wert in "Maßnahme Diabetes unter 65" ist nicht zulässig.
	* ORCLI-Code: CL-1201924
	*/
	public static final int AMP_MASSNAHME_DIABETES_BIS65_INVALID = 1201924;
	/**
	* Der Wert in "Maßnahme Diabetes unter 65" ist nicht zulässig. (Bei ab 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201925
	*/
	public static final int AMP_MASSNAHME_DIABETES_BIS65_FORBIDDEN = 1201925;
	/**
	* "Sehvermögen innerhalb der letzten 24 Monate" ist ein Mussfeld.
	* ORCLI-Code: CL-1201931
	*/
	public static final int AMP_SEHVERMOEGEN_KONTROLLIERT_REQUIRED = 1201931;
	/**
	* Der Wert in "Sehvermögen innerhalb der letzten 24 Monate" ist nicht zulässig.
	* ORCLI-Code: CL-1201934
	*/
	public static final int AMP_SEHVERMOEGEN_KONTROLLIERT_INVALID = 1201934;
	/**
	* Der Wert in "Sehvermögen innerhalb der letzten 24 Monate" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201935
	*/
	public static final int AMP_SEHVERMOEGEN_KONTROLLIERT_FORBIDDEN = 1201935;
	/**
	* "FA-Untersuchung Glaukom ab 65" ist ein Mussfeld.
	* ORCLI-Code: CL-1201941
	*/
	public static final int AMP_UNTERSUCHUNG_GLAUKOM_AB65_REQUIRED = 1201941;
	/**
	* Der Wert in "FA-Untersuchung Glaukom ab 65" ist nicht zulässig.
	* ORCLI-Code: CL-1201944
	*/
	public static final int AMP_UNTERSUCHUNG_GLAUKOM_AB65_INVALID = 1201944;
	/**
	* Der Wert in "FA-Untersuchung Glaukom ab 65" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201945
	*/
	public static final int AMP_UNTERSUCHUNG_GLAUKOM_AB65_FORBIDDEN = 1201945;
	/**
	* "Maßnahme Diabetes ab 65" ist ein Mussfeld.
	* ORCLI-Code: CL-1201951
	*/
	public static final int AMP_MASSNAHME_DIABETES_AB65_REQUIRED = 1201951;
	/**
	* Der Wert in "Maßnahme Diabetes ab 65" ist nicht zulässig.
	* ORCLI-Code: CL-1201954
	*/
	public static final int AMP_MASSNAHME_DIABETES_AB65_INVALID = 1201954;
	/**
	* Der Wert in "Maßnahme Diabetes ab 65" ist nicht zulässig. (Bei unter 65-jährigen ist keine Eingabe erlaubt.)
	* ORCLI-Code: CL-1201955
	*/
	public static final int AMP_MASSNAHME_DIABETES_AB65_FORBIDDEN = 1201955;
	/**
	* "Bereits bekannte Erkrankung (1)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201963
	*/
	public static final int AMP_ERKRANKUNG1_WRONG_FORMAT = 1201963;
	/**
	* "Bereits bekannte Erkrankung (2)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201973
	*/
	public static final int AMP_ERKRANKUNG2_WRONG_FORMAT = 1201973;
	/**
	* "Bereits bekannte Erkrankung (3)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201983
	*/
	public static final int AMP_ERKRANKUNG3_WRONG_FORMAT = 1201983;
	/**
	* "Verdacht auf behandlungswürdiges Gesundheitsproblem" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1201993
	*/
	public static final int AMP_VERDACHT_GESUNDHEITSPROBLEM_WRONG_FORMAT = 1201993;
	/**
	* "Maßnahme Sonstiges" ist ein Mussfeld.
	* ORCLI-Code: CL-1202001
	*/
	public static final int AMP_MASSNAHME_SONSTIGES_REQUIRED = 1202001;
	/**
	* Der Wert in "Maßnahme Sonstiges" ist nicht zulässig.
	* ORCLI-Code: CL-1202004
	*/
	public static final int AMP_MASSNAHME_SONSTIGES_INVALID = 1202004;
	/**
	* Der Wert in "Maßnahme Sonstiges" ist nicht zulässig. (Bei Auswahl von "Keine" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1202005
	*/
	public static final int AMP_MASSNAHME_SONSTIGES_INVALID2 = 1202005;
	/**
	* Der Wert in "Abschlussgespräch" ist nicht zulässig.
	* ORCLI-Code: CL-1202014
	*/
	public static final int AMP_ABSCHLUSSGESPRAECH_INVALID = 1202014;
	/**
	* "DatenblattMammographie" ist ein Mussfeld.
	* ORCLI-Code: CL-1203001
	*/
	public static final int DATENBLATT_MAMMOGRAPHIE_REQUIRED = 1203001;
	/**
	* "Anschrift" ist ein Mussfeld.
	* ORCLI-Code: CL-1203111
	*/
	public static final int MAM_ANSCHRIFT_REQUIRED = 1203111;
	/**
	* "Anschrift" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1203113
	*/
	public static final int MAM_ANSCHRIFT_WRONG_FORMAT = 1203113;
	/**
	* "Postleitzahl" ist ein Mussfeld.
	* ORCLI-Code: CL-1203121
	*/
	public static final int MAM_POSTLEITZAHL_REQUIRED = 1203121;
	/**
	* "Postleitzahl" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1203123
	*/
	public static final int MAM_POSTLEITZAHL_WRONG_FORMAT = 1203123;
	/**
	* "Aufklärung vor Untersuchung durchgeführt" ist ein Mussfeld.
	* ORCLI-Code: CL-1203141
	*/
	public static final int MAM_AUFKLAERUNG_REQUIRED = 1203141;
	/**
	* Der Wert in "Aufklärung vor Untersuchung durchgeführt" ist nicht zulässig.
	* ORCLI-Code: CL-1203144
	*/
	public static final int MAM_AUFKLAERUNG_INVALID = 1203144;
	/**
	* "Kategorie" ist ein Mussfeld.
	* ORCLI-Code: CL-1203151
	*/
	public static final int MAM_KATEGORIE_REQUIRED = 1203151;
	/**
	* Der Wert in "Kategorie" ist nicht zulässig.
	* ORCLI-Code: CL-1203154
	*/
	public static final int MAM_KATEGORIE_INVALID = 1203154;
	/**
	* "Probandin über Ergebnis informiert" ist ein Mussfeld.
	* ORCLI-Code: CL-1203161
	*/
	public static final int MAM_ERGEBNISINFORMATION_REQUIRED = 1203161;
	/**
	* Der Wert in "Probandin über Ergebnis informiert" ist nicht zulässig.
	* ORCLI-Code: CL-1203164
	*/
	public static final int MAM_ERGEBNISINFORMATION_INVALID = 1203164;
	/**
	* "DatenblattPapAbstrich" ist ein Mussfeld.
	* ORCLI-Code: CL-1204001
	*/
	public static final int DATENBLATT_PAP_ABSTRICH_REQUIRED = 1204001;
	/**
	* "Anschrift" ist ein Mussfeld.
	* ORCLI-Code: CL-1204111
	*/
	public static final int PAP_ANSCHRIFT_REQUIRED = 1204111;
	/**
	* "Anschrift" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1204113
	*/
	public static final int PAP_ANSCHRIFT_WRONG_FORMAT = 1204113;
	/**
	* "Postleitzahl" ist ein Mussfeld.
	* ORCLI-Code: CL-1204121
	*/
	public static final int PAP_POSTLEITZAHL_REQUIRED = 1204121;
	/**
	* "Postleitzahl" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1204123
	*/
	public static final int PAP_POSTLEITZAHL_WRONG_FORMAT = 1204123;
	/**
	* "Aufklärung vor Untersuchung durchgeführt" ist ein Mussfeld.
	* ORCLI-Code: CL-1204131
	*/
	public static final int PAP_AUFKLAERUNG_REQUIRED = 1204131;
	/**
	* Der Wert in "Aufklärung vor Untersuchung durchgeführt" ist nicht zulässig.
	* ORCLI-Code: CL-1204134
	*/
	public static final int PAP_AUFKLAERUNG_INVALID = 1204134;
	/**
	* "Qualität" ist ein Mussfeld.
	* ORCLI-Code: CL-1204141
	*/
	public static final int PAP_QUALITAET_REQUIRED = 1204141;
	/**
	* Der Wert in "Qualität" ist nicht zulässig.
	* ORCLI-Code: CL-1204144
	*/
	public static final int PAP_QUALITAET_INVALID = 1204144;
	/**
	* "Beurteilung" ist ein Mussfeld. ("Qualität" ist mit "eingeschränkt" oder "nicht beurteilbar" belegt.)
	* ORCLI-Code: CL-1204151
	*/
	public static final int PAP_BEURTEILUNG_REQUIRED = 1204151;
	/**
	* Der Wert in "Beurteilung" ist nicht zulässig.
	* ORCLI-Code: CL-1204154
	*/
	public static final int PAP_BEURTEILUNG_INVALID = 1204154;
	/**
	* "Abstrichwiederholung" ist ein Mussfeld.
	* ORCLI-Code: CL-1204161
	*/
	public static final int PAP_ABSTRICHWIEDERHOLUNG_REQUIRED = 1204161;
	/**
	* Der Wert in "Abstrichwiederholung" ist nicht zulässig.
	* ORCLI-Code: CL-1204164
	*/
	public static final int PAP_ABSTRICHWIEDERHOLUNG_INVALID = 1204164;
	/**
	* "PAP Klasse" ist ein Mussfeld.
	* ORCLI-Code: CL-1204171
	*/
	public static final int PAP_PAP_KLASSE_REQUIRED = 1204171;
	/**
	* Der Wert in "PAP Klasse" ist nicht zulässig.
	* ORCLI-Code: CL-1204174
	*/
	public static final int PAP_PAP_KLASSE_INVALID = 1204174;
	/**
	* "Maßnahme" ist ein Mussfeld.
	* ORCLI-Code: CL-1204181
	*/
	public static final int PAP_MASSNAHME_REQUIRED = 1204181;
	/**
	* Der Wert in "Maßnahme" ist nicht zulässig.
	* ORCLI-Code: CL-1204184
	*/
	public static final int PAP_MASSNAHME_INVALID = 1204184;
	/**
	* "Informationsrelevanter Befund" ist ein Mussfeld.
	* ORCLI-Code: CL-1204191
	*/
	public static final int PAP_BEFUND_REQUIRED = 1204191;
	/**
	* Der Wert in "Informationsrelevanter Befund" ist nicht zulässig.
	* ORCLI-Code: CL-1204194
	*/
	public static final int PAP_BEFUND_INVALID = 1204194;
	/**
	* "Probandin über Ergebnis informiert" ist ein Mussfeld.
	* ORCLI-Code: CL-1204201
	*/
	public static final int PAP_ERGEBNISINFORMATION_REQUIRED = 1204201;
	/**
	* Der Wert in "Probandin über Ergebnis informiert" ist nicht zulässig.
	* ORCLI-Code: CL-1204204
	*/
	public static final int PAP_ERGEBNISINFORMATION_INVALID = 1204204;
	/**
	* "Von ProbandIn angegebene Auffälligkeiten" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1204213
	*/
	public static final int PAP_AUFFAELLIGKEITEN_WRONG_FORMAT = 1204213;
	/**
	* "DatenblattKoloskopie" ist ein Mussfeld.
	* ORCLI-Code: CL-1205001
	*/
	public static final int DATENBLATT_KOLOSKOPIE_REQUIRED = 1205001;
	/**
	* "Postleitzahl" ist ein Mussfeld.
	* ORCLI-Code: CL-1205181
	*/
	public static final int KOL_POSTLEITZAHL_REQUIRED = 1205181;
	/**
	* "Postleitzahl" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1205183
	*/
	public static final int KOL_POSTLEITZAHL_WRONG_FORMAT = 1205183;
	/**
	* "Ort" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1205193
	*/
	public static final int KOL_ORT_WRONG_FORMAT = 1205193;
	/**
	* "Sedierung oder Analgesie notwendig" ist ein Mussfeld.
	* ORCLI-Code: CL-1205201
	*/
	public static final int KOL_SEDIERUNG_ANALGESIE_REQUIRED = 1205201;
	/**
	* Der Wert in "Sedierung oder Analgesie notwendig" ist nicht zulässig.
	* ORCLI-Code: CL-1205204
	*/
	public static final int KOL_SEDIERUNG_ANALGESIE_INVALID = 1205204;
	/**
	* "Zoekum erreicht" ist ein Mussfeld.
	* ORCLI-Code: CL-1205211
	*/
	public static final int KOL_ZOEKUM_ERREICHT_REQUIRED = 1205211;
	/**
	* Der Wert in "Zoekum erreicht" ist nicht zulässig.
	* ORCLI-Code: CL-1205214
	*/
	public static final int KOL_ZOEKUM_ERREICHT_INVALID = 1205214;
	/**
	* "Grund für unvollständige Koloskopie" ist ein Mussfeld. ("Zoekum erreicht" ist mit "Nein" belegt.)
	* ORCLI-Code: CL-1205221
	*/
	public static final int KOL_GRUND_UNVOLLSTAENDIGE_KOLO_REQUIRED = 1205221;
	/**
	* Der Wert in "Grund für unvollständige Koloskopie" ist nicht zulässig.
	* ORCLI-Code: CL-1205224
	*/
	public static final int KOL_GRUND_UNVOLLSTAENDIGE_KOLO_INVALID = 1205224;
	/**
	* Der Wert in "Grund für unvollständige Koloskopie" ist nicht zulässig. ("Zoekum erreicht" ist mit "Ja" belegt.)
	* ORCLI-Code: CL-1205225
	*/
	public static final int KOL_GRUND_UNVOLLSTAENDIGE_KOLO_FORBIDDEN = 1205225;
	/**
	* "Makroskopischer Befund" ist ein Mussfeld.
	* ORCLI-Code: CL-1205231
	*/
	public static final int KOL_MAKROSKOPISCHER_BEFUND_REQUIRED = 1205231;
	/**
	* Der Wert in "Makroskopischer Befund" ist nicht zulässig.
	* ORCLI-Code: CL-1205234
	*/
	public static final int KOL_MAKROSKOPISCHER_BEFUND_INVALID = 1205234;
	/**
	* Der Wert in "Makroskopischer Befund" ist nicht zulässig. (Bei Auswahl von "ohne Befund" ist keine zusätzliche Auswahl erlaubt.)
	* ORCLI-Code: CL-1205235
	*/
	public static final int KOL_MAKROSKOPISCHER_BEFUND_INVALID2 = 1205235;
	/**
	* "Interventionspflichtige Komplikationen" ist ein Mussfeld.
	* ORCLI-Code: CL-1205241
	*/
	public static final int KOL_INTERVENTIONSPFLICHTIG_REQUIRED = 1205241;
	/**
	* Der Wert in "Interventionspflichtige Komplikationen" ist nicht zulässig.
	* ORCLI-Code: CL-1205244
	*/
	public static final int KOL_INTERVENTIONSPFLICHTIG_INVALID = 1205244;
	/**
	* "Komplikationsart" ist ein Mussfeld. ("Interventionspflichtige Komplikationen" ist mit "Ja" belegt.)
	* ORCLI-Code: CL-1205251
	*/
	public static final int KOL_INTER_KOMPLIKATION_JA_REQUIRED = 1205251;
	/**
	* Der Wert in "Komplikationsart" ist nicht zulässig.
	* ORCLI-Code: CL-1205254
	*/
	public static final int KOL_INTER_KOMPLIKATION_JA_INVALID = 1205254;
	/**
	* Der Wert in "Komplikationsart" ist nicht zulässig. ("Interventionspflichtige Komplikationen" ist mit "Nein" belegt.)
	* ORCLI-Code: CL-1205255
	*/
	public static final int KOL_INTER_KOMPLIKATION_JA_FORBIDDEN = 1205255;
	/**
	* "Behandlung" ist ein Mussfeld. ("Interventionspflichtige Komplikationen" ist mit "Ja" belegt.)
	* ORCLI-Code: CL-1205261
	*/
	public static final int KOL_BEHANDLUNG_REQUIRED = 1205261;
	/**
	* Der Wert in "Behandlung" ist nicht zulässig.
	* ORCLI-Code: CL-1205264
	*/
	public static final int KOL_BEHANDLUNG_INVALID = 1205264;
	/**
	* Der Wert in "Behandlung" ist nicht zulässig. ("Interventionspflichtige Komplikationen" ist mit "Nein" belegt.)
	* ORCLI-Code: CL-1205265
	*/
	public static final int KOL_BEHANDLUNG_FORBIDDEN = 1205265;
	/**
	* "Ausgang" ist ein Mussfeld. ("Interventionspflichtige Komplikationen" ist mit "Ja" belegt.)
	* ORCLI-Code: CL-1205271
	*/
	public static final int KOL_AUSGANG_REQUIRED = 1205271;
	/**
	* Der Wert in "Ausgang" ist nicht zulässig.
	* ORCLI-Code: CL-1205274
	*/
	public static final int KOL_AUSGANG_INVALID = 1205274;
	/**
	* Der Wert in "Ausgang" ist nicht zulässig. ("Interventionspflichtige Komplikationen" ist mit "Nein" belegt.)
	* ORCLI-Code: CL-1205275
	*/
	public static final int KOL_AUSGANG_FORBIDDEN = 1205275;
    /**
    * "Anzahl", "Größe", "Lokalisation" und "Form" müssen angegeben werden, wenn "Makroskopischer Befund" mit "Kolon Ca", "Rektum Ca" oder "Polypen" befüllt ist.
    * ORCLI-Code: CL-1205280
    */
    public static final int KOL_ANZAHL_FORM_GROESSE_LOKALISATON_REQUIRED = 1205280;
	/**
	* "Anzahl" ist ein Mussfeld. ("Form" und/oder "Größe" und/oder "Lokalisation" ist angegeben.)
	* ORCLI-Code: CL-1205282
	*/
	public static final int KOL_ANZAHL_REQUIRED = 1205281;
	/**
	* Der Wert in "Anzahl" ist nicht zulässig.
	* ORCLI-Code: CL-1205284
	*/
	public static final int KOL_ANZAHL_INVALID = 1205284;
	/**
	* Der Wert in "Anzahl" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205285
	*/
	public static final int KOL_ANZAHL_FORBIDDEN = 1205285;
	/**
	* "Form" ist ein Mussfeld. ("Anzahl" und/oder "Größe" und/oder "Lokalisation" ist angegeben.)
	* ORCLI-Code: CL-1205292
	*/
	public static final int KOL_FORM_REQUIRED = 1205291;
	/**
	* Der Wert in "Form" ist nicht zulässig.
	* ORCLI-Code: CL-1205294
	*/
	public static final int KOL_FORM_INVALID = 1205294;
	/**
	* Der Wert in "Form" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205295
	*/
	public static final int KOL_FORM_FORBIDDEN = 1205295;
	/**
	* "Größe" ist ein Mussfeld. ("Anzahl" und/oder "Form" und/oder "Lokalisation" ist angegeben.)
	* ORCLI-Code: CL-1205302
	*/
	public static final int KOL_GROESSE_REQUIRED = 1205301;
	/**
	* Der Wert in "Größe" ist nicht zulässig.
	* ORCLI-Code: CL-1205304
	*/
	public static final int KOL_GROESSE_INVALID = 1205304;
	/**
	* Der Wert in "Größe" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205305
	*/
	public static final int KOL_GROESSE_FORBIDDEN = 1205305;
	/**
	* "Lokalisation" ist ein Mussfeld. ("Anzahl" und/oder "Form" und/oder "Größe" ist angegeben.)
	* ORCLI-Code: CL-1205312
	*/
	public static final int KOL_LOKALISATION_REQUIRED = 1205311;
	/**
	* Der Wert in "Lokalisation" ist nicht zulässig.
	* ORCLI-Code: CL-1205314
	*/
	public static final int KOL_LOKALISATION_INVALID = 1205314;
	/**
	* Der Wert in "Lokalisation" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205315
	*/
	public static final int KOL_LOKALISATION_FORBIDDEN = 1205315;
    /**
    * "Polypektomie" ist ein Mussfeld.
    * ORCLI-Code: CL-1205321
    */
    public static final int KOL_POLYPEKTOMIE_REQUIRED = 1205321;
	/**
	* Der Wert in "Polypektomie" ist nicht zulässig.
	* ORCLI-Code: CL-1205324
	*/
	public static final int KOL_POLYPEKTOMIE_INVALID = 1205324;
	/**
	* Der Wert in "Polypektomie" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205325
	*/
	public static final int KOL_POLYPEKTOMIE_FORBIDDEN = 1205325;
    /**
	* "Zangenabtragung" ist ein Mussfeld.
	* ORCLI-Code: CL-1205331
	*/
	public static final int KOL_ZANGENABTRAGUNG_REQUIRED = 1205331;
	/**
	* Der Wert in "Zangenabtragung" ist nicht zulässig.
	* ORCLI-Code: CL-1205334
	*/
	public static final int KOL_ZANGENABTRAGUNG_INVALID = 1205334;
	/**
	* Der Wert in "Zangenabtragung" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205335
	*/
	public static final int KOL_ZANGENABTRAGUNG_FORBIDDEN = 1205335;
	/**
	* "Polyp(en) entfernt" ist ein Pflichtfeld. 
	* (Eintrag muss gewählt werden, da "Polypektomie" ungleich "keine" und/oder "Zangenabtragung" mit "Ja" belegt ist.)
	* ORCLI-Code: CL-1205342
	*/
	public static final int KOL_POLYP_ENTFERNT_REQUIRED2 = 1205342;
	/**
	* Der Wert in "Polyp(en) entfernt" ist nicht zulässig.
	* ORCLI-Code: CL-1205344
	*/
	public static final int KOL_POLYP_ENTFERNT_INVALID = 1205344;
	/**
	* Der Wert in "Polyp(en) entfernt" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205345
	*/
	public static final int KOL_POLYP_ENTFERNT_FORBIDDEN = 1205345;
	/**
	* Der Wert in "Polyp(en) entfernt" ist ungültig. 
	* ("Polypektomie" mit "keine" und "Zangenabtragung" mit "Nein" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205347
	*/
	public static final int KOL_POLYP_ENTFERNT_FORBIDDEN3 = 1205347;
    /**
	* "Polyp(en) geborgen" ist ein Pflichtfeld. 
	* (Eintrag muss gewählt werden, da "Polypektomie" ungleich "keine" und/oder "Zangenabtragung" mit "Ja" belegt ist.)
	* ORCLI-Code: CL-1205352
	*/
	public static final int KOL_POLYP_GEBORGEN_REQUIRED2 = 1205352;
	/**
	* Der Wert in "Polyp(en) geborgen" ist nicht zulässig.
	* ORCLI-Code: CL-1205354
	*/
	public static final int KOL_POLYP_GEBORGEN_INVALID = 1205354;
	/**
	* Der Wert in "Polyp(en) geborgen" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205355
	*/
	public static final int KOL_POLYP_GEBORGEN_FORBIDDEN = 1205355;
	/**
	* Der Wert in "Polyp(en) geborgen" ist ungültig. 
	* ("Polypektomie" mit "keine" und "Zangenabtragung" mit "Nein" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205357
	*/
	public static final int KOL_POLYP_GEBORGEN_FORBIDDEN3 = 1205357;
    /**
	* "Biopsie entnommen" ist ein Pflichtfeld. 
	* (Eintrag muss gewählt werden, da "Polypektomie" mit "keine" und "Zangenabtragung" mit "Nein" belegt ist.)
	* ORCLI-Code: CL-1205362
	*/
	public static final int KOL_BIOPSIE_ENTNOMMEN_REQUIRED2 = 1205362;
	/**
	* Der Wert in "Biopsie entnommen" ist nicht zulässig.
	* ORCLI-Code: CL-1205364
	*/
	public static final int KOL_BIOPSIE_ENTNOMMEN_INVALID = 1205364;
	/**
	* Der Wert in "Biopsie entnommen" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205365
	*/
	public static final int KOL_BIOPSIE_ENTNOMMEN_FORBIDDEN = 1205365;
	/**
	* Es muss mindestens bei "Polyp", "Adenom", "Karzinom" oder "Sonstiges" ein Eintrag gewählt werden.
	* ORCLI-Code: CL-1205480
	*/
	public static final int KOL_HISTOLOGISCHER_BEFUND_REQUIRED = 1205370;
	/**
	* Der Wert in "Polyp" ist nicht zulässig.
	* ORCLI-Code: CL-1205374
	*/
	public static final int KOL_POLYP_INVALID = 1205374;
	/**
	* Der Wert in "Polyp" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205375
	*/
	public static final int KOL_POLYP_FORBIDDEN = 1205375;
    /**
    * Der Wert in "Polyp" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205377
    */
    public static final int KOL_POLYP_FORBIDDEN3 = 1205377;
    /**
    * Der Wert in "Polyp" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205378
    */
    public static final int KOL_POLYP_FORBIDDEN4 = 1205378;
	/**
	* Der Wert in "Adenom" ist nicht zulässig.
	* ORCLI-Code: CL-1205384
	*/
	public static final int KOL_ADENOM_INVALID = 1205384;
	/**
	* Der Wert in "Adenom" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205385
	*/
	public static final int KOL_ADENOM_FORBIDDEN = 1205385;
    /**
    * Der Wert in "Adenom" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205387
    */
    public static final int KOL_ADENOM_FORBIDDEN3 = 1205387;
    /**
    * Der Wert in "Adenom" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205388
    */
    public static final int KOL_ADENOM_FORBIDDEN4 = 1205388;
    /**
    * "Adenom in toto entfernt" ist ein Mussfeld. (Eintrag muss gewählt werden, da "Adenom" belegt ist.)
    * ORCLI-Code: CL-1205391
    */
    public static final int KOL_ADENOM_ENTFERNT_REQUIRED = 1205391;
	/**
	* Der Wert in "Adenom in toto entfernt" ist nicht zulässig.
	* ORCLI-Code: CL-1205394
	*/
	public static final int KOL_ADENOM_ENTFERNT_INVALID = 1205394;
	/**
	* Der Wert in "Adenom in toto entfernt" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205395
	*/
	public static final int KOL_ADENOM_ENTFERNT_FORBIDDEN = 1205395;
    /**
    * Der Wert in "Adenom in toto entfernt" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205397
    */
    public static final int KOL_ADENOM_ENTFERNT_FORBIDDEN3 = 1205397;
    /**
    * Der Wert in "Adenom in toto entfernt" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205398
    */
    public static final int KOL_ADENOM_ENTFERNT_FORBIDDEN4 = 1205398;
    /**
    * "Karzinom in toto entfernt" ist ein Mussfeld. (Eintrag muss gewählt werden, da "Karzinom" mit "Ja" belegt ist.)
    * ORCLI-Code: CL-1205401
    */
    public static final int KOL_KARZINOM_ENTFERNT_REQUIRED = 1205401;
	/**
	* Der Wert in "Karzinom in toto entfernt" ist nicht zulässig.
	* ORCLI-Code: CL-1205404
	*/
	public static final int KOL_KARZINOM_ENTFERNT_INVALID = 1205404;
	/**
	* Der Wert in "Karzinom in toto entfernt" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205405
	*/
	public static final int KOL_KARZINOM_ENTFERNT_FORBIDDEN = 1205405;
    /**
    * Der Wert in "Karzinom in toto entfernt" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205407
    */
    public static final int KOL_KARZINOM_ENTFERNT_FORBIDDEN3 = 1205407;
    /**
    * Der Wert in "Karzinom in toto entfernt" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205408
    */
    public static final int KOL_KARZINOM_ENTFERNT_FORBIDDEN4 = 1205408;
	/**
	* Der Wert in "Sonstiges" ist nicht zulässig.
	* ORCLI-Code: CL-1205414
	*/
	public static final int KOL_SONSTIGES_INVALID = 1205414;
	/**
	* Der Wert in "Sonstiges" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205415
	*/
	public static final int KOL_SONSTIGES_FORBIDDEN = 1205415;
    /**
    * Der Wert in "Sonstiges" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205417
    */
    public static final int KOL_SONSTIGES_FORBIDDEN3 = 1205417;
    /**
    * Der Wert in "Sonstiges" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205418
    */
    public static final int KOL_SONSTIGES_FORBIDDEN4 = 1205418;
	/**
	* "Diagnose" ist ein Mussfeld. (Da mindestens "Polyp", "Adenom", "Karzinom" oder "Sonstiges" anzugeben ist.)
	* ORCLI-Code: CL-1205422
	*/
	public static final int KOL_DIAGNOSE_REQUIRED = 1205421;
	/**
	* Der Wert in "Diagnose" ist nicht zulässig.
	* ORCLI-Code: CL-1205424
	*/
	public static final int KOL_DIAGNOSE_INVALID = 1205424;
	/**
	* Der Wert in "Diagnose" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205425
	*/
	public static final int KOL_DIAGNOSE_FORBIDDEN = 1205425;
    /**
    * Der Wert in "Diagnose" ist nicht zulässig. ("Karzinom" ist mit "Ja" belegt, nur "Rektum Ca." oder "Kolon Ca." als Auswahl erlaubt.)
    * ORCLI-Code: CL-1205426
    */
    public static final int KOL_DIAGNOSE_INVALID2 = 1205426;
    /**
    * Der Wert in "Diagnose" ist nicht zulässig. ("Adenom" belegt und "Karzinom" mit "Nein" oder nicht belegt, nur Eintrag "Adenome" erlaubt.)
    * ORCLI-Code: CL-1205427
    */
    public static final int KOL_DIAGNOSE_INVALID3 = 1205427;
	/**
	* "Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist ein Mussfeld.
	* ORCLI-Code: CL-1205431
	*/
	public static final int KOL_PATIENTENKONTAKT_VERLOREN_REQUIRED = 1205431;
	/**
	* Der Wert in "Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist nicht zulässig.
	* ORCLI-Code: CL-1205434
	*/
	public static final int KOL_PATIENTENKONTAKT_VERLOREN_INVALID = 1205434;
	/**
	* Der Wert in "Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205435
	*/
	public static final int KOL_PATIENTENKONTAKT_VERLOREN_FORBIDDEN = 1205435;
	/**
	* "Maßnahme" ist ein Mussfeld. ("Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist mit "Ja" belegt.)
	* ORCLI-Code: CL-1205441
	*/
	public static final int KOL_MASSNAHMEN_REQUIRED = 1205441;
	/**
	* Der Wert in "Maßnahme" ist nicht zulässig.
	* ORCLI-Code: CL-1205444
	*/
	public static final int KOL_MASSNAHMEN_INVALID = 1205444;
	/**
	* Der Wert in "Maßnahme" ist nicht zulässig. ("Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist mit "Nein" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205445
	*/
	public static final int KOL_MASSNAHMEN_FORBIDDEN = 1205445;
	/**
	* Der Wert in "Maßnahme" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205446
	*/
	public static final int KOL_MASSNAHMEN_NOT_ALLOWED = 1205446;
	/**
	* "Endoskopische Polypenabtragung" ist ein Mussfeld. ("Maßnahme" ist mit "endoskopische Polypenabtragung" belegt.)
	* ORCLI-Code: CL-1205451
	*/
	public static final int KOL_POLYPENABTRAGUNG_REQUIRED = 1205451;
	/**
	* Der Wert in "endoskopische Polypenabtragung" ist nicht zulässig.
	* ORCLI-Code: CL-1205454
	*/
	public static final int KOL_POLYPENABTRAGUNG_INVALID = 1205454;
	/**
	* Der Wert in "endoskopische Polypenabtragung" ist nicht zulässig. ("Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist mit "Nein" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205455
	*/
	public static final int KOL_POLYPENABTRAGUNG_FORBIDDEN = 1205455;
	/**
	* Der Wert in "endoskopische Polypenabtragung" ist nicht zulässig. ("Maßnahme" ist mit "Kontrollkoloskopie" oder "Operation" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205456
	*/
	public static final int KOL_POLYPENABTRAGUNG_FORBIDDEN2 = 1205456;
	/**
	* Der Wert in "endoskopische Polypenabtragung" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205457
	*/
	public static final int KOL_POLYPENABTRAGUNG_FORBIDDEN3 = 1205457;
	/**
	* "Kontrollkoloskopie in" ist ein Mussfeld. ("Maßnahme" ist mit "Kontrollkoloskopie" belegt.)
	* ORCLI-Code: CL-1205461
	*/
	public static final int KOL_KONTROLLE_MONATE_REQUIRED = 1205461;
	/**
	* "Kontrollkoloskopie in" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1205463
	*/
	public static final int KOL_KONTROLLE_MONATE_WRONG_FORMAT = 1205463;
	/**
	* Der Wert in "Kontrollkoloskopie in" ist nicht zulässig. ("Angeratene weitere Maßnahmen bei Polypen/Adenomen/Karzinom" ist mit "Nein" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205465
	*/
	public static final int KOL_KONTROLLE_MONATE_FORBIDDEN = 1205465;
	/**
	* Der Wert in "Kontrollkoloskopie in" ist nicht zulässig. ("Maßnahme" ist mit "Polypenabtragung" oder "Operation" belegt bzw. nicht gesetzt.)
	* ORCLI-Code: CL-1205466
	*/
	public static final int KOL_KONTROLLE_MONATE_NOT_ALLOWED = 1205466;
	/**
	* Der Wert in "Kontrollkoloskopie in" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
	* ORCLI-Code: CL-1205467
	*/
	public static final int KOL_KONTROLLE_MONATE_NOT_ALLOWED2 = 1205467;
    /**
    * "Kommentar" hat nicht das richtige Format. Bitte überprüfen Sie ihre Eingabe.
    * ORCLI-Code: CL-1205473
    */
    public static final int KOL_KOMMENTAR_WRONG_FORMAT = 1205473;
    /**
    * Der Wert in "Karzinom" ist nicht zulässig.
    * ORCLI-Code: CL-1205484
    */
    public static final int KOL_HISTOKARZINOM_INVALID = 1205484;
    /**
    * Der Wert in "Karzinom" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
    * ORCLI-Code: CL-1205485
    */
    public static final int KOL_HISTOKARZINOM_FORBIDDEN = 1205485;
    /**
    * Der Wert in "Karzinom" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205487
    */
    public static final int KOL_HISTOKARZINOM_FORBIDDEN3 = 1205487;
    /**
    * Der Wert in "Karzinom" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205488
    */
    public static final int KOL_HISTOKARZINOM_FORBIDDEN4 = 1205488;



    /**
    * "Dysplasie " ist ein Mussfeld. (Eintrag muss gewählt werden, da "Adenom" belegt ist.)
    * ORCLI-Code: CL-1205491
    */
    public static final int KOL_DYSPLASIE_REQUIRED = 1205491;
    /**
    * Der Wert in "Dysplasie" ist nicht zulässig.
    * ORCLI-Code: CL-1205494
    */
    public static final int KOL_DYSPLASIE_INVALID = 1205494;
    /**
    * Der Wert in "Dysplasie" ist nicht zulässig. ("Adenom" ist nicht belegt.)
    * ORCLI-Code: CL-1205495
    */
    public static final int KOL_DYSPLASIE_FORBIDDEN = 1205495;
    /**
    * Der Wert in "Dysplasie" ist nicht zulässig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
    * ORCLI-Code: CL-1205496
    */
    public static final int KOL_DYSPLASIE_FORBIDDEN2 = 1205496;
    /**
    * Der Wert in "Dysplasie" ist nicht zulässig. ("Polyp geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205498
    */
    public static final int KOL_DYSPLASIE_FORBIDDEN4 = 1205498;
    /**
    * Der Wert in "Dysplasie" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205499
    */
    public static final int KOL_DYSPLASIE_FORBIDDEN5 = 1205499;
    /**
    * "Vorbereitungsqualität " ist ein Mussfeld.
    * ORCLI-Code: CL-1205501
    */
    public static final int KOL_VORBEREITUNGSQUALITAET_REQUIRED = 1205501;
    /**
    * Der Wert in "Vorbereitungsqualität" ist nicht zulässig.
    * ORCLI-Code: CL-1205504
    */
    public static final int KOL_VORBEREITUNGSQUALITAET_INVALID = 1205504;
    /**
    * "Patientenzustimmung" ist ein Pflichtfeld.
    * ORCLI-Code: CL-1205511
    */
    public static final int KOL_PATIENTENZUSTIMMUNG_REQUIRED = 1205511;
    /**
    * Der Wert in "Patientenzustimmung" ist ungültig.
    * ORCLI-Code: CL-1205514
    */
    public static final int KOL_PATIENTENZUSTIMMUNG_INVALID = 1205514;
    /**
    * Der Wert in "Patientenzustimmung" ist ungültig. 
    * (Bei Erfassung einer Qualitätszertifikatskoloskopie ist die Angabe nicht erlaubt.)
    * ORCLI-Code: CL-1205515
    */
    public static final int KOL_PATIENTENZUSTIMMUNG_FORBIDDEN = 1205515;
    /**
    * "Untersuchung" ist ein Pflichtfeld.
    * ORCLI-Code: CL-1205521
    */
    public static final int KOL_UNTERSUCHUNG_REQUIRED = 1205521;
    /**
    * Der Wert in "Untersuchung" ist ungültig. 
    * ORCLI-Code: CL-1205524
    */
    public static final int KOL_UNTERSUCHUNG_INVALID = 1205524;
    /**
    * "Anzahl Adenome" ist ein Pflichtfeld. (Eintrag muss gewählt werden, da Adenom belegt ist.) 
    * ORCLI-Code: CL-1205531
    */
    public static final int KOL_ANZAHL_ADENOME_REQUIRED = 1205531;
    /**
    * Der Wert in "Anzahl Adenome" ist ungültig.
    * ORCLI-Code: CL-1205534
    */
    public static final int KOL_ANZAHL_ADENOME_INVALID = 1205534;
    /**
    * Der Wert in "Anzahl Adenome" ist ungültig. ("Adenom" ist nicht belegt.)
    * ORCLI-Code: CL-1205535
    */
    public static final int KOL_ANZAHL_ADENOME_FORBIDDEN = 1205535;
    /**
    * Der Wert in "Anzahl Adenome" ist ungültig. ("Makroskopischer Befund" ist mit "ohne Befund" belegt.)
    * ORCLI-Code: CL-1205536
    */
    public static final int KOL_ANZAHL_ADENOME_FORBIDDEN2 = 1205536;
    /**
    * Der Wert in "Anzahl Adenome" ist ungültig. 
    * ("Polypektomie" mit "keine" und "Zangenabtragung" und "Biopsie entnommen" mit "Nein" belegt.)
    * ORCLI-Code: CL-1205537
    */
    public static final int KOL_ANZAHL_ADENOME_FORBIDDEN3 = 1205537;
    /**
    * Der Wert in "Anzahl Adenome" ist ungültig. 
    * ("Polyp(en) geborgen" mit "Nein" und "Biopsie entnommen" mit "Nein" oder nicht belegt.)
    * ORCLI-Code: CL-1205538
    */
    public static final int KOL_ANZAHL_ADENOME_FORBIDDEN4 = 1205538;
    /**
	* "DatenblattDmpDm2" ist ein Mussfeld.
	* ORCLI-Code: CL-1206001
	*/
	public static final int DATENBLATT_DMP_DM2_REQUIRED = 1206001;
	/**
	* "Untersuchungsdatum" ist ein Mussfeld.
	* ORCLI-Code: CL-1206051
	*/
	public static final int DMP_DATENBLATT_UNTERSUCHUNGSDATUM_REQUIRED = 1206051;
	/**
	* "Untersuchungsdatum" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206053
	*/
	public static final int DMP_DATENBLATT_UNTERSUCHUNGSDATUM_WRONG_FORMAT = 1206053;
	/**
	* Der Wert in "Untersuchungsdatum" ist nicht zulässig.
	* ORCLI-Code: CL-1206054
	*/
	public static final int DMP_DATENBLATT_UNTERSUCHUNGSDATUM_INVALID = 1206054;
	/**
	* "Diabetes-Diagnose" ist ein Mussfeld.
	* ORCLI-Code: CL-1206201
	*/
	public static final int DM2_DIABETES_DIAGNOSE_JAHR_REQUIRED = 1206201;
	/**
	* "Diabetes-Diagnose" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206203
	*/
	public static final int DM2_DIABETES_DIAGNOSE_JAHR_WRONG_FORMAT = 1206203;
	/**
	* Der Wert in "Diabetes-Diagnose" ist nicht zulässig. (Wert liegt nicht zwischen 1900 und aktuellem Jahr bzw. ist kleiner als das Geburtsjahr.)
	* ORCLI-Code: CL-1206204
	*/
	public static final int DM2_DIABETES_DIAGNOSE_JAHR_INVALID = 1206204;
	/**
	* "Hypertonie seit" ist ein Mussfeld.
	* ORCLI-Code: CL-1206211
	*/
	public static final int DM2_HYPERTONIE_SEIT_JAHR_REQUIRED = 1206211;
	/**
	* "Hypertonie seit" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206213
	*/
	public static final int DM2_HYPERTONIE_SEIT_JAHR_WRONG_FORMAT = 1206213;
	/**
	* Der Wert in "Hypertonie seit" ist nicht zulässig. (Wert liegt nicht zwischen 1900 und aktuellem Jahr bzw. ist kleiner als das Geburtsjahr.)
	* ORCLI-Code: CL-1206214
	*/
	public static final int DM2_HYPERTONIE_SEIT_JAHR_INVALID = 1206214;
	/**
	* "Insulin seit" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206223
	*/
	public static final int DM2_INSULIN_SEIT_JAHR_WRONG_FORMAT = 1206223;
	/**
	* Der Wert in "Insulin seit" ist nicht zulässig. (Wert liegt nicht zwischen 1900 und aktuellem Jahr bzw. ist kleiner als das Geburtsjahr.)
	* ORCLI-Code: CL-1206224
	*/
	public static final int DM2_INSULIN_SEIT_JAHR_INVALID = 1206224;
	/**
	* "OAD seit" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206233
	*/
	public static final int DM2_OAD_SEIT_JAHR_WRONG_FORMAT = 1206233;
	/**
	* Der Wert in "OAD seit" ist nicht zulässig. (Wert liegt nicht zwischen 1900 und aktuellem Jahr bzw. ist kleiner als das Geburtsjahr.)
	* ORCLI-Code: CL-1206234
	*/
	public static final int DM2_OAD_SEIT_JAHR_INVALID = 1206234;
	/**
	* "Blindheit" ist ein Mussfeld.
	* ORCLI-Code: CL-1206241
	*/
	public static final int DM2_BLINDHEIT_REQUIRED = 1206241;
	/**
	* Der Wert in "Blindheit" ist nicht zulässig.
	* ORCLI-Code: CL-1206244
	*/
	public static final int DM2_BLINDHEIT_INVALID = 1206244;
	/**
	* "Terminales Nierenversagen" ist ein Mussfeld.
	* ORCLI-Code: CL-1206251
	*/
	public static final int DM2_TERMINALES_NIERENVERSAGEN_REQUIRED = 1206251;
	/**
	* Der Wert in "Terminales Nierenversagen" ist nicht zulässig.
	* ORCLI-Code: CL-1206254
	*/
	public static final int DM2_TERMINALES_NIERENVERSAGEN_INVALID = 1206254;
	/**
	* "Herz: Infarkt" ist ein Mussfeld.
	* ORCLI-Code: CL-1206261
	*/
	public static final int DM2_HERZINFARKT_REQUIRED = 1206261;
	/**
	* Der Wert in "Herz: Infarkt" ist nicht zulässig.
	* ORCLI-Code: CL-1206264
	*/
	public static final int DM2_HERZINFARKT_INVALID = 1206264;
	/**
	* "Herz: Bypass/Dilatation" ist ein Mussfeld.
	* ORCLI-Code: CL-1206271
	*/
	public static final int DM2_HERZ_BYPASS_DILATATION_REQUIRED = 1206271;
	/**
	* Der Wert in "Herz: Bypass/Dilatation" ist nicht zulässig.
	* ORCLI-Code: CL-1206274
	*/
	public static final int DM2_HERZ_BYPASS_DILATATION_INVALID = 1206274;
	/**
	* "Apoplexie" ist ein Mussfeld.
	* ORCLI-Code: CL-1206281
	*/
	public static final int DM2_APOPLEXIE_REQUIRED = 1206281;
	/**
	* Der Wert in "Apoplexie" ist nicht zulässig.
	* ORCLI-Code: CL-1206284
	*/
	public static final int DM2_APOPLEXIE_INVALID = 1206284;
	/**
	* "Amputation" ist ein Mussfeld.
	* ORCLI-Code: CL-1206291
	*/
	public static final int DM2_AMPUTATION_REQUIRED = 1206291;
	/**
	* Der Wert in "Amputation" ist nicht zulässig.
	* ORCLI-Code: CL-1206294
	*/
	public static final int DM2_AMPUTATION_INVALID = 1206294;
	/**
	* "Neuropathie" ist ein Mussfeld.
	* ORCLI-Code: CL-1206301
	*/
	public static final int DM2_NEUROPATHIE_REQUIRED = 1206301;
	/**
	* Der Wert in "Neuropathie" ist nicht zulässig.
	* ORCLI-Code: CL-1206304
	*/
	public static final int DM2_NEUROPATHIE_INVALID = 1206304;
	/**
	* "Angina pectoris" ist ein Mussfeld.
	* ORCLI-Code: CL-1206311
	*/
	public static final int DM2_ANGINA_PECTORIS_REQUIRED = 1206311;
	/**
	* Der Wert in "Angina pectoris" ist nicht zulässig.
	* ORCLI-Code: CL-1206314
	*/
	public static final int DM2_ANGINA_PECTORIS_INVALID = 1206314;
	/**
	* "Claudicatio" ist ein Mussfeld.
	* ORCLI-Code: CL-1206321
	*/
	public static final int DM2_CLAUDICATIO_REQUIRED = 1206321;
	/**
	* Der Wert in "Claudicatio" ist nicht zulässig.
	* ORCLI-Code: CL-1206324
	*/
	public static final int DM2_CLAUDICATIO_INVALID = 1206324;
	/**
	* "TIA/PRIND" ist ein Mussfeld.
	* ORCLI-Code: CL-1206331
	*/
	public static final int DM2_TIAPRIND_REQUIRED = 1206331;
	/**
	* Der Wert in "TIA/PRIND" ist nicht zulässig.
	* ORCLI-Code: CL-1206334
	*/
	public static final int DM2_TIAPRIND_INVALID = 1206334;
	/**
	* "Schwere Hypoglykämie" ist ein Mussfeld.
	* ORCLI-Code: CL-1206341
	*/
	public static final int DM2_SCHWERE_HYPOGLYKAEMIE_REQUIRED = 1206341;
	/**
	* Der Wert in "Schwere Hypoglykämie" ist nicht zulässig.
	* ORCLI-Code: CL-1206344
	*/
	public static final int DM2_SCHWERE_HYPOGLYKAEMIE_INVALID = 1206344;
	/**
	* "Erektile Dysfunktion" ist ein Mussfeld.
	* ORCLI-Code: CL-1206351
	*/
	public static final int DM2_EREKTILE_DYSFUNKTION_REQUIRED = 1206351;
	/**
	* Der Wert in "Erektile Dysfunktion" ist nicht zulässig.
	* ORCLI-Code: CL-1206354
	*/
	public static final int DM2_EREKTILE_DYSFUNKTION_INVALID = 1206354;
	/**
	* Der Wert in "Erektile Dysfunktion" ist nicht zulässig. (Angabe nur bei Männern möglich.)
	* ORCLI-Code: CL-1206355
	*/
	public static final int DM2_EREKTILE_DYSFUNKTION_FORBIDDEN = 1206355;
	/**
	* Der Wert in "Herzinsuffizienz" ist nicht zulässig.
	* ORCLI-Code: CL-1206364
	*/
	public static final int DM2_HERZINSUFFIZIENZ_INVALID = 1206364;
	/**
	* Der Wert in "KHK" ist nicht zulässig.
	* ORCLI-Code: CL-1206374
	*/
	public static final int DM2_KHK_INVALID = 1206374;
	/**
	* Der Wert in "Depression" ist nicht zulässig.
	* ORCLI-Code: CL-1206384
	*/
	public static final int DM2_DEPRESSION_INVALID = 1206384;
	/**
	* Der Wert in "PAVK" ist nicht zulässig.
	* ORCLI-Code: CL-1206394
	*/
	public static final int DM2_PAVK_INVALID = 1206394;
	/**
	* Der Wert in "Bypass" ist nicht zulässig.
	* ORCLI-Code: CL-1206404
	*/
	public static final int DM2_PAVK_BYPASS_INVALID = 1206404;
	/**
	* Der Wert in "Dilatation" ist nicht zulässig.
	* ORCLI-Code: CL-1206414
	*/
	public static final int DM2_PAVK_DILATATION_INVALID = 1206414;
	/**
	* "In den letzten 12 Monaten" ist ein Mussfeld.
	* ORCLI-Code: CL-1206421
	*/
	public static final int DM2_INNERHALB12_MONATEN_REQUIRED = 1206421;
	/**
	* Der Wert in "in den letzten 12 Monaten" ist nicht zulässig.
	* ORCLI-Code: CL-1206424
	*/
	public static final int DM2_INNERHALB12_MONATEN_INVALID = 1206424;
	/**
	* Der Wert in "Laserung" ist nicht zulässig.
	* ORCLI-Code: CL-1206434
	*/
	public static final int DM2_LASERUNG_INVALID = 1206434;
	/**
	* Der Wert in "Retinopathie: nicht proliferativ" ist nicht zulässig.
	* ORCLI-Code: CL-1206444
	*/
	public static final int DM2_RETINOPATHIE_NICHT_PROLIFERATIV_INVALID = 1206444;
	/**
	* Der Wert in "Retinopathie: proliferativ" ist nicht zulässig.
	* ORCLI-Code: CL-1206454
	*/
	public static final int DM2_RETINOPATHIE_PROLIFERATIV_INVALID = 1206454;
	/**
	* Der Wert in "Retinopathie: proliferativ" ist nicht zulässig. ("Retinopathie: nicht proliferativ" mit "Ja" belegt.)
	* ORCLI-Code: CL-1206455
	*/
	public static final int DM2_RETINOPATHIE_PROLIFERATIV_INVALID2 = 1206455;
	/**
	* Der Wert in "Makulopathie" ist nicht zulässig.
	* ORCLI-Code: CL-1206464
	*/
	public static final int DM2_MAKULOPATHIE_INVALID = 1206464;
	/**
	* "Fußdeformität (links)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206471
	*/
	public static final int DM2_FUSSDEFORMITAET_LINKS_REQUIRED = 1206471;
	/**
	* Der Wert in "Fußdeformität (links)" ist nicht zulässig.
	* ORCLI-Code: CL-1206474
	*/
	public static final int DM2_FUSSDEFORMITAET_LINKS_INVALID = 1206474;
	/**
	* "Fußdeformität (rechts)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206481
	*/
	public static final int DM2_FUSSDEFORMITAET_RECHTS_REQUIRED = 1206481;
	/**
	* Der Wert in "Fußdeformität (rechts)" ist nicht zulässig.
	* ORCLI-Code: CL-1206484
	*/
	public static final int DM2_FUSSDEFORMITAET_RECHTS_INVALID = 1206484;
	/**
	* "Geheiltes Ulkus (links)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206491
	*/
	public static final int DM2_GEHEILTES_ULKUS_LINKS_REQUIRED = 1206491;
	/**
	* Der Wert in "Geheiltes Ulkus (links)" ist nicht zulässig.
	* ORCLI-Code: CL-1206494
	*/
	public static final int DM2_GEHEILTES_ULKUS_LINKS_INVALID = 1206494;
	/**
	* "Geheiltes Ulkus (rechts)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206501
	*/
	public static final int DM2_GEHEILTES_ULKUS_RECHTS_REQUIRED = 1206501;
	/**
	* Der Wert in "Geheiltes Ulkus (rechts)" ist nicht zulässig.
	* ORCLI-Code: CL-1206504
	*/
	public static final int DM2_GEHEILTES_ULKUS_RECHTS_INVALID = 1206504;
	/**
	* "Akutes Ulkus (links)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206511
	*/
	public static final int DM2_AKUTES_ULKUS_LINKS_REQUIRED = 1206511;
	/**
	* Der Wert in "Akutes Ulkus (links)" ist nicht zulässig.
	* ORCLI-Code: CL-1206514
	*/
	public static final int DM2_AKUTES_ULKUS_LINKS_INVALID = 1206514;
	/**
	* "Akutes Ulkus (rechts)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206521
	*/
	public static final int DM2_AKUTES_ULKUS_RECHTS_REQUIRED = 1206521;
	/**
	* Der Wert in "Akutes Ulkus (rechts)" ist nicht zulässig.
	* ORCLI-Code: CL-1206524
	*/
	public static final int DM2_AKUTES_ULKUS_RECHTS_INVALID = 1206524;
	/**
	* "Puls nicht tastbar (links)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206531
	*/
	public static final int DM2_PULS_NICHT_TASTBAR_LINKS_REQUIRED = 1206531;
	/**
	* Der Wert in "Puls nicht tastbar (links)" ist nicht zulässig.
	* ORCLI-Code: CL-1206534
	*/
	public static final int DM2_PULS_NICHT_TASTBAR_LINKS_INVALID = 1206534;
	/**
	* "Puls nicht tastbar (rechts)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206541
	*/
	public static final int DM2_PULS_NICHT_TASTBAR_RECHTS_REQUIRED = 1206541;
	/**
	* Der Wert in "Puls nicht tastbar (rechts)" ist nicht zulässig.
	* ORCLI-Code: CL-1206544
	*/
	public static final int DM2_PULS_NICHT_TASTBAR_RECHTS_INVALID = 1206544;
	/**
	* "Vibrationsempfinden vermindert (links)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206551
	*/
	public static final int DM2_VIBRATIONSEMPFINDEN_VERMINDERT_LINKS_REQUIRED = 1206551;
	/**
	* Der Wert in "Vibrationsempfinden vermindert (links)" ist nicht zulässig.
	* ORCLI-Code: CL-1206554
	*/
	public static final int DM2_VIBRATIONSEMPFINDEN_VERMINDERT_LINKS_INVALID = 1206554;
	/**
	* "Vibrationsempfinden vermindert (rechts)" ist ein Mussfeld.
	* ORCLI-Code: CL-1206561
	*/
	public static final int DM2_VIBRATIONSEMPFINDEN_VERMINDERT_RECHTS_REQUIRED = 1206561;
	/**
	* Der Wert in "Vibrationsempfinden vermindert (rechts)" ist nicht zulässig.
	* ORCLI-Code: CL-1206564
	*/
	public static final int DM2_VIBRATIONSEMPFINDEN_VERMINDERT_RECHTS_INVALID = 1206564;
	/**
	* "Rauchen" ist ein Mussfeld.
	* ORCLI-Code: CL-1206571
	*/
	public static final int DM2_RAUCHEN_REQUIRED = 1206571;
	/**
	* "Rauchen" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206573
	*/
	public static final int DM2_RAUCHEN_WRONG_FORMAT = 1206573;
	/**
	* Der Wert in "Rauchen" ist nicht zulässig.
	* ORCLI-Code: CL-1206574
	*/
	public static final int DM2_RAUCHEN_INVALID = 1206574;
	/**
	* Der Wert in "Rauchen" ist nicht zulässig. (Muss größer 0 sein, wenn "Tabak" auf "ja" gesetzt ist.)
	* ORCLI-Code: CL-1206575
	*/
	public static final int DM2_RAUCHEN_INVALID2 = 1206575;
	/**
	* "EQ-5D" ist ein Mussfeld.
	* ORCLI-Code: CL-1206581
	*/
	public static final int DM2_EQ_5D_REQUIRED = 1206581;
	/**
	* "EQ-5D" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206583
	*/
	public static final int DM2_EQ_5D_WRONG_FORMAT = 1206583;
	/**
	* "EQ-5D VAS" ist ein Mussfeld.
	* ORCLI-Code: CL-1206591
	*/
	public static final int DM2_EQ_5DVAS_REQUIRED = 1206591;
	/**
	* "EQ-5D VAS" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206593
	*/
	public static final int DM2_EQ_5DVAS_WRONG_FORMAT = 1206593;
	/**
	* Der Wert in "EQ-5D VAS" ist nicht zulässig.
	* ORCLI-Code: CL-1206594
	*/
	public static final int DM2_EQ_5DVAS_INVALID = 1206594;
	/**
	* "Gewicht" ist ein Mussfeld.
	* ORCLI-Code: CL-1206601
	*/
	public static final int DM2_GEWICHT_REQUIRED = 1206601;
	/**
	* "Gewicht" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206603
	*/
	public static final int DM2_GEWICHT_WRONG_FORMAT = 1206603;
	/**
	* Der Wert in "Gewicht" ist nicht zulässig.
	* ORCLI-Code: CL-1206604
	*/
	public static final int DM2_GEWICHT_INVALID = 1206604;
	/**
	* "Größe" ist ein Mussfeld.
	* ORCLI-Code: CL-1206611
	*/
	public static final int DM2_GROESSE_REQUIRED = 1206611;
	/**
	* "Größe" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206613
	*/
	public static final int DM2_GROESSE_WRONG_FORMAT = 1206613;
	/**
	* Der Wert in "Größe" ist nicht zulässig.
	* ORCLI-Code: CL-1206614
	*/
	public static final int DM2_GROESSE_INVALID = 1206614;
	/**
	* "Blutdruck in Ruhe Einmalmessung (systolisch)" ist ein Mussfeld. ("Blutdruck in Ruhe Einmalmessung (diastolisch)" ist belegt.)
	* ORCLI-Code: CL-1206631
	*/
	public static final int DM2_RRSYS_RUHEMESSUNG_REQUIRED = 1206631;
	/**
	* "Blutdruck in Ruhe Einmalmessung (systolisch)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206633
	*/
	public static final int DM2_RRSYS_RUHEMESSUNG_WRONG_FORMAT = 1206633;
	/**
	* Der Wert in "Blutdruck in Ruhe Einmalmessung (systolisch)" ist nicht zulässig.
	* ORCLI-Code: CL-1206634
	*/
	public static final int DM2_RRSYS_RUHEMESSUNG_INVALID = 1206634;
	/**
	* Der Wert in "Blutdruck in Ruhe Einmalmessung (systolisch)" ist nicht zulässig. (Der Wert muss größer sein als der diastolische.)
	* ORCLI-Code: CL-1206635
	*/
	public static final int DM2_RRSYS_RUHEMESSUNG_INVALID2 = 1206635;
	/**
	* "Blutdruck in Ruhe Einmalmessung (diastolisch)" ist ein Mussfeld. ("Blutdruck in Ruhe Einmalmessung (systolisch)" ist belegt.)
	* ORCLI-Code: CL-1206641
	*/
	public static final int DM2_RRDIA_RUHEMESSUNG_REQUIRED = 1206641;
	/**
	* "Blutdruck in Ruhe Einmalmessung (diastolisch)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206643
	*/
	public static final int DM2_RRDIA_RUHEMESSUNG_WRONG_FORMAT = 1206643;
	/**
	* Der Wert in "Blutdruck in Ruhe Einmalmessung (diastolisch)" ist nicht zulässig.
	* ORCLI-Code: CL-1206644
	*/
	public static final int DM2_RRDIA_RUHEMESSUNG_INVALID = 1206644;
	/**
	* Entweder "HbA1c (%)" oder "HbA1c (mmol/mol)" muss angegeben werden.
	* ORCLI-Code: CL-1206690
	*/
	public static final int DM2_HBA_1C_HBA_1C_MOL_REQUIRED = 1206690;
	/**
	* "HbA1c (%)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206693
	*/
	public static final int DM2_HBA_1C_WRONG_FORMAT = 1206693;
	/**
	* Der Wert in "HbA1c (%)" ist nicht zulässig.
	* ORCLI-Code: CL-1206694
	*/
	public static final int DM2_HBA_1C_INVALID = 1206694;
	/**
	* "Kreatinin" ist ein Mussfeld.
	* ORCLI-Code: CL-1206701
	*/
	public static final int DM2_KREATININ_REQUIRED = 1206701;
	/**
	* "Kreatinin" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206703
	*/
	public static final int DM2_KREATININ_WRONG_FORMAT = 1206703;
	/**
	* Der Wert in "Kreatinin" ist nicht zulässig.
	* ORCLI-Code: CL-1206704
	*/
	public static final int DM2_KREATININ_INVALID = 1206704;
    /**
    * "Cholesterin" ist ein Mussfeld.
    * ORCLI-Code: CL-1206711
    */
    public static final int DM2_CHOLESTERIN_REQUIRED = 1206711;
	/**
	* "Cholesterin" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206713
	*/
	public static final int DM2_CHOLESTERIN_WRONG_FORMAT = 1206713;
	/**
	* Der Wert in "Cholesterin" ist nicht zulässig.
	* ORCLI-Code: CL-1206714
	*/
	public static final int DM2_CHOLESTERIN_INVALID = 1206714;
    /**
    * "HDL-Chol" ist ein Mussfeld.
    * ORCLI-Code: CL-1206721
    */
    public static final int DM2_HDL_CHOLESTERIN_REQUIRED = 1206721;
	/**
	* "HDL-Chol" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206723
	*/
	public static final int DM2_HDL_CHOLESTERIN_WRONG_FORMAT = 1206723;
	/**
	* Der Wert in "HDL-Chol" ist nicht zulässig.
	* ORCLI-Code: CL-1206724
	*/
	public static final int DM2_HDL_CHOLESTERIN_INVALID = 1206724;
    /**
    * "Triglyceride" ist ein Mussfeld.
    * ORCLI-Code: CL-1206741
    */
    public static final int DM2_TRIGLYCERIDE_REQUIRED = 1206741;
	/**
	* "Triglyceride" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206743
	*/
	public static final int DM2_TRIGLYCERIDE_WRONG_FORMAT = 1206743;
	/**
	* Der Wert in "Triglyceride" ist nicht zulässig.
	* ORCLI-Code: CL-1206744
	*/
	public static final int DM2_TRIGLYCERIDE_INVALID = 1206744;
	/**
	* "Mikroalbuminurie" ist ein Mussfeld.
	* ORCLI-Code: CL-1206751
	*/
	public static final int DM2_MIKROALBUMINURIE_REQUIRED = 1206751;
	/**
	* Der Wert in "Mikroalbuminurie" ist nicht zulässig.
	* ORCLI-Code: CL-1206754
	*/
	public static final int DM2_MIKROALBUMINURIE_INVALID = 1206754;
	/**
	* "Proteinurie" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206763
	*/
	public static final int DM2_PROTEINURIE_WRONG_FORMAT = 1206763;
	/**
	* Der Wert in "Proteinurie" ist nicht zulässig.
	* ORCLI-Code: CL-1206764
	*/
	public static final int DM2_PROTEINURIE_INVALID = 1206764;
	/**
	* "Nur Diät" ist ein Mussfeld.
	* ORCLI-Code: CL-1206771
	*/
	public static final int DM2_NUR_DIAET_REQUIRED = 1206771;
	/**
	* Der Wert in "Nur Diät" ist nicht zulässig.
	* ORCLI-Code: CL-1206774
	*/
	public static final int DM2_NUR_DIAET_INVALID = 1206774;
	/**
	* "OAD" ist ein Mussfeld.
	* ORCLI-Code: CL-1206781
	*/
	public static final int DM2_OAD_REQUIRED = 1206781;
	/**
	* Der Wert in "OAD" ist nicht zulässig.
	* ORCLI-Code: CL-1206784
	*/
	public static final int DM2_OAD_INVALID = 1206784;
	/**
	* "Insulin" ist ein Mussfeld.
	* ORCLI-Code: CL-1206791
	*/
	public static final int DM2_INSULIN_REQUIRED = 1206791;
	/**
	* Der Wert in "Insulin" ist nicht zulässig.
	* ORCLI-Code: CL-1206794
	*/
	public static final int DM2_INSULIN_INVALID = 1206794;
    /**
    * Entweder "Konventionell", "Prä-prandial", "Intensiviert" oder "Nur basal" muss mit "Ja" belegt sein.
    * ORCLI-Code: CL-1206800
    */
    public static final int DM2_INSULIN_ZUSATZ_REQUIRED = 1206800;
	/**
	* Der Wert in "Insulin: Konventionell" ist nicht zulässig.
	* ORCLI-Code: CL-1206804
	*/
	public static final int DM2_INSULIN_KONVENTIONELL_INVALID = 1206804;
    /**
    * Der Wert in "Insulin: Konventionell" ist nicht zulässig. ("Insulin" mit "Nein" belegt.)
    * ORCLI-Code: CL-1206805
    */
    public static final int DM2_INSULIN_KONVENTIONELL_INVALID2 = 1206805;
    /**
     * Der Wert in "Insulin: Konventionell" ist nicht zulässig. ("Prä-prandial" und/oder "Intensiviert" und/oder "Nur basal" mit "Ja" belegt.)
     * ORCLI-Code: CL-1206806
     */
     public static final int DM2_INSULIN_KONVENTIONELL_INVALID3 = 1206806;
	/**
	* Der Wert in "Insulin: Prä-prandial" ist nicht zulässig.
	* ORCLI-Code: CL-1206814
	*/
	public static final int DM2_INSULIN_PRAEPRANDIAL_INVALID = 1206814;
    /**
    * Der Wert in "Insulin: Prä-prandial" ist nicht zulässig. ("Insulin" mit "Nein" belegt.)
    * ORCLI-Code: CL-1206815
    */
    public static final int DM2_INSULIN_PRAEPRANDIAL_INVALID2 = 1206815;
    /**
     * Der Wert in "Insulin: Prä-prandial" ist nicht zulässig. ("Intensiviert" und/oder "Nur basal" mit "Ja" belegt.)
     * ORCLI-Code: CL-1206816
     */
     public static final int DM2_INSULIN_PRAEPRANDIAL_INVALID3 = 1206816;
	/**
	* Der Wert in "Insulin: Intensiviert" ist nicht zulässig.
	* ORCLI-Code: CL-1206824
	*/
	public static final int DM2_INSULIN_INTENSIVIERT_INVALID = 1206824;
    /**
    * Der Wert in "Insulin: Intensiviert" ist nicht zulässig. ("Insulin" mit "Nein" belegt.)
    * ORCLI-Code: CL-1206825
    */
    public static final int DM2_INSULIN_INTENSIVIERT_INVALID2 = 1206825;
    /**
     * Der Wert in "Insulin: Intensiviert" ist nicht zulässig. ("Nur basal" mit "Ja" belegt.)
     * ORCLI-Code: CL-1206826
     */
     public static final int DM2_INSULIN_INTENSIVIERT_INVALID3 = 1206826;
	/**
	* Der Wert in "Insulin: Nur basal" ist nicht zulässig.
	* ORCLI-Code: CL-1206834
	*/
	public static final int DM2_INSULIN_NUR_BASAL_INVALID = 1206834;
    /**
    * Der Wert in "Insulin: Nur basal" ist nicht zulässig. ("Insulin" mit "Nein" belegt.)
    * ORCLI-Code: CL-1206835
    */
    public static final int DM2_INSULIN_NUR_BASAL_INVALID2 = 1206835;
	/**
	* "Blutdruck Therapie" ist ein Mussfeld.
	* ORCLI-Code: CL-1206841
	*/
	public static final int DM2_BLUTDRUCK_THERAPIE_REQUIRED = 1206841;
	/**
	* Der Wert in "Blutdruck Therapie" ist nicht zulässig.
	* ORCLI-Code: CL-1206844
	*/
	public static final int DM2_BLUTDRUCK_THERAPIE_INVALID = 1206844;
	/**
	* "Gewicht" ist ein Mussfeld.
	* ORCLI-Code: CL-1206851
	*/
	public static final int DM2_GEWICHT_ZIELVEREINBARUNG_REQUIRED = 1206851;
	/**
	* Der Wert in "Gewicht" ist nicht zulässig.
	* ORCLI-Code: CL-1206854
	*/
	public static final int DM2_GEWICHT_ZIELVEREINBARUNG_INVALID = 1206854;
	/**
	* "Bewegung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206861
	*/
	public static final int DM2_BEWEGUNG_REQUIRED = 1206861;
	/**
	* Der Wert in "Bewegung" ist nicht zulässig.
	* ORCLI-Code: CL-1206864
	*/
	public static final int DM2_BEWEGUNG_INVALID = 1206864;
	/**
	* "Tabak" ist ein Mussfeld.
	* ORCLI-Code: CL-1206871
	*/
	public static final int DM2_TABAK_REQUIRED = 1206871;
	/**
	* Der Wert in "Tabak" ist nicht zulässig. (Darf nicht den Wert "Ja" haben, wenn "Rauchen" den Wert 0 hat.)
	* ORCLI-Code: CL-1206874
	*/
	public static final int DM2_TABAK_INVALID = 1206874;
	/**
	* "Ernährung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206881
	*/
	public static final int DM2_ERNAEHRUNG_REQUIRED = 1206881;
	/**
	* Der Wert in "Ernährung" ist nicht zulässig.
	* ORCLI-Code: CL-1206884
	*/
	public static final int DM2_ERNAEHRUNG_INVALID = 1206884;
	/**
	* "Blutdruck Zielvereinbarung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206891
	*/
	public static final int DM2_BLUTDRUCK_ZIELVEREINBARUNG_REQUIRED = 1206891;
	/**
	* Der Wert in "Blutdruck Zielvereinbarung" ist nicht zulässig.
	* ORCLI-Code: CL-1206894
	*/
	public static final int DM2_BLUTDRUCK_ZIELVEREINBARUNG_INVALID = 1206894;
	/**
	* Entweder "HbA1c (%) Zielvereinbarung" oder "HbA1c (mmol/mol) Zielvereinbarung" muss angegeben werden.
	* ORCLI-Code: CL-1206900
	*/
	public static final int DM2_HBA_1C_ZV_HBA_1C_MOL_ZV_REQUIRED = 1206900;
	/**
	* "HbA1c (%) Zielvereinbarung" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206903
	*/
	public static final int DM2_HBA_1C_ZIELVEREINBARUNG_WRONG_FORMAT = 1206903;
	/**
	* Der Wert in "HbA1c (%) Zielvereinbarung" ist nicht zulässig.
	* ORCLI-Code: CL-1206904
	*/
	public static final int DM2_HBA_1C_ZIELVEREINBARUNG_INVALID = 1206904;
	/**
	* "Blutdruckmessung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206911
	*/
	public static final int DM2_BLUTDRUCKMESSUNG_REQUIRED = 1206911;
	/**
	* Der Wert in "Blutdruckmessung" ist nicht zulässig.
	* ORCLI-Code: CL-1206914
	*/
	public static final int DM2_BLUTDRUCKMESSUNG_INVALID = 1206914;
	/**
	* "Blutzuckermessung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206921
	*/
	public static final int DM2_BLUTZUCKERMESSUNG_REQUIRED = 1206921;
	/**
	* Der Wert in "Blutzuckermessung" ist nicht zulässig.
	* ORCLI-Code: CL-1206924
	*/
	public static final int DM2_BLUTZUCKERMESSUNG_INVALID = 1206924;
	/**
	* "Harnzuckermessung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206931
	*/
	public static final int DM2_HARNZUCKERMESSUNG_REQUIRED = 1206931;
	/**
	* Der Wert in "Harnzuckermessung" ist nicht zulässig.
	* ORCLI-Code: CL-1206934
	*/
	public static final int DM2_HARNZUCKERMESSUNG_INVALID = 1206934;
	/**
	* "Diabetes- Schulung" ist ein Mussfeld.
	* ORCLI-Code: CL-1206941
	*/
	public static final int DM2_SCHULUNG_REQUIRED = 1206941;
	/**
	* Der Wert in "Diabetes- Schulung" ist nicht zulässig.
	* ORCLI-Code: CL-1206944
	*/
	public static final int DM2_SCHULUNG_INVALID = 1206944;
	/**
	* Der Wert in "Diabetes- Schulung" ist nicht zulässig. (Muss den Wert "Ja" haben, wenn "Schulungsjahr" angegeben ist.)
	* ORCLI-Code: CL-1206945
	*/
	public static final int DM2_SCHULUNG_INVALID2 = 1206945;
	/**
	* "Schulungsjahr" ist ein Mussfeld.
	* ORCLI-Code: CL-1206951
	*/
	public static final int DM2_DIABETES_SCHULUNG_WANN_JAHR_REQUIRED = 1206951;
	/**
	* "Schulungsjahr" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1206953
	*/
	public static final int DM2_DIABETES_SCHULUNG_WANN_JAHR_WRONG_FORMAT = 1206953;
	/**
	* Der Wert in "Schulungsjahr" ist nicht zulässig. (Wert liegt nicht zwischen 1900 und aktuellem Jahr bzw. ist kleiner als das Geburtsjahr.)
	* ORCLI-Code: CL-1206954
	*/
	public static final int DM2_DIABETES_SCHULUNG_WANN_JAHR_INVALID = 1206954;
	/**
	* Der Wert in "Retinopathie" ist nicht zulässig.
	* ORCLI-Code: CL-1206994
	*/
	public static final int DM2_RETINOPATHIE_INVALID = 1206994;
	/**
	* Der Wert in "Retinopathie" ist nicht zulässig. ("Retinopathie: proliferativ" oder "Retinopathie: nicht proliferativ" mit "Ja" belegt.)
	* ORCLI-Code: CL-1206995
	*/
	public static final int DM2_RETINOPATHIE_INVALID2 = 1206995;
    /**
    * "HbA1c (mmol/mol)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
    * ORCLI-Code: CL-1206963
    */
    public static final int DM2_HBA_1C_MOL_WRONG_FORMAT = 1206963;
    /**
    * Der Wert in "HbA1c (mmol/mol)" ist nicht zulässig.
    * ORCLI-Code: CL-1206964
    */
    public static final int DM2_HBA_1C_MOL_INVALID = 1206964;
    /**
    * "HbA1c (mmol/mol)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
    * ORCLI-Code: CL-1206973
    */
    public static final int DM2_HBA_1C_MOL_ZIELVEREINBARUNG_WRONG_FORMAT = 1206973;
    /**
    * Der Wert in "HbA1c (mmol/mol)" ist nicht zulässig.
    * ORCLI-Code: CL-1206974
    */
    public static final int DM2_HBA_1C_MOL_ZIELVEREINBARUNG_INVALID = 1206974;
	/**
	* "Datenblatttyp" ist ein Mussfeld.
	* ORCLI-Code: CL-1290021
	*/
	public static final int DATENBLATT_TYP_REQUIRED = 1290021;
	/**
	* Der Wert in "Datenblatttyp" ist nicht zulässig.
	* ORCLI-Code: CL-1290024
	*/
	public static final int DATENBLATT_TYP_INVALID = 1290024;
	/**
	* "Von-Datum" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1290033
	*/
	public static final int VON_DATUM_WRONG_FORMAT = 1290033;
	/**
	* "Bis-Datum" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
	* ORCLI-Code: CL-1290043
	*/
	public static final int BIS_DATUM_WRONG_FORMAT = 1290043;
	/**
	* "Suchkriterien" ist ein Mussfeld.
	* ORCLI-Code: CL-1290061
	*/
	public static final int SUCHKRITERIEN_REQUIRED = 1290061;
	/**
	* "Versionsnummer" ist ein Mussfeld.
	* ORCLI-Code: CL-1290081
	*/
	public static final int DATENBLATT_VERSIONSNUMMER_REQUIRED = 1290081;
	/**
	* Der Wert in "Versionsnummer" ist nicht zulässig.
	* ORCLI-Code: CL-1290084
	*/
	public static final int DATENBLATT_VERSIONSNUMMER_INVALID = 1290084;
    /**
    * Der Wert in "SVTCode" ist nicht zulässig.
    * ORCLI-Code: CL-1290094
    */
    public static final int SVT_INVALID = 1290094;
    /**
    * Das Bis-Datum darf nicht vor dem Von-Datum liegen.
    * ORCLI-Code: CL-1200030
    */
    public static final int VON_DATUM_VOR_BIS_DATUM = 1200030;
    /**
     * "Geburtsdatum" ist ein Mussfeld.
     * ORCLI-Code: CL-1290071
     */
    public static final int GEBURTSDATUM_REQUIRED = 1290071;
    /**
     * "Geburtsdatum" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1290073
     */
    public static final int GEBURTSDATUM_WRONG_FORMAT = 1290073;
    /**
     * Der Wert in "Geburtsdatum " ist nicht zulässig.
     * Das Datum darf nicht in der Zukunft liegen.
     * ORCLI-Code: CL-1290074
     */
    public static final int GEBURTSDATUM_INVALID4 = 1290074;
    /**
     * Der Wert in "Geburtsdatum " ist nicht zulässig.
     * Das Datum darf nicht nach dem Behandlungsdatum der verfügbaren
     * Konsultation(en) liegen.
     * ORCLI-Code: CL-1290075
     */
    public static final int GEBURTSDATUM_INVALID = 1290075;
    /**
     * Der Wert in "Geburtsdatum " ist nicht zulässig.
     * Das Datum der Eingabe stimmt nicht mit dem ermittelten
     * Datum überein.
     * ORCLI-Code: CL-1290076
     */
    public static final int GEBURTSDATUM_INVALID2 = 1290076;
    /**
     * Der Wert in "Geburtsdatum" ist nicht zulässig.
     * Das Datum darf nicht nach dem Datum der Einschreibung liegen.
     * ORCLI-Code: CL-1290077
     */
    public static final int GEBURTSDATUM_INVALID3 = 1290077;
    /**
     * "Untersuchungsdatum" ist ein Mussfeld.
     * ORCLI-Code: CL-1207101
     */
    public static final int QZK_UNTERSUCHUNGSDATUM_REQUIRED = 1207101;
    /**
     * "Untersuchungsdatum" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1207103
     */
    public static final int QZK_UNTERSUCHUNGSDATUM_WRONG_FORMAT = 1207103;
    /**
     * Der Wert in "Untersuchungsdatum" ist nicht zulässig.
     * ORCLI-Code: CL-1207104
     */
    public static final int QZK_UNTERSUCHUNGSDATUM_INVALID = 1207104;
    /**
     * "DatenblattDmpPmi" ist ein Mussfeld.
     * ORCLI-Code: CL-1208001
     */
    public static final int DATENBLATT_DMP_PMI_REQUIRED = 1208001;
    /**
     * "Anzahl bisheriger Infarkte" ist ein Mussfeld.
     * ORCLI-Code: CL-1208201
     */
    public static final int PMI_ANZAHL_INFARKTE_REQUIRED = 1208201;
    /**
     * "Anzahl bisheriger Infarkte" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208203
     */
    public static final int PMI_ANZAHL_INFARKTE_WRONG_FORMAT = 1208203;
    /**
     * Der Wert in "Anzahl bisheriger Infarkte" ist nicht zulässig.
     * ORCLI-Code: CL-1208204
     */
    public static final int PMI_ANZAHL_INFARKTE_INVALID = 1208204;
    /**
     * "Letzter Herzinfarkt (Jahr)" ist ein Mussfeld. ("Anzahl bisheriger Infarkte" ist mit größer 0 belegt.)
     * ORCLI-Code: CL-1208211
     */
    public static final int PMI_LETZTER_INFARKT_JAHR_REQUIRED = 1208211;
    /**
     * "Letzter Herzinfarkt (Jahr)" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208213
     */
    public static final int PMI_LETZTER_INFARKT_JAHR_WRONG_FORMAT = 1208213;
    /**
     * Der Wert in "Letzter Herzinfarkt (Jahr)" ist nicht zulässig.
     * (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208214
     */
    public static final int PMI_LETZTER_INFARKT_JAHR_INVALID = 1208214;
    /**
     * Der Wert in "Letzter Herzinfarkt (Jahr)" ist nicht zulässig.
     * ("Anzahl bisheriger Infarkte" ist mit "0" belegt.)
     * ORCLI-Code: CL-1208215
     */
    public static final int PMI_LETZTER_INFARKT_JAHR_FORBIDDEN = 1208215;
    /**
     * "Infarktart" ist ein Mussfeld. ("Anzahl bisheriger Infarkte" ist mit größer 0 belegt.)
     * ORCLI-Code: CL-1208221
     */
    public static final int PMI_INFARKTART_REQUIRED = 1208221;
    /**
     * Der Wert in "Infarktart" ist nicht zulässig.
     * ORCLI-Code: CL-1208224
     */
    public static final int PMI_INFARKTART_INVALID = 1208224;
    /**
     * Der Wert in "Infarktart" ist nicht zulässig. ("Anzahl bisheriger Infarkte" ist mit "0" belegt.)
     * ORCLI-Code: CL-1208225
     */
    public static final int PMI_INFARKTART_FORBIDDEN = 1208225;
    /**
     * "Insult (Familienanamnese)" ist ein Mussfeld.
     * ORCLI-Code: CL-1208231
     */
    public static final int PMI_INSULT_FAMILIE_REQUIRED = 1208231;
    /**
     * Der Wert in "Insult (Familienanamnese)" ist nicht zulässig.
     * ORCLI-Code: CL-1208234
     */
    public static final int PMI_INSULT_FAMILIE_INVALID = 1208234;
    /**
     * "Herzinfarkt (Familienanamnese)" ist ein Mussfeld.
     * ORCLI-Code: CL-1208241
     */
    public static final int PMI_HERZINFARKT_FAMILIE_REQUIRED = 1208241;
    /**
     * Der Wert in "Herzinfarkt (Familienanamnese)" ist nicht zulässig.
     * ORCLI-Code: CL-1208244
     */
    public static final int PMI_HERZINFARKT_FAMILIE_INVALID = 1208244;
    /**
     * "PAVK" ist ein Mussfeld.
     * ORCLI-Code: CL-1208871
     */
    public static final int PMI_PAVK_REQUIRED = 1208871;
    /**
     * Der Wert in "PAVK" ist nicht zulässig.
     * ORCLI-Code: CL-1208874
     */
    public static final int PMI_PAVK_INVALID = 1208874;
    /**
     * "Aortacoronarer Bypass" ist ein Mussfeld.
     * ORCLI-Code: CL-1208251
     */
    public static final int PMI_AORTACORONAR_BYPASS_REQUIRED = 1208251;
    /**
     * "Aortacoronarer Bypass" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208253
     */
    public static final int PMI_AORTACORONAR_BYPASS_WRONG_FORMAT = 1208253;
    /**
     * "Carotis-OP" ist ein Mussfeld.
     * ORCLI-Code: CL-1208261
     */
    public static final int PMI_CAROTIS_OP_REQUIRED = 1208261;
    /**
     * "Carotis-OP" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208263
     */
    public static final int PMI_CAROTIS_OP_WRONG_FORMAT = 1208263;
    /**
     * "Peripherer Bypass/PTA" ist ein Mussfeld.
     * ORCLI-Code: CL-1208271
     */
    public static final int PMI_PERIPHERER_BYPASS_PTA_REQUIRED = 1208271;
    /**
     * "Peripherer Bypass/PTA" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208273
     */
    public static final int PMI_PERIPHERER_BYPASS_PTA_WRONG_FORMAT = 1208273;
    /**
     * "Stent" ist ein Mussfeld.
     * ORCLI-Code: CL-1208281
     */
    public static final int PMI_STENT_REQUIRED = 1208281;
    /**
     * "Stent" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208283
     */
    public static final int PMI_STENT_WRONG_FORMAT = 1208283;
    /**
     * Der Wert in "Letzter Stent" ist nicht zulässig.
     * ORCLI-Code: CL-1208294
     */
    public static final int PMI_LETZTER_STENT_INVALID = 1208294;
    /**
     * Der Wert in "Letzter Stent" ist nicht zulässig. ("Stent" ist mit "0" belegt.)
     * ORCLI-Code: CL-1208295
     */
    public static final int PMI_LETZTER_STENT_FORBIDDEN = 1208295;
    /**
     * "Angina pectoris" ist ein Mussfeld.
     * ORCLI-Code: CL-1208301
     */
    public static final int PMI_ANGINA_PECTORIS_REQUIRED = 1208301;
    /**
     * "Angina pectoris" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208303
     */
    public static final int PMI_ANGINA_PECTORIS_WRONG_FORMAT = 1208303;
    /**
     * Der Wert in "Angina pectoris" ist nicht zulässig.
     * ORCLI-Code: CL-1208304
     */
    public static final int PMI_ANGINA_PECTORIS_INVALID = 1208304;
    /**
     * "Herzinsuffizienz" ist ein Mussfeld.
     * ORCLI-Code: CL-1208311
     */
    public static final int PMI_HERZINSUFFIZIENZ_REQUIRED = 1208311;
    /**
     * "Herzinsuffizienz" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208313
     */
    public static final int PMI_HERZINSUFFIZIENZ_WRONG_FORMAT = 1208313;
    /**
     * Der Wert in "Herzinsuffizienz" ist nicht zulässig.
     * ORCLI-Code: CL-1208314
     */
    public static final int PMI_HERZINSUFFIZIENZ_INVALID = 1208314;
    /**
     * "Insult (Anamnese)" ist ein Mussfeld.
     * ORCLI-Code: CL-1208321
     */
    public static final int PMI_INSULT_ANAMNESE_REQUIRED = 1208321;
    /**
     * Der Wert in "Insult (Anamnese)" ist nicht zulässig.
     * ORCLI-Code: CL-1208324
     */
    public static final int PMI_INSULT_ANAMNESE_INVALID = 1208324;
    /**
     * "Letzte kardiologische REHA" ist ein Mussfeld.
     * ORCLI-Code: CL-1208331
     */
    public static final int PMI_LETZTE_KARDIOLOGISCHE_REHA_REQUIRED = 1208331;
    /**
     * "Letzte kardiologische REHA" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208333
     */
    public static final int PMI_LETZTE_KARDIOLOGISCHE_REHA_WRONG_FORMAT = 1208333;
    /**
     * Der Wert in "Letzte kardiologische REHA" ist nicht zulässig.
     * (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208334
     */
    public static final int PMI_LETZTE_KARDIOLOGISCHE_REHA_INVALID = 1208334;
    /**
     * "Hypertonie seit ca." ist ein Mussfeld.
     * ORCLI-Code: CL-1208341
     */
    public static final int PMI_HYPERTONIE_SEIT_REQUIRED = 1208341;
    /**
     * "Hypertonie seit ca." hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208343
     */
    public static final int PMI_HYPERTONIE_SEIT_WRONG_FORMAT = 1208343;
    /**
     * Der Wert in "Hypertonie seit ca." ist nicht zulässig.
     * (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208344
     */
    public static final int PMI_HYPERTONIE_SEIT_INVALID = 1208344;
    /**
     * "Diabetes seit ca." ist ein Mussfeld.
     * ORCLI-Code: CL-1208351
     */
    public static final int PMI_DIABETES_SEIT_REQUIRED = 1208351;
    /**
     * "Diabetes seit ca." hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208353
     */
    public static final int PMI_DIABETES_SEIT_WRONG_FORMAT = 1208353;
    /**
     * Der Wert in "Diabetes seit ca." ist nicht zulässig.
     * (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208354
     */
    public static final int PMI_DIABETES_SEIT_INVALID = 1208354;
    /**
     * "Dialysepflicht seit" ist ein Mussfeld.
     * ORCLI-Code: CL-1208361
     */
    public static final int PMI_DIALYSEPFLICHT_SEIT_REQUIRED = 1208361;
    /**
     * "Dialysepflicht seit" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208363
     */
    public static final int PMI_DIALYSEPFLICHT_SEIT_WRONG_FORMAT = 1208363;
    /**
     * Der Wert in "Dialysepflicht seit" ist nicht zulässig.
     * (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208364
     */
    public static final int PMI_DIALYSEPFLICHT_SEIT_INVALID = 1208364;
    /**
     * "Rauchen seit ca." ist ein Mussfeld.
     * ORCLI-Code: CL-1208371
     */
    public static final int PMI_RAUCHEN_SEIT_REQUIRED = 1208371;
    /**
     * "Rauchen seit ca." hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208373
     */
    public static final int PMI_RAUCHEN_SEIT_WRONG_FORMAT = 1208373;
    /**
     * Der Wert in "Rauchen seit ca." ist nicht zulässig. (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208374
     */
    public static final int PMI_RAUCHEN_SEIT_INVALID = 1208374;
    /**
     * "Zigaretten/Tag derzeit" ist ein Mussfeld.
     * ORCLI-Code: CL-1208381
     */
    public static final int PMI_ZIGARETTEN_PRO_TAG_REQUIRED = 1208381;
    /**
     * "Zigaretten/Tag derzeit" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208383
     */
    public static final int PMI_ZIGARETTEN_PRO_TAG_WRONG_FORMAT = 1208383;
    /**
     * Der Wert in "Zigaretten/Tag derzeit" ist nicht zulässig.
     * ORCLI-Code: CL-1208384
     */
    public static final int PMI_ZIGARETTEN_PRO_TAG_INVALID = 1208384;
    /**
     * "Gewicht" ist ein Mussfeld.
     * ORCLI-Code: CL-1208391
     */
    public static final int PMI_GEWICHT_BEFUND_REQUIRED = 1208391;
    /**
     * "Gewicht" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208393
     */
    public static final int PMI_GEWICHT_BEFUND_WRONG_FORMAT = 1208393;
    /**
     * Der Wert in "Gewicht" ist nicht zulässig.
     * ORCLI-Code: CL-1208394
     */
    public static final int PMI_GEWICHT_BEFUND_INVALID = 1208394;
    /**
     * "Größe" ist ein Mussfeld.
     * ORCLI-Code: CL-1208401
     */
    public static final int PMI_GROESSE_REQUIRED = 1208401;
    /**
     * "Größe" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208403
     */
    public static final int PMI_GROESSE_WRONG_FORMAT = 1208403;
    /**
     * Der Wert in "Größe" ist nicht zulässig.
     * ORCLI-Code: CL-1208404
     */
    public static final int PMI_GROESSE_INVALID = 1208404;
    /**
     * "Bauchumfang" ist ein Mussfeld.
     * ORCLI-Code: CL-1208411
     */
    public static final int PMI_BAUCHUMFANG_REQUIRED = 1208411;
    /**
     * "Bauchumfang" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208413
     */
    public static final int PMI_BAUCHUMFANG_WRONG_FORMAT = 1208413;
    /**
     * Der Wert in "Bauchumfang" ist nicht zulässig.
     * ORCLI-Code: CL-1208414
     */
    public static final int PMI_BAUCHUMFANG_INVALID = 1208414;
    /**
     * "Blutdruck (sys.) Befund" ist ein Mussfeld.
     * ORCLI-Code: CL-1208431
     */
    public static final int PMI_BLUTDRUCK_SYS_BEFUND_REQUIRED = 1208431;
    /**
     * "Blutdruck (sys.) Befund" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208433
     */
    public static final int PMI_BLUTDRUCK_SYS_BEFUND_WRONG_FORMAT = 1208433;
    /**
     * Der Wert in "Blutdruck (sys.) Befund" ist nicht zulässig.
     * ORCLI-Code: CL-1208434
     */
    public static final int PMI_BLUTDRUCK_SYS_BEFUND_INVALID = 1208434;
    /**
     * Der Wert in "Blutdruck (sys.) Befund" ist nicht zulässig.
     * (Der Wert muss größer sein als der diastolische.)
     * ORCLI-Code: CL-1208435
     */
    public static final int PMI_BLUTDRUCK_SYS_BEFUND_INVALID2 = 1208435;
    /**
     * "Blutdruck (dia.) Befund" ist ein Mussfeld.
     * ORCLI-Code: CL-1208441
     */
    public static final int PMI_BLUTDRUCK_DIA_BEFUND_REQUIRED = 1208441;
    /**
     * "Blutdruck (dia.) Befund" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208443
     */
    public static final int PMI_BLUTDRUCK_DIA_BEFUND_WRONG_FORMAT = 1208443;
    /**
     * Der Wert in "Blutdruck (dia.) Befund" ist nicht zulässig.
     * ORCLI-Code: CL-1208444
     */
    public static final int PMI_BLUTDRUCK_DIA_BEFUND_INVALID = 1208444;
    /**
     * "Blutdruckmessungsart" ist ein Mussfeld.
     * ORCLI-Code: CL-1208451
     */
    public static final int PMI_BLUTDRUCK_MESSART_REQUIRED = 1208451;
    /**
     * Der Wert in "Blutdruckmessungsart" ist nicht zulässig.
     * ORCLI-Code: CL-1208454
     */
    public static final int PMI_BLUTDRUCK_MESSART_INVALID = 1208454;
    /**
     * "Cholesterin" ist ein Mussfeld.
     * ORCLI-Code: CL-1208461
     */
    public static final int PMI_CHOLESTERIN_REQUIRED = 1208461;
    /**
     * "Cholesterin" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208463
     */
    public static final int PMI_CHOLESTERIN_WRONG_FORMAT = 1208463;
    /**
     * Der Wert in "Cholesterin" ist nicht zulässig.
     * ORCLI-Code: CL-1208464
     */
    public static final int PMI_CHOLESTERIN_INVALID = 1208464;
    /**
     * "HDL-Chol" ist ein Mussfeld.
     * ORCLI-Code: CL-1208471
     */
    public static final int PMI_HDL_CHOLESTERIN_REQUIRED = 1208471;
    /**
     * "HDL-Chol" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208473
     */
    public static final int PMI_HDL_CHOLESTERIN_WRONG_FORMAT = 1208473;
    /**
     * Der Wert in "HDL-Chol" ist nicht zulässig.
     * ORCLI-Code: CL-1208474
     */
    public static final int PMI_HDL_CHOLESTERIN_INVALID = 1208474;
    /**
     * "Triglyceride" ist ein Mussfeld.
     * ORCLI-Code: CL-1208481
     */
    public static final int PMI_TRIGLYCERIDE_REQUIRED = 1208481;
    /**
     * "Triglyceride" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208483
     */
    public static final int PMI_TRIGLYCERIDE_WRONG_FORMAT = 1208483;
    /**
     * Der Wert in "Triglyceride" ist nicht zulässig.
     * ORCLI-Code: CL-1208484
     */
    public static final int PMI_TRIGLYCERIDE_INVALID = 1208484;
    /**
     * "EQ-5D" ist ein Mussfeld.
     * ORCLI-Code: CL-1208501
     */
    public static final int PMI_EQ_5D_REQUIRED = 1208501;
    /**
     * "EQ-5D" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208503
     */
    public static final int PMI_EQ_5D_WRONG_FORMAT = 1208503;
    /**
     * "EQ-5D VAS" ist ein Mussfeld.
     * ORCLI-Code: CL-1208511
     */
    public static final int PMI_EQ_5DVAS_REQUIRED = 1208511;
    /**
     * "EQ-5D VAS" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208513
     */
    public static final int PMI_EQ_5DVAS_WRONG_FORMAT = 1208513;
    /**
     * Der Wert in "EQ-5D VAS" ist nicht zulässig.
     * ORCLI-Code: CL-1208514
     */
    public static final int PMI_EQ_5DVAS_INVALID = 1208514;
    /**
     * "Depressionsscore" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208523
     */
    public static final int PMI_DEPRESSIONSSCORE_WRONG_FORMAT = 1208523;
    /**
     * Der Wert in "Depressionsscore" ist nicht zulässig.
     * ORCLI-Code: CL-1208524
     */
    public static final int PMI_DEPRESSIONSSCORE_INVALID = 1208524;
    /**
     * "Gesamtscore" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208533
     */
    public static final int PMI_GESAMTSCORE_WRONG_FORMAT = 1208533;
    /**
     * Der Wert in "Gesamtscore" ist nicht zulässig.
     * ORCLI-Code: CL-1208534
     */
    public static final int PMI_GESAMTSCORE_INVALID = 1208534;
    /**
     * Entweder "Diabetiker(in): HbA1c" oder "Nicht-Diabetiker: Nüchtern-BZ-Wert" muss angegeben werden.
     * ORCLI-Code: CL-1208540
     */
    public static final int PMI_DIABETIKER_HBA1C_NICHTDIABETIKER_NUECHTERN_BZ_WERT_REQUIRED = 1208540;
    /**
     * "Diabetiker(in): HbA1c" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208543
     */
    public static final int PMI_DIABETIKER_HBA1C_WRONG_FORMAT = 1208543;
    /**
     * Der Wert in "Diabetiker(in): HbA1c" ist nicht zulässig.
     * ORCLI-Code: CL-1208544
     */
    public static final int PMI_DIABETIKER_HBA1C_INVALID = 1208544;
    /**
     * "Nicht-Diabetiker(in): Nüchtern-BZ-Wert" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208553
     */
    public static final int PMI_NICHTDIABETIKER_NUECHTERN_BZ_WERT_WRONG_FORMAT = 1208553;
    /**
     * Der Wert in "Nicht-Diabetiker(in): Nüchtern-BZ-Wert" ist nicht zulässig.
     * ORCLI-Code: CL-1208554
     */
    public static final int PMI_NICHTDIABETIKER_NUECHTERN_BZ_WERT_INVALID = 1208554;
    /**
     * "Betablocker" ist ein Mussfeld.
     * ORCLI-Code: CL-1208561
     */
    public static final int PMI_BETABLOCKER_REQUIRED = 1208561;
    /**
     * Der Wert in "Betablocker" ist nicht zulässig.
     * ORCLI-Code: CL-1208564
     */
    public static final int PMI_BETABLOCKER_INVALID = 1208564;
    /**
     * Der Wert in "Betablocker Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208574
     */
    public static final int PMI_BETABLOCKER_KONTRAINDIAKTION_INVALID = 1208574;
    /**
     * "Ace-Hemmer" ist ein Mussfeld.
     * ORCLI-Code: CL-1208581
     */
    public static final int PMI_ACEHEMMER_REQUIRED = 1208581;
    /**
     * Der Wert in "Ace-Hemmer" ist nicht zulässig.
     * ORCLI-Code: CL-1208584
     */
    public static final int PMI_ACEHEMMER_INVALID = 1208584;
    /**
     * Der Wert in "Ace-Hemmer Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208594
     */
    public static final int PMI_ACEHEMMER_KONTRAINDIAKTION_INVALID = 1208594;
    /**
     * "AT-II-Antagonisten" ist ein Mussfeld.
     * ORCLI-Code: CL-1208601
     */
    public static final int PMI_AT_II_ANTAGONISTEN_REQUIRED = 1208601;
    /**
     * Der Wert in "AT-II-Antagonisten" ist nicht zulässig.
     * ORCLI-Code: CL-1208604
     */
    public static final int PMI_AT_II_ANTAGONISTEN_INVALID = 1208604;
    /**
     * Der Wert in "AT-II-Antagonisten Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208614
     */
    public static final int PMI_AT_II_ANTAGONISTEN_KONTRAINDIAKTION_INVALID = 1208614;
    /**
     * "Statine" ist ein Mussfeld.
     * ORCLI-Code: CL-1208621
     */
    public static final int PMI_STATINE_REQUIRED = 1208621;
    /**
     * Der Wert in "Statine" ist nicht zulässig.
     * ORCLI-Code: CL-1208624
     */
    public static final int PMI_STATINE_INVALID = 1208624;
    /**
     * Der Wert in "Statine Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208634
     */
    public static final int PMI_STATINE_KONTRAINDIAKTION_INVALID = 1208634;
    /**
     * "ASS (z.B. Aspirin)" ist ein Mussfeld.
     * ORCLI-Code: CL-1208641
     */
    public static final int PMI_ASS_REQUIRED = 1208641;
    /**
     * Der Wert in "ASS (z.B. Aspirin)" ist nicht zulässig.
     * ORCLI-Code: CL-1208644
     */
    public static final int PMI_ASS_INVALID = 1208644;
    /**
     * Der Wert in "ASS (z.B. Aspirin) Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208654
     */
    public static final int PMI_ASS_KONTRAINDIAKTION_INVALID = 1208654;
    /**
     * "Sonstige (z.B. Pvavix)" ist ein Mussfeld.
     * ORCLI-Code: CL-1208661
     */
    public static final int PMI_SONSTIGE_TAH_REQUIRED = 1208661;
    /**
     * Der Wert in "Sonstige (z.B. Pvavix)" ist nicht zulässig.
     * ORCLI-Code: CL-1208664
     */
    public static final int PMI_SONSTIGE_TAH_INVALID = 1208664;
    /**
     * Der Wert in "Sonstige (z.B. Pvavix) Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208674
     */
    public static final int PMI_SONSTIGE_TAH_KONTRAINDIAKTION_INVALID = 1208674;
    /**
     * "Nitrate/Molsidomin" ist ein Mussfeld.
     * ORCLI-Code: CL-1208681
     */
    public static final int PMI_NITRATE_MOLSIDOMIN_REQUIRED = 1208681;
    /**
     * Der Wert in "Nitrate/Molsidomin" ist nicht zulässig.
     * ORCLI-Code: CL-1208684
     */
    public static final int PMI_NITRATE_MOLSIDOMIN_INVALID = 1208684;
    /**
     * Der Wert in "Nitrate/Molsidomin Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208694
     */
    public static final int PMI_NITRATE_MOLSIDOMIN_KONTRAINDIAKTION_INVALID = 1208694;
    /**
     * "Kalziumkanal-Blocker" ist ein Mussfeld.
     * ORCLI-Code: CL-1208701
     */
    public static final int PMI_KALZIUMKANAL_BLOCKER_REQUIRED = 1208701;
    /**
     * Der Wert in "Kalziumkanal-Blocker" ist nicht zulässig.
     * ORCLI-Code: CL-1208704
     */
    public static final int PMI_KALZIUMKANAL_BLOCKER_INVALID = 1208704;
    /**
     * Der Wert in "Kalziumkanal-Blocker Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208714
     */
    public static final int PMI_KALZIUMKANAL_BLOCKER_KONTRAINDIAKTION_INVALID = 1208714;
    /**
     * "Kaliumkanal-Öffner" ist ein Mussfeld.
     * ORCLI-Code: CL-1208704
     */
    public static final int PMI_KALIUMKANAL_OEFFNER_REQUIRED = 1208721;
    /**
     * Der Wert in "Kaliumkanal-Öffner" ist nicht zulässig.
     * ORCLI-Code: CL-1208724
     */
    public static final int PMI_KALIUMKANAL_OEFFNER_INVALID = 1208724;
    /**
     * Der Wert in "Kaliumkanal-Öffner Kontraindikation" ist nicht zulässig.
     * ORCLI-Code: CL-1208734
     */
    public static final int PMI_KALIUMKANAL_OEFFNER_KONTRAINDIAKTION_INVALID = 1208734;
    /**
     * "Blutdruck (sys.) Zielvereinbarung" ist ein Mussfeld.
     * ORCLI-Code: CL-1208741
     */
    public static final int PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_REQUIRED = 1208741;
    /**
     * "Blutdruck (sys.) Zielvereinbarung" hat nicht das richtige Format.
     * Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208743
     */
    public static final int PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_WRONG_FORMAT = 1208743;
    /**
     * Der Wert in "Blutdruck (sys.) Zielvereinbarung" ist nicht zulässig.
     * ORCLI-Code: CL-1208744
     */
    public static final int PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_INVALID = 1208744;
    /**
     * Der Wert in "Blutdruck (sys.) Zielvereinbarung" ist nicht zulässig.
     * (Der Wert muss größer sein als der diastolische.)
     * ORCLI-Code: CL-1208745
     */
    public static final int PMI_BLUTDRUCK_SYS_ZIELVEREINBARUNG_INVALID2 = 1208745;
    /**
     * "Blutdruck (dia.) Zielvereinbarung" ist ein Mussfeld.
     * ORCLI-Code: CL-1208751
     */
    public static final int PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_REQUIRED = 1208751;
    /**
     * "Blutdruck (dia.) Zielvereinbarung" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208753
     */
    public static final int PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_WRONG_FORMAT = 1208753;
    /**
     * Der Wert in "Blutdruck (dia.) Zielvereinbarung" ist nicht zulässig.
     * ORCLI-Code: CL-1208754
     */
    public static final int PMI_BLUTDRUCK_DIA_ZIELVEREINBARUNG_INVALID = 1208754;
    /**
     * "Ernährung" ist ein Mussfeld.
     * ORCLI-Code: CL-1208761
     */
    public static final int PMI_ERNAEHRUNG_REQUIRED = 1208761;
    /**
     * Der Wert in "Ernährung" ist nicht zulässig.
     * ORCLI-Code: CL-1208764
     */
    public static final int PMI_ERNAEHRUNG_INVALID = 1208764;
    /**
     * "Bewegung ist ein Mussfeld.
     * ORCLI-Code: CL-1208771
     */
    public static final int PMI_BEWEGUNG_REQUIRED = 1208771;
    /**
     * Der Wert in "Bewegung" ist nicht zulässig.
     * ORCLI-Code: CL-1208774
     */
    public static final int PMI_BEWEGUNG_INVALID = 1208774;
    /**
     * "Gewichtsreduktion" ist ein Mussfeld.
     * ORCLI-Code: CL-1208781
     */
    public static final int PMI_GEWICHT_ZIELVEREINBARUNG_REQUIRED = 1208781;
    /**
     * Der Wert in "Gewichtsreduktion" ist nicht zulässig.
     * ORCLI-Code: CL-1208784
     */
    public static final int PMI_GEWICHT_ZIELVEREINBARUNG_INVALID = 1208784;
    /**
     * "Tabakreduktion/-stopp" ist ein Mussfeld.
     * ORCLI-Code: CL-1208791
     */
    public static final int PMI_TABAK_REQUIRED = 1208791;
    /**
     * Der Wert in "Tabakreduktion/-stopp" ist nicht zulässig.
     * ORCLI-Code: CL-1208794
     */
    public static final int PMI_TABAK_INVALID = 1208794;
    /**
     * "Grippeimpfung" ist ein Mussfeld.
     * ORCLI-Code: CL-1208881
     */
    public static final int PMI_GRIPPEIMPFUNG_ZIELVEREINBARUNG_REQUIRED = 1208881;
    /**
     * Der Wert in "Grippeimpfung" ist nicht zulässig.
     * ORCLI-Code: CL-1208884
     */
    public static final int PMI_GRIPPEIMPFUNG_ZIELVEREINBARUNG_INVALID = 1208884;
    /**
     * "Ernährungsberatung" ist ein Mussfeld.
     * ORCLI-Code: CL-1208801
     */
    public static final int PMI_ERNAEHRUNGS_BERATUNG_REQUIRED = 1208801;
    /**
     * Der Wert in "Ernährungsberatung" ist nicht zulässig.
     * ORCLI-Code: CL-1208804
     */
    public static final int PMI_ERNAEHRUNGS_BERATUNG_INVALID = 1208804;
    /**
     * "Körperliche Aktivitäten" ist ein Mussfeld.
     * ORCLI-Code: CL-1208811
     */
    public static final int PMI_KOERPERLICHE_AKTIVITAETEN_REQUIRED = 1208811;
    /**
     * Der Wert in "Körperliche Aktivitäten" ist nicht zulässig.
     * ORCLI-Code: CL-1208814
     */
    public static final int PMI_KOERPERLICHE_AKTIVITAETEN_INVALID = 1208814;
    /**
     * "Raucherberatung/-entwöhnung" ist ein Mussfeld.
     * ORCLI-Code: CL-1208821
     */
    public static final int PMI_RAUCHERBERATUNG_ENTWOEHNUNG_REQUIRED = 1208821;
    /**
     * Der Wert in "Raucherberatung/-entwöhnung" ist nicht zulässig.
     * ORCLI-Code: CL-1208824
     */
    public static final int PMI_RAUCHERBERATUNG_ENTWOEHNUNG_INVALID = 1208824;
    /**
     * "Grippeimpfung im letzten Jahr" ist ein Mussfeld.
     * ORCLI-Code: CL-1208831
     */
    public static final int PMI_GRIPPEIMPFUNG_REQUIRED = 1208831;
    /**
     * Der Wert in "Grippeimpfung im letzten Jahr" ist nicht zulässig.
     * ORCLI-Code: CL-1208834
     */
    public static final int PMI_GRIPPEIMPFUNG_INVALID = 1208834;
    /**
     * "Überweisung zum Internisten/Kardiologen" ist ein Mussfeld.
     * ORCLI-Code: CL-1208841
     */
    public static final int PMI_UEBERWEISUNG_INTERNIST_KARDIOLOGE_REQUIRED = 1208841;
    /**
     * Der Wert in "Überweisung zum Internisten/Kardiologen" ist nicht zulässig.
     * ORCLI-Code: CL-1208844
     */
    public static final int PMI_UEBERWEISUNG_INTERNIST_KARDIOLOGE_INVALID = 1208844;
    /**
     * "Überweisung zur intern./kardiol. Ambulanz" ist ein Mussfeld.
     * ORCLI-Code: CL-1208891
     */
    public static final int PMI_UEBERWEISUNG_INTERN_KARDIOL_AMBULANZ_REQUIRED = 1208891;
    /**
     * Der Wert in "Überweisung zur intern./kardiol. Ambulanz" ist nicht zulässig.
     * ORCLI-Code: CL-1208894
     */
    public static final int PMI_UEBERWEISUNG_INTERN_KARDIOL_AMBULANZ_INVALID = 1208894;
    /**
     * "Überweisung zur stationären Aufnahme" ist ein Mussfeld.
     * ORCLI-Code: CL-1208901
     */
    public static final int PMI_UEBERWEISUNG_STATIONAERE_AUFNAHME_REQUIRED = 1208901;
    /**
     * Der Wert in "Überweisung zur stationären Aufnahme" ist nicht zulässig.
     * ORCLI-Code: CL-1208904
     */
    public static final int PMI_UEBERWEISUNG_STATIONAERE_AUFNAHME_INVALID = 1208904;
    /**
     * Der Wert in "Schulung" ist nicht zulässig.
     * ORCLI-Code: CL-1208854
     */
    public static final int PMI_PMI_SCHULUNG_INVALID = 1208854;
    /**
     * "Schulungsjahr" ist ein Mussfeld. ("Schulung mit "Ja" belegt.)
     * ORCLI-Code: CL-1208861
     */
    public static final int PMI_PMI_SCHULUNG_WANN_JAHR_REQUIRED = 1208861;
    /**
     * "Schulungsjahr" hat nicht das richtige Format. Bitte überprüfen Sie Ihre Eingabe.
     * ORCLI-Code: CL-1208863
     */
    public static final int PMI_PMI_SCHULUNG_WANN_JAHR_FORMAT = 1208863;
    /**
     * Der Wert in "Schulungsjahr" ist nicht zulässig.
     * (Wert liegt nicht zwischen dem aktuellem Jahr und dem Geburtsjahr.)
     * ORCLI-Code: CL-1208864
     */
    public static final int PMI_PMI_SCHULUNG_WANN_JAHR_INVALID = 1208864;
    /**
     * Der Wert in "Schulungsjahr" ist nicht zulässig.
     * ("Schulung" mit "Nein" bzw. nicht belegt.)
     * ORCLI-Code: CL-1208865
     */
    public static final int PMI_PMI_SCHULUNG_WANN_JAHR_FORBIDDEN = 1208865;
}