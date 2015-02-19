/**
 * Service_V3_0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.soap;

public class Service_V3_0  implements java.io.Serializable {
    private java.lang.String description;

    private java.lang.String endPointURL;

    private int mainVersionNumber;

    private java.lang.String name;

    private int subVersionNumber;

    private java.lang.String type;

    public Service_V3_0() {
    }

    public Service_V3_0(
           java.lang.String description,
           java.lang.String endPointURL,
           int mainVersionNumber,
           java.lang.String name,
           int subVersionNumber,
           java.lang.String type) {
           this.description = description;
           this.endPointURL = endPointURL;
           this.mainVersionNumber = mainVersionNumber;
           this.name = name;
           this.subVersionNumber = subVersionNumber;
           this.type = type;
    }


    /**
     * Gets the description value for this Service_V3_0.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Service_V3_0.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the endPointURL value for this Service_V3_0.
     * 
     * @return endPointURL
     */
    public java.lang.String getEndPointURL() {
        return endPointURL;
    }


    /**
     * Sets the endPointURL value for this Service_V3_0.
     * 
     * @param endPointURL
     */
    public void setEndPointURL(java.lang.String endPointURL) {
        this.endPointURL = endPointURL;
    }


    /**
     * Gets the mainVersionNumber value for this Service_V3_0.
     * 
     * @return mainVersionNumber
     */
    public int getMainVersionNumber() {
        return mainVersionNumber;
    }


    /**
     * Sets the mainVersionNumber value for this Service_V3_0.
     * 
     * @param mainVersionNumber
     */
    public void setMainVersionNumber(int mainVersionNumber) {
        this.mainVersionNumber = mainVersionNumber;
    }


    /**
     * Gets the name value for this Service_V3_0.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Service_V3_0.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the subVersionNumber value for this Service_V3_0.
     * 
     * @return subVersionNumber
     */
    public int getSubVersionNumber() {
        return subVersionNumber;
    }


    /**
     * Sets the subVersionNumber value for this Service_V3_0.
     * 
     * @param subVersionNumber
     */
    public void setSubVersionNumber(int subVersionNumber) {
        this.subVersionNumber = subVersionNumber;
    }


    /**
     * Gets the type value for this Service_V3_0.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Service_V3_0.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Service_V3_0)) return false;
        Service_V3_0 other = (Service_V3_0) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.endPointURL==null && other.getEndPointURL()==null) || 
             (this.endPointURL!=null &&
              this.endPointURL.equals(other.getEndPointURL()))) &&
            this.mainVersionNumber == other.getMainVersionNumber() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.subVersionNumber == other.getSubVersionNumber() &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEndPointURL() != null) {
            _hashCode += getEndPointURL().hashCode();
        }
        _hashCode += getMainVersionNumber();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getSubVersionNumber();
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Service_V3_0.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "Service_V3_0"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endPointURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "endPointURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainVersionNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "mainVersionNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subVersionNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "subVersionNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.client.chipkarte.at", "type"));
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
