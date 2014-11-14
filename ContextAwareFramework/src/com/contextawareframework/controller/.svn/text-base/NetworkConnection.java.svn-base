//package com.contextawareframework.controller;
// 
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.location.Location;
//import android.location.LocationManager;
//import android.net.ConnectivityManager;
//import android.location.LocationListener;
//import android.net.NetworkInfo;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.util.Log;
//  
//public class NetworkConnection extends Service implements LocationListener {
//    
//	private  Context _context;
//	Location location = null;
//	
//	// flag for GPS status
//	boolean isGPSEnabled = false;
//	
//	// flag for network status
//    boolean isNetworkEnabled = false;
//    
//    // flag for GPS status
//    boolean canGetLocation = false;
//    
//    double latitude; // latitude
//    double longitude; // longitude
//    
//  // Declaring a Location Manager
//    protected LocationManager locationManager;
//	
//     // The minimum distance to change Updates in meters
//    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
// 
//    // The minimum time between updates in milliseconds
//    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
//  
//    public NetworkConnection(Context context){
//        this._context = context;
//        getLocation();
//    }
//  
//    /**
//     * Checking for all possible internet providers
//     * **/
//      
//    public boolean isConnectingToInternet(){
//        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
//          if (connectivity != null)
//          {
//              NetworkInfo[] info = connectivity.getAllNetworkInfo();
//              if (info != null)
//                  for (int i = 0; i < info.length; i++)
//                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
//                      {
//                          return true;
//                      }
//  
//          }
//          return false;
//    }
//    
//    
//    public Location getLocation() {
//    	
//    	locationManager = (LocationManager) _context.getSystemService(LOCATION_SERVICE);
//    	
//    	 // getting GPS status
//        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//       
//        // getting network status
//        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//        
//        if (!isGPSEnabled && !isNetworkEnabled) 
//        {
//            // no network provider is enabled
//        } 
//        else 
//        {
//            this.canGetLocation = true;
//            if (isNetworkEnabled) {
//                locationManager.requestLocationUpdates(
//                        LocationManager.NETWORK_PROVIDER,
//                        MIN_TIME_BW_UPDATES,
//                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//                Log.d("Network", "Network Enabled");
//                if (locationManager != null) {
//                    location = locationManager
//                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                    if (location != null) {
//                        latitude = location.getLatitude();
//                        longitude = location.getLongitude();
//                    }
//                }
//            }
//            // if GPS Enabled get lat/long using GPS Services
//            if (isGPSEnabled) {
//                if (location == null) {
//                    locationManager.requestLocationUpdates(
//                            LocationManager.GPS_PROVIDER,
//                            MIN_TIME_BW_UPDATES,
//                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//                    Log.d("GPS", "GPS Enabled");
//                    if (locationManager != null) {
//                        location = locationManager
//                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                        if (location != null) {
//                            latitude = location.getLatitude();
//                            longitude = location.getLongitude();
//                        }
//                    }
//                }
//            }
//        }
//
//        return location;
//     }
//    
//    
//    /**
//     * Function to check GPS/wifi enabled
//     *
//     * @return boolean
//     * */    
//    public boolean canGetLocation() {
//        return this.canGetLocation;
//    }
//    
//    
//    /**
//     * Function to get latitude
//     * */
//    public double getLatitude() {
//        if (location != null) {
//            latitude = location.getLatitude();
//        }
// 
//        // return latitude
//        return latitude;
//    }
// 
//    /**
//     * Function to get longitude
//     * */
//    public double getLongitude() {
//        if (location != null) {
//            longitude = location.getLongitude();
//        }
// 
//        // return longitude
//        return longitude;
//    }
// 
//    
//    
//    @Override
//    public void onLocationChanged(Location location) {
//    }
// 
//    @Override
//    public void onProviderDisabled(String provider) {
//    }
// 
//    @Override
//    public void onProviderEnabled(String provider) {
//    }
// 
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//    }
// 
//    @Override
//    public IBinder onBind(Intent arg0) {
//        return null;
//    }
//    public void unregisterLccationListener()
//    {
//    	locationManager.removeUpdates(this); // To unregister the Location Listener
//    }
//    
//    
//}