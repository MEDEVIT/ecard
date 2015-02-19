package at.medevit.elexis.at.dynamicdata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Registry of the Austrian insurance carrier, this registry
 * is optionally online updated by the ecard plugins (if available)
 */
public class Sozialversicherungstraeger {
	
	private static HashSet<Sozialversicherungstraeger.SVT> sozialversicherungstraeger =
		new HashSet<SVT>();
	
	static {
		for (Versicherungstraeger v : Versicherungstraeger.values()) {
			sozialversicherungstraeger.add(new SVT(v.code, v.kurzbezeichnung, v.text, v.EKVKCode,
				v.EKVKName, v.ASVG));
		}
	}
	
	public static void setSozialversicherungstraeger(SVT in){
		boolean result = sozialversicherungstraeger.add(in);
		if (result) {
			return;
		} else {
			sozialversicherungstraeger.remove(in);
			sozialversicherungstraeger.add(in);
		}
	}
	
	public static List<Sozialversicherungstraeger.SVT> getAllSozialversicherungstraeger(){
		return new ArrayList<Sozialversicherungstraeger.SVT>(sozialversicherungstraeger);
	}
	
	/**
	 * @param ekvkCode
	 *            e.g. EKVKCode 1900 is Vorarlberger Gebietskrankenkasse
	 * @return the {@link Sozialversicherungstraeger.SVT} that corresponds to
	 *         the EKVK code, <code>null</code> if not existent
	 */
	public static Sozialversicherungstraeger.SVT getByEKVKCode(String ekvkCode) {
		for (Sozialversicherungstraeger.SVT entry : sozialversicherungstraeger) {
			if(entry.EKVKCode.equalsIgnoreCase(ekvkCode)) return entry;
		}
		return null;
	}
	
	/**
	 * @param ekvkCode
	 *            e.g. EKVKName VGKK is Vorarlberger Gebietskrankenasse
	 * @return the {@link Sozialversicherungstraeger.SVT} that corresponds to
	 *         the EKVK name, <code>null</code> if not existent
	 */
	public static Sozialversicherungstraeger.SVT getByEKVKName(String ekvkName) {
		for (Sozialversicherungstraeger.SVT entry : sozialversicherungstraeger) {
			if(entry.EKVKName.equalsIgnoreCase(ekvkName)) return entry;
		}
		return null;
	}
	
	/**
	 * @param code
	 *            e.g. code 19 is Vorarlberger Gebietskrankenasse
	 * @return the {@link Sozialversicherungstraeger.SVT} that corresponds to
	 *         the code, <code>null</code> if not existent
	 */
	public static Sozialversicherungstraeger.SVT getByCode(String code) {
		for (Sozialversicherungstraeger.SVT entry : sozialversicherungstraeger) {
			if(entry.code.equalsIgnoreCase(code)) return entry;
		}
		return null;
	}
	
	/** Entspricht SvtProperty von chipkarte.at */
	public static class SVT {
		public String code;
		public String text;
		/** Ist Pflichtversicherung nach dem Allgemeinen Sozialversicherungsgesetz (ASVG) */
		public boolean ASVG;
		public String EKVKCode;
		public String EKVKName;
		public String kurzbezeichnung;
		
		public SVT(String code, String kurzbezeichnung, String text, String EKVKCode,
			String EKVKName, boolean isASVG){
			this.code = code;
			this.kurzbezeichnung = kurzbezeichnung;
			this.text = text;
			this.EKVKCode = EKVKCode;
			this.EKVKName = EKVKName;
			this.ASVG = isASVG;
		}
		
		@Override
		public boolean equals(Object obj){
			Sozialversicherungstraeger.SVT in;
			if (obj instanceof Sozialversicherungstraeger.SVT) {
				in = (Sozialversicherungstraeger.SVT) obj;
			} else {
				return false;
			}
			
			if (!(this.code.equalsIgnoreCase(in.code))) {
				return false;
			}
			
			return true;
		}
		
		@Override
		public int hashCode(){
			return this.code.hashCode();
		}
	}
	
