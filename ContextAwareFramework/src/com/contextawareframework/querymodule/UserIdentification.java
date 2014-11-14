/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 

 * @File        UserIdentification
 * @Created:    30.04.2014
 * @author:     Prasenjit
 * Last Change: 05.05.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.querymodule;


import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.Patterns;

public class UserIdentification {
	// Private variables
	private static String userEmailId = null;
	private static String mDeviceId = null;
	//private static Context mContext;
	
	// To get the context from Application layer to library
	/*public static void getContextFromMain(Context context)
	{
		mContext = context;
	}*/
	// Setters and Getters
	public static String getUserEmailId(Context mContext) {
		return setUserEmailId(mContext);
	}
	// User has to mention permission as required to get access to this. Applicable above API : 9
	private static String setUserEmailId(Context mContext) {
		Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
    	Account[] accounts = AccountManager.get(mContext).getAccounts();
    	for (Account account : accounts) {
    	    if (emailPattern.matcher(account.name).matches()) {
    	    	userEmailId = account.name;
    	        Log.d("Email",userEmailId);
    	    }
    	}
    	
		return  userEmailId;
	}
	
	public static String getmDeviceId(Context mContext) {
		return setmDeviceId(mContext);
	}
	
	private static String setmDeviceId(Context mContext)
	{
		  mDeviceId = ((TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
		    if (mDeviceId != null) {
		        return mDeviceId;
		    } else {
		        return android.os.Build.SERIAL;
		    }
	}
	
	
}
