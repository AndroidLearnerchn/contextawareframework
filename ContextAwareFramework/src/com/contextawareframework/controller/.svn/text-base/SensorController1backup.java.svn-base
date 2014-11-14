package com.contextawareframework.controller;
///*****************************************************************
// * Copyright (c) 2013 by CDAC Chennai 
// * @File        SensorController
// * @Created:    19.11.2013
// * @author:     Prasenjit
// * Last Change: 20.11.2013 by Prasenjit
// ******************************************************************/
//package com.contextawareframework.controller;
//
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.contextawareframework.globalvariable.GlobalVariable;
////import com.contextawareframework.sensorlistener.ProximityListener;
//import com.contextawareframework.backgroundservices.AccelerometerDataListener;
//import com.contextawareframework.backgroundservices.GPSTracker;
//import com.contextawareframework.backgroundservices.ProximityDataListener;
////import com.contextawareframework.backgroundservices.ProximityDataListener;
//import com.contextawareframework.exceptions.AccelerometerSensorException;
//import com.contextawareframework.exceptions.BatteryException;
//import com.contextawareframework.exceptions.GPSSensorException;
//import com.contextawareframework.exceptions.LightSensorException;
//import com.contextawareframework.exceptions.ProximitySensorException;
//
//
///****************************************************************************
// * This class is the controller part. User can register the sensor listener 
// * and can store data in the database by using this class
// * **************************************************************************/
//public class SensorController1 {
//	
//	public Context SensorControllerclasscontext;
//	private SensorManager sensorManager;
//	private GPSTracker gps;
//	private AccelerometerDataListener accel;
//	private ProximityDataListener proximity;
//	//private ProximityListener proximitylistener;
//	private SensorEventListener accelListener, proximityListener, lightListener;
//	public SensorController1(Context context)
//	{
//		SensorControllerclasscontext = context;
//	}
//	/*
//	 * To register the Accelerometer Service for database insertion
//	 * */
//	public final void registerAccelerometerService() throws AccelerometerSensorException // 1st Sensor
//	{
//		
//		if(GlobalVariable.SENSOR_ACCELEROMETER == true)
//		{
//		// Create an object of specific service class to  
//			accel = new AccelerometerDataListener(SensorControllerclasscontext);
//			try{
//				Log.d("Debug","inside registerAccelerometerListner");
//				accel.enableAccelerometerListener(accelListener, SensorManager.SENSOR_DELAY_NORMAL);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//			//Else part
//			accel.disableAccelerometerListener(accelListener);
//		
//		}
//	}
//	/*
//	 * To register the Proximity Service for database insertion
//	 * */
//	public final void registerProximityService() throws ProximitySensorException
//	{
//		if(GlobalVariable.SENSOR_PROXIMITY == true)
//		{
//		// Create an object of specific service class to  
//			proximity = new ProximityDataListener(SensorControllerclasscontext);
//			try{
//				Log.d("Debug","inside registerProximityListener");
//				proximity.en
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//			//Else part
//			accel.disableAccelerometerListener(accelListener);
//		
//		}
//	}
//	//date 27th feb 2014 Prasenjit
////	public final void registerProximityService() throws ProximitySensorException // 2nd Sensor
////	{
////		if(GlobalVariable.SENSOR_PROXIMITY == true)
////		{
////			//Intent startLightDataCollectionService = new Intent(this,LightDataCollectionService.class);
////			
////		// Create an object of specific service class to store data
////			//These lines should be moved in service class    -------->   @Important
////			// Date 21.11.13
////			/*-------------------------------------------------------------Privious Flow-----------------*/
////			sensorManager = (SensorManager)SensorControllerclasscontext.getSystemService(Context.SENSOR_SERVICE);
////	        Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
////	        if (proximitySensor == null){
////	            Toast.makeText(SensorControllerclasscontext,
////	              "No Proximity Sensor! quit-",
////	              Toast.LENGTH_LONG).show();
////	           }
////	        
////	        else
////	        {
////	        	
////	            float max =  proximitySensor.getMaximumRange();
////	            Toast.makeText(SensorControllerclasscontext,
////	  	              "Proximity Sensor found! value = " + max,
////	  	              Toast.LENGTH_LONG).show();
////	            Log.d("Debug","max value = " + max);
////	            sensorManager.registerListener(proximityListener,
////	            		proximitySensor,
////		                SensorManager.SENSOR_DELAY_NORMAL);//proximitySensorEventListener
////	           }
////	           
////	
////			proximity = new ProximityDataListener(SensorControllerclasscontext);
////			try{
////				Log.d("Debug","inside registerProximityListner");
////				
////				proximity.enableProximitySensor(proximityListener);
////			}
////			catch(Exception e)
////			{
////				e.printStackTrace();
////			}
////		}
////		else
////		{
////			//Else part
////			proximity.disableProximitySensor(proximityListener);
////		}
////	}
//	// Listener to listen the Proximity sensor
//	
//	//Not in use after creating the service Date 21.11.13
//	
////	
////	SensorEventListener proximitySensorEventListener  = new SensorEventListener(){
////	     
////	      @Override
////	      public  void onAccuracyChanged(Sensor sensor, int accuracy) {
////	       // TODO Auto-generated method stub
////	        
////	      }
////	     
////	      @Override
////	      public  void onSensorChanged(SensorEvent event) {
////	       // TODO Auto-generated method stub
////	       if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
////	    	   Log.d("Debug","Inside OnSensorChanged Method ");
////	        float currentReading = event.values[0];
////	        Log.d("Debug","Proximity Sensor Value = " + currentReading);
////	      
////	       }
////	      }
////	          
////	        };
//	
//	/*
//	 * To register the Light Service for database insertion
//	 * */
//	public final void registerLightService() throws LightSensorException // 3rd Sensor
//	{
//		if(GlobalVariable.SENSOR_LIGHT == true)
//		{
//			//Intent startLightDataCollectionService = new Intent(this,LightDataCollectionService.class);
//			
//		// Create an object of specific service class to 
//			// These lines to be moved in Service class, It will not work here as we are not extending 
//			// the Activity class
//			
//			sensorManager = (SensorManager)SensorControllerclasscontext.getSystemService(Context.SENSOR_SERVICE);
//	        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//	        if (lightSensor == null){
//	            Toast.makeText(SensorControllerclasscontext,
//	              "No Light Sensor! quit-",
//	              Toast.LENGTH_LONG).show();
//	           }
//	        
//	        else
//	        {
//	            float max =  lightSensor.getMaximumRange();
//	            Toast.makeText(SensorControllerclasscontext,
//	  	              "Light Sensor found! value = " + max,
//	  	              Toast.LENGTH_LONG).show();
//	            Log.d("Debug","max value = " + max);
//	            sensorManager.registerListener(lightSensorEventListener,
//		                lightSensor,
//		                SensorManager.SENSOR_DELAY_NORMAL);
//	           }
//	    
//		}
//		else
//		{
//			// First if, else part
//		}
//		
//	}
//	// Create a Listener to listen Light Sensor event
//	SensorEventListener lightSensorEventListener = new SensorEventListener(){
//	     
//	      @Override
//	      public void onAccuracyChanged(Sensor sensor, int accuracy) {
//	       // TODO Auto-generated method stub
//	        
//	      }
//	     
//	      @Override
//	      public void onSensorChanged(SensorEvent event) {
//	       // TODO Auto-generated method stub
//	       if(event.sensor.getType()==Sensor.TYPE_LIGHT){
//	    	   Log.d("Debug","Inside OnSensorChanged Method ");
//	        float currentReading = event.values[0];
//	        Log.d("Debug","Light Sensor Value = " + currentReading);
//	      
//	       }
//	      }
//	          
//	        };
//	/*
//	 * To register the Battery Service for database insertion
//	 * */
//	public final void registerBatteryService() throws BatteryException
//	{
//		if(GlobalVariable.SENSOR_BATTERY == true)
//		{
//		// Create an object of specific service class to  
//		}
//		else
//		{
//			//Else part
//		}
//	}
//	
//	/*
//	 * To register the Location Service for database insertion
//	 * */
//	public final void registerLocationService() throws GPSSensorException // 4th Sensor
//	{
//		
//		if(GlobalVariable.SENSOR_LOCATION == true)
//		{
//		// Create an object of specific service class to  
//			gps = new GPSTracker(SensorControllerclasscontext);
//
//			// check if GPS enabled		
//	        if(gps.canGetLocation()){
//	        	
//	        	double latitude = gps.getLatitude();
//	        	double longitude = gps.getLongitude();
//	        	
//	        	// \n is for new line
//	        	Log.d("Debug","Latitude = " + latitude);
//	        	Log.d("Debug","Longitude = " + longitude);
//	        	Toast.makeText(SensorControllerclasscontext.getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();	
//	        }else{
//	        	// can't get location
//	        	// GPS or Network is not enabled
//	        	// Ask user to enable GPS/network in settings
//	        	gps.showSettingsAlert();
//	        }
//		}
//		else
//		{
//			//Else part
//			
//		}
//		
//	}
//	// Listener part for Location Manager 
//	
//	
//	
//	/*
//	 * To un-register the Accelerometer Service for database insertion
//	 * */
//	public final void unregisterAccelerometerService() throws AccelerometerSensorException
//	{
//		//sensorManager.unregisterListener(lightSensorEventListener); // Change the Listener
//		accel.disableAccelerometerListener(accelListener);
//		GlobalVariable.SENSOR_ACCELEROMETER = false;
//	}
//	/*
//	 * To un-register the Proximity Service for database insertion
//	 * */
//	public final void unregisterProximityService() throws ProximitySensorException
//	{
//		sensorManager.unregisterListener(proximityListener); // check this 
//		
//		Log.d("Debug","Inside unregisterProximity method");
//		try{
//		proximity.disableProximitySensor(proximityListener);
//		proximity.
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		GlobalVariable.SENSOR_PROXIMITY = false;
//	}
//	/*
//	 * To un-register the Light sensor Service for database insertion
//	 * */
//	public final void unregisterLightService() throws LightSensorException
//	{
//		sensorManager.unregisterListener(lightSensorEventListener);
//		GlobalVariable.SENSOR_LIGHT = false;
//	}
//	/*
//	 * To un-register the Battery Service for database insertion
//	 * */
//	public final void unregisterBatteryService() 
//	{
//		sensorManager.unregisterListener(lightSensorEventListener); // Change the listener
//		GlobalVariable.SENSOR_BATTERY = false;
//	}
//	/*
//	 * To un-register the Location Service for database insertion
//	 * */
//	public final void unregisterLocationService() throws GPSSensorException
//	{
//		gps.stopUsingGPS(); // Change the Listener 
//		GlobalVariable.SENSOR_LOCATION = false;
//	}
//}
