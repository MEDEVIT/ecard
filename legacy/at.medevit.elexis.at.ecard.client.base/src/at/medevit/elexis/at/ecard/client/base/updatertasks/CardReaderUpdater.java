package at.medevit.elexis.at.ecard.client.base.updatertasks;

import org.eclipse.ui.IStartup;

import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.base.status.CardReaderStatus;
import ch.elexis.Hub;

public class CardReaderUpdater implements IStartup {

	private static Thread t;

	private static Runnable cardWatcher = new Runnable() {
		@Override
		public void run() {
			while (true) {
				try {
					CardReaderStatus.updateStatus();
					// TODO -> make configurable
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	};

	public static void startCardWatcher() {
		if (t == null) {
			t = new Thread(cardWatcher);
			t.start();
		}
	}
	
	@Override
	public void earlyStartup() {
		if (Hub.localCfg.get(GINAConfigurationConstants.ENABLE_LOCAL_CCR, true)) {
			if (t == null)
				CardReaderUpdater.startCardWatcher();
		}
	}
}