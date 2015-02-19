package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import ch.elexis.Hub;

import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.BaseException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.KonsultationSuchFilterDialog;

public class KonsultationsDatenAnfordernAsynchron extends AbstractHandler {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.kse.command.KonsultationsDatenAnfordernAsynchron";
	
	public static final String ANFRAGE_ID = "at.medevit.elexis.at.ecard.client.kse.anfrageId";
	
	private KonsultationSuchFilterDialog ksfd;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		ksfd =
			new KonsultationSuchFilterDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), false);
		int retVal = ksfd.open();
		
		if (retVal == IDialogConstants.OK_ID) {
			boolean fails = true;
			while (fails) {
				try {
					String anfrageId =
						KseService.getInstance(null).sendKonsultationsdatenAnfrage(
							DialogStatus.getDialogId(), ksfd.getSelektionskriterien());
					fails = false;
					MessageDialog.openInformation(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), "Anfrage übermittelt",
						"Die Anfrage wurde an den e-Card Server übermittelt. Die Anfrage-ID lautet "
							+ anfrageId + ".");
					// Store the anfrageId for later reference
					Hub.localCfg.set(ANFRAGE_ID, anfrageId);
				} catch (DialogException e) {
					retVal = handleExceptionInDialog(e);
				} catch (InvalidParameterException e) {
					retVal = handleExceptionInDialog(e);
				} catch (AccessException e) {
					retVal = handleExceptionInDialog(e);
				} catch (KseException e) {
					retVal = handleExceptionInDialog(e);
				} catch (ServiceException e) {
					retVal = handleExceptionInDialog(e);
				}
				if (retVal == IDialogConstants.CANCEL_ID)
					return null;
			}
		}
		return null;
	}
	
	private int handleExceptionInDialog(BaseException e){
		ksfd =
			new KonsultationSuchFilterDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), e.getMessage1());
		return ksfd.open();
	}
}
