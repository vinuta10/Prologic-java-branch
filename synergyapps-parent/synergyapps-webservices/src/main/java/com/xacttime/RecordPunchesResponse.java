
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
 *         &lt;element name="RecordPunchesResult" type="{http://xacttime.com/}ArrayOfPunchStatus" minOccurs="0"/>
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
    "recordPunchesResult"
})
@XmlRootElement(name = "RecordPunchesResponse")
public class RecordPunchesResponse {

    @XmlElement(name = "RecordPunchesResult")
    protected ArrayOfPunchStatus recordPunchesResult;

    /**
     * Gets the value of the recordPunchesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPunchStatus }
     *     
     */
    public ArrayOfPunchStatus getRecordPunchesResult() {
        return recordPunchesResult;
    }

    /**
     * Sets the value of the recordPunchesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPunchStatus }
     *     
     */
    public void setRecordPunchesResult(ArrayOfPunchStatus value) {
        this.recordPunchesResult = value;
    }

}
