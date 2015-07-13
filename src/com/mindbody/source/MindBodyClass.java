package com.mindbody.source;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mindbodyonline.clients.api._0_5Class.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfString;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfClass;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020Service;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Class.GetClassesRequest;
import com.mindbodyonline.clients.api._0_5Class.GetClassesResult;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsRequest;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResult;
import com.mindbodyonline.clients.api._0_5Class.SourceCredentials;
import com.mindbodyonline.clients.api._0_5Class.UserCredentials;
import com.mindbodyonline.clients.api._0_5Class.XMLDetailLevel;
import com.mindbodyonline.clients.api._0_5Class.Class;


public class MindBodyClass {

	public static void main(String[] args) {
		System.out.println("Hello");
		ArrayOfInt siteIds = new ArrayOfInt();
		List<Integer> intList = siteIds.getInt();
		intList.add(7335);


		UserCredentials userCredentials = new UserCredentials();
//		userCredentials.setUsername("andy@brndbot.com");
//		userCredentials.setPassword("258;Andover");
		userCredentials.setUsername("_BrndbotLLC");
		userCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		userCredentials.setSiteIDs(siteIds);
		
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName("BrndbotLLC");
		sourceCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		sourceCredentials.setSiteIDs(siteIds);
		
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

	}

}
