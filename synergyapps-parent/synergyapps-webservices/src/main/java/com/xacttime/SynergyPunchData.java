
package com.xacttime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SynergyPunchData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SynergyPunchData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TransactionTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "SynergyPunchData", propOrder = {
    "userId",
    "transactionTime",
    "punchType",
    "laborLevelDetailIds"
})
public class SynergyPunchData {

    @XmlElement(name = "UserId")
    protected int userId;
    @XmlElement(name = "TransactionTime")
    protected long transactionTime;
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
     */
    public long getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets the value of the transactionTime property.
     * 
     */
    public void setTransactionTime(long value) {
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
