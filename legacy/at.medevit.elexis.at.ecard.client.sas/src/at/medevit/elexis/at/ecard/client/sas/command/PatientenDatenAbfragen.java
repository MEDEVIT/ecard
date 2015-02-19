package at.medevit.elexis.at.ecard.client.sas.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

import at.chipkarte.client.sas.soap.Suchkriterien;
import at.medevit.elexis.model.IContact;
import at.medevit.elexis.model.IXid;

public class PatientenDatenAbfragen extends AbstractHandler {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.sas.command.PatientenDatenAbfragen";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		if(event.getApplicationContext() instanceof IContact) {
			IContact k = (IContact) event.getApplicationContext();

		} else if(event.getApplicationContext() instanceof IXid ) {
			
			
			
			
		} else {
			Object o = HandlerUtil.getVariable(event, ISources.ACTIVE_CURRENT_SELECTION_NAME);
			if(o == null) return null;
			IContact k = (IContact) o;
		}


		// Benötigt vorname, nachname und Geburtsdatum
		
		Suchkriterien sk = new Suchkriterien();
		
		return null;
	}
	
}
