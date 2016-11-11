
package com.mindbodyonline.clients.api._0_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.mindbodyonline.clients.api._0_4.RecordSet;


/**
 * <p>Java class for SelectAggregateDataXmlResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SelectAggregateDataXmlResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBResult">
 *       &lt;sequence>
 *         &lt;element name="Results" type="{http://clients.mindbodyonline.com/API/0_4}RecordSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectAggregateDataXmlResult", propOrder = {
    "results"
})
public class SelectAggregateDataXmlResult
    extends MBResult
{

    @XmlElement(name = "Results")
    protected RecordSet results;

    /**
     * Gets the value of the results property.
     * 
     * @return
     *     possible object is
     *     {@link RecordSet }
     *     
     */
    public RecordSet getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordSet }
     *     
     */
    public void setResults(RecordSet value) {
        this.results = value;
    }

}
