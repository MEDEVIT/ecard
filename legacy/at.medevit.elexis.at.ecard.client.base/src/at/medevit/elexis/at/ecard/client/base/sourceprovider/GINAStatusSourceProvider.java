package at.medevit.elexis.at.ecard.client.base.sourceprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;

public class GINAStatusSourceProvider extends AbstractSourceProvider {
	
	public static final String GINA_STATUS = "at.medevit.elexis.at.ecard.client.base.sourceprovider.GINAStatusSourceProvider.GINAStatus";
	
	@Override
	public void dispose(){}
	
	@Override
	public Map<String, Integer> getCurrentState(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(GINA_STATUS, GINAStatus.getGinaStatus());
		return map;
	}
	
	@Override
	public String[] getProvidedSourceNames(){
		return new String[] { GINA_STATUS };
	}
	
	public void statusChanged() {
		fireSourceChanged(ISources.WORKBENCH, GINA_STATUS, GINAStatus.getGinaStatus());
	}
}
