package com.contextawareframework.probe;

import android.content.Context;
import android.net.ConnectivityManager;

public class WfiProbe {
	/**
	 * Checks whether the network is available on Android device.
	 * If the network signal is very low, it will be evaluated as NOT available.
	 * This routine will check both MOBILE and WIFI signal.
	 * If both of them are in disable status, <code>false</code> will be return absolutely.
	 * </p>
	 * Return <code>true</code> if the network is available. Otherwise, return <code>false</code>.
	 * </p>
	 * 
	 * @param ctx Context.
	 * 
	 * @return <code>True</code> : the network is available.</br>
	 *         <code>False</code>: the network is NOT available.
	 */
	
	//in if condition || connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected() To check if network is available or not
	
	 public static boolean isNetworkAvailable(Context ctx) {
		ConnectivityManager connMgr = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected() ){
				return true;
		}
			
		return false;
	 } 
}
