
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
 *         &lt;element name="RecordPunchResult" type="{http://xacttime.com/}PunchStatus" minOccurs="0"/>
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
    "recordPunchResult"
})
@XmlRootElement(name = "RecordPunchResponse")
public class RecordPunchResponse {

    @XmlElement(name = "RecordPunchResult")
    protected PunchStatus recordPunchResult;

    /**
     * Gets the value of the recordPunchResult property.
     * 
     * @return
     *     possible object is
     *     {@link PunchStatus }
     *     
     */
    public PunchStatus getRecordPunchResult() {
        return recordPunchResult;
    }

    /**
     * Sets the value of the recordPunchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PunchStatus }
     *     
     */
    public void setRecordPunchResult(PunchStatus value) {
        this.recordPunchResult = value;
    }

}
