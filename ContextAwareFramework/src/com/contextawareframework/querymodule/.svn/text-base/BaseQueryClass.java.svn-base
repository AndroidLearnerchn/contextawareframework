/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * 
 * @File        BaseUploadClass
 * @Created:    30.04.2014
 * @author:     Prasenjit
 * Last Change: 05.05.2014 by Prasenjit
 */

package com.contextawareframework.querymodule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

// New Packages
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

public class BaseQueryClass{

	private static boolean serverAvailable = false;
	private static String serverAvailableString = null;
	private static String developerEmail = null;
	private static String appPkgName = null;
	private static String ApiKey = null;
	private static String userEmailId = null;
	private static String deviceId = null;
	private static String appId = null;
	private boolean serverRequestStatus = false;
	private String serverStatus = "false";
	
	private Context mContext;
	
	//URL Strings for specific request
	private final String CHECKAPIKEY = "apiCheck/"; 
	
	// Constructor
	public  BaseQueryClass(Context context,String devEmail,String apiKey, String appid)
	{
		// Developer information
		mContext = context;
		developerEmail = devEmail; //DeveloperInfo.setDeveloperEmailId(devEmail);// Check this part
		appPkgName = DeveloperInfo.setAppPackageName(mContext);
		ApiKey = apiKey;//DeveloperInfo.setAPIKey(apiKey);
		appId = appid;
		// User Information 
		userEmailId = UserIdentification.getUserEmailId(mContext);// Here also issue..
		deviceId = UserIdentification.getmDeviceId(mContext);
		 Log.d("debug",userEmailId + " " + deviceId+ " "+ appPkgName);
		 if(serverStatus.equals("true"))
		 {
			Log.d("Debug","True, no need to query server");
		 }
		 else
		 {
			 try{
					serverAvailableString = checkApi();//checkServerAvailability();
					}
					catch(Exception e)
					{
						Log.d("Debug","Inside Constructor");
						e.printStackTrace();
					} 
			 
		 }
	}
	
	private String checkApi()
	{
		/*String devEmail = "test123@gmail.com";
        String apiKey = "a975d70e-bebc-4270-8160-d71fa5241bd2"; //a975d70e-bebc-4270-8160-d71fa5241bd2 correct api key
        String pkgName = "com.test";
        String appId = "com.testtestApp";*/
		String response = null;
	    HttpClient client = new DefaultHttpClient();
	    HttpPost post = new HttpPost("http://10.184.0.132:8005/ContextAwareFrameworkWebService/apiCheckTest1");
	    Log.d("Debug","test1");
	    // set values you'd like to send
	    List pairs = new ArrayList();
	    pairs.add(new BasicNameValuePair("devEmail", developerEmail));
	    pairs.add(new BasicNameValuePair("apiKey", ApiKey));
	    pairs.add(new BasicNameValuePair("pkgName", appPkgName));
	    pairs.add(new BasicNameValuePair("appId", appId));
	    pairs.add(new BasicNameValuePair("userEmail", userEmailId));
	    pairs.add(new BasicNameValuePair("userdeviceId", deviceId));
	    pairs.add(new BasicNameValuePair("random", "randomConstant"));
	    try {
	        post.setEntity(new UrlEncodedFormEntity(pairs));
	        // set ResponseHandler to handle String responses
	        ResponseHandler<String> responseHandler = new BasicResponseHandler();
	        response = client.execute(post, responseHandler);
	        serverRequestStatus = true;
	        serverStatus = response;
	        Log.v("HttpPost", "Response: " + serverStatus);
	    } 
	    catch (Exception e) 
	    {
	    	Log.e("Debug","Error in post method");
	    	e.printStackTrace();
	    }
	    
	    return response;
	}
	
	//Method to set the server status code if user already registered
	private String setServerStatusCode()
	{
		
		String response = null;
	    HttpClient client = new DefaultHttpClient();
	    HttpPost post = new HttpPost("http://10.184.0.132:8005/ContextAwareFrameworkWebService/apiCheckTest1");
	    Log.d("Debug","test1");
	    // set values you'd like to send
	    List pairs = new ArrayList();
	    //pairs.add(new BasicNameValuePair("devEmail", developerEmail));
	    //pairs.add(new BasicNameValuePair("apiKey", ApiKey));
	    pairs.add(new BasicNameValuePair("pkgName", appPkgName));
	    pairs.add(new BasicNameValuePair("appId", appId));
	    pairs.add(new BasicNameValuePair("userEmail", userEmailId));
	    pairs.add(new BasicNameValuePair("", deviceId));
	    pairs.add(new BasicNameValuePair("random", "randomConstant"));
	    try {
	        post.setEntity(new UrlEncodedFormEntity(pairs));
	        // set ResponseHandler to handle String responses
	        ResponseHandler<String> responseHandler = new BasicResponseHandler();
	        response = client.execute(post, responseHandler);
	        serverRequestStatus = true;
	        serverStatus = response;
	        Log.v("HttpPost", "Response: " + serverStatus);
	    } 
	    catch (Exception e) 
	    {
	    	Log.e("Debug","Error in post method");
	    	e.printStackTrace();
	    }
	    
	    return response;
	}
	
	public void requestServerURL()
	{
		/*if(serverAvailable)
		{
			// Write ur logic 
		}
		else
		{
		
		}
		*/
	}
	
	public void responseServerUrl()
	{
		/*if(serverAvailable)
		{
			// Write ur logic 
		}
		else
		{
		
		}
		*/
	}
	/*
	 * method to query accelerometer data of external server
	 */
	public void queryAccelerometerData()
	{
		try
		{
			if(serverRequestStatus==true)
			{
				
			}
			else
			{
				checkApi();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*private boolean checkServerAvailability()
	{
		//check the apikey, pkgname and developer email for registration to our external
		// server..
		// make a private static variable true. else give error message
		try{
		Log.d("Debug","Inside CheckServerAvailablity 1");
		String ULR = "http://10.184.0.119:8081/RestfulLogin/LoginService/";
		Log.d("Debug","Inside CheckServerAvailablity 2");
		String RequestURL = ULR+developerEmail+"/"+appPkgName+"/"+ApiKey;
		Log.d("ReqUrl"," " + RequestURL);
		Log.d("Debug","Inside CheckServerAvailablity 3");
		//new HttpAsyncTask().execute(RequestURL);
		new HttpAsyncTask().execute("http://10.184.0.119:8081/RestfulLogin/LoginService/test/prasen/test123");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	*/
	/*public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {
 
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
 
            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        return result;
    }*/
	/* private static String convertInputStreamToString(InputStream inputStream) throws IOException{
	        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
	        String line = "";
	        String result = "";
	        while((line = bufferedReader.readLine()) != null)
	            result += line;
	 
	        inputStream.close();
	        return result;
	 
	    }*/
	/*private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
           Log.d("Return value","Return from server: "+result );
       }
    }*/
}
