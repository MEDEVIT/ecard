/**
 * Konsultationsdaten.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class Konsultationsdaten  implements java.io.Serializable {
    private at.chipkarte.client.base.soap.SvPerson angehoerigenDaten;

    private at.chipkarte.client.kse.soap.KonsultationsBeleg konsultationsBeleg;

    private at.chipkarte.client.base.soap.SvPerson versichertenDaten;

    public Konsultationsdaten() {
    }

    public Konsultationsdaten(
           at.chipkarte.client.base.soap.SvPerson angehoerigenDaten,
           at.chipkarte.client.kse.soap.KonsultationsBeleg konsultationsBeleg,
           at.chipkarte.client.base.soap.SvPerson versichertenDaten) {
           this.angehoerigenDaten = angehoerigenDaten;
           this.konsultationsBeleg = konsultationsBeleg;
           this.versichertenDaten = versichertenDaten;
    }


    /**
     * Gets the angehoerigenDaten value for this Konsultationsdaten.
     * 
     * @return angehoerigenDaten
     */
    public at.chipkarte.client.base.soap.SvPerson getAngehoerigenDaten() {
        return angehoerigenDaten;
    }


    /**
     * Sets the angehoerigenDaten value for this Konsultationsdaten.
     * 
     * @param angehoerigenDaten
     */
    public void setAngehoerigenDaten(at.chipkarte.client.base.soap.SvPerson angehoerigenDaten) {
        this.angehoerigenDaten = angehoerigenDaten;
    }


    /**
     * Gets the konsultationsBeleg value for this Konsultationsdaten.
     * 
     * @return konsultationsBeleg
     */
    public at.chipkarte.client.kse.soap.KonsultationsBeleg getKonsultationsBeleg() {
        return konsultationsBeleg;
    }


    /**
     * Sets the konsultationsBeleg value for this Konsultationsdaten.
     * 
     * @param konsultationsBeleg
     */
    public void setKonsultationsBeleg(at.chipkarte.client.kse.soap.KonsultationsBeleg konsultationsBeleg) {
        this.konsultationsBeleg = konsultationsBeleg;
    }


    /**
     * Gets the versichertenDaten value for this Konsultationsdaten.
     * 
     * @return versichertenDaten
     */
    public at.chipkarte.client.base.soap.SvPerson getVersichertenDaten() {
        return versichertenDaten;
    }


    /**
     * Sets the versichertenDaten value for this Konsultationsdaten.
     * 
     * @param versichertenDaten
     */
    public void setVersichertenDaten(at.chipkarte.client.base.soap.SvPerson versichertenDaten) {
        this.versichertenDaten = versichertenDaten;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Konsultationsdaten)) return false;
        Konsultationsdaten other = (Konsultationsdaten) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.angehoerigenDaten==null && other.getAngehoerigenDaten()==null) || 
             (this.angehoerigenDaten!=null &&
              this.angehoerigenDaten.equals(other.getAngehoerigenDaten()))) &&
            ((this.konsultationsBeleg==null && other.getKonsultationsBeleg()==null) || 
             (this.konsultationsBeleg!=null &&
              this.konsultationsBeleg.equals(other.getKonsultationsBeleg()))) &&
            ((this.versichertenDaten==null && other.getVersichertenDaten()==null) || 
             (this.versichertenDaten!=null &&
              this.versichertenDaten.equals(other.getVersichertenDaten())));
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
        if (getAngehoerigenDaten() != null) {
            _hashCode += getAngehoerigenDaten().hashCode();
        }
        if (getKonsultationsBeleg() != null) {
            _hashCode += getKonsultationsBeleg().hashCode();
        }
        if (getVersichertenDaten() != null) {
            _hashCode += getVersichertenDaten().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Konsultationsdaten.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Konsultationsdaten"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("angehoerigenDaten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "angehoerigenDaten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "SvPerson"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("konsultationsBeleg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsultationsBeleg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "KonsultationsBeleg"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versichertenDaten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "versichertenDaten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "SvPerson"));
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
