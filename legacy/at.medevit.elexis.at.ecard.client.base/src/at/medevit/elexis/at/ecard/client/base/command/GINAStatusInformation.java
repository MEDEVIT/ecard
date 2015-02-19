package at.medevit.elexis.at.ecard.client.base.command;

import static at.medevit.elexis.at.ecard.client.base.status.GINAStatus.GINA_STATUS_CONNECTION_NOT_CONFIGURED;
import static at.medevit.elexis.at.ecard.client.base.status.GINAStatus.GINA_STATUS_CURRENTLY_UPDATING;
import static at.medevit.elexis.at.ecard.client.base.status.GINAStatus.GINA_STATUS_OFFLINE;
import static at.medevit.elexis.at.ecard.client.base.status.GINAStatus.GINA_STATUS_ONLINE;
import static at.medevit.elexis.at.ecard.client.base.status.GINAStatus.getGinaStatus;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.wb.swt.ResourceManager;

import at.medevit.elexis.at.ecard.client.base.ui.dialog.GINAStatusDialog;

public class GINAStatusInformation extends AbstractHandler implements IElementUpdater {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.base.command.GINAStatusInformation";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		GINAStatusDialog gst = new GINAStatusDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		gst.open();
		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters){
		int ginaStatus = getGinaStatus();
		switch (ginaStatus) {
		case GINA_STATUS_CONNECTION_NOT_CONFIGURED:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
					"at.medevit.elexis.at.ecard.client.base",
					"rsc/icons/ginaboxIconNotConfigured.png"));
			break;
		case GINA_STATUS_ONLINE:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/ginaboxIconTransparent.png"));
			break;
		case GINA_STATUS_OFFLINE:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/ginaboxIconOffline.png"));
			break;
		case GINA_STATUS_CURRENTLY_UPDATING:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/ginaboxIconHourglass.png"));
			break;
		default:
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/ginaboxIconNoConnection.png"));
			break;
		}
	}
	
}
