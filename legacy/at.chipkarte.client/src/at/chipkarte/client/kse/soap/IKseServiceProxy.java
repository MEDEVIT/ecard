package at.chipkarte.client.kse.soap;

public class IKseServiceProxy implements at.chipkarte.client.kse.soap.IKseService {
  private String _endpoint = null;
  private at.chipkarte.client.kse.soap.IKseService iKseService = null;
  
  public IKseServiceProxy() {
    _initIKseServiceProxy();
  }
  
  public IKseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIKseServiceProxy();
  }
  
  private void _initIKseServiceProxy() {
    try {
      iKseService = (new at.chipkarte.client.kse.soap.Soap_kse_110Locator()).getSoap_kse_110();
      if (iKseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iKseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iKseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iKseService != null)
      ((javax.xml.rpc.Stub)iKseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public at.chipkarte.client.kse.soap.IKseService getIKseService() {
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService;
  }
  
  public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.checkStatus(dialogId);
  }
  
  public at.chipkarte.client.kse.soap.Limit[] getLimit(java.lang.String dialogId, int zeitraum) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getLimit(dialogId, zeitraum);
  }
  
  public at.chipkarte.client.kse.soap.ErgebnisKonsultation doKonsultation(java.lang.String cin, java.lang.String dialogId, java.lang.String svNummer, java.lang.String svtCode, java.lang.String anspruchId, java.lang.String fachgebietsCode, java.lang.String behandlungsfallCode, java.lang.String nacherfassungsgrundCode, java.lang.String behandlungsdatum, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.BCardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.doKonsultation(cin, dialogId, svNummer, svtCode, anspruchId, fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode, behandlungsdatum, forceExecution, cardReaderId);
  }
  
  public void sendZusatzinformationsAntwort(java.lang.String dialogId, long zusatzinformationsAntwortId, int zusatzinformationsAntwort) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.DialogException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iKseService == null)
      _initIKseServiceProxy();
    iKseService.sendZusatzinformationsAntwort(dialogId, zusatzinformationsAntwortId, zusatzinformationsAntwort);
  }
  
  public at.chipkarte.client.kse.soap.OfflineRecord doKonsultationOffline(java.lang.String cin, java.lang.String dialogId, java.lang.String svNummer, java.lang.String svtCode, java.lang.String fachgebietsCode, java.lang.String behandlungsfallCode, java.lang.String nacherfassungsgrundCode, java.lang.String behandlungsdatum, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.doKonsultationOffline(cin, dialogId, svNummer, svtCode, fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode, behandlungsdatum, forceExecution, cardReaderId);
  }
  
  public at.chipkarte.client.kse.soap.KonsultationsBeleg stornierenKonsultation(java.lang.String dialogId, long konsId, int konsVersion) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.stornierenKonsultation(dialogId, konsId, konsVersion);
  }
  
  public at.chipkarte.client.kse.soap.ErgebnisKonsultation wiederinkraftsetzenKonsultation(java.lang.String dialogId, long konsId, int konsVersion) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.wiederinkraftsetzenKonsultation(dialogId, konsId, konsVersion);
  }
  
  public at.chipkarte.client.kse.soap.KonsultationsBeleg aendernKonsultation(java.lang.String dialogId, long konsId, int konsVersion, java.lang.String behandlungsfallCode) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.aendernKonsultation(dialogId, konsId, konsVersion, behandlungsfallCode);
  }
  
  public at.chipkarte.client.kse.soap.Konsultationsdaten[] getKonsultationsdaten(java.lang.String dialogId, at.chipkarte.client.kse.soap.SuchFilter selektionsKriterien, java.lang.String selektionsart) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getKonsultationsdaten(dialogId, selektionsKriterien, selektionsart);
  }
  
  public java.lang.String sendKonsultationsdatenAnfrage(java.lang.String dialogId, at.chipkarte.client.kse.soap.SuchFilter selektionsKriterien) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.sendKonsultationsdatenAnfrage(dialogId, selektionsKriterien);
  }
  
  public at.chipkarte.client.kse.soap.Konsultationsdaten[] downloadKonsultationsdaten(java.lang.String dialogId, java.lang.String anfrageId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.downloadKonsultationsdaten(dialogId, anfrageId);
  }
  
  public at.chipkarte.client.kse.soap.KonsultationdatenAnfrage[] getKonsultationsdatenAnfragen(java.lang.String dialogId, boolean onlyReady) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getKonsultationsdatenAnfragen(dialogId, onlyReady);
  }
  
  public void deleteKonsultationsdatenAnfrage(java.lang.String dialogId, java.lang.String anfrageId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    iKseService.deleteKonsultationsdatenAnfrage(dialogId, anfrageId);
  }
  
  public at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignierenKonsultationen(java.lang.String dialogId, java.lang.String cin, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.nachsignierenKonsultationen(dialogId, cin, forceExecution, cardReaderId);
  }
  
  public at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignierenKonsultationenBCard(java.lang.String dialogId, java.lang.String svNummer, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.BCardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.nachsignierenKonsultationenBCard(dialogId, svNummer, cardReaderId);
  }
  
  public at.chipkarte.client.kse.soap.OfflineRecord nachsignierenKonsultationenOffline(java.lang.String dialogId, java.lang.String cin, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.nachsignierenKonsultationenOffline(dialogId, cin, forceExecution, cardReaderId);
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getBehandlungsfaelle() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getBehandlungsfaelle();
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getBehandlungsfaelleByFachgebiet(java.lang.String fachgebietCode) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getBehandlungsfaelleByFachgebiet(fachgebietCode);
  }
  
  public at.chipkarte.client.kse.soap.OfflineRecord[] getOfflineRecords(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getOfflineRecords(dialogId);
  }
  
  public long getNumberOfflineKonsultationen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getNumberOfflineKonsultationen(dialogId);
  }
  
  public long getNumberOfflineNachsignaturen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.getNumberOfflineNachsignaturen(dialogId);
  }
  
  public void deleteOfflineRecord(java.lang.String dialogId, java.lang.String offlineId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    iKseService.deleteOfflineRecord(dialogId, offlineId);
  }
  
  public at.chipkarte.client.kse.soap.ErgebnisKonsultation sendOfflineKonsultation(java.lang.String dialogId, java.lang.String offlineId, java.lang.String fachgebietsCode, java.lang.String behandlungsfallCode, java.lang.String svtCode, java.lang.String anspruchId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.sendOfflineKonsultation(dialogId, offlineId, fachgebietsCode, behandlungsfallCode, svtCode, anspruchId);
  }
  
  public at.chipkarte.client.kse.soap.KonsultationsBeleg[] sendOfflineNachsignatur(java.lang.String dialogId, java.lang.String offlineId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iKseService == null)
      _initIKseServiceProxy();
    return iKseService.sendOfflineNachsignatur(dialogId, offlineId);
  }
  
  
}