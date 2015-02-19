/**
 * SvPerson.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class SvPerson  implements java.io.Serializable {
    private java.lang.String geburtsdatum;

    private java.lang.String geschlecht;

    private java.lang.String nachname;

    private java.lang.String svNummer;

    private java.lang.String titelHinten;

    private java.lang.String titelVorne;

    private java.lang.String vorname;

    public SvPerson() {
    }

    public SvPerson(
           java.lang.String geburtsdatum,
           java.lang.String geschlecht,
           java.lang.String nachname,
           java.lang.String svNummer,
           java.lang.String titelHinten,
           java.lang.String titelVorne,
           java.lang.String vorname) {
           this.geburtsdatum = geburtsdatum;
           this.geschlecht = geschlecht;
           this.nachname = nachname;
           this.svNummer = svNummer;
           this.titelHinten = titelHinten;
           this.titelVorne = titelVorne;
           this.vorname = vorname;
    }


    /**
     * Gets the geburtsdatum value for this SvPerson.
     * 
     * @return geburtsdatum
     */
    public java.lang.String getGeburtsdatum() {
        return geburtsdatum;
    }


    /**
     * Sets the geburtsdatum value for this SvPerson.
     * 
     * @param geburtsdatum
     */
    public void setGeburtsdatum(java.lang.String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }


    /**
     * Gets the geschlecht value for this SvPerson.
     * 
     * @return geschlecht
     */
    public java.lang.String getGeschlecht() {
        return geschlecht;
    }


    /**
     * Sets the geschlecht value for this SvPerson.
     * 
     * @param geschlecht
     */
    public void setGeschlecht(java.lang.String geschlecht) {
        this.geschlecht = geschlecht;
    }


    /**
     * Gets the nachname value for this SvPerson.
     * 
     * @return nachname
     */
    public java.lang.String getNachname() {
        return nachname;
    }


    /**
     * Sets the nachname value for this SvPerson.
     * 
     * @param nachname
     */
    public void setNachname(java.lang.String nachname) {
        this.nachname = nachname;
    }


    /**
     * Gets the svNummer value for this SvPerson.
     * 
     * @return svNummer
     */
    public java.lang.String getSvNummer() {
        return svNummer;
    }


    /**
     * Sets the svNummer value for this SvPerson.
     * 
     * @param svNummer
     */
    public void setSvNummer(java.lang.String svNummer) {
        this.svNummer = svNummer;
    }


    /**
     * Gets the titelHinten value for this SvPerson.
     * 
     * @return titelHinten
     */
    public java.lang.String getTitelHinten() {
        return titelHinten;
    }


    /**
     * Sets the titelHinten value for this SvPerson.
     * 
     * @param titelHinten
     */
    public void setTitelHinten(java.lang.String titelHinten) {
        this.titelHinten = titelHinten;
    }


    /**
     * Gets the titelVorne value for this SvPerson.
     * 
     * @return titelVorne
     */
    public java.lang.String getTitelVorne() {
        return titelVorne;
    }


    /**
     * Sets the titelVorne value for this SvPerson.
     * 
     * @param titelVorne
     */
    public void setTitelVorne(java.lang.String titelVorne) {
        this.titelVorne = titelVorne;
    }


    /**
     * Gets the vorname value for this SvPerson.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this SvPerson.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SvPerson)) return false;
        SvPerson other = (SvPerson) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.geburtsdatum==null && other.getGeburtsdatum()==null) || 
             (this.geburtsdatum!=null &&
              this.geburtsdatum.equals(other.getGeburtsdatum()))) &&
            ((this.geschlecht==null && other.getGeschlecht()==null) || 
             (this.geschlecht!=null &&
              this.geschlecht.equals(other.getGeschlecht()))) &&
            ((this.nachname==null && other.getNachname()==null) || 
             (this.nachname!=null &&
              this.nachname.equals(other.getNachname()))) &&
            ((this.svNummer==null && other.getSvNummer()==null) || 
             (this.svNummer!=null &&
              this.svNummer.equals(other.getSvNummer()))) &&
            ((this.titelHinten==null && other.getTitelHinten()==null) || 
             (this.titelHinten!=null &&
              this.titelHinten.equals(other.getTitelHinten()))) &&
            ((this.titelVorne==null && other.getTitelVorne()==null) || 
             (this.titelVorne!=null &&
              this.titelVorne.equals(other.getTitelVorne()))) &&
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
        if (getGeburtsdatum() != null) {
            _hashCode += getGeburtsdatum().hashCode();
        }
        if (getGeschlecht() != null) {
            _hashCode += getGeschlecht().hashCode();
        }
        if (getNachname() != null) {
            _hashCode += getNachname().hashCode();
        }
        if (getSvNummer() != null) {
            _hashCode += getSvNummer().hashCode();
        }
        if (getTitelHinten() != null) {
            _hashCode += getTitelHinten().hashCode();
        }
        if (getTitelVorne() != null) {
            _hashCode += getTitelVorne().hashCode();
        }
        if (getVorname() != null) {
            _hashCode += getVorname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SvPerson.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "SvPerson"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geburtsdatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "geburtsdatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geschlecht");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "geschlecht"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nachname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "nachname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "svNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titelHinten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titelHinten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titelVorne");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titelVorne"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vorname"));
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
