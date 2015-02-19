package at.medevit.elexis.at.dynamicdata;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** 
 * Central register for type Fachgebiet
 * This class initializes with a set of default values. It may be updated during runtime
 * by external sources s.a. GINA
 */
public class Fachgebiete {
	
	private static HashMap<Integer, String> fachgebiete = new HashMap<Integer, String>();
	public static int DEFAULT_FACHGEBIET_ALLGEMEIN = 1; // for fallback selections
	
	// Initialize the HashMap with predefined values
	static {
		for (SpecialityCode sp : SpecialityCode.values()) {
			fachgebiete.put(sp.getCode(), sp.getName());
		}
	}
	
	public static Fachgebiet getByCode(int code) {
		return new Fachgebiet(code, fachgebiete.get(code));
	}	
	
	public static void setFachgebiet(int code, String text) {
		fachgebiete.put(code, text);
	}
	
	public static List<Fachgebiete.Fachgebiet> getAllFachgebiete() {
		LinkedList<Fachgebiet> ret = new LinkedList<Fachgebiete.Fachgebiet>();
		Set<Integer> vals = fachgebiete.keySet();
		for (Integer code : vals) {
			ret.add(new Fachgebiet(code, fachgebiete.get(code)));
		}
		return ret;
	}
	
	/**
	 * Class to transport the results in a rather unspecific way
	 */
	public static class Fachgebiet {
		int code;
		String text;
		
		public Fachgebiet(int code, String text){
			this.code = code;
			this.text = text;
		}
		
		public String getText(){
			return text;
		}
		
		public int getCode(){
			return code;
		}
	}
	
	/** Current list as of 2.11.2011 via GINA */
	public enum SpecialityCode {
		ALLGEMEIN(1, "Allgemeinmedizin"),
		ANAESTHOLOGIE_INTENSIV(2, "Anästhesiologie und Intensivmedizin"),
		AUGEN_OTPOMETRIE(3, "Augenheilkunde und Optometrie"),
		CHIRURGIE(4, "Chirurgie"),
		HAUT_GESCHLECHT(5, "Haut- und Geschlechtskrankheiten"),
		FRAUEN_GEBURT(6, "Frauenheilkunde und Geburtshilfe"),
		INNERE(7, "Innere Medizin"),
		KINDER_JUGEND(8, "Kinder- und Jugendheilkunde"),
		HNO(9, "Hals-, Nasen und Ohrenkrankheiten"),
		LUNGEN(10, "Lungenkreankheiten"),
		NEURO_PHSYCHIATRIE(11, "Neurologie und Psychiatrie"),
		ORTHOPAEDIE(12, "Orthopädie und orthopädische Chirurgie"),
		PHYSIKALISCHE(13, "Physikalische Medizin"),
		RADIOLOGIE(14, "Radiologie"),
		UNFALLCHIRURGIE(15, "Unfallchirurgie"),
		UROLOGIE(16, "Urologie"),
		ZAHN_MUND_KIEFER(17, "Zahn-, Mund- Kieferheilkunde"),
		NEUROCHIRURGIE(18, "Neurochirurgie"),
		NEUROLOGIE(19, "Neurologie"),
		PSYCHIATRIE(20, "Psychiatrie"),
		PLASTISCHECHIRURGIE(21, "Plastische Chirurgie"),
		KINDERCHIRURGIE(22, "Kinderchirurgie"),
		MUND_KIEFER_GESICHTCHIRURGIE(23, "Mund-, Kiefer- und Gesichtschirurgie"),
		NUKLEAR(24, "Nuklearmedizin"),
		RDIALOGIE_DIAG(25, "Medizinische Radiologie-Diagnostik"),
		STRAHLEN_RADIOONKOLOGIE(26, "Strahlentherapie - Radioonkologie"),
		DENT(27, "Zahnarzt"),
		BLUTGRUPPEN_TRANSFUSION(28, "Blutgruppenserologie und Transfusionsmedizin"),
		IMMUNOLOGIE(29, "Immunologie"),
		KINDJUGENDPSYHIATRIE(32, "Kinder- und Jugendpsychiatrie"),
		HISTO_EMBRYOLOGIE(33, "Histologie und Embryologie"),
		BIOLOGIE(34, "Medizinische Biologie"),
		VIROLOGIE(35, "Virologie"),
		PHARMA_TOXIKOLOGIE(38, "Pharmakologie und Toxikologie"),
		LEIHFIRMEN(42, "Leihfirmen für Heilbehelfe und Hilfsmittel"),
		LAB_DIAGNOSTIK(50, "Medizische und Chemische Labordiagnostik"),
		LAB_EEG(51, "Labor, EEG"),
		LAB_ZYTO(52, "Labor, zytodiagnostisch"),
		PATHOLOGIE(53, "Pathologie"),
		MIKROBIOLOGIE(55, "Hygiene und Mikrobiologie"),
		HAUSAPOTHEKENARZT(59, "Hausapothekenführender Arzt"),
		APOTHEKE(60, "Öffentliche Apotheke - Krankenhausapotheke"),
		BANDAGIST(61, "Bandagist"),
		DENTIST(62, "Dentist"),
		RETTUNG(65, "Rettungsdienste, Beförderungsgewerbe"),
		ORTHOPAEDIESCHUHMACHER(68, "Orthopädieschuhmacher"),
		ORTHOPAEDIETECHNIKER(69, "Orthopädietechniker"),
		PSYCHOTHERAPEUT(72, "Psychotherapeut"),
		KRANKENANSTALT(80, "Krankenanstalt stationär, Krankenhausambulanz"),
		CT_MR(84, "CT, MR und andere Leistungen"),
		SELBST_AMBULATORIUM(85, "Selbstständiges Ambulatorium, ausgenommen ZMK und phys. Medizin"),
		SELBST_AMBULATORIUM_ZMK(86, "Selbstständiges Ambulatorium für ZMK"),
		PENSIONISTENHEIM(87, "Pensionisten- oder Pflegeheim"),
		HEIME(90, "Genesungsheim, Kurheim, sonstige Heime"),
		SELBST_AMBULATORIUM_PHYS(91, "Selbstständiges Ambulatorium für physikalische Medizin"),
		ANDERE(99, "Sonstige Vertragspartner");
		
		private int code;
		private String name;
		
		private SpecialityCode(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
		
		public static SpecialityCode getByCode(int code) {
			SpecialityCode[] values = values();
			
			for(int i = 0; i < values.length; i++) {
				if(values[i].getCode() == code)
					return values[i];
			}
			return null;
		}
	}

}
