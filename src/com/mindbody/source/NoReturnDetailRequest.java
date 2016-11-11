package com.mindbody.source;

public class NoReturnDetailRequest {
	
	private String startDate;
	private String endDate;
	private Integer pricingOptionId;
	private Integer locationId;
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the pricingOptionId
	 */
	public Integer getPricingOptionId() {
		return pricingOptionId;
	}
	/**
	 * @param pricingOptionId the pricingOptionId to set
	 */
	public void setPricingOptionId(Integer pricingOptionId) {
		this.pricingOptionId = pricingOptionId;
	}
	/**
	 * @return the locationId
	 */
	public Integer getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

}
