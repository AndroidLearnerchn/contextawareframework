/*
 * Copyright (c) 2013 by CDAC Chennai 
 * 
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
 * @File        UserInfo
 * @Created:    06.06.2014
 * @author:     Prasenjit
 * Last Change: 10.12.2014 by Prasenjit
 */

package com.contextawareframework.os;

/**
 * Pojo class for getting the phone user which can be stored it in the database for 
 * user identification. 
 */
public class UserInfo {

	private String userEmailId = null;
	private String deviceId = null;
	private String appId = null;
	private String userId = null;
	private String developerEmail = null;
	private String userAuthStatus = "false";
	private boolean authenticatedUser = false;

	/**
	 * Default Constructor
	 * 
	 */
	public UserInfo()
	{
		
	}
	
	/**
	 * Method to get the status code which will get updated based on authenticatedUser variable.
	 * @return String : It will return the Auth Status which will be used to store in the 
	 *                  server side database.
	 */
	public String getUserAuthStatus() {
		return userAuthStatus;
	}
	
	/**
	 * Method to set the User Auth Status key
	 * 
	 */
	public void setUserAuthStatus(String userAuthStatus) {
		this.userAuthStatus = userAuthStatus;
	}
	
	/**
	 * Method to get the Developer Email Id
	 * @return String : It will return the Developer Email Id 
	 */
	public String getDeveloperEmail() {
		return developerEmail;
	}
	
	/**
	 * Method to set the developer Email
	 * 
	 */
	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}
	
	/**
	 * 
	 * @return String : Get the User Id
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Method to set the UserId. 
	 * 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Method to get the User Email id. 
	 * @return It returns the User Email Id.
	 */
	
	public String getUserEmailId() {
		return userEmailId;
	}

	/**
	 * Method to set the user Email Id. This field will also be automatically fetched if the 
	 * user has registered the mobile with any email.  
	 * 
	 */
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	/**
	 * Method to get the device id of the user.
	 * @return String : Returns the Device Id of the user.
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * Method to get the Device Id. This will be automatically fetched, if user have 
	 * telephony service then imei number will be selected else device id will be selected 
	 * for Tablets as they may not have telephony service.
	 * 
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * Method to get the Application Id.
	 * @return String : It returns the application Id
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * Method to set the Application Id. This is used to detect multiple application
	 * developed by the same developer as well as to handle the same name application
	 * with different Application Developer.
	 * 
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * Method to get the authenticatedUser variable key value.
	 * @return boolean Retuns the current stage of authentication true if authenticated
	 * else false.
	 */
	public boolean isAuthenticatedUser() {
		return authenticatedUser;
	}

	/**
	 * Method to set the authenticatedUser variable which will be updated on 
	 * successfull authentication from the server.
	 * 
	 */
	public void setAuthenticatedUser(boolean authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	
}
