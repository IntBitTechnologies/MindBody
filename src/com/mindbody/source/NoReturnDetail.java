package com.mindbody.source;

import java.io.IOException;

import com.csvreader.CsvReader;

public class NoReturnDetail {
	private String clientID;
	private Long locationID;
	private String lastName;
	private String firstName;
	private String email;
	private String lastVisit;
	private Long pricingOptionID;
	
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
	 * @return the locationID
	 */
	public Long getLocationID() {
		return locationID;
	}


	/**
	 * @param locationID the locationID to set
	 */
	public void setLocationID(Long locationID) {
		this.locationID = locationID;
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
	 * @return the lastVisit
	 */
	public String getLastVisit() {
		return lastVisit;
	}


	/**
	 * @param lastVisit the lastVisit to set
	 */
	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
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


	public static NoReturnDetail parse(CsvReader csvReader) throws NumberFormatException, IOException {
		NoReturnDetail noReturnDetail = new NoReturnDetail();
		noReturnDetail.clientID = csvReader.get(0);
		noReturnDetail.locationID = Long.parseLong(csvReader.get(1));
		noReturnDetail.lastName = csvReader.get(2);
		noReturnDetail.firstName = csvReader.get(3);
		noReturnDetail.email = csvReader.get(4);
		noReturnDetail.lastVisit = csvReader.get(5);
		noReturnDetail.pricingOptionID = Long.parseLong(csvReader.get(6));
		return noReturnDetail;
	}

}
