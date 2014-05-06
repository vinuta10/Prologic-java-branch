
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
 *         &lt;element name="SynergyRecordPunchResult" type="{http://xacttime.com/}PunchStatus" minOccurs="0"/>
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
    "synergyRecordPunchResult"
})
@XmlRootElement(name = "SynergyRecordPunchResponse")
public class SynergyRecordPunchResponse {

    @XmlElement(name = "SynergyRecordPunchResult")
    protected PunchStatus synergyRecordPunchResult;

    /**
     * Gets the value of the synergyRecordPunchResult property.
     * 
     * @return
     *     possible object is
     *     {@link PunchStatus }
     *     
     */
    public PunchStatus getSynergyRecordPunchResult() {
        return synergyRecordPunchResult;
    }

    /**
     * Sets the value of the synergyRecordPunchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PunchStatus }
     *     
     */
    public void setSynergyRecordPunchResult(PunchStatus value) {
        this.synergyRecordPunchResult = value;
    }

}
