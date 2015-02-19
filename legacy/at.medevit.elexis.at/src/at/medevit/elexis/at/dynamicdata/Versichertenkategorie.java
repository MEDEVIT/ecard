package at.medevit.elexis.at.dynamicdata;

public enum Versichertenkategorie {
		ERWERBSTAETIG(1, "Erwerbstätig, Arbeitsl., Selbstv."),
		PENSIONIST(5, "Pensionist(in)"),
		KRIGSHINTERBLIEBENE(7, "Kriegshinterbliebene(r)"),
		ZUGETEILT_OFG(20, "Zugeteilt nach OFG"),
		ZUGETEILT_KOVG_HVG(21, "Zugeteilt nach KOVG, HVG"),
		ZUGETEILT_KOVG_D(22, "Zugeteilt nach KOVG-D"),
		ZUGETEILT_STVG(23, "Zugeteilt nach STVG"),
		ZUGETEILT_VOG(24, "Zugeteilt nach VOG"),
		NICHTVERS_MUKI(25, "MUKI-Nichtversicherte"),
		NICHTVERS_VU(26, "VU-Nichtversicherte"),
		FREMDSTAATEN(29, "Fremdstaaten (De-facto-Versicherte)"),

		LAND_SERBIEN(31, "Serbien"),
		LAND_SERBIEN_MONTE(32, "Serbien-Montenegro"),
		LAND_MONTENEGRO(33, "Montenegro"),
		LAND_TUERKEI(34, "Türkei"),
		LAND_ISRAEL(41, "Israel"),
		LAND_TUNESIEN(47, "Tunesien"),
		LAND_KROATIEN(49, "Kroatien"),
		LAND_MAZEDONIEN(56, "Mazedonien"),
		LAND_BOSNIEN_HERZ(57, "Bosnien-Herzigovina"),
		LAND_BULGARIEN(63, "Bulgarien"),
		LAND_RUMAENIEN(64, "Rumänien"),
		
		LAND_SLOWAKEI(65, "Slowakei"),
		LAND_ESTLAND(66, "Estland"),
		LAND_LETTLAND(67, "Lettland"),
		LAND_LITAUEN(68, "Litauen"),
		LAND_MALTA(69, "Malta"),
		LAND_DEUTSCHLAND(70, "Deutschland"),
		LAND_ITALIEN(71, "Italien"),
		LAND_SPANIEN(73, "Spanien"),
		LAND_FRANKREICH(75, "Frankreich"),
		LAND_SCHWEDEN(76, "Schweden"),
		LAND_LIECHTENSTEIN(77, "Liechtenstein"),
		LAND_SCHWEIZ(78, "Schweiz"),
		LAND_LUXEMBURG(79, "Luxemburg"),
		LAND_NIEDERLANDE(80, "Niederlande"),
		LAND_BELGIEN(82, "Belgien"),
		LAND_GROSSBRIT(83, "Großbritannien (inkl. Nordirland)"),
		LAND_GRIECHENLAND(84, "Griechenland"),
		LAND_PORTUGAL(85, "Portugal"),
		LAND_FINNLAND(86, "Finnland"),
		LAND_SLOWENIEN(88, "Slowenien"),
		LAND_NORWEGEN(90, "Norwegen"),
		LAND_DAENEMARK(91, "Dänemark"),
		LAND_IRLAND(92, "Irland"),
		LAND_ISLAND(93, "Island"),
		LAND_POLEN(94, "Polen"),
		LAND_UNGARN(95, "Ungarn"),
		LAND_TSCHECHIEN(98, "Tschechien"),
		LAND_ZYPERN(99, "Zypern");
		
	private int code;
	private String name;
	
	private Versichertenkategorie(int code, String name){
		this.code = code;
		this.name = name;
	}
	
	public int getCode(){
		return code;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}
		
	public static Versichertenkategorie getByCode(int code){
		for (Versichertenkategorie entry : Versichertenkategorie.values()) {
			if (entry.code == code)
				return entry;
		}
		return null;
	}
}
