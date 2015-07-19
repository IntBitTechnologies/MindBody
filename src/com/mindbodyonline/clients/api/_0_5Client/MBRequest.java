
package com.mindbodyonline.clients.api._0_5Client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;


/**
 * <p>Java class for MBRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MBRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceCredentials" type="{http://clients.mindbodyonline.com/api/0_5}SourceCredentials" minOccurs="0"/>
 *         &lt;element name="UserCredentials" type="{http://clients.mindbodyonline.com/api/0_5}UserCredentials" minOccurs="0"/>
 *         &lt;element name="XMLDetail" type="{http://clients.mindbodyonline.com/api/0_5}XMLDetailLevel"/>
 *         &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CurrentPageIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Fields" type="{http://clients.mindbodyonline.com/api/0_5}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MBRequest", propOrder = {
    "sourceCredentials",
    "userCredentials",
    "xmlDetail",
    "pageSize",
    "currentPageIndex",
    "fields"
})
@XmlSeeAlso({
    GetClientServicesRequest.class,
    GetRequiredClientFieldsRequest.class,
    AddOrUpdateClientsRequest.class,
    GetCustomClientFieldsRequest.class,
    UpdateClientServicesRequest.class,
    GetClientScheduleRequest.class,
    AddClientFormulaNoteRequest.class,
    GetClientContractsRequest.class,
    GetClientAccountBalancesRequest.class,
    GetClientReferralTypesRequest.class,
    GetClientsRequest.class,
    ValidateLoginRequest.class,
    GetClientIndexesRequest.class,
    GetClientContactLogsRequest.class,
    ClientSendUserNewPasswordRequest.class,
    UploadClientDocumentRequest.class,
    GetClientPurchasesRequest.class,
    GetClientVisitsRequest.class,
    GetContactLogTypesRequest.class,
    GetActiveClientMembershipsRequest.class,
    AddArrivalRequest.class,
    DeleteCientFormulaNoteRequest.class,
    AddOrUpdateContactLogsRequest.class,
    GetClientFormulaNotesRequest.class
})
public class MBRequest {

    @XmlElement(name = "SourceCredentials")
    protected SourceCredentials sourceCredentials;
    @XmlElement(name = "UserCredentials")
    protected UserCredentials userCredentials;
    @XmlElement(name = "XMLDetail", required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected XMLDetailLevel xmlDetail;
    @XmlElement(name = "PageSize", required = true, type = Integer.class, nillable = true)
    protected Integer pageSize;
    @XmlElement(name = "CurrentPageIndex", required = true, type = Integer.class, nillable = true)
    protected Integer currentPageIndex;
    @XmlElement(name = "Fields")
    protected ArrayOfString fields;

    /**
     * Gets the value of the sourceCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link SourceCredentials }
     *     
     */
    public SourceCredentials getSourceCredentials() {
        return sourceCredentials;
    }

    /**
     * Sets the value of the sourceCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceCredentials }
     *     
     */
    public void setSourceCredentials(SourceCredentials value) {
        this.sourceCredentials = value;
    }

    /**
     * Gets the value of the userCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link UserCredentials }
     *     
     */
    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    /**
     * Sets the value of the userCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserCredentials }
     *     
     */
    public void setUserCredentials(UserCredentials value) {
        this.userCredentials = value;
    }

    /**
     * Gets the value of the xmlDetail property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDetailLevel }
     *     
     */
    public XMLDetailLevel getXMLDetail() {
        return xmlDetail;
    }

    /**
     * Sets the value of the xmlDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDetailLevel }
     *     
     */
    public void setXMLDetail(XMLDetailLevel value) {
        this.xmlDetail = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageSize(Integer value) {
        this.pageSize = value;
    }

    /**
     * Gets the value of the currentPageIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    /**
     * Sets the value of the currentPageIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCurrentPageIndex(Integer value) {
        this.currentPageIndex = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setFields(ArrayOfString value) {
        this.fields = value;
    }

}
