package at.medevit.elexis.at.ecard.client.base.ui.dialog.provider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import at.chipkarte.client.base.soap.Message;

public class DialogInfoDialogNachrichtenLabelProvider extends LabelProvider implements
		ITableLabelProvider {
	
	@Override
	public Image getColumnImage(Object element, int columnIndex){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getColumnText(Object element, int columnIndex){
		Message m = (Message) element;	
		switch (columnIndex) {
		case 0: return m.getTimestamp();
		case 1: return m.getId();
		case 2: return m.getText();
		case 3: return m.getAppid();
		case 4: return m.getCategory();
		case 5: return m.getData();
		default: return "";
		}
	}
	
}
