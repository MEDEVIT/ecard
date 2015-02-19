package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import at.chipkarte.client.kse.soap.OfflineRecord;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenLabelHelper;

public class OfflineKonsultationsdatenUebertragenLabelProvider implements IBaseLabelProvider, ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex){
		OfflineRecord or = (OfflineRecord) element;
		switch (columnIndex) {
		case 0: return or.getErstellungsDatum();
		case 1: return or.getOfflineFrist();
		case 2: return or.getVorname()+" "+or.getNachname()+" ("+or.getSvNummer()+")";
		case 3: return or.getId();
		case 4: return KonsultationsdatenLabelHelper.offlineRecordTypeToLabel(or.getType());
		default: return "";
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener){
		// TODO Auto-generated method stub
		
	}
}
