
package com.mindbodyonline.clients.api._0_5Client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetClientContractsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetClientContractsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://clients.mindbodyonline.com/api/0_5}MBResult">
 *       &lt;sequence>
 *         &lt;element name="Contracts" type="{http://clients.mindbodyonline.com/api/0_5}ArrayOfClientContract" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetClientContractsResult", propOrder = {
    "contracts"
})
public class GetClientContractsResult
    extends MBResult
{

    @XmlElement(name = "Contracts")
    protected ArrayOfClientContract contracts;

    /**
     * Gets the value of the contracts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClientContract }
     *     
     */
    public ArrayOfClientContract getContracts() {
        return contracts;
    }

    /**
     * Sets the value of the contracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClientContract }
     *     
     */
    public void setContracts(ArrayOfClientContract value) {
        this.contracts = value;
    }

}
