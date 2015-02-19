package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import java.text.DecimalFormat;

import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.base.soap.BaseProperty;

public class BasePropertyComboLabelProvider extends LabelProvider {
	
	DecimalFormat df2 = new DecimalFormat("00");
	
	@Override
	public String getText(Object element){
		BaseProperty f = (BaseProperty) element;
		try {
			int code = Integer.parseInt(f.getCode());
			return "["+df2.format(code)+"]\t"+f.getText();
		} catch (NumberFormatException e) {
			return "["+f.getCode()+"]\t"+f.getText();
		}


	}
	
}
