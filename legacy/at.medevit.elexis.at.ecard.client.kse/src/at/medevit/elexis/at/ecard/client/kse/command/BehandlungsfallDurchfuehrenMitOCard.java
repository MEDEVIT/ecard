package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import at.medevit.elexis.at.ecard.client.kse.ui.dialog.BehandlungsfallDurchfuehrenMitOCardDialog;

public class BehandlungsfallDurchfuehrenMitOCard extends BehandlungsfallDurchfuehren {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.kse.command.BehandlungsfallDurchfuehrenMitOCard";
	
	BehandlungsfallDurchfuehrenMitOCardDialog bfdmoc = null;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		
		bfdmoc =
			new BehandlungsfallDurchfuehrenMitOCardDialog(Display.getCurrent().getActiveShell());
		int retVal = bfdmoc.open();
		
		handleDialogResult(retVal, bfdmoc.getErgebnisKonsultation(), bfdmoc.getOfflineRecord());
		
		return null;
	}
	
}
