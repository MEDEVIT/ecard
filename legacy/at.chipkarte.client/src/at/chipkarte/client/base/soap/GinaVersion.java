/**
 * GinaVersion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class GinaVersion  implements java.io.Serializable {
    private java.lang.String softwareVersion;

    private java.lang.String typ;

    public GinaVersion() {
    }

    public GinaVersion(
           java.lang.String softwareVersion,
           java.lang.String typ) {
           this.softwareVersion = softwareVersion;
           this.typ = typ;
    }


    /**
     * Gets the softwareVersion value for this GinaVersion.
     * 
     * @return softwareVersion
     */
    public java.lang.String getSoftwareVersion() {
        return softwareVersion;
    }


    /**
     * Sets the softwareVersion value for this GinaVersion.
     * 
     * @param softwareVersion
     */
    public void setSoftwareVersion(java.lang.String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }


    /**
     * Gets the typ value for this GinaVersion.
     * 
     * @return typ
     */
    public java.lang.String getTyp() {
        return typ;
    }


    /**
     * Sets the typ value for this GinaVersion.
     * 
     * @param typ
     */
    public void setTyp(java.lang.String typ) {
        this.typ = typ;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GinaVersion)) return false;
        GinaVersion other = (GinaVersion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.softwareVersion==null && other.getSoftwareVersion()==null) || 
             (this.softwareVersion!=null &&
              this.softwareVersion.equals(other.getSoftwareVersion()))) &&
            ((this.typ==null && other.getTyp()==null) || 
             (this.typ!=null &&
              this.typ.equals(other.getTyp())));
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
        if (getSoftwareVersion() != null) {
            _hashCode += getSoftwareVersion().hashCode();
        }
        if (getTyp() != null) {
            _hashCode += getTyp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GinaVersion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "GinaVersion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softwareVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "softwareVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "typ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
