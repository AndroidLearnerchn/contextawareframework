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

 * @File        LightDbHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 11.08.2014 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.sensors.environmentsensors.Light;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This is a database helper class for all CRUD operation on Light Sensor in Android
 */
public class  LightDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private static LightDbHelper lightDbHelper;
	private static boolean enableDebugging = CAFConfig.isEnableDebugging();

	private String TAG =  "LightDbHelper" ;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_LIGHT_ID,
			ContextAwareSQLiteHelper.COLUMN_LIGHT_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_LIGHT_CUR_READING};

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
	private LightDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}

	/**
	 * Method to create the class object
	 */
	public static synchronized LightDbHelper getInstance(Context context)
	{
		if (lightDbHelper == null)
			lightDbHelper = new LightDbHelper(context);

		return lightDbHelper;
	}

	/**
	 * Method to open the database for writing
	 */
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
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
	public Light createLightRowData(long timestamp,Float light_cur_read){
		ContentValues values = new ContentValues();
		Light newRow = null;
		try
		{
			values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
			values.put(ContextAwareSQLiteHelper.COLUMN_LIGHT_CUR_READING, light_cur_read);

			long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_LIGHT, null,
					values);
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LIGHT,
					allColumns, ContextAwareSQLiteHelper.COLUMN_LIGHT_ID + " = " + insertId, null,
					null, null, null);
			cursor.moveToFirst();
			newRow = cursorToLightRow(cursor);
			cursor.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"createLightRowData Method");
		}
		return newRow;
	}
	/**
	 * Method to delete a row from database
	 */
	public void deleteLightRowData(Light light) {
		long id = light.getId();
		try{
			System.out.println("Comment deleted with id: " + id);
			database.delete(ContextAwareSQLiteHelper.TABLE_LIGHT, ContextAwareSQLiteHelper.COLUMN_LIGHT_ID
					+ " = " + id, null);
			if(enableDebugging)
			{
				Log.d(TAG,"deleteLightRowData Method");
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
	}
	/**
	 * Method to list all row of the Light table
	 */
	public List<Light> getAllRows() {
		List<Light> lightRowData = new ArrayList<Light>();
		try
		{
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LIGHT,
					allColumns, null, null, null, null, null);

			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Light light = cursorToLightRow(cursor);
				lightRowData.add(light);
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
			Log.d(TAG,"getAllRows Method");
		}
		return lightRowData;
	}
	/**
	 * Method to initialize a Light POJO object
	 */
	private Light cursorToLightRow(Cursor cursor) {
		Light lightpojo = new Light();
		try
		{
			lightpojo.setTimestamp(cursor.getLong(0));
			lightpojo.setCurrentReading(cursor.getFloat(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"cursorToLightRow Method");
		}
		return lightpojo;
	}
} 
