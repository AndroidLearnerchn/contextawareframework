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
 * @File        SDCardException
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 30.10.2014 by Prasenjit
 */
package com.contextawareframework.exceptions;
/**
 * Can be used if any error caused while using SD card 
 */
public class SDCardException extends CAFException{

	/**
	 * Default Constructor 
	 */
	public SDCardException()
	{
		super("SD Card Not Available");
	}
	/**
	 * Custom Constructor 
	 */
	public SDCardException(String message)
	{
		super(message);
	}
}
