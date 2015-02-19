/**
 * Soap_sas_90SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class Soap_sas_90SoapBindingStub extends org.apache.axis.client.Stub implements at.chipkarte.client.sas.soap.ISasService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[3];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Property"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Property[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "checkStatusReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("svNummerAbfragen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummerAbfragenSuchkriterien"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "Suchkriterien"), at.chipkarte.client.sas.soap.Suchkriterien.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "AbfrageErgebnis"));
        oper.setReturnClass(at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummerAbfragenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.sas.soap.exceptions.SasException",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "SasException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "InvalidParameterSuchkriterienException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("patientendatenAbfragen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "AbfrageErgebnis"));
        oper.setReturnClass(at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "patientendatenAbfragenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.sas.soap.exceptions.SasException",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "SasException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException",
                      new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "InvalidParameterSuchkriterienException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        _operations[2] = oper;

    }

    public Soap_sas_90SoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Soap_sas_90SoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Soap_sas_90SoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.AccessException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "BaseException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.BaseException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.DialogException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.ServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "InvalidParameterSuchkriterienException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.sas.client.chipkarte.at", "SasException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.exceptions.SasException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Property");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Property.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "AbfrageErgebnis");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.AbfrageErgebnis.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "Suchkriterien");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.sas.soap.Suchkriterien.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "checkStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.Property[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.Property[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.Property[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceException) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogException) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.sas.soap.AbfrageErgebnis svNummerAbfragen(java.lang.String dialogId, at.chipkarte.client.sas.soap.Suchkriterien svNummerAbfragenSuchkriterien) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.sas.soap.exceptions.SasException, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummerAbfragen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, svNummerAbfragenSuchkriterien});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.SasException) {
              throw (at.chipkarte.client.sas.soap.exceptions.SasException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException) {
              throw (at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceException) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogException) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.sas.soap.AbfrageErgebnis patientendatenAbfragen(java.lang.String dialogId, java.lang.String svNummer) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.sas.soap.exceptions.SasException, at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException, at.chipkarte.client.base.soap.exceptions.DialogException, at.chipkarte.client.base.soap.exceptions.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "patientendatenAbfragen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, svNummer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.sas.soap.AbfrageErgebnis) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.sas.soap.AbfrageErgebnis.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.SasException) {
              throw (at.chipkarte.client.sas.soap.exceptions.SasException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException) {
              throw (at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.DialogException) {
              throw (at.chipkarte.client.base.soap.exceptions.DialogException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceException) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
