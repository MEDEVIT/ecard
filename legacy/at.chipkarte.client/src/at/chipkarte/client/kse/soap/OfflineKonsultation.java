/**
 * OfflineKonsultation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.kse.soap;

public class OfflineKonsultation  implements java.io.Serializable {
    private java.lang.String behandlungsDatum;

    private java.lang.String behandlunsfallCode;

    private java.lang.String fachgebietsCode;

    private java.lang.String konsultationsartCode;

    private java.lang.String svtCode;

    public OfflineKonsultation() {
    }

    public OfflineKonsultation(
           java.lang.String behandlungsDatum,
           java.lang.String behandlunsfallCode,
           java.lang.String fachgebietsCode,
           java.lang.String konsultationsartCode,
           java.lang.String svtCode) {
           this.behandlungsDatum = behandlungsDatum;
           this.behandlunsfallCode = behandlunsfallCode;
           this.fachgebietsCode = fachgebietsCode;
           this.konsultationsartCode = konsultationsartCode;
           this.svtCode = svtCode;
    }


    /**
     * Gets the behandlungsDatum value for this OfflineKonsultation.
     * 
     * @return behandlungsDatum
     */
    public java.lang.String getBehandlungsDatum() {
        return behandlungsDatum;
    }


    /**
     * Sets the behandlungsDatum value for this OfflineKonsultation.
     * 
     * @param behandlungsDatum
     */
    public void setBehandlungsDatum(java.lang.String behandlungsDatum) {
        this.behandlungsDatum = behandlungsDatum;
    }


    /**
     * Gets the behandlunsfallCode value for this OfflineKonsultation.
     * 
     * @return behandlunsfallCode
     */
    public java.lang.String getBehandlunsfallCode() {
        return behandlunsfallCode;
    }


    /**
     * Sets the behandlunsfallCode value for this OfflineKonsultation.
     * 
     * @param behandlunsfallCode
     */
    public void setBehandlunsfallCode(java.lang.String behandlunsfallCode) {
        this.behandlunsfallCode = behandlunsfallCode;
    }


    /**
     * Gets the fachgebietsCode value for this OfflineKonsultation.
     * 
     * @return fachgebietsCode
     */
    public java.lang.String getFachgebietsCode() {
        return fachgebietsCode;
    }


    /**
     * Sets the fachgebietsCode value for this OfflineKonsultation.
     * 
     * @param fachgebietsCode
     */
    public void setFachgebietsCode(java.lang.String fachgebietsCode) {
        this.fachgebietsCode = fachgebietsCode;
    }


    /**
     * Gets the konsultationsartCode value for this OfflineKonsultation.
     * 
     * @return konsultationsartCode
     */
    public java.lang.String getKonsultationsartCode() {
        return konsultationsartCode;
    }


    /**
     * Sets the konsultationsartCode value for this OfflineKonsultation.
     * 
     * @param konsultationsartCode
     */
    public void setKonsultationsartCode(java.lang.String konsultationsartCode) {
        this.konsultationsartCode = konsultationsartCode;
    }


    /**
     * Gets the svtCode value for this OfflineKonsultation.
     * 
     * @return svtCode
     */
    public java.lang.String getSvtCode() {
        return svtCode;
    }


    /**
     * Sets the svtCode value for this OfflineKonsultation.
     * 
     * @param svtCode
     */
    public void setSvtCode(java.lang.String svtCode) {
        this.svtCode = svtCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OfflineKonsultation)) return false;
        OfflineKonsultation other = (OfflineKonsultation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.behandlungsDatum==null && other.getBehandlungsDatum()==null) || 
             (this.behandlungsDatum!=null &&
              this.behandlungsDatum.equals(other.getBehandlungsDatum()))) &&
            ((this.behandlunsfallCode==null && other.getBehandlunsfallCode()==null) || 
             (this.behandlunsfallCode!=null &&
              this.behandlunsfallCode.equals(other.getBehandlunsfallCode()))) &&
            ((this.fachgebietsCode==null && other.getFachgebietsCode()==null) || 
             (this.fachgebietsCode!=null &&
              this.fachgebietsCode.equals(other.getFachgebietsCode()))) &&
            ((this.konsultationsartCode==null && other.getKonsultationsartCode()==null) || 
             (this.konsultationsartCode!=null &&
              this.konsultationsartCode.equals(other.getKonsultationsartCode()))) &&
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
        if (getBehandlungsDatum() != null) {
            _hashCode += getBehandlungsDatum().hashCode();
        }
        if (getBehandlunsfallCode() != null) {
            _hashCode += getBehandlunsfallCode().hashCode();
        }
        if (getFachgebietsCode() != null) {
            _hashCode += getFachgebietsCode().hashCode();
        }
        if (getKonsultationsartCode() != null) {
            _hashCode += getKonsultationsartCode().hashCode();
        }
        if (getSvtCode() != null) {
            _hashCode += getSvtCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OfflineKonsultation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "OfflineKonsultation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("behandlungsDatum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlungsDatum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("behandlunsfallCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.kse.client.chipkarte.at", "behandlunsfallCode"));
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
