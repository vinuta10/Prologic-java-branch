/**
 * PunchData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.synel.synergy.synergy2416.webservices

public class PunchData  implements java.io.Serializable {
    private int userId;

    private com.xacttime.DateTimeOffset transactionTime;

    private com.xacttime.TimeSlicePreType punchType;

    private int[] laborLevelDetailIds;

    public PunchData() {
    }

    public PunchData(
           int userId,
           com.xacttime.DateTimeOffset transactionTime,
           com.xacttime.TimeSlicePreType punchType,
           int[] laborLevelDetailIds) {
           this.userId = userId;
           this.transactionTime = transactionTime;
           this.punchType = punchType;
           this.laborLevelDetailIds = laborLevelDetailIds;
    }


    /**
     * Gets the userId value for this PunchData.
     * 
     * @return userId
     */
    public int getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this PunchData.
     * 
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }


    /**
     * Gets the transactionTime value for this PunchData.
     * 
     * @return transactionTime
     */
    public com.xacttime.DateTimeOffset getTransactionTime() {
        return transactionTime;
    }


    /**
     * Sets the transactionTime value for this PunchData.
     * 
     * @param transactionTime
     */
    public void setTransactionTime(com.xacttime.DateTimeOffset transactionTime) {
        this.transactionTime = transactionTime;
    }


    /**
     * Gets the punchType value for this PunchData.
     * 
     * @return punchType
     */
    public com.xacttime.TimeSlicePreType getPunchType() {
        return punchType;
    }


    /**
     * Sets the punchType value for this PunchData.
     * 
     * @param punchType
     */
    public void setPunchType(com.xacttime.TimeSlicePreType punchType) {
        this.punchType = punchType;
    }


    /**
     * Gets the laborLevelDetailIds value for this PunchData.
     * 
     * @return laborLevelDetailIds
     */
    public int[] getLaborLevelDetailIds() {
        return laborLevelDetailIds;
    }


    /**
     * Sets the laborLevelDetailIds value for this PunchData.
     * 
     * @param laborLevelDetailIds
     */
    public void setLaborLevelDetailIds(int[] laborLevelDetailIds) {
        this.laborLevelDetailIds = laborLevelDetailIds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PunchData)) return false;
        PunchData other = (PunchData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.userId == other.getUserId() &&
            ((this.transactionTime==null && other.getTransactionTime()==null) || 
             (this.transactionTime!=null &&
              this.transactionTime.equals(other.getTransactionTime()))) &&
            ((this.punchType==null && other.getPunchType()==null) || 
             (this.punchType!=null &&
              this.punchType.equals(other.getPunchType()))) &&
            ((this.laborLevelDetailIds==null && other.getLaborLevelDetailIds()==null) || 
             (this.laborLevelDetailIds!=null &&
              java.util.Arrays.equals(this.laborLevelDetailIds, other.getLaborLevelDetailIds())));
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
        _hashCode += getUserId();
        if (getTransactionTime() != null) {
            _hashCode += getTransactionTime().hashCode();
        }
        if (getPunchType() != null) {
            _hashCode += getPunchType().hashCode();
        }
        if (getLaborLevelDetailIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLaborLevelDetailIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLaborLevelDetailIds(), i);
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
        new org.apache.axis.description.TypeDesc(PunchData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xacttime.com/", "PunchData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xacttime.com/", "UserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xacttime.com/", "TransactionTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xacttime.com/", "DateTimeOffset"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punchType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xacttime.com/", "PunchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xacttime.com/", "TimeSlicePreType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("laborLevelDetailIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xacttime.com/", "LaborLevelDetailIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xacttime.com/", "int"));
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
