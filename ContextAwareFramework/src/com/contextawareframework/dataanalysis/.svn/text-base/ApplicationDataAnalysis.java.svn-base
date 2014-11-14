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
 */
package com.contextawareframework.dataanalysis;


import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;
import android.app.Activity;


public class ApplicationDataAnalysis 
{
	
	public static String phoneno =  null;	 
	public static String[] ar = new String[1000];	
    public static String[] ar1 = new String[1000];
    public static String[] ar2 = new String[1000];  
	  
	public static  int i = 0;	
	public static  int l= 0;
	public static  int m = 0;
	
	private  Context _context;
	
	
public ApplicationDataAnalysis (Context context)
  {		
				
		this._context = context;
  }
	
public StringBuffer getOutCallDetails() 
 {
 
	  Log.d("INSIDE METHOD CALL ::::", " INSIDE METHOD CALL :::" );
	  
	  StringBuffer sb = new StringBuffer(); 	  
	  Cursor managedCursor = ((Activity) _context).managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);	  
	  
	  int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);  
	  int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);	  
	  int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);	  
	  int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);	 		
	  sb.append("Call Log :");
	  
  
	
	  while (managedCursor.moveToNext()) 
	  {
		  
	   String phNumber = managedCursor.getString(number);
	   String callType = managedCursor.getString(type);
	   String callDate = managedCursor.getString(date);
	   Date callDayTime = new Date(Long.valueOf(callDate));
	   String callDuration = managedCursor.getString(duration);	  
	   
	       
	   
	   String dir = null;
	   int dircode = Integer.parseInt(callType); 
	   
	   
	   
	   switch (dircode) 
	   {
	   	     
	    case CallLog.Calls.OUTGOING_TYPE:	    	
	    dir = "OUTGOING";	         
	   	if(ar[i] == null)
	    {	    	       	    
	    	ar[i] =	phNumber;	    	
	    		    	
	    }	   	
	   	i++;	   	
	    break;
	    
	   }
	    
	  }
	    
	 
	    HashMap<String,Integer> duplicates = new HashMap<String,Integer>();
	    for(int j=0; j<ar.length; j++)
	    {
	        if(duplicates.containsKey(ar[j]))
	        {
	            int numberOfOccurances = duplicates.get(ar[j]);
	            duplicates.put(ar[j], (numberOfOccurances + 1));
	           
	        }
	        else
	        {
	            duplicates.put(ar[j], 1);
	        }
	    }
	    
	    Log.d("DUPLICATES ENTRY ::::", "DUPLICATES ENTRY ::" + duplicates + ",  DUPLICATES::  ENTRY " + duplicates);

	    int temp  = 0;
	    String finalvalue = null;
	    
	    Set<String> keys = duplicates.keySet();	    
	    for(String key: keys)
	    {		
	 
	    	if((key != null) && (temp < duplicates.get(key)))
	    	{
	    		temp = duplicates.get(key);
	    		finalvalue = key;	    		
	    	}    		
	    	
           
        }
	    
	    Log.d("TEMP ::::", "TEMP ::" + temp + ",  TEMP:: VALUE " + temp);  
    	Log.d("FINAL VALUE ::::", "FINAL VALUE ::" + finalvalue + ",  FINAL VALUE " + finalvalue);    	
    	sb.append("\nYou have made the maximum outgoing call from--- " +  finalvalue + " \nNo of times "
    		     + temp);
    	sb.append("\n----------------------------------"); 	
    
	    return sb;
 }

	
