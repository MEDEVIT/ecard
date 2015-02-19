/**
 * SoapServiceManagerLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.soap;

public class SoapServiceManagerLocator extends org.apache.axis.client.Service implements at.chipkarte.client.soap.SoapServiceManager {

    public SoapServiceManagerLocator() {
    }


    public SoapServiceManagerLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoapServiceManagerLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoapServiceManager
    private java.lang.String SoapServiceManager_address = "http://localhost/axis/services/soap/ServiceManager";

    public java.lang.String getSoapServiceManagerAddress() {
        return SoapServiceManager_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SoapServiceManagerWSDDServiceName = "soap/ServiceManager";

    public java.lang.String getSoapServiceManagerWSDDServiceName() {
        return SoapServiceManagerWSDDServiceName;
    }

    public void setSoapServiceManagerWSDDServiceName(java.lang.String name) {
        SoapServiceManagerWSDDServiceName = name;
    }

    public at.chipkarte.client.soap.IServiceManager getSoapServiceManager() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoapServiceManager_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoapServiceManager(endpoint);
    }

    public at.chipkarte.client.soap.IServiceManager getSoapServiceManager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            at.chipkarte.client.soap.SoapServiceManagerSoapBindingStub _stub = new at.chipkarte.client.soap.SoapServiceManagerSoapBindingStub(portAddress, this);
            _stub.setPortName(getSoapServiceManagerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoapServiceManagerEndpointAddress(java.lang.String address) {
        SoapServiceManager_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (at.chipkarte.client.soap.IServiceManager.class.isAssignableFrom(serviceEndpointInterface)) {
                at.chipkarte.client.soap.SoapServiceManagerSoapBindingStub _stub = new at.chipkarte.client.soap.SoapServiceManagerSoapBindingStub(new java.net.URL(SoapServiceManager_address), this);
                _stub.setPortName(getSoapServiceManagerWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("soap/ServiceManager".equals(inputPortName)) {
            return getSoapServiceManager();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "soap/ServiceManager");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "soap/ServiceManager"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SoapServiceManager".equals(portName)) {
            setSoapServiceManagerEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
