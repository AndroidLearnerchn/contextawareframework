/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Csvfilewriter
 * @Created:    28.01.2014
 * @author:     Prasenjit
 * Last Change: 29.01.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.contextawareframework.dbmanager.ContextAwareSQLiteHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
/************************************************************************************
 * Class to generate csv file from sql query on the database. CSV file 
 * is created on sdcard so read / write permission has to be mentioned
 * in the android manifest file
 ***********************************************************************************/
public class Csvfilewriter {
	
	private Context localcontext;
	public static String checkCondition;
	public static int curRowCount;
	public static int prevRowCount;
	public static int totalRowCount;
	//Default Constructor
	/******************************************************************
	 * Description : Constructor
	 ******************************************************************/
	public Csvfilewriter(Context context)
	{
		localcontext = context;
	}
	///----------------------To save any sensor data in simple text file-------------------//
	/******************************************************************
	 * Description : To save any sensor data in simple text file
	 ******************************************************************/
	public void saveAllSensorData(long timestamp,float x, float y, float z,float latitude,float longitude )
	{
		String data;
		try
		{			
			{
				data= "    x :      " + x + "     y :     " + y + "        z :    " + z + "     Latitude :     " + latitude + "     Longitude :    " + longitude + "     time :     " +   timestamp  ;
			}
			File root = new File(android.os.Environment.getExternalStorageDirectory(), "Notes");
			if (!root.exists()) {
				root.mkdirs();
			}
			File gpxfile = new File(root,"sensorLog.txt");
			if(!gpxfile.exists())
			{
				data= "       x          ||        y       ||        z        ||     Latitude    ||    Longitude    ||    time      "  ;
			}
			FileWriter writer = new FileWriter(gpxfile,true);

			writer.append(data + "\n");

			writer.flush();
			writer.close();
			//Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	// Method to create file to insert data
	/******************************************************************
	 * Description : Method to create file to store data from database 
	 * to an external file on SD card. Need to mention Read / Write Permission 
	 * in the Android Manifest file.
	 ******************************************************************/
	public FileWriter createFile() throws IOException
	{	
		FileWriter writer;
		File root = new File(android.os.Environment.getExternalStorageDirectory(), "Notes");
		if (!root.exists()) {
			root.mkdirs();
		}
		File gpxfile = new File(root,"sensorLog.csv");
		if(!gpxfile.exists())
		{
			writer = new FileWriter(gpxfile,true);
			///writer.append(data + "\n");
			// writer.flush();
			// writer.close();
		}
		else
		{
			gpxfile.delete();
			writer = new FileWriter(gpxfile,true);
			//writer.append(data + "\n");
			//  writer.flush();
			//  writer.close();
		}
		return writer;
	}
	// Method to write data
	/******************************************************************
	 * Description : Method to write data on the newly created file
	 ******************************************************************/
	public void writeData(String data, FileWriter writer) throws FileNotFoundException,IOException
	{
		//FileWriter writer = new FileWriter(fileName,true);
		writer.append(data + "\n");
		writer.flush();
		writer.close();
	}
	///----------------------To save any sensor data in simple text file-------------------//
	/******************************************************************
	 * Description : To save Accelerometer sensor data in simple CSV file
	 ******************************************************************/
	public String saveAccelData(int id, long timestamp, float x, float y, float z)
	{
		String data= null;
		try
		{
			Log.d("Debug","Inside saveAccelData, file creation method");
			//			if(i==0)
			//			{
			//				 data= "This is test         x  ||        y     ||    z    ||   time   "  ;
			//				i++;
			//			}

			//else
			data = id + "," +x + "," + y + "," + z + "," + timestamp  ;

			//Date 3rd Feb
			/* File root = new File(android.os.Environment.getExternalStorageDirectory(), "Notes");
	        if (!root.exists()) {
	            root.mkdirs();
	        }
	        File gpxfile = new File(root,"sensorLog.csv");*/
			/*if(!gpxfile.exists())
	        {
	        	data= "This is test         x  ||        y     ||    z    ||   time   "  ;
	        }*/
			/*  FileWriter writer = new FileWriter(gpxfile,true);
	        Log.d("query Result ", "Res = " + data);
	      // writer.write(data+"\n");
	        writer.append(data + "\n");

	        writer.flush();
	        writer.close();*/
			//Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

		}
		catch(Exception e)
		{
			e.printStackTrace();
			//	         importError = e.getMessage();
			//	         iError();
		}
		return data;
	}
	//-----Start-------------------------------------------To store Proximity Sensor data------------------//
	/******************************************************************
	 * Description : To save Accelerometer sensor data in simple CSV file
	 ******************************************************************/
	public void saveProximityData(float x, float y, float z, long timestamp)
	{
		String data;
		try
		{
			//			if(i==0)
			//			{
			//				 data= "This is test         x  ||        y     ||    z    ||   time   "  ;
			//				i++;
			//			}

			//else
			{
				data= "This is test x = " + x + " y = " + y + " z = " + z + "  time = " + timestamp  ;
			}
			File root = new File(android.os.Environment.getExternalStorageDirectory(), "Notes");
			if (!root.exists()) {
				root.mkdirs();
			}
			File gpxfile = new File(root,"sensorLog.txt");
			if(!gpxfile.exists())
			{
				data= "This is test         x  ||        y     ||    z    ||   time   "  ;
			}
			FileWriter writer = new FileWriter(gpxfile,true);

			writer.append(data + "\n");

			writer.flush();
			writer.close();
			//Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			//	         importError = e.getMessage();
			//	         iError();
		}

	}
	//-End-----------------------------------------------To store Proximity Sensor data------------------//

	//Start------------------------------------------------To store GPS Location Sensor data------------------//
	public void saveGPSLocationData(float latitude, float longitude,long timestamp)
	{
		String data;
		try
		{
			//			if(i==0)
			//			{
			//				 data= "This is test         x  ||        y     ||    z    ||   time   "  ;
			//				i++;
			//			}

			//else
			{
				data= "This is test latitude = " + latitude + " y = " + longitude + "  time = " + timestamp  ;
			}
			File root = new File(android.os.Environment.getExternalStorageDirectory(), "Notes");
			if (!root.exists()) {
				root.mkdirs();
			}
			File gpxfile = new File(root,"sensorLog.csv");
			//	        if(!gpxfile.exists())
			//	        {
			//	        	data= "This is test         x  ||        y     ||    z    ||   time   "  ;
			//	        }
			FileWriter writer = new FileWriter(gpxfile,false);// Changed here , making true will enable overwrite
			Log.d("query Result ", "Res = " + data);
			writer.write(data+"\n");
			//writer.append(data + "\n");

			writer.flush();
			writer.close();
			//Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			//	         importError = e.getMessage();
			//	         iError();
		}

	}

	//End------------------------------------------------To store GPS Location Sensor data------------------//
	public void getDataFromTable(String tablename)
	{
		ContextAwareSQLiteHelper dbhelper = new ContextAwareSQLiteHelper(localcontext);
		/*File exportDir = new File(Environment.getExternalStorageDirectory(), "");       
			if (!exportDir.exists())
			{
				exportDir.mkdirs();
			}

			File file = new File(exportDir, "Accelerometerdb.csv");*/
		try
		{
			//file.createNewFile();     
			String  tableName = tablename ; 
			Log.d("Debug",tablename);

			SQLiteDatabase db = dbhelper.getReadableDatabase();
			//select _id from Accelerometer where _id <= (select  max(_id)-10 from Accelerometer);
			//String query = "select * from Accelerometer";//where _id <= (select  max(_id)-10 from Accelerometer)"; //select * from "+ tablename +" where _id > max(_id)-10 ";// + curRowCount;
			Log.d("Debug","PrevRowCount = " + prevRowCount);
			String query = "select * from Accelerometer where _id > " + prevRowCount  ;
			String queryForgetCount = " select * from Accelerometer "; 
			Cursor getcolumnCount = db.rawQuery(queryForgetCount, null);
			totalRowCount = getcolumnCount.getCount();
			
			Cursor curCSV = db.rawQuery(query,null);//new String [] {checkCondition});
			curRowCount =  curCSV.getCount();
			prevRowCount = prevRowCount + curRowCount;
			Log.d("Debug","CurRowCount = " + curRowCount+ "Total = " + totalRowCount);

			//checkCondition = ""+curCSV.getCount();
			int i =0;
			FileWriter writer = createFile();
			while(curCSV.moveToNext())
			{
				//Which column you want to exprort
				String data = saveAccelData(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2),curCSV.getFloat(3),curCSV.getFloat(4));
				//writeData(data, writer);
				writer.append(data+"\n");


				Log.d("Debug","Data from sursor to write function");
				//String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4)};
				//System.out.println("All val = " + arrStr[i]);
				//csvWrite.writeNext(arrStr);

			}
			//csvWrite.close();
			writer.flush();
			writer.close();

			curCSV.close();
		}
		catch(Exception sqlEx)
		{
			Log.e("ERROR in Simple  FileWriter", sqlEx.getMessage(), sqlEx);
		}
	}
}
