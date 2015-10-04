package com.mindbody.source;

import org.apache.commons.validator.routines.EmailValidator;


public class MindBodyUtil {

	public static Boolean isValidEmail(String email) {
		if(email != null && email.length() > 0)
		      return EmailValidator.getInstance().isValid(email);
		return false;
	}
	
}
