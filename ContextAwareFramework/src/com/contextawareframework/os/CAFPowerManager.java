package com.contextawareframework.os;

/*
 * Copyright (c) 2013-14 by CDAC Chennai 
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
 * @File        CAFPowerManager
 * @Created:    23.07.2014
 * @author:     Divya
 * Last Change: 15.10.2014 by Prasenjit
 */



import com.contextawareframework.globalvariable.CAFConfig;

import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;

/**
 * This class implements PARTIAL_WAKE_LOCK 
 */
public class CAFPowerManager {
	
	/* Local variable for wakelock */
	private PowerManager.WakeLock wakeLock;
	
	/* Local variable to store the context of the calling activity.*/
	private Context mContext;
	
	/* powerManager to accquire the Power Manager service */
	private PowerManager powerManager;
	
	/* To enable / disable Log messages. */
	private String TAG = "CAFPowerManager"; 
	
	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 
	
	/**
	 * Method to assign the context of the component
	 * @param context
	 */
	public CAFPowerManager(Context context)
	{
		mContext=context;
	}

	/**
	 * Method to acquire a partial wake lock
	 */
	public void acquirePartialWakeLock(){ 
		try
		{
			//powerManager to accquire the Power Manager service
			 powerManager=(PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
			if( powerManager != null)
			{
				//create a new wakelock
				wakeLock=powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK," Partial Wakelock ");
				
				// To acquire the wake lock
				wakeLock.acquire();
				if(enableDebugging)
					Log.d(TAG,"Partial Wake Lock Accquired");
				
				//Toast acquire=Toast.makeText(mContext, " Accquired partial Wake lock ", Toast.LENGTH_SHORT);
				//acquire.show();
				
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Method to acquire a lock which causes Screen up
	 */
	public void acquireCausesWakeupLock(){ 
		try
		{
			//powerManager to accquire the Power Manager service
			 powerManager=(PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
			
			//create a new wakelock
			 wakeLock=powerManager.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP," Accquire of this lock causes screen on ");
			
			// To acquire the wake lock
			 wakeLock.acquire();
			
			 // To get a message if debugging is turned on
			 if(enableDebugging)
				 Log.d(TAG,"Partial Wake Lock Accquired");
			 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Method to acquire a wakelock with a timeout
	 * @param time
	 */
	public void acquireWakelocktime(long time){
		try
		{
			//powerManager to acquire the Power Manager service
			powerManager=(PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
			
			//create a new Wakelock
			wakeLock=powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"Will accquire the lock for specified time");
			
			//acquire Wakelock
			wakeLock.acquire(time);
			
			// To get a message if debugging is turned on
			if(enableDebugging)
				 Log.d(TAG,"Partial Wake Lock Accquired");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method to release Wakelock acquired using acquireWakeLock()
	 */
	public void releaseWakeLock(){
		try{
			//releases the wakelock
			wakeLock.release();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return the enableDebugging
	 */
	public boolean isEnableDebugging() {
		return enableDebugging;
	}

	/**
	 * @param enableDebugging the enableDebugging to set
	 */
	public void setEnableDebugging(boolean enableDebugging) {
		CAFPowerManager.enableDebugging = enableDebugging;
	}


}