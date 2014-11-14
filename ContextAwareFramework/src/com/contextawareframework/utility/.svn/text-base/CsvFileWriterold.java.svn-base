/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Battery
 * @Created:    28.01.2014
 * @author:     Prasenjit
 * Last Change: 29.01.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.contextawareframework.dbmanager.AccelerometerDbHelper;
import com.contextawareframework.dbmanager.ContextAwareSQLiteHelper;
import com.contextawareframework.sensors.motionsensors.Accelerometer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import au.com.bytecode.opencsv.CSVWriter;
/************************************************************************
 * Class to generate Accelerometer table csv file on sdcard (Using 3rd party
 * library) Presently not in use.
 ************************************************************************/
public class CsvFileWriterold{
	private Context localcontext;
	public CsvFileWriterold(Context contextFromMain)
	{
		localcontext = contextFromMain;
	}
	public void wrtieCsvFile(String tableName){
		//File dbFile=localcontext.getDatabasePath("contextAwareFramework.db");
		ContextAwareSQLiteHelper dbhelper = new ContextAwareSQLiteHelper(localcontext);
		File exportDir = new File(Environment.getExternalStorageDirectory(), "");       
		if (!exportDir.exists())
		{
			exportDir.mkdirs();
		}

		File file = new File(exportDir, "Accelerometerdb.csv");
		try
		{
			file.createNewFile();               
			CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
			String  tablename = tableName ; 
			SQLiteDatabase db = dbhelper.getReadableDatabase();
			Cursor curCSV = db.rawQuery("SELECT * FROM "+ tablename  ,null);
            csvWrite.writeNext(curCSV.getColumnNames());
            int i =0;
            while(curCSV.moveToNext())
            {
               //Which column you want to exprort
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4)};
                System.out.println("All val = " + arrStr[i]);
                csvWrite.writeNext(arrStr);
                
            }
			csvWrite.close();
			curCSV.close();
		}
		catch(Exception sqlEx)
		{
			Log.e("ERROR in Csv FileWriter", sqlEx.getMessage(), sqlEx);
		}
	}
}