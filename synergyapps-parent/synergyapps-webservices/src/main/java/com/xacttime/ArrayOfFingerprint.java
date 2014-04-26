
package com.xacttime;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFingerprint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFingerprint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fingerprint" type="{http://xacttime.com/}Fingerprint" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFingerprint", propOrder = {
    "fingerprint"
})
public class ArrayOfFingerprint {

    @XmlElement(name = "Fingerprint", nillable = true)
    protected List<Fingerprint> fingerprint;

    /**
     * Gets the value of the fingerprint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fingerprint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFingerprint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fingerprint }
     * 
     * 
     */
    public List<Fingerprint> getFingerprint() {
        if (fingerprint == null) {
            fingerprint = new ArrayList<Fingerprint>();
        }
        return this.fingerprint;
    }

}
