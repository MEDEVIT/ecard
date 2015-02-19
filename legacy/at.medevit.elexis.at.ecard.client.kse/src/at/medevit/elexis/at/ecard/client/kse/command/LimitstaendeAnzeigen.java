package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import at.medevit.elexis.at.ecard.client.kse.ui.dialog.LimitstaendeAnzeigenDialog;

public class LimitstaendeAnzeigen extends AbstractHandler {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.kse.command.LimitstaendeAnzeigen";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		LimitstaendeAnzeigenDialog lad = new LimitstaendeAnzeigenDialog(Display.getCurrent().getActiveShell());
		int retVal = lad.open();
		
		return null;
	}
	
}
