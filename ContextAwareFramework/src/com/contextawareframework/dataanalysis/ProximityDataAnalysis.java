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
 * @File        ProxmityDataAnalysis
 * @Created:    9.12.2014
 * @author:     Prasenjit
 * Last Change: 9.12.2014 by Prasenjit
 */

package com.contextawareframework.dataanalysis;

import com.contextawareframework.backgroundservices.ProximityDataListener;

import android.content.Context;
import android.util.Log;

/**
 * This class will take care of proximity sensor on different devices irrespective of the type.
 * Two types of Proximity sensors are available,  
 *
 */
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
			
			//Log.d("Debug","max : " + maxValue);
			//Log.d("Debug","near");
			status[0]=0;
			status[1]=1;
		}
		else
		{	
			//Log.d("Debug","far");
			
			status[0]=1;
			status[1]=0;
		}
		return status;
	}
}
