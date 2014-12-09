package com.contextawareframework.dataanalysis;

import com.contextawareframework.backgroundservices.ProximityDataListener;

import android.content.Context;
import android.util.Log;

public class ProximityDataAnalysis {
	
	Context localContext;
	//private int near= 0;
	//private int far= 1;
	/**  if far then value will be 1, if near value will be 0
	 *  */
	private int status[]= {99,99};
	private int maxValue;
	
	/**
	 * Default Constructor
	 */
	public ProximityDataAnalysis(Context contextFromMainApp) {
		localContext = contextFromMainApp;
		maxValue = (int)ProximityDataListener.getInstance(localContext).getMaxValue();
	}
	public int[] nearFarStatus(float currentValue)
	{
		if(currentValue < maxValue)
		{
			
			Log.d("Debug","max : " + maxValue);
			Log.d("Debug","near");
			status[0]=0;
			status[1]=1;
		}
		else
		{	
			Log.d("Debug","far");
			
			status[0]=1;
			status[1]=0;
		}
		return status;
	}
}
