package com.mindbody.source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;

import com.intbit.firebase.controller.FirebaseController;
import com.intbit.firebase.error.FirebaseException;
import com.intbit.firebase.error.JacksonUtilityException;
import com.intbit.firebase.service.FirebaseCallBack;
import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfClass;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfString;
import com.mindbodyonline.clients.api._0_5Class.Class;
import com.mindbodyonline.clients.api._0_5Class.ClassSchedule;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020Service;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Class.GetClassesRequest;
import com.mindbodyonline.clients.api._0_5Class.GetClassesResult;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsRequest;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResult;
import com.mindbodyonline.clients.api._0_5Client.ArrayOfClientMembership;
import com.mindbodyonline.clients.api._0_5Client.Client;
import com.mindbodyonline.clients.api._0_5Client.ClientContract;
import com.mindbodyonline.clients.api._0_5Client.ClientIndex;
import com.mindbodyonline.clients.api._0_5Client.ClientIndexValue;
import com.mindbodyonline.clients.api._0_5Client.ClientMembership;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020Service;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Client.GetActiveClientMembershipsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetActiveClientMembershipsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientContractsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientContractsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientsResult;
import com.mindbodyonline.clients.api._0_5Client.Visit;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesRequest;
import com.mindbodyonline.clients.api._0_5Sale.GetSalesResult;
import com.mindbodyonline.clients.api._0_5Sale.Sale;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020Service;
import com.mindbodyonline.clients.api._0_5Sale.SaleX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffRequest;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffResult;
import com.mindbodyonline.clients.api._0_5Staff.Staff;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020Service;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020ServiceSoap;

public class PrototypeMindbodyDataDump {

	private static String pattern = "MM-dd-yyyy HHmm";
	private static SimpleDateFormat format = new SimpleDateFormat(pattern);
	private static String kBasePath = "/Users/AR/Documents/IntBit-Tech/Brndbot/Data/";
	private static String sourcePassword = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
	private static String sourceName = "BrndbotLLC";
	private static String baseURL = "https://brndbot.firebaseio.com/";

	private static UserCredentials userCredentials;
	private static SourceCredentials sourceCredentials;
	private static FirebaseController firebaseController;
	private static int kHistory = -600;

