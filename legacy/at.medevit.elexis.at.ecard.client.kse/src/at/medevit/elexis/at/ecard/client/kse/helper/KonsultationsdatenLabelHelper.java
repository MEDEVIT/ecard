package at.medevit.elexis.at.ecard.client.kse.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import at.chipkarte.client.base.soap.SvtProperty;
import at.chipkarte.client.base.soap.constants.Anspruchsart;
import at.chipkarte.client.base.soap.constants.Bundesland;
import at.chipkarte.client.kse.soap.constants.Konsultationsart;
import at.chipkarte.client.kse.soap.constants.OfflineRecordType;
import at.chipkarte.client.kse.soap.constants.StatusKonsultation;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsbeleg;

public class KonsultationsdatenLabelHelper {

	/**
	 * "Konvertiere" eine {@link Konsultationsbeleg#abrechnungsPeriode} in einen "menschenlesbaren" String
	 * @param periode
	 * @return
	 */
	public static String abrechnungsPeriodeToLabel(String periode){
		String[] monthDE = { "Jänner", "Februar", "März", "April", "Mai",
			"Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"
		};
		
		String year = periode.substring(0, 4);
		int unit = Integer.parseInt(periode.substring(4, 6));
		String interval = periode.substring(6, 7);
		if(interval.equalsIgnoreCase("Q")) {
			return unit+". Quartal "+year;
		} else {
			return monthDE[unit-1]+" "+year;
		}
	}

	public static String booleanValueToLabel(boolean bool){
		if(bool) {
			return "JA";
		} else {
			return "NEIN";
		}
	}
	
