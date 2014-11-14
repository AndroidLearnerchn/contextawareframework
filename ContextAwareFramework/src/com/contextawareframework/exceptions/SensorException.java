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
 * @File        SensorException
 * @Created:    19.11.2013
 * @author:     Prasenjit
 * Last Change: 12.08.2014 by Prasenjit
 */
package com.contextawareframework.exceptions;

public class SensorException extends CAFException{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Default Constructor 
	 */
	public SensorException()
	{
		super(" Sensor Not Available");
	}
	/**
	 * Custom Constructor, can be used to show user defined exception messages
	 */
	public SensorException(String message)
	{
		super(message);
	}

/*
	public class AccelerometerSensorException extends SensorException{
		*//**
		 * Can be used if any error caused while using Accelerometer Sensor 
		 *//*
		private static final long serialVersionUID = 1L;
		*//**
		 * Default Constructor 
		 *//*
		public AccelerometerSensorException()
		{
			super("Accelerometer Sensor Not Available");
		}
		*//**
		 * Custom Constructor
		 *//*
		public AccelerometerSensorException(String message)
		{
			super(message);
		}
	}

	public class GPSSensorException extends SensorException{
		*//**
		 * Default Constructor 
		 *//*
		public GPSSensorException() {
			super("GPS Sensor Not Available");
		}
		*//**
		 * Custom Constructor 
		 *//*
		public GPSSensorException(String message)
		{
			super(message);
		}

	}
	public class LightSensorException extends SensorException{
		*//**
		 * Default Constructor 
		 *//*
		public LightSensorException() {
			super("Light Sensor Not Available");
		}
		*//**
		 * Custom Constructor 
		 *//*
		public LightSensorException(String message)
		{
			super(message);
		}

	}
	public class ProximitySensorException extends SensorException{
		*//**
		 * Default Constructor 
		 *//*
		public ProximitySensorException()
		{
			super("Proximity Sensor Not Available");
		}
		*//**
		 * Custom Constructor 
		 *//*
		public ProximitySensorException(String message)
		{
			super(message);
		}
	}
	public class GyroscopeSensorException extends SensorException{
		*//**
		 * Default Constructor 
		 *//*
		public GyroscopeSensorException()
		{
			super("Gyroscope Sensor Not Available");
		}
		*//**
		 * Custom Constructor 
		 *//*
		public GyroscopeSensorException(String message)
		{
			super(message);
		}
	}
	public class MagnetometerSensorException extends SensorException{
		*//**
		 * Default Constructor 
		 *//*
		public MagnetometerSensorException()
		{
			super("Magnetometer Sensor Not Available");
		}
		*//**
		 * Custom Constructor 
		 *//*
		public MagnetometerSensorException(String message)
		{
			super(message);
		}
	}*/
}