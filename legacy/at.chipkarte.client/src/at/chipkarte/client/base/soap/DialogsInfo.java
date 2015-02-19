/**
 * DialogsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.chipkarte.client.base.soap;

public class DialogsInfo  implements java.io.Serializable {
    private int currentDialogsCount;

    private int maxDialogsCount;

    public DialogsInfo() {
    }

    public DialogsInfo(
           int currentDialogsCount,
           int maxDialogsCount) {
           this.currentDialogsCount = currentDialogsCount;
           this.maxDialogsCount = maxDialogsCount;
    }


    /**
     * Gets the currentDialogsCount value for this DialogsInfo.
     * 
     * @return currentDialogsCount
     */
    public int getCurrentDialogsCount() {
        return currentDialogsCount;
    }


    /**
     * Sets the currentDialogsCount value for this DialogsInfo.
     * 
     * @param currentDialogsCount
     */
    public void setCurrentDialogsCount(int currentDialogsCount) {
        this.currentDialogsCount = currentDialogsCount;
    }


    /**
     * Gets the maxDialogsCount value for this DialogsInfo.
     * 
     * @return maxDialogsCount
     */
    public int getMaxDialogsCount() {
        return maxDialogsCount;
    }


    /**
     * Sets the maxDialogsCount value for this DialogsInfo.
     * 
     * @param maxDialogsCount
     */
    public void setMaxDialogsCount(int maxDialogsCount) {
        this.maxDialogsCount = maxDialogsCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DialogsInfo)) return false;
        DialogsInfo other = (DialogsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.currentDialogsCount == other.getCurrentDialogsCount() &&
            this.maxDialogsCount == other.getMaxDialogsCount();
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
        _hashCode += getCurrentDialogsCount();
        _hashCode += getMaxDialogsCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DialogsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "DialogsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentDialogsCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "currentDialogsCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxDialogsCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.base.client.chipkarte.at", "maxDialogsCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
