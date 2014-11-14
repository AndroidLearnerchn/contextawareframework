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
 * @File        GPSTracker (Modified ( Original file, GPSTracker) from Google Sample Code)
 * @Created:    20.11.2013
 * @author:     Rekha
 * Last Change: 24.03.2014 by Rekha
 */
package com.contextawareframework.backgroundservices;
 
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.location.LocationListener;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
  
public class GPSTracker extends Service implements LocationListener {

 	private  Context _context;
	private  Location location = null;
	
	// flag for GPS status
	boolean isGPSEnabled = false;
	
	// flag for network status
    boolean isNetworkEnabled = false;
    
    // flag for GPS status
    boolean canGetLocation = false;
    
    double latitude; // latitude
    double longitude; // longitude
    
  // Declaring a Location Manager
    protected LocationManager locationManager;
	
     // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
 
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    
  /* written for location context data analysis by Rekha  */  
   /* public NetworkConnection()
    {
    	Log.d("CAN GET LOCATION", "CAN GET LOCATION" + MIN_DISTANCE_CHANGE_FOR_UPDATES + ", CAN GET LOCATION " +MIN_DISTANCE_CHANGE_FOR_UPDATES);
    	try
    	{
        	getLocation();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }*/
    /* written for location context data analysis by Rekha */   
  
    public GPSTracker(Context context)
    {
    	//Log.d("MAIN ACTIVITY CONTEXT 5 ::::", "ACTIVITY CONTEXT 5 ::" + context + ", ACTIVITY CONTEXT::  5 " + context);    	
    	this._context = context;    	
    	//Log.d("MAIN ACTIVITY CONTEXT 6 ::::", "ACTIVITY CONTEXT 6 ::" + _context + ", ACTIVITY CONTEXT::  6 " + _context);    	
    	location = getLocation();   	
        
    }
  
    /**
     * Checking for all possible internet providers
     * **/
      
    public boolean isConnectingToInternet()
    {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null)
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null)
                  for (int i = 0; i < info.length; i++)
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                          return true;
                      }  
          }
          return false;
    }
    
    
    public Location getLocation() 
    {    	
    	Log.d("MAIN ACTIVITY CONTEXT 7 ::::", "ACTIVITY CONTEXT 7 ::" + _context + ", ACTIVITY CONTEXT::  7 " + _context);   
    	try
    	{   
    		if(_context != null)
    		{
    		  locationManager = (LocationManager) _context.getSystemService(LOCATION_SERVICE);    		  
    		}
    		else
    		{
    			Log.d("CONTEXT", "CONTEXT" +_context+ "CONTEXT" +_context);
    		}    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();    		
    	}
    	
    	//Log.d("LOCATION MANAGER", "LOCATION MANAGER" +locationManager+ "LOCATION MANAGER" +locationManager); 
    	
    	 // getting GPS status
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        
        //Log.d("IS GPS ENABLED", "IS GPS ENABLED" +isGPSEnabled+ "IS GPS ENABLED" +isGPSEnabled);
       
        // getting network status
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        
        if (!isGPSEnabled && !isNetworkEnabled) 
        {
            // no network provider is enabled
        } 
        else 
        {
            this.canGetLocation = true;
            if (isNetworkEnabled) {
                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                
                Log.d("Network", "Network Enabled");
                Log.d("LOCATION MANAGER INSIDE NETWORK", "LOCATION MANAGER INSIDE NETWORK" +locationManager+ "LOCATION MANAGER" +locationManager);
                
                if (locationManager != null) {
                	
                	Log.d("Location Manager not null", "Location Manager not null");                	
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);                    
                    Log.d("Location not null 1", "Location not null 1" +location+ "Location not null 1" +location);
                    
                    if (location != null) 
                    {  
                    	Log.d("Location not null 2", "Location not null 2" +location+ "Location not null 2" +location);                    	
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();                        
                        Log.d("Location Latitude & Longitude", "Location Latitude & Longitude" +latitude+ "Location Latitude & Longitude" +longitude);
                                                
                    }
                }
            }
            // if GPS Enabled get lat/long using GPS Services
            if (isGPSEnabled) {
                if (location == null) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("GPS", "GPS Enabled");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
            }
        }
        
       Log.d("Location Latitude & Longitude", "Location Latitude & Longitude" +latitude+ "Location Latitude & Longitude" +longitude);
       return location;
       
     }
    
    
    /**
     * Function to check GPS/wifi enabled
     *
     * @return boolean
     * */    
    public boolean canGetLocation() {
        return this.canGetLocation;
    }
    
    
    /**
     * Function to get latitude
     * */
    public double getLatitude() 
    {
        if (location != null) {
            latitude = location.getLatitude();
        }
 
        // return latitude
        return latitude;
    }
 
    /**
     * Function to get longitude
     * */
    public double getLongitude() 
    {
        if (location != null) {
            longitude = location.getLongitude();
        }
         // return longitude
        return longitude;
    }
 
    
    
    @Override
    public void onLocationChanged(Location location) {
    	
    }
 
    @Override
    public void onProviderDisabled(String provider) {
    	
    }
 
    @Override
    public void onProviderEnabled(String provider) {
    	
    }
 
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    	
    }
 
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
    
    
}