package com.mindbody.source;

import java.util.List;

import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeResult;
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
		userCredentials.setUsername("_"+this.userId);
		userCredentials.setPassword(this.userPassword);
		userCredentials.setSiteIDs(this.sitesIds);
		this.serviceUserCredentials = userCredentials;
		
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setSourceName(this.userId);
		sourceCredentials.setPassword(this.userPassword);
		sourceCredentials.setSiteIDs(this.sitesIds);
		this.serviceSourceCredentials = sourceCredentials;
	}
	
	public GetActivationCodeResult getActivationCode(String userId, String userPassword, int[] siteIds) {
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
		GetActivationCodeResult activationResult = siteSoap.getActivationCode(activationRequest);
		return activationResult;
	}
	
	public GetClassesResult getClasses(GetClassesRequest classesRequest) {
		classesRequest.setSourceCredentials(serviceSourceCredentials);
		classesRequest.setUserCredentials(serviceUserCredentials);
		classesRequest.setXMLDetail(XMLDetailLevel.FULL);

		ClassX0020Service classService = new ClassX0020Service();
		ClassX0020ServiceSoap classSoap = classService.getClassX0020ServiceSoap();
		GetClassesResult classesResult = classSoap.getClasses(classesRequest);
		return classesResult;
	}
	
	public GetEnrollmentsResult getEnrollments(GetEnrollmentsRequest enrollmentsRequest) {
		enrollmentsRequest.setSourceCredentials(serviceSourceCredentials);
		enrollmentsRequest.setUserCredentials(serviceUserCredentials);
		enrollmentsRequest.setXMLDetail(XMLDetailLevel.FULL);

		ArrayOfString enrollmentFields = new ArrayOfString();
		List<String> enrollmentFieldsList = enrollmentFields.getString();
		enrollmentFieldsList.add("Enrollment.Classes");
		enrollmentFieldsList.add("Enrollments.Classes.Resource");
		enrollmentsRequest.setFields(enrollmentFields);

		ClassX0020Service classService = new ClassX0020Service();
		ClassX0020ServiceSoap classSoap = classService.getClassX0020ServiceSoap();

		GetEnrollmentsResult enrollmentsResult = classSoap.getEnrollments(enrollmentsRequest);
		return enrollmentsResult;
	}
	
	public GetStaffResult getStaff(GetStaffRequest staffRequest) {
		staffRequest.setSourceCredentials(serviceSourceCredentials);
		staffRequest.setUserCredentials(serviceUserCredentials);
		staffRequest.setXMLDetail(XMLDetailLevel.FULL);

		StaffX0020Service staffService = new StaffX0020Service();
		StaffX0020ServiceSoap staffSoap = staffService.getStaffX0020ServiceSoap();		
		
		GetStaffResult staffResult = staffSoap.getStaff(staffRequest);
		return staffResult;
	}
	
	public GetSalesResult getSales(GetSalesRequest salesRequest) {
		salesRequest.setSourceCredentials(serviceSourceCredentials);
		salesRequest.setUserCredentials(serviceUserCredentials);
		salesRequest.setXMLDetail(XMLDetailLevel.FULL);

		SaleX0020Service saleService = new SaleX0020Service();
		SaleX0020ServiceSoap saleSoap = saleService.getSaleX0020ServiceSoap();
		
		GetSalesResult saleResult = saleSoap.getSales(salesRequest);
		return saleResult;
	}
	
	public GetClientsResult getClients(GetClientsRequest clientsRequest) {
		clientsRequest.setSourceCredentials(serviceSourceCredentials);
		clientsRequest.setUserCredentials(serviceUserCredentials);
		clientsRequest.setXMLDetail(XMLDetailLevel.FULL);

		ClientX0020Service clientService = new ClientX0020Service();
		ClientX0020ServiceSoap clientSoap = clientService.getClientX0020ServiceSoap();
		
		GetClientsResult clientsResult = clientSoap.getClients(clientsRequest);
		return clientsResult;
	}
}
