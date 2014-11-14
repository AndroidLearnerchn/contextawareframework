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
 * @File        GyroscopeDbHelper
 * @Created:    5.09.2014
 * @author:     Prasenjit
 * Last Change: 8.09.2014 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.sensors.motionsensors.Gyrometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This is a database helper class for all CRUD operation on Gyroscope Sensor in Android
 */
public class  GyroscopeDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private static GyroscopeDbHelper gyroscopeDbHelper;

	private static boolean enableDebugging = CAFConfig.isEnableDebugging();
	private String TAG =  "GyroscopeDbHelper" ;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_GYRO_ID,
			ContextAwareSQLiteHelper.COLUMN_GYRO_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_GYRO_X, ContextAwareSQLiteHelper.COLUMN_GYRO_Y, ContextAwareSQLiteHelper.COLUMN_GYRO_Z
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
	private GyroscopeDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}

	public static synchronized GyroscopeDbHelper getInstance(Context context)
	{
		if (gyroscopeDbHelper == null)
			gyroscopeDbHelper = new GyroscopeDbHelper(context);

		return gyroscopeDbHelper;
	}

	/**
	 * Method to open the database for writing
	 */
	public void open() {
		try
		{
			database = dbHelper.getWritableDatabase();
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
	public Gyrometer createGyroRowData(long timestamp,Float x, Float y, Float z){
		Gyrometer newRow = null ;
		try
		{
			ContentValues values = new ContentValues();
			values.put(ContextAwareSQLiteHelper.COLUMN_GYRO_TIMESTAMP, timestamp);
			values.put(ContextAwareSQLiteHelper.COLUMN_GYRO_X,x);
			values.put(ContextAwareSQLiteHelper.COLUMN_GYRO_Y, y);
			values.put(ContextAwareSQLiteHelper.COLUMN_GYRO_Z, z);
			long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_GYRO, null,
					values);
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_GYRO,
					allColumns, ContextAwareSQLiteHelper.COLUMN_GYRO_ID + " = " + insertId, null,
					null, null, null);
			cursor.moveToFirst();
			newRow = cursorToGyroRow(cursor);
			cursor.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"createGyroRowDataMethod");
		}
		return newRow;
	}

	/**
	 * Method to delete a row from database.
	 */
	public void deleteGyroRowData(Gyrometer accel) {
		try{
			long id = accel.getId();
			System.out.println("Comment deleted with id: " + id);
			database.delete(ContextAwareSQLiteHelper.TABLE_GYRO, ContextAwareSQLiteHelper.COLUMN_GYRO_ID+ " = " + id, null);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method to list all row of the Gyrometer table
	 */
	public List<Gyrometer> getAllRows() {
		List<Gyrometer> gyroRows = new ArrayList<Gyrometer>();
		Cursor cursor;
		try
		{
			cursor = database.query(ContextAwareSQLiteHelper.TABLE_GYRO,
					allColumns, null, null, null, null, null);

			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Gyrometer gyro = cursorToGyroRow(cursor);
				gyroRows.add(gyro);
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
		return gyroRows;
	}
	/**
	 * Method to intialize a Gyrometer POJO object
	 */
	private Gyrometer cursorToGyroRow(Cursor cursor) {
		Gyrometer gyroRow = new Gyrometer();
		try{
			gyroRow.setTimeStamp(cursor.getLong(0));
			gyroRow.setxAxis(cursor.getFloat(1));
			gyroRow.setyAxis(cursor.getFloat(2));
			gyroRow.setzAxis(cursor.getFloat(3));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"cursorToGyroRow");
		}
		return gyroRow;
	}
} 
