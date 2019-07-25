package com.qa.client;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {

	// . GET METHOD
	public void get(String url) throws ClientProtocolException, IOException, JSONException {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// http get request
		HttpGet httpGet = new HttpGet(url);

		// Send button or HIT the get url
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		// a. Status Code
		int statusCode = httpResponse.getStatusLine().getStatusCode();

		System.out.println("Status Code -------> " + statusCode);

		// b. Json String
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		System.out.println("Response String" + responseString);

		// convert for string to json object
		JSONObject responseJson = new JSONObject(responseString);

		System.out.println("Response json for API" + responseJson);

		// All Header
		Header[] headerArray = httpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array -->  " + allHeaders);
	}

}
