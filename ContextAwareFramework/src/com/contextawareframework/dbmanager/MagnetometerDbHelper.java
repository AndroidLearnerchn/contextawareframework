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
 * @File        MagnetometerDbHelper
 * @Created:    15.09.2014
 * @author:     Prasenjit
 * Last Change: 26.09.2014 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.sensors.motionsensors.Gyrometer;
import com.contextawareframework.sensors.positionsensors.Magnetometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This is a database helper class for all CRUD operation on Magnetometer Sensor in Android
 */
public class  MagnetometerDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private static MagnetometerDbHelper magnetometerDbHelper;

	private static boolean enableDebugging = CAFConfig.isEnableDebugging();
	private String TAG =  "MagnetometerDbHelper" ;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_MAG_ID,
			ContextAwareSQLiteHelper.COLUMN_MAG_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_MAG_X, ContextAwareSQLiteHelper.COLUMN_MAG_Y, ContextAwareSQLiteHelper.COLUMN_MAG_Z
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
	private MagnetometerDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}

	public static synchronized MagnetometerDbHelper getInstance(Context context)
	{
		if (magnetometerDbHelper == null)
			magnetometerDbHelper = new MagnetometerDbHelper(context);

		return magnetometerDbHelper;
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
	public Magnetometer createMagnetometerRowData(long timestamp,Float x, Float y, Float z){
		Magnetometer newRow = null ;
		try
		{
			ContentValues values = new ContentValues();
			values.put(ContextAwareSQLiteHelper.COLUMN_MAG_TIMESTAMP, timestamp);
			values.put(ContextAwareSQLiteHelper.COLUMN_MAG_X,x);
			values.put(ContextAwareSQLiteHelper.COLUMN_MAG_Y, y);
			values.put(ContextAwareSQLiteHelper.COLUMN_MAG_Z, z);
			long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_MAGNETOMETER, null,
					values);
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_MAGNETOMETER,
					allColumns, ContextAwareSQLiteHelper.COLUMN_MAG_ID + " = " + insertId, null,
					null, null, null);
			cursor.moveToFirst();
			newRow = cursorToMagnetometerRow(cursor);
			cursor.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"createMagnetoRowData Method");
		}
		return newRow;
	}

	/**
	 * Method to delete a row from database.
	 */
	public void deleteMagnetometerRowData(Magnetometer rowData) {
		try{
			long id = rowData.getId();
			System.out.println("Comment deleted with id: " + id);
			database.delete(ContextAwareSQLiteHelper.TABLE_MAGNETOMETER, ContextAwareSQLiteHelper.COLUMN_MAG_ID+ " = " + id, null);
			if(enableDebugging)
			{
				Log.d(TAG,"deleteMagnetoRowData Method");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method to list all row of the Magnetometer table
	 */
	public List<Magnetometer> getAllRows() {
		List<Magnetometer> magnetoRows = new ArrayList<Magnetometer>();
		Cursor cursor;
		try
		{
			cursor = database.query(ContextAwareSQLiteHelper.TABLE_MAGNETOMETER,
					allColumns, null, null, null, null, null);

			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Magnetometer magneto = cursorToMagnetometerRow(cursor);
				magnetoRows.add(magneto);
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
		return magnetoRows;
	}
	/**
	 * Method to initialize a Magnetometer POJO object
	 */
	private Magnetometer cursorToMagnetometerRow(Cursor cursor) {
		Magnetometer magnetoRow = new Magnetometer();
		try{
			magnetoRow.setTimeStamp(cursor.getLong(0));
			magnetoRow.setxAxis(cursor.getFloat(1));
			magnetoRow.setyAxis(cursor.getFloat(2));
			magnetoRow.setzAxis(cursor.getFloat(3));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"cursorToMagnetometerRow");
		}
		return magnetoRow;
	}
} 
