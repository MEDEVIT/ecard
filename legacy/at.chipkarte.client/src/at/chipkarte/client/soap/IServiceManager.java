/**
 * IServiceManager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.soap;

public interface IServiceManager extends java.rmi.Remote {
    public at.chipkarte.client.soap.Service[] getServices() throws java.rmi.RemoteException;
    public at.chipkarte.client.soap.Service_V3_0[] getServices_V3_0() throws java.rmi.RemoteException;
}
