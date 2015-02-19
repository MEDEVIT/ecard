/**
 * LimitKonfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class LimitKonfig  implements java.io.Serializable {
    private java.lang.String datumBis;

    private java.lang.String datumVon;

    private java.lang.String limitCode;

    private java.lang.String limitType;

    private int limitValue;

    private int limitValuePercent;

    private java.lang.String valueType;

    public LimitKonfig() {
    }

    public LimitKonfig(
           java.lang.String datumBis,
           java.lang.String datumVon,
           java.lang.String limitCode,
           java.lang.String limitType,
           int limitValue,
           int limitValuePercent,
           java.lang.String valueType) {
           this.datumBis = datumBis;
           this.datumVon = datumVon;
           this.limitCode = limitCode;
           this.limitType = limitType;
           this.limitValue = limitValue;
           this.limitValuePercent = limitValuePercent;
           this.valueType = valueType;
    }


    /**
     * Gets the datumBis value for this LimitKonfig.
     * 
     * @return datumBis
     */
    public java.lang.String getDatumBis() {
        return datumBis;
    }


    /**
     * Sets the datumBis value for this LimitKonfig.
     * 
     * @param datumBis
     */
    public void setDatumBis(java.lang.String datumBis) {
        this.datumBis = datumBis;
    }


    /**
     * Gets the datumVon value for this LimitKonfig.
     * 
     * @return datumVon
     */
    public java.lang.String getDatumVon() {
        return datumVon;
    }


    /**
     * Sets the datumVon value for this LimitKonfig.
     * 
     * @param datumVon
     */
    public void setDatumVon(java.lang.String datumVon) {
        this.datumVon = datumVon;
    }


    /**
     * Gets the limitCode value for this LimitKonfig.
     * 
     * @return limitCode
     */
    public java.lang.String getLimitCode() {
        return limitCode;
    }


    /**
     * Sets the limitCode value for this LimitKonfig.
     * 
     * @param limitCode
     */
    public void setLimitCode(java.lang.String limitCode) {
        this.limitCode = limitCode;
    }


    /**
     * Gets the limitType value for this LimitKonfig.
     * 
     * @return limitType
     */
    public java.lang.String getLimitType() {
        return limitType;
    }


    /**
     * Sets the limitType value for this LimitKonfig.
     * 
     * @param limitType
     */
    public void setLimitType(java.lang.String limitType) {
        this.limitType = limitType;
    }


    /**
     * Gets the limitValue value for this LimitKonfig.
     * 
     * @return limitValue
     */
    public int getLimitValue() {
        return limitValue;
    }


    /**
     * Sets the limitValue value for this LimitKonfig.
     * 
     * @param limitValue
     */
    public void setLimitValue(int limitValue) {
        this.limitValue = limitValue;
    }


    /**
     * Gets the limitValuePercent value for this LimitKonfig.
     * 
     * @return limitValuePercent
     */
    public int getLimitValuePercent() {
        return limitValuePercent;
    }


    /**
     * Sets the limitValuePercent value for this LimitKonfig.
     * 
     * @param limitValuePercent
     */
    public void setLimitValuePercent(int limitValuePercent) {
        this.limitValuePercent = limitValuePercent;
    }


    /**
     * Gets the valueType value for this LimitKonfig.
     * 
     * @return valueType
     */
    public java.lang.String getValueType() {
        return valueType;
    }


    /**
     * Sets the valueType value for this LimitKonfig.
     * 
     * @param valueType
     */
    public void setValueType(java.lang.String valueType) {
        this.valueType = valueType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LimitKonfig)) return false;
        LimitKonfig other = (LimitKonfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datumBis==null && other.getDatumBis()==null) || 
             (this.datumBis!=null &&
              this.datumBis.equals(other.getDatumBis()))) &&
            ((this.datumVon==null && other.getDatumVon()==null) || 
             (this.datumVon!=null &&
              this.datumVon.equals(other.getDatumVon()))) &&
            ((this.limitCode==null && other.getLimitCode()==null) || 
             (this.limitCode!=null &&
              this.limitCode.equals(other.getLimitCode()))) &&
            ((this.limitType==null && other.getLimitType()==null) || 
             (this.limitType!=null &&
              this.limitType.equals(other.getLimitType()))) &&
            this.limitValue == other.getLimitValue() &&
            this.limitValuePercent == other.getLimitValuePercent() &&
            ((this.valueType==null && other.getValueType()==null) || 
             (this.valueType!=null &&
              this.valueType.equals(other.getValueType())));
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
        if (getDatumBis() != null) {
            _hashCode += getDatumBis().hashCode();
        }
        if (getDatumVon() != null) {
            _hashCode += getDatumVon().hashCode();
        }
        if (getLimitCode() != null) {
            _hashCode += getLimitCode().hashCode();
        }
        if (getLimitType() != null) {
            _hashCode += getLimitType().hashCode();
        }
        _hashCode += getLimitValue();
        _hashCode += getLimitValuePercent();
        if (getValueType() != null) {
            _hashCode += getValueType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LimitKonfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "LimitKonfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datumBis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "datumBis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datumVon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "datumVon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitValuePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "limitValuePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "valueType"));
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
