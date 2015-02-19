package at.medevit.elexis.at.ecard.client.base.exceptionHandler;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.base.soap.exceptions.DialogException;

public class DialogExceptionHandler {

	public static void handle(DialogException e){
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if(shell != null) {
			MessageDialog md =
			new MessageDialog(shell, "Dialogfehler", null,
				e.getMessage1(), MessageDialog.ERROR,
				new String[] {
					"OK"
				}, 0);
			md.open();
		}
		e.printStackTrace();
	}
	
}
