package com.mindbody.source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeResult;
import com.mindbodyonline.clients.api._0_5.GetSitesRequest;
import com.mindbodyonline.clients.api._0_5.GetSitesResult;
import com.mindbodyonline.clients.api._0_5.Site;
import com.mindbodyonline.clients.api._0_5.SiteX0020Service;
import com.mindbodyonline.clients.api._0_5.SiteX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;
import com.mindbodyonline.clients.api._0_5.XMLDetailLevel;
import com.mindbodyonline.clients.api._0_5Class.ArrayOfString;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020Service;
import com.mindbodyonline.clients.api._0_5Class.ClassX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Class.GetClassesRequest;
import com.mindbodyonline.clients.api._0_5Class.GetClassesResult;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsRequest;
import com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResult;
import com.mindbodyonline.clients.api._0_5Client.Client;
import com.mindbodyonline.clients.api._0_5Client.ClientIndex;
import com.mindbodyonline.clients.api._0_5Client.ClientIndexValue;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020Service;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesResult;
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

public class MindBody {

	private String userId;
	private String userPassword;
	private ArrayOfInt sitesIds;

	private UserCredentials serviceUserCredentials;
	private SourceCredentials serviceSourceCredentials;

	public MindBody(String userId, String userPassword, int[] siteIdsArray) {

		this.userId = userId;
		this.userPassword = userPassword;

		this.sitesIds = new ArrayOfInt();
		List<Integer> intList = this.sitesIds.getInt();

		for (int i = 0; i < siteIdsArray.length; i++) {
			intList.add(siteIdsArray[i]);
		}

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("_" + this.userId);
		userCredentials.setPassword(this.userPassword);
		userCredentials.setSiteIDs(this.sitesIds);
		this.serviceUserCredentials = userCredentials;

		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName(this.userId);
		sourceCredentials.setPassword(this.userPassword);
		sourceCredentials.setSiteIDs(this.sitesIds);
		this.serviceSourceCredentials = sourceCredentials;
	}

	public static GetActivationCodeResult getActivationCode(String userId,
			String userPassword, int[] siteIds) {
		SiteX0020Service siteService = new SiteX0020Service();
		SiteX0020ServiceSoap siteSoap = siteService.getSiteX0020ServiceSoap();

		GetActivationCodeRequest activationRequest = new GetActivationCodeRequest();
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName(userId);
		sourceCredentials.setPassword(userPassword);
		ArrayOfInt siteIdsArray = new ArrayOfInt();
		List<Integer> intList = siteIdsArray.getInt();

		for (int i = 0; i < siteIds.length; i++) {
			intList.add(siteIds[i]);
		}

		sourceCredentials.setSiteIDs(siteIdsArray);
		activationRequest.setSourceCredentials(sourceCredentials);
		GetActivationCodeResult activationResult = siteSoap
				.getActivationCode(activationRequest);
		return activationResult;
	}

	public GetClassesResult getClasses(GetClassesRequest classesRequest) {
		if (isActivated()) {

			classesRequest.setSourceCredentials(serviceSourceCredentials);
			classesRequest.setUserCredentials(serviceUserCredentials);
			classesRequest.setXMLDetail(XMLDetailLevel.FULL);

			ClassX0020Service classService = new ClassX0020Service();
			ClassX0020ServiceSoap classSoap = classService
					.getClassX0020ServiceSoap();
			GetClassesResult classesResult = classSoap
					.getClasses(classesRequest);
			return classesResult;
		}
		return null;
	}

	public GetEnrollmentsResult getEnrollments(
			GetEnrollmentsRequest enrollmentsRequest) {
		if (isActivated()) {

			enrollmentsRequest.setSourceCredentials(serviceSourceCredentials);
			enrollmentsRequest.setUserCredentials(serviceUserCredentials);
			enrollmentsRequest.setXMLDetail(XMLDetailLevel.FULL);

			ArrayOfString enrollmentFields = new ArrayOfString();
			List<String> enrollmentFieldsList = enrollmentFields.getString();
			enrollmentFieldsList.add("Enrollment.Classes");
			enrollmentFieldsList.add("Enrollments.Classes.Resource");
			enrollmentsRequest.setFields(enrollmentFields);

			ClassX0020Service classService = new ClassX0020Service();
			ClassX0020ServiceSoap classSoap = classService
					.getClassX0020ServiceSoap();

			GetEnrollmentsResult enrollmentsResult = classSoap
					.getEnrollments(enrollmentsRequest);
			return enrollmentsResult;
		}
		return null;
	}

