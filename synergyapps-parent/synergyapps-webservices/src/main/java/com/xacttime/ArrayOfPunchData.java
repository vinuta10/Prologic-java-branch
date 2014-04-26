
package com.xacttime;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPunchData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPunchData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PunchData" type="{http://xacttime.com/}PunchData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPunchData", propOrder = {
    "punchData"
})
public class ArrayOfPunchData {

    @XmlElement(name = "PunchData", nillable = true)
    protected List<PunchData> punchData;

    /**
     * Gets the value of the punchData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the punchData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPunchData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PunchData }
     * 
     * 
     */
    public List<PunchData> getPunchData() {
        if (punchData == null) {
            punchData = new ArrayList<PunchData>();
        }
        return this.punchData;
    }

}
