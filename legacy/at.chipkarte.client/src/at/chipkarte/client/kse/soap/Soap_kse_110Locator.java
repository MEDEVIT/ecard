/**
 * Soap_kse_110Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class Soap_kse_110Locator extends org.apache.axis.client.Service implements at.chipkarte.client.kse.soap.Soap_kse_110 {

    public Soap_kse_110Locator() {
    }


    public Soap_kse_110Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Soap_kse_110Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Soap_kse_110
    private java.lang.String Soap_kse_110_address = "http://localhost/axis/services/soap_kse_11.0";

    public java.lang.String getSoap_kse_110Address() {
        return Soap_kse_110_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Soap_kse_110WSDDServiceName = "soap_kse_11.0";

    public java.lang.String getSoap_kse_110WSDDServiceName() {
        return Soap_kse_110WSDDServiceName;
    }

    public void setSoap_kse_110WSDDServiceName(java.lang.String name) {
        Soap_kse_110WSDDServiceName = name;
    }

    public at.chipkarte.client.kse.soap.IKseService getSoap_kse_110() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Soap_kse_110_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoap_kse_110(endpoint);
    }

    public at.chipkarte.client.kse.soap.IKseService getSoap_kse_110(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            at.chipkarte.client.kse.soap.Soap_kse_110SoapBindingStub _stub = new at.chipkarte.client.kse.soap.Soap_kse_110SoapBindingStub(portAddress, this);
            _stub.setPortName(getSoap_kse_110WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoap_kse_110EndpointAddress(java.lang.String address) {
        Soap_kse_110_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (at.chipkarte.client.kse.soap.IKseService.class.isAssignableFrom(serviceEndpointInterface)) {
                at.chipkarte.client.kse.soap.Soap_kse_110SoapBindingStub _stub = new at.chipkarte.client.kse.soap.Soap_kse_110SoapBindingStub(new java.net.URL(Soap_kse_110_address), this);
                _stub.setPortName(getSoap_kse_110WSDDServiceName());
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
        if ("soap_kse_11.0".equals(inputPortName)) {
            return getSoap_kse_110();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "soap_kse_11.0");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "soap_kse_11.0"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Soap_kse_110".equals(portName)) {
            setSoap_kse_110EndpointAddress(address);
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
