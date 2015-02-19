package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.BehandlungsfallDurchfuehrenMitECardDialog;

public class BehandlungsfallDurchfuehrenMitECard extends BehandlungsfallDurchfuehren {
	
	public static final String ID =
		"at.medevit.elexis.at.ecard.client.kse.command.BehandlungsfallDurchfuehrenMitECard";
	
	BehandlungsfallDurchfuehrenMitECardDialog bfdmec = null;
	ErgebnisKonsultation ek = null;
	OfflineRecord or = null;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException{
		
		bfdmec =
			new BehandlungsfallDurchfuehrenMitECardDialog(Display.getCurrent().getActiveShell());
		int retVal = bfdmec.open();
		
		handleDialogResult(retVal, bfdmec.getErgebnisKonsultation(), bfdmec.getOfflineRecord());
		
		return null;
	}
}
