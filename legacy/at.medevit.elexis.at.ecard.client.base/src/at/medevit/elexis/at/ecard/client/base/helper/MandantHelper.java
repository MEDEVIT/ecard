package at.medevit.elexis.at.ecard.client.base.helper;

import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.base.soap.Card;
import at.medevit.elexis.at.XID.HVNR;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.MandantAufnehmenDialog;
import ch.elexis.StringConstants;
import ch.elexis.core.data.IPerson;
import ch.elexis.data.Mandant;
import ch.elexis.data.Xid;

public class MandantHelper {
	
	public static Mandant findAndIfNotAvailableAddMandant(Card cardData){
		Mandant m = null;
		m = (Mandant) Xid.findObject(HVNR.DOMAIN_AT_HVNR, cardData.getNummer());
		if (m == null) {
			int retVal =
				new MandantAufnehmenDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), cardData).open();
			if(retVal == MandantAufnehmenDialog.OK) {
				m = new Mandant(cardData.getNachname(), cardData.getVorname(), cardData.getGeburtsdatum(), cardData.getGeschlechtCode().toLowerCase());
				// We need to manually set the mandant to be a person, otherwise it will not be shown
				m.set(Mandant.FLD_IS_PERSON, StringConstants.ONE);
				boolean succ = m.addXid(HVNR.DOMAIN_AT_HVNR, cardData.getNummer(), true);
				if(succ == false) System.out.println("!!!!!! Error updating svnr on "+cardData.getNachname());
				m.set(IPerson.FLD_TITLE, cardData.getTitel());
				// TODO TitelHinten
			}
			// TODO Bestehendem Mandant zuweisen
		}
		return m;
	}
	
}
