
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
 *         &lt;element name="SelectDataXmlResult" type="{http://clients.mindbodyonline.com/api/0_5}SelectDataXmlResult" minOccurs="0"/>
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
    "selectDataXmlResult"
})
@XmlRootElement(name = "SelectDataXmlResponse")
public class SelectDataXmlResponse {

    @XmlElement(name = "SelectDataXmlResult")
    protected SelectDataXmlResult selectDataXmlResult;

    /**
     * Gets the value of the selectDataXmlResult property.
     * 
     * @return
     *     possible object is
     *     {@link SelectDataXmlResult }
     *     
     */
    public SelectDataXmlResult getSelectDataXmlResult() {
        return selectDataXmlResult;
    }

    /**
     * Sets the value of the selectDataXmlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectDataXmlResult }
     *     
     */
    public void setSelectDataXmlResult(SelectDataXmlResult value) {
        this.selectDataXmlResult = value;
    }

}
