
package com.xacttime;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeSlicePreType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TimeSlicePreType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NonWork"/>
 *     &lt;enumeration value="Transfer"/>
 *     &lt;enumeration value="StartLunch"/>
 *     &lt;enumeration value="StartBreak"/>
 *     &lt;enumeration value="ClockIn"/>
 *     &lt;enumeration value="ClockOut"/>
 *     &lt;enumeration value="EndLunch"/>
 *     &lt;enumeration value="EndBreak"/>
 *     &lt;enumeration value="PayAdjustment"/>
 *     &lt;enumeration value="SwipeAndGo"/>
 *     &lt;enumeration value="CallBack"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TimeSlicePreType")
@XmlEnum
public enum TimeSlicePreType {

    @XmlEnumValue("NonWork")
    NON_WORK("NonWork"),
    @XmlEnumValue("Transfer")
    TRANSFER("Transfer"),
    @XmlEnumValue("StartLunch")
    START_LUNCH("StartLunch"),
    @XmlEnumValue("StartBreak")
    START_BREAK("StartBreak"),
    @XmlEnumValue("ClockIn")
    CLOCK_IN("ClockIn"),
    @XmlEnumValue("ClockOut")
    CLOCK_OUT("ClockOut"),
    @XmlEnumValue("EndLunch")
    END_LUNCH("EndLunch"),
    @XmlEnumValue("EndBreak")
    END_BREAK("EndBreak"),
    @XmlEnumValue("PayAdjustment")
    PAY_ADJUSTMENT("PayAdjustment"),
    @XmlEnumValue("SwipeAndGo")
    SWIPE_AND_GO("SwipeAndGo"),
    @XmlEnumValue("CallBack")
    CALL_BACK("CallBack");
    private final String value;

    TimeSlicePreType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimeSlicePreType fromValue(String v) {
        for (TimeSlicePreType c: TimeSlicePreType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
