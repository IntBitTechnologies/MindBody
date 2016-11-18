package com.mindbody.source;

public class BaseDetail {

	public Long safeLong(String parseLong) {
		Long value = new Long(0);
		try {
			value = Long.parseLong(parseLong);
		} catch (Exception e) {
		}
		return value;
	}

	public String safeString(String string) {
		return string;
	}
	
	public Double safeDouble(String parseDouble) {
		Double value = new Double(0);
		try {
			value = Double.parseDouble(parseDouble);
		} catch (Exception e) {
		}
		return value;

	}


}
