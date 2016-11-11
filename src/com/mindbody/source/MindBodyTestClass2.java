package com.mindbody.source;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.csvreader.CsvReader;
import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeResult;
import com.mindbodyonline.clients.api._0_5.GetProgramsRequest;
import com.mindbodyonline.clients.api._0_5.GetProgramsResult;
import com.mindbodyonline.clients.api._0_5.GetSitesRequest;
import com.mindbodyonline.clients.api._0_5.GetSitesResult;
import com.mindbodyonline.clients.api._0_5.ScheduleType;
import com.mindbodyonline.clients.api._0_5.Site;
import com.mindbodyonline.clients.api._0_5.SiteX0020Service;
import com.mindbodyonline.clients.api._0_5.SiteX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfClass;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfString;
import com.mindbodyonline.clients.api._0_5Class.Class;
import com.mindbodyonline.clients.api._0_5Class.ClassSchedule;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020Service;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Class.GetClassVisitsRequest;
import com.mindbodyonline.clients.api._0_5Class.GetClassVisitsResult;
import com.mindbodyonline.clients.api._0_5Class.GetClassesRequest;
import com.mindbodyonline.clients.api._0_5Class.GetClassesResult;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsRequest;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResult;
import com.mindbodyonline.clients.api._0_5Client.AddOrUpdateClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.AddOrUpdateClientsResponse;
import com.mindbodyonline.clients.api._0_5Client.AddOrUpdateClientsResult;
import com.mindbodyonline.clients.api._0_5Client.ArrayOfClient;
import com.mindbodyonline.clients.api._0_5Client.ArrayOfProgram;
import com.mindbodyonline.clients.api._0_5Client.Client;
import com.mindbodyonline.clients.api._0_5Client.ClientIndex;
import com.mindbodyonline.clients.api._0_5Client.ClientIndexValue;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020Service;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientPurchasesRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientPurchasesResponse;
import com.mindbodyonline.clients.api._0_5Client.GetClientPurchasesResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientServicesRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientServicesResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsResponse;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientsResult;
import com.mindbodyonline.clients.api._0_5Client.ObjectFactory;
import com.mindbodyonline.clients.api._0_5Client.Program;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesRequest;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesResult;
import com.mindbodyonline.clients.api._0_5Sale.GetServicesRequest;
import com.mindbodyonline.clients.api._0_5Sale.GetServicesResult;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020Service;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffRequest;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffResult;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020Service;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020ServiceSoap;

public class MindBodyTestClass2 {

	private static String sourcePassword = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
	private static String sourceName = "BrndbotLLC";


	public static void main(String[] args) {
		
		int[] list = new  int[]{-99};
		MindBody mindBody = new MindBody(sourceName, sourcePassword, list);
		try {
//			RevenueCategoryResponse revenueCategoryResponse = mindBody.getRevenueCategories(MindBodyRevenueType.Service);
//			for (int i = 0; i < revenueCategoryResponse.getRows().size(); i++) {
//				System.out.println(revenueCategoryResponse.getRows().get(i).toString());	
//			}
			
			NoReturnDetailRequest noReturnDetailRequest = new NoReturnDetailRequest();
//			noReturnDetailRequest.setLocationId(1);
			noReturnDetailRequest.setPricingOptionId(1198);
			noReturnDetailRequest.setStartDate("2016-10-01");
			noReturnDetailRequest.setEndDate("2016-10-31");
//			
			NoReturnDetailResponse noReturnDetailResponse = mindBody.getNoReturnDetail(noReturnDetailRequest);
			for (int i = 0; i < noReturnDetailResponse.getRows().size(); i++) {
				System.out.println(noReturnDetailResponse.getRows().get(i));
			}
			
//			SalesDetailRequest salesDetailRequest = new SalesDetailRequest();
//			salesDetailRequest.setStartDate("2016-10-01");
//			salesDetailRequest.setEndDate("2016-10-31");
//			salesDetailRequest.setServiceCategoryId(42);
//			salesDetailRequest.setRevenueCategoryId(-3);
//			salesDetailRequest.setPricingOptionId(10265);
//			salesDetailRequest.setLocationId(1);
//			SalesDetailResponse salesDetailResponse = mindBody.getSalesDetail(salesDetailRequest);
//			for (int i = 0; i < salesDetailResponse.getRows().size(); i++) {
//				System.out.println(salesDetailResponse.getRows().get(i));
//			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static Date toDate(XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return null;
		}
		return calendar.toGregorianCalendar().getTime();
	}
	
	private static Date combineDateTime(XMLGregorianCalendar xmlcalendarStartDate, XMLGregorianCalendar xmlcalendarStartTime) {
		
        Calendar calendarA = Calendar.getInstance();
        calendarA.setTime(toDate(xmlcalendarStartDate));
        Calendar calendarB = Calendar.getInstance();
        calendarB.setTime(toDate(xmlcalendarStartTime));

        calendarA.set(Calendar.HOUR_OF_DAY, calendarB.get(Calendar.HOUR_OF_DAY));
        calendarA.set(Calendar.MINUTE, calendarB.get(Calendar.MINUTE));
        calendarA.set(Calendar.SECOND, calendarB.get(Calendar.SECOND));
        calendarA.set(Calendar.MILLISECOND, calendarB.get(Calendar.MILLISECOND));

        Date result = calendarA.getTime();
        return result;
    }

}
