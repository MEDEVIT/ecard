package at.medevit.elexis.at.ecard.client.kse.model.annotated;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Javadoc Sozialversicherung: Enthält die Daten zu einer (nacherfassten) Konsultation.<br>
 * <br>
 * Diese Klasse speichert die bestehenden Konsultationsdaten die im Zuge von Konsultationen erstellt,<br>
 * oder von vorherigen Systemen mittels {@link KseService#downloadKonsultationsdaten} bezogen werden.<br>
 * <br>
 * Eine "Konsultationsdaten-Entität" besteht hierbei aus <br>
 * AngehörigenDaten Typ {@link SvPerson} (Versichertendaten der SV-Person, von der sich der vorliegende Anspruch ableitet)<br>
 * Konsultationsbeleg v<br>
 * Versichertendaten Typ {@link SvPerson} (Versichertendaten der SV-Person, die diese Konsultation in Anspruch genommen hat)<br>
 * 
 */
@Entity
public class Konsultationsdaten {
	/** Versichertendaten der SV-Person, von der sich der vorliegende Anspruch ableitet. 
	 * Der gespeicherte String ist eine Referenz auf einen Kontakt in Elexis */
	String angehoerigenDaten;
	
	/** Versichertendaten der SV-Person, die diese Konsultation in Anspruch genommen hat. 
	 * Der gespeicherte String ist eine Referenz auf einen Kontakt in Elexis */
	String versichertenDaten;
	
	/** Konsultationsbeleg in bestimmter Version. */
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	Konsultationsbeleg konsultationsBeleg;

	public Konsultationsdaten(){}

	/**
	 * @return the angehoerigenDaten
	 */
	public String getAngehoerigenDaten(){
		return angehoerigenDaten;
	}

	/**
	 * @param angehoerigenDaten the angehoerigenDaten to set
	 */
	public void setAngehoerigenDaten(String angehoerigenDaten){
		this.angehoerigenDaten = angehoerigenDaten;
	}

	/**
	 * @return the versichertenDaten
	 */
	public String getVersichertenDaten(){
		return versichertenDaten;
	}

	/**
	 * @param versichertenDaten the versichertenDaten to set
	 */
	public void setVersichertenDaten(String versichertenDaten){
		this.versichertenDaten = versichertenDaten;
	}

	/**
	 * @return the konsultationsBeleg
	 */
	public Konsultationsbeleg getKonsultationsBeleg(){
		return konsultationsBeleg;
	}

	/**
	 * @param konsultationsBeleg the konsultationsBeleg to set
	 */
	public void setKonsultationsBeleg(Konsultationsbeleg konsultationsBeleg){
		this.konsultationsBeleg = konsultationsBeleg;
	}
	
}
