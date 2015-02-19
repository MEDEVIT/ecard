/**
 * Soap_sas_90Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class Soap_sas_90Locator extends org.apache.axis.client.Service implements at.chipkarte.client.sas.soap.Soap_sas_90 {

    public Soap_sas_90Locator() {
    }


    public Soap_sas_90Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Soap_sas_90Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Soap_sas_90
    private java.lang.String Soap_sas_90_address = "http://localhost/axis/services/soap_sas_9.0";

    public java.lang.String getSoap_sas_90Address() {
        return Soap_sas_90_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Soap_sas_90WSDDServiceName = "soap_sas_9.0";

    public java.lang.String getSoap_sas_90WSDDServiceName() {
        return Soap_sas_90WSDDServiceName;
    }

    public void setSoap_sas_90WSDDServiceName(java.lang.String name) {
        Soap_sas_90WSDDServiceName = name;
    }

    public at.chipkarte.client.sas.soap.ISasService getSoap_sas_90() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Soap_sas_90_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoap_sas_90(endpoint);
    }

    public at.chipkarte.client.sas.soap.ISasService getSoap_sas_90(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            at.chipkarte.client.sas.soap.Soap_sas_90SoapBindingStub _stub = new at.chipkarte.client.sas.soap.Soap_sas_90SoapBindingStub(portAddress, this);
            _stub.setPortName(getSoap_sas_90WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoap_sas_90EndpointAddress(java.lang.String address) {
        Soap_sas_90_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (at.chipkarte.client.sas.soap.ISasService.class.isAssignableFrom(serviceEndpointInterface)) {
                at.chipkarte.client.sas.soap.Soap_sas_90SoapBindingStub _stub = new at.chipkarte.client.sas.soap.Soap_sas_90SoapBindingStub(new java.net.URL(Soap_sas_90_address), this);
                _stub.setPortName(getSoap_sas_90WSDDServiceName());
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
        if ("soap_sas_9.0".equals(inputPortName)) {
            return getSoap_sas_90();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "soap_sas_9.0");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "soap_sas_9.0"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Soap_sas_90".equals(portName)) {
            setSoap_sas_90EndpointAddress(address);
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
