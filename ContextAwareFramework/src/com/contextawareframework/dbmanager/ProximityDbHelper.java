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
 * @File        ProximityDbHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 11.08.2014 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.sensors.positionsensors.Proximity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This is a database helper class for all CRUD operation on Proximity Sensor in Android
 */
public class  ProximityDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String TAG =  "ProximityDbHelper" ;
	private static ProximityDbHelper proximityDbHelper;
	private boolean enableDebugging = CAFConfig.isEnableDebugging();

	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID,
			ContextAwareSQLiteHelper.COLUMN_PROXIMITY_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_NEAR, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_FAR};
	/**
	 * Default Constructor
	 */
	private ProximityDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}

	public static synchronized ProximityDbHelper getInstance(Context context)
	{
		if (proximityDbHelper == null)
			proximityDbHelper = new ProximityDbHelper(context);

		return proximityDbHelper;
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
	public Proximity createProximiytRowData(long timestamp,int near, int far)
	{
		ContentValues values = new ContentValues();
		Proximity newRow = null;
		try{
			values.put(ContextAwareSQLiteHelper.COLUMN_PROXIMITY_TIMESTAMP, timestamp);
			values.put(ContextAwareSQLiteHelper.COLUMN_PROXIMITY_NEAR,near);
			values.put(ContextAwareSQLiteHelper.COLUMN_PROXIMITY_FAR, far);

			long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_PROXIMITY, null,
					values);
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_PROXIMITY,
					allColumns, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID + " = " + insertId, null,
					null, null, null);
			cursor.moveToFirst();
			newRow = cursorToProximityRow(cursor);
			cursor.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"createProximityRowData Method");
		}
		return newRow;
	}

	/**
	 * Method to delete a row from database
	 */
	public void deleteProximityRowData(Proximity proximity) {
		try
		{
			long id = proximity.getId();
			System.out.println("Comment deleted with id: " + id);
			database.delete(ContextAwareSQLiteHelper.TABLE_PROXIMITY, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID
					+ " = " + id, null);
			if(enableDebugging)
			{
				Log.d(TAG,"deleteProximityRowData Method");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Method to list all row of the Proximity table
	 */
	public List<Proximity> getAllRows() {
		List<Proximity> proximityRow = new ArrayList<Proximity>();
		try
		{
			Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_PROXIMITY,
					allColumns, null, null, null, null, null);

			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Proximity proximity = cursorToProximityRow(cursor);
				proximityRow.add(proximity);
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
			Log.d(TAG,"getAllRow Method");
		}
		return proximityRow;
	}
	/**
	 * Method to intialize a Proximity POJO object
	 */
	private Proximity cursorToProximityRow(Cursor cursor) {
		Proximity proximityRow = new Proximity();
		try
		{
			proximityRow.setTimestamp(cursor.getLong(0));
			proximityRow.setNear(cursor.getInt(1));
			proximityRow.setFar(cursor.getInt(2));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(enableDebugging)
		{
			Log.d(TAG,"cursorToProximityRow Method");
		}
		return proximityRow;
	}

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
} 
