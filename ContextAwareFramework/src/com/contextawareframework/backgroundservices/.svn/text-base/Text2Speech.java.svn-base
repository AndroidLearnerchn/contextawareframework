/**
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
 * @File        Text2Speech
 * @Created:    04.08.2014
 * @author:     Divya
 * Last Change: 05.08.2014 by Divya
 */

package com.contextawareframework.backgroundservices;
import android.util.Log;
import java.util.Locale;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
public class Text2Speech extends Service implements OnInitListener{

	private TextToSpeech ttsObj=null;
	
	@Override
	public void onInit(int status){
		// Check if Text to speech engine has been successfully instantiated
		if(status ==TextToSpeech.SUCCESS){
		Log.d("Text2Speech","initialisation Succesful");
		}
		else{
		Log.d("TTS","Initialisation failed");
		}
	
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		ttsObj=new TextToSpeech(this,this);
		Log.d("onCreate","Inside it");
	}
	@Override
	public int onStartCommand(Intent intent,int flags, int startId){
		try{
			Bundle extras=intent.getExtras();
			//Get the language in which to speak
			Locale language=(Locale)extras.get("Language");
			//Sets the language
			int result=ttsObj.setLanguage(language);
			//Checks if language data is missing or  language is not supported
				if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
					Log.d("TTS","Language not supported");
				}
				else{
				Log.d("TTS","Language supported");
				}
				
				if(ttsObj!=null && extras!=null){
					String from=(String)extras.get("From");
					ttsObj.speak(from, TextToSpeech.QUEUE_ADD, null);
					Log.d("onStart","Inside it");
				}
			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return START_STICKY;
	
		
	}
	//Stop and Shutdown Text to speech engine
	@Override
	public void onDestroy(){
		super.onDestroy();
		if(ttsObj!=null){
			ttsObj.stop();
			ttsObj.shutdown();
		}
	}
	@Override
	public IBinder onBind(Intent intent){
		return null;
	} 
	
}


