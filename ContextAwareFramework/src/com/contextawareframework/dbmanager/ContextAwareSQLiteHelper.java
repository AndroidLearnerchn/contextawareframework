/*
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
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        ContextAwareSQLiteHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 11.08.2014 by Prasenjit
 */
package com.contextawareframework.dbmanager;

import com.contextawareframework.exceptions.SQLiteQueryException;
import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This is a Database helper class for creating tables for sensors 
 * and context based on details (property field) provided by Sensor 
 * or Context. Add the table name and create statement here to add 
 * new table.
 */
public class ContextAwareSQLiteHelper extends SQLiteOpenHelper {

	// Database name for all sensor (context data) data 
	private static final String DATABASE_NAME = "contextawareframework.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TAG = "ContextAwareSQLiteHelper";

	//Added 4.8.14 Prasenjit
	private static boolean enableDebugging = CAFConfig.isEnableDebugging();

	private ContextAwareSQLiteHelper  contextAwareSQLiteHelper;
	private Context mContext;

	//------------------------------------Table for Storing user Information-----------------------------------//
	public static final String TABLE_USERINFO = "userinfo";
	public static final String COLUMN_USER_EMAIL = "usermail";
	public static final String COLUMN_DEV_EMAIL = "devmail";
	public static final String COLUMN_DEVICE_ID = "deviceid";
	public static final String COLUMN_APP_ID = "appid";
	public static final String COLUMN_USER_ID = "userid"; // unique ( appid + useremail )
	public static final String COLUMN_USER_AUTH_STATUS = "false"; // To check if its true then user can query the server
	//---------------------------------------------------------------------------------------------------------//

	//-------------------------------------Table for Magnetometer-------------------------------------------------//
	// Tabel Name
	public static final String TABLE_MAGNETOMETER = "magnetometer";

	// Gyroscope Table Column(Properties)
	public static final String COLUMN_MAG_ID = "id";
	public static final String COLUMN_MAG_TIMESTAMP = "time_stamp";
	public static final String COLUMN_MAG_X= "x_axis";
	public static final String COLUMN_MAG_Y= "y_axis";
	public static final String COLUMN_MAG_Z= "z_axis";
	//------------------------------------- Table for Magnetometer Sensor ends here -------------------------------------------------//

	//-------------------------------------Table for Gyroscope-------------------------------------------------//
	// Tabel Name
	public static final String TABLE_GYRO = "gyroscope";

	// Gyroscope Table Column(Properties)
	public static final String COLUMN_GYRO_ID = "id";
	public static final String COLUMN_GYRO_TIMESTAMP = "time_stamp";
	public static final String COLUMN_GYRO_X= "x_axis";
	public static final String COLUMN_GYRO_Y= "y_axis";
	public static final String COLUMN_GYRO_Z= "z_axis";
	//------------------------------------- Table for Gyroscope Sensor ends here -------------------------------------------------//

	//-------------------------------------Table for Accelerometer-------------------------------------------------//
	// Table Name
	public static final String TABLE_ACCEL = "accelerometer";

	//Accelerometer Table Column(Properties)	
	public static final String COLUMN_ACCEL_ID = "id";
	public static final String COLUMN_ACCEL_TIMESTAMP = "time_stamp";
	public static final String COLUMN_ACCEL_X= "x_axis";
	public static final String COLUMN_ACCEL_Y= "y_axis";
	public static final String COLUMN_ACCEL_Z= "z_axis";
	//------------------------------------- Table for Accelerometer Sensor ends here -------------------------------------------------//

	//-------------------------------------Table for Battery-------------------------------------------------//
	// Not in working state, database not been designed for Battery information
	public static final String TABLE_BATTERY = "battery";
	public static final String COLUMN_BATTERY_ID = "_id";
	public static final String COLUMN_BATTERY_TIMESTAMP = "time_stamp";

	//Accelerometer Table Column(Properties)
	public static final String COLUMN_BATTERY_X= "x_axis";
	public static final String COLUMN_BATTERY_y= "y_axis";
	public static final String COLUMN_BATTERY_Z= "z_axis";
	//-------------------------------------Table for Battery End here-------------------------------------------------//

	//-------------------------------------Table for Light Sensor-------------------------------------------------//

	//LightSensor Table Column(Properties)
	public static final String TABLE_LIGHT = "light";
	public static final String COLUMN_LIGHT_ID = "id";
	public static final String COLUMN_LIGHT_TIMESTAMP = "time_stamp";
	public static final String COLUMN_LIGHT_CUR_READING= "current_reading";

	//-------------------------------------Table for Light Sensor ends here-------------------------------------------------//

	//-------------------------------------Table for Proximity Sensor-------------------------------------------------//

