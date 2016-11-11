
package com.mindbodyonline.clients.api._0_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFunctionNamesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFunctionNamesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBResult">
 *       &lt;sequence>
 *         &lt;element name="Functions" type="{http://clients.mindbodyonline.com/api/0_5}ArrayOfApiFunction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFunctionNamesResult", propOrder = {
    "functions"
})
public class GetFunctionNamesResult
    extends MBResult
{

    @XmlElement(name = "Functions")
    protected ArrayOfApiFunction functions;

    /**
     * Gets the value of the functions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfApiFunction }
     *     
     */
    public ArrayOfApiFunction getFunctions() {
        return functions;
    }

    /**
     * Sets the value of the functions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfApiFunction }
     *     
     */
    public void setFunctions(ArrayOfApiFunction value) {
        this.functions = value;
    }

}