	/**
	 * Current list as of 4.11.2011 via GINA
	 */
	private enum Versicherungstraeger {
		WGKK("11", "WGKK", "Gebietskrankenkasse Wien", "1100", "WGKK", true), 
		NOEGKK("12", "NÖGKK", "Gebietskrankenkasse Niederösterreich", "1200", "NOEGKK", true), 
		BGKK("13", "BGKK", "Gebietskrankenkasse Burgenland", "1300", "BGKK", true), 
		OÖGKK("14", "OÖGKK", "Gebietskrankenkasse Oberösterreich", "1400", "OOEGKK", true), 
		STGKK("15", "STGKK", "Gebietskrankenkasse Steiermark", "1500", "STGKK", true), 
		KGKK("16", "KGKK", "Gebietskrankenkasse Kärnten", "1600", "KGKK", true), 
		SGKK("17", "SGKK", "Gebietskrankenkasse Salzburg", "1700", "SGKK", true), 
		TGKK("18", "TGKK", "Gebietskrankenkasse Tirol", "1800", "TGKK", true), 
		VGKK("19", "VGKK", "Gebietskrankenkasse Vorarlberg", "1900", "VGKK", true), 
		BKKAT("21", "BKKAT", "Betriebskrankenkasse Austria Tabak", "2100", "BKKTABAK", true), 
		BKKVB("22", "BKKVB", "Betriebskrankenkasse der Wiener Verkehrsbetriebe", "2200", "BKKWVB", true), 
		BKKMO("24", "BKKMO", "Betriebskrankenkasse Mondi", "2400", "BKKMONDI", true), 
		BKKVABS("25", "BKKVABS", "Betriebskrankenkasse voestalpine Bahnsysteme", "2500", "BKKVABS", true),
		BKKZW("26", "BKKZW", "Betriebskrankenkasse Zeltweg", "2600", "BKKZELTWEG", true),
		BKKKA("28", "BKKKA", "Betriebskrankenkasse Kapfenberg", "2800", "BKKKAPFENBERG", true),
		VAEB("05", "VAEB", "Versicherungsanstalt für Eisenbahnen und Bergbau", "0500", "VAEB", false), 
		BVA("07", "BVA", "Versicherungsanstalt öffentlich Bediensteter", "0700", "BVA", false), 
		SVA("40", "SVA", "Sozialversicherungsanstalt der gewerblichen Wirtschaft", "4000", "SVAGW", false),
		SVB("50", "SVB", "Sozialversicherungsanstalt der Bauern", "5000", "SVB", false), 
		KFAW("1A", "KFAW", "Krankenfürsorgeanstalt der Bediensteten der Stadt Wien", "1A00", "KFAWIEN", false),
		KFGRZ("5A", "KFGRZ", "Krankenfürsorgeanstalt für die Beamten der Landeshauptstadt Graz", "5A00", "KFGRAZ", false), 
		KFVIL("6A", "KFVIL", "Krankenfürsorgeanstalt für die Beamten der Stadt Villach", "6A00", "KFAVILLACH", false), 
		KFSAL("7A", "KFSAL", "Krankenfürsorgeanstalt der Magistratsbeamten der Landeshauptstadt Salzburg", "7A00", "KFASALZBURG", false),
		KFTGB("8B", "KFTGB", "Kranken- und Unfallfürsorge der Tiroler Gemeindebeamten", "8B00", "KUFTGEM", false),
		KFTLB("8C", "KFTLB", "Kranken- und Unfallfürsorge der Tiroler Landesbeamten", "8C00", "KUFTIROL", false),
		KFTLL("8D", "KFTLL", "Kranken- und Unfallfürsorge der Tiroler Landeslehrer", "8D00", "KUFTLEHRER", false);
		
		private String code;
		private String text;
		private boolean ASVG;
		private String EKVKCode;
		private String EKVKName;
		private String kurzbezeichnung;
		
		private Versicherungstraeger(String code, String kurzbezeichnung, String text,
			String EKVKCode, String EKVKName, boolean ASVG){
			this.code = code;
			this.kurzbezeichnung = kurzbezeichnung;
			this.text = text;
			this.EKVKCode = EKVKCode;
			this.EKVKName = EKVKName;
			this.ASVG = ASVG;
		}
		
	}
	
}
