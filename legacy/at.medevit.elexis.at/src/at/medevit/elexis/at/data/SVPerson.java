package at.medevit.elexis.at.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import at.medevit.elexis.at.XID.SVNR;
import ch.elexis.data.Patient;
import ch.elexis.data.Person;
import ch.elexis.data.Xid;
import ch.rgw.tools.TimeTool;

/**
 * Adapterklasse {@link SVPerson} verwendet bei eCard System auf {@link Patient} native in Elexis
 * 
 * @author M. Descher
 * 
 */
public class SVPerson extends Patient {
	
	public static final String ENTRY_TITEL_HINTEN = "titelHinten";
	
	private Patient elexisPatient;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	/**
	 * Aus {@link at.chipkarte.client.base.soap.constants.Geschlecht}: Geschlecht ist männlich.
	 */
	public static final String MAENNLICH = "M";
	/**
	 * Aus {@link at.chipkarte.client.base.soap.constants.Geschlecht}: Geschlecht ist weiblich.
	 */
	public static final String WEIBLICH = "W";
	
	public String getGeburtsdatum(){
		// Format: TT.MM.JJJJ
		Date d = getGeburtsdatumDate();
		return sdf.format(d);
	}
	
	public void setGeburtsdatum(Date birthday){
		elexisPatient.set(Person.FLD_BIRTHDATE, sdf.format(birthday));
	}
	
	private Date getGeburtsdatumDate() {
		return new TimeTool(elexisPatient.get(Person.FLD_BIRTHDATE)).getTime();
	}
	
	/**
	 * Code des Geschlechts der SV-Person.
	 * Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Geschlecht}.
	 * Format: maximal 1-stellig
	 */
	public String getGeschlecht(){
		String sex = elexisPatient.get(Person.FLD_SEX).trim();
		if(sex.equalsIgnoreCase("m")) return MAENNLICH;
		return WEIBLICH;
	}
	
	public void setGeschlecht(String sex) {
		elexisPatient.set(Person.FLD_SEX, sex.toLowerCase());
	}
	
	public String getNachname(){
		//Format: maximal 70-stellig
		return elexisPatient.get(Person.FLD_LASTNAME);
	}
	
	public void setNachname(String nachname) {
		// TODO: Check length
		elexisPatient.set(Person.FLD_LASTNAME, nachname);
	}
	
	public String getSvNummer(){
		return elexisPatient.getXid(SVNR.DOMAIN_AT_SVNR);
	}
	
	public void setSvNummer(String svnr) {
		boolean succ = elexisPatient.addXid(SVNR.DOMAIN_AT_SVNR, svnr, true);
		// TODO
		if(succ == false) System.out.println("!!!!!! Error updating svnr on "+getLabel());
	}
	
	public String getTitelHinten(){
		return (String) elexisPatient.getMap(FLD_EXTINFO).get(ENTRY_TITEL_HINTEN);
	}
	
	@SuppressWarnings("unchecked")
	public void setTitelHinten(String titelHinten) {
		@SuppressWarnings("rawtypes")
		Map extInfo = elexisPatient.getMap(FLD_EXTINFO);
		extInfo.put(ENTRY_TITEL_HINTEN, titelHinten);
		elexisPatient.setMap(FLD_EXTINFO, extInfo);
	}
	
	public String getTitelVorne(){
		return elexisPatient.get(Person.TITLE);
	}
	
	public void setTitelVorne(String tv) {
		elexisPatient.set(Person.TITLE, tv);
	}
	
	public String getVorname(){
		return elexisPatient.get(Person.FLD_FIRSTNAME);
	}
	
	public void setVorname(String vorname) {
		elexisPatient.set(Person.FLD_FIRSTNAME, vorname);
	}
	
	/**
	 * 
	 * @param svnr Sozialversicherungsnummer
	 * @return Die SVPerson die dieser SVNR zugeordnet ist oder null falls nicht gefunden
	 */
	public static SVPerson findBySVNR(String svnr) {
		SVPerson ret = null;
		Patient p = (Patient) Xid.findObject(SVNR.DOMAIN_AT_SVNR, svnr);
		if(p != null) {
			ret = new SVPerson(p);
		}
		return ret;
	}
	
	public Patient getElexisPatient() {
		return elexisPatient;
	}
	
	@Override
	public String storeToString(){
		return elexisPatient.storeToString();
	}
	
	@Override
	public String getLabel(){
		StringBuilder sb = new StringBuilder();
		if(getTitelVorne()!=null) sb.append(getTitelVorne()+" ");
		sb.append(getVorname()+" ");
		sb.append(getNachname());
		if(getTitelHinten()!=null) sb.append(", "+getTitelHinten());
		sb.append(" ("+getSvNummer()+")");
		return sb.toString();
	}

	public SVPerson() {}
	
	public SVPerson(Patient p) {
		elexisPatient = p;
	}

	public SVPerson(String svnr, String vorname, String nachname, String geburtsdatum, String geschlechtCode) {
		elexisPatient = new Patient(nachname, vorname, geburtsdatum, geschlechtCode.toLowerCase());
		setSvNummer(svnr);
	}
}
