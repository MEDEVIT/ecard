package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.kse.soap.constants.LimitZeitraum;

public class LimitZeitraumComboLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element){
		int x = (Integer) element;
		switch (x) {
		case LimitZeitraum.AKTUELLE_PRUEFPERIODE: return "Aktuelle Prüfperiode";
		case LimitZeitraum.NACHBRINGFRIST: return "Nachbringfrist";
		default: return "";
		}
	}
	
}
