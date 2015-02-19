package at.medevit.elexis.at.ecard.client.kse.ui.provider;

import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

import at.chipkarte.client.kse.soap.constants.StatusKonsultation;
import at.medevit.elexis.at.data.SVPerson;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenLabelHelper;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsbeleg;

public class KonsultationenTreeLabelProvider extends StyledCellLabelProvider implements ITableLabelProvider, IFontProvider  {

	// TODO: Is der Labelprovider do ned nur schaas? wei geht der überhaupt? wei schau mal datei au LimitstaendeAnzeigenLabel lblb
	
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

	@Override
	public Image getColumnImage(Object element, int columnIndex){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex){
		if(element.getClass().equals(String.class)) {
			if(columnIndex==0) return KonsultationsdatenLabelHelper.abrechnungsPeriodeToLabel(element.toString());
		} else if (element.getClass().equals(Konsultationsbeleg.class)) {
			Konsultationsbeleg kb = (Konsultationsbeleg) element;
			return konsultationsbelegToLabel(kb);
		}
		return "";
	}

	private String konsultationsbelegToLabel(Konsultationsbeleg kb){
		SVPerson p = SVPerson.findBySVNR(kb.getSvNummer());
		StringBuilder sb = new StringBuilder();
		sb.append(KonsultationsdatenLabelHelper.datumToLabel(kb.getBehandlungsDatum())+"\t");
		sb.append(kb.getKonsultationsartCode()+"\t");
		sb.append(kb.getBehandlungsfallCode()+"\t");
		if(p!=null) { 
			sb.append(p.getNachname()+", "+p.getVorname()+"\t");
		} else {
			sb.append("n/a, n/a\t");
		}
		sb.append(KonsultationsdatenLabelHelper.versicherungstraegerCodeToLabel(Integer.parseInt(kb.getLeistungsSvtCode()))+"\t");
		sb.append("["+KonsultationsdatenLabelHelper.statusToLabel(kb.getStatus())+"]\t");
		return sb.toString();
	}

//	@Override
//	public Image decorateImage(Image image, Object element){
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public String decorateText(String text, Object element){
//		if(element != null && element instanceof Konsultationsbeleg) {
//		Konsultationsbeleg kb = (Konsultationsbeleg) element;
//		int status = Integer.parseInt(kb.getStatus());
//		if(status == StatusKonsultation.STORNIERT) return "[STORNIERT] "+text;
//	}
//		return text;
//	}

	@Override
	public Font getFont(Object element){
		if(element != null && element instanceof Konsultationsbeleg) {
			Konsultationsbeleg kb = (Konsultationsbeleg) element;
			int status = Integer.parseInt(kb.getStatus());
			// WINDOWSONLY ARGHG
			if(status == StatusKonsultation.STORNIERT) return SWTResourceManager.getFont("Lucida Grande", 11, SWT.None, true, false);
		}
		return null;
	}
}
