/**
 * Zusatzinformation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class Zusatzinformation  implements java.io.Serializable {
    private java.lang.String svtCode;

    private long zusatzinformationsAntwortId;

    private java.lang.String zusatzinformationsText;

    public Zusatzinformation() {
    }

    public Zusatzinformation(
           java.lang.String svtCode,
           long zusatzinformationsAntwortId,
           java.lang.String zusatzinformationsText) {
           this.svtCode = svtCode;
           this.zusatzinformationsAntwortId = zusatzinformationsAntwortId;
           this.zusatzinformationsText = zusatzinformationsText;
    }


    /**
     * Gets the svtCode value for this Zusatzinformation.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this Zusatzinformation.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }


    /**
     * Gets the zusatzinformationsAntwortId value for this Zusatzinformation.
     * 
     * @return zusatzinformationsAntwortId
     */
    public long getZusatzinformationsAntwortId() {
        return zusatzinformationsAntwortId;
    }


    /**
     * Sets the zusatzinformationsAntwortId value for this Zusatzinformation.
     * 
     * @param zusatzinformationsAntwortId
     */
    public void setZusatzinformationsAntwortId(long zusatzinformationsAntwortId) {
        this.zusatzinformationsAntwortId = zusatzinformationsAntwortId;
    }


    /**
     * Gets the zusatzinformationsText value for this Zusatzinformation.
     * 
     * @return zusatzinformationsText
     */
    public java.lang.String getZusatzinformationsText() {
        return zusatzinformationsText;
    }


    /**
     * Sets the zusatzinformationsText value for this Zusatzinformation.
     * 
     * @param zusatzinformationsText
     */
    public void setZusatzinformationsText(java.lang.String zusatzinformationsText) {
        this.zusatzinformationsText = zusatzinformationsText;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Zusatzinformation)) return false;
        Zusatzinformation other = (Zusatzinformation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.svtCode==null && other.getSvtCode()==null) || 
             (this.svtCode!=null &&
              this.svtCode.equals(other.getSvtCode()))) &&
            this.zusatzinformationsAntwortId == other.getZusatzinformationsAntwortId() &&
            ((this.zusatzinformationsText==null && other.getZusatzinformationsText()==null) || 
             (this.zusatzinformationsText!=null &&
              this.zusatzinformationsText.equals(other.getZusatzinformationsText())));
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
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        _hashCode += new Long(getZusatzinformationsAntwortId()).hashCode();
        if (getZusatzinformationsText() != null) {
            _hashCode += getZusatzinformationsText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Zusatzinformation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Zusatzinformation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svtCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zusatzinformationsAntwortId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "zusatzinformationsAntwortId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zusatzinformationsText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "zusatzinformationsText"));
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
