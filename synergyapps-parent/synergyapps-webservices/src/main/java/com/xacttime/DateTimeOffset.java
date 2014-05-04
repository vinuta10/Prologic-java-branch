
package com.xacttime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DateTimeOffset complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateTimeOffset">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateTimeOffset")
public class DateTimeOffset {

private long myepoch;
	
	public DateTimeOffset(){
		
	}
	
	public DateTimeOffset(long epoch) {
		setMyepoch(epoch);
	}

	public long getMyepoch() {
		return myepoch;
	}

	public void setMyepoch(long myepoch) {
		this.myepoch = myepoch;
	}
	
}
