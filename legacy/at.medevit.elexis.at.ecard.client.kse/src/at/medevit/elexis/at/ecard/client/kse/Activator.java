package at.medevit.elexis.at.ecard.client.kse;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "at.medevit.elexis.at.ecard.client.kse"; //$NON-NLS-1$
	private static Activator plugin;
	
	public Activator(){}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception{
		super.start(context);
		plugin = this;
//		DialogStatus.attachObserver(KseStatus.getInstance());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception{
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