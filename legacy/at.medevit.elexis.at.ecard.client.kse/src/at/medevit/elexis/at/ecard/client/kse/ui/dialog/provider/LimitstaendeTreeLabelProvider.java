package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;

import at.chipkarte.client.kse.soap.Limit;
import at.chipkarte.client.kse.soap.LimitValue;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenLabelHelper;

public class LimitstaendeTreeLabelProvider extends LabelProvider implements ILabelProvider {


	@Override
	public String getText(Object element){
		if(element instanceof Limit) {
			Limit l = (Limit) element;
			return l.getFachgebietsCode()+" "+KonsultationsdatenLabelHelper.versicherungstraegerCodeToLabel(Integer.parseInt(l.getSvtCode()));
		}
		if(element instanceof LimitValue) {
			LimitValue lv = (LimitValue) element;
			return KonsultationsdatenLabelHelper.limitcodeToLabel(lv.getLimitCode())+"\t"+lv.getValue();
		}
		return element.getClass().getName();
	}

	
	
}
