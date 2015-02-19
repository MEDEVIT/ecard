/**
 * Ordination.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class Ordination  implements java.io.Serializable {
    private java.lang.String bezirk;

    private java.lang.String bundeslandCode;

    private java.lang.String landCode;

    private java.lang.String ordinationId;

    private long ordinationNumber;

    private java.lang.String postleitzahl;

    private java.lang.String stadt;

    private java.lang.String strasse;

    private boolean uebersiedeln;

    private java.lang.String uebersiedelnDate;

    private java.lang.String vorgaengerOrdinationId;

    private at.chipkarte.client.base.soap.TaetigkeitsBereich[] taetigkeitsBereich;

    public Ordination() {
    }

    public Ordination(
           java.lang.String bezirk,
           java.lang.String bundeslandCode,
           java.lang.String landCode,
           java.lang.String ordinationId,
           long ordinationNumber,
           java.lang.String postleitzahl,
           java.lang.String stadt,
           java.lang.String strasse,
           boolean uebersiedeln,
           java.lang.String uebersiedelnDate,
           java.lang.String vorgaengerOrdinationId,
           at.chipkarte.client.base.soap.TaetigkeitsBereich[] taetigkeitsBereich) {
           this.bezirk = bezirk;
           this.bundeslandCode = bundeslandCode;
           this.landCode = landCode;
           this.ordinationId = ordinationId;
           this.ordinationNumber = ordinationNumber;
           this.postleitzahl = postleitzahl;
           this.stadt = stadt;
           this.strasse = strasse;
           this.uebersiedeln = uebersiedeln;
           this.uebersiedelnDate = uebersiedelnDate;
           this.vorgaengerOrdinationId = vorgaengerOrdinationId;
           this.taetigkeitsBereich = taetigkeitsBereich;
    }


    /**
     * Gets the bezirk value for this Ordination.
     * 
     * @return bezirk
     */
    public java.lang.String getBezirk() {
        return bezirk;
    }


    /**
     * Sets the bezirk value for this Ordination.
     * 
     * @param bezirk
     */
    public void setBezirk(java.lang.String bezirk) {
        this.bezirk = bezirk;
    }


    /**
     * Gets the bundeslandCode value for this Ordination.
     * 
     * @return bundeslandCode
     */
    public java.lang.String getBundeslandCode() {
        return bundeslandCode;
    }


    /**
     * Sets the bundeslandCode value for this Ordination.
     * 
     * @param bundeslandCode
     */
    public void setBundeslandCode(java.lang.String bundeslandCode) {
        this.bundeslandCode = bundeslandCode;
    }


    /**
     * Gets the landCode value for this Ordination.
     * 
     * @return landCode
     */
    public java.lang.String getLandCode() {
        return landCode;
    }


    /**
     * Sets the landCode value for this Ordination.
     * 
     * @param landCode
     */
    public void setLandCode(java.lang.String landCode) {
        this.landCode = landCode;
    }


    /**
     * Gets the ordinationId value for this Ordination.
     * 
     * @return ordinationId
     */
    public java.lang.String getOrdinationId() {
        return ordinationId;
    }


    /**
     * Sets the ordinationId value for this Ordination.
     * 
     * @param ordinationId
     */
    public void setOrdinationId(java.lang.String ordinationId) {
        this.ordinationId = ordinationId;
    }


    /**
     * Gets the ordinationNumber value for this Ordination.
     * 
     * @return ordinationNumber
     */
    public long getOrdinationNumber() {
        return ordinationNumber;
    }


    /**
     * Sets the ordinationNumber value for this Ordination.
     * 
     * @param ordinationNumber
     */
    public void setOrdinationNumber(long ordinationNumber) {
        this.ordinationNumber = ordinationNumber;
    }


    /**
     * Gets the postleitzahl value for this Ordination.
     * 
     * @return postleitzahl
     */
    public java.lang.String getPostleitzahl() {
        return postleitzahl;
    }


    /**
     * Sets the postleitzahl value for this Ordination.
     * 
     * @param postleitzahl
     */
    public void setPostleitzahl(java.lang.String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }


    /**
     * Gets the stadt value for this Ordination.
     * 
     * @return stadt
     */
    public java.lang.String getStadt() {
        return stadt;
    }


    /**
     * Sets the stadt value for this Ordination.
     * 
     * @param stadt
     */
    public void setStadt(java.lang.String stadt) {
        this.stadt = stadt;
    }


    /**
     * Gets the strasse value for this Ordination.
     * 
     * @return strasse
     */
    public java.lang.String getStrasse() {
        return strasse;
    }


    /**
     * Sets the strasse value for this Ordination.
     * 
     * @param strasse
     */
    public void setStrasse(java.lang.String strasse) {
        this.strasse = strasse;
    }


    /**
     * Gets the uebersiedeln value for this Ordination.
     * 
     * @return uebersiedeln
     */
    public boolean isUebersiedeln() {
        return uebersiedeln;
    }


    /**
     * Sets the uebersiedeln value for this Ordination.
     * 
     * @param uebersiedeln
     */
    public void setUebersiedeln(boolean uebersiedeln) {
        this.uebersiedeln = uebersiedeln;
    }


    /**
     * Gets the uebersiedelnDate value for this Ordination.
     * 
     * @return uebersiedelnDate
     */
    public java.lang.String getUebersiedelnDate() {
        return uebersiedelnDate;
    }


    /**
     * Sets the uebersiedelnDate value for this Ordination.
     * 
     * @param uebersiedelnDate
     */
    public void setUebersiedelnDate(java.lang.String uebersiedelnDate) {
        this.uebersiedelnDate = uebersiedelnDate;
    }


    /**
     * Gets the vorgaengerOrdinationId value for this Ordination.
     * 
     * @return vorgaengerOrdinationId
     */
    public java.lang.String getVorgaengerOrdinationId() {
        return vorgaengerOrdinationId;
    }


    /**
     * Sets the vorgaengerOrdinationId value for this Ordination.
     * 
     * @param vorgaengerOrdinationId
     */
    public void setVorgaengerOrdinationId(java.lang.String vorgaengerOrdinationId) {
        this.vorgaengerOrdinationId = vorgaengerOrdinationId;
    }


    /**
     * Gets the taetigkeitsBereich value for this Ordination.
     * 
     * @return taetigkeitsBereich
     */
    public at.chipkarte.client.base.soap.TaetigkeitsBereich[] getTaetigkeitsBereich() {
        return taetigkeitsBereich;
    }


    /**
     * Sets the taetigkeitsBereich value for this Ordination.
     * 
     * @param taetigkeitsBereich
     */
    public void setTaetigkeitsBereich(at.chipkarte.client.base.soap.TaetigkeitsBereich[] taetigkeitsBereich) {
        this.taetigkeitsBereich = taetigkeitsBereich;
    }

    public at.chipkarte.client.base.soap.TaetigkeitsBereich getTaetigkeitsBereich(int i) {
        return this.taetigkeitsBereich[i];
    }

    public void setTaetigkeitsBereich(int i, at.chipkarte.client.base.soap.TaetigkeitsBereich _value) {
        this.taetigkeitsBereich[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ordination)) return false;
        Ordination other = (Ordination) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bezirk==null && other.getBezirk()==null) || 
             (this.bezirk!=null &&
              this.bezirk.equals(other.getBezirk()))) &&
            ((this.bundeslandCode==null && other.getBundeslandCode()==null) || 
             (this.bundeslandCode!=null &&
              this.bundeslandCode.equals(other.getBundeslandCode()))) &&
            ((this.landCode==null && other.getLandCode()==null) || 
             (this.landCode!=null &&
              this.landCode.equals(other.getLandCode()))) &&
            ((this.ordinationId==null && other.getOrdinationId()==null) || 
             (this.ordinationId!=null &&
              this.ordinationId.equals(other.getOrdinationId()))) &&
            this.ordinationNumber == other.getOrdinationNumber() &&
            ((this.postleitzahl==null && other.getPostleitzahl()==null) || 
             (this.postleitzahl!=null &&
              this.postleitzahl.equals(other.getPostleitzahl()))) &&
            ((this.stadt==null && other.getStadt()==null) || 
             (this.stadt!=null &&
              this.stadt.equals(other.getStadt()))) &&
            ((this.strasse==null && other.getStrasse()==null) || 
             (this.strasse!=null &&
              this.strasse.equals(other.getStrasse()))) &&
            this.uebersiedeln == other.isUebersiedeln() &&
            ((this.uebersiedelnDate==null && other.getUebersiedelnDate()==null) || 
             (this.uebersiedelnDate!=null &&
              this.uebersiedelnDate.equals(other.getUebersiedelnDate()))) &&
            ((this.vorgaengerOrdinationId==null && other.getVorgaengerOrdinationId()==null) || 
             (this.vorgaengerOrdinationId!=null &&
              this.vorgaengerOrdinationId.equals(other.getVorgaengerOrdinationId()))) &&
            ((this.taetigkeitsBereich==null && other.getTaetigkeitsBereich()==null) || 
             (this.taetigkeitsBereich!=null &&
              java.util.Arrays.equals(this.taetigkeitsBereich, other.getTaetigkeitsBereich())));
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
        if (getBezirk() != null) {
            _hashCode += getBezirk().hashCode();
        }
        if (getBundeslandCode() != null) {
            _hashCode += getBundeslandCode().hashCode();
        }
        if (getLandCode() != null) {
            _hashCode += getLandCode().hashCode();
        }
        if (getOrdinationId() != null) {
            _hashCode += getOrdinationId().hashCode();
        }
        _hashCode += new Long(getOrdinationNumber()).hashCode();
        if (getPostleitzahl() != null) {
            _hashCode += getPostleitzahl().hashCode();
        }
        if (getStadt() != null) {
            _hashCode += getStadt().hashCode();
        }
        if (getStrasse() != null) {
            _hashCode += getStrasse().hashCode();
        }
        _hashCode += (isUebersiedeln() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUebersiedelnDate() != null) {
            _hashCode += getUebersiedelnDate().hashCode();
        }
        if (getVorgaengerOrdinationId() != null) {
            _hashCode += getVorgaengerOrdinationId().hashCode();
        }
        if (getTaetigkeitsBereich() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTaetigkeitsBereich());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTaetigkeitsBereich(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ordination.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Ordination"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bezirk");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "bezirk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bundeslandCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "bundeslandCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "landCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordinationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ordinationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postleitzahl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "postleitzahl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stadt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "stadt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strasse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "strasse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uebersiedeln");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "uebersiedeln"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uebersiedelnDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "uebersiedelnDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vorgaengerOrdinationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vorgaengerOrdinationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taetigkeitsBereich");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "taetigkeitsBereich"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "TaetigkeitsBereich"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
