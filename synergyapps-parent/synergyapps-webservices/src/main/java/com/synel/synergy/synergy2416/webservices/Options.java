/**
 * Options.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.synel.synergy.synergy2416.webservices;

public class Options  implements java.io.Serializable {
    private IdTypes identifyUsersWith;

    private java.lang.String timeZone;

    public Options() {
    }

    public Options(
           IdTypes identifyUsersWith,
           java.lang.String timeZone) {
           this.identifyUsersWith = identifyUsersWith;
           this.timeZone = timeZone;
    }


    /**
     * Gets the identifyUsersWith value for this Options.
     * 
     * @return identifyUsersWith
     */
    public IdTypes getIdentifyUsersWith() {
        return identifyUsersWith;
    }


    /**
     * Sets the identifyUsersWith value for this Options.
     * 
     * @param identifyUsersWith
     */
    public void setIdentifyUsersWith(IdTypes identifyUsersWith) {
        this.identifyUsersWith = identifyUsersWith;
    }


    /**
     * Gets the timeZone value for this Options.
     * 
     * @return timeZone
     */
    public java.lang.String getTimeZone() {
        return timeZone;
    }


    /**
     * Sets the timeZone value for this Options.
     * 
     * @param timeZone
     */
    public void setTimeZone(java.lang.String timeZone) {
        this.timeZone = timeZone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Options)) return false;
        Options other = (Options) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.identifyUsersWith==null && other.getIdentifyUsersWith()==null) || 
             (this.identifyUsersWith!=null &&
              this.identifyUsersWith.equals(other.getIdentifyUsersWith()))) &&
            ((this.timeZone==null && other.getTimeZone()==null) || 
             (this.timeZone!=null &&
              this.timeZone.equals(other.getTimeZone())));
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
        if (getIdentifyUsersWith() != null) {
            _hashCode += getIdentifyUsersWith().hashCode();
        }
        if (getTimeZone() != null) {
            _hashCode += getTimeZone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Options.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xacttime.com/", "Options"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifyUsersWith");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xacttime.com/", "IdentifyUsersWith"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xacttime.com/", "IdTypes"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xacttime.com/", "TimeZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
