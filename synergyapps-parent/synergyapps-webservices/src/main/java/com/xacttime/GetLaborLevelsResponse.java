
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
 *         &lt;element name="GetLaborLevelsResult" type="{http://xacttime.com/}ArrayOfLaborLevel" minOccurs="0"/>
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
    "getLaborLevelsResult"
})
@XmlRootElement(name = "GetLaborLevelsResponse")
public class GetLaborLevelsResponse {

    @XmlElement(name = "GetLaborLevelsResult")
    protected ArrayOfLaborLevel getLaborLevelsResult;

    /**
     * Gets the value of the getLaborLevelsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLaborLevel }
     *     
     */
    public ArrayOfLaborLevel getGetLaborLevelsResult() {
        return getLaborLevelsResult;
    }

    /**
     * Sets the value of the getLaborLevelsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLaborLevel }
     *     
     */
    public void setGetLaborLevelsResult(ArrayOfLaborLevel value) {
        this.getLaborLevelsResult = value;
    }

}
