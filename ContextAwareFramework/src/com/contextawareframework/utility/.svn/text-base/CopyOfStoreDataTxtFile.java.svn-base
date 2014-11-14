package com.contextawareframework.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CopyOfStoreDataTxtFile {

	///----------------------To save any sensor data in simple text file-------------------//
	
	public void saveAllSensorData(long timestamp,float x, float y, float z,float latitude,float longitude )
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
//	         importError = e.getMessage();
//	         iError();
	    }
	   
	}
	///----------------------To save any sensor data in simple text file-------------------//
	public void saveAccelData(float x, float y, float z, long timestamp)
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
	//-----Start-------------------------------------------To store Proximity Sensor data------------------//
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
	//End------------------------------------------------To store GPS Location Sensor data------------------//
}
