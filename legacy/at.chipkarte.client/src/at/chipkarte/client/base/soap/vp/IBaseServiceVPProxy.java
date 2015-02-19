package at.chipkarte.client.base.soap.vp;

public class IBaseServiceVPProxy implements at.chipkarte.client.base.soap.vp.IBaseServiceVP {
  private String _endpoint = null;
  private at.chipkarte.client.base.soap.vp.IBaseServiceVP iBaseServiceVP = null;
  
  public IBaseServiceVPProxy() {
    _initIBaseServiceVPProxy();
  }
  
  public IBaseServiceVPProxy(String endpoint) {
    _endpoint = endpoint;
    _initIBaseServiceVPProxy();
  }
  
  private void _initIBaseServiceVPProxy() {
    try {
      iBaseServiceVP = (new at.chipkarte.client.base.soap.vp.Soap_base_90Locator()).getSoap_base_90();
      if (iBaseServiceVP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iBaseServiceVP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iBaseServiceVP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iBaseServiceVP != null)
      ((javax.xml.rpc.Stub)iBaseServiceVP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public at.chipkarte.client.base.soap.vp.IBaseServiceVP getIBaseServiceVP() {
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP;
  }
  
  public java.lang.String createDialog(java.lang.String cardReaderId, at.chipkarte.client.base.soap.vp.ProduktInfo produktInfo, java.lang.String extUID) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.createDialog(cardReaderId, produktInfo, extUID);
  }
  
  public at.chipkarte.client.base.soap.CardReader[] getCardReaders() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getCardReaders();
  }
  
  public at.chipkarte.client.base.soap.Card getCardData(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getCardData(cardReaderId);
  }
  
  public at.chipkarte.client.base.soap.Property[] getExtendedCardData(java.lang.String cardReaderId, java.lang.String CIN) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getExtendedCardData(cardReaderId, CIN);
  }
  
  public void changePin(java.lang.String cardReaderId, java.lang.String cin, java.lang.String oldPin, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.changePin(cardReaderId, cin, oldPin, newPin);
  }
  
  public void changePinWithPuk(java.lang.String cardReaderId, java.lang.String cin, java.lang.String puk, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.changePinWithPuk(cardReaderId, cin, puk, newPin);
  }
  
  public int doCardTest(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.doCardTest(cardReaderId);
  }
  
  public at.chipkarte.client.base.soap.Vertragspartner authenticateDialog(java.lang.String dialogId, java.lang.String cin, java.lang.String pin, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.authenticateDialog(dialogId, cin, pin, cardReaderId);
  }
  
  public void setDialogAddress(java.lang.String dialogId, java.lang.String ordinationId, java.lang.String taetigkeitsBereichId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
  }
  
  public void closeDialog(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.closeDialog(dialogId);
  }
  
  public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.checkStatus(dialogId);
  }
  
  public void uebersiedelnOrdination(java.lang.String dialogId, java.lang.String ordinationId, boolean forceUebersiedlung) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.uebersiedelnOrdination(dialogId, ordinationId, forceUebersiedlung);
  }
  
  public at.chipkarte.client.base.soap.Message[] getMessages(java.lang.String dialogId, boolean newOnly) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getMessages(dialogId, newOnly);
  }
  
  public at.chipkarte.client.base.soap.DialogsInfo getFreeDialogs() throws java.rmi.RemoteException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getFreeDialogs();
  }
  
  public at.chipkarte.client.base.soap.GinaVersion getGinaSoftwareVersion() throws java.rmi.RemoteException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getGinaSoftwareVersion();
  }
  
  public at.chipkarte.client.base.soap.VertragsDaten[] getVertraege(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getVertraege(dialogId);
  }
  
  public at.chipkarte.client.base.soap.SvPerson getBCardSvPerson(java.lang.String dialogId, boolean forceExecution, java.lang.String readerId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.BCardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getBCardSvPerson(dialogId, forceExecution, readerId);
  }
  
  public at.chipkarte.client.base.soap.SvtProperty[] getSVTs() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getSVTs();
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getFachgebiete() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getFachgebiete();
  }
  
  public at.chipkarte.client.base.soap.BaseProperty[] getFachgebieteByOrdId(java.lang.String dialogId, java.lang.String ordId, java.lang.String taetigkeitsBereichId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getFachgebieteByOrdId(dialogId, ordId, taetigkeitsBereichId);
  }
  
  public at.chipkarte.client.base.soap.StatusInformationen getGinaAndServiceavailabilityInformation() throws java.rmi.RemoteException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getGinaAndServiceavailabilityInformation();
  }
  
  public void setCardReader(java.lang.String dialogId, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.setCardReader(dialogId, cardReaderId);
  }
  
  public at.chipkarte.client.base.soap.ReaderStatusResult getReaderStatusEvents(java.lang.String handle, java.lang.String[] cardReaderId, int timeOut) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getReaderStatusEvents(handle, cardReaderId, timeOut);
  }
  
  public void releaseCardReader(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    iBaseServiceVP.releaseCardReader(cardReaderId);
  }
  
  public java.lang.String[] getBerechtigungen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException{
    if (iBaseServiceVP == null)
      _initIBaseServiceVPProxy();
    return iBaseServiceVP.getBerechtigungen(dialogId);
  }
  
  
}