package at.medevit.elexis.at.ecard.client.base.ui.dialog.provider;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.base.soap.Ordination;

public class DialogAufbauenDialogOrdinationLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		Ordination o = (Ordination) element;
		return o.getOrdinationNumber()+": "+o.getStrasse()+", "+o.getPostleitzahl()+" "+o.getStadt();
	}
}
