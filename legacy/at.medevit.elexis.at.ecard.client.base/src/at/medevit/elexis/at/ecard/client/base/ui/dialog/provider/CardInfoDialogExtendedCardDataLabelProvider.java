package at.medevit.elexis.at.ecard.client.base.ui.dialog.provider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import at.chipkarte.client.base.soap.Property;

public class CardInfoDialogExtendedCardDataLabelProvider extends LabelProvider implements
		ITableLabelProvider {
	
	@Override
	public Image getColumnImage(Object element, int columnIndex){
		return null;
	}
	
	@Override
	public String getColumnText(Object element, int columnIndex){
		Property p = (Property) element;
		switch (columnIndex) {
		case 0: return p.getKey();
		case 1: return p.getValue();
		default: return "";
		}
	}
	
}
