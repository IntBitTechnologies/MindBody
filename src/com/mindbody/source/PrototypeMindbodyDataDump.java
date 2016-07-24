package com.mindbody.source;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.codehaus.jackson.map.ObjectMapper;

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
import com.mindbodyonline.clients.api._0_5Client.ClientMembership;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020Service;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Client.GetActiveClientMembershipsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetActiveClientMembershipsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientContractsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientContractsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientsResult;
import com.mindbodyonline.clients.api._0_5Client.Visit;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffRequest;
import com.mindbodyonline.clients.api._0_5Staff.GetStaffResult;
import com.mindbodyonline.clients.api._0_5Staff.Staff;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020Service;
import com.mindbodyonline.clients.api._0_5Staff.StaffX0020ServiceSoap;

public class PrototypeMindbodyDataDump {

	private static String sourcePassword = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
	private static String sourceName = "BrndbotLLC";
	private static String baseURL = "https://brndbot.firebaseio.com/";

	private static UserCredentials userCredentials;
	private static SourceCredentials sourceCredentials;
	private static FirebaseController firebaseController;
	private static int kMinusOneYear = -360;

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

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// try {
//				getClasses();
				// List<Client> clients = getClients(clientSoap, true);
				// getClientMemberships(clientSoap, clients);

				// getClientContracts(clientSoap, clients);

				// getClientVisits(clientSoap, clients);
//				getStaff();
				getEnrollments();
				// } catch (UnsupportedEncodingException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (FirebaseException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (JacksonUtilityException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			}
		};
		runnable.run();
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
				for (int j = 0; j < clientVisits.size(); j++) {
					System.out.println("Found client id:" + client.getID()
							+ " name:" + client.getFirstName());
					Visit visit = clientVisits.get(j);
					System.out.println(clientVisits.get(j).getClassID());
					ObjectMapper m = new ObjectMapper();
					Map<String, Object> map = m.convertValue(visit, Map.class);
					String id = client.getID() + visit.getID();
					saveMapInFireBase(map, Visit.class.getSimpleName(), id);
				}
			}
		} //
			// End Getting client visits
		System.out.println("Completed Getting client visits");
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
				for (int j = 0; j < clientContracts.size(); j++) {
					System.out.println("Found client id:" + client.getID()
							+ " name:" + client.getFirstName());
					ClientContract clientContract = clientContracts.get(j);
					System.out.println(clientContracts.get(j).getAction()
							.value());

					ObjectMapper m = new ObjectMapper();
					Map<String, Object> map = m.convertValue(clientContract,
							Map.class);
					String id = client.getID() + clientContract.getID();
					saveMapInFireBase(map,
							ClientMembership.class.getSimpleName(), id);

				}
			}
		} // End Getting client contracts for a given client
		System.out.println("Completed Getting Client Contracts");

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
				for (int j = 0; j < clientMemberships.size(); j++) {
					System.out.println("Found client id:" + client.getID()
							+ " name:" + client.getFirstName());
					ClientMembership clientMembership = clientMemberships
							.get(j);
					System.out.println(clientMemberships.get(j).getName());

					ObjectMapper m = new ObjectMapper();
					Map<String, Object> map = m.convertValue(clientMembership,
							Map.class);
					String id = client.getID() + clientMembership.getID();
					saveMapInFireBase(map,
							ClientMembership.class.getSimpleName(), id);
				}
			}
		}
		System.out.println("Complete GettingActiveMemberships");
		// End Getting active memberships for a given client
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
		for (int j = 1; j < totalPageCount; j++) {
			System.out.println("Storing clients in page:" + j);
			getClientsRequest = getClientsRequest(j);
			if (j == 2) {
				break;
			}
			List<Client> clientList = getClientsResult.getClients().getClient();
			for (int i = 0; i < clientList.size(); i++) {

				if (i == 40) {
					break;
				}
				Client client = clientList.get(i);
				System.out.println("Storing client:" + client.getLastName()
						+ " number:" + i * j);
				if (client.getEmailOptIn() != null
						&& client.getEmailOptIn().getValue()) {

					if (client.getInactive() == null
							|| (client.getInactive() != null && !client
									.getInactive().getValue())) {
						activeClients.add(client);
						if (shouldSaveinFireBase) {
							ObjectMapper m = new ObjectMapper();
							Map<String, Object> map = m.convertValue(client,
									Map.class);
							String id = client.getID();
							saveMapInFireBase(map,
									Client.class.getSimpleName(), id);
						}
					}
				}
			}
		}
		System.out.println("Completed getting all clients");

		return activeClients;
		// End Getting active email opted in clients
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
		// cal.add(Calendar.DATE, -1);
		cal.add(Calendar.DATE, kMinusOneYear);
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
		// 102 permission denied
		GetClassesResult classesResult = classSoap.getClasses(classesRequest);
		ArrayOfClass arrayOfClasses = classesResult.getClasses();
		if (arrayOfClasses != null && arrayOfClasses.getClazz() != null) {
			List<Class> classesList = arrayOfClasses.getClazz();
			for (int i = 0; i < classesList.size(); i++) {

				Class classInstance = classesList.get(i);
				ObjectMapper m = new ObjectMapper();
				Map<String, Object> map = m.convertValue(classInstance,
						Map.class);
				String id = classInstance.getID().getValue().toString();
				saveMapInFireBase(map, Class.class.getSimpleName(), id);
			}

		}
		System.out.println("Completed classes");
	}

	private static void saveMapInFireBase(Map<String, Object> map, String name,
			String id) {
		try {
			firebaseController.save(name, id, map, new FirebaseCallBack() {

				@Override
				public void errorReceived(Integer arg0) {
					// TODO Auto-generated method
					// stub

				}

				@Override
				public void dataReceived(Map<String, Object> arg0) {
					// TODO Auto-generated method
					// stub

				}
			});
		} catch (Exception e) {
			System.out.println("Could not add instance id:" + id);
		} catch (FirebaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JacksonUtilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		cal.add(Calendar.DATE, kMinusOneYear);
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
		for (int i = 0; i < enrollmentsResult.getEnrollments()
				.getClassSchedule().size(); i++) {

			ClassSchedule schedule = enrollmentsResult.getEnrollments()
					.getClassSchedule().get(i);
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(schedule, Map.class);
			String id = schedule.getID().getValue().toString();
			saveMapInFireBase(map, "Enrollments", id);

		}
		System.out.println("Completed Enrollment");
	}

	private static void getStaff() {
		System.out.println("Started staff");
		StaffX0020Service staffService = new StaffX0020Service();
		StaffX0020ServiceSoap staffSoap = staffService
				.getStaffX0020ServiceSoap();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.add(Calendar.DATE, -1);
		cal.add(Calendar.DATE, kMinusOneYear);
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

		GetStaffResult staffResult = staffSoap.getStaff(staffRequest);
		for (int i = 0; i < staffResult.getStaffMembers().getStaff().size(); i++) {
			Staff staff = staffResult.getStaffMembers().getStaff().get(i);
			ObjectMapper m = new ObjectMapper();
			Map<String, Object> map = m.convertValue(staff, Map.class);
			String id = staff.getID().getValue().toString();
			saveMapInFireBase(map, Staff.class.getSimpleName(), id);
		}
		System.out.println("Completed staff");
	}

}
