package at.medevit.elexis.at.ecard.client.kse.helper;

import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.Konsultationsdaten;
import at.chipkarte.client.kse.soap.OfflineKonsultation;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.chipkarte.client.kse.soap.Zusatzinformation;
import at.chipkarte.client.kse.soap.constants.KseMessage;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.ZusatzinformationBeantwortenDialog;

public class ErgebnisKonsultationHelper {
	
	/**
	 * Handle an incoming {@link ErgebnisKonsultation} by checking it for incoming
	 * message codes (taking necessary actions if applicable) and persisting the
	 * contained {@link Konsultationsdaten}
	 * @param ek
	 */
	public static void handleIncomingErgebnisKonsultation(ErgebnisKonsultation ek) {
		Integer[] mc = ek.getKseMessageCodes();
		if(mc != null ) for (int i = 0; i < mc.length; i++) {
			switch (mc[i]) {
			case KseMessage.PATIENT_ZUSATZINFO:
				Zusatzinformation zi = ek.getZusatzinformation();
				ZusatzinformationBeantwortenDialog zbd =
					new ZusatzinformationBeantwortenDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), zi);
				int retValZBD = zbd.open();
				break;
			case KseMessage.ERST_KONSULTATION: // Eine Erstkonsultation zeichnet sich dadurch ... p43
				// TODO: Was tun mit dieser Information? Zu Konsultationsdaten hinzufügen?
				break;
			case KseMessage.SVT_UEBERSTEUERT:
				// TODO
				System.out.println("SVT_UEBERSTEUERT");
				break;
			default:
				break;
			}
		}
		
		KonsultationsdatenHelper.persistKonsultationsdaten(ek.getKonsultationsDaten(), false);
	}

	/**
	 * Handle an incoming {@link OfflineRecord}
	 * @param or
	 */
	public static void handleIncomingOfflineRecord(OfflineRecord or){
		OfflineKonsultation ok = or.getOfflineKonsultation();
		
	}
}
