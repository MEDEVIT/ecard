package at.medevit.elexis.at.ecard.client.base.ui.dialog.provider;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.base.soap.TaetigkeitsBereich;

public class DialogAufbauenDialogTaetigkeitsbereichLabelProvider extends
		LabelProvider {
	@Override
	public String getText(Object element) {
		TaetigkeitsBereich t = (TaetigkeitsBereich) element;
		return t.getCode()+": "+t.getAnzeigeText();
	}
}
