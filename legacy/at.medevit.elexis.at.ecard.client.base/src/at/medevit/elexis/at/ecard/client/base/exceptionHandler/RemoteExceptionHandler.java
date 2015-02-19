package at.medevit.elexis.at.ecard.client.base.exceptionHandler;

import java.rmi.RemoteException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import at.medevit.elexis.at.ecard.client.base.Activator;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;

public class RemoteExceptionHandler {
	
	/**
	 * Handle the remote exception.<br> 
	 * We set the GINA status to {@link GINAStatus#GINA_STATUS_NO_CONNECTION_TO_GINA},
	 * store the exception information in {@link GINAStatus},
	 * disconnect the {@link BaseService} and inform the user.
	 * <br>An "external" service calling this has to make sure to disconnect its own instance.
	 * @param e occurring exception
	 */
	public static synchronized void handleRemoteException(RemoteException e) {
		StackTraceElement[] er = Thread.currentThread().getStackTrace();
		System.out.println("Caller: \n"+er[0]+"\n"+er[1]+"\n"+er[2]+"\n"+er[3]+"\n"+er[4]+"\n"+er[5]+"\n"+er[6]);
		System.out.println("Caller: \n"+er[0]+"\n"+er[1]+"\n"+er[2]+"\n"+er[3]);
		// Communication-related exceptions, we can't cope with this!
		
		// If we are already in NO_CONNECTION_STATE we don't need to alert again!
		if(GINAStatus.getGinaStatus()==GINAStatus.GINA_STATUS_NO_CONNECTION_TO_GINA) return;
		
		GINAStatus.setGinaStatus(GINAStatus.GINA_STATUS_NO_CONNECTION_TO_GINA, null);
		GINAStatus.setRemoteExceptionInformation(e);
		BaseService.disconnect();
		
		// TODO: Nicer message
		final String error = e.getMessage();
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run(){
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
					"GINA Verbindungsfehler", 
					"Es kann keine Verbindung zur GINA-Box hergestellt werden.\n Fehlergrund: "+error);
				
			}
		});
		
		Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "GINA Service " + e.getMessage(), e);
		StatusManager.getManager().handle(status, StatusManager.LOG);
	}
	
}
