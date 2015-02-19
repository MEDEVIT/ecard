package at.medevit.elexis.at.ecard.client.base.ui.dialog.provider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import at.chipkarte.client.base.soap.VertragsDaten;

public class DialogInfoDialogVertragsDatenLabelProvider extends LabelProvider implements
		ITableLabelProvider {
	
	@Override
	public Image getColumnImage(Object element, int columnIndex){
		return null;
	}
	
	@Override
	public String getColumnText(Object element, int columnIndex){
		VertragsDaten vd = (VertragsDaten) element;
		switch (columnIndex) {
		case 0: return vd.getBezBereich();
		case 1: return vd.getFachGebietsCode();
		case 2: return vd.getLeistungsSVT();
		case 3: return vd.getOrdId();
		case 4: return vd.getVerrechnungsSVT();
		case 5: return vd.getTaetigkeitsBereichId();
		case 6: return vd.getVertragsTyp();
		default: return "";
		}
	}
	
}
