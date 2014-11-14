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
 * @File		CAFService        
 * @Created:    20.07.2014
 * @author:     Prasenjit
 * Last Change: 24.07.2014 by Prasenjit
 */
package com.contextawareframework.backgroundservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CAFService extends Service{

	/** indicates how to behave if the service is killed */
	int mStartMode;

	/** interface for clients that bind */
	IBinder mBinder;     

	/** indicates whether onRebind should be used */
	boolean mAllowRebind;

	/** Tag for debugging */
	private final String TAG = "CAFService";
	private static boolean enableDebugging = false;

	/**
	 * Method to start debugging, all log tags in this class will be printed
	 */
	protected void setEnableDebugging(boolean value)
	{
		enableDebugging = value;
	}
	/**
	 * Method to stop debugging.
	 */
	protected boolean getEnableDebugging()
	{
		return enableDebugging;		  
	}
	/** Called when the service is being created. */
	@Override
	public void onCreate() {
		if(enableDebugging)
			Log.d(TAG,"onCreate");
	}

	/** The service is starting, due to a call to startService() */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(enableDebugging)
			Log.d(TAG,"onStartCommand");
		return mStartMode;
	}

	/** A client is binding to the service with bindService() */
	@Override
	public IBinder onBind(Intent intent) {
		if(enableDebugging)
			Log.d(TAG,"onBind");
		return mBinder;
	}

	/** Called when all clients have unbound with unbindService() */
	@Override
	public boolean onUnbind(Intent intent) {
		if(enableDebugging)
			Log.d(TAG,"onUnbind");
		return mAllowRebind;
	}

	/** Called when a client is binding to the service with bindService()*/
	@Override
	public void onRebind(Intent intent) {
		if(enableDebugging)
			Log.d(TAG,"onRebind");
	}

	/** Called when The service is no longer used and is being destroyed */
	@Override
	public void onDestroy() {
		if(enableDebugging)
			Log.d(TAG,"onDestroy");
	}

}
