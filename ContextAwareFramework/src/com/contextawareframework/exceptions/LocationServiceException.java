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
 * @File        LocationServiceException
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 30.10.2014 by Prasenjit
 */
package com.contextawareframework.exceptions;
/**
 * This class can be used to report errors when using GPS sensor.
 */
public class LocationServiceException extends SensorException{
	/**
	 * Default Constructor 
	 */
	public LocationServiceException() {
		super("GPS Sensor Not Available");
	}
	/**
	 * Custom Constructor 
	 */
	public LocationServiceException(String message)
	{
		super(message);
	}

}
