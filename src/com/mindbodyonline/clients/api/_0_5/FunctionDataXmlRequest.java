
package com.mindbodyonline.clients.api._0_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FunctionDataXmlRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionDataXmlRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBRequest">
 *       &lt;sequence>
 *         &lt;element name="FunctionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FunctionParams" type="{http://clients.mindbodyonline.com/api/0_5}ArrayOfFunctionParam" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionDataXmlRequest", propOrder = {
    "functionName",
    "functionParams"
})
public class FunctionDataXmlRequest
    extends MBRequest
{

    @XmlElement(name = "FunctionName")
    protected String functionName;
    @XmlElement(name = "FunctionParams")
    protected ArrayOfFunctionParam functionParams;

    /**
     * Gets the value of the functionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * Sets the value of the functionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionName(String value) {
        this.functionName = value;
    }

    /**
     * Gets the value of the functionParams property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFunctionParam }
     *     
     */
    public ArrayOfFunctionParam getFunctionParams() {
        return functionParams;
    }

    /**
     * Sets the value of the functionParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFunctionParam }
     *     
     */
    public void setFunctionParams(ArrayOfFunctionParam value) {
        this.functionParams = value;
    }

}
