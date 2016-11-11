
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
 *         &lt;element name="SelectAggregateDataCSVResult" type="{http://clients.mindbodyonline.com/api/0_5}SelectAggregateDataCSVResult" minOccurs="0"/>
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
    "selectAggregateDataCSVResult"
})
@XmlRootElement(name = "SelectAggregateDataCSVResponse")
public class SelectAggregateDataCSVResponse {

    @XmlElement(name = "SelectAggregateDataCSVResult")
    protected SelectAggregateDataCSVResult selectAggregateDataCSVResult;

    /**
     * Gets the value of the selectAggregateDataCSVResult property.
     * 
     * @return
     *     possible object is
     *     {@link SelectAggregateDataCSVResult }
     *     
     */
    public SelectAggregateDataCSVResult getSelectAggregateDataCSVResult() {
        return selectAggregateDataCSVResult;
    }

    /**
     * Sets the value of the selectAggregateDataCSVResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectAggregateDataCSVResult }
     *     
     */
    public void setSelectAggregateDataCSVResult(SelectAggregateDataCSVResult value) {
        this.selectAggregateDataCSVResult = value;
    }

}
