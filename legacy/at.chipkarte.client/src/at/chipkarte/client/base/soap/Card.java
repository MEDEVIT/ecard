/**
 * Card.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class Card  implements java.io.Serializable {
    private java.lang.String cardType;

    private java.lang.String cin;

    private java.lang.String csn;

    private java.lang.String geburtsdatum;

    private java.lang.String geschlechtCode;

    private java.lang.String nachname;

    private java.lang.String nachnameLatin1;

    private java.lang.String nummer;

    private java.lang.String titel;

    private java.lang.String titelHinten;

    private java.lang.String titelHintenLatin1;

    private java.lang.String titelLatin1;

    private java.lang.String vorname;

    private java.lang.String vornameLatin1;

    public Card() {
    }

    public Card(
           java.lang.String cardType,
           java.lang.String cin,
           java.lang.String csn,
           java.lang.String geburtsdatum,
           java.lang.String geschlechtCode,
           java.lang.String nachname,
           java.lang.String nachnameLatin1,
           java.lang.String nummer,
           java.lang.String titel,
           java.lang.String titelHinten,
           java.lang.String titelHintenLatin1,
           java.lang.String titelLatin1,
           java.lang.String vorname,
           java.lang.String vornameLatin1) {
           this.cardType = cardType;
           this.cin = cin;
           this.csn = csn;
           this.geburtsdatum = geburtsdatum;
           this.geschlechtCode = geschlechtCode;
           this.nachname = nachname;
           this.nachnameLatin1 = nachnameLatin1;
           this.nummer = nummer;
           this.titel = titel;
           this.titelHinten = titelHinten;
           this.titelHintenLatin1 = titelHintenLatin1;
           this.titelLatin1 = titelLatin1;
           this.vorname = vorname;
           this.vornameLatin1 = vornameLatin1;
    }


    /**
     * Gets the cardType value for this Card.
     * 
     * @return cardType
     */
    public java.lang.String getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this Card.
     * 
     * @param cardType
     */
    public void setCardType(java.lang.String cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the cin value for this Card.
     * 
     * @return cin
     */
    public java.lang.String getCin() {
        return cin;
    }


    /**
     * Sets the cin value for this Card.
     * 
     * @param cin
     */
    public void setCin(java.lang.String cin) {
        this.cin = cin;
    }


    /**
     * Gets the csn value for this Card.
     * 
     * @return csn
     */
    public java.lang.String getCsn() {
        return csn;
    }


    /**
     * Sets the csn value for this Card.
     * 
     * @param csn
     */
    public void setCsn(java.lang.String csn) {
        this.csn = csn;
    }


    /**
     * Gets the geburtsdatum value for this Card.
     * 
     * @return geburtsdatum
     */
    public java.lang.String getGeburtsdatum() {
        return geburtsdatum;
    }


    /**
     * Sets the geburtsdatum value for this Card.
     * 
     * @param geburtsdatum
     */
    public void setGeburtsdatum(java.lang.String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }


    /**
     * Gets the geschlechtCode value for this Card.
     * 
     * @return geschlechtCode
     */
    public java.lang.String getGeschlechtCode() {
        return geschlechtCode;
    }


    /**
     * Sets the geschlechtCode value for this Card.
     * 
     * @param geschlechtCode
     */
    public void setGeschlechtCode(java.lang.String geschlechtCode) {
        this.geschlechtCode = geschlechtCode;
    }


    /**
     * Gets the nachname value for this Card.
     * 
     * @return nachname
     */
    public java.lang.String getNachname() {
        return nachname;
    }


    /**
     * Sets the nachname value for this Card.
     * 
     * @param nachname
     */
    public void setNachname(java.lang.String nachname) {
        this.nachname = nachname;
    }


    /**
     * Gets the nachnameLatin1 value for this Card.
     * 
     * @return nachnameLatin1
     */
    public java.lang.String getNachnameLatin1() {
        return nachnameLatin1;
    }


    /**
     * Sets the nachnameLatin1 value for this Card.
     * 
     * @param nachnameLatin1
     */
    public void setNachnameLatin1(java.lang.String nachnameLatin1) {
        this.nachnameLatin1 = nachnameLatin1;
    }


    /**
     * Gets the nummer value for this Card.
     * 
     * @return nummer
     */
    public java.lang.String getNummer() {
        return nummer;
    }


    /**
     * Sets the nummer value for this Card.
     * 
     * @param nummer
     */
    public void setNummer(java.lang.String nummer) {
        this.nummer = nummer;
    }


    /**
     * Gets the titel value for this Card.
     * 
     * @return titel
     */
    public java.lang.String getTitel() {
        return titel;
    }


    /**
     * Sets the titel value for this Card.
     * 
     * @param titel
     */
    public void setTitel(java.lang.String titel) {
        this.titel = titel;
    }


    /**
     * Gets the titelHinten value for this Card.
     * 
     * @return titelHinten
     */
    public java.lang.String getTitelHinten() {
        return titelHinten;
    }


    /**
     * Sets the titelHinten value for this Card.
     * 
     * @param titelHinten
     */
    public void setTitelHinten(java.lang.String titelHinten) {
        this.titelHinten = titelHinten;
    }


    /**
     * Gets the titelHintenLatin1 value for this Card.
     * 
     * @return titelHintenLatin1
     */
    public java.lang.String getTitelHintenLatin1() {
        return titelHintenLatin1;
    }


    /**
     * Sets the titelHintenLatin1 value for this Card.
     * 
     * @param titelHintenLatin1
     */
    public void setTitelHintenLatin1(java.lang.String titelHintenLatin1) {
        this.titelHintenLatin1 = titelHintenLatin1;
    }


    /**
     * Gets the titelLatin1 value for this Card.
     * 
     * @return titelLatin1
     */
    public java.lang.String getTitelLatin1() {
        return titelLatin1;
    }


    /**
     * Sets the titelLatin1 value for this Card.
     * 
     * @param titelLatin1
     */
    public void setTitelLatin1(java.lang.String titelLatin1) {
        this.titelLatin1 = titelLatin1;
    }


    /**
     * Gets the vorname value for this Card.
     * 
     * @return vorname
     */
    public java.lang.String getVorname() {
        return vorname;
    }


    /**
     * Sets the vorname value for this Card.
     * 
     * @param vorname
     */
    public void setVorname(java.lang.String vorname) {
        this.vorname = vorname;
    }


    /**
     * Gets the vornameLatin1 value for this Card.
     * 
     * @return vornameLatin1
     */
    public java.lang.String getVornameLatin1() {
        return vornameLatin1;
    }


    /**
     * Sets the vornameLatin1 value for this Card.
     * 
     * @param vornameLatin1
     */
    public void setVornameLatin1(java.lang.String vornameLatin1) {
        this.vornameLatin1 = vornameLatin1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.cin==null && other.getCin()==null) || 
             (this.cin!=null &&
              this.cin.equals(other.getCin()))) &&
            ((this.csn==null && other.getCsn()==null) || 
             (this.csn!=null &&
              this.csn.equals(other.getCsn()))) &&
            ((this.geburtsdatum==null && other.getGeburtsdatum()==null) || 
             (this.geburtsdatum!=null &&
              this.geburtsdatum.equals(other.getGeburtsdatum()))) &&
            ((this.geschlechtCode==null && other.getGeschlechtCode()==null) || 
             (this.geschlechtCode!=null &&
              this.geschlechtCode.equals(other.getGeschlechtCode()))) &&
            ((this.nachname==null && other.getNachname()==null) || 
             (this.nachname!=null &&
              this.nachname.equals(other.getNachname()))) &&
            ((this.nachnameLatin1==null && other.getNachnameLatin1()==null) || 
             (this.nachnameLatin1!=null &&
              this.nachnameLatin1.equals(other.getNachnameLatin1()))) &&
            ((this.nummer==null && other.getNummer()==null) || 
             (this.nummer!=null &&
              this.nummer.equals(other.getNummer()))) &&
            ((this.titel==null && other.getTitel()==null) || 
             (this.titel!=null &&
              this.titel.equals(other.getTitel()))) &&
            ((this.titelHinten==null && other.getTitelHinten()==null) || 
             (this.titelHinten!=null &&
              this.titelHinten.equals(other.getTitelHinten()))) &&
            ((this.titelHintenLatin1==null && other.getTitelHintenLatin1()==null) || 
             (this.titelHintenLatin1!=null &&
              this.titelHintenLatin1.equals(other.getTitelHintenLatin1()))) &&
            ((this.titelLatin1==null && other.getTitelLatin1()==null) || 
             (this.titelLatin1!=null &&
              this.titelLatin1.equals(other.getTitelLatin1()))) &&
            ((this.vorname==null && other.getVorname()==null) || 
             (this.vorname!=null &&
              this.vorname.equals(other.getVorname()))) &&
            ((this.vornameLatin1==null && other.getVornameLatin1()==null) || 
             (this.vornameLatin1!=null &&
              this.vornameLatin1.equals(other.getVornameLatin1())));
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
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getCin() != null) {
            _hashCode += getCin().hashCode();
        }
        if (getCsn() != null) {
            _hashCode += getCsn().hashCode();
        }
        if (getGeburtsdatum() != null) {
            _hashCode += getGeburtsdatum().hashCode();
        }
        if (getGeschlechtCode() != null) {
            _hashCode += getGeschlechtCode().hashCode();
        }
        if (getNachname() != null) {
            _hashCode += getNachname().hashCode();
        }
        if (getNachnameLatin1() != null) {
            _hashCode += getNachnameLatin1().hashCode();
        }
        if (getNummer() != null) {
            _hashCode += getNummer().hashCode();
        }
        if (getTitel() != null) {
            _hashCode += getTitel().hashCode();
        }
        if (getTitelHinten() != null) {
            _hashCode += getTitelHinten().hashCode();
        }
        if (getTitelHintenLatin1() != null) {
            _hashCode += getTitelHintenLatin1().hashCode();
        }
        if (getTitelLatin1() != null) {
            _hashCode += getTitelLatin1().hashCode();
        }
        if (getVorname() != null) {
            _hashCode += getVorname().hashCode();
        }
        if (getVornameLatin1() != null) {
            _hashCode += getVornameLatin1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Card.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "Card"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "csn"));
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
        elemField.setFieldName("geschlechtCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "geschlechtCode"));
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
        elemField.setFieldName("nachnameLatin1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "nachnameLatin1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nummer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "nummer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titel"));
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
        elemField.setFieldName("titelHintenLatin1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titelHintenLatin1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titelLatin1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "titelLatin1"));
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
        elemField.setFieldName("vornameLatin1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "vornameLatin1"));
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
