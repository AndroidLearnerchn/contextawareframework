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
 * @File        SensorController1
 * @Created:    19.11.2013
 * @author:     Prasenjit
 * Last Change: 20.11.2013 by Prasenjit
 */
 
package com.contextawareframework.controller;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.contextawareframework.backgroundservices.AccelerometerDataListener;
import com.contextawareframework.backgroundservices.GPSTracker;
import com.contextawareframework.backgroundservices.LightDataListener;
import com.contextawareframework.backgroundservices.ProximityDataListener;
import com.contextawareframework.exceptions.AccelerometerSensorException;
import com.contextawareframework.exceptions.GPSSensorException;
import com.contextawareframework.exceptions.LightSensorException;
import com.contextawareframework.exceptions.ProximitySensorException;
import com.contextawareframework.globalvariable.CAFConfig;


/**
 * This class is the controller part. User can register / unregister the sensor 
 * listener using the specific methods. To use this class, create an object of
 * the class, pass the localcontext, assign the specific sensor global variable 
 * true, call the method written here
 */
public class SensorController1 {

	public Context contextFromActivity;
	private SensorManager sensorManager;
	private GPSTracker gps;
	private AccelerometerDataListener accel;
	private ProximityDataListener proximity;
	private LightDataListener light;
	private SensorEventListener accelListener, proximityListener, lightListener;
	private static final String TAG = "SENSORCONTROLLER1";
	
	// User can use different delays to register the sensor
	public static final int FASTEST = SensorManager.SENSOR_DELAY_FASTEST;
	public static final int GAME = SensorManager.SENSOR_DELAY_GAME;
	public static final int NORMAL = SensorManager.SENSOR_DELAY_NORMAL;
	public final int UI = SensorManager.SENSOR_DELAY_UI;
	
	public SensorController1(Context context)
	{
		contextFromActivity = context;
		
	}
	/**
	 * To register the Accelerometer Service 
	 */
	public final void registerAccelerometerService(SensorEventListener listenerfromMainApp, int sampleRate) throws AccelerometerSensorException // 1st Sensor
	{
		accelListener = listenerfromMainApp;
		
		// Create an object of specific service class to  
		accel = AccelerometerDataListener.getInstance(contextFromActivity);
		
		if(CAFConfig.isSensorAccelerometer())
		{
			try
			{
				Log.d(TAG,"inside registerAccelerometerListner");
				accel.enableAccelerometerListener(accelListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Else part
			Log.d(TAG,"SENSOR_ACCELEROMETER is false");
			accel.disableAccelerometerListener(accelListener);

		}
	}
	/**
	 * To register the Proximity Service
	 */
	public final void registerProximityService(SensorEventListener listenerfromMainApp, int sampleRate) throws ProximitySensorException
	{
		proximityListener = listenerfromMainApp;
		
		// Create an object of specific service class to  
		proximity = ProximityDataListener.getInstance(contextFromActivity);
		
		if(CAFConfig.isSensorProximity())
		{						
			try{
				Log.d(TAG,"inside registerProximityListener");
				proximity.enableProximitySensor(proximityListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Else part
			Log.d(TAG,"SENSOR_PROXIMITY is false");
			proximity.disableProximitySensor(proximityListener);
		}
	}

	/**
	 * To register the Light Service
	 */
	public final void registerLightService(SensorEventListener listenerfromMainApp, int sampleRate) throws LightSensorException
	{	
		lightListener = listenerfromMainApp;
		// Create an object of specific service class to  
		light = LightDataListener.getInstance(contextFromActivity);
		if(CAFConfig.isSensorLight())
		{
			
			try{
				Log.d(TAG,"inside registerProximityListener");
				if(lightListener!=null)
					light.enableLightSensor(lightListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Else part
			Log.d(TAG,"SENSOR_LIGHT is false");
			light.disableLightSensor(lightListener);

		}
	}

	/**
	 * To un-register the Accelerometer 
	 */
	public final void unregisterAccelerometerService(SensorEventListener listenerfromMainApp) throws AccelerometerSensorException
	{
		//sensorManager.unregisterListener(lightSensorEventListener); // Change the Listener
		if(listenerfromMainApp!=null)
		{
			accel.disableAccelerometerListener(listenerfromMainApp);
			CAFConfig.setSensorAccelerometer(false);
			Log.d(TAG,"Unregister Accelerometer Sensor");
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}
		
	}
	/**
	 * To un-register the Proximity Service
	 */
	public final void unregisterProximityService(SensorEventListener listenerfromMainApp) throws ProximitySensorException
	{
		if(listenerfromMainApp!=null)
		{
			proximity.disableProximitySensor(listenerfromMainApp);
			CAFConfig.setSensorProximity(false);
			Log.d(TAG,"Unregister Proximity Sensor");
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}
	}
	/**
	 * To un-register the Light sensor Service
	 */
	public final void unregisterLightService(SensorEventListener listenerfromMainApp) throws LightSensorException
	{
		if(listenerfromMainApp!=null)
		{
			light.disableLightSensor(listenerfromMainApp);
			CAFConfig.setSensorLight(false);
			Log.d(TAG,"Unregister Light Sensor");
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}
	}
	/**
	 * To un-register the Battery Service
	 */
	public final void unregisterBatteryService() 
	{
		
	}
	/**
	 * To un-register the Location Service
	 */
	public final void unregisterLocationService() throws GPSSensorException
	{
		//gps.stopUsingGPS(); // Change the Listener 
		
		CAFConfig.setSensorLocation(false);
		
		Log.d(TAG,"Unregister Location Service");
	}
}
