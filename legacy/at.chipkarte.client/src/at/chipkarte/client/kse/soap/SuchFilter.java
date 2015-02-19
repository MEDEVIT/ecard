/**
 * SuchFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class SuchFilter  implements java.io.Serializable {
    private java.lang.String SVNummer;

    private java.lang.String behandlungsfallCode;

    private java.lang.String datumBis;

    private java.lang.String datumVon;

    private java.lang.String fachgebietsCode;

    private java.lang.String konsultationsartCode;

    private java.lang.String ordId;

    private java.lang.String svtCode;

    public SuchFilter() {
    }

    public SuchFilter(
           java.lang.String SVNummer,
           java.lang.String behandlungsfallCode,
           java.lang.String datumBis,
           java.lang.String datumVon,
           java.lang.String fachgebietsCode,
           java.lang.String konsultationsartCode,
           java.lang.String ordId,
           java.lang.String svtCode) {
           this.SVNummer = SVNummer;
           this.behandlungsfallCode = behandlungsfallCode;
           this.datumBis = datumBis;
           this.datumVon = datumVon;
           this.fachgebietsCode = fachgebietsCode;
           this.konsultationsartCode = konsultationsartCode;
           this.ordId = ordId;
           this.svtCode = svtCode;
    }


    /**
     * Gets the SVNummer value for this SuchFilter.
     * 
     * @return SVNummer
     */
    public java.lang.String getSVNummer() {
        return SVNummer;
    }


    /**
     * Sets the SVNummer value for this SuchFilter.
     * 
     * @param SVNummer
     */
    public void setSVNummer(java.lang.String SVNummer) {
        this.SVNummer = SVNummer;
    }


    /**
     * Gets the behandlungsfallCode value for this SuchFilter.
     * 
     * @return behandlungsfallCode
     */
    public java.lang.String getBehandlungsfallCode() {
        return behandlungsfallCode;
    }


    /**
     * Sets the behandlungsfallCode value for this SuchFilter.
     * 
     * @param behandlungsfallCode
     */
    public void setBehandlungsfallCode(java.lang.String behandlungsfallCode) {
        this.behandlungsfallCode = behandlungsfallCode;
    }


    /**
     * Gets the datumBis value for this SuchFilter.
     * 
     * @return datumBis
     */
    public java.lang.String getDatumBis() {
        return datumBis;
    }


    /**
     * Sets the datumBis value for this SuchFilter.
     * 
     * @param datumBis
     */
    public void setDatumBis(java.lang.String datumBis) {
        this.datumBis = datumBis;
    }


    /**
     * Gets the datumVon value for this SuchFilter.
     * 
     * @return datumVon
     */
    public java.lang.String getDatumVon() {
        return datumVon;
    }


    /**
     * Sets the datumVon value for this SuchFilter.
     * 
     * @param datumVon
     */
    public void setDatumVon(java.lang.String datumVon) {
        this.datumVon = datumVon;
    }


    /**
     * Gets the fachgebietsCode value for this SuchFilter.
     * 
     * @return fachgebietsCode
     */
    public java.lang.String getFachgebietsCode() {
        return fachgebietsCode;
    }


    /**
     * Sets the fachgebietsCode value for this SuchFilter.
     * 
     * @param fachgebietsCode
     */
    public void setFachgebietsCode(java.lang.String fachgebietsCode) {
        this.fachgebietsCode = fachgebietsCode;
    }


    /**
     * Gets the konsultationsartCode value for this SuchFilter.
     * 
     * @return konsultationsartCode
     */
    public java.lang.String getKonsultationsartCode() {
        return konsultationsartCode;
    }


    /**
     * Sets the konsultationsartCode value for this SuchFilter.
     * 
     * @param konsultationsartCode
     */
    public void setKonsultationsartCode(java.lang.String konsultationsartCode) {
        this.konsultationsartCode = konsultationsartCode;
    }


    /**
     * Gets the ordId value for this SuchFilter.
     * 
     * @return ordId
     */
    public java.lang.String getOrdId() {
        return ordId;
    }


    /**
     * Sets the ordId value for this SuchFilter.
     * 
     * @param ordId
     */
    public void setOrdId(java.lang.String ordId) {
        this.ordId = ordId;
    }


    /**
     * Gets the svtCode value for this SuchFilter.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this SuchFilter.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuchFilter)) return false;
        SuchFilter other = (SuchFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SVNummer==null && other.getSVNummer()==null) || 
             (this.SVNummer!=null &&
              this.SVNummer.equals(other.getSVNummer()))) &&
            ((this.behandlungsfallCode==null && other.getBehandlungsfallCode()==null) || 
             (this.behandlungsfallCode!=null &&
              this.behandlungsfallCode.equals(other.getBehandlungsfallCode()))) &&
            ((this.datumBis==null && other.getDatumBis()==null) || 
             (this.datumBis!=null &&
              this.datumBis.equals(other.getDatumBis()))) &&
            ((this.datumVon==null && other.getDatumVon()==null) || 
             (this.datumVon!=null &&
              this.datumVon.equals(other.getDatumVon()))) &&
            ((this.fachgebietsCode==null && other.getFachgebietsCode()==null) || 
             (this.fachgebietsCode!=null &&
              this.fachgebietsCode.equals(other.getFachgebietsCode()))) &&
            ((this.konsultationsartCode==null && other.getKonsultationsartCode()==null) || 
             (this.konsultationsartCode!=null &&
              this.konsultationsartCode.equals(other.getKonsultationsartCode()))) &&
            ((this.ordId==null && other.getOrdId()==null) || 
             (this.ordId!=null &&
              this.ordId.equals(other.getOrdId()))) &&
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
        if (getSVNummer() != null) {
            _hashCode += getSVNummer().hashCode();
        }
        if (getBehandlungsfallCode() != null) {
            _hashCode += getBehandlungsfallCode().hashCode();
        }
        if (getDatumBis() != null) {
            _hashCode += getDatumBis().hashCode();
        }
        if (getDatumVon() != null) {
            _hashCode += getDatumVon().hashCode();
        }
        if (getFachgebietsCode() != null) {
            _hashCode += getFachgebietsCode().hashCode();
        }
        if (getKonsultationsartCode() != null) {
            _hashCode += getKonsultationsartCode().hashCode();
        }
        if (getOrdId() != null) {
            _hashCode += getOrdId().hashCode();
        }
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuchFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "SuchFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SVNummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "SVNummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("behandlungsfallCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsfallCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datumBis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "datumBis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datumVon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "datumVon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fachgebietsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "fachgebietsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("konsultationsartCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "konsultationsartCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "ordId"));
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
