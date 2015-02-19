/**
 * Limit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class Limit  implements java.io.Serializable {
    private java.lang.String fachgebietsCode;

    private at.chipkarte.client.kse.soap.LimitKonfig[] limitConfig;

    private at.chipkarte.client.kse.soap.LimitValue[] limitValue;

    private java.lang.String svtCode;

    public Limit() {
    }

    public Limit(
           java.lang.String fachgebietsCode,
           at.chipkarte.client.kse.soap.LimitKonfig[] limitConfig,
           at.chipkarte.client.kse.soap.LimitValue[] limitValue,
           java.lang.String svtCode) {
           this.fachgebietsCode = fachgebietsCode;
           this.limitConfig = limitConfig;
           this.limitValue = limitValue;
           this.svtCode = svtCode;
    }


    /**
     * Gets the fachgebietsCode value for this Limit.
     * 
     * @return fachgebietsCode
     */
    public java.lang.String getFachgebietsCode() {
        return fachgebietsCode;
    }


    /**
     * Sets the fachgebietsCode value for this Limit.
     * 
     * @param fachgebietsCode
     */
    public void setFachgebietsCode(java.lang.String fachgebietsCode) {
        this.fachgebietsCode = fachgebietsCode;
    }


    /**
     * Gets the limitConfig value for this Limit.
     * 
     * @return limitConfig
     */
    public at.chipkarte.client.kse.soap.LimitKonfig[] getLimitConfig() {
        return limitConfig;
    }


    /**
     * Sets the limitConfig value for this Limit.
     * 
     * @param limitConfig
     */
    public void setLimitConfig(at.chipkarte.client.kse.soap.LimitKonfig[] limitConfig) {
        this.limitConfig = limitConfig;
    }

    public at.chipkarte.client.kse.soap.LimitKonfig getLimitConfig(int i) {
        return this.limitConfig[i];
    }

    public void setLimitConfig(int i, at.chipkarte.client.kse.soap.LimitKonfig _value) {
        this.limitConfig[i] = _value;
    }


    /**
     * Gets the limitValue value for this Limit.
     * 
     * @return limitValue
     */
    public at.chipkarte.client.kse.soap.LimitValue[] getLimitValue() {
        return limitValue;
    }


    /**
     * Sets the limitValue value for this Limit.
     * 
     * @param limitValue
     */
    public void setLimitValue(at.chipkarte.client.kse.soap.LimitValue[] limitValue) {
        this.limitValue = limitValue;
    }

    public at.chipkarte.client.kse.soap.LimitValue getLimitValue(int i) {
        return this.limitValue[i];
    }

    public void setLimitValue(int i, at.chipkarte.client.kse.soap.LimitValue _value) {
        this.limitValue[i] = _value;
    }


    /**
     * Gets the svtCode value for this Limit.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this Limit.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Limit)) return false;
        Limit other = (Limit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fachgebietsCode==null && other.getFachgebietsCode()==null) || 
             (this.fachgebietsCode!=null &&
              this.fachgebietsCode.equals(other.getFachgebietsCode()))) &&
            ((this.limitConfig==null && other.getLimitConfig()==null) || 
             (this.limitConfig!=null &&
              java.util.Arrays.equals(this.limitConfig, other.getLimitConfig()))) &&
            ((this.limitValue==null && other.getLimitValue()==null) || 
             (this.limitValue!=null &&
              java.util.Arrays.equals(this.limitValue, other.getLimitValue()))) &&
            ((this.svtCode==null && other.getSvtCode()==null) || 
             (this.svtCode!=null &&
              this.svtCode.equals(other.getSvtCode())));
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
        if (getFachgebietsCode() != null) {
            _hashCode += getFachgebietsCode().hashCode();
        }
        if (getLimitConfig() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLimitConfig());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLimitConfig(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLimitValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLimitValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLimitValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Limit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Limit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fachgebietsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "LimitKonfig"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "LimitValue"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svtCode"));
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
