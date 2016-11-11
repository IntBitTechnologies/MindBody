
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
 *         &lt;element name="FunctionDataXmlResult" type="{http://clients.mindbodyonline.com/api/0_5}SelectDataXmlResult" minOccurs="0"/>
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
    "functionDataXmlResult"
})
@XmlRootElement(name = "FunctionDataXmlResponse")
public class FunctionDataXmlResponse {

    @XmlElement(name = "FunctionDataXmlResult")
    protected SelectDataXmlResult functionDataXmlResult;

    /**
     * Gets the value of the functionDataXmlResult property.
     * 
     * @return
     *     possible object is
     *     {@link SelectDataXmlResult }
     *     
     */
    public SelectDataXmlResult getFunctionDataXmlResult() {
        return functionDataXmlResult;
    }

    /**
     * Sets the value of the functionDataXmlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectDataXmlResult }
     *     
     */
    public void setFunctionDataXmlResult(SelectDataXmlResult value) {
        this.functionDataXmlResult = value;
    }

}
