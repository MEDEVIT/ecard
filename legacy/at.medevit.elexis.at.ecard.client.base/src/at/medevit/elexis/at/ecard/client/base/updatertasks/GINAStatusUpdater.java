package at.medevit.elexis.at.ecard.client.base.updatertasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IStartup;

import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import ch.elexis.actions.Heartbeat;
import ch.elexis.actions.Heartbeat.HeartListener;

/**
 * This class is responsible for the periodic updating tasks
 * 
 * @author marco
 *
 */
public class GINAStatusUpdater implements HeartListener, IStartup {
	
	@Override
	public void heartbeat() {
		GINAStatus.updateStatus(false);
	}

	@Override
	public void earlyStartup(){
		Job job = new Job("GINA Status Aktualisierung") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				GINAStatus.updateStatus(true);
				return Status.OK_STATUS;
			}
		};
		job.setSystem(true);
		job.schedule();		

		Heartbeat.getInstance().addListener(this, Heartbeat.FREQUENCY_LOW);	
	}
	
}
