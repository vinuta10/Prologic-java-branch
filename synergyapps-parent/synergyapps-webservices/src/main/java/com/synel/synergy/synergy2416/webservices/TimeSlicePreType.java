/**
 * TimeSlicePreType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.synel.synergy.synergy2416.webservices

public class TimeSlicePreType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TimeSlicePreType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NonWork = "NonWork";
    public static final java.lang.String _Transfer = "Transfer";
    public static final java.lang.String _StartLunch = "StartLunch";
    public static final java.lang.String _StartBreak = "StartBreak";
    public static final java.lang.String _ClockIn = "ClockIn";
    public static final java.lang.String _ClockOut = "ClockOut";
    public static final java.lang.String _EndLunch = "EndLunch";
    public static final java.lang.String _EndBreak = "EndBreak";
    public static final java.lang.String _PayAdjustment = "PayAdjustment";
    public static final java.lang.String _SwipeAndGo = "SwipeAndGo";
    public static final java.lang.String _CallBack = "CallBack";
    public static final TimeSlicePreType NonWork = new TimeSlicePreType(_NonWork);
    public static final TimeSlicePreType Transfer = new TimeSlicePreType(_Transfer);
    public static final TimeSlicePreType StartLunch = new TimeSlicePreType(_StartLunch);
    public static final TimeSlicePreType StartBreak = new TimeSlicePreType(_StartBreak);
    public static final TimeSlicePreType ClockIn = new TimeSlicePreType(_ClockIn);
    public static final TimeSlicePreType ClockOut = new TimeSlicePreType(_ClockOut);
    public static final TimeSlicePreType EndLunch = new TimeSlicePreType(_EndLunch);
    public static final TimeSlicePreType EndBreak = new TimeSlicePreType(_EndBreak);
    public static final TimeSlicePreType PayAdjustment = new TimeSlicePreType(_PayAdjustment);
    public static final TimeSlicePreType SwipeAndGo = new TimeSlicePreType(_SwipeAndGo);
    public static final TimeSlicePreType CallBack = new TimeSlicePreType(_CallBack);
    public java.lang.String getValue() { return _value_;}
    public static TimeSlicePreType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TimeSlicePreType enumeration = (TimeSlicePreType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TimeSlicePreType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeSlicePreType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xacttime.com/", "TimeSlicePreType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
