package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import at.chipkarte.client.base.soap.Message;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;

public class KonsultationsDatenAnfrageLoeschen extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		
		ISelection selection =
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Message sel = (Message) strucSelection.getFirstElement();
			if (sel.getCategory().equalsIgnoreCase("ZS_KSE_MSG_ASYDL")) {
				try {
					KseService.getInstance(null).deleteKonsultationsdatenAnfrage(
						DialogStatus.getDialogId(), sel.getText().trim());
					DialogStatus.updateDialogStatus(true);
					MessageDialog.openInformation(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), "Anfrage gelöscht",
						"Die Konsultationsdaten-Anfrage wurde am e-card Serversystem gelöscht.");
					DialogStatus.removeMessage(sel);
				} catch (InvalidParameterException e) {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell(), "Ungültiger Parameter", e.getMessage1());
				} catch (AccessException e) {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell(), "Zugriffsfehler", e.getMessage1());
				} catch (ServiceException e) {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell(), "Service-Fehler", e.getMessage1());
				} catch (DialogException e) {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell(), "Dialog-Fehler", e.getMessage1());
				}
				// TODO Refactor ExceptionHandling
			}		
		}
		
		return null;
	}
	
}
