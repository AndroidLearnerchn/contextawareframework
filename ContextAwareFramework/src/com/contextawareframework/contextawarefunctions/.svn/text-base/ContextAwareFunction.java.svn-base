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
 * @File        ContextAwareFunction
 * @Created:    25.11.2013
 * @author:     Prasenjit
 * Last Change: 26.11.2013 by Prasenjit
 */

package com.contextawareframework.contextawarefunctions;

import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * This class is the controller part. User can register the sensor listener 
 * and can store data in the database by using this class
 */

public class ContextAwareFunction {

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 

	Context localContext;
	private static String TAG = "ContextAwareFuntion";

	private AudioManager mAudioManager ;  

	long eventtime;

	public ContextAwareFunction(Context contextFromMainApp)
	{
		localContext = contextFromMainApp;
	}

	/**
	 * Description : Method to increase the volume by getting AudioManager.STREAM_MUSIC
	 * service of Android 
	 */
	public void volumeIncrease()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"VolumeIncrease Method");
		}	
		try
		{
			mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);
			if(mAudioManager!=null)
			{
				int maxVal = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
				int curVal = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
				if(curVal <= maxVal)
					curVal = curVal + 1;
				if(curVal == maxVal )
				{
					Toast.makeText(localContext, "Max volume Reached", Toast.LENGTH_SHORT).show();
				}
				// This won't get true at all...
				if(curVal > maxVal)
				{
					curVal = maxVal;
				}
				mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, curVal, 0);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Description : To decrease the volume by getting AudioManager.STREAM_MUSIC sevice
	 * of Android. 
	 */
	public void volumeDecrease()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"VolumeDecrease Method");
		}	
		try{
			mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);
			//int maxVal = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
			if(mAudioManager!=null)
			{
				int curVal = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
				if(curVal > 0 )
					curVal = curVal - 1;
				if( curVal <= 0 )
				{
					curVal = 0;
					Toast.makeText(localContext,"Min volume Reached", Toast.LENGTH_SHORT).show();
				}

				mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, curVal, 0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	// Function to play / pause / nextSong / prevSong of a music player
	/**
	 * Description : Method to play Song. It uses ACION_MEDIA_BUTTON intent.
	 */
	public final void playSong()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"playSong Method");
		}	
		try
		{
			mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);
			eventtime = SystemClock.uptimeMillis();

			//mAudioManager.requestAudioFocus(l, streamType, ); here 
			if(mAudioManager!=null)
			{
				if(!mAudioManager.isMusicActive())
				{
					Log.d("PlaySong11","Check");
					Intent upIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
					KeyEvent upEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MUSIC, 0);
					upIntent.putExtra(Intent.EXTRA_KEY_EVENT, upEvent);
					localContext.sendOrderedBroadcast(upIntent, null); // Check here if correct
					Log.d("PlaySong22","Check");
				}
				if(mAudioManager.isMusicActive()) //Check Here
				{
					Log.d("PlaySong1","Check");
					Intent upIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
					KeyEvent upEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, 0);
					upIntent.putExtra(Intent.EXTRA_KEY_EVENT, upEvent);
					localContext.sendOrderedBroadcast(upIntent, null); // Check here if correct
					Log.d("PlaySong2","Check");
				}
			}
			else
			{
				Log.d(TAG,"audioManager is null");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Description : Method to pause the song. It uses ACTION_MEDIA_BUTTON intent.
	 */
	public final void pauseSong()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"pauseSong Method");
		}	
		try
		{
			mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);
			eventtime = SystemClock.uptimeMillis();
			if(mAudioManager!=null)
			{
				if(mAudioManager.isMusicActive())
				{
					Log.d("PauseSong","Check1");
					Intent downIntent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
					KeyEvent downEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE, 0);
					downIntent.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
					localContext.sendOrderedBroadcast(downIntent, null);
					Log.d("PauseSong","Check2");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Description : Play the next Song. It uses ACTION_MEDIA_BUTTON intent.
	 */
	public final void playNextSong()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"playNextSong Method");
		}	
		try
		{
			if(mAudioManager!=null)
			{
				mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);
				eventtime = SystemClock.uptimeMillis();
				if(mAudioManager.isMusicActive())
				{
					Intent downIntentnext = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
					KeyEvent downEvent = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_DOWN,   KeyEvent.KEYCODE_MEDIA_NEXT, 0);
					downIntentnext.putExtra(Intent.EXTRA_KEY_EVENT, downEvent);
					localContext.sendOrderedBroadcast(downIntentnext, null);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Description : Method to play previous song. It uses ACTION_MEDIA_BUTTON intent.
	 */
	public final void playPrevSong()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"playPrevSong Method");
		}	
		try
		{
			if(mAudioManager!=null)
			{
				mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);
				eventtime = SystemClock.uptimeMillis();
				if(mAudioManager.isMusicActive())
				{
					Intent downIntentprev = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
					KeyEvent downEventprev = new KeyEvent(eventtime, eventtime, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS, 0);
					downIntentprev.putExtra(Intent.EXTRA_KEY_EVENT, downEventprev);
					localContext.sendOrderedBroadcast(downIntentprev, null);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Description : Another way to play a song
	 */
	public void play1()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"play1 Method");
		}	
		try
		{
			if(mAudioManager!=null)
			{
				mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);    
				if (mAudioManager.isMusicActive()) {
					Intent mediaIntent = new Intent("com.android.music.musicservicecommand");
					mediaIntent.putExtra("command", "play");
					localContext.sendBroadcast(mediaIntent);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Description : Another way to pause the song
	 */
	public void pause1()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"pause1 Method");
		}	
		try
		{
			if(mAudioManager!=null)
			{
				mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);    
				if (mAudioManager.isMusicActive()) {
					Intent mediaIntent = new Intent("com.android.music.musicservicecommand");
					mediaIntent.putExtra("command", "pause");
					localContext.sendBroadcast(mediaIntent);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Description : Another way to play next song
	 */
	public void next1()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"next1 Method");
		}	
		try
		{
			if(mAudioManager!=null)
			{
				mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);    
				if (mAudioManager.isMusicActive()) {
					Intent mediaIntent = new Intent("com.android.music.musicservicecommand");
					mediaIntent.putExtra("command", "next");
					localContext.sendBroadcast(mediaIntent);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Description : Another way to play previous song
	 */
	public void previous1()
	{
		if(CAFConfig.isEnableDebugging())
		{
			Log.d(TAG,"previous1 Method");
		}	
		try
		{
			if(mAudioManager!=null)
			{
				mAudioManager = (AudioManager)localContext.getSystemService(Context.AUDIO_SERVICE);    
				if (mAudioManager.isMusicActive()) {
					Intent mediaIntent = new Intent("com.android.music.musicservicecommand");
					mediaIntent.putExtra("command", "previous");
					localContext.sendBroadcast(mediaIntent);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Detect Accelerometer Motion, shake in Left for X axis
	 */
	public boolean shakeRight(float xAxis)
	{	//boolean status = false;
		if(xAxis < -12)
			return true;
		else
			return false; 
	}
	/**
	 * Detect Accelerometer Motion, shake in Right for X axis
	 */
	public boolean shakeLeft(float xAxis)
	{
		if(xAxis > 12)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion, detects shake in up for Z axis
	 */
	public boolean shakeUp(float zAxis)
	{
		if(zAxis < -15)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion, detects shake in down for Z axis
	 */
	public boolean shakeDown(float zAxis)
	{
		if(zAxis > 15)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion, detects shake in front for Y axis
	 */
	public boolean shakeFront(float yAxis)
	{
		if(yAxis < -12)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion,detects shake back for Y axis
	 */
	public boolean shakeBack(float yAxis)
	{
		if(yAxis > 12)
			return true;
		else
			return false;
	}

	/**
	 * Method to give more flexibility to Developers
	 */

	/**
	 * Detect Accelerometer Motion, shake in Left for X axis
	 */
	public boolean shakeRight(float xAxis,int range)
	{	//boolean status = false;
		if(xAxis < -range)
			return true;
		else
			return false; 
	}
	/**
	 * Detect Accelerometer Motion, shake in Right for X axis
	 */
	public boolean shakeLeft(float xAxis,int range)
	{
		if(xAxis > range)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion, detects shake in up for Z axis
	 */
	public boolean shakeUp(float zAxis,int range)
	{
		if(zAxis < -range)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion, detects shake in down for Z axis
	 */
	public boolean shakeDown(float zAxis,int range)
	{
		if(zAxis > range)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion, detects shake in front for Y axis
	 */
	public boolean shakeFront(float yAxis,int range)
	{
		if(yAxis < -range)
			return true;
		else
			return false;
	}
	/**
	 * Detect Accelerometer Motion,detects shake back for Y axis
	 */
	public boolean shakeBack(float yAxis,int range)
	{
		if(yAxis > range)
			return true;
		else
			return false;
	}

	/**
	 * @return the enableDebugging
	 */
	public static final boolean isEnableDebugging() {
		return enableDebugging;
	}

	/**
	 * @param enableDebugging the enableDebugging to set
	 */
	public static final void setEnableDebugging(boolean enableDebugging) {
		ContextAwareFunction.enableDebugging = enableDebugging;
	}
}

//End of File