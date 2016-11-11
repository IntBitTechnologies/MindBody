package com.mindbody.source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import com.mindbodyonline.clients.api._0_5.ArrayOfFunctionParam;
import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.FunctionDataXmlRequest;
import com.mindbodyonline.clients.api._0_5.FunctionParam;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeResult;
import com.mindbodyonline.clients.api._0_5.GetLocationsRequest;
import com.mindbodyonline.clients.api._0_5.GetLocationsResult;
import com.mindbodyonline.clients.api._0_5.GetProgramsRequest;
import com.mindbodyonline.clients.api._0_5.GetProgramsResult;
import com.mindbodyonline.clients.api._0_5.GetSitesRequest;
import com.mindbodyonline.clients.api._0_5.GetSitesResult;
import com.mindbodyonline.clients.api._0_5.SelectDataCSVResult;
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
import com.mindbodyonline.clients.api._0_5Client.AddOrUpdateClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.AddOrUpdateClientsResult;
import com.mindbodyonline.clients.api._0_5Client.ArrayOfClient;
import com.mindbodyonline.clients.api._0_5Client.Client;
import com.mindbodyonline.clients.api._0_5Client.ClientIndex;
import com.mindbodyonline.clients.api._0_5Client.ClientIndexValue;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020Service;
import com.mindbodyonline.clients.api._0_5Client.ClientX0020ServiceSoap;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientIndexesResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientVisitsResult;
import com.mindbodyonline.clients.api._0_5Client.GetClientsRequest;
import com.mindbodyonline.clients.api._0_5Client.GetClientsResult;
import com.mindbodyonline.clients.api._0_5Client.ObjectFactory;
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

