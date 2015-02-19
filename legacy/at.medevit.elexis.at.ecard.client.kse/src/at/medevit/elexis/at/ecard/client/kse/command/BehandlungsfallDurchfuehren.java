package at.medevit.elexis.at.ecard.client.kse.command;

import org.eclipse.core.commands.AbstractHandler;

import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.medevit.elexis.at.ecard.client.kse.helper.ErgebnisKonsultationHelper;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.BehandlungsfallDurchfuehrenDialog;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.BehandlungsfallDurchfuehrenMitECardDialog;

public abstract class BehandlungsfallDurchfuehren extends AbstractHandler {

	protected void handleDialogResult(int retVal, ErgebnisKonsultation ek, OfflineRecord or){
		if (retVal == BehandlungsfallDurchfuehrenDialog.BEHANDLUNGSFALL_OK_ONLINE) {			
			ErgebnisKonsultationHelper.handleIncomingErgebnisKonsultation(ek);
		} else if (retVal == BehandlungsfallDurchfuehrenMitECardDialog.BEHANDLUNGSFALL_OK_OFFLINE) {
			ErgebnisKonsultationHelper.handleIncomingOfflineRecord(or);
		}
	}
	
}
