
package com.xacttime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PunchData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PunchData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TransactionTime" type="{http://xacttime.com/}DateTimeOffset"/>
 *         &lt;element name="PunchType" type="{http://xacttime.com/}TimeSlicePreType"/>
 *         &lt;element name="LaborLevelDetailIds" type="{http://xacttime.com/}ArrayOfInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PunchData", propOrder = {
    "userId",
    "transactionTime",
    "punchType",
    "laborLevelDetailIds"
})
public class PunchData {

    @XmlElement(name = "UserId")
    protected int userId;
    @XmlElement(name = "TransactionTime", required = true)
    protected DateTimeOffset transactionTime;
    @XmlElement(name = "PunchType", required = true)
    protected TimeSlicePreType punchType;
    @XmlElement(name = "LaborLevelDetailIds")
    protected ArrayOfInt laborLevelDetailIds;

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the transactionTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeOffset }
     *     
     */
    public DateTimeOffset getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets the value of the transactionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeOffset }
     *     
     */
    public void setTransactionTime(DateTimeOffset value) {
        this.transactionTime = value;
    }

    /**
     * Gets the value of the punchType property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSlicePreType }
     *     
     */
    public TimeSlicePreType getPunchType() {
        return punchType;
    }

    /**
     * Sets the value of the punchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSlicePreType }
     *     
     */
    public void setPunchType(TimeSlicePreType value) {
        this.punchType = value;
    }

    /**
     * Gets the value of the laborLevelDetailIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getLaborLevelDetailIds() {
        return laborLevelDetailIds;
    }

    /**
     * Sets the value of the laborLevelDetailIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setLaborLevelDetailIds(ArrayOfInt value) {
        this.laborLevelDetailIds = value;
    }

}
