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
 * @File        MagnetometerDataListener
 * @Created:    16.09.2014
 * @author:     Prasenjit
 * Last Change: 18.09.2014 by Prasenjit
 */

package com.contextawareframework.backgroundservices;

import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;



/**
 * Description : To register / un-register Magnetometer Sensor. To make it as service mention
 * 				 the package name inside service tag of your Android manifest file
 */
public class MagnetometerDataListener extends CAFService {

	/* Description : Android SensorManager object to work with sensors.*/
	private SensorManager mSensorManager;

	/* Local variable to select the type of sensor.*/
	private Sensor mMagnetometer;

	/* Local variable to store the context of the calling activity.*/
	private Context mContext = null ;

	/* Local variable to store the SensorEventListener from the calling / implementing Activity. */
	private SensorEventListener listener;

	/* Tag for debugging the class */
	private final String TAG = "MagnetometerDataListener";

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 

	/* Class variable */
	private static MagnetometerDataListener magnetoDataListenerInstance;

	/**
	 * Description : Method to enable debugging
	 * @param boolean
	 */
	public void setEnableDebugging(boolean value)
	{
		enableDebugging = value;
	}

	/**
	 * Description : Method to get the present value of enableDebugging
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
	private MagnetometerDataListener(Context context)
	{
		mContext = context;
	}

	/**
	 * Description : Method to create an instance of MagnetometerDataListener Class.
	 * @param context Calling Activity context
	 * @return magnetoDataListener Class instance
	 */
	public static synchronized MagnetometerDataListener getInstance(Context context)
	{
		if (magnetoDataListenerInstance == null)
			magnetoDataListenerInstance = new MagnetometerDataListener(context);

		return magnetoDataListenerInstance;
	}

	/**
	 * Description : Method to enable magnetometer Sensor in Android
	 * @param listenerFromActiity : User has to implement the SensorEventListener and pass it 
	 * 							    to the calling method
	 */
	public void enableMagnetometerListener(SensorEventListener listenerFromActivity,int sampleRate)
	{
		if(listenerFromActivity!=null)
		{	
			listener = listenerFromActivity;
		}
		else			
		{	
			if(CAFConfig.isEnableDebugging())
			{
				Log.d(TAG,"enableMagnetometer Method");
				Log.d(TAG,"listenerFromActivity is null");
			}

		}
		mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
		if(mSensorManager == null)
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Sensor Service not Available");				
			}
		}
		else
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Sensor Service Available");
			}
			try
			{
				mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
				if(mMagnetometer!=null)
				{
					mSensorManager.registerListener(listener, mMagnetometer , sampleRate);
				}
				else
				{
					Log.d(TAG,"Magnetometer Sensor not Found");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to enable disable Magnetometer Sensor in Android
	 */
	public void disableMagnetometerListener(SensorEventListener listenerFromActivity)
	{	
		try
		{
			if(listenerFromActivity!=null)
				mSensorManager.unregisterListener(listenerFromActivity);
			else
			{
				if(enableDebugging)
					Log.d(TAG,"listenerFromActivity is null");
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}

}
