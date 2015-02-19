package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenHelper;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsbeleg;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsdaten;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.KonsultationsbelegDetailDialog;

public class KonsultationsbelegAnzeigen extends AbstractHandler implements IDoubleClickListener {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.kse.command.KonsultationsbelegAnzeigen";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		
		ISelection selection =
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			if (!(strucSelection.getFirstElement() instanceof Konsultationsbeleg))
				return null;
			Konsultationsbeleg sel = (Konsultationsbeleg) strucSelection.getFirstElement();
			
			Konsultationsdaten kd = KonsultationsdatenHelper.getKonsultationsdatenEntry(sel);
			if (kd != null) {
				new KonsultationsbelegDetailDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), kd).open();
			}
		}
		
		return null;
	}
	
	@Override
	public void doubleClick(DoubleClickEvent event){
		IHandlerService handlerService =
			(IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
		try {
			handlerService.executeCommand(ID, null);
		} catch (Exception ex) {
			throw new RuntimeException(ID + " not found");
		}
		
	}
	
}
