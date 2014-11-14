/**
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
 * @File        LocationDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 * 
 */
package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.globalvariable.CAFConfig;
import com.contextawareframework.sensors.motionsensors.Accelerometer;
import com.contextawareframework.sensors.positionsensors.LocationPojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This is a database helper class for all CRUD operation on GPS / Location  Sensor in Android
 */
public class  LocationDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private static LocationDbHelper locationDbHelper;

	private static boolean enableDebugging = CAFConfig.isEnableDebugging();
	private String TAG =  "LocationDbHelper" ;
	private String[] allColumns = { 
			ContextAwareSQLiteHelper.COLUMN_LOCATION_ID,
			ContextAwareSQLiteHelper.COLUMN_LOCATION_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_LOCATION_LATITUDE, ContextAwareSQLiteHelper.COLUMN_LOCATION_LONGINTUDE, ContextAwareSQLiteHelper.COLUMN_LOCATION_PLACENAME,
			ContextAwareSQLiteHelper.COLUMN_LOCATION_PLACEINFO };

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
	 * Private Constructor to implement Singleton pattern. 
	 */
	private LocationDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}

	public static synchronized LocationDbHelper getInstance(Context context)
	{
		if (locationDbHelper == null)
			locationDbHelper = new LocationDbHelper(context);

		return locationDbHelper;
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
	 * Method to create a row of Location Table
	 * @param timestamp Store the timestamp in long
	 * @param latitude Latitude of the place
	 * @param longitude Longitude of the place
	 * @param place Name of the place
	 * @param placeInfo Information about the place 
	 * @return newLocationRow LocationPojo Class object with lat, long, time, place and placeinfo
	 */
	public LocationPojo createLocationRowData(String timestamp,String latitude, String longitude, String place, String placeInfo)
	{
		ContentValues values = new ContentValues();
		values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_TIMESTAMP, timestamp);
		values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_LATITUDE,latitude);
		values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_LONGINTUDE, longitude);
		values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_PLACENAME, place);
		values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_PLACEINFO, placeInfo);    	        

		long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_LOCATION, null, values);

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LOCATION,
				allColumns, ContextAwareSQLiteHelper.COLUMN_LOCATION_ID + " = " + insertId, null,
				null, null, null);

		cursor.moveToFirst();
		LocationPojo newLocationRow = cursorToLocationRow(cursor);
		cursor.close();
		if(enableDebugging)
		{
			Log.d(TAG,"createLocationRowData Method");
		}

		return newLocationRow;
	}
	
	/**
	 * Method to delete a row from database.
	 */
	public void deleteLocationRow(LocationPojo location) {

		long id = location.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_LOCATION, ContextAwareSQLiteHelper.COLUMN_LOCATION_ID
				+ " = " + id, null);
		if(enableDebugging)
		{
			Log.d(TAG,"deleteLocationRow Method");
		}
	}

	/**
	 * Method to list all row of the Location table
	 */
	public List<LocationPojo> getAllRows() {

		List<LocationPojo> locationRow = new ArrayList<LocationPojo>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LOCATION,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			LocationPojo location = cursorToLocationRow(cursor);
			locationRow.add(location);
			cursor.moveToNext();

		}

		// Make sure to close the cursor
		cursor.close();
		if(enableDebugging)
		{
			Log.d(TAG,"getAllRows");
		}
		return locationRow;
	}
	/**
	 * Method to initialize a Location POJO object
	 */
	private LocationPojo cursorToLocationRow(Cursor cursor) 
	{

		LocationPojo location = new LocationPojo();

		// Set the Time-stamp
		location.setTimestamp(cursor.getLong(0));

		// Set the Latitude Value
		location.setLatitude(cursor.getFloat(1));

		// Set the Longitude Value
		location.setLongitude(cursor.getFloat(2));

		// To get the location name using Geolocation if possible
		location.setPlaceName(cursor.getString(3));

		// To get the place info
		location.setPlaceInfo(cursor.getString(4));
		if(enableDebugging)
		{
			Log.d(TAG,"cursorToLocationRow");
		}
		return location;
	}

} 