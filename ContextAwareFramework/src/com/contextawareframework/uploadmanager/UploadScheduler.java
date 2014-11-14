/*
 * Copyright (c) 2013-14 by CDAC Chennai 
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
 * @File        UploadScheduler
 * @Created:    20.11.2013
 * @author:     Prasenjit
 * Last Change: 28.11.2013 by Prasenjit
 */
 
package com.contextawareframework.uploadmanager;


import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import static java.util.concurrent.TimeUnit.*;

/**
 * Description : This class is useful if the user wants to schedule the task
 *
 */


public class UploadScheduler {
	Context localcontext; // Context of the activity where user started the
							// service class.
	Object serviceClassName;// Wrtie the service with the functionality you
							// wanted to automate
	/**
	 * 
	 */
	int interval; // Time interval in seconds

	// Constructor to initialize the class variables
	public UploadScheduler(Context contextFromMain, Object serviceclass,
			int delay) {
		localcontext = contextFromMain;
		serviceClassName = serviceclass;
		interval = delay;

	}

	/**
	 * Description : Method to be called to automate the task
	 */
	public void scheduleUpload() {
		Log.d("Debug", "automate part start");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 10);

		Intent intent = new Intent(localcontext, serviceClassName.getClass());

		PendingIntent pintent = PendingIntent.getService(localcontext, 0, intent, 0);

		AlarmManager alarm = (AlarmManager) localcontext
				.getSystemService(Context.ALARM_SERVICE);
		int i;
		i = 15;
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
				i * 1000, pintent);
		Log.d("Debug", "automate part end");
	}
}