/**
 * OfflineRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class OfflineRecord  implements java.io.Serializable {
    private java.lang.String erstellungsDatum;

    private java.lang.String id;

    private java.lang.String nachname;

    private java.lang.String offlineFrist;

    private at.chipkarte.client.kse.soap.OfflineKonsultation offlineKonsultation;

    private java.lang.String svNummer;

    private int type;

    private java.lang.String vorname;

    public OfflineRecord() {
    }

    public OfflineRecord(
           java.lang.String erstellungsDatum,
           java.lang.String id,
           java.lang.String nachname,
           java.lang.String offlineFrist,
           at.chipkarte.client.kse.soap.OfflineKonsultation offlineKonsultation,
           java.lang.String svNummer,
           int type,
           java.lang.String vorname) {
           this.erstellungsDatum = erstellungsDatum;
           this.id = id;
           this.nachname = nachname;
           this.offlineFrist = offlineFrist;
           this.offlineKonsultation = offlineKonsultation;
           this.svNummer = svNummer;
           this.type = type;
           this.vorname = vorname;
    }


    /**
     * Gets the erstellungsDatum value for this OfflineRecord.
     * 
     * @return erstellungsDatum
     */
    public java.lang.String getErstellungsDatum() {
        return erstellungsDatum;
    }


    /**
     * Sets the erstellungsDatum value for this OfflineRecord.
     * 
     * @param erstellungsDatum
     */
    public void setErstellungsDatum(java.lang.String erstellungsDatum) {
        this.erstellungsDatum = erstellungsDatum;
    }


    /**
     * Gets the id value for this OfflineRecord.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this OfflineRecord.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the nachname value for this OfflineRecord.
     * 
     * @return nachname
     */
    public java.lang.String getNachname() {
        return nachname;
    }


    /**
     * Sets the nachname value for this OfflineRecord.
     * 
     * @param nachname
     */
    public void setNachname(java.lang.String nachname) {
        this.nachname = nachname;
    }


    /**
     * Gets the offlineFrist value for this OfflineRecord.
     * 
     * @return offlineFrist
     */
    public java.lang.String getOfflineFrist() {
        return offlineFrist;
    }


    /**
     * Sets the offlineFrist value for this OfflineRecord.
     * 
     * @param offlineFrist
     */
    public void setOfflineFrist(java.lang.String offlineFrist) {
        this.offlineFrist = offlineFrist;
    }


    /**
     * Gets the offlineKonsultation value for this OfflineRecord.
     * 
     * @return offlineKonsultation
     */
    public at.chipkarte.client.kse.soap.OfflineKonsultation getOfflineKonsultation() {
        return offlineKonsultation;
    }


    /**
     * Sets the offlineKonsultation value for this OfflineRecord.
     * 
     * @param offlineKonsultation
     */
    public void setOfflineKonsultation(at.chipkarte.client.kse.soap.OfflineKonsultation offlineKonsultation) {
        this.offlineKonsultation = offlineKonsultation;
    }


    /**
     * Gets the svNummer value for this OfflineRecord.
     * 
     * @return svNummer
     */
    public java.lang.String getSvNummer() {
        return svNummer;
    }


    /**
     * Sets the svNummer value for this OfflineRecord.
     * 
     * @param svNummer
     */
    public void setSvNummer(java.lang.String svNummer) {
        this.svNummer = svNummer;
    }


    /**
     * Gets the type value for this OfflineRecord.
     * 
     * @return type
     */
    public int getType() {
        return type;
    }


    /**
     * Sets the type value for this OfflineRecord.
     * 
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }


    /**
     * Gets the vorname value for this OfflineRecord.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this OfflineRecord.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OfflineRecord)) return false;
        OfflineRecord other = (OfflineRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.erstellungsDatum==null && other.getErstellungsDatum()==null) || 
             (this.erstellungsDatum!=null &&
              this.erstellungsDatum.equals(other.getErstellungsDatum()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nachname==null && other.getNachname()==null) || 
             (this.nachname!=null &&
              this.nachname.equals(other.getNachname()))) &&
            ((this.offlineFrist==null && other.getOfflineFrist()==null) || 
             (this.offlineFrist!=null &&
              this.offlineFrist.equals(other.getOfflineFrist()))) &&
            ((this.offlineKonsultation==null && other.getOfflineKonsultation()==null) || 
             (this.offlineKonsultation!=null &&
              this.offlineKonsultation.equals(other.getOfflineKonsultation()))) &&
            ((this.svNummer==null && other.getSvNummer()==null) || 
             (this.svNummer!=null &&
              this.svNummer.equals(other.getSvNummer()))) &&
            this.type == other.getType() &&
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
        if (getErstellungsDatum() != null) {
            _hashCode += getErstellungsDatum().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNachname() != null) {
            _hashCode += getNachname().hashCode();
        }
        if (getOfflineFrist() != null) {
            _hashCode += getOfflineFrist().hashCode();
        }
        if (getOfflineKonsultation() != null) {
            _hashCode += getOfflineKonsultation().hashCode();
        }
        if (getSvNummer() != null) {
            _hashCode += getSvNummer().hashCode();
        }
        _hashCode += getType();
        if (getVorname() != null) {
            _hashCode += getVorname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OfflineRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erstellungsDatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "erstellungsDatum"));
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
        elemField.setFieldName("nachname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "nachname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineFrist");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "offlineFrist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offlineKonsultation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "offlineKonsultation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineKonsultation"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("svNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "svNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vorname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "vorname"));
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
