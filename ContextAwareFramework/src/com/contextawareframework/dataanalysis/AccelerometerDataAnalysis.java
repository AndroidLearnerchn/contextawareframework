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
 * @File        AccelerometerDataAnalysis
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 */



package com.contextawareframework.dataanalysis;

import android.content.Context;


/**
 * This class help the user to select either low pass or high pass filter from the Accelerometer
 * Sensor in Android. It returns the float array with first three values as low pass filter
 * and the next three value as high pass filter.
 */
public class AccelerometerDataAnalysis {

	Context localContext;
	/**
	 * Default Constructor
	 */
	public AccelerometerDataAnalysis(Context contextFromMainApp)
	{
		localContext = contextFromMainApp;
	}

	/**
	 * Method to perform low pass filter and high pass filter on Accelerometer data.
	 */
	public float[] AccelDataAnalysis(float x,float y, float z)
	{	
		float [] values = {0,0,0,0,0,0} ;
		try{
			//ContextAwareFunction caf = new ContextAwareFunction(localContext);
			// alpha is calculated as t / (t + dT)
			// with t, the low-pass filter's time-constant
			// and dT, the event delivery rate

			final float alpha = (float) 0.75;

			float gravity[]={0,0,0};

			// Isolate the force of gravity with the low-pass filter.
			gravity[0] = alpha * gravity[0] + (1 - alpha) * x;
			gravity[1] = alpha * gravity[1] + (1 - alpha) * y;
			gravity[2] = alpha * gravity[2] + (1 - alpha) * z;

			// Assigning values that can be used in Application level directly for any additional feature
			values[0] = gravity[0];
			values[1] = gravity[1];
			values[2] = gravity[2];

			// Remove the gravity contribution with the high-pass filter.

			float linear_acceleration[]= {0,0,0};

			// Assigning values that can be used in Application level directly for any additional feature
			linear_acceleration[0] = x - gravity[0];
			linear_acceleration[1] = y - gravity[1];
			linear_acceleration[2] = z - gravity[2];

			values[3] = linear_acceleration[0];
			values[4] = linear_acceleration[1];
			values[5] = linear_acceleration[2];
			//Log.d("Debug","X coordinate value = " + event.values[0]);
			//Log.d("Debug","Z coordinate value = " + event.values[2]);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  values;
	}

}
