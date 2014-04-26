
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
 *         &lt;element name="webServicesKey" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="fingerprint" type="{http://xacttime.com/}Fingerprint" minOccurs="0"/>
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
    "webServicesKey",
    "fingerprint"
})
@XmlRootElement(name = "SetFingerprint")
public class SetFingerprint {

    @XmlElement(required = true)
    protected String webServicesKey;
    protected Fingerprint fingerprint;

    /**
     * Gets the value of the webServicesKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebServicesKey() {
        return webServicesKey;
    }

    /**
     * Sets the value of the webServicesKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebServicesKey(String value) {
        this.webServicesKey = value;
    }

    /**
     * Gets the value of the fingerprint property.
     * 
     * @return
     *     possible object is
     *     {@link Fingerprint }
     *     
     */
    public Fingerprint getFingerprint() {
        return fingerprint;
    }

    /**
     * Sets the value of the fingerprint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fingerprint }
     *     
     */
    public void setFingerprint(Fingerprint value) {
        this.fingerprint = value;
    }

}
