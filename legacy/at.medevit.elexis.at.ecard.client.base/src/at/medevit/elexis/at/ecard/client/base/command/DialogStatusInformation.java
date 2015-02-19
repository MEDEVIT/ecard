package at.medevit.elexis.at.ecard.client.base.command;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.wb.swt.ResourceManager;

import static at.medevit.elexis.at.ecard.client.base.status.DialogStatus.*;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.DialogInfoDialog;

public class DialogStatusInformation extends AbstractHandler implements IElementUpdater {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.base.command.DialogStatusInformation";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		DialogInfoDialog did = new DialogInfoDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		did.open();
		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters){
		int dialogStatus = getDialogStatus();
		switch (dialogStatus) {
		case DIALOG_STATUS_CLOSED:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base",
				"rsc/icons-nonfree/bullet_ball_grey.png"));
			break;
		case DIALOG_STATUS_OPEN:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base",
				"rsc/icons-nonfree/bullet_ball_green.png"));
			break;
		case DIALOG_STATUS_OPEN_NEWMESSAGES:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base",
				"rsc/icons-nonfree/mail2.png"));
			break;
		default:
			break;
		}
	}
	
}