	//Proximity Table Column(Properties)
	public static final String TABLE_PROXIMITY = "proximity";
	public static final String COLUMN_PROXIMITY_ID = "id";
	public static final String COLUMN_PROXIMITY_TIMESTAMP = "time_stamp";
	public static final String COLUMN_PROXIMITY_NEAR= "near";
	public static final String COLUMN_PROXIMITY_FAR= "far";

	//-------------------------------------Table for Proximity Sensor ends here-------------------------------------------------//

	//-------------------------------------Table for Location Sensor-------------------------------------------------//

	//Location Table Column(Properties)
	public static final String TABLE_LOCATION = "location";
	public static final String COLUMN_LOCATION_ID = "id";
	public static final String COLUMN_LOCATION_TIMESTAMP = "time_stamp";
	public static final String COLUMN_LOCATION_LATITUDE= "latitude";
	public static final String COLUMN_LOCATION_LONGINTUDE= "longitude";
	public static final String COLUMN_LOCATION_PLACENAME= "place_name";
	public static final String COLUMN_LOCATION_PLACEINFO= "place_info";	

	// Changed on 4.3.14 Mam Code integration Above code. 

	/*public static final String TABLE_LOCATION = "Location";
	public static final String COLUMN_LOCATION_ID = "_id";
	public static final String COLUMN_LOCATION_TIMESTAMP = "Time_Stamp";
	//Accelerometer Table Column(Properties)
	public static final String COLUMN_LOCATION_LATITUDE= "lat_value";
	public static final String COLUMN_LOCATION_LONGINTUDE= "long_value";
	public static final String COLUMN_LOCATION_PLACE= "z_value"; // To get the place information we may need to use the Geolocation class*/ 
	//-------------------------------------Table for Location Sensor-------------------------------------------------//


	// Database creation sql statement
	// UserInfo Table Added 06.06.14
	private static final String CREATE_TABLE_USERINFO = "create table "
			+ TABLE_USERINFO + "(" + COLUMN_USER_EMAIL
			+ " text not null, " + COLUMN_USER_ID
			+ " text primary key," + COLUMN_DEV_EMAIL + " text not null, "   +  COLUMN_DEVICE_ID  + " text not null, " +  COLUMN_APP_ID + " text not null " + COLUMN_USER_AUTH_STATUS + " text not null " + " ); ";


	// Accelerometer Table create statement
	private static final String CREATE_TABLE_ACCELEROMETER = "create table "
			+ TABLE_ACCEL + "(" + COLUMN_ACCEL_ID
			+ " integer primary key autoincrement, " + COLUMN_ACCEL_TIMESTAMP
			+ " integer not null," + COLUMN_ACCEL_X + " real, "   +  COLUMN_ACCEL_Y  + " real, " +  COLUMN_ACCEL_Z + " real " + " ); ";

	// Gyroscope Table create statement
	private static final String CREATE_TABLE_GYROMETER = "create table "
			+ TABLE_GYRO + "(" + COLUMN_GYRO_ID
			+ " integer primary key autoincrement, " + COLUMN_GYRO_TIMESTAMP
			+ " integer not null," + COLUMN_GYRO_X + " real, "   +  COLUMN_GYRO_Y  + " real, " +  COLUMN_GYRO_Z + " real " + " ); ";

	// Magnetometer Table create statement
	private static final String CREATE_TABLE_MAGNETOMETER = "create table "
			+ TABLE_MAGNETOMETER + "(" + COLUMN_MAG_ID
			+ " integer primary key autoincrement, " + COLUMN_MAG_TIMESTAMP
			+ " integer not null," + COLUMN_MAG_X + " real, "   +  COLUMN_MAG_Y  + " real, " +  COLUMN_MAG_Z + " real " + " ); ";

	// Battery Table create statement. This is sample table, should not be used as column names are not
	// defined as per actual entity attribute(s).
	// For Battery there are lots of field, So which fields have to be stored is not yet fixed.
	private static final String CREATE_TABLE_BATTERY = "create table "
			+ TABLE_BATTERY + "(" + COLUMN_BATTERY_ID
			+ " integer primary key autoincrement, " + COLUMN_BATTERY_TIMESTAMP
			+ " text not null," + COLUMN_BATTERY_X + " integer, "   +  COLUMN_BATTERY_y  + " integer, " +  COLUMN_BATTERY_Z + " integer " + " ); ";

	// Light Table create statement
	private static final String CREATE_TABLE_LIGHT = "create table "
			+ TABLE_LIGHT + "(" + COLUMN_LIGHT_ID
			+ " integer primary key autoincrement, " + COLUMN_LIGHT_TIMESTAMP
			+ " real not null," + COLUMN_LIGHT_CUR_READING + " real" + " ); ";

