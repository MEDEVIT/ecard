/**
 * ServiceStatusInformation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class ServiceStatusInformation  implements java.io.Serializable {
    private java.lang.String hinweisAktion;

    private java.lang.String hinweisZusatz;

    private boolean modus;

    private java.lang.String modusText;

    private java.lang.String serviceName;

    public ServiceStatusInformation() {
    }

    public ServiceStatusInformation(
           java.lang.String hinweisAktion,
           java.lang.String hinweisZusatz,
           boolean modus,
           java.lang.String modusText,
           java.lang.String serviceName) {
           this.hinweisAktion = hinweisAktion;
           this.hinweisZusatz = hinweisZusatz;
           this.modus = modus;
           this.modusText = modusText;
           this.serviceName = serviceName;
    }


    /**
     * Gets the hinweisAktion value for this ServiceStatusInformation.
     * 
     * @return hinweisAktion
     */
    public java.lang.String getHinweisAktion() {
        return hinweisAktion;
    }


    /**
     * Sets the hinweisAktion value for this ServiceStatusInformation.
     * 
     * @param hinweisAktion
     */
    public void setHinweisAktion(java.lang.String hinweisAktion) {
        this.hinweisAktion = hinweisAktion;
    }


    /**
     * Gets the hinweisZusatz value for this ServiceStatusInformation.
     * 
     * @return hinweisZusatz
     */
    public java.lang.String getHinweisZusatz() {
        return hinweisZusatz;
    }


    /**
     * Sets the hinweisZusatz value for this ServiceStatusInformation.
     * 
     * @param hinweisZusatz
     */
    public void setHinweisZusatz(java.lang.String hinweisZusatz) {
        this.hinweisZusatz = hinweisZusatz;
    }


    /**
     * Gets the modus value for this ServiceStatusInformation.
     * 
     * @return modus
     */
    public boolean isModus() {
        return modus;
    }


    /**
     * Sets the modus value for this ServiceStatusInformation.
     * 
     * @param modus
     */
    public void setModus(boolean modus) {
        this.modus = modus;
    }


    /**
     * Gets the modusText value for this ServiceStatusInformation.
     * 
     * @return modusText
     */
    public java.lang.String getModusText() {
        return modusText;
    }


    /**
     * Sets the modusText value for this ServiceStatusInformation.
     * 
     * @param modusText
     */
    public void setModusText(java.lang.String modusText) {
        this.modusText = modusText;
    }


    /**
     * Gets the serviceName value for this ServiceStatusInformation.
     * 
     * @return serviceName
     */
    public java.lang.String getServiceName() {
        return serviceName;
    }


    /**
     * Sets the serviceName value for this ServiceStatusInformation.
     * 
     * @param serviceName
     */
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceStatusInformation)) return false;
        ServiceStatusInformation other = (ServiceStatusInformation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hinweisAktion==null && other.getHinweisAktion()==null) || 
             (this.hinweisAktion!=null &&
              this.hinweisAktion.equals(other.getHinweisAktion()))) &&
            ((this.hinweisZusatz==null && other.getHinweisZusatz()==null) || 
             (this.hinweisZusatz!=null &&
              this.hinweisZusatz.equals(other.getHinweisZusatz()))) &&
            this.modus == other.isModus() &&
            ((this.modusText==null && other.getModusText()==null) || 
             (this.modusText!=null &&
              this.modusText.equals(other.getModusText()))) &&
            ((this.serviceName==null && other.getServiceName()==null) || 
             (this.serviceName!=null &&
              this.serviceName.equals(other.getServiceName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHinweisAktion() != null) {
            _hashCode += getHinweisAktion().hashCode();
        }
        if (getHinweisZusatz() != null) {
            _hashCode += getHinweisZusatz().hashCode();
        }
        _hashCode += (isModus() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getModusText() != null) {
            _hashCode += getModusText().hashCode();
        }
        if (getServiceName() != null) {
            _hashCode += getServiceName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceStatusInformation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ServiceStatusInformation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hinweisAktion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "hinweisAktion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hinweisZusatz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "hinweisZusatz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "modus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modusText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "modusText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "serviceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
