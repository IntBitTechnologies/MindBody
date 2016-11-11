
package com.mindbodyonline.clients.api._0_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SelectAggregateDataCSVRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SelectAggregateDataCSVRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBRequest">
 *       &lt;sequence>
 *         &lt;element name="SelectSql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectAggregateDataCSVRequest", propOrder = {
    "selectSql"
})
public class SelectAggregateDataCSVRequest
    extends MBRequest
{

    @XmlElement(name = "SelectSql")
    protected String selectSql;

    /**
     * Gets the value of the selectSql property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectSql() {
        return selectSql;
    }

    /**
     * Sets the value of the selectSql property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectSql(String value) {
        this.selectSql = value;
    }

}
