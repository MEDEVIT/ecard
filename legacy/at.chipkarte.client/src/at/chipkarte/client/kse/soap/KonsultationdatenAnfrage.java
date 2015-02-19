/**
 * KonsultationdatenAnfrage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class KonsultationdatenAnfrage  implements java.io.Serializable {
    private java.lang.String anfrageId;

    private at.chipkarte.client.kse.soap.SuchFilter filter;

    private int status;

    private java.lang.String timestamp;

    public KonsultationdatenAnfrage() {
    }

    public KonsultationdatenAnfrage(
           java.lang.String anfrageId,
           at.chipkarte.client.kse.soap.SuchFilter filter,
           int status,
           java.lang.String timestamp) {
           this.anfrageId = anfrageId;
           this.filter = filter;
           this.status = status;
           this.timestamp = timestamp;
    }


    /**
     * Gets the anfrageId value for this KonsultationdatenAnfrage.
     * 
     * @return anfrageId
     */
    public java.lang.String getAnfrageId() {
        return anfrageId;
    }


    /**
     * Sets the anfrageId value for this KonsultationdatenAnfrage.
     * 
     * @param anfrageId
     */
    public void setAnfrageId(java.lang.String anfrageId) {
        this.anfrageId = anfrageId;
    }


    /**
     * Gets the filter value for this KonsultationdatenAnfrage.
     * 
     * @return filter
     */
    public at.chipkarte.client.kse.soap.SuchFilter getFilter() {
        return filter;
    }


    /**
     * Sets the filter value for this KonsultationdatenAnfrage.
     * 
     * @param filter
     */
    public void setFilter(at.chipkarte.client.kse.soap.SuchFilter filter) {
        this.filter = filter;
    }


    /**
     * Gets the status value for this KonsultationdatenAnfrage.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this KonsultationdatenAnfrage.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the timestamp value for this KonsultationdatenAnfrage.
     * 
     * @return timestamp
     */
    public java.lang.String getTimestamp() {
        return timestamp;
    }


    /**
     * Sets the timestamp value for this KonsultationdatenAnfrage.
     * 
     * @param timestamp
     */
    public void setTimestamp(java.lang.String timestamp) {
        this.timestamp = timestamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KonsultationdatenAnfrage)) return false;
        KonsultationdatenAnfrage other = (KonsultationdatenAnfrage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anfrageId==null && other.getAnfrageId()==null) || 
             (this.anfrageId!=null &&
              this.anfrageId.equals(other.getAnfrageId()))) &&
            ((this.filter==null && other.getFilter()==null) || 
             (this.filter!=null &&
              this.filter.equals(other.getFilter()))) &&
            this.status == other.getStatus() &&
            ((this.timestamp==null && other.getTimestamp()==null) || 
             (this.timestamp!=null &&
              this.timestamp.equals(other.getTimestamp())));
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
        if (getAnfrageId() != null) {
            _hashCode += getAnfrageId().hashCode();
        }
        if (getFilter() != null) {
            _hashCode += getFilter().hashCode();
        }
        _hashCode += getStatus();
        if (getTimestamp() != null) {
            _hashCode += getTimestamp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KonsultationdatenAnfrage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationdatenAnfrage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anfrageId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "anfrageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "filter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "SuchFilter"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "timestamp"));
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
