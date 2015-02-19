package at.medevit.elexis.at.ecard.client.base.ui.dialog.provider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import at.chipkarte.client.base.soap.ServiceStatusInformation;
import ch.elexis.util.viewers.TableLabelProvider;

public class GINAStatusDialogServiceStatusInformationLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public String getColumnText(Object element, int columnIndex){
		ServiceStatusInformation ssi = (ServiceStatusInformation) element;
		switch (columnIndex) {
		case 0: return ssi.getServiceName();
		case 1: return ssi.getModusText();
		case 2: return ssi.getHinweisAktion();
		case 3: return ssi.getHinweisZusatz();
		default:return "";
		}
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex){
		return null;
	}
	
}
