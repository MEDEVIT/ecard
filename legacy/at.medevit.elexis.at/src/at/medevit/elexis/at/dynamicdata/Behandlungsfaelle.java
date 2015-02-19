package at.medevit.elexis.at.dynamicdata;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Registry for Behandlungsfaelle. This registry is statically initialzed by an Enumeration, and if
 * an ecard connection is available periodically updated.
 *
 */
public class Behandlungsfaelle {

	private static HashMap<String, Behandlungsfall> behandlungsfaelle = new HashMap<String, Behandlungsfall>();
	
	// Initialize the HashMap with predefined values
	static {
		for (TicketCode tc : TicketCode.values()) {
			behandlungsfaelle.put(tc.getNewCode(), new Behandlungsfall(tc.getCode(), tc.getNewCode(), tc.getName()));
		}
	}
	
	public static Behandlungsfall getByNewCode(String newCode) {
		return behandlungsfaelle.get(newCode);
	}
	
	public static void setBehandlungsfall(String newCode, String text) {
		Behandlungsfall old = behandlungsfaelle.get(newCode);
		int oldcode = 0;
		if(old != null) oldcode = old.code;
		behandlungsfaelle.put(newCode, new Behandlungsfall(oldcode, newCode, text));
	}
	
	public static List<Behandlungsfaelle.Behandlungsfall> getAllBehandlungsfaelle() {
		LinkedList<Behandlungsfaelle.Behandlungsfall> ret = new LinkedList<Behandlungsfaelle.Behandlungsfall>();
		Set<String> vals = behandlungsfaelle.keySet();
		for (String c : vals) {
			ret.add(behandlungsfaelle.get(c));
		}
		return ret;
	}
	
	/**
	 * Class to transport the results in a rather unspecific way
	 */
	public static class Behandlungsfall {
		public int code;
		public String newCode;
		public String text;
		
		public Behandlungsfall(int code, String newCode, String text){
			this.code = code;
			this.newCode = newCode;
			this.text = text;
		}
		
		public String getText(){
			return text;
		}
		
		public int getCode(){
			return code;
		}
		
		public String getNewCode(){
			return newCode;
		}
	}
	
	
	/**
	 * Codes defining Scheinart (code) for accounting without e-card and
	 * Behandlungsfall (newCode) for accounting with e-card.
	 * 
	 * Current list as of 3.11.2011 via GINA
	 */
	private enum TicketCode {
		REGELFALL(1, "RF", "Regelfall"),
		UEBERWEISUNG(2, "ÜW", "Betriebsfall Überweisung"),
		VB_ERSTE_HILFE(3, "EH", "Vertretung/Bereitschaft Erste-Hilfe"),
		VERTRETUNG(4, "", "Vertretung"),
		SONNTAG(5, "", "Sonntagsdienst"),
		VU_VORSORGE(6, "VU", "Vorsorgeuntersuchung"),
		VU_BASIS(0, "VN", "Basisvorsorgeuntersuchung"),
		VU_GYNAEKOLOGISCH(0, "VG", "Gynäkologische Basisvorsorgeuntersuchung"),
		VU_MAMMOGRAPHIE(0, "VM", "Vorsorgeuntersuchung Mammographie"),
		VU_KOLOSKOPIE(0, "VK", "Vorsorgeuntersuchung Koloskopie"),
		VU_PAPABSTRICH(0, "VP", "Vorsorgeuntersuchung PAP-Abstrich"),
		VU_BLUT(0, "VB", "Vorsorgeuntersuchung Blut"),
		VU_FOLGETERMIN(0, "VA", "Vorsorgeuntersuchung Folgetermin"),
		ZUWEISUNG(0, "ZW", "Betriebsfall Zuweisung"),
		VB_BEREITSCHAFT(0, "BE", "Vertretung/Bereitschaft Bereitschaft"),
		MUTTERKIND(0, "MK", "Mutter-Kind-Pass-Untersuchung"),
		VB_URLAUB(0, "AU", "Vertretung/Bereitschaft Urlaub Erstbehandler"),
		VB_KRANKHEIT(0, "KE", "Vertretung/Bereitschaft Krankheit Erstbehandler"),
		VB_FORTBILDUNG(0, "FE", "Vertretung/Bereitschaft Fortbildung Erstbehandler"),
		VB_NICHTERREICHBAR(0, "NE", "Vertretung/Bereitschaft Nichterreichbarkeit des Erstbehandlers"),
		VB_ERSTEHILFE(0, "EH", "Vertretung/Bereitschaft Erste Hilfe"),
		BH_ORDINATIONVERLEG(0, "OV", "Behandlungsübernahme Ordinationsverlegung"),
		BH_VERTRAGSENDE(0, "SE", "Behandlungsübernahme Vertragsende Erstbehandler"),
		BH_TOD(0, "TE", "Behandlungsübernahme Tod Erstbehandler"),
		BH_WOHNUNGSWECHSEL(0, "WW", "Behandlungsübernahme Wohnungswechsel"),
		BH_DIENSTREISE(0, "DP", "Behandlungsübernahme Deinstreise SV-Person"),
		URLAUB(0, "UR", "Urlaub");
		
		private int code;
		private String newCode;
		private String name;

		private TicketCode(int code, String newCode, String name) {
			this.code = code;
			this.newCode = newCode;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getNewCode() {
			return newCode;
		}
		
		public String getName() {
			return name;
		}
	}
}
