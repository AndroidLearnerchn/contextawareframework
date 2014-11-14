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
 * @File        SoundRecorder
 * @Created:    20.11.2013
 * @author:     Prasenjit
 * Last Change: 24.07.2014 by Prasenjit
 */
package com.contextawareframework.backgroundservices;

import android.content.Context;
import android.media.MediaRecorder;

import android.os.Handler;
import android.util.Log;

/**
 * Description : This class need to be re-designed. 22.07.14 Prasenjit
 */
public class SoundRecorder extends CAFService{
	MediaRecorder mRecorder;
    Thread runner;
    public static double soundinDb;
    private static double mEMA = 0.0;
    static final private double EMA_FILTER = 0.6;
    // Use this string constant to debug this class
    private static final String DEBUG_MIC = "SoundRecorder";
    Context mContext;
    // Constructor
	public SoundRecorder(Context contextfFromActivity)
	{
		mContext= contextfFromActivity;
	}
	
	final Runnable updater = new Runnable(){

        public void run(){          
            updateTv();
        };
    };
    final Handler mHandler = new Handler();

    public void getSoundInDb() {
        

        
       // mStatusView = (TextView) findViewById(R.id.status);


        if (runner == null)
        { 
            runner = new Thread(){
                public void run()
                {
                    while (runner != null)
                    {
                        try
                        {
                            Thread.sleep(1000);
                            Log.i("Noise", "Tock");
                        } catch (InterruptedException e) { };
                        mHandler.post(updater);
                    }
                }
            };
            runner.start();
            Log.d("Noise", "start runner()");
        }
    }

    

    

    public void startRecorder(){
        if (mRecorder == null)
        {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile("/dev/null"); 
            if(mRecorder != null)
            {
            	Log.d("Debug","record sound method");
            try
            {           
                mRecorder.prepare();
            }catch (java.io.IOException ioe) {
                android.util.Log.e("[Monkey]", "IOException: " + android.util.Log.getStackTraceString(ioe));

            }catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " + android.util.Log.getStackTraceString(e));
            }
            try
            {           
                mRecorder.start();
            }catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " + android.util.Log.getStackTraceString(e));
            }
            }
            //mEMA = 0.0;
        }

    }
    public void stopRecorder() {
        if (mRecorder != null) {
            mRecorder.stop();       
            mRecorder.release();
            mRecorder = null;
        }
    }

    public void updateTv(){
    	
       //mStatusView.setText(Double.toString((getAmplitudeEMA())) + " dB");
    	//mStatusView.setText(Double.toString((soundDb(32767))) + " dB");
    	soundinDb = soundDb(32767);
    	Log.d("Debug"," Sound in Db = " + soundinDb);
    }
    public double soundDb(double ampl){
        return  20 * Math.log10(getAmplitudeEMA() / ampl);
    }
    public double getAmplitude() {
        if (mRecorder != null)
            return  (mRecorder.getMaxAmplitude());
        else
            return 0;

    }
    public double getAmplitudeEMA() {
        double amp =  getAmplitude();
        mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA;
        return mEMA;
    }

}
