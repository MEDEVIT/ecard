/**
 * ReaderStatusEvent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class ReaderStatusEvent  implements java.io.Serializable {
    private java.lang.String cardReaderId;

    private java.lang.String cardReaderState;

    private java.lang.String cardType;

    private java.lang.String eventType;

    private java.lang.String timeStamp;

    public ReaderStatusEvent() {
    }

    public ReaderStatusEvent(
           java.lang.String cardReaderId,
           java.lang.String cardReaderState,
           java.lang.String cardType,
           java.lang.String eventType,
           java.lang.String timeStamp) {
           this.cardReaderId = cardReaderId;
           this.cardReaderState = cardReaderState;
           this.cardType = cardType;
           this.eventType = eventType;
           this.timeStamp = timeStamp;
    }


    /**
     * Gets the cardReaderId value for this ReaderStatusEvent.
     * 
     * @return cardReaderId
     */
    public java.lang.String getCardReaderId() {
        return cardReaderId;
    }


    /**
     * Sets the cardReaderId value for this ReaderStatusEvent.
     * 
     * @param cardReaderId
     */
    public void setCardReaderId(java.lang.String cardReaderId) {
        this.cardReaderId = cardReaderId;
    }


    /**
     * Gets the cardReaderState value for this ReaderStatusEvent.
     * 
     * @return cardReaderState
     */
    public java.lang.String getCardReaderState() {
        return cardReaderState;
    }


    /**
     * Sets the cardReaderState value for this ReaderStatusEvent.
     * 
     * @param cardReaderState
     */
    public void setCardReaderState(java.lang.String cardReaderState) {
        this.cardReaderState = cardReaderState;
    }


    /**
     * Gets the cardType value for this ReaderStatusEvent.
     * 
     * @return cardType
     */
    public java.lang.String getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this ReaderStatusEvent.
     * 
     * @param cardType
     */
    public void setCardType(java.lang.String cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the eventType value for this ReaderStatusEvent.
     * 
     * @return eventType
     */
    public java.lang.String getEventType() {
        return eventType;
    }


    /**
     * Sets the eventType value for this ReaderStatusEvent.
     * 
     * @param eventType
     */
    public void setEventType(java.lang.String eventType) {
        this.eventType = eventType;
    }


    /**
     * Gets the timeStamp value for this ReaderStatusEvent.
     * 
     * @return timeStamp
     */
    public java.lang.String getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this ReaderStatusEvent.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.lang.String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReaderStatusEvent)) return false;
        ReaderStatusEvent other = (ReaderStatusEvent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cardReaderId==null && other.getCardReaderId()==null) || 
             (this.cardReaderId!=null &&
              this.cardReaderId.equals(other.getCardReaderId()))) &&
            ((this.cardReaderState==null && other.getCardReaderState()==null) || 
             (this.cardReaderState!=null &&
              this.cardReaderState.equals(other.getCardReaderState()))) &&
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.eventType==null && other.getEventType()==null) || 
             (this.eventType!=null &&
              this.eventType.equals(other.getEventType()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp())));
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
        if (getCardReaderId() != null) {
            _hashCode += getCardReaderId().hashCode();
        }
        if (getCardReaderState() != null) {
            _hashCode += getCardReaderState().hashCode();
        }
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getEventType() != null) {
            _hashCode += getEventType().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReaderStatusEvent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "ReaderStatusEvent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardReaderId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardReaderState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardReaderState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "cardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "eventType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "timeStamp"));
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
