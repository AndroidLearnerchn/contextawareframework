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
 * @File        ProximityDataListener
 * @Created:    20.11.2013
 * @author:     Prasenjit
 * Last Change: 22.08.2014 by Prasenjit
 */
package com.contextawareframework.backgroundservices;

import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Description : To register Proximity Sensor. To make it as service, mention the
 * 				 package name inside service tag of your Android manifest file
 * */
public class ProximityDataListener extends CAFService {

	/* Android SensorManager object to work with sensors.*/
	private SensorManager mSensorManager;

	/* Local variable to select the type of sensor.*/
	private Sensor mProximity;

	/* Local variable to store the context of the calling activity.*/
	private final Context mContext;

	/* Local variable to store the SensorEventListener from the calling / implementing Activity. */
	private SensorEventListener listener;

	// Use this string constant to debug this class
	private static final String TAG = "ProximityDataListener";

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging();

	/* Class instance variable */
	private static ProximityDataListener proximityDataListenerInstance;

	/**
	 * Method to enable debugging
	 * @param boolean
	 */
	public void setEnableDebugging(boolean value)
	{
		enableDebugging = value;
	}

	/**
	 * Method to get the present value of enableDebugging
	 * @return boolean
	 */
	public boolean getEnableDebugging()
	{
		return enableDebugging;
	}

	/**
	 * Description : Private constructor. Singleton Pattern to create the class object
	 * @param context Calling Activity context
	 */
	private ProximityDataListener(Context context)
	{
		mContext = context;
	}

	/**
	 * Description : Method to create an instance of ProximityDataListener Class.
	 * @param context Calling Activity context
	 * @return ProximityDataListener Class instance
	 */
	public static synchronized ProximityDataListener getInstance(Context context)
	{
		if (proximityDataListenerInstance == null)
			proximityDataListenerInstance = new ProximityDataListener(context);

		return proximityDataListenerInstance;
	}

	/**
	 * Method to enable Proximity Sensor in Android
	 */
	public void enableProximitySensor(SensorEventListener listenerFromActivity, int sampleRate) 
	{

		if(listenerFromActivity!=null)
		{
			listener = listenerFromActivity;
		}
		else			
		{
			if(CAFConfig.isEnableDebugging())
			{
				Log.d(TAG,"enableProximitySensor Method");
				Log.d(TAG,"listenerFromActivity is null");
			}
		}
		mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
		if (mSensorManager == null) 
		{
			if(enableDebugging)
			{
				Log.d(TAG, "Proximity Sensor not found");
				Toast.makeText(this, "No Proximity Sensor found! quit-",Toast.LENGTH_SHORT).show();
			}
		} 
		else 
		{
			if(enableDebugging)
			{
				Log.d(TAG, "Proximity Sensor Found");
				Toast.makeText(mContext, "Proximity Sensor found",Toast.LENGTH_SHORT).show();
			}

			try 
			{
				mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
				mSensorManager.registerListener(listener, mProximity,sampleRate);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to disable Proximity Sensor in Android
	 */
	public void disableProximitySensor(SensorEventListener listenerFromActivity)
	{
		try
		{			
			if(mSensorManager != null)
			{
				if(listenerFromActivity!=null)
					mSensorManager.unregisterListener(listenerFromActivity);
				else
				{
					if(enableDebugging)
						Log.d(TAG,"listenerFromActivity is null");
				}
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}
}
