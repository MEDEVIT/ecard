package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.base.soap.SvtProperty;

public class SvtPropertyComboLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element){
		SvtProperty sp = (SvtProperty) element;
		return sp.getCode()+"\t"+sp.getText();
	}
	
}
