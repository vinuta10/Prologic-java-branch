
package com.xacttime;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BadgeNumber"/>
 *     &lt;enumeration value="EmployeeNumber"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdTypes")
@XmlEnum
public enum IdTypes {

    @XmlEnumValue("BadgeNumber")
    BADGE_NUMBER("BadgeNumber"),
    @XmlEnumValue("EmployeeNumber")
    EMPLOYEE_NUMBER("EmployeeNumber");
    private final String value;

    IdTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdTypes fromValue(String v) {
        for (IdTypes c: IdTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
