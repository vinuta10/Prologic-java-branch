
package com.xacttime;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLaborLevel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLaborLevel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LaborLevel" type="{http://xacttime.com/}LaborLevel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLaborLevel", propOrder = {
    "laborLevel"
})
public class ArrayOfLaborLevel {

    @XmlElement(name = "LaborLevel", nillable = true)
    protected List<LaborLevel> laborLevel;

    /**
     * Gets the value of the laborLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the laborLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaborLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LaborLevel }
     * 
     * 
     */
    public List<LaborLevel> getLaborLevel() {
        if (laborLevel == null) {
            laborLevel = new ArrayList<LaborLevel>();
        }
        return this.laborLevel;
    }

}