	// Proximity Table create statement
	private static final String CREATE_TABLE_PROXIMITY = "create table "
			+ TABLE_PROXIMITY + "(" + COLUMN_PROXIMITY_ID
			+ " integer primary key autoincrement, " + COLUMN_PROXIMITY_TIMESTAMP
			+ " real not null," + COLUMN_PROXIMITY_NEAR + " real, "   + COLUMN_PROXIMITY_FAR   + " real " + " ); ";

	// Location Table create statement
	//Date modified 3.3 14

	private static final String CREATE_TABLE_LOCATION = "create table " + TABLE_LOCATION + "(" + COLUMN_LOCATION_ID + " integer primary key autoincrement, " + COLUMN_LOCATION_TIMESTAMP
			+ " real not null," + COLUMN_LOCATION_LATITUDE + " real not null, " + COLUMN_LOCATION_LONGINTUDE   + " real not null, " + COLUMN_LOCATION_PLACENAME + " text not null, " + COLUMN_LOCATION_PLACEINFO + " text not null "  +  " ); ";


	/*private static final String CREATE_TABLE_LOCATION = "create table "
			+ TABLE_LOCATION + "(" + COLUMN_LOCATION_ID
			+ " integer primary key autoincrement, " + COLUMN_LOCATION_TIMESTAMP
			+ " text not null," + COLUMN_LOCATION_LATITUDE + " integer, "   + COLUMN_LOCATION_LONGINTUDE   + " integer " + " ); ";
	 */
	
	@Override
	public void onCreate(SQLiteDatabase database)
	{
		if(enableDebugging)
		{
			Log.d(TAG,"OnCreate Method Called");
		}
		try
		{
			if(CAFConfig.isTableAccelerometer())
			{
				database.execSQL(CREATE_TABLE_ACCELEROMETER);
				if(enableDebugging)
				{
					Log.d(TAG,"Accelerometer Table created");
				}
			}
			if(CAFConfig.isTableBattery())
			{
				database.execSQL(CREATE_TABLE_BATTERY);
				if(enableDebugging)
				{
					Log.d(TAG,"Battery Table created");
				}
			}
			if(CAFConfig.isTableLight())
			{
				database.execSQL(CREATE_TABLE_LIGHT);
				if(enableDebugging)
				{
					Log.d(TAG,"Light Table created");
				}
			}
			if(CAFConfig.isTableProximity())
			{	
				database.execSQL(CREATE_TABLE_PROXIMITY);
				if(enableDebugging)
				{
					Log.d(TAG,"Proximity Table created");
				}
			}
			if(CAFConfig.isTableLocation())
			{
				database.execSQL(CREATE_TABLE_LOCATION);
				if(enableDebugging)
				{
					Log.d(TAG,"Location Table created");
				}
			}
			if(CAFConfig.isTableUserinfo())
			{
				database.execSQL(CREATE_TABLE_USERINFO);
				if(enableDebugging)
				{
					Log.d(TAG,"Userinfo Table created");
				}
			}
			if(CAFConfig.isTableGyroscope())
			{
				database.execSQL(CREATE_TABLE_GYROMETER);
				if(enableDebugging)
				{
					Log.d(TAG,"Gyrometer Table created");
				}
			}
			if(CAFConfig.isTableMagnetometer())
			{
				database.execSQL(CREATE_TABLE_MAGNETOMETER);
				if(enableDebugging)
				{
					Log.d(TAG,"Magnetometer Table created");
				}
			}
		}
		catch(SQLiteQueryException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(enableDebugging)
		{
			Log.d(TAG +" : "+ContextAwareSQLiteHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "+ newVersion + ", which will destroy all old data");
		}
		// If database version updated then it will delete all tables with its database and create a new empty one
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCEL);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BATTERY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIGHT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROXIMITY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERINFO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GYRO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAGNETOMETER);
		onCreate(db);
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


	/**
	 * Description : Private constructor. Singleton Pattern to create the class object
	 * @param context Calling Activity context
	 */

	//	private  ContextAwareSQLiteHelper(Context context)
	//	{
	//		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	//	}
	/**
	 * Description : Method to create an instance of AccelerometerDataListener Class.
	 * @param  context Calling Activity context
	 * @return ContextAwareSQLiteHelper Class instance
	 */
	/*public synchronized ContextAwareSQLiteHelper getInstance(Context context)
	{
		if (contextAwareSQLiteHelper == null)
			contextAwareSQLiteHelper = new ContextAwareSQLiteHelper(context);

		return contextAwareSQLiteHelper;
	}
*/
	/**
	 * Public Constructor
	 * @param context
	 */
	public ContextAwareSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
} 
