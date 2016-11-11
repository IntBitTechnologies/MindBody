
package com.mindbodyonline.clients.api._0_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFunctionParametersRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFunctionParametersRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBRequest">
 *       &lt;sequence>
 *         &lt;element name="FunctionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFunctionParametersRequest", propOrder = {
    "functionID"
})
public class GetFunctionParametersRequest
    extends MBRequest
{

    @XmlElement(name = "FunctionID")
    protected int functionID;

    /**
     * Gets the value of the functionID property.
     * 
     */
    public int getFunctionID() {
        return functionID;
    }

    /**
     * Sets the value of the functionID property.
     * 
     */
    public void setFunctionID(int value) {
        this.functionID = value;
    }

}
