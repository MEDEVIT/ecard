package at.medevit.elexis.at.ecard.client.base.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.exceptionHandler.CardExceptionHandler;
import at.medevit.elexis.at.ecard.client.base.exceptionHandler.DialogExceptionHandler;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.DialogAufbauenDialog;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.DialogInfoDialog;
import ch.elexis.Hub;

/**
 * Erstelle einen Dialog zum e-Card Server, verwendet {@link DialogAufbauenDialog} zur
 * User-Interaktion. Bei erfolgreichem Aufbau des Dialoges wird dem Anwender ein Fenster mit den
 * DialogDaten angezeigt, die Daten hierzu werden aus {@link DialogStatus} bezogen.
 * 
 * @author descher@medevit.at
 * 
 */
public class DialogAufbauen extends AbstractHandler {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.base.command.DialogAufbauen";
	
	private String cardReaderId;
	private String extUID = "";
	private String dialogId;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		cardReaderId =
			Hub.localCfg
				.get(GINAConfigurationConstants.CFG_GINA_LOCAL_CCR, GINAConfigurationConstants.NO_VALUE);
		try {
			dialogId =
				BaseService.getInstance(null).createDialog(cardReaderId, BaseService.PRODUCT_INFO,
					extUID);
			DialogAufbauenDialog dad =
				new DialogAufbauenDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), dialogId);
			int ret = dad.open();
			
			if (ret == Dialog.CANCEL) {
				BaseService.getInstance(null).closeDialog(dialogId);
				return null;
			}
			
			if (ret == Dialog.OK) {
				BaseService.getInstance(null).setDialogAddress(dialogId,
					dad.getSelectedOrdination().getOrdinationId(),
					dad.getSelectedTaetigkeitsBereich().getId());
				
				DialogStatus.setDialogId(dialogId, dad.getVertragspartner(), dad.getOrdination(),
					dad.getSelectedTaetigkeitsBereich());
				
				if (dad.getUserWantsToSeeDialogInfo()) {
					DialogInfoDialog did =
						new DialogInfoDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getShell());
					did.open();
				}
			}
			
		} catch (CardException e) {
			// TODO ?
			CardExceptionHandler.handle(e);
		} catch (DialogException e) {
			// TODO ?
			DialogExceptionHandler.handle(e);
		}
		
		return null;
	}
	
}
