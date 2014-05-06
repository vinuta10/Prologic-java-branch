
package com.xacttime;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSynergyPunchData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSynergyPunchData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SynergyPunchData" type="{http://xacttime.com/}SynergyPunchData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSynergyPunchData", propOrder = {
    "synergyPunchData"
})
public class ArrayOfSynergyPunchData {

    @XmlElement(name = "SynergyPunchData", nillable = true)
    protected List<SynergyPunchData> synergyPunchData;

    /**
     * Gets the value of the synergyPunchData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the synergyPunchData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSynergyPunchData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SynergyPunchData }
     * 
     * 
     */
    public List<SynergyPunchData> getSynergyPunchData() {
        if (synergyPunchData == null) {
            synergyPunchData = new ArrayList<SynergyPunchData>();
        }
        return this.synergyPunchData;
    }

}
