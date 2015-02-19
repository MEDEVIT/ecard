package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import at.medevit.elexis.at.ecard.client.kse.ui.dialog.OfflineKonsultationsdatenUebertragenDialog;

public class OfflineKonsultationsdatenUebertragen extends AbstractHandler {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.kse.command.OfflineKonsultationsdatenUebertragen";
	
	OfflineKonsultationsdatenUebertragenDialog okud = null;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		okud = new OfflineKonsultationsdatenUebertragenDialog(Display.getCurrent().getActiveShell());
		int retVal = okud.open();
		
		return null;
	}
	
}
