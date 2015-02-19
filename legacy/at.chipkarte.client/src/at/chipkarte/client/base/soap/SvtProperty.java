/**
 * SvtProperty.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class SvtProperty  extends at.chipkarte.client.base.soap.BaseProperty  implements java.io.Serializable {
    private boolean ASVG;

    private java.lang.String EKVKCode;

    private java.lang.String EKVKName;

    private java.lang.String kurzbezeichnung;

    public SvtProperty() {
    }

    public SvtProperty(
           java.lang.String code,
           boolean nurAnzeige,
           java.lang.String text,
           boolean ASVG,
           java.lang.String EKVKCode,
           java.lang.String EKVKName,
           java.lang.String kurzbezeichnung) {
        super(
            code,
            nurAnzeige,
            text);
        this.ASVG = ASVG;
        this.EKVKCode = EKVKCode;
        this.EKVKName = EKVKName;
        this.kurzbezeichnung = kurzbezeichnung;
    }


    /**
     * Gets the ASVG value for this SvtProperty.
     * 
     * @return ASVG
     */
    public boolean isASVG() {
        return ASVG;
    }


    /**
     * Sets the ASVG value for this SvtProperty.
     * 
     * @param ASVG
     */
    public void setASVG(boolean ASVG) {
        this.ASVG = ASVG;
    }


    /**
     * Gets the EKVKCode value for this SvtProperty.
     * 
     * @return EKVKCode
     */
    public java.lang.String getEKVKCode() {
        return EKVKCode;
    }


    /**
     * Sets the EKVKCode value for this SvtProperty.
     * 
     * @param EKVKCode
     */
    public void setEKVKCode(java.lang.String EKVKCode) {
        this.EKVKCode = EKVKCode;
    }


    /**
     * Gets the EKVKName value for this SvtProperty.
     * 
     * @return EKVKName
     */
    public java.lang.String getEKVKName() {
        return EKVKName;
    }


    /**
     * Sets the EKVKName value for this SvtProperty.
     * 
     * @param EKVKName
     */
    public void setEKVKName(java.lang.String EKVKName) {
        this.EKVKName = EKVKName;
    }


    /**
     * Gets the kurzbezeichnung value for this SvtProperty.
     * 
     * @return kurzbezeichnung
     */
    public java.lang.String getKurzbezeichnung() {
        return kurzbezeichnung;
    }


    /**
     * Sets the kurzbezeichnung value for this SvtProperty.
     * 
     * @param kurzbezeichnung
     */
    public void setKurzbezeichnung(java.lang.String kurzbezeichnung) {
        this.kurzbezeichnung = kurzbezeichnung;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SvtProperty)) return false;
        SvtProperty other = (SvtProperty) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.ASVG == other.isASVG() &&
            ((this.EKVKCode==null && other.getEKVKCode()==null) || 
             (this.EKVKCode!=null &&
              this.EKVKCode.equals(other.getEKVKCode()))) &&
            ((this.EKVKName==null && other.getEKVKName()==null) || 
             (this.EKVKName!=null &&
              this.EKVKName.equals(other.getEKVKName()))) &&
            ((this.kurzbezeichnung==null && other.getKurzbezeichnung()==null) || 
             (this.kurzbezeichnung!=null &&
              this.kurzbezeichnung.equals(other.getKurzbezeichnung())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += (isASVG() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEKVKCode() != null) {
            _hashCode += getEKVKCode().hashCode();
        }
        if (getEKVKName() != null) {
            _hashCode += getEKVKName().hashCode();
        }
        if (getKurzbezeichnung() != null) {
            _hashCode += getKurzbezeichnung().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SvtProperty.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "SvtProperty"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASVG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ASVG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EKVKCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "EKVKCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EKVKName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "EKVKName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kurzbezeichnung");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "kurzbezeichnung"));
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
