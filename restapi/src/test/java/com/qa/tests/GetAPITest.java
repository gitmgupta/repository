package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient resetClient;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		apiUrl = prop.getProperty("URL");
		serviceUrl = prop.getProperty("serviceURL");
		url = apiUrl + serviceUrl;

	}

	@Test
	public void getAPITest() throws ClientProtocolException, IOException, JSONException {

		resetClient = new RestClient();
		resetClient.get(url);
	}
}
