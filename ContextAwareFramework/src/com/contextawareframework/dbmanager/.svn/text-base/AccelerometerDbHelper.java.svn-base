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
 * @File        AccelerometerDbHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 11.08.2014 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.sensors.motionsensors.Accelerometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This is a database helper class for all CRUD operation on Accelerometer Sensor in Android
 */
public class  AccelerometerDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private static AccelerometerDbHelper accelerometerDbHelper;

	private static boolean enableDebugging = CAFConfig.isEnableDebugging();
	private String TAG =  "AccelerometerDbHelper" ;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_ACCEL_ID,
			ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_ACCEL_X, ContextAwareSQLiteHelper.COLUMN_ACCEL_Y, ContextAwareSQLiteHelper.COLUMN_ACCEL_Z
	};

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
	 * Default Constructor
	 */
	private AccelerometerDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}
	public static synchronized AccelerometerDbHelper getInstance(Context context)
	{
		if (accelerometerDbHelper == null)
			accelerometerDbHelper = new AccelerometerDbHelper(context);

		return accelerometerDbHelper;
	}

	/**
	 * Method to open the database for writing
	 */
	public void open() {
		try{
			database = dbHelper.getWritableDatabase();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * Method to open the database in read only mode 
	 */
	public void openReadOnly()
	{
		try
		{
			database = dbHelper.getReadableDatabase();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Method to close the database connection
	 */
	public void close() {
		dbHelper.close();
	}

	/**
	 * Method to create insert a row of data into the database
	 */
	public Accelerometer createAccelRowData(long timestamp,Float x, Float y, Float z){
		Accelerometer newAccelRow = null ;
		try
		{
			ContentValues values = new ContentValues();
			values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
			values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_X,x);
			values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_Y, y);
			values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_Z, z);
			long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_ACCEL, null,
					values);
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
					allColumns, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID + " = " + insertId, null,
					null, null, null);
			cursor.moveToFirst();
			newAccelRow = cursorToAccelRow(cursor);
			cursor.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"createAccelRowDataMethod");
		}
		return newAccelRow;
	}

	/**
	 * Method to delete a row from database.
	 */
	public void deleteAccelRowData(Accelerometer accel) {
		try{
			int id = accel.getId();
			System.out.println("Comment deleted with id: " + id);
			database.delete(ContextAwareSQLiteHelper.TABLE_ACCEL, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID+ " = " + id, null);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method to list all row of the Accelerometer table
	 */
	public List<Accelerometer> getAllRows() {
		List<Accelerometer> accelRows = new ArrayList<Accelerometer>();
		Cursor cursor;
		try
		{
			cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
					allColumns, null, null, null, null, null);

			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Accelerometer accel = cursorToAccelRow(cursor);
				accelRows.add(accel);
				cursor.moveToNext();
			}
			// Make sure to close the cursor
			cursor.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"getAllRows");
		}
		return accelRows;
	}
	/**
	 * Method to initialize a Accelerometer POJO object
	 */
	private Accelerometer cursorToAccelRow(Cursor cursor) {
		Accelerometer accelRow = new Accelerometer();
		try{
			accelRow.setTimestamp(cursor.getLong(0));
			accelRow.setX(cursor.getFloat(1));
			accelRow.setY(cursor.getFloat(2));
			accelRow.setZ(cursor.getFloat(3));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"cursorToAccelRow");
		}
		return accelRow;
	}
} 
