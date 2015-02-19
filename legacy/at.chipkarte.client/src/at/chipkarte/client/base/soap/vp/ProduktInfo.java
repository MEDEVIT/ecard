/**
 * ProduktInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap.vp;

public class ProduktInfo  implements java.io.Serializable {
    private int produktId;

    private java.lang.String produktVersion;

    public ProduktInfo() {
    }

    public ProduktInfo(
           int produktId,
           java.lang.String produktVersion) {
           this.produktId = produktId;
           this.produktVersion = produktVersion;
    }


    /**
     * Gets the produktId value for this ProduktInfo.
     * 
     * @return produktId
     */
    public int getProduktId() {
        return produktId;
    }


    /**
     * Sets the produktId value for this ProduktInfo.
     * 
     * @param produktId
     */
    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }


    /**
     * Gets the produktVersion value for this ProduktInfo.
     * 
     * @return produktVersion
     */
    public java.lang.String getProduktVersion() {
        return produktVersion;
    }


    /**
     * Sets the produktVersion value for this ProduktInfo.
     * 
     * @param produktVersion
     */
    public void setProduktVersion(java.lang.String produktVersion) {
        this.produktVersion = produktVersion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProduktInfo)) return false;
        ProduktInfo other = (ProduktInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.produktId == other.getProduktId() &&
            ((this.produktVersion==null && other.getProduktVersion()==null) || 
             (this.produktVersion!=null &&
              this.produktVersion.equals(other.getProduktVersion())));
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
        _hashCode += getProduktId();
        if (getProduktVersion() != null) {
            _hashCode += getProduktVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProduktInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vp.soap.base.client.chipkarte.at", "ProduktInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produktId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://vp.soap.base.client.chipkarte.at", "produktId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produktVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://vp.soap.base.client.chipkarte.at", "produktVersion"));
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
