package com.mindbody.source;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import com.csvreader.CsvReader;
import com.mindbodyonline.clients.api._0_4.RecordSet;
import com.mindbodyonline.clients.api._0_4.Row;
import com.mindbodyonline.clients.api._0_5.ArrayOfFunctionParam;
import com.mindbodyonline.clients.api._0_5.DataService;
import com.mindbodyonline.clients.api._0_5.DataServiceSoap;
import com.mindbodyonline.clients.api._0_5.FunctionDataCSV;
import com.mindbodyonline.clients.api._0_5.FunctionDataXmlRequest;
import com.mindbodyonline.clients.api._0_5.FunctionDataXmlResponse;
import com.mindbodyonline.clients.api._0_5.FunctionParam;
import com.mindbodyonline.clients.api._0_5.SelectDataCSVResult;
import com.mindbodyonline.clients.api._0_5.SelectDataXmlResult;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;

public class MindBodyCustomCalls {
	private static String sourcePassword = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
	private static String sourceName = "BrndbotLLC";


	public static void main(String[] args) {
		
		com.mindbodyonline.clients.api._0_5.ArrayOfInt siteIds = new com.mindbodyonline.clients.api._0_5.ArrayOfInt();
		List<Integer> saleIntList = siteIds.getInt();
//		saleIntList.add(7335);
		saleIntList.add(-99);
		
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName(sourceName);
		sourceCredentials.setPassword(sourcePassword);
		sourceCredentials.setSiteIDs(siteIds);

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("_" + sourceName);
		userCredentials.setPassword(sourcePassword);
		userCredentials.setSiteIDs(siteIds);

		FunctionDataCSV functionDataCSV = new FunctionDataCSV();

		FunctionDataXmlRequest functionDataXmlRequest = new FunctionDataXmlRequest();
		functionDataXmlRequest.setSourceCredentials(sourceCredentials);
//		functionDataXmlRequest.setUserCredentials(userCredentials);
		functionDataXmlRequest.setXMLDetail(XMLDetailLevel.FULL);
//		functionDataXmlRequest.setPageSize(5000);
//		functionDataXmlRequest.setCurrentPageIndex(0);
		
//		functionDataXmlRequest = getRevenueCategories(functionDataXmlRequest);
		
//		functionDataXmlRequest = getSalesDetail(functionDataXmlRequest);
		functionDataXmlRequest = getNoReturnDetail(functionDataXmlRequest);

		try {
			functionDataCSV.setRequest(functionDataXmlRequest);
			DataService dataService = new DataService();
			DataServiceSoap dataServiceSoap = dataService.getDataServiceSoap();
			SelectDataCSVResult selectDataCSVResult = dataServiceSoap.functionDataCSV(functionDataXmlRequest);
			if (selectDataCSVResult != null) {
				String csvEscape = StringEscapeUtils.escapeHtml4(selectDataCSVResult.getCSV());
				System.out.println("csv ESCAPE------------------------------------------------");
				System.out.println(csvEscape);
				StringReader reader = new StringReader(csvEscape);
				CsvReader csvReader = new CsvReader(reader);
				csvReader.readHeaders();
				while (csvReader.readRecord())
				{
					String row = csvReader.getRawRecord();
					System.out.println(row);
				}
		
				csvReader.close();
			}
				
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}


	private static FunctionDataXmlRequest getRevenueCategories(
			FunctionDataXmlRequest functionDataXmlRequest) {
		functionDataXmlRequest.setFunctionName("BrndBot_GetRevenueCategories");
//		ArrayOfFunctionParam arrayOfFunctionParam = new ArrayOfFunctionParam();
//		List<FunctionParam> functionParams = arrayOfFunctionParam.getFunctionParam();
//		FunctionParam functionParam = new FunctionParam();
//	
//		functionParam.setParamDataType("string");
//		functionParam.setParamValue("product");
//		functionParam.setParamName("@revenuetype");
//		
//		functionParams.add(functionParam);
//		
//		functionDataXmlRequest.setFunctionParams(arrayOfFunctionParam);
		return functionDataXmlRequest;
	}
	
	private static FunctionDataXmlRequest getSalesDetail(
			FunctionDataXmlRequest functionDataXmlRequest) {
		functionDataXmlRequest.setFunctionName("BrndBot_GetSalesDetail");
		ArrayOfFunctionParam arrayOfFunctionParam = new ArrayOfFunctionParam();
		List<FunctionParam> functionParams = arrayOfFunctionParam.getFunctionParam();
		
		FunctionParam functionParam = new FunctionParam();
//		functionParam.setParamDataType("Date");
//		functionParam.setParamValue("2016-10-01");
//		functionParam.setParamName("@startdate");
//		functionParams.add(functionParam);
//
//		functionParam = new FunctionParam();
//		functionParam.setParamDataType("Date");
//		functionParam.setParamValue("2016-10-31");
//		functionParam.setParamName("@enddate");
//		functionParams.add(functionParam);
		
		functionParam = new FunctionParam();
		functionParam.setParamDataType("int");
		functionParam.setParamValue("42");
		functionParam.setParamName("@servicecategoryID");
		functionParams.add(functionParam);
		
		functionParam = new FunctionParam();
		functionParam.setParamDataType("int");
		functionParam.setParamValue("-3");
		functionParam.setParamName("@revenuecategoryID");
		functionParams.add(functionParam);
		
		functionParam = new FunctionParam();
		functionParam.setParamDataType("int");
		functionParam.setParamValue("10265");
		functionParam.setParamName("@pricingoptionID");
		functionParams.add(functionParam);
		
		functionParam = new FunctionParam();
		functionParam.setParamDataType("int");
		functionParam.setParamValue("1");
		functionParam.setParamName("@locationID");
		functionParams.add(functionParam);
		
		
		functionDataXmlRequest.setFunctionParams(arrayOfFunctionParam);
		return functionDataXmlRequest;
	}
	
	private static FunctionDataXmlRequest getNoReturnDetail(
			FunctionDataXmlRequest functionDataXmlRequest) {
		functionDataXmlRequest.setFunctionName("Brndbot_NoReturnDetail");
		ArrayOfFunctionParam arrayOfFunctionParam = new ArrayOfFunctionParam();
		List<FunctionParam> functionParams = arrayOfFunctionParam.getFunctionParam();
		
		FunctionParam functionParam = new FunctionParam();
		functionParam.setParamDataType("Date");
		functionParam.setParamValue("2016-10-01");
		functionParam.setParamName("@startdate");
		functionParams.add(functionParam);

		functionParam = new FunctionParam();
		functionParam.setParamDataType("Date");
		functionParam.setParamValue("2016-10-31");
		functionParam.setParamName("@enddate");
		functionParams.add(functionParam);
		
		functionParam = new FunctionParam();
		functionParam.setParamDataType("int");
		functionParam.setParamValue("10311");
		functionParam.setParamName("@pricingoptionID");
		functionParams.add(functionParam);
		
		functionParam = new FunctionParam();
		functionParam.setParamDataType("int");
		functionParam.setParamValue("1");
		functionParam.setParamName("@locationID");
		functionParams.add(functionParam);
		
		
		functionDataXmlRequest.setFunctionParams(arrayOfFunctionParam);
		return functionDataXmlRequest;
	}
	
	


}
