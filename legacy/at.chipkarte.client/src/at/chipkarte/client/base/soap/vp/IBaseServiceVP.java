/**
 * IBaseServiceVP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap.vp;

public interface IBaseServiceVP extends java.rmi.Remote {
    public java.lang.String createDialog(java.lang.String cardReaderId, at.chipkarte.client.base.soap.vp.ProduktInfo produktInfo, java.lang.String extUID) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.CardReader[] getCardReaders() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public at.chipkarte.client.base.soap.Card getCardData(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public at.chipkarte.client.base.soap.Property[] getExtendedCardData(java.lang.String cardReaderId, java.lang.String CIN) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public void changePin(java.lang.String cardReaderId, java.lang.String cin, java.lang.String oldPin, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public void changePinWithPuk(java.lang.String cardReaderId, java.lang.String cin, java.lang.String puk, java.lang.String newPin) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public int doCardTest(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public at.chipkarte.client.base.soap.Vertragspartner authenticateDialog(java.lang.String dialogId, java.lang.String cin, java.lang.String pin, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public void setDialogAddress(java.lang.String dialogId, java.lang.String ordinationId, java.lang.String taetigkeitsBereichId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public void closeDialog(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public void uebersiedelnOrdination(java.lang.String dialogId, java.lang.String ordinationId, boolean forceUebersiedlung) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.Message[] getMessages(java.lang.String dialogId, boolean newOnly) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.DialogsInfo getFreeDialogs() throws java.rmi.RemoteException;
    public at.chipkarte.client.base.soap.GinaVersion getGinaSoftwareVersion() throws java.rmi.RemoteException;
    public at.chipkarte.client.base.soap.VertragsDaten[] getVertraege(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.SvPerson getBCardSvPerson(java.lang.String dialogId, boolean forceExecution, java.lang.String readerId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.BCardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.SvtProperty[] getSVTs() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public at.chipkarte.client.base.soap.BaseProperty[] getFachgebiete() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public at.chipkarte.client.base.soap.BaseProperty[] getFachgebieteByOrdId(java.lang.String dialogId, java.lang.String ordId, java.lang.String taetigkeitsBereichId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.StatusInformationen getGinaAndServiceavailabilityInformation() throws java.rmi.RemoteException;
    public void setCardReader(java.lang.String dialogId, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
    public at.chipkarte.client.base.soap.ReaderStatusResult getReaderStatusEvents(java.lang.String handle, java.lang.String[] cardReaderId, int timeOut) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public void releaseCardReader(java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.base.soap.exceptions.ServiceException;
    public java.lang.String[] getBerechtigungen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException;
}
