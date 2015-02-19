package at.medevit.elexis.at.dynamicdata;

public enum Bundesland {
	VORARLBERG(9, "Vorarlberg"),
	TIROL(8, "Tirol"),
	SALZBURG(7, "Salzburg"),
	KAERNTEN(6, "Kärtnen"),
	STEIERMARK(5, "Steiermark"),
	OBEROESTERREICH(4, "Oberösterreich"),
	BURGENLAND(3, "Burgenland"),
	NIEDEROESTERREICH(2, "Niederösterreich"),
	WIEN(1, "Wien"),
	AUSLAND(0, "Ausland"),
	ALL(99, "Alle");
	
	private int code;
	private String name;

	private Bundesland(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}

