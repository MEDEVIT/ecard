package at.medevit.elexis.at.ecard.client.base;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.medevit.elexis.at.ecard.client.base.exceptionHandler.DialogExceptionHandler;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import ch.elexis.util.Log;

public class Activator extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "at.medevit.elexis.at.ecard.client.base"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;
	
	private static Log logger = Log.get(Activator.class.getName());
	
	public Activator(){}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception{
		super.start(context);
		plugin = this;
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception{
		if (DialogStatus.dialogOpen()) {
			try {
				logger.log("Schliesse Dialog " + DialogStatus.getDialogId(), Log.INFOS);
				BaseService.getInstance(null).closeDialog(DialogStatus.getDialogId());
//				DialogStatus.setDialogClosed(); throws Widget is disposed
			} catch (DialogException e) {
				DialogExceptionHandler.handle(e);
			}
		}
		
		plugin = null;
		super.stop(context);
	}
	
	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault(){
		return plugin;
	}
}
