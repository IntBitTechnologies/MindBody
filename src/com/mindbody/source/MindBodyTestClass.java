package com.mindbody.source;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeResult;
import com.mindbodyonline.clients.api._0_5.SiteX0020Service;
import com.mindbodyonline.clients.api._0_5.SiteX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfClass;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfString;
import com.mindbodyonline.clients.api._0_5Class.Class;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020Service;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Class.GetClassesRequest;
import com.mindbodyonline.clients.api._0_5Class.GetClassesResult;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsRequest;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResult;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020Service;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Client.GetClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientsResult;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesRequest;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesResult;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020Service;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffRequest;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffResult;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020Service;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020ServiceSoap;

public class MindBodyTestClass {

	private static String sourcePassword = "";
	private static String sourceName = "";
	
	public static void main(String[] args) {
		
		ArrayOfInt siteIds = new ArrayOfInt();
		List<Integer> intList = siteIds.getInt();
		intList.add(7335);

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("_BrndbotLLC");
		userCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		userCredentials.setSiteIDs(siteIds);
		
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName("BrndbotLLC");
		sourceCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		sourceCredentials.setSiteIDs(siteIds);
		
		SiteX0020Service siteService = new SiteX0020Service();
		SiteX0020ServiceSoap siteSoap = siteService.getSiteX0020ServiceSoap();
		
		GetActivationCodeRequest activationRequest = new GetActivationCodeRequest();
		activationRequest.setSourceCredentials(sourceCredentials);
		GetActivationCodeResult activationResult = siteSoap.getActivationCode(activationRequest);
		System.out.println(activationResult.toString());
		
		ClassX0020Service classService = new ClassX0020Service();
		ClassX0020ServiceSoap classSoap = classService.getClassX0020ServiceSoap();
		
		GetClassesRequest classesRequest = new GetClassesRequest();
		classesRequest.setSourceCredentials(sourceCredentials);
		classesRequest.setUserCredentials(userCredentials);
		classesRequest.setXMLDetail(XMLDetailLevel.FULL);
		classesRequest.setCurrentPageIndex(0);
		
		GregorianCalendar startDate = new GregorianCalendar();
		startDate.setTime(new Date());
		XMLGregorianCalendar calendarStartDate = null;
		try {
			calendarStartDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		classesRequest.setStartDateTime(calendarStartDate);
		
		GregorianCalendar nextTenDays =new GregorianCalendar();
		nextTenDays.add(Calendar.DATE, 10);

		XMLGregorianCalendar calendarDateNextTenDays = null;
		try {
			calendarDateNextTenDays = DatatypeFactory.newInstance().newXMLGregorianCalendar(nextTenDays);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		classesRequest.setEndDateTime(calendarDateNextTenDays);
		classesRequest.setHideCanceledClasses(false);
		
		GetClassesResult classesResult = classSoap.getClasses(classesRequest);
		ArrayOfClass arrayOfClasses = classesResult.getClasses();
		if (arrayOfClasses != null && arrayOfClasses.getClazz() != null) {
			List<Class> classesList = arrayOfClasses.getClazz();
			for (int i = 0; i < classesList.size(); i++) {
				Class classInstance = classesList.get(i);
				System.out.println(classInstance.toString());
			}	
		}
				
		GetEnrollmentsRequest enrollmentsRequest = new GetEnrollmentsRequest();
		enrollmentsRequest.setSourceCredentials(sourceCredentials);
		enrollmentsRequest.setUserCredentials(userCredentials);
		enrollmentsRequest.setXMLDetail(XMLDetailLevel.FULL);
		enrollmentsRequest.setPageSize(0);
		ArrayOfString enrollmentFields = new ArrayOfString();
		List<String> enrollmentFieldsList = enrollmentFields.getString();
		enrollmentFieldsList.add("Enrollment.Classes");
		enrollmentFieldsList.add("Enrollments.Classes.Resource");
		enrollmentsRequest.setFields(enrollmentFields);
		enrollmentsRequest.setEndDate(calendarDateNextTenDays);
		
		GetEnrollmentsResult enrollmentsResult = classSoap.getEnrollments(enrollmentsRequest);
		System.out.println(enrollmentsResult.toString());

		
		com.mindbodyonline.clients.api._0_5.ArrayOfInt saleSiteIds = new com.mindbodyonline.clients.api._0_5.ArrayOfInt();
		List<Integer> saleIntList = saleSiteIds.getInt();
		saleIntList.add(7335);

		SaleX0020Service saleService = new SaleX0020Service();
		SaleX0020ServiceSoap saleSoap = saleService.getSaleX0020ServiceSoap();
		
		GetSalesRequest salesRequest = new GetSalesRequest();
		salesRequest.setStartSaleDateTime(calendarStartDate);
		salesRequest.setEndSaleDateTime(calendarDateNextTenDays);
		SourceCredentials saleSourceCredentials = new SourceCredentials();
		saleSourceCredentials.setSourceName(sourceName);
		saleSourceCredentials.setPassword(sourcePassword);
		saleSourceCredentials.setSiteIDs(saleSiteIds);
		
		UserCredentials saleUserCredentials = new UserCredentials();
		saleUserCredentials.setUsername("_"+sourceName);
		saleUserCredentials.setPassword(sourcePassword);
		saleUserCredentials.setSiteIDs(saleSiteIds);
		
		salesRequest.setSourceCredentials(saleSourceCredentials);
		salesRequest.setUserCredentials(saleUserCredentials);
		
		GetSalesResult saleResult = saleSoap.getSales(salesRequest);
		System.out.println(saleResult);
		
		StaffX0020Service staffService = new StaffX0020Service();
		StaffX0020ServiceSoap staffSoap = staffService.getStaffX0020ServiceSoap();
		
		GetStaffRequest staffRequest = new GetStaffRequest();
		staffRequest.setSourceCredentials(saleSourceCredentials);
		staffRequest.setUserCredentials(saleUserCredentials);
		staffRequest.setStartDateTime(calendarStartDate);
		
		GetStaffResult staffResult = staffSoap.getStaff(staffRequest);
		System.out.println(staffResult);
		
		ClientX0020Service clientService = new ClientX0020Service();
		ClientX0020ServiceSoap clientSoap = clientService.getClientX0020ServiceSoap();
		
		GetClientsRequest clientsRequest = new GetClientsRequest();
		clientsRequest.setSourceCredentials(saleSourceCredentials);
		clientsRequest.setUserCredentials(saleUserCredentials);
		
		
		GetClientsResult clientsResult = clientSoap.getClients(clientsRequest);
		System.out.println(clientsResult);		
	}
}
