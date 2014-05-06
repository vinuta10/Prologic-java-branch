
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
 *         &lt;element name="SynergyRecordPunchesResult" type="{http://xacttime.com/}ArrayOfPunchStatus" minOccurs="0"/>
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
    "synergyRecordPunchesResult"
})
@XmlRootElement(name = "SynergyRecordPunchesResponse")
public class SynergyRecordPunchesResponse {

    @XmlElement(name = "SynergyRecordPunchesResult")
    protected ArrayOfPunchStatus synergyRecordPunchesResult;

    /**
     * Gets the value of the synergyRecordPunchesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPunchStatus }
     *     
     */
    public ArrayOfPunchStatus getSynergyRecordPunchesResult() {
        return synergyRecordPunchesResult;
    }

    /**
     * Sets the value of the synergyRecordPunchesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPunchStatus }
     *     
     */
    public void setSynergyRecordPunchesResult(ArrayOfPunchStatus value) {
        this.synergyRecordPunchesResult = value;
    }

}
