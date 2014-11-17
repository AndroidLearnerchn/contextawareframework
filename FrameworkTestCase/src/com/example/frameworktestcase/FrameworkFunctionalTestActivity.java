package com.example.frameworktestcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.contextawareframework.contextawarefunctions.ContextAwareFunction;
import com.contextawareframework.controller.SensorController;
import com.contextawareframework.dbmanager.AccelerometerDbHelper;
import com.contextawareframework.dbmanager.ContextAwareSQLiteHelper;
import com.contextawareframework.dbmanager.GyroscopeDbHelper;
import com.contextawareframework.dbmanager.LightDbHelper;
import com.contextawareframework.dbmanager.LocationDbHelper;
import com.contextawareframework.dbmanager.MagnetometerDbHelper;
import com.contextawareframework.dbmanager.ProximityDbHelper;
import com.contextawareframework.exceptions.AccelerometerSensorException;
import com.contextawareframework.exceptions.CAFException;
import com.contextawareframework.exceptions.LightSensorException;
import com.contextawareframework.exceptions.ProximitySensorException;
import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.utility.CsvFileWriter;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

public class FrameworkFunctionalTestActivity extends Activity {
	AccelerometerDbHelper  accelDbHelper;
	LightDbHelper lightDbHelper;
	ProximityDbHelper proximityDbHelper;
	GyroscopeDbHelper gyroDbHelper;
	LocationDbHelper locationDbHelper;
	MagnetometerDbHelper magnetoDbHelper;
	long timestamp;
	ContextAwareSQLiteHelper dbHelper;
	
	
	
	private CheckBox chkAccel, chkProximity, chkLight, chkGyro, chkGPS, chkMagnetometer;
	SensorController controller;
	ContextAwareFunction caFunction;
	SensorEventListener accelSensorListener, proximitySensorListener, lightSensorListener, gyroSensorListener, magnetoSensorListener;
	LocationListener gpsSensorListener;
	
	CsvFileWriter accelFileWriter, proximityFileWriter, magnetoFileWriter, gyroFileWriter, lightFileWriter,locationFileWriter  ;
	
