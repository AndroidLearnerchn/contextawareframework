package com.example.frameworktestcase;

import com.contextawareframework.controller.SensorController;
import com.contextawareframework.exceptions.AccelerometerSensorException;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;

public class SecondActivity extends Activity {
	SensorController controller;
	SensorEventListener  accelListener;
	private final String TAG = "Second Activity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Singleton second = Singleton.getInstance();
		second.doSomething("Second Activity");
		/*try
		{
			accelListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				Log.d(TAG,"Second Activity");
				Log.d(TAG,"Value from Second"+event.values[0]);
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
			GlobalVariable.SENSOR_ACCELEROMETER= true;
			controller = new SensorController1(this);
			controller.registerAccelerometerService(accelListener);
		}
		catch(AccelerometerSensorException e)
		{
			e.printStackTrace();
		}*/
		
	}
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.d(TAG,"second Activity OnDestory");
		/*try{
		controller.unregisterAccelerometerService(accelListener);
		}
		catch(AccelerometerSensorException e)
		{
			e.printStackTrace();
		}*/
	}
}
