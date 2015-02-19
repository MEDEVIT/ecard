/**
 * StatusInformationen.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class StatusInformationen  implements java.io.Serializable {
    private at.chipkarte.client.base.soap.GinaInfo ginaInfo;

    private at.chipkarte.client.base.soap.ServiceStatusInformation[] serviceStatusInformation;

    private java.lang.String wartungsfensterBis;

    private java.lang.String wartungsfensterHinweis;

    private boolean wartungsfensterKennzeichen;

    private java.lang.String wartungsfensterText;

    private java.lang.String wartungsfensterVon;

    public StatusInformationen() {
    }

    public StatusInformationen(
           at.chipkarte.client.base.soap.GinaInfo ginaInfo,
           at.chipkarte.client.base.soap.ServiceStatusInformation[] serviceStatusInformation,
           java.lang.String wartungsfensterBis,
           java.lang.String wartungsfensterHinweis,
           boolean wartungsfensterKennzeichen,
           java.lang.String wartungsfensterText,
           java.lang.String wartungsfensterVon) {
           this.ginaInfo = ginaInfo;
           this.serviceStatusInformation = serviceStatusInformation;
           this.wartungsfensterBis = wartungsfensterBis;
           this.wartungsfensterHinweis = wartungsfensterHinweis;
           this.wartungsfensterKennzeichen = wartungsfensterKennzeichen;
           this.wartungsfensterText = wartungsfensterText;
           this.wartungsfensterVon = wartungsfensterVon;
    }


    /**
     * Gets the ginaInfo value for this StatusInformationen.
     * 
     * @return ginaInfo
     */
    public at.chipkarte.client.base.soap.GinaInfo getGinaInfo() {
        return ginaInfo;
    }


    /**
     * Sets the ginaInfo value for this StatusInformationen.
     * 
     * @param ginaInfo
     */
    public void setGinaInfo(at.chipkarte.client.base.soap.GinaInfo ginaInfo) {
        this.ginaInfo = ginaInfo;
    }


    /**
     * Gets the serviceStatusInformation value for this StatusInformationen.
     * 
     * @return serviceStatusInformation
     */
    public at.chipkarte.client.base.soap.ServiceStatusInformation[] getServiceStatusInformation() {
        return serviceStatusInformation;
    }


    /**
     * Sets the serviceStatusInformation value for this StatusInformationen.
     * 
     * @param serviceStatusInformation
     */
    public void setServiceStatusInformation(at.chipkarte.client.base.soap.ServiceStatusInformation[] serviceStatusInformation) {
        this.serviceStatusInformation = serviceStatusInformation;
    }

    public at.chipkarte.client.base.soap.ServiceStatusInformation getServiceStatusInformation(int i) {
        return this.serviceStatusInformation[i];
    }

    public void setServiceStatusInformation(int i, at.chipkarte.client.base.soap.ServiceStatusInformation _value) {
        this.serviceStatusInformation[i] = _value;
    }


    /**
     * Gets the wartungsfensterBis value for this StatusInformationen.
     * 
     * @return wartungsfensterBis
     */
    public java.lang.String getWartungsfensterBis() {
        return wartungsfensterBis;
    }


    /**
     * Sets the wartungsfensterBis value for this StatusInformationen.
     * 
     * @param wartungsfensterBis
     */
    public void setWartungsfensterBis(java.lang.String wartungsfensterBis) {
        this.wartungsfensterBis = wartungsfensterBis;
    }


    /**
     * Gets the wartungsfensterHinweis value for this StatusInformationen.
     * 
     * @return wartungsfensterHinweis
     */
    public java.lang.String getWartungsfensterHinweis() {
        return wartungsfensterHinweis;
    }


    /**
     * Sets the wartungsfensterHinweis value for this StatusInformationen.
     * 
     * @param wartungsfensterHinweis
     */
    public void setWartungsfensterHinweis(java.lang.String wartungsfensterHinweis) {
        this.wartungsfensterHinweis = wartungsfensterHinweis;
    }


    /**
     * Gets the wartungsfensterKennzeichen value for this StatusInformationen.
     * 
     * @return wartungsfensterKennzeichen
     */
    public boolean isWartungsfensterKennzeichen() {
        return wartungsfensterKennzeichen;
    }


    /**
     * Sets the wartungsfensterKennzeichen value for this StatusInformationen.
     * 
     * @param wartungsfensterKennzeichen
     */
    public void setWartungsfensterKennzeichen(boolean wartungsfensterKennzeichen) {
        this.wartungsfensterKennzeichen = wartungsfensterKennzeichen;
    }


    /**
     * Gets the wartungsfensterText value for this StatusInformationen.
     * 
     * @return wartungsfensterText
     */
    public java.lang.String getWartungsfensterText() {
        return wartungsfensterText;
    }


    /**
     * Sets the wartungsfensterText value for this StatusInformationen.
     * 
     * @param wartungsfensterText
     */
    public void setWartungsfensterText(java.lang.String wartungsfensterText) {
        this.wartungsfensterText = wartungsfensterText;
    }


    /**
     * Gets the wartungsfensterVon value for this StatusInformationen.
     * 
     * @return wartungsfensterVon
     */
    public java.lang.String getWartungsfensterVon() {
        return wartungsfensterVon;
    }


    /**
     * Sets the wartungsfensterVon value for this StatusInformationen.
     * 
     * @param wartungsfensterVon
     */
    public void setWartungsfensterVon(java.lang.String wartungsfensterVon) {
        this.wartungsfensterVon = wartungsfensterVon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StatusInformationen)) return false;
        StatusInformationen other = (StatusInformationen) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ginaInfo==null && other.getGinaInfo()==null) || 
             (this.ginaInfo!=null &&
              this.ginaInfo.equals(other.getGinaInfo()))) &&
            ((this.serviceStatusInformation==null && other.getServiceStatusInformation()==null) || 
             (this.serviceStatusInformation!=null &&
              java.util.Arrays.equals(this.serviceStatusInformation, other.getServiceStatusInformation()))) &&
            ((this.wartungsfensterBis==null && other.getWartungsfensterBis()==null) || 
             (this.wartungsfensterBis!=null &&
              this.wartungsfensterBis.equals(other.getWartungsfensterBis()))) &&
            ((this.wartungsfensterHinweis==null && other.getWartungsfensterHinweis()==null) || 
             (this.wartungsfensterHinweis!=null &&
              this.wartungsfensterHinweis.equals(other.getWartungsfensterHinweis()))) &&
            this.wartungsfensterKennzeichen == other.isWartungsfensterKennzeichen() &&
            ((this.wartungsfensterText==null && other.getWartungsfensterText()==null) || 
             (this.wartungsfensterText!=null &&
              this.wartungsfensterText.equals(other.getWartungsfensterText()))) &&
            ((this.wartungsfensterVon==null && other.getWartungsfensterVon()==null) || 
             (this.wartungsfensterVon!=null &&
              this.wartungsfensterVon.equals(other.getWartungsfensterVon())));
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
        if (getGinaInfo() != null) {
            _hashCode += getGinaInfo().hashCode();
        }
        if (getServiceStatusInformation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceStatusInformation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceStatusInformation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWartungsfensterBis() != null) {
            _hashCode += getWartungsfensterBis().hashCode();
        }
        if (getWartungsfensterHinweis() != null) {
            _hashCode += getWartungsfensterHinweis().hashCode();
        }
        _hashCode += (isWartungsfensterKennzeichen() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getWartungsfensterText() != null) {
            _hashCode += getWartungsfensterText().hashCode();
        }
        if (getWartungsfensterVon() != null) {
            _hashCode += getWartungsfensterVon().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StatusInformationen.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "StatusInformationen"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ginaInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ginaInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "GinaInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceStatusInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "serviceStatusInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ServiceStatusInformation"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wartungsfensterBis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "wartungsfensterBis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wartungsfensterHinweis");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "wartungsfensterHinweis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wartungsfensterKennzeichen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "wartungsfensterKennzeichen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wartungsfensterText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "wartungsfensterText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wartungsfensterVon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "wartungsfensterVon"));
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
