
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
 *         &lt;element name="RunFunctionForJobResult" type="{http://clients.mindbodyonline.com/api/0_5}RunFunctionForJobResult" minOccurs="0"/>
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
    "runFunctionForJobResult"
})
@XmlRootElement(name = "RunFunctionForJobResponse")
public class RunFunctionForJobResponse {

    @XmlElement(name = "RunFunctionForJobResult")
    protected RunFunctionForJobResult runFunctionForJobResult;

    /**
     * Gets the value of the runFunctionForJobResult property.
     * 
     * @return
     *     possible object is
     *     {@link RunFunctionForJobResult }
     *     
     */
    public RunFunctionForJobResult getRunFunctionForJobResult() {
        return runFunctionForJobResult;
    }

    /**
     * Sets the value of the runFunctionForJobResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunFunctionForJobResult }
     *     
     */
    public void setRunFunctionForJobResult(RunFunctionForJobResult value) {
        this.runFunctionForJobResult = value;
    }

}
