package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.kse.soap.constants.Nacherfassungsgrund;

public class KonsultationsartLabelProvider extends LabelProvider {
	
	public static final String REGULAERE_KONSULTATION = "REG";
	
	/**
	 * see {@link Nacherfassungsgrund} for respective values, {@link KonsultationsartLabelProvider#REGULAERE_KONSULTATION} is
	 * additionally defined to represent a "Reguläre Konsultation"
	 */
	public static final String[] values = {
		REGULAERE_KONSULTATION, Nacherfassungsgrund.AUSSERHALB_ORDINATIONSZEIT,
		Nacherfassungsgrund.NACHERFASSTE_KONSULTATION_HAUSBESUCH,
		Nacherfassungsgrund.NACHERFASSTE_KONSULTATION_STOERUNG
	};
	
	@Override
	public String getText(Object element){
		String val = (String) element;
		if (val.equals(Nacherfassungsgrund.AUSSERHALB_ORDINATIONSZEIT))
			return "Nacherfassung (außerhalb Ordinationszeit)";
		if (val.equals(Nacherfassungsgrund.NACHERFASSTE_KONSULTATION_HAUSBESUCH))
			return "Nacherfassung (Konsultation Hausbesuch)";
		if (val.equals(Nacherfassungsgrund.NACHERFASSTE_KONSULTATION_STOERUNG))
			return "Nacherfassung (Störung eCard)";
		if (val.equals(REGULAERE_KONSULTATION))
			return "Reguläre Konsultation";
		return "Unbekannter Typ";
	}
}