	private static final String TAG = "FrameworkFunctionalityTestCase";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_framework_functional_test);
		CAFConfig.setEnableDebugging(true);
		chkAccel = (CheckBox) findViewById(R.id.chkBoxAccelerometer);
		chkProximity = (CheckBox) findViewById(R.id.chkBoxProximity);
		chkLight = (CheckBox) findViewById(R.id.chkBoxLight);
		chkGyro = (CheckBox) findViewById(R.id.chkBoxGyro);
		chkGPS = (CheckBox) findViewById(R.id.chkBoxGPS);
		chkMagnetometer = (CheckBox) findViewById(R.id.chkBoxMagnetometer);
		
		controller = SensorController.getInstance(this);
		
		CAFConfig.setTableAccelerometer(true);
		CAFConfig.setTableProximity(true);
		CAFConfig.setTableLight(true);
		CAFConfig.setTableGyroscope(true);
		CAFConfig.setTableLocation(true);
		CAFConfig.setTableMagnetometer(true);
		
		dbHelper=  new ContextAwareSQLiteHelper(this);

		// Using Singleton Pattern for creating the DbHelper Object
		accelDbHelper =   AccelerometerDbHelper.getInstance(this);
		gyroDbHelper = GyroscopeDbHelper.getInstance(this);
		lightDbHelper =  LightDbHelper.getInstance(this);
		proximityDbHelper = ProximityDbHelper.getInstance(this);
		locationDbHelper = LocationDbHelper.getInstance(this);
		magnetoDbHelper = MagnetometerDbHelper.getInstance(this);
		
		// Opening database for read / write access. 
		accelDbHelper.open();
		gyroDbHelper.open();
		proximityDbHelper.open();
		lightDbHelper.open();
		locationDbHelper.open();
		magnetoDbHelper.open();
		
		
		// Location Listener 
		gpsSensorListener = new LocationListener(){

			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
			       Log.d(TAG,"Location Update");
			       
			       float lat= (float)location.getLatitude();
			       float longitude = (float)location.getLongitude();
			       Log.d(TAG,"Longitude : "+longitude);
			       Log.d(TAG,"Latitude : "+ lat);
			       String place = "Tidel Park";
			       String placeInfo = "CDAC";			       
			       timestamp = System.currentTimeMillis(); 
			       locationDbHelper.createLocationRowData(timestamp, lat, longitude, place, placeInfo);
			     
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		// Gyroscope SensorEventListener
		gyroSensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"gyroscope");
				timestamp = System.currentTimeMillis();
				gyroDbHelper.createGyrometerRowData(timestamp, event.values[0], event.values[1], event.values[2]);
				
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub

			}
		};
		
		// Magnetometer SensorEventListener
				magnetoSensorListener  = new  SensorEventListener() {

					@Override
					public void onSensorChanged(SensorEvent event) {
						Log.d(TAG,"Magnetometer");
						timestamp = System.currentTimeMillis();
						//magnetoDbHelper.setEnableDebugging(true);
						Log.d(TAG,"Values are :" + timestamp + "  "+event.values[0]+"  "+ event.values[1] +" " +event.values[2]);
						magnetoDbHelper.createMagnetometerRowData(timestamp, event.values[0], event.values[1], event.values[2]);
						
					}

					@Override
					public void onAccuracyChanged(Sensor sensor, int accuracy) {
						// TODO Auto-generated method stub

					}
				};

		// Proximity SensorEventListener
		proximitySensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"proximity");
				timestamp = System.currentTimeMillis();
				proximityDbHelper.createProximiytRowData(timestamp, event.values[0], event.values[1]);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub

			}
		};

		// Accelerometer SensorEventListener
		accelSensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"Accelerometer");	
				timestamp = System.currentTimeMillis();
				accelDbHelper.createAccelRowData(timestamp, event.values[0], event.values[1], event.values[2]);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {

			}
		};

		// Light SensorEventListener
		lightSensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"light");
				timestamp = System.currentTimeMillis();
				lightDbHelper.createLightRowData(timestamp, event.values[0]);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {

			}
		};

		chkProximity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkProximity.isChecked())
				{ Log.d(TAG,"Test proximity");

				try
				{
					if(controller==null){
						Log.d("Debug", "Controller is null");
					}
					else
					{
						CAFConfig.setSensorProximity(true);
						Log.d("Debug", " Registering  proximity sensor");
						controller.registerProximityService(proximitySensorListener,SensorController.NORMAL);

					}
				} 
				catch (ProximitySensorException e) 
				{
					e.printStackTrace();
				}	
				}
				else
				{

					Log.d(TAG, " Un-Registering  proximity sensor");
					try{
						if(proximitySensorListener!=null)
						{
							controller.unregisterProximityService(proximitySensorListener);
							CAFConfig.setSensorProximity(false);
						}
					}
					catch(ProximitySensorException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		
		chkGyro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkGyro.isChecked())
				{ Log.d(TAG,"Test Gyrometer");

				try
				{
					if(controller==null){
						Log.d("Debug", "Controller is null");
					}
					else
					{
						CAFConfig.setSensorGyroscope(true);
						Log.d("Debug", " Registering  Gyroscope sensor");
						controller.registerGyroscopeService(gyroSensorListener,SensorController.NORMAL);

					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}	
				}
				else
				{

					Log.d(TAG, " Un-Registering  gyroscope sensor");
					try{
						if(gyroSensorListener!=null)
						{
							controller.unregisterGyroscopeService(gyroSensorListener);
							CAFConfig.setSensorGyroscope(false);
						}
					}
					catch(CAFException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		
		
		// Magnetometer Chekbox listener 
		
		chkMagnetometer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkMagnetometer.isChecked())
				{ Log.d(TAG,"Test Magnetometer");

				try
				{
					if(controller==null){
						Log.d("Debug", "Controller is null");
					}
					else
					{
						CAFConfig.setSensorMagnetometer(true);
						Log.d("Debug", " Registering  Magnetometer sensor");
						controller.registerMagnetometerService(magnetoSensorListener,SensorController.NORMAL);

					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}	
				}
				else
				{

					Log.d(TAG, " Un-Registering  Magnetometer sensor");
					try{
						if(magnetoSensorListener!=null)
						{
							controller.unregisterMagnetometerService(magnetoSensorListener);
							CAFConfig.setSensorMagnetometer(false);
						}
					}
					catch(CAFException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		
		// Registering checkbox listener for Location Service
		chkGPS.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkGPS.isChecked())
				{ Log.d(TAG,"Test GPS");

				try
				{
					if(controller==null){
						Log.d("Debug", "Controller is null");
					}
					else
					{
						CAFConfig.setSensorLocation(true);
						Log.d("Debug", " Registering  Location / GPS sensor");
						controller.registerLocationService(LocationManager.NETWORK_PROVIDER,0,0,gpsSensorListener);

					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}	
				}
				else
				{				
					try{
						if(gpsSensorListener!=null)
						{
							controller.unregisterLocationService(gpsSensorListener);
							Log.d(TAG, " Un-Registering  Location / GPS sensor");
							//CAFConfig.setSensorGyroscope(false);
						}
					}
					catch(CAFException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		
		chkLight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkLight.isChecked())
				{
					Log.d(TAG,"Test light");
					try
					{	
						CAFConfig.setSensorLight(true);
						controller.registerLightService(lightSensorListener,SensorController.NORMAL);
					} 
					catch (LightSensorException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{

					Log.d(TAG, " Un-Registering  Light sensor");
					try{
						if(lightSensorListener!=null)
						{
							controller.unregisterLightService(lightSensorListener);
							CAFConfig.setSensorLight(false);
						}
					}
					catch(LightSensorException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		chkAccel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkAccel.isChecked())
				{	Log.d(TAG,"Test Accelerometer");
				try
				{
					CAFConfig.setSensorAccelerometer(true);
					controller.registerAccelerometerService(accelSensorListener,SensorController.NORMAL);
				} 
				catch (AccelerometerSensorException e) 
				{
					e.printStackTrace();
				}
				}
				else
				{

					Log.d(TAG, " Un-Registering  Accelerometer sensor");
					try{
						if(accelSensorListener!=null)
						{
							
							controller.unregisterAccelerometerService(accelSensorListener);
							CAFConfig.setSensorAccelerometer(false);
						}
					}
					catch(AccelerometerSensorException e)
					{
						e.printStackTrace();
					}

				}

			}
		});

	}
	@Override
	protected void onResume()
	{
		super.onResume();

	}
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		try
		{   // To  test createcsvfile, 
			
			/*CsvFileWriter fileWriter = new CsvFileWriter(getApplicationContext());
			
			fileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_ACCEL,fileWriter.createFile(null, null, null));
			Log.d("File","File Created");
			String d = fileWriter.dataToWrite(1,"Name","Again");
			Log.d(TAG,"dataToWrite "+ d);*/
			
			/* To create the csv file at time of exist*/
			
			// Take data on a file
			accelFileWriter = new CsvFileWriter(this);
			gyroFileWriter = new CsvFileWriter(this);
			magnetoFileWriter = new CsvFileWriter(this);
			proximityFileWriter = new CsvFileWriter(this);
			lightFileWriter = new CsvFileWriter(this);
			locationFileWriter = new CsvFileWriter(this);
			
			//File path = new File;
			FileWriter accelWriter,proximityWriter, lightWriter, gyroWriter, magnetoWriter, locationWriter;
	    	try {
	    		// For sensor Accelerometer
	    		accelWriter = accelFileWriter.createFile(null, null, "Accelerometer.csv");
				accelFileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_ACCEL, accelWriter);
				accelWriter.close();
				accelDbHelper.close();		
				
				// For sensor Gyroscope
				gyroWriter = gyroFileWriter.createFile(null, null, "GyroMeter.csv");
				gyroFileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_GYRO, gyroWriter);
				gyroWriter.close();
				gyroDbHelper.close();
				
				// For Light Sensor
				lightWriter = lightFileWriter.createFile(null, null, "Light.csv");
				lightFileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_LIGHT, lightWriter);
				lightWriter.close();
				lightDbHelper.close();
				
				// For Proximity Sensor
				proximityWriter = proximityFileWriter.createFile(null, null, "Proximity.csv");
				proximityFileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_PROXIMITY, proximityWriter);
				proximityWriter.close();
				proximityDbHelper.close();
				
				// For Magnetometer Sensor
				magnetoWriter = magnetoFileWriter.createFile(null, null, "Magnetometer.csv");
				magnetoFileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_MAGNETOMETER, magnetoWriter);
				magnetoWriter.close();
				magnetoDbHelper.close();
				
				// For Loaction Service
				locationWriter = locationFileWriter.createFile(null, null, "Location.csv");
				locationFileWriter.getDataFromTable(ContextAwareSQLiteHelper.TABLE_LOCATION, locationWriter);
				locationWriter.close();
				locationDbHelper.close();
				
			} 
	    	catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 /* Till here */
			if(controller!=null)
			{
				if(accelSensorListener!=null)
					controller.unregisterAccelerometerService(accelSensorListener);
				if(proximitySensorListener!=null)
					controller.unregisterProximityService(proximitySensorListener);
				if(lightSensorListener!=null)
					controller.unregisterLightService(lightSensorListener);
				if(gyroSensorListener!=null)
					controller.unregisterLightService(gyroSensorListener);
				if(gpsSensorListener!=null)
					controller.unregisterLocationService(gpsSensorListener);
				if(magnetoSensorListener!=null)
					controller.unregisterMagnetometerService(magnetoSensorListener);
			}
			
			//fileWirter.dataToWrite();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
