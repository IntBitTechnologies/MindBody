package com.mindbody.source;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.intbit.firebase.controller.FirebaseController;
import com.intbit.firebase.error.FirebaseException;
import com.intbit.firebase.error.JacksonUtilityException;
import com.intbit.firebase.service.FirebaseCallBack;
import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;
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

public class PrototypeMindbodyDataDump {

	private static String sourcePassword = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
	private static String sourceName = "BrndbotLLC";
	private static String baseURL = "https://brndbot.firebaseio.com";

	private static UserCredentials userCredentials;
	private static SourceCredentials sourceCredentials;
	private static FirebaseController firebaseController;

	public static void main(String args[]) {

		try {
			firebaseController = new FirebaseController(baseURL);

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

			List<Client> clients = getClients(clientSoap);

			getClientMemberships(clientSoap, clients);

			getClientContracts(clientSoap, clients);

			getClientVisits(clientSoap, clients);

		} catch (Exception | FirebaseException | JacksonUtilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getClientVisits(ClientX0020ServiceSoap clientSoap,
			List<Client> activeClients) {
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
					System.out.println(clientVisits.get(j).getClassID());
				}
			}
		} //
		// End Getting client visits

	}

	private static void getClientContracts(ClientX0020ServiceSoap clientSoap,
			List<Client> activeClients) {
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
					System.out.println(clientContracts.get(j).getAction()
							.value());
				}
			}
		} // End Getting client contracts for a given client

	}

	private static void getClientMemberships(ClientX0020ServiceSoap clientSoap,
			List<Client> activeClients) {

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
					System.out.println(clientMemberships.get(j).getName());
				}
			}
		}
		// End Getting active memberships for a given client
	}

	private static List<Client> getClients(ClientX0020ServiceSoap clientSoap)
			throws UnsupportedEncodingException, FirebaseException,
			JacksonUtilityException {
		// Getting active email opted in clients
		GetClientsRequest getClientsRequest = new GetClientsRequest();
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
		for (int j = 0; j < totalPageCount; j++) {
			List<Client> clientList = getClientsResult.getClients().getClient();
			for (int i = 0; i < clientList.size(); i++) {
				Client client = clientList.get(i);
				if (client.getEmailOptIn() != null
						&& client.getEmailOptIn().getValue()) {

					if (client.getInactive() == null
							|| (client.getInactive() != null && !client
									.getInactive().getValue())) {
						activeClients.add(client);
						ObjectMapper m = new ObjectMapper();
						Map<String, Object> map = m.convertValue(client,
								Map.class);
						firebaseController.save(Client.class.getName(), client.getID(),
								map, new FirebaseCallBack() {

									@Override
									public void errorReceived(Integer arg0) {
										// TODO Auto-generated method stub

									}

									@Override
									public void dataReceived(
											Map<String, Object> arg0) {
										// TODO Auto-generated method stub

									}
								});
					}
				}
			}
			getClientsRequest.setCurrentPageIndex(j);
		}
		System.out.println("Completed getting all clients");

		return activeClients;
		// End Getting active email opted in clients
	}
}
