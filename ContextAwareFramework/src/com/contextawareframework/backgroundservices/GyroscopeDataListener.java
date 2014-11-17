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
 * @File        GyroscopeDataListener
 * @Created:    5.09.2014
 * @author:     Prasenjit
 * Last Change: 8.09.2014 by Prasenjit
 */

package com.contextawareframework.backgroundservices;

import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings.Global;
import android.util.Log;
import android.widget.Toast;


/**
 * Description : To register / un-register Gyrometer Sensor. To make it as service mention
 * 				 the package name inside service tag of your Android manifest file
 */
public class GyroscopeDataListener extends CAFService {

	/* Description : Android SensorManager object to work with sensors.*/
	private SensorManager mSensorManager;

	/* Local variable to select the type of sensor.*/
	private Sensor mGyroscope;

	/* Local variable to store the context of the calling activity.*/
	private Context mContext = null ;

	/* Local variable to store the SensorEventListener from the calling / implementing Activity. */
	private SensorEventListener listener;

	/* Tag for debugging the class */
	private final String TAG = "GyroscopeDataListener";

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 

	/* Class variable */
	private static GyroscopeDataListener gyroDataListenerInstance;

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
	private GyroscopeDataListener(Context context)
	{
		mContext = context;
	}

	/**
	 * Description : Method to create an instance of GyroscopeDataListener Class.
	 * @param context Calling Activity context
	 * @return GyroscopeDataListener Class instance
	 */
	public static synchronized GyroscopeDataListener getInstance(Context context)
	{
		if (gyroDataListenerInstance == null)
			gyroDataListenerInstance = new GyroscopeDataListener(context);

		return gyroDataListenerInstance;
	}

	/**
	 * Description : Method to enable Gyroscope Sensor in Android
	 * @param listenerFromActiity : User has to implement the SensorEventListener and pass it 
	 * 							    to the calling method
	 */
	public void enableGyroscopeListener(SensorEventListener listenerFromActivity,int sampleRate)
	{
		if(listenerFromActivity!=null)
		{	
			listener = listenerFromActivity;
		}
		else			
		{	
			if(CAFConfig.isEnableDebugging())
			{
				Log.d(TAG,"enableGyroscope Method");
				Log.d(TAG,"listenerFromActivity is null");
			}

		}
		mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
		if(mSensorManager == null)
		{
			if(enableDebugging)
			{
				Log.d(TAG,"No Sensor Service available");
				//Toast.makeText(this,"No Sensor Service found! quit-",Toast.LENGTH_SHORT).show();
			}
		}
		else
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Sensor Service Found, else part");
				//Toast.makeText(mContext,"Sensor Service found",Toast.LENGTH_SHORT).show();
			}
			try
			{
				mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
				if(mGyroscope!=null)
					{
						mSensorManager.registerListener(listener, mGyroscope , sampleRate);
						if(enableDebugging)
						{
							Log.d(TAG,"Gyroscope Sensor Found, registering service");
							//Toast.makeText(mContext,"Sensor Service found",Toast.LENGTH_SHORT).show();
						}
					}
				else
				{
					Log.d(TAG,"Gyroscope Sensor not available");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to disable Gyroscope Sensor in Android
	 */
	public void disableGyroscopeListener(SensorEventListener listenerFromActivity)
	{	
		try
		{
			if(listenerFromActivity!=null)
			{	mSensorManager.unregisterListener(listenerFromActivity);
				//if(enableDebugging)
					//Log.d(TAG,"unregistering Gyroscope Sensor");
			}
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
