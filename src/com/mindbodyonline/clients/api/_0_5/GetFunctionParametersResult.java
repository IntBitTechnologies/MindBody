
package com.mindbodyonline.clients.api._0_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFunctionParametersResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFunctionParametersResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBResult">
 *       &lt;sequence>
 *         &lt;element name="Parameters" type="{http://clients.mindbodyonline.com/api/0_5}ArrayOfApiFunctionParameter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFunctionParametersResult", propOrder = {
    "parameters"
})
public class GetFunctionParametersResult
    extends MBResult
{

    @XmlElement(name = "Parameters")
    protected ArrayOfApiFunctionParameter parameters;

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfApiFunctionParameter }
     *     
     */
    public ArrayOfApiFunctionParameter getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfApiFunctionParameter }
     *     
     */
    public void setParameters(ArrayOfApiFunctionParameter value) {
        this.parameters = value;
    }

}
