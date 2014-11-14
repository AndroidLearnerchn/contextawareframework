package com.example.frameworktestcase;

import com.contextawareframework.controller.SensorController;
import com.contextawareframework.exceptions.AccelerometerSensorException;
import com.contextawareframework.globalvariable.CAFConfig;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	SensorEventListener accelSensorListener,accelSensorListener1;
	private static String TAG = "MAIN ACTIVITY";
	SensorController controller;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		controller = SensorController.getInstance(this);
		try
		{
			
			accelSensorListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				Log.d(TAG,"Value1 hello: " + event.values[0]);
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		};
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			
			accelSensorListener1 = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				Log.d(TAG,"Value2 hi : " + event.values[0]);
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		};
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
			CAFConfig.setSensorAccelerometer(true);
			controller.registerAccelerometerService(accelSensorListener,SensorController.NORMAL);
			controller.registerAccelerometerService(accelSensorListener1,SensorController.NORMAL);
			
		}
		catch(AccelerometerSensorException e)
		{
			e.printStackTrace();
		}
		
		}	
	@Override
	protected void onResume()
	{
		super.onResume();
		Singleton singleinstance = Singleton.getInstance();
		singleinstance.doSomething("First Activity");
		Log.d(TAG,"onResume");
	}
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.d(TAG,"onDestroy");
		
		try{
			controller.unregisterAccelerometerService(accelSensorListener);
			controller.unregisterAccelerometerService(accelSensorListener1);
		}
		catch(AccelerometerSensorException e)
		{
			e.printStackTrace();
		}
	}
	public void startSecondActivity(View v)
	{
		try{
			Intent intent = new Intent(this,SecondActivity.class);
			startActivity(intent);
			//controller.unregisterAccelerometerService(accelSensorListener1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