public StringBuffer getInCallDetails() 
{
	 
		  Log.d("INSIDE METHOD CALL ::::", " INSIDE METHOD CALL :::" );
		  
		  StringBuffer sb1 = new StringBuffer(); 	  
		  Cursor managedCursor = ((Activity) _context).managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);	  
		  
		  int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);  
		  int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);	  
		  int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);	  
		  int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);	 		
		  sb1.append("Call Log :");
		  
	 	
		  while (managedCursor.moveToNext()) 
		  {
			  
		   String phNumber = managedCursor.getString(number);
		   String callType = managedCursor.getString(type);
		   String callDate = managedCursor.getString(date);
		   Date callDayTime = new Date(Long.valueOf(callDate));
		   String callDuration = managedCursor.getString(duration);	  
		   
	
		   
		   String dir = null;
		   int dircode = Integer.parseInt(callType); 
		   
		   
		   
		   switch (dircode) 
		   {
		   	     
		    case CallLog.Calls.INCOMING_TYPE:	    	
		 	dir = "INCOMING";
		  	if(ar1[l] == null)
		    {	    	       	    
		    	ar1[l] =	phNumber;	    	
		    		    	
		    }	   	
		   	l++;
		    break;
		        
		   
	       }
		    
		  }
		 
				  
		    HashMap<String,Integer> duplicates = new HashMap<String,Integer>();
		    for(int j=0; j<ar1.length; j++)
		    {
		        if(duplicates.containsKey(ar1[j]))
		        {
		            int numberOfOccurances = duplicates.get(ar1[j]);
		            duplicates.put(ar1[j], (numberOfOccurances + 1));
		           
		        }
		        else
		        {
		            duplicates.put(ar1[j], 1);
		        }
		    }
		    
		    Log.d("DUPLICATES ENTRY ::::", "DUPLICATES ENTRY ::" + duplicates + ",  DUPLICATES::  ENTRY " + duplicates);

		    int temp  = 0;
		    String finalvalue = null;
		    
		    Set<String> keys = duplicates.keySet();	    
		    for(String key: keys)
		    {		
		    	
		    			    	
		    	if((key != null) && (temp < duplicates.get(key)))
		    	{
		    		temp = duplicates.get(key);
		    		finalvalue = key;	    		
		    	}    		
		    	
	       }
		    
		    Log.d("TEMP ::::", "TEMP ::" + temp + ",  TEMP:: VALUE " + temp);  
	    	Log.d("FINAL VALUE ::::", "FINAL VALUE ::" + finalvalue + ",  FINAL VALUE " + finalvalue);    	
	    	sb1.append("\nYou have got maximum incoming call from--- " +  finalvalue + " \nNo of times "
	    		     + temp);
	    	sb1.append("\n----------------------------------");	
	    	
	        return sb1;
	    	  
	    	  
}

	 
public StringBuffer getMissedCallDetails() 
{
	
	  StringBuffer sb2 = new StringBuffer(); 	  
	  Cursor managedCursor = ((Activity) _context).managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);	  
	  
	  int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);  
	  int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);	  
	  int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);	  
	  int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);	 		
	  sb2.append("Call Log :");
	  
 
	
	  while (managedCursor.moveToNext()) 
	  {
		  
	   String phNumber = managedCursor.getString(number);
	   String callType = managedCursor.getString(type);
	   String callDate = managedCursor.getString(date);
	   Date callDayTime = new Date(Long.valueOf(callDate));
	   String callDuration = managedCursor.getString(duration);	  
	   
	   
	   String dir = null;
	   int dircode = Integer.parseInt(callType); 
	   
	   
	   
	   switch (dircode) 
	   {
	   	     
	   case CallLog.Calls.MISSED_TYPE:	    	
			// 	Log.d("INSIDE MISSED TYPE ::::", "INSIDE MISSED TYPE ::" + CallLog.Calls.MISSED_TYPE + ", INSIDE MISSED TYPE:::  " + CallLog.Calls.MISSED_TYPE);	
			    dir = "MISSED";
				if(ar2[m] == null)
			    {	    	       	    
			    	ar2[m] =	phNumber;	    	
			    		    	
			    }	   	
			   	m++;	    
			    break;
			    
	   }
	    
	  }
	    

  
	    HashMap<String,Integer> duplicates = new HashMap<String,Integer>();
	    for(int j=0; j<ar2.length; j++)
	    {
	        if(duplicates.containsKey(ar2[j]))
	        {
	            int numberOfOccurances = duplicates.get(ar2[j]);
	            duplicates.put(ar2[j], (numberOfOccurances + 1));
	           
	        }
	        else
	        {
	            duplicates.put(ar2[j], 1);
	        }
	    }
	    
	    Log.d("DUPLICATES ENTRY ::::", "DUPLICATES ENTRY ::" + duplicates + ",  DUPLICATES::  ENTRY " + duplicates);

	    int temp  = 0;
	    String finalvalue = null;
	    
	    Set<String> keys = duplicates.keySet();	    
	    for(String key: keys)
	    {		
	 
	    	if((key != null) && (temp < duplicates.get(key)))
	    	{
	    		temp = duplicates.get(key);
	    		finalvalue = key;	    		
	    	}    		
	    	
          
       }
	    
	    Log.d("TEMP ::::", "TEMP ::" + temp + ",  TEMP:: VALUE " + temp);  
     	Log.d("FINAL VALUE ::::", "FINAL VALUE ::" + finalvalue + ",  FINAL VALUE " + finalvalue);    	
    	sb2.append("\nYou have got maximum missed call from--- " +  finalvalue + " \nNo of times "
   		     + temp);
     	sb2.append("\n----------------------------------"); 	
   
	    return sb2;


	
}
	    
	
	
	
	
}