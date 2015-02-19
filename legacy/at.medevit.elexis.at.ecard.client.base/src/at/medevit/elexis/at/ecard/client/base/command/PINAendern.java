package at.medevit.elexis.at.ecard.client.base.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import at.medevit.elexis.at.ecard.client.base.ui.dialog.PINAendernDialog;

public class PINAendern extends AbstractHandler {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.base.command.PINAendern";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PINAendernDialog pid = new PINAendernDialog(Display.getDefault().getActiveShell());
		pid.open();
		return null;
	}
	
}
