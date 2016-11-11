
package com.mindbodyonline.clients.api._0_5;

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
 *         &lt;element name="FunctionDataCSVResult" type="{http://clients.mindbodyonline.com/api/0_5}SelectDataCSVResult" minOccurs="0"/>
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
    "functionDataCSVResult"
})
@XmlRootElement(name = "FunctionDataCSVResponse")
public class FunctionDataCSVResponse {

    @XmlElement(name = "FunctionDataCSVResult")
    protected SelectDataCSVResult functionDataCSVResult;

    /**
     * Gets the value of the functionDataCSVResult property.
     * 
     * @return
     *     possible object is
     *     {@link SelectDataCSVResult }
     *     
     */
    public SelectDataCSVResult getFunctionDataCSVResult() {
        return functionDataCSVResult;
    }

    /**
     * Sets the value of the functionDataCSVResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectDataCSVResult }
     *     
     */
    public void setFunctionDataCSVResult(SelectDataCSVResult value) {
        this.functionDataCSVResult = value;
    }

}
