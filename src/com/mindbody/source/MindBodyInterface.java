package com.mindbody.source;

import java.util.List;

import com.mindbodyonline.clients.api._0_5.ArrayOfInt;
import com.mindbodyonline.clients.api._0_5.GetActivationCodeRequest;
import com.mindbodyonline.clients.api._0_5.MBRequest;
import com.mindbodyonline.clients.api._0_5.Site;
import com.mindbodyonline.clients.api._0_5.SiteX0020Service;
import com.mindbodyonline.clients.api._0_5.SourceCredentials;
import com.mindbodyonline.clients.api._0_5.UserCredentials;

public class MindBodyInterface {

	public static void main(String args[]) {
		MBRequest request = new MBRequest();
		

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUsername("andy@brndbot.com");
		userCredentials.setPassword("258;Andover");
		request.setUserCredentials(userCredentials);
		
		SourceCredentials sourceCredentials = new SourceCredentials();
		sourceCredentials.setPassword("WBQ2o/mat0gOfT1WeoXDKP1eH8Y=");
		sourceCredentials.setSourceName("BrndbotLLC");
		
		ArrayOfInt siteIds = new ArrayOfInt();
		List<Integer> intList = siteIds.getInt();
		intList.add(7335);
		
		sourceCredentials.setSiteIDs(siteIds);
		
		GetActivationCodeRequest activationCodeResult = new GetActivationCodeRequest();
		activationCodeResult.setSourceCredentials(sourceCredentials);

		SiteX0020Service service = new SiteX0020Service();
		service.getExecutor();
		
	}

}