	public GetStaffResult getStaff(GetStaffRequest staffRequest) {
		if (isActivated()) {

			staffRequest.setSourceCredentials(serviceSourceCredentials);
			staffRequest.setUserCredentials(serviceUserCredentials);
			staffRequest.setXMLDetail(XMLDetailLevel.FULL);

			StaffX0020Service staffService = new StaffX0020Service();
			StaffX0020ServiceSoap staffSoap = staffService
					.getStaffX0020ServiceSoap();

			GetStaffResult staffResult = staffSoap.getStaff(staffRequest);
			return staffResult;
		}
		return null;
	}

	public GetSalesResult getSales(GetSalesRequest salesRequest) {
		if (isActivated()) {
			salesRequest.setSourceCredentials(serviceSourceCredentials);
			salesRequest.setUserCredentials(serviceUserCredentials);
			salesRequest.setXMLDetail(XMLDetailLevel.FULL);

			SaleX0020Service saleService = new SaleX0020Service();
			SaleX0020ServiceSoap saleSoap = saleService
					.getSaleX0020ServiceSoap();

			GetSalesResult saleResult = saleSoap.getSales(salesRequest);
			return saleResult;
		}
		return null;
	}

	public GetClientsResult getClients(GetClientsRequest clientsRequest) {
		if (isActivated()) {
			clientsRequest.setSourceCredentials(serviceSourceCredentials);
			clientsRequest.setUserCredentials(serviceUserCredentials);
			clientsRequest.setXMLDetail(XMLDetailLevel.FULL);

			ClientX0020Service clientService = new ClientX0020Service();
			ClientX0020ServiceSoap clientSoap = clientService
					.getClientX0020ServiceSoap();

			GetClientsResult clientsResult = clientSoap
					.getClients(clientsRequest);
			return clientsResult;

		}
		return null;
	}

	public boolean isActivated() {

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("_" + this.userId);
		userCredentials.setPassword(this.userPassword);
		userCredentials.setSiteIDs(this.sitesIds);

		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName(this.userId);
		sourceCredentials.setPassword(this.userPassword);
		sourceCredentials.setSiteIDs(this.sitesIds);

		GetSitesRequest getSitesRequest = new GetSitesRequest();
		getSitesRequest.setSearchText("");
		getSitesRequest.setSourceCredentials(sourceCredentials);
		getSitesRequest.setUserCredentials(userCredentials);

		SiteX0020Service siteService = new SiteX0020Service();
		SiteX0020ServiceSoap siteSoap = siteService.getSiteX0020ServiceSoap();

		GetSitesResult sitesResult = siteSoap.getSites(getSitesRequest);
		if (sitesResult.getSites() != null) {

			for (int i = 0; i < sitesResult.getSites().getSite().size(); i++) {
				Site site = sitesResult.getSites().getSite().get(i);
				if (sitesIds.getInt().contains(site.getID())) {
					return true;
				}
			}
		}
		return false;
	}

