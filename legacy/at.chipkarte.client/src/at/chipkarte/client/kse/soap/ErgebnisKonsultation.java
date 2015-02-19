/**
 * ErgebnisKonsultation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class ErgebnisKonsultation  implements java.io.Serializable {
    private at.chipkarte.client.kse.soap.Konsultationsdaten konsultationsDaten;

    private java.lang.Integer[] kseMessageCodes;

    private at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignKonsultationen;

    private at.chipkarte.client.kse.soap.Zusatzinformation zusatzinformation;

    public ErgebnisKonsultation() {
    }

    public ErgebnisKonsultation(
           at.chipkarte.client.kse.soap.Konsultationsdaten konsultationsDaten,
           java.lang.Integer[] kseMessageCodes,
           at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignKonsultationen,
           at.chipkarte.client.kse.soap.Zusatzinformation zusatzinformation) {
           this.konsultationsDaten = konsultationsDaten;
           this.kseMessageCodes = kseMessageCodes;
           this.nachsignKonsultationen = nachsignKonsultationen;
           this.zusatzinformation = zusatzinformation;
    }


    /**
     * Gets the konsultationsDaten value for this ErgebnisKonsultation.
     * 
     * @return konsultationsDaten
     */
    public at.chipkarte.client.kse.soap.Konsultationsdaten getKonsultationsDaten() {
        return konsultationsDaten;
    }


    /**
     * Sets the konsultationsDaten value for this ErgebnisKonsultation.
     * 
     * @param konsultationsDaten
     */
    public void setKonsultationsDaten(at.chipkarte.client.kse.soap.Konsultationsdaten konsultationsDaten) {
        this.konsultationsDaten = konsultationsDaten;
    }


    /**
     * Gets the kseMessageCodes value for this ErgebnisKonsultation.
     * 
     * @return kseMessageCodes
     */
    public java.lang.Integer[] getKseMessageCodes() {
        return kseMessageCodes;
    }


    /**
     * Sets the kseMessageCodes value for this ErgebnisKonsultation.
     * 
     * @param kseMessageCodes
     */
    public void setKseMessageCodes(java.lang.Integer[] kseMessageCodes) {
        this.kseMessageCodes = kseMessageCodes;
    }

    public java.lang.Integer getKseMessageCodes(int i) {
        return this.kseMessageCodes[i];
    }

    public void setKseMessageCodes(int i, java.lang.Integer _value) {
        this.kseMessageCodes[i] = _value;
    }


    /**
     * Gets the nachsignKonsultationen value for this ErgebnisKonsultation.
     * 
     * @return nachsignKonsultationen
     */
    public at.chipkarte.client.kse.soap.KonsultationsBeleg[] getNachsignKonsultationen() {
        return nachsignKonsultationen;
    }


    /**
     * Sets the nachsignKonsultationen value for this ErgebnisKonsultation.
     * 
     * @param nachsignKonsultationen
     */
    public void setNachsignKonsultationen(at.chipkarte.client.kse.soap.KonsultationsBeleg[] nachsignKonsultationen) {
        this.nachsignKonsultationen = nachsignKonsultationen;
    }

    public at.chipkarte.client.kse.soap.KonsultationsBeleg getNachsignKonsultationen(int i) {
        return this.nachsignKonsultationen[i];
    }

    public void setNachsignKonsultationen(int i, at.chipkarte.client.kse.soap.KonsultationsBeleg _value) {
        this.nachsignKonsultationen[i] = _value;
    }


    /**
     * Gets the zusatzinformation value for this ErgebnisKonsultation.
     * 
     * @return zusatzinformation
     */
    public at.chipkarte.client.kse.soap.Zusatzinformation getZusatzinformation() {
        return zusatzinformation;
    }


    /**
     * Sets the zusatzinformation value for this ErgebnisKonsultation.
     * 
     * @param zusatzinformation
     */
    public void setZusatzinformation(at.chipkarte.client.kse.soap.Zusatzinformation zusatzinformation) {
        this.zusatzinformation = zusatzinformation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ErgebnisKonsultation)) return false;
        ErgebnisKonsultation other = (ErgebnisKonsultation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.konsultationsDaten==null && other.getKonsultationsDaten()==null) || 
             (this.konsultationsDaten!=null &&
              this.konsultationsDaten.equals(other.getKonsultationsDaten()))) &&
            ((this.kseMessageCodes==null && other.getKseMessageCodes()==null) || 
             (this.kseMessageCodes!=null &&
              java.util.Arrays.equals(this.kseMessageCodes, other.getKseMessageCodes()))) &&
            ((this.nachsignKonsultationen==null && other.getNachsignKonsultationen()==null) || 
             (this.nachsignKonsultationen!=null &&
              java.util.Arrays.equals(this.nachsignKonsultationen, other.getNachsignKonsultationen()))) &&
            ((this.zusatzinformation==null && other.getZusatzinformation()==null) || 
             (this.zusatzinformation!=null &&
              this.zusatzinformation.equals(other.getZusatzinformation())));
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
        if (getKonsultationsDaten() != null) {
            _hashCode += getKonsultationsDaten().hashCode();
        }
        if (getKseMessageCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKseMessageCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKseMessageCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNachsignKonsultationen() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNachsignKonsultationen());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNachsignKonsultationen(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getZusatzinformation() != null) {
            _hashCode += getZusatzinformation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ErgebnisKonsultation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ErgebnisKonsultation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("konsultationsDaten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsultationsDaten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Konsultationsdaten"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kseMessageCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "kseMessageCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nachsignKonsultationen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachsignKonsultationen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zusatzinformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "zusatzinformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Zusatzinformation"));
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
