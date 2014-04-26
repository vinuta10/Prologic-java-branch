
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
 *         &lt;element name="GetFingerprintsResult" type="{http://xacttime.com/}ArrayOfFingerprint" minOccurs="0"/>
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
    "getFingerprintsResult"
})
@XmlRootElement(name = "GetFingerprintsResponse")
public class GetFingerprintsResponse {

    @XmlElement(name = "GetFingerprintsResult")
    protected ArrayOfFingerprint getFingerprintsResult;

    /**
     * Gets the value of the getFingerprintsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFingerprint }
     *     
     */
    public ArrayOfFingerprint getGetFingerprintsResult() {
        return getFingerprintsResult;
    }

    /**
     * Sets the value of the getFingerprintsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFingerprint }
     *     
     */
    public void setGetFingerprintsResult(ArrayOfFingerprint value) {
        this.getFingerprintsResult = value;
    }

}
