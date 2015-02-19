/**
 * KseException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap.exceptions;

/**
 * Exceptions, die im Zusammenhang mit Konsultationen vom e-card Serversystem geworfen werden. Fehlercodes siehe
 * {@link at.chipkarte.client.kse.soap.constants.KseExceptionConstants KseExceptionConstants}.
 */
public class KseException  extends at.chipkarte.client.base.soap.exceptions.BaseException  implements java.io.Serializable {
    private at.chipkarte.client.kse.soap.Anspruch[] anspruch;

    public KseException() {
    }

    public KseException(
           java.lang.String code,
           int errorCode,
           java.lang.String message1,
           at.chipkarte.client.kse.soap.Anspruch[] anspruch) {
        super(
            code,
            errorCode,
            message1);
        this.anspruch = anspruch;
    }


    /**
     * Gets the anspruch value for this KseException.
     * 
     * @return anspruch
     */
    public at.chipkarte.client.kse.soap.Anspruch[] getAnspruch() {
        return anspruch;
    }


    /**
     * Sets the anspruch value for this KseException.
     * 
     * @param anspruch
     */
    public void setAnspruch(at.chipkarte.client.kse.soap.Anspruch[] anspruch) {
        this.anspruch = anspruch;
    }

    public at.chipkarte.client.kse.soap.Anspruch getAnspruch(int i) {
        return this.anspruch[i];
    }

    public void setAnspruch(int i, at.chipkarte.client.kse.soap.Anspruch _value) {
        this.anspruch[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KseException)) return false;
        KseException other = (KseException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.anspruch==null && other.getAnspruch()==null) || 
             (this.anspruch!=null &&
              java.util.Arrays.equals(this.anspruch, other.getAnspruch())));
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
        if (getAnspruch() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnspruch());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnspruch(), i);
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
        new org.apache.axis.description.TypeDesc(KseException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "KseException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anspruch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://exceptions.soap.kse.client.chipkarte.at", "anspruch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Anspruch"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
