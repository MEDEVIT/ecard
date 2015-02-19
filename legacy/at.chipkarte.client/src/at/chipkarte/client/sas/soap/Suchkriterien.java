/**
 * Suchkriterien.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class Suchkriterien  implements java.io.Serializable {
    private java.lang.String familienname;

    private java.lang.String geburtsdatum;

    private java.lang.String vorname;

    public Suchkriterien() {
    }

    public Suchkriterien(
           java.lang.String familienname,
           java.lang.String geburtsdatum,
           java.lang.String vorname) {
           this.familienname = familienname;
           this.geburtsdatum = geburtsdatum;
           this.vorname = vorname;
    }


    /**
     * Gets the familienname value for this Suchkriterien.
     * 
     * @return familienname
     */
    public java.lang.String getFamilienname() {
        return familienname;
    }


    /**
     * Sets the familienname value for this Suchkriterien.
     * 
     * @param familienname
     */
    public void setFamilienname(java.lang.String familienname) {
        this.familienname = familienname;
    }


    /**
     * Gets the geburtsdatum value for this Suchkriterien.
     * 
     * @return geburtsdatum
     */
    public java.lang.String getGeburtsdatum() {
        return geburtsdatum;
    }


    /**
     * Sets the geburtsdatum value for this Suchkriterien.
     * 
     * @param geburtsdatum
     */
    public void setGeburtsdatum(java.lang.String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }


    /**
     * Gets the vorname value for this Suchkriterien.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this Suchkriterien.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suchkriterien)) return false;
        Suchkriterien other = (Suchkriterien) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.familienname==null && other.getFamilienname()==null) || 
             (this.familienname!=null &&
              this.familienname.equals(other.getFamilienname()))) &&
            ((this.geburtsdatum==null && other.getGeburtsdatum()==null) || 
             (this.geburtsdatum!=null &&
              this.geburtsdatum.equals(other.getGeburtsdatum()))) &&
            ((this.vorname==null && other.getVorname()==null) || 
             (this.vorname!=null &&
              this.vorname.equals(other.getVorname())));
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
        if (getFamilienname() != null) {
            _hashCode += getFamilienname().hashCode();
        }
        if (getGeburtsdatum() != null) {
            _hashCode += getGeburtsdatum().hashCode();
        }
        if (getVorname() != null) {
            _hashCode += getVorname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suchkriterien.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "Suchkriterien"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familienname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "familienname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geburtsdatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "geburtsdatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "vorname"));
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
