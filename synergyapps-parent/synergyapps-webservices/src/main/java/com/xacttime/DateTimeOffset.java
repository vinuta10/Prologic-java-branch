
package com.xacttime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;


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
	private DateTime myTime;
	
	public DateTimeOffset(){
		
	}
	
	public DateTimeOffset(DateTime dt){
		myTime = dt;
	}

	public DateTime getMyTime() {
		return myTime;
	}

	public void setMyTime(DateTime myTime) {
		this.myTime = myTime;
	}

}
