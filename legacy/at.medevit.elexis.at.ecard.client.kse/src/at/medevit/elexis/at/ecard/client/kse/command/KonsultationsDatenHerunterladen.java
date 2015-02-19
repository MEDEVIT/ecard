package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import at.chipkarte.client.base.soap.Message;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.Konsultationsdaten;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenHelper;

public class KonsultationsDatenHerunterladen extends AbstractHandler {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.kse.command.KonsultationsDatenHerunterladen";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		
		ISelection selection =
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Message sel = (Message) strucSelection.getFirstElement();
			if (sel.getCategory().equalsIgnoreCase("ZS_KSE_MSG_ASYDL")) {
				try {
					Konsultationsdaten[] kd = KseService.getInstance(null).downloadKonsultationsdaten(
						DialogStatus.getDialogId(), sel.getText().trim());
					for (int i = 0; i < kd.length; i++) {
						KonsultationsdatenHelper.persistKonsultationsdaten(kd[i], true);		
						System.out.println("Erhalte " + kd[i].getKonsultationsBeleg().getId());
					}
					DialogStatus.updateDialogStatus(true);
					DialogStatus.removeMessage(sel);
					
				} catch (InvalidParameterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (KseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DialogException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		return null;
	}
	
}
