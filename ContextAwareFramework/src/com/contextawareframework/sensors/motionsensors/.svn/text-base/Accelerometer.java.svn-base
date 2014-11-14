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
 * @File        Accelerometer
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 22.08.2014 by Prasenjit
 */
package com.contextawareframework.sensors.motionsensors;

/**
 * This is a POJO class for accessing all details of Accelerometer Sensor in Android. 
 * It contains Getter and Setter for each attribute
 */

public class Accelerometer {
	private long timeStamp;
	private double xAxis;
	private double yAxis;
	private double zAxis;
	private int id;
	private String comment;

	/**
	 * Default Constructor
	 */
	public Accelerometer(){
		xAxis = 0;
		yAxis = 0;
		zAxis = 0;
		timeStamp = 0;
	}

	/**
	 * Custom Constructor
	 */
	public Accelerometer(long timestamp, double x, double y, double z) {
		timeStamp = timestamp;
		xAxis = x;
		yAxis = y;
		zAxis = z;
	}

	/**
	 * Description : Getter and Setter method for each attribute
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = (int) id;
	}
	/**
	 * 
	 * @return
	 */
	public long getTimestamp() {
		return timeStamp;
	}

	/**
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timeStamp = timestamp;
	}

	/**
	 * 
	 * @return
	 */
	public double getX() {
		return xAxis;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.xAxis = x;
	}

	/**
	 * 
	 * @return
	 */
	public double getY() {
		return yAxis;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.yAxis = y;
	}

	/**
	 * 
	 * @return
	 */
	public double getZ() {
		return zAxis;
	}

	/**
	 * 
	 * @param z
	 */
	public void setZ(double z) {
		this.zAxis = z;
	}

	/**
	 * 
	 * @return
	 */
	public String getComment() {

		return comment;
	}

	/**
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 
	 */
	public String toString()
	{
		return "t="+timeStamp+", x="+xAxis+", y="+yAxis+", z="+zAxis;
	}
}
