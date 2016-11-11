package com.mindbody.source;

import java.io.StringReader;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.mindbodyonline.clients.api._0_5.DataService;
import com.mindbodyonline.clients.api._0_5.DataServiceSoap;
import com.mindbodyonline.clients.api._0_5.FunctionDataXmlRequest;
import com.mindbodyonline.clients.api._0_5.SelectDataCSVResult;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;


public class MindBodyUtil {

	public static Boolean isValidEmail(String email) {
		if(email != null && email.length() > 0)
		      return EmailValidator.getInstance().isValid(email);
		return false;
	}
	
	public static boolean isEmpty(final String value) {
        return (value == null || (value.trim().length() == 0) || value.equalsIgnoreCase("null"));
    }
	
	public static FunctionDataXmlRequest generalFunctionalRequest(String functionName, UserCredentials userCredentials, SourceCredentials sourceCredentials) {
		FunctionDataXmlRequest functionDataXmlRequest = new FunctionDataXmlRequest();
		functionDataXmlRequest.setSourceCredentials(sourceCredentials);
		functionDataXmlRequest.setUserCredentials(userCredentials);
		functionDataXmlRequest.setXMLDetail(XMLDetailLevel.FULL);
		functionDataXmlRequest.setPageSize(5000);
		functionDataXmlRequest.setCurrentPageIndex(0);
		functionDataXmlRequest.setFunctionName(functionName);
		return functionDataXmlRequest;
	}
	
	public static SelectDataCSVResult executeFunctionRequest(FunctionDataXmlRequest functionDataXmlRequest) {
		DataService dataService = new DataService();
		DataServiceSoap dataServiceSoap = dataService.getDataServiceSoap();
		SelectDataCSVResult selectDataCSVResult = dataServiceSoap.functionDataCSV(functionDataXmlRequest);
		return selectDataCSVResult;
	}

	public static StringReader parseCSV(SelectDataCSVResult selectDataCSVResult) {
		String escapedCSV = StringEscapeUtils.escapeHtml4(selectDataCSVResult.getCSV());
		StringReader reader = new StringReader(escapedCSV);
		return reader;
	}
}
