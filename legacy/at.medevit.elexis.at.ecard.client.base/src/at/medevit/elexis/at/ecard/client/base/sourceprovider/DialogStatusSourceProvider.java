package at.medevit.elexis.at.ecard.client.base.sourceprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;

public class DialogStatusSourceProvider extends AbstractSourceProvider {
	
	public static final String DIALOG_STATUS = "at.medevit.elexis.at.ecard.client.base.sourceprovider.DialogStatusSourceProvider.DialogStatus";
	
	@Override
	public void dispose(){}
	
	@Override
	public Map getCurrentState(){
		Map map = new HashMap<String, Integer>();
		map.put(DIALOG_STATUS, DialogStatus.getDialogStatus());
		return map;
	}
	
	@Override
	public String[] getProvidedSourceNames(){
		return new String[] { DIALOG_STATUS };
	}
	
	public void statusChanged() {
		fireSourceChanged(ISources.WORKBENCH, DIALOG_STATUS, DialogStatus.getDialogStatus());
	}
	
}
