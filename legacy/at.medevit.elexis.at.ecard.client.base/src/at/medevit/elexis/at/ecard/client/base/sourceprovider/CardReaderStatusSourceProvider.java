package at.medevit.elexis.at.ecard.client.base.sourceprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import at.medevit.elexis.at.ecard.client.base.status.CardReaderStatus;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;

public class CardReaderStatusSourceProvider extends AbstractSourceProvider {
	
	public static final String CARD_READER_STATUS = "at.medevit.elexis.at.ecard.client.base.sourceprovider.CardReaderStatusSourceProvider.CardReaderStatus";

	@Override
	public void dispose(){}
	
	@Override
	public Map getCurrentState(){
		System.out.println("CardReaderStatus "+CardReaderStatus.getStatus());
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(CARD_READER_STATUS, CardReaderStatus.getStatus());
		return map;
	}
	
	@Override
	public String[] getProvidedSourceNames(){
		return new String[] { CARD_READER_STATUS };
	}
	
	public void statusChanged() {
		fireSourceChanged(ISources.WORKBENCH, CARD_READER_STATUS, CardReaderStatus.getStatus());
	}
	
}
