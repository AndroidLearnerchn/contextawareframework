package com.example.frameworktestcase;

import android.util.Log;

public class Singleton {

	private static Singleton singletonInstance;
	private final String TAG = "Singleton";
	private Singleton()
	{
		Log.d(TAG,"singleton Constructor");
	}

	public static synchronized Singleton getInstance()
	{
		if (singletonInstance == null)
			singletonInstance = new Singleton();

		return singletonInstance;
	}
	
	public void doSomething(String value)
	{
		Log.d(TAG,value);
	}
}
