package com.mindbody.source;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MainClass {

	public MainClass() {

		/*<soapenv:envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns="http://clients.mindbodyonline.com/api/0_5"> 
	    <soapenv:header />
	    <soapenv:body>
	        <getactivationcode>
	            <request>
	                <sourcecredentials>
	                <sourcename>XXXX</sourcename>
	                <password>XXXX</password>
	                <siteids> 
	                    <int>XXXX</int>
	                </siteids>
	                </sourcecredentials>
	            </request>
	        </getactivationcode>
	    </soapenv:Body />
	    </soapenv:Envelope />*/

	}

	public static void main(String[] args) {
		try {

			String userNameString = "BrndbotLLC";
			String passwordString = "WBQ2o/mat0gOfT1WeoXDKP1eH8Y=";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
						
			Element soapEnv = doc.createElement("soapenv:Envelope");
			soapEnv.setAttribute("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			soapEnv.setAttribute("xmlns", "http://clients.mindbodyonline.com/api/0_5");
			
//			soapEnv.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
//			soapEnv.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
//			soapEnv.setAttribute("xmlns:soap", "http://schemas.xmlsoap.org/soap/envelope/");

			doc.appendChild(soapEnv);
			
			Element soapHeader = doc.createElement("soapenv:Header");
			soapEnv.appendChild(soapHeader);
			
			Element soapBody = doc.createElement("soapenv:Body");
			soapEnv.appendChild(soapBody);
			
			String prefix = "";
			
			Element getactivationcode = doc.createElement(prefix+"GetActivationCode");
//			getactivationcode.setAttribute("xmlns", "http://clients.mindbodyonline.com/api/0_5/");
			soapBody.appendChild(getactivationcode);
			
			Element request = doc.createElement(prefix+"Request");
			getactivationcode.appendChild(request);

			
			Element rootElement = doc.createElement(prefix+"SourceCredentials");
			request.appendChild(rootElement);

			Element sourceName = doc.createElement(prefix+"SourceName");
			sourceName.appendChild(doc.createTextNode(userNameString));

			rootElement.appendChild(sourceName);

			Element password = doc.createElement(prefix+"Password");
			password.appendChild(doc.createTextNode(passwordString));
			rootElement.appendChild(password);


			Element siteIds = doc.createElement(prefix+"SiteIDs");
			rootElement.appendChild(siteIds);
			
			Element siteId = doc.createElement(prefix+"int");
			siteId.appendChild(doc.createTextNode("7335"));
			siteIds.appendChild(siteId);

			request.appendChild(rootElement);
			
			Element userCredentials = doc.createElement(prefix+"UserCredentials");
			
			Element username = doc.createElement(prefix+"Username");
			username.appendChild(doc.createTextNode("andy@brndbot.com"));
			
			Element upassword = doc.createElement(prefix+"Password");
			upassword.appendChild(doc.createTextNode("258;Andover"));
			
			Element siteIds2 = doc.createElement(prefix+"SiteIDs");
			

			userCredentials.appendChild(username);
			userCredentials.appendChild(upassword);
			userCredentials.appendChild(siteIds2);
			request.appendChild(userCredentials);
			
			Element xmlDetail = doc.createElement(prefix+"XMLDetail");
			xmlDetail.appendChild(doc.createTextNode("Full"));
			request.appendChild(xmlDetail);
			
			Element pageSize = doc.createElement(prefix+"PageSize");
			pageSize.appendChild(doc.createTextNode("50"));
			request.appendChild(pageSize);
			
			Element currentPageIndex = doc.createElement(prefix+"CurrentPageIndex");
			currentPageIndex.appendChild(doc.createTextNode("0"));
			request.appendChild(currentPageIndex);
			
			Element fields = doc.createElement(prefix+"Fields");
			request.appendChild(fields);
			
			
			
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
//			StreamResult result = new StreamResult(new File("/Users/AR/Desktop/file.xml"));
			StreamResult result = new StreamResult(new StringWriter());
			transformer.transform(source, result);
			String requestString = result.getWriter().toString();
			System.out.println(result.getWriter().toString());
			System.out.println("Response:"+executePost("https://api.mindbodyonline.com/0_5/SiteService.asmx",requestString));
//			System.out.println("Response:"+executePost("https://clients.mindbodyonline.com/api/0_5/SiteService.asmx/GetActivationCode", requestString));
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	public static String executePost(String targetURL, String request) {
		HttpURLConnection connection = null;
		try {
			// Create connection
			URL url = new URL(targetURL);
		     connection = (HttpURLConnection)url.openConnection();
		     connection.setRequestMethod("POST");
//			connection.setRequestProperty("Content-Type",
//					"application/x-www-form-urlencoded");

		     connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
			connection.setRequestProperty("Content-Length",
					Integer.toString(request.getBytes().length));
			connection.setRequestProperty("SOAPAction", "http://clients.mindbodyonline.com/api/0_5/GetActivationCode");

			System.out.println("Content length:"+Integer.toString(request.getBytes().length));
			
			connection.setRequestProperty("Host", "api.mindbodyonline.com");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.3.1 (java 1.5)");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setDoInput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeUTF(request);
			wr.close();
			
			connection.connect();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder(); // or StringBuffer if
															// not Java 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}


