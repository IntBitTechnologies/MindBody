package com.mindbody.source;

import java.io.IOException;

import com.csvreader.CsvReader;

public class RevenueCategory extends BaseDetail{

	private String categoryName;
	private Long categoryId;
	private String categoryType;
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}
	/**
	 * @param categoryType the categoryType to set
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public static RevenueCategory parse(CsvReader csvReader) throws IOException {
		RevenueCategory revenueCategory = new RevenueCategory();
		revenueCategory.categoryName = revenueCategory.safeString(csvReader.get(0));
		revenueCategory.categoryId = revenueCategory.safeLong(csvReader.get(1));
		revenueCategory.categoryType = revenueCategory.safeString(csvReader.get(2));
		return revenueCategory;
	}

}

