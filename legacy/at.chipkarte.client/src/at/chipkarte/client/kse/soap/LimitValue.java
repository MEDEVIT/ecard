/**
 * LimitValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class LimitValue  implements java.io.Serializable {
    private java.lang.String limitCode;

    private long value;

    public LimitValue() {
    }

    public LimitValue(
           java.lang.String limitCode,
           long value) {
           this.limitCode = limitCode;
           this.value = value;
    }


    /**
     * Gets the limitCode value for this LimitValue.
     * 
     * @return limitCode
     */
    public java.lang.String getLimitCode() {
        return limitCode;
    }


    /**
     * Sets the limitCode value for this LimitValue.
     * 
     * @param limitCode
     */
    public void setLimitCode(java.lang.String limitCode) {
        this.limitCode = limitCode;
    }


    /**
     * Gets the value value for this LimitValue.
     * 
     * @return value
     */
    public long getValue() {
        return value;
    }


    /**
     * Sets the value value for this LimitValue.
     * 
     * @param value
     */
    public void setValue(long value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LimitValue)) return false;
        LimitValue other = (LimitValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.limitCode==null && other.getLimitCode()==null) || 
             (this.limitCode!=null &&
              this.limitCode.equals(other.getLimitCode()))) &&
            this.value == other.getValue();
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
        if (getLimitCode() != null) {
            _hashCode += getLimitCode().hashCode();
        }
        _hashCode += new Long(getValue()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LimitValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "LimitValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
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
