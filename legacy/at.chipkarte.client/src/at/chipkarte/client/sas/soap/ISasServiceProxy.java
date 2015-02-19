package at.chipkarte.client.sas.soap;

public class ISasServiceProxy implements at.chipkarte.client.sas.soap.ISasService {
  private String _endpoint = null;
  private at.chipkarte.client.sas.soap.ISasService iSasService = null;
  
  public ISasServiceProxy() {
    _initISasServiceProxy();
  }
  
  public ISasServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initISasServiceProxy();
  }
  
  private void _initISasServiceProxy() {
    try {
      iSasService = (new at.chipkarte.client.sas.soap.Soap_sas_90Locator()).getSoap_sas_90();
      if (iSasService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iSasService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iSasService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iSasService != null)
      ((javax.xml.rpc.Stub)iSasService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public at.chipkarte.client.sas.soap.ISasService getISasService() {
    if (iSasService == null)
      _initISasServiceProxy();
    return iSasService;
  }
  
  public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iSasService == null)
      _initISasServiceProxy();
    return iSasService.checkStatus(dialogId);
  }
  
  public at.chipkarte.client.sas.soap.AbfrageErgebnis svNummerAbfragen(java.lang.String dialogId, at.chipkarte.client.sas.soap.Suchkriterien svNummerAbfragenSuchkriterien) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.sas.soap.exceptions.SasException, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iSasService == null)
      _initISasServiceProxy();
    return iSasService.svNummerAbfragen(dialogId, svNummerAbfragenSuchkriterien);
  }
  
  public at.chipkarte.client.sas.soap.AbfrageErgebnis patientendatenAbfragen(java.lang.String dialogId, java.lang.String svNummer) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.sas.soap.exceptions.SasException, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException, at.chipkarte.client.base.soap.exceptions.DialogException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iSasService == null)
      _initISasServiceProxy();
    return iSasService.patientendatenAbfragen(dialogId, svNummer);
  }
  
  
}