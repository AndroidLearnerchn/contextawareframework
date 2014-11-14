/*
 * Copyright (c) 2014 by CDAC Chennai 
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
 * Last Change: 12.08.2014 by Prasenjit
 */

package com.contextawareframework.controller;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationListener;
import android.util.Log;

import com.contextawareframework.backgroundservices.AccelerometerDataListener;
import com.contextawareframework.backgroundservices.LocationDataListener;
import com.contextawareframework.backgroundservices.GyroscopeDataListener;
import com.contextawareframework.backgroundservices.LightDataListener;
import com.contextawareframework.backgroundservices.ProximityDataListener;
import com.contextawareframework.exceptions.AccelerometerSensorException;
import com.contextawareframework.exceptions.CAFException;
import com.contextawareframework.exceptions.GPSSensorException;
import com.contextawareframework.exceptions.LightSensorException;
import com.contextawareframework.exceptions.ProximitySensorException;
import com.contextawareframework.globalvariable.CAFConfig;


/**
 * Register / unregister the sensor listener using the specific methods. To use 
 * this class, create an object of the class, pass the localcontext, assign the 
 * specific sensor global variable true, call the method written here
 * 
 * Sample Code : 
 * ---------------------------------------------------------------------------------
 * SensorController controller = SensorController.getInstance(getApplicationContext);
 * 
 * CAFConfig.setSensor[Name of Sensor](true);
 * 																			Delay
 * controller.register[SensorName]Service(sensorListener,SensorController.NORMAL);
 * ----------------------------------------------------------------------------------
 */
public class SensorController {

	private Context contextFromActivity;
	
	/* GPSTracker Class reference variable */
	private LocationDataListener gps;
	
	/* AccelerometerDataListener Class reference variable */
	private AccelerometerDataListener accel;
	
	/* GyroscopeDataListener Class reference variable */
	private GyroscopeDataListener gyroscope;
	
	/* ProximityDataListener Class reference variable */
	private ProximityDataListener proximity;
	
	/* ProximityDataListener Class reference variable */
	private LocationDataListener locationDataListener;
	
	/* LightDataListerner Class reference variable*/
	private LightDataListener light;
	
	/* SensorEventListener Class reference variable*/
	private SensorEventListener accelListener, proximityListener, lightListener, gyroscopeListener;
	private LocationListener locationListener;
	
	/* Tag for debugging information*/
	private static final String TAG = "SENSORCONTROLLER";


	/**
	 * Set sensor delay to SENSOR_DELAY_FASTEST
	 */
	public static final int FASTEST = SensorManager.SENSOR_DELAY_FASTEST;

	/**
	 * Set sensor delay to SENSOR_DELAY_GAME
	 */
	public static final int GAME = SensorManager.SENSOR_DELAY_GAME;

	/**
	 * Set sensor delay to SENSOR_DELAY_NORMAL
	 */
	public static final int NORMAL = SensorManager.SENSOR_DELAY_NORMAL;

	/**
	 * Set sensor delay to SENSOR_DELAY_UI
	 */
	public static final int UI = SensorManager.SENSOR_DELAY_UI;

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 

	/* Class reference variable */
	private static SensorController controller;

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
	private SensorController(Context context)
	{
		contextFromActivity = context;
	}

	/**
	 * Description : Method to create an instance of AccelerometerDataListener Class.
	 * @param context Calling Activity context
	 * @return AccelerometerDataListener Class instance
	 */
	public static synchronized SensorController getInstance(Context context)
	{
		if (controller == null)
			controller = new SensorController(context);

		return controller;
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
				if(enableDebugging)
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
			if(enableDebugging)
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
			try
			{
				if(enableDebugging)
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
			if(enableDebugging)
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

			try
			{
				if(enableDebugging)
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
			if(enableDebugging)
				Log.d(TAG,"SENSOR_LIGHT is false");
			light.disableLightSensor(lightListener);

		}
	}
	/**
	 * To register the Location Service
	 */
	public final void registerLocationService(String provider, long minTime, float minDistance, LocationListener locationListener) throws GPSSensorException
	{
		this.locationListener = locationListener;

		// Create an object of specific service class to  
		locationDataListener = LocationDataListener.getInstance(contextFromActivity);

		if(CAFConfig.isSensorLocation())
		{						
			try
			{
				if(enableDebugging)
					Log.d(TAG,"inside registerLocationListener");
				// User need to pass the Provider details, minTime and minDistance for location update and the locationListener to be implemented by the user 
				locationDataListener.enableLocationListener(provider, minTime, minDistance, locationListener);   
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			if(enableDebugging)
				Log.d(TAG,"SENSOR_LOCATION is false");
			locationDataListener.disableLocationListener(locationListener);
		}
	}

	/**
	 * Method to register Gyroscope sensor listening
	 * @param listenerfromMainApp
	 * @param sampleRate
	 * @throws Exception
	 */
	public final void registerGyroscopeService(SensorEventListener listenerfromMainApp, int sampleRate)  
	{
		gyroscopeListener = listenerfromMainApp;

		// Create an object of specific service class to  
		gyroscope = GyroscopeDataListener.getInstance(contextFromActivity);

		if(CAFConfig.isSensorGyroscope())
		{
			try
			{	
				if(enableDebugging)
					Log.d(TAG,"inside registerGyroscopeListner");
				gyroscope.enableGyroscopeListener(gyroscopeListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{			
			if(enableDebugging)
				Log.d(TAG,"SENSOR_GYROSCOPE is false");
			gyroscope.disableGyroscopeListener(gyroscopeListener);

		}
	}
	
	/**
	 * To un-register the Gyroscope 
	 */
	public final void unregisterGyroscopeService(SensorEventListener listenerfromMainApp) throws AccelerometerSensorException
	{		
		if(listenerfromMainApp!=null)
		{	
			if(gyroscope!=null)
			{
				gyroscope.disableGyroscopeListener(listenerfromMainApp);
				CAFConfig.setSensorGyroscope(false);
				if(enableDebugging)
					Log.d(TAG,"Unregister Gyroscope Sensor");
			}
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}

	}
	
	/**
	 * To un-register the Accelerometer 
	 */
	public final void unregisterAccelerometerService(SensorEventListener listenerfromMainApp) throws AccelerometerSensorException
	{		
		if(listenerfromMainApp!=null)
		{	
			if(accel!=null)
			{
				accel.disableAccelerometerListener(listenerfromMainApp);
				CAFConfig.setSensorAccelerometer(false);
				if(enableDebugging)
					Log.d(TAG,"Unregister Accelerometer Sensor");
			}
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
			if(proximity!=null)
			{
					proximity.disableProximitySensor(listenerfromMainApp);
					CAFConfig.setSensorProximity(false);
					if(enableDebugging)
						Log.d(TAG,"Unregister Proximity Sensor");
			}
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
			if(light!=null)
			{
				light.disableLightSensor(listenerfromMainApp);
				CAFConfig.setSensorLight(false);
				if(enableDebugging)
					Log.d(TAG,"Unregister Light Sensor");
			}
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
	public final void unregisterLocationService(LocationListener locationListener) throws GPSSensorException
	{
		if(gps!=null)
		{	
			if(enableDebugging)
				Log.d(TAG,"Unregister Location Service");
			gps.stopUsingGPS(locationListener); // Change the Listener 
			CAFConfig.setSensorLocation(false);
		}
		else
		{
			Log.d(TAG,"gps is null");
		}
		
	}
}
