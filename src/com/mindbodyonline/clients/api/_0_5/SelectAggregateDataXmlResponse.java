
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
 *         &lt;element name="SelectAggregateDataXmlResult" type="{http://clients.mindbodyonline.com/api/0_5}SelectAggregateDataXmlResult" minOccurs="0"/>
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
    "selectAggregateDataXmlResult"
})
@XmlRootElement(name = "SelectAggregateDataXmlResponse")
public class SelectAggregateDataXmlResponse {

    @XmlElement(name = "SelectAggregateDataXmlResult")
    protected SelectAggregateDataXmlResult selectAggregateDataXmlResult;

    /**
     * Gets the value of the selectAggregateDataXmlResult property.
     * 
     * @return
     *     possible object is
     *     {@link SelectAggregateDataXmlResult }
     *     
     */
    public SelectAggregateDataXmlResult getSelectAggregateDataXmlResult() {
        return selectAggregateDataXmlResult;
    }

    /**
     * Sets the value of the selectAggregateDataXmlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectAggregateDataXmlResult }
     *     
     */
    public void setSelectAggregateDataXmlResult(SelectAggregateDataXmlResult value) {
        this.selectAggregateDataXmlResult = value;
    }

}
