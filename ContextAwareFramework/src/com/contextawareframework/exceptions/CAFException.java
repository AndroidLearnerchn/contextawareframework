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
 * @File        CAFException
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 30.10.2014 by Prasenjit
 */
package com.contextawareframework.exceptions;
/**
 * Base exception class for all exception(s). All other sensor based exception class
 * extends this base class.
 */
public class CAFException extends Exception{
	/**
	 * Default Constructor 
	 */
	public CAFException (){
		
	}
	/**
	 * Custom Constructor 
	 */
	public CAFException (String message){
		super(message);
	}
}
