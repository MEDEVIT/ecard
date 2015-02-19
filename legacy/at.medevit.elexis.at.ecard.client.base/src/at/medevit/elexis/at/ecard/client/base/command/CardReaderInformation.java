package at.medevit.elexis.at.ecard.client.base.command;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.wb.swt.ResourceManager;

import at.chipkarte.client.base.soap.constants.CardType;
import at.medevit.elexis.at.ecard.client.base.status.CardReaderStatus;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.CardInfoDialog;

public class CardReaderInformation extends AbstractHandler implements IElementUpdater {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.base.command.CardReaderInformation";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		CardInfoDialog cid = new CardInfoDialog(Display.getCurrent().getActiveShell());
		cid.open();
		return null;
	}
	
	@Override
	public void updateElement(UIElement element, Map parameters){
		int crs = CardReaderStatus.getStatus();
		if (crs == CardReaderStatus.CARD_READER_CONTAINS_O_CARD) {
			element.setText(CardType.O_CARD);
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/oCardIcon.png"));
		} else if (crs == CardReaderStatus.CARD_READER_CONTAINS_E_CARD) {
			element.setText(CardType.E_CARD);
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/eCardIcon.png"));
		} else if (crs == CardReaderStatus.CARD_READER_CONTAINS_B_CARD) {
			element.setText(CardType.B_CARD);
			// TODO: BUERGERCARD ICON
		} else if (crs == CardReaderStatus.CARD_READER_CONTAINS_SCHULUNGS_E_CARD) {
			element.setText(CardType.SCHULUNGS_E_CARD);
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/eCardIcon.png"));
		} else {
			element.setIcon(ResourceManager.getPluginImageDescriptor(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/emptyTransparent.png"));
		}
	}
	
}
