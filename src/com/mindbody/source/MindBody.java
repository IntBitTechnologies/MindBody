package com.mindbody.source;

import java.util.List;

import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeResult;
import com.mindbodyonline.clients.api._0_5.SiteX0020Service;
import com.mindbodyonline.clients.api._0_5.SiteX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;

public class MindBody {

	public static void main(String args[]) {
		
		System.out.println("Hello");
		ArrayOfInt siteIds = new ArrayOfInt();
		List<Integer> intList = siteIds.getInt();
		intList.add(7335);


		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("andy@brndbot.com");
		userCredentials.setPassword("258;Andover");
//		userCredentials.setUsername("_BrndbotLLC");
//		userCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		userCredentials.setSiteIDs(siteIds);
		
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName("BrndbotLLC");
		sourceCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		sourceCredentials.setSiteIDs(siteIds);
		
		GetActivationCodeRequest activationCodeResult = new GetActivationCodeRequest();
		activationCodeResult.setSourceCredentials(sourceCredentials);
		
		SiteX0020Service siteService = new SiteX0020Service();
		SiteX0020ServiceSoap soap = siteService.getSiteX0020ServiceSoap();
		
		GetActivationCodeResult response = soap.getActivationCode(activationCodeResult);
		System.out.println(response.getActivationLink());
//		
//		GetProgramsRequest programsRequest = new GetProgramsRequest();
//		programsRequest.setUserCredentials(userCredentials);
//		programsRequest.setSourceCredentials(sourceCredentials);
//		programsRequest.setScheduleType(ScheduleType.ALL);
//		
//		GetProgramsResult programsResponse = soap.getPrograms(programsRequest);
//		ArrayOfProgram arrayOfPrograms = programsResponse.getPrograms();
//		for (Program program:arrayOfPrograms.getProgram()) {
//			System.out.println(program.getName());
//		}
//		
//		System.out.println(programsResponse.getPrograms());
//		
//		GetResourceScheduleRequest resourceScheduleRequest = new GetResourceScheduleRequest();
//		GregorianCalendar c = new GregorianCalendar();
//		c.setTime(new Date());
//		XMLGregorianCalendar calendarDate = null;
//		try {
//			calendarDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//		} catch (DatatypeConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		resourceScheduleRequest.setDate(calendarDate);
//		resourceScheduleRequest.setSourceCredentials(sourceCredentials);
//		resourceScheduleRequest.setUserCredentials(userCredentials);
//		
//		GetResourceScheduleResult resourcesScheduleResponse = soap.getResourceSchedule(resourceScheduleRequest);
//		System.out.println(resourcesScheduleResponse.toString());
//		
//		GetSessionTypesRequest sessionsTypeRequest = new GetSessionTypesRequest();
//		sessionsTypeRequest.setSourceCredentials(sourceCredentials);
//		sessionsTypeRequest.setUserCredentials(userCredentials);
//		ArrayOfInt programIds = new ArrayOfInt();
//		List<Integer> programIdsIntList = programIds.getInt();
//		programIdsIntList.add(22);
//		sessionsTypeRequest.setProgramIDs(programIds);
//		
//		GetSessionTypesResult sessionsTypeResult = soap.getSessionTypes(sessionsTypeRequest);
//		sessionsTypeRequest.setOnlineOnly(true);
//		ArrayOfSessionType arrayOfSessionType = sessionsTypeResult.getSessionTypes();
//		System.out.println("Session Type:");
//		for (SessionType session : arrayOfSessionType.getSessionType()) {
//			System.out.println("Name:"+session.getName() +"defaultLength:"+session.getDefaultTimeLength() +"programId"+session.getProgramID());
//		}
		
	}

}
