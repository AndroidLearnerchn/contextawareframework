/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        BatteryDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/
package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.sensors.motionsensors.Accelerometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/*******************************************************************************************
 * This is a database helper class for all CRUD operation on Accelerometer Sensor in Android
 *******************************************************************************************/
//NOTE NOT IN WORKING FORM
public class  BatteryDbHelper{

  // Database fields
  private SQLiteDatabase database;
  private ContextAwareSQLiteHelper dbHelper;
  private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_ACCEL_ID,
		  ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_ACCEL_X, ContextAwareSQLiteHelper.COLUMN_ACCEL_Y, ContextAwareSQLiteHelper.COLUMN_ACCEL_Z
		  };

  public BatteryDbHelper(Context context) {
    dbHelper = new ContextAwareSQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Accelerometer createComment(String comment) {
    ContentValues values = new ContentValues();
    values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, comment);
    long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_ACCEL, null,
        values);
    Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
        allColumns, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Accelerometer newComment = cursorToComment(cursor);
    cursor.close();
    return newComment;
  }

  //prasen

      public Accelerometer createCommentint(long timestamp,Float value1, Float value2, Float value3){
	  ContentValues values = new ContentValues();
	    values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
	    values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_X,value1);
	    values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_Y, value2);
	    values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_Z, value3);
	    long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_ACCEL, null,
	        values);
	    Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
	        allColumns, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Accelerometer newComment = cursorToComment(cursor);
	    cursor.close();
	    return newComment;
  }
//Till here 
  public void deleteComment(Accelerometer accel) {
    long id = accel.getId();
    System.out.println("Comment deleted with id: " + id);
    database.delete(ContextAwareSQLiteHelper.TABLE_ACCEL, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID
        + " = " + id, null);
  }

  public List<Accelerometer> getAllComments() {
    List<Accelerometer> comments = new ArrayList<Accelerometer>();

    Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
    	Accelerometer accel = cursorToComment(cursor);
      comments.add(accel);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return comments;
  }

  private Accelerometer cursorToComment(Cursor cursor) {
	  Accelerometer accel = new Accelerometer();
    accel.setTimestamp(cursor.getLong(0));
    accel.setX(cursor.getFloat(1));
    accel.setY(cursor.getFloat(2));
    accel.setZ(cursor.getFloat(3));
    return accel;
  }
} 
