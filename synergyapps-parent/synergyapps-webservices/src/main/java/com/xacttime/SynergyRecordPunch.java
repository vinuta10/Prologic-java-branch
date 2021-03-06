
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
 *         &lt;element name="terminalId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="punch" type="{http://xacttime.com/}SynergyPunchData" minOccurs="0"/>
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
    "terminalId",
    "punch"
})
@XmlRootElement(name = "SynergyRecordPunch")
public class SynergyRecordPunch {

    @XmlElement(required = true)
    protected String webServicesKey;
    protected int terminalId;
    protected SynergyPunchData punch;

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
     * Gets the value of the terminalId property.
     * 
     */
    public int getTerminalId() {
        return terminalId;
    }

    /**
     * Sets the value of the terminalId property.
     * 
     */
    public void setTerminalId(int value) {
        this.terminalId = value;
    }

    /**
     * Gets the value of the punch property.
     * 
     * @return
     *     possible object is
     *     {@link SynergyPunchData }
     *     
     */
    public SynergyPunchData getPunch() {
        return punch;
    }

    /**
     * Sets the value of the punch property.
     * 
     * @param value
     *     allowed object is
     *     {@link SynergyPunchData }
     *     
     */
    public void setPunch(SynergyPunchData value) {
        this.punch = value;
    }

}
