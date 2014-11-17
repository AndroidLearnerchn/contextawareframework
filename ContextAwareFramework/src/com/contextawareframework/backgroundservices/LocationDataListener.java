/*
 * Copyright (c) 2014 by CDAC Chennai 
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
 * @Original File : GPSTracker
 * @File        LocationDataListener(Modified copy)
 * @Created:    24.04.2014
 * @author:     Prasenjit
 * Last Change: 09.09.2014 by Prasenjit
 */
package com.contextawareframework.backgroundservices;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

/**
 * This clas is listener class for GPS Sensor, can be used just to register the GPS / Location 
 * listener only. If GPS enabled then will try to get the lat / long from GPS else it will try 
 * to get the location details from Network Provider (If the phone has network coverage) 
 * */
public class LocationDataListener extends CAFService{

	private final Context mContext;
	
	// flag for GPS status
	boolean isGPSEnabled = false;

	// flag for network status
	boolean isNetworkEnabled = false;

	// flag for GPS status
	boolean canGetLocation = false;
	
	// Use this string constant to debug this class
    private static final String TAG = "LocationDataListener";
	
    private Location location; // location
    
	double latitude; // latitude
	double longitude; // longitude

	// The minimum distance to change Updates in meters
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters 

	// The minimum time between updates in milliseconds
	private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute 

	// Declaring a Location Manager
	protected LocationManager locationManager;
	private LocationListener locationListener;
	private static LocationDataListener locationDataListenerInstance;
	
	/**
	 * Description : Private constructor. Singleton Pattern to create the class object
	 * @param context Calling Activity context
	 */
	private LocationDataListener(Context context)
	{
		mContext = context;		
	}

	/**
	 * Description : Method to create an instance of LocationDataListener Class.
	 * @param context Calling Activity context
	 * @return LocationDataListener Class instance
	 */
	public static synchronized LocationDataListener getInstance(Context context)
	{
		if (locationDataListenerInstance == null)
			locationDataListenerInstance = new LocationDataListener(context);

		return locationDataListenerInstance;
	}
	
	public void enableLocationListener(String provider, long minTime, float minDistance, LocationListener locationListener)
	{
		location = getLocation(provider, minTime, minDistance, locationListener);
	}
	public void disableLocationListener(LocationListener listenerFromActivity)
	{
		unregisterLocationListener(listenerFromActivity);
	}
	/**
	 * @author Rekha N
     * Checking for all possible internet providers
     * **/
      
    public boolean isConnectingToInternet()
    {
        ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
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
	public Location getLocation(String provider, long minTime, float minDistance, LocationListener locationListener) {
		try {
			locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

			// getting GPS status
			isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

			// getting network status
			isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (!isGPSEnabled && !isNetworkEnabled) {
				// no network provider is enabled
				Log.d(TAG,"No service available to get the location. Network and GPS both are disable or not available");
				
			}
			else
			{
				this.canGetLocation = true;
				if (isNetworkEnabled) {
					// This line need to be changed
					//locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener); // Now this will be implemented in user level
					
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTime, minDistance, locationListener); // Now this will be implemented in user level
					Log.d("Network", "Network");
					if (locationManager != null) {
						location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) {
							latitude = location.getLatitude();
							longitude = location.getLongitude();
						}
					}
				}
				// if GPS Enabled get lat/long using GPS Services
				if (isGPSEnabled) {
					if (location == null) {
						locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 60000, locationListener);
						Log.d("GPS Enabled", "GPS Enabled");
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return location;
	}
	
	/**
	 * Stop using Location listener
	 * Calling this function will stop using GPS in your app
	 * */
	public void unregisterLocationListener(LocationListener locationListener){
		if(locationManager != null){
			locationManager.removeUpdates(locationListener);
		}		
	}
	
	/**
	 * Function to get latitude
	 * */
	public double getLatitude(){
		if(location != null){
			latitude = location.getLatitude();
		}
		
		// return latitude
		return latitude;
	}
	
	/**
	 * Function to get longitude
	 * */
	public double getLongitude(){
		if(location != null){
			longitude = location.getLongitude();
		}
		
		// return longitude
		return longitude;
	}
	
	/**
	 * Function to check GPS/wifi enabled
	 * @return boolean
	 * */
	public boolean canGetLocation() {
		return this.canGetLocation;
	}
	
	/**
	 * Function to show settings alert dialog
	 * On pressing Settings button will lauch Settings Options
	 * */
	public void showSettingsAlert(){
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
   	 
        // Setting Dialog Title
        alertDialog.setTitle("GPS settings");
 
        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
 
        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
            	Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            	mContext.startActivity(intent);
            }
        });
 
        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
