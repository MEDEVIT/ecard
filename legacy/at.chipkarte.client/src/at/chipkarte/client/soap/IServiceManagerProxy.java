package at.chipkarte.client.soap;

public class IServiceManagerProxy implements at.chipkarte.client.soap.IServiceManager {
  private String _endpoint = null;
  private at.chipkarte.client.soap.IServiceManager iServiceManager = null;
  
  public IServiceManagerProxy() {
    _initIServiceManagerProxy();
  }
  
  public IServiceManagerProxy(String endpoint) {
    _endpoint = endpoint;
    _initIServiceManagerProxy();
  }
  
  private void _initIServiceManagerProxy() {
    try {
      iServiceManager = (new at.chipkarte.client.soap.SoapServiceManagerLocator()).getSoapServiceManager();
      if (iServiceManager != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iServiceManager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iServiceManager)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iServiceManager != null)
      ((javax.xml.rpc.Stub)iServiceManager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public at.chipkarte.client.soap.IServiceManager getIServiceManager() {
    if (iServiceManager == null)
      _initIServiceManagerProxy();
    return iServiceManager;
  }
  
  public at.chipkarte.client.soap.Service[] getServices() throws java.rmi.RemoteException{
    if (iServiceManager == null)
      _initIServiceManagerProxy();
    return iServiceManager.getServices();
  }
  
  public at.chipkarte.client.soap.Service_V3_0[] getServices_V3_0() throws java.rmi.RemoteException{
    if (iServiceManager == null)
      _initIServiceManagerProxy();
    return iServiceManager.getServices_V3_0();
  }
  
  
}