	public HashMap<String, List<Client>> getEmailLists() {
		if (isActivated()) {

			long startTime = System.currentTimeMillis();
			long serviceCallTime = 0;
			long dataProcessingTime = 0;
			long endTime = 0;

			ClientX0020Service clientService = new ClientX0020Service();
			ClientX0020ServiceSoap clientSoap = clientService
					.getClientX0020ServiceSoap();

			GetClientIndexesRequest clientIndexesRequest = new GetClientIndexesRequest();
			clientIndexesRequest.setSourceCredentials(serviceSourceCredentials);
			clientIndexesRequest.setUserCredentials(serviceUserCredentials);
			clientIndexesRequest.setXMLDetail(XMLDetailLevel.FULL);
			com.mindbodyonline.clients.api._0_5Client.ArrayOfString clientIndexesFields = new com.mindbodyonline.clients.api._0_5Client.ArrayOfString();

			List<String> clientIndexesFieldsList = clientIndexesFields
					.getString();
			clientIndexesFieldsList.add("Clients.ClientIndexes");
			clientIndexesRequest.setFields(clientIndexesFields);

			HashMap<String, List<Client>> clientIndexesHashmap = new HashMap<String, List<Client>>();

			long serviceCallStartTime = System.currentTimeMillis();
			GetClientIndexesResult clientIndexesResult = clientSoap
					.getClientIndexes(clientIndexesRequest);

			endTime = System.currentTimeMillis();
			serviceCallTime = serviceCallTime
					+ (endTime - serviceCallStartTime);

			long dataProcessingStartTime = System.currentTimeMillis();
			for (int i = 0; i < clientIndexesResult.getClientIndexes()
					.getClientIndex().size(); i++) {
				ClientIndex clientIndex = clientIndexesResult
						.getClientIndexes().getClientIndex().get(i);
				String clientIndexName = clientIndex.getName();
				clientIndexesHashmap.put(clientIndexName,
						new ArrayList<Client>());
				if (clientIndex.getValues() != null
						&& clientIndex.getValues().getClientIndexValue() != null
						&& clientIndex.getValues().getClientIndexValue().size() > 0) {
					List<ClientIndexValue> subSections = clientIndexesResult
							.getClientIndexes().getClientIndex().get(i)
							.getValues().getClientIndexValue();
					for (int j = 0; j < subSections.size(); j++) {
						clientIndexesHashmap.put(clientIndexName + " - "
								+ subSections.get(j).getName(),
								new ArrayList<Client>());
					}
				}
			}

			endTime = System.currentTimeMillis();
			dataProcessingTime = dataProcessingTime
					+ (endTime - dataProcessingStartTime);

			GetClientsRequest clientsRequest = new GetClientsRequest();
			clientsRequest.setSourceCredentials(serviceSourceCredentials);
			clientsRequest.setUserCredentials(serviceUserCredentials);
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
			GetClientsResult clientsResult = clientSoap
					.getClients(clientsRequest);

			endTime = System.currentTimeMillis();
			serviceCallTime = serviceCallTime
					+ (endTime - serviceCallStartTime);

			dataProcessingStartTime = System.currentTimeMillis();
			clientIndexesHashmap = processEmailOptin(clientIndexesHashmap,
					clientsResult);

			endTime = System.currentTimeMillis();
			dataProcessingTime = dataProcessingTime
					+ (endTime - dataProcessingStartTime);

			int pageCount = clientsResult.getTotalPageCount();

			for (int currentPage = 1; currentPage < pageCount; currentPage++) {
				clientsRequest.setCurrentPageIndex(currentPage);
				serviceCallStartTime = System.currentTimeMillis();

				clientsResult = clientSoap.getClients(clientsRequest);

				endTime = System.currentTimeMillis();
				serviceCallTime = serviceCallTime
						+ (endTime - serviceCallStartTime);

				dataProcessingStartTime = System.currentTimeMillis();
				clientIndexesHashmap = processEmailOptin(clientIndexesHashmap,
						clientsResult);
				endTime = System.currentTimeMillis();
				dataProcessingTime = dataProcessingTime
						+ (endTime - dataProcessingStartTime);

			}

			endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			// System.out.println("Data Processing time:"+dataProcessingTime /
			// 1000.0+" seconds");
			// System.out.println("Service Call Execution time:"+serviceCallTime
			// / 1000.0+" seconds");
			// System.out.println(totalTime / 1000.0+" seconds");

			return clientIndexesHashmap;
		}
		return null;
	}

	private static HashMap<String, List<Client>> processEmailOptin(
			HashMap<String, List<Client>> currentMap,
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
