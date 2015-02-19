package at.medevit.elexis.at.XID;

import org.eclipse.ui.IStartup;

import ch.elexis.data.Xid;

/**
 * Hauptverbandsnummer bzw. Vertragspartnernummer: wird dem Kassenarzt durch den Hauptverband zugeteilt, der Wahlarzt erhält keine solche Nummer:
 * AUSNAHME: Invertragnahme mit zumindest einer „kleinen“ Kasse, Vorsorgeuntersuchungsvertrag oder Erteilung der Rezepturbefugnis.
 * Die Vertragspartnernummer ist ein 6-stelliger numerischer Begriff, der aus 5 Stellen Laufnummer und 1 Stelle Prüfziffer besteht.
 * Die Vertragspartnernummer wird grundsätzlich personenbezogen vergeben. Jede
 * Ordination beziehungsweise Betriebsstätte eines Vertragspartners wird durch eine Adressnummer bezeichnet. 
 * Jeder Ortswechsel einer Ordination beziehungsweise Betriebsstätte erfordert die Vergabe einer neuen Adressnummer.
 * Die Vergabe der Vertragspartnernummer erfolgt automatisch durch Erhöhen der letztvergebenen Laufnummer und Berechnen der 
 * zugehörigen Prüfziffer beim Neu- zugang eines Vertragspartners.<br>
 * Quelle http://www.forumgesundheit.at
 */
public class HVNR implements IStartup {
	public static final String DOMAIN_AT_HVNR = "www.sozialversicherung.at/hvnr";
	public static final String SIMPLENAME_AT_HVNR = "HVNR";
	
	@Override
	public void earlyStartup(){
		Xid.localRegisterXIDDomainIfNotExists(HVNR.DOMAIN_AT_HVNR,
			HVNR.SIMPLENAME_AT_HVNR, Xid.ASSIGNMENT_REGIONAL);
	}

}
