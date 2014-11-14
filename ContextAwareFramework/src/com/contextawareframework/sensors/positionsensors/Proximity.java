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
 * @File        Proximity
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 22.08.2014 by Prasenjit
 */

package com.contextawareframework.sensors.positionsensors;

/**
 * This is a POJO class for accessing all details of Proximity in Android
 */
public class Proximity {

	private float near;
	private float far;
	private long timestamp;
	private int id;

	/**
	 * Public Constructor
	 */
	public Proximity()
	{

	}

	/**
	 * Method to get value of near field
	 * @return float value 
	 */
	public float isNear() {
		return near;
	}

	/**
	 * Method to Assign float value to "near" class attribute
	 * @param near 
	 */
	public void setNear(float near) {
		this.near = near;
	}

	/**
	 * Method to get the value of "far" class attribute
	 * @return far
	 */
	public float isFar() {
		return far;
	}

	/**
	 * Method to set the "far" class attribute
	 * @param far
	 */
	public void setFar(float far) {
		this.far = far;
	}

	/**
	 * Method to get the timestamp value
	 * @return timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Method to set the timestamp value
	 * @param timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Method to get the "id" class attribute
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method to set the "id" class attribute 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
