/**
 * Vertragspartner.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class Vertragspartner  implements java.io.Serializable {
    private java.lang.String anredeCode;

    private at.chipkarte.client.base.soap.AuthenticationStatus authenticationStatus;

    private java.lang.String druckNachname;

    private java.lang.String druckVorname;

    private java.lang.String geburtsdatum;

    private java.lang.String nachname;

    private at.chipkarte.client.base.soap.Ordination[] ordination;

    private java.lang.String titelHinten;

    private java.lang.String titelVorne;

    private java.lang.String vorname;

    private java.lang.String vpId;

    private java.lang.String vpNummer;

    public Vertragspartner() {
    }

    public Vertragspartner(
           java.lang.String anredeCode,
           at.chipkarte.client.base.soap.AuthenticationStatus authenticationStatus,
           java.lang.String druckNachname,
           java.lang.String druckVorname,
           java.lang.String geburtsdatum,
           java.lang.String nachname,
           at.chipkarte.client.base.soap.Ordination[] ordination,
           java.lang.String titelHinten,
           java.lang.String titelVorne,
           java.lang.String vorname,
           java.lang.String vpId,
           java.lang.String vpNummer) {
           this.anredeCode = anredeCode;
           this.authenticationStatus = authenticationStatus;
           this.druckNachname = druckNachname;
           this.druckVorname = druckVorname;
           this.geburtsdatum = geburtsdatum;
           this.nachname = nachname;
           this.ordination = ordination;
           this.titelHinten = titelHinten;
           this.titelVorne = titelVorne;
           this.vorname = vorname;
           this.vpId = vpId;
           this.vpNummer = vpNummer;
    }


    /**
     * Gets the anredeCode value for this Vertragspartner.
     * 
     * @return anredeCode
     */
    public java.lang.String getAnredeCode() {
        return anredeCode;
    }


    /**
     * Sets the anredeCode value for this Vertragspartner.
     * 
     * @param anredeCode
     */
    public void setAnredeCode(java.lang.String anredeCode) {
        this.anredeCode = anredeCode;
    }


    /**
     * Gets the authenticationStatus value for this Vertragspartner.
     * 
     * @return authenticationStatus
     */
    public at.chipkarte.client.base.soap.AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }


    /**
     * Sets the authenticationStatus value for this Vertragspartner.
     * 
     * @param authenticationStatus
     */
    public void setAuthenticationStatus(at.chipkarte.client.base.soap.AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }


    /**
     * Gets the druckNachname value for this Vertragspartner.
     * 
     * @return druckNachname
     */
    public java.lang.String getDruckNachname() {
        return druckNachname;
    }


    /**
     * Sets the druckNachname value for this Vertragspartner.
     * 
     * @param druckNachname
     */
    public void setDruckNachname(java.lang.String druckNachname) {
        this.druckNachname = druckNachname;
    }


    /**
     * Gets the druckVorname value for this Vertragspartner.
     * 
     * @return druckVorname
     */
    public java.lang.String getDruckVorname() {
        return druckVorname;
    }


    /**
     * Sets the druckVorname value for this Vertragspartner.
     * 
     * @param druckVorname
     */
    public void setDruckVorname(java.lang.String druckVorname) {
        this.druckVorname = druckVorname;
    }


    /**
     * Gets the geburtsdatum value for this Vertragspartner.
     * 
     * @return geburtsdatum
     */
    public java.lang.String getGeburtsdatum() {
        return geburtsdatum;
    }


    /**
     * Sets the geburtsdatum value for this Vertragspartner.
     * 
     * @param geburtsdatum
     */
    public void setGeburtsdatum(java.lang.String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }


    /**
     * Gets the nachname value for this Vertragspartner.
     * 
     * @return nachname
     */
    public java.lang.String getNachname() {
        return nachname;
    }


    /**
     * Sets the nachname value for this Vertragspartner.
     * 
     * @param nachname
     */
    public void setNachname(java.lang.String nachname) {
        this.nachname = nachname;
    }


    /**
     * Gets the ordination value for this Vertragspartner.
     * 
     * @return ordination
     */
    public at.chipkarte.client.base.soap.Ordination[] getOrdination() {
        return ordination;
    }


    /**
     * Sets the ordination value for this Vertragspartner.
     * 
     * @param ordination
     */
    public void setOrdination(at.chipkarte.client.base.soap.Ordination[] ordination) {
        this.ordination = ordination;
    }

    public at.chipkarte.client.base.soap.Ordination getOrdination(int i) {
        return this.ordination[i];
    }

    public void setOrdination(int i, at.chipkarte.client.base.soap.Ordination _value) {
        this.ordination[i] = _value;
    }


    /**
     * Gets the titelHinten value for this Vertragspartner.
     * 
     * @return titelHinten
     */
    public java.lang.String getTitelHinten() {
        return titelHinten;
    }


    /**
     * Sets the titelHinten value for this Vertragspartner.
     * 
     * @param titelHinten
     */
    public void setTitelHinten(java.lang.String titelHinten) {
        this.titelHinten = titelHinten;
    }


    /**
     * Gets the titelVorne value for this Vertragspartner.
     * 
     * @return titelVorne
     */
    public java.lang.String getTitelVorne() {
        return titelVorne;
    }


    /**
     * Sets the titelVorne value for this Vertragspartner.
     * 
     * @param titelVorne
     */
    public void setTitelVorne(java.lang.String titelVorne) {
        this.titelVorne = titelVorne;
    }


    /**
     * Gets the vorname value for this Vertragspartner.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this Vertragspartner.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }


    /**
     * Gets the vpId value for this Vertragspartner.
     * 
     * @return vpId
     */
    public java.lang.String getVpId() {
        return vpId;
    }


    /**
     * Sets the vpId value for this Vertragspartner.
     * 
     * @param vpId
     */
    public void setVpId(java.lang.String vpId) {
        this.vpId = vpId;
    }


    /**
     * Gets the vpNummer value for this Vertragspartner.
     * 
     * @return vpNummer
     */
    public java.lang.String getVpNummer() {
        return vpNummer;
    }


    /**
     * Sets the vpNummer value for this Vertragspartner.
     * 
     * @param vpNummer
     */
    public void setVpNummer(java.lang.String vpNummer) {
        this.vpNummer = vpNummer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Vertragspartner)) return false;
        Vertragspartner other = (Vertragspartner) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anredeCode==null && other.getAnredeCode()==null) || 
             (this.anredeCode!=null &&
              this.anredeCode.equals(other.getAnredeCode()))) &&
            ((this.authenticationStatus==null && other.getAuthenticationStatus()==null) || 
             (this.authenticationStatus!=null &&
              this.authenticationStatus.equals(other.getAuthenticationStatus()))) &&
            ((this.druckNachname==null && other.getDruckNachname()==null) || 
             (this.druckNachname!=null &&
              this.druckNachname.equals(other.getDruckNachname()))) &&
            ((this.druckVorname==null && other.getDruckVorname()==null) || 
             (this.druckVorname!=null &&
              this.druckVorname.equals(other.getDruckVorname()))) &&
            ((this.geburtsdatum==null && other.getGeburtsdatum()==null) || 
             (this.geburtsdatum!=null &&
              this.geburtsdatum.equals(other.getGeburtsdatum()))) &&
            ((this.nachname==null && other.getNachname()==null) || 
             (this.nachname!=null &&
              this.nachname.equals(other.getNachname()))) &&
            ((this.ordination==null && other.getOrdination()==null) || 
             (this.ordination!=null &&
              java.util.Arrays.equals(this.ordination, other.getOrdination()))) &&
            ((this.titelHinten==null && other.getTitelHinten()==null) || 
             (this.titelHinten!=null &&
              this.titelHinten.equals(other.getTitelHinten()))) &&
            ((this.titelVorne==null && other.getTitelVorne()==null) || 
             (this.titelVorne!=null &&
              this.titelVorne.equals(other.getTitelVorne()))) &&
            ((this.vorname==null && other.getVorname()==null) || 
             (this.vorname!=null &&
              this.vorname.equals(other.getVorname()))) &&
            ((this.vpId==null && other.getVpId()==null) || 
             (this.vpId!=null &&
              this.vpId.equals(other.getVpId()))) &&
            ((this.vpNummer==null && other.getVpNummer()==null) || 
             (this.vpNummer!=null &&
              this.vpNummer.equals(other.getVpNummer())));
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
        if (getAnredeCode() != null) {
            _hashCode += getAnredeCode().hashCode();
        }
        if (getAuthenticationStatus() != null) {
            _hashCode += getAuthenticationStatus().hashCode();
        }
        if (getDruckNachname() != null) {
            _hashCode += getDruckNachname().hashCode();
        }
        if (getDruckVorname() != null) {
            _hashCode += getDruckVorname().hashCode();
        }
        if (getGeburtsdatum() != null) {
            _hashCode += getGeburtsdatum().hashCode();
        }
        if (getNachname() != null) {
            _hashCode += getNachname().hashCode();
        }
        if (getOrdination() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrdination());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrdination(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getVpId() != null) {
            _hashCode += getVpId().hashCode();
        }
        if (getVpNummer() != null) {
            _hashCode += getVpNummer().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Vertragspartner.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Vertragspartner"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anredeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "anredeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticationStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "authenticationStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "AuthenticationStatus"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("druckNachname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "druckNachname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("druckVorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "druckVorname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geburtsdatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "geburtsdatum"));
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
        elemField.setFieldName("ordination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Ordination"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vpId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vpNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vpNummer"));
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
