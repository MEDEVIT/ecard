package at.medevit.elexis.at.ecard.client.base.ui.preferencePage;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.base.soap.CardReader;

public class LanCCRComboViewerLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		CardReader cr = (CardReader) element;
		return cr.getName();
	}
}
