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
import com.mindbodyonline.clients.api._0_5Client.GetClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientsResult;
import com.mindbodyonline.clients.api._0_5Client.ObjectFactory;
import com.mindbodyonline.clients.api._0_5Client.Program;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesRequest;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesResult;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020Service;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffRequest;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffResult;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020Service;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020ServiceSoap;

public class MindBodyTestClass {

	private static String sourcePassword = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
	private static String sourceName = "BrndbotLLC";


	public static void main(String[] args) {
		
		ArrayOfInt siteIds = new ArrayOfInt();
		List<Integer> intList = siteIds.getInt();
		intList.add(7335);

		int[] list = new  int[]{7335};
		MindBody mindBody = new MindBody(sourceName, sourcePassword, list);
		
		List<String> emailIds = new ArrayList<String>();
		try {
//			CsvReader csvReader = new CsvReader("/Users/AR/Desktop/BrndBot/contact_export_061516_2153.csv");
//			csvReader.readRecord();
//			while (csvReader.readRecord()) {
//				System.out.println(csvReader.get(0));
//				emailIds.add(csvReader.get(0));
//			}
//			emailIds.add("andy.swansburg@gmail.com");
//			Map<String, String> m = mindBody.searchEmailAndUpdateEmailOptIn(emailIds);
//
//			HashMap<String, List<Client>> map = mindBody.getEmailLists();
//			List<Client> all = map.get("");
//			for (int i = 0; i < all.size(); i++) {
//				System.out.println(all.get(i).getFirstName() + ":"+all.get(i).getEmailOptIn());
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
//
//		GetActivationCodeRequest activationRequest = new GetActivationCodeRequest();
//		activationRequest.setSourceCredentials(sourceCredentials);
//		GetActivationCodeResult activationResult = siteSoap
//				.getActivationCode(activationRequest);
//		System.out.println(activationResult.toString());
//
//		GetProgramsRequest programsRequest = new GetProgramsRequest();
//		programsRequest.setSourceCredentials(sourceCredentials);
//		programsRequest.setUserCredentials(userCredentials);
//		programsRequest.setOnlineOnly(true);
//		programsRequest.setScheduleType(ScheduleType.ALL);
//
//		GetProgramsResult programsResult = siteSoap
//				.getPrograms(programsRequest);
//		System.out.println(programsResult);

		// 9999 invalid
//		ClassX0020Service classService = new ClassX0020Service();
//		ClassX0020ServiceSoap classSoap = classService
//				.getClassX0020ServiceSoap();
//
//		GetClassesRequest classesRequest = new GetClassesRequest();
//		classesRequest.setSourceCredentials(sourceCredentials);
//		classesRequest.setUserCredentials(userCredentials);
//		classesRequest.setXMLDetail(XMLDetailLevel.FULL);
//		classesRequest.setCurrentPageIndex(0);
//
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		// cal.add(Calendar.DATE, -1);
//		cal.add(Calendar.DATE, -60);
//		Date dateBefore30Days = cal.getTime();
//
//		GregorianCalendar startDate = new GregorianCalendar();
//		startDate.setTime(dateBefore30Days);
//		XMLGregorianCalendar calendarStartDate = null;
//		try {
//			calendarStartDate = DatatypeFactory.newInstance()
//					.newXMLGregorianCalendar(startDate);
//		} catch (DatatypeConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		classesRequest.setStartDateTime(calendarStartDate);
//
//		GregorianCalendar nextTenDays = new GregorianCalendar();
//		nextTenDays.add(Calendar.DATE, 0);
//
//		XMLGregorianCalendar calendarDateNextTenDays = null;
//		try {
//			calendarDateNextTenDays = DatatypeFactory.newInstance()
//					.newXMLGregorianCalendar(nextTenDays);
//		} catch (DatatypeConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		classesRequest.setEndDateTime(calendarDateNextTenDays);
//		classesRequest.setHideCanceledClasses(false);
//		// 102 permission denied
//		GetClassesResult classesResult = classSoap.getClasses(classesRequest);
//		ArrayOfClass arrayOfClasses = classesResult.getClasses();
//		if (arrayOfClasses != null && arrayOfClasses.getClazz() != null) {
//			List<Class> classesList = arrayOfClasses.getClazz();
//			for (int i = 0; i < classesList.size(); i++) {
//				Class classInstance = classesList.get(i);
//				String className = classInstance.getClassDescription()
//						.getName();
//				String staffname = classInstance.getStaff().getName();
//				if (!staffname.equalsIgnoreCase("Class Cancelled")) {
//					SimpleDateFormat format;
//					format = new SimpleDateFormat("h:mm a");
//					
//					Date d = toDate(classInstance.getStartDateTime().getValue());
//					
//					System.out.println(format.format(d));
//
//					format = new SimpleDateFormat("EEEEEE a");
//					
//					System.out.println(format.format(d));
//
//					System.out.println(className + "," + d.toGMTString() + ","
//							+ staffname);
//				} else {
//					System.out.println("Class is canceled");
//				}
//			}
//
//		}
//		GetClassVisitsRequest clientsVisitRequest = new GetClassVisitsRequest();
//		clientsVisitRequest.setSourceCredentials(sourceCredentials);
//		clientsVisitRequest.setUserCredentials(userCredentials);
//		clientsVisitRequest.setClassID(64827);
//
//		GetClassVisitsResult clientsVisitResult = classSoap
//				.getClassVisits(clientsVisitRequest);
//		System.out.println(clientsVisitResult);
//
//		//
//
//		GetEnrollmentsRequest enrollmentsRequest = new GetEnrollmentsRequest();
//		enrollmentsRequest.setSourceCredentials(sourceCredentials);
//		enrollmentsRequest.setUserCredentials(userCredentials);
//		enrollmentsRequest.setXMLDetail(XMLDetailLevel.FULL);
//		enrollmentsRequest.setPageSize(0);
//		ArrayOfString enrollmentFields = new ArrayOfString();
//		List<String> enrollmentFieldsList = enrollmentFields.getString();
//		enrollmentFieldsList.add("Enrollment.Classes");
//		enrollmentFieldsList.add("Enrollments.Classes.Resource");
//		enrollmentsRequest.setFields(enrollmentFields);
//		enrollmentsRequest.setEndDate(calendarDateNextTenDays);
//
//		GetEnrollmentsResult enrollmentsResult = classSoap
//				.getEnrollments(enrollmentsRequest);
//		for (int i = 0; i < enrollmentsResult.getEnrollments().getClassSchedule().size(); i++) {
//			ClassSchedule schdule = enrollmentsResult.getEnrollments().getClassSchedule().get(i);
//			JAXBElement<XMLGregorianCalendar> jcalendarStartDate = schdule.getStartDate();
//            JAXBElement<XMLGregorianCalendar> jcalendarStartTime = schdule.getStartTime();
//
//            XMLGregorianCalendar xmlcalendarStartDate = (XMLGregorianCalendar) jcalendarStartDate.getValue();
//            XMLGregorianCalendar xmlcalendarStartTime = (XMLGregorianCalendar) jcalendarStartTime.getValue();
//            if (xmlcalendarStartDate != null && xmlcalendarStartTime != null) {
//
//                Date finalDate = combineDateTime(xmlcalendarStartDate, xmlcalendarStartTime);
//                
//                SimpleDateFormat format;
//    			format = new SimpleDateFormat("h:mm a");
//    			    			
//    			System.out.println(format.format(finalDate));
//    			format = new SimpleDateFormat("EEEEEE a");
//    			
//    			System.out.println(format.format(finalDate));
//
//    			format = new SimpleDateFormat("MM-dd-yyyy h:mm EEEEEE a");
//    			
//    			System.out.println(format.format(finalDate));
//
//            }
//
//			
//
//		}
//		System.out.println(enrollmentsResult.toString());

		/*GetSitesRequest getSitesRequest = new GetSitesRequest();
		getSitesRequest.setSearchText("");
		getSitesRequest.setSourceCredentials(sourceCredentials);
		getSitesRequest.setUserCredentials(userCredentials);
		
		GetSitesResult sitesResult = siteSoap.getSites(getSitesRequest);
		if (sitesResult.getSites() != null) {
			for (int i = 0; i < sitesResult.getSites().getSite().size(); i++) {
				Site site = sitesResult.getSites().getSite().get(i);
				if (intList.contains(site.getID())) {
					System.out.println("Present:"+site.getID());		
				}
				
			}	
		}*/
		
		
		
		
		com.mindbodyonline.clients.api._0_5.ArrayOfInt saleSiteIds = new com.mindbodyonline.clients.api._0_5.ArrayOfInt();
		List<Integer> saleIntList = saleSiteIds.getInt();
		saleIntList.add(7335);

		SaleX0020Service saleService = new SaleX0020Service();
		SaleX0020ServiceSoap saleSoap = saleService.getSaleX0020ServiceSoap();

		GetSalesRequest salesRequest = new GetSalesRequest();
//		salesRequest.setStartSaleDateTime(calendarStartDate);
//		salesRequest.setEndSaleDateTime(calendarDateNextTenDays);
		SourceCredentials saleSourceCredentials = new SourceCredentials();
		saleSourceCredentials.setSourceName(sourceName);
		saleSourceCredentials.setPassword(sourcePassword);
		saleSourceCredentials.setSiteIDs(saleSiteIds);

		UserCredentials saleUserCredentials = new UserCredentials();
		saleUserCredentials.setUsername("_" + sourceName);
		saleUserCredentials.setPassword(sourcePassword);
		saleUserCredentials.setSiteIDs(saleSiteIds);

		salesRequest.setSourceCredentials(saleSourceCredentials);
		salesRequest.setUserCredentials(saleUserCredentials);
//		salesRequest.setStartSaleDateTime(calendarStartDate);
//		salesRequest.setEndSaleDateTime(calendarDateNextTenDays);

//		GetSalesResult saleResult = saleSoap.getSales(salesRequest);
//		System.out.println(saleResult);
		//
		// StaffX0020Service staffService = new StaffX0020Service();
		// StaffX0020ServiceSoap staffSoap =
		// staffService.getStaffX0020ServiceSoap();
		//
		// GetStaffRequest staffRequest = new GetStaffRequest();
		// staffRequest.setSourceCredentials(saleSourceCredentials);
		// staffRequest.setUserCredentials(saleUserCredentials);
		// staffRequest.setStartDateTime(calendarStartDate);
		//
		// GetStaffResult staffResult = staffSoap.getStaff(staffRequest);
		// System.out.println(staffResult);
		//
		
		long startTime = System.currentTimeMillis();
		long serviceCallTime = 0;
		long dataProcessingTime = 0;
		long endTime = 0;
		
		ClientX0020Service clientService = new ClientX0020Service();
		ClientX0020ServiceSoap clientSoap = clientService
				.getClientX0020ServiceSoap();

		GetClientIndexesRequest clientIndexesRequest = new GetClientIndexesRequest();
		clientIndexesRequest.setSourceCredentials(saleSourceCredentials);
		clientIndexesRequest.setUserCredentials(saleUserCredentials);
		clientIndexesRequest.setXMLDetail(XMLDetailLevel.FULL);
		com.mindbodyonline.clients.api._0_5Client.ArrayOfString clientIndexesFields = new com.mindbodyonline.clients.api._0_5Client.ArrayOfString();

		List<String> clientIndexesFieldsList = clientIndexesFields.getString();
		clientIndexesFieldsList.add("Clients.ClientIndexes");
//		clientIndexesFieldsList.add("Clients.CustomClientFields");
//		clientIndexesFieldsList.add("Clients.ClientRelationships");
//		clientIndexesFieldsList.add("Clients.FirstName");
//		clientIndexesFieldsList.add("Clients.LastName");
//		clientIndexesFieldsList.add("Clients.BirthDate");
		clientIndexesRequest.setFields(clientIndexesFields);

		HashMap<String, List<Client>> clientIndexesHashmap = new HashMap<String, List<Client>>();

		long serviceCallStartTime = System.currentTimeMillis();
		long dataProcessingStartTime = System.currentTimeMillis();

/*		GetClientIndexesResult clientIndexesResult = clientSoap
				.getClientIndexes(clientIndexesRequest);
		
		endTime = System.currentTimeMillis();
		serviceCallTime = serviceCallTime + (endTime - serviceCallStartTime);
		
		long dataProcessingStartTime = System.currentTimeMillis();
		for (int i = 0; i < clientIndexesResult.getClientIndexes()
				.getClientIndex().size(); i++) {
			ClientIndex clientIndex =  clientIndexesResult.getClientIndexes()
					.getClientIndex().get(i); 
			String clientIndexName = clientIndex.getName();
			clientIndexesHashmap.put(clientIndexName, new ArrayList<Client>());
			if (clientIndex.getValues() != null && clientIndex.getValues().getClientIndexValue() != null && clientIndex.getValues().getClientIndexValue().size() > 0) {
				List<ClientIndexValue> subSections = clientIndexesResult.getClientIndexes().getClientIndex().get(i).getValues().getClientIndexValue();
				for (int j = 0; j < subSections.size(); j++) {
					clientIndexesHashmap.put(clientIndexName + " - " + subSections.get(j).getName(), new ArrayList<Client>());
				}
			}
		}
		
		endTime = System.currentTimeMillis();
		dataProcessingTime = dataProcessingTime + (endTime - dataProcessingStartTime);
		*/
		GetClientsRequest clientsRequest = new GetClientsRequest();
		clientsRequest.setSourceCredentials(saleSourceCredentials);
		clientsRequest.setUserCredentials(saleUserCredentials);
		clientsRequest.setXMLDetail(XMLDetailLevel.FULL);
		clientsRequest.setPageSize(5000);
		
//		clientsRequest.setFields(clientIndexesFields);
		clientsRequest.setCurrentPageIndex(0);
		
		
		clientIndexesHashmap.put("All", new ArrayList<Client>());
		
		serviceCallStartTime = System.currentTimeMillis();
		System.out.println("Getting details for page:"+0);
		List<String> clientsToUpdateList = new ArrayList<String>();
		clientsToUpdateList.add("becky@beautifulusable.com");
		clientsToUpdateList.add("mmabraham@hotmail.com");
		
		ArrayOfClient arrayOfClient = new ArrayOfClient();

		for (int i = 0; i < clientsToUpdateList.size(); i++) {
			clientsRequest.setSearchText(clientsToUpdateList.get(i));
			GetClientsResult clientsResult = clientSoap.getClients(clientsRequest);
			arrayOfClient.getClient().addAll(clientsResult.getClients().getClient());
		}
		
		
		endTime = System.currentTimeMillis();
		serviceCallTime = serviceCallTime + (endTime - serviceCallStartTime);
		updateMindbodyOptin(clientSoap, arrayOfClient,saleSourceCredentials,saleUserCredentials);
		
		//clientIndexesHashmap = processEmailOptin(clientIndexesHashmap, clientsResult);
		
		endTime = System.currentTimeMillis();

		
		/*int pageCount = clientsResult.getTotalPageCount();
		
		for (int currentPage = 1; currentPage < pageCount; currentPage++) {
			clientsRequest.setCurrentPageIndex(currentPage);
			serviceCallStartTime = System.currentTimeMillis();
			System.out.println("Getting details for page:"+currentPage);
			clientsResult = clientSoap.getClients(clientsRequest);
			
			endTime = System.currentTimeMillis();
			serviceCallTime = serviceCallTime + (endTime - serviceCallStartTime);

			dataProcessingStartTime = System.currentTimeMillis();
			clientIndexesHashmap = processEmailOptin(clientIndexesHashmap, clientsResult);
			endTime = System.currentTimeMillis();
			dataProcessingTime = dataProcessingTime + (endTime - dataProcessingStartTime);

		}
		
		endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		Iterator it = clientIndexesHashmap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, List<Client>> pair = (Entry<String, List<Client>>)it.next();
	        System.out.println(pair.getKey() + " = Number of email ids (" + pair.getValue().size() + ")");
	    }
		System.out.println("Data Processing time:"+dataProcessingTime / 1000.0+" seconds");
		System.out.println("Service Call Execution time:"+serviceCallTime / 1000.0+" seconds");
		System.out.println(totalTime / 1000.0+" seconds");

		GetClientServicesRequest clientServicesRequest = new GetClientServicesRequest();
		clientServicesRequest.setSourceCredentials(sourceCredentials);
		clientServicesRequest.setUserCredentials(userCredentials);
		// clientServicesRequest.setClassID(64827);
		// clientServicesRequest.setClientID("100000012");
		clientServicesRequest.setClientID("100005248");
		clientServicesRequest.setPageSize(1000);
		clientServicesRequest.setCurrentPageIndex(0);

		ArrayOfInt arrayOfProgram = new ArrayOfInt();
		List<Integer> arrayOfProgramList = arrayOfProgram.getInt();

		arrayOfProgramList.add(22);
		arrayOfProgramList.add(23);
		arrayOfProgramList.add(26);
		arrayOfProgramList.add(31);
		arrayOfProgramList.add(35);
		arrayOfProgramList.add(36);
		arrayOfProgramList.add(43);
		arrayOfProgramList.add(44);
		arrayOfProgramList.add(47);
		arrayOfProgramList.add(51);
		arrayOfProgramList.add(52);
		arrayOfProgramList.add(60);
		arrayOfProgramList.add(61);
		arrayOfProgramList.add(63);
		arrayOfProgramList.add(64);

		clientServicesRequest.setProgramIDs(arrayOfProgram);

		GetClientServicesResult clientServicesResult = clientSoap
				.getClientServices(clientServicesRequest);
		System.out.println(clientServicesResult);
*/
		/*GetClientPurchasesRequest clientPurchasesRequest = new GetClientPurchasesRequest();
		clientPurchasesRequest.setSourceCredentials(saleSourceCredentials);
		clientPurchasesRequest.setUserCredentials(saleUserCredentials);
		clientPurchasesRequest.setClientID("100000012");
//		clientPurchasesRequest.setStartDate(calendarStartDate);
//		clientPurchasesRequest.setEndDate(calendarDateNextTenDays);

		GetClientPurchasesResult clientPurchaseResult = clientSoap
				.getClientPurchases(clientPurchasesRequest);
		System.out.println(clientPurchaseResult);*/

	}

	private static void updateMindbodyOptin(ClientX0020ServiceSoap clientSoap, ArrayOfClient clientArray, SourceCredentials saleSourceCredentials, UserCredentials saleUserCredentials) {
		AddOrUpdateClientsRequest addOrUpdateClientsRequest = new AddOrUpdateClientsRequest();
		addOrUpdateClientsRequest.setUserCredentials(saleUserCredentials);
		addOrUpdateClientsRequest.setSourceCredentials(saleSourceCredentials);
		addOrUpdateClientsRequest.setSendEmail(false);
		addOrUpdateClientsRequest.setUpdateAction("Update");
		addOrUpdateClientsRequest.setTest(false);
		List<Client> clientList = clientArray.getClient();
		List<Client> updatedClientList = new ArrayList<Client>();
		for (Client client : clientList) {
			ObjectFactory objectFactory = new ObjectFactory();

			JAXBElement<Boolean> boolValue = objectFactory.createClientEmailOptIn(false);
			client.setEmailOptIn(boolValue);
			updatedClientList.add(client);
		}
		ArrayOfClient updatedClientArray = new ArrayOfClient();
		updatedClientArray.getClient().addAll(updatedClientList);
		addOrUpdateClientsRequest.setClients(updatedClientArray);
		AddOrUpdateClientsResult addOrUpdateClientsResult = clientSoap.addOrUpdateClients(addOrUpdateClientsRequest);
		System.out.println("updated client:"+addOrUpdateClientsResult.getResultCount());
	}

	private static HashMap<String, List<Client>> processEmailOptin(
			HashMap<String, List<Client>> currentMap, GetClientsResult clientsResult) {

		List<Client> arrayOfClients = clientsResult.getClients().getClient();
		for (int i = 0; i < arrayOfClients.size(); i++) {
				Client client = arrayOfClients.get(i);
				if (client.getEmailOptIn().getValue() && MindBodyUtil.isValidEmail(client.getEmail())) {
					for (int j = 0; j < client.getClientIndexes().getClientIndex().size(); j++) {
						ClientIndex clientIndex = client.getClientIndexes().getClientIndex().get(j);
						String clientIndexName = clientIndex.getName();
						if (!currentMap.containsKey(clientIndexName)) {
							currentMap.put(clientIndexName, new ArrayList<Client>());
						}
						
						List<ClientIndexValue> subSections = clientIndex.getValues().getClientIndexValue();
						for (int k = 0; k < subSections.size(); k++) {

							String indexPlusSubsection = clientIndexName + " - " + subSections.get(k).getName();
							if (!currentMap.containsKey(indexPlusSubsection)) {
								currentMap.put(indexPlusSubsection, new ArrayList<Client>());
							}
							currentMap.get(indexPlusSubsection).add(client);
						}
						
						currentMap.get(clientIndexName).add(client);
					}
					currentMap.get("All").add(client);
				}
		}
		
		return currentMap;
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
