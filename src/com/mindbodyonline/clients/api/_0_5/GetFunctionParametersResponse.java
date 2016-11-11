
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
 *         &lt;element name="GetFunctionParametersResult" type="{http://clients.mindbodyonline.com/api/0_5}GetFunctionParametersResult" minOccurs="0"/>
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
    "getFunctionParametersResult"
})
@XmlRootElement(name = "GetFunctionParametersResponse")
public class GetFunctionParametersResponse {

    @XmlElement(name = "GetFunctionParametersResult")
    protected GetFunctionParametersResult getFunctionParametersResult;

    /**
     * Gets the value of the getFunctionParametersResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetFunctionParametersResult }
     *     
     */
    public GetFunctionParametersResult getGetFunctionParametersResult() {
        return getFunctionParametersResult;
    }

    /**
     * Sets the value of the getFunctionParametersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFunctionParametersResult }
     *     
     */
    public void setGetFunctionParametersResult(GetFunctionParametersResult value) {
        this.getFunctionParametersResult = value;
    }

}
