/**
 * ReaderStatusResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class ReaderStatusResult  implements java.io.Serializable {
    private java.lang.String handle;

    private at.chipkarte.client.base.soap.ReaderStatusEvent[] readerStatusEvents;

    public ReaderStatusResult() {
    }

    public ReaderStatusResult(
           java.lang.String handle,
           at.chipkarte.client.base.soap.ReaderStatusEvent[] readerStatusEvents) {
           this.handle = handle;
           this.readerStatusEvents = readerStatusEvents;
    }


    /**
     * Gets the handle value for this ReaderStatusResult.
     * 
     * @return handle
     */
    public java.lang.String getHandle() {
        return handle;
    }


    /**
     * Sets the handle value for this ReaderStatusResult.
     * 
     * @param handle
     */
    public void setHandle(java.lang.String handle) {
        this.handle = handle;
    }


    /**
     * Gets the readerStatusEvents value for this ReaderStatusResult.
     * 
     * @return readerStatusEvents
     */
    public at.chipkarte.client.base.soap.ReaderStatusEvent[] getReaderStatusEvents() {
        return readerStatusEvents;
    }


    /**
     * Sets the readerStatusEvents value for this ReaderStatusResult.
     * 
     * @param readerStatusEvents
     */
    public void setReaderStatusEvents(at.chipkarte.client.base.soap.ReaderStatusEvent[] readerStatusEvents) {
        this.readerStatusEvents = readerStatusEvents;
    }

    public at.chipkarte.client.base.soap.ReaderStatusEvent getReaderStatusEvents(int i) {
        return this.readerStatusEvents[i];
    }

    public void setReaderStatusEvents(int i, at.chipkarte.client.base.soap.ReaderStatusEvent _value) {
        this.readerStatusEvents[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReaderStatusResult)) return false;
        ReaderStatusResult other = (ReaderStatusResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.handle==null && other.getHandle()==null) || 
             (this.handle!=null &&
              this.handle.equals(other.getHandle()))) &&
            ((this.readerStatusEvents==null && other.getReaderStatusEvents()==null) || 
             (this.readerStatusEvents!=null &&
              java.util.Arrays.equals(this.readerStatusEvents, other.getReaderStatusEvents())));
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
        if (getHandle() != null) {
            _hashCode += getHandle().hashCode();
        }
        if (getReaderStatusEvents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReaderStatusEvents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReaderStatusEvents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReaderStatusResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ReaderStatusResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("handle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "handle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readerStatusEvents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "readerStatusEvents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ReaderStatusEvent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
