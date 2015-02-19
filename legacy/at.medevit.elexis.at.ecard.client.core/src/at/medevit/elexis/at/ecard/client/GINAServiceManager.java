package at.medevit.elexis.at.ecard.client;

import java.rmi.RemoteException;

import org.eclipse.ui.PlatformUI;

import at.chipkarte.client.base.soap.vp.IBaseServiceVP;
import at.chipkarte.client.base.soap.vp.IBaseServiceVPProxy;
import at.chipkarte.client.kse.soap.IKseService;
import at.chipkarte.client.kse.soap.IKseServiceProxy;
import at.chipkarte.client.sas.soap.ISasService;
import at.chipkarte.client.sas.soap.ISasServiceProxy;
import at.chipkarte.client.soap.IServiceManager;
import at.chipkarte.client.soap.IServiceManagerProxy;
import at.chipkarte.client.soap.Service;
import at.chipkarte.client.soap.constants.ServiceName;

public class GINAServiceManager {
	
	private GINAServiceManager(){};
	
	public static String getConfiguredGinaServiceManagerEndpointUrl(){
		return "http://"
			+ PlatformUI.getPreferenceStore().getString(GINAConfigurationConstants.CFG_GINA_IP)
			+ "/axis/services/soap/ServiceManager";
	}
	
	protected static Service[] getGINAServices(String endpointUrl) throws RemoteException{
		IServiceManager serviceManager = new IServiceManagerProxy(endpointUrl);
		return serviceManager.getServices();
	}
	
	private static String getGINAServiceStringUrl(String service, String version,
		String ginaServiceManagerUrl) throws RemoteException{
		
		Service[] ginaServices = getGINAServices(ginaServiceManagerUrl);
		
		if (ginaServices != null) {
			for (Service serviceEntry : ginaServices) {
				if (serviceEntry.getName().equalsIgnoreCase(service)
					&& serviceEntry.getVersion().equalsIgnoreCase(version)) {
					return serviceEntry.getEndPointURL();
				}
			}
		}
		return null;
	}
	
	public static IBaseServiceVP getBaseService(String version, String ginaUrl)
		throws RemoteException{
		return new IBaseServiceVPProxy(getGINAServiceStringUrl(ServiceName.BASE_SERVICE, version,
			ginaUrl));
	}
	
	public static IKseService getKseService(String version, String ginaUrl) throws RemoteException{
		return new IKseServiceProxy(getGINAServiceStringUrl(ServiceName.KSE_SERVICE, version,
			ginaUrl));
	}
	
	public static ISasService getSasService(String version, String ginaUrl) throws RemoteException{
		return new ISasServiceProxy(getGINAServiceStringUrl(ServiceName.SAS_SERVICE, version,
			ginaUrl));
	}
}
