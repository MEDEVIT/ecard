/**
 * GinaInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class GinaInfo  implements java.io.Serializable {
    private java.lang.String dnsName;

    private java.lang.String ipAdresse;

    private java.lang.String produktVersion;

    public GinaInfo() {
    }

    public GinaInfo(
           java.lang.String dnsName,
           java.lang.String ipAdresse,
           java.lang.String produktVersion) {
           this.dnsName = dnsName;
           this.ipAdresse = ipAdresse;
           this.produktVersion = produktVersion;
    }


    /**
     * Gets the dnsName value for this GinaInfo.
     * 
     * @return dnsName
     */
    public java.lang.String getDnsName() {
        return dnsName;
    }


    /**
     * Sets the dnsName value for this GinaInfo.
     * 
     * @param dnsName
     */
    public void setDnsName(java.lang.String dnsName) {
        this.dnsName = dnsName;
    }


    /**
     * Gets the ipAdresse value for this GinaInfo.
     * 
     * @return ipAdresse
     */
    public java.lang.String getIpAdresse() {
        return ipAdresse;
    }


    /**
     * Sets the ipAdresse value for this GinaInfo.
     * 
     * @param ipAdresse
     */
    public void setIpAdresse(java.lang.String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }


    /**
     * Gets the produktVersion value for this GinaInfo.
     * 
     * @return produktVersion
     */
    public java.lang.String getProduktVersion() {
        return produktVersion;
    }


    /**
     * Sets the produktVersion value for this GinaInfo.
     * 
     * @param produktVersion
     */
    public void setProduktVersion(java.lang.String produktVersion) {
        this.produktVersion = produktVersion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GinaInfo)) return false;
        GinaInfo other = (GinaInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dnsName==null && other.getDnsName()==null) || 
             (this.dnsName!=null &&
              this.dnsName.equals(other.getDnsName()))) &&
            ((this.ipAdresse==null && other.getIpAdresse()==null) || 
             (this.ipAdresse!=null &&
              this.ipAdresse.equals(other.getIpAdresse()))) &&
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
        if (getDnsName() != null) {
            _hashCode += getDnsName().hashCode();
        }
        if (getIpAdresse() != null) {
            _hashCode += getIpAdresse().hashCode();
        }
        if (getProduktVersion() != null) {
            _hashCode += getProduktVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GinaInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "GinaInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dnsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "dnsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipAdresse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ipAdresse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produktVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "produktVersion"));
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
