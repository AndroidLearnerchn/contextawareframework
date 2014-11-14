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
 * @File        AccelerometerDataListener
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
import android.provider.Settings.Global;
import android.util.Log;
import android.widget.Toast;


/**
 * Description : To register / un-register Accelerometer Sensor. To make it as service mention
 * 				 the package name inside service tag of your Android manifest file
 */
public class AccelerometerDataListener extends CAFService {

	/** Android SensorManager object to work with sensors. This variable is not 
	 * exposed to user.
	 * */
	private SensorManager mSensorManager;

	/* Local variable to select the type of sensor.*/
	private Sensor mAccelerometer;

	/* Local variable to store the context of the calling activity.*/
	private Context mContext = null ;

	/* Local variable to store the SensorEventListener from the calling / implementing Activity. */
	private SensorEventListener listener;

	/* Tag for debugging the class */
	private final String TAG = "AccelerometerDataListener";

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 

	/* Class variable */
	private static AccelerometerDataListener accelDataListenerInstance;

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
	private AccelerometerDataListener(Context context)
	{
		mContext = context;
	}

	/**
	 * Description : Method to create an instance of AccelerometerDataListener Class.
	 * @param context Calling Activity context
	 * @return AccelerometerDataListener Class instance
	 */
	public static synchronized AccelerometerDataListener getInstance(Context context)
	{
		if (accelDataListenerInstance == null)
			accelDataListenerInstance = new AccelerometerDataListener(context);

		return accelDataListenerInstance;
	}

	/**
	 * Method to enable Accelerometer Sensor in Android
	 * @param listenerFromActiity : User has to implement the SensorEventListener and pass it 
	 * 							    to the calling method
	 */
	public void enableAccelerometerListener(SensorEventListener listenerFromActivity,int sampleRate)
	{
		if(listenerFromActivity!=null)
		{	
			listener = listenerFromActivity;
		}
		else			
		{	
			if(enableDebugging)
			{
				Log.d(TAG,"enableAccelerometer Method");
				Log.d(TAG,"listenerFromActivity is null");
			}

		}
		mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
		if(mSensorManager == null)
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Accelerometer Sensor Found");
				Toast.makeText(this,"No Accelerometer Sensor found! quit-",Toast.LENGTH_SHORT).show();
			}
		}
		else
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Accelerometer Sensor Found, else part");
				Toast.makeText(mContext,"Accelerometer Sensor found",Toast.LENGTH_SHORT).show();
			}
			try
			{
				mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
				mSensorManager.registerListener(listener, mAccelerometer , sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to enable disable Accelerometer Sensor in Android
	 */
	public void disableAccelerometerListener(SensorEventListener listenerFromActivity)
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
