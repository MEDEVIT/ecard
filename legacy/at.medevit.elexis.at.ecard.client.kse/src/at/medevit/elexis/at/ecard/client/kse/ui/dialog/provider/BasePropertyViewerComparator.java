package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import at.chipkarte.client.base.soap.BaseProperty;

public class BasePropertyViewerComparator extends ViewerComparator {
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2){
		BaseProperty a1 = (BaseProperty) e1;
		BaseProperty a2 = (BaseProperty) e2;
		return a1.getText().compareToIgnoreCase(a2.getText());
	}
}
