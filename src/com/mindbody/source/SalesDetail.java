package com.mindbody.source;

import java.io.IOException;

import com.csvreader.CsvReader;

public class SalesDetail extends BaseDetail{

	private String clientID;
	private String lastName;
	private String firstName;
	private String email;
	private String pricingOptionName;
	private Long pricingOptionID;
	private String serviceCategoryName;
	private Long serviceCategoryID;
	private String revenueCategoryName;
	private Long revenueCategoryID;
	private String saleDate;
	private Double saleAmount;
	private String saleSource;

	/**
	 * @return the clientID
	 */
	public String getClientID() {
		return clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pricingOptionName
	 */
	public String getPricingOptionName() {
		return pricingOptionName;
	}

	/**
	 * @param pricingOptionName the pricingOptionName to set
	 */
	public void setPricingOptionName(String pricingOptionName) {
		this.pricingOptionName = pricingOptionName;
	}

	/**
	 * @return the pricingOptionID
	 */
	public Long getPricingOptionID() {
		return pricingOptionID;
	}

	/**
	 * @param pricingOptionID the pricingOptionID to set
	 */
	public void setPricingOptionID(Long pricingOptionID) {
		this.pricingOptionID = pricingOptionID;
	}

	/**
	 * @return the serviceCategoryName
	 */
	public String getServiceCategoryName() {
		return serviceCategoryName;
	}

	/**
	 * @param serviceCategoryName the serviceCategoryName to set
	 */
	public void setServiceCategoryName(String serviceCategoryName) {
		this.serviceCategoryName = serviceCategoryName;
	}

	/**
	 * @return the serviceCategoryID
	 */
	public Long getServiceCategoryID() {
		return serviceCategoryID;
	}

	/**
	 * @param serviceCategoryID the serviceCategoryID to set
	 */
	public void setServiceCategoryID(Long serviceCategoryID) {
		this.serviceCategoryID = serviceCategoryID;
	}

	/**
	 * @return the revenueCategoryName
	 */
	public String getRevenueCategoryName() {
		return revenueCategoryName;
	}

	/**
	 * @param revenueCategoryName the revenueCategoryName to set
	 */
	public void setRevenueCategoryName(String revenueCategoryName) {
		this.revenueCategoryName = revenueCategoryName;
	}

	/**
	 * @return the revenueCategoryID
	 */
	public Long getRevenueCategoryID() {
		return revenueCategoryID;
	}

	/**
	 * @param revenueCategoryID the revenueCategoryID to set
	 */
	public void setRevenueCategoryID(Long revenueCategoryID) {
		this.revenueCategoryID = revenueCategoryID;
	}

	/**
	 * @return the saleDate
	 */
	public String getSaleDate() {
		return saleDate;
	}

	/**
	 * @param saleDate the saleDate to set
	 */
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	/**
	 * @return the saleAmount
	 */
	public Double getSaleAmount() {
		return saleAmount;
	}

	/**
	 * @param saleAmount the saleAmount to set
	 */
	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

	/**
	 * @return the saleSource
	 */
	public String getSaleSource() {
		return saleSource;
	}

	/**
	 * @param saleSource the saleSource to set
	 */
	public void setSaleSource(String saleSource) {
		this.saleSource = saleSource;
	}
	
	public static SalesDetail parse(CsvReader csvReader) throws IOException {
		SalesDetail salesDetail = new SalesDetail();
		salesDetail.clientID = salesDetail.safeString(csvReader.get(0));
		salesDetail.lastName = salesDetail.safeString(csvReader.get(1));
		salesDetail.firstName = salesDetail.safeString(csvReader.get(2));
		salesDetail.email = salesDetail.safeString(csvReader.get(3));
		salesDetail.pricingOptionName = salesDetail.safeString(csvReader.get(4));
		salesDetail.pricingOptionID = salesDetail.safeLong(csvReader.get(5));
		salesDetail.serviceCategoryName = salesDetail.safeString(csvReader.get(6));
		salesDetail.serviceCategoryID = salesDetail.safeLong(csvReader.get(7));
		salesDetail.revenueCategoryName = salesDetail.safeString(csvReader.get(8));
		salesDetail.revenueCategoryID = salesDetail.safeLong(csvReader.get(9));
		salesDetail.saleDate = salesDetail.safeString(csvReader.get(10));
		salesDetail.saleAmount = salesDetail.safeDouble(csvReader.get(11));
		salesDetail.saleSource = salesDetail.safeString(csvReader.get(12));
		return salesDetail;
	}

	
}
