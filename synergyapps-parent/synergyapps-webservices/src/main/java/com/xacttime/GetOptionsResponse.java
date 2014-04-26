
package com.xacttime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetOptionsResult" type="{http://xacttime.com/}Options" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getOptionsResult"
})
@XmlRootElement(name = "GetOptionsResponse")
public class GetOptionsResponse {

    @XmlElement(name = "GetOptionsResult")
    protected Options getOptionsResult;

    /**
     * Gets the value of the getOptionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link Options }
     *     
     */
    public Options getGetOptionsResult() {
        return getOptionsResult;
    }

    /**
     * Sets the value of the getOptionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Options }
     *     
     */
    public void setGetOptionsResult(Options value) {
        this.getOptionsResult = value;
    }

}
