/**
 * Anspruch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class Anspruch  implements java.io.Serializable {
    private java.lang.String abgeleitetNachname;

    private java.lang.String abgeleitetTitelHinten;

    private java.lang.String abgeleitetTitelVorne;

    private java.lang.String abgeleitetVorname;

    private java.lang.String ablSvNummer;

    private java.lang.String id;

    private java.lang.String svtCode;

    public Anspruch() {
    }

    public Anspruch(
           java.lang.String abgeleitetNachname,
           java.lang.String abgeleitetTitelHinten,
           java.lang.String abgeleitetTitelVorne,
           java.lang.String abgeleitetVorname,
           java.lang.String ablSvNummer,
           java.lang.String id,
           java.lang.String svtCode) {
           this.abgeleitetNachname = abgeleitetNachname;
           this.abgeleitetTitelHinten = abgeleitetTitelHinten;
           this.abgeleitetTitelVorne = abgeleitetTitelVorne;
           this.abgeleitetVorname = abgeleitetVorname;
           this.ablSvNummer = ablSvNummer;
           this.id = id;
           this.svtCode = svtCode;
    }


    /**
     * Gets the abgeleitetNachname value for this Anspruch.
     * 
     * @return abgeleitetNachname
     */
    public java.lang.String getAbgeleitetNachname() {
        return abgeleitetNachname;
    }


    /**
     * Sets the abgeleitetNachname value for this Anspruch.
     * 
     * @param abgeleitetNachname
     */
    public void setAbgeleitetNachname(java.lang.String abgeleitetNachname) {
        this.abgeleitetNachname = abgeleitetNachname;
    }


    /**
     * Gets the abgeleitetTitelHinten value for this Anspruch.
     * 
     * @return abgeleitetTitelHinten
     */
    public java.lang.String getAbgeleitetTitelHinten() {
        return abgeleitetTitelHinten;
    }


    /**
     * Sets the abgeleitetTitelHinten value for this Anspruch.
     * 
     * @param abgeleitetTitelHinten
     */
    public void setAbgeleitetTitelHinten(java.lang.String abgeleitetTitelHinten) {
        this.abgeleitetTitelHinten = abgeleitetTitelHinten;
    }


    /**
     * Gets the abgeleitetTitelVorne value for this Anspruch.
     * 
     * @return abgeleitetTitelVorne
     */
    public java.lang.String getAbgeleitetTitelVorne() {
        return abgeleitetTitelVorne;
    }


    /**
     * Sets the abgeleitetTitelVorne value for this Anspruch.
     * 
     * @param abgeleitetTitelVorne
     */
    public void setAbgeleitetTitelVorne(java.lang.String abgeleitetTitelVorne) {
        this.abgeleitetTitelVorne = abgeleitetTitelVorne;
    }


    /**
     * Gets the abgeleitetVorname value for this Anspruch.
     * 
     * @return abgeleitetVorname
     */
    public java.lang.String getAbgeleitetVorname() {
        return abgeleitetVorname;
    }


    /**
     * Sets the abgeleitetVorname value for this Anspruch.
     * 
     * @param abgeleitetVorname
     */
    public void setAbgeleitetVorname(java.lang.String abgeleitetVorname) {
        this.abgeleitetVorname = abgeleitetVorname;
    }


    /**
     * Gets the ablSvNummer value for this Anspruch.
     * 
     * @return ablSvNummer
     */
    public java.lang.String getAblSvNummer() {
        return ablSvNummer;
    }


    /**
     * Sets the ablSvNummer value for this Anspruch.
     * 
     * @param ablSvNummer
     */
    public void setAblSvNummer(java.lang.String ablSvNummer) {
        this.ablSvNummer = ablSvNummer;
    }


    /**
     * Gets the id value for this Anspruch.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Anspruch.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the svtCode value for this Anspruch.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this Anspruch.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Anspruch)) return false;
        Anspruch other = (Anspruch) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abgeleitetNachname==null && other.getAbgeleitetNachname()==null) || 
             (this.abgeleitetNachname!=null &&
              this.abgeleitetNachname.equals(other.getAbgeleitetNachname()))) &&
            ((this.abgeleitetTitelHinten==null && other.getAbgeleitetTitelHinten()==null) || 
             (this.abgeleitetTitelHinten!=null &&
              this.abgeleitetTitelHinten.equals(other.getAbgeleitetTitelHinten()))) &&
            ((this.abgeleitetTitelVorne==null && other.getAbgeleitetTitelVorne()==null) || 
             (this.abgeleitetTitelVorne!=null &&
              this.abgeleitetTitelVorne.equals(other.getAbgeleitetTitelVorne()))) &&
            ((this.abgeleitetVorname==null && other.getAbgeleitetVorname()==null) || 
             (this.abgeleitetVorname!=null &&
              this.abgeleitetVorname.equals(other.getAbgeleitetVorname()))) &&
            ((this.ablSvNummer==null && other.getAblSvNummer()==null) || 
             (this.ablSvNummer!=null &&
              this.ablSvNummer.equals(other.getAblSvNummer()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.svtCode==null && other.getSvtCode()==null) || 
             (this.svtCode!=null &&
              this.svtCode.equals(other.getSvtCode())));
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
        if (getAbgeleitetNachname() != null) {
            _hashCode += getAbgeleitetNachname().hashCode();
        }
        if (getAbgeleitetTitelHinten() != null) {
            _hashCode += getAbgeleitetTitelHinten().hashCode();
        }
        if (getAbgeleitetTitelVorne() != null) {
            _hashCode += getAbgeleitetTitelVorne().hashCode();
        }
        if (getAbgeleitetVorname() != null) {
            _hashCode += getAbgeleitetVorname().hashCode();
        }
        if (getAblSvNummer() != null) {
            _hashCode += getAblSvNummer().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Anspruch.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "Anspruch"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abgeleitetNachname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "abgeleitetNachname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abgeleitetTitelHinten");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "abgeleitetTitelHinten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abgeleitetTitelVorne");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "abgeleitetTitelVorne"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abgeleitetVorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "abgeleitetVorname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ablSvNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ablSvNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svtCode"));
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
