/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 

 * @File        UserInfo
 * @Created:    06.06.2014
 * @author:     Prasenjit
 * Last Change: 09.06.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.os;

public class UserInfo {

	private String userEmailId = null;
	private String deviceId = null;
	private String appId = null;
	private String userId = null;
	private String developerEmail = null;
	private String userAuthStatus = "false";
	
	
	public String getUserAuthStatus() {
		return userAuthStatus;
	}
	public void setUserAuthStatus(String userAuthStatus) {
		this.userAuthStatus = userAuthStatus;
	}
	public String getDeveloperEmail() {
		return developerEmail;
	}
	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private boolean authenticatedUser = false;
	
	
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public boolean isAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(boolean authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	
}
