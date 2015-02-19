/**
 * SoapServiceManager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.soap;

public interface SoapServiceManager extends javax.xml.rpc.Service {
    public java.lang.String getSoapServiceManagerAddress();

    public at.chipkarte.client.soap.IServiceManager getSoapServiceManager() throws javax.xml.rpc.ServiceException;

    public at.chipkarte.client.soap.IServiceManager getSoapServiceManager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
