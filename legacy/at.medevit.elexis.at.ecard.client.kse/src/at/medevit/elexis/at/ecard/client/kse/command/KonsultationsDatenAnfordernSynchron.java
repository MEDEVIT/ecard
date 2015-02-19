package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.BaseException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.Konsultationsdaten;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenHelper;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.KonsultationSuchFilterDialog;

public class KonsultationsDatenAnfordernSynchron extends AbstractHandler {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.kse.command.KonsultationsDatenAnfordernSynchron";
	
	private KonsultationSuchFilterDialog ksfd;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		
		ksfd =
			new KonsultationSuchFilterDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell());
		int retVal = ksfd.open();
		
		if (retVal == IDialogConstants.OK_ID) {
			boolean fails = true;
			while (fails) {
				try {
					Konsultationsdaten[] kd =
						KseService.getInstance(null).getKonsultationsdaten(
							DialogStatus.getDialogId(), ksfd.getSelektionskriterien(),
							ksfd.getSelektionsart());
					fails = false;

					for (int i = 0; i < kd.length; i++) {
						// TODO refresh view
						KonsultationsdatenHelper.persistKonsultationsdaten(kd[i], true);

						System.out.println("Erhalte " + kd[i].getKonsultationsBeleg().getId());
						// TODO Anzeigen, Option zum Ersetzen/Vergleichen
						// nicht existierende importieren?
						// existierende überschreiben?
					}
					
					// TODO: These exception handling not nice :( --- makes me very sad, smells
				} catch (DialogException e) {
					retVal = handleExceptionInDialog(e);
				} catch (ServiceException e) {
					retVal = handleExceptionInDialog(e);
				} catch (KseException e) {
					retVal = handleExceptionInDialog(e);
				} catch (AccessException e) {
					retVal = handleExceptionInDialog(e);
				} catch (InvalidParameterException e) {
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
			new KonsultationSuchFilterDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), e.getMessage1());
		return ksfd.open();
	}
	
}
