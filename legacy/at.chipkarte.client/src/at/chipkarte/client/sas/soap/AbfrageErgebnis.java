/**
 * AbfrageErgebnis.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.sas.soap;

public class AbfrageErgebnis  implements java.io.Serializable {
    private java.lang.String familienname;

    private java.lang.String geburtsdatum;

    private java.lang.String svNummer;

    private java.lang.String vorname;

    private java.lang.String todesdatum;

    private java.lang.String todesdatumBestaetigtKZ;

    public AbfrageErgebnis() {
    }

    public AbfrageErgebnis(
           java.lang.String familienname,
           java.lang.String geburtsdatum,
           java.lang.String svNummer,
           java.lang.String vorname,
           java.lang.String todesdatum,
           java.lang.String todesdatumBestaetigtKZ) {
           this.familienname = familienname;
           this.geburtsdatum = geburtsdatum;
           this.svNummer = svNummer;
           this.vorname = vorname;
           this.todesdatum = todesdatum;
           this.todesdatumBestaetigtKZ = todesdatumBestaetigtKZ;
    }


    /**
     * Gets the familienname value for this AbfrageErgebnis.
     * 
     * @return familienname
     */
    public java.lang.String getFamilienname() {
        return familienname;
    }


    /**
     * Sets the familienname value for this AbfrageErgebnis.
     * 
     * @param familienname
     */
    public void setFamilienname(java.lang.String familienname) {
        this.familienname = familienname;
    }


    /**
     * Gets the geburtsdatum value for this AbfrageErgebnis.
     * 
     * @return geburtsdatum
     */
    public java.lang.String getGeburtsdatum() {
        return geburtsdatum;
    }


    /**
     * Sets the geburtsdatum value for this AbfrageErgebnis.
     * 
     * @param geburtsdatum
     */
    public void setGeburtsdatum(java.lang.String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }


    /**
     * Gets the svNummer value for this AbfrageErgebnis.
     * 
     * @return svNummer
     */
    public java.lang.String getSvNummer() {
        return svNummer;
    }


    /**
     * Sets the svNummer value for this AbfrageErgebnis.
     * 
     * @param svNummer
     */
    public void setSvNummer(java.lang.String svNummer) {
        this.svNummer = svNummer;
    }


    /**
     * Gets the vorname value for this AbfrageErgebnis.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this AbfrageErgebnis.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }


    /**
     * Gets the todesdatum value for this AbfrageErgebnis.
     * 
     * @return todesdatum
     */
    public java.lang.String getTodesdatum() {
        return todesdatum;
    }


    /**
     * Sets the todesdatum value for this AbfrageErgebnis.
     * 
     * @param todesdatum
     */
    public void setTodesdatum(java.lang.String todesdatum) {
        this.todesdatum = todesdatum;
    }


    /**
     * Gets the todesdatumBestaetigtKZ value for this AbfrageErgebnis.
     * 
     * @return todesdatumBestaetigtKZ
     */
    public java.lang.String getTodesdatumBestaetigtKZ() {
        return todesdatumBestaetigtKZ;
    }


    /**
     * Sets the todesdatumBestaetigtKZ value for this AbfrageErgebnis.
     * 
     * @param todesdatumBestaetigtKZ
     */
    public void setTodesdatumBestaetigtKZ(java.lang.String todesdatumBestaetigtKZ) {
        this.todesdatumBestaetigtKZ = todesdatumBestaetigtKZ;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AbfrageErgebnis)) return false;
        AbfrageErgebnis other = (AbfrageErgebnis) obj;
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
            ((this.svNummer==null && other.getSvNummer()==null) || 
             (this.svNummer!=null &&
              this.svNummer.equals(other.getSvNummer()))) &&
            ((this.vorname==null && other.getVorname()==null) || 
             (this.vorname!=null &&
              this.vorname.equals(other.getVorname()))) &&
            ((this.todesdatum==null && other.getTodesdatum()==null) || 
             (this.todesdatum!=null &&
              this.todesdatum.equals(other.getTodesdatum()))) &&
            ((this.todesdatumBestaetigtKZ==null && other.getTodesdatumBestaetigtKZ()==null) || 
             (this.todesdatumBestaetigtKZ!=null &&
              this.todesdatumBestaetigtKZ.equals(other.getTodesdatumBestaetigtKZ())));
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
        if (getSvNummer() != null) {
            _hashCode += getSvNummer().hashCode();
        }
        if (getVorname() != null) {
            _hashCode += getVorname().hashCode();
        }
        if (getTodesdatum() != null) {
            _hashCode += getTodesdatum().hashCode();
        }
        if (getTodesdatumBestaetigtKZ() != null) {
            _hashCode += getTodesdatumBestaetigtKZ().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AbfrageErgebnis.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "AbfrageErgebnis"));
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
        elemField.setFieldName("svNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "svNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "vorname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("todesdatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "todesdatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("todesdatumBestaetigtKZ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sas.client.chipkarte.at", "todesdatumBestaetigtKZ"));
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
