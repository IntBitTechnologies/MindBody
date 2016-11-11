package com.mindbody.source;

public enum MindBodyRevenueType {
	Product("product"), Service("service");

	private String value;

	// Constructor
	MindBodyRevenueType(String p) {
		value = p;
	}

	String getValue() {
		return value;
	}
}