	/**
	 * Convert a date of type TTMMYYYY to the form TT. MM. YYYY
	 * @param behandlungsDatum
	 * @return
	 */
	public static String datumToLabel(String behandlungsDatum){
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return output.format(sdf.parse(behandlungsDatum));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Convert a {@link LimitCode} into a label.
	 * @param limitCode
	 * @return
	 */
	public static String limitcodeToLabel(String limitCode){
		int lc = limitCode.hashCode();
		switch (lc) {
		case 2521: return "Ohne e-card Limit"; // OH
		case 2519: return "Offline Limit"; // OF
		default: return limitCode;
		}
	}
	
	/**
	 * Returns the Bundesland string according to the code, as defined in
	 * {@link Bundesland}
	 * @param bundeslandCode
	 * @return
	 */
	public static String bundeslandCodeToLabel(int bundeslandCode) {
		switch (bundeslandCode) {
		case 0: return "AUSLAND";
		case 1: return "WIEN";
		case 2: return "NIEDERÖSTERREICH";
		case 3: return "BURGENLAND";
		case 4: return "OBERÖSTERREICH";
		case 5: return "STEIERMARK";
		case 6: return "KÄRNTEN";
		case 7: return "SALZBURG";
		case 8: return "TIROL";
		case 9: return "VORARLBERG";
		default: return "";
		}
	}
	
	/**
	 * Tries to resolve the svtCode to the label, by using the currently
	 * provided list of Sozialversicherungsträger. If unsuccessful, simply
	 * returns the integer as string.<br><br>
	 * Resolution is possible, after {@link GINAStatus} has been properly initialized.
	 * @param svtCode
	 * @return Kurzbezeichnung of the Sozialversicherungsträger
	 */
	public static String versicherungstraegerCodeToLabel(int svtCode) {
		SvtProperty[] svtl = GINAStatus.getCurrentSVTList();
		if(svtl == null) return svtCode+"";
		for (int i = 0; i < svtl.length; i++) {
			int svtCodeL = Integer.parseInt(svtl[i].getCode());
			if(svtCodeL==svtCode) return svtl[i].getKurzbezeichnung();
		}
		return svtCode+"";
	}
	
	/**
	 * Convert an {@link OfflineRecordType} into a label
	 * @param offlineRecordType
	 * @return
	 */
	public static String offlineRecordTypeToLabel(int offlineRecordType) {
		switch (offlineRecordType) {
		case 1: return "KONSULTATION";
		case 2: return "NACHSIGNATUR"; 
		default: return offlineRecordType+"";
		}
	}
	
	/**
	 * Convert an {@link Anspruchsart} into a label.
	 * @param anspruchsart
	 * @return
	 */
	public static String anspruchsartToLabel(String anspruchsart) {
		int a = anspruchsart.hashCode();
		switch (a) {
		case 83: return "Sachleistung"; // S
		case 71: return "Geldleistung"; // G
		case 2622: return "Sachleistung gem. §122 Abs. 3a ASVG"; //S1
		case 2623: return "Sachleistung: VU&MKP für Nichtversicherte."; //S2
		default: return "";
		}
	}

	/**
	 * Convert a {@link Konsultationsart} into a label.
	 * @param konsultationsart String as provided by {@link Konsultationsart}.TYPE
	 * @return
	 */
	public static String konsultationsartToLabel(String konsultationsart){
		int k = konsultationsart.hashCode();
		switch (k) {
		case 78321: return "Online Konsultation mit e-card"; // OKM
		case 78323: return "Online Konsultation mit o-card"; // OKO
		case 78322: return "Online Konsultation mit e-card nachsigniert"; // OKN
		case 77267: return "Nacherfasste Konsultation wegen Hausbesuch"; // NHM
		case 77268: return "Nacherfasste Konsultation wegen Hausbesuch mit e-card nachsigniert"; //NHN
		case 77269: return "Nacherfasste Konsultation wegen Hausbesuch ohne e-card"; // NHO
		case 77608: return "Nacherfasste Konsultation wegen Störung mit e-card"; // NSM
		case 77609: return "Nacherfasste Konsultation wegen Störung mit e-card nachsigniert"; // NSN
		case 77610: return "Nacherfasste Konsultation wegen Störung ohne e-card"; // NSO
		case 78310: return "Online Konsultation mit Bürgerkarte"; // OKB
		case 78327: return "Online Konsultation mit Bürgerkarte nachsigniert"; // OKS
		case 69920: return "Offline Konsultation wegen Störung mit e-card"; // FSM
		case 69921: return "Offline Konsultation wegen Störung mit nachgebrachter e-card nachsigniert"; // FSN
		case 69922: return "Offline Konsultation wegen Störung ohne e-card"; // FSO
		case 77256: return "Nacherfasste Konsultation wegen Hausbesuch mit Bürgerkarte"; // NHB
		case 77273: return "Nacherfasste Konsultation wegen Hausbesuch mit nachgebrachter Bürgerkarte nachsigniert"; // NHS
		case 77597: return "Nacherfasste Konsultation wegen Störung mit Bürgerkarte"; // NSB
		case 77614: return "Nacherfasste Konsultation wegen Störung mit nachgebrachter Bürgerkarte nachsigniert"; // NSS
		case 74384: return "Offline nacherfasste Konsultation wegen Hausbesuch mit e-card";  // KHM
		case 74385: return "Offline nacherfasste Konsultation wegen Hausbesuch mit e-card nachsigniert"; // KHN
		case 74390: return "Offline nacherfasste Konsultation wegen Hausbesuch mit Bürgerkarte nachsigniert"; // KHS
		case 74386: return "Offline nacherfasste Konsultation wegen Hausbesuch ohne e-card"; // KHO
		case 74725: return "Offline nacherfasste Konsultation wegen Störung mit e-card"; // KSM
		case 74726: return "Offline nacherfasste Konsultation wegen Störung mit e-card nachsigniert"; // KSN
		case 74731: return "Offline nacherfasste Konsultation wegen Störung mit Bürgerkarte nachsigniert"; // KSS
		case 74727: return "Offline nacherfasste Konsultation wegen Störung ohne e-card"; // KSO
		case 69926: return "Offline Konsultation wegen Störung mit Bürgerkarte nachsigniert"; // FSS
		case 77050: return "Nacherfasste Konsultation außerhalb der Ordinationszeit mit e-card"; // NAM
		case 77039: return "Nacherfasste Konsultation außerhalb der Ordinationszeit mit Bürgerkarte"; // NAB
		case 77051: return "Nacherfasste Konsultation außerhalb der Ordinationszeit mit e-card nachsigniert"; // NAN
		case 77056: return "Nacherfasste Konsultation außerhalb der Ordinationszeit mit Bürgerkarte nachsigniert"; // NAS
		case 77052: return "Nacherfasste Konsultation außerhalb der Ordinationszeit ohne e-card"; // NAO
		case 74167: return "Offline nacherfasste Konsultation außerhalb der Ordinationszeit mit e-card"; // KAM
		case 74168: return "Offline nacherfasste Konsultation außerhalb der Ordinationszeit mit e-card nachsigniert"; // KAN
		case 74173: return "Offline nacherfasste Konsultation außerhalb der Ordinationszeit mit Bürgerkarte nachsigniert"; // KAS
		case 74169: return "Offline nacherfasste Konsultation außerhalb der Ordinationszeit ohne e-card"; // KAO
		default: return konsultationsart;
		}
	}
	
	/**
	 * Convert an {@link StatusKonsultation} elemnt to a label
	 * @param status
	 * @return
	 */
	public static String statusToLabel(String status){
		int stat = Integer.parseInt(status);
		switch (stat) {
		case StatusKonsultation.NEU: return "Neu";
		case StatusKonsultation.NACHSIGNIERT: return "Nachsigniert";
		case StatusKonsultation.GEAENDERT: return "Geändert";
		case StatusKonsultation.STORNIERT: return "Storniert";
		case StatusKonsultation.WIEDER_IN_KRAFT_GESETZT: return "Wieder in Kraft gesetzt";
		default: return "";
		}
	}
	
}
