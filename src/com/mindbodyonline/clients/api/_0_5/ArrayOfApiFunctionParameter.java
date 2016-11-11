
package com.mindbodyonline.clients.api._0_5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfApiFunctionParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfApiFunctionParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApiFunctionParameter" type="{http://clients.mindbodyonline.com/api/0_5}ApiFunctionParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfApiFunctionParameter", propOrder = {
    "apiFunctionParameter"
})
public class ArrayOfApiFunctionParameter {

    @XmlElement(name = "ApiFunctionParameter", nillable = true)
    protected List<ApiFunctionParameter> apiFunctionParameter;

    /**
     * Gets the value of the apiFunctionParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiFunctionParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApiFunctionParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApiFunctionParameter }
     * 
     * 
     */
    public List<ApiFunctionParameter> getApiFunctionParameter() {
        if (apiFunctionParameter == null) {
            apiFunctionParameter = new ArrayList<ApiFunctionParameter>();
        }
        return this.apiFunctionParameter;
    }

}
