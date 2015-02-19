package at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import at.chipkarte.client.kse.soap.Limit;
import at.chipkarte.client.kse.soap.LimitKonfig;
import at.chipkarte.client.kse.soap.LimitValue;

public class LimitstaendeTreeContentProvider implements ITreeContentProvider {

	private TreeViewer tableTreeViewerLimits;
	
	public LimitstaendeTreeContentProvider(TreeViewer tableTreeViewerLimits){
		this.tableTreeViewerLimits = tableTreeViewerLimits;
	}

	@Override
	public void dispose(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput){
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getElements(Object inputElement){
		return (Limit[]) inputElement;
	}

	@Override
	public Object[] getChildren(Object parentElement){
		List<Object> result = new LinkedList<Object>();
		if(parentElement instanceof Limit) {
			Limit l = (Limit) parentElement;
			LimitKonfig[] lc = l.getLimitConfig();
			LimitValue[] lv = l.getLimitValue();
			if(lc != null && lc.length > 0) {
				for (int i = 0; i < lc.length; i++) {
					result.add(lc[i]);
				}
			}
			if(lv != null && lv.length > 0) {
				for (int i = 0; i < lv.length; i++) {
					result.add(lv[i]);
				}
			}
		}
		return result.toArray(new Object[] {});
	}

	@Override
	public Object getParent(Object element){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element){
		if(element instanceof Limit) {
			Limit l = (Limit) element;
			LimitKonfig[] lc = l.getLimitConfig();
			LimitValue[] lv = l.getLimitValue();

			if((lc != null && lc.length > 0) || (lv != null && lv.length > 0)) {
				if(lv!=null) System.out.println("LV: "+lv.length);
				if(lc!=null) System.out.println("LC: "+lc.length);
				return true;
			}
		}
		return false;
	}
	
}