//When creating Jar file. Choose Runnable Jar and Choose MindBodyTest - Utility as the main file. 
//And make sure the project where this is used has all the jars. This is not a far JAR. FYI
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
//			long totalTime = endTime - startTime;
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

	public Map<String, String> searchEmailAndUpdateEmailOptIn(
			List<String> emailIds) {

		Map<String, String> result = new HashMap<String, String>();

		if (isActivated()) {

			long startTime = System.currentTimeMillis();

			ClientX0020Service clientService = new ClientX0020Service();
			ClientX0020ServiceSoap clientSoap = clientService
					.getClientX0020ServiceSoap();

			GetClientsRequest clientsRequest = new GetClientsRequest();
			clientsRequest.setSourceCredentials(serviceSourceCredentials);
			clientsRequest.setUserCredentials(serviceUserCredentials);
			clientsRequest.setXMLDetail(XMLDetailLevel.FULL);
			clientsRequest.setPageSize(5000);
			clientsRequest.setCurrentPageIndex(0);

			ArrayOfClient arrayOfClient = new ArrayOfClient();

			for (int i = 0; i < emailIds.size(); i++) {
				if (emailIds.get(i) != null
						&& MindBodyUtil.isValidEmail(emailIds.get(i))) {
					clientsRequest.setSearchText(emailIds.get(i));
					GetClientsResult clientsResult = clientSoap
							.getClients(clientsRequest);
					if (clientsResult != null
							&& clientsResult.getClients() != null
							&& clientsResult.getClients().getClient().size() > 0) {
						arrayOfClient.getClient().addAll(
								clientsResult.getClients().getClient());
					}
				}
			}
			result = updateMindbodyOptin(clientSoap, arrayOfClient);
			long endTime = System.currentTimeMillis();
			result.put("Total time of execution",
					String.valueOf(endTime - startTime));
		} else {
			result.put("Mindbody not activated", "true");
		}

		return result;
	}

	private Map<String, String> updateMindbodyOptin(
			ClientX0020ServiceSoap clientSoap, ArrayOfClient clientArray) {
		AddOrUpdateClientsRequest addOrUpdateClientsRequest = new AddOrUpdateClientsRequest();
		addOrUpdateClientsRequest.setUserCredentials(serviceUserCredentials);
		addOrUpdateClientsRequest
				.setSourceCredentials(serviceSourceCredentials);
		addOrUpdateClientsRequest.setSendEmail(false);
		addOrUpdateClientsRequest.setUpdateAction("Update");
		addOrUpdateClientsRequest.setTest(false);
		List<Client> clientList = clientArray.getClient();
		List<Client> updatedClientList = new ArrayList<Client>();
		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<Boolean> boolValue = objectFactory
				.createClientEmailOptIn(false);

		int i = 0;
		if (clientList != null && clientList.size() > 0) {
			for (Client client : clientList) {
				++i;
				client.setEmailOptIn(boolValue);
				updatedClientList.add(client);
			}
			ArrayOfClient updatedClientArray = new ArrayOfClient();
			updatedClientArray.getClient().addAll(updatedClientList);
			addOrUpdateClientsRequest.setClients(updatedClientArray);
			AddOrUpdateClientsResult addOrUpdateClientsResult = clientSoap
					.addOrUpdateClients(addOrUpdateClientsRequest);
			if (addOrUpdateClientsResult.getErrorCode() != 200) {
				i = 0;
			}
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("Number of clients updated", String.valueOf(i));
		return result;
	}

	public SalesDetailResponse getSalesDetail(SalesDetailRequest salesDetailRequest) throws IOException {
		if (isActivated()) {
			FunctionDataXmlRequest functionDataXmlRequest = MindBodyUtil
					.generalFunctionalRequest("BrndBot_GetSalesDetail",
							serviceUserCredentials, serviceSourceCredentials);
			functionDataXmlRequest = getSalesDetail(functionDataXmlRequest,
					salesDetailRequest);
			SelectDataCSVResult selectDataCSVResult = MindBodyUtil.executeFunctionRequest(functionDataXmlRequest);
			SalesDetailResponse salesDetailResponse = SalesDetailResponse.parse(selectDataCSVResult);
			return salesDetailResponse;
		}
		return null;
	}

	public RevenueCategoryResponse getRevenueCategories(
			MindBodyRevenueType revenueType) throws IOException {
		if (isActivated()) {
			FunctionDataXmlRequest functionDataXmlRequest = MindBodyUtil
					.generalFunctionalRequest("BrndBot_GetRevenueCategories",
							serviceUserCredentials, serviceSourceCredentials);
			functionDataXmlRequest = getRevenueCategories(
					functionDataXmlRequest, revenueType);
			SelectDataCSVResult selectDataCSVResult = MindBodyUtil.executeFunctionRequest(functionDataXmlRequest);
			RevenueCategoryResponse revenueCategoryResponse = RevenueCategoryResponse.parse(selectDataCSVResult);
			return revenueCategoryResponse;
		}
		return null;
	}

	public NoReturnDetailResponse getNoReturnDetail(NoReturnDetailRequest noReturnDetailRequest) throws IOException {
		if (isActivated()) {
			FunctionDataXmlRequest functionDataXmlRequest = MindBodyUtil
					.generalFunctionalRequest("Brndbot_NoReturnDetail",
							serviceUserCredentials, serviceSourceCredentials);
			functionDataXmlRequest = getNoReturnDetail(functionDataXmlRequest,
					noReturnDetailRequest);
			SelectDataCSVResult selectDataCSVResult = MindBodyUtil.executeFunctionRequest(functionDataXmlRequest);
			NoReturnDetailResponse response = NoReturnDetailResponse.parse(selectDataCSVResult);
			return response;

		}
		return null;
	}

	private FunctionDataXmlRequest getRevenueCategories(
			FunctionDataXmlRequest functionDataXmlRequest,
			MindBodyRevenueType revenueType) {
		ArrayOfFunctionParam arrayOfFunctionParam = new ArrayOfFunctionParam();
		List<FunctionParam> functionParams = arrayOfFunctionParam
				.getFunctionParam();
		FunctionParam functionParam = new FunctionParam();

		functionParam.setParamDataType("string");
		if (revenueType == null) {
			revenueType = MindBodyRevenueType.Service;
		}
		functionParam.setParamValue(revenueType.getValue());
		functionParam.setParamName("@revenuetype");

		functionParams.add(functionParam);

		functionDataXmlRequest.setFunctionParams(arrayOfFunctionParam);
		return functionDataXmlRequest;
	}

	private FunctionDataXmlRequest getSalesDetail(
			FunctionDataXmlRequest functionDataXmlRequest,
			SalesDetailRequest salesDetailRequest) {

		ArrayOfFunctionParam arrayOfFunctionParam = new ArrayOfFunctionParam();
		List<FunctionParam> functionParams = arrayOfFunctionParam
				.getFunctionParam();

		FunctionParam functionParam = new FunctionParam();
		if (!MindBodyUtil.isEmpty(salesDetailRequest.getStartDate())) {
			functionParam.setParamDataType("Date");
			functionParam.setParamValue(salesDetailRequest.getStartDate());
			functionParam.setParamName("@startdate");
			functionParams.add(functionParam);
		}

		if (!MindBodyUtil.isEmpty(salesDetailRequest.getEndDate())) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("Date");
			functionParam.setParamValue(salesDetailRequest.getEndDate());
			functionParam.setParamName("@enddate");
			functionParams.add(functionParam);
		}

		if (salesDetailRequest.getServiceCategoryId() != null) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("int");
			functionParam.setParamValue(String.valueOf(salesDetailRequest
					.getServiceCategoryId()));
			functionParam.setParamName("@servicecategoryID");
			functionParams.add(functionParam);
		}

		if (salesDetailRequest.getRevenueCategoryId() != null) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("int");
			functionParam.setParamValue(String.valueOf(salesDetailRequest
					.getRevenueCategoryId()));
			functionParam.setParamName("@revenuecategoryID");
			functionParams.add(functionParam);
		}

		if (salesDetailRequest.getPricingOptionId() != null) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("int");
			functionParam.setParamValue(String.valueOf(salesDetailRequest
					.getPricingOptionId()));
			functionParam.setParamName("@pricingoptionID");
			functionParams.add(functionParam);
		}

		if (salesDetailRequest.getLocationId() != null) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("int");
			functionParam.setParamValue(String.valueOf(salesDetailRequest
					.getLocationId()));
			functionParam.setParamName("@locationID");
			functionParams.add(functionParam);
		}

		if (functionParams != null && functionParams.size() > 0) {
			functionDataXmlRequest.setFunctionParams(arrayOfFunctionParam);
		}

		return functionDataXmlRequest;
	}

	private FunctionDataXmlRequest getNoReturnDetail(
			FunctionDataXmlRequest functionDataXmlRequest,
			NoReturnDetailRequest noReturnDetailRequest) {
		ArrayOfFunctionParam arrayOfFunctionParam = new ArrayOfFunctionParam();
		List<FunctionParam> functionParams = arrayOfFunctionParam
				.getFunctionParam();

		FunctionParam functionParam = new FunctionParam();
		if (!MindBodyUtil.isEmpty(noReturnDetailRequest.getStartDate())) {
			functionParam.setParamDataType("datetime");
			functionParam.setParamValue(noReturnDetailRequest.getStartDate());
			functionParam.setParamName("@startdate");
			functionParams.add(functionParam);
		}

		if (!MindBodyUtil.isEmpty(noReturnDetailRequest.getEndDate())) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("datetime");
			functionParam.setParamValue(noReturnDetailRequest.getEndDate());
			functionParam.setParamName("@enddate");
			functionParams.add(functionParam);
		}

		if (noReturnDetailRequest.getPricingOptionId() != null) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("int");
			functionParam.setParamValue(String.valueOf(noReturnDetailRequest
					.getPricingOptionId()));
			functionParam.setParamName("@pricingoptionID");
			functionParams.add(functionParam);
		}

		if (noReturnDetailRequest.getLocationId() != null) {
			functionParam = new FunctionParam();
			functionParam.setParamDataType("int");
			functionParam.setParamValue(String.valueOf(noReturnDetailRequest
					.getLocationId()));
			functionParam.setParamName("@locationID");
			functionParams.add(functionParam);
		}

		if (functionParams != null && functionParams.size() > 0) {
			functionDataXmlRequest.setFunctionParams(arrayOfFunctionParam);
		}

		return functionDataXmlRequest;
	}

	public GetServicesResult getPricingOptions(List<Integer> programIds) {
		if (isActivated()) {

			GetServicesRequest servicesRequest = new GetServicesRequest();
			servicesRequest.setSourceCredentials(serviceSourceCredentials);
			servicesRequest.setUserCredentials(serviceUserCredentials);
			servicesRequest.setCurrentPageIndex(0);
			servicesRequest.setXMLDetail(XMLDetailLevel.FULL);
			ArrayOfInt programArrayOfInt = new ArrayOfInt();
			List<Integer> programIdsList = programArrayOfInt.getInt();
			if (programIds != null && programIds.size() > 0) {
				for (Iterator<Integer> iterator = programIds.iterator(); iterator
						.hasNext();) {
					Integer id = (Integer) iterator.next();
					programIdsList.add(id);
				}
				servicesRequest.setProgramIDs(programArrayOfInt);
			}

			SaleX0020Service saleService = new SaleX0020Service();
			SaleX0020ServiceSoap saleSoap = saleService
					.getSaleX0020ServiceSoap();
			GetServicesResult servicesResult = saleSoap
					.getServices(servicesRequest);
			return servicesResult;
		}
		return null;
	}

	public GetProgramsResult getServiceCategories(
			com.mindbodyonline.clients.api._0_5.ScheduleType scheduleType,
			Boolean onlineOnly) {
		if (isActivated()) {

			GetProgramsRequest programsRequest = new GetProgramsRequest();
			programsRequest.setSourceCredentials(serviceSourceCredentials);
			programsRequest.setUserCredentials(serviceUserCredentials);
			if (onlineOnly == null) {
				onlineOnly = false;
			}
			programsRequest.setOnlineOnly(onlineOnly);
			programsRequest.setScheduleType(scheduleType);
			SiteX0020Service siteService = new SiteX0020Service();
			SiteX0020ServiceSoap siteSoap = siteService
					.getSiteX0020ServiceSoap();
			GetProgramsResult programsResult = siteSoap
					.getPrograms(programsRequest);
			return programsResult;
		}

		return null;
	}
	
	public GetLocationsResult getLocations(){
		if (isActivated()) {
			GetLocationsRequest locationsRequest = new GetLocationsRequest();
			locationsRequest.setSourceCredentials(serviceSourceCredentials);
			locationsRequest.setUserCredentials(serviceUserCredentials);
			SiteX0020Service siteService = new SiteX0020Service();
			SiteX0020ServiceSoap siteSoap = siteService
					.getSiteX0020ServiceSoap();
			GetLocationsResult locationsResult = siteSoap
					.getLocations(locationsRequest);
			return locationsResult;
		}

		return null;
	}
	
	public GetClientVisitsResult getClientVisits(GetClientVisitsRequest clientVisitsRequest){
		if (isActivated()) {
			clientVisitsRequest.setSourceCredentials(serviceSourceCredentials);
			clientVisitsRequest.setUserCredentials(serviceUserCredentials);
			ClientX0020Service clientService = new ClientX0020Service();
			ClientX0020ServiceSoap clientSoap = clientService
					.getClientX0020ServiceSoap();
			GetClientVisitsResult clientVisitsResult = clientSoap
					.getClientVisits(clientVisitsRequest);
			return clientVisitsResult;
		}

		return null;
	}
}
