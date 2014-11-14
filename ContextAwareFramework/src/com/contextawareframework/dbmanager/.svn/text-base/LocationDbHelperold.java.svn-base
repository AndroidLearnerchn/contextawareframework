package com.contextawareframework.dbmanager;
///*****************************************************************
// * Copyright (c) 2013 by CDAC Chennai 
// * @File        AccelerometerDBHelper
// * @Created:    18.11.2013
// * @author:     Prasenjit
// * Last Change: 18.11.2013 by Prasenjit
// ******************************************************************/
//package com.contextawareframework.dbmanager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.contextawareframework.sensors.positionsensors.LocationPojo;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
///*******************************************************************************************
// * This is a database helper class for all CRUD operation on GPS Sensor in Android
// *******************************************************************************************/
//public class  LocationDbHelperold{
//
//  // Database fields
//  private SQLiteDatabase database;
//  private ContextAwareSQLiteHelper dbHelper;
//  private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_LOCATION_ID,
//		  ContextAwareSQLiteHelper.COLUMN_LOCATION_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_LOCATION_LATITUDE, ContextAwareSQLiteHelper.COLUMN_LOCATION_LONGINTUDE, ContextAwareSQLiteHelper.COLUMN_LOCATION_PLACE
//		  };
//
//  public LocationDbHelperold(Context context) {
//    dbHelper = new ContextAwareSQLiteHelper(context);
//  }
//
//  public void open() throws SQLException {
//    database = dbHelper.getWritableDatabase();
//  }
//
//  public void close() {
//    dbHelper.close();
//  }
//
//  public LocationPojo createComment(String comment) {
//    ContentValues values = new ContentValues();
//    values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_TIMESTAMP, comment);
//    long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_LOCATION, null,
//        values);
//    Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LOCATION,
//        allColumns, ContextAwareSQLiteHelper.COLUMN_LOCATION_ID + " = " + insertId, null,
//        null, null, null);
//    cursor.moveToFirst();
//    LocationPojo newComment = cursorToComment(cursor);
//    cursor.close();
//    return newComment;
//  }
//
//  //prasen
//
//      public LocationPojo createCommentint(long timestamp,Float value1, Float value2, Float value3){
//	  ContentValues values = new ContentValues();
//	    values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
//	    values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_LATITUDE,value1);
//	    values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_LONGINTUDE, value2);
//	    values.put(ContextAwareSQLiteHelper.COLUMN_LOCATION_PLACE, value3);
//	    long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_LOCATION, null,
//	        values);
//	    Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LOCATION,
//	        allColumns, ContextAwareSQLiteHelper.COLUMN_LOCATION_ID + " = " + insertId, null,
//	        null, null, null);
//	    cursor.moveToFirst();
//	    LocationPojo newComment = cursorToComment(cursor);
//	    cursor.close();
//	    return newComment;
//  }
////Till here 
//  public void deleteComment(LocationPojo location) {
//    long id = location.getId();
//    System.out.println("Comment deleted with id: " + id);
//    database.delete(ContextAwareSQLiteHelper.TABLE_LOCATION, ContextAwareSQLiteHelper.COLUMN_LOCATION_ID
//        + " = " + id, null);
//  }
//
//  public List<LocationPojo> getAllComments() {
//    List<LocationPojo> comments = new ArrayList<LocationPojo>();
//
//    Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LOCATION,
//        allColumns, null, null, null, null, null);
//
//    cursor.moveToFirst();
//    while (!cursor.isAfterLast()) {
//    	LocationPojo location = cursorToComment(cursor);
//      comments.add(location);
//      cursor.moveToNext();
//    }
//    // Make sure to close the cursor
//    cursor.close();
//    return comments;
//  }
//
//  private LocationPojo cursorToComment(Cursor cursor) 
//  {
//	  
//	  LocationPojo location = new LocationPojo();
//	  // Set the Time-stamp
//	  location.setTimestamp(cursor.getLong(0));
//	  
//	  // Set the Latitude Value
//      location.setLatitude(cursor.getFloat(1));
//      
//      // Set the Longitude Value
//      location.setLongitude(cursor.getFloat(2));
//      
//      // To get the location name using Geolocation if possible
//      location.setLocation(cursor.getString(3));
//      
//     return location;
//  }
//} 
