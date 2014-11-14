/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        BatteryController2
 * @Created:    25.11.2013
 * @author:     Prasenjit
 * Last Change: 15.05.2014 by Prasenjit
 ******************************************************************/

package com.contextawareframework.controller;

import com.contextawareframework.os.Battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;



public abstract class BatteryController2 extends BroadcastReceiver{
	 
	private static int level=0;
	@Override
	public void onReceive(Context contextFromMainActivity, Intent intentFromMainActivity){
		/* We can implement this method here also to get the Battery property value.
		 * Making it abstract enforce the developer to implement it according to his use. 
		 * 
		 */
		// Can be used if you want to store in database.
		//Battery battery=new Battery();
		
		Battery.setLevel(intentFromMainActivity.getIntExtra("level", 0));
		//int level = intentFromMainActivity.getIntExtra("level", 0);
		Log.i("level "," level "+Battery.getLevel());
		level = Battery.getLevel();
		
	}
	
	public static int checkBatteryLevel()
	{
		if(level<0)
			return level;
		else
		{
			Log.i("Debug","Current level : " + level);
			//level = 0; set the desired value here for return
		}
		return level;
	}
	

}
