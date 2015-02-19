/**
 * Soap_kse_110SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class Soap_kse_110SoapBindingStub extends org.apache.axis.client.Stub implements at.chipkarte.client.kse.soap.IKseService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[24];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Property"));
        oper.setReturnClass(at.chipkarte.client.base.soap.Property[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "checkStatusReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLimit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "zeitraum"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Limit"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.Limit[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getLimitReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doKonsultation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svtCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "anspruchId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietsCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsfallCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nacherfassungsgrundCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsdatum"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "forceExecution"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ErgebnisKonsultation"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.ErgebnisKonsultation.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "doKonsultationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.base.soap.exceptions.CardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault5"),
                      "at.chipkarte.client.base.soap.exceptions.BCardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "BCardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendZusatzinformationsAntwort");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "zusatzinformationsAntwortId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "zusatzinformationsAntwort"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doKonsultationOffline");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svtCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietsCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsfallCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nacherfassungsgrundCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsdatum"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "forceExecution"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineRecord"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.OfflineRecord.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "doKonsultationOfflineReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.base.soap.exceptions.CardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("stornierenKonsultation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsVersion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.KonsultationsBeleg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "stornierenKonsultationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wiederinkraftsetzenKonsultation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsVersion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ErgebnisKonsultation"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.ErgebnisKonsultation.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "wiederinkraftsetzenKonsultationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aendernKonsultation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsVersion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsfallCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.KonsultationsBeleg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "aendernKonsultationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getKonsultationsdaten");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "selektionsKriterien"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "SuchFilter"), at.chipkarte.client.kse.soap.SuchFilter.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "selektionsart"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Konsultationsdaten"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.Konsultationsdaten[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getKonsultationsdatenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendKonsultationsdatenAnfrage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "selektionsKriterien"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "SuchFilter"), at.chipkarte.client.kse.soap.SuchFilter.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendKonsultationsdatenAnfrageReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("downloadKonsultationsdaten");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "anfrageId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Konsultationsdaten"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.Konsultationsdaten[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "downloadKonsultationsdatenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getKonsultationsdatenAnfragen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "onlyReady"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationdatenAnfrage"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.KonsultationdatenAnfrage[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getKonsultationsdatenAnfragenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteKonsultationsdatenAnfrage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "anfrageId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nachsignierenKonsultationen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "forceExecution"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.KonsultationsBeleg[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignierenKonsultationenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.base.soap.exceptions.CardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nachsignierenKonsultationenBCard");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svNummer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.KonsultationsBeleg[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignierenKonsultationenBCardReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.base.soap.exceptions.CardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault5"),
                      "at.chipkarte.client.base.soap.exceptions.BCardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "BCardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nachsignierenKonsultationenOffline");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "forceExecution"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "cardReaderId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineRecord"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.OfflineRecord.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignierenKonsultationenOfflineReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault4"),
                      "at.chipkarte.client.base.soap.exceptions.CardException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBehandlungsfaelle");
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "BaseProperty"));
        oper.setReturnClass(at.chipkarte.client.base.soap.BaseProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getBehandlungsfaelleReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBehandlungsfaelleByFachgebiet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "BaseProperty"));
        oper.setReturnClass(at.chipkarte.client.base.soap.BaseProperty[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getBehandlungsfaelleByFachgebietReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOfflineRecords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineRecord"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.OfflineRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getOfflineRecordsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getNumberOfflineKonsultationen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getNumberOfflineKonsultationenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getNumberOfflineNachsignaturen");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getNumberOfflineNachsignaturenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteOfflineRecord");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "offlineId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendOfflineKonsultation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "offlineId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietsCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsfallCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svtCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "anspruchId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ErgebnisKonsultation"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.ErgebnisKonsultation.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendOfflineKonsultationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendOfflineNachsignatur");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "dialogId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "offlineId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        oper.setReturnClass(at.chipkarte.client.kse.soap.KonsultationsBeleg[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendOfflineNachsignaturReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault3"),
                      "at.chipkarte.client.kse.soap.exceptions.InvalidParameterException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault2"),
                      "at.chipkarte.client.base.soap.exceptions.AccessException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "AccessException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault6"),
                      "at.chipkarte.client.kse.soap.exceptions.KseException",
                      new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault"),
                      "at.chipkarte.client.base.soap.exceptions.ServiceException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "ServiceException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fault1"),
                      "at.chipkarte.client.base.soap.exceptions.DialogException",
                      new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "DialogException"), 
                      true
                     ));
        _operations[23] = oper;

    }

    public Soap_kse_110SoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Soap_kse_110SoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Soap_kse_110SoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "BCardException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.BCardException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.base.client.chipkarte.at", "CardException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.exceptions.CardException.class;
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

            qName = new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "InvalidParameterException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.exceptions.InvalidParameterException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.exceptions.KseException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "BaseProperty");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.BaseProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Property");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.Property.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "SvPerson");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.base.soap.SvPerson.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Anspruch");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.Anspruch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ErgebnisKonsultation");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.ErgebnisKonsultation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationdatenAnfrage");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.KonsultationdatenAnfrage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.KonsultationsBeleg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Konsultationsdaten");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.Konsultationsdaten.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Limit");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.Limit.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "LimitKonfig");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.LimitKonfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "LimitValue");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.LimitValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineKonsultation");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.OfflineKonsultation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineRecord");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.OfflineRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "SuchFilter");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.SuchFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Zusatzinformation");
            cachedSerQNames.add(qName);
            cls = at.chipkarte.client.kse.soap.Zusatzinformation.class;
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "checkStatus"));

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

    public at.chipkarte.client.kse.soap.Limit[] getLimit(java.lang.String dialogId, int zeitraum) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getLimit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, new java.lang.Integer(zeitraum)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.Limit[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.Limit[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.Limit[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.ErgebnisKonsultation doKonsultation(java.lang.String cin, java.lang.String dialogId, java.lang.String svNummer, java.lang.String svtCode, java.lang.String anspruchId, java.lang.String fachgebietsCode, java.lang.String behandlungsfallCode, java.lang.String nacherfassungsgrundCode, java.lang.String behandlungsdatum, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.BCardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "doKonsultation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cin, dialogId, svNummer, svtCode, anspruchId, fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode, behandlungsdatum, new java.lang.Boolean(forceExecution), cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.ErgebnisKonsultation) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.ErgebnisKonsultation) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.ErgebnisKonsultation.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardException) {
              throw (at.chipkarte.client.base.soap.exceptions.CardException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.BCardException) {
              throw (at.chipkarte.client.base.soap.exceptions.BCardException) axisFaultException.detail;
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

    public void sendZusatzinformationsAntwort(java.lang.String dialogId, long zusatzinformationsAntwortId, int zusatzinformationsAntwort) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.DialogException, at.chipkarte.client.base.soap.exceptions.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendZusatzinformationsAntwort"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, new java.lang.Long(zusatzinformationsAntwortId), new java.lang.Integer(zusatzinformationsAntwort)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.OfflineRecord doKonsultationOffline(java.lang.String cin, java.lang.String dialogId, java.lang.String svNummer, java.lang.String svtCode, java.lang.String fachgebietsCode, java.lang.String behandlungsfallCode, java.lang.String nacherfassungsgrundCode, java.lang.String behandlungsdatum, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "doKonsultationOffline"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cin, dialogId, svNummer, svtCode, fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode, behandlungsdatum, new java.lang.Boolean(forceExecution), cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.OfflineRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.OfflineRecord) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.OfflineRecord.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardException) {
              throw (at.chipkarte.client.base.soap.exceptions.CardException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.KonsultationsBeleg stornierenKonsultation(java.lang.String dialogId, long konsId, int konsVersion) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "stornierenKonsultation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, new java.lang.Long(konsId), new java.lang.Integer(konsVersion)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.KonsultationsBeleg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.ErgebnisKonsultation wiederinkraftsetzenKonsultation(java.lang.String dialogId, long konsId, int konsVersion) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "wiederinkraftsetzenKonsultation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, new java.lang.Long(konsId), new java.lang.Integer(konsVersion)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.ErgebnisKonsultation) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.ErgebnisKonsultation) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.ErgebnisKonsultation.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.KonsultationsBeleg aendernKonsultation(java.lang.String dialogId, long konsId, int konsVersion, java.lang.String behandlungsfallCode) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "aendernKonsultation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, new java.lang.Long(konsId), new java.lang.Integer(konsVersion), behandlungsfallCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.KonsultationsBeleg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.Konsultationsdaten[] getKonsultationsdaten(java.lang.String dialogId, at.chipkarte.client.kse.soap.SuchFilter selektionsKriterien, java.lang.String selektionsart) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getKonsultationsdaten"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, selektionsKriterien, selektionsart});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.Konsultationsdaten[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.Konsultationsdaten[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.Konsultationsdaten[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public java.lang.String sendKonsultationsdatenAnfrage(java.lang.String dialogId, at.chipkarte.client.kse.soap.SuchFilter selektionsKriterien) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendKonsultationsdatenAnfrage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, selektionsKriterien});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.Konsultationsdaten[] downloadKonsultationsdaten(java.lang.String dialogId, java.lang.String anfrageId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "downloadKonsultationsdaten"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, anfrageId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.Konsultationsdaten[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.Konsultationsdaten[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.Konsultationsdaten[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.KonsultationdatenAnfrage[] getKonsultationsdatenAnfragen(java.lang.String dialogId, boolean onlyReady) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getKonsultationsdatenAnfragen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, new java.lang.Boolean(onlyReady)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.KonsultationdatenAnfrage[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.KonsultationdatenAnfrage[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.KonsultationdatenAnfrage[].class);
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

    public void deleteKonsultationsdatenAnfrage(java.lang.String dialogId, java.lang.String anfrageId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "deleteKonsultationsdatenAnfrage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, anfrageId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignierenKonsultationen(java.lang.String dialogId, java.lang.String cin, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignierenKonsultationen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, cin, new java.lang.Boolean(forceExecution), cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.KonsultationsBeleg[].class);
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
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardException) {
              throw (at.chipkarte.client.base.soap.exceptions.CardException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignierenKonsultationenBCard(java.lang.String dialogId, java.lang.String svNummer, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.BCardException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignierenKonsultationenBCard"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, svNummer, cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.KonsultationsBeleg[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardException) {
              throw (at.chipkarte.client.base.soap.exceptions.CardException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.BCardException) {
              throw (at.chipkarte.client.base.soap.exceptions.BCardException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.OfflineRecord nachsignierenKonsultationenOffline(java.lang.String dialogId, java.lang.String cin, boolean forceExecution, java.lang.String cardReaderId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.base.soap.exceptions.CardException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignierenKonsultationenOffline"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, cin, new java.lang.Boolean(forceExecution), cardReaderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.OfflineRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.OfflineRecord) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.OfflineRecord.class);
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
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.CardException) {
              throw (at.chipkarte.client.base.soap.exceptions.CardException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.base.soap.BaseProperty[] getBehandlungsfaelle() throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getBehandlungsfaelle"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.BaseProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.BaseProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.BaseProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceException) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.base.soap.BaseProperty[] getBehandlungsfaelleByFachgebiet(java.lang.String fachgebietCode) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getBehandlungsfaelleByFachgebiet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {fachgebietCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.base.soap.BaseProperty[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.base.soap.BaseProperty[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.base.soap.BaseProperty[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.ServiceException) {
              throw (at.chipkarte.client.base.soap.exceptions.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public at.chipkarte.client.kse.soap.OfflineRecord[] getOfflineRecords(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getOfflineRecords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.OfflineRecord[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.OfflineRecord[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.OfflineRecord[].class);
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
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public long getNumberOfflineKonsultationen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getNumberOfflineKonsultationen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
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
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public long getNumberOfflineNachsignaturen(java.lang.String dialogId) throws java.rmi.RemoteException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "getNumberOfflineNachsignaturen"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
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
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public void deleteOfflineRecord(java.lang.String dialogId, java.lang.String offlineId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "deleteOfflineRecord"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, offlineId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.ErgebnisKonsultation sendOfflineKonsultation(java.lang.String dialogId, java.lang.String offlineId, java.lang.String fachgebietsCode, java.lang.String behandlungsfallCode, java.lang.String svtCode, java.lang.String anspruchId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendOfflineKonsultation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, offlineId, fachgebietsCode, behandlungsfallCode, svtCode, anspruchId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.ErgebnisKonsultation) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.ErgebnisKonsultation) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.ErgebnisKonsultation.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

    public at.chipkarte.client.kse.soap.KonsultationsBeleg[] sendOfflineNachsignatur(java.lang.String dialogId, java.lang.String offlineId) throws java.rmi.RemoteException, at.chipkarte.client.kse.soap.exceptions.InvalidParameterException, at.chipkarte.client.base.soap.exceptions.AccessException, at.chipkarte.client.kse.soap.exceptions.KseException, at.chipkarte.client.base.soap.exceptions.ServiceException, at.chipkarte.client.base.soap.exceptions.DialogException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "sendOfflineNachsignatur"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dialogId, offlineId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (at.chipkarte.client.kse.soap.KonsultationsBeleg[]) org.apache.axis.utils.JavaUtils.convert(_resp, at.chipkarte.client.kse.soap.KonsultationsBeleg[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) {
              throw (at.chipkarte.client.kse.soap.exceptions.InvalidParameterException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.base.soap.exceptions.AccessException) {
              throw (at.chipkarte.client.base.soap.exceptions.AccessException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof at.chipkarte.client.kse.soap.exceptions.KseException) {
              throw (at.chipkarte.client.kse.soap.exceptions.KseException) axisFaultException.detail;
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

}
