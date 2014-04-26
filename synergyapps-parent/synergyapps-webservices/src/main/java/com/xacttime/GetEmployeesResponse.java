
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
 *         &lt;element name="GetEmployeesResult" type="{http://xacttime.com/}ArrayOfEmployee" minOccurs="0"/>
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
    "getEmployeesResult"
})
@XmlRootElement(name = "GetEmployeesResponse")
public class GetEmployeesResponse {

    @XmlElement(name = "GetEmployeesResult")
    protected ArrayOfEmployee getEmployeesResult;

    /**
     * Gets the value of the getEmployeesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployee }
     *     
     */
    public ArrayOfEmployee getGetEmployeesResult() {
        return getEmployeesResult;
    }

    /**
     * Sets the value of the getEmployeesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployee }
     *     
     */
    public void setGetEmployeesResult(ArrayOfEmployee value) {
        this.getEmployeesResult = value;
    }

}
