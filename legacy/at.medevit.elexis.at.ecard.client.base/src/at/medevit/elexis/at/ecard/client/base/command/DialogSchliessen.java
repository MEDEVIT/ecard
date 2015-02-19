package at.medevit.elexis.at.ecard.client.base.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.exceptionHandler.DialogExceptionHandler;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;

public class DialogSchliessen extends AbstractHandler {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.base.command.DialogSchliessen";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		String dialogId = DialogStatus.getDialogId();
		if(dialogId != null) {
			try {
				BaseService.getInstance(null).closeDialog(dialogId);
				DialogStatus.setDialogClosed();
			} catch (DialogException e) {
				DialogExceptionHandler.handle(e);
			}
		}

		return null;
	}
	
}
