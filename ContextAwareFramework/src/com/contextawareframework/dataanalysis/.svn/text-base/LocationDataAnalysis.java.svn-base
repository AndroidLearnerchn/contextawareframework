/*
 * Copyright (c) 2014 by CDAC Chennai 
 * @File        LocationDataAnalysis
 * @Created:    22.04.2014
 * @author:     Rekha.N
 * Last Change: 22.04.2014 by Rekha.N
 */
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

import java.util.Calendar;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.media.AudioManager;



public class LocationDataAnalysis 
{
	
//* NetworkConnection nc = new NetworkConnection();
public Boolean internetAvailability = false;	
public static int count = 0;
public static int count1 = 0;

public static String prvlat = "";
public static String prvlon = "";


public int locationchangestatus(String curlat, String curlon)  
{
	
	 Log.d("STATUS IN LOCATION CHANGE", "STATUS IN LOCATION CHANGE" + curlat + "STATUS IN MAIN ACTIVITY" +curlon);		
	 int status = 0 ;	 
	 Log.d("PREVIOUS LATITUDE AND LONGITUDE::::", "PREVIOUS LATITUDE:::" + prvlat + "PREVIOUS LONGITUDE:::" +prvlon);
	
	// if(((!curlat.equals(prvlat))   && (!curlon.equals(prvlon)))  && ((!prvlat.equals("")) && (!prvlat.equals(""))));\
	 if((prvlat.equals("")) && (prvlon.equals("")))
	 {
		   prvlat = curlat;
	       prvlon =  curlon;
	       status = 0;		     
	       Log.d("INSIDE FIRST IF::::", "INSIDE FIRST IF:::" + status + "INSIDE FIRST IF:::" +status);
	 }
	 else  if((!(curlat.equals(prvlat))) && (!(curlon.equals(prvlon))))
	 {
		 prvlat = curlat;
	     prvlon =  curlon;
	     status = 1;
	     Log.d("INSIDE SECOND IF::::", "INSIDE SECOND IF:::" + status + "INSIDE SECOND IF:::" +status);
	 }
	 else
	 {
		 status = 0;			 
		 Log.d("INSIDE THIRD IF::::", "INSIDE THIRD IF:::" + status + "INSIDE THIRD IF:::" +status);
	 }
	
	 Log.d("STATUS IN LOCATION CHANGE RETURN VALUE", "STATUS IN LOCATION CHANGE RETURN VALUE" + status + "STATUS IN LOCATION CHANGE RETURN VALUE" +status); 
	 return status;				
}



    
 public int startloccontext(Double lat, Double lont) // starting the service of checking 
 {       	                    
	 // coded 23/04/14	 
	 int result = -1;
	 
	//* internetAvailability = nc.isConnectingToInternet();	 
	//* if(internetAvailability == true)
	//* {
	//*	 if(nc.canGetLocation())
	//*	 {
			 int statusinmain =  locationchangestatus(Double.toString(lat), Double.toString(lont));
			 Boolean isNight;
             Calendar cal = Calendar.getInstance();
             int hour = cal.get(Calendar.HOUR_OF_DAY);
             
            Log.d("STATUS MAIN::::", "STATUS MAIN:::" + statusinmain + "STATUS MAIN:::" +statusinmain);
             
             
             if((statusinmain == 0))
             {               
                  if(hour < 6 || hour > 18)
                  {
                        count = count + 1;
                        Log.d("COUNT::::", "COUNT:::" + count + "COUNT:::" +count);
                        
                        if(count > 8)
                        {
                             Log.d("IS NIGHT:::::::", "" +count );                             
                             result = 0;
                             return result;                             
                                                        
	                       /*   AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
	                            audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);*/	                         
                             // Record in db this place is House here db insertion needed.                     
                        }               
                       
                 }
                 else
                 {  
                      count1 = count1 + 1;
                      
                      Log.d("COUNT1::::", "COUNT1:::" + count1 + "COUNT1:::" +count1);
                      
                      if(count1 > 8)
                       {
                             Log.d("IS DAY:::::::", "" +count1 );                             
                             result = 1;
                             return result;
                             
	                	     /*  AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
	                             audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);*/	                         
                             // Record in db this place is Office here db insertion needed.                      
                        }        
                  }

             } // closing tag for no location change check
            else
             {
                   count = 0;
                   count1 = 0;
                   return result;                   
             }
                  			 
	//*	 }		 
	//* }
	 
             
     Log.d("RESULT::::", "RESULT:::" + result + "RESULT:::" +result);        
	 return result;	 
	 
// coded 23/04/14 
	 
} //closing tag for startloccontextservice method
 
 
 
 
 
 
 

}  //closing tag for class LocationDataAnalysis

