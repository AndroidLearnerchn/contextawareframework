package com.contextawareframework.sensors.positionsensors;

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
 * @File        Magnetometer
 * @Created:    16.09.2014
 * @author:     Prasenjit
 * Last Change: 18.09.2014 by Prasenjit
 */


public class Magnetometer {

	private long timeStamp;
	private double xAxis;
	private double yAxis;
	private double zAxis;
	private int id;
	/**
	 * Default constructor
	 */
	public Magnetometer()
	{
		
	}
	/**
	 * @return the timeStamp
	 */
	public final long getTimeStamp() {
		return timeStamp;
	}
	
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public final void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	/**
	 * @return the xAxis
	 */
	public final double getxAxis() {
		return xAxis;
	}
	
	/**
	 * @param xAxis the xAxis to set
	 */
	public final void setxAxis(double xAxis) {
		this.xAxis = xAxis;
	}
	/**
	 * @return the yAxis
	 */
	public final double getyAxis() {
		return yAxis;
	}
	
	/**
	 * @param yAxis the yAxis to set
	 */
	public final void setyAxis(double yAxis) {
		this.yAxis = yAxis;
	}
	
	/**
	 * @return the zAxis
	 */
	public final double getzAxis() {
		return zAxis;
	}
	
	/**
	 * @param zAxis the zAxis to set
	 */
	public final void setzAxis(double zAxis) {
		this.zAxis = zAxis;
	}
	
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}
}
