package at.medevit.elexis.at.ecard.client.base.helper;

import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.SvPerson;
import at.medevit.elexis.at.data.SVPerson;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.PatientAufnehmenDialog;
import ch.elexis.actions.ElexisEventDispatcher;
import ch.elexis.data.Patient;

/**
 * This class contains helpers for patient related operations. E.g. synchronizing the master data of
 * patients and contacts as delivered by different sources with the Elexis internal representation
 * of this data.
 */
public class PatientHelper {
	
	/**
	 * Find a patient according to an inserted e-Card resp. the SVNR value. If the patient is not
	 * yet registered in the system offer a dialog to add the patient.
	 */
	public static SVPerson findAndIfNotAvailableAddSVPerson(Card cardData){
		SVPerson p = null;	
		p = SVPerson.findBySVNR(cardData.getNummer());
		
		if (p == null) {
			int retVal =
				new PatientAufnehmenDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), cardData).open();
			if (retVal == PatientAufnehmenDialog.OK) {
				p =
					new SVPerson(cardData.getNummer(), cardData.getVorname(),
						cardData.getNachname(), cardData.getGeburtsdatum(),
						cardData.getGeschlechtCode());
				if (cardData.getTitel() != null)
					p.setTitelVorne(cardData.getTitel());
				if (cardData.getTitelHinten() != null)
					p.setTitelHinten(cardData.getTitelHinten());
			}
		}
		return p;
	}
	
	// TODO: Refactor these functions!
	public static SVPerson findAndIfNotAvailableAddSVPerson(SvPerson svp){
		SVPerson p = null;
		p = SVPerson.findBySVNR(svp.getSvNummer());
		
		if (p == null) {
			int retVal =
				new PatientAufnehmenDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), svp).open();
			if (retVal == PatientAufnehmenDialog.OK) {
				p =
					new SVPerson(svp.getSvNummer(), svp.getVorname(), svp.getNachname(),
						svp.getGeburtsdatum(), svp.getGeschlecht());
				if (svp.getTitelVorne() != null)
					p.setTitelVorne(svp.getTitelVorne());
				if (svp.getTitelHinten() != null)
					p.setTitelHinten(svp.getTitelHinten());
			}
			// TODO Zuweisen eines bestehenden Kontakts.
		}
		return p;
	}
	
	/**
	 * Selects the {@link Patient} adapted by an {@link SVPerson} if available in the system, if not
	 * available nothing happens.
	 */
	public static void setElexisSelectedPatientByInsertedCard(Card cardData){
		SVPerson p = SVPerson.findBySVNR(cardData.getNummer());
		if (p != null)
			ElexisEventDispatcher.fireSelectionEvent(p.getElexisPatient());
	}
	
}
