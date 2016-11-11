
package com.mindbodyonline.clients.api._0_5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfApiFunction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfApiFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApiFunction" type="{http://clients.mindbodyonline.com/api/0_5}ApiFunction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfApiFunction", propOrder = {
    "apiFunction"
})
public class ArrayOfApiFunction {

    @XmlElement(name = "ApiFunction", nillable = true)
    protected List<ApiFunction> apiFunction;

    /**
     * Gets the value of the apiFunction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiFunction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApiFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApiFunction }
     * 
     * 
     */
    public List<ApiFunction> getApiFunction() {
        if (apiFunction == null) {
            apiFunction = new ArrayList<ApiFunction>();
        }
        return this.apiFunction;
    }

}
