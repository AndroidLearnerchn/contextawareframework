/* 
 * Copyright (c) 2013-14 by CDAC Chennai 
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
 * @File        CsvFileWriter
 * @Created:    20.11.2013
 * @author:     Prasenjit
 * Last Change: 2.09.2014 by Prasenjit
 */
// This file can be used
package com.contextawareframework.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.contextawareframework.dbmanager.ContextAwareSQLiteHelper;
import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.content.Loader.ForceLoadContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * 
 * Description : Class to create CSV File either from database or to directly store the 
 *               sensor / context data in csv file.[This file to be used]
 */
public class CsvFileWriter {

	private static final String TAG = "CsvFileWriterClass";  
	private Context localContext;

	// Variable to store the current row count for the queried table.
	public static int curRowCount;

	// To store the last row count in an application life cycle.
	public static int prevRowCount=0;
	
	/* Cursor to a row */
	public static Cursor curCSV;
	
	// Total row count of the queried table at present
	public static int totalRowCount;

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 
		
	/**
	 * Constructor 
	 * */
	public CsvFileWriter(Context context)
	{
		localContext= context;
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
	 * Description : Method to create file to store data from database 
	 * to an external file on SD card. Need to mention Read / Write Permission 
	 * in the Android Manifest file.
	 * @return writer FileWriter where user is writing the queried data
	 * @param path File descriptor where user is creating file
	 * @param folderName Folder Name to be created where file have to be stored
	 * @param fileName File Name of the file to be created to store the sensor / context data
	 **/
	public FileWriter createFile(File path,String folderName, String fileName) throws IOException
	{	
		FileWriter writer = null;
		if(enableDebugging)
		{
			Log.d(TAG,"createFile Method");
		}
		try
		{
			// Check if path is not null
			if(path==null)
				path = android.os.Environment.getExternalStorageDirectory();

			if(CAFConfig.isEnableDebugging())
			{
				Log.d(TAG, "Path : "+path);
			}

			// Check if folderName is not null
			if(folderName == null)
				folderName = "CSVFolder";

			// Create a file descriptor with path and folderName
			File root = new File(path, folderName);

			//To check if folder is not already present
			if (!root.exists()) {
				root.mkdirs();
				if(CAFConfig.isEnableDebugging())
				{
					Log.d(TAG, "If folder not present "+root);
				}

			}

			//To check if fileName is not null
			if(fileName == null)
			{
				fileName = "CSVFile.csv";
			}

			// Create a file descriptor with path as root and fileName
			File file = new File(root,fileName);

			//If file is not present then it will create the file
			if(!file.exists())
			{
				writer = new FileWriter(file,true); // If true it will append in the existing file

				// To see the debugging message 
				if(enableDebugging)
				{
					Log.d(TAG, " file created");
				}

			}
			else
			{	
				/* If file is already present for an iteration then it will delete the file and create a new file.
				 * If you dont want to delete then comment the else part
				 */ 
				file.delete(); 

				// To see the debugging message 
				if(enableDebugging)
				{
					Log.d(TAG, " file exist, deleting file : "+ fileName);
				}

				// Create the new file again
				writer = new FileWriter(file,true);

				// To see the debugging message
				if(enableDebugging)
				{
					Log.d(TAG, " "+"new file created : "+ fileName );
				}


			}
		}
		catch(IOException e)
		{
			Log.e(TAG,"Error while writing");
			e.printStackTrace();
		}
		return writer;
	}

	/**
	 * Method to prepare a string data to be written in the file
	 */
	public String dataToWrite(Object... value)
	{			
		StringBuilder strbuilder = null;
		strbuilder = new StringBuilder();
		for (Object object:value)
		{	
			//Log.d(TAG,""+object);
			// Generate a row of data from table / sensor in string format with a "," as common separator 
			strbuilder = (StringBuilder) strbuilder.append(object+",");


		}
		if(enableDebugging)
		{
			Log.d(TAG,""+ strbuilder);
		}
		
		return strbuilder.toString();
	}
	/**
	 * Method to get the data from table and generate a csv file
	 * @param tableName Table name for which you want to query the database
	 * @param writer FileWriter object where data need to be written
	 * @return int 1 if data successfully written on csv file, 0 if error
	 */
	public int getDataFromTable(String tableName, FileWriter writer)
	{
		int success = 0;

		ContextAwareSQLiteHelper dbhelper = new ContextAwareSQLiteHelper(localContext);
		String data = null;
		try
		{ 
			// Need to be written in synchronized block to stop editing the same csv file from any other thread 
			
			synchronized(this) 
			{
				//Log.d("Debug",tableName);

				// Get the permission to read the database 
				SQLiteDatabase database = dbhelper.getReadableDatabase();
				//Log.d("Debug","PrevRowCount = " + prevRowCount);

				// Query to get the newly inserted data in the table
				String query = "select * from "+ tableName +" where id > " + prevRowCount;
							
				//To get the row count
				String queryForGetPresentCount = " select * from  " + tableName ;
				
				// Execute the query 
				Cursor getrowCount = database.rawQuery(queryForGetPresentCount, null);

				// Total number of rows in the selected table 
				totalRowCount = getrowCount.getCount();
				
				// To check the current table name which is being queried for generating csv file., previous row count and present row count
				if(enableDebugging)
				{
					Log.d(TAG,"Table Name : " + tableName);
					Log.d(TAG,"Prev Row Count = " + prevRowCount);
					Log.d(TAG,"Total Row Count = " + totalRowCount);
				}
				
				
				// Get the newly added rows in the table
				curCSV = database.rawQuery(query,null);//new String [] {checkCondition});

				curRowCount =  curCSV.getCount();
				if(prevRowCount!=0)
					prevRowCount = prevRowCount + curRowCount;
				else 
					prevRowCount = 0;
				//Log.d("Debug","CurRowCount = " + curRowCount+ "Total = " + totalRowCount);
				
				int i =0;
				
				//int columnCount = curCSV.getColumnCount();
				
				while(curCSV.moveToNext())
				{
					if(tableName.equals("accelerometer"))
					{
						//One row, each column data delimited with "," in form of single string
						data = dataToWrite(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2),curCSV.getFloat(3),curCSV.getFloat(4));
					}
					else if(tableName.equals("location"))
					{
						data = dataToWrite(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2),curCSV.getFloat(3),curCSV.getString(4),curCSV.getString(5));
					}
					else if(tableName.equals("light"))
					{
						data = dataToWrite(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2));
					}
					else if(tableName.equals("proximity"))
					{
						data = dataToWrite(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2),curCSV.getFloat(3));
					}
					else if(tableName.equals("gyroscope"))
					{
						data = dataToWrite(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2),curCSV.getFloat(3),curCSV.getFloat(4));
					}
					else if(tableName.equals("magnetometer"))
					{
						data = dataToWrite(curCSV.getInt(0),curCSV.getLong(1),curCSV.getFloat(2),curCSV.getFloat(3),curCSV.getFloat(4));
					}
					else
					{
						Log.d(TAG,"No table found");
					}
					// writeData(data, writer);
					writer.append(data+"\n");
					//Log.d("Debug","Data from cursor to write function");


				}
				//csvWrite.close();

				writer.flush();
				writer.close();
				curCSV.close();
				//Log.d(TAG,"Data correctly written in the csv file ");
				success =1;
			}
			return success;
		}
		catch(Exception sqlEx)
		{
			Log.e("ERROR in Simple  FileWriter", sqlEx.getMessage(), sqlEx);
			success= 0;
			return success;
		}
	}
}
