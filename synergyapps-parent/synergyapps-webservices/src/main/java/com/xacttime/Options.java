
package com.xacttime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Options complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Options">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentifyUsersWith" type="{http://xacttime.com/}IdTypes"/>
 *         &lt;element name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Options", propOrder = {
    "identifyUsersWith",
    "timeZone"
})
public class Options {

    @XmlElement(name = "IdentifyUsersWith", required = true)
    protected IdTypes identifyUsersWith;
    @XmlElement(name = "TimeZone")
    protected String timeZone;

    /**
     * Gets the value of the identifyUsersWith property.
     * 
     * @return
     *     possible object is
     *     {@link IdTypes }
     *     
     */
    public IdTypes getIdentifyUsersWith() {
        return identifyUsersWith;
    }

    /**
     * Sets the value of the identifyUsersWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdTypes }
     *     
     */
    public void setIdentifyUsersWith(IdTypes value) {
        this.identifyUsersWith = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

}