	public static void main(String args[]) {

		try {
			firebaseController = new FirebaseController(baseURL);
		} catch (FirebaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ArrayOfInt siteIds = new ArrayOfInt();
		List<Integer> intList = siteIds.getInt();
		intList.add(7335);

		sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName(sourceName);
		sourceCredentials.setPassword(sourcePassword);
		sourceCredentials.setSiteIDs(siteIds);

		userCredentials = new UserCredentials();
		userCredentials.setUsername("_" + sourceName);
		userCredentials.setPassword(sourcePassword);
		userCredentials.setSiteIDs(siteIds);

		ClientX0020Service clientService = new ClientX0020Service();
		ClientX0020ServiceSoap clientSoap = clientService
				.getClientX0020ServiceSoap();

		createFolder();
		Runnable runner2 = new Runnable() {

			@Override
			public void run() {
				List<Client> clients;
				try {
					if (true) {
						clients = getClients(clientSoap, true);
//						clients = clients.subList(0, 30);
						getClientMemberships(clientSoap, clients);
						getClientContracts(clientSoap, clients);
						getClientVisits(clientSoap, clients);	
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FirebaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JacksonUtilityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		Runnable runner1 = new Runnable() {

			@Override
			public void run() {
//				getClasses();
//				getStaff();
//				getEnrollments();
//				getSales();
//				getEmailLists();
			}
		};
		runner2.run();
		runner1.run();
	}

	private static void getClientVisits(ClientX0020ServiceSoap clientSoap,
			List<Client> activeClients) {
		System.out.println("Started Getting client visits");
		// Getting client visits
		GetClientVisitsRequest getClientVisitsRequest = new GetClientVisitsRequest();
		getClientVisitsRequest.setUserCredentials(userCredentials);
		getClientVisitsRequest.setSourceCredentials(sourceCredentials);
		getClientVisitsRequest.setXMLDetail(XMLDetailLevel.FULL);
		getClientVisitsRequest.setCurrentPageIndex(0);
		getClientVisitsRequest.setPageSize(10000);
		Map<String, Object> globalMap = new HashMap<String, Object>();

		for (int i = 0; i < activeClients.size(); i++) {
			Client client = activeClients.get(i);
			getClientVisitsRequest.setClientID(client.getID());
			GetClientVisitsResult getClientVisitsResult = clientSoap
					.getClientVisits(getClientVisitsRequest);
			List<Visit> clientVisits = getClientVisitsResult.getVisits()
					.getVisit();
			System.out.println("---------------------------------------------");
			if (clientVisits == null || clientVisits.size() == 0) {
				System.out.println("Found nothing for client id:"
						+ client.getID() + " name:" + client.getFirstName());
			} else {
				globalMap.putAll(mapClientVisits(client, clientVisits));
			}
		} //
			// End Getting client visits
		saveMapInFile(globalMap, Visit.class.getSimpleName());
		System.out.println("Completed Getting client visits");
	}

	private static Map<String, Object> mapClientVisits(
			Client client, List<Visit> clientVisits) {
		Map<String, Object> globalMap = new HashMap<String, Object>();
		for (int j = 0; j < clientVisits.size(); j++) {
			System.out.println("Found client id:" + client.getID()
					+ " name:" + client.getFirstName());
			Visit visit = clientVisits.get(j);
			System.out.println(clientVisits.get(j).getClassID());
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(visit, Map.class);
			String id = client.getID() + visit.getID();
			globalMap.put(id, map);
		}
		return globalMap;
	}

	private static void getClientContracts(ClientX0020ServiceSoap clientSoap,
			List<Client> activeClients) {
		System.out.println("Started Getting Client Contracts");
		// Getting client contracts for a given client
		GetClientContractsRequest getClientContractsRequest = new GetClientContractsRequest();
		getClientContractsRequest.setSourceCredentials(sourceCredentials);
		getClientContractsRequest.setUserCredentials(userCredentials);
		getClientContractsRequest.setPageSize(10000);
		getClientContractsRequest.setCurrentPageIndex(0);
		getClientContractsRequest.setXMLDetail(XMLDetailLevel.FULL);
		Map<String, Object> globalMap = new HashMap<String, Object>();

		for (int i = 0; i < activeClients.size(); i++) {
			Client client = activeClients.get(i);
			getClientContractsRequest.setClientID(client.getID());
			GetClientContractsResult getClientContractsResult = clientSoap
					.getClientContracts(getClientContractsRequest);
			List<ClientContract> clientContracts = getClientContractsResult
					.getContracts().getClientContract();
			System.out.println("---------------------------------------------");
			if (clientContracts == null || clientContracts.size() == 0) {
				System.out.println("Found nothing for client id:"
						+ client.getID() + " name:" + client.getFirstName());
			} else {
				globalMap.putAll(mapClientContracts(client, clientContracts));
			}
		} // End Getting client contracts for a given client
		saveMapInFile(globalMap, ClientContract.class.getSimpleName());
		System.out.println("Completed Getting Client Contracts");

	}

	private static Map<String, Object> mapClientContracts(
			Client client, List<ClientContract> clientContracts) {
		Map<String, Object> globalMap = new HashMap<String, Object>();

		for (int j = 0; j < clientContracts.size(); j++) {
			System.out.println("Found client id:" + client.getID()
					+ " name:" + client.getFirstName());
			ClientContract clientContract = clientContracts.get(j);
//			System.out.println(clientContracts.get(j).getAction()
//					.value());

			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(clientContract,
					Map.class);
			String id = client.getID() + clientContract.getID();
			globalMap.put(id, map);
		}
		return globalMap;
	}

	private static void getClientMemberships(ClientX0020ServiceSoap clientSoap,
			List<Client> activeClients) {

		System.out.println("Starting GettingMemberShips");
		// Getting active memberships for a given client
		GetActiveClientMembershipsRequest getActiveClientMembershipsRequest = new GetActiveClientMembershipsRequest();
		getActiveClientMembershipsRequest.setUserCredentials(userCredentials);
		getActiveClientMembershipsRequest
				.setSourceCredentials(sourceCredentials);
		getActiveClientMembershipsRequest.setXMLDetail(XMLDetailLevel.FULL);
		getActiveClientMembershipsRequest.setCurrentPageIndex(0);
		getActiveClientMembershipsRequest.setPageSize(10000);
		Map<String, Object> globalMap = new HashMap<String, Object>();
		for (int i = 0; i < activeClients.size(); i++) {
			Client client = activeClients.get(i);
			getActiveClientMembershipsRequest.setClientID(client.getID());
			GetActiveClientMembershipsResult getActiveClientMembershipsResult = clientSoap
					.getActiveClientMemberships(getActiveClientMembershipsRequest);
			List<ClientMembership> clientMemberships = getActiveClientMembershipsResult
					.getClientMemberships().getClientMembership();
			System.out.println("---------------------------------------------");
			if (clientMemberships == null || clientMemberships.size() == 0) {
				System.out.println("Found nothing for client id:"
						+ client.getID() + " name:" + client.getFirstName());
			} else {
				globalMap.putAll(mapClientMemberships(client, clientMemberships));
				
			}
		}

		saveMapInFile(globalMap, ClientMembership.class.getSimpleName());
		System.out.println("Complete GettingActiveMemberships");
		// End Getting active memberships for a given client
	}

	private static Map<String, Object> mapClientMemberships(Client client,
			List<ClientMembership> clientMemberships) {
		Map<String, Object> globalMap = new HashMap<String, Object>();

		for (int j = 0; j < clientMemberships.size(); j++) {
			ClientMembership clientMembership = clientMemberships
					.get(j);
			System.out.println(clientMemberships.get(j).getName());
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(clientMembership,
					Map.class);
			String id = client.getID() + clientMembership.getID();
			globalMap.put(id, map);
		}
		return globalMap;
	}

	private static List<Client> getClients(ClientX0020ServiceSoap clientSoap,
			boolean shouldSaveinFireBase) throws UnsupportedEncodingException,
			FirebaseException, JacksonUtilityException {

		System.out.println("Started clients");
		// Getting active email opted in clients
		GetClientsRequest getClientsRequest = getClientsRequest(0);
		getClientsRequest.setUserCredentials(userCredentials);
		getClientsRequest.setSourceCredentials(sourceCredentials);
		getClientsRequest.setXMLDetail(XMLDetailLevel.FULL);
		getClientsRequest.setPageSize(10000);
		getClientsRequest.setCurrentPageIndex(0);
		getClientsRequest.setSearchText("");

		List<Client> activeClients = new ArrayList<Client>();
		GetClientsResult getClientsResult = clientSoap
				.getClients(getClientsRequest);
		int totalPageCount = getClientsResult.getTotalPageCount();
		Map<String, Object> globalMap = new HashMap<String, Object>();
		globalMap.putAll(mapClients(getClientsResult));
		for (int j = 1; j < totalPageCount; j++) {
			System.out.println("Storing clients in page:" + j);
			getClientsRequest = getClientsRequest(j);
			getClientsResult = clientSoap.getClients(getClientsRequest);
			globalMap.putAll(mapClients(getClientsResult));
			activeClients.addAll(getClientsResult.getClients().getClient());
//			if (j == 5) {
//				break;
//			}
		}
		
		if (shouldSaveinFireBase) {
			saveMapInFile(globalMap, Client.class.getSimpleName());
		}
		System.out.println("Completed getting all clients");

		return activeClients;
		// End Getting active email opted in clients
	}

	private static Map<String, Object> mapClients(
			GetClientsResult getClientsResult) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		List<Client> clientList = getClientsResult.getClients().getClient();
		for (int i = 0; i < clientList.size(); i++) {
//			if (i == 60) {
//				break;
//			}
			Client client = clientList.get(i);
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(client, Map.class);
			String id = client.getID();
			tempMap.put(id, map);
		}
		return tempMap;
	}

	private static GetClientsRequest getClientsRequest(int page) {
		// Getting active email opted in clients
		GetClientsRequest getClientsRequest = new GetClientsRequest();
		getClientsRequest.setUserCredentials(userCredentials);
		getClientsRequest.setSourceCredentials(sourceCredentials);
		getClientsRequest.setXMLDetail(XMLDetailLevel.FULL);
		getClientsRequest.setPageSize(10000);
		getClientsRequest.setCurrentPageIndex(page);
		getClientsRequest.setSearchText("");
		return getClientsRequest;
	}

	private static void getClasses() {
		System.out.println("Started classes");
		ClassX0020Service classService = new ClassX0020Service();
		ClassX0020ServiceSoap classSoap = classService
				.getClassX0020ServiceSoap();

		GetClassesRequest classesRequest = new GetClassesRequest();
		classesRequest.setSourceCredentials(sourceCredentials);
		classesRequest.setUserCredentials(userCredentials);
		classesRequest.setXMLDetail(XMLDetailLevel.FULL);
		classesRequest.setCurrentPageIndex(0);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, kHistory);
		Date dateBefore30Days = cal.getTime();

		GregorianCalendar startDate = new GregorianCalendar();
		startDate.setTime(dateBefore30Days);
		XMLGregorianCalendar calendarStartDate = null;
		try {
			calendarStartDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		classesRequest.setStartDateTime(calendarStartDate);

		GregorianCalendar nextTenDays = new GregorianCalendar();
		nextTenDays.add(Calendar.DATE, 0);

		XMLGregorianCalendar calendarDateNextTenDays = null;
		try {
			calendarDateNextTenDays = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(nextTenDays);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		classesRequest.setEndDateTime(calendarDateNextTenDays);
		classesRequest.setHideCanceledClasses(false);
		GetClassesResult classesResult = classSoap.getClasses(classesRequest);
		Map<String, Object> globalMap = new HashMap<String, Object>();
		globalMap.putAll(mapClasses(classesResult));
		int pageCount = classesResult.getTotalPageCount();
		for (int currentPage = 1; currentPage < pageCount; currentPage++) {
			classesRequest.setCurrentPageIndex(currentPage);
			classesResult = classSoap.getClasses(classesRequest);
			globalMap.putAll(mapClasses(classesResult));
		}
		
		saveMapInFile(globalMap, Class.class.getSimpleName());

		System.out.println("Completed classes");
	}

	private static Map<String, Object> mapClasses(GetClassesResult classesResult) {
		Map<String, Object> globalMap = new HashMap<String, Object>();

		ArrayOfClass arrayOfClasses = classesResult.getClasses();
		if (arrayOfClasses != null && arrayOfClasses.getClazz() != null) {
			List<Class> classesList = arrayOfClasses.getClazz();
			for (int i = 0; i < classesList.size(); i++) {

				ObjectMapper objectMapper = new ObjectMapper();
				Class classInstance = classesList.get(i);
				Map c = objectMapper.convertValue(classInstance, Map.class);
				String id = classInstance.getID().getValue().toString();
				globalMap.put(id, c);
			}
		}
		return globalMap;
	}

	private static void saveMapInFile(Map<String, Object> map, String tableName) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			File file = new File(kBasePath + tableName+format.format(new Date())+".json");
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectMapper objectMapper = new ObjectMapper();
//			InputStream is = new FileInputStream(file);
//			if (is != null && is.available() > 0) {
////				temp = objectMapper.readValue(is, Map.class);
//				String jsonResp = objectMapper.writeValueAsString(map);				
//
//			}
//			temp.putAll(map);
			String jsonResp = objectMapper.writeValueAsString(map);
			FileUtils.write(file, jsonResp);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void saveMapInFireBase(Map<String, Object> map, String tableName,
			String id) {
		
	}

	private static void createFolder() {
		{
			try {
				File file = new File(kBasePath);
				if (!file.exists())
					FileUtils.forceMkdir(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void getEnrollments() {
		System.out.println("Started enrollment");
		ClassX0020Service classService = new ClassX0020Service();
		ClassX0020ServiceSoap classSoap = classService
				.getClassX0020ServiceSoap();
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
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.add(Calendar.DATE, -1);
		cal.add(Calendar.DATE, kHistory);
		Date dateBefore30Days = cal.getTime();

		GregorianCalendar startDate = new GregorianCalendar();
		startDate.setTime(dateBefore30Days);
		XMLGregorianCalendar calendarStartDate = null;
		try {
			calendarStartDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enrollmentsRequest.setStartDate(calendarStartDate);

		GregorianCalendar nextTenDays = new GregorianCalendar();
		nextTenDays.add(Calendar.DATE, 0);

		XMLGregorianCalendar calendarDateNextTenDays = null;
		try {
			calendarDateNextTenDays = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(nextTenDays);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enrollmentsRequest.setEndDate(calendarDateNextTenDays);

		GetEnrollmentsResult enrollmentsResult = classSoap
				.getEnrollments(enrollmentsRequest);
		Map<String, Object> globalMap = new HashMap<String, Object>();
		globalMap.putAll(mapEnrollments(enrollmentsResult));
		int pageCount = enrollmentsResult.getTotalPageCount();
		for (int currentPage = 1; currentPage < pageCount; currentPage++) {
			enrollmentsRequest.setCurrentPageIndex(currentPage);
			enrollmentsResult = classSoap
					.getEnrollments(enrollmentsRequest);
			globalMap.putAll(mapEnrollments(enrollmentsResult));
		}
		saveMapInFile(globalMap, "Enrollments");
		System.out.println("Completed Enrollment");
	}

	private static Map<String, Object> mapEnrollments(
			GetEnrollmentsResult enrollmentsResult) {
		Map tempMap = new HashMap<String, Object>();
		for (int i = 0; i < enrollmentsResult.getEnrollments()
				.getClassSchedule().size(); i++) {

			ClassSchedule schedule = enrollmentsResult.getEnrollments()
					.getClassSchedule().get(i);
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(schedule, Map.class);
			String id = schedule.getID().getValue().toString();
			tempMap.put(id, map);
			
		}
		return tempMap;
	}

	private static void getStaff() {
		System.out.println("Started staff");
		StaffX0020Service staffService = new StaffX0020Service();
		StaffX0020ServiceSoap staffSoap = staffService
				.getStaffX0020ServiceSoap();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.add(Calendar.DATE, -1);
		cal.add(Calendar.DATE, kHistory);
		Date dateBefore30Days = cal.getTime();

		GregorianCalendar startDate = new GregorianCalendar();
		startDate.setTime(dateBefore30Days);
		XMLGregorianCalendar calendarStartDate = null;
		try {
			calendarStartDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetStaffRequest staffRequest = new GetStaffRequest();
		staffRequest.setSourceCredentials(sourceCredentials);
		staffRequest.setUserCredentials(userCredentials);
		staffRequest.setStartDateTime(calendarStartDate);
		Map<String,Object> tempMap = new HashMap<String, Object>();
		GetStaffResult staffResult = staffSoap.getStaff(staffRequest);
		for (int i = 0; i < staffResult.getStaffMembers().getStaff().size(); i++) {
			Staff staff = staffResult.getStaffMembers().getStaff().get(i);
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(staff, Map.class);
			String id = staff.getID().getValue().toString();
			tempMap.put(id, map);
		}
		saveMapInFile(tempMap, Staff.class.getSimpleName());
		System.out.println("Completed staff");
	}

	private static void getSales() {

		System.out.println("Started Getting Sales");
		SaleX0020Service saleService = new SaleX0020Service();
		SaleX0020ServiceSoap saleSoap = saleService.getSaleX0020ServiceSoap();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.add(Calendar.DATE, -1);
		cal.add(Calendar.DATE, -30);
		Date dateBefore30Days = cal.getTime();

		GregorianCalendar startDate = new GregorianCalendar();
		startDate.setTime(dateBefore30Days);
		XMLGregorianCalendar calendarStartDate = null;
		try {
			calendarStartDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GregorianCalendar nextTenDays = new GregorianCalendar();
		nextTenDays.add(Calendar.DATE, 0);

		XMLGregorianCalendar calendarDateNextTenDays = null;
		try {
			calendarDateNextTenDays = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(nextTenDays);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GetSalesRequest salesRequest = new GetSalesRequest();
		salesRequest.setStartSaleDateTime(calendarStartDate);
		salesRequest.setEndSaleDateTime(calendarDateNextTenDays);
		salesRequest.setSourceCredentials(sourceCredentials);
		salesRequest.setUserCredentials(userCredentials);
		salesRequest.setStartSaleDateTime(calendarStartDate);
		salesRequest.setEndSaleDateTime(calendarDateNextTenDays);
		salesRequest.setCurrentPageIndex(0);
		salesRequest.setXMLDetail(XMLDetailLevel.FULL);

		GetSalesResult saleResult = saleSoap.getSales(salesRequest);
		Map<String, Object> globalMap = new HashMap<String, Object>();
		globalMap.putAll(mapSales(saleResult));
		int pageCount = saleResult.getTotalPageCount();
		for (int currentPage = 1; currentPage < pageCount; currentPage++) {
			salesRequest.setCurrentPageIndex(currentPage);
			saleResult = saleSoap
					.getSales(salesRequest);
			globalMap.putAll(mapSales(saleResult));
		}
		saveMapInFile(globalMap, Sale.class.getSimpleName());
		System.out.println("Completed Getting Sales");

	}

	private static Map<String, Object> mapSales(
			GetSalesResult saleResult) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		for (int i = 0; i < saleResult.getSales().getSale().size(); i++) {
			Sale sale = saleResult.getSales().getSale().get(i);
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(sale, Map.class);
			String id = String.valueOf(sale.getID());
			tempMap.put(id, map);
		}
		return tempMap;
	}

	public static void getEmailLists() {
		
		System.out.println("Started Gettin Email Lists");

		ClientX0020Service clientService = new ClientX0020Service();
		ClientX0020ServiceSoap clientSoap = clientService
				.getClientX0020ServiceSoap();

		GetClientIndexesRequest clientIndexesRequest = new GetClientIndexesRequest();
		clientIndexesRequest.setSourceCredentials(sourceCredentials);
		clientIndexesRequest.setUserCredentials(userCredentials);
		clientIndexesRequest.setXMLDetail(XMLDetailLevel.FULL);
		com.mindbodyonline.clients.api._0_5Client.ArrayOfString clientIndexesFields = new com.mindbodyonline.clients.api._0_5Client.ArrayOfString();

		List<String> clientIndexesFieldsList = clientIndexesFields.getString();
		clientIndexesFieldsList.add("Clients.ClientIndexes");
		clientIndexesRequest.setFields(clientIndexesFields);

		Map<String, List<Client>> clientIndexesHashmap = new HashMap<String, List<Client>>();

		long serviceCallStartTime = System.currentTimeMillis();
		GetClientIndexesResult clientIndexesResult = clientSoap
				.getClientIndexes(clientIndexesRequest);

		long dataProcessingStartTime = System.currentTimeMillis();
		for (int i = 0; i < clientIndexesResult.getClientIndexes()
				.getClientIndex().size(); i++) {
			ClientIndex clientIndex = clientIndexesResult.getClientIndexes()
					.getClientIndex().get(i);
			String clientIndexName = clientIndex.getName();
			clientIndexesHashmap.put(clientIndexName, new ArrayList<Client>());
			if (clientIndex.getValues() != null
					&& clientIndex.getValues().getClientIndexValue() != null
					&& clientIndex.getValues().getClientIndexValue().size() > 0) {
				List<ClientIndexValue> subSections = clientIndexesResult
						.getClientIndexes().getClientIndex().get(i).getValues()
						.getClientIndexValue();
				for (int j = 0; j < subSections.size(); j++) {
					clientIndexesHashmap.put(clientIndexName + " - "
							+ subSections.get(j).getName(),
							new ArrayList<Client>());
				}
			}
		}

		GetClientsRequest clientsRequest = new GetClientsRequest();
		clientsRequest.setSourceCredentials(sourceCredentials);
		clientsRequest.setUserCredentials(userCredentials);
		clientsRequest.setXMLDetail(XMLDetailLevel.FULL);
		clientsRequest.setPageSize(5000);
		clientsRequest.setSearchText("");
		// clientIndexesFieldsList.add("Clients.Email");
		// clientIndexesFieldsList.add("Clients.ID");
		// clientIndexesFieldsList.add("Clients.EmailOptIn");
		// clientIndexesFieldsList.add("Clients.ClientIndexes.ArrayOfClientIndex");
		// clientIndexesFieldsList.add("Clients.ClientIndexes.ArrayOfClientIndex.ClientIndex");
		// clientIndexesFieldsList.add("Clients.ClientIndexes.ArrayOfClientIndex.ClientIndex.Name");
		// clientIndexesFieldsList.add("Clients.ClientIndexes.ArrayOfClientIndex.ClientIndex.ArrayOfClientIndexValue");
		// clientIndexesFieldsList.add("Clients.ClientIndexes.ArrayOfClientIndex.ClientIndex.ArrayOfClientIndexValue.ClientIndexValue");

		clientsRequest.setFields(clientIndexesFields);
		clientsRequest.setCurrentPageIndex(0);

		clientIndexesHashmap.put("All", new ArrayList<Client>());

		serviceCallStartTime = System.currentTimeMillis();
		GetClientsResult clientsResult = clientSoap.getClients(clientsRequest);

		dataProcessingStartTime = System.currentTimeMillis();
		clientIndexesHashmap = processEmailOptin(clientIndexesHashmap,
				clientsResult);

		int pageCount = clientsResult.getTotalPageCount();

		for (int currentPage = 1; currentPage < pageCount; currentPage++) {
			clientsRequest.setCurrentPageIndex(currentPage);
			serviceCallStartTime = System.currentTimeMillis();

			clientsResult = clientSoap.getClients(clientsRequest);

			clientIndexesHashmap = processEmailOptin(clientIndexesHashmap,
					clientsResult);

		}

		Map<String, Object> emailListMap = new HashMap<String, Object>();
		Iterator it = clientIndexesHashmap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        List<Client> clients = (List<Client>) pair.getValue();
	        Map<String, Object> clientMap = new HashMap<String, Object>();
	        ObjectMapper m = new ObjectMapper();

	        for (int i = 0; i < clients.size(); i++) {
	        	Client client = clients.get(i);
	        	Map<String, Object> map = m.convertValue(client,
						Map.class);
	        	clientMap.put(client.getID(), map);
			}
	        String id = (String) pair.getKey();
	        emailListMap.put(id, clientMap);
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    saveMapInFile(emailListMap, ClientIndex.class.getSimpleName());

	    System.out.println("Completed Getting Email Lists");
	}

	private static Map<String, List<Client>> processEmailOptin(
			Map<String, List<Client>> currentMap,
			GetClientsResult clientsResult) {

		List<Client> arrayOfClients = clientsResult.getClients().getClient();
		for (int i = 0; i < arrayOfClients.size(); i++) {
			Client client = arrayOfClients.get(i);
			if (client.getEmailOptIn().getValue()
					&& MindBodyUtil.isValidEmail(client.getEmail())) {
				for (int j = 0; j < client.getClientIndexes().getClientIndex()
						.size(); j++) {
					ClientIndex clientIndex = client.getClientIndexes()
							.getClientIndex().get(j);
					String clientIndexName = clientIndex.getName();
					if (!currentMap.containsKey(clientIndexName)) {
						currentMap
								.put(clientIndexName, new ArrayList<Client>());
					}

					List<ClientIndexValue> subSections = clientIndex
							.getValues().getClientIndexValue();
					for (int k = 0; k < subSections.size(); k++) {

						String indexPlusSubsection = clientIndexName + " - "
								+ subSections.get(k).getName();
						if (!currentMap.containsKey(indexPlusSubsection)) {
							currentMap.put(indexPlusSubsection,
									new ArrayList<Client>());
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

}